
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
public class Insertar {
    public boolean insert(String nombre, String apellido, String dni) {
        /*
        Metodo que permite insertar datos en una tabla
        @param nombre, apellido dni
        return iTable
         */
        boolean iTable = false;
        String sql = "INSERT INTO ALUMNO (nombre,apellido,dni) VALUES(?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);

            pstmt.setString(2, apellido);

            pstmt.setString(3, dni);

            pstmt.executeUpdate();
            iTable = true;
            JOptionPane.showMessageDialog(null, "Datos insertados en la tabla");
        } catch (SQLException e) {
            iTable = false;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Datos mal escritos, imposible insertar en tabla");
        }
        return iTable;
    }
    public boolean insert2(String dni, String nombre, String telefono) {
        /*
        Metodo que permite insertar datos en una tabla
        @param dni, nombre, telefono
        return iTable2
         */
        boolean iTable2 = false;
         // el id se genera autómaticamente
        String sql = "INSERT INTO ESCUELA(dni,nombre,telefono) VALUES(?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dni);

            pstmt.setString(2, nombre);

            pstmt.setString(3, telefono);

            pstmt.executeUpdate();
            iTable2 = true;
        } catch (SQLException e) {
            iTable2 = false;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Datos mal escritos o repetida la clave primaria");
        }
        return iTable2;
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

