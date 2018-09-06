package classes;

import com.sun.jmx.snmp.Timestamp;
import packets.motion.CarMotionData;
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
    public HashMap<Integer, Long> miniSectors;
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
    
    public void setPreviousGapTimes(float distance){
        int index = (int) (distance / 250);
        if(miniSectors.get(index) == null){
            miniSectors.put(index, System.currentTimeMillis());
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
    }
    
    public float getLapTime(int lap){
        try{
            return previousLaps.get(lap);
        }catch(Exception e){
            return 0f;
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
        setPreviousGapTimes(lap.totalDistance);
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
}
