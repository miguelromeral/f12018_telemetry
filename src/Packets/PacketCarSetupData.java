package Packets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Car Setup Packet.
 *
 * @author miguelangel.garciar
 * @author Codemasters
 * @see
 * https://forums.codemasters.com/discussion/136948/f1-2018-udp-specification
 */
public class PacketCarSetupData extends Packet{
        
    ////////////////////////////////////////////////////////////////
    //                                                            //
    //                      CAR SETUP PACKET                      //
    //                                                            //
    ////////////////////////////////////////////////////////////////
    /**
     * Packet Size in bytes (w/o header size).
     */
    public static int LENGHT = 841;
    /**
     * List of all car setup data.
     */
    public ArrayList<CarSetupData> carSetupData = new ArrayList<>();
    
    /**
     * Packet Car Setup Data constructor.
     * @param content All byte content in datagram.
     */
    public PacketCarSetupData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;

        int from = Packet.HEADER_SIZE;
        int to = 0;
        byte[] carcontent;
        int count = 0;
        while(count < 20){
            to = from + CarSetupData.SIZE;
            carcontent = Arrays.copyOfRange(content, from, to);
            CarSetupData ctd = new CarSetupData(carcontent);
            carSetupData.add(ctd);
            
            from += CarSetupData.SIZE;
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
                
        for(CarSetupData car : carSetupData){
            ret += "\n------------\n";
            ret += car.toString();
        }
        
        return ret;
    }
}
