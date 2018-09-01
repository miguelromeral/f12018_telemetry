package Packets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Car Status Packet.
 *
 * @author miguelangel.garciar
 * @author Codemasters
 * @see
 * https://forums.codemasters.com/discussion/136948/f1-2018-udp-specification
 */
public class PacketCarStatusData extends Packet{
    
    ////////////////////////////////////////////////////////////////
    //                                                            //
    //                  CAR STATUS DATA PACKET                    //
    //                                                            //
    ////////////////////////////////////////////////////////////////
    /**
     * Packet Size in bytes (w/o header size).
     */
    public static int LENGHT = 1061;
    /**
     * List of all car status data in the session.
     */
    public ArrayList<CarStatusData> carStatusData = new ArrayList<>();
    
    /**
     * Packet Car Status constructor.
     * @param content 
     */
    public PacketCarStatusData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;

        int from = Packet.HEADER_SIZE;
        int to = 0;
        byte[] carcontent;
        while(from < LENGHT){
            to = from + CarStatusData.SIZE;

            carcontent = Arrays.copyOfRange(content, from, to);
            
            CarStatusData csd = new CarStatusData(carcontent);
            carStatusData.add(csd);
            
            from += CarStatusData.SIZE;
        }

    }
    
    /**
     * Get all data.
     * @return 
     */
    public String toString(){
        String ret = super.toString();
                
        for(CarStatusData car : carStatusData){
            ret += "\n------------\n";
            ret += car.toString();
        }
        
        return ret;
    }
    
}
