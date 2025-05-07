/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Instituciones;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;
import proyecto_gm.Facultades.DatosFacultades;
import proyecto_gm.Facultades.Facultades;

/**
 *
 * @author Emerson
 */
public class DatosInstituciones {

    static Connection conn = ConexionBD.getConnection();

    public void mostrarDatosInstituciones(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
        try {
            PreparedStatement stmt = conn.prepareStatement("CALL listar_instituciones()");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("codigoInstituciones"),
                    rs.getString("Ruc"),
                    rs.getString("RazonSocial"),
                    rs.getString("Direccion"),
                    rs.getString("Sede")};
                modelo.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void insertarDatos(Instituciones institucion, JTable tabla) {
        try {
            // Verificar si el campo ID está vacío
            if (institucion.getId().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un Id", "Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            }

            
            String idTexto = institucion.getId();
            int idInstitucion = Integer.parseInt(idTexto.substring(3)); 
                 
            // Llamar al procedimiento almacenado para insertar
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_instituciones(?, ?, ?, ?, ?) }");
            cstmt.setInt(1, idInstitucion);
            cstmt.setString(2, institucion.getRuc());
            cstmt.setString(3, institucion.getRazonSocial());
            cstmt.setString(4, institucion.getDireccion());
            cstmt.setString(5, institucion.getSede());
            cstmt.execute();
            cstmt.close();

            // Llamar al procedimiento almacenado para obtener la institución
            CallableStatement cstmt2 = conn.prepareCall("{ CALL obtener_institucion(?) }");
            cstmt2.setInt(1, idInstitucion);
            ResultSet rs = cstmt2.executeQuery();

            if (rs.next()) {
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                Object[] rowData = {
                    rs.getString("codigoInstituciones"),
                    rs.getString("Ruc"),
                    rs.getString("RazonSocial"),
                    rs.getString("Direccion"),
                    rs.getString("Sede")
                };
                modelo.addRow(rowData);
                tabla.setModel(modelo);
            }

            rs.close();
            cstmt2.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El ID debe tener el formato correcto (por ejemplo: INS00001)", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminarDatos(JTable tabla) {
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            String id = tabla.getModel().getValueAt(fila, 0).toString(); // Se asume que el ID está en la primera columna
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere eliminar la fila seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try ( CallableStatement stmt = conn.prepareCall("{ CALL eliminar_instituciones(?) }")) {
                    stmt.setString(1, id); // Se usa setString porque el ID es VARCHAR
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

    public static void guardarCambios(Instituciones institucion, JTable tabla) {
        try {
            // Llamada al procedimiento sin parámetros
            CallableStatement cstmt = conn.prepareCall("{ CALL listar_instituciones() }"); // Sin parámetros
            ResultSet rs = cstmt.executeQuery();

            // Verificar si el resultado tiene filas, lo que indica que el registro ya existe
            if (rs.next()) {
                // Si el registro existe, hacer una actualización
                DatosInstituciones.actualizarDatos(institucion, tabla);
            } else {
                // Si el registro no existe, hacer una inserción
                DatosInstituciones.insertarDatos(institucion, tabla);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void actualizarDatos(Instituciones institucion, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_instituciones(?, ?, ?, ?, ?) }");
            cstmt.setString(1, institucion.getId());
            cstmt.setString(2, institucion.getRuc());
            cstmt.setString(3, institucion.getRazonSocial());
            cstmt.setString(4, institucion.getDireccion());
            cstmt.setString(5, institucion.getSede());
            cstmt.execute(); // Ejecuta la actualización en la base de datos

            // Limpiar y actualizar la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0); // Limpiar la tabla

            PreparedStatement stmt = conn.prepareStatement("CALL listar_instituciones()"); // Recargar datos
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("codigoInstituciones"),
                    rs.getString("Ruc"),
                    rs.getString("RazonSocial"),
                    rs.getString("Direccion"),
                    rs.getString("Sede")
                };
                modelo.addRow(row);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String GenerarCodigo() {
        String codigoGenerado = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?, ?) }")) {
            cstmt.setString(1, "institucioneseducativas");   // Tabla
            cstmt.setString(2, "IdInstitucionEducativa");    // Campo numérico
            cstmt.setString(3, "");
            cstmt.registerOutParameter(4, Types.VARCHAR);    // ID generado como texto
            cstmt.execute();

            String idGenerado = cstmt.getString(4);

            int id = Integer.parseInt(idGenerado);
            codigoGenerado = String.format("INS%06d", id);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return codigoGenerado;
    }

    public static boolean validarNumeros(String datos) {
        return datos.matches("[0-9]*");
    }

}
