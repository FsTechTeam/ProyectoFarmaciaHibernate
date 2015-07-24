/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Geek
 */
@Entity
public class VentaDet implements Serializable {
    private int num;
    private Articulo articulo;
    private int cant;
    private double importe;
    private VentaCab ventaCab;

    @ManyToOne
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getNum() {
        return num;
    }
    
    public void setNum(int num) {
        this.num = num;
    }

    @ManyToOne
    public VentaCab getVentaCab() {
        return ventaCab;
    }

    public void setVentaCab(VentaCab ventaCab) {
        this.ventaCab = ventaCab;
    }   
    
}
