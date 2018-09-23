package gui.stints;

import gui.livetiming.*;
import classes.Controller;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author miguelangel.garciar
 */
public class Stints extends javax.swing.JFrame {

    public static int MAX_STINTS = 8;
    
    Stints_Thread thread;
    
    JLabel[][] labels;
    
    public Stints(Controller controller) {
        initComponents();
        /*
        boolean race = false;
        if(controller.session.data != null){
            int type = controller.session.data.sessionType;
            if(type == 10 || type == 11){
                race = true;
            }
        }
        
        
        if(!race){
            JOptionPane.showMessageDialog(null, "You must be on a race to see the tyres usage.", "Not a race detected", 
                        JOptionPane.WARNING_MESSAGE);
            return;
        }else{*/
            thread = new Stints_Thread(controller, this);
            thread.start();

            setPanels();
       // }
    }
    
    private void setPanels(){
        labels = new JLabel[20][15];
        setOnePanel(labels[0], labPos1, labCol1, labNum1, labName1, lab_1_stint_1, lab_1_stint_2, lab_1_stint_3, lab_1_stint_4, lab_1_stint_5, lab_1_stint_6, lab_1_stint_7, lab_1_stint_8, labPen1, labStops1);
        setOnePanel(labels[1], labPos2, labCol2, labNum2, labName2, lab_2_stint_1, lab_2_stint_2, lab_2_stint_3, lab_2_stint_4, lab_2_stint_5, lab_2_stint_6, lab_2_stint_7, lab_2_stint_8, labPen2, labStops2);
        setOnePanel(labels[2], labPos3, labCol3, labNum3, labName3, lab_3_stint_1, lab_3_stint_2, lab_3_stint_3, lab_3_stint_4, lab_3_stint_5, lab_3_stint_6, lab_3_stint_7, lab_3_stint_8,  labPen3, labStops3);
        setOnePanel(labels[3], labPos4, labCol4, labNum4, labName4, lab_4_stint_1, lab_4_stint_2, lab_4_stint_3, lab_4_stint_4, lab_4_stint_5, lab_4_stint_6, lab_4_stint_7, lab_4_stint_8, labPen4, labStops4);
        setOnePanel(labels[4], labPos5, labCol5, labNum5, labName5, lab_5_stint_1, lab_5_stint_2, lab_5_stint_3, lab_5_stint_4, lab_5_stint_5, lab_5_stint_6, lab_5_stint_7, lab_5_stint_8,  labPen5, labStops5);
        setOnePanel(labels[5], labPos6, labCol6, labNum6, labName6, lab_6_stint_1, lab_6_stint_2, lab_6_stint_3, lab_6_stint_4, lab_6_stint_5, lab_6_stint_6, lab_6_stint_7, lab_6_stint_8,  labPen6, labStops6);
        setOnePanel(labels[6], labPos7, labCol7, labNum7, labName7, lab_7_stint_1, lab_7_stint_2, lab_7_stint_3, lab_7_stint_4, lab_7_stint_5, lab_7_stint_6, lab_7_stint_7, lab_7_stint_8, labPen7, labStops7);
        setOnePanel(labels[7], labPos8, labCol8, labNum8, labName8, lab_8_stint_1, lab_8_stint_2, lab_8_stint_3, lab_8_stint_4, lab_8_stint_5, lab_8_stint_6, lab_8_stint_7, lab_8_stint_8, labPen8, labStops8);
        setOnePanel(labels[8], labPos9, labCol9, labNum9, labName9, lab_9_stint_1, lab_9_stint_2, lab_9_stint_3, lab_9_stint_4, lab_9_stint_5, lab_9_stint_6, lab_9_stint_7, lab_9_stint_8, labPen9, labStops9);
        setOnePanel(labels[9], labPos10, labCol10, labNum10, labName10, lab_10_stint_1, lab_10_stint_2, lab_10_stint_3, lab_10_stint_4, lab_10_stint_5, lab_10_stint_6, lab_10_stint_7, lab_10_stint_8, labPen10, labStops10);
        setOnePanel(labels[10], labPos11, labCol11, labNum11, labName11, lab_11_stint_1, lab_11_stint_2, lab_11_stint_3, lab_11_stint_4, lab_11_stint_5, lab_11_stint_6, lab_11_stint_7, lab_11_stint_8, labPen11, labStops11);
        setOnePanel(labels[11], labPos12, labCol12, labNum12, labName12, lab_12_stint_1, lab_12_stint_2, lab_12_stint_3, lab_12_stint_4, lab_12_stint_5, lab_12_stint_6, lab_12_stint_7, lab_12_stint_8, labPen12, labStops12);
        setOnePanel(labels[12], labPos13, labCol13, labNum13, labName13, lab_13_stint_1, lab_13_stint_2, lab_13_stint_3, lab_13_stint_4, lab_13_stint_5, lab_13_stint_6, lab_13_stint_7, lab_13_stint_8,  labPen13, labStops13);
        setOnePanel(labels[13], labPos14, labCol14, labNum14, labName14, lab_14_stint_1, lab_14_stint_2, lab_14_stint_3, lab_14_stint_4, lab_14_stint_5, lab_14_stint_6, lab_14_stint_7, lab_14_stint_8, labPen14, labStops14);
        setOnePanel(labels[14], labPos15, labCol15, labNum15, labName15, lab_15_stint_1, lab_15_stint_2, lab_15_stint_3, lab_15_stint_4, lab_15_stint_5, lab_15_stint_6, lab_15_stint_7, lab_15_stint_8,  labPen15, labStops15);
        setOnePanel(labels[15], labPos16, labCol16, labNum16, labName16, lab_16_stint_1, lab_16_stint_2, lab_16_stint_3, lab_16_stint_4, lab_16_stint_5, lab_16_stint_6, lab_16_stint_7, lab_16_stint_8, labPen16, labStops16);
        setOnePanel(labels[16], labPos17, labCol17, labNum17, labName17, lab_17_stint_1, lab_17_stint_2, lab_17_stint_3, lab_17_stint_4, lab_17_stint_5, lab_17_stint_6, lab_17_stint_7, lab_17_stint_8, labPen17, labStops17);
        setOnePanel(labels[17], labPos18, labCol18, labNum18, labName18, lab_18_stint_1, lab_18_stint_2, lab_18_stint_3, lab_18_stint_4, lab_18_stint_5, lab_18_stint_6, lab_18_stint_7, lab_18_stint_8, labPen18, labStops18);
        setOnePanel(labels[18], labPos19, labCol19, labNum19, labName19, lab_19_stint_1, lab_19_stint_2, lab_19_stint_3, lab_19_stint_4, lab_19_stint_5, lab_19_stint_6, lab_19_stint_7, lab_19_stint_8,  labPen19, labStops19);
        setOnePanel(labels[19], labPos20, labCol20, labNum20, labName20, lab_20_stint_1, lab_20_stint_2, lab_20_stint_3, lab_20_stint_4, lab_20_stint_5, lab_20_stint_6, lab_20_stint_7, lab_20_stint_8,  labPen20,labStops20);
    }
    
    private void setOnePanel(JLabel[] label, JLabel pos, JLabel col, JLabel num, JLabel name, JLabel s1, JLabel s2, JLabel s3, JLabel s4,
            JLabel s5, JLabel s6, JLabel s7, JLabel s8, JLabel pen, JLabel stops){
        label[0] = pos;
        label[1] = col;
        label[2] = num;
        label[3] = name;
        label[4] = s1;
        label[5] = s2;
        label[6] = s3;
        label[7] = s4;
        label[8] = s5;
        label[9] = s6;
        label[10] = s7;
        label[11] = s8;
        label[12] = pen;
        label[13] = stops;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelTiming = new javax.swing.JPanel();
        panel0 = new javax.swing.JPanel();
        labPos0 = new javax.swing.JLabel();
        labCol0 = new javax.swing.JLabel();
        labPen0 = new javax.swing.JLabel();
        labNum = new javax.swing.JLabel();
        labName0 = new javax.swing.JLabel();
        labNum21 = new javax.swing.JLabel();
        labTime0 = new javax.swing.JLabel();
        labS10 = new javax.swing.JLabel();
        labS20 = new javax.swing.JLabel();
        labS30 = new javax.swing.JLabel();
        labDelta0 = new javax.swing.JLabel();
        labLast0 = new javax.swing.JLabel();
        labBest0 = new javax.swing.JLabel();
        labBest21 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        labPos1 = new javax.swing.JLabel();
        labPen1 = new javax.swing.JLabel();
        labCol1 = new javax.swing.JLabel();
        labNum1 = new javax.swing.JLabel();
        labName1 = new javax.swing.JLabel();
        labStops1 = new javax.swing.JLabel();
        lab_1_stint_1 = new javax.swing.JLabel();
        lab_1_stint_2 = new javax.swing.JLabel();
        lab_1_stint_3 = new javax.swing.JLabel();
        lab_1_stint_4 = new javax.swing.JLabel();
        lab_1_stint_5 = new javax.swing.JLabel();
        lab_1_stint_6 = new javax.swing.JLabel();
        lab_1_stint_7 = new javax.swing.JLabel();
        lab_1_stint_8 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        labPos2 = new javax.swing.JLabel();
        labPen2 = new javax.swing.JLabel();
        labCol2 = new javax.swing.JLabel();
        labNum2 = new javax.swing.JLabel();
        labName2 = new javax.swing.JLabel();
        labStops2 = new javax.swing.JLabel();
        lab_2_stint_1 = new javax.swing.JLabel();
        lab_2_stint_2 = new javax.swing.JLabel();
        lab_2_stint_3 = new javax.swing.JLabel();
        lab_2_stint_4 = new javax.swing.JLabel();
        lab_2_stint_5 = new javax.swing.JLabel();
        lab_2_stint_6 = new javax.swing.JLabel();
        lab_2_stint_7 = new javax.swing.JLabel();
        lab_2_stint_8 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        labPos3 = new javax.swing.JLabel();
        labPen3 = new javax.swing.JLabel();
        labCol3 = new javax.swing.JLabel();
        labNum3 = new javax.swing.JLabel();
        labName3 = new javax.swing.JLabel();
        labStops3 = new javax.swing.JLabel();
        lab_3_stint_1 = new javax.swing.JLabel();
        lab_3_stint_2 = new javax.swing.JLabel();
        lab_3_stint_3 = new javax.swing.JLabel();
        lab_3_stint_4 = new javax.swing.JLabel();
        lab_3_stint_5 = new javax.swing.JLabel();
        lab_3_stint_6 = new javax.swing.JLabel();
        lab_3_stint_7 = new javax.swing.JLabel();
        lab_3_stint_8 = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        labPos4 = new javax.swing.JLabel();
        labPen4 = new javax.swing.JLabel();
        labCol4 = new javax.swing.JLabel();
        labNum4 = new javax.swing.JLabel();
        labName4 = new javax.swing.JLabel();
        labStops4 = new javax.swing.JLabel();
        lab_4_stint_1 = new javax.swing.JLabel();
        lab_4_stint_2 = new javax.swing.JLabel();
        lab_4_stint_3 = new javax.swing.JLabel();
        lab_4_stint_4 = new javax.swing.JLabel();
        lab_4_stint_5 = new javax.swing.JLabel();
        lab_4_stint_6 = new javax.swing.JLabel();
        lab_4_stint_7 = new javax.swing.JLabel();
        lab_4_stint_8 = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        labPos5 = new javax.swing.JLabel();
        labPen5 = new javax.swing.JLabel();
        labCol5 = new javax.swing.JLabel();
        labNum5 = new javax.swing.JLabel();
        labName5 = new javax.swing.JLabel();
        labStops5 = new javax.swing.JLabel();
        lab_5_stint_1 = new javax.swing.JLabel();
        lab_5_stint_2 = new javax.swing.JLabel();
        lab_5_stint_3 = new javax.swing.JLabel();
        lab_5_stint_4 = new javax.swing.JLabel();
        lab_5_stint_5 = new javax.swing.JLabel();
        lab_5_stint_6 = new javax.swing.JLabel();
        lab_5_stint_7 = new javax.swing.JLabel();
        lab_5_stint_8 = new javax.swing.JLabel();
        panel6 = new javax.swing.JPanel();
        labPos6 = new javax.swing.JLabel();
        labPen6 = new javax.swing.JLabel();
        labCol6 = new javax.swing.JLabel();
        labNum6 = new javax.swing.JLabel();
        labName6 = new javax.swing.JLabel();
        labStops6 = new javax.swing.JLabel();
        lab_6_stint_1 = new javax.swing.JLabel();
        lab_6_stint_2 = new javax.swing.JLabel();
        lab_6_stint_3 = new javax.swing.JLabel();
        lab_6_stint_4 = new javax.swing.JLabel();
        lab_6_stint_5 = new javax.swing.JLabel();
        lab_6_stint_6 = new javax.swing.JLabel();
        lab_6_stint_7 = new javax.swing.JLabel();
        lab_6_stint_8 = new javax.swing.JLabel();
        panel7 = new javax.swing.JPanel();
        labPos7 = new javax.swing.JLabel();
        labPen7 = new javax.swing.JLabel();
        labCol7 = new javax.swing.JLabel();
        labNum7 = new javax.swing.JLabel();
        labName7 = new javax.swing.JLabel();
        labStops7 = new javax.swing.JLabel();
        lab_7_stint_1 = new javax.swing.JLabel();
        lab_7_stint_2 = new javax.swing.JLabel();
        lab_7_stint_3 = new javax.swing.JLabel();
        lab_7_stint_4 = new javax.swing.JLabel();
        lab_7_stint_5 = new javax.swing.JLabel();
        lab_7_stint_6 = new javax.swing.JLabel();
        lab_7_stint_7 = new javax.swing.JLabel();
        lab_7_stint_8 = new javax.swing.JLabel();
        panel8 = new javax.swing.JPanel();
        labPos8 = new javax.swing.JLabel();
        labPen8 = new javax.swing.JLabel();
        labCol8 = new javax.swing.JLabel();
        labNum8 = new javax.swing.JLabel();
        labName8 = new javax.swing.JLabel();
        labStops8 = new javax.swing.JLabel();
        lab_8_stint_1 = new javax.swing.JLabel();
        lab_8_stint_2 = new javax.swing.JLabel();
        lab_8_stint_3 = new javax.swing.JLabel();
        lab_8_stint_4 = new javax.swing.JLabel();
        lab_8_stint_5 = new javax.swing.JLabel();
        lab_8_stint_6 = new javax.swing.JLabel();
        lab_8_stint_7 = new javax.swing.JLabel();
        lab_8_stint_8 = new javax.swing.JLabel();
        panel9 = new javax.swing.JPanel();
        labPos9 = new javax.swing.JLabel();
        labPen9 = new javax.swing.JLabel();
        labCol9 = new javax.swing.JLabel();
        labNum9 = new javax.swing.JLabel();
        labName9 = new javax.swing.JLabel();
        labStops9 = new javax.swing.JLabel();
        lab_9_stint_1 = new javax.swing.JLabel();
        lab_9_stint_2 = new javax.swing.JLabel();
        lab_9_stint_3 = new javax.swing.JLabel();
        lab_9_stint_4 = new javax.swing.JLabel();
        lab_9_stint_5 = new javax.swing.JLabel();
        lab_9_stint_6 = new javax.swing.JLabel();
        lab_9_stint_7 = new javax.swing.JLabel();
        lab_9_stint_8 = new javax.swing.JLabel();
        panel10 = new javax.swing.JPanel();
        labPos10 = new javax.swing.JLabel();
        labPen10 = new javax.swing.JLabel();
        labCol10 = new javax.swing.JLabel();
        labNum10 = new javax.swing.JLabel();
        labName10 = new javax.swing.JLabel();
        labStops10 = new javax.swing.JLabel();
        lab_10_stint_1 = new javax.swing.JLabel();
        lab_10_stint_2 = new javax.swing.JLabel();
        lab_10_stint_3 = new javax.swing.JLabel();
        lab_10_stint_4 = new javax.swing.JLabel();
        lab_10_stint_5 = new javax.swing.JLabel();
        lab_10_stint_6 = new javax.swing.JLabel();
        lab_10_stint_7 = new javax.swing.JLabel();
        lab_10_stint_8 = new javax.swing.JLabel();
        panel11 = new javax.swing.JPanel();
        labPos11 = new javax.swing.JLabel();
        labPen11 = new javax.swing.JLabel();
        labCol11 = new javax.swing.JLabel();
        labNum11 = new javax.swing.JLabel();
        labName11 = new javax.swing.JLabel();
        labStops11 = new javax.swing.JLabel();
        lab_11_stint_1 = new javax.swing.JLabel();
        lab_11_stint_2 = new javax.swing.JLabel();
        lab_11_stint_3 = new javax.swing.JLabel();
        lab_11_stint_4 = new javax.swing.JLabel();
        lab_11_stint_5 = new javax.swing.JLabel();
        lab_11_stint_6 = new javax.swing.JLabel();
        lab_11_stint_7 = new javax.swing.JLabel();
        lab_11_stint_8 = new javax.swing.JLabel();
        panel12 = new javax.swing.JPanel();
        labPos12 = new javax.swing.JLabel();
        labPen12 = new javax.swing.JLabel();
        labCol12 = new javax.swing.JLabel();
        labNum12 = new javax.swing.JLabel();
        labName12 = new javax.swing.JLabel();
        labStops12 = new javax.swing.JLabel();
        lab_12_stint_1 = new javax.swing.JLabel();
        lab_12_stint_2 = new javax.swing.JLabel();
        lab_12_stint_3 = new javax.swing.JLabel();
        lab_12_stint_4 = new javax.swing.JLabel();
        lab_12_stint_5 = new javax.swing.JLabel();
        lab_12_stint_6 = new javax.swing.JLabel();
        lab_12_stint_7 = new javax.swing.JLabel();
        lab_12_stint_8 = new javax.swing.JLabel();
        panel13 = new javax.swing.JPanel();
        labPos13 = new javax.swing.JLabel();
        labPen13 = new javax.swing.JLabel();
        labCol13 = new javax.swing.JLabel();
        labNum13 = new javax.swing.JLabel();
        labName13 = new javax.swing.JLabel();
        labStops13 = new javax.swing.JLabel();
        lab_13_stint_1 = new javax.swing.JLabel();
        lab_13_stint_2 = new javax.swing.JLabel();
        lab_13_stint_3 = new javax.swing.JLabel();
        lab_13_stint_4 = new javax.swing.JLabel();
        lab_13_stint_5 = new javax.swing.JLabel();
        lab_13_stint_6 = new javax.swing.JLabel();
        lab_13_stint_7 = new javax.swing.JLabel();
        lab_13_stint_8 = new javax.swing.JLabel();
        panel14 = new javax.swing.JPanel();
        labPos14 = new javax.swing.JLabel();
        labPen14 = new javax.swing.JLabel();
        labCol14 = new javax.swing.JLabel();
        labNum14 = new javax.swing.JLabel();
        labName14 = new javax.swing.JLabel();
        labStops14 = new javax.swing.JLabel();
        lab_14_stint_1 = new javax.swing.JLabel();
        lab_14_stint_2 = new javax.swing.JLabel();
        lab_14_stint_3 = new javax.swing.JLabel();
        lab_14_stint_4 = new javax.swing.JLabel();
        lab_14_stint_5 = new javax.swing.JLabel();
        lab_14_stint_6 = new javax.swing.JLabel();
        lab_14_stint_7 = new javax.swing.JLabel();
        lab_14_stint_8 = new javax.swing.JLabel();
        panel15 = new javax.swing.JPanel();
        labPos15 = new javax.swing.JLabel();
        labPen15 = new javax.swing.JLabel();
        labCol15 = new javax.swing.JLabel();
        labNum15 = new javax.swing.JLabel();
        labName15 = new javax.swing.JLabel();
        labStops15 = new javax.swing.JLabel();
        lab_15_stint_1 = new javax.swing.JLabel();
        lab_15_stint_2 = new javax.swing.JLabel();
        lab_15_stint_3 = new javax.swing.JLabel();
        lab_15_stint_4 = new javax.swing.JLabel();
        lab_15_stint_5 = new javax.swing.JLabel();
        lab_15_stint_6 = new javax.swing.JLabel();
        lab_15_stint_7 = new javax.swing.JLabel();
        lab_15_stint_8 = new javax.swing.JLabel();
        panel16 = new javax.swing.JPanel();
        labPos16 = new javax.swing.JLabel();
        labPen16 = new javax.swing.JLabel();
        labCol16 = new javax.swing.JLabel();
        labNum16 = new javax.swing.JLabel();
        labName16 = new javax.swing.JLabel();
        labStops16 = new javax.swing.JLabel();
        lab_16_stint_1 = new javax.swing.JLabel();
        lab_16_stint_2 = new javax.swing.JLabel();
        lab_16_stint_3 = new javax.swing.JLabel();
        lab_16_stint_4 = new javax.swing.JLabel();
        lab_16_stint_5 = new javax.swing.JLabel();
        lab_16_stint_6 = new javax.swing.JLabel();
        lab_16_stint_7 = new javax.swing.JLabel();
        lab_16_stint_8 = new javax.swing.JLabel();
        panel17 = new javax.swing.JPanel();
        labPos17 = new javax.swing.JLabel();
        labPen17 = new javax.swing.JLabel();
        labCol17 = new javax.swing.JLabel();
        labNum17 = new javax.swing.JLabel();
        labName17 = new javax.swing.JLabel();
        labStops17 = new javax.swing.JLabel();
        lab_17_stint_1 = new javax.swing.JLabel();
        lab_17_stint_2 = new javax.swing.JLabel();
        lab_17_stint_3 = new javax.swing.JLabel();
        lab_17_stint_4 = new javax.swing.JLabel();
        lab_17_stint_5 = new javax.swing.JLabel();
        lab_17_stint_6 = new javax.swing.JLabel();
        lab_17_stint_7 = new javax.swing.JLabel();
        lab_17_stint_8 = new javax.swing.JLabel();
        panel18 = new javax.swing.JPanel();
        labPos18 = new javax.swing.JLabel();
        labPen18 = new javax.swing.JLabel();
        labCol18 = new javax.swing.JLabel();
        labNum18 = new javax.swing.JLabel();
        labName18 = new javax.swing.JLabel();
        labStops18 = new javax.swing.JLabel();
        lab_18_stint_1 = new javax.swing.JLabel();
        lab_18_stint_2 = new javax.swing.JLabel();
        lab_18_stint_3 = new javax.swing.JLabel();
        lab_18_stint_4 = new javax.swing.JLabel();
        lab_18_stint_5 = new javax.swing.JLabel();
        lab_18_stint_6 = new javax.swing.JLabel();
        lab_18_stint_7 = new javax.swing.JLabel();
        lab_18_stint_8 = new javax.swing.JLabel();
        panel19 = new javax.swing.JPanel();
        labPos19 = new javax.swing.JLabel();
        labPen19 = new javax.swing.JLabel();
        labCol19 = new javax.swing.JLabel();
        labNum19 = new javax.swing.JLabel();
        labName19 = new javax.swing.JLabel();
        labStops19 = new javax.swing.JLabel();
        lab_19_stint_1 = new javax.swing.JLabel();
        lab_19_stint_2 = new javax.swing.JLabel();
        lab_19_stint_3 = new javax.swing.JLabel();
        lab_19_stint_4 = new javax.swing.JLabel();
        lab_19_stint_5 = new javax.swing.JLabel();
        lab_19_stint_6 = new javax.swing.JLabel();
        lab_19_stint_7 = new javax.swing.JLabel();
        lab_19_stint_8 = new javax.swing.JLabel();
        panel20 = new javax.swing.JPanel();
        labPos20 = new javax.swing.JLabel();
        labPen20 = new javax.swing.JLabel();
        labCol20 = new javax.swing.JLabel();
        labNum20 = new javax.swing.JLabel();
        labName20 = new javax.swing.JLabel();
        labStops20 = new javax.swing.JLabel();
        lab_20_stint_1 = new javax.swing.JLabel();
        lab_20_stint_2 = new javax.swing.JLabel();
        lab_20_stint_3 = new javax.swing.JLabel();
        lab_20_stint_4 = new javax.swing.JLabel();
        lab_20_stint_5 = new javax.swing.JLabel();
        lab_20_stint_6 = new javax.swing.JLabel();
        lab_20_stint_7 = new javax.swing.JLabel();
        lab_20_stint_8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tyres Usage");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(19, 19, 19));
        jPanel1.setPreferredSize(new java.awt.Dimension(1248, 700));

        panelTiming.setBackground(new java.awt.Color(19, 19, 19));
        panelTiming.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tyres Age", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204))); // NOI18N
        panelTiming.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel0.setBackground(new java.awt.Color(125, 125, 125));
        panel0.setLayout(new javax.swing.BoxLayout(panel0, javax.swing.BoxLayout.LINE_AXIS));

        labPos0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labPos0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos0.setText("P");
        labPos0.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos0.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos0.setPreferredSize(new java.awt.Dimension(20, 17));
        panel0.add(labPos0);

        labCol0.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol0.setForeground(new java.awt.Color(255, 255, 255));
        labCol0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol0.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol0.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labCol0);

        labPen0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labPen0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen0.setMaximumSize(new java.awt.Dimension(40, 17));
        labPen0.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labPen0);

        labNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum.setText("#");
        labNum.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labNum);

        labName0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labName0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labName0.setText("NAME");
        labName0.setMaximumSize(new java.awt.Dimension(200, 17));
        labName0.setMinimumSize(new java.awt.Dimension(20, 17));
        labName0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labName0);

        labNum21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labNum21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum21.setText("STOPS");
        labNum21.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum21.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum21.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labNum21);

        labTime0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labTime0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime0.setText("STINT 1");
        labTime0.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime0.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labTime0);

        labS10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labS10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS10.setText("STINT 2");
        labS10.setMaximumSize(new java.awt.Dimension(100, 17));
        labS10.setMinimumSize(new java.awt.Dimension(20, 17));
        labS10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labS10);

        labS20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labS20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS20.setText("STINT 3");
        labS20.setMaximumSize(new java.awt.Dimension(100, 17));
        labS20.setMinimumSize(new java.awt.Dimension(20, 17));
        labS20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labS20);

        labS30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labS30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS30.setText("STINT 4");
        labS30.setMaximumSize(new java.awt.Dimension(100, 17));
        labS30.setMinimumSize(new java.awt.Dimension(20, 17));
        labS30.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labS30);

        labDelta0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labDelta0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta0.setText("STINT 5");
        labDelta0.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta0.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labDelta0);

        labLast0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labLast0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast0.setText("STINT 6");
        labLast0.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast0.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labLast0);

        labBest0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labBest0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest0.setText("STINT 7");
        labBest0.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest0.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labBest0);

        labBest21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labBest21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest21.setText("STINT 8");
        labBest21.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest21.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest21.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labBest21);

        panelTiming.add(panel0, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, 1210, 27));

        panel1.setBackground(new java.awt.Color(19, 19, 19));
        panel1.setLayout(new javax.swing.BoxLayout(panel1, javax.swing.BoxLayout.LINE_AXIS));

        labPos1.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos1.setForeground(new java.awt.Color(255, 255, 255));
        labPos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos1.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos1.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos1.setPreferredSize(new java.awt.Dimension(20, 17));
        panel1.add(labPos1);

        labPen1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen1.setForeground(new java.awt.Color(255, 255, 255));
        labPen1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen1.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen1.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labPen1);

        labCol1.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol1.setForeground(new java.awt.Color(255, 255, 255));
        labCol1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol1.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol1.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labCol1);

        labNum1.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum1.setForeground(new java.awt.Color(255, 255, 255));
        labNum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum1.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum1.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labNum1);

        labName1.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName1.setForeground(new java.awt.Color(255, 255, 255));
        labName1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName1.setMaximumSize(new java.awt.Dimension(200, 17));
        labName1.setMinimumSize(new java.awt.Dimension(20, 17));
        labName1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labName1);

        labStops1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops1.setForeground(new java.awt.Color(255, 255, 0));
        labStops1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops1.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops1.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labStops1);

        lab_1_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_1_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_1_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_1_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_1_stint_1.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_1_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel1.add(lab_1_stint_1);

        lab_1_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_1_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_1_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_1_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_1_stint_2.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_1_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel1.add(lab_1_stint_2);

        lab_1_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_1_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_1_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_1_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_1_stint_3.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_1_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel1.add(lab_1_stint_3);

        lab_1_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_1_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_1_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_1_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_1_stint_4.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_1_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel1.add(lab_1_stint_4);

        lab_1_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_1_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_1_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_1_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_1_stint_5.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_1_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel1.add(lab_1_stint_5);

        lab_1_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_1_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_1_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_1_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_1_stint_6.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_1_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel1.add(lab_1_stint_6);

        lab_1_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_1_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_1_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_1_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_1_stint_7.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_1_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel1.add(lab_1_stint_7);

        lab_1_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_1_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_1_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_1_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_1_stint_8.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_1_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel1.add(lab_1_stint_8);

        panelTiming.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 43, 1210, 27));

        panel2.setBackground(new java.awt.Color(25, 25, 25));
        panel2.setLayout(new javax.swing.BoxLayout(panel2, javax.swing.BoxLayout.LINE_AXIS));

        labPos2.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos2.setForeground(new java.awt.Color(255, 255, 255));
        labPos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos2.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos2.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos2.setPreferredSize(new java.awt.Dimension(20, 17));
        panel2.add(labPos2);

        labPen2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen2.setForeground(new java.awt.Color(255, 255, 255));
        labPen2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen2.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen2.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labPen2);

        labCol2.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol2.setForeground(new java.awt.Color(255, 255, 255));
        labCol2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol2.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol2.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labCol2);

        labNum2.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum2.setForeground(new java.awt.Color(255, 255, 255));
        labNum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum2.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum2.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labNum2);

        labName2.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName2.setForeground(new java.awt.Color(255, 255, 255));
        labName2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName2.setMaximumSize(new java.awt.Dimension(200, 17));
        labName2.setMinimumSize(new java.awt.Dimension(20, 17));
        labName2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labName2);

        labStops2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops2.setForeground(new java.awt.Color(255, 255, 0));
        labStops2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops2.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops2.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labStops2);

        lab_2_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_2_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_2_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_2_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_2_stint_1.setMinimumSize(new java.awt.Dimension(50, 25));
        lab_2_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel2.add(lab_2_stint_1);

        lab_2_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_2_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_2_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_2_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_2_stint_2.setMinimumSize(new java.awt.Dimension(50, 25));
        lab_2_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel2.add(lab_2_stint_2);

        lab_2_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_2_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_2_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_2_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_2_stint_3.setMinimumSize(new java.awt.Dimension(50, 25));
        lab_2_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel2.add(lab_2_stint_3);

        lab_2_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_2_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_2_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_2_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_2_stint_4.setMinimumSize(new java.awt.Dimension(50, 25));
        lab_2_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel2.add(lab_2_stint_4);

        lab_2_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_2_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_2_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_2_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_2_stint_5.setMinimumSize(new java.awt.Dimension(50, 25));
        lab_2_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel2.add(lab_2_stint_5);

        lab_2_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_2_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_2_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_2_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_2_stint_6.setMinimumSize(new java.awt.Dimension(50, 25));
        lab_2_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel2.add(lab_2_stint_6);

        lab_2_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_2_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_2_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_2_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_2_stint_7.setMinimumSize(new java.awt.Dimension(50, 25));
        lab_2_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel2.add(lab_2_stint_7);

        lab_2_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_2_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_2_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_2_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_2_stint_8.setMinimumSize(new java.awt.Dimension(50, 25));
        lab_2_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel2.add(lab_2_stint_8);

        panelTiming.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 70, 1210, 27));

        panel3.setBackground(new java.awt.Color(19, 19, 19));
        panel3.setLayout(new javax.swing.BoxLayout(panel3, javax.swing.BoxLayout.LINE_AXIS));

        labPos3.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos3.setForeground(new java.awt.Color(255, 255, 255));
        labPos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos3.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos3.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos3.setPreferredSize(new java.awt.Dimension(20, 17));
        panel3.add(labPos3);

        labPen3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen3.setForeground(new java.awt.Color(255, 255, 255));
        labPen3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen3.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen3.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labPen3);

        labCol3.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol3.setForeground(new java.awt.Color(255, 255, 255));
        labCol3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol3.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol3.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labCol3);

        labNum3.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum3.setForeground(new java.awt.Color(255, 255, 255));
        labNum3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum3.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum3.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labNum3);

        labName3.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName3.setForeground(new java.awt.Color(255, 255, 255));
        labName3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName3.setMaximumSize(new java.awt.Dimension(200, 17));
        labName3.setMinimumSize(new java.awt.Dimension(20, 17));
        labName3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labName3);

        labStops3.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops3.setForeground(new java.awt.Color(255, 255, 0));
        labStops3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops3.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops3.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labStops3);

        lab_3_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_3_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_3_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_3_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_3_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_3_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel3.add(lab_3_stint_1);

        lab_3_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_3_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_3_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_3_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_3_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_3_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel3.add(lab_3_stint_2);

        lab_3_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_3_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_3_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_3_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_3_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_3_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel3.add(lab_3_stint_3);

        lab_3_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_3_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_3_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_3_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_3_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_3_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel3.add(lab_3_stint_4);

        lab_3_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_3_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_3_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_3_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_3_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_3_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel3.add(lab_3_stint_5);

        lab_3_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_3_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_3_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_3_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_3_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_3_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel3.add(lab_3_stint_6);

        lab_3_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_3_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_3_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_3_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_3_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_3_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel3.add(lab_3_stint_7);

        lab_3_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_3_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_3_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_3_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_3_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_3_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel3.add(lab_3_stint_8);

        panelTiming.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 97, 1210, 27));

        panel4.setBackground(new java.awt.Color(25, 25, 25));
        panel4.setLayout(new javax.swing.BoxLayout(panel4, javax.swing.BoxLayout.LINE_AXIS));

        labPos4.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos4.setForeground(new java.awt.Color(255, 255, 255));
        labPos4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos4.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos4.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos4.setPreferredSize(new java.awt.Dimension(20, 17));
        panel4.add(labPos4);

        labPen4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen4.setForeground(new java.awt.Color(255, 255, 255));
        labPen4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen4.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen4.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labPen4);

        labCol4.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol4.setForeground(new java.awt.Color(255, 255, 255));
        labCol4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol4.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol4.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labCol4);

        labNum4.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum4.setForeground(new java.awt.Color(255, 255, 255));
        labNum4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum4.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum4.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labNum4);

        labName4.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName4.setForeground(new java.awt.Color(255, 255, 255));
        labName4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName4.setMaximumSize(new java.awt.Dimension(200, 17));
        labName4.setMinimumSize(new java.awt.Dimension(20, 17));
        labName4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labName4);

        labStops4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops4.setForeground(new java.awt.Color(255, 255, 0));
        labStops4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops4.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops4.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labStops4);

        lab_4_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_4_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_4_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_4_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_4_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_4_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel4.add(lab_4_stint_1);

        lab_4_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_4_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_4_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_4_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_4_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_4_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel4.add(lab_4_stint_2);

        lab_4_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_4_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_4_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_4_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_4_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_4_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel4.add(lab_4_stint_3);

        lab_4_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_4_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_4_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_4_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_4_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_4_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel4.add(lab_4_stint_4);

        lab_4_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_4_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_4_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_4_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_4_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_4_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel4.add(lab_4_stint_5);

        lab_4_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_4_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_4_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_4_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_4_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_4_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel4.add(lab_4_stint_6);

        lab_4_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_4_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_4_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_4_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_4_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_4_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel4.add(lab_4_stint_7);

        lab_4_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_4_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_4_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_4_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_4_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_4_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel4.add(lab_4_stint_8);

        panelTiming.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 124, 1210, 27));

        panel5.setBackground(new java.awt.Color(19, 19, 19));
        panel5.setLayout(new javax.swing.BoxLayout(panel5, javax.swing.BoxLayout.LINE_AXIS));

        labPos5.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos5.setForeground(new java.awt.Color(255, 255, 255));
        labPos5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos5.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos5.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos5.setPreferredSize(new java.awt.Dimension(20, 17));
        panel5.add(labPos5);

        labPen5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen5.setForeground(new java.awt.Color(255, 255, 255));
        labPen5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen5.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen5.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labPen5);

        labCol5.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol5.setForeground(new java.awt.Color(255, 255, 255));
        labCol5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol5.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol5.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labCol5);

        labNum5.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum5.setForeground(new java.awt.Color(255, 255, 255));
        labNum5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum5.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum5.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labNum5);

        labName5.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName5.setForeground(new java.awt.Color(255, 255, 255));
        labName5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName5.setMaximumSize(new java.awt.Dimension(200, 17));
        labName5.setMinimumSize(new java.awt.Dimension(20, 17));
        labName5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labName5);

        labStops5.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops5.setForeground(new java.awt.Color(255, 255, 0));
        labStops5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops5.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops5.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labStops5);

        lab_5_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_5_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_5_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_5_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_5_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_5_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel5.add(lab_5_stint_1);

        lab_5_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_5_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_5_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_5_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_5_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_5_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel5.add(lab_5_stint_2);

        lab_5_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_5_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_5_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_5_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_5_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_5_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel5.add(lab_5_stint_3);

        lab_5_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_5_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_5_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_5_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_5_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_5_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel5.add(lab_5_stint_4);

        lab_5_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_5_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_5_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_5_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_5_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_5_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel5.add(lab_5_stint_5);

        lab_5_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_5_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_5_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_5_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_5_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_5_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel5.add(lab_5_stint_6);

        lab_5_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_5_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_5_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_5_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_5_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_5_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel5.add(lab_5_stint_7);

        lab_5_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_5_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_5_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_5_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_5_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_5_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel5.add(lab_5_stint_8);

        panelTiming.add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 151, 1210, 27));

        panel6.setBackground(new java.awt.Color(25, 25, 25));
        panel6.setLayout(new javax.swing.BoxLayout(panel6, javax.swing.BoxLayout.LINE_AXIS));

        labPos6.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos6.setForeground(new java.awt.Color(255, 255, 255));
        labPos6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos6.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos6.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos6.setPreferredSize(new java.awt.Dimension(20, 17));
        panel6.add(labPos6);

        labPen6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen6.setForeground(new java.awt.Color(255, 255, 255));
        labPen6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen6.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen6.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labPen6);

        labCol6.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol6.setForeground(new java.awt.Color(255, 255, 255));
        labCol6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol6.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol6.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labCol6);

        labNum6.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum6.setForeground(new java.awt.Color(255, 255, 255));
        labNum6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum6.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum6.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labNum6);

        labName6.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName6.setForeground(new java.awt.Color(255, 255, 255));
        labName6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName6.setMaximumSize(new java.awt.Dimension(200, 17));
        labName6.setMinimumSize(new java.awt.Dimension(20, 17));
        labName6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labName6);

        labStops6.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops6.setForeground(new java.awt.Color(255, 255, 0));
        labStops6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops6.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops6.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labStops6);

        lab_6_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_6_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_6_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_6_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_6_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_6_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel6.add(lab_6_stint_1);

        lab_6_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_6_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_6_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_6_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_6_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_6_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel6.add(lab_6_stint_2);

        lab_6_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_6_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_6_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_6_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_6_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_6_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel6.add(lab_6_stint_3);

        lab_6_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_6_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_6_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_6_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_6_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_6_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel6.add(lab_6_stint_4);

        lab_6_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_6_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_6_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_6_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_6_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_6_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel6.add(lab_6_stint_5);

        lab_6_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_6_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_6_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_6_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_6_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_6_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel6.add(lab_6_stint_6);

        lab_6_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_6_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_6_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_6_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_6_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_6_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel6.add(lab_6_stint_7);

        lab_6_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_6_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_6_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_6_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_6_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_6_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel6.add(lab_6_stint_8);

        panelTiming.add(panel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 178, 1210, 27));

        panel7.setBackground(new java.awt.Color(19, 19, 19));
        panel7.setLayout(new javax.swing.BoxLayout(panel7, javax.swing.BoxLayout.LINE_AXIS));

        labPos7.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos7.setForeground(new java.awt.Color(255, 255, 255));
        labPos7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos7.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos7.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos7.setPreferredSize(new java.awt.Dimension(20, 17));
        panel7.add(labPos7);

        labPen7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen7.setForeground(new java.awt.Color(255, 255, 255));
        labPen7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen7.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen7.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labPen7);

        labCol7.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol7.setForeground(new java.awt.Color(255, 255, 255));
        labCol7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol7.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol7.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labCol7);

        labNum7.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum7.setForeground(new java.awt.Color(255, 255, 255));
        labNum7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum7.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum7.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labNum7);

        labName7.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName7.setForeground(new java.awt.Color(255, 255, 255));
        labName7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName7.setMaximumSize(new java.awt.Dimension(200, 17));
        labName7.setMinimumSize(new java.awt.Dimension(20, 17));
        labName7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labName7);

        labStops7.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops7.setForeground(new java.awt.Color(255, 255, 0));
        labStops7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops7.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops7.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labStops7);

        lab_7_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_7_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_7_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_7_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_7_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_7_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel7.add(lab_7_stint_1);

        lab_7_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_7_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_7_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_7_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_7_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_7_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel7.add(lab_7_stint_2);

        lab_7_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_7_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_7_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_7_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_7_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_7_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel7.add(lab_7_stint_3);

        lab_7_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_7_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_7_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_7_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_7_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_7_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel7.add(lab_7_stint_4);

        lab_7_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_7_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_7_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_7_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_7_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_7_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel7.add(lab_7_stint_5);

        lab_7_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_7_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_7_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_7_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_7_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_7_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel7.add(lab_7_stint_6);

        lab_7_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_7_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_7_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_7_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_7_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_7_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel7.add(lab_7_stint_7);

        lab_7_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_7_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_7_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_7_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_7_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_7_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel7.add(lab_7_stint_8);

        panelTiming.add(panel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 205, 1210, 27));

        panel8.setBackground(new java.awt.Color(25, 25, 25));
        panel8.setLayout(new javax.swing.BoxLayout(panel8, javax.swing.BoxLayout.LINE_AXIS));

        labPos8.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos8.setForeground(new java.awt.Color(255, 255, 255));
        labPos8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos8.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos8.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos8.setPreferredSize(new java.awt.Dimension(20, 17));
        panel8.add(labPos8);

        labPen8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen8.setForeground(new java.awt.Color(255, 255, 255));
        labPen8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen8.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen8.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labPen8);

        labCol8.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol8.setForeground(new java.awt.Color(255, 255, 255));
        labCol8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol8.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol8.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labCol8);

        labNum8.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum8.setForeground(new java.awt.Color(255, 255, 255));
        labNum8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum8.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum8.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labNum8);

        labName8.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName8.setForeground(new java.awt.Color(255, 255, 255));
        labName8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName8.setMaximumSize(new java.awt.Dimension(200, 17));
        labName8.setMinimumSize(new java.awt.Dimension(20, 17));
        labName8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labName8);

        labStops8.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops8.setForeground(new java.awt.Color(255, 255, 0));
        labStops8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops8.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops8.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labStops8);

        lab_8_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_8_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_8_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_8_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_8_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_8_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel8.add(lab_8_stint_1);

        lab_8_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_8_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_8_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_8_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_8_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_8_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel8.add(lab_8_stint_2);

        lab_8_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_8_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_8_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_8_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_8_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_8_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel8.add(lab_8_stint_3);

        lab_8_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_8_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_8_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_8_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_8_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_8_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel8.add(lab_8_stint_4);

        lab_8_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_8_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_8_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_8_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_8_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_8_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel8.add(lab_8_stint_5);

        lab_8_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_8_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_8_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_8_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_8_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_8_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel8.add(lab_8_stint_6);

        lab_8_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_8_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_8_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_8_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_8_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_8_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel8.add(lab_8_stint_7);

        lab_8_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_8_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_8_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_8_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_8_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_8_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel8.add(lab_8_stint_8);

        panelTiming.add(panel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 232, 1210, 27));

        panel9.setBackground(new java.awt.Color(19, 19, 19));
        panel9.setLayout(new javax.swing.BoxLayout(panel9, javax.swing.BoxLayout.LINE_AXIS));

        labPos9.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos9.setForeground(new java.awt.Color(255, 255, 255));
        labPos9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos9.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos9.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos9.setPreferredSize(new java.awt.Dimension(20, 17));
        panel9.add(labPos9);

        labPen9.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen9.setForeground(new java.awt.Color(255, 255, 255));
        labPen9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen9.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen9.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labPen9);

        labCol9.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol9.setForeground(new java.awt.Color(255, 255, 255));
        labCol9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol9.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol9.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labCol9);

        labNum9.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum9.setForeground(new java.awt.Color(255, 255, 255));
        labNum9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum9.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum9.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labNum9);

        labName9.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName9.setForeground(new java.awt.Color(255, 255, 255));
        labName9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName9.setMaximumSize(new java.awt.Dimension(200, 17));
        labName9.setMinimumSize(new java.awt.Dimension(20, 17));
        labName9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labName9);

        labStops9.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops9.setForeground(new java.awt.Color(255, 255, 0));
        labStops9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops9.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops9.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labStops9);

        lab_9_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_9_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_9_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_9_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_9_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_9_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel9.add(lab_9_stint_1);

        lab_9_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_9_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_9_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_9_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_9_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_9_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel9.add(lab_9_stint_2);

        lab_9_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_9_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_9_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_9_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_9_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_9_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel9.add(lab_9_stint_3);

        lab_9_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_9_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_9_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_9_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_9_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_9_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel9.add(lab_9_stint_4);

        lab_9_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_9_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_9_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_9_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_9_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_9_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel9.add(lab_9_stint_5);

        lab_9_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_9_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_9_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_9_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_9_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_9_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel9.add(lab_9_stint_6);

        lab_9_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_9_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_9_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_9_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_9_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_9_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel9.add(lab_9_stint_7);

        lab_9_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_9_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_9_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_9_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_9_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_9_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel9.add(lab_9_stint_8);

        panelTiming.add(panel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 259, 1210, 27));

        panel10.setBackground(new java.awt.Color(25, 25, 25));
        panel10.setLayout(new javax.swing.BoxLayout(panel10, javax.swing.BoxLayout.LINE_AXIS));

        labPos10.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos10.setForeground(new java.awt.Color(255, 255, 255));
        labPos10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos10.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos10.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos10.setPreferredSize(new java.awt.Dimension(20, 17));
        panel10.add(labPos10);

        labPen10.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen10.setForeground(new java.awt.Color(255, 255, 255));
        labPen10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen10.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen10.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labPen10);

        labCol10.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol10.setForeground(new java.awt.Color(255, 255, 255));
        labCol10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol10.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol10.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labCol10);

        labNum10.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum10.setForeground(new java.awt.Color(255, 255, 255));
        labNum10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum10.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum10.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labNum10);

        labName10.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName10.setForeground(new java.awt.Color(255, 255, 255));
        labName10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName10.setMaximumSize(new java.awt.Dimension(200, 17));
        labName10.setMinimumSize(new java.awt.Dimension(20, 17));
        labName10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labName10);

        labStops10.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops10.setForeground(new java.awt.Color(255, 255, 0));
        labStops10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops10.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops10.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labStops10);

        lab_10_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_10_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_10_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_10_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_10_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_10_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel10.add(lab_10_stint_1);

        lab_10_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_10_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_10_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_10_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_10_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_10_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel10.add(lab_10_stint_2);

        lab_10_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_10_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_10_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_10_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_10_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_10_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel10.add(lab_10_stint_3);

        lab_10_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_10_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_10_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_10_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_10_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_10_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel10.add(lab_10_stint_4);

        lab_10_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_10_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_10_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_10_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_10_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_10_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel10.add(lab_10_stint_5);

        lab_10_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_10_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_10_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_10_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_10_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_10_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel10.add(lab_10_stint_6);

        lab_10_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_10_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_10_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_10_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_10_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_10_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel10.add(lab_10_stint_7);

        lab_10_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_10_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_10_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_10_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_10_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_10_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel10.add(lab_10_stint_8);

        panelTiming.add(panel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 286, 1210, 27));

        panel11.setBackground(new java.awt.Color(19, 19, 19));
        panel11.setLayout(new javax.swing.BoxLayout(panel11, javax.swing.BoxLayout.LINE_AXIS));

        labPos11.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos11.setForeground(new java.awt.Color(255, 255, 255));
        labPos11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos11.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos11.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos11.setPreferredSize(new java.awt.Dimension(20, 17));
        panel11.add(labPos11);

        labPen11.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen11.setForeground(new java.awt.Color(255, 255, 255));
        labPen11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen11.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen11.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labPen11);

        labCol11.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol11.setForeground(new java.awt.Color(255, 255, 255));
        labCol11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol11.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol11.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labCol11);

        labNum11.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum11.setForeground(new java.awt.Color(255, 255, 255));
        labNum11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum11.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum11.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labNum11);

        labName11.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName11.setForeground(new java.awt.Color(255, 255, 255));
        labName11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName11.setMaximumSize(new java.awt.Dimension(200, 17));
        labName11.setMinimumSize(new java.awt.Dimension(20, 17));
        labName11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labName11);

        labStops11.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops11.setForeground(new java.awt.Color(255, 255, 0));
        labStops11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops11.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops11.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labStops11);

        lab_11_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_11_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_11_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_11_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_11_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_11_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel11.add(lab_11_stint_1);

        lab_11_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_11_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_11_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_11_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_11_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_11_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel11.add(lab_11_stint_2);

        lab_11_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_11_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_11_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_11_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_11_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_11_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel11.add(lab_11_stint_3);

        lab_11_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_11_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_11_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_11_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_11_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_11_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel11.add(lab_11_stint_4);

        lab_11_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_11_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_11_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_11_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_11_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_11_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel11.add(lab_11_stint_5);

        lab_11_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_11_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_11_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_11_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_11_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_11_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel11.add(lab_11_stint_6);

        lab_11_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_11_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_11_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_11_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_11_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_11_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel11.add(lab_11_stint_7);

        lab_11_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_11_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_11_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_11_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_11_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_11_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel11.add(lab_11_stint_8);

        panelTiming.add(panel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 313, 1210, 27));

        panel12.setBackground(new java.awt.Color(25, 25, 25));
        panel12.setLayout(new javax.swing.BoxLayout(panel12, javax.swing.BoxLayout.LINE_AXIS));

        labPos12.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos12.setForeground(new java.awt.Color(255, 255, 255));
        labPos12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos12.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos12.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos12.setPreferredSize(new java.awt.Dimension(20, 17));
        panel12.add(labPos12);

        labPen12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen12.setForeground(new java.awt.Color(255, 255, 255));
        labPen12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen12.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen12.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labPen12);

        labCol12.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol12.setForeground(new java.awt.Color(255, 255, 255));
        labCol12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol12.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol12.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labCol12);

        labNum12.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum12.setForeground(new java.awt.Color(255, 255, 255));
        labNum12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum12.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum12.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labNum12);

        labName12.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName12.setForeground(new java.awt.Color(255, 255, 255));
        labName12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName12.setMaximumSize(new java.awt.Dimension(200, 17));
        labName12.setMinimumSize(new java.awt.Dimension(20, 17));
        labName12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labName12);

        labStops12.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops12.setForeground(new java.awt.Color(255, 255, 0));
        labStops12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops12.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops12.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labStops12);

        lab_12_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_12_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_12_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_12_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_12_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_12_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel12.add(lab_12_stint_1);

        lab_12_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_12_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_12_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_12_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_12_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_12_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel12.add(lab_12_stint_2);

        lab_12_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_12_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_12_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_12_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_12_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_12_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel12.add(lab_12_stint_3);

        lab_12_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_12_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_12_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_12_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_12_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_12_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel12.add(lab_12_stint_4);

        lab_12_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_12_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_12_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_12_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_12_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_12_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel12.add(lab_12_stint_5);

        lab_12_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_12_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_12_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_12_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_12_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_12_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel12.add(lab_12_stint_6);

        lab_12_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_12_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_12_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_12_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_12_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_12_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel12.add(lab_12_stint_7);

        lab_12_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_12_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_12_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_12_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_12_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_12_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel12.add(lab_12_stint_8);

        panelTiming.add(panel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 340, 1210, 27));

        panel13.setBackground(new java.awt.Color(19, 19, 19));
        panel13.setLayout(new javax.swing.BoxLayout(panel13, javax.swing.BoxLayout.LINE_AXIS));

        labPos13.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos13.setForeground(new java.awt.Color(255, 255, 255));
        labPos13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos13.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos13.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos13.setPreferredSize(new java.awt.Dimension(20, 17));
        panel13.add(labPos13);

        labPen13.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen13.setForeground(new java.awt.Color(255, 255, 255));
        labPen13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen13.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen13.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labPen13);

        labCol13.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol13.setForeground(new java.awt.Color(255, 255, 255));
        labCol13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol13.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol13.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labCol13);

        labNum13.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum13.setForeground(new java.awt.Color(255, 255, 255));
        labNum13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum13.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum13.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labNum13);

        labName13.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName13.setForeground(new java.awt.Color(255, 255, 255));
        labName13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName13.setMaximumSize(new java.awt.Dimension(200, 17));
        labName13.setMinimumSize(new java.awt.Dimension(20, 17));
        labName13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labName13);

        labStops13.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops13.setForeground(new java.awt.Color(255, 255, 0));
        labStops13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops13.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops13.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labStops13);

        lab_13_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_13_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_13_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_13_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_13_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_13_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel13.add(lab_13_stint_1);

        lab_13_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_13_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_13_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_13_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_13_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_13_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel13.add(lab_13_stint_2);

        lab_13_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_13_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_13_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_13_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_13_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_13_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel13.add(lab_13_stint_3);

        lab_13_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_13_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_13_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_13_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_13_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_13_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel13.add(lab_13_stint_4);

        lab_13_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_13_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_13_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_13_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_13_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_13_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel13.add(lab_13_stint_5);

        lab_13_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_13_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_13_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_13_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_13_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_13_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel13.add(lab_13_stint_6);

        lab_13_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_13_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_13_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_13_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_13_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_13_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel13.add(lab_13_stint_7);

        lab_13_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_13_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_13_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_13_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_13_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_13_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel13.add(lab_13_stint_8);

        panelTiming.add(panel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 367, 1210, 27));

        panel14.setBackground(new java.awt.Color(25, 25, 25));
        panel14.setLayout(new javax.swing.BoxLayout(panel14, javax.swing.BoxLayout.LINE_AXIS));

        labPos14.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos14.setForeground(new java.awt.Color(255, 255, 255));
        labPos14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos14.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos14.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos14.setPreferredSize(new java.awt.Dimension(20, 17));
        panel14.add(labPos14);

        labPen14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen14.setForeground(new java.awt.Color(255, 255, 255));
        labPen14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen14.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen14.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labPen14);

        labCol14.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol14.setForeground(new java.awt.Color(255, 255, 255));
        labCol14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol14.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol14.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labCol14);

        labNum14.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum14.setForeground(new java.awt.Color(255, 255, 255));
        labNum14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum14.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum14.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labNum14);

        labName14.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName14.setForeground(new java.awt.Color(255, 255, 255));
        labName14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName14.setMaximumSize(new java.awt.Dimension(200, 17));
        labName14.setMinimumSize(new java.awt.Dimension(20, 17));
        labName14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labName14);

        labStops14.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops14.setForeground(new java.awt.Color(255, 255, 0));
        labStops14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops14.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops14.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labStops14);

        lab_14_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_14_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_14_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_14_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_14_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_14_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel14.add(lab_14_stint_1);

        lab_14_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_14_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_14_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_14_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_14_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_14_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel14.add(lab_14_stint_2);

        lab_14_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_14_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_14_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_14_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_14_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_14_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel14.add(lab_14_stint_3);

        lab_14_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_14_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_14_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_14_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_14_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_14_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel14.add(lab_14_stint_4);

        lab_14_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_14_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_14_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_14_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_14_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_14_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel14.add(lab_14_stint_5);

        lab_14_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_14_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_14_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_14_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_14_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_14_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel14.add(lab_14_stint_6);

        lab_14_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_14_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_14_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_14_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_14_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_14_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel14.add(lab_14_stint_7);

        lab_14_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_14_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_14_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_14_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_14_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_14_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel14.add(lab_14_stint_8);

        panelTiming.add(panel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 394, 1210, 27));

        panel15.setBackground(new java.awt.Color(19, 19, 19));
        panel15.setLayout(new javax.swing.BoxLayout(panel15, javax.swing.BoxLayout.LINE_AXIS));

        labPos15.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos15.setForeground(new java.awt.Color(255, 255, 255));
        labPos15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos15.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos15.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos15.setPreferredSize(new java.awt.Dimension(20, 17));
        panel15.add(labPos15);

        labPen15.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen15.setForeground(new java.awt.Color(255, 255, 255));
        labPen15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen15.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen15.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labPen15);

        labCol15.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol15.setForeground(new java.awt.Color(255, 255, 255));
        labCol15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol15.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol15.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labCol15);

        labNum15.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum15.setForeground(new java.awt.Color(255, 255, 255));
        labNum15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum15.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum15.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labNum15);

        labName15.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName15.setForeground(new java.awt.Color(255, 255, 255));
        labName15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName15.setMaximumSize(new java.awt.Dimension(200, 17));
        labName15.setMinimumSize(new java.awt.Dimension(20, 17));
        labName15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labName15);

        labStops15.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops15.setForeground(new java.awt.Color(255, 255, 0));
        labStops15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops15.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops15.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labStops15);

        lab_15_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_15_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_15_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_15_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_15_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_15_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel15.add(lab_15_stint_1);

        lab_15_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_15_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_15_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_15_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_15_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_15_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel15.add(lab_15_stint_2);

        lab_15_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_15_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_15_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_15_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_15_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_15_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel15.add(lab_15_stint_3);

        lab_15_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_15_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_15_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_15_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_15_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_15_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel15.add(lab_15_stint_4);

        lab_15_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_15_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_15_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_15_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_15_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_15_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel15.add(lab_15_stint_5);

        lab_15_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_15_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_15_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_15_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_15_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_15_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel15.add(lab_15_stint_6);

        lab_15_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_15_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_15_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_15_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_15_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_15_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel15.add(lab_15_stint_7);

        lab_15_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_15_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_15_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_15_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_15_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_15_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel15.add(lab_15_stint_8);

        panelTiming.add(panel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 421, 1210, 27));

        panel16.setBackground(new java.awt.Color(25, 25, 25));
        panel16.setLayout(new javax.swing.BoxLayout(panel16, javax.swing.BoxLayout.LINE_AXIS));

        labPos16.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos16.setForeground(new java.awt.Color(255, 255, 255));
        labPos16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos16.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos16.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos16.setPreferredSize(new java.awt.Dimension(20, 17));
        panel16.add(labPos16);

        labPen16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen16.setForeground(new java.awt.Color(255, 255, 255));
        labPen16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen16.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen16.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labPen16);

        labCol16.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol16.setForeground(new java.awt.Color(255, 255, 255));
        labCol16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol16.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol16.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labCol16);

        labNum16.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum16.setForeground(new java.awt.Color(255, 255, 255));
        labNum16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum16.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum16.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labNum16);

        labName16.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName16.setForeground(new java.awt.Color(255, 255, 255));
        labName16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName16.setMaximumSize(new java.awt.Dimension(200, 17));
        labName16.setMinimumSize(new java.awt.Dimension(20, 17));
        labName16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labName16);

        labStops16.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops16.setForeground(new java.awt.Color(255, 255, 0));
        labStops16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops16.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops16.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labStops16);

        lab_16_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_16_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_16_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_16_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_16_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_16_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel16.add(lab_16_stint_1);

        lab_16_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_16_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_16_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_16_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_16_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_16_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel16.add(lab_16_stint_2);

        lab_16_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_16_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_16_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_16_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_16_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_16_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel16.add(lab_16_stint_3);

        lab_16_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_16_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_16_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_16_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_16_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_16_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel16.add(lab_16_stint_4);

        lab_16_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_16_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_16_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_16_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_16_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_16_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel16.add(lab_16_stint_5);

        lab_16_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_16_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_16_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_16_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_16_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_16_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel16.add(lab_16_stint_6);

        lab_16_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_16_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_16_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_16_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_16_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_16_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel16.add(lab_16_stint_7);

        lab_16_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_16_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_16_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_16_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_16_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_16_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel16.add(lab_16_stint_8);

        panelTiming.add(panel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 448, 1210, 27));

        panel17.setBackground(new java.awt.Color(19, 19, 19));
        panel17.setLayout(new javax.swing.BoxLayout(panel17, javax.swing.BoxLayout.LINE_AXIS));

        labPos17.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos17.setForeground(new java.awt.Color(255, 255, 255));
        labPos17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos17.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos17.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos17.setPreferredSize(new java.awt.Dimension(20, 17));
        panel17.add(labPos17);

        labPen17.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen17.setForeground(new java.awt.Color(255, 255, 255));
        labPen17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen17.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen17.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labPen17);

        labCol17.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol17.setForeground(new java.awt.Color(255, 255, 255));
        labCol17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol17.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol17.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labCol17);

        labNum17.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum17.setForeground(new java.awt.Color(255, 255, 255));
        labNum17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum17.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum17.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labNum17);

        labName17.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName17.setForeground(new java.awt.Color(255, 255, 255));
        labName17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName17.setMaximumSize(new java.awt.Dimension(200, 17));
        labName17.setMinimumSize(new java.awt.Dimension(20, 17));
        labName17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labName17);

        labStops17.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops17.setForeground(new java.awt.Color(255, 255, 0));
        labStops17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops17.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops17.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labStops17);

        lab_17_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_17_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_17_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_17_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_17_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_17_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel17.add(lab_17_stint_1);

        lab_17_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_17_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_17_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_17_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_17_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_17_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel17.add(lab_17_stint_2);

        lab_17_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_17_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_17_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_17_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_17_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_17_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel17.add(lab_17_stint_3);

        lab_17_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_17_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_17_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_17_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_17_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_17_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel17.add(lab_17_stint_4);

        lab_17_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_17_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_17_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_17_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_17_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_17_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel17.add(lab_17_stint_5);

        lab_17_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_17_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_17_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_17_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_17_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_17_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel17.add(lab_17_stint_6);

        lab_17_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_17_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_17_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_17_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_17_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_17_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel17.add(lab_17_stint_7);

        lab_17_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_17_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_17_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_17_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_17_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_17_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel17.add(lab_17_stint_8);

        panelTiming.add(panel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 475, 1210, 27));

        panel18.setBackground(new java.awt.Color(25, 25, 25));
        panel18.setLayout(new javax.swing.BoxLayout(panel18, javax.swing.BoxLayout.LINE_AXIS));

        labPos18.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos18.setForeground(new java.awt.Color(255, 255, 255));
        labPos18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos18.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos18.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos18.setPreferredSize(new java.awt.Dimension(20, 17));
        panel18.add(labPos18);

        labPen18.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen18.setForeground(new java.awt.Color(255, 255, 255));
        labPen18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen18.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen18.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labPen18);

        labCol18.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol18.setForeground(new java.awt.Color(255, 255, 255));
        labCol18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol18.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol18.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labCol18);

        labNum18.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum18.setForeground(new java.awt.Color(255, 255, 255));
        labNum18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum18.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum18.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labNum18);

        labName18.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName18.setForeground(new java.awt.Color(255, 255, 255));
        labName18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName18.setMaximumSize(new java.awt.Dimension(200, 17));
        labName18.setMinimumSize(new java.awt.Dimension(20, 17));
        labName18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labName18);

        labStops18.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops18.setForeground(new java.awt.Color(255, 255, 0));
        labStops18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops18.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops18.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labStops18);

        lab_18_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_18_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_18_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_18_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_18_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_18_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel18.add(lab_18_stint_1);

        lab_18_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_18_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_18_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_18_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_18_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_18_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel18.add(lab_18_stint_2);

        lab_18_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_18_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_18_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_18_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_18_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_18_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel18.add(lab_18_stint_3);

        lab_18_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_18_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_18_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_18_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_18_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_18_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel18.add(lab_18_stint_4);

        lab_18_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_18_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_18_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_18_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_18_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_18_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel18.add(lab_18_stint_5);

        lab_18_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_18_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_18_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_18_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_18_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_18_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel18.add(lab_18_stint_6);

        lab_18_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_18_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_18_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_18_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_18_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_18_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel18.add(lab_18_stint_7);

        lab_18_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_18_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_18_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_18_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_18_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_18_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel18.add(lab_18_stint_8);

        panelTiming.add(panel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 502, 1210, 27));

        panel19.setBackground(new java.awt.Color(19, 19, 19));
        panel19.setLayout(new javax.swing.BoxLayout(panel19, javax.swing.BoxLayout.LINE_AXIS));

        labPos19.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos19.setForeground(new java.awt.Color(255, 255, 255));
        labPos19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos19.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos19.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos19.setPreferredSize(new java.awt.Dimension(20, 17));
        panel19.add(labPos19);

        labPen19.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen19.setForeground(new java.awt.Color(255, 255, 255));
        labPen19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen19.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen19.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labPen19);

        labCol19.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol19.setForeground(new java.awt.Color(255, 255, 255));
        labCol19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol19.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol19.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labCol19);

        labNum19.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum19.setForeground(new java.awt.Color(255, 255, 255));
        labNum19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum19.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum19.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labNum19);

        labName19.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName19.setForeground(new java.awt.Color(255, 255, 255));
        labName19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName19.setMaximumSize(new java.awt.Dimension(200, 17));
        labName19.setMinimumSize(new java.awt.Dimension(20, 17));
        labName19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labName19);

        labStops19.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops19.setForeground(new java.awt.Color(255, 255, 0));
        labStops19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops19.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops19.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labStops19);

        lab_19_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_19_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_19_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_19_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_19_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_19_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel19.add(lab_19_stint_1);

        lab_19_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_19_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_19_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_19_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_19_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_19_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel19.add(lab_19_stint_2);

        lab_19_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_19_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_19_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_19_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_19_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_19_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel19.add(lab_19_stint_3);

        lab_19_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_19_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_19_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_19_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_19_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_19_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel19.add(lab_19_stint_4);

        lab_19_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_19_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_19_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_19_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_19_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_19_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel19.add(lab_19_stint_5);

        lab_19_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_19_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_19_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_19_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_19_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_19_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel19.add(lab_19_stint_6);

        lab_19_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_19_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_19_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_19_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_19_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_19_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel19.add(lab_19_stint_7);

        lab_19_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_19_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_19_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_19_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_19_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_19_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel19.add(lab_19_stint_8);

        panelTiming.add(panel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 529, 1210, 27));

        panel20.setBackground(new java.awt.Color(25, 25, 25));
        panel20.setLayout(new javax.swing.BoxLayout(panel20, javax.swing.BoxLayout.LINE_AXIS));

        labPos20.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labPos20.setForeground(new java.awt.Color(255, 255, 255));
        labPos20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPos20.setMaximumSize(new java.awt.Dimension(50, 17));
        labPos20.setMinimumSize(new java.awt.Dimension(20, 17));
        labPos20.setPreferredSize(new java.awt.Dimension(20, 17));
        panel20.add(labPos20);

        labPen20.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labPen20.setForeground(new java.awt.Color(255, 255, 255));
        labPen20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPen20.setMaximumSize(new java.awt.Dimension(40, 18));
        labPen20.setMinimumSize(new java.awt.Dimension(20, 17));
        labPen20.setPreferredSize(new java.awt.Dimension(50, 25));
        panel20.add(labPen20);

        labCol20.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        labCol20.setForeground(new java.awt.Color(255, 255, 255));
        labCol20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCol20.setMaximumSize(new java.awt.Dimension(10, 17));
        labCol20.setMinimumSize(new java.awt.Dimension(20, 17));
        labCol20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labCol20);

        labNum20.setFont(new java.awt.Font("Formula1 Display Regular", 2, 14)); // NOI18N
        labNum20.setForeground(new java.awt.Color(255, 255, 255));
        labNum20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNum20.setMaximumSize(new java.awt.Dimension(50, 17));
        labNum20.setMinimumSize(new java.awt.Dimension(20, 17));
        labNum20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labNum20);

        labName20.setFont(new java.awt.Font("Formula1 Display Bold", 1, 14)); // NOI18N
        labName20.setForeground(new java.awt.Color(255, 255, 255));
        labName20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labName20.setMaximumSize(new java.awt.Dimension(200, 17));
        labName20.setMinimumSize(new java.awt.Dimension(20, 17));
        labName20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labName20);

        labStops20.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labStops20.setForeground(new java.awt.Color(255, 255, 0));
        labStops20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labStops20.setMaximumSize(new java.awt.Dimension(50, 25));
        labStops20.setMinimumSize(new java.awt.Dimension(20, 17));
        labStops20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labStops20);

        lab_20_stint_1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_20_stint_1.setForeground(new java.awt.Color(255, 255, 255));
        lab_20_stint_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_20_stint_1.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_20_stint_1.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_20_stint_1.setPreferredSize(new java.awt.Dimension(50, 25));
        panel20.add(lab_20_stint_1);

        lab_20_stint_2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_20_stint_2.setForeground(new java.awt.Color(255, 255, 255));
        lab_20_stint_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_20_stint_2.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_20_stint_2.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_20_stint_2.setPreferredSize(new java.awt.Dimension(50, 25));
        panel20.add(lab_20_stint_2);

        lab_20_stint_3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_20_stint_3.setForeground(new java.awt.Color(255, 255, 255));
        lab_20_stint_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_20_stint_3.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_20_stint_3.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_20_stint_3.setPreferredSize(new java.awt.Dimension(50, 25));
        panel20.add(lab_20_stint_3);

        lab_20_stint_4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_20_stint_4.setForeground(new java.awt.Color(255, 255, 255));
        lab_20_stint_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_20_stint_4.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_20_stint_4.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_20_stint_4.setPreferredSize(new java.awt.Dimension(50, 25));
        panel20.add(lab_20_stint_4);

        lab_20_stint_5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_20_stint_5.setForeground(new java.awt.Color(255, 255, 255));
        lab_20_stint_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_20_stint_5.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_20_stint_5.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_20_stint_5.setPreferredSize(new java.awt.Dimension(50, 25));
        panel20.add(lab_20_stint_5);

        lab_20_stint_6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_20_stint_6.setForeground(new java.awt.Color(255, 255, 255));
        lab_20_stint_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_20_stint_6.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_20_stint_6.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_20_stint_6.setPreferredSize(new java.awt.Dimension(50, 25));
        panel20.add(lab_20_stint_6);

        lab_20_stint_7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_20_stint_7.setForeground(new java.awt.Color(255, 255, 255));
        lab_20_stint_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_20_stint_7.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_20_stint_7.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_20_stint_7.setPreferredSize(new java.awt.Dimension(50, 25));
        panel20.add(lab_20_stint_7);

        lab_20_stint_8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_20_stint_8.setForeground(new java.awt.Color(255, 255, 255));
        lab_20_stint_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_20_stint_8.setMaximumSize(new java.awt.Dimension(100, 25));
        lab_20_stint_8.setMinimumSize(new java.awt.Dimension(20, 25));
        lab_20_stint_8.setPreferredSize(new java.awt.Dimension(50, 25));
        panel20.add(lab_20_stint_8);

        panelTiming.add(panel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 556, 1210, 27));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTiming, javax.swing.GroupLayout.DEFAULT_SIZE, 1228, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTiming, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(thread != null){
            thread.controller.removePaso(thread.paso);
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labBest0;
    private javax.swing.JLabel labBest21;
    private javax.swing.JLabel labCol0;
    private javax.swing.JLabel labCol1;
    private javax.swing.JLabel labCol10;
    private javax.swing.JLabel labCol11;
    private javax.swing.JLabel labCol12;
    private javax.swing.JLabel labCol13;
    private javax.swing.JLabel labCol14;
    private javax.swing.JLabel labCol15;
    private javax.swing.JLabel labCol16;
    private javax.swing.JLabel labCol17;
    private javax.swing.JLabel labCol18;
    private javax.swing.JLabel labCol19;
    private javax.swing.JLabel labCol2;
    private javax.swing.JLabel labCol20;
    private javax.swing.JLabel labCol3;
    private javax.swing.JLabel labCol4;
    private javax.swing.JLabel labCol5;
    private javax.swing.JLabel labCol6;
    private javax.swing.JLabel labCol7;
    private javax.swing.JLabel labCol8;
    private javax.swing.JLabel labCol9;
    private javax.swing.JLabel labDelta0;
    private javax.swing.JLabel labLast0;
    private javax.swing.JLabel labName0;
    private javax.swing.JLabel labName1;
    private javax.swing.JLabel labName10;
    private javax.swing.JLabel labName11;
    private javax.swing.JLabel labName12;
    private javax.swing.JLabel labName13;
    private javax.swing.JLabel labName14;
    private javax.swing.JLabel labName15;
    private javax.swing.JLabel labName16;
    private javax.swing.JLabel labName17;
    private javax.swing.JLabel labName18;
    private javax.swing.JLabel labName19;
    private javax.swing.JLabel labName2;
    private javax.swing.JLabel labName20;
    private javax.swing.JLabel labName3;
    private javax.swing.JLabel labName4;
    private javax.swing.JLabel labName5;
    private javax.swing.JLabel labName6;
    private javax.swing.JLabel labName7;
    private javax.swing.JLabel labName8;
    private javax.swing.JLabel labName9;
    private javax.swing.JLabel labNum;
    private javax.swing.JLabel labNum1;
    private javax.swing.JLabel labNum10;
    private javax.swing.JLabel labNum11;
    private javax.swing.JLabel labNum12;
    private javax.swing.JLabel labNum13;
    private javax.swing.JLabel labNum14;
    private javax.swing.JLabel labNum15;
    private javax.swing.JLabel labNum16;
    private javax.swing.JLabel labNum17;
    private javax.swing.JLabel labNum18;
    private javax.swing.JLabel labNum19;
    private javax.swing.JLabel labNum2;
    private javax.swing.JLabel labNum20;
    private javax.swing.JLabel labNum21;
    private javax.swing.JLabel labNum3;
    private javax.swing.JLabel labNum4;
    private javax.swing.JLabel labNum5;
    private javax.swing.JLabel labNum6;
    private javax.swing.JLabel labNum7;
    private javax.swing.JLabel labNum8;
    private javax.swing.JLabel labNum9;
    private javax.swing.JLabel labPen0;
    private javax.swing.JLabel labPen1;
    private javax.swing.JLabel labPen10;
    private javax.swing.JLabel labPen11;
    private javax.swing.JLabel labPen12;
    private javax.swing.JLabel labPen13;
    private javax.swing.JLabel labPen14;
    private javax.swing.JLabel labPen15;
    private javax.swing.JLabel labPen16;
    private javax.swing.JLabel labPen17;
    private javax.swing.JLabel labPen18;
    private javax.swing.JLabel labPen19;
    private javax.swing.JLabel labPen2;
    private javax.swing.JLabel labPen20;
    private javax.swing.JLabel labPen3;
    private javax.swing.JLabel labPen4;
    private javax.swing.JLabel labPen5;
    private javax.swing.JLabel labPen6;
    private javax.swing.JLabel labPen7;
    private javax.swing.JLabel labPen8;
    private javax.swing.JLabel labPen9;
    private javax.swing.JLabel labPos0;
    private javax.swing.JLabel labPos1;
    private javax.swing.JLabel labPos10;
    private javax.swing.JLabel labPos11;
    private javax.swing.JLabel labPos12;
    private javax.swing.JLabel labPos13;
    private javax.swing.JLabel labPos14;
    private javax.swing.JLabel labPos15;
    private javax.swing.JLabel labPos16;
    private javax.swing.JLabel labPos17;
    private javax.swing.JLabel labPos18;
    private javax.swing.JLabel labPos19;
    private javax.swing.JLabel labPos2;
    private javax.swing.JLabel labPos20;
    private javax.swing.JLabel labPos3;
    private javax.swing.JLabel labPos4;
    private javax.swing.JLabel labPos5;
    private javax.swing.JLabel labPos6;
    private javax.swing.JLabel labPos7;
    private javax.swing.JLabel labPos8;
    private javax.swing.JLabel labPos9;
    private javax.swing.JLabel labS10;
    private javax.swing.JLabel labS20;
    private javax.swing.JLabel labS30;
    private javax.swing.JLabel labStops1;
    private javax.swing.JLabel labStops10;
    private javax.swing.JLabel labStops11;
    private javax.swing.JLabel labStops12;
    private javax.swing.JLabel labStops13;
    private javax.swing.JLabel labStops14;
    private javax.swing.JLabel labStops15;
    private javax.swing.JLabel labStops16;
    private javax.swing.JLabel labStops17;
    private javax.swing.JLabel labStops18;
    private javax.swing.JLabel labStops19;
    private javax.swing.JLabel labStops2;
    private javax.swing.JLabel labStops20;
    private javax.swing.JLabel labStops3;
    private javax.swing.JLabel labStops4;
    private javax.swing.JLabel labStops5;
    private javax.swing.JLabel labStops6;
    private javax.swing.JLabel labStops7;
    private javax.swing.JLabel labStops8;
    private javax.swing.JLabel labStops9;
    private javax.swing.JLabel labTime0;
    private javax.swing.JLabel lab_10_stint_1;
    private javax.swing.JLabel lab_10_stint_2;
    private javax.swing.JLabel lab_10_stint_3;
    private javax.swing.JLabel lab_10_stint_4;
    private javax.swing.JLabel lab_10_stint_5;
    private javax.swing.JLabel lab_10_stint_6;
    private javax.swing.JLabel lab_10_stint_7;
    private javax.swing.JLabel lab_10_stint_8;
    private javax.swing.JLabel lab_11_stint_1;
    private javax.swing.JLabel lab_11_stint_2;
    private javax.swing.JLabel lab_11_stint_3;
    private javax.swing.JLabel lab_11_stint_4;
    private javax.swing.JLabel lab_11_stint_5;
    private javax.swing.JLabel lab_11_stint_6;
    private javax.swing.JLabel lab_11_stint_7;
    private javax.swing.JLabel lab_11_stint_8;
    private javax.swing.JLabel lab_12_stint_1;
    private javax.swing.JLabel lab_12_stint_2;
    private javax.swing.JLabel lab_12_stint_3;
    private javax.swing.JLabel lab_12_stint_4;
    private javax.swing.JLabel lab_12_stint_5;
    private javax.swing.JLabel lab_12_stint_6;
    private javax.swing.JLabel lab_12_stint_7;
    private javax.swing.JLabel lab_12_stint_8;
    private javax.swing.JLabel lab_13_stint_1;
    private javax.swing.JLabel lab_13_stint_2;
    private javax.swing.JLabel lab_13_stint_3;
    private javax.swing.JLabel lab_13_stint_4;
    private javax.swing.JLabel lab_13_stint_5;
    private javax.swing.JLabel lab_13_stint_6;
    private javax.swing.JLabel lab_13_stint_7;
    private javax.swing.JLabel lab_13_stint_8;
    private javax.swing.JLabel lab_14_stint_1;
    private javax.swing.JLabel lab_14_stint_2;
    private javax.swing.JLabel lab_14_stint_3;
    private javax.swing.JLabel lab_14_stint_4;
    private javax.swing.JLabel lab_14_stint_5;
    private javax.swing.JLabel lab_14_stint_6;
    private javax.swing.JLabel lab_14_stint_7;
    private javax.swing.JLabel lab_14_stint_8;
    private javax.swing.JLabel lab_15_stint_1;
    private javax.swing.JLabel lab_15_stint_2;
    private javax.swing.JLabel lab_15_stint_3;
    private javax.swing.JLabel lab_15_stint_4;
    private javax.swing.JLabel lab_15_stint_5;
    private javax.swing.JLabel lab_15_stint_6;
    private javax.swing.JLabel lab_15_stint_7;
    private javax.swing.JLabel lab_15_stint_8;
    private javax.swing.JLabel lab_16_stint_1;
    private javax.swing.JLabel lab_16_stint_2;
    private javax.swing.JLabel lab_16_stint_3;
    private javax.swing.JLabel lab_16_stint_4;
    private javax.swing.JLabel lab_16_stint_5;
    private javax.swing.JLabel lab_16_stint_6;
    private javax.swing.JLabel lab_16_stint_7;
    private javax.swing.JLabel lab_16_stint_8;
    private javax.swing.JLabel lab_17_stint_1;
    private javax.swing.JLabel lab_17_stint_2;
    private javax.swing.JLabel lab_17_stint_3;
    private javax.swing.JLabel lab_17_stint_4;
    private javax.swing.JLabel lab_17_stint_5;
    private javax.swing.JLabel lab_17_stint_6;
    private javax.swing.JLabel lab_17_stint_7;
    private javax.swing.JLabel lab_17_stint_8;
    private javax.swing.JLabel lab_18_stint_1;
    private javax.swing.JLabel lab_18_stint_2;
    private javax.swing.JLabel lab_18_stint_3;
    private javax.swing.JLabel lab_18_stint_4;
    private javax.swing.JLabel lab_18_stint_5;
    private javax.swing.JLabel lab_18_stint_6;
    private javax.swing.JLabel lab_18_stint_7;
    private javax.swing.JLabel lab_18_stint_8;
    private javax.swing.JLabel lab_19_stint_1;
    private javax.swing.JLabel lab_19_stint_2;
    private javax.swing.JLabel lab_19_stint_3;
    private javax.swing.JLabel lab_19_stint_4;
    private javax.swing.JLabel lab_19_stint_5;
    private javax.swing.JLabel lab_19_stint_6;
    private javax.swing.JLabel lab_19_stint_7;
    private javax.swing.JLabel lab_19_stint_8;
    private javax.swing.JLabel lab_1_stint_1;
    private javax.swing.JLabel lab_1_stint_2;
    private javax.swing.JLabel lab_1_stint_3;
    private javax.swing.JLabel lab_1_stint_4;
    private javax.swing.JLabel lab_1_stint_5;
    private javax.swing.JLabel lab_1_stint_6;
    private javax.swing.JLabel lab_1_stint_7;
    private javax.swing.JLabel lab_1_stint_8;
    private javax.swing.JLabel lab_20_stint_1;
    private javax.swing.JLabel lab_20_stint_2;
    private javax.swing.JLabel lab_20_stint_3;
    private javax.swing.JLabel lab_20_stint_4;
    private javax.swing.JLabel lab_20_stint_5;
    private javax.swing.JLabel lab_20_stint_6;
    private javax.swing.JLabel lab_20_stint_7;
    private javax.swing.JLabel lab_20_stint_8;
    private javax.swing.JLabel lab_2_stint_1;
    private javax.swing.JLabel lab_2_stint_2;
    private javax.swing.JLabel lab_2_stint_3;
    private javax.swing.JLabel lab_2_stint_4;
    private javax.swing.JLabel lab_2_stint_5;
    private javax.swing.JLabel lab_2_stint_6;
    private javax.swing.JLabel lab_2_stint_7;
    private javax.swing.JLabel lab_2_stint_8;
    private javax.swing.JLabel lab_3_stint_1;
    private javax.swing.JLabel lab_3_stint_2;
    private javax.swing.JLabel lab_3_stint_3;
    private javax.swing.JLabel lab_3_stint_4;
    private javax.swing.JLabel lab_3_stint_5;
    private javax.swing.JLabel lab_3_stint_6;
    private javax.swing.JLabel lab_3_stint_7;
    private javax.swing.JLabel lab_3_stint_8;
    private javax.swing.JLabel lab_4_stint_1;
    private javax.swing.JLabel lab_4_stint_2;
    private javax.swing.JLabel lab_4_stint_3;
    private javax.swing.JLabel lab_4_stint_4;
    private javax.swing.JLabel lab_4_stint_5;
    private javax.swing.JLabel lab_4_stint_6;
    private javax.swing.JLabel lab_4_stint_7;
    private javax.swing.JLabel lab_4_stint_8;
    private javax.swing.JLabel lab_5_stint_1;
    private javax.swing.JLabel lab_5_stint_2;
    private javax.swing.JLabel lab_5_stint_3;
    private javax.swing.JLabel lab_5_stint_4;
    private javax.swing.JLabel lab_5_stint_5;
    private javax.swing.JLabel lab_5_stint_6;
    private javax.swing.JLabel lab_5_stint_7;
    private javax.swing.JLabel lab_5_stint_8;
    private javax.swing.JLabel lab_6_stint_1;
    private javax.swing.JLabel lab_6_stint_2;
    private javax.swing.JLabel lab_6_stint_3;
    private javax.swing.JLabel lab_6_stint_4;
    private javax.swing.JLabel lab_6_stint_5;
    private javax.swing.JLabel lab_6_stint_6;
    private javax.swing.JLabel lab_6_stint_7;
    private javax.swing.JLabel lab_6_stint_8;
    private javax.swing.JLabel lab_7_stint_1;
    private javax.swing.JLabel lab_7_stint_2;
    private javax.swing.JLabel lab_7_stint_3;
    private javax.swing.JLabel lab_7_stint_4;
    private javax.swing.JLabel lab_7_stint_5;
    private javax.swing.JLabel lab_7_stint_6;
    private javax.swing.JLabel lab_7_stint_7;
    private javax.swing.JLabel lab_7_stint_8;
    private javax.swing.JLabel lab_8_stint_1;
    private javax.swing.JLabel lab_8_stint_2;
    private javax.swing.JLabel lab_8_stint_3;
    private javax.swing.JLabel lab_8_stint_4;
    private javax.swing.JLabel lab_8_stint_5;
    private javax.swing.JLabel lab_8_stint_6;
    private javax.swing.JLabel lab_8_stint_7;
    private javax.swing.JLabel lab_8_stint_8;
    private javax.swing.JLabel lab_9_stint_1;
    private javax.swing.JLabel lab_9_stint_2;
    private javax.swing.JLabel lab_9_stint_3;
    private javax.swing.JLabel lab_9_stint_4;
    private javax.swing.JLabel lab_9_stint_5;
    private javax.swing.JLabel lab_9_stint_6;
    private javax.swing.JLabel lab_9_stint_7;
    private javax.swing.JLabel lab_9_stint_8;
    private javax.swing.JPanel panel0;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel10;
    private javax.swing.JPanel panel11;
    private javax.swing.JPanel panel12;
    private javax.swing.JPanel panel13;
    private javax.swing.JPanel panel14;
    private javax.swing.JPanel panel15;
    private javax.swing.JPanel panel16;
    private javax.swing.JPanel panel17;
    private javax.swing.JPanel panel18;
    private javax.swing.JPanel panel19;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel20;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panel7;
    private javax.swing.JPanel panel8;
    private javax.swing.JPanel panel9;
    public javax.swing.JPanel panelTiming;
    // End of variables declaration//GEN-END:variables
}
