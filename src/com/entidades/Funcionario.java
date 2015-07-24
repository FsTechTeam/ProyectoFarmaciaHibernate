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
import javax.persistence.OneToMany;

/**
 *
 * @author Geek
 */
@Entity
public class Funcionario implements Serializable {
    private List<CompraCab> compraCabs = new ArrayList<CompraCab>();
    private List<VentaCab> ventaCabs = new ArrayList<VentaCab>();
    private int id;
    private String nombres;
    private String apellidos;
    private String dir;
    private String tel;
    private String cargo;

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @OneToMany(mappedBy = "funcionario")
    public List<VentaCab> getVentaCabs() {
        return ventaCabs;
    }

    public void setVentaCabs(List<VentaCab> ventaCabs) {
        this.ventaCabs = ventaCabs;
    }

    @OneToMany(mappedBy = "funcionario")
    public List<CompraCab> getCompraCabs() {
        return compraCabs;
    }

    public void setCompraCabs(List<CompraCab> compraCabs) {
        this.compraCabs = compraCabs;
    }
    
    
}
