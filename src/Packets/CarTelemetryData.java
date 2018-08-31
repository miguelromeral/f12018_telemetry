package Packets;

import classes.DataTypeUtilities;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import sun.misc.FloatingDecimal;

/**
 *
 * @author miguelangel.garciar
 */
public class CarTelemetryData {
    
    public static int SIZE = 53;       // bytes
    
    public int      speed;                      // Speed of car in kilometres per hour
    public short    throttle;                   // Amount of throttle applied (0 to 100)
    public short    steer;                      // Steering (-100 (full lock left) to 100 (full lock right))
    public short    brake;                      // Amount of brake applied (0 to 100)
    public short    clutch;                     // Amount of clutch applied (0 to 100)
    public short    gear;                       // Gear selected (1-8, N=0, R=-1)
    public int      engineRPM;                  // Engine RPM
    public short    drs;                        // 0 = off, 1 = on
    public short    revLightsPercent;           // Rev lights indicator (percentage)
    public int      brakesTemperature[];        // Brakes temperature (celsius)
    public int      tyresSurfaceTemperature[];  // Tyres surface temperature (celsius)
    public int      tyresInnerTemperature[];    // Tyres inner temperature (celsius)
    public int      engineTemperature;          // Engine temperature (celsius)
    public float    tyresPressure[];            // Tyres pressure (PSI)
    
    public CarTelemetryData(byte[] content) {
        ByteBuffer bb = ByteBuffer.wrap(content);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        
        speed = DataTypeUtilities.convert_uint16(bb.getShort());
        throttle = DataTypeUtilities.convert_uint8(bb.get());
        steer = DataTypeUtilities.convert_uint8(bb.get());
        brake = DataTypeUtilities.convert_uint8(bb.get());
        clutch = DataTypeUtilities.convert_uint8(bb.get());
        gear = DataTypeUtilities.convert_uint8(bb.get());
        engineRPM = (short) DataTypeUtilities.convert_uint16(bb.getShort());
        drs = DataTypeUtilities.convert_uint8(bb.get());
        revLightsPercent = DataTypeUtilities.convert_uint8(bb.get());
        brakesTemperature = new int[4];
        brakesTemperature[0] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        brakesTemperature[1] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        brakesTemperature[2] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        brakesTemperature[3] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        tyresSurfaceTemperature = new int[4];
        tyresSurfaceTemperature[0] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        tyresSurfaceTemperature[1] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        tyresSurfaceTemperature[2] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        tyresSurfaceTemperature[3] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        tyresInnerTemperature = new int[4];
        tyresInnerTemperature[0] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        tyresInnerTemperature[1] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        tyresInnerTemperature[2] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        tyresInnerTemperature[3] = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        engineTemperature = (int) DataTypeUtilities.convert_uint16(bb.getShort());
        tyresPressure = new float[4];
        tyresPressure[0] = DataTypeUtilities.convert_float_vector(bb.getFloat());
        tyresPressure[1] = DataTypeUtilities.convert_float_vector(bb.getFloat());
        tyresPressure[2] = DataTypeUtilities.convert_float_vector(bb.getFloat());
        tyresPressure[3] = DataTypeUtilities.convert_float_vector(bb.getFloat());
    }
    
    public String getDRS(){
        switch(drs){
            case 0: return "OFF";
            case 1: return "ON";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getGear(){
        switch(gear){
            case -1: return "R";
            case 0: return "N";
            case 1: return "1";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            default: return "-";
        }
    }
    
    public String toString(){
        String ret = "Speed: "+speed+" kpm\n";
        ret += "Throttle: "+throttle+"\n";
        ret += "Steer: "+steer+"\n";
        ret += "Brake: "+brake+"\n";
        ret += "Clutch: "+clutch+"\n";
        ret += "Gear: "+gear+"\n";
        
        
        ret += "Engine RPM: "+engineRPM+" rpm\n";
        ret += "DRS: "+getDRS()+"\n";
        ret += "Rev lights Percent: "+revLightsPercent+" %\n";
        ret += "Brakes Temperature:\n";
        ret += " - RL: "+brakesTemperature[0]+" ºC\n";
        ret += " - RL: "+brakesTemperature[1]+" ºC\n";
        ret += " - RL: "+brakesTemperature[2]+" ºC\n";
        ret += " - RL: "+brakesTemperature[3]+" ºC\n";
        ret += "Tyres Surface Temperature:\n";
        ret += " - RL: "+tyresSurfaceTemperature[0]+" ºC\n";
        ret += " - RL: "+tyresSurfaceTemperature[1]+" ºC\n";
        ret += " - RL: "+tyresSurfaceTemperature[2]+" ºC\n";
        ret += " - RL: "+tyresSurfaceTemperature[3]+" ºC\n";
        ret += "Tyres Inner Temperature:\n";
        ret += " - RL: "+tyresInnerTemperature[0]+" ºC\n";
        ret += " - RL: "+tyresInnerTemperature[1]+" ºC\n";
        ret += " - RL: "+tyresInnerTemperature[2]+" ºC\n";
        ret += " - RL: "+tyresInnerTemperature[3]+" ºC\n";
        ret += "Engine Temperature: "+engineTemperature+" ºC\n";
        ret += "Tyres Pressure:\n";
        ret += " - RL: "+tyresPressure[0]+" psi\n";
        ret += " - RL: "+tyresPressure[1]+" psi\n";
        ret += " - RL: "+tyresPressure[2]+" psi\n";
        ret += " - RL: "+tyresPressure[3]+" psi\n";
    
        
        return ret;
    }
}
