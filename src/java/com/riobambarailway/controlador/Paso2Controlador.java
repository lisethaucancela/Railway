/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.controlador;

import com.riobambarailway.entidades.CReservation;
import com.riobambarailway.entidades.Ccompra;
import com.riobambarailway.entidades.Ccomprador;
import com.riobambarailway.entidades.Cpassenger;
import com.riobambarailway.modelo.MCompra;
import com.riobambarailway.modelo.Mcomprador;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import recursos.Util;

/**
 *
 * @author Liseth
 */
@ManagedBean(name="Paso2Controlador")
@RequestScoped
public class Paso2Controlador {

    private CReservation reserva;
    private Cpassenger objpasajero;
    private Ccompra objcompra;
    private Integer numeropaquete;
    private int cantidad;
    private Ccomprador objcomprador;
    private List<Cpassenger> lstPasajeros = new ArrayList<Cpassenger>();
    
    @ManagedProperty("#{PagoControlador}")
    private PagoControlador pago;

    public Paso2Controlador() {
        this.objcompra = new Ccompra();
        this.objpasajero = new Cpassenger();
        this.objcomprador = new Ccomprador();
    }

    @PostConstruct
    public void reinit() {
        obtPaquete();
    }

    public void obtPaquete() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map params = facesContext.getExternalContext().getRequestParameterMap();
          //  numeropaquete = new Integer((String) params.get("numeropaquete"));
           // cantidad = new Integer((String) params.get("cantidad"));
            //String Fecha = (String) params.get("fecha");
            /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
             Date myReceivedDate = dateFormat.parse(Fecha);
             String NewFecha = dateFormat.format(myReceivedDate);*/

            //objcompra.setFecha(Fecha);
            for (int i = 0; i < pago.getCantidad(); i++) {
                lstPasajeros.add(new Cpassenger());
            }
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    public void insertarDatos() {
        try {

            /*if (Mcomprador.insertarComprador(objcomprador)) {
                if (MCompra.insertarCompra(objcompra)) {
                    Util.addSuccessMessage("Succesfull", "Datos Ingresados");
                } else {
                    Util.addErrorMessage("Datos no Ingresados");
                }
                Util.addSuccessMessage("Succesfull", "Datos Ingresados");
            } else {
                Util.addErrorMessage("Datos no Ingresados");
            }*/

            //cargarGrupoFamiliar();
            //objGrupoFamiliar = new CGrupoFamiliar();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }

    }

    public void prueba() {
        try {
            RequestContext.getCurrentInstance().execute("PF('wgEditarAcademico').hide()");
            Util.addSuccessMessage("Succesfull", "Datos Ingresados");
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }

    }

    public CReservation getReserva() {
        return reserva;
    }

    public void setReserva(CReservation reserva) {
        this.reserva = reserva;
    }

    public Ccompra getObjcompra() {
        return objcompra;
    }

    public void setObjcompra(Ccompra objcompra) {
        this.objcompra = objcompra;
    }

    public Integer getNumeropaquete() {
        return numeropaquete;
    }

    public void setNumeropaquete(Integer numeropaquete) {
        this.numeropaquete = numeropaquete;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Cpassenger> getLstPasajeros() {
        return lstPasajeros;
    }

    public void setLstPasajeros(List<Cpassenger> lstPasajeros) {
        this.lstPasajeros = lstPasajeros;
    }

    public Cpassenger getObjpasajero() {
        return objpasajero;
    }

    public void setObjpasajero(Cpassenger objpasajero) {
        this.objpasajero = objpasajero;
    }

    public Ccomprador getObjcomprador() {
        return objcomprador;
    }

    public void setObjcomprador(Ccomprador objcomprador) {
        this.objcomprador = objcomprador;
    }

    public PagoControlador getPago() {
        return pago;
    }

    public void setPago(PagoControlador pago) {
        this.pago = pago;
    }

}
