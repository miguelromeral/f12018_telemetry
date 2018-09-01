package Packets;

import java.util.Arrays;

/**
 * Event Packet.
 *
 * @author miguelangel.garciar
 * @author Codemasters
 * @see
 * https://forums.codemasters.com/discussion/136948/f1-2018-udp-specification
 */
public class PacketEventData extends Packet{
    
    ////////////////////////////////////////////////////////////////
    //                                                            //
    //                       EVENT PACKET                         //
    //                                                            //
    ////////////////////////////////////////////////////////////////
    /**
     * Packet Size in bytes (w/o header size).
     */    
    public static int LENGHT = 25; // Bytes
    /**
     * Event string code. SSTA or SEND.
     */
    public String eventStringCode;
    
    /**
     * Packet Event contructor.
     * @param content All datagram content in bytes.
     */
    public PacketEventData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;
        
        try{
            eventStringCode = new String(Arrays.copyOfRange(content, 21, 25), "UTF-8");
        }catch(Exception e){
            eventStringCode = "";
        }
    }
    
    /**
     * Get all data.
     * @return 
     */
    @Override
    public String toString(){
        String ret = super.toString();
        
        ret += "Event String Code: "+eventStringCode+"\n";
        
        return ret;
    }
}
