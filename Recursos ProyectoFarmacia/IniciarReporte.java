/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aporte_reportes;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import mouna.ConexionDB;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Gerson
 */
public class IniciarReporte {
    Connection conn = null;
    
    public IniciarReporte() { }

    public static void ejecutarReporte(String parametroBD, String rutaReporte, String nombreReporte){
        try{
            //String archivo = "src\\Reportes\\reporte1.jasper";
            String archivo = rutaReporte;
            System.out.println("cargando desde: " + archivo);
            if(archivo == null){
                System.out.println("No se encuentra el archivo");
                System.exit(2);
            }
            
            JasperReport masterReport = null;
            
            try
            {
                masterReport = (JasperReport) JRLoader.loadObject(archivo);
            }
            catch(JRException er)
            {
               System.out.println("Error cargando el reporte maestro: " + er.getMessage());
               System.exit(3);
            }
            File logo = new File("src\\aporte_reportes\\logo.jpg"); //solo le cambias la ruta donde esta la imagen
            System.out.println(logo.getAbsolutePath());
            //este es el parametro, se pueden agregar mas parametros con parametro.put
            Map parametro = new HashMap();
            parametro.put("dato", parametroBD);
            parametro.put("ruta", logo);
            //reporte diseñado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, ConexionDB.ObtenerConexion());
            
            //se lanza el viewer de Jasper, no termina aplicacion salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle(nombreReporte);
            jviewer.setVisible(true);
        }catch(Exception e){
            System.out.println("Mensaje de Error" + e.getMessage());
        }   
    }
    
    public void cerrar(){
        try
        {
            conn.close();
        }catch(SQLException er){
            er.printStackTrace();
        }
    }
}
