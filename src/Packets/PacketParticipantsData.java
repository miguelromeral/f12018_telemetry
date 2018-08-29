package Packets;

import static Packets.PacketCarTelemetryData.LENGHT;
import classes.DataTypeUtilities;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author miguelangel.garciar
 */
public class PacketParticipantsData extends Packet{
    
    public static int LENGHT = 1082; // Bytes
    
    public short numCars;           // Number of cars in the data
    public ArrayList<ParticipantData> participants = new ArrayList<>();
    
    public PacketParticipantsData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;
        
        numCars = DataTypeUtilities.convert_uint8(content[21]);
        
        int from = Packet.HEADER_SIZE + 1;
        int to = 0;
        byte[] participant;
        int count = 0;
        while(count < numCars){
            to = from + ParticipantData.SIZE;

            //System.out.println("["+count+"] -> From ("+from+") to ("+to+")");
            participant = Arrays.copyOfRange(content, from, to);
            
            ParticipantData par = new ParticipantData(participant);
            participants.add(par);
            
            from += ParticipantData.SIZE;
            count ++;
        }
    }
    
    @Override
    public String toString(){
        String ret = super.toString();
        ret += "Num car: "+numCars+"\n";
        for(ParticipantData par : participants){
            ret += "\n------------\n";
            ret += par.toString();
            
            //return ret;
        }
        
        return ret;
    }
    
}
