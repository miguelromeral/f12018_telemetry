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
    ArrayList<CarMotionData> carMotionData = new ArrayList<>();;

    // EXTRA PLAYER CAR ONLY DATA
    /**
     * Suspension Position. Wheels in order: RL, RR, FL, FR.
     */
    float[] suspensionPosition;
    /**
     * Suspension Velocity.
     */
    float[] suspensionVelocity;
    /**
     * Suspension Acceleration.
     */
    float[] suspensionAcceleration;
    /**
     * Speed of each wheel.
     */
    float[] wheelSpeed;
    /**
     * Slip ratio for each wheel.
     */
    float[] wheelSlip;
    /**
     * Velocity in local space.
     */
    float localVelocityX;
    /**
     * Velocity in local space.
     */
    float localVelocityY;
    /**
     * Velocity in local space.
     */
    float localVelocityZ;
    /**
     * Angular velocity x-component.
     */
    float angularVelocityX;
    /**
     * Angular velocity y-component.
     */
    float angularVelocityY;
    /**
     * Angular velocity z-component.
     */
    float angularVelocityZ;
    /**
     * Angular velocity x-component.
     */
    float angularAccelerationX;
    /**
     * Angular velocity y-component.
     */
    float angularAccelerationY;
    /**
     * Angular velocity z-component.
     */
    float angularAccelerationZ;
    /**
     * Current front wheels angle in radians.
     */
    float frontWheelsAngle;

    
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
        
        
        ByteBuffer bb = ByteBuffer.wrap(Arrays.copyOfRange(content, Packet.HEADER_SIZE + 20 * CarMotionData.SIZE, LENGHT));
        bb.order(ByteOrder.LITTLE_ENDIAN);
        
        suspensionPosition = new float[4];
        suspensionPosition[0] = DataTypeUtilities.convert_float(bb.getFloat());
        suspensionPosition[1] = DataTypeUtilities.convert_float(bb.getFloat());
        suspensionPosition[2] = DataTypeUtilities.convert_float(bb.getFloat());
        suspensionPosition[3] = DataTypeUtilities.convert_float(bb.getFloat());
        
        suspensionVelocity = new float[4];
        suspensionVelocity[0] = DataTypeUtilities.convert_float(bb.getFloat());
        suspensionVelocity[1] = DataTypeUtilities.convert_float(bb.getFloat());
        suspensionVelocity[2] = DataTypeUtilities.convert_float(bb.getFloat());
        suspensionVelocity[3] = DataTypeUtilities.convert_float(bb.getFloat());
        
        suspensionAcceleration = new float[4];
        suspensionAcceleration[0] = DataTypeUtilities.convert_float(bb.getFloat());
        suspensionAcceleration[1] = DataTypeUtilities.convert_float(bb.getFloat());
        suspensionAcceleration[2] = DataTypeUtilities.convert_float(bb.getFloat());
        suspensionAcceleration[3] = DataTypeUtilities.convert_float(bb.getFloat());
        
        wheelSpeed = new float[4];
        wheelSpeed[0] = DataTypeUtilities.convert_float(bb.getFloat());
        wheelSpeed[1] = DataTypeUtilities.convert_float(bb.getFloat());
        wheelSpeed[2] = DataTypeUtilities.convert_float(bb.getFloat());
        wheelSpeed[3] = DataTypeUtilities.convert_float(bb.getFloat());
        
        wheelSlip = new float[4];
        wheelSlip[0] = DataTypeUtilities.convert_float(bb.getFloat());
        wheelSlip[1] = DataTypeUtilities.convert_float(bb.getFloat());
        wheelSlip[2] = DataTypeUtilities.convert_float(bb.getFloat());
        wheelSlip[3] = DataTypeUtilities.convert_float(bb.getFloat());
        

        localVelocityX = DataTypeUtilities.convert_float(bb.getFloat());
        localVelocityY = DataTypeUtilities.convert_float(bb.getFloat());
        localVelocityZ = DataTypeUtilities.convert_float(bb.getFloat());
        angularVelocityX = DataTypeUtilities.convert_float(bb.getFloat());
        angularVelocityY = DataTypeUtilities.convert_float(bb.getFloat());
        angularVelocityZ = DataTypeUtilities.convert_float(bb.getFloat());
        angularAccelerationX = DataTypeUtilities.convert_float(bb.getFloat());
        angularAccelerationY = DataTypeUtilities.convert_float(bb.getFloat());
        angularAccelerationZ = DataTypeUtilities.convert_float(bb.getFloat());
        frontWheelsAngle = DataTypeUtilities.convert_float(bb.getFloat());
    }
    
    /**
     * Get all data.
     * @return 
     */
    @Override
    public String toString(){
        String ret = super.toString();
        
      /*  for (CarMotionData cmd : carMotionData){
            ret += "-----------------\n";
            ret += cmd.toString();
            //return ret;
        }
      */
        ret += "Suspension Position:\n";
        ret += "RL: "+suspensionPosition[0]+"\n";
        ret += "RR: "+suspensionPosition[1]+"\n";
        ret += "FL: "+suspensionPosition[2]+"\n";
        ret += "FR: "+suspensionPosition[3]+"\n";
     
        ret += "Suspension Velocity:\n";
        ret += "RL: "+suspensionVelocity[0]+"\n";
        ret += "RR: "+suspensionVelocity[1]+"\n";
        ret += "FL: "+suspensionVelocity[2]+"\n";
        ret += "FR: "+suspensionVelocity[3]+"\n";
       
        ret += "Suspension Acceleration:\n";
        ret += "RL: "+suspensionAcceleration[0]+"\n";
        ret += "RR: "+suspensionAcceleration[1]+"\n";
        ret += "FL: "+suspensionAcceleration[2]+"\n";
        ret += "FR: "+suspensionAcceleration[3]+"\n";
        
        ret += "Wheel speed:\n";
        ret += "RL: "+wheelSpeed[0]+"\n";
        ret += "RR: "+wheelSpeed[1]+"\n";
        ret += "FL: "+wheelSpeed[2]+"\n";
        ret += "FR: "+wheelSpeed[3]+"\n";
        
        ret += "Wheel slip:\n";
        ret += "RL: "+wheelSlip[0]+"\n";
        ret += "RR: "+wheelSlip[1]+"\n";
        ret += "FL: "+wheelSlip[2]+"\n";
        ret += "FR: "+wheelSlip[3]+"\n";
        
        ret += "Local Velocity X:"+localVelocityX+"\n";
        ret += "Local Velocity Y:"+localVelocityY+"\n";
        ret += "Local Velocity Z:"+localVelocityZ+"\n";
        ret += "Angular Velocity X:"+angularVelocityX+"\n";
        ret += "Angular Velocity Y:"+angularVelocityY+"\n";
        ret += "Angular Velocity Z:"+angularVelocityZ+"\n";
        ret += "Angular Acceleration X:"+angularAccelerationX+"\n";
        ret += "Angular Acceleration Y:"+angularAccelerationY+"\n";
        ret += "Angular Acceleration Z:"+angularAccelerationZ+"\n";
        ret += "Front Wheels Angle:"+frontWheelsAngle+"\n";
        
        return ret;
    }
}
