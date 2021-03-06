/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.entidades.Articulo;
import com.entidades.CompraCab;
import com.entidades.CompraDet;
import com.entidades.Funcionario;

import com.entidades.Proveedor;
import com.entidades.Tipo;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import org.codehaus.groovy.tools.shell.util.SimpleCompletor;
import org.hibernate.Session;
import util.HibernateUtil;
import org.jdesktop.swingx.autocomplete.*;

/**
 *
 * @author Geek
 */
public class dCompraRapida extends javax.swing.JDialog {

    /**
     * Creates new form dCompraRapida
     */
    private  int idProd=0;
    private int numCompra=0;
    public dCompraRapida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        hibernateSession();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public dCompraRapida(java.awt.Frame parent, boolean modal, int idProd) {
        super(parent, modal);
        initComponents();
        this.idProd=idProd;
        setLocationRelativeTo(null);
        hibernateSession();
        buscarArticulo();
        arranque();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addEscapeKey();
        retornarFechaHoy();
        cmbLote.setEnabled(false);
        
        
    }
    private Session st;
    private DefaultTableModel model;
    
    public void hibernateSession(){
        st = HibernateUtil.getSessionFactory().openSession();
    }
    public void buscarArticulo(){

        try {
            Articulo art = (Articulo)st.load(Articulo.class, idProd);
            this.txtDes.setText(art.getDes());
            this.txtPCo.setText(String.valueOf(art.getPco()));
            this.txtPres.setText(String.valueOf(art.getTipo().getDes()));
            this.txtCan.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay artículo con ID: " + idProd);
        }    
    }
    private void arranque(){
        txtNfactura.requestFocus();
        txtTotal.setEnabled(false);
        txtDes.setEnabled(false);
        txtPres.setEnabled(false);
        txtTotal.setEnabled(false);
        txtPCo.setEnabled(false);
        addEscapeKey();
        AutoCompleteDecorator.decorate(this.cmbProveedor);
        cargarCombo();
        retornarFechaHoy();
        
        
    }
    DefaultComboBoxModel combomodel;
    public void cargarCombo(){
        hibernateSession();
        combomodel=(DefaultComboBoxModel) cmbProveedor.getModel();
        combomodel.removeAllElements();
        combomodel.addElement("Selecione un proveedor");
        List<Proveedor> lista = (List<Proveedor>)st.createQuery("From Proveedor").list();
        for(Proveedor tipoList : lista){
            combomodel.addElement(tipoList);            
        }
        cmbProveedor.setModel(combomodel);
        
}
    public void calcularParcial(){
        int canCompra = 0;
        double pCompra = 0;
        double totalParcial = 0 ;
        try {
            canCompra = Integer.parseInt(this.txtCan.getText());
            pCompra = Double.parseDouble(this.txtPCo.getText());
            totalParcial = canCompra * pCompra;
            totalParcial = Math.rint(totalParcial*100)/100;
            this.txtTotal.setText(String.valueOf(totalParcial)); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se requiere datos numéricos.");
            this.txtCan.setText(null);
            this.txtCan.requestFocus();
        }
    }
    public void calcularParcial2(){
        int canCompra = 0;
        double pCompra = 0;
        double totalParcial = 0 ;
        try {
            canCompra = Integer.parseInt(this.txtCan.getText());
            pCompra = Double.parseDouble(this.txtTotal.getText());
            totalParcial = pCompra / canCompra;
            totalParcial = Math.rint(totalParcial*100)/100;
            this.txtPCo.setText(String.valueOf(totalParcial)); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se requiere datos numéricos.");
            this.txtCan.setText(null);
            this.txtTotal.setText(null);
            this.txtTotal.requestFocus();
            
        }
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
    public void guardar(){
    //Metodo que nos permite almacenar los datos intruducidos en la base de datos,
    //los datos se guardan en la tabla CompraCab y CompraDet.
    //la primera almacena la cabecera de compra y la segunda los detalles.
        if (this.txtNfactura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo factura es necesario");
        }else{
            if (this.txtSerie.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo 'Serie' es necesario");
            }
            else{
                
                    if (this.cmbProveedor.getSelectedItem().equals(null)) {
                        JOptionPane.showMessageDialog(null, "Seleccione un proveedor valido");
                    }else{
                        if (this.txtCan.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "¿Cuantas unidades de "+txtDes.getText()+" desea comprar?");
                        }
                        else{
                            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea Guardar esta compra?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                            if (confirmacion==0) {
                              try{  
                                st.beginTransaction();
                                CompraCab compra = new CompraCab();
                                int idFun = 1;
                                int idPrv = ((Proveedor)cmbProveedor.getSelectedItem()).getId();
                                double totalCompra = Double.parseDouble(this.txtTotal.getText());
                                String NFac = txtNfactura.getText();
                                String Ser = txtSerie.getText();
                                Funcionario funcionario = (Funcionario)st.load(Funcionario.class, idFun);
                                Proveedor proveedor = (Proveedor)st.load(Proveedor.class, idPrv);
                                SimpleDateFormat formato = new SimpleDateFormat("yyMMdd");
                                String fecha1 = formato.format(fecha.getDate());
                                Calendar fechaCompra = retornarCalendar(fecha1);
                                Calendar cal = Calendar.getInstance();
                                String horaCompra = retornarStringHora(cal);
                                obtenetID();
                                compra.setNFactura(NFac);
                                compra.setSerie(Ser);
                                compra.setNum(numCompra);
                                compra.setProveedor(proveedor);
                                compra.setFuncionario(funcionario);
                                compra.setFecha(fechaCompra);
                                compra.setHora(horaCompra);
                                compra.setTotal(totalCompra);
                                funcionario.getCompraCabs().add(compra);
                                proveedor.getCompraCabs().add(compra);
                                CompraDet detalleCompra = new CompraDet();
                                int idArticulo = idProd;
                                Articulo ventaArticulo = (Articulo)st.load(Articulo.class, idArticulo);
                                int cantCompra = Integer.parseInt(txtCan.getText());
                                double importeVenta = Double.parseDouble(txtTotal.getText());
                                detalleCompra.setArticulo(ventaArticulo);
                                detalleCompra.setCantidad(cantCompra);
                                detalleCompra.setImporte(importeVenta);
                                detalleCompra.setCabecera(compra);
                                compra.getCompraDets().add(detalleCompra);
                                st.save(compra);
                                st.getTransaction().commit();
                                actualizarStrock(cantCompra, idArticulo);
                                arranque();
                                JOptionPane.showMessageDialog(null, "Compra realizada con exito.");
                                this.dispose();
                            }catch(Exception e ){JOptionPane.showMessageDialog(null, "Error en la compra");}
                          }
                            
                        }
                    }
                
            }
            
        }
}
   public void obtenetID(){
    //Utilizamos el método siguiente para conseguir en número de compra...
    //correspondiente
    numCompra = 0;
    List<CompraCab> lista = (List<CompraCab>)st.createQuery("From CompraCab").list();
    for (Iterator<CompraCab> it = lista.iterator(); it.hasNext();) {
        CompraCab compraCab = it.next();
        numCompra = compraCab.getNum() + 1;
    }
    if(numCompra==0){
        numCompra=1;
    } 
}
   public Calendar retornarCalendar(String fecha){
        //Se le pasa como argumento un String-Fecha y la combierte en objeto calendar.
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        Calendar cal = Calendar.getInstance();    
        try {
            cal.setTime(sdf.parse(fecha));
        } catch (ParseException ex) {
          JOptionPane.showMessageDialog(null, "Error; compruebe formato de fecha: " + ex);  
        }
        return cal;
    }
   
    public String retornarStringHora(Calendar fecha){
        //Médodo que se le para un objeto calendar y la combierte en formato String-hora
        String retorno=null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        if (fecha != null) {
        retorno = sdf.format(fecha.getTime());
        }
        return retorno;
    } 
    public void retornarFechaHoy(){
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date2 = new Date(stamp.getTime());
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        fecha.setDate(date2);
    }
    
   
    public void actualizarStrock(int cantidadCompra, int idArticulo){
    //Despúes que el proceso de guardado se de de forma correcta, 
    //se actualizar el stock de los artículos comprados.
    st.beginTransaction();
    Articulo actualizar = (Articulo)st.load(Articulo.class, idArticulo);
    int temp = actualizar.getCan() + cantidadCompra;
    actualizar.setCan(temp);
    st.update(actualizar);
    st.getTransaction().commit();
}
    

    
//    public boolean buscarLote(int idlote){
//        boolean find=false;
//        try{
//            Lote lote=(Lote)st.load(Lote.class, idlote);
//            find=true;
//        }catch(Exception e){
//            find =false;
//        }
//        return find;
//    }
    public void ingresarNuevoLote(){
        int nLote= Integer.parseInt((String) cmbLote.getSelectedItem());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonNice1 = new org.edisoncor.gui.button.ButtonNice();
        buttonRect1 = new org.edisoncor.gui.button.ButtonRect();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNfactura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox();
        fecha = new com.toedter.calendar.JDateChooser();
        cmbLote = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDes = new javax.swing.JTextField();
        txtCan = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPCo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPres = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        btnGuardar = new org.edisoncor.gui.button.ButtonSeven();
        btnCancelar = new org.edisoncor.gui.button.ButtonSeven();
        jLabel1 = new javax.swing.JLabel();

        buttonNice1.setText("buttonNice1");

        buttonRect1.setText("buttonRect1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setText("Compra rapida");

        jLabel16.setFont(new java.awt.Font("Comfortaa", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("Puede utilizarce para cuando se compra un solo producto...");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comfortaa", 1, 12))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setText("No. Factura:");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setText("Serie:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setText("Fecha:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setText("No. Lote");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setText("Total factura:");

        txtTotal.setBackground(new java.awt.Color(0, 51, 102));
        txtTotal.setFont(new java.awt.Font("Hiragino Maru Gothic Pro", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtTotal.setEnabled(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setText("Proveedor:");

        cmbProveedor.setEditable(true);
        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbProveedorFocusLost(evt);
            }
        });
        cmbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedorActionPerformed(evt);
            }
        });
        cmbProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbProveedorKeyPressed(evt);
            }
        });

        cmbLote.setEditable(true);
        cmbLote.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbLoteFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNfactura)
                    .addComponent(cmbProveedor, 0, 124, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(cmbLote, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12)
                            .addComponent(cmbLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comfortaa", 1, 12))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setText("Producto:");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setText("Cantidad:");

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
        jLabel18.setText("Precio Compra: ");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setText("Presentacion:");

        jRadioButton1.setFont(new java.awt.Font("Comfortaa", 3, 12)); // NOI18N
        jRadioButton1.setText("¿Cambio el precio de compra?");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPCo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCan, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel18)
                    .addComponent(txtPCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1))
                .addGap(9, 9, 9))
        );

        btnGuardar.setBackground(new java.awt.Color(0, 204, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.setFont(new java.awt.Font("Comfortaa", 1, 14)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Comfortaa", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Comfortaa", 3, 12)); // NOI18N
        jLabel1.setText("Esc para salir. . .");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel16))
                            .addComponent(jLabel7)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 6, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void cmbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProveedorActionPerformed

    private void txtCanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCanKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            calcularParcial();
            btnGuardar.requestFocus();
        }
    }//GEN-LAST:event_txtCanKeyPressed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1.isSelected()== true) {
            txtTotal.requestFocus();
            txtTotal.setBackground(Color.white);
            txtTotal.setForeground(Color.BLACK);
            txtTotal.setEnabled(true);
        }else{
            txtCan.requestFocus();
            Color bgColor = new Color(0,51,102);
            txtTotal.setBackground(bgColor);
            txtTotal.setForeground(Color.WHITE);
            txtTotal.setEnabled(false);
        }       
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            calcularParcial2();
            btnGuardar.requestFocus();
        }
    }//GEN-LAST:event_txtTotalKeyPressed

    

     
    private void cmbProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbProveedorKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbProveedorKeyPressed

    private void txtCanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCanFocusLost
        // TODO add your handling code here:
        calcularParcial();
    }//GEN-LAST:event_txtCanFocusLost

    private void cmbProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbProveedorFocusLost
        // TODO add your handling code here:
        this.cmbProveedor.getSelectedIndex();
    }//GEN-LAST:event_cmbProveedorFocusLost

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
        
                                
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    private void cmbLoteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbLoteFocusLost
        // TODO add your handling code here:
//        int idLote= ((Lote)cmbLote.getSelectedItem()).getId();
//        if(buscarLote(idLote)){
//            JOptionPane.showMessageDialog(null, "Lote valido");
//        }else{
//            ingresarNuevoLote();
//        }
        
    }//GEN-LAST:event_cmbLoteFocusLost

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
            java.util.logging.Logger.getLogger(dCompraRapida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dCompraRapida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dCompraRapida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dCompraRapida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dCompraRapida dialog = new dCompraRapida(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonSeven btnCancelar;
    private org.edisoncor.gui.button.ButtonSeven btnGuardar;
    private org.edisoncor.gui.button.ButtonNice buttonNice1;
    private org.edisoncor.gui.button.ButtonRect buttonRect1;
    private javax.swing.JComboBox cmbLote;
    private javax.swing.JComboBox cmbProveedor;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtCan;
    private javax.swing.JTextField txtDes;
    private javax.swing.JTextField txtNfactura;
    private javax.swing.JTextField txtPCo;
    private javax.swing.JTextField txtPres;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
