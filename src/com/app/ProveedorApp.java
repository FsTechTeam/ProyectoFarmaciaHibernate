/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProveedorApp.java
 *
 * Created on 20/11/2012, 10:06:51 AM
 */
package com.app;

import com.entidades.Proveedor;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Geek
 */
public class ProveedorApp extends javax.swing.JDialog {

    /** Creates new form ProveedorApp */
    public ProveedorApp(/*java.awt.Frame parent, boolean modal*/) {
       //super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);//Centrar Formulario.
        hibernateSession();//Método para abrir una sesión hibernate.
        arranque();//Método limpiar campos, ajustar tabla y configurar botones.
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                this.id.setVisible(false);

    }
    private Session st;//Variable de clase tipo Session para manejar la sesión hibernate.
    //Variable de clase tipo DefaultTableModel para trabajar con la tabla.
    private DefaultTableModel model;
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        des = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        dir = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        nit = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        guardar = new org.edisoncor.gui.button.ButtonSeven();
        cancelar = new org.edisoncor.gui.button.ButtonSeven();
        nuevo = new org.edisoncor.gui.button.ButtonSeven();
        editar = new org.edisoncor.gui.button.ButtonSeven();
        eliminar = new org.edisoncor.gui.button.ButtonSeven();
        informe = new org.edisoncor.gui.button.ButtonSeven();
        jLabel18 = new javax.swing.JLabel();
        tel = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proveedores");
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setText("Agregar Proveedor");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setText("Ingrese un nuevo proveedor a su sistema ...");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setText("Nombre:");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setText("Casa medica:");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setText("N.I.T.:");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setText("Correo:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Descripción", "Dirección", "Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        guardar.setBackground(new java.awt.Color(0, 204, 0));
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color(255, 0, 51));
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        nuevo.setBackground(new java.awt.Color(0, 153, 255));
        nuevo.setText("+ Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        editar.setBackground(new java.awt.Color(255, 255, 51));
        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(255, 0, 102));
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        informe.setBackground(new java.awt.Color(255, 153, 0));
        informe.setText("Informe");
        informe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(informe, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setText("Tel:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dir)
                                    .addComponent(des)
                                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(17, 17, 17)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Evento MouseClicked para el jTable1
        cargarProveedor();
    }//GEN-LAST:event_jTable1MouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        arranque();
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        // TODO add your handling code here:
        nuevo();
    }//GEN-LAST:event_nuevoActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_editarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_eliminarActionPerformed

    private void informeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_informeActionPerformed

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
            java.util.logging.Logger.getLogger(ProveedorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProveedorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProveedorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProveedorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ProveedorApp dialog = new ProveedorApp(/*new javax.swing.JFrame(), true*/);
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
    private org.edisoncor.gui.button.ButtonSeven cancelar;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField des;
    private javax.swing.JTextField dir;
    private org.edisoncor.gui.button.ButtonSeven editar;
    private org.edisoncor.gui.button.ButtonSeven eliminar;
    private org.edisoncor.gui.button.ButtonSeven guardar;
    private javax.swing.JTextField id;
    private org.edisoncor.gui.button.ButtonSeven informe;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nit;
    private org.edisoncor.gui.button.ButtonSeven nuevo;
    private javax.swing.JTextField tel;
    // End of variables declaration//GEN-END:variables
public void hibernateSession(){
    //Abrimos una sesión, como la variable es de clase, podremos utilizarla
    //desde cualquier método.
    st = HibernateUtil.getSessionFactory().openSession();
}
public void arranque(){
    //Limpiamos campos, configuramos objetos.
    this.id.setEnabled(false);
    this.id.setText(null);
    this.des.setEnabled(false);
    this.des.setText(null);
    this.dir.setEnabled(false);
    this.dir.setText(null);
    this.tel.setEnabled(false);
    this.tel.setText(null);
    this.correo.setEnabled(false);
    this.correo.setText(null);
    this.nit.setEnabled(false);
    this.nit.setText(null);
    this.guardar.setText("Guardar");
    this.nuevo.setEnabled(true);
    this.guardar.setEnabled(false);
    this.editar.setEnabled(false);
    this.eliminar.setEnabled(false);
    this.jTable1.setEnabled(true);
    defaultTableModel();
    cargarTable();
}
public void defaultTableModel(){
    //Configuramos nuestra tabla de la forma siguiente.
    this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
    this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
    this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
    this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
    //La variable model es de clase, podremos utilizar en cualquier método.
    //Nos permitira agregar, editar y eliminar datos de la tabla.
    model = (DefaultTableModel) this.jTable1.getModel();
    model.setNumRows(0);
}
public void cargarTable(){
    //Llamamos a la variable "st" para iniciar una transacción con la DB.
    st.beginTransaction();
    //Obtenemos una lista de todos los registros de la tabla proveedor de la siquiente forma.
    List<Proveedor> list = (List<Proveedor>)st.createQuery("from Proveedor p order by p.des").list();
    //Con Iterator podremos navegar por la lista anterior creada.
    for (Iterator<Proveedor> it = list.iterator(); it.hasNext();) {
        //Casteo a clase Proveedor de la lista para poder utilizar los get y set.
        Proveedor proveedor = it.next();
        //Cada ciclo carga un fila nueva a la tabla con registros del DB.
        model.addRow(new Object[]{
            proveedor.getId(),proveedor.getDes(),proveedor.getDir(),proveedor.getTel()
        });        
    }
}
public void nuevo(){
    //Habilitamos campos y objetos para cargar un nuevo registro a la DB.
    this.id.setText("Auto");
    this.des.setEnabled(true);
    this.des.setText(null);
    this.dir.setEnabled(true);
    this.dir.setText(null);
    this.tel.setEnabled(true);
    this.tel.setText(null);
    this.correo.setEnabled(true);
    this.correo.setText(null);
    this.nit.setEnabled(true);
    this.nit.setText(null);
    this.nuevo.setEnabled(false);
    this.guardar.setText("Guardar");
    this.guardar.setEnabled(true);
    this.jTable1.setEnabled(false);
}
public void guardar(){
    //Antes de proceder a guardar comprobamos que no hayan campos vacios.
    if(this.des.getText().isEmpty()){
        this.des.setText("-");
        guardar();
    }
    else{
        if(this.dir.getText().isEmpty()){
           this.dir.setText("-");
           guardar();
        }
        else{
            if(this.tel.getText().isEmpty()){
                this.tel.setText("-");
                guardar();
            }else{
                if(this.nit.getText().isEmpty()){
                    this.nit.setText("-");
                    guardar();
                }
            else{
                //Tendremos dos posibles casos, un nuevo registro o actualización.
                //Si el botón guardar muestro la etiqueta "Guardar", se creará un nuevo registro.
                if(this.guardar.getText().equals("Guardar")){
                   st.beginTransaction();
                   Proveedor prov = new Proveedor();
                   prov.setDes(this.des.getText());
                   prov.setDir(this.dir.getText());
                   prov.setTel(this.tel.getText());
                   prov.setCorreo(this.correo.getText());
                   prov.setNit(this.nit.getText());
                   
                   //save para nuevo registro
                   st.save(prov);
                   //El commit permite confirmar la transacción y procesarla
                   st.getTransaction().commit();
                   arranque();
                   JOptionPane.showMessageDialog(null, "Proveedor guardado correctamente.");
                }
                else{
                    //Caso contrario a la anterior, se cargará el registro seleccionado
                    //y se podra actualizar los cambios.
                    st.beginTransaction();
                    int idProv = Integer.parseInt(this.id.getText());
                    //Para cargar un registro se utiliza un load con los parámetros de clase e "id"
                    Proveedor prov = (Proveedor)st.load(Proveedor.class, idProv);
                    prov.setDes(this.des.getText());
                    prov.setDir(this.dir.getText());
                    prov.setTel(this.tel.getText());
                    prov.setCorreo(this.correo.getText());
                    prov.setNit(this.nit.getText());
                    //Para el caso será un update.
                    st.update(prov);
                    st.getTransaction().commit();
                    arranque();
                    JOptionPane.showMessageDialog(null, "Proveedor actualizado correctamente.");                    
                }
            }
        }
    }
}
}
public void cargarProveedor(){
    //Lo siguiente permite rellenar los campos con los datos que se obtengan
    //de la fila seleccionada del jTable1
    if(this.jTable1.isEnabled()){
      //Se obtiene la fila seleccionada
      int selectedRow = this.jTable1.getSelectedRow();
      //Se obtiene el "id" del registro que esta en la columna "0"
      int idProv = Integer.parseInt(String.valueOf(model.getValueAt(selectedRow, 0)));
      //Se utiliza un load para cargar el objeto.
      Proveedor prov = (Proveedor)st.load(Proveedor.class, idProv);
      //Cargado el objeto se pueden utilizar los "get".
      this.id.setText(String.valueOf(prov.getId()));
      this.des.setText(prov.getDes());
      this.dir.setText(prov.getDir());
      this.tel.setText(prov.getTel());
      this.correo.setText(prov.getCorreo());
      this.nit.setText(prov.getNit());
      this.editar.setEnabled(true);
      this.eliminar.setEnabled(true);
      this.nuevo.setEnabled(false);
    }
}
public void editar(){
    //Activa campos para edición.
    this.des.setEnabled(true);
    this.dir.setEnabled(true);
    this.tel.setEnabled(true);
    this.correo.setEnabled(true);
    this.nit.setEnabled(true);
    this.nuevo.setEnabled(false);
    this.eliminar.setEnabled(false);
    this.guardar.setEnabled(true);
    this.guardar.setText("Actualizar");
    this.jTable1.setEnabled(false);
}
public void eliminar(){
    //Forma de confirmar una eliminación de registro.
    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Eliminación de Registro", "Desea eliminar este registro.", JOptionPane.YES_NO_OPTION);
   if(showConfirmDialog == 1){
       JOptionPane.showMessageDialog(null, "Registro no eliminado.");
   }
   else{
      //Iniciamos una transacción
      st.beginTransaction();
      //Obtenemos la fila seleccionada de la tabla.
      int selectedRow = this.jTable1.getSelectedRow();
      //Obtenemos el "id" del registro de la columna "0" de la tabla.
      int idProv = Integer.parseInt(String.valueOf(model.getValueAt(selectedRow, 0)));
      //Cargamos el objeto.
      Proveedor prov = (Proveedor)st.load(Proveedor.class, idProv);
      //Eliminamos con delete
      st.delete(prov);
      //Confirmamos la transacción
      st.getTransaction().commit();
      JOptionPane.showMessageDialog(null, "Registro eliminado.");
      arranque();      
   }
}
public void informe(){
    //try - para controlar las excepciones.
    try {
        //Creamos una lista de los datos de la tabla "Proveedor" utilizando "List".
        //Iniciamos una transacción.
        st.beginTransaction();
        List<Proveedor> lista = (List<Proveedor>)st.createQuery("From Proveedor").list();
        //Utilizamos el método siguiente para cargar el reporte "ProveedorReport.jasper"
        //El "JRLoader.loadObject" es el cargador.
        JasperReport report  = (JasperReport)JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/ProveedorReport.jasper")); 
        //El método siguiente nos permite pasarle los datos al reporte utilizando JRBeanCollectionDataSource y como argumento la lista que creamos más arriba.
        //La lista posee todos los campos necesarios para pasarle datos al reporte.
        JasperPrint fillReport = JasperFillManager.fillReport(report, null,new JRBeanCollectionDataSource(lista));
        //El JasperViewer para visualizar, le pasamos como argumento nuestro "fillReport" de arriba.
        JasperViewer jviewer = new JasperViewer(fillReport,false);
        //Le damos un título al reporte.
        jviewer.setTitle("Lista de Proveedores");
        //La hacemos visible.
        jviewer.setVisible(true);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error cargando reporte.");
    }
}
}
