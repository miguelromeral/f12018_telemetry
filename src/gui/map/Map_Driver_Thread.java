package gui.map;

import packets.lapdata.LapData;
import packets.session.PacketSessionData;
import classes.statics.DataTypeUtilities;
import classes.Driver;
import classes.Paso;
import classes.statics.GUIFeatures;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author miguelangel.garciar
 */
public class Map_Driver_Thread extends Thread{
    
    JPanel map;
    JLabel label;
    Driver driver;
    Map_Thread tcontroller;
    Paso paso;
    boolean keep;
    
    public Map_Driver_Thread(Map_Thread con){
        tcontroller = con;
        map = tcontroller.view.panelMap;
        paso = new Paso();
        keep = true;
        label = new JLabel();
        label.setSize(250,15);
        label.setOpaque(false);
        map.add(label);
    }
    
    public void setDriver(Driver d){
        driver = d;
        paso.abrir();
    }
    
    public void setTyreImage(Driver d){
        if(d != null && d.carStatus != null && d.participant != null){
            GUIFeatures.getTyreImageMini(label,label.getHeight(), d.carStatus.tyreCompound);
            label.setText(d.participant.getAcronim());
            if(d.lap.pitStatus == 0){
                label.setForeground(Color.YELLOW);
            }else{
                label.setForeground(Color.GRAY);
            }
        }
    }
    
    public void setNewMotion(Driver d){
        if(d != null && d.carMotion != null){
            
            if(d.participant.driverId == 1){
                System.out.println("------------");
                System.out.println("Horizontal: "+d.carMotion.worldPositionX);
                System.out.println("Vertical: "+d.carMotion.worldPositionZ);
            }
                
            int min = Integer.min(map.getWidth(), map.getHeight());

            float x = ((d.carMotion.worldPositionX + 1250 ) / 2500) * min;
            float z = ((d.carMotion.worldPositionZ + 1250 ) / 2500) * min;

            label.setLocation((int) x, (int) z);
        }
    }
    
    public void delete(){
        keep = false;
    }
    
    public void run(){
        while(keep){
            paso.mirar();
            
            Driver d = driver;
            
            setTyreImage(d);
            setNewMotion(d);
            
            paso.cerrar();
        }
    }
}
