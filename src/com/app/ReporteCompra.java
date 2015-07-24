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

import com.entidades.CompraCab;
import com.entidades.CompraDet;
import com.entidades.Proveedor;
import com.informes.CompraR;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Ariel
 */
public class ReporteCompra extends javax.swing.JDialog {

    /** Creates new form ReporteVenta */
    public ReporteCompra(/*java.awt.Frame parent, boolean modal*/) {
       //super(parent, modal);
        initComponents();        
        setLocationRelativeTo(null);
        hibernateSession();
        arranque();        
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    private Session st;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        inicioG = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        finG = new javax.swing.JFormattedTextField();
        verG = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        inicioF = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        finF = new javax.swing.JFormattedTextField();
        verF = new javax.swing.JButton();
        listaP = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario de Reportes");
        setModalityType(java.awt.Dialog.ModalityType.DOCUMENT_MODAL);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/note.png"))); // NOI18N
        jLabel1.setText("Reportes de Compras.");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte General"));

        jLabel2.setText("Fechas inicio (día/mes/año)");

        try {
            inicioG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Fechas fin (días/mes/año)");

        try {
            finG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        verG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/secund.png"))); // NOI18N
        verG.setText("VER");
        verG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inicioG, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(finG, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(verG)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inicioG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verG)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte por Proveedores"));

        jLabel4.setText("Fechas inicio (día/mes/año)");

        try {
            inicioF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Fechas fin (días/mes/año)");

        try {
            finF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        verF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/secund.png"))); // NOI18N
        verF.setText("VER");
        verF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verFActionPerformed(evt);
            }
        });

        jLabel6.setText("Lista de Proveedores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inicioF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(finF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(verF))
                    .addComponent(listaP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inicioF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(verF))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, 0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verGActionPerformed
        //Condición agregada para ejecutar el informe.
        if(!inicioG.getText().isEmpty() && !finG.getText().isEmpty()){
            informeGeneral();
        }
        else{
            JOptionPane.showMessageDialog(null, "Especifique una fecha correcta.");
        }
    }//GEN-LAST:event_verGActionPerformed

    private void verFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verFActionPerformed
        //Condición agregada para ejecutar el informe.
        if(!inicioF.getText().isEmpty() && !finF.getText().isEmpty() && !listaP.getSelectedItem().toString().isEmpty()){
            informeProveedor();
        }
        else{
            JOptionPane.showMessageDialog(null, "Especifique los datos necesarios. -Fecha- y -Proveedor-");
        }        
    }//GEN-LAST:event_verFActionPerformed

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
                ReporteCompra dialog = new ReporteCompra(/*new javax.swing.JFrame(), true*/);
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
    private javax.swing.JFormattedTextField finF;
    private javax.swing.JFormattedTextField finG;
    private javax.swing.JFormattedTextField inicioF;
    private javax.swing.JFormattedTextField inicioG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox listaP;
    private javax.swing.JButton verF;
    private javax.swing.JButton verG;
    // End of variables declaration//GEN-END:variables
private void hibernateSession(){
    //Método para abrir una sesión hibernate.
    st = HibernateUtil.getSessionFactory().openSession();
}
private void arranque(){
    //Metodo para configurar los elementos de arranque
    Calendar cal = Calendar.getInstance();
    String fecha = retornarString(cal);
    inicioG.setText(fecha);
    finG.setText(fecha);
    inicioF.setText(fecha);
    finF.setText(fecha);
    //Creamos una lista de proveedores para llenar nuestro lista desplegable o comboBox.
    List<Proveedor> listF = (List<Proveedor>)st.createQuery("From Proveedor").list();
    //Otra forma de navegar por una lista a diferencia de Iterator.
    for (int i = 0; i < listF.size(); i++) {
        Proveedor p = listF.get(i);
        listaP.addItem(p.getDes());
    }
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();    
        try {
            cal.setTime(sdf.parse(fecha));
        } catch (ParseException ex) {
          JOptionPane.showMessageDialog(null, "Error; compruebe formato de fecha: " + ex);  
        }
        return cal;
}
public void informeGeneral(){
    //Método para nuestro informe general
    //try - para controlar las excepciones.
    try {               
        //Iniciamos una transacción
        st.beginTransaction();
        //Utilizamos un Lista para almacenar los datos combinados.
        //Inicializamos nuestra lista como ArrayList().
        List compraList = new ArrayList();
        //Creamos una Query utilizando nuestra sesión y HQL (Hibernate Query Language)
        //Las condiciones son - fecha de inicio y fin.
        Query query = (Query) st.createQuery("From CompraCab c Where c. fecha>=? and c. fecha<=?");
        //A diferencia del SQL, las condiciones se pasan como parámetros.
        //El primer parámetro indica el orden que empieza de "0", el segundo la variable.
        query.setParameter(0, retornarCalendar(inicioG.getText()));
        query.setParameter(1, retornarCalendar(finG.getText()));
        //Obtenemos la lista de "CompraCab"
        List<CompraCab> lista = query.list();
        int id=0;
        //Navegamos la lista utilizando Iterator.
        for (Iterator<CompraCab> it = lista.iterator(); it.hasNext();) {
            CompraCab compraCab = it.next();
            String funcionario = compraCab.getFuncionario().getNombres() +" " +compraCab.getFuncionario().getApellidos();
            String proveedor = compraCab.getProveedor().getDes();
            String fecha = retornarString(compraCab.getFecha());
            List<CompraDet> compraDets = compraCab.getCompraDets();
            //Navegamos por la lista de detalles utilizando también iterator.
            for (Iterator<CompraDet> it1 = compraDets.iterator(); it1.hasNext();) {
                id++;
                CompraDet compraDet = it1.next();
                //Llenamos nuestro lista creada más arriba con los elementos necesarios.
                compraList.add(new CompraR(id, funcionario, proveedor, fecha, compraDet.getArticulo().getDes(), compraDet.getCantidad(), compraDet.getImporte()));
            }
        }            
        //Utilizamos el método siguiente para cargar el reporte "*.jasper"
        //El "JRLoader.loadObject" es el cargador.
        JasperReport report  = (JasperReport)JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/ReporteCompras.jasper")); 
        //El método siguiente nos permite pasarle los datos al reporte utilizando JRBeanCollectionDataSource y como argumento la lista que creamos más arriba.
        JasperPrint fillReport = JasperFillManager.fillReport(report, null,new JRBeanCollectionDataSource(compraList));
        //El JasperViewer para visualizar, le pasamos como argumento nuestro "fillReport" de arriba.
        JasperViewer jviewer = new JasperViewer(fillReport,false);
        //Le damos un título al reporte.
        jviewer.setTitle("Compras Generales.");
        //La hacemos visible.
        jviewer.setVisible(true);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error cargando reporte." + e);
    }
}
public void informeProveedor(){
    //Este método es similar al de más arriba, por tanto se saltan algunos comentarios.
    //try - para controlar las excepciones.
    try {               
        //Iniciamos una transacción
        st.beginTransaction();
        //Utilizamos un Lista para almacenar los datos.
        List compraList = new ArrayList();        
        Query query = (Query) st.createQuery("From CompraCab c Where c. fecha>=? and c. fecha<=?");
        query.setParameter(0, retornarCalendar(inicioF.getText()));
        query.setParameter(1, retornarCalendar(finF.getText()));
        List<CompraCab> lista = query.list();
        int id=0;
        for (Iterator<CompraCab> it = lista.iterator(); it.hasNext();) {
            CompraCab compraCab = it.next();
            String funcionario = compraCab.getFuncionario().getNombres()+" "+compraCab.getFuncionario().getApellidos();
            String proveedor = compraCab.getProveedor().getDes();
            String fecha = retornarString(compraCab.getFecha());
            List<CompraDet> compraDets = compraCab.getCompraDets();            
            for (Iterator<CompraDet> it1 = compraDets.iterator(); it1.hasNext();) {
                id++;
                CompraDet compraDet = it1.next();
                //Una condición para filtrar la lista, obteniendo solo la de un proveedor en específico.
                if( proveedor.equals(listaP.getSelectedItem().toString())){
                  compraList.add(new CompraR(id, funcionario, proveedor, fecha, compraDet.getArticulo().getDes(), compraDet.getCantidad(), compraDet.getImporte()));  
                }                
            }
        }           
        //Utilizamos el método siguiente para cargar el reporte "*.jasper"
        //El "JRLoader.loadObject" es el cargador.
        JasperReport report  = (JasperReport)JRLoader.loadObject(ClassLoader.getSystemResource("com/informes/ReportCompraDos.jasper")); 
        //El método siguiente nos permite pasarle los datos al reporte utilizando JRBeanCollectionDataSource y como argumento la lista que creamos más arriba.
        JasperPrint fillReport = JasperFillManager.fillReport(report, null,new JRBeanCollectionDataSource(compraList));
        //El JasperViewer para visualizar, le pasamos como argumento nuestro "fillReport" de arriba.
        JasperViewer jviewer = new JasperViewer(fillReport,false);
        //Le damos un título al reporte.
        jviewer.setTitle("Lista de Compras por Proveedores.");
        //La hacemos visible.
        jviewer.setVisible(true);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error cargando reporte.");
    }
}
}