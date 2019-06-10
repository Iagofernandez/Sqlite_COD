/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.cod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author X541
 */
public class ClavesPrimarias {
     public String getCif(String id) {
        /*
        Metodo para obtener el dni de un id especifico
        @param id
        return dato
         */
        String sql = "SELECT dni FROM ALUMNO where id =" + id;

        String dato = "";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            dato = rs.getString("dni");

        } catch (SQLException ex) {

            Logger.getLogger(ClavesPrimarias.class.getName()).log(Level.SEVERE, null, ex);

        }

        return dato;

    }

    public int getId() {
        /*
        Metodo que nos permite recoger el id de los alumnos
        @param rowId
        return rowId
         */

        String sql = "SELECT max(id) from ALUMNO";

        int rowID = 0;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            rowID = rs.getInt("max(id)");

        } catch (SQLException ex) {

            Logger.getLogger(ClavesPrimarias.class.getName()).log(Level.SEVERE, null, ex);

        }

        return rowID;

    }
    Connection connect() {
        /*
        Metodo que genera la conexion del programa a nuestra base de datos
        @param conn de tipo Connection
        return conn
         */

        // url = ruta de nuestra base de datos
        String url = "jdbc:sqlite:C:\\Users\\X541\\Documents\\NetBeansProjects\\Database\\testeo.db";

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(url);

            System.out.println("Conexión establecida.");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return conn;

    }
}
