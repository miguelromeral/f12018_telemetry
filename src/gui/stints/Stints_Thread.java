package gui.stints;

import gui.livetiming.*;
import packets.carstatus.CarStatusData;
import packets.cartelemetry.CarTelemetryData;
import packets.lapdata.LapData;
import packets.session.PacketSessionData;
import classes.Controller;
import classes.Driver;
import classes.Paso;
import classes.Session;
import classes.statics.GUIFeatures;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author miguelangel.garciar
 */
public class Stints_Thread extends Thread{
    
    Controller controller;
    Stints view;
    Paso paso;
    
    public Stints_Thread(Controller controller, Stints view){
        this.controller = controller;
        this.view = view;
        paso = new Paso();
        controller.addPaso(paso);
    }
    
    
    private void printParticipantData(Driver d, JLabel labs[]){
        if(d != null){
            if(d.lap != null){
                labs[0].setText(d.lap.carPosition+"");
                labs[1].setText("I");
            }else{
                labs[0].setText("");
                labs[1].setText("");
            }
            if(d.participant != null){
                labs[1].setForeground(GUIFeatures.getColorByTeam(d.participant.teamId));
                labs[2].setText(d.participant.raceNumber+"");
                labs[2].setForeground(GUIFeatures.getColorByTeam(d.participant.teamId));
                labs[3].setText(d.participant.getName().toUpperCase());
            }else{
                labs[2].setText("");
                labs[3].setText("");                
            }
        }
    }
    
    
    private void printColorNameOnTrack(Driver d, JLabel labs[]){
        if(d != null && d.lap != null){
            if(d.lap.pitStatus != 0){
                labs[3].setForeground(new Color(90, 90, 90));
            }else if(d.lap.resultStatus == 2 || d.lap.resultStatus == 3){
                labs[3].setForeground(Color.white);
            }else{
                labs[3].setForeground(Color.red);
            }
        }
    }

    
    private void printShieldImage(Driver d, JLabel labs[]){
        if(d != null && d.participant != null){
            GUIFeatures.setConstructorImage(labs[12], labs[12].getHeight(), labs[12].getHeight(), d.participant.teamId);
        }
    }
    
    private void printTyresUsed(Driver driver, PacketSessionData data, JLabel labs[]){
        if(driver.stints.isEmpty()){
            setLabelsStint(null, labs[4], data, driver, 0);
            setLabelsStint(null, labs[5], data, driver, 0);
            setLabelsStint(null, labs[6], data, driver, 0);
            setLabelsStint(null, labs[7], data, driver, 0);
            setLabelsStint(null, labs[8], data, driver, 0);
            setLabelsStint(null, labs[9], data, driver, 0);
            setLabelsStint(null, labs[10], data, driver, 0);
            setLabelsStint(null, labs[11], data, driver, 0);
            labs[13].setText("");
            return;
        }
        ArrayList<HashMap<Integer, Short>> stints = driver.stints;
        int desf = (stints.size() <= 8 ? 0 : stints.size() - 8);
        for(int i = 0; i<Stints.MAX_STINTS; i++){
            if(i + desf < stints.size()){
                setLabelsStint(stints.get(i + desf), labs[i+4], data, driver, i + desf);
                
                
            }else{
                setLabelsStint(null, labs[i+4], data, driver, 0);
                //System.out.println("-->");
            }
        }
        labs[13].setText(""+(stints.size() - 1));
    }
    
    private void setLabelsStint(HashMap<Integer, Short> stint, JLabel lab, PacketSessionData data, Driver d, int numStint){
        if(stint != null && d.lap != null){
            for(Integer key : stint.keySet()) {
                int age = d.getTyreAges(numStint, d.lap.currentLapNum);
                if(!lab.getText().equals(""+age)){
                
                    GUIFeatures.getTyreImage(lab, lab.getHeight(), stint.get(key), data.era);
                    lab.setText(""+age);
                }
            }
        }else{
            lab.setText("");
            lab.setIcon(null);
        }
    }
    
    private void printDriverInfo(Driver d, PacketSessionData data, int index){
        if(d != null && data != null){
            printParticipantData(d, view.labels[index]);
            printColorNameOnTrack(d, view.labels[index]);
            printTyresUsed(d, data, view.labels[index]);
            printShieldImage(d, view.labels[index]);
        }
    }
    
    public void run(){
        while (true)
        {
            paso.mirar();
            
            ArrayList<Driver> drivers = controller.session.getAllDrivers();
            PacketSessionData data = controller.session.data;
            
            if(drivers != null){
                for(int i = 0; i < drivers.size(); i++){
                    printDriverInfo(controller.session.getDriverByPosition(i+1), data, i);
                }
            }
            
            paso.cerrar();
            
        }
    }
    
}
