package classes;

import Packets.Packet;
import Packets.PacketCarStatusData;
import Packets.PacketCarTelemetryData;
import Packets.PacketFactory;
import Packets.PacketParticipantsData;
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
    
    public synchronized void newPacket(byte[] content){
        Packet packet = PacketFactory.getPacket(content);
        
        if(packet != null){
            session.setUserIndex(packet.playerCarIndex);
            
            /*
            System.out.print("{");
            for(byte b : content){
                System.out.print(b+", ");
            }
            System.out.println("}");

            System.out.println("Length: "+packet.lenght+"\n---------------");
           
          */
            
            
            
            
            switch(packet.packetId){
            
                case 4:
                    //System.out.println(packet.toString());
                    session.setParticipantsData((PacketParticipantsData) packet);
                    break;
                case 6:
                    //System.out.println(packet.toString());
                    session.setOwnCarTelemetryData((PacketCarTelemetryData) packet);
                    break;
                case 7:
                    //System.out.println(packet.toString());
                    session.setOwnCarStatusData((PacketCarStatusData) packet);
                    break;
            }
            
            openAllPasos();
        }
    }
}