package classes.statics;

import packets.lapdata.LapData;
import classes.Driver;
import classes.Session;
import com.sun.jmx.snmp.SnmpDataTypeEnums;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author miguelangel.garciar
 */
public abstract class DataTypeUtilities {
    
    public static byte[] reorder(byte[] source){
        int length = source.length;
        byte[] dest = new byte[length];
        for(int i=0; i<length; i--){
            dest[i] = source[length-1-i];
        }
        return dest;
    }
    
    public static short convert_uint16(short s){
        //s = reorder(s);
        //return (short) (s & 0xffff);
        return (short) (s & 0xffff);
    }
    
    // FUNCIONA BIEN
    public static short convert_uint8(byte b){
        return b;
    }
    
    public static BigInteger convert_uint64(long l){
        BigInteger b = BigInteger.valueOf(l);
        return b;
    }
    
    public static float convert_float(float f){
        return f;
    }
    
    public static float convert_float_normalised_vector(short f){
        return f / 32767.0f;
    }
    
    public static long convert_uint32(int i){
        return i;
    }
    
    
    public static float getDeltaBetween(Session session, int first, int second){
        Driver f = session.getDriverByPosition(first);
        Driver s = session.getDriverByPosition(second);
        
        if(f != null && s != null && f.lap != null && s.lap != null){
            int lapf = f.lap.currentLapNum;
            int laps = s.lap.currentLapNum;
            
            if(lapf == laps || lapf == laps + 1){
                
                if(s.lap.carPosition == 18){
                    System.out.println("1 - S1: "+f.lastS1+", S2: "+f.lastS2+", S3: "+f.lastS3+", Last: "+f.lap.lastLapTime+", Current: "+f.lap.currentLapTime);
                    System.out.println("20 - S1: "+s.lastS1+", S2: "+s.lastS2+", S3: "+s.lastS3+", Last: "+s.lap.lastLapTime+", Current: "+s.lap.currentLapTime);
                }
                
               float curDiff = f.lap.currentLapTime - s.lap.currentLapTime;
               
               if(curDiff >= 0f){
                   
                   if(s.lap.sector <= 2){
                       curDiff = curDiff + (s.lap.sector1Time - f.lap.sector1Time);
                   }
                   if(s.lap.sector == 2){
                       curDiff = curDiff + (s.lap.sector2Time - f.lap.sector2Time);
                   }
                   if (s.lap.carPosition == 18) {
                       System.out.println("Result: " + (curDiff));
                   }
                   return curDiff;
  
               }else{
                   
                   if (s.lap.carPosition == 18) {
                       System.out.println("* Result: " + (f.lap.lastLapTime - s.lap.currentLapTime + f.lap.currentLapTime));
                   }
                   return f.lap.lastLapTime - s.lap.currentLapTime + f.lap.currentLapTime;
                  
               }
               
              //  return s.lastS3 -  f.lastS3 + s.lastS2 - f.lastS2 + s.lastS1 - f.lastS1 + s.lap.lastLapTime - f.lap.lastLapTime;
                
                
            }else{
                return 5000f + (lapf - laps - 1);
            }
            
        }else{
            return Float.POSITIVE_INFINITY;
        }
    }
    
    public static String getFormattedDelta(float delta){
        if(delta > 5000f && delta < 5100f){
            return "+ "+(int)(delta - 5000f)+" LAPS";
        }else{
            if(Float.isInfinite(delta)){
                return "";
            }
            if(delta == 0){
                return "+/-";
            }
            int decimals = (int) (delta * 1000) % 1000;
            String pad = "";
            if(decimals < 10){
                pad = "00";
            }else if(decimals < 100){
                pad = "0";
            }
            
            return (int)(delta)+"."+pad+""+decimals;
        }
    }
    
    public static float getDeltaQualifying(Session session, int first, int second){
        Driver f = session.getDriverByPosition(first);
        Driver s = session.getDriverByPosition(second);
        
        if(f != null && s != null && f.lap != null && s.lap != null){
            if(s.lap.bestLapTime == 0f){
                return Float.NaN;
            }
            float dif = s.lap.bestLapTime - f.lap.bestLapTime;
            return dif;
        }
        return Float.NaN;
    }
    
    public static String getFormattedDeltaQualifying(float delta){
        if(Float.isNaN(delta)){
            return "";
        }
        if(delta == 0){
            return "+/-";
        }
        int decimals = (int) (delta * 1000) % 1000;
            String pad = "";
            if(decimals < 10){
                pad = "00";
            }else if(decimals < 100){
                pad = "0";
            }
            
            return (int)(delta)+"."+pad+""+decimals;
    }
}
