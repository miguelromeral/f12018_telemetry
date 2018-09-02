package gui;

import Packets.CarStatusData;
import Packets.CarTelemetryData;
import Packets.LapData;
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
    
    public void createThreads(int numDrivers){
        for(int i=0; i<numDrivers; i++){
            LiveTiming_Driver_Thread l = new LiveTiming_Driver_Thread(this, view.labels[i]);
            threads.add(l);
            l.start();
        }
    }
    
    public void killOtherThreads(){
        try{
            for(LiveTiming_Driver_Thread l : threads){
                l.delete();
                l.interrupt();
                l.stop();
                threads.remove(l);
            }
        }catch(Exception e){
            
        }
    }
    
    public void run(){
        while (true)
        {
            paso.mirar();
            
            ArrayList<Driver> drivers = controller.session.getDrivers();
            
            if(drivers != null){
                
                if(!drivers.isEmpty()){

                    
                    if(drivers.size() != threads.size()){
                        killOtherThreads();
                        createThreads(drivers.size());
                    }else{
                        if(threads.isEmpty()){
                            createThreads(drivers.size());
                        }
                    }
                    
                    for(int i=0; i<drivers.size(); i++){
                        threads.get(i).setDriver(controller.session.getDriverByPosition(i + 1));
                    }
                }

                view.lab_bestS1.setText(LapData.formatSeconds(controller.session.bestS1, true));
                view.lab_bestS2.setText(LapData.formatSeconds(controller.session.bestS2, true));
                view.lab_bestS3.setText(LapData.formatSeconds(controller.session.bestS3, true));
                view.lab_bestTotal.setText(LapData.formatSeconds(controller.session.bestS1 + controller.session.bestS2 + controller.session.bestS3, true));

               /* System.out.print("S1 "+controller.session.bestS1+" | ");
                System.out.print("S2 "+controller.session.bestS2+" | ");
                System.out.print("S3 "+controller.session.bestS3+" | ");
                System.out.println("Total "+(controller.session.bestS1 + controller.session.bestS2 + controller.session.bestS3));*/
            }else{
                killOtherThreads();
            }
            
            
            PacketSessionData data = controller.session.data;
            
            if(data != null){
                // Weather Info
                GUIFeatures.setWeatherImage(view.lab_weather, view.lab_weather.getWidth(), data.weather, data.trackId, data.isNightRace());
                view.lab_weather_text.setText(data.getWeather());
                
                view.lab_trackTemperature.setText(data.trackTemperature+" ºC");
                view.lab_airTemperature.setText(data.airTemperature+" ºC");
                
                switch(data.sessionType){
                    case 10: case 11: view.lab_remaining.setText("Laps: "+data.totalLaps);
                        break;
                    default: view.lab_remaining.setText("");
                }
            }
            
            paso.cerrar();
            
        }
    }
    
}
