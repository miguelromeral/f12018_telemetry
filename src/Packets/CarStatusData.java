package Packets;

import classes.DataTypeUtilities;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import sun.misc.FloatingDecimal;

/**
 *
 * @author miguelangel.garciar
 */
public class CarStatusData {
    
    public static int SIZE = 416 / 8;       // bits / (bits / Byte)
    
    // uint8 --> short
    public short       tractionControl;            // 0 (off) - 2 (high)
    // uint8 --> short
    public short       antiLockBrakes;             // 0 (off) - 1 (on)
    // uint8 --> short
    public short       fuelMix;                    // Fuel mix - 0 = lean, 1 = standard, 2 = rich, 3 = max
    // uint8 --> short
    public short       frontBrakeBias;           // Front brake bias (percentage)
    // uint8 --> short
    public short       pitLimiterStatus;         // Pit limiter status - 0 = off, 1 = on
    public float       fuelInTank;               // Current fuel mass
    public float       fuelCapacity;             // Fuel capacity
    // uint16 --> int (32)
    public int         maxRPM;                   // Cars max RPM, point of rev limiter
    // uint16 --> int (32)
    public int         idleRPM;                  // Cars idle RPM
    // uint8 --> short
    public short       maxGears;                 // Maximum number of gears
    // uint8 --> short
    public short       drsAllowed;               // 0 = not allowed, 1 = allowed, -1 = unknown
    // uint8 --> short
    public short       tyresWear[]; // 4         // Tyre wear percentage
    // uint8 --> short
    public short       tyreCompound;             // Modern - 0 = hyper soft, 1 = ultra soft
                                            // 2 = super soft, 3 = soft, 4 = medium, 5 = hard
                                            // 6 = super hard, 7 = inter, 8 = wet
                                            // Classic - 0-6 = dry, 7-8 = wet
    // uint8 --> short
    public short       tyresDamage[]; // 4       // Tyre damage (percentage)
    // uint8 --> short
    public short       frontLeftWingDamage;      // Front left wing damage (percentage)
    // uint8 --> short
    public short       frontRightWingDamage;     // Front right wing damage (percentage)
    // uint8 --> short
    public short       rearWingDamage;           // Rear wing damage (percentage)
    // uint8 --> short
    public short       engineDamage;             // Engine damage (percentage)
    // uint8 --> short
    public short       gearBoxDamage;            // Gear box damage (percentage)
    // uint8 --> short
    public short       exhaustDamage;            // Exhaust damage (percentage)
    // int8 --> short
    public short       vehicleFiaFlags;          // -1 = invalid/unknown, 0 = none, 1 = green
                                            // 2 = blue, 3 = yellow, 4 = red
    public float       ersStoreEnergy;           // ERS energy store in Joules
    // uint8 --> short
    public short       ersDeployMode;            // ERS deployment mode, 0 = none, 1 = low, 2 = medium
                                            // 3 = high, 4 = overtake, 5 = hotlap
    public float       ersHarvestedThisLapMGUK;  // ERS energy harvested this lap by MGU-K
    public float        ersHarvestedThisLapMGUH;  // ERS energy harvested this lap by MGU-H
    public float       ersDeployedThisLap;       // ERS energy deployed this lap
    
    public CarStatusData(byte[] content) {
        ByteBuffer bb = ByteBuffer.wrap(content);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        
        tractionControl = DataTypeUtilities.convert_uint8(bb.get());
        antiLockBrakes = DataTypeUtilities.convert_uint8(bb.get());
        fuelMix = DataTypeUtilities.convert_uint8(bb.get());
        frontBrakeBias = DataTypeUtilities.convert_uint8(bb.get());
        pitLimiterStatus = DataTypeUtilities.convert_uint8(bb.get());
        fuelInTank = DataTypeUtilities.convert_float_vector(bb.getFloat());
        fuelCapacity = DataTypeUtilities.convert_float_vector(bb.getFloat());
        maxRPM = DataTypeUtilities.convert_uint16(bb.getShort());
        idleRPM = DataTypeUtilities.convert_uint16(bb.getShort());
        maxGears = DataTypeUtilities.convert_uint8(bb.get());
        drsAllowed = DataTypeUtilities.convert_uint8(bb.get());
        tyresWear = new short[4];
        tyresWear[0] = DataTypeUtilities.convert_uint8(bb.get());
        tyresWear[1] = DataTypeUtilities.convert_uint8(bb.get());
        tyresWear[2] = DataTypeUtilities.convert_uint8(bb.get());
        tyresWear[3] = DataTypeUtilities.convert_uint8(bb.get());
        tyreCompound = DataTypeUtilities.convert_uint8(bb.get());
        tyresDamage = new short[4];
        tyresDamage[0] = DataTypeUtilities.convert_uint8(bb.get());
        tyresDamage[1] = DataTypeUtilities.convert_uint8(bb.get());
        tyresDamage[2] = DataTypeUtilities.convert_uint8(bb.get());
        tyresDamage[3] = DataTypeUtilities.convert_uint8(bb.get());
        frontLeftWingDamage = DataTypeUtilities.convert_uint8(bb.get());
        frontRightWingDamage = DataTypeUtilities.convert_uint8(bb.get());
        rearWingDamage = DataTypeUtilities.convert_uint8(bb.get());
        engineDamage = DataTypeUtilities.convert_uint8(bb.get());
        gearBoxDamage = DataTypeUtilities.convert_uint8(bb.get());
        exhaustDamage = DataTypeUtilities.convert_uint8(bb.get());
        vehicleFiaFlags = DataTypeUtilities.convert_uint8(bb.get());
        ersStoreEnergy = DataTypeUtilities.convert_float_vector(bb.getFloat());
        ersDeployMode = DataTypeUtilities.convert_uint8(bb.get());
        ersHarvestedThisLapMGUK = DataTypeUtilities.convert_float_vector(bb.getFloat());
        ersHarvestedThisLapMGUH = DataTypeUtilities.convert_float_vector(bb.getFloat());
        ersDeployedThisLap = DataTypeUtilities.convert_float_vector(bb.getFloat());
    }
    
    public String getTractionControl(){
        switch(tractionControl){
            case 0: return "OFF";
            case 1: return "Medium";
            case 2: return "High";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getAntiLockBrakes(){
        switch(antiLockBrakes){
            case 0: return "OFF";
            case 1: return "ON";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getFuelMix(){
        switch(fuelMix){
            case 0: return "Lean";
            case 1: return "Standard";
            case 2: return "Rich";
            case 3: return "MAX";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getPitLimiter(){
        switch(pitLimiterStatus){
            case 0: return "OFF";
            case 1: return "ON";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getDRSAllowed(){
        switch(drsAllowed){
            case 0: return "NOT ALLOWED";
            case 1: return "ALLOWED";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getTyreCompound(){
        switch(tyreCompound){
            case 0: return "HYPER SOFT";
            case 1: return "ULTRA SOFT";
            case 2: return "SUPER SOFT";
            case 3: return "SOFT";
            case 4: return "MEDIUM";
            case 5: return "HARD";
            case 6: return "SUPER HARD";
            case 7: return "INTER";
            case 8: return "WET";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getVehicleFiaFlag(){
        switch(vehicleFiaFlags){
            case 0: return "NONE";
            case 1: return "GREEN";
            case 2: return "BLUE";
            case 3: return "YELLOW";
            case 4: return "RED";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getERSDeployMode(){
        switch(ersDeployMode){
            case 0: return "None";
            case 1: return "Low";
            case 2: return "Medium";
            case 3: return "High";
            case 4: return "Overtake";
            case 5: return "Hotlap";
            default: return "** UNKNOWN **";
        }
    }
    
    public String toString(){
        String ret = "Traction control: "+getTractionControl()+"\n";
        ret += "AntiLock Brakes: "+getAntiLockBrakes()+"\n";
        ret += "Fuel Mix: "+getFuelMix()+"\n";
        ret += "Front Brake Bias:"+frontBrakeBias+" %\n";
        ret += "Pit limiter: "+getPitLimiter()+"\n";
        ret += "Fuel in tank: "+fuelInTank+" Kg \n";
        ret += "Fuel capacity: "+fuelCapacity+" Kg \n";
        ret += "Max. rpm: "+maxRPM+" rpm\n";
        ret += "Idle rpm: "+idleRPM+" rpm\n";
        ret += "Max. gears: "+maxGears+"\n";
        ret += "DRS: "+getDRSAllowed()+"\n";
        
        ret += "Tyres %:\n";
        ret += " - ??: "+tyresWear[0]+"\n";
        ret += " - ??: "+tyresWear[1]+"\n";
        ret += " - ??: "+tyresWear[2]+"\n";
        ret += " - ??: "+tyresWear[3]+"\n";
        
        ret += "Tyres (Compound): "+getTyreCompound()+"\n";
        
        ret += "Tyres Damage (%):\n";
        ret += " - ??: "+tyresDamage[0]+" % \n";
        ret += " - ??: "+tyresDamage[1]+" % \n";
        ret += " - ??: "+tyresDamage[2]+" % \n";
        ret += " - ??: "+tyresDamage[3]+" % \n";
        
        ret += "Front Left Wing Damage: "+frontLeftWingDamage+" %\n";
        ret += "Front Right Wing Damage: "+frontRightWingDamage+" %\n";
        
        ret += "Rear Wing Damage: "+rearWingDamage+" %\n";
        ret += "Engine Damage: "+engineDamage+" %\n";
        ret += "Gear Box Damage: "+gearBoxDamage+" %\n";
        ret += "Exhaust Damage: "+exhaustDamage+" %\n";
        
        ret += "Vehicle Flag: "+getVehicleFiaFlag()+"\n";
        
        ret += "ERS Storage Energy: "+ersStoreEnergy+" Jules\n";
        
        ret += "ERS Deploy Mode: "+getERSDeployMode()+"\n";
        
        ret += "ERS Harvested This Lap MGU-K: "+ersHarvestedThisLapMGUK+"\n";
        ret += "ERS Harvested This Lap MGU-H: "+ersHarvestedThisLapMGUH+"\n";
        ret += "ERS Deployed This Lap: "+ersDeployedThisLap+"\n";
        return ret;
    }
}
