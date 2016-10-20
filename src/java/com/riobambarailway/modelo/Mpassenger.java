/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.modelo;

import com.riobambarailway.accesodatos.AccesoDatos;
import com.riobambarailway.accesodatos.ConjuntoResultado;
import com.riobambarailway.accesodatos.Parametro;
import com.riobambarailway.entidades.Ccomprador;
import com.riobambarailway.entidades.Cpassenger;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class Mpassenger {
    
    public static boolean insertarPassenger(Cpassenger passenger) throws Exception {
        boolean respuesta = false;

        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "SELECT * from public.fn_insert_tpasajero(?,?,?,?,?)";
            lstP.add(new Parametro(1, passenger.getNombrePas()));
            lstP.add(new Parametro(2, passenger.getApellidoPas()));
            lstP.add(new Parametro(5, passenger.getPaisPas()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            
            while (rs.next()) {
                if (rs.getBoolean(0) == true) {
                    respuesta = true;
                }
            }
            rs = null;
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        return respuesta;

    }
}
