/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.entidades.Articulo;
import com.entidades.VentaCab;
import com.entidades.VentaDet;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Geek
 */
public class pEstadisticasProducto extends javax.swing.JDialog {

    /**
     * Creates new form pEstadisticasProducto
     */
    private int idProd;
    public pEstadisticasProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        hibernateSession();
    }
     public pEstadisticasProducto(java.awt.Frame parent, boolean modal, int idProd) {
        super(parent, modal);
        initComponents();
        this.idProd=idProd;
        hibernateSession();
        retornarFechaHoy();
        listenerDateChooser();
        listenerDateChooser2();
        retornarCantidadArt();
        
        
    }
     private Session st;
    private DefaultTableModel model;
    
    public void hibernateSession(){
        st = HibernateUtil.getSessionFactory().openSession();
    }
     public void retornarFechaHoy(){
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date2 = new Date(stamp.getTime());
        System.out.println(date2);
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("" + formato.format(date2));
        jFecha1.setDate(date2);
        jFecha2.setDate(date2);
    }
     public void listenerDateChooser() {
       jFecha1.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                if ("date".equals(pce.getPropertyName())) {
                    arranque();
                }
            }
        });
    }
    public void listenerDateChooser2() {
        jFecha2.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                if ("date".equals(pce.getPropertyName())) {
                    arranque();
                }
            }
        });
    } 
    public void buscarArticulo(){

        try {
            Articulo art = (Articulo)st.load(Articulo.class, idProd);
            this.txtDes.setText(art.getDes());
            
            this.txtPres.setText(String.valueOf(art.getTipo().getDes()));
            this.txtCan.setText(String.valueOf(art.getCan()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay artículo con ID: " + idProd);
        }    
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
        Tablemodel();
        SimpleDateFormat formato = new SimpleDateFormat("YYMMdd");
        String fecha = formato.format(jFecha1.getDate());
        String fecha2 = formato.format(jFecha2.getDate());
        Query q = st.createQuery("From ventacab a where a.fecha between ? and ?");
        q.setParameter(0, fecha);
        q.setParameter(1, fecha2);
        List<VentaCab> lista = (List<VentaCab>) q.list();
        int contador=0;
        for (VentaCab ventaList : lista) {
            String date = "" + formato.format(ventaList.getFecha().getTime());
            if (date.equals(fecha)) {
                model.addRow(new Object[]{
                    ventaList.getNum(), ventaList.getFecha().getTime(), ventaList.getTotal()});
            }
        }
            txtCanVenTotal.setText(""+contador);
    }
    public void retornarCantidadArt(){
        
        Query q  = st.createQuery("sum(cant) From VentaDet where articulo_id = ? ");
        q.setParameter(0, idProd);
        List<VentaDet> lista = (List<VentaDet>)q.uniqueResult();
        txtCanVenTotal.setText(String.valueOf(lista));
        
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
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDes = new javax.swing.JTextField();
        txtCan = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCanVenTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPres = new javax.swing.JTextField();
        jFecha1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jFecha2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setText("Estadisticas por producto");

        jLabel16.setFont(new java.awt.Font("Comfortaa", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("Conozca a detalle los movimientos de su producto . . . ");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comfortaa", 1, 12))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setText("Producto:");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setText("Existencias: ");

        txtCan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCanFocusLost(evt);
            }
        });
        txtCan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCanKeyPressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setText("Cantidad Total V:");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setText("Presentacion:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setText("F.Inicio: ");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setText("F.Final: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCan, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCanVenTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtCanVenTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13))
                    .addComponent(jFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N. Venta", "Fecha V.", "Cant."
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jLabel16))
                        .addComponent(jLabel7)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(67, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel16)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(299, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCanFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCanFocusLost

    private void txtCanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCanKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCanKeyPressed

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
            java.util.logging.Logger.getLogger(pEstadisticasProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pEstadisticasProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pEstadisticasProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pEstadisticasProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pEstadisticasProducto dialog = new pEstadisticasProducto(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser jFecha1;
    private com.toedter.calendar.JDateChooser jFecha2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCan;
    private javax.swing.JTextField txtCanVenTotal;
    private javax.swing.JTextField txtDes;
    private javax.swing.JTextField txtPres;
    // End of variables declaration//GEN-END:variables
}