package proyecto_gm.CajaChica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosCajaChica {

    static Connection conn = ConexionBD.getConnection();

    public static String GenerarCodigo() {
        String codigoGenerado = "";
        try (CallableStatement cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?) }")) {
            cstmt.setString(1, "cajachica");
            cstmt.setString(2, "IdCajaChica");
            cstmt.registerOutParameter(3, Types.INTEGER);
            cstmt.execute();
            int idGenerado = cstmt.getInt(3);
            codigoGenerado = String.valueOf(idGenerado);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al generar código", JOptionPane.ERROR_MESSAGE);
        }
        return codigoGenerado;
    }

    public static void Mostrar(DefaultTableModel modelo) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("CALL listar_cajachica()");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("Id"), rs.getString("NroOperacion"), rs.getString("Fecha"),
                    rs.getString("Descripcion"), rs.getFloat("Entrada"), rs.getFloat("Salida"),
                    rs.getFloat("Saldo")
                };
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al mostrar datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<CajaChica> listaidTransBanca() {
        List<CajaChica> lista = new ArrayList<>();
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_id_TransBanca }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                lista.add(new CajaChica(rs.getInt("IdTransferenciaBancaria")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar N° Transacción", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public static void Insertar(CajaChica caj) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_cajachica(?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setString(1, caj.getId());
            cstmt.setInt(2, caj.getIdTransferenciasBancarias());
            cstmt.setString(3, caj.getFecha());
            cstmt.setString(4, caj.getDescripcion());
            cstmt.setFloat(5, caj.getEntrada());
            cstmt.setFloat(6, caj.getSalida());
            cstmt.setFloat(7, caj.getSaldo());
            cstmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al insertar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Actualizar(CajaChica caj) {
        try {
            CallableStatement cstmt = conn.prepareCall("{CALL actualizar_cajachica(?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setString(1, caj.getId());
            cstmt.setInt(2, caj.getIdTransferenciasBancarias());
            cstmt.setString(3, caj.getFecha());
            cstmt.setString(4, caj.getDescripcion());
            cstmt.setFloat(5, caj.getEntrada());
            cstmt.setFloat(6, caj.getSalida());
            cstmt.setFloat(7, caj.getSaldo());
            cstmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al actualizar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Eliminar(String id) {
        try {
            CallableStatement stmt = conn.prepareCall("{ CALL eliminar_cajachica(?) }");
            stmt.setString(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al eliminar", JOptionPane.ERROR_MESSAGE);
        }
    }
}
