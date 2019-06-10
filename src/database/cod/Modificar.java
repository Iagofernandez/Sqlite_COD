
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
public class Modificar {
     public void update(int id, String nombre, String apellido) {
        /*
        Metood que nos permite modificar datos de una tabla
        @param id nombre apellido
        return uTable
         */
        boolean uTable = false;
        String sql = "UPDATE ALUMNO SET nombre = ? , "
                + "apellido = ?  "
                + "WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, nombre);

            pstmt.setString(2, apellido);

            pstmt.setInt(3, id);

            // update 
            pstmt.executeUpdate();
            uTable = true;
            JOptionPane.showMessageDialog(null, "Datos de la tabla modificados con exito");
        } catch (SQLException e) {
            uTable = false;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "El id no existe o es un valor no aceptado(String, etc)");

        }

    }

    public boolean update2(String dni, String nombre, String telefono) {
        /*
        Metood que nos permite modificar datos de una tabla
        @param dni, nombre, telefono
        return uTable2
         */
        boolean uTable2 = false;
        String sql = "UPDATE ESCUELA SET nombre = ? , "
                + "telefono = ? "
                + "WHERE dni = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, nombre);

            pstmt.setString(2, telefono);

            pstmt.setString(3, dni);

            // update 
            pstmt.executeUpdate();
            uTable2 = true;
        } catch (SQLException e) {
            uTable2 = false;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "El id no existe o es incorrecto su formato, debe ser un numero");

        }
        return uTable2;
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
