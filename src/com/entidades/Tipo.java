/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Geek
 */

@Entity
@Table(name = "Tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT a FROM Tipo a"),
    @NamedQuery(name = "Tipo.findBydes", query = "SELECT a FROM Tipo a WHERE a. des like :descripcion"),
    @NamedQuery(name = "Tipo.findBydes&pres", query = "SELECT a FROM Tipo a WHERE a. des = :descripcion"),

})
public class Tipo implements Serializable {
    private List<Articulo> articulos = new ArrayList<Articulo>();
    private int id;
    private String des;
    
    @Column(length=50)
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

    @OneToMany(mappedBy = "tipo",cascade= CascadeType.ALL)
    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
    @Override
    public String toString(){
        return this.des;
    
    }
    
}
