package Packets;

import static Packets.PacketEventData.LENGHT;
import classes.DataTypeUtilities;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 *
 * @author miguelangel.garciar
 */
public class ParticipantData extends Packet {
    
    public static int SIZE = 53;
    
    public short      aiControlled;           // Whether the vehicle is AI (1) or Human (0) controlled
    public short      driverId;               // Driver id - see appendix
    public short      teamId;                 // Team id - see appendix
    public short      raceNumber;             // Race number of the car
    public short      nationality;            // Nationality of the driver
    public String              name;              // Name of participant in UTF-8 format – null terminated
                                         // Will be truncated with … (U+2026) if too long
    
    public ParticipantData(byte[] content){
        super(Arrays.copyOfRange(content, 0, Packet.HEADER_SIZE));
        super.lenght = LENGHT;
        
        ByteBuffer bb = ByteBuffer.wrap(content);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        
        aiControlled = DataTypeUtilities.convert_uint8(bb.get());
        driverId = DataTypeUtilities.convert_uint8(bb.get());
        teamId = DataTypeUtilities.convert_uint8(bb.get());
        raceNumber = DataTypeUtilities.convert_uint8(bb.get());
        nationality = DataTypeUtilities.convert_uint8(bb.get());
        try{
            name = new String(Arrays.copyOfRange(content, 5, 53), "UTF-8");
        }catch(Exception e){
            name = "** INVALID **";
        }
        
    }
    
    public String getAIControlled(){
        switch(aiControlled){
            case 0: return "Human";
            case 1: return "IA";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getDriver(){
        switch(driverId){
            case 0: return "Carlos SAINZ";
            case 2: return "Daniel RICCIARDO";
            case 3: return "Fernando ALONSO";
            case 6: return "Kimi RÄIKKÖNEN";
            case 7: return "Lewis HAMILTON";
            case 8: return "Marcus ERICSSON";
            case 9: return "Max VERSTAPPEN";
            case 10: return "Nico HULKENBERG";
            case 11: return "Kevin MAGNUSSEN";
            case 12: return "Romain GROSJEAN";
            case 13: return "Sebastian VETTEL";
            case 14: return "Sergio PÉREZ";
            case 15: return "Valtteri BOTTAS";
            case 17: return "Esteban OCON";
            case 18: return "Stoffel VANDOORNE";
            case 19: return "Lance STROLL";
            case 20: return "Arron BARNES";
            case 21: return "Martin Giles";
            case 22: return "Alex MURRAY";
            case 23: return "Lucas ROTH";
            case 24: return "Igor CORREIA";
            case 25: return "Sophie LEVASSEUR";
            case 26: return "Jonas SCHIFFER";
            case 27: return "Alain FOREST";
            case 28: return "Jay LETOURNEAU";
            case 29: return "Esto SAARI";
            case 30: return "Yasar ATIYEH";
            case 31: return "Callisto CALABRESI";
            case 32: return "Naota IZUM";
            case 33: return "Howard CLARKE";
            case 34: return "Wilheim KAUFMANN";
            case 35: return "Marie LAURSEN";
            case 36: return "Flavio NIEVES";
            case 58: return "Charles LECLERC";
            case 59: return "Pierre GASLY";
            case 60: return "Brendon HARTLEY";
            case 61: return "Segey SIROTKIN";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getTeam(){
        switch(teamId){
            case 0: return "Mercedes";
            case 1: return "Ferrari";
            case 2: return "RedBull";
            case 3: return "Williams";
            case 4: return "Force India";
            case 5: return "Renault";
            case 6: return "Toro Rosso";
            case 7: return "Haas";
            case 8: return "McLaren";
            case 9: return "Sauber";
            case 10: return "McLaren '88";
            case 11: return "McLaren '91";
            case 12: return "Williams '92";
            case 13: return "Ferrari '95";
            case 14: return "Williams '96";
            case 15: return "McLaren '98";
            case 16: return "Ferrari 2002";
            case 17: return "Ferarri 2004";
            case 18: return "Renault 2006";
            case 19: return "Ferrari 2007";
            case 20: return "McLaren 2008";
            case 21: return "RedBull 2010";
            case 22: return "Ferarri '76";
            case 34: return "McLaren '76";
            case 35: return "Lotus '72";
            case 36: return "Ferrari '79";
            case 37: return "McLaren '82";
            case 38: return "Williams 2003";
            case 39: return "Brawn GP 2009";
            case 40: return "Lotus '78";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getNationality(){
        switch(nationality){
            case 1: return "USA";
            case 2: return "ARG";
            case 3: return "AUS";
            case 4: return "AUT";
            case 5: return "AZE";
            case 6: return "BAH";
            case 7: return "BEL";
            case 8: return "BOL";
            case 9: return "BRA";
            case 10: return "GBR";
            case 11: return "BUL";
            case 12: return "CAM";
            case 13: return "CAN";
            case 14: return "CHL";
            case 15: return "CHN";
            case 16: return "COL";
            case 17: return "CRI";
            case 18: return "CRO";
            case 19: return "CYP";
            case 20: return "CZE";
            case 21: return "DEN";
            case 22: return "NED";
            case 23: return "ECU";
            case 24: return "ENG";
            case 25: return "EMI";
            case 26: return "EST";
            case 27: return "FIN";
            case 28: return "FRA";
            case 29: return "GER";
            case 30: return "GHA";
            case 31: return "GRE";
            case 32: return "GUA";
            case 33: return "HON";
            case 34: return "HKO";
            case 35: return "HUN";
            case 36: return "ICS";
            case 37: return "IND";
            case 38: return "IDN";
            case 39: return "IRL";
            case 40: return "ISR";
            case 41: return "ITA";
            case 42: return "JAM";
            case 43: return "JAP";
            case 44: return "JOR";
            case 45: return "KUW";
            case 46: return "LAT";
            case 47: return "LEB";
            case 48: return "LIT";
            case 49: return "LUX";
            case 50: return "MLS";
            case 51: return "MAL";
            case 52: return "MEX";
            case 53: return "MON";
            case 54: return "NZE";
            case 55: return "NIC";
            case 56: return "NKR";
            case 57: return "NIR";
            case 58: return "NOR";
            case 59: return "OMA";
            case 60: return "PAK";
            case 61: return "PAN";
            case 62: return "PAR";
            case 63: return "PER";
            case 64: return "POL";
            case 65: return "POR";
            case 66: return "QAT";
            case 67: return "ROM";
            case 68: return "RUS";
            case 69: return "SAL";
            case 70: return "SAU";
            case 71: return "SCO";
            case 72: return "SER";
            case 73: return "SIN";
            case 74: return "SLK";
            case 75: return "SLN";
            case 76: return "SKR";
            case 77: return "SAF";
            case 78: return "ESP";
            case 79: return "SWE";
            case 80: return "SWI";
            case 81: return "TAI";
            case 82: return "THA";
            case 83: return "TUR";
            case 84: return "URU";
            case 85: return "UKR";
            case 86: return "VEN";
            case 87: return "WEL";
            default: return "** UNKNOWN **";
        }
    }
    
    public String getName(){
        return name.toString();
    }
    
    public String toString(){
        String ret = "Controlled by: "+getAIControlled()+"\n";
        ret += "Driver: "+getDriver()+"\n";
        ret += "Team: "+getTeam()+"\n";
        ret += "Race Number: "+raceNumber+"\n";
        ret += "Nationality: "+getNationality()+"\n";
        ret += "Name: "+getName()+"\n";
        return ret;
    }
}
