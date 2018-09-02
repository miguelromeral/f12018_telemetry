package Packets;

import classes.DataTypeUtilities;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author miguelangel.garciar
 */
public class CarMotionData {
    
    /**
     * Size in bytes of the structure
     */
    public static int SIZE = 60;
    
    /**
     * World space X position.
     */
    public float         worldPositionX;
    /**
     * World space Y position.
     */
    public float         worldPositionY;
    /**
     * World space Z position.
     */
    public float         worldPositionZ;
    /**
     * Velocity in world space X.
     */
    public float         worldVelocityX;
    /**
     * Velocity in world space Y.
     */
    public float         worldVelocityY;
    /**
     * Velocity in world space Z.
     */
    public float         worldVelocityZ;
    /**
     * World space forward X direction (normalised).
     */
    public float         worldForwardDirX;
    /**
     * World space forward Y direction (normalised).
     */
    public float         worldForwardDirY;
    /**
     * World space forward Z direction (normalised).
     */
    public float         worldForwardDirZ;
    /**
     * World space right X direction (normalised).
     */
    public float         worldRightDirX;
    /**
     * World space right Y direction (normalised).
     */
    public float         worldRightDirY;
    /**
     * World space right Z direction (normalised).
     */
    public float         worldRightDirZ;
    /**
     * Lateral G-Force component.
     */
    public float         gForceLateral;
    /**
     * Longitudinal G-Force component.
     */
    public float         gForceLongitudinal;
    /**
     * Vertical G-Force component.
     */
    public float         gForceVertical;
    /**
     * Yaw angle in radians.
     */
    public float         yaw;
    /**
     * Pitch angle in radians.
     */
    public float         pitch;
    /**
     * Roll angle in radians.
     */
    public float         roll;
    
    
    public CarMotionData(byte[] content){
        ByteBuffer bb = ByteBuffer.wrap(content);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        
        worldPositionX = DataTypeUtilities.convert_float(bb.getFloat());
        worldPositionY = DataTypeUtilities.convert_float(bb.getFloat());
        worldPositionZ = DataTypeUtilities.convert_float(bb.getFloat());
        worldVelocityX =DataTypeUtilities.convert_float(bb.getFloat());
        worldVelocityY = DataTypeUtilities.convert_float(bb.getFloat());
        worldVelocityZ = DataTypeUtilities.convert_float(bb.getFloat());
        
        worldForwardDirX = DataTypeUtilities.convert_float_normalised_vector(bb.getShort());
        worldForwardDirY  = DataTypeUtilities.convert_float_normalised_vector(bb.getShort());
        worldForwardDirZ  = DataTypeUtilities.convert_float_normalised_vector(bb.getShort());
        worldRightDirX = DataTypeUtilities.convert_float_normalised_vector(bb.getShort());
        worldRightDirY = DataTypeUtilities.convert_float_normalised_vector(bb.getShort());
        worldRightDirZ = DataTypeUtilities.convert_float_normalised_vector(bb.getShort());
        
        gForceLateral = DataTypeUtilities.convert_float(bb.getFloat());
        gForceLongitudinal = DataTypeUtilities.convert_float(bb.getFloat());
        gForceVertical = DataTypeUtilities.convert_float(bb.getFloat());
        yaw =DataTypeUtilities.convert_float(bb.getFloat());
        pitch = DataTypeUtilities.convert_float(bb.getFloat());
        roll = DataTypeUtilities.convert_float(bb.getFloat());
    }
    
    /**
     * Get all data.
     * @return 
     */
    public String toString(){
        String ret = "World Position X: "+worldPositionX+"\n";
        ret += "World Position Y: "+worldPositionY+"\n";
        ret += "World Position Z: "+worldPositionZ+"\n";
        
        ret += "World Forward Dir X: "+worldForwardDirX+"\n";
        ret += "World Forward Dir Y: "+worldForwardDirY+"\n";
        ret += "World Forward Dir Z: "+worldForwardDirZ+"\n";
        ret += "World Right Dir X: "+worldRightDirX+"\n";
        ret += "World Right Dir Y: "+worldRightDirY+"\n";
        ret += "World Right Dir Z: "+worldRightDirZ+"\n";
        
        ret += "G Force Lateral: "+gForceLateral+"\n";
        ret += "G Force Longitudinal: "+gForceLongitudinal+"\n";
        ret += "G Force Vertical: "+gForceVertical+"\n";
        ret += "Yaw: "+yaw+"\n";
        ret += "Pitch: "+pitch+"\n";
        ret += "Roll: "+roll+"\n";
        
        
        return ret;
    }
}
