package Packets;

import classes.DataTypeUtilities;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author miguelangel.garciar
 */
public class LapData {
    
    public static int SIZE = 41;
    
    public float       lastLapTime;           // Last lap time in seconds
    public float       currentLapTime;        // Current time around the lap in seconds
    public float       bestLapTime;           // Best lap time of the session in seconds
    public float       sector1Time;           // Sector 1 time in seconds
    public float       sector2Time;           // Sector 2 time in seconds
    public float       lapDistance;           // Distance vehicle is around current lap in metres – could
                                         // be negative if line hasn’t been crossed yet
    public float       totalDistance;         // Total distance travelled in session in metres – could
                                         // be negative if line hasn’t been crossed yet
    public float       safetyCarDelta;        // Delta in seconds for safety car
    public short       carPosition;           // Car race position
    public short       currentLapNum;         // Current lap number
    public short       pitStatus;             // 0 = none, 1 = pitting, 2 = in pit area
    public short       sector;                // 0 = sector1, 1 = sector2, 2 = sector3
    public short       currentLapInvalid;     // Current lap invalid - 0 = valid, 1 = invalid
    public short       penalties;             // Accumulated time penalties in seconds to be added
    public short       gridPosition;          // Grid position the vehicle started the race in
    public short       driverStatus;          // Status of driver - 0 = in garage, 1 = flying lap
                                         // 2 = in lap, 3 = out lap, 4 = on track
    public short       resultStatus;          // Result status - 0 = invalid, 1 = inactive, 2 = active
                                         // 3 = finished, 4 = disqualified, 5 = not classified
                                         // 6 = retired
    
    public LapData(byte[] content){
        ByteBuffer bb = ByteBuffer.wrap(content);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        
        lastLapTime = DataTypeUtilities.convert_float(bb.getFloat());
        currentLapTime= DataTypeUtilities.convert_float(bb.getFloat());  
        bestLapTime= DataTypeUtilities.convert_float(bb.getFloat());     
        sector1Time= DataTypeUtilities.convert_float(bb.getFloat());
        sector2Time= DataTypeUtilities.convert_float(bb.getFloat());      
        lapDistance= DataTypeUtilities.convert_float(bb.getFloat());      
        totalDistance= DataTypeUtilities.convert_float(bb.getFloat());    
        safetyCarDelta= DataTypeUtilities.convert_float(bb.getFloat());   
        
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
    
    public String formatSeconds(float seconds){
        Date date = new Date((long)(seconds*1000));
        return new SimpleDateFormat("mm:ss.SSS").format(date)+" / "+seconds;
    }
    
    public String getLastLapTime(){
       return formatSeconds(lastLapTime);
    }
    
    public String getCurrentLapTime(){
       return formatSeconds(currentLapTime);
    }
    
    public String toString(){
        String ret = "Last lap time: "+getLastLapTime()+"\n";
        ret += "Current lap time: "+getCurrentLapTime()+"\n";
        
        
        
        return ret;
    }
}
