package Packets;

import classes.DataTypeUtilities;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Car Motion Packet.
 *
 * @author miguelangel.garciar
 * @author Codemasters
 * @see
 * https://forums.codemasters.com/discussion/136948/f1-2018-udp-specification
 */
public class PacketMotionData extends Packet{
    
    ////////////////////////////////////////////////////////////////
    //                                                            //
    //                      CAR MOTION PACKET                     //
    //                                                            //
    ////////////////////////////////////////////////////////////////
    /**
     * Packet Size in bytes (w/o header size).
     */
    public static int LENGHT = 1341;
    /**
     * Data for all cars on track (20).
     */
    public ArrayList<CarMotionData> carMotionData = new ArrayList<>();
    /**
     * Extra car motion data (for the user).
     */
    public ExtraCarMotionData extraCarMotionData;
    
    /**
     * Packet Car Telemetry constructor.
     * @param content All byte content in datagram.
     */
    public PacketMotionData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;
        
        int from = Packet.HEADER_SIZE;
        int to = 0;
        int count = 0;
        while(count < 20){
            to = from + CarMotionData.SIZE;

            byte[] cmdc = Arrays.copyOfRange(content, from, to);
            
            CarMotionData cmd = new CarMotionData(cmdc);
            carMotionData.add(cmd);
            
            from += CarMotionData.SIZE;
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
        
        for (CarMotionData cmd : carMotionData){
            ret += "-----------------\n";
            ret += cmd.toString();
        }
        
        ret += extraCarMotionData.toString();
        return ret;
    }
}
