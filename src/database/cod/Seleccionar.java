
package database.cod;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import database.cod.Conectarse.*;
import java.sql.DriverManager;

/**
 *
 * @author X541
 */
public class Seleccionar {
     public boolean selectAll() {
        /*
        Metodo que recorre la tabla y recoge los datos existentes
        @param sql
        return sTable
         */
        boolean sTable = false;
        String sql = "SELECT id, nombre, apellido, dni FROM ALUMNO";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // bucle para imprimir todos los datos de nuestra tabla
            while (rs.next()) {

                System.out.println(rs.getInt("id") + "\t"
                        + rs.getString("nombre") + "\t"
                        + rs.getString("apellido") + "\t"
                        + rs.getString("dni"));
                sTable = true;
                JOptionPane.showMessageDialog(null, rs);
            }

        } catch (SQLException e) {
            sTable = false;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Datos mal seleccionados");

        }
        return sTable;

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

