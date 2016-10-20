/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.entidades;

/**
 *
 * @author William
 */
public class Ccomprador {

    private int idComprador;
    private String nombreComprador;
    private String apellidoComprador;
    private String correoComprador;
    private String celularComprador;
    private String telefonoComprador;
    private String telTrabajoComprador;

    public Ccomprador() {
    }

    public Ccomprador(int idComprador, String nombreComprador, String apellidoComprador, String correoComprador, String celularComprador, String telefonoComprador, String telTrabajoComprador) {
        this.idComprador = idComprador;
        this.nombreComprador = nombreComprador;
        this.apellidoComprador = apellidoComprador;
        this.correoComprador = correoComprador;
        this.celularComprador = celularComprador;
        this.telefonoComprador = telefonoComprador;
        this.telTrabajoComprador = telTrabajoComprador;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getApellidoComprador() {
        return apellidoComprador;
    }

    public void setApellidoComprador(String apellidoComprador) {
        this.apellidoComprador = apellidoComprador;
    }

    public String getCorreoComprador() {
        return correoComprador;
    }

    public void setCorreoComprador(String correoComprador) {
        this.correoComprador = correoComprador;
    }

    public String getTelefonoComprador() {
        return telefonoComprador;
    }

    public void setTelefonoComprador(String telefonoComprador) {
        this.telefonoComprador = telefonoComprador;
    }

    public String getTelTrabajoComprador() {
        return telTrabajoComprador;
    }

    public void setTelTrabajoComprador(String telTrabajoComprador) {
        this.telTrabajoComprador = telTrabajoComprador;
    }

    public String getCelularComprador() {
        return celularComprador;
    }

    public void setCelularComprador(String celularComprador) {
        this.celularComprador = celularComprador;
    }

}
