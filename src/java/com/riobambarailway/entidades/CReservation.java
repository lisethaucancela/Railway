/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.entidades;

/**
 *
 * @author Liseth
 */
public class CReservation {

    private int id;
    private CPaquete objpaquete;

    public CReservation() {
    }

    public CReservation(CPaquete objpaquete) {
        this.objpaquete = objpaquete;
    }

    public CPaquete getObjpaquete() {
        return objpaquete;
    }

    public void setObjpaquete(CPaquete objpaquete) {
        this.objpaquete = objpaquete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

}
