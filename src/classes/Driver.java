package classes;

import com.sun.jmx.snmp.Timestamp;
import packets.carmotion.CarMotionData;
import packets.carsetup.CarSetupData;
import packets.carstatus.CarStatusData;
import packets.cartelemetry.CarTelemetryData;
import packets.lapdata.LapData;
import packets.participants.PacketParticipantsData;
import packets.participants.ParticipantData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author miguelangel.garciar
 */
public class Driver {
    
    public CarSetupData carSetup;
    public CarStatusData carStatus;
    public CarTelemetryData carTelemetry;
    public ParticipantData participant;
    public CarMotionData carMotion;
    public LapData lap;
    public HashMap<Integer, Float> previousLaps;
    // #LAP --> (lapDistance / X , Time)
    public HashMap<Integer, HashMap<Integer, Long>> miniSectors;
    // #STINT --> (lapInit , Tyre)
    public ArrayList<HashMap<Integer, Short>> stints;
    public int lastPitStopLap;
    public static int MINISECTOR_GAP = 100;
    
    public HashMap<Integer, Float> fuelUsed;
    public Session session;
    
    public float bestS1;
    public float bestS2;
    public float bestS3;
    public float lastS1;
    public float lastS2;
    public float lastS3;
    
    public Driver(ParticipantData pd, Session session){
        this.session = session;
        setNewParticipant(pd);
        initializeSectores();
    }
    
    public void setStint(){
        if(lap != null && carStatus != null){
            if(lap.currentLapNum == 1){
                if(stints.isEmpty()){
                    HashMap<Integer, Short> st = new HashMap<>();
                    stints.add(st);
                    st.put(0, carStatus.tyreCompound);
                    lastPitStopLap = 1;
                }
            }else{
                if(stints.isEmpty()){
                    HashMap<Integer, Short> st = new HashMap<>();
                    stints.add(st);
                    st.put((int) lap.currentLapNum, carStatus.tyreCompound);
                    lastPitStopLap = lap.currentLapNum;
                }
                
                if(lap.driverStatus == 3 && lap.pitStatus == 1 && lap.currentLapNum != lastPitStopLap){
                    HashMap<Integer, Short> st = new HashMap<>();
                    stints.add(st);
                    st.put(lap.currentLapNum - 1, carStatus.tyreCompound);
                    lastPitStopLap = lap.currentLapNum;
                }
            }
        }
        /*
        
        if (participant.aiControlled == 0){
            System.out.println("-------------");
            System.out.println("Stints:");
            
            for(int i = 0; i<stints.size(); i++){
                HashMap<Integer, Short> st = stints.get(i);
                
                System.out.println("    "+(i));
                for(Integer key : st.keySet()) {
                    System.out.println("        Lap: "+key);
                    System.out.println("        Compound: "+st.get(key));
                }
            }
        }*/
    }
    
    public int getTyreAges(int stint, int currentLap){
        if(stints.isEmpty() || stint > stints.size()){
            return -1;
        }
        HashMap<Integer, Short> mystint = stints.get(stint);
        int initlap = 0;
        int lastlap = 0;
        for (int key : mystint.keySet()) {
            initlap = key;
        }
        // This stint is not the last one.
        if(stint + 1 < stints.size()){
            HashMap<Integer, Short> next = stints.get(stint + 1);
            for (int key : next.keySet()) {
                lastlap = key;
            }
            return lastlap - initlap;
        }
        // This is the last stint
        return currentLap - initlap;
    }
    
    public void setPreviousGapTimes(float lapDistance, int lapNum){
        if(lapDistance > 0f || lapNum > 0){
            
            if(miniSectors.get(lapNum) == null){
                HashMap<Integer, Long> newLap = new HashMap<>();
                newLap.put(0, System.currentTimeMillis());
                miniSectors.put(lapNum, newLap);
            }else{
                int index = (int) (lapDistance / MINISECTOR_GAP);
                
                if(miniSectors.get(lapNum).get(index) == null){
                    miniSectors.get(lapNum).put(index, System.currentTimeMillis());
                }
            }
            
        }
    }
    
    public void setFuelUsed(){
        if(lap != null && carStatus != null){
            if(lap.currentLapNum == 1 && lap.totalDistance <= 0f){
                if(fuelUsed.get(0) == null){
                    fuelUsed.put(0, carStatus.fuelInTank);
                }
            }else{
                if(fuelUsed.get(lap.currentLapNum - 1) == null){
                    fuelUsed.put(lap.currentLapNum - 1, carStatus.fuelInTank);
                }
            }
        }
    }
    
    public void initializeSectores(){
        bestS1 = Float.POSITIVE_INFINITY;
        bestS2 = Float.POSITIVE_INFINITY;
        bestS3 = Float.POSITIVE_INFINITY;
        lastS1 = Float.POSITIVE_INFINITY;
        lastS2 = Float.POSITIVE_INFINITY;
        lastS3 = Float.POSITIVE_INFINITY;
        previousLaps = new HashMap<>();
        miniSectors = new HashMap<>();
        stints = new ArrayList<>();
        fuelUsed = new HashMap<>();
    }
    
    public float getLapTime(int lap){
        try{
            return previousLaps.get(lap);
        }catch(Exception e){
            return -1f;
        }
    }
    
    public float getLastS1(){
        if(lastS1 == Float.POSITIVE_INFINITY){
            return 0f;
        }else{
            return lastS1;
        }
    }
    
    public float getLastS2(){
        if(lastS2 == Float.POSITIVE_INFINITY){
            return 0f;
        }else{
            return lastS2;
        }
    }
    
    public float getLastS3(){
        if(lastS3 == Float.POSITIVE_INFINITY){
            return 0f;
        }else{
            return lastS3;
        }
    }
    
    public void setNewLap(LapData newLap){
        lap = newLap;
        
        setPreviousGapTimes(lap.lapDistance, lap.currentLapNum);
        setStint();
        setFuelUsed();
        if(lap.getSector() != 1 && lap.sector1Time != 0f){
            lastS1 = lap.sector1Time;
            if(lastS1 < bestS1){
                bestS1 = lastS1;
                if(bestS1 <= session.bestS1){
                    session.bestS1 = bestS1;
                }
            }
        }
        if(lap.getSector() == 3 && lap.sector1Time != 0f){
            lastS2 = lap.sector2Time;
            if(lastS2 < bestS2){
                bestS2 = lastS2;
                if(bestS2 < session.bestS2){
                    session.bestS2 = bestS2;
                }
            }
        }
        if(lap.getSector() == 1 && lap.lastLapTime != 0f && lastS1 != Float.POSITIVE_INFINITY && lastS2 != Float.POSITIVE_INFINITY){
            lastS3 = lap.lastLapTime - lastS1 - lastS2;
            if(lastS3 < bestS3){
                bestS3 = lastS3;
                if(bestS3 < session.bestS3){
                    session.bestS3 = bestS3;
                }
            }
        }
        if(lap.getSector() == 1){
            if(lap.lastLapTime != 0f){
                previousLaps.put(lap.currentLapNum - 1, lap.lastLapTime);
                
                if(lap.lastLapTime == lap.bestLapTime && session.betterThanLap(lap.bestLapTime)){
                    session.bestLap = lap.bestLapTime;
                }
            }
        }
    }
    
    public void setNewParticipant(ParticipantData pd){
        participant = pd;
    }
    
    public void setNewCarTelemetry(CarTelemetryData ctd){
        carTelemetry = ctd;
    }
    
    public void setNewCarStatus(CarStatusData csd){
        carStatus = csd;
    }
    
    public void setNewCarSetup(CarSetupData csd){
        carSetup = csd;
    }
    
    public void setNewCarMotion(CarMotionData cmd){
        carMotion = cmd;
    }
    
    public String toString(){
        String ret = "";
        if(participant != null){
            ret += "Driver:\n"+participant.toString();
        }
        return ret;
    }
}
