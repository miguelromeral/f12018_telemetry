package classes;

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
        return f / 32767.0f;
    }
    
    public static long convert_uint32(int i){
        return i;
    }
}
