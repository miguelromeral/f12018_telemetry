package classes;

import packets.carmotion.CarMotionData;
import packets.carstatus.CarStatusData;
import packets.cartelemetry.CarTelemetryData;
import packets.carmotion.ExtraCarMotionData;
import packets.lapdata.LapData;
import packets.carsetup.PacketCarSetupData;
import packets.carstatus.PacketCarStatusData;
import packets.cartelemetry.PacketCarTelemetryData;
import packets.event.PacketEventData;
import packets.lapdata.PacketLapData;
import packets.carmotion.PacketMotionData;
import packets.participants.PacketParticipantsData;
import packets.session.PacketSessionData;
import packets.participants.ParticipantData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author miguelangel.garciar
 */
public class Session {
    
    public int userIndex;
    public PacketSessionData data;
    public ExtraCarMotionData extraMotionData;
    public ArrayList<Driver> drivers;
    public String status;
    
    public float bestS1;
    public float bestS2;
    public float bestS3;
    public float bestLap;
    
    public Session(){
        initialize();
    }
    
    public void initialize(){
        status = "SSTA";
        bestS1 = Float.POSITIVE_INFINITY;
        bestS2 = Float.POSITIVE_INFINITY;
        bestS3 = Float.POSITIVE_INFINITY;
        bestLap = Float.POSITIVE_INFINITY;
        
        if(drivers != null){
            for(Driver d : drivers){
                d.initializeSectores();
            }
        }
    }
    
    public boolean isInitialized(){
        if(status.equals("SSTA") && drivers != null && data != null){
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<Driver> getAllDrivers(){
        if(drivers != null){
            return drivers;
        }else{
            return null;
        }
    }
    
    public Driver getUserDriver(){
        if(drivers != null && !drivers.isEmpty()){
            return drivers.get(userIndex);
        }
        return null;
    }
    
    public Driver getDriverByName(String name){
        for(Driver d : drivers){
            if(d.participant.getName().equalsIgnoreCase(name)){
                return d;
            }
        }
        return null;
    }
    
    public synchronized boolean betterThanS1(float sector){
        if(LapData.formatSeconds(sector, true) != null){
            return sector <= bestS1;
        }else{
            return false;
        }
    }
    
    public synchronized boolean betterThanS2(float sector){
        if(LapData.formatSeconds(sector, true) != null){
            return sector <= bestS2;
        }else{
            return false;
        }
    }
    
    public synchronized boolean betterThanS3(float sector){
        if(LapData.formatSeconds(sector, true) != null){
            return sector <= bestS3;
        }else{
            return false;
        }
    }
    
    public synchronized boolean betterThanLap(float lap){
        if(LapData.formatSeconds(lap, true) != null){
            return lap <= bestLap;
        }else{
            return false;
        }
    }
    
    public ArrayList<String> getAllNameParticipants(){
        ArrayList<String> list = new ArrayList<>();
        
        if(drivers != null){
            for(Driver d : drivers){
                list.add(d.participant.getName());
            }
        }
        
        return list;
    }
    
    public void setUserIndex(int user){
        this.userIndex = user;
    }
    
    public Driver getDriverByPosition(int pos){
        if(drivers != null){
            for(Driver d : drivers){
                if(d.lap != null){
                    if(d.lap.carPosition == pos){
                        return d;
                    }
                }else{
                    return null;
                }
            }
            return null;
        }
        return null;
    }
    
    public void createDrivers(PacketParticipantsData ppd){
        if(drivers == null){
            drivers = new ArrayList<>();
            for(int i=0; i<ppd.participants.size(); i++){
                Driver d = new Driver(ppd.participants.get(i), this);
                drivers.add(d);
            }
        }
    }
    
    public void setCarSetupData(PacketCarSetupData pcsd){
        if(drivers != null && !drivers.isEmpty()){
            for(int i=0; i<drivers.size(); i++){
                drivers.get(i).setNewCarSetup(pcsd.carSetupData.get(i));
            }
        }
    }
    
    public void setCarStatusData(PacketCarStatusData packetCarStatusData){
       /* if(drivers == null){
            createDrivers(packetCarStatusData.carStatusData.size());
        }*/
        if(drivers != null && !drivers.isEmpty()){
            for(int i=0; i<drivers.size(); i++){
                drivers.get(i).setNewCarStatus(packetCarStatusData.carStatusData.get(i));
            }
        }
    }
    
    public void setCarTelemetryData(PacketCarTelemetryData packetCarTelemetryData){
       /* if(drivers == null){
            createDrivers(packetCarTelemetryData.carTelemetryData.size());
        }*/
        if(drivers != null && !drivers.isEmpty()){
            for(int i=0; i<drivers.size(); i++){
                drivers.get(i).setNewCarTelemetry(packetCarTelemetryData.carTelemetryData.get(i));
            }
        }
    }
    
    public void setMotionData(PacketMotionData pmd){
      /*  if(drivers == null){
            createDrivers(pmd.carMotionData.size());
        }*/
        if(drivers != null && !drivers.isEmpty()){
            for(int i=0; i<drivers.size(); i++){
                drivers.get(i).setNewCarMotion(pmd.carMotionData.get(i));
            }
        }
        extraMotionData = pmd.extraCarMotionData;
    }
    
    public void setParticipantsData(PacketParticipantsData packetParticipantsData){
        if(drivers == null){
            createDrivers(packetParticipantsData);
            System.out.println("SET PARTICIPANTS! "+packetParticipantsData.participants.size());
        }
        if(drivers != null && !drivers.isEmpty()){
            HashMap<Short, ParticipantData> driversId = new HashMap<Short, ParticipantData>();

            for(ParticipantData pd : packetParticipantsData.participants){
                driversId.put(pd.driverId, pd);
            }
            for(Driver d : drivers){
                ParticipantData pd = driversId.get(d.participant.driverId);
                if(pd != null){
                    d.setNewParticipant(pd);
                }
            }
        }
    }
    
    
    public void setEventAction(PacketEventData packetEventData){
        if(packetEventData.eventStringCode.equals("SSTA")){
            initialize();
            drivers = null;
        }else{
            status = "SEND";
        }
    }
    
    
    public void setLapData(PacketLapData packetLapData){
     /*   if(drivers == null){
            createDrivers(packetLapData.lapData.size());
        }*/
        if(drivers != null && !drivers.isEmpty()){
            for(int i=0; i<drivers.size(); i++){
                drivers.get(i).setNewLap(packetLapData.lapData.get(i));
            }
        }
    }
    
    public void setSessionData(PacketSessionData packetSessionData){
        data = packetSessionData;
    }
}
