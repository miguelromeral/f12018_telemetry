package gui;

import Packets.CarStatusData;
import Packets.CarTelemetryData;
import classes.Controller;
import classes.Paso;
import java.awt.Color;
import static java.lang.Thread.sleep;
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
    
    public void run(){
        while (true)
        {
            paso.mirar();
            CarStatusData car = controller.session.getUserDriver().carStatus;
            CarTelemetryData tel = controller.session.getUserDriver().carTelemetry;
            
            boolean drsAllowed = false;
            boolean drsActivated = false;
            
            if(car != null){
                
                GUIFeatures.getTyreImage(view.lab_tyreCompound, 60, car.tyreCompound);
                
                // TyreWear %:
                GUIFeatures.setTyreWear(view.pb_tyreWearRL, view.lab_tyreWearRL, car.tyresWear[0]);
                GUIFeatures.setTyreWear(view.pb_tyreWearRR, view.lab_tyreWearRR, car.tyresWear[1]);
                GUIFeatures.setTyreWear(view.pb_tyreWearFL, view.lab_tyreWearFL, car.tyresWear[2]);
                GUIFeatures.setTyreWear(view.pb_tyreWearFR, view.lab_tyreWearFR, car.tyresWear[3]);
                
                // Fuel Mix:
                view.lab_fuelMix.setText(car.getFuelMix());
                
                // Engine Damage:
                view.lab_damageMGUH.setText("- %");         // Motor Generator Unit - Hear
                view.lab_damageES.setText("- %");           // Energy Store
                view.lab_damageCE.setText("- %");           // Control Electrics
                view.lab_damageICE.setText("- %");          // Internal Combustion Engine
                view.lab_damageMGUK.setText("- %");         // MGU-Kinetic
                view.lab_damageTC.setText("- %");           // Turbo Charger
                view.lab_damageGearbox.setText(+car.gearBoxDamage+" %"); // Gear Box
                
                // ERS Panel
                float ersTotal = car.ersStoreEnergy;
                float ersMGUK = car.ersHarvestedThisLapMGUK;
                float ersMGUH = car.ersHarvestedThisLapMGUH;
                float ersLap = car.ersDeployedThisLap;
                
                float max = 122.07f;
                float yellow = ersMGUK + ersMGUH / max;
                float blue = (ersTotal / max) * 100;
                float white = (1 - (ersLap / max)) * 100;
                
                view.pb_yellow.setValue((int) yellow);
                view.pb_blue.setValue((int) blue);
                view.pb_white.setValue((int) white);
                
                view.lab_ers_yellow.setText((int) yellow+"%");
                view.lab_ers_blue.setText((int) blue+"%");
                view.lab_ers_white.setText((int) white+"%");
                
                
                
                // ERS Deployed Mode 
                view.lab_ersModeNumber.setText(""+car.ersDeployMode);
                view.lab_ersDeploy.setText(car.getERSDeployMode());
                
                // Pit Limiter
                if(car.pitLimiterStatus == 1){
                    view.lab_pitLimiter.setForeground(new Color(255, 255, 255));
                    view.lab_pitLimiter.setBackground(new Color(0, 102, 255));
                }else{
                    view.lab_pitLimiter.setForeground(new Color(100, 100, 100));
                    view.lab_pitLimiter.setBackground(new Color(19, 19, 19));
                }
                
                // DRS allowed
                if(car.drsAllowed == 1){
                    drsAllowed = true;
                }
                
                // ABS
                if(car.antiLockBrakes == 1){
                    view.lab_abs.setForeground(new Color(0, 0, 0));
                    view.lab_abs.setBackground(new Color(255, 204, 51));
                }else{
                    view.lab_abs.setForeground(new Color(100, 100, 100));
                    view.lab_abs.setBackground(new Color(19, 19, 19));
                }
                
                // Flag
                if(controller.session.data != null){
                    GUIFeatures.setFlagLabel(view.lab_flag, car.vehicleFiaFlags, controller.session.data.getSafetyCarStatus());
                }else{
                    GUIFeatures.setFlagLabel(view.lab_flag, car.vehicleFiaFlags, "");
                }
                
            }
            if(tel != null){
                // Speed
                view.lab_speed.setText(""+tel.speed);

                // Throttle %
                view.pb_throttle.setValue((int) tel.throttle);
                // Brake %
                view.pb_brake.setValue((int) tel.brake);
                // Clutch %
                view.pb_clutch.setValue((int) tel.clutch);
                
                // Revs:
                view.lab_revs.setText(""+tel.engineRPM);
                view.pb_revs.setValue(tel.engineRPM);
                
                // Steer %
                int steer = tel.steer;
                if(steer > 0){
                    view.pb_steer_r.setValue(steer);
                    view.pb_steer_l.setValue(100);
                    view.lab_steer.setText(steer+"%");
                }else if(steer < 0){
                    steer += 100;
                    view.pb_steer_r.setValue(0);
                    view.pb_steer_l.setValue(steer);
                    view.lab_steer.setText((100-steer)+"%");
                }else{
                    view.pb_steer_r.setValue(0);
                    view.pb_steer_l.setValue(100);
                    view.lab_steer.setText("0%");
                }
                
                // Gear
                view.lab_gear.setText(tel.getGear());
                
                // DRS Activated:
                if(tel.drs == 1){
                    drsActivated = true;
                }
                
            }
            
            if(drsAllowed || drsActivated){
                if(drsActivated){
                    view.lab_drs.setForeground(new Color(0, 0, 0));
                    view.lab_drs.setBackground(new Color(102, 255, 51));
                }else{
                    view.lab_drs.setForeground(new Color(0, 0, 0));
                    view.lab_drs.setBackground(new Color(255, 103, 0));
                }
            }else{
                view.lab_drs.setForeground(new Color(100, 100, 100));
                view.lab_drs.setBackground(new Color(19, 19, 19));
            }
            
            paso.cerrar();
            
        }
    }
    
}
