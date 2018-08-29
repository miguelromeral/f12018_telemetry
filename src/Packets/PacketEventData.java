package Packets;

import static Packets.PacketParticipantsData.LENGHT;
import java.util.Arrays;

/**
 *
 * @author miguelangel.garciar
 */
public class PacketEventData extends Packet{
    
    public static int LENGHT = 25; // Bytes
    
    public String eventStringCode;           // Event string code, see above
    
    public PacketEventData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;
        
        try{
            eventStringCode = new String(Arrays.copyOfRange(content, 21, 25), "UTF-8");
        }catch(Exception e){
            eventStringCode = "** UNKNOWN **";
        }
    }
    
    
    public String toString(){
        String ret = super.toString();
        
        ret += "Event String Code: "+eventStringCode+"\n";
        
        return ret;
    }
}
