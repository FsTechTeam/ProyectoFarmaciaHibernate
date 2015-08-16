/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VentaApp.java
 *
 * Created on 09/11/2012, 02:18:20 PM
 */
package com.app;

import com.entidades.Articulo;
import com.entidades.CompraCab;
import com.entidades.CompraDet;
import com.entidades.Funcionario;
import com.entidades.Proveedor;
import com.entidades.Tipo;
import com.entidades.VentaDet;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import util.HibernateUtil;

/**
 *
 * @author Geek
 */
public class CompraApp extends javax.swing.JDialog {

    /** Creates new form VentaApp */
    public int idCompra =0;
    private DefaultTableModel model;//Variable para manejar el DefaultTableModel.
    private Session st;//Variable para almacenar la Session de Hibernate.
    private int var,idArtt,numCompra;//Variables de clase auxiliares necesarias.

    public CompraApp(/*java.awt.Frame parent, boolean modal*/) {
        //super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);//Centra formulario
        hibernateSession();//Método para abrir una Session de Hibernate.
        arranque();//Meto para limpiar y habilitar campos.
        cargarCombo();
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                this.id.setText("1");
                this.nombres.setText("Dr. Eular");
                this.apellidos.setText("Bautista");
                this.id.setVisible(false);
                this.idArt.setVisible(false);
                nuevo();
                cargarCombo2();
                cmbLote.setEnabled(false);
                this.desArt.setVisible(false);
                jPanel3.setEnabled(false);
                addEscapeKey();
                this.nombres.setEnabled(false);
                this.apellidos.setEnabled(false);
    }
    public CompraApp(java.awt.Frame parent, boolean modal, int idCompra) {
        super(parent, modal);
        this.idCompra=idCompra;
        initComponents();
        setLocationRelativeTo(null);//Centra formulario
        hibernateSession();//Método para abrir una Session de Hibernate.
        cargarCombo();
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                this.id.setVisible(false);
                this.idArt.setVisible(false);
                cargarCombo2();
                cmbLote.setEnabled(false);
                this.desArt.setVisible(false);
                jPanel3.setEnabled(false);
                addEscapeKey();
                this.nombres.setEnabled(false);
                this.apellidos.setEnabled(false);
                cargarCompra();
    }
    
    private void cargarCompra(){
        tableModel();
        st.beginTransaction();
        List comprList = new ArrayList();
        Query query=(Query)st.createQuery("From  CompraCab");
        List<CompraCab> lista=query.list();
        int id=0;
        for(Iterator<CompraCab>it=lista.iterator(); it.hasNext();){
            CompraCab compraCab = it.next();
            int num = compraCab.getNum();
            this.id.setText(String.valueOf(compraCab.getId()));
            this.nombres.setText(compraCab.getFuncionario().getNombres());
            this.apellidos.setText(compraCab.getFuncionario().getApellidos());
            String proveedor = compraCab.getProveedor().getDes();
            txtNfactura.setText(compraCab.getNFactura());
            txtSerie.setText(compraCab.getSerie());
            txtTotal.setText(String.valueOf(compraCab.getTotal()));
            totalGeneral.setText(String.valueOf(compraCab.getTotal()));
            cmbProveedor.setSelectedItem(proveedor);
            Calendar ca = compraCab.getFecha();
            ca.getInstance();
            Date d = ca.getTime();
            fecha.setDate(d);
            List<CompraDet> lista1 = (List<CompraDet>) st.createQuery("From CompraDet").list();
            double contador=0;
            for (CompraDet compraList : lista1) {
                if (num==idCompra) {
                    model.addRow(new Object[]{
                        compraList.getId(), compraList.getArticulo().getDes(), compraList.getArticulo().getPco(), compraList.getCantidad(), compraList.getImporte()});
                      
            }
        }
            
        
        }
    
    
    }
    
    public static int idArticulo;
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        totalGeneral = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        eliminar = new org.edisoncor.gui.button.ButtonSeven();
        agregar = new org.edisoncor.gui.button.ButtonSeven();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pco = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        can = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        producto = new javax.swing.JComboBox();
        idArt = new javax.swing.JTextField();
        desArt = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNfactura = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox();
        fecha = new com.toedter.calendar.JDateChooser();
        cmbLote = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        hora = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        num = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        nombres = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compras");
        setModal(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        nuevo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/New-file-icon-3.png"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nuevo.setContentAreaFilled(false);
        nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        guardar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/Save-icon.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        guardar.setContentAreaFilled(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/img/delete-file-icon.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cancelar.setContentAreaFilled(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel24.setText("Q.");

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel25.setText("Total esta compra:");

        totalGeneral.setEditable(false);
        totalGeneral.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalGeneral.setForeground(new java.awt.Color(0, 0, 102));
        totalGeneral.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel24)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(totalGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(4, 4, 4)
                        .addComponent(totalGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 520, 90));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        eliminar.setBackground(new java.awt.Color(255, 0, 0));
        eliminar.setText("Eliminar");
        eliminar.setFont(new java.awt.Font("Comfortaa", 1, 14)); // NOI18N
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        agregar.setBackground(new java.awt.Color(0, 204, 0));
        agregar.setText("Agregar");
        agregar.setFont(new java.awt.Font("Comfortaa", 1, 14)); // NOI18N
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        agregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                agregarKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Artículo", "Precio de Compra", "Cantidad", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Articulo"));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText("Descripcion");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Precio de Compra:");

        pco.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel14.setText("Disponibles:");

        can.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setText("Cantidad:");

        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });
        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel16.setText("Total:");

        total.setEditable(false);

        jLabel22.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jLabel22.setText("Q.");

        jLabel23.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jLabel23.setText("Q.");

        producto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        producto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productoItemStateChanged(evt);
            }
        });
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });

        idArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idArtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(producto, 0, 241, Short.MAX_VALUE)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pco, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9)
                        .addGap(23, 23, 23)
                        .addComponent(desArt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(can, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(idArt, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desArt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(can, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel14))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)
                                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comfortaa", 1, 12))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setText("No. Factura:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setText("Serie:");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setText("Fecha:");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setText("No. Lote");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setText("Total factura:");

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

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setText("Proveedor:");

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNfactura)
                    .addComponent(cmbProveedor, 0, 124, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotal)
                    .addComponent(cmbLote, 0, 159, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel17)
                            .addComponent(cmbLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 830, 380));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comfortaa", 1, 12))); // NOI18N

        hora.setEditable(false);
        hora.setForeground(new java.awt.Color(0, 51, 153));
        hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hora.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        hora.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel20.setText("Hora:");

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setText("No. Compra:");

        num.setEditable(false);
        num.setForeground(new java.awt.Color(0, 51, 153));
        num.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        num.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel26.setText("Usuario:");

        nombres.setEditable(false);

        apellidos.setEditable(false);

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 830, 60));

        jLabel7.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setText("Compras");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel27.setFont(new java.awt.Font("Comfortaa", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 153));
        jLabel27.setText("Puede utilizarce para cuando se compra un solo producto...");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Comfortaa", 3, 12)); // NOI18N
        jLabel1.setText("Esc para salir. . .");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 610, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 790, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        nuevo();// Evento ActionPerformed para botón nuevo.
    }//GEN-LAST:event_nuevoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        arranque();// Evento ActionPerformed para botón cancelar.
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyPressed
        //Uso del Evento KeyPressed dentro del campo de texto "id".
//        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
//            buscarFuncionario();
//        }
    }//GEN-LAST:event_idKeyPressed

    private void idArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idArtKeyPressed
        //Uso del Evento KeyPressed dentro del campo de texto "idArt".
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscarArticulo();
        }
    }//GEN-LAST:event_idArtKeyPressed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        guardar();// Evento ActionPerformed para botón guardar.
    }//GEN-LAST:event_guardarActionPerformed

    private void cantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyPressed
        //Uso del Evento KeyPressed dentro del campo de texto "cantidad".
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            calcularParcial();
        }
    }//GEN-LAST:event_cantidadKeyPressed

    private void productoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productoItemStateChanged
        // TODO add your handling code here:
        if(producto.getSelectedIndex()>0){
           buscarArticulocom();
        }
        else{
        this.desArt.setText(null);
        this.pco.setText((null));
        this.can.setText((null));
        this.cantidad.setText(null);
        this.idArt.setText(null);
        }
        
        
    }//GEN-LAST:event_productoItemStateChanged

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productoActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
        agregar();// Evento ActionPerformed para botón agregar.

    }//GEN-LAST:event_agregarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        eliminar();// Evento ActionPerformed para botón eliminar.
    }//GEN-LAST:event_eliminarActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
        // TODO add your handling code here:
//        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
//            calcularParcial2();
//            btnGuardar.requestFocus();
//        }
    }//GEN-LAST:event_txtTotalKeyPressed

    private void cmbProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbProveedorFocusLost
        // TODO add your handling code here:
        this.cmbProveedor.getSelectedIndex();
    }//GEN-LAST:event_cmbProveedorFocusLost

    private void cmbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProveedorActionPerformed

    private void cmbProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbProveedorKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbProveedorKeyPressed

    private void cmbLoteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbLoteFocusLost
        // TODO add your handling code here:
//        int idLote= ((Lote)cmbLote.getSelectedItem()).getId();
//        if(buscarLote(idLote)){
//            JOptionPane.showMessageDialog(null, "Lote valido");
//        }else{
//            ingresarNuevoLote();
//        }

    }//GEN-LAST:event_cmbLoteFocusLost

    private void agregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_agregarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            agregar();
        }
    }//GEN-LAST:event_agregarKeyPressed

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
            java.util.logging.Logger.getLogger(CompraApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompraApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompraApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompraApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CompraApp dialog = new CompraApp(/*new javax.swing.JFrame(), true*/);
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
    private org.edisoncor.gui.button.ButtonSeven agregar;
    private javax.swing.JTextField apellidos;
    private javax.swing.JTextField can;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JComboBox cmbLote;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JTextField desArt;
    private org.edisoncor.gui.button.ButtonSeven eliminar;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField hora;
    private javax.swing.JTextField id;
    private javax.swing.JTextField idArt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombres;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextField num;
    private javax.swing.JTextField pco;
    private javax.swing.JComboBox producto;
    private javax.swing.JTextField total;
    private javax.swing.JTextField totalGeneral;
    private javax.swing.JTextField txtNfactura;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
public void hibernateSession(){
    //Abrimos una session y la guardamos en una variable de clase.
    st = HibernateUtil.getSessionFactory().openSession();
}

public void buscarArticulo(){
    //Utilizamos el método siguiente para buscar artículos por el "ID",
    //este método se llama desde un evento KeyPressed.
    int idArti = 0;
    try {
        try {
           idArti = Integer.parseInt(this.idArt.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ID debe ser numérico.");
        }
        Articulo art = (Articulo)st.load(Articulo.class, idArti);
        this.id.setText(String.valueOf(idArti));
        this.desArt.setText(art.getDes());
        this.pco.setText(String.valueOf(art.getPco()));
        this.can.setText(String.valueOf(art.getCan()));
        this.cantidad.requestFocus();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No hay artículo con ID: " + idArti);
    }    
}
public void arranque(){
    //Configuramos objetos para el arranque.
    addEscapeKey();
    hibernateSession();
    this.producto.setEnabled(false);
    this.cmbProveedor.setEnabled(false);
    this.nuevo.setEnabled(true);
    this.agregar.setEnabled(false);
    this.eliminar.setEnabled(false);
    this.guardar.setEnabled(false);
    this.num.setText(null);
    AutoCompleteDecorator.decorate(this.cmbProveedor);
    this.hora.setText(null);
    this.id.setText("1");
    this.nombres.setText("Dr.Eular");
    this.apellidos.setText("Bautista");
    this.id.setEnabled(false);
    this.nombres.setText(null);
    this.apellidos.setText(null);
    this.idArt.setText(null);
    this.idArt.setEnabled(false);
    this.desArt.setText(null);
    this.pco.setText(null);
    this.can.setText(null);
    this.cantidad.setText(null);
    this.cantidad.setEnabled(false);
    this.total.setText(null);
    this.totalGeneral.setText(null);
    tableModel();
}


public void tableModel(){
    //Configuramos el jTable utilizando DefaultTableModel
    this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(15);
    this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
    this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
    this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
    this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
    model = (DefaultTableModel)this.jTable1.getModel();
    model.setNumRows(0);
}

public void obtenetID(){
    //Utilizamos el método siguiente para conseguir en número de compra...
    //correspondiente
    numCompra = 0;
    List<CompraCab> lista = (List<CompraCab>)st.createQuery("From CompraCab").list();
    for (Iterator<CompraCab> it = lista.iterator(); it.hasNext();) {
        CompraCab compraCab = it.next();
        if (compraCab.getNum()!=0) {
            numCompra = compraCab.getNum() + 1;
        }
        
    }
    if(numCompra==0){
        numCompra=1;
    } 
}
public void retornarFechaHoy(){
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date2 = new Date(stamp.getTime());
        System.out.println(date2);
        SimpleDateFormat formato = new SimpleDateFormat("YYMMdd");
        System.out.println("" + formato.format(date2));
        fecha.setDate(date2);
    }
public void nuevo(){
    //Configuramos acciones, habilitamos campos al precionar el botón nuevo
    obtenetID();
    this.id.setText("1");
    this.nombres.setText("Dr. Eular");
    this.apellidos.setText("Bautista");
    this.producto.setEnabled(true);
    this.cmbProveedor.setEnabled(true);
    this.id.setEnabled(true);
    this.idArt.setEnabled(true);
    this.cantidad.setEnabled(true);
    this.agregar.setEnabled(true);
    this.eliminar.setEnabled(true);
    this.guardar.setEnabled(true);
    this.nuevo.setEnabled(false);
    this.id.requestFocus();
    Calendar cal = Calendar.getInstance();
    String calString = retornarString(cal);
    String calHora = retornarStringHora(cal);
    retornarFechaHoy();
    this.num.setText(String.valueOf(numCompra));    
    this.hora.setText(calHora);
}

public void calcularParcial(){
    //Lo siguiente nos permite calcular el total para cada artículo,
    //esto tomando en cuenta total de compra y precio de compra.
    double canCompra = 0;
    double pCompra = 0;
    double totalParcial = 0 ;
    try {
        canCompra = Double.parseDouble(this.cantidad.getText());
        if(canCompra>0){
        pCompra = Double.parseDouble(this.pco.getText());       
           totalParcial = canCompra * pCompra;
           totalParcial=Math.rint(totalParcial*100)/100;
           this.total.setText(String.valueOf(totalParcial)); 
           this.agregar.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
            cantidad.setText("");
        }
           
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Se requiere datos numérico.");
    }
}
//public void buscarFuncionario(){
//    //Utilizamos el método siguiente para buscar funcionario por el "ID",
//    //este método se llama desde un evento KeyPressed.
//    int idFunc = 0;
//    try {
//        try {
//           idFunc = Integer.parseInt(this.id.getText());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "ID debe ser numérico.");
//        }
//         Funcionario funcio = (Funcionario)st.load(Funcionario.class, idFunc);
//         this.nombres.setText(funcio.getNombres());
//         this.apellidos.setText(funcio.getApellidos());
//         this.idProv.requestFocus();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "No hay funcionario con ID: " + idFunc);
//    }    
//}
//public void buscarProveedor(){
//    //Utilizamos el método siguiente para buscar proveedor por el "ID",
//    //este método se llama desde un evento KeyPressed.
//    int idPrv = 0;
//    try {
//        try {
//           idPrv = ((Proveedor)proveedor.getSelectedItem()).getId();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "ID debe ser numérico.");
//        }
//         Proveedor proveedor = (Proveedor)st.load(Proveedor.class, idPrv);
//         this.idProv.setText(String.valueOf(idPrv));
//         this.desProv.setText(proveedor.getDes());
//         this.dirProv.setText(proveedor.getDir());
//         this.idArt.requestFocus();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "No hay proveedor con ID: " + idPrv);
//    }    
//}
public void agregar(){
    //Método llamado desde el botón agregar, primeramente comprobamos que los datos sean correctos,
    //que los campos no esten vacios, que no se repitan datos.
    if(this.id.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Seleccione un funcionario.");
    }
    else{
        if(this.cmbProveedor.getSelectedItem().equals(null)){
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor.");
        }
        else{
            if(this.idArt.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Seleccione un articulo.");
            }
            else{
                if(this.cantidad.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Indique una cantidad.");
                }
                else{
                    verificar();
                    if(var>=1){
                        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Artículo ya Agregado. Desea sumar la cantidad.", "Mensaje del Sistema.", JOptionPane.YES_NO_OPTION);
                        if(showConfirmDialog==0){
                           sumarRepetido(); 
                           calcular();
                           confimAgregar();
                           limpiar();
                        }
                        else{
                            limpiar();
                            this.idArt.requestFocus();
                        }
                    }
                    else{
                            model.addRow(new Object[]{
                            this.idArt.getText(),this.desArt.getText(),this.pco.getText(),this.cantidad.getText(),this.total.getText()
                            });                    
                            calcular();
                            confimAgregar();
                            limpiar(); 
                    }
                    
                }
            }
        }
    }
}



public void confimAgregar(){
    //Método que pregunta al usuario si desea agregar más artículo a la lista.
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Agregar más Articulos.", "Mensaje del Sistema.", JOptionPane.YES_NO_OPTION);
        if(showConfirmDialog == 0){
            this.idArt.requestFocus();
        }
        else{
            this.guardar.requestFocus();
        }
        
}
public void limpiar(){
    //Limpia campo de datos..
    this.idArt.setText(null);
    this.desArt.setText(null);
    this.pco.setText(null);
    this.can.setText(null);
    this.cantidad.setText(null);
    this.total.setText(null);
    this.id.setEnabled(false);
    
    
}
public void calcular(){
    //Método para calcular el total de la compra, obteniendo datos del jtable.
    double totalG = 0;
    for (int i = 0; i < this.jTable1.getRowCount(); i++) {
        Object valueAt = model.getValueAt(i, 4);
        totalG += Double.parseDouble(valueAt.toString());
        totalG = Math.rint(totalG*100)/100;
    }
    this.totalGeneral.setText(String.valueOf(totalG));
    this.txtTotal.setText(String.valueOf(totalG));
}
public void verificar(){
    //Método para verificar que no se duplique el mismo artículo en la tabla,
    //para ello se comprueba el id del artículo.
    var = 0;
    int idAr = Integer.parseInt(this.idArt.getText());
    if(this.jTable1.getRowCount()>=1){
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            Object valueAt = model.getValueAt(i, 0);
            int parseInt = Integer.parseInt(valueAt.toString());
            if(idAr == parseInt){
                var = 1;
                idArtt = i;
            }        
        }        
    }  
}
public void sumarRepetido(){
        //Si se repite el ingreso de un artículo específico,se puede obtar por sumar la cantidad de compra,
        //este método localizar el id del artículo específico y aumenta la cantidad de la
        //compra sumandola.
        int artCant = Integer.parseInt(this.cantidad.getText());
        double artTotal = Double.parseDouble(this.total.getText());
        Object valueAt = model.getValueAt(idArtt, 3);
        Object valueAt1 = model.getValueAt(idArtt, 4);
        int cantArt = Integer.parseInt(valueAt.toString());
        double totalArt = Double.parseDouble(valueAt1.toString());
        int x = artCant + cantArt;
        double y = artTotal + totalArt;
            model.setValueAt(x, idArtt, 3);
            model.setValueAt(y, idArtt, 4);        
}

public String retornarString(Calendar fecha){
        //Médodo que se le para un objeto calendar y la combierte en formato String-Fecha
        String retorno=null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (fecha != null) {
        retorno = sdf.format(fecha.getTime());
        }
        return retorno;
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
public void eliminar(){
    //Permite al usuario seleccionar una fila específica de la table y eliminarla.
    if(this.jTable1.getSelectedRow()==-1){
      JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de la tabla.");  
    }
    else{
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Eliminar fila seleccionada.", "Mensaje del Sistema.", JOptionPane.YES_NO_OPTION);
        if(showConfirmDialog == 0){
            int sel = this.jTable1.getSelectedRow();
            model.removeRow(sel);
            this.idArt.requestFocus();
        }
        else{
            this.idArt.requestFocus();
        }
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
    if(this.id.getText().isEmpty() ||this.cmbProveedor.getSelectedItem().equals(null) ){
        JOptionPane.showMessageDialog(null, "Faltan datos para guardar. Verifique.");
    }
    else{
        if(this.jTable1.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "No hay datos para guardar.");
        }else{
            if(txtNfactura.getText().isEmpty() && txtSerie.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Faltan datos de factura");
            }
        else{
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Desea guardar esta compra.", "Mensaje del Sistema.", JOptionPane.YES_NO_OPTION);
            if(showConfirmDialog == 0){
                try {
                    st.beginTransaction();
                    CompraCab compra = new CompraCab();
                    int idFun = Integer.parseInt(this.id.getText());
                    int idPrv = ((Proveedor)cmbProveedor.getSelectedItem()).getId();
                    double totalCompra = Double.parseDouble(this.totalGeneral.getText());
                    String NFac = txtNfactura.getText();
                    String Ser = txtSerie.getText();
                    Funcionario funcionario = (Funcionario)st.load(Funcionario.class, idFun);
                    Proveedor proveedor = (Proveedor)st.load(Proveedor.class, idPrv);
                    SimpleDateFormat formato = new SimpleDateFormat("YYMMdd");
                    String fecha1 = formato.format(fecha.getDate());
                    Calendar fechaCompra = retornarCalendar(fecha1);
                    String horaCompra = this.hora.getText();
                    compra.setNFactura(NFac);
                    compra.setSerie(Ser);
                    compra.setNum(Integer.valueOf(this.num.getText()));
                    compra.setProveedor(proveedor);
                    compra.setFuncionario(funcionario);
                    compra.setFecha(fechaCompra);
                    compra.setHora(horaCompra);
                    compra.setTotal(totalCompra);
                    funcionario.getCompraCabs().add(compra);
                    proveedor.getCompraCabs().add(compra);
                    int rowCount = this.jTable1.getRowCount();
                    int[] idArti = new int[rowCount];
                    int[] cantCompra = new int[rowCount];
                    for (int i = 0; i < this.jTable1.getRowCount(); i++) {
                        CompraDet detalleCompra = new CompraDet();
                        int idArticulo = Integer.parseInt(String.valueOf(model.getValueAt(i, 0)));
                        idArti[i] = idArticulo;
                        Articulo ventaArticulo = (Articulo)st.load(Articulo.class, idArticulo);
                        int cantidadCompra = Integer.parseInt(String.valueOf(model.getValueAt(i, 3)));
                        cantCompra[i]= cantidadCompra;
                        double importeVenta = Double.parseDouble(String.valueOf(model.getValueAt(i, 4)));
                        detalleCompra.setArticulo(ventaArticulo);
                        detalleCompra.setCantidad(cantidadCompra);
                        detalleCompra.setImporte(importeVenta);
                        detalleCompra.setCabecera(compra);
                        compra.getCompraDets().add(detalleCompra);
                    }
                    st.save(compra);
                    st.getTransaction().commit();
                    for (int i = 0; i < idArti.length; i++) {
                        actualizarStrock(cantCompra[i], idArti[i]);
                    }
                    arranque();
                    JOptionPane.showMessageDialog(null, "Compra guardada correctamente.");
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error guardando compra. Verifique.");
                }
                
            }
            else{                
                this.idArt.requestFocus();
            }
            
        }}
    }
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

    DefaultComboBoxModel combomodel;

    public void cargarCombo(){
        
    hibernateSession();
    combomodel=(DefaultComboBoxModel) producto.getModel();
    combomodel.removeAllElements();
    combomodel.addElement("Selecione un producto");
    List<Articulo> lista = (List<Articulo>)st.createQuery("From Articulo a order by a.des").list();
    
    for(Articulo tipoList : lista){
        
        combomodel.addElement(tipoList);            
    }
    System.out.println(""+combomodel.getSize());
    producto.setModel(combomodel);
}
    DefaultComboBoxModel combomodel2;
    public void cargarCombo2(){
        hibernateSession();
        combomodel2=(DefaultComboBoxModel)cmbProveedor.getModel();
        combomodel2.removeAllElements();
        combomodel2.addElement("Seleccione un producto");
        List<Proveedor> listaP = (List<Proveedor>)st.createQuery("From Proveedor").list();
        for(Proveedor lista : listaP){
            combomodel2.addElement(lista);
            
        }
        cmbProveedor.setModel(combomodel2);
    }

    public void buscarArticulocom(){
    int idArti = 0;
    try {
        try {
           idArti = ((Articulo)producto.getSelectedItem()).getId();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ID debe ser numérico.");
        }
        Articulo art = (Articulo)st.load(Articulo.class, idArti);
        this.desArt.setText(String.valueOf(art.getDes()));
        this.pco.setText(String.valueOf(art.getPco()));
        this.can.setText(String.valueOf(art.getCan()));
        this.cantidad.requestFocus();
        this.idArt.setText(""+idArti);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No hay artículo con ID: " + idArti);
    }    
}
    



}
