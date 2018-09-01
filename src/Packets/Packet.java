package Packets;

import classes.DataTypeUtilities;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Packet Structure (Header). Specific structures must herede from it.
 *
 * @author miguelangel.garciar
 * @author Codemasters
 * @see
 * https://forums.codemasters.com/discussion/136948/f1-2018-udp-specification
 */
public class Packet {

    ////////////////////////////////////////////////////////////////
    //                                                            //
    //                           HEADER                           //
    //                                                            //
    ////////////////////////////////////////////////////////////////
    // STATIC VALUES
    /**
     * Header Size (bytes).
     */
    public static int HEADER_SIZE = 21;
    /**
     * Packet Format F1 2018.
     */
    public static int PACKET_FORMAT = 2018;

    // STRUCTURE ATTRIBUTES
    /**
     * 2018.
     */
    public int packetFormat;
    /**
     * Version of this packet type, all start from 1.
     */
    public short packetVersion;
    /**
     * Identifier for the packet type: 0 - Motion 1 - Session 2 - Lap Data 3 -
     * Event 4 - Participants 5 - Car Setups 6 - Car Telemetry 7 - Car Status
     */
    public short packetId;
    /**
     * Unique identifier for the session.
     */
    public BigInteger sessionUID;
    /**
     * Session timestamp.
     */
    public float sessionTime;
    /**
     * Identifier for the frame the data was retrieved on.
     */
    public Long frameIdentifier;
    /**
     * Index of player's car in the array.
     */
    public short playerCarIndex;

    // PACKET TOTAL SIZE (BYTES)
    /**
     * PACKET TOTAL SIZE (BYTES).
     */
    public int lenght;

    /**
     * Packet Constructor (Only header values)
     *
     * @param content Byte content (may be only header or all datagram)
     */
    public Packet(byte[] content) {
        ByteBuffer bb = ByteBuffer.wrap(content);
        bb.order(ByteOrder.LITTLE_ENDIAN);

        packetFormat = DataTypeUtilities.convert_uint16(bb.getShort());
        packetVersion = DataTypeUtilities.convert_uint8(bb.get());
        packetId = DataTypeUtilities.convert_uint8(bb.get());
        sessionUID = DataTypeUtilities.convert_uint64(bb.getLong());
        sessionTime = bb.getFloat();
        frameIdentifier = DataTypeUtilities.convert_uint32(bb.getInt());
        playerCarIndex = DataTypeUtilities.convert_uint8(bb.get());
    }

    /**
     * String with data.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Format: " + packetFormat + "\n"
                + "Version: " + packetVersion + "\n"
                + "ID: " + packetId + "\n"
                + "Session UID: " + sessionUID + "\n"
                + "Session Time: " + sessionTime + "\n"
                + "Frame Identifier: " + frameIdentifier + "\n"
                + "Player Car Index: " + playerCarIndex + "\n";
    }
}
