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
public class VentaCab implements Serializable {
    private List<VentaDet> ventaDets = new ArrayList<VentaDet>();
    private int num;
    private Cliente cliente;
    private Funcionario funcionario;
    private Calendar fecha;
    private String hora;
    private double total;
    private boolean pagado;
    private String numorden;

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getNumorden() {
        return numorden;
    }

    public void setNumorden(String numorden) {
        this.numorden = numorden;
    }
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }    
    
    @ManyToOne
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @OneToMany(mappedBy = "ventaCab",cascade= CascadeType.ALL)
    public List<VentaDet> getVentaDets() {
        return ventaDets;
    }

    public void setVentaDets(List<VentaDet> ventaDets) {
        this.ventaDets = ventaDets;
    }
    
    
}
