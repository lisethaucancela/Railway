/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riobambarailway.modelo;

import com.riobambarailway.accesodatos.AccesoDatos;
import com.riobambarailway.accesodatos.ConjuntoResultado;
import com.riobambarailway.accesodatos.Parametro;
import com.riobambarailway.entidades.Ccompra;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class MCompra {

    public static boolean insertarCompra(Ccompra compra) throws Exception {
        boolean respuesta = false;

        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "INSERT INTO `bdrailway`.`compra`\n"
                    + "`compra_id_paquete`,\n"
                    + "`compra_fecha`,\n"
                    + "`compra_cantidad`,\n"
                    + "`compra_precio_unitario`,\n"
                    + "`compra_precio_total`,\n"
                    + "`compra_comprador_id`)\n"
                    + "VALUES (?,?,?,?,?,?);";
            lstP.add(new Parametro(1, compra.getIdPack()));
            lstP.add(new Parametro(2, compra.getFecha()));
            lstP.add(new Parametro(3, compra.getCantidad()));
            lstP.add(new Parametro(4, compra.getPrecioUnitario()));
            lstP.add(new Parametro(5, compra.getPrecioTotal()));
            lstP.add(new Parametro(6, compra.getIdComprador()));
            Boolean rs = AccesoDatos.ejecutaComando(sql, lstP);
            if (rs == true) {
                respuesta = true;
            }

            rs = null;
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        return respuesta;

    }
}
