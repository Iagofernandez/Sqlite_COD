package database.cod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author X541
 */
public class ListaDeDatos {

    public ArrayList<Object[]> tablas() {

        ArrayList<Object[]> tablas = new ArrayList<>();

        String sql = "SELECT id, nombre, apellido, dni FROM ALUMNO";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Object[] datos = new Object[4];

                datos[0] = Integer.toString(rs.getInt("id"));

                datos[1] = rs.getString("nombre");

                datos[2] = rs.getString("apellido");

                datos[3] = rs.getString("dni");

                tablas.add(datos);

            }

        } catch (SQLException ex) {

            Logger.getLogger(ListaDeDatos.class.getName()).log(Level.SEVERE, null, ex);

        }

        return tablas;

    }

    public ArrayList<Object[]> tablaA() {

        ArrayList<Object[]> tablaA = new ArrayList<>();

        String sql = "SELECT dni, nombre, telefono FROM ESCUELA";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Object[] datos = new Object[3];

                datos[0] = rs.getString("dni");

                datos[1] = rs.getString("nombre");

                datos[2] = rs.getString("telefono");

                tablaA.add(datos);

            }

        } catch (SQLException ex) {

            Logger.getLogger(ListaDeDatos.class.getName()).log(Level.SEVERE, null, ex);

        }

        return tablaA;

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
