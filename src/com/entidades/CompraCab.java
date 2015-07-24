/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Geek
 */
@Entity
public class CompraCab implements Serializable {
    private List<CompraDet> compraDets = new ArrayList<CompraDet>();
    private int id;
    private int num;
    private Proveedor proveedor;
    private Funcionario funcionario;
    private Calendar fecha;
    private String hora;
    private double total;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
        
    @Temporal(javax.persistence.TemporalType.DATE)
    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    
    @ManyToOne
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

   
    @ManyToOne
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @OneToMany(mappedBy = "cabecera",cascade= CascadeType.ALL)
    public List<CompraDet> getCompraDets() {
        return compraDets;
    }

    public void setCompraDets(List<CompraDet> compraDets) {
        this.compraDets = compraDets;
    }
        
}
