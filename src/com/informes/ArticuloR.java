/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informes;

/**
 *
 * @author Ariel
 */
public class ArticuloR {
    private int id;
    private String des;
    private String tipo;
    private int pve;
    private int can;

    public ArticuloR(int id, String des, String tipo, int pve, int can) {
        this.id = id;
        this.des = des;
        this.tipo = tipo;
        this.pve = pve;
        this.can = can;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPve() {
        return pve;
    }

    public void setPve(int pve) {
        this.pve = pve;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
        
}
