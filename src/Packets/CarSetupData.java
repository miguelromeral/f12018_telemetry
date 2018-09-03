package Packets;

import classes.DataTypeUtilities;
import com.sun.prism.PixelFormat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author miguelangel.garciar
 */
public class CarSetupData {
    /**
     * Lap Data strcture size (in bytes).
     */
    public static int SIZE = 41;
    /**
     * Front wing aero.
     */
    short frontWing;
    /**
     * Rear wing aero.
     */
    short rearWing;
    /**
     * Differential adjustment on throttle (percentage).
     */
    short onThrottle;
    /**
     * Differential adjustment off throttle (percentage).
     */
    short offThrottle;
    /**
     * Front camber angle (suspension geometry).
     */
    float frontCamber;
    /**
     * Rear camber angle (suspension geometry).
     */
    float rearCamber;
    /**
     * Front toe angle (suspension geometry).
     */
    float frontToe;
    /**
     * Rear toe angle (suspension geometry).
     */
    float rearToe;
    /**
     * Front suspension.
     */
    short frontSuspension;
    /**
     * Rear suspension.
     */
    short rearSuspension;
    /**
     * Front anti-roll bar.
     */
    short frontAntiRollBar;
    /**
     * Front anti-roll bar.
     */
    short rearAntiRollBar;
    /**
     * Front ride height.
     */
    short frontSuspensionHeight;
    /**
     * Rear ride height.
     */
    short rearSuspensionHeight;
    /**
     * Brake pressure (percentage).
     */
    short brakePressure;
    /**
     * Brake bias (percentage).
     */
    short brakeBias;
    /**
     * Front tyre pressure (PSI).
     */
    float frontTyrePressure;
    /**
     * Rear tyre pressure (PSI).
     */
    float rearTyrePressure;
    /**
     * Ballast.
     */
    short ballast;
    /**
     * Fuel load.
     */
    float fuelLoad;


    
    /**
     * Car Setup Data structure constructor.
     * @param content All byte content for the car.
     */
    public CarSetupData(byte[] content){
        ByteBuffer bb = ByteBuffer.wrap(content);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        
        frontWing = DataTypeUtilities.convert_uint8(bb.get());
        rearWing = DataTypeUtilities.convert_uint8(bb.get());
        onThrottle = DataTypeUtilities.convert_uint8(bb.get());
        offThrottle = DataTypeUtilities.convert_uint8(bb.get());

        frontCamber = DataTypeUtilities.convert_float(bb.getFloat());
        rearCamber = DataTypeUtilities.convert_float(bb.getFloat());
        frontToe = DataTypeUtilities.convert_float(bb.getFloat());
        rearToe = DataTypeUtilities.convert_float(bb.getFloat());

        frontSuspension = DataTypeUtilities.convert_uint8(bb.get());
        rearSuspension = DataTypeUtilities.convert_uint8(bb.get());
        frontAntiRollBar = DataTypeUtilities.convert_uint8(bb.get());
        rearAntiRollBar = DataTypeUtilities.convert_uint8(bb.get());
        frontSuspensionHeight = DataTypeUtilities.convert_uint8(bb.get());
        rearSuspensionHeight = DataTypeUtilities.convert_uint8(bb.get());
        brakePressure = DataTypeUtilities.convert_uint8(bb.get());
        brakeBias = DataTypeUtilities.convert_uint8(bb.get());

        frontTyrePressure = DataTypeUtilities.convert_float(bb.getFloat());
        rearTyrePressure = DataTypeUtilities.convert_float(bb.getFloat());

        ballast = DataTypeUtilities.convert_uint8(bb.get());

        fuelLoad = DataTypeUtilities.convert_float(bb.getFloat());
    }
    
    /**
     * Get all data.
     * @return 
     */
    @Override
    public String toString(){
        String ret = "Front Wing: "+frontWing+"\n";
        ret += "Rear Wing: "+rearWing+"\n";
        ret += "On throttle: "+onThrottle+"\n";
        ret += "Off throttle: "+offThrottle+"\n";
        ret += "Front camber: "+frontCamber+"\n";
        ret += "Rear camber: "+rearCamber+"\n";
        ret += "Front toe: "+frontToe+"\n";
        ret += "Rear toe: "+rearToe+"\n";
        ret += "Front suspension: "+frontSuspension+"\n";
        ret += "Rear suspension: "+rearSuspension+"\n";
        ret += "Front antirollbar: "+frontAntiRollBar+"\n";
        ret += "Rear antirollbar: "+rearAntiRollBar+"\n";
        ret += "Front suspension height: "+frontSuspensionHeight+"\n";
        ret += "Rear suspension height: "+rearSuspensionHeight+"\n";
        ret += "Brake pressure: "+brakePressure+"\n";
        ret += "Brake bias: "+brakeBias+"\n";
        ret += "Front tyre pressure: "+frontTyrePressure+"\n";
        ret += "Rear tyre pressure: "+rearTyrePressure+"\n";
        ret += "Ballast: "+ballast+"\n";
        ret += "Fuel load: "+fuelLoad+"\n";
        return ret;
    }
}
