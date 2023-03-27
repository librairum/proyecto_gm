package proyecto_gm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Datos de la conexión
    private static final String USERNAME = "root";
    private static final String PASSWORD = "#1nv1t36082";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/gming";

    private static Connection conn = null;

    private ConexionBD() {
        // Constructor privado para evitar que se cree una instancia de esta clase
    }

    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Carga el controlador de MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Crea la conexión a la base de datos
                conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                // Manejo de errores
                e.printStackTrace();
            }
        }
        return conn;
    }
}