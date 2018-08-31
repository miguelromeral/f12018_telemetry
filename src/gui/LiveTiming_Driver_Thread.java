package gui;

import Packets.LapData;
import classes.Driver;
import classes.Paso;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author miguelangel.garciar
 */
public class LiveTiming_Driver_Thread extends Thread{
    
    JLabel[] labs;
    Driver driver;
    LiveTiming_Thread tcontroller;
    Paso paso;
    boolean keep;
    
    public LiveTiming_Driver_Thread(LiveTiming_Thread con, JLabel[] lab){
        tcontroller = con;
        labs = lab;
        paso = new Paso();
        keep = true;
    }
    
    public void setDriver(Driver d){
        driver = d;
        paso.abrir();
    }
    
    public void delete(){
        keep = false;
    }
    
    public void run(){
        while(keep){
            paso.mirar();
            
            if(driver != null){
                labs[0].setText(driver.lap.carPosition+"");
                labs[1].setText("I");
                labs[1].setForeground(GUIFeatures.getColorByTeam(driver.participant.teamId));
                labs[2].setText(driver.participant.raceNumber+"");
                labs[2].setForeground(GUIFeatures.getColorByTeam(driver.participant.teamId));
                labs[3].setText(driver.participant.getName().toUpperCase());

                if(driver.lap.pitStatus == 0){
                    labs[4].setText(driver.lap.getCurrentLapTime(true));
                    
                    if(driver.lap.getCurrentLapInvalid()){
                        labs[4].setForeground(Color.red);
                    }else{
                        labs[4].setForeground(Color.white);
                    }
                    
                    
                }else{
                    labs[4].setText("");
                }

                // Sector 1
                labs[5].setText(LapData.formatSeconds(driver.getLastS1(), false));
                if(driver.session.betterThanS1(driver.lastS1)){
                    labs[5].setForeground(GUIFeatures.getColorTiming(3));
                }else if(driver.lastS1 <= driver.bestS1){
                    labs[5].setForeground(GUIFeatures.getColorTiming(2));
                }else{
                    labs[5].setForeground(Color.WHITE);
                }
                
                // Sector 2
                labs[6].setText(LapData.formatSeconds(driver.getLastS2(), false));
                if(driver.session.betterThanS2(driver.lastS2)){
                    labs[6].setForeground(GUIFeatures.getColorTiming(3));
                }else if(driver.lastS2 <= driver.bestS2){
                    labs[6].setForeground(GUIFeatures.getColorTiming(2));
                }else{
                    labs[6].setForeground(Color.WHITE);
                }
                
                // Sector 3
                labs[7].setText(LapData.formatSeconds(driver.getLastS3(), false));
                if(driver.session.betterThanS3(driver.lastS3)){
                    labs[7].setForeground(GUIFeatures.getColorTiming(3));
                }else if(driver.lastS3 <= driver.bestS3){
                    labs[7].setForeground(GUIFeatures.getColorTiming(2));
                }else{
                    labs[7].setForeground(Color.WHITE);
                }
                
                // Delta - 8
                
                labs[9].setText(driver.lap.getLastLapTime(true));
                if(driver.session.betterThanLap(driver.lap.lastLapTime)){
                    labs[9].setForeground(GUIFeatures.getColorTiming(3));
                }else if(driver.lap.lastLapTime <= driver.lap.bestLapTime){
                    labs[9].setForeground(GUIFeatures.getColorTiming(2));
                }else{
                    labs[9].setForeground(Color.WHITE);
                }
                
                
                labs[10].setText(driver.lap.getBestLapTime(true));
                if(driver.session.betterThanLap(driver.lap.bestLapTime)){
                    labs[10].setForeground(GUIFeatures.getColorTiming(3));
                }else{
                    labs[10].setForeground(Color.WHITE);
                }
                
                labs[11].setText(driver.lap.currentLapNum+"");
                GUIFeatures.getTyreImage(labs[12], labs[12].getHeight(), driver.carStatus.tyreCompound);
                labs[13].setText(driver.lap.getPitStatus());
                labs[14].setText(driver.lap.penalties+"");

            }
            
            paso.cerrar();
        }
    }
}
