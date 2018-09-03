package classes;

import classes.Controller;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author miguelangel.garciar
 */
public class Receiver extends Thread{
    
    private boolean stop = false;
    private int port = 20777;
    private Controller controller;
    private static int MAX_BUFFER = 2048;
    
    
    
    public Receiver(int port, Controller controller){
        this.port = port;
        this.controller = controller;
    }
    
    public void run(){
        try{
            DatagramSocket dsocket = new DatagramSocket(port);
            byte[] buffer = new byte[MAX_BUFFER];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Now loop forever, waiting to receive packets and printing them.
            while (true) {
              // Wait to receive a datagram
              dsocket.receive(packet);
              // Send contents to Controller
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                    controller.newPacket(buffer);
                  }
              }).run();
              
              // Reset the length of the packet before reusing it.
              packet.setLength(buffer.length);
            }
        }catch(SocketException se){
            se.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
