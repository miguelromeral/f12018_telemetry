package gui.livetiming;

import classes.Controller;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author miguelangel.garciar
 */
public class LiveTiming extends javax.swing.JFrame {

    public static String LATEST = "LATEST";
    public static String CURRENT = "CURRENT";
    public static String BEST = "BEST";
    public static String DELTA_1ST = "1ST";
    public static String DELTA_NEXT = "NEXT";
    public static String DELTA_USER = "USER";
    
    LiveTiming_Thread thread;
    String sectorsOption = LATEST;
    String deltaOption = DELTA_1ST;
    ButtonGroup groupOptions;
    ButtonGroup deltaOptions;
    
    
    JLabel[][] labels;
    
    public LiveTiming(Controller controller) {
        initComponents();
        thread = new LiveTiming_Thread(controller, this);
        thread.start();
        
        
        groupOptions = new ButtonGroup();
        groupOptions.add(rbViewBest);
        groupOptions.add(rbViewCurrent);
        groupOptions.add(rbViewLatest);
        deltaOptions = new ButtonGroup();
        deltaOptions.add(rbGap1st);
        deltaOptions.add(rbGapNext);
        deltaOptions.add(rbGapUser);
        
        setPanels();
    }
    
    private void setPanels(){
        labels = new JLabel[20][15];
        setOnePanel(labels[0], labPos1, labCol1, labNum1, labName1, labTime1, labS11, labS21, labS31, labDelta1, labLast1, labBest1, labLap1, labTyre1, labBox1, labPen1);
        setOnePanel(labels[1], labPos2, labCol2, labNum2, labName2, labTime2, labS12, labS22, labS32, labDelta2, labLast2, labBest2, labLap2, labTyre2, labBox2, labPen2);
        setOnePanel(labels[2], labPos3, labCol3, labNum3, labName3, labTime3, labS13, labS23, labS33, labDelta3, labLast3, labBest3, labLap3, labTyre3, labBox3, labPen3);
        setOnePanel(labels[3], labPos4, labCol4, labNum4, labName4, labTime4, labS14, labS24, labS34, labDelta4, labLast4, labBest4, labLap4, labTyre4, labBox4, labPen4);
        setOnePanel(labels[4], labPos5, labCol5, labNum5, labName5, labTime5, labS15, labS25, labS35, labDelta5, labLast5, labBest5, labLap5, labTyre5, labBox5, labPen5);
        setOnePanel(labels[5], labPos6, labCol6, labNum6, labName6, labTime6, labS16, labS26, labS36, labDelta6, labLast6, labBest6, labLap6, labTyre6, labBox6, labPen6);
        setOnePanel(labels[6], labPos7, labCol7, labNum7, labName7, labTime7, labS17, labS27, labS37, labDelta7, labLast7, labBest7, labLap7, labTyre7, labBox7, labPen7);
        setOnePanel(labels[7], labPos8, labCol8, labNum8, labName8, labTime8, labS18, labS28, labS38, labDelta8, labLast8, labBest8, labLap8, labTyre8, labBox8, labPen8);
        setOnePanel(labels[8], labPos9, labCol9, labNum9, labName9, labTime9, labS19, labS29, labS39, labDelta9, labLast9, labBest9, labLap9, labTyre9, labBox9, labPen9);
        setOnePanel(labels[9], labPos10, labCol10, labNum10, labName10, labTime10, labS40, labS41, labS42, labDelta10, labLast10, labBest10, labLap10, labTyre10, labBox10, labPen10);
        setOnePanel(labels[10], labPos11, labCol11, labNum11, labName11, labTime11, labS43, labS44, labS45, labDelta11, labLast11, labBest11, labLap11, labTyre11, labBox11, labPen11);
        setOnePanel(labels[11], labPos12, labCol12, labNum12, labName12, labTime12, labS46, labS47, labS48, labDelta12, labLast12, labBest12, labLap12, labTyre12, labBox12, labPen12);
        setOnePanel(labels[12], labPos13, labCol13, labNum13, labName13, labTime13, labS49, labS50, labS51, labDelta13, labLast13, labBest13, labLap13, labTyre13, labBox13, labPen13);
        setOnePanel(labels[13], labPos14, labCol14, labNum14, labName14, labTime14, labS52, labS53, labS54, labDelta14, labLast14, labBest14, labLap14, labTyre14, labBox14, labPen14);
        setOnePanel(labels[14], labPos15, labCol15, labNum15, labName15, labTime15, labS55, labS56, labS57, labDelta15, labLast15, labBest15, labLap15, labTyre15, labBox15, labPen15);
        setOnePanel(labels[15], labPos16, labCol16, labNum16, labName16, labTime16, labS58, labS59, labS60, labDelta16, labLast16, labBest16, labLap16, labTyre16, labBox16, labPen16);
        setOnePanel(labels[16], labPos17, labCol17, labNum17, labName17, labTime17, labS61, labS62, labS63, labDelta17, labLast17, labBest17, labLap17, labTyre17, labBox17, labPen17);
        setOnePanel(labels[17], labPos18, labCol18, labNum18, labName18, labTime18, labS64, labS65, labS66, labDelta18, labLast18, labBest18, labLap18, labTyre18, labBox18, labPen18);
        setOnePanel(labels[18], labPos19, labCol19, labNum19, labName19, labTime19, labS67, labS68, labS69, labDelta19, labLast19, labBest19, labLap19, labTyre19, labBox19, labPen19);
        setOnePanel(labels[19], labPos20, labCol20, labNum20, labName20, labTime20, labS70, labS71, labS72, labDelta20, labLast20, labBest20, labLap20, labTyre20, labBox20, labPen20);
    }
    
    private void setOnePanel(JLabel[] label, JLabel pos, JLabel col, JLabel num, JLabel name, JLabel time, JLabel s1, JLabel s2, JLabel s3,
            JLabel delta, JLabel last, JLabel best, JLabel lap, JLabel tyre, JLabel pit, JLabel pen){
        label[0] = pos;
        label[1] = col;
        label[2] = num;
        label[3] = name;
        label[4] = time;
        label[5] = s1;
        label[6] = s2;
        label[7] = s3;
        label[8] = delta;
        label[9] = last;
        label[10] = best;
        label[11] = lap;
        label[12] = tyre;
        label[13] = pit;
        label[14] = pen;
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
        panelSession = new javax.swing.JPanel();
        lab_weather = new javax.swing.JLabel();
        space = new javax.swing.JLabel();
        lab_weather_text = new javax.swing.JLabel();
        space1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        space2 = new javax.swing.JLabel();
        lab_trackTemperature = new javax.swing.JLabel();
        space3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        space4 = new javax.swing.JLabel();
        lab_airTemperature = new javax.swing.JLabel();
        space5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lab_bestS1 = new javax.swing.JLabel();
        lab_bestS2 = new javax.swing.JLabel();
        lab_bestS3 = new javax.swing.JLabel();
        lab_bestTotal = new javax.swing.JLabel();
        space6 = new javax.swing.JLabel();
        lab_remaining = new javax.swing.JLabel();
        space7 = new javax.swing.JLabel();
        panelTiming = new javax.swing.JPanel();
        panel0 = new javax.swing.JPanel();
        labPos0 = new javax.swing.JLabel();
        labCol0 = new javax.swing.JLabel();
        labPen0 = new javax.swing.JLabel();
        labNum = new javax.swing.JLabel();
        labName0 = new javax.swing.JLabel();
        labTime0 = new javax.swing.JLabel();
        labS10 = new javax.swing.JLabel();
        labS20 = new javax.swing.JLabel();
        labS30 = new javax.swing.JLabel();
        labDelta0 = new javax.swing.JLabel();
        labLast0 = new javax.swing.JLabel();
        labBest0 = new javax.swing.JLabel();
        labLap0 = new javax.swing.JLabel();
        labTyre0 = new javax.swing.JLabel();
        labPit0 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        labPos1 = new javax.swing.JLabel();
        labPen1 = new javax.swing.JLabel();
        labCol1 = new javax.swing.JLabel();
        labNum1 = new javax.swing.JLabel();
        labName1 = new javax.swing.JLabel();
        labTime1 = new javax.swing.JLabel();
        labS11 = new javax.swing.JLabel();
        labS21 = new javax.swing.JLabel();
        labS31 = new javax.swing.JLabel();
        labDelta1 = new javax.swing.JLabel();
        labLast1 = new javax.swing.JLabel();
        labBest1 = new javax.swing.JLabel();
        labLap1 = new javax.swing.JLabel();
        labTyre1 = new javax.swing.JLabel();
        labBox1 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        labPos2 = new javax.swing.JLabel();
        labPen2 = new javax.swing.JLabel();
        labCol2 = new javax.swing.JLabel();
        labNum2 = new javax.swing.JLabel();
        labName2 = new javax.swing.JLabel();
        labTime2 = new javax.swing.JLabel();
        labS12 = new javax.swing.JLabel();
        labS22 = new javax.swing.JLabel();
        labS32 = new javax.swing.JLabel();
        labDelta2 = new javax.swing.JLabel();
        labLast2 = new javax.swing.JLabel();
        labBest2 = new javax.swing.JLabel();
        labLap2 = new javax.swing.JLabel();
        labTyre2 = new javax.swing.JLabel();
        labBox2 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        labPos3 = new javax.swing.JLabel();
        labPen3 = new javax.swing.JLabel();
        labCol3 = new javax.swing.JLabel();
        labNum3 = new javax.swing.JLabel();
        labName3 = new javax.swing.JLabel();
        labTime3 = new javax.swing.JLabel();
        labS13 = new javax.swing.JLabel();
        labS23 = new javax.swing.JLabel();
        labS33 = new javax.swing.JLabel();
        labDelta3 = new javax.swing.JLabel();
        labLast3 = new javax.swing.JLabel();
        labBest3 = new javax.swing.JLabel();
        labLap3 = new javax.swing.JLabel();
        labTyre3 = new javax.swing.JLabel();
        labBox3 = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        labPos4 = new javax.swing.JLabel();
        labPen4 = new javax.swing.JLabel();
        labCol4 = new javax.swing.JLabel();
        labNum4 = new javax.swing.JLabel();
        labName4 = new javax.swing.JLabel();
        labTime4 = new javax.swing.JLabel();
        labS14 = new javax.swing.JLabel();
        labS24 = new javax.swing.JLabel();
        labS34 = new javax.swing.JLabel();
        labDelta4 = new javax.swing.JLabel();
        labLast4 = new javax.swing.JLabel();
        labBest4 = new javax.swing.JLabel();
        labLap4 = new javax.swing.JLabel();
        labTyre4 = new javax.swing.JLabel();
        labBox4 = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        labPos5 = new javax.swing.JLabel();
        labPen5 = new javax.swing.JLabel();
        labCol5 = new javax.swing.JLabel();
        labNum5 = new javax.swing.JLabel();
        labName5 = new javax.swing.JLabel();
        labTime5 = new javax.swing.JLabel();
        labS15 = new javax.swing.JLabel();
        labS25 = new javax.swing.JLabel();
        labS35 = new javax.swing.JLabel();
        labDelta5 = new javax.swing.JLabel();
        labLast5 = new javax.swing.JLabel();
        labBest5 = new javax.swing.JLabel();
        labLap5 = new javax.swing.JLabel();
        labTyre5 = new javax.swing.JLabel();
        labBox5 = new javax.swing.JLabel();
        panel6 = new javax.swing.JPanel();
        labPos6 = new javax.swing.JLabel();
        labPen6 = new javax.swing.JLabel();
        labCol6 = new javax.swing.JLabel();
        labNum6 = new javax.swing.JLabel();
        labName6 = new javax.swing.JLabel();
        labTime6 = new javax.swing.JLabel();
        labS16 = new javax.swing.JLabel();
        labS26 = new javax.swing.JLabel();
        labS36 = new javax.swing.JLabel();
        labDelta6 = new javax.swing.JLabel();
        labLast6 = new javax.swing.JLabel();
        labBest6 = new javax.swing.JLabel();
        labLap6 = new javax.swing.JLabel();
        labTyre6 = new javax.swing.JLabel();
        labBox6 = new javax.swing.JLabel();
        panel7 = new javax.swing.JPanel();
        labPos7 = new javax.swing.JLabel();
        labPen7 = new javax.swing.JLabel();
        labCol7 = new javax.swing.JLabel();
        labNum7 = new javax.swing.JLabel();
        labName7 = new javax.swing.JLabel();
        labTime7 = new javax.swing.JLabel();
        labS17 = new javax.swing.JLabel();
        labS27 = new javax.swing.JLabel();
        labS37 = new javax.swing.JLabel();
        labDelta7 = new javax.swing.JLabel();
        labLast7 = new javax.swing.JLabel();
        labBest7 = new javax.swing.JLabel();
        labLap7 = new javax.swing.JLabel();
        labTyre7 = new javax.swing.JLabel();
        labBox7 = new javax.swing.JLabel();
        panel8 = new javax.swing.JPanel();
        labPos8 = new javax.swing.JLabel();
        labPen8 = new javax.swing.JLabel();
        labCol8 = new javax.swing.JLabel();
        labNum8 = new javax.swing.JLabel();
        labName8 = new javax.swing.JLabel();
        labTime8 = new javax.swing.JLabel();
        labS18 = new javax.swing.JLabel();
        labS28 = new javax.swing.JLabel();
        labS38 = new javax.swing.JLabel();
        labDelta8 = new javax.swing.JLabel();
        labLast8 = new javax.swing.JLabel();
        labBest8 = new javax.swing.JLabel();
        labLap8 = new javax.swing.JLabel();
        labTyre8 = new javax.swing.JLabel();
        labBox8 = new javax.swing.JLabel();
        panel9 = new javax.swing.JPanel();
        labPos9 = new javax.swing.JLabel();
        labPen9 = new javax.swing.JLabel();
        labCol9 = new javax.swing.JLabel();
        labNum9 = new javax.swing.JLabel();
        labName9 = new javax.swing.JLabel();
        labTime9 = new javax.swing.JLabel();
        labS19 = new javax.swing.JLabel();
        labS29 = new javax.swing.JLabel();
        labS39 = new javax.swing.JLabel();
        labDelta9 = new javax.swing.JLabel();
        labLast9 = new javax.swing.JLabel();
        labBest9 = new javax.swing.JLabel();
        labLap9 = new javax.swing.JLabel();
        labTyre9 = new javax.swing.JLabel();
        labBox9 = new javax.swing.JLabel();
        panel10 = new javax.swing.JPanel();
        labPos10 = new javax.swing.JLabel();
        labPen10 = new javax.swing.JLabel();
        labCol10 = new javax.swing.JLabel();
        labNum10 = new javax.swing.JLabel();
        labName10 = new javax.swing.JLabel();
        labTime10 = new javax.swing.JLabel();
        labS40 = new javax.swing.JLabel();
        labS41 = new javax.swing.JLabel();
        labS42 = new javax.swing.JLabel();
        labDelta10 = new javax.swing.JLabel();
        labLast10 = new javax.swing.JLabel();
        labBest10 = new javax.swing.JLabel();
        labLap10 = new javax.swing.JLabel();
        labTyre10 = new javax.swing.JLabel();
        labBox10 = new javax.swing.JLabel();
        panel11 = new javax.swing.JPanel();
        labPos11 = new javax.swing.JLabel();
        labPen11 = new javax.swing.JLabel();
        labCol11 = new javax.swing.JLabel();
        labNum11 = new javax.swing.JLabel();
        labName11 = new javax.swing.JLabel();
        labTime11 = new javax.swing.JLabel();
        labS43 = new javax.swing.JLabel();
        labS44 = new javax.swing.JLabel();
        labS45 = new javax.swing.JLabel();
        labDelta11 = new javax.swing.JLabel();
        labLast11 = new javax.swing.JLabel();
        labBest11 = new javax.swing.JLabel();
        labLap11 = new javax.swing.JLabel();
        labTyre11 = new javax.swing.JLabel();
        labBox11 = new javax.swing.JLabel();
        panel12 = new javax.swing.JPanel();
        labPos12 = new javax.swing.JLabel();
        labPen12 = new javax.swing.JLabel();
        labCol12 = new javax.swing.JLabel();
        labNum12 = new javax.swing.JLabel();
        labName12 = new javax.swing.JLabel();
        labTime12 = new javax.swing.JLabel();
        labS46 = new javax.swing.JLabel();
        labS47 = new javax.swing.JLabel();
        labS48 = new javax.swing.JLabel();
        labDelta12 = new javax.swing.JLabel();
        labLast12 = new javax.swing.JLabel();
        labBest12 = new javax.swing.JLabel();
        labLap12 = new javax.swing.JLabel();
        labTyre12 = new javax.swing.JLabel();
        labBox12 = new javax.swing.JLabel();
        panel13 = new javax.swing.JPanel();
        labPos13 = new javax.swing.JLabel();
        labPen13 = new javax.swing.JLabel();
        labCol13 = new javax.swing.JLabel();
        labNum13 = new javax.swing.JLabel();
        labName13 = new javax.swing.JLabel();
        labTime13 = new javax.swing.JLabel();
        labS49 = new javax.swing.JLabel();
        labS50 = new javax.swing.JLabel();
        labS51 = new javax.swing.JLabel();
        labDelta13 = new javax.swing.JLabel();
        labLast13 = new javax.swing.JLabel();
        labBest13 = new javax.swing.JLabel();
        labLap13 = new javax.swing.JLabel();
        labTyre13 = new javax.swing.JLabel();
        labBox13 = new javax.swing.JLabel();
        panel14 = new javax.swing.JPanel();
        labPos14 = new javax.swing.JLabel();
        labPen14 = new javax.swing.JLabel();
        labCol14 = new javax.swing.JLabel();
        labNum14 = new javax.swing.JLabel();
        labName14 = new javax.swing.JLabel();
        labTime14 = new javax.swing.JLabel();
        labS52 = new javax.swing.JLabel();
        labS53 = new javax.swing.JLabel();
        labS54 = new javax.swing.JLabel();
        labDelta14 = new javax.swing.JLabel();
        labLast14 = new javax.swing.JLabel();
        labBest14 = new javax.swing.JLabel();
        labLap14 = new javax.swing.JLabel();
        labTyre14 = new javax.swing.JLabel();
        labBox14 = new javax.swing.JLabel();
        panel15 = new javax.swing.JPanel();
        labPos15 = new javax.swing.JLabel();
        labPen15 = new javax.swing.JLabel();
        labCol15 = new javax.swing.JLabel();
        labNum15 = new javax.swing.JLabel();
        labName15 = new javax.swing.JLabel();
        labTime15 = new javax.swing.JLabel();
        labS55 = new javax.swing.JLabel();
        labS56 = new javax.swing.JLabel();
        labS57 = new javax.swing.JLabel();
        labDelta15 = new javax.swing.JLabel();
        labLast15 = new javax.swing.JLabel();
        labBest15 = new javax.swing.JLabel();
        labLap15 = new javax.swing.JLabel();
        labTyre15 = new javax.swing.JLabel();
        labBox15 = new javax.swing.JLabel();
        panel16 = new javax.swing.JPanel();
        labPos16 = new javax.swing.JLabel();
        labPen16 = new javax.swing.JLabel();
        labCol16 = new javax.swing.JLabel();
        labNum16 = new javax.swing.JLabel();
        labName16 = new javax.swing.JLabel();
        labTime16 = new javax.swing.JLabel();
        labS58 = new javax.swing.JLabel();
        labS59 = new javax.swing.JLabel();
        labS60 = new javax.swing.JLabel();
        labDelta16 = new javax.swing.JLabel();
        labLast16 = new javax.swing.JLabel();
        labBest16 = new javax.swing.JLabel();
        labLap16 = new javax.swing.JLabel();
        labTyre16 = new javax.swing.JLabel();
        labBox16 = new javax.swing.JLabel();
        panel17 = new javax.swing.JPanel();
        labPos17 = new javax.swing.JLabel();
        labPen17 = new javax.swing.JLabel();
        labCol17 = new javax.swing.JLabel();
        labNum17 = new javax.swing.JLabel();
        labName17 = new javax.swing.JLabel();
        labTime17 = new javax.swing.JLabel();
        labS61 = new javax.swing.JLabel();
        labS62 = new javax.swing.JLabel();
        labS63 = new javax.swing.JLabel();
        labDelta17 = new javax.swing.JLabel();
        labLast17 = new javax.swing.JLabel();
        labBest17 = new javax.swing.JLabel();
        labLap17 = new javax.swing.JLabel();
        labTyre17 = new javax.swing.JLabel();
        labBox17 = new javax.swing.JLabel();
        panel18 = new javax.swing.JPanel();
        labPos18 = new javax.swing.JLabel();
        labPen18 = new javax.swing.JLabel();
        labCol18 = new javax.swing.JLabel();
        labNum18 = new javax.swing.JLabel();
        labName18 = new javax.swing.JLabel();
        labTime18 = new javax.swing.JLabel();
        labS64 = new javax.swing.JLabel();
        labS65 = new javax.swing.JLabel();
        labS66 = new javax.swing.JLabel();
        labDelta18 = new javax.swing.JLabel();
        labLast18 = new javax.swing.JLabel();
        labBest18 = new javax.swing.JLabel();
        labLap18 = new javax.swing.JLabel();
        labTyre18 = new javax.swing.JLabel();
        labBox18 = new javax.swing.JLabel();
        panel19 = new javax.swing.JPanel();
        labPos19 = new javax.swing.JLabel();
        labPen19 = new javax.swing.JLabel();
        labCol19 = new javax.swing.JLabel();
        labNum19 = new javax.swing.JLabel();
        labName19 = new javax.swing.JLabel();
        labTime19 = new javax.swing.JLabel();
        labS67 = new javax.swing.JLabel();
        labS68 = new javax.swing.JLabel();
        labS69 = new javax.swing.JLabel();
        labDelta19 = new javax.swing.JLabel();
        labLast19 = new javax.swing.JLabel();
        labBest19 = new javax.swing.JLabel();
        labLap19 = new javax.swing.JLabel();
        labTyre19 = new javax.swing.JLabel();
        labBox19 = new javax.swing.JLabel();
        panel20 = new javax.swing.JPanel();
        labPos20 = new javax.swing.JLabel();
        labPen20 = new javax.swing.JLabel();
        labCol20 = new javax.swing.JLabel();
        labNum20 = new javax.swing.JLabel();
        labName20 = new javax.swing.JLabel();
        labTime20 = new javax.swing.JLabel();
        labS70 = new javax.swing.JLabel();
        labS71 = new javax.swing.JLabel();
        labS72 = new javax.swing.JLabel();
        labDelta20 = new javax.swing.JLabel();
        labLast20 = new javax.swing.JLabel();
        labBest20 = new javax.swing.JLabel();
        labLap20 = new javax.swing.JLabel();
        labTyre20 = new javax.swing.JLabel();
        labBox20 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        manuView = new javax.swing.JMenu();
        rbViewLatest = new javax.swing.JRadioButtonMenuItem();
        rbViewCurrent = new javax.swing.JRadioButtonMenuItem();
        rbViewBest = new javax.swing.JRadioButtonMenuItem();
        menuGap = new javax.swing.JMenu();
        rbGap1st = new javax.swing.JRadioButtonMenuItem();
        rbGapNext = new javax.swing.JRadioButtonMenuItem();
        rbGapUser = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Live Timing");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(19, 19, 19));
        jPanel1.setPreferredSize(new java.awt.Dimension(1248, 700));

        panelSession.setBackground(new java.awt.Color(19, 19, 19));
        panelSession.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Session", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204))); // NOI18N
        panelSession.setLayout(new javax.swing.BoxLayout(panelSession, javax.swing.BoxLayout.LINE_AXIS));

        lab_weather.setText("jLabel2");
        lab_weather.setMaximumSize(new java.awt.Dimension(60, 60));
        lab_weather.setMinimumSize(new java.awt.Dimension(60, 60));
        panelSession.add(lab_weather);

        space.setMaximumSize(new java.awt.Dimension(10, 0));
        space.setMinimumSize(new java.awt.Dimension(10, 0));
        space.setPreferredSize(new java.awt.Dimension(10, 0));
        panelSession.add(space);

        lab_weather_text.setFont(new java.awt.Font("Formula1 Display Regular", 0, 24)); // NOI18N
        lab_weather_text.setForeground(new java.awt.Color(255, 255, 255));
        lab_weather_text.setText("Weather");
        panelSession.add(lab_weather_text);

        space1.setMaximumSize(new java.awt.Dimension(10, 0));
        space1.setMinimumSize(new java.awt.Dimension(10, 0));
        space1.setPreferredSize(new java.awt.Dimension(10, 0));
        panelSession.add(space1);

        jLabel13.setFont(new java.awt.Font("Formula1 Display Regular", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("T:");
        panelSession.add(jLabel13);

        space2.setMaximumSize(new java.awt.Dimension(10, 0));
        space2.setMinimumSize(new java.awt.Dimension(10, 0));
        space2.setPreferredSize(new java.awt.Dimension(10, 0));
        panelSession.add(space2);

        lab_trackTemperature.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lab_trackTemperature.setForeground(new java.awt.Color(255, 255, 255));
        lab_trackTemperature.setText("Weather");
        panelSession.add(lab_trackTemperature);

        space3.setMaximumSize(new java.awt.Dimension(10, 0));
        space3.setMinimumSize(new java.awt.Dimension(10, 0));
        space3.setPreferredSize(new java.awt.Dimension(10, 0));
        panelSession.add(space3);

        jLabel12.setFont(new java.awt.Font("Formula1 Display Regular", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("A:");
        panelSession.add(jLabel12);

        space4.setMaximumSize(new java.awt.Dimension(10, 0));
        space4.setMinimumSize(new java.awt.Dimension(10, 0));
        space4.setPreferredSize(new java.awt.Dimension(10, 0));
        panelSession.add(space4);

        lab_airTemperature.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lab_airTemperature.setForeground(new java.awt.Color(255, 255, 255));
        lab_airTemperature.setText("Weather");
        panelSession.add(lab_airTemperature);

        space5.setMaximumSize(new java.awt.Dimension(10, 0));
        space5.setMinimumSize(new java.awt.Dimension(10, 0));
        space5.setPreferredSize(new java.awt.Dimension(10, 0));
        panelSession.add(space5);

        jPanel2.setBackground(new java.awt.Color(19, 19, 19));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Best Time Session", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(500, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        lab_bestS1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_bestS1.setForeground(new java.awt.Color(255, 255, 255));
        lab_bestS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_bestS1.setMaximumSize(new java.awt.Dimension(100, 17));
        lab_bestS1.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_bestS1.setPreferredSize(new java.awt.Dimension(50, 17));
        jPanel2.add(lab_bestS1);

        lab_bestS2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_bestS2.setForeground(new java.awt.Color(255, 255, 255));
        lab_bestS2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_bestS2.setMaximumSize(new java.awt.Dimension(100, 17));
        lab_bestS2.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_bestS2.setPreferredSize(new java.awt.Dimension(50, 17));
        jPanel2.add(lab_bestS2);

        lab_bestS3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_bestS3.setForeground(new java.awt.Color(255, 255, 255));
        lab_bestS3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_bestS3.setMaximumSize(new java.awt.Dimension(100, 17));
        lab_bestS3.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_bestS3.setPreferredSize(new java.awt.Dimension(50, 17));
        jPanel2.add(lab_bestS3);

        lab_bestTotal.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lab_bestTotal.setForeground(new java.awt.Color(255, 255, 255));
        lab_bestTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_bestTotal.setMaximumSize(new java.awt.Dimension(100, 17));
        lab_bestTotal.setMinimumSize(new java.awt.Dimension(20, 17));
        lab_bestTotal.setPreferredSize(new java.awt.Dimension(50, 17));
        jPanel2.add(lab_bestTotal);

        panelSession.add(jPanel2);

        space6.setMaximumSize(new java.awt.Dimension(10, 0));
        space6.setMinimumSize(new java.awt.Dimension(10, 0));
        space6.setPreferredSize(new java.awt.Dimension(10, 0));
        panelSession.add(space6);

        lab_remaining.setFont(new java.awt.Font("Formula1 Display Regular", 0, 18)); // NOI18N
        lab_remaining.setForeground(new java.awt.Color(204, 204, 204));
        lab_remaining.setText("remaining");
        lab_remaining.setMaximumSize(new java.awt.Dimension(100, 50));
        lab_remaining.setPreferredSize(new java.awt.Dimension(200, 50));
        panelSession.add(lab_remaining);

        space7.setMaximumSize(new java.awt.Dimension(50, 0));
        space7.setMinimumSize(new java.awt.Dimension(50, 0));
        space7.setPreferredSize(new java.awt.Dimension(10, 0));
        panelSession.add(space7);

        panelTiming.setBackground(new java.awt.Color(19, 19, 19));
        panelTiming.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Timing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204))); // NOI18N
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

        labTime0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labTime0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime0.setText("TIME");
        labTime0.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime0.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labTime0);

        labS10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labS10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS10.setText("S1");
        labS10.setMaximumSize(new java.awt.Dimension(100, 17));
        labS10.setMinimumSize(new java.awt.Dimension(20, 17));
        labS10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labS10);

        labS20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labS20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS20.setText("S2");
        labS20.setMaximumSize(new java.awt.Dimension(100, 17));
        labS20.setMinimumSize(new java.awt.Dimension(20, 17));
        labS20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labS20);

        labS30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labS30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS30.setText("S3");
        labS30.setMaximumSize(new java.awt.Dimension(100, 17));
        labS30.setMinimumSize(new java.awt.Dimension(20, 17));
        labS30.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labS30);

        labDelta0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labDelta0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta0.setText("DELTA");
        labDelta0.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta0.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labDelta0);

        labLast0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labLast0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast0.setText("LAST");
        labLast0.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast0.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labLast0);

        labBest0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labBest0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest0.setText("BEST");
        labBest0.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest0.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labBest0);

        labLap0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labLap0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap0.setText("LAP");
        labLap0.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap0.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labLap0);

        labTyre0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labTyre0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre0.setText("TYRE");
        labTyre0.setMaximumSize(new java.awt.Dimension(40, 17));
        labTyre0.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labTyre0);

        labPit0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labPit0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPit0.setText("PIT");
        labPit0.setMaximumSize(new java.awt.Dimension(40, 17));
        labPit0.setPreferredSize(new java.awt.Dimension(50, 17));
        panel0.add(labPit0);

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

        labTime1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime1.setForeground(new java.awt.Color(255, 255, 255));
        labTime1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime1.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime1.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labTime1);

        labS11.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS11.setForeground(new java.awt.Color(255, 255, 255));
        labS11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS11.setMaximumSize(new java.awt.Dimension(100, 17));
        labS11.setMinimumSize(new java.awt.Dimension(20, 17));
        labS11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labS11);

        labS21.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS21.setForeground(new java.awt.Color(255, 255, 255));
        labS21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS21.setMaximumSize(new java.awt.Dimension(100, 17));
        labS21.setMinimumSize(new java.awt.Dimension(20, 17));
        labS21.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labS21);

        labS31.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS31.setForeground(new java.awt.Color(255, 255, 255));
        labS31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS31.setMaximumSize(new java.awt.Dimension(100, 17));
        labS31.setMinimumSize(new java.awt.Dimension(20, 17));
        labS31.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labS31);

        labDelta1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta1.setForeground(new java.awt.Color(255, 255, 0));
        labDelta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta1.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta1.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labDelta1);

        labLast1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast1.setForeground(new java.awt.Color(255, 255, 255));
        labLast1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast1.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast1.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labLast1);

        labBest1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest1.setForeground(new java.awt.Color(255, 255, 255));
        labBest1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest1.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest1.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labBest1);

        labLap1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap1.setForeground(new java.awt.Color(255, 255, 255));
        labLap1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap1.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap1.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labLap1);

        labTyre1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre1.setForeground(new java.awt.Color(255, 255, 255));
        labTyre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre1.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre1.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labTyre1);

        labBox1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox1.setForeground(new java.awt.Color(255, 255, 255));
        labBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox1.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox1.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox1.setPreferredSize(new java.awt.Dimension(50, 17));
        panel1.add(labBox1);

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

        labTime2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime2.setForeground(new java.awt.Color(255, 255, 255));
        labTime2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime2.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime2.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labTime2);

        labS12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS12.setForeground(new java.awt.Color(255, 255, 255));
        labS12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS12.setMaximumSize(new java.awt.Dimension(100, 17));
        labS12.setMinimumSize(new java.awt.Dimension(20, 17));
        labS12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labS12);

        labS22.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS22.setForeground(new java.awt.Color(255, 255, 255));
        labS22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS22.setMaximumSize(new java.awt.Dimension(100, 17));
        labS22.setMinimumSize(new java.awt.Dimension(20, 17));
        labS22.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labS22);

        labS32.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS32.setForeground(new java.awt.Color(255, 255, 255));
        labS32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS32.setMaximumSize(new java.awt.Dimension(100, 17));
        labS32.setMinimumSize(new java.awt.Dimension(20, 17));
        labS32.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labS32);

        labDelta2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta2.setForeground(new java.awt.Color(255, 255, 0));
        labDelta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta2.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta2.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labDelta2);

        labLast2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast2.setForeground(new java.awt.Color(255, 255, 255));
        labLast2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast2.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast2.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labLast2);

        labBest2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest2.setForeground(new java.awt.Color(255, 255, 255));
        labBest2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest2.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest2.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labBest2);

        labLap2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap2.setForeground(new java.awt.Color(255, 255, 255));
        labLap2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap2.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap2.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labLap2);

        labTyre2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre2.setForeground(new java.awt.Color(255, 255, 255));
        labTyre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre2.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre2.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labTyre2);

        labBox2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox2.setForeground(new java.awt.Color(255, 255, 255));
        labBox2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox2.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox2.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox2.setPreferredSize(new java.awt.Dimension(50, 17));
        panel2.add(labBox2);

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

        labTime3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime3.setForeground(new java.awt.Color(255, 255, 255));
        labTime3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime3.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime3.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labTime3);

        labS13.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS13.setForeground(new java.awt.Color(255, 255, 255));
        labS13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS13.setMaximumSize(new java.awt.Dimension(100, 17));
        labS13.setMinimumSize(new java.awt.Dimension(20, 17));
        labS13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labS13);

        labS23.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS23.setForeground(new java.awt.Color(255, 255, 255));
        labS23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS23.setMaximumSize(new java.awt.Dimension(100, 17));
        labS23.setMinimumSize(new java.awt.Dimension(20, 17));
        labS23.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labS23);

        labS33.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS33.setForeground(new java.awt.Color(255, 255, 255));
        labS33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS33.setMaximumSize(new java.awt.Dimension(100, 17));
        labS33.setMinimumSize(new java.awt.Dimension(20, 17));
        labS33.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labS33);

        labDelta3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta3.setForeground(new java.awt.Color(255, 255, 0));
        labDelta3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta3.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta3.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labDelta3);

        labLast3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast3.setForeground(new java.awt.Color(255, 255, 255));
        labLast3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast3.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast3.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labLast3);

        labBest3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest3.setForeground(new java.awt.Color(255, 255, 255));
        labBest3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest3.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest3.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labBest3);

        labLap3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap3.setForeground(new java.awt.Color(255, 255, 255));
        labLap3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap3.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap3.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labLap3);

        labTyre3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre3.setForeground(new java.awt.Color(255, 255, 255));
        labTyre3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre3.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre3.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labTyre3);

        labBox3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox3.setForeground(new java.awt.Color(255, 255, 255));
        labBox3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox3.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox3.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox3.setPreferredSize(new java.awt.Dimension(50, 17));
        panel3.add(labBox3);

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

        labTime4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime4.setForeground(new java.awt.Color(255, 255, 255));
        labTime4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime4.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime4.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labTime4);

        labS14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS14.setForeground(new java.awt.Color(255, 255, 255));
        labS14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS14.setMaximumSize(new java.awt.Dimension(100, 17));
        labS14.setMinimumSize(new java.awt.Dimension(20, 17));
        labS14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labS14);

        labS24.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS24.setForeground(new java.awt.Color(255, 255, 255));
        labS24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS24.setMaximumSize(new java.awt.Dimension(100, 17));
        labS24.setMinimumSize(new java.awt.Dimension(20, 17));
        labS24.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labS24);

        labS34.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS34.setForeground(new java.awt.Color(255, 255, 255));
        labS34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS34.setMaximumSize(new java.awt.Dimension(100, 17));
        labS34.setMinimumSize(new java.awt.Dimension(20, 17));
        labS34.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labS34);

        labDelta4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta4.setForeground(new java.awt.Color(255, 255, 0));
        labDelta4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta4.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta4.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labDelta4);

        labLast4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast4.setForeground(new java.awt.Color(255, 255, 255));
        labLast4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast4.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast4.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labLast4);

        labBest4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest4.setForeground(new java.awt.Color(255, 255, 255));
        labBest4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest4.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest4.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labBest4);

        labLap4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap4.setForeground(new java.awt.Color(255, 255, 255));
        labLap4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap4.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap4.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labLap4);

        labTyre4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre4.setForeground(new java.awt.Color(255, 255, 255));
        labTyre4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre4.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre4.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labTyre4);

        labBox4.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox4.setForeground(new java.awt.Color(255, 255, 255));
        labBox4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox4.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox4.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox4.setPreferredSize(new java.awt.Dimension(50, 17));
        panel4.add(labBox4);

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

        labTime5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime5.setForeground(new java.awt.Color(255, 255, 255));
        labTime5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime5.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime5.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labTime5);

        labS15.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS15.setForeground(new java.awt.Color(255, 255, 255));
        labS15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS15.setMaximumSize(new java.awt.Dimension(100, 17));
        labS15.setMinimumSize(new java.awt.Dimension(20, 17));
        labS15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labS15);

        labS25.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS25.setForeground(new java.awt.Color(255, 255, 255));
        labS25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS25.setMaximumSize(new java.awt.Dimension(100, 17));
        labS25.setMinimumSize(new java.awt.Dimension(20, 17));
        labS25.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labS25);

        labS35.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS35.setForeground(new java.awt.Color(255, 255, 255));
        labS35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS35.setMaximumSize(new java.awt.Dimension(100, 17));
        labS35.setMinimumSize(new java.awt.Dimension(20, 17));
        labS35.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labS35);

        labDelta5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta5.setForeground(new java.awt.Color(255, 255, 0));
        labDelta5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta5.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta5.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labDelta5);

        labLast5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast5.setForeground(new java.awt.Color(255, 255, 255));
        labLast5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast5.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast5.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labLast5);

        labBest5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest5.setForeground(new java.awt.Color(255, 255, 255));
        labBest5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest5.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest5.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labBest5);

        labLap5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap5.setForeground(new java.awt.Color(255, 255, 255));
        labLap5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap5.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap5.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labLap5);

        labTyre5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre5.setForeground(new java.awt.Color(255, 255, 255));
        labTyre5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre5.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre5.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labTyre5);

        labBox5.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox5.setForeground(new java.awt.Color(255, 255, 255));
        labBox5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox5.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox5.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox5.setPreferredSize(new java.awt.Dimension(50, 17));
        panel5.add(labBox5);

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

        labTime6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime6.setForeground(new java.awt.Color(255, 255, 255));
        labTime6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime6.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime6.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labTime6);

        labS16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS16.setForeground(new java.awt.Color(255, 255, 255));
        labS16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS16.setMaximumSize(new java.awt.Dimension(100, 17));
        labS16.setMinimumSize(new java.awt.Dimension(20, 17));
        labS16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labS16);

        labS26.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS26.setForeground(new java.awt.Color(255, 255, 255));
        labS26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS26.setMaximumSize(new java.awt.Dimension(100, 17));
        labS26.setMinimumSize(new java.awt.Dimension(20, 17));
        labS26.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labS26);

        labS36.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS36.setForeground(new java.awt.Color(255, 255, 255));
        labS36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS36.setMaximumSize(new java.awt.Dimension(100, 17));
        labS36.setMinimumSize(new java.awt.Dimension(20, 17));
        labS36.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labS36);

        labDelta6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta6.setForeground(new java.awt.Color(255, 255, 0));
        labDelta6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta6.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta6.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labDelta6);

        labLast6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast6.setForeground(new java.awt.Color(255, 255, 255));
        labLast6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast6.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast6.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labLast6);

        labBest6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest6.setForeground(new java.awt.Color(255, 255, 255));
        labBest6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest6.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest6.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labBest6);

        labLap6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap6.setForeground(new java.awt.Color(255, 255, 255));
        labLap6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap6.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap6.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labLap6);

        labTyre6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre6.setForeground(new java.awt.Color(255, 255, 255));
        labTyre6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre6.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre6.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labTyre6);

        labBox6.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox6.setForeground(new java.awt.Color(255, 255, 255));
        labBox6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox6.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox6.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox6.setPreferredSize(new java.awt.Dimension(50, 17));
        panel6.add(labBox6);

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

        labTime7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime7.setForeground(new java.awt.Color(255, 255, 255));
        labTime7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime7.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime7.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labTime7);

        labS17.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS17.setForeground(new java.awt.Color(255, 255, 255));
        labS17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS17.setMaximumSize(new java.awt.Dimension(100, 17));
        labS17.setMinimumSize(new java.awt.Dimension(20, 17));
        labS17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labS17);

        labS27.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS27.setForeground(new java.awt.Color(255, 255, 255));
        labS27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS27.setMaximumSize(new java.awt.Dimension(100, 17));
        labS27.setMinimumSize(new java.awt.Dimension(20, 17));
        labS27.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labS27);

        labS37.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS37.setForeground(new java.awt.Color(255, 255, 255));
        labS37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS37.setMaximumSize(new java.awt.Dimension(100, 17));
        labS37.setMinimumSize(new java.awt.Dimension(20, 17));
        labS37.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labS37);

        labDelta7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta7.setForeground(new java.awt.Color(255, 255, 0));
        labDelta7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta7.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta7.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labDelta7);

        labLast7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast7.setForeground(new java.awt.Color(255, 255, 255));
        labLast7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast7.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast7.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labLast7);

        labBest7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest7.setForeground(new java.awt.Color(255, 255, 255));
        labBest7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest7.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest7.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labBest7);

        labLap7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap7.setForeground(new java.awt.Color(255, 255, 255));
        labLap7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap7.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap7.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labLap7);

        labTyre7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre7.setForeground(new java.awt.Color(255, 255, 255));
        labTyre7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre7.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre7.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labTyre7);

        labBox7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox7.setForeground(new java.awt.Color(255, 255, 255));
        labBox7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox7.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox7.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox7.setPreferredSize(new java.awt.Dimension(50, 17));
        panel7.add(labBox7);

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

        labTime8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime8.setForeground(new java.awt.Color(255, 255, 255));
        labTime8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime8.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime8.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labTime8);

        labS18.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS18.setForeground(new java.awt.Color(255, 255, 255));
        labS18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS18.setMaximumSize(new java.awt.Dimension(100, 17));
        labS18.setMinimumSize(new java.awt.Dimension(20, 17));
        labS18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labS18);

        labS28.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS28.setForeground(new java.awt.Color(255, 255, 255));
        labS28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS28.setMaximumSize(new java.awt.Dimension(100, 17));
        labS28.setMinimumSize(new java.awt.Dimension(20, 17));
        labS28.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labS28);

        labS38.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS38.setForeground(new java.awt.Color(255, 255, 255));
        labS38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS38.setMaximumSize(new java.awt.Dimension(100, 17));
        labS38.setMinimumSize(new java.awt.Dimension(20, 17));
        labS38.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labS38);

        labDelta8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta8.setForeground(new java.awt.Color(255, 255, 0));
        labDelta8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta8.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta8.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labDelta8);

        labLast8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast8.setForeground(new java.awt.Color(255, 255, 255));
        labLast8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast8.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast8.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labLast8);

        labBest8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest8.setForeground(new java.awt.Color(255, 255, 255));
        labBest8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest8.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest8.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labBest8);

        labLap8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap8.setForeground(new java.awt.Color(255, 255, 255));
        labLap8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap8.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap8.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labLap8);

        labTyre8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre8.setForeground(new java.awt.Color(255, 255, 255));
        labTyre8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre8.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre8.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labTyre8);

        labBox8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox8.setForeground(new java.awt.Color(255, 255, 255));
        labBox8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox8.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox8.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox8.setPreferredSize(new java.awt.Dimension(50, 17));
        panel8.add(labBox8);

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

        labTime9.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime9.setForeground(new java.awt.Color(255, 255, 255));
        labTime9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime9.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime9.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labTime9);

        labS19.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS19.setForeground(new java.awt.Color(255, 255, 255));
        labS19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS19.setMaximumSize(new java.awt.Dimension(100, 17));
        labS19.setMinimumSize(new java.awt.Dimension(20, 17));
        labS19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labS19);

        labS29.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS29.setForeground(new java.awt.Color(255, 255, 255));
        labS29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS29.setMaximumSize(new java.awt.Dimension(100, 17));
        labS29.setMinimumSize(new java.awt.Dimension(20, 17));
        labS29.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labS29);

        labS39.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS39.setForeground(new java.awt.Color(255, 255, 255));
        labS39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS39.setMaximumSize(new java.awt.Dimension(100, 17));
        labS39.setMinimumSize(new java.awt.Dimension(20, 17));
        labS39.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labS39);

        labDelta9.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta9.setForeground(new java.awt.Color(255, 255, 0));
        labDelta9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta9.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta9.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labDelta9);

        labLast9.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast9.setForeground(new java.awt.Color(255, 255, 255));
        labLast9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast9.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast9.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labLast9);

        labBest9.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest9.setForeground(new java.awt.Color(255, 255, 255));
        labBest9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest9.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest9.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labBest9);

        labLap9.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap9.setForeground(new java.awt.Color(255, 255, 255));
        labLap9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap9.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap9.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labLap9);

        labTyre9.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre9.setForeground(new java.awt.Color(255, 255, 255));
        labTyre9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre9.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre9.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labTyre9);

        labBox9.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox9.setForeground(new java.awt.Color(255, 255, 255));
        labBox9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox9.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox9.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox9.setPreferredSize(new java.awt.Dimension(50, 17));
        panel9.add(labBox9);

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

        labTime10.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime10.setForeground(new java.awt.Color(255, 255, 255));
        labTime10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime10.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime10.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labTime10);

        labS40.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS40.setForeground(new java.awt.Color(255, 255, 255));
        labS40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS40.setMaximumSize(new java.awt.Dimension(100, 17));
        labS40.setMinimumSize(new java.awt.Dimension(20, 17));
        labS40.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labS40);

        labS41.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS41.setForeground(new java.awt.Color(255, 255, 255));
        labS41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS41.setMaximumSize(new java.awt.Dimension(100, 17));
        labS41.setMinimumSize(new java.awt.Dimension(20, 17));
        labS41.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labS41);

        labS42.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS42.setForeground(new java.awt.Color(255, 255, 255));
        labS42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS42.setMaximumSize(new java.awt.Dimension(100, 17));
        labS42.setMinimumSize(new java.awt.Dimension(20, 17));
        labS42.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labS42);

        labDelta10.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta10.setForeground(new java.awt.Color(255, 255, 0));
        labDelta10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta10.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta10.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labDelta10);

        labLast10.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast10.setForeground(new java.awt.Color(255, 255, 255));
        labLast10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast10.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast10.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labLast10);

        labBest10.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest10.setForeground(new java.awt.Color(255, 255, 255));
        labBest10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest10.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest10.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labBest10);

        labLap10.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap10.setForeground(new java.awt.Color(255, 255, 255));
        labLap10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap10.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap10.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labLap10);

        labTyre10.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre10.setForeground(new java.awt.Color(255, 255, 255));
        labTyre10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre10.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre10.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labTyre10);

        labBox10.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox10.setForeground(new java.awt.Color(255, 255, 255));
        labBox10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox10.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox10.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox10.setPreferredSize(new java.awt.Dimension(50, 17));
        panel10.add(labBox10);

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

        labTime11.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime11.setForeground(new java.awt.Color(255, 255, 255));
        labTime11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime11.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime11.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labTime11);

        labS43.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS43.setForeground(new java.awt.Color(255, 255, 255));
        labS43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS43.setMaximumSize(new java.awt.Dimension(100, 17));
        labS43.setMinimumSize(new java.awt.Dimension(20, 17));
        labS43.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labS43);

        labS44.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS44.setForeground(new java.awt.Color(255, 255, 255));
        labS44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS44.setMaximumSize(new java.awt.Dimension(100, 17));
        labS44.setMinimumSize(new java.awt.Dimension(20, 17));
        labS44.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labS44);

        labS45.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS45.setForeground(new java.awt.Color(255, 255, 255));
        labS45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS45.setMaximumSize(new java.awt.Dimension(100, 17));
        labS45.setMinimumSize(new java.awt.Dimension(20, 17));
        labS45.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labS45);

        labDelta11.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta11.setForeground(new java.awt.Color(255, 255, 0));
        labDelta11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta11.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta11.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labDelta11);

        labLast11.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast11.setForeground(new java.awt.Color(255, 255, 255));
        labLast11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast11.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast11.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labLast11);

        labBest11.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest11.setForeground(new java.awt.Color(255, 255, 255));
        labBest11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest11.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest11.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labBest11);

        labLap11.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap11.setForeground(new java.awt.Color(255, 255, 255));
        labLap11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap11.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap11.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labLap11);

        labTyre11.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre11.setForeground(new java.awt.Color(255, 255, 255));
        labTyre11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre11.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre11.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labTyre11);

        labBox11.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox11.setForeground(new java.awt.Color(255, 255, 255));
        labBox11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox11.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox11.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox11.setPreferredSize(new java.awt.Dimension(50, 17));
        panel11.add(labBox11);

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

        labTime12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime12.setForeground(new java.awt.Color(255, 255, 255));
        labTime12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime12.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime12.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labTime12);

        labS46.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS46.setForeground(new java.awt.Color(255, 255, 255));
        labS46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS46.setMaximumSize(new java.awt.Dimension(100, 17));
        labS46.setMinimumSize(new java.awt.Dimension(20, 17));
        labS46.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labS46);

        labS47.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS47.setForeground(new java.awt.Color(255, 255, 255));
        labS47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS47.setMaximumSize(new java.awt.Dimension(100, 17));
        labS47.setMinimumSize(new java.awt.Dimension(20, 17));
        labS47.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labS47);

        labS48.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS48.setForeground(new java.awt.Color(255, 255, 255));
        labS48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS48.setMaximumSize(new java.awt.Dimension(100, 17));
        labS48.setMinimumSize(new java.awt.Dimension(20, 17));
        labS48.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labS48);

        labDelta12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta12.setForeground(new java.awt.Color(255, 255, 0));
        labDelta12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta12.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta12.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labDelta12);

        labLast12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast12.setForeground(new java.awt.Color(255, 255, 255));
        labLast12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast12.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast12.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labLast12);

        labBest12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest12.setForeground(new java.awt.Color(255, 255, 255));
        labBest12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest12.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest12.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labBest12);

        labLap12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap12.setForeground(new java.awt.Color(255, 255, 255));
        labLap12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap12.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap12.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labLap12);

        labTyre12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre12.setForeground(new java.awt.Color(255, 255, 255));
        labTyre12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre12.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre12.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labTyre12);

        labBox12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox12.setForeground(new java.awt.Color(255, 255, 255));
        labBox12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox12.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox12.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox12.setPreferredSize(new java.awt.Dimension(50, 17));
        panel12.add(labBox12);

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

        labTime13.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime13.setForeground(new java.awt.Color(255, 255, 255));
        labTime13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime13.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime13.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labTime13);

        labS49.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS49.setForeground(new java.awt.Color(255, 255, 255));
        labS49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS49.setMaximumSize(new java.awt.Dimension(100, 17));
        labS49.setMinimumSize(new java.awt.Dimension(20, 17));
        labS49.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labS49);

        labS50.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS50.setForeground(new java.awt.Color(255, 255, 255));
        labS50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS50.setMaximumSize(new java.awt.Dimension(100, 17));
        labS50.setMinimumSize(new java.awt.Dimension(20, 17));
        labS50.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labS50);

        labS51.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS51.setForeground(new java.awt.Color(255, 255, 255));
        labS51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS51.setMaximumSize(new java.awt.Dimension(100, 17));
        labS51.setMinimumSize(new java.awt.Dimension(20, 17));
        labS51.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labS51);

        labDelta13.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta13.setForeground(new java.awt.Color(255, 255, 0));
        labDelta13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta13.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta13.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labDelta13);

        labLast13.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast13.setForeground(new java.awt.Color(255, 255, 255));
        labLast13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast13.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast13.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labLast13);

        labBest13.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest13.setForeground(new java.awt.Color(255, 255, 255));
        labBest13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest13.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest13.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labBest13);

        labLap13.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap13.setForeground(new java.awt.Color(255, 255, 255));
        labLap13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap13.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap13.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labLap13);

        labTyre13.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre13.setForeground(new java.awt.Color(255, 255, 255));
        labTyre13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre13.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre13.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labTyre13);

        labBox13.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox13.setForeground(new java.awt.Color(255, 255, 255));
        labBox13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox13.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox13.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox13.setPreferredSize(new java.awt.Dimension(50, 17));
        panel13.add(labBox13);

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

        labTime14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime14.setForeground(new java.awt.Color(255, 255, 255));
        labTime14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime14.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime14.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labTime14);

        labS52.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS52.setForeground(new java.awt.Color(255, 255, 255));
        labS52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS52.setMaximumSize(new java.awt.Dimension(100, 17));
        labS52.setMinimumSize(new java.awt.Dimension(20, 17));
        labS52.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labS52);

        labS53.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS53.setForeground(new java.awt.Color(255, 255, 255));
        labS53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS53.setMaximumSize(new java.awt.Dimension(100, 17));
        labS53.setMinimumSize(new java.awt.Dimension(20, 17));
        labS53.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labS53);

        labS54.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS54.setForeground(new java.awt.Color(255, 255, 255));
        labS54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS54.setMaximumSize(new java.awt.Dimension(100, 17));
        labS54.setMinimumSize(new java.awt.Dimension(20, 17));
        labS54.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labS54);

        labDelta14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta14.setForeground(new java.awt.Color(255, 255, 0));
        labDelta14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta14.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta14.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labDelta14);

        labLast14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast14.setForeground(new java.awt.Color(255, 255, 255));
        labLast14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast14.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast14.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labLast14);

        labBest14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest14.setForeground(new java.awt.Color(255, 255, 255));
        labBest14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest14.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest14.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labBest14);

        labLap14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap14.setForeground(new java.awt.Color(255, 255, 255));
        labLap14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap14.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap14.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labLap14);

        labTyre14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre14.setForeground(new java.awt.Color(255, 255, 255));
        labTyre14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre14.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre14.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labTyre14);

        labBox14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox14.setForeground(new java.awt.Color(255, 255, 255));
        labBox14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox14.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox14.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox14.setPreferredSize(new java.awt.Dimension(50, 17));
        panel14.add(labBox14);

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

        labTime15.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime15.setForeground(new java.awt.Color(255, 255, 255));
        labTime15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime15.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime15.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labTime15);

        labS55.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS55.setForeground(new java.awt.Color(255, 255, 255));
        labS55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS55.setMaximumSize(new java.awt.Dimension(100, 17));
        labS55.setMinimumSize(new java.awt.Dimension(20, 17));
        labS55.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labS55);

        labS56.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS56.setForeground(new java.awt.Color(255, 255, 255));
        labS56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS56.setMaximumSize(new java.awt.Dimension(100, 17));
        labS56.setMinimumSize(new java.awt.Dimension(20, 17));
        labS56.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labS56);

        labS57.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS57.setForeground(new java.awt.Color(255, 255, 255));
        labS57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS57.setMaximumSize(new java.awt.Dimension(100, 17));
        labS57.setMinimumSize(new java.awt.Dimension(20, 17));
        labS57.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labS57);

        labDelta15.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta15.setForeground(new java.awt.Color(255, 255, 0));
        labDelta15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta15.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta15.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labDelta15);

        labLast15.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast15.setForeground(new java.awt.Color(255, 255, 255));
        labLast15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast15.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast15.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labLast15);

        labBest15.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest15.setForeground(new java.awt.Color(255, 255, 255));
        labBest15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest15.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest15.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labBest15);

        labLap15.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap15.setForeground(new java.awt.Color(255, 255, 255));
        labLap15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap15.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap15.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labLap15);

        labTyre15.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre15.setForeground(new java.awt.Color(255, 255, 255));
        labTyre15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre15.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre15.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labTyre15);

        labBox15.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox15.setForeground(new java.awt.Color(255, 255, 255));
        labBox15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox15.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox15.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox15.setPreferredSize(new java.awt.Dimension(50, 17));
        panel15.add(labBox15);

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

        labTime16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime16.setForeground(new java.awt.Color(255, 255, 255));
        labTime16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime16.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime16.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labTime16);

        labS58.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS58.setForeground(new java.awt.Color(255, 255, 255));
        labS58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS58.setMaximumSize(new java.awt.Dimension(100, 17));
        labS58.setMinimumSize(new java.awt.Dimension(20, 17));
        labS58.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labS58);

        labS59.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS59.setForeground(new java.awt.Color(255, 255, 255));
        labS59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS59.setMaximumSize(new java.awt.Dimension(100, 17));
        labS59.setMinimumSize(new java.awt.Dimension(20, 17));
        labS59.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labS59);

        labS60.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS60.setForeground(new java.awt.Color(255, 255, 255));
        labS60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS60.setMaximumSize(new java.awt.Dimension(100, 17));
        labS60.setMinimumSize(new java.awt.Dimension(20, 17));
        labS60.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labS60);

        labDelta16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta16.setForeground(new java.awt.Color(255, 255, 0));
        labDelta16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta16.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta16.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labDelta16);

        labLast16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast16.setForeground(new java.awt.Color(255, 255, 255));
        labLast16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast16.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast16.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labLast16);

        labBest16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest16.setForeground(new java.awt.Color(255, 255, 255));
        labBest16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest16.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest16.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labBest16);

        labLap16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap16.setForeground(new java.awt.Color(255, 255, 255));
        labLap16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap16.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap16.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labLap16);

        labTyre16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre16.setForeground(new java.awt.Color(255, 255, 255));
        labTyre16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre16.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre16.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labTyre16);

        labBox16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox16.setForeground(new java.awt.Color(255, 255, 255));
        labBox16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox16.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox16.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox16.setPreferredSize(new java.awt.Dimension(50, 17));
        panel16.add(labBox16);

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

        labTime17.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime17.setForeground(new java.awt.Color(255, 255, 255));
        labTime17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime17.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime17.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labTime17);

        labS61.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS61.setForeground(new java.awt.Color(255, 255, 255));
        labS61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS61.setMaximumSize(new java.awt.Dimension(100, 17));
        labS61.setMinimumSize(new java.awt.Dimension(20, 17));
        labS61.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labS61);

        labS62.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS62.setForeground(new java.awt.Color(255, 255, 255));
        labS62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS62.setMaximumSize(new java.awt.Dimension(100, 17));
        labS62.setMinimumSize(new java.awt.Dimension(20, 17));
        labS62.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labS62);

        labS63.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS63.setForeground(new java.awt.Color(255, 255, 255));
        labS63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS63.setMaximumSize(new java.awt.Dimension(100, 17));
        labS63.setMinimumSize(new java.awt.Dimension(20, 17));
        labS63.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labS63);

        labDelta17.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta17.setForeground(new java.awt.Color(255, 255, 0));
        labDelta17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta17.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta17.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labDelta17);

        labLast17.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast17.setForeground(new java.awt.Color(255, 255, 255));
        labLast17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast17.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast17.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labLast17);

        labBest17.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest17.setForeground(new java.awt.Color(255, 255, 255));
        labBest17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest17.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest17.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labBest17);

        labLap17.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap17.setForeground(new java.awt.Color(255, 255, 255));
        labLap17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap17.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap17.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labLap17);

        labTyre17.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre17.setForeground(new java.awt.Color(255, 255, 255));
        labTyre17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre17.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre17.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labTyre17);

        labBox17.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox17.setForeground(new java.awt.Color(255, 255, 255));
        labBox17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox17.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox17.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox17.setPreferredSize(new java.awt.Dimension(50, 17));
        panel17.add(labBox17);

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

        labTime18.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime18.setForeground(new java.awt.Color(255, 255, 255));
        labTime18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime18.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime18.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labTime18);

        labS64.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS64.setForeground(new java.awt.Color(255, 255, 255));
        labS64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS64.setMaximumSize(new java.awt.Dimension(100, 17));
        labS64.setMinimumSize(new java.awt.Dimension(20, 17));
        labS64.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labS64);

        labS65.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS65.setForeground(new java.awt.Color(255, 255, 255));
        labS65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS65.setMaximumSize(new java.awt.Dimension(100, 17));
        labS65.setMinimumSize(new java.awt.Dimension(20, 17));
        labS65.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labS65);

        labS66.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS66.setForeground(new java.awt.Color(255, 255, 255));
        labS66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS66.setMaximumSize(new java.awt.Dimension(100, 17));
        labS66.setMinimumSize(new java.awt.Dimension(20, 17));
        labS66.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labS66);

        labDelta18.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta18.setForeground(new java.awt.Color(255, 255, 0));
        labDelta18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta18.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta18.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labDelta18);

        labLast18.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast18.setForeground(new java.awt.Color(255, 255, 255));
        labLast18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast18.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast18.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labLast18);

        labBest18.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest18.setForeground(new java.awt.Color(255, 255, 255));
        labBest18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest18.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest18.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labBest18);

        labLap18.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap18.setForeground(new java.awt.Color(255, 255, 255));
        labLap18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap18.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap18.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labLap18);

        labTyre18.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre18.setForeground(new java.awt.Color(255, 255, 255));
        labTyre18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre18.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre18.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labTyre18);

        labBox18.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox18.setForeground(new java.awt.Color(255, 255, 255));
        labBox18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox18.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox18.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox18.setPreferredSize(new java.awt.Dimension(50, 17));
        panel18.add(labBox18);

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

        labTime19.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime19.setForeground(new java.awt.Color(255, 255, 255));
        labTime19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime19.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime19.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labTime19);

        labS67.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS67.setForeground(new java.awt.Color(255, 255, 255));
        labS67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS67.setMaximumSize(new java.awt.Dimension(100, 17));
        labS67.setMinimumSize(new java.awt.Dimension(20, 17));
        labS67.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labS67);

        labS68.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS68.setForeground(new java.awt.Color(255, 255, 255));
        labS68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS68.setMaximumSize(new java.awt.Dimension(100, 17));
        labS68.setMinimumSize(new java.awt.Dimension(20, 17));
        labS68.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labS68);

        labS69.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS69.setForeground(new java.awt.Color(255, 255, 255));
        labS69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS69.setMaximumSize(new java.awt.Dimension(100, 17));
        labS69.setMinimumSize(new java.awt.Dimension(20, 17));
        labS69.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labS69);

        labDelta19.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta19.setForeground(new java.awt.Color(255, 255, 0));
        labDelta19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta19.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta19.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labDelta19);

        labLast19.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast19.setForeground(new java.awt.Color(255, 255, 255));
        labLast19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast19.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast19.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labLast19);

        labBest19.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest19.setForeground(new java.awt.Color(255, 255, 255));
        labBest19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest19.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest19.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labBest19);

        labLap19.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap19.setForeground(new java.awt.Color(255, 255, 255));
        labLap19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap19.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap19.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labLap19);

        labTyre19.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre19.setForeground(new java.awt.Color(255, 255, 255));
        labTyre19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre19.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre19.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labTyre19);

        labBox19.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox19.setForeground(new java.awt.Color(255, 255, 255));
        labBox19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox19.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox19.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox19.setPreferredSize(new java.awt.Dimension(50, 17));
        panel19.add(labBox19);

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

        labTime20.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTime20.setForeground(new java.awt.Color(255, 255, 255));
        labTime20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTime20.setMaximumSize(new java.awt.Dimension(100, 17));
        labTime20.setMinimumSize(new java.awt.Dimension(20, 17));
        labTime20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labTime20);

        labS70.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS70.setForeground(new java.awt.Color(255, 255, 255));
        labS70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS70.setMaximumSize(new java.awt.Dimension(100, 17));
        labS70.setMinimumSize(new java.awt.Dimension(20, 17));
        labS70.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labS70);

        labS71.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS71.setForeground(new java.awt.Color(255, 255, 255));
        labS71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS71.setMaximumSize(new java.awt.Dimension(100, 17));
        labS71.setMinimumSize(new java.awt.Dimension(20, 17));
        labS71.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labS71);

        labS72.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labS72.setForeground(new java.awt.Color(255, 255, 255));
        labS72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labS72.setMaximumSize(new java.awt.Dimension(100, 17));
        labS72.setMinimumSize(new java.awt.Dimension(20, 17));
        labS72.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labS72);

        labDelta20.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labDelta20.setForeground(new java.awt.Color(255, 255, 0));
        labDelta20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDelta20.setMaximumSize(new java.awt.Dimension(100, 17));
        labDelta20.setMinimumSize(new java.awt.Dimension(20, 17));
        labDelta20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labDelta20);

        labLast20.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLast20.setForeground(new java.awt.Color(255, 255, 255));
        labLast20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLast20.setMaximumSize(new java.awt.Dimension(100, 17));
        labLast20.setMinimumSize(new java.awt.Dimension(20, 17));
        labLast20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labLast20);

        labBest20.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBest20.setForeground(new java.awt.Color(255, 255, 255));
        labBest20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBest20.setMaximumSize(new java.awt.Dimension(100, 17));
        labBest20.setMinimumSize(new java.awt.Dimension(20, 17));
        labBest20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labBest20);

        labLap20.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labLap20.setForeground(new java.awt.Color(255, 255, 255));
        labLap20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labLap20.setMaximumSize(new java.awt.Dimension(40, 17));
        labLap20.setMinimumSize(new java.awt.Dimension(20, 17));
        labLap20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labLap20);

        labTyre20.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labTyre20.setForeground(new java.awt.Color(255, 255, 255));
        labTyre20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTyre20.setMaximumSize(new java.awt.Dimension(40, 25));
        labTyre20.setMinimumSize(new java.awt.Dimension(20, 17));
        labTyre20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labTyre20);

        labBox20.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labBox20.setForeground(new java.awt.Color(255, 255, 255));
        labBox20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labBox20.setMaximumSize(new java.awt.Dimension(40, 17));
        labBox20.setMinimumSize(new java.awt.Dimension(20, 17));
        labBox20.setPreferredSize(new java.awt.Dimension(50, 17));
        panel20.add(labBox20);

        panelTiming.add(panel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 556, 1210, 27));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTiming, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSession, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTiming, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));

        manuView.setForeground(new java.awt.Color(255, 255, 255));
        manuView.setText("Sectors Time");
        manuView.setFont(new java.awt.Font("Formula1 Display Regular", 0, 12)); // NOI18N

        rbViewLatest.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        rbViewLatest.setFont(new java.awt.Font("Formula1 Display Regular", 0, 12)); // NOI18N
        rbViewLatest.setSelected(true);
        rbViewLatest.setText("Latest");
        rbViewLatest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbViewLatestActionPerformed(evt);
            }
        });
        manuView.add(rbViewLatest);

        rbViewCurrent.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        rbViewCurrent.setFont(new java.awt.Font("Formula1 Display Regular", 0, 12)); // NOI18N
        rbViewCurrent.setText("Current");
        rbViewCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbViewCurrentActionPerformed(evt);
            }
        });
        manuView.add(rbViewCurrent);

        rbViewBest.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        rbViewBest.setFont(new java.awt.Font("Formula1 Display Regular", 0, 12)); // NOI18N
        rbViewBest.setText("Best");
        rbViewBest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbViewBestActionPerformed(evt);
            }
        });
        manuView.add(rbViewBest);

        jMenuBar1.add(manuView);

        menuGap.setForeground(new java.awt.Color(255, 255, 255));
        menuGap.setText("Delta");
        menuGap.setFont(new java.awt.Font("Formula1 Display Regular", 0, 12)); // NOI18N

        rbGap1st.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        rbGap1st.setFont(new java.awt.Font("Formula1 Display Regular", 0, 12)); // NOI18N
        rbGap1st.setSelected(true);
        rbGap1st.setText("To 1st");
        rbGap1st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGap1stActionPerformed(evt);
            }
        });
        menuGap.add(rbGap1st);

        rbGapNext.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        rbGapNext.setFont(new java.awt.Font("Formula1 Display Regular", 0, 12)); // NOI18N
        rbGapNext.setText("To next");
        rbGapNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGapNextActionPerformed(evt);
            }
        });
        menuGap.add(rbGapNext);

        rbGapUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        rbGapUser.setFont(new java.awt.Font("Formula1 Display Regular", 0, 12)); // NOI18N
        rbGapUser.setText("User Delta");
        rbGapUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGapUserActionPerformed(evt);
            }
        });
        menuGap.add(rbGapUser);

        jMenuBar1.add(menuGap);

        setJMenuBar(jMenuBar1);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        thread.controller.removePaso(thread.paso);
        thread.killOtherThreads();
    }//GEN-LAST:event_formWindowClosing

    private void rbViewLatestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbViewLatestActionPerformed
        sectorsOption = LATEST;
        thread.paso.abrir();
    }//GEN-LAST:event_rbViewLatestActionPerformed

    private void rbViewCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbViewCurrentActionPerformed
        sectorsOption = CURRENT;
        thread.paso.abrir();
    }//GEN-LAST:event_rbViewCurrentActionPerformed

    private void rbViewBestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbViewBestActionPerformed
        sectorsOption = BEST;
        thread.paso.abrir();
    }//GEN-LAST:event_rbViewBestActionPerformed

    private void rbGap1stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGap1stActionPerformed
        deltaOption = DELTA_1ST;
        thread.paso.abrir();
    }//GEN-LAST:event_rbGap1stActionPerformed

    private void rbGapNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGapNextActionPerformed
        deltaOption = DELTA_NEXT;
        thread.paso.abrir();
    }//GEN-LAST:event_rbGapNextActionPerformed

    private void rbGapUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGapUserActionPerformed
        deltaOption = DELTA_USER;
        thread.paso.abrir();
    }//GEN-LAST:event_rbGapUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labBest0;
    private javax.swing.JLabel labBest1;
    private javax.swing.JLabel labBest10;
    private javax.swing.JLabel labBest11;
    private javax.swing.JLabel labBest12;
    private javax.swing.JLabel labBest13;
    private javax.swing.JLabel labBest14;
    private javax.swing.JLabel labBest15;
    private javax.swing.JLabel labBest16;
    private javax.swing.JLabel labBest17;
    private javax.swing.JLabel labBest18;
    private javax.swing.JLabel labBest19;
    private javax.swing.JLabel labBest2;
    private javax.swing.JLabel labBest20;
    private javax.swing.JLabel labBest3;
    private javax.swing.JLabel labBest4;
    private javax.swing.JLabel labBest5;
    private javax.swing.JLabel labBest6;
    private javax.swing.JLabel labBest7;
    private javax.swing.JLabel labBest8;
    private javax.swing.JLabel labBest9;
    private javax.swing.JLabel labBox1;
    private javax.swing.JLabel labBox10;
    private javax.swing.JLabel labBox11;
    private javax.swing.JLabel labBox12;
    private javax.swing.JLabel labBox13;
    private javax.swing.JLabel labBox14;
    private javax.swing.JLabel labBox15;
    private javax.swing.JLabel labBox16;
    private javax.swing.JLabel labBox17;
    private javax.swing.JLabel labBox18;
    private javax.swing.JLabel labBox19;
    private javax.swing.JLabel labBox2;
    private javax.swing.JLabel labBox20;
    private javax.swing.JLabel labBox3;
    private javax.swing.JLabel labBox4;
    private javax.swing.JLabel labBox5;
    private javax.swing.JLabel labBox6;
    private javax.swing.JLabel labBox7;
    private javax.swing.JLabel labBox8;
    private javax.swing.JLabel labBox9;
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
    private javax.swing.JLabel labDelta1;
    private javax.swing.JLabel labDelta10;
    private javax.swing.JLabel labDelta11;
    private javax.swing.JLabel labDelta12;
    private javax.swing.JLabel labDelta13;
    private javax.swing.JLabel labDelta14;
    private javax.swing.JLabel labDelta15;
    private javax.swing.JLabel labDelta16;
    private javax.swing.JLabel labDelta17;
    private javax.swing.JLabel labDelta18;
    private javax.swing.JLabel labDelta19;
    private javax.swing.JLabel labDelta2;
    private javax.swing.JLabel labDelta20;
    private javax.swing.JLabel labDelta3;
    private javax.swing.JLabel labDelta4;
    private javax.swing.JLabel labDelta5;
    private javax.swing.JLabel labDelta6;
    private javax.swing.JLabel labDelta7;
    private javax.swing.JLabel labDelta8;
    private javax.swing.JLabel labDelta9;
    private javax.swing.JLabel labLap0;
    private javax.swing.JLabel labLap1;
    private javax.swing.JLabel labLap10;
    private javax.swing.JLabel labLap11;
    private javax.swing.JLabel labLap12;
    private javax.swing.JLabel labLap13;
    private javax.swing.JLabel labLap14;
    private javax.swing.JLabel labLap15;
    private javax.swing.JLabel labLap16;
    private javax.swing.JLabel labLap17;
    private javax.swing.JLabel labLap18;
    private javax.swing.JLabel labLap19;
    private javax.swing.JLabel labLap2;
    private javax.swing.JLabel labLap20;
    private javax.swing.JLabel labLap3;
    private javax.swing.JLabel labLap4;
    private javax.swing.JLabel labLap5;
    private javax.swing.JLabel labLap6;
    private javax.swing.JLabel labLap7;
    private javax.swing.JLabel labLap8;
    private javax.swing.JLabel labLap9;
    private javax.swing.JLabel labLast0;
    private javax.swing.JLabel labLast1;
    private javax.swing.JLabel labLast10;
    private javax.swing.JLabel labLast11;
    private javax.swing.JLabel labLast12;
    private javax.swing.JLabel labLast13;
    private javax.swing.JLabel labLast14;
    private javax.swing.JLabel labLast15;
    private javax.swing.JLabel labLast16;
    private javax.swing.JLabel labLast17;
    private javax.swing.JLabel labLast18;
    private javax.swing.JLabel labLast19;
    private javax.swing.JLabel labLast2;
    private javax.swing.JLabel labLast20;
    private javax.swing.JLabel labLast3;
    private javax.swing.JLabel labLast4;
    private javax.swing.JLabel labLast5;
    private javax.swing.JLabel labLast6;
    private javax.swing.JLabel labLast7;
    private javax.swing.JLabel labLast8;
    private javax.swing.JLabel labLast9;
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
    private javax.swing.JLabel labPit0;
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
    private javax.swing.JLabel labS11;
    private javax.swing.JLabel labS12;
    private javax.swing.JLabel labS13;
    private javax.swing.JLabel labS14;
    private javax.swing.JLabel labS15;
    private javax.swing.JLabel labS16;
    private javax.swing.JLabel labS17;
    private javax.swing.JLabel labS18;
    private javax.swing.JLabel labS19;
    private javax.swing.JLabel labS20;
    private javax.swing.JLabel labS21;
    private javax.swing.JLabel labS22;
    private javax.swing.JLabel labS23;
    private javax.swing.JLabel labS24;
    private javax.swing.JLabel labS25;
    private javax.swing.JLabel labS26;
    private javax.swing.JLabel labS27;
    private javax.swing.JLabel labS28;
    private javax.swing.JLabel labS29;
    private javax.swing.JLabel labS30;
    private javax.swing.JLabel labS31;
    private javax.swing.JLabel labS32;
    private javax.swing.JLabel labS33;
    private javax.swing.JLabel labS34;
    private javax.swing.JLabel labS35;
    private javax.swing.JLabel labS36;
    private javax.swing.JLabel labS37;
    private javax.swing.JLabel labS38;
    private javax.swing.JLabel labS39;
    private javax.swing.JLabel labS40;
    private javax.swing.JLabel labS41;
    private javax.swing.JLabel labS42;
    private javax.swing.JLabel labS43;
    private javax.swing.JLabel labS44;
    private javax.swing.JLabel labS45;
    private javax.swing.JLabel labS46;
    private javax.swing.JLabel labS47;
    private javax.swing.JLabel labS48;
    private javax.swing.JLabel labS49;
    private javax.swing.JLabel labS50;
    private javax.swing.JLabel labS51;
    private javax.swing.JLabel labS52;
    private javax.swing.JLabel labS53;
    private javax.swing.JLabel labS54;
    private javax.swing.JLabel labS55;
    private javax.swing.JLabel labS56;
    private javax.swing.JLabel labS57;
    private javax.swing.JLabel labS58;
    private javax.swing.JLabel labS59;
    private javax.swing.JLabel labS60;
    private javax.swing.JLabel labS61;
    private javax.swing.JLabel labS62;
    private javax.swing.JLabel labS63;
    private javax.swing.JLabel labS64;
    private javax.swing.JLabel labS65;
    private javax.swing.JLabel labS66;
    private javax.swing.JLabel labS67;
    private javax.swing.JLabel labS68;
    private javax.swing.JLabel labS69;
    private javax.swing.JLabel labS70;
    private javax.swing.JLabel labS71;
    private javax.swing.JLabel labS72;
    private javax.swing.JLabel labTime0;
    private javax.swing.JLabel labTime1;
    private javax.swing.JLabel labTime10;
    private javax.swing.JLabel labTime11;
    private javax.swing.JLabel labTime12;
    private javax.swing.JLabel labTime13;
    private javax.swing.JLabel labTime14;
    private javax.swing.JLabel labTime15;
    private javax.swing.JLabel labTime16;
    private javax.swing.JLabel labTime17;
    private javax.swing.JLabel labTime18;
    private javax.swing.JLabel labTime19;
    private javax.swing.JLabel labTime2;
    private javax.swing.JLabel labTime20;
    private javax.swing.JLabel labTime3;
    private javax.swing.JLabel labTime4;
    private javax.swing.JLabel labTime5;
    private javax.swing.JLabel labTime6;
    private javax.swing.JLabel labTime7;
    private javax.swing.JLabel labTime8;
    private javax.swing.JLabel labTime9;
    private javax.swing.JLabel labTyre0;
    private javax.swing.JLabel labTyre1;
    private javax.swing.JLabel labTyre10;
    private javax.swing.JLabel labTyre11;
    private javax.swing.JLabel labTyre12;
    private javax.swing.JLabel labTyre13;
    private javax.swing.JLabel labTyre14;
    private javax.swing.JLabel labTyre15;
    private javax.swing.JLabel labTyre16;
    private javax.swing.JLabel labTyre17;
    private javax.swing.JLabel labTyre18;
    private javax.swing.JLabel labTyre19;
    private javax.swing.JLabel labTyre2;
    private javax.swing.JLabel labTyre20;
    private javax.swing.JLabel labTyre3;
    private javax.swing.JLabel labTyre4;
    private javax.swing.JLabel labTyre5;
    private javax.swing.JLabel labTyre6;
    private javax.swing.JLabel labTyre7;
    private javax.swing.JLabel labTyre8;
    private javax.swing.JLabel labTyre9;
    public javax.swing.JLabel lab_airTemperature;
    public javax.swing.JLabel lab_bestS1;
    public javax.swing.JLabel lab_bestS2;
    public javax.swing.JLabel lab_bestS3;
    public javax.swing.JLabel lab_bestTotal;
    public javax.swing.JLabel lab_remaining;
    public javax.swing.JLabel lab_trackTemperature;
    public javax.swing.JLabel lab_weather;
    public javax.swing.JLabel lab_weather_text;
    private javax.swing.JMenu manuView;
    private javax.swing.JMenu menuGap;
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
    private javax.swing.JPanel panelSession;
    public javax.swing.JPanel panelTiming;
    private javax.swing.JRadioButtonMenuItem rbGap1st;
    private javax.swing.JRadioButtonMenuItem rbGapNext;
    private javax.swing.JRadioButtonMenuItem rbGapUser;
    private javax.swing.JRadioButtonMenuItem rbViewBest;
    private javax.swing.JRadioButtonMenuItem rbViewCurrent;
    private javax.swing.JRadioButtonMenuItem rbViewLatest;
    private javax.swing.JLabel space;
    private javax.swing.JLabel space1;
    private javax.swing.JLabel space2;
    private javax.swing.JLabel space3;
    private javax.swing.JLabel space4;
    private javax.swing.JLabel space5;
    private javax.swing.JLabel space6;
    private javax.swing.JLabel space7;
    // End of variables declaration//GEN-END:variables
}
