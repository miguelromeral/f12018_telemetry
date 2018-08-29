package Packets;

import classes.DataTypeUtilities;
import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 *
 * @author miguelangel.garciar
 */
public class Packet {
    
    ////////////////////////////////////////////////////////////////
    //                                                            //
    //                           HEADER                           //
    //                                                            //
    ////////////////////////////////////////////////////////////////
    
    public static int HEADER_SIZE = 21; // Bytes
    
    // uint16 --> int (32)
    public int         packetFormat;       // 2018
    // uint8 --> short (16)
    public short       packetVersion;      // Version of this packet type, all start from 1
    // uint8 --> short (16)
    public short       packetId;           // Identifier for the packet type, see below
    // uint64
    public BigInteger  sessionUID;         // Unique identifier for the session
    // float (32)
    public float       sessionTime;        // Session timestamp
    // uint (32) --> Long (64)
    public Long frameIdentifier;           // Identifier for the frame the data was retrieved on
    // uint8 --> short (16)
    public short    playerCarIndex;        // Index of player's car in the array
    
    public byte[]  content;            // All packet content
    public int     lenght;
            
    public Packet(byte[] content){
        this.content = content;
        ByteBuffer bb = ByteBuffer.wrap(content);
        
        packetFormat = DataTypeUtilities.convert_uint16(bb.getShort());
        packetVersion = DataTypeUtilities.convert_uint8(bb.get());
        packetId = DataTypeUtilities.convert_uint8(bb.get());
        sessionUID = DataTypeUtilities.convert_uint64(bb.getLong());
        sessionTime = bb.getFloat();
        frameIdentifier = DataTypeUtilities.convert_uint32(bb.getInt());
        playerCarIndex = DataTypeUtilities.convert_uint8(bb.get());
    }
    
    public String toString(){
        return "Format: "+packetFormat+"\n"+
                "Version: "+packetVersion+"\n"+
                "ID: "+ packetId+"\n"+
                "Session UID: "+sessionUID+"\n"+
                "Session Time: "+sessionTime+"\n"+
                "Frame Identifier: "+frameIdentifier+"\n"+
                "Player Car Index: "+playerCarIndex+"\n";
    }
}
