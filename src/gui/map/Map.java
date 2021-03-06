package gui.map;

import classes.Controller;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author miguelangel.garciar
 */
public class Map extends javax.swing.JFrame {

    Map_Thread thread;
    
    public Map(Controller controller) {
        initComponents();
        thread = new Map_Thread(controller, this);
        thread.start();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        map = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        jLabel6.setText("jLabel6");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Live Timing");
        setMinimumSize(new java.awt.Dimension(680, 680));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelMap.setBackground(new java.awt.Color(19, 19, 19));
        panelMap.setPreferredSize(new java.awt.Dimension(1248, 700));

        javax.swing.GroupLayout panelMapLayout = new javax.swing.GroupLayout(panelMap);
        panelMap.setLayout(panelMapLayout);
        panelMapLayout.setHorizontalGroup(
            panelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMapLayout.createSequentialGroup()
                .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        panelMapLayout.setVerticalGroup(
            panelMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMap, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelMap, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        thread.controller.removePaso(thread.paso);
        thread.killOtherThreads();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JLabel map;
    public final javax.swing.JPanel panelMap = new javax.swing.JPanel();
    // End of variables declaration//GEN-END:variables
}
