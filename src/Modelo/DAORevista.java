/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Juana Isabel Diaz Castillo
 */
public class DAORevista {

    public Revista Insertar(String titulo, int ayo, String issn, float precio, java.sql.Time Horaventa) {

        String transaccion = "Insert into Revista values('"
                + titulo + "','"
                + ayo + "','"
                + issn + "','"
                + precio + "','"
                + Horaventa + "')";

        if (new DataBase().Actualizar(transaccion) > 0) {
            return new Revista(titulo, ayo, issn, precio, Horaventa);
        }
        return null;
    }

    public int Actualizar(int numero, String titulo, int ayo, String issn, float precio, java.sql.Time Horaventa) {

        String transaccion = "Update Revista set titulo='"
                + titulo + "',ayo='"
                + ayo + "',issn='"
                + issn + "',precio='"
                + precio + "',Horaventa='"
                + Horaventa + "' Where numero="
                + numero;

        return new DataBase().Actualizar(transaccion);
    }

    public List ObtenerDatos() {

        String transaccion = "Select * From Revista";

        List<Map> registros = new DataBase().Listar(transaccion);
        List<Revista> revista = new ArrayList();

        for (Map registro : registros) {

            Revista rs = new Revista((int) registro.get("numero"),
                    (String) registro.get("titulo"),
                    (int) registro.get("ayo"),
                    (String) registro.get("issn"),
                    (Float.parseFloat( registro.get("precio").toString())),
                    (java.sql.Time.valueOf( registro.get("Horaventa").toString())));
            revista.add(rs);
        }
        return revista;
    }

    public int Eliminar(int numero) {

        String trassaccion = "Delete From Revista Where numero='" + numero + "'";
        return new DataBase().Actualizar(trassaccion);

    }

}
