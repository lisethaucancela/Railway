/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.controlador;

import com.riobambarailway.entidades.CPaquete;
import com.riobambarailway.entidades.CReservation;
import com.riobambarailway.modelo.MPaquete;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Liseth
 */
@ManagedBean
@RequestScoped
public class Paso1Controlador {

    private CReservation reserva;
    private String numeropaquete;
    private CPaquete objpaquete;

    public Paso1Controlador() {
        reserva = new CReservation();
        objpaquete = new CPaquete();
    }

    @PostConstruct
    public void reinit() {

    }

    public String obtParam(ActionEvent event) {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map params = facesContext.getExternalContext().getRequestParameterMap();
            //numeropaquete = new Integer((String) params.get("numeropaquete"));
            numeropaquete = (String) event.getComponent().getAttributes().get("numeropaquete");
            objpaquete = MPaquete.obtPaquete(Integer.parseInt(numeropaquete));
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
        return "compra";
    }

    public CReservation getReserva() {
        return reserva;
    }

    public void setReserva(CReservation reserva) {
        this.reserva = reserva;
    }

    public String getNumeropaquete() {
        return numeropaquete;
    }

    public void setNumeropaquete(String numeropaquete) {
        this.numeropaquete = numeropaquete;
    }

    public CPaquete getObjpaquete() {
        return objpaquete;
    }

    public void setObjpaquete(CPaquete objpaquete) {
        this.objpaquete = objpaquete;
    }

}
