package gui.carsetup;

import gui.carstatus.*;
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
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import packets.carsetup.CarSetupData;
import sun.security.x509.AlgorithmId;

/**
 *
 * @author miguelangel.garciar
 */
public class CarSetup_Thread extends Thread{
    
    Controller controller;
    Driver driver;
    CarSetup view;
    Paso paso;
    
    public CarSetup_Thread(Controller controller, CarSetup view){
        this.controller = controller;
        this.view = view;
        paso = new Paso();
        controller.addPaso(paso);
    }
    
    public void setDriver(Driver d){
        driver = d;
    }
    
    private void printAerodynamicsPanel(CarSetupData setup){
        if(setup != null){
            view.pb_fwa.setValue(setup.frontWing);
            view.pb_rwa.setValue(setup.rearWing);
            view.lab_fwa.setText(" "+setup.frontWing);
            view.lab_rwa.setText(" "+setup.rearWing);
        }else{
            view.pb_fwa.setValue(-1);
            view.pb_rwa.setValue(-1);
            view.lab_fwa.setText(" UNK");
            view.lab_rwa.setText(" UNK");
        }
    }
    
    private void printTransmissionPanel(CarSetupData setup){
        if(setup != null){
            view.pb_onThrottle.setValue(setup.onThrottle);
            view.pb_offThrottle.setValue(setup.offThrottle);
            view.lab_onThrottle.setText(" "+setup.onThrottle+" %");
            view.lab_offThrottle.setText(" "+setup.offThrottle+" %");
        }else{
            view.pb_onThrottle.setValue(49);
            view.pb_offThrottle.setValue(49);
            view.lab_onThrottle.setText(" UNK");
            view.lab_offThrottle.setText(" UNK");
        }
    }
    
    private void printBrakesPanel(CarSetupData setup){
        if(setup != null){
            view.pb_brakePressure.setValue(setup.brakePressure);
            view.lab_brakePressure.setText(" "+setup.brakePressure+" %");
            view.pb_brakeBias.setValue(Math.abs(setup.brakeBias - 70));
            view.lab_brakeBias.setText(" "+setup.brakeBias+" %");
        }else{
            view.pb_brakePressure.setValue(50);
            view.lab_brakePressure.setText(" UNK");
            view.pb_brakeBias.setValue(0);
            view.lab_brakeBias.setText(" UNK");
        }
    }
    
    private void printTyresPanel(CarSetupData setup){
        if(setup != null){
            view.pb_frontTyrePressure.setValue((int) (setup.frontTyrePressure * 10));
            view.pb_rearTyrePressure.setValue((int) (setup.rearTyrePressure * 10));
            view.lab_fronTyrePressure.setText(" "+setup.frontTyrePressure+" psi");
            view.lab_rearTyrePressure.setText(" "+setup.rearTyrePressure+" psi");
        }else{
            view.pb_frontTyrePressure.setValue(210);
            view.pb_rearTyrePressure.setValue(195);
            view.lab_fronTyrePressure.setText(" UNK");
            view.lab_rearTyrePressure.setText(" UNK");
        }
    }
    
    private void printBallastPanel(CarSetupData setup){
        if(setup != null){
            view.pb_ballast.setValue(setup.ballast);
            view.lab_ballast.setText(" "+setup.ballast);
        }else{
            view.pb_ballast.setValue(0);
            view.lab_ballast.setText(" UNK");
        }
    }
    
    public String getFloatString(float f){
        int uds = (int) f;
        int decs = (int) Math.abs((f * 100) % 100);
        if(decs == 0){
            return uds+".00";
        }
        if(decs < 10){
            return uds+".0"+decs;
        }
        return uds+"."+decs;
    }
    
    private void printSuspensionGeometryPanel(CarSetupData setup){
        if(setup != null){
            int fc = 100 - ((int) (Math.abs(setup.frontCamber) * 100) - 250);
            view.pb_frontCamber.setValue(fc);
            view.lab_frontCamber.setText(" "+getFloatString(setup.frontCamber)+" º");
            int rc = 100 - ((int) (Math.abs(setup.rearCamber) * 100) - 100);
            view.pb_rearCamber.setValue(rc);
            view.lab_rearCamber.setText(" "+getFloatString(setup.rearCamber)+" º");
            
            int ft = (int) ((setup.frontToe) * 100) - 5;
            view.pb_frontToe.setValue(ft);
            view.lab_frontToe.setText(" "+getFloatString(setup.frontToe)+" º");
            
            view.pb_rearToe.setValue((int)(setup.rearToe * 100));
            view.lab_rearToe.setText(" "+getFloatString(setup.rearToe)+"º");
        }else{
            view.pb_frontCamber.setValue(0);
            view.lab_frontCamber.setText(" UNK");
            view.pb_rearCamber.setValue(0);
            view.lab_rearCamber.setText(" UNK");
            view.pb_frontToe.setValue(0);
            view.lab_frontToe.setText(" UNK");
            view.pb_rearToe.setValue(20);
            view.lab_rearToe.setText(" UNK");
        }
    }
    
    private void printSuspensionPanel(CarSetupData setup){
        if(setup != null){
            view.pb_frontSuspension.setValue(setup.frontSuspension);
            view.lab_frontSuspension.setText(" "+setup.frontSuspension);
            view.pb_rearSuspension.setValue(setup.rearSuspension);
            view.lab_rearSuspension.setText(" "+setup.rearSuspension);
            view.pb_frontAntiRollBar.setValue(setup.frontAntiRollBar);
            view.lab_frontAntiRollBar.setText(" "+setup.frontAntiRollBar);
            view.pb_rearAntiRollBar.setValue(setup.rearAntiRollBar);
            view.lab_rearAntiRollBar.setText(" "+setup.rearAntiRollBar);
            view.pb_frontSuspensionHeight.setValue(setup.frontSuspensionHeight);
            view.lab_frontRideHeight.setText(" "+setup.frontSuspensionHeight);
            view.pb_rearSuspensionHeight.setValue(setup.rearSuspensionHeight);
            view.lab_rearRideHeight.setText(" "+setup.rearSuspensionHeight);
        }else{
            view.pb_frontSuspension.setValue(0);
            view.lab_frontSuspension.setText(" UNK");
            view.pb_rearSuspension.setValue(0);
            view.lab_rearSuspension.setText(" UNK");
            view.pb_frontAntiRollBar.setValue(0);
            view.lab_frontAntiRollBar.setText(" UNK");
            view.pb_rearAntiRollBar.setValue(0);
            view.lab_rearAntiRollBar.setText(" UNK");
            view.pb_frontSuspensionHeight.setValue(0);
            view.lab_frontRideHeight.setText(" UNK");
            view.pb_rearSuspensionHeight.setValue(0);
            view.lab_rearRideHeight.setText(" UNK");
        }
    }
    
    private void printFuelPanel(CarSetupData setup){
        if(setup != null){
            view.pb_fuelLoad.setValue((int) setup.fuelLoad);
            view.lab_fuelLoad.setText(" "+(int) setup.fuelLoad+" kg");
        }else{
            view.pb_fuelLoad.setValue(0);
            view.lab_fuelLoad.setText(" UNK");
        }
    }
    
    private void printLabelTeam(Driver d){
        if(d != null && d.participant != null){
            view.lab_team.setText(d.participant.getTeam().toUpperCase());
            view.lab_team.setForeground(GUIFeatures.getColorByTeam(d.participant.teamId));
        }else{
            view.lab_team.setText("* NO TEAM DETECTED *");
            view.lab_team.setForeground(Color.gray);
        }
    }
    
    public void run(){
        while (true)
        {
            paso.mirar();
            
            Driver d = driver;
            CarSetupData setup = (d == null ? null : d.carSetup);
            
            printLabelTeam(d);
            printAerodynamicsPanel(setup);
            printTransmissionPanel(setup);
            printBrakesPanel(setup);
            printTyresPanel(setup);
            printSuspensionGeometryPanel(setup);
            printSuspensionPanel(setup);
            printBallastPanel(setup);
            printFuelPanel(setup);
            
            paso.cerrar();
            
        }
    }
}
