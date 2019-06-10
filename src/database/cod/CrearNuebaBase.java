
package database.cod;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author X541
 */
public class CrearNuebaBase {
     public static boolean createNewDatabase(String fileName) {
        /*
        Metodo que genera una nueva base de datos
        @param fileName de tipo  STring
        return db
         */
        boolean db = false;
        String url = "jdbc:sqlite:C:\\Users\\X541\\Documents\\NetBeansProjects\\Database\\" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {

            if (conn != null) {

                DatabaseMetaData meta = conn.getMetaData();

                System.out.println("Driver " + meta.getDriverName());
                db = true;
                System.out.println("Base de datos creada.");

            }

        } catch (SQLException e) {
            db = false;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Fallo a la hora de crear la base de datos");

        }
        return db;
    }
}
