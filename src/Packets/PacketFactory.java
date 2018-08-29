package Packets;

/**
 *
 * @author miguelangel.garciar
 */
public class PacketFactory {
    
    public static Packet getPacket(byte[] content){
        Packet p = new Packet(content);
        switch(p.packetId){
            
            case 4: return new PacketParticipantsData(content);
            
            case 6: return new PacketCarTelemetryData(content);
            case 7: return new PacketCarStatusData(content);
            default: return null;
        }
    }
    
}
