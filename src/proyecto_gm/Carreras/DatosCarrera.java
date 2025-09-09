package proyecto_gm.Carreras;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_gm.ConexionBD;

public class DatosCarrera {

    static Connection conn = ConexionBD.getConnection();


    public static List<Carreras> listar() {
        List<Carreras> lista = new ArrayList<>();   
        Connection conn = ConexionBD.getConnection();
        
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_carreras() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Carreras carrera = new Carreras();
                carrera.setId(rs.getInt("IdCarrera"));
                carrera.setDescripcion(rs.getString("descripcion"));
                lista.add(carrera);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public static void insertar(Carreras carrera) {
        Connection conn = ConexionBD.getConnection();
        try (CallableStatement cstmt = conn.prepareCall("{ CALL insertar_carrera(?) }")) { 
            cstmt.setString(1, carrera.getDescripcion());
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Carrera registrada exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar carrera: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void actualizar(Carreras carrera) {
        Connection conn = ConexionBD.getConnection();
        
        try (CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_carrera(?, ?) }")) {
            cstmt.setInt(1, carrera.getId());
            cstmt.setString(2, carrera.getDescripcion());
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Carrera actualizada exitosamente.", "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar carrera: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminar(int id) {
        Connection conn = ConexionBD.getConnection();
        
        try (CallableStatement cstmt = conn.prepareCall("{ CALL eliminar_carrera(?) }")) {
            cstmt.setInt(1, id);
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Carrera eliminada exitosamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar carrera: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
}
