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
public class Cpassenger {

    private int numero;
    private String nombrePas;
    private String apellidoPas;
    private int tipo_identPas;
    private String num_identPas;
    private String paisPas;

    public Cpassenger() {
    }
    
     public Cpassenger(int num) {
         numero = num;
    }

    public Cpassenger(String nombrePas, String apellidoPas, int tipo_identPas, String numero_identPas, String paisPas) {
        this.nombrePas = nombrePas;
        this.apellidoPas = apellidoPas;
        this.tipo_identPas = tipo_identPas;
        this.num_identPas = numero_identPas;
        this.paisPas = paisPas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    public String getNombrePas() {
        return nombrePas;
    }

    public void setNombrePas(String nombrePas) {
        this.nombrePas = nombrePas;
    }

    public String getApellidoPas() {
        return apellidoPas;
    }

    public void setApellidoPas(String apellidoPas) {
        this.apellidoPas = apellidoPas;
    }

    public int getTipo_identPas() {
        return tipo_identPas;
    }

    public void setTipo_identPas(int tipo_identPas) {
        this.tipo_identPas = tipo_identPas;
    }

    public String getNum_identPas() {
        return num_identPas;
    }

    public void setNum_identPas(String numero_identPas) {
        this.num_identPas = numero_identPas;
    }

    public String getPaisPas() {
        return paisPas;
    }

    public void setPaisPas(String paisPas) {
        this.paisPas = paisPas;
    }
    

}
