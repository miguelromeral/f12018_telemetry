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
    
    private void printParticipantData(Driver d){
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
                labs[2].setText(driver.participant.raceNumber+"");
                labs[2].setForeground(GUIFeatures.getColorByTeam(d.participant.teamId));
                labs[3].setText(driver.participant.getName().toUpperCase());
            }else{
                labs[2].setText("");
                labs[3].setText("");                
            }
        }
    }
    
    private void printLastSector1Data(Driver d){
        if(d != null){
            labs[5].setText(LapData.formatSeconds(d.getLastS1(), false));
            if(d.session.betterThanS1(d.lastS1)){
                labs[5].setForeground(GUIFeatures.getColorTiming(3));
            }else if(d.lastS1 <= d.bestS1){
                labs[5].setForeground(GUIFeatures.getColorTiming(2));
            }else{
                labs[5].setForeground(Color.WHITE);
            }
        }else{
            labs[5].setText("");
        }
    }
    
    private void printCurrentSector1Data(Driver d){
        if(d != null && d.lap != null){
            labs[5].setText(d.lap.getSector1Time(false));
            
            if(d.lap.getSector() != 1){
                if(d.session.betterThanS1(d.lastS1)){
                    labs[5].setForeground(GUIFeatures.getColorTiming(3));
                }else if(d.lastS1 <= d.bestS1){
                    labs[5].setForeground(GUIFeatures.getColorTiming(2));
                }else{
                    labs[5].setForeground(Color.WHITE);
                }
            }else{
                labs[5].setForeground(Color.WHITE);
            }
            
        }else{
            labs[5].setText("");
        }
    }
    
    private void printCurrentSector2Data(Driver d){
        if(d != null && d.lap != null){
            labs[6].setText(d.lap.getSector2Time(false));
            
            if(d.lap.getSector() != 2){
                if(d.session.betterThanS2(d.lastS2)){
                    labs[6].setForeground(GUIFeatures.getColorTiming(3));
                }else if(d.lastS2 <= d.bestS2){
                    labs[6].setForeground(GUIFeatures.getColorTiming(2));
                }else{
                    labs[6].setForeground(Color.WHITE);
                }
            }else{
                labs[6].setForeground(Color.WHITE);
            }
            
        }else{
            labs[6].setText("");
        }
    }
    
    private void printCurrentSector3Data(Driver d){
        if(d != null && d.lap != null){
            labs[7].setText(d.lap.getSector3Time(false));
            
            if(d.lap.getSector() != 3){
                if(d.session.betterThanS3(d.lastS3)){
                    labs[7].setForeground(GUIFeatures.getColorTiming(3));
                }else if(d.lastS3 <= d.bestS3){
                    labs[7].setForeground(GUIFeatures.getColorTiming(2));
                }else{
                    labs[7].setForeground(Color.WHITE);
                }
            }else{
                labs[7].setForeground(Color.WHITE);
            }
            
        }else{
            labs[7].setText("");
        }
    }
    
    private void printLastSector2Data(Driver d){
        if(d != null){
            labs[6].setText(LapData.formatSeconds(d.getLastS2(), false));
            if(d.session.betterThanS2(d.lastS2)){
                labs[6].setForeground(GUIFeatures.getColorTiming(3));
            }else if(d.lastS2 <= d.bestS2){
                labs[6].setForeground(GUIFeatures.getColorTiming(2));
            }else{
                labs[6].setForeground(Color.WHITE);
            }
        }else{
            labs[6].setText("");
        }
    }
    
    private void printLastSector3Data(Driver d){
        if(d != null){
            labs[7].setText(LapData.formatSeconds(d.getLastS3(), false));
            if(d.session.betterThanS3(d.lastS3)){
                labs[7].setForeground(GUIFeatures.getColorTiming(3));
            }else if(d.lastS3 <= d.bestS3){
                labs[7].setForeground(GUIFeatures.getColorTiming(2));
            }else{
                labs[7].setForeground(Color.WHITE);
            }
        }else{
            labs[7].setText("");
        }
    }
   
    private void printLastLapData(Driver d){
        if(d != null && d.lap != null){
            labs[9].setText(d.lap.getLastLapTime(true));
            
            if(d.session.betterThanLap(d.lap.lastLapTime)){
                labs[9].setForeground(GUIFeatures.getColorTiming(3));
            }else if(d.lap.lastLapTime <= d.lap.bestLapTime){
                labs[9].setForeground(GUIFeatures.getColorTiming(2));
            }else{
                labs[9].setForeground(Color.WHITE);
            }
        }else{
            labs[9].setText("");
        }
    }
    
    private void printBestLapData(Driver d){
        if(d != null && d.lap != null){
            labs[10].setText(d.lap.getBestLapTime(true));
            if(d.session.bestLap != Float.POSITIVE_INFINITY && d.session.betterThanLap(d.lap.bestLapTime)){
                labs[10].setForeground(GUIFeatures.getColorTiming(3));
            }else{
                labs[10].setForeground(Color.WHITE);
            }
        }else{
            labs[10].setText("");
        }
    }
    
    private void printLapNumberData(Driver d){
        if(d != null && d.lap != null){
            labs[11].setText(d.lap.currentLapNum+"");
        }else{
            labs[11].setText("");
        }
    }
    
    private void printTyreImage(Driver d){
        if(d != null && d.carStatus != null){
            GUIFeatures.getTyreImage(labs[12], labs[12].getHeight(), d.carStatus.tyreCompound);
        }
    }
    
    private void printColorNameOnTrack(Driver d){
        if(d != null && d.lap != null){
            if(d.lap.pitStatus == 0){
                labs[3].setForeground(Color.WHITE);
            }else{
                labs[3].setForeground(new Color(90,90,90));
            }
        }
    }
    
    private void printCurrentLapTime(Driver d){
        if(d != null){
            if(d.lap != null && d.lap.resultStatus == 2){
                if(d.lap.pitStatus == 0){
                    labs[4].setText(d.lap.getCurrentLapTime(true));
                    if(d.lap.getCurrentLapInvalid()){
                        labs[4].setForeground(Color.red);
                    }else{
                        labs[4].setForeground(Color.white);
                    }
                }else{
                    labs[4].setText("");
                }
            }else{
                switch(d.lap.resultStatus){
                    case 6: labs[4].setText("OUT");
                        break;
                    default: labs[4].setText("");
                }
            }
        }else{
            labs[4].setText("");
        }
    }
    
    private void printSectorTimes(Driver d){
        if(d != null && d.lap.resultStatus != 6){
            switch(tcontroller.getOptionData()){
                case "Latest": 
                    printLastSector1Data(d);
                    printLastSector2Data(d);
                    printLastSector3Data(d);
                    break;
                case "Current":
                    printCurrentSector1Data(d);
                    printCurrentSector2Data(d);
                    printCurrentSector3Data(d);
                    break;
            }
        }else{
            labs[5].setText("");
            labs[6].setText("");
            labs[7].setText("");
        }
    }
    
    public void run(){
        while(keep){
            paso.mirar();
            
            Driver d = driver;
            
            printParticipantData(d);
            printColorNameOnTrack(d);
            
            printCurrentLapTime(d);

            printSectorTimes(d);
            
            printLastLapData(d);
            printBestLapData(d);

            printLapNumberData(d);

            printTyreImage(d);
            
            
            if(d != null && d.lap != null){
                // Delta - 
                labs[8].setText(""+d.lap.resultStatus);
                
                labs[13].setText(d.lap.getPitStatus());
                
                //labs[14].setText(driver.lap.penalties+"");

            }
            
            
            paso.cerrar();
        }
    }
}
