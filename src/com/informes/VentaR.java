/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informes;

/**
 *
 * @author Ariel
 */
public class VentaR {
    private int id;
    private String funcionario;
    private String cliente;
    private String fecha;
    private String articulo;
    private int cantidad;
    private double importe;

    public VentaR(int id, String funcionario, String cliente, String fecha, String articulo, int cantidad, double importe) {
        this.id = id;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.fecha = fecha;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(long importe) {
        this.importe = importe;
    }  
    
}
