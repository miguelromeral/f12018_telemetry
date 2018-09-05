package packets.participants;

import classes.statics.DataTypeUtilities;
import java.util.ArrayList;
import java.util.Arrays;
import packets.Packet;

/**
 * Session Packet.
 *
 * @author miguelangel.garciar
 * @author Codemasters
 * @see
 * https://forums.codemasters.com/discussion/136948/f1-2018-udp-specification
 */
public class PacketParticipantsData extends Packet{
        
    ////////////////////////////////////////////////////////////////
    //                                                            //
    //                   PARTICIPANT PACKET                       //
    //                                                            //
    ////////////////////////////////////////////////////////////////
    /**
     * Packet Size in bytes (w/o header size).
     */
    public static int LENGHT = 1082;
    /**
     * Number of cars in the data.
     */
    public short numCars;
    /**
     * List of all participants in the packet.
     */
    public ArrayList<ParticipantData> participants = new ArrayList<>();
    
    /**
     * Packet Participant constructor.
     * @param content All datagram content in bytes.
     */
    public PacketParticipantsData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;
        
        numCars = DataTypeUtilities.convert_uint8(content[21]);
        
        int from = Packet.HEADER_SIZE + 1;
        int to = 0;
        byte[] participant;
        int count = 0;
        while(count < numCars){
            to = from + ParticipantData.LENGHT;

            //System.out.println("["+count+"] -> From ("+from+") to ("+to+")");
            participant = Arrays.copyOfRange(content, from, to);
            
            ParticipantData par = new ParticipantData(participant);
            participants.add(par);
            
            from += ParticipantData.LENGHT;
            count ++;
        }
    }
    
    /**
     * Get all data.
     * @return 
     */
    @Override
    public String toString(){
        String ret = super.toString();
        ret += "Num car: "+numCars+"\n";
        for(ParticipantData par : participants){
            ret += "\n------------\n";
            ret += par.toString();
        }
        
        return ret;
    }
    
}
