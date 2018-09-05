package packets.lapdata;

import java.util.ArrayList;
import java.util.Arrays;
import packets.Packet;

/**
 * Lap Data Packet.
 * 
 * @author miguelangel.garciar
 * @author Codemasters
 * @see
 * https://forums.codemasters.com/discussion/136948/f1-2018-udp-specification
 */
public class PacketLapData extends Packet{
    
    ////////////////////////////////////////////////////////////////
    //                                                            //
    //                      LAP DATA PACKET                       //
    //                                                            //
    ////////////////////////////////////////////////////////////////
    // STATIC VALUES
    /**
     * Packet size in bytes (w/o header size).
     */
    public static int LENGHT = 841;
    /**
     * Lap data for all cars on track (20).
     */
    public ArrayList<LapData> lapData = new ArrayList<>();
    
    /**
     * Packet Lap Data constructor.
     * @param content All datagram content in bytes.
     */
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
    
    /**
     * Get all data.
     * @return 
     */
    @Override
    public String toString(){
        
        String ret = super.toString();
                
        for(LapData lap : lapData){
            ret += "\n------------\n";
            ret += lap.toString();
        }
        
        return ret;
    }
    
}
