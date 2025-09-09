package proyecto_gm.Viaticos;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosViaticos {
    static Connection conn = ConexionBD.getConnection();

    public static void listar(DefaultTableModel modelo) {
        try (PreparedStatement pstmt = conn.prepareStatement("CALL listar_viaticos()");
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("Id"),
                    rs.getString("Descripcion"),
                    rs.getFloat("Pasaje"),
                    rs.getFloat("Menu"),
                    rs.getString("Empleado"),
                    rs.getString("Periodo")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean insertar(Viaticos v) {
        try (CallableStatement cstmt = conn.prepareCall("{CALL insertar_viaticos(?, ?, ?, ?, ?)}")) {
            cstmt.setString(1, v.getDescripcion());
            cstmt.setFloat(2, v.getPasaje());
            cstmt.setFloat(3, v.getMenu());
            cstmt.setString(4, v.getIdEmpleado());
            cstmt.setString(5, v.getIdPeriodo());
            cstmt.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean actualizar(Viaticos v) {
        try (CallableStatement cstmt = conn.prepareCall("{CALL actualizar_viaticos(?, ?, ?, ?, ?, ?)}")) {
            cstmt.setInt(1, v.getId());
            cstmt.setString(2, v.getDescripcion());
            cstmt.setFloat(3, v.getPasaje());
            cstmt.setFloat(4, v.getMenu());
            cstmt.setString(5, v.getIdEmpleado());
            cstmt.setString(6, v.getIdPeriodo());
            cstmt.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean eliminar(int id) {
        try (CallableStatement cstmt = conn.prepareCall("{CALL eliminar_viaticos(?)}")) {
            cstmt.setInt(1, id);
            cstmt.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
