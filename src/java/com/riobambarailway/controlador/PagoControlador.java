/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.controlador;

import com.riobambarailway.entidades.CPaquete;
import com.riobambarailway.entidades.Ccompra;
import com.riobambarailway.entidades.Ccomprador;
import com.riobambarailway.entidades.Cpassenger;
import com.riobambarailway.modelo.MCompra;
import com.riobambarailway.modelo.MPaquete;
import com.riobambarailway.modelo.Mcomprador;
import com.riobambarailway.modelo.Mpassenger;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.SelectEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import org.primefaces.context.DefaultRequestContext;

import recursos.Util;

@ManagedBean
@FlowScoped("FlowCompra")
public class PagoControlador implements Serializable {

    private List<Cpassenger> lstPasajeros;
    private Cpassenger objpasajero;
    private Cpassenger selObjPasajero;
    private Ccompra objcompra;
    private Ccomprador objcomprador;
    private Date date1;
    private CPaquete objpaquete;
    private Date date3;
    private Integer numeropaquete;
    private double total;
    private int cantidad;

    public PagoControlador() {
        this.objcompra = new Ccompra();
        this.objcomprador = new Ccomprador();
        this.objpasajero = new Cpassenger();
        this.selObjPasajero = new Cpassenger();

    }

    public String getHomeAction() {
        return "/index";
    }

    @PostConstruct
    public void reinit() {
        obtPaquete();
    }

    public void obtPaquete() {
        try {
            //FacesContext facesContext = FacesContext.getCurrentInstance();
            //Map params = facesContext.getExternalContext().getRequestParameterMap();
            //numeropaquete = new Integer((String) params.get("numeropaquete"));
            objpaquete = MPaquete.obtPaquete(numeropaquete);
            total = objcompra.getCantidad() * objpaquete.getCosto();

        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    public void prueba() throws Exception {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("pasajeros.xhtml?numeropaquete=" + numeropaquete + "&cantidad=" + cantidad + "&fecha=" + date1);
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void seleccionarPaquete(int numero) {
        try {
            numeropaquete = numero;
            obtenerPaquete();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    public void obtenerPaquete() {
        try {
            objpaquete = MPaquete.obtPaquete(numeropaquete);
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    public void crearPasajeros() {
        lstPasajeros = new ArrayList<Cpassenger>();
        try {
            if (cantidad != 0) {
                for (int i = 1; i <= cantidad; i++) {
                    lstPasajeros.add(new Cpassenger(i));
                }
            }
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    public void insertarPago() throws IOException {

        try {
            numeropaquete = 1;
            obtPaquete();
            objcompra.setIdPack(numeropaquete);
            int id_comprador = Mcomprador.insertarComprador(objcomprador);
            if (id_comprador != 0) {
                objcomprador.setIdComprador(id_comprador);
                objcompra.setPrecioUnitario(objpaquete.getCosto());
                objcompra.setPrecioTotal(objpaquete.getCosto() * cantidad);
                objcompra.setIdComprador(objcomprador);
                MCompra.insertarCompra(objcompra);
            }
            Mpassenger.insertarPassenger(objpasajero);
            /*objPersona.setObjSexo(Msexo.obtSexo(idSexo));
             String nombre = objPersona.getNombre();
             String apellido = objPersona.getApellido();
             usuario = String.valueOf(nombre.charAt(0) + "" + nombre.charAt(1) + "" + apellido.charAt(0) + "" + apellido.charAt(1));
             if (MPersona.insertarPersona(objPersona) && MPersona.insertarComentario(objComentario, objPersona) && MPersona.insertarCuenta(usuario, objPersona)) {
             //DefaultRequestContext.getCurrentInstance().execute("dlgPersonaInsertar.hide()");
             //Mensajes de confirmacion de la cuenta

             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Su cuenta se ha creado satisfactoriamente", "Su cuenta se a creado con el usuario =>   " + usuario + "y con la comstraseña tedx123");
             RequestContext.getCurrentInstance().showMessageInDialog(message);

             //Util.addSuccessMessage("Datos Insertados");
             //cargarFacultad();
             } else {
             Util.mostrarMensaje("Datos no insertados Insertados");
             }

             objPersona = null;*/
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }

    }

    public void insertarPasajero() {
        try {
            if (lstPasajeros != null) {
                if (lstPasajeros.add(objpasajero)) {
                    DefaultRequestContext.getCurrentInstance().execute("$('#dialogCreatePasajero').modal('hide')");
                    objpasajero = null;
                    objpasajero = new Cpassenger();
                } else {
                }
            } else {
                this.lstPasajeros = new ArrayList<Cpassenger>();
                if (lstPasajeros.add(objpasajero)) {
                    DefaultRequestContext.getCurrentInstance().execute("$('#dialogCreatePasajero').modal('hide')");
                    objpasajero = null;
                    objpasajero = new Cpassenger();
                }

            }
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Funciones -Setter and Getter-">
    public Cpassenger getObjpasajero() {
        return objpasajero;
    }

    public void setObjpasajero(Cpassenger objpasajero) {
        this.objpasajero = objpasajero;
    }

    public Ccompra getObjcompra() {
        return objcompra;
    }

    public void setObjcompra(Ccompra objcompra) {
        this.objcompra = objcompra;
    }

    public Ccomprador getObjcomprador() {
        return objcomprador;
    }

    public void setObjcomprador(Ccomprador objcomprador) {
        this.objcomprador = objcomprador;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public CPaquete getObjpaquete() {
        return objpaquete;
    }

    public void setObjpaquete(CPaquete objpaquete) {
        this.objpaquete = objpaquete;
    }

    public Integer getNumeropaquete() {
        return numeropaquete;
    }

    public void setNumeropaquete(Integer numeropaquete) {
        this.numeropaquete = numeropaquete;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public Cpassenger getSelObjPasajero() {
        return selObjPasajero;
    }

    public void setSelObjPasajero(Cpassenger selObjPasajero) {
        this.selObjPasajero = selObjPasajero;
    }
//</editor-fold>

}
