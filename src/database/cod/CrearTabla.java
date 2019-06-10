/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.cod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author X541
 */
public class CrearTabla {
     public static boolean createNewTable() {
        /*
        Metodo que permite crear tablas con sus datos
        @param 
        return cTable de tipo boolean
         */
        boolean cTable = false;
        // url = ruta de la base de datos
        String url = "jdbc:sqlite:C:\\Users\\X541\\Documents\\NetBeansProjects\\Database\\testeo.db";

        //SQL statement for creating a new table
        String sql2 = "CREATE TABLE IF NOT EXISTS ESCUELA (\n"
                + "	dni PRIMARY KEY, \n"
                + "	nombre text NOT NULL, \n"
                + "     telefono text \n"
                + " );";

        String sql = "CREATE TABLE IF NOT EXISTS ALUMNO (\n"
                + "	id integer PRIMARY KEY, \n"
                + "	nombre text NOT NULL, \n"
                + "	apellido text NOT NULL, \n"
                + "     dni text, \n"
                + "     FOREIGN KEY(dni) REFERENCES ESCUELA (dni) \n"
                + " );";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {

            // creamos la tabla cargando nuestra sentencia en la variable sql
            stmt.execute(sql2);

            stmt.execute(sql);
            cTable = true;
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            cTable = false;

        }
        return cTable;
    }
     
}
