package proyecto_gm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String USERNAME = "avnadmin";
    private static final String PASSWORD = "cambiarclave";
    private static final String CONN_STRING = "jdbc:mysql://mysql-a21bb78-sistemasnet26-321c.k.aivencloud.com:10658/gmingenieros?useSSL=true&requireSSL=true";

    private ConexionBD() {
        // Evitar instanciación 
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error en la conexión: " + e.getMessage());
            return null;
        }
    }
}
