package classes;

import Packets.CarStatusData;
import Packets.CarTelemetryData;
import Packets.PacketCarStatusData;
import Packets.PacketCarTelemetryData;

/**
 *
 * @author miguelangel.garciar
 */
public class Session {
    
    public CarStatusData ownCar;
    public CarTelemetryData ownTelemetry;
    
    public Session(){
        
    }
    
    public void setOwnCarStatusData(PacketCarStatusData packetCarStatusData){
        this.ownCar = packetCarStatusData.carStatusData.get(packetCarStatusData.playerCarIndex);
    }
    
    public void setOwnCarTelemetryData(PacketCarTelemetryData packetCarTelemetryData){
        this.ownTelemetry = packetCarTelemetryData.carTelemetryData.get(packetCarTelemetryData.playerCarIndex);
    }
    
    
}
