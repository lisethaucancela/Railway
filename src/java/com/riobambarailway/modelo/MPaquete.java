/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.modelo;

import com.riobambarailway.accesodatos.AccesoDatos;
import com.riobambarailway.accesodatos.ConjuntoResultado;
import com.riobambarailway.accesodatos.Parametro;
import com.riobambarailway.entidades.CPaquete;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Liseth
 */
public class MPaquete {

    public static CPaquete obtPaquete(Integer codigo) throws Exception {
        CPaquete objPaquete = null;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            //String sql = "SELECT * from fn_select_paquete(?);";
            String sql = "SELECT * FROM bdrailway.pack where pack_id=?;";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                objPaquete = new CPaquete(rs.getInt(0),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4));
            }
        } catch (SQLException e) {
            throw e;
        }
        return objPaquete;
    }
}
