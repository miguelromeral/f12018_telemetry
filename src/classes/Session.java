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

/**
 *
 * @author miguelangel.garciar
 */
public class Session {
    
    public int userIndex;
    public PacketSessionData data;
    public ArrayList<Driver> drivers;
    
    public float bestS1 = Float.POSITIVE_INFINITY;
    public float bestS2 = Float.POSITIVE_INFINITY;
    public float bestS3 = Float.POSITIVE_INFINITY;
    public float bestLap = Float.POSITIVE_INFINITY;
    
    public Session(){
        drivers = new ArrayList<>();
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
        //System.out.println("Best SECTOR: "+LapData.formatSeconds(bestS1, true)+", Matching: "+LapData.formatSeconds(sector, true)+", result: "+(sector <= bestS1));
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
    
    public void setCarStatusData(PacketCarStatusData packetCarStatusData){
        if(!drivers.isEmpty()){
            for(int i=0; i<drivers.size(); i++){
                drivers.get(i).setNewCarStatus(packetCarStatusData.carStatusData.get(i));
            }
        }
    }
    
    public void setCarTelemetryData(PacketCarTelemetryData packetCarTelemetryData){
        if(!drivers.isEmpty()){
            for(int i=0; i<drivers.size(); i++){
                drivers.get(i).setNewCarTelemetry(packetCarTelemetryData.carTelemetryData.get(i));
            }
        }
    }
    
    public void setParticipantsData(PacketParticipantsData packetParticipantsData){
        if(drivers.isEmpty()){
            for(ParticipantData pd : packetParticipantsData.participants){
                Driver d = new Driver(pd, this);
                drivers.add(d);
                
                if(d.participant.driverId == 15){
                    System.out.println("BOTTAS!");
                }
            }
            System.out.println("SET PARTICIPANTS!");
        }else{
            
            // Tratar aquí el cambio de pilotos
            
            for(int i=0; i<drivers.size(); i++){
                drivers.get(i).setNewParticipant(packetParticipantsData.participants.get(i));
            }
        }
    }
    
    
    public void setEventAction(PacketEventData packetEventData){
       
    }
    
    
    public void setLapData(PacketLapData packetLapData){
        if(!drivers.isEmpty()){
            for(int i=0; i<drivers.size(); i++){
                drivers.get(i).setNewLap(packetLapData.lapData.get(i));
            }
        }
    }
    
    public void setSessionData(PacketSessionData packetSessionData){
        data = packetSessionData;
    }
    
}
