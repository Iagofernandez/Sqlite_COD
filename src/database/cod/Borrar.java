/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.cod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author X541
 */
public class Borrar {
     public boolean delete(int id) {
        /*
        Metodo que nos permite eleiminar datos de una tabla
        @param id
        return dTable
         */
        boolean dTable = false;
        String sql = "DELETE FROM ALUMNO WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);

            // execute the delete statement
            pstmt.executeUpdate();
            dTable = true;
            JOptionPane.showMessageDialog(null, "Datos de id " + id + " Han sido eliminados");
        } catch (SQLException e) {
            dTable = false;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "El id no exste o no tiene el formato adecuado, debe ser un int");

        }
        return dTable;
    }

    public boolean delete2(String dni) {
        /*
        Metodo que permite eliminar datos de una tabla a traves de su clave primaria
        @param dni
        return dTable2
         */
        boolean dTable2 = false;

        String sql = "DELETE FROM ESCUELA WHERE dni = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, dni);

            // execute the delete statement
            pstmt.executeUpdate();
            dTable2 = true;
            JOptionPane.showMessageDialog(null, "El dni " + dni + " ha sido eliminado");
        } catch (SQLException e) {
            dTable2 = false;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "EL Dni no existe o su formato es incorrecto");

        }
        return dTable2;
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
