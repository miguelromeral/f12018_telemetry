package gui;

import Packets.CarStatusData;
import Packets.CarTelemetryData;
import Packets.PacketSessionData;
import classes.Controller;
import classes.Paso;
import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.SwingUtilities;

/**
 *
 * @author miguelangel.garciar
 */
public class SessionData_Thread extends Thread{
    
    Controller controller;
    SessionData view;
    Paso paso;
    
    public SessionData_Thread(Controller controller, SessionData view){
        this.controller = controller;
        this.view = view;
        paso = new Paso();
        controller.addPaso(paso);
    }
    
    public void run(){
        while (true)
        {
            paso.mirar();
            
            
            CarStatusData car = controller.session.getUserDriver().carStatus;
            PacketSessionData data = controller.session.data;
            
            if(data != null){
                // Weather Info
                GUIFeatures.setWeatherImage(view.lab_weather, view.lab_weather.getWidth(), data.weather, data.trackId, data.isNightRace());
                view.lab_weather_text.setText(data.getWeather());
                
                view.lab_trackTemperature.setText(data.trackTemperature+" ºC");
                view.lab_airTemperature.setText(data.airTemperature+" ºC");
                
                // Session Info
                view.lab_type.setText(data.getSessionType());
                
                if(data.sessionType > 0 && data.sessionType < 10){
                    view.lab_time_left.setText(data.getSessionTimeLeft());
                }else{
                    view.lab_time_left.setText("");
                }
                
                // Track Info
                GUIFeatures.setTrackImage(view.lab_track, view.lab_track.getWidth(), view.lab_track.getHeight(), data.trackId);
                
                view.lab_pitLimiter.setText(data.pitSpeedLimit+" Km/h");
            }
            
            // Flag
            if(car != null && 
                    data != null){
                GUIFeatures.setFlagLabel(view.lab_flag, car.vehicleFiaFlags, data.getSafetyCarStatus());
            }else{
                if (car != null){
                    GUIFeatures.setFlagLabel(view.lab_flag, car.vehicleFiaFlags, "");
                }else{
                    GUIFeatures.setFlagLabel(view.lab_flag, 0, "");
                }
            }
            
            paso.cerrar();
            
        }
    }
    
}
