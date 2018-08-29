package Packets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author miguelangel.garciar
 */
public class PacketCarStatusData extends Packet{
    
    public static int LENGHT = 1061; // Bytes
    
    public ArrayList<CarStatusData> carStatusData = new ArrayList<>();
    
    public PacketCarStatusData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;

        int from = Packet.HEADER_SIZE;
        int to = 0;
        byte[] carcontent;
        while(from < LENGHT){
            to = from + CarStatusData.SIZE;

            //System.out.println("From ("+from+") , to ("+to+")");
            carcontent = Arrays.copyOfRange(content, from, to);
            
            CarStatusData csd = new CarStatusData(carcontent);
            carStatusData.add(csd);
            
            from += CarStatusData.SIZE;
        }

    }
    
    public String toString(){
        String ret = super.toString();
                
        for(CarStatusData car : carStatusData){
            ret += "\n------------\n";
            ret += " Car X\n";
            ret += car.toString();
            
            return ret;
        }
        
        return ret;
    }
    
}
