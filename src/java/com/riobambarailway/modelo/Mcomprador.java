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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class Mcomprador {

    public static int insertarComprador(Ccomprador comprador) throws Exception {
        int respuesta=0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            /*String sql = "INSERT INTO `bdrailway`.`comprador`\n"
                    + "(`comprador_nombre`,`comprador_apellido`,`comprador_correo`,\n"
                    + "`comprador_celular`,`comprador_telefono`,`comprador_telefono_trabajo`)\n"
                    + "VALUES (?,?,?,?,?,?);";*/
            String sql = "CALL `bdrailway`.`fn_insert_comprador`(?,?,?,?,?,?);";
            
            lstP.add(new Parametro(1, comprador.getNombreComprador()));
            lstP.add(new Parametro(2, comprador.getApellidoComprador()));
            lstP.add(new Parametro(3, comprador.getCorreoComprador()));
            lstP.add(new Parametro(4, comprador.getCelularComprador()));
            lstP.add(new Parametro(5, comprador.getTelefonoComprador()));
            lstP.add(new Parametro(6, comprador.getTelTrabajoComprador()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);

            while (rs.next()) {
                respuesta = rs.getInt(0);
            }
            rs = null;
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        return respuesta;

    }
}
