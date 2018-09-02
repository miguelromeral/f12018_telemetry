/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFrame;
import classes.Controller;

/**
 *
 * @author miguelangel.garciar
 */
public class Main extends javax.swing.JFrame {

    public Controller controller;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        controller = new Controller(18027);
       /*
        // Type 0:
        byte[] cont4 = {-30, 7, 1, 0, 9, -110, 73, 109, 127, 86,
            -44, -47, -44, 17, -33, 67, 45, 36, 0, 0,
            0,
            
            50, 122, -123, 67,
            27, -74, -103, -62,
            -16, 59, 28, -61,
            
            -16, -97, 64, -63,
            -118, -25, 66, 60,
            -36, 45, -107, 65,
            
            -104,
            -70,
            96,
            -1,
            -118,
            107,
            118, -108, 1, 0,
            -104, -70, 95, 54, 81, -68, -66, -108, 62, -68, 62, 60, -96, -68, 52, -71, 18, -65, 37, -79, 42, -69, -96, -128, 106, -72, -35, 1, -85, 67, -83, -89, -123, -62, 99, -15, 7, -60, 20, 20, -32, 65, -37, 58, -81, -65, 117, 111, 77, -65, -43, 127, 10, -6, -113, -3, 48, 2, -120, -6, -36, 127, 8, 4, -66, -65, -55, 4, -68, -67, 16, -20, -106, -66, 67, 65, -53, 63, 86, 17, 66, 61, -116, 33, 47, 61, -9, 126, -107, 67, -72, -116, -103, -62, -17, -54, 77, -61, 34, 107, 63, -63, 5, -105, -75, -67, -113, -44, -109, 65, 114, -70, 70, -1, 114, 107, -114, -108, -12, -1, 114, -70, 61, 104, 23, -68, 50, -98, -98, -69, 126, -111, 65, 61, -65, 18, 19, -65, 30, -119, 95, -69, -79, 109, -53, 57, -8, -44, 38, 67, 27, -39, 99, -62, 110, 13, 18, -60, -6, 94, -21, 65, 121, 18, -114, -65, 7, -105, 115, -63, 33, 114, 68, -5, 65, -58, -88, 57, -75, -4, 57, 114, -127, 51, -82, -65, 29, -66, -107, -65, 44, 75, 66, -66, 58, 120, 2, 64, -13, -30, 54, 61, 22, -11, -46, 60, -126, -94, -78, 67, 56, 67, -105, -62, -61, -55, -109, -61, -78, 48, 14, -62, -36, -102, 118, -65, 107, -48, 90, 66, 65, -70, 1, -2, 78, 107, -81, -108, 20, 0, 63, -70, 22, -99, -45, 60, 10, -95, 85, -64, -54, -104, -31, -67, 8, -119, 19, -65, 54, -79, 2, -68, 20, -101, 35, -70, 6, 53, -37, 67, -107, -5, -112, -62, 22, -22, -30, -61, -21, 23, 83, 65, -23, -109, -15, -65, -118, -2, 83, 66, -67, 30, -61, -5, 45, 124, -50, -125, 61, -5, -107, 30, -74, 102, 55, -64, 125, 12, 48, 63, -64, 12, 37, 63, 109, 116, 120, 62, 80, -1, -26, -68, 113, 121, 24, 61, -103, 35, 60, 67, 122, 48, 104, -62, -123, -78, 19, -60, 95, 106, -8, 65, 11, -25, -15, -65, 105, 1, 92, -64, -49, 126, 17, -8, -115, -16, 94, 15, 60, -2, 14, 127, -108, 94, -30, -65, -128, -47, -8, -66, 21, 85, 68, -67, 9, -128, -40, 63, 52, -118, -127, 61, 112, 21, 98, 60, 11, 3, -60, 67, -45, 127, -118, -62, 38, 19, 2, -60, -113, -24, -2, 65, 86, -87, -32, -65, 9, -83, -65, 65, 48, 102, -114, -6, -31, 76, -8, -78, -9, -4, 44, 102, 51, 8, -127, -66, 107, 16, -107, 63, 24, 31, -117, -66, -120, -61, 108, 63, 92, -118, -95, 60, 115, 126, -62, 60, 64, -49, -59, 67, -8, 75, -107, -62, -123, 75, -79, -61, 53, -102, -10, -63, -20, 26, 41, -65, 63, -121, 59, 66, -95, -71, -121, -2, -25, 106, 24, -107, -21, -1, -97, -71, -38, -112, 44, 62, -13, 121, 108, 63, 18, 69, 64, 61, 122, 8, 21, -65, 35, 106, -31, -69, -107, 77, 42, 58, 49, -98, -79, 67, 38, -82, -122, -62, 114, -126, 7, -60, -4, -43, -21, 65, 18, 57, -88, -65, -93, 65, 4, 65, 88, 123, 105, -6, -69, 33, 34, -34, 85, -3, 103, 123, -19, 66, -2, -65, -3, 80, 89, 63, -78, -106, -66, 61, 31, -62, -90, 63, -98, 6, 22, 61, 114, -37, -86, 60, -121, 71, 97, 67, -20, -115, 110, -62, 98, 119, 17, -60, -96, 85, -30, 65, -74, 86, -93, -65, -120, 33, -110, 65, 14, 108, 1, -5, 107, 68, -128, -69, 15, -1, 30, 108, 90, -97, -27, -65, 34, 102, 52, 63, -114, -103, -102, 60, -18, -67, -128, 63, 100, 21, -18, 60, -108, 18, -15, 59, 97, 86, -53, 67, 98, 32, -116, -62, 22, 21, -2, -61, -101, 42, -2, 65, -78, -88, -27, -65, -104, 90, -14, 65, -19, 92, -65, -6, -36, 87, 1, -88, 81, -3, -23, 92, 44, 83, -38, -65, 110, -4, 57, 63, 90, -63, -45, 62, -49, 9, 80, 63, -65, 96, 124, 60, -40, -1, -85, 60, -80, 120, -118, 67, 56, -128, -126, -62, 49, 32, -47, -61, 24, 117, -80, -63, -80, -108, -27, 62, -118, -29, 69, -63, -17, -112, -18, 1, 107, -64, -105, 63, 50, 0, -20, -112, -98, -105, -96, 63, -121, 15, 69, 63, 118, 1, 26, -67, 84, -49, 5, -64, -114, 62, 74, 60, 34, -119, -55, -70, -124, 87, 47, 67, -104, 91, 101, -62, 94, -9, 18, -60, 120, 55, -8, 65, -52, -6, -64, -65, 87, 116, 46, -63, -61, 120, 111, -7, 26, -42, -34, 41, 71, -2, -15, 120, -83, -28, 2, -64, -125, 28, 96, -65, 120, -128, 126, 62, -75, -57, -13, 63, -32, -67, 88, 61, 30, -4, 92, 60, 117, -83, -93, 67, -30, -8, -125, -62, 38, 62, 7, -60, 10, 26, -43, 65, -92, 117, -8, -65, 82, -73, 34, -63, 31, 118, -39, -10, -111, -49, -120, 48, -102, -1, 112, 118, 52, -68, 10, -64, -46, -52, 34, -65, -84, -50, -37, 62, -78, -11, -6, 63, 120, 20, -118, 61, -98, 36, 77, 59, 75, 51, 6, 67, -101, -38, 112, -62, 0, 126, -51, -61, 33, 102, 53, -62, 50, -35, -48, 63, -98, -13, -98, 65, -1, -118, 7, 4, -69, 51, 33, -52, 33, -6, 35, -117, -111, -5, -57, -65, -16, 53, 41, -65, 46, 62, 88, 62, 52, -90, -109, -65, -87, -39, 38, 60, -96, 17, 60, 61, 121, 61, 74, 67, 113, -72, 106, -62, -49, -92, 19, -60, -67, -115, -17, 65, -16, -37, -89, -65, 19, -14, -122, 64, -66, 126, 109, -6, -6, 16, -7, -18, 38, -1, -38, 126, -9, -4, -24, -65, -126, 126, 54, 62, 61, 100, 38, -66, 46, -9, -73, 63, -111, 73, 45, 61, -69, 121, -38, 59, 84, -88, -50, 67, -51, -88, -108, -62, 37, -80, -84, -61, -109, 97, 16, -62, -7, 108, -92, -65, -72, 116, 85, 66, 55, -72, 12, -2, -13, 105, 18, -106, -33, -3, 48, -72, 127, 114, -46, -66, 74, 91, -17, 62, 42, 17, 18, -65, 84, 121, 24, -65, 62, 32, -73, -68, 89, 114, -120, 60, -59, 57, -53, 67, -9, 100, -115, -62, 93, 125, -11, -61, -82, 13, -41, 65, -49, 0, 26, -65, 25, -44, 12, 66, -68, 77, -21, -3, -87, 101, 84, -102, 106, 0, -64, 77, -77, -114, -87, -66, 14, 22, 115, 63, -28, 106, -123, 63, 114, 28, 39, 63, -30, 48, 76, 60, 54, 73, 84, -69, 41, -86, 126, 66, -4, -42, -100, -62, 122, 125, 63, 67, 2, -118, 60, -62, -58, 114, -62, -65, -121, -110, -109, 66, 34, -69, -39, -3, -34, 107, 39, -108, -38, -3, 26, -69, 57, 19, 44, -67, 114, -64, -112, 61, -28, -46, 77, -67, 17, 124, 17, -65, -18, 73, -66, -68, 33, -63, -119, 60, 35, -17, -111, 63, 90, 10, -114, 63, -43, 44, 75, 64, 64, -100, 76, 64, -74, -95, 48, -62, 52, 67, 64, -62, 37, -68, -89, 65, 7, 63, -110, 65, -78, -64, -56, -60, -125, -20, -23, -60, 60, -109, -123, 68, -9, -98, 90, 68, -58, -108, -79, 65, -110, -108, -79, 65, -80, -90, -79, 65, -15, -90, -79, 65, -79, -23, -103, -71, -92, -51, -101, -71, -124, 38, 48, 56, -84, 101, 60, 56, 41, 59, 80, -69, -35, -95, -10, 61, -47, -112, -79, 65, 121, -14, 48, 62, -128, 101, -113, 56, 74, -68, -43, 61, 83, 32, 68, -65, -97, -111, 88, -67, -127, -91, 57, -65, -34, -41, -65, 57, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };
        controller.newPacket(cont4);
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("F1 2018 Telemetry");
        setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        jButton1.setText("Live Telemetry");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        jButton2.setText("Session Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Formula1 Display Bold", 0, 14)); // NOI18N
        jButton3.setText("Live Timing");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Console(controller).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new SessionData(controller).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new LiveTiming(controller).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
