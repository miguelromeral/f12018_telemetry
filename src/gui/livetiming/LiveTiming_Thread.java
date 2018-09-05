package gui.livetiming;

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
           /*     l.interrupt();
                l.stop();*/
                threads.remove(l);
                
            }
        }catch(Exception e){
            
        }
    }
    
    public String getOptionData(){
        return (String) view.combo_data.getSelectedItem();
    }
    
    private void printBestSectors(){
        view.lab_bestS1.setText(LapData.formatSeconds(controller.session.bestS1, true));
        view.lab_bestS2.setText(LapData.formatSeconds(controller.session.bestS2, true));
        view.lab_bestS3.setText(LapData.formatSeconds(controller.session.bestS3, true));
        view.lab_bestTotal.setText(LapData.formatSeconds(controller.session.bestS1 + controller.session.bestS2 + controller.session.bestS3, true));

       /* System.out.print("S1 "+controller.session.bestS1+" | ");
        System.out.print("S2 "+controller.session.bestS2+" | ");
        System.out.print("S3 "+controller.session.bestS3+" | ");
        System.out.println("Total "+(controller.session.bestS1 + controller.session.bestS2 + controller.session.bestS3));*/
    }
    
    private void printRaceStatus(PacketSessionData data){
        if(data.sessionType > 0 && data.sessionType < 9){
            view.lab_remaining.setText(data.getSessionType()+": "+data.getSessionTimeLeft());
        }else if(data.sessionType == 10 || data.sessionType == 11){
            view.lab_remaining.setText("Laps: "+data.totalLaps);
        }else{
            view.lab_remaining.setText("");
        }
    }
    
    private void printWeather(PacketSessionData data){
        // Weather Info
        GUIFeatures.setWeatherImage(view.lab_weather, view.lab_weather.getWidth(), data.weather, data.trackId, data.isNightRace());
        view.lab_weather_text.setText(data.getWeather());

        view.lab_trackTemperature.setText(data.trackTemperature+" ºC");
        view.lab_airTemperature.setText(data.airTemperature+" ºC");
    }
    
    public void run(){
        while (true)
        {
            paso.mirar();
            
            ArrayList<Driver> drivers = controller.session.getAllDrivers();
            
            if(drivers != null){
                if(threads.isEmpty()){
                    createThreads(20);
                }
                
             //   System.out.println("Drivers: "+drivers.size()+", Threads: "+threads.size());
                
                if(!drivers.isEmpty()){
                    for(int i=0; i<threads.size(); i++){
                        threads.get(i).setDriver(controller.session.getDriverByPosition(i + 1));
                    }
                }

            }
            
            PacketSessionData data = controller.session.data;
            
            if(data != null){
                printWeather(data);
                printRaceStatus(data);
            }
            
            printBestSectors();
            
            paso.cerrar();
            
        }
    }
    
}
