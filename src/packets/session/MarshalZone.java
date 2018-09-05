package packets.session;

import classes.statics.DataTypeUtilities;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Marshal Zone structure.
 *
 * @author miguelangel.garciar
 * @author Codemasters
 * @see
 * https://forums.codemasters.com/discussion/136948/f1-2018-udp-specification
 */
public class MarshalZone {
    /**
     * Structure size in bytes.
     */
    public static int SIZE = 5;
    /**
     * Fraction (0..1) of way through the lap the marshal zone starts.
     */
    public float   zoneStart;
    /**
     * Zone flag.
     * -1 = invalid/unknown.
     * 0 = none.
     * 1 = green.
     * 2 = blue.
     * 3 = yellow.
     * 4 = red.
     */
    public short   zoneFlag;
    
    /**
     * Marshal Zone structure constructor.
     * @param content Byte content for marshal zone.
     */
    public MarshalZone (byte[] content){
        ByteBuffer bb = ByteBuffer.wrap(content);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        
        zoneStart = DataTypeUtilities.convert_float(bb.getFloat());
        zoneStart = DataTypeUtilities.convert_uint8(bb.get());
    }
    
    public String getZoneFlag(){
        switch(zoneFlag){
            case -1: return "INVALID";
            case 0: return "NONE";
            case 1: return "GREEN";
            case 2: return "BLUE";
            case 3: return "YELLOW";
            case 4: return "RED";
            default: return "** UNKNOWN **";
        }
    }
    
    /**
     * Get all data.
     * @return 
     */
    public String toString(){
        String ret = "Zone: "+zoneFlag+"\n";
        ret += "Flag: "+getZoneFlag()+"\n";
        return ret;
    }
}
