/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import OtrasClases.CellRenderer;
import OtrasClases.CellRendererComp;
import com.entidades.Articulo;
import com.entidades.CompraCab;
import com.entidades.CompraDet;
import com.entidades.VentaCab;
import com.entidades.VentaDet;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Geek
 */
public class pPrincipalCompras extends javax.swing.JPanel {

    /**
     * Creates new form pPrincipal
     */
    public pPrincipalCompras() {
        initComponents();
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date2 = new Date(stamp.getTime());
        System.out.println(date2);
        SimpleDateFormat formato = new SimpleDateFormat("YYMMdd");
        System.out.println("" + formato.format(date2));
        jDateChooser1.setDate(date2);
        listenerDateChooser();
        //jDateChooser1.setDateFormatString("dd/mm/yyyy");
        setCellRender(jTable1);
        hibernateSession();
        arranque();
        centrar();
        
       
    }
    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRendererComp());
        }
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new org.edisoncor.gui.button.ButtonSeven();
        btnGuardar1 = new org.edisoncor.gui.button.ButtonSeven();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1002, 734));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTable1 = new javax.swing.JTable(){ public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
        }};
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N. Compra", "N. Factura", "Proveedor", "Total", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Compras Totales:");

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
        buttonTransluceIcon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransluceIcon2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setText("Compras realizadas en fecha: ");

        jLabel19.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 153));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Shopping-basket-icon.png"))); // NOI18N
        jLabel19.setText("Nueva C.");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comfortaa", 0, 12))); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(0, 204, 0));
        btnGuardar.setText("Pagado");
        btnGuardar.setFont(new java.awt.Font("Comfortaa", 1, 12)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardar1.setBackground(new java.awt.Color(255, 0, 0));
        btnGuardar1.setText("Pendiente");
        btnGuardar1.setFont(new java.awt.Font("Comfortaa", 1, 12)); // NOI18N
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addGap(6, 6, 6)
                        .addComponent(buttonTransluceIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonTransluceIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salidat, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel19))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonTransluceIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonTransluceIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salidat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void buttonTransluceIcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransluceIcon2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTransluceIcon2ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        llamarCompras();
        arranque();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try{
            int selectedRow = this.jTable1.getSelectedRow();
            //Se obtiene el "id" del registro que esta en la columna "0"
            int idCompra = Integer.parseInt(String.valueOf(model.getValueAt(selectedRow, 0)));
            pagarCompra(idCompra);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Seleccione una fila.");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

     public void pagarCompra(int idC){
        st.beginTransaction();
        CompraCab compra = (CompraCab)st.load(CompraCab.class, idC);
        compra.setPagado(true);
        st.update(compra);
        st.getTransaction().commit();
        arranque();
        JOptionPane.showMessageDialog(null, "Compra Pagada");
    }
     public void pendienteCompra(int idC){
        st.beginTransaction();
        CompraCab compra = (CompraCab)st.load(CompraCab.class, idC);
        compra.setPagado(false);
        st.update(compra);
        st.getTransaction().commit();
        arranque();
        JOptionPane.showMessageDialog(null, "Compra Pendiente");
    
    }
    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
        try{
            int selectedRow = this.jTable1.getSelectedRow();
            //Se obtiene el "id" del registro que esta en la columna "0"
            int idCompra = Integer.parseInt(String.valueOf(model.getValueAt(selectedRow, 0)));
            pendienteCompra(idCompra);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Seleccione una fila.");
        }
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
           if(jTable1.getSelectedRow()>=0){
            try{
                int selectedRow= this.jTable1.getSelectedRow();
                Object valueAt = model.getValueAt(selectedRow, 0);
                int idCompra = Integer.parseInt(valueAt.toString());
                Principal p = new Principal();
                pDetalleCompra pd = new pDetalleCompra(p, true, idCompra);
                pd.setModal(true);
                pd.setVisible(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Hubo un error, verifique.");

            }
           }
       }
        
    }//GEN-LAST:event_jTable1MouseClicked
   
    
    private void llamarCompras() {
        CompraApp c = new CompraApp(/*this, true*/);
        //c.setDefaultCloseOperation(HIDE_ON_CLOSE);
        c.setTitle("Formulario de Compras");
        c.setVisible(true);
    }
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
        setCellRender(jTable1);
        
        
    }
    

    public void Tablemodel() {
        this.jTable1.setRowHeight(20);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        model = (DefaultTableModel)this.jTable1.getModel();
        model.setNumRows(0);
    }

    public void cargarTabla() {
        
       Tablemodel();
        SimpleDateFormat formato = new SimpleDateFormat("YYMMdd");
        String fecha = formato.format(jDateChooser1.getDate());
        System.out.println("" + fecha);
        List<CompraDet> lista = (List<CompraDet>) st.createQuery("From CompraDet group by cabecera_id").list();
        System.out.println("" + lista.size());
        double contador=0;
        for (CompraDet ventaList : lista) {
            String date = "" + formato.format(ventaList.getCabecera().getFecha().getTime());
            if (date.equals(fecha)) {
                model.addRow(new Object[]{
                    ventaList.getCabecera().getNum(), ventaList.getCabecera().getNFactura(),ventaList.getCabecera().getProveedor().getDes(),new java.text.DecimalFormat("Q #,##0.00").format(Double.valueOf(ventaList.getCabecera().getTotal())), ventaList.getCabecera().isPagado()});
                contador=contador+ ventaList.getCabecera().getTotal();
                contador = Math.rint(contador*100)/100;
                
               
            }
        }
            salidat.setText(new java.text.DecimalFormat("Q #,##0.00").format(Double.valueOf(contador)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonSeven btnGuardar;
    private org.edisoncor.gui.button.ButtonSeven btnGuardar1;
    private org.edisoncor.gui.button.ButtonTransluceIcon buttonTransluceIcon1;
    private org.edisoncor.gui.button.ButtonTransluceIcon buttonTransluceIcon2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField salidat;
    // End of variables declaration//GEN-END:variables
}

