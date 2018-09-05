package packets.cartelemetry;

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
public class PacketCarTelemetryData extends Packet{
    
    ////////////////////////////////////////////////////////////////
    //                                                            //
    //                   CAR TELEMTRY PACKET                      //
    //                                                            //
    ////////////////////////////////////////////////////////////////
    /**
     * Packet Size in bytes (w/o header size).
     */
    public static int LENGHT = 1085;
    /**
     * List of all car telemetry data in session.
     */
    public ArrayList<CarTelemetryData> carTelemetryData = new ArrayList<>();
    
    /**
     * Packet Car Telemetry constructor.
     * @param content All byte content in datagram.
     */
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
    
    /**
     * Get all data.
     * @return 
     */
    public String toString(){
        String ret = super.toString();
                
        for(CarTelemetryData car : carTelemetryData){
            ret += "\n------------\n";
            ret += " Car X\n";
            ret += car.toString();
        }
        
        return ret;
    }
    
}
