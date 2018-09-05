package gui.console;

import packets.carstatus.CarStatusData;
import packets.cartelemetry.CarTelemetryData;
import packets.session.PacketSessionData;
import classes.Controller;
import classes.Driver;
import classes.Paso;
import classes.statics.GUIFeatures;
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

/**
 *
 * @author miguelangel.garciar
 */
public class Console_Thread extends Thread{
    
    Controller controller;
    Console view;
    Paso paso;
    
    public Console_Thread(Controller controller, Console view){
        this.controller = controller;
        this.view = view;
        paso = new Paso();
        controller.addPaso(paso);
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
            view.lab_damageMGUH.setText("- %");         // Motor Generator Unit - Hear
            view.lab_damageES.setText("- %");           // Energy Store
            view.lab_damageCE.setText("- %");           // Control Electrics
            view.lab_damageICE.setText("- %");          // Internal Combustion Engine
            view.lab_damageMGUK.setText("- %");         // MGU-Kinetic
            view.lab_damageTC.setText("- %");           // Turbo Charger
            view.lab_damageGearbox.setText(+car.gearBoxDamage+" %"); // Gear Box
        }else{
            view.lab_damageMGUH.setText("UNK");         // Motor Generator Unit - Hear
            view.lab_damageES.setText("UNK");           // Energy Store
            view.lab_damageCE.setText("UNK");           // Control Electrics
            view.lab_damageICE.setText("UNK");          // Internal Combustion Engine
            view.lab_damageMGUK.setText("UNK");         // MGU-Kinetic
            view.lab_damageTC.setText("UNK");           // Turbo Charger
            view.lab_damageGearbox.setText("UNK"); // Gear Box
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
    
    private void setPanelSteer(CarTelemetryData tel){
        int steer = (tel == null ? 0 : tel.steer);
        if (steer > 0) {
            view.pb_steer_r.setValue(steer);
            view.pb_steer_l.setValue(100);
            view.lab_steer.setText(steer + "%");
        } else if (steer < 0) {
            steer += 100;
            view.pb_steer_r.setValue(0);
            view.pb_steer_l.setValue(steer);
            view.lab_steer.setText((100 - steer) + "%");
        } else {
            view.pb_steer_r.setValue(0);
            view.pb_steer_l.setValue(100);
            view.lab_steer.setText("0%");
        }
    }
    
    private void setPanelPedals(CarTelemetryData tel){
        if(tel != null){
            // Speed
            view.lab_speed.setText("" + tel.speed);
            // Throttle %
            view.pb_throttle.setValue((int) tel.throttle);
            // Brake %
            view.pb_brake.setValue((int) tel.brake);
            // Clutch %
            view.pb_clutch.setValue((int) tel.clutch);

            // Revs:
            view.lab_revs.setText("" + tel.engineRPM);
            view.pb_revs.setValue(tel.engineRPM);
        }else{// Speed
            view.lab_speed.setText("UNK");
            view.pb_throttle.setValue(0);
            view.pb_brake.setValue(0);
            view.pb_clutch.setValue(0);
            view.lab_revs.setText("-");
            view.pb_revs.setValue(0);
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
    
    public void run(){
        while (true)
        {
            paso.mirar();
            
            Driver d = controller.session.getUserDriver();
            PacketSessionData data = controller.session.data;
            CarStatusData car = (d == null ? null : d.carStatus);
            CarTelemetryData tel = (d == null ? null : d.carTelemetry);
            
            setPanelTyreDamage(car);
            setPanelFuel(car);
            setPanelEngine(car);
            setPanelERSStorage(car);
            setPanelFlag(data, car);
            setPanelPedals(tel);
            setPanelSteer(tel);
            setPanelConsole(car, tel);
                
                
            paso.cerrar();
            
        }
    }
}
