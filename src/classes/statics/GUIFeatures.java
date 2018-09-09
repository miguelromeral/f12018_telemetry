package classes.statics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author miguelangel.garciar
 */
public class GUIFeatures {
    
    public static void setFlagLabel(JLabel lab, int flag, String sc){
        switch(flag){
            case -1: lab.setForeground(new Color(0,0,0));
                    lab.setBackground(new Color(255,255,255));
                    lab.setText("WARNING FLAG");
                break;
            case 0: lab.setForeground(new Color(19,19,19));
                    lab.setBackground(new Color(19,19,19));
                    lab.setText("");
                break;
            case 1: lab.setForeground(new Color(0,0,0));
                    lab.setBackground(new Color(102,255,51));
                    lab.setText("GREEN FLAG");
                break;
            case 2: lab.setForeground(new Color(0,0,0));
                    lab.setBackground(new Color(0,102,255));
                    lab.setText("BLUE FLAG");
                break;
            case 3: lab.setForeground(new Color(0,0,0));
                    lab.setBackground(new Color(255,255,0));
                    lab.setText("YELLOW FLAG "+sc);
                break;
            case 4: lab.setForeground(new Color(255,255,255));
                    lab.setBackground(new Color(255,0,0));
                    lab.setText("RED FLAG");
                break;
        }
    }
    
    /**
     * @param type 1 Worst Personal | 2 Best personal | 3 Best Session
     */
    public static Color getColorTiming(int type){
        switch(type){
            case 1: return new Color(255, 255, 0);
            case 2: return new Color(0, 255, 0);
            case 3: return new Color(255, 0, 255);
            default: return Color.WHITE;
        }
    }
    
    public static void setSizeLabel(JLabel label, int w, int h){
        label.setMinimumSize(new Dimension(w, h));
        label.setPreferredSize(new Dimension(w, h));
        label.setMaximumSize(new Dimension(w, h));
    }
    
    public static void setTrackImage(JLabel label, int sh, int sv, int track) {
        try {
            label.setText("");
            String tr = null;
            switch(track){
                case 0: tr =  "australia"; break;
                case 1: tr =  "france";break;
                case 2: tr =  "china";break;
                case 3: case 21: tr =  "barhain";break;
                case 4: tr =  "spain";break;
                case 5: tr =  "monaco";break;
                case 6: tr =  "canada";break;
                case 7: case 22: tr =  "greatbritain";break;
                case 8: tr =  "germany";break;
                case 9: tr =  "hungary";break;
                case 10: tr =  "belgium";break;
                case 11: tr =  "italy";break;
                case 12: tr =  "singapore";break;
                case 13: case 24: tr =  "japan";break;
                case 14: tr =  "abudabi";break;
                case 15: case 23: tr =  "usa";break;
                case 16: tr =  "brasil";break;
                case 17: tr =  "austria";break;
                case 18: tr =  "russia";break;
                case 19: tr =  "mexico";break;
                case 20: tr =  "azerbaijan";break;
            }
            if(tr != null){
                setImageIcon(label, sh, sv, "track/"+tr);
            }
        } catch (Exception e) {
            System.out.println("Error en la imagen: " + e.toString());
        }
    }
    
    public static Color getColorByTeam(int team){
        switch(team){
            case 0: return new Color(0, 210, 190);// Mercedes
            case 1: return new Color(220, 0, 0);// Ferrari
            case 2: return new Color(30, 65, 255);// RedBull
            case 3: return new Color(255, 255, 255);// Williams
            case 4: return new Color(245, 150, 200);// Force India
            case 5: return new Color(255, 245, 0);// Renault
            case 6: return new Color(70, 155, 255);// Toro Rosso
            case 7: return new Color(130, 130, 130);// Haas
            case 8: return new Color(255, 135, 0); // McLaren
            case 9: return new Color(155, 0, 0);// Sauber
            default: return Color.white;
        }
    }
    
    public static void setWeatherImage(JLabel label, int size, int weather, int trak, boolean night) {
        try {
            label.setText("");
            String we = null;
            switch(weather){
                case 0: we = (night ? "moon_clear" : "sunny_clear"); break;
                case 1: we = (night ? "moon_light_cloud" : "sunny_light_cloud"); break;
                case 2: we = "overcast"; break;
                case 3: we = "light_rain"; break;
                case 4: we = "heavy_rain"; break;
                case 5: we = "storm"; break;
                default:
            }
            if(we != null){
                setImageIcon(label, size, size, "weather/"+we);
            }
        } catch (Exception e) {
            System.out.println("Error en la imagen: " + e.toString());
        }
    }
    
    public static void setImageIcon(JLabel label, int sizehor, int sizever, String image){
        ImageIcon imagen = new ImageIcon("images/"+image+".png");
        Icon imgRedimensionada = new ImageIcon(imagen.getImage().getScaledInstance(sizehor,sizever,Image.SCALE_DEFAULT));
        label.setIcon(imgRedimensionada);
    }
    
    public static void getTyreImage(JLabel label, int size, int compound, int era) {
        try {
            label.setText("");
            String tyre = null;
            if(era == 0){
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
            }else{
                if(compound < 7){
                    setImageIcon(label, size, size, "tyres/dry_classic");
                }else if (compound < 9){
                    setImageIcon(label, size, size, "tyres/wet_classic");
                }
            }
        } catch (Exception e) {
        }
    }
    
    public static void getTyreImageMini(JLabel label, int size, int compound) {
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
                setImageIcon(label, size, size, "tyres/mini/"+tyre);
            }
        } catch (Exception e) {
            System.out.println("Error en la imagen: " + e.toString());
        }
    }
    
    public static void setTyreWear(JProgressBar pb, int usage){
        
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
        
        pb.setValue(usage);
        pb.setForeground(col);
    }
    
    public static void setBrakeTemperature(JLabel lab, int perc){
        
        Color col; 
        if(perc >= 1025){
            col = Color.red;
        }else if(perc >= 900){
            col = Color.orange;
        }else if(perc >= 775){
            col = Color.yellow;
        }else if(perc > 250){
            col = Color.green;
        }else{
            col = Color.cyan;
        }
        
        lab.setText(perc+"ºC");
        lab.setForeground(col);
    }
    
    public static void setTyreSurfaceTemperature(JLabel lab, int perc){
        
        Color col; 
        if(perc >= 135){
            col = Color.red;
        }else if(perc >= 122){
            col = Color.orange;
        }else if(perc >= 110){
            col = Color.yellow;
        }else if(perc >= 70){
            col = Color.green;
        }else{
            col = Color.cyan;
        }
        
        lab.setText(perc+"ºC");
        lab.setForeground(col);
    }
    
    public static void setTyreInnerTemperature(JLabel lab, int perc){
        
        Color col; 
        if(perc >= 110){
            col = Color.red;
        }else if(perc >= 105){
            col = Color.orange;
        }else if(perc >= 100){
            col = Color.yellow;
        }else if(perc > 85){
            col = Color.green;
        }else{
            col = Color.cyan;
        }
        
        lab.setText(perc+"ºC");
        lab.setForeground(col);
    }    
    
    public static Color getEngineTemperature(int perc){
        
        Color col; 
        if(perc >= 160){
            col = Color.red;
        }else if(perc >= 150){
            col = Color.orange;
        }else if(perc >= 135){
            col = Color.yellow;
        }else if(perc >= 70){
            col = Color.green;
        }else{
            col = Color.cyan;
        }
        
        return col;
    }    
    
    public static void setTyrePressure(JLabel lab, float pres){
        Color col; 
        if(pres < 20f || pres > 24f){
            col = Color.red;
        }else{
            col = Color.green;
        }
        
        lab.setForeground(col);
        lab.setText(pres+" psi");
    }
    
    public static void printRevLight(JLabel label, int position, int perc){
        float percLight = (position / 15f);
        if (perc <= (int) (percLight * 100) && perc != 100){
            label.setForeground(new Color(51,51,51));
        }else{
            if(position <= 5){
                label.setForeground(Color.GREEN);
            }else if(position <= 10){
                label.setForeground(Color.RED);
            }else{
                label.setForeground(Color.BLUE);
            }
        }
    }
    
    public static Color getColorByDamagePercentage(int perc){
        Color col; 
        if(perc < 30){
            col = Color.green;
        }else if(perc < 50){
            col = Color.yellow;
        }else if(perc < 65){
            col = Color.orange;
        }else if(perc < 100){
            col = Color.red;
        }else{
            col = Color.BLACK;
        }
        return col;
    }
}
