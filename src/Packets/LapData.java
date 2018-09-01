package Packets;

import classes.DataTypeUtilities;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Lap Data structure
 *
 * @author miguelangel.garciar
 * @author Codemasters
 * @see
 * https://forums.codemasters.com/discussion/136948/f1-2018-udp-specification
 */
public class LapData {
    /**
     * Lap Data strcture size (in bytes).
     */
    public static int SIZE = 41;
    /**
     * Last lap time in seconds.
     */
    public float       lastLapTime;
    /**
     * Current time around the lap in seconds.
     */
    public float       currentLapTime;
    /**
     * Best lap time of the session in seconds.
     */
    public float       bestLapTime;
    /**
     * Sector 1 time in seconds.
     */
    public float       sector1Time;
    /**
     * Sector 2 time in seconds.
     */
    public float       sector2Time;
    /**
     * Distance vehicle is around current lap in metres – could be negative if line hasn’t been crossed yet.
     */
    public float       lapDistance;
    /**
     * Total distance travelled in session in metres – could be negative if line hasn’t been crossed yet.
     */
    public float       totalDistance;
    /**
     * Delta in seconds for safety car.
     */
    public float       safetyCarDelta;
    /**
     * Car race position.
     */
    public short       carPosition;
    /**
     * Current lap number.
     */
    public short       currentLapNum;
    /**
     * 0 = none.
     * 1 = pitting.
     * 2 = in pit area.
     */
    public short       pitStatus;
    /**
     * 0 = sector1.
     * 1 = sector2.
     * 2 = sector3.
     */
    public short       sector;
    /**
     * Current lap invalid.
     * 0 = valid.
     * 1 = invalid.
     */
    public short       currentLapInvalid;
    /**
     * Accumulated time penalties in seconds to be added.
     */
    public short       penalties;
    /**
     * Grid position the vehicle started the race in.
     */
    public short       gridPosition;
    /**
     * Status of driver.
     * 0 = in garage.
     * 1 = flying lap
     * 2 = in lap.
     * 3 = out lap.
     * 4 = on track.
     */
    public short       driverStatus;
    /**
     * Result status.
     * 0 = invalid.
     * 1 = inactive.
     * 2 = active.
     * 3 = finished.
     * 4 = disqualified.
     * 5 = not classified.
     * 6 = retired.
     */
    public short       resultStatus;
    
    /**
     * Lap Data constructor
     * @param content byte content for only the lap data.
     */
    public LapData(byte[] content){
        ByteBuffer bb = ByteBuffer.wrap(content);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        
        lastLapTime = DataTypeUtilities.convert_float_normal(bb.getFloat());
        currentLapTime= DataTypeUtilities.convert_float_normal(bb.getFloat());  
        bestLapTime= DataTypeUtilities.convert_float_normal(bb.getFloat());     
        sector1Time= DataTypeUtilities.convert_float_normal(bb.getFloat());
        sector2Time= DataTypeUtilities.convert_float_normal(bb.getFloat());      
        lapDistance= DataTypeUtilities.convert_float_normal(bb.getFloat());      
        totalDistance= DataTypeUtilities.convert_float_normal(bb.getFloat());    
        safetyCarDelta= DataTypeUtilities.convert_float_normal(bb.getFloat());   
        
        carPosition= DataTypeUtilities.convert_uint8(bb.get());      
        currentLapNum= DataTypeUtilities.convert_uint8(bb.get());          
        pitStatus= DataTypeUtilities.convert_uint8(bb.get());              
        sector= DataTypeUtilities.convert_uint8(bb.get());                 
        currentLapInvalid= DataTypeUtilities.convert_uint8(bb.get());      
        penalties= DataTypeUtilities.convert_uint8(bb.get());         
        gridPosition= DataTypeUtilities.convert_uint8(bb.get());      
        driverStatus= DataTypeUtilities.convert_uint8(bb.get());      
        resultStatus= DataTypeUtilities.convert_uint8(bb.get());      
    }
    
    /**
     * Print seconds formatted.
     * @param seconds float seconds.
     * @param large large format (with .000) or not (0.).
     * @return 
     */
    public static String formatSeconds(float seconds, boolean large){
        if(seconds <= 0 || seconds == Float.POSITIVE_INFINITY){
            return "";
        }
        if(large){  
            Date date = new Date((long)(seconds * 1000));
            return new SimpleDateFormat("m:ss.SSS").format(date);
        }
        if(seconds >= 60){
            return ((int)(seconds / 60))+((int) seconds)+"."+(int) ((seconds * 10) % 10); 
        }
        return ((int) seconds)+"."+(int) ((seconds * 10) % 10); 
    }
    
    public String getLastLapTime(boolean large){
       return formatSeconds(lastLapTime, large);
    }
    
    public String getCurrentLapTime(boolean large){
       return formatSeconds(currentLapTime, large);
    }
    
    public String getBestLapTime(boolean large){
        return formatSeconds(bestLapTime, large);
    }
    
    /**
     * Get this lap Sector 1.
     * @param large format to print.
     * @return 
     */
    public String getSector1Time(boolean large){
        if(getSector() == 1){
            float sector1 = currentLapTime;
            return formatSeconds(sector1, large);
        }else if(getSector() > 1){
            return formatSeconds(this.sector1Time, large);
        }else{
            return null;
        }
    }
    
    /**
     * Get this lap Sector 2.
     * @param large format to print.
     * @return 
     */
    public String getSector2Time(boolean large){
        if(getSector() == 2){
            float sector2 = currentLapTime - sector1Time;
            return formatSeconds(sector2, large);
        }else if(getSector() > 2){
            return formatSeconds(this.sector2Time, large);
        }else{
            return null;
        }
    }
    
    /**
     * Get this lap Sector 3.
     * @param large format to print.
     * @return 
     */
    public String getSector3Time(boolean large){
        if(getSector() == 3){
            float sector3 = currentLapTime - sector1Time - sector2Time;
            return formatSeconds(sector3, large);
        }else{
            return null;
        }
    }
    
    /**
     * Get this lap Sector 3 in float type.
     * @return 
     */
    public float getSector3Float(){
        if(sector == 2){
            return currentLapTime - sector1Time - sector2Time;
        }else{
            return 0f;
        }
    }
    
    public String getPitStatus(){
        switch(pitStatus){
            case 0: return "";
            case 1: return "IN";
            case 2: return "BOX";
            default: return "** UNK **";
        }
    }
    
    /**
     * Get human readable sector.
     * @return 
     */
    public int getSector(){
        return sector + 1;
    }
    
    /**
     * Check if the lap is invalid.
     * @return 
     */
    public boolean getCurrentLapInvalid(){
        return currentLapInvalid == 1;
    }
    
    public String getDriverStatus(){
        switch(driverStatus){
            case 0: return "GARAGE";
            case 1: return "FLYING LAP";
            case 2: return "IN LAP";
            case 3: return "OUT LAP";
            case 4: return "ON TRACK";
            default: return "";
        }
    }
    
    /**
     * Get human readable acronim result status (based on <code>driverStatus</code>).
     * @return  0 = invalid.
     *          1 = inactive.
     *          2 = active.
     *          3 = finished.
     *          4 = disqualified.
     *          5 = not classified.
     *          6 = retired.
     */
    public String getResultStatus(){
        switch(driverStatus){
            case 0: return "INV";
            case 1: return "INA";
            case 2: return "ACT";
            case 3: return "FIN";
            case 4: return "DSQ";
            case 5: return "DNC";
            case 6: return "DNF";
            default: return "";
        }
    }
    
    /**
     * Get all data.
     * @return 
     */
    @Override
    public String toString(){
        String ret = "Last lap time: "+getLastLapTime(true)+"\n";
        ret += "Current lap time: "+getCurrentLapTime(true)+"\n";
        ret += "Best lap time: "+getBestLapTime(true)+"\n";
        ret += "Sector 1 time: "+getSector1Time(true)+"\n";
        ret += "Sector 2 time: "+getSector2Time(true)+"\n";
        ret += "Lap distance: "+lapDistance+" m\n";
        ret += "Total distance: "+totalDistance+" m\n";
        ret += "SC Delta: "+safetyCarDelta+"\n";
        ret += "Car position: "+carPosition+"\n";
        ret += "Current Lap: "+currentLapNum+"\n";
        ret += "Pit status: "+getPitStatus() +"\n";
        ret += "Sector: "+getSector() +"\n";
        ret += "Current Lap Invalid: "+getCurrentLapInvalid()+"\n";
        ret += "Penalties: "+penalties+"\n";
        ret += "Grid Position: "+gridPosition+"\n";
        ret += "Driver Status: "+getDriverStatus()+"\n";
        ret += "Result Status: "+getResultStatus()+"\n";
        
        return ret;
    }
}
