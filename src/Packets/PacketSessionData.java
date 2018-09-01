package Packets;

import static Packets.PacketEventData.LENGHT;
import classes.DataTypeUtilities;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Session Packet.
 * @author miguelangel.garciar
 * @author Codemasters
 * @see https://forums.codemasters.com/discussion/136948/f1-2018-udp-specification
 */
public class PacketSessionData extends Packet{
    
    ////////////////////////////////////////////////////////////////
    //                                                            //
    //                     SESSION PACKET                         //
    //                                                            //
    ////////////////////////////////////////////////////////////////
    
    // STATIC VALUES
    /** Packet Size in bytes (w/o header size). */
    public static int LENGHT = 126; // Bytes
    
    /** Weather. */
    public short    weather;
    /** Track temp in degrees celsius. */
    public short trackTemperature;
    /**
     * Air temp in degrees celsius.
     */
    public short airTemperature;
    /**
     * Total number of laps in this race.
     */
    public short totalLaps;
    /**
     * Track length in metres.
     */
    public int trackLength;
    /**
     * Session type.
     */
    public short sessionType;
    /**
     * Track ID.
     */
    public short trackId;
    /**
     * Era.
     */
    public short era;
    /**
     * Time left in session in seconds.
     */
    public int sessionTimeLeft;
    /**
     * Session duration in seconds.
     */
    public int sessionDuration;
    /** Pit speed limit in kilometres per hour. */
    public short    pitSpeedLimit;
    /** Whether the game is paused. */
    public short    gamePaused;
    /** Whether the player is spectating. */
    public short    isSpectating;
    /** Index of the car being spectated. */
    public short    spectatorCarIndex;
    /** SLI Pro support. */
    public short    sliProNativeSupport;
    /** Number of marshal zones to follow. */
    public short    numMarshalZones;
    /** List of marshal zones – max 21. */
    public ArrayList<MarshalZone> marshalZones = new ArrayList<>();
    /** Safety Car status. */
    public short    safetyCarStatus;
    /** Network game. */
    public short    networkGame;
    
    /**
     * Packet Session constructor.
     * @param content All datagrama content in bytes.
     */
    public PacketSessionData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;
        
        ByteBuffer bb = ByteBuffer.wrap(Arrays.copyOfRange(content, Packet.HEADER_SIZE, LENGHT));
        bb.order(ByteOrder.LITTLE_ENDIAN);
        
        weather = DataTypeUtilities.convert_uint8(bb.get());
        trackTemperature = DataTypeUtilities.convert_uint8(bb.get());
        airTemperature = DataTypeUtilities.convert_uint8(bb.get());
        totalLaps = DataTypeUtilities.convert_uint8(bb.get());
        trackLength = DataTypeUtilities.convert_uint16(bb.getShort());
        sessionType =DataTypeUtilities.convert_uint8(bb.get());
        trackId = DataTypeUtilities.convert_uint8(bb.get());         
        era = DataTypeUtilities.convert_uint8(bb.get());               
        sessionTimeLeft = DataTypeUtilities.convert_uint16(bb.getShort());   
        sessionDuration = DataTypeUtilities.convert_uint16(bb.getShort());   
        pitSpeedLimit = DataTypeUtilities.convert_uint8(bb.get());     
        gamePaused = DataTypeUtilities.convert_uint8(bb.get());        
        isSpectating = DataTypeUtilities.convert_uint8(bb.get());      
        spectatorCarIndex = DataTypeUtilities.convert_uint8(bb.get()); 
        sliProNativeSupport = DataTypeUtilities.convert_uint8(bb.get());
        numMarshalZones = DataTypeUtilities.convert_uint8(bb.get());

        int from = Packet.HEADER_SIZE + 19;
        int to = 0;
        int count = 0;
        while(count < 21){
            to = from + MarshalZone.SIZE;

            byte[] mzc = Arrays.copyOfRange(content, from, to);
            
            MarshalZone mz = new MarshalZone(mzc);
            marshalZones.add(mz);
            
            from += MarshalZone.SIZE;
            count ++;
        }

        safetyCarStatus = DataTypeUtilities.convert_uint8(bb.get());
        networkGame = DataTypeUtilities.convert_uint8(bb.get());
    }
    
    /**
     * Get weather based on <code>weather</code>.
     * @return 0 - Clear | 1 - Light Cloud | 2 - Overcast | 3 - Light Rain | 4 - Heavy Rain | 5 - Storm | default: ""
     * 
     */
    public String getWeather(){
        switch(weather){
            case 0: return "Clear";
            case 1: return "Light Cloud";
            case 2: return "Overcast";
            case 3: return "Light Rain";
            case 4: return "Heavy Rain";
            case 5: return "Storm";
            default: return "";
        }
    }
    
    /**
     * Name of the track based on <code>trackId</code>.
     * @return 0 - Melbourne | 1 - Paul Ricard | 2 - Shanghai | 3 - Sakhir | 4 - Catalunya | 
     *         5 - Monaco | 6 - Montreal | 7 - Silverstone | 8 - Hockenheim | 9 - Hungaroring | 
     *         10 - Spa | 11 - Monza | 12 - Singapore | 13 - Suzuka | 14 - Abu Dhabi | 
     *         15 - Texas | 16 - Brasil | 17 - Austria | 18 - Sochi | 19 - Mexico | 
     *         20 - Baku | 21 - Sakhir (short) | 22 - Silverstone (short) | 23 - Texas (short) | 24 - Suzuka (short) | 
     *         default: ""
     */
    public String getTrack(){
        switch(trackId){
            case 0: return "Melbourne";
            case 1: return "Paul Ricard";
            case 2: return "Shanghai";
            case 3: return "Sakhir";
            case 4: return "Catalunya";
            case 5: return "Monaco";
            case 6: return "Montreal";
            case 7: return "Silverstone";
            case 8: return "Hockenheim";
            case 9: return "Hungaroring";
            case 10: return "Spa";
            case 11: return "Monza";
            case 12: return "Singapore";
            case 13: return "Suzuka";
            case 14: return "Abu Dhabi";
            case 15: return "Texas";
            case 16: return "Brazil";
            case 17: return "Austria";
            case 18: return "Sochi";
            case 19: return "Mexico";
            case 20: return "Baku";
            case 21: return "Sakhir (short)";
            case 22: return "Silverstone (short)";
            case 23: return "Texas (short)";
            case 24: return "Suzuka (short)";
            default: return "";
        }
    }
    
    /**
     * Get Session Type based on <code>sessionType</code>.
     * @return 1 - FP1 | 2 - FP2 | 3 - FP3 | 4 - Practice | 5 - Q1 | 
     *         6 - Q2 | 7 - Q3 | 8 - Qualifying | 9 - OSQ | 10 - Race | 
     *         11 - R2 | 12 - Time Trial | default: ""
     */
    public String getSessionType(){
        switch(sessionType){
            case 1: return "FP1";
            case 2: return "FP2";
            case 3: return "FP3";
            case 4: return "Practice";
            case 5: return "Q1";
            case 6: return "Q2";
            case 7: return "Q3";
            case 8: return "Qualifying";
            case 9: return "OSQ";
            case 10: return "Race";
            case 11: return "R2";
            case 12: return "Time Trial";
            default: return "";
        }
    }
    
    /**
     * Get era based on <code>era</code>.
     * @return 0 - Modern | 1 - Classic | default: ""
     */
    public String getEra(){
        switch(era){
            case 0: return "Modern";
            case 1: return "Classic";
            default: return "";
        }
    }
    
    /**
     * Get formatted session time left.
     * @return 
     */
    public String getSessionTimeLeft(){
        Date date = new Date((long)(sessionTimeLeft*1000));
        return new SimpleDateFormat("H:mm:ss").format(date);
    }
    
    /**
     * Get formatted session duration.
     * @return 
     */
    public String getSessionDuration(){
        Date date = new Date((long)(sessionDuration*1000));
        return new SimpleDateFormat("H:mm:ss").format(date);
    }
    
    /**
     * Get if user is spectating
     * @return 0 - No | 1 - Yes
     */
    public String getIsSpectating(){
        if(isSpectating == 1){
            return "Yes";
        }else{
            return "No";
        }
    }
    
    /**
     * Get if user has SLI Pro Native support.
     * @return 0 - No | 1 - Yes
     */
    public String getSliProNativeSupport(){
        if(sliProNativeSupport == 1){
            return "YES";
        }else{
            return "NO";
        }
    }
    
    /**
     * Get Safety Car status based on <code>safetyCarStatus</code>.
     * @return 0 - No SC | 1 - SC | 2 - VSC | default: ""
     */
    public String getSafetyCarStatus(){
        switch(safetyCarStatus){
            case 0: return "NO SC";
            case 1: return "SAFETY CAR";
            case 2: return "VIRTUAL SC";
            default: return "";
        }
    }
    
    /**
     * Get network game.
     * @return 0 - Offline | 1 - Online | default: ""
     */
    public String getNetworkGame(){
        switch(networkGame){
            case 0: return "Offline";
            case 1: return "Online";
            default: return "";
        }
    }
    
    /**
     * Check if is night race circuit.
     * @return 
     */
    public boolean isNightRace(){
        switch(trackId){
            case 3: case 12: case 14: return true;
            default: return false;
        }
    }
    
    /**
     * Get all data.
     * @return 
     */
    @Override
    public String toString(){
        String ret = super.toString();
       
        ret += "Weather: "+getWeather()+"\n";
        ret += "Track Temperature: "+trackTemperature+" ºC\n";
        ret += "Air Temperature: "+airTemperature+" ºC\n";
        ret += "Total laps: "+totalLaps+" laps\n";
        ret += "Track Length: "+trackLength+" m\n";
        ret += "Session Type: "+getSessionType()+"\n";
        ret += "Track: "+getTrack()+"\n";
        ret += "Era: "+getEra()+"\n";
        ret += "Session Time Left: "+getSessionTimeLeft()+"\n";
        ret += "Session Duration: "+getSessionDuration()+"\n";
        ret += "Pit Speed Limit: "+pitSpeedLimit+"\n";
        ret += "Game paused: "+gamePaused+"\n";
        ret += "Is spectating: "+getIsSpectating()+"\n";
        ret += "Spectator Car Index: "+  spectatorCarIndex+"\n";
        ret += "Sli Pro Native Support: "+ getSliProNativeSupport()+"\n";
        ret += "Marshal Zones: "+ numMarshalZones+"\n";
        
        for(MarshalZone mz : marshalZones){
            ret += "\n------------\n";
            ret += mz.toString();
        }
        
        ret += "Safete Car: "+getSafetyCarStatus()+"\n";
        ret += "Network: "+getNetworkGame()+"\n";
        
        return ret;
    }
    
}
