/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Geek
 */
public class SeleccionarReporte extends javax.swing.JDialog {

    /**
     * Creates new form SeleccionarReporte
     */
    public SeleccionarReporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         setLocationRelativeTo(null);//Centrar Formulario.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNice1 = new org.edisoncor.gui.panel.PanelNice();
        panelCurves2 = new org.edisoncor.gui.panel.PanelCurves();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnPresentacion = new org.edisoncor.gui.button.ButtonSeven();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelNice1.setBackground(new java.awt.Color(0, 102, 153));

        panelCurves2.setBackground(new java.awt.Color(255, 0, 51));
        panelCurves2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/logotitulo.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Comfortaa", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/ventas_1.png"))); // NOI18N
        jLabel18.setText("Ventas");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Comfortaa", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/compras_1.png"))); // NOI18N
        jLabel19.setText("Compras");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comfortaa", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccione el tipo de reporte que desee visualizar.");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        btnPresentacion.setBackground(new java.awt.Color(255, 0, 51));
        btnPresentacion.setText("Salir");
        btnPresentacion.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        btnPresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPresentacionMouseClicked(evt);
            }
        });
        btnPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresentacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCurves2Layout = new javax.swing.GroupLayout(panelCurves2);
        panelCurves2.setLayout(panelCurves2Layout);
        panelCurves2Layout.setHorizontalGroup(
            panelCurves2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurves2Layout.createSequentialGroup()
                .addGroup(panelCurves2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCurves2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCurves2Layout.createSequentialGroup()
                        .addGroup(panelCurves2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCurves2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelCurves2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelCurves2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel18)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel19))
                            .addGroup(panelCurves2Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 40, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCurves2Layout.setVerticalGroup(
            panelCurves2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurves2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelCurves2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelNice1.add(panelCurves2, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelNice1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        this.dispose();
        llamarReporteVenta();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        this.dispose();
//        try {
//            //llamarReporteCompra();
//            JasperReport report  = (JasperReport)JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/ReporteCompras.jasper"));
//            JasperPrint jasperPrint = JasperFillManager.fillReport(report, null);
//            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
//            jviewer.setTitle("Compras Generales.");
//            jviewer.setVisible(true);
//        } catch (JRException e) {
//            JOptionPane.showMessageDialog(null, "Error cargando reporte." + e);
//        }
        llamarReporteCompra();
        
        
    }//GEN-LAST:event_jLabel19MouseClicked

    private void btnPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresentacionActionPerformed
        // TODO add your handling code here:
        this.dispose();

        
    }//GEN-LAST:event_btnPresentacionActionPerformed

    private void btnPresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPresentacionMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnPresentacionMouseClicked

     private void llamarReporteVenta() {
        ReporteVenta rv = new ReporteVenta(/*new javax.swing.JFrame(), true*/);
       // rv.setDefaultCloseOperation(HIDE_ON_CLOSE);
        rv.setTitle("Reportes de Ventas");
        rv.setVisible(true);
    }

    private void llamarReporteCompra() {
        Principal pr = new Principal();
        ReporteCompra rc = new ReporteCompra(pr, true);
       // rc.setDefaultCloseOperation(HIDE_ON_CLOSE);
        rc.setTitle("Reportes de Compras");
        rc.setVisible(true);
    }
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SeleccionarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SeleccionarReporte dialog = new SeleccionarReporte(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonSeven btnPresentacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JSeparator jSeparator1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves2;
    private org.edisoncor.gui.panel.PanelNice panelNice1;
    // End of variables declaration//GEN-END:variables
}
