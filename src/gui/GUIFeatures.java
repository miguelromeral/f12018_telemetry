package gui;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author miguelangel.garciar
 */
public class GUIFeatures {
    
    
    public static void setImageIcon(JLabel label, int sizehor, int sizever, String image){
        ImageIcon imagen = new ImageIcon("images/"+image+".png");
        Icon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(sizehor,sizever,Image.SCALE_DEFAULT));
        label.setIcon(imgRedimensionada);
    }
    
    public static void getTyreImage(JLabel label, int size, int compound) {
        try {
            label.setText("");
            String tyre = null;
            switch(compound){
                case 0: tyre = "hypersoft"; break;
                case 1: tyre = "ultrasoft"; break;
                case 2: tyre = "supersoft"; break;
                case 3: tyre = "soft"; break;
                case 4: tyre = "medium"; break;
                case 5: tyre = "hard"; break;
                case 6: tyre = "superhard"; break;
                case 7: tyre = "inter"; break;
                case 8: tyre = "wet"; break;
            }
            if(tyre != null){
                setImageIcon(label, size, size, "tyres/"+tyre);
            }
        } catch (Exception e) {
            System.out.println("Error en la imagen: " + e.toString());
        }
    }
    
    public static void setTyreWear(JProgressBar pb, JLabel lab, int usage){
        
        Color col; 
        if(usage < 30){
            col = Color.green;
        }else if(usage < 50){
            col = Color.yellow;
        }else if(usage < 65){
            col = Color.orange;
        }else if(usage < 100){
            col = Color.red;
        }else{
            col = Color.BLACK;
        }
        
        lab.setText(usage+"%");
        lab.setForeground(col);
        pb.setValue(usage);
        pb.setForeground(col);
    }
    
}
