/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 04/12/2013, 09:31:29 AM
 */
package com.app;

import com.entidades.Articulo;
import com.entidades.VentaDet;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;
import javax.swing.JTabbedPane;

/**
 *
 * @author Geek
 */
public class Principal extends javax.swing.JFrame{

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        //Centrar Formulario.
        setLocationRelativeTo(null);
        jLabel4.setEnabled(true);
        //Arrancar maximizado el formulario
        setExtendedState(MAXIMIZED_BOTH);
        //Especificar un icono para la aplicación: "png" "jpg" 
        setIconImage(new ImageIcon(ClassLoader.getSystemResource("com/img/logos.png")).getImage());
       // jTable1.setRowHeight(30);

        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date2 = new Date(stamp.getTime());
        System.out.println(date2);
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("" + formato.format(date2));

        //jDateChooser1.setDate(date2);
        //listenerDateChooser();
        //jDateChooser1.setDateFormatString("dd/mm/yyyy");
        //jTable1.setEnabled(false);
        hibernateSession();
        //arranque();
        

        //centrar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        panelNice1 = new org.edisoncor.gui.panel.PanelNice();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Farmacia Gastroclinica");
        setIconImages(null);

        jToolBar1.setRollover(true);

        panelNice1.setBackground(new java.awt.Color(0, 102, 153));
        panelNice1.setForeground(new java.awt.Color(0, 102, 0));

        jLabel3.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/ventas_1.png"))); // NOI18N
        jLabel3.setText("Ventas");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Shopping-basket-icon.png"))); // NOI18N
        jLabel19.setText("Compras");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/logotitulo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Presentation-icon.png"))); // NOI18N
        jLabel4.setText(" Informes");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Search-good-icon.png"))); // NOI18N
        jLabel5.setText("Medicamentos");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Truck-icon.png"))); // NOI18N
        jLabel8.setText("Proveedores");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Comfortaa", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/peqV.png"))); // NOI18N
        jLabel21.setText("Ver Medicamentos");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Comfortaa", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/peqP.png"))); // NOI18N
        jLabel22.setText("Principal");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCurves1Layout = new javax.swing.GroupLayout(panelCurves1);
        panelCurves1.setLayout(panelCurves1Layout);
        panelCurves1Layout.setHorizontalGroup(
            panelCurves1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurves1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(panelCurves1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCurves1Layout.createSequentialGroup()
                        .addGroup(panelCurves1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCurves1Layout.createSequentialGroup()
                        .addGroup(panelCurves1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20))
                        .addGap(16, 16, 16))))
            .addGroup(panelCurves1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelCurves1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel19)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelCurves1Layout.setVerticalGroup(
            panelCurves1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCurves1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelNice1Layout = new javax.swing.GroupLayout(panelNice1);
        panelNice1.setLayout(panelNice1Layout);
        panelNice1Layout.setHorizontalGroup(
            panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNice1Layout.createSequentialGroup()
                .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelNice1Layout.setVerticalGroup(
            panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jToolBar1.add(panelNice1);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Referenciales");

        jMenuItem2.setText("Tipo de Artículos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Artículos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Clientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Usuarios");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Proveedores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Transacciones");

        jMenuItem7.setText("Ventas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Compras");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Informes");

        jMenuItem9.setText("Informes de Ventas");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Informes de Compras");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ayuda");

        jMenuItem11.setText("Acerca de");
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public void centrar() {
//        JTextFieldDateEditor fecha = (JTextFieldDateEditor) jDateChooser1.getComponent(1);
//        fecha.setHorizontalAlignment(JTextField.CENTER);
//    }

//    public void listenerDateChooser() {
//        jDateChooser1.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent pce) {
//                if ("date".equals(pce.getPropertyName())) {
//                    arranque();
//                }
//            }
//        });
//    }

    private DefaultTableModel model;
    private Session st;

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        llamarVentas();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        llamarCompras();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        llamarTipo();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        llamarArticulo();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        llamarCliente();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        llamarFuncionario();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        llamarProveedor();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        llamarReporteVenta();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        llamarReporteCompra();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        
        //llamarCompras();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        //llamarVentas();
        //cargarTabla();
        llamarVentasP();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        SeleccionarReporte sr = new SeleccionarReporte(this, true);
        sr.setTitle("Seleccionar tipo de reporte");
        sr.setVisible(true);
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        llamarArticulo();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        llamarProveedor();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
//        VerPro vp = new VerPro();
//        vp.setVisible(true);
//        this.jTabbedPane1.removeAll();
        llamarProductos();
        
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        llamarpanel();
        
        
        
    }//GEN-LAST:event_jLabel22MouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelNice panelNice1;
    // End of variables declaration//GEN-END:variables
    private void llamarVentas() {
        //Creamos una instancia del formulario VentaApp en este caso.
        //Se le pasan dos parámetros (this, true), el primero indica el formulario padre, en este caso "Principal".
        //El segundo si es modal o no.
        VentaApp v = new VentaApp(this, true);
        //Indicamos que se muestren las opciones "minimizar", "maximizar" y "cerrar"
        //v.setDefaultCloseOperation(HIDE_ON_CLOSE);
        //Indicamos el título del formulario.
        v.setTitle("Formulario de Ventas");
        //La hacemos visible.
        v.setVisible(true);
    }
    private void llamarProductos(){
        this.jTabbedPane1.removeAll();
        pMedicamentos medicamentos = new pMedicamentos();
        
        this.jTabbedPane1.add(medicamentos);
        medicamentos.setVisible(true);
        this.jTabbedPane1.setTitleAt(0, "Medicamentos");
    }
    private void llamarVentasP(){
        this.jTabbedPane1.removeAll();
        pClientes clientes = new pClientes();
        this.jTabbedPane1.add(clientes);
        clientes.setVisible(true);
        this.jTabbedPane1.setTitleAt(0, "Seleccione el Cliente");
    }

    
    //Los pasos para llamar cada formulario son iguales a la anterior.
    private void llamarpanel(){
        this.jTabbedPane1.removeAll();
        pPrincipal principal = new pPrincipal();
        this.jTabbedPane1.add(principal);
        this.jTabbedPane1.setSize(jTabbedPane1.getHeight(), jTabbedPane1.getWidth());
        this.jTabbedPane1.setMaximumSize(this.jTabbedPane1.getSize());
        principal.setVisible(true);
        this.jTabbedPane1.setTitleAt(0, "Principal");
    }
  
    private void llamarCompras() {
        CompraApp c = new CompraApp(/*this, true*/);
        //c.setDefaultCloseOperation(HIDE_ON_CLOSE);
        c.setTitle("Formulario de Compras");
        c.setVisible(true);
    }

    private void llamarTipo() {
        TipoApp t = new TipoApp(/*this, true*/);
        //t.setDefaultCloseOperation(HIDE_ON_CLOSE);
        t.setTitle("Formulario de Tipos de Artículos");
        t.setVisible(true);
    }

    private void llamarArticulo() {
        ArticuloApp a = new ArticuloApp(/*this, true*/);
      //  a.setDefaultCloseOperation(HIDE_ON_CLOSE);
        a.setTitle("Formulario de Artículos");
        a.setVisible(true);
    }

    private void llamarCliente() {
        ClienteApp cl = new ClienteApp(/*this, true*/);
        cl.setDefaultCloseOperation(HIDE_ON_CLOSE);
        cl.setTitle("Formulario de Clientes");
        cl.setVisible(true);
    }

    private void llamarFuncionario() {
        FuncionarioApp f = new FuncionarioApp(this, true);
      //  f.setDefaultCloseOperation(HIDE_ON_CLOSE);
        f.setTitle("Formulario de Funcionarios");
        f.setVisible(true);
    }

    private void llamarProveedor() {
        ProveedorApp p = new ProveedorApp(/*this, true*/);
       // p.setDefaultCloseOperation(HIDE_ON_CLOSE);
        p.setTitle("Formulario de Proveedores");
        p.setVisible(true);
    }

    private void llamarReporteVenta() {
        ReporteVenta rv = new ReporteVenta(/*this, true*/);
       // rv.setDefaultCloseOperation(HIDE_ON_CLOSE);
        rv.setTitle("Reportes de Ventas");
        rv.setVisible(true);
    }

    private void llamarReporteCompra() {
        ReporteCompra rc = new ReporteCompra(/*this, true*/);
       // rc.setDefaultCloseOperation(HIDE_ON_CLOSE);
        rc.setTitle("Reportes de Compras");
        rc.setVisible(true);
    }

//    public void arranque() {
//        Tablemodel();
//        cargarTabla();
//        
//        
//        
//    }

//    public void Tablemodel() {
//        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(15);
//        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
//        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
//        model = (DefaultTableModel)this.jTable1.getModel();
//        model.setNumRows(0);
//    }

//    public void cargarTabla() {
//        //System.out.println(""+jDateChooser1.getDate().toString());
//       Tablemodel();
//        SimpleDateFormat formato = new SimpleDateFormat("YYMMdd");
//        String fecha = formato.format(jDateChooser1.getDate());
//        System.out.println("" + fecha);
//        List<VentaDet> lista = (List<VentaDet>) st.createQuery("From VentaDet group by VentaCab_num").list();
//        System.out.println("" + lista.size());
//        double contador=0;
//        for (VentaDet ventaList : lista) {
//            String date = "" + formato.format(ventaList.getVentaCab().getFecha().getTime());
//            // System.out.println(""+formato.format(ventaList.getVentaCab().getFecha().getTime()));
//            if (date.equals(fecha)) {
//                model.addRow(new Object[]{
//                    ventaList.getVentaCab().getNum(), ventaList.getVentaCab().getCliente().getDes() + " " + ventaList.getVentaCab().getCliente().getRuc(),"Q. " + ventaList.getVentaCab().getTotal()});
//                contador=contador+ ventaList.getVentaCab().getTotal();
//                contador = Math.rint(contador*100)/100;
//                jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer());
//                if (ventaList.getVentaCab().isPagado()==false) {
//                    Color bgColor = new Color(130, 220, 100);
//                    jTable1.setBackground(bgColor);
//                    
//                }
//                
//            }
//        }
//            salidat.setText("Q. "+contador);
//    }

    private void hibernateSession() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    
}
