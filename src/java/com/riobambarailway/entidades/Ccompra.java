/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.entidades;

import java.sql.Date;

/**
 *
 * @author William
 */
public class Ccompra {
    private int idCompra;
    private int idPack;
    private Date fecha;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;
    private Ccomprador idComprador;

    public Ccompra() {
    }

    public Ccompra(int idCompra, int idPack, Date fecha, int cantidad, double precioUnitario, double precioTotal) {
        this.idCompra = idCompra;
        this.idPack = idPack;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdPack() {
        return idPack;
    }

    public void setIdPack(int idPack) {
        this.idPack = idPack;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Ccomprador getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Ccomprador idComprador) {
        this.idComprador = idComprador;
    }

   
}
