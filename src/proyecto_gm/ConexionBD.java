package proyecto_gm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

   private static final String USERNAME = "avnadmin";
    private static final String PASSWORD = "AVNS_5be8o3RIpMZgj26OakP";
    private static final String CONN_STRING = "jdbc:mysql://mysql-a21bb78-sistemasnet26-321c.k.aivencloud.com:10658/gmingenieros?useSSL=true&requireSSL=true";
   
    public static String codPerfil = "";
    public static String nomPerfil = "";
    public static String nomUsuario = "";
    //conexion a base de datoa Reloj de actividad GMADMINISTRACIOn MYSQL
    private static final String connReloj = "jdbc:mysql://mysql-a21bb78-sistemasnet26-321c.k.aivencloud.com:10658/gmadministracion?useSSL=true&requireSSL=true";
    
    public ConexionBD() {
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
    
    public static Connection getConnectionAsistencia(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(connReloj, USERNAME,PASSWORD);
            
        }catch(ClassNotFoundException | SQLException ex){
            System.err.println("Error en la conexión: " + ex.getMessage());
            return null;
        }
    } 
}
