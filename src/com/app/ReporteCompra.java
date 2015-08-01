/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReporteVenta.java
 *
 * Created on 15/11/2013, 01:56:54 PM
 */
package com.app;

import com.entidades.Articulo;
import com.entidades.CompraCab;
import com.entidades.CompraDet;
import com.entidades.Proveedor;
import com.entidades.VentaCab;
import com.reportes.IniciarReportes;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import util.HibernateUtil;

/**
 *
 * @author Geek
 */
public class ReporteCompra extends javax.swing.JDialog {

    /** Creates new form ReporteVenta */
    public ReporteCompra(java.awt.Frame parent, boolean modal) {
       super(parent, modal);
        initComponents();        
        setLocationRelativeTo(null);
        hibernateSession();
        arranque();        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        listaF.setEnabled(false);
    }
    private Session st;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        listaA = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jFecha1 = new com.toedter.calendar.JDateChooser();
        jFecha2 = new com.toedter.calendar.JDateChooser();
        btnGuardar = new org.edisoncor.gui.button.ButtonSeven();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jFecha3 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jFecha4 = new com.toedter.calendar.JDateChooser();
        btnGuardar1 = new org.edisoncor.gui.button.ButtonSeven();
        jRadioButton3 = new javax.swing.JRadioButton();
        listaF = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        listaP = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jFecha5 = new com.toedter.calendar.JDateChooser();
        jFecha6 = new com.toedter.calendar.JDateChooser();
        btnGuardar2 = new org.edisoncor.gui.button.ButtonSeven();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario de Reportes");
        setBackground(new java.awt.Color(255, 255, 255));
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte por Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comfortaa", 0, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Fechas inicio (día/mes/año)");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Fechas fin (días/mes/año)");

        listaA.setEditable(true);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Productos");

        btnGuardar.setBackground(new java.awt.Color(0, 204, 0));
        btnGuardar.setText("Ver");
        btnGuardar.setFont(new java.awt.Font("Comfortaa", 1, 14)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listaA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comfortaa", 0, 14))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setText("Fechas inicio (día/mes/año)");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText("Fechas fin (días/mes/año)");

        btnGuardar1.setBackground(new java.awt.Color(0, 204, 0));
        btnGuardar1.setText("Ver");
        btnGuardar1.setFont(new java.awt.Font("Comfortaa", 1, 14)); // NOI18N
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Comfortaa", 3, 12)); // NOI18N
        jRadioButton3.setText("¿Detalle por Factura?");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        listaF.setEditable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(listaF, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jFecha4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jRadioButton3)))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFecha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setText("Reporte de Compras");

        jLabel16.setFont(new java.awt.Font("Comfortaa", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("Datos agrupados que se transforman en informacion. . . ");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Comfortaa", 3, 12)); // NOI18N
        jLabel1.setText("Esc para salir. . .");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte por Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comfortaa", 0, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setText("Fechas inicio (día/mes/año)");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Fechas fin (días/mes/año)");

        listaP.setEditable(true);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Proveedores");

        btnGuardar2.setBackground(new java.awt.Color(0, 204, 0));
        btnGuardar2.setText("Ver");
        btnGuardar2.setFont(new java.awt.Font("Comfortaa", 1, 14)); // NOI18N
        btnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jFecha6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFecha5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFecha5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFecha6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel16))
                    .addComponent(jLabel7)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(427, 427, 427))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // TODO add your handling code here:
            
            SimpleDateFormat formato = new SimpleDateFormat("yyMMdd");
            String fecha = formato.format(jFecha1.getDate());
            String fecha2 = formato.format(jFecha2.getDate());
            System.out.println(fecha);
            System.out.println(fecha2);
            Date f1 = formato.parse(fecha);
            Date f2= formato.parse(fecha2);
             if (this.listaA.getSelectedItem().equals(null)) {
                JOptionPane.showMessageDialog(null, "Seleccione un Producto");
             }else{
                    if (f1.after(f2)==true) {
                        JOptionPane.showMessageDialog(null, "Seleccione una fecha valida");
                        jFecha1.requestFocus();
                    }else{
                            int idProd = ((Articulo)listaA.getSelectedItem()).getId();
                            System.out.println(idProd);
                            llamarReporteCompraProducto(idProd, f1,f2,null);
                        }
                    
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un problema, revise sus datos.");
            }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            
            SimpleDateFormat formato = new SimpleDateFormat("yyMMdd");
            String fecha3 = formato.format(jFecha3.getDate());
            String fecha4 = formato.format(jFecha4.getDate());
            System.out.println(fecha3);
            System.out.println(fecha4);
            Date f1 = formato.parse(fecha3);
            Date f2= formato.parse(fecha4);
            if (f1.after(f2)==true) {
                JOptionPane.showMessageDialog(null, "Seleccione una fecha valida");
                jFecha1.requestFocus();
            }else{
                if(jRadioButton3.isSelected()== true){
                    String NFac = ((CompraCab)listaF.getSelectedItem()).getNFactura();
                    llamarReporteCompraProducto(0, f1,f2,NFac);
                }else{
                    if(jRadioButton3.isSelected()==false){
                        llamarReporteCompraProducto(0, f1,f2,null);
                    }                    
                }
                
            }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un problema, revise sus datos.");
            }
        
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton3.isSelected()== true) {
            listaF.setEnabled(true);
        }else{
            listaF.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void btnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar2ActionPerformed
        // TODO add your handling code here:
        try {
            
            SimpleDateFormat formato = new SimpleDateFormat("yyMMdd");
            String fecha = formato.format(jFecha5.getDate());
            String fecha2 = formato.format(jFecha6.getDate());
            Date f1 = formato.parse(fecha);
            Date f2= formato.parse(fecha2);
             if (this.listaP.getSelectedItem().equals(null)) {
                JOptionPane.showMessageDialog(null, "Seleccione Proveedor");
             }else{
                    if (f1.after(f2)==true) {
                        JOptionPane.showMessageDialog(null, "Seleccione una fecha valida");
                        jFecha5.requestFocus();
                    }else{
                            if(listaP.getSelectedIndex()==0){
                                llamarReporteProveedor(0, f1, f2);
                            }else{
                            int idProv = ((Proveedor)listaP.getSelectedItem()).getId();
                            llamarReporteProveedor(idProv, f1,f2);
                        }
                    }
                    
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un problema, revise sus datos.");
            }
    }//GEN-LAST:event_btnGuardar2ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReporteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ReporteCompra dialog = new ReporteCompra(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonSeven btnGuardar;
    private org.edisoncor.gui.button.ButtonSeven btnGuardar1;
    private org.edisoncor.gui.button.ButtonSeven btnGuardar2;
    private com.toedter.calendar.JDateChooser jFecha1;
    private com.toedter.calendar.JDateChooser jFecha2;
    private com.toedter.calendar.JDateChooser jFecha3;
    private com.toedter.calendar.JDateChooser jFecha4;
    private com.toedter.calendar.JDateChooser jFecha5;
    private com.toedter.calendar.JDateChooser jFecha6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox listaA;
    private javax.swing.JComboBox listaF;
    private javax.swing.JComboBox listaP;
    // End of variables declaration//GEN-END:variables

    public void retornarFechaHoy(){
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date2 = new Date(stamp.getTime());
        System.out.println(date2);
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        
        jFecha1.setDate(date2);
        jFecha2.setDate(date2);
        jFecha3.setDate(date2);
        jFecha4.setDate(date2);
        jFecha5.setDate(date2);
        jFecha6.setDate(date2);
    }
    DefaultComboBoxModel combomodel;
     public void cargarCombo(){
        hibernateSession();
        combomodel=(DefaultComboBoxModel) listaA.getModel();
        combomodel.removeAllElements();
        combomodel.addElement("Selecione un Producto");
        List<Articulo> lista = (List<Articulo>)st.createQuery("From Articulo").list();
        for(Articulo tipoList : lista){
            combomodel.addElement(tipoList);            
        }
        listaA.setModel(combomodel);
    } 
     public void cargarCombo2(){
        hibernateSession();
        combomodel=(DefaultComboBoxModel) listaF.getModel();
        combomodel.removeAllElements();
        combomodel.addElement("Selecione el # de Factura");
        List<CompraCab> lista = (List<CompraCab>)st.createQuery("From CompraCab").list();
        for(CompraCab tipoList : lista){
            combomodel.addElement(tipoList);            
        }
        listaF.setModel(combomodel);
    }
     public void cargarCombo3(){
        hibernateSession();
        combomodel=(DefaultComboBoxModel) listaP.getModel();
        combomodel.removeAllElements();
        combomodel.addElement("General");
        List<Proveedor> lista = (List<Proveedor>)st.createQuery("From Proveedor").list();
        for(Proveedor tipoList : lista){
            combomodel.addElement(tipoList);            
        }
        listaP.setModel(combomodel);
    } 
   private void hibernateSession(){
    //Método para abrir una sesión hibernate.
    st = HibernateUtil.getSessionFactory().openSession();
}
private void arranque(){
    //Metodo para configurar los elementos de arranque
    Calendar cal = Calendar.getInstance();
    String fecha = retornarString(cal);
    //Creamos una lista de proveedores para llenar nuestro lista desplegable o comboBox.
    cargarCombo();
    cargarCombo2();
    cargarCombo3();
    AutoCompleteDecorator.decorate(this.listaA);
    AutoCompleteDecorator.decorate(this.listaF);
    AutoCompleteDecorator.decorate(this.listaP);
    addEscapeKey();
    retornarFechaHoy();
}
public void llamarReporteCompraProducto(int id, Date fecha1, Date fecha2, String NFactura) throws ParseException{
       IniciarReportes ir = new IniciarReportes();
       ir.ReporteCompras(id,fecha1,fecha2, NFactura);
}
public void llamarReporteProveedor(int idP, Date fecha1, Date fecha2){
    IniciarReportes ir = new IniciarReportes();
    ir.ReporteProveedor(idP, fecha1, fecha2);
}


private void addEscapeKey(){
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction(){
           @Override
           public void actionPerformed(ActionEvent e){
               dispose();
           }      
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }
    //Métodos para trabajar con objeto Calendar.
    public String retornarString(Calendar fecha){
            //Método que retorna un String de fecha pasándole como argumento un objeto Calendar.
            String retorno=null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            if (fecha != null) {
            retorno = sdf.format(fecha.getTime());
            }
            return retorno;
    }
    public Calendar retornarCalendar(String fecha){
            //Método que retorna un objeto Calendar pasando un String de fecha preformateado.
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
            Calendar cal = Calendar.getInstance();    
            try {
                cal.setTime(sdf.parse(fecha));
            } catch (ParseException ex) {
              JOptionPane.showMessageDialog(null, "Error; compruebe formato de fecha: " + ex);  
            }
            return cal;
    }

}
