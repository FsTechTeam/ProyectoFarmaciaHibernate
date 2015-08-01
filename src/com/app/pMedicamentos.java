/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.entidades.Articulo;
import com.reportes.IniciarReportes;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Geek
 */
public class pMedicamentos extends javax.swing.JPanel{

    /**
     * Creates new form pMedicamentos
     */
    public pMedicamentos() {
        initComponents();
        setCellRender(jTable1);
        hibernateSession();
        arranque();
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTextField1.requestFocus();
        
        
        
    }
    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }
    
    private Session st;
    private DefaultTableModel model;
    private void hibernateSession(){
    st = HibernateUtil.getSessionFactory().openSession();
    }
    
    private void arranque(){
    hibernateSession();
    tableModel();
    cargarTabla();
    
}
    public void tableModel(){
    this.jTable1.setRowHeight(20);
    this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
    this.jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
    this.jTable1.getColumnModel().getColumn(0).setMinWidth(0);
    this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
    this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
    this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
    this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
    this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(20);
    this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(20);
    model = (DefaultTableModel)this.jTable1.getModel();
    model.setNumRows(0);
    
}
    public boolean isCellEditable(int row, int col){
        return false;
    }
    public void cargarTabla(){
    List<Articulo> lista = (List<Articulo>)st.createQuery("From Articulo a order by a.des").list();
    for(Articulo articuloList : lista){
        model.addRow(new Object[]{
           articuloList.getId(), articuloList.getDes(),articuloList.getTipo().getDes(),"Q. "+articuloList.getPve(), "Q. "+articuloList.getPco(), " "+ articuloList.getCan()+"   UNIDAD(ES)", "Q. "+articuloList.getPor()});
    }
}
    private void busquedaProducto(String nombre, int filtro){
         Query q = st.getNamedQuery("Articulo.findBydes");
         q.setString("descripcion", nombre+"%");
         List<Articulo> lista = q.list();
            for(Articulo articuloList : lista){
                model.addRow(new Object[]{
                    articuloList.getId(), articuloList.getDes(),articuloList.getTipo().getDes(),"Q. "+articuloList.getPve(), "Q. "+articuloList.getPco(), " "+ articuloList.getCan()+"   UNIDAD(ES)", "Q. "+articuloList.getPor()});
            }
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTablaMedicamentos = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){ public boolean isCellEditable(int rowIndex, int colIndex) {
            return false; //Disallow the editing of any cell
        }};
        jLabel21 = new javax.swing.JLabel();

        jMenuItem1.setText("Compra Rapida");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuTablaMedicamentos.add(jMenuItem1);

        jMenuItem2.setText("Estadisticas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuTablaMedicamentos.add(jMenuItem2);

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Comfortaa", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Visualice la informacion de todos los productos . . . ");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Producto", "Presentacion", "Precio Venta", "Precio Compra", "Existencias", "Precio Calle"
            }
        ));
        jTable1.setToolTipText("Medicamentos");
        jTable1.setComponentPopupMenu(menuTablaMedicamentos);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setText("Buscar Medicamento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1)))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        if (this.jTextField1.getText().isEmpty()) {
            tableModel();
            cargarTabla();
            
        }else{
            tableModel();
            busquedaProducto(this.jTextField1.getText(), 1);
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void cargarProducto(int fila){
        int selectedRow = this.jTable1.getSelectedRow();
        String nombre = String.valueOf(model.getValueAt(selectedRow, 0));
        Query q = st.getNamedQuery("Articulo.findBydes&pres");
        q.setString("descripcion", nombre);
        
        
        
    
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int selectedRow= this.jTable1.getSelectedRow();
        int idProd=Integer.parseInt(String.valueOf(model.getValueAt(selectedRow, 0)));
        dCompraRapida compraRap = new dCompraRapida(new javax.swing.JFrame(), true, idProd);
        compraRap.setVisible(true);
        arranque();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow= this.jTable1.getSelectedRow();
        System.out.println(String.valueOf(model.getValueAt(selectedRow, 0)));
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int selectedRow= this.jTable1.getSelectedRow();
        int idProd=Integer.parseInt(String.valueOf(model.getValueAt(selectedRow, 0)));
        pEstadisticasProducto estP = new pEstadisticasProducto(new javax.swing.JFrame(), true, idProd);
        estP.setVisible(true);
        arranque();
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPopupMenu menuTablaMedicamentos;
    // End of variables declaration//GEN-END:variables
}
