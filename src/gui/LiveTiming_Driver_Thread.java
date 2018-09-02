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
    
    private void printParticipantData(){
        if(driver != null){
            labs[0].setText(driver.lap.carPosition+"");
            labs[1].setText("I");
            labs[1].setForeground(GUIFeatures.getColorByTeam(driver.participant.teamId));
            labs[2].setText(driver.participant.raceNumber+"");
            labs[2].setForeground(GUIFeatures.getColorByTeam(driver.participant.teamId));
            labs[3].setText(driver.participant.getName().toUpperCase());
        }
    }
    
    private void printLastSector1Data(){
        if(driver != null){
            labs[5].setText(LapData.formatSeconds(driver.getLastS1(), false));
            if(driver.session.betterThanS1(driver.lastS1)){
                labs[5].setForeground(GUIFeatures.getColorTiming(3));
            }else if(driver.lastS1 <= driver.bestS1){
                labs[5].setForeground(GUIFeatures.getColorTiming(2));
            }else{
                labs[5].setForeground(Color.WHITE);
            }
        }
    }
    
    private void printLastSector2Data(){
        if(driver != null){
            labs[6].setText(LapData.formatSeconds(driver.getLastS2(), false));
            if(driver.session.betterThanS2(driver.lastS2)){
                labs[6].setForeground(GUIFeatures.getColorTiming(3));
            }else if(driver.lastS2 <= driver.bestS2){
                labs[6].setForeground(GUIFeatures.getColorTiming(2));
            }else{
                labs[6].setForeground(Color.WHITE);
            }
        }
    }
    
    private void printLastSector3Data(){
        if(driver != null){
            labs[7].setText(LapData.formatSeconds(driver.getLastS3(), false));
            if(driver.session.betterThanS3(driver.lastS3)){
                labs[7].setForeground(GUIFeatures.getColorTiming(3));
            }else if(driver.lastS3 <= driver.bestS3){
                labs[7].setForeground(GUIFeatures.getColorTiming(2));
            }else{
                labs[7].setForeground(Color.WHITE);
            }
        }
    }
   
    private void printLastLapData(){
        if(driver != null){
            labs[9].setText(driver.lap.getLastLapTime(true));
            if(driver.session.betterThanLap(driver.lap.lastLapTime)){
                labs[9].setForeground(GUIFeatures.getColorTiming(3));
            }else if(driver.lap.lastLapTime <= driver.lap.bestLapTime){
                labs[9].setForeground(GUIFeatures.getColorTiming(2));
            }else{
                labs[9].setForeground(Color.WHITE);
            }
        }
    }
    
    private void printBestLapData(){
        if(driver != null){
            labs[10].setText(driver.lap.getBestLapTime(true));
            if(driver.session.betterThanLap(driver.lap.bestLapTime)){
                labs[10].setForeground(GUIFeatures.getColorTiming(3));
            }else{
                labs[10].setForeground(Color.WHITE);
            }
        }
    }
    
    private void printLapNumberData(){
        if(driver != null){
            labs[11].setText(driver.lap.currentLapNum+"");
        }
    }
    
    private void printTyreImage(){
        if(driver != null){
            if(driver.carStatus != null){
                GUIFeatures.getTyreImage(labs[12], labs[12].getHeight(), driver.carStatus.tyreCompound);
            }
        }
    }
    
    private void printLabelsGarage(){
        if(driver != null && driver.lap != null){
            if(driver.lap.pitStatus == 0){
                labs[3].setForeground(Color.WHITE);
                labs[4].setText(driver.lap.getCurrentLapTime(true));
            }else{
                labs[3].setForeground(new Color(90,90,90));
                labs[4].setText("");
            }
        }
    }
    
    public void run(){
        while(keep){
            paso.mirar();
            
            if(driver != null){
                printParticipantData();

                if(driver.lap != null){
                    if(driver.lap.getCurrentLapInvalid()){
                        labs[4].setForeground(Color.red);
                    }else{
                        labs[4].setForeground(Color.white);
                    }
                }
                
                
                

                printLastSector1Data();
                printLastSector2Data();
                printLastSector3Data();
                
                
                // Delta - 8
                
                printLastLapData();
                printBestLapData();
                
                printLapNumberData();
                
                printTyreImage();
                
                labs[13].setText(driver.lap.getPitStatus());
                
                //labs[14].setText(driver.lap.penalties+"");

            }
            
            printLabelsGarage();
            
            paso.cerrar();
        }
    }
}
