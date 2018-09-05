package classes;

import packets.Packet;
import packets.carsetup.PacketCarSetupData;
import packets.carstatus.PacketCarStatusData;
import packets.cartelemetry.PacketCarTelemetryData;
import packets.event.PacketEventData;
import packets.PacketFactory;
import packets.lapdata.PacketLapData;
import packets.motion.PacketMotionData;
import packets.participants.PacketParticipantsData;
import packets.session.PacketSessionData;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author miguelangel.garciar
 */
public class Controller {
    
    public Receiver receiver;
    public ArrayList<Paso> pasos;
    public Session session;
    public AtomicInteger lastPacketID;
    
    public Controller(int port){
        pasos = new ArrayList<>();
        receiver = new Receiver(port, this);
        receiver.start();
        session = new Session();
    }
    
    private void openAllPasos(){
        for(Paso p : pasos){
            p.abrir();
        }
    }
    
    public void addPaso(Paso p){
        pasos.add(p);
    }
    
    public void removePaso(Paso p){
        pasos.remove(p);
    }
    
        int i = 0;
        
    public synchronized void newPacket(byte[] content){
        Packet packet = PacketFactory.getPacket(content);
        
        
        if(packet != null){
            session.setUserIndex(packet.playerCarIndex);
            
        /*   
            System.out.println("// ID: "+packet.packetId);
            System.out.print("byte[] cont"+i+" = {");
            for(byte b : content){
                System.out.print(b+", ");
            }
            System.out.println("};\ncontroller.newPacket(cont"+i+");");

            i++;
          */
         //   System.out.println("Packet: "+packet.frameIdentifier);
            
            switch(packet.packetId){
            
                case 0:
                    //System.out.println(packet.toString());
                    session.setMotionData((PacketMotionData) packet);
                    break;
                case 1:
                    //System.out.println(packet.toString());
                    session.setSessionData((PacketSessionData) packet);
                    break;
                case 2:
                    //System.out.println(packet.toString());
                    session.setLapData((PacketLapData) packet);
                    break;    
                case 3:
                    //System.out.println(packet.toString());
                    session.setEventAction((PacketEventData) packet);
                    break;
                case 4:
                    //System.out.println(packet.toString());
                    session.setParticipantsData((PacketParticipantsData) packet);
                    break;
                case 5:
                    //System.out.println(packet.toString());
                    session.setCarSetupData((PacketCarSetupData) packet);
                    break;
                case 6:
                    //System.out.println(packet.toString());
                    session.setCarTelemetryData((PacketCarTelemetryData) packet);
                    break;
                case 7:
                    //System.out.println(packet.toString());
                    session.setCarStatusData((PacketCarStatusData) packet);
                    break;
            }
            
            openAllPasos();
        }
    }
}
