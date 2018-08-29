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
            
            
            CarStatusData car = controller.session.ownCar;
            PacketSessionData data = controller.session.data;
            
            if(car != null){
                // Flag
                GUIFeatures.setFlagLabel(view.lab_flag, car.vehicleFiaFlags);
            }
            
            if(data != null){
                // Weather Info
                GUIFeatures.setWeatherImage(view.lab_weather, view.lab_weather.getWidth(), data.weather, data.trackId, data.isNightRace());
                view.lab_weather_text.setText(data.getWeather());
                
            }
            
            paso.cerrar();
            
        }
    }
    
}
