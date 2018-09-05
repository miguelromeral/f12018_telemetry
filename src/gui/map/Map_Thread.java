package gui.map;

import packets.carstatus.CarStatusData;
import packets.cartelemetry.CarTelemetryData;
import packets.lapdata.LapData;
import packets.session.PacketSessionData;
import classes.Controller;
import classes.Driver;
import classes.Paso;
import classes.Session;
import classes.statics.GUIFeatures;
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
public class Map_Thread extends Thread{
    
    Controller controller;
    Map view;
    Paso paso;
    ArrayList<Map_Driver_Thread> threads;
    
    public Map_Thread(Controller controller, Map view){
        this.controller = controller;
        this.view = view;
        paso = new Paso();
        controller.addPaso(paso);
        threads = new ArrayList<>();
    }
    
    public void createThreads(int numDrivers){
        for(int i=0; i<numDrivers; i++){
            Map_Driver_Thread l = new Map_Driver_Thread(this);
            threads.add(l);
            l.start();
        }
    }
    
    public void killOtherThreads(){
        try{
            for(Map_Driver_Thread l : threads){
                l.delete();
                threads.remove(l);
                
            }
        }catch(Exception e){
            
        }
    }
    
    public void run(){
        while (true)
        {
            paso.mirar();
            
            ArrayList<Driver> drivers = controller.session.getAllDrivers();
            PacketSessionData data = controller.session.data;
            
            if(drivers != null){
                if(threads.isEmpty()){
                    createThreads(20);
                }
                if(!drivers.isEmpty()){
                    for(int i=0; i<drivers.size(); i++){
                        threads.get(i).setDriver(drivers.get(i));
                    }
                }

            }
            if(data != null){
                GUIFeatures.setTrackImage(view.map, 680, 680, data.trackId);
                
            }
            
            
            paso.cerrar();
            
        }
    }
    
}
