package classes.statics;

import packets.lapdata.LapData;
import classes.Driver;
import classes.Session;
import com.sun.jmx.snmp.SnmpDataTypeEnums;
import java.awt.List;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author miguelangel.garciar
 */
public abstract class DataTypeUtilities {
    
    
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
            float distancef = f.lap.lapDistance;
            int laps = s.lap.currentLapNum;
            float distances = s.lap.lapDistance;
            
            
            if (lapf == laps || (lapf == laps + 1 && distancef < distances)){
            
                
                
                if(!f.miniSectors.isEmpty() && !s.miniSectors.isEmpty()){
                    
                    
                    // Last one of the seconds, is the slowest
                    int index = (int) distances / Driver.MINISECTOR_GAP;

                    // We get the CURRENT LAP of SECOND, is the last.
                    if(f.miniSectors.get(laps) == null || f.miniSectors.get(laps).get(index) == null){
                        return Float.POSITIVE_INFINITY;
                    }
                    
                    long timef = f.miniSectors.get(laps).get(index);
                    long times = s.miniSectors.get(laps).get(index);
                    

                    long diff = times - timef;

                    return (float) (diff / 1000f);
                    
                        
                } else {
                    return Float.POSITIVE_INFINITY;
                }
                
                
            }else{
                return 5000f + (lapf - laps);
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
            int decimals = (int) Math.abs(delta * 1000) % 1000;
            String pad = "";
            if(decimals == 0){
                return (int) delta + ".000";
            }
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
    
    public static String printFormattedFloat(float f){
        char sign = ' ';
        if(f < 0f){
            sign = '-';
        }
        int uds = Math.abs((int) f);
        int decimals = (int) Math.abs((f * 1000) % 1000);
        if(decimals == 0){
            return sign+""+uds+".00";
        }
        if(decimals < 10){
            return sign+""+uds+".0"+decimals;
        }
        return sign+""+uds+"."+decimals;
    }
}
