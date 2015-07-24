/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Geek
 */
@Entity
@Table(name = "Articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findBydes", query = "SELECT a FROM Articulo a WHERE a. des like :descripcion"),
    @NamedQuery(name = "Articulo.findBydes&pres", query = "SELECT a FROM Articulo a WHERE a. des = :descripcion"),

})
public class Articulo implements Serializable {
    private int id;
    private String des;
    private double pco;
    private double por;
    private double pve;
    private int can;
    private Tipo tipo;
    

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPco() {
        return pco;
    }

    public void setPco(double pco) {
        this.pco = pco;
    }

    public double getPor() {
        return por;
    }

    public void setPor(double por) {
        this.por = por;
    }

    public double getPve() {
        return pve;
    }

    public void setPve(double pve) {
        this.pve = pve;
    }

    @ManyToOne
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return this.des;
    
    }
    
       
    
}
