/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Geek
 */
public class IniciarReportes {
        public static final String DRIVER="com.mysql.jdbc.Driver";
        public static final String RUTA="jdbc:mysql://localhost:3306/proyectobdfa?zeroDateTimeBehavior=convertToNull";
        public static final String USER="root";
        public static final String PASSWORD="";
	public static Connection CONEXION;
        
        public void ReporteCompras(int idProd, Date fecha1, Date fecha2, String NFact){
            try{
                Class.forName(DRIVER);
                CONEXION = DriverManager.getConnection(RUTA,USER,PASSWORD);
                if(idProd==0 && NFact==null)
                {
                    String archivo="src//com//reportes//ComprasAll.jasper";
                    JasperReport reporte=null;
                    reporte=(JasperReport) JRLoader.loadObjectFromFile(archivo);
                    Map param=new HashMap();
                    param.put("fecha1", fecha1);
                    param.put("fecha2", fecha2);
                    JasperPrint jasperprint= JasperFillManager.fillReport(reporte,param,CONEXION);
                    JasperViewer visor=new JasperViewer(jasperprint,false);
                    visor.setTitle("Reporte Compras");
                    visor.setVisible(true);
                }
                if(idProd>0){
                    String archivo="src//com//reportes//ComprasProducto.jasper";
                    JasperReport reporte=null;
                    reporte=(JasperReport) JRLoader.loadObjectFromFile(archivo);
                    Map param=new HashMap();
                    param.put("id",idProd);
                    param.put("fecha1",fecha1);
                    param.put("fecha2",fecha2);
                    JasperPrint jasperprint= JasperFillManager.fillReport(reporte,param,CONEXION);
                    JasperViewer visor=new JasperViewer(jasperprint,false);
                    visor.setTitle("Reporte Compras Producto");
                    visor.setVisible(true);
                }
                if(NFact!=null){
                    String archivo="src//com//reportes//ComprasDetalle.jasper";
                    JasperReport reporte=null;
                    reporte=(JasperReport) JRLoader.loadObjectFromFile(archivo);
                    Map param=new HashMap();
                    param.put("NFactura",NFact);
                    JasperPrint jasperprint= JasperFillManager.fillReport(reporte,param,CONEXION);
                    JasperViewer visor=new JasperViewer(jasperprint,false);
                    visor.setTitle("Reporte Detalle Compras");
                    visor.setVisible(true);
                }
            }catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(null, e);
            }
    }
        public void ReporteProveedor(int idProv, Date fecha1, Date fecha2){
            try{
                Class.forName(DRIVER);
                CONEXION = DriverManager.getConnection(RUTA,USER,PASSWORD);
            if (idProv==0) {
                String archivo="src//com//reportes//ProveedorAll.jasper";
                JasperReport reporte=null;
                reporte = (JasperReport)JRLoader.loadObjectFromFile(archivo);
                Map param=new HashMap();
                param.put("fecha1", fecha1);
                param.put("fecha2", fecha2);
                JasperPrint jasperprint=JasperFillManager.fillReport(reporte, param, CONEXION);
                JasperViewer visor=new JasperViewer(jasperprint,false);
                visor.setTitle("Reporte Proveedores");
                visor.setVisible(true);
            }else{
                 String archivo="src//com//reportes//ProveedorDetalle.jasper";
                JasperReport reporte=null;
                reporte = (JasperReport)JRLoader.loadObjectFromFile(archivo);
                Map param=new HashMap();
                param.put("id", idProv);
                param.put("fecha1", fecha1);
                param.put("fecha2", fecha2);
                JasperPrint jasperprint=JasperFillManager.fillReport(reporte, param, CONEXION);
                JasperViewer visor=new JasperViewer(jasperprint,false);
                visor.setTitle("Reporte Proveedores");
                visor.setVisible(true);
            }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Hubo un error"+e);
            }
        
        }
        public void ReporteVentas(int idProd, Date fecha1, Date fecha2, int idVenta, int marc, int general) {
            try{
                Class.forName(DRIVER);
                CONEXION = DriverManager.getConnection(RUTA,USER,PASSWORD);
                if (idProd==0 && idVenta==0 && marc==0 && general==0) {
                    //la ruta del archivo debe ser "src//...//...//reporte.jasper"
                    String archivo="src//com//reportes//VentasAll.jasper";
                    JasperReport reporte=null;
                    reporte=(JasperReport)JRLoader.loadObjectFromFile(archivo);
                    Map param=new HashMap();
                    param.put("fecha1", fecha1);
                    param.put("fecha2", fecha2);
                    JasperPrint jasperprint = JasperFillManager.fillReport(reporte, param, CONEXION);
                    JasperViewer visor=new JasperViewer(jasperprint,false);
                    visor.setTitle("Reporte Ventas");
                    visor.setVisible(true);
                }
                if(idProd==0 && idVenta==0 && marc==0 && general==1){
                    //la ruta del archivo debe ser "src//...//...//reporte.jasper"
                    String archivo="src//com//reportes//VentasAllGeneral.jasper";
                    JasperReport reporte=null;
                    reporte=(JasperReport)JRLoader.loadObjectFromFile(archivo);
                    Map param=new HashMap();
                    param.put("fecha1", fecha1);
                    param.put("fecha2", fecha2);
                    JasperPrint jasperprint = JasperFillManager.fillReport(reporte, param, CONEXION);
                    JasperViewer visor=new JasperViewer(jasperprint,false);
                    visor.setTitle("Reporte Ventas");
                    visor.setVisible(true);
                }
                 if (marc==1 && idVenta==0 && idProd==0 && general==0) {
                    //la ruta del archivo debe ser "src//...//...//reporte.jasper"
                    String archivo="src//com//reportes//VentasAllMedicamentos.jasper";
                    JasperReport reporte=null;
                    reporte=(JasperReport)JRLoader.loadObjectFromFile(archivo);
                    Map param=new HashMap();
                    param.put("fecha1", fecha1);
                    param.put("fecha2", fecha2);
                    JasperPrint jasperprint = JasperFillManager.fillReport(reporte, param, CONEXION);
                    JasperViewer visor=new JasperViewer(jasperprint,false);
                    visor.setTitle("Reporte Ventas");
                    visor.setVisible(true);
                }
                if(idProd>0&&general==0){
                    String archivo="src//com//reportes//VentasProducto.jasper";
                    JasperReport reporte=null;
                    reporte=(JasperReport)JRLoader.loadObjectFromFile(archivo);
                    Map param=new HashMap();
                    param.put("id",idProd);
                    param.put("fecha1", fecha1);
                    param.put("fecha2", fecha2);
                    JasperPrint jasperprint = JasperFillManager.fillReport(reporte, param, CONEXION);
                    JasperViewer visor=new JasperViewer(jasperprint,false);
                    visor.setTitle("Reporte Ventas Producto");
                    visor.setVisible(true);
                }
                if(idVenta>=1&& general ==0){
                    //la ruta del archivo debe ser "src//...//...//reporte.jasper"
                    String archivo="src//com//reportes//VentasDetalle.jasper";
                    JasperReport reporte=null;
                    reporte=(JasperReport)JRLoader.loadObjectFromFile(archivo);
                    Map param=new HashMap();
                    param.put("id", idVenta);
                    JasperPrint jasperprint = JasperFillManager.fillReport(reporte, param, CONEXION);
                    JasperViewer visor=new JasperViewer(jasperprint,false);
                    visor.setTitle("Reporte Detalle Ventas");
                    visor.setVisible(true);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+ e);
            }
        
        
        }
}
