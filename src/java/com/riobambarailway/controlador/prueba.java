/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Liseth
 */
@ManagedBean
@RequestScoped
public class prueba {

    /**
     * Creates a new instance of prueba
     */
    @ManagedProperty("#{PagoControlador}")
    private PagoControlador pago;
    public prueba() {
        
    }
    
}
