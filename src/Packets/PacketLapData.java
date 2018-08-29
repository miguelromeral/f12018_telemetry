package Packets;

import static Packets.PacketCarStatusData.LENGHT;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author miguelangel.garciar
 */
public class PacketLapData extends Packet{
    
    public static int LENGHT = 841; // Bytes
    
    public ArrayList<LapData> lapData = new ArrayList<>();
    
    public PacketLapData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;

        int from = Packet.HEADER_SIZE;
        int to = 0;
        byte[] lapcontent;
        while(from < LENGHT){
            to = from + LapData.SIZE;

            lapcontent = Arrays.copyOfRange(content, from, to);
            
            LapData lap = new LapData(lapcontent);
            lapData.add(lap);
            
            from += LapData.SIZE;
        }
    }
    
    public String toString(){
        
        String ret = super.toString();
                
        for(LapData lap : lapData){
            ret += "\n------------\n";
            ret += lap.toString();
            
            return ret;
        }
        
        return ret;
    }
    
}
