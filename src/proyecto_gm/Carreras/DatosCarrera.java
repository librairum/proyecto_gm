package proyecto_gm.Carreras;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;
import proyecto_gm.Facultades.DatosFacultades;
import proyecto_gm.Facultades.Facultades;

public class DatosCarrera {

    static Connection conn = ConexionBD.getConnection();

    public static void mostrarDatosCarreras(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

        try {
            PreparedStatement stmt = conn.prepareStatement("CALL listar_carreras()");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("codigoCarrera"),
                    rs.getString("descripcion")
                };
                modelo.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String GenerarCodigoCarrera() {
        String codigoGenerado = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?, ?) }")) {
            cstmt.setString(1, "carreras");         
            cstmt.setString(2, "IdCarrera");         
            cstmt.setString(3, "");                   
            cstmt.registerOutParameter(4, Types.VARCHAR);
            cstmt.execute();

            String idGenerado = cstmt.getString(4);     
            int id = Integer.parseInt(idGenerado);
            codigoGenerado = String.format("CAR%06d", id);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return codigoGenerado;
    }

    public static void insertarDatos(Carreras carrera, JTable tabla) {
        try {
            if (carrera.getId().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un Id", "Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Extraer solo el número del ID (por ejemplo, de "CAR00001" obtener "1")
            String idNumericoStr = carrera.getId().replaceAll("[^0-9]", ""); // Elimina todo menos los dígitos
            int idCarrera = Integer.parseInt(idNumericoStr);

            // Preparar la llamada al procedimiento almacenado para insertar la carrera
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_carreras(?, ?) }");
            cstmt.setInt(1, idCarrera);
            cstmt.setString(2, carrera.getDescripcion());
            cstmt.execute();
            cstmt.close();

            // Recuperar datos insertados
            CallableStatement cstmt2 = conn.prepareCall("{ CALL obtener_carrera(?) }");
            cstmt2.setInt(1, idCarrera);
            ResultSet rs = cstmt2.executeQuery();

            if (rs.next()) {
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                Object[] rowData = {
                    rs.getString("codigoCarrera"),
                    rs.getString("descripcion")
                };
                modelo.addRow(rowData);
                tabla.setModel(modelo);
            }

            rs.close();
            cstmt2.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminarDatos(JTable tabla) {
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            String id = tabla.getModel().getValueAt(fila, 0).toString(); // Se asume que el ID está en la primera columna
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere eliminar la fila seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try ( CallableStatement stmt = conn.prepareCall("{ CALL eliminar_carreras(?) }")) {
                    stmt.setString(1, id);
                    stmt.execute();

                    // Eliminar la fila de la tabla
                    ((DefaultTableModel) tabla.getModel()).removeRow(fila);
                    JOptionPane.showMessageDialog(null, "La fila ha sido eliminada exitosamente.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.");
        }
    }

    public static void actualizarDatos(Carreras carrera, JTable tabla) {
        try {
            // Confirmación antes de actualizar
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere actualizar la fila seleccionada?", "Confirmar actualización", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // Ejecutar el procedimiento almacenado
                try ( CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_carreras(?, ?) }")) {
                    cstmt.setString(1, carrera.getId());
                    cstmt.setString(2, carrera.getDescripcion());
                    cstmt.execute();
                }

                // Mensaje de éxito
                JOptionPane.showMessageDialog(null, "La carrera ha sido actualizada exitosamente.");

                // Actualizamos la tabla
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0);

                try ( PreparedStatement stmt = conn.prepareStatement("CALL listar_carreras()");  ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Object[] row = new Object[]{rs.getString("codigoCarrera"), rs.getString("Descripcion")};
                        modelo.addRow(row);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void editar(JTable tabla, JTextField[] cajas) {
        // Obtener el indice de la fila seleccionada
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            for (int i = 0; i < cajas.length; i++) {
                String dato = tabla.getModel().getValueAt(fila, i).toString();
                cajas[i].setText(dato);
            }

            cajas[0].setEditable(false);
            cajas[1].requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
        }

    }

}
