/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.clases;

/**
 *
 * @author Walter
 */
public class ClsVentas {
    private String compra;
    private String nombre;
    private String tipo;
    
    public ClsVentas(String comp, String nomb, String tipo) {
        this.compra = comp;
        this.nombre = nomb;
        this.tipo = tipo;
    }

    public ClsVentas() {
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
}
