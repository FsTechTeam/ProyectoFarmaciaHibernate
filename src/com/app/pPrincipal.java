/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.entidades.VentaDet;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Geek
 */
public class pPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form pPrincipal
     */
    public pPrincipal() {
        initComponents();
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date2 = new Date(stamp.getTime());
        System.out.println(date2);
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("" + formato.format(date2));

        jDateChooser1.setDate(date2);
        listenerDateChooser();
        //jDateChooser1.setDateFormatString("dd/mm/yyyy");
        jTable1.setEnabled(false);
        hibernateSession();
        arranque();
        

        centrar();

        
    }
    private DefaultTableModel model;
    private Session st;

    private void hibernateSession() {
        st = HibernateUtil.getSessionFactory().openSession();
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
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        salidat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        buttonTransluceIcon1 = new org.edisoncor.gui.button.ButtonTransluceIcon();
        buttonTransluceIcon2 = new org.edisoncor.gui.button.ButtonTransluceIcon();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        buttonTransluceIcon3 = new org.edisoncor.gui.button.ButtonTransluceIcon();
        buttonTransluceIcon4 = new org.edisoncor.gui.button.ButtonTransluceIcon();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1002, 734));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NoOrden", "Paciente", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Ventas Totales:");

        salidat.setEditable(false);
        salidat.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N

        buttonTransluceIcon1.setBackground(new java.awt.Color(0, 204, 0));
        buttonTransluceIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/izq.png"))); // NOI18N
        buttonTransluceIcon1.setText("buttonTransluceIcon1");
        buttonTransluceIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTransluceIcon1MouseClicked(evt);
            }
        });

        buttonTransluceIcon2.setBackground(new java.awt.Color(0, 204, 0));
        buttonTransluceIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/der.png"))); // NOI18N
        buttonTransluceIcon2.setText("buttonTransluceIcon1");
        buttonTransluceIcon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonTransluceIcon2MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setText("Ordenes del dia:");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Pagado:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Pendiente:");

        buttonTransluceIcon3.setBackground(new java.awt.Color(51, 153, 0));

        buttonTransluceIcon4.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonTransluceIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonTransluceIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salidat, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonTransluceIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonTransluceIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salidat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTransluceIcon3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTransluceIcon4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonTransluceIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonTransluceIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTransluceIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTransluceIcon1MouseClicked
        // TODO add your handling code here:
        Date date = new Date(jDateChooser1.getDate().getTime() - 86400000);
        SimpleDateFormat formato = new SimpleDateFormat("YYMMdd");
        jDateChooser1.setDate(date);
        //arranque();
    }//GEN-LAST:event_buttonTransluceIcon1MouseClicked

    private void buttonTransluceIcon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonTransluceIcon2MouseClicked
        // TODO add your handling code here:
        Date date = new Date(jDateChooser1.getDate().getTime() + 86400000);
        SimpleDateFormat formato = new SimpleDateFormat("YYMMdd");
        jDateChooser1.setDate(date);
        //arranque();
    }//GEN-LAST:event_buttonTransluceIcon2MouseClicked

    public void centrar() {
        JTextFieldDateEditor fecha = (JTextFieldDateEditor) jDateChooser1.getComponent(1);
        fecha.setHorizontalAlignment(JTextField.CENTER);
    }

    public void listenerDateChooser() {
        jDateChooser1.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                if ("date".equals(pce.getPropertyName())) {
                    arranque();
                }
            }
        });
    }
    public void arranque() {
        Tablemodel();
        cargarTabla();
        
        
        
    }

    public void Tablemodel() {
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
        model = (DefaultTableModel)this.jTable1.getModel();
        model.setNumRows(0);
    }

    public void cargarTabla() {
        //System.out.println(""+jDateChooser1.getDate().toString());
       Tablemodel();
        SimpleDateFormat formato = new SimpleDateFormat("YYMMdd");
        String fecha = formato.format(jDateChooser1.getDate());
        System.out.println("" + fecha);
        List<VentaDet> lista = (List<VentaDet>) st.createQuery("From VentaDet group by VentaCab_num").list();
        System.out.println("" + lista.size());
        double contador=0;
        for (VentaDet ventaList : lista) {
            String date = "" + formato.format(ventaList.getVentaCab().getFecha().getTime());
            // System.out.println(""+formato.format(ventaList.getVentaCab().getFecha().getTime()));
            if (date.equals(fecha)) {
                model.addRow(new Object[]{
                    ventaList.getVentaCab().getNum(), ventaList.getVentaCab().getCliente().getDes() + " " + ventaList.getVentaCab().getCliente().getRuc(),"Q. " + ventaList.getVentaCab().getTotal()});
                contador=contador+ ventaList.getVentaCab().getTotal();
                contador = Math.rint(contador*100)/100;
                jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer());
                if (ventaList.getVentaCab().isPagado()==false) {
                    Color bgColor = new Color(130, 220, 100);
                    jTable1.setBackground(bgColor);
                    
                }
                
            }
        }
            salidat.setText("Q. "+contador);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonTransluceIcon buttonTransluceIcon1;
    private org.edisoncor.gui.button.ButtonTransluceIcon buttonTransluceIcon2;
    private org.edisoncor.gui.button.ButtonTransluceIcon buttonTransluceIcon3;
    private org.edisoncor.gui.button.ButtonTransluceIcon buttonTransluceIcon4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField salidat;
    // End of variables declaration//GEN-END:variables
}

