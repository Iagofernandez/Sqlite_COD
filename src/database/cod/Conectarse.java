/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.cod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author X541
 */
public class Conectarse {
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
