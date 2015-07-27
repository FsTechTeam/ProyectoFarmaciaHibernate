/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Geek
 */
@Entity
public class Lote implements Serializable{
    
    private int id;
    private int NLote;
    private Date FechaV;
    private Articulo articulo;

    public int getNLote() {
        return NLote;
    }

    public void setNLote(int NLote) {
        this.NLote = NLote;
    }

    public Date getFechaV() {
        return FechaV;
    }

    public void setFechaV(Date FechaV) {
        this.FechaV = FechaV;
    }
    
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    
    @ManyToOne
    public Articulo getArticulo(){
        return articulo;
    }
    public void setArticulo(Articulo articulo){
        this.articulo=articulo;
    }
}
