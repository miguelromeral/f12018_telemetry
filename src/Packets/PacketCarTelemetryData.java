package Packets;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author miguelangel.garciar
 */
public class PacketCarTelemetryData extends Packet{
    
    public static int LENGHT = 1085; // Bytes
    
    public ArrayList<CarTelemetryData> carTelemetryData = new ArrayList<>();
    
    public PacketCarTelemetryData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;

        int from = Packet.HEADER_SIZE;
        int to = 0;
        byte[] carcontent;
        int count = 0;
        while(count < 20){
            to = from + CarTelemetryData.SIZE;

            //System.out.println("["+count+"] -> From ("+from+") to ("+to+")");
            carcontent = Arrays.copyOfRange(content, from, to);
            
            CarTelemetryData ctd = new CarTelemetryData(carcontent);
            carTelemetryData.add(ctd);
            
            from += CarTelemetryData.SIZE;
            count ++;
        }

    }
    
    public String toString(){
        String ret = super.toString();
                
        for(CarTelemetryData car : carTelemetryData){
            ret += "\n------------\n";
            ret += " Car X\n";
            ret += car.toString();
            
            return ret;
        }
        
        return ret;
    }
    
}
