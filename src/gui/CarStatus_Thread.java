package gui;

import Packets.CarStatusData;
import Packets.CarTelemetryData;
import Packets.PacketSessionData;
import classes.Controller;
import classes.Driver;
import classes.Paso;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import sun.security.x509.AlgorithmId;

/**
 *
 * @author miguelangel.garciar
 */
public class CarStatus_Thread extends Thread{
    
    Controller controller;
    Driver driver;
    CarStatus view;
    Paso paso;
    
    public CarStatus_Thread(Controller controller, CarStatus view){
        this.controller = controller;
        this.view = view;
        paso = new Paso();
        controller.addPaso(paso);
    }
    
    public void setDriver(Driver d){
        driver = d;
    }
    
    private void setPanelTyreDamage(CarStatusData car){
        if(car != null){
            GUIFeatures.getTyreImage(view.lab_tyreCompound, 60, car.tyreCompound);
            GUIFeatures.setTyreWear(view.pb_tyreWearRL, view.lab_tyreWearRL, car.tyresWear[0]);
            GUIFeatures.setTyreWear(view.pb_tyreWearRR, view.lab_tyreWearRR, car.tyresWear[1]);
            GUIFeatures.setTyreWear(view.pb_tyreWearFL, view.lab_tyreWearFL, car.tyresWear[2]);
            GUIFeatures.setTyreWear(view.pb_tyreWearFR, view.lab_tyreWearFR, car.tyresWear[3]);
        }else{
            view.lab_tyreCompound.setText("UNK");
            GUIFeatures.setTyreWear(view.pb_tyreWearRL, view.lab_tyreWearRL, 0);
            GUIFeatures.setTyreWear(view.pb_tyreWearRR, view.lab_tyreWearRR, 0);
            GUIFeatures.setTyreWear(view.pb_tyreWearFL, view.lab_tyreWearFL, 0);
            GUIFeatures.setTyreWear(view.pb_tyreWearFR, view.lab_tyreWearFR, 0);
        }
    }
    
    private void setPanelERSStorage(CarStatusData car){
        if(car != null){
            float ersTotal = car.ersStoreEnergy;
            float ersMGUK = car.ersHarvestedThisLapMGUK;
            float ersMGUH = car.ersHarvestedThisLapMGUH;
            float ersLap = car.ersDeployedThisLap;

            int yellow = (int) (((ersMGUK + ersMGUH) / CarStatusData.MAX_ERS_STORAGE) * 100);
            int blue = (int) ((ersTotal / CarStatusData.MAX_ERS_STORAGE) * 100);
            int white = (int) ((1 - (ersLap / CarStatusData.MAX_ERS_STORAGE)) * 100);

            view.pb_yellow.setValue(yellow);
            view.pb_blue.setValue(blue);
            view.pb_white.setValue(white);

            view.lab_ers_yellow.setText((int) yellow+"%");
            view.lab_ers_blue.setText((int) blue+"%");
            view.lab_ers_white.setText((int) white+"%");

            // ERS Deployed Mode 
            view.lab_ersModeNumber.setText(""+car.ersDeployMode);
            view.lab_ersDeploy.setText(car.getERSDeployMode());
        }else{
            view.pb_yellow.setValue(0);
            view.pb_blue.setValue(0);
            view.pb_white.setValue(0);

            view.lab_ers_yellow.setText("UNK");
            view.lab_ers_blue.setText("UNK");
            view.lab_ers_white.setText("UNK");

            // ERS Deployed Mode 
            view.lab_ersModeNumber.setText("-");
            view.lab_ersDeploy.setText("UNKNOWN");
        }
    }
    
    private void setPanelFuel(CarStatusData car){
        if(car != null){
            view.lab_fuelMix.setText(car.getFuelMix());
        }else{
            view.lab_fuelMix.setText("UNKNOWN");
        }
    }
    
    private void setPanelEngine(CarStatusData car){
        if(car != null){
            view.lab_engine_damage.setText(car.engineDamage+"%");
            view.lab_engine_damage.setForeground(GUIFeatures.getColorByDamagePercentage(car.engineDamage));
            
            view.lab_exhaust_damage.setText(car.exhaustDamage+"%");
            view.lab_exhaust_damage.setForeground(GUIFeatures.getColorByDamagePercentage(car.exhaustDamage));
            
            view.lab_gearbox_damage.setText(car.gearBoxDamage+"%");
            view.lab_gearbox_damage.setForeground(GUIFeatures.getColorByDamagePercentage(car.gearBoxDamage));
            
            
        }else{
            view.lab_engine_damage.setText("UNK");
            view.lab_engine_damage.setForeground(GUIFeatures.getColorByDamagePercentage(0));
            
            view.lab_exhaust_damage.setText("UNK");
            view.lab_exhaust_damage.setForeground(GUIFeatures.getColorByDamagePercentage(0));
            
            view.lab_gearbox_damage.setText("UNK");
            view.lab_gearbox_damage.setForeground(GUIFeatures.getColorByDamagePercentage(0));
        }
    }
    
    private void setPanelConsole(CarStatusData car, CarTelemetryData tel){
        boolean drsAllowed = false;
        boolean drsActivated = false;
        if(car != null){
            // Pit Limiter
            if (car.pitLimiterStatus == 1) {
                view.lab_pitLimiter.setForeground(new Color(255, 255, 255));
                view.lab_pitLimiter.setBackground(new Color(0, 102, 255));
            } else {
                view.lab_pitLimiter.setForeground(new Color(100, 100, 100));
                view.lab_pitLimiter.setBackground(new Color(19, 19, 19));
            }

            // ABS
            if (car.antiLockBrakes == 1) {
                view.lab_abs.setForeground(new Color(0, 0, 0));
                view.lab_abs.setBackground(new Color(255, 204, 51));
            } else {
                view.lab_abs.setForeground(new Color(100, 100, 100));
                view.lab_abs.setBackground(new Color(19, 19, 19));
            }
            if (car.drsAllowed == 1) {
                drsAllowed = true;
            }
        }else{
            view.lab_pitLimiter.setForeground(new Color(100, 100, 100));
            view.lab_pitLimiter.setBackground(new Color(19, 19, 19));

            view.lab_abs.setForeground(new Color(100, 100, 100));
            view.lab_abs.setBackground(new Color(19, 19, 19));
        }
        if(tel != null){
            // Gear
            view.lab_gear.setText(tel.getGear());
            if (tel.drs == 1) {
                drsActivated = true;
            }
        }else{
            view.lab_gear.setText("-");
        }
        if (drsAllowed || drsActivated) {
            if (drsActivated) {
                view.lab_drs.setForeground(new Color(0, 0, 0));
                view.lab_drs.setBackground(new Color(102, 255, 51));
            } else {
                view.lab_drs.setForeground(new Color(0, 0, 0));
                view.lab_drs.setBackground(new Color(255, 103, 0));
            }
        } else {
            view.lab_drs.setForeground(new Color(100, 100, 100));
            view.lab_drs.setBackground(new Color(19, 19, 19));
        }
    }
    
    private void setPanelFlag(PacketSessionData data, CarStatusData car){
        // Flag
        if(car != null){
            if (data != null && data.safetyCarStatus != 0) {
                GUIFeatures.setFlagLabel(view.lab_flag, car.vehicleFiaFlags, data.getSafetyCarStatus());
            } else {
                GUIFeatures.setFlagLabel(view.lab_flag, car.vehicleFiaFlags, "");
            }
        }else{
            GUIFeatures.setFlagLabel(view.lab_flag, 0, "");
        }
    }
    
    private void setFrontRightWingDamage(int perc){
        Color col; 
        if(perc < 30){
            col = Color.green;
        }else if(perc < 50){
            col = Color.yellow;
        }else if(perc < 65){
            col = Color.orange;
        }else if(perc <= 100){
            col = Color.red;
        }else{
            col = Color.BLACK;
        }
        
        view.lab_FRWD.setText(perc+"%");
        view.lab_FRWD.setForeground(col);
        view.pb_frwd.setValue(perc);
        view.pb_frwd.setForeground(col);
    }
    
    private void setFrontLeftWingDamage(int perc){
        Color col; 
        if(perc < 30){
            col = Color.green;
        }else if(perc < 50){
            col = Color.yellow;
        }else if(perc < 65){
            col = Color.orange;
        }else if(perc <= 100){
            col = Color.red;
        }else{
            col = Color.BLACK;
        }
        
        view.lab_FLWD.setText(perc+"%");
        view.lab_FLWD.setForeground(col);
        view.pb_flwd.setValue(perc);
        view.pb_flwd.setForeground(col);
    }
    
    private void setRearWingDamage(int perc){
        Color col; 
        if(perc < 30){
            col = Color.green;
        }else if(perc < 50){
            col = Color.yellow;
        }else if(perc < 65){
            col = Color.orange;
        }else if(perc <= 100){
            col = Color.red;
        }else{
            col = Color.BLACK;
        }
        
        view.lab_rwd.setText(perc+"%");
        view.lab_rwd.setForeground(col);
        view.pb_rwd.setValue(perc);
        view.pb_rwd.setForeground(col);
    }
    
    private void setWingDamage(CarStatusData car){
        if(car != null){
            setFrontRightWingDamage(car.frontRightWingDamage);
            setFrontLeftWingDamage(car.frontLeftWingDamage);
            setRearWingDamage(car.rearWingDamage);
        }else{
            setFrontRightWingDamage(0);
            setFrontLeftWingDamage(0);
            setRearWingDamage(0);
        }
    }
    
    public void run(){
        while (true)
        {
            paso.mirar();
            
            Driver d = driver;
            PacketSessionData data = controller.session.data;
            CarStatusData car = (d == null ? null : d.carStatus);
            CarTelemetryData tel = (d == null ? null : d.carTelemetry);
            
            setPanelTyreDamage(car);
            setPanelFuel(car);
            setPanelEngine(car);
            setPanelERSStorage(car);
            setPanelFlag(data, car);
            setPanelConsole(car, tel);
            setWingDamage(car);
                
            paso.cerrar();
            
        }
    }
}
