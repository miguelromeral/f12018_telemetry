package gui;

import Packets.CarStatusData;
import Packets.CarTelemetryData;
import Packets.PacketSessionData;
import classes.Controller;
import classes.Driver;
import classes.Paso;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author miguelangel.garciar
 */
public class LiveTiming_Thread extends Thread{
    
    Controller controller;
    LiveTiming view;
    Paso paso;
    ArrayList<LiveTiming_Driver_Thread> threads;
    
    public LiveTiming_Thread(Controller controller, LiveTiming view){
        this.controller = controller;
        this.view = view;
        paso = new Paso();
        controller.addPaso(paso);
        threads = new ArrayList<>();
    }
    
    public void createThreads(){
        for(int i=0; i<20; i++){
            LiveTiming_Driver_Thread l = new LiveTiming_Driver_Thread(this, view.labels[i]);
            threads.add(l);
            l.start();
        }
    }
    
    public void killOtherThreads(){
        for(LiveTiming_Driver_Thread l : threads){
            l.delete();
            l.interrupt();
            l.stop();
        }
    }
    
    public void run(){
        createThreads();
        while (true)
        {
            paso.mirar();
            
            ArrayList<Driver> drivers = controller.session.getDrivers();
            
            if(!drivers.isEmpty()){
                
                //System.out.println(drivers.get(1));
                
                for(int i=0; i<drivers.size(); i++){
                    threads.get(i).setDriver(controller.session.getDriverByPosition(i + 1));
                }
            }
            
            paso.cerrar();
            
        }
    }
    
}
