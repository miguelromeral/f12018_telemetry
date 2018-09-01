package classes;

import Packets.CarStatusData;
import Packets.CarTelemetryData;
import Packets.LapData;
import Packets.PacketCarStatusData;
import Packets.PacketCarTelemetryData;
import Packets.PacketEventData;
import Packets.PacketLapData;
import Packets.PacketParticipantsData;
import Packets.PacketSessionData;
import Packets.ParticipantData;
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
    public ArrayList<Driver> drivers;
    public ArrayList<LapData> laps;
    
    public float bestS1;
    public float bestS2;
    public float bestS3;
    public float bestLap;
    
    public Session(){
        initialize();
    }
    
    public void initialize(){
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
    
    public ArrayList<Driver> getDrivers(){
        return drivers;
    }
    
    public Driver getUserDriver(){
        if(!drivers.isEmpty()){
            return drivers.get(userIndex);
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
                }
                /*else{
                    if(d.
                }*/
            }
            return null;
        }
        return null;
    }
    
    public void setCarStatusData(PacketCarStatusData packetCarStatusData){
        if(drivers != null){
            if(!drivers.isEmpty()){
                for(int i=0; i<drivers.size(); i++){
                    drivers.get(i).setNewCarStatus(packetCarStatusData.carStatusData.get(i));
                }
            }
        }
    }
    
    public void setCarTelemetryData(PacketCarTelemetryData packetCarTelemetryData){
        if(drivers != null){
            if(!drivers.isEmpty()){
                for(int i=0; i<drivers.size(); i++){
                    drivers.get(i).setNewCarTelemetry(packetCarTelemetryData.carTelemetryData.get(i));
                }
            }
        }
    }
    
    public void setParticipantsData(PacketParticipantsData packetParticipantsData){
        if(drivers != null){
            if(!drivers.isEmpty()){
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
        }else{
            drivers = new ArrayList<>();
            for(ParticipantData pd : packetParticipantsData.participants){
                Driver d = new Driver(pd, this);
                drivers.add(d);
            }
            System.out.println("SET PARTICIPANTS!");
        }
    }
    
    
    public void setEventAction(PacketEventData packetEventData){
        if(packetEventData.eventStringCode.equals("SSTA")){
            initialize();
            drivers = null;
            
        }
    }
    
    
    public void setLapData(PacketLapData packetLapData){
        if(drivers != null){
            if(!drivers.isEmpty()){
                for(int i=0; i<drivers.size(); i++){
                    drivers.get(i).setNewLap(packetLapData.lapData.get(i));
                }
            }

            laps = packetLapData.lapData;
        }
    }
    
    public void setSessionData(PacketSessionData packetSessionData){
        data = packetSessionData;
    }
    
}
