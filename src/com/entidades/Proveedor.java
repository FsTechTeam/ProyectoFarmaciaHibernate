/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "Proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT a FROM Proveedor a"),
    @NamedQuery(name = "Proveedor.findBydes", query = "SELECT a FROM Proveedor a WHERE a. des like :descripcion"),
    @NamedQuery(name = "Proveedor.findBydes&pres", query = "SELECT a FROM Proveedor a WHERE a. des = :descripcion"),

})
public class Proveedor implements Serializable {
    private List<CompraCab> compraCabs = new ArrayList<CompraCab>();
    private int id;
    private String des;
    private String dir;
    private String tel;
    private String correo;
    private String nit;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @OneToMany(mappedBy = "proveedor")
    public List<CompraCab> getCompraCabs() {
        return compraCabs;
    }

    public void setCompraCabs(List<CompraCab> compraCabs) {
        this.compraCabs = compraCabs;
    }
     @Override
    public String toString(){
        return this.des;
    
    }
}
