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
 *
 * @author miguelangel.garciar
 */
public class PacketSessionData extends Packet{
    
    public static int LENGHT = 126; // Bytes
    
    public short    weather;              	// Weather - 0 = clear, 1 = light cloud, 2 = overcast
                                            	// 3 = light rain, 4 = heavy rain, 5 = storm
    public short    trackTemperature;    	// Track temp. in degrees celsius
    public short    airTemperature;      	// Air temp. in degrees celsius
    public short    totalLaps;           	// Total number of laps in this race
    public int      trackLength;           	// Track length in metres
    public short    sessionType;         	// 0 = unknown, 1 = P1, 2 = P2, 3 = P3, 4 = Short P
                                            	// 5 = Q1, 6 = Q2, 7 = Q3, 8 = Short Q, 9 = OSQ
                                            	// 10 = R, 11 = R2, 12 = Time Trial
    public short    trackId;         		// -1 for unknown, 0-21 for tracks, see appendix
    public short    era;                  	// Era, 0 = modern, 1 = classic
    public int      sessionTimeLeft;    	// Time left in session in seconds
    public int      sessionDuration;     	// Session duration in seconds
    public short    pitSpeedLimit;      	// Pit speed limit in kilometres per hour
    public short    gamePaused;               // Whether the game is paused
    public short    isSpectating;        	// Whether the player is spectating
    public short    spectatorCarIndex;  	// Index of the car being spectated
    public short    sliProNativeSupport;	// SLI Pro support, 0 = inactive, 1 = active
    public short    numMarshalZones;         	// Number of marshal zones to follow
    public ArrayList<MarshalZone> marshalZones = new ArrayList<>();         // List of marshal zones – max 21
    public short    safetyCarStatus;          // 0 = no safety car, 1 = full safety car
                                                // 2 = virtual safety car
    public short    networkGame;              // 0 = offline, 1 = online
    
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
    
    public String getWeather(){
        // Weather - 0 = clear, 1 = light cloud, 2 = overcast
                                            	// 3 = light rain, 4 = heavy rain, 5 = storm
        switch(weather){
            case 0: return "Clear";
            case 1: return "Light Cloud";
            case 2: return "Overcast";
            case 3: return "Light Rain";
            case 4: return "Heavy Rain";
            case 5: return "Storm";
            default: return "** UNKNOWN **";
        }
    }
    
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
            default: return "** UNKNOWN **";
        }
    }
    
    public String getSessionType(){
        switch(sessionType){
            case 0: return "UNKNOWN";
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
            default: return "** UNKNOWN **";
        }
    }
    
    public String getEra(){
        switch(era){
            case 0: return "Modern";
            case 1: return "Classic";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getSessionTimeLeft(){
        Date date = new Date((long)(sessionTimeLeft*1000));
        return new SimpleDateFormat("H:mm:ss").format(date);
    }
    
    public String getSessionDuration(){
        Date date = new Date((long)(sessionDuration*1000));
        return new SimpleDateFormat("H:mm:ss").format(date);
    }
    
    public String getIsSpectating(){
        if(isSpectating == 1){
            return "Yes";
        }else{
            return "No";
        }
    }
    
    public String getSliProNativeSupport(){
        if(sliProNativeSupport == 1){
            return "YES";
        }else{
            return "NO";
        }
    }
    
    public String getSafetyCarStatus(){
        switch(safetyCarStatus){
            case 0: return "No SC";
            case 1: return "SAFETY CAR";
            case 2: return "VIRTUAL SC";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getNetworkGame(){
        switch(networkGame){
            case 0: return "Offline";
            case 1: return "Online";
            default: return "** UNKNOWN **";
        }
    }
    
    public boolean isNightRace(){
        switch(trackId){
            case 3: case 12: case 14: return true;
            default: return false;
        }
    }
    
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
