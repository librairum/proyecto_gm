package proyecto_gm.CajaChica;

import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosCajaChica {

    static Connection conn = ConexionBD.getConnection();

    public static void LimpiarCampos(JTextField[] camposTexto, JComboBox[] combos) {
    for (JTextField campo : camposTexto) {
        campo.setText("");
    }

    for (JComboBox combo : combos) {
        combo.setSelectedIndex(0); // o -1 si quieres dejarlo sin selección
    }
}

    // Mostrar datos
    public static void Mostrar(DefaultTableModel modelo) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("CALL listar_cajachica()");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("Id"),
                    rs.getString("NroOperacion"),
                    rs.getString("Fecha"),
                    rs.getString("Descripcion"),
                    rs.getString("Entrada"),
                    rs.getString("Salida"),
                    rs.getString("Saldo")
                };
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String ObtenerSiguienteIdCajaChica() {
        String siguienteId = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_siguiente_id_cajachica() }")) {
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                siguienteId = rs.getString("SiguienteId");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al obtener el siguiente ID", JOptionPane.ERROR_MESSAGE);
        }
        return siguienteId;
    }

    /*
    public static void NuevaFila(JTable tabla) {
        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        // Agregar una nueva fila vacía al modelo de la tabla
        modelo.addRow(new Object[]{});
        // Obtener el número de fila de la última fila agregada
        int fila = modelo.getRowCount() - 1;
        // Habilitar la edición de la nueva fila
        tabla.editCellAt(fila, 0);

    }
     */
//    public static String GenerarCodigo(String tabla, String prefijo, int longitud) {
//        CallableStatement cstmt = null;
//        String codigo_generado = "";
//        try {
//            cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?, ?, ?) }");
//            cstmt.setString(1, tabla);
//            cstmt.setString(2, prefijo);
//            cstmt.setInt(3, longitud);
//            cstmt.registerOutParameter(4, Types.VARCHAR);
//
//            cstmt.execute();
//
//            codigo_generado = cstmt.getString(5);
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            if (cstmt != null) {
//                try {
//                    cstmt.close();
//                } catch (SQLException e) {
//                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        }
//        return codigo_generado;
//        
//    }
   public static void Habilitar(Container contenedor, boolean bloquear) {
    Component[] components = contenedor.getComponents();
    for (Component component : components) {
        if (component instanceof JButton) {
            String button = ((JButton) component).getName();
            if (button != null) {
                if (button.equals("deshacer")) {
                    ((JButton) component).setEnabled(bloquear);
                } else if (button.equals("agregar") || button.equals("editar") || button.equals("eliminar")) {
                    ((JButton) component).setEnabled(!bloquear); // lógica inversa
                }
            }
        }
    }
}


    public static void Insertar(CajaChica caj, JTable tabla, String periodo) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_cajachica(?,?, ?, ?, ?, ?, ?) }");

            cstmt.setString(1, caj.getId());
            cstmt.setString(2, caj.getIdTransferenciasBancarias());
            cstmt.setString(3, caj.getFecha());
            cstmt.setString(4, caj.getDescripcion());
            cstmt.setFloat(5, caj.getEntrada());
            cstmt.setFloat(6, caj.getSalida());
            cstmt.setFloat(7, caj.getSaldo());

            cstmt.execute(); // Se inserta los datos a la BD

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "¡Registro guardado correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Actualizamos la tabla sin borrar las filas existentes
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            Object[] fila = {
                caj.getId(),
                caj.getIdTransferenciasBancarias(),
                caj.getFecha(),
                caj.getDescripcion(),
                caj.getEntrada(),
                caj.getSalida(),
                caj.getSaldo()
            };
            modelo.addRow(fila);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Actualizar(CajaChica caj, JTable tabla, String periodo) {
        try {
            CallableStatement cstmt = conn.prepareCall("{CALL actualizar_cajachica(?, ?, ?, ?, ?, ?, ?) }");

            cstmt.setString(1, caj.getId());
            cstmt.setString(2, caj.getIdTransferenciasBancarias());
            cstmt.setString(3, caj.getFecha());
            cstmt.setString(4, caj.getDescripcion());
            cstmt.setFloat(5, caj.getEntrada());
            cstmt.setFloat(6, caj.getSalida());
            cstmt.setFloat(7, caj.getSaldo());

            cstmt.execute();

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            
            //DatosCajaChica.Mostrar(modelo, periodo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
    public static boolean validarCamposCompletados(JTable table) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        int rowCount = modelo.getRowCount();
        int columnCount = modelo.getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                Object value = modelo.getValueAt(row, column);

                if (value == null || value.toString().isEmpty()) {
                    System.out.println("La celda en la fila " + (row + 1) + ", columna " + (column + 1) + " no está completada");
                    return false;
                }
            }
        }

        // Si todas las celdas están completadas, devuelve true
        return true;
    }
     */
    public static void Eliminar(JTable tabla) {
        try {
            // Obtener el indice de la fila seleccionada
            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                String[] options = {"Sí", "No", "Cancelar"};
                int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que quiere eliminar la fila seleccionada?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                if (opcion == JOptionPane.YES_OPTION) {
                    // Obtener los datos de fila seleccionada
                    String id = tabla.getModel().getValueAt(fila, 0).toString(); //Se asume que el ID se encuentra en la primera columna

                    // Ejecutar el procedimiento almacenado
                    java.sql.CallableStatement stmt = conn.prepareCall("{ CALL eliminar_cajachica(?) }");
                    stmt.setString(1, id);
                    stmt.execute();

                    // Actualizar el JTable
                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.removeRow(fila);
                    // JOptionPane.showMessageDialog(null, "La fila ha sido eliminada exitosamente");                
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void CargarCombo(JComboBox<String> cboNroOperacion) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_operacion() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                cboNroOperacion.addItem(rs.getString("NroOperacion"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String CapturarIdOperacion(JComboBox<String> cboNroOperacion) {
        String idCategoria = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_id_Operacion(?) }")) {
            cstmt.setString(1, cboNroOperacion.getSelectedItem().toString());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                idCategoria = rs.getString("IdTransferenciaBancaria");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Categoría", JOptionPane.ERROR_MESSAGE);
        }
        return idCategoria;
    }

    /*
    public static String CapturarID(String transferencia) {
        String idTransferenciasBancarias = "";
        try {
            // CapturarID las opciones seleccionadas en los combo boxes

            // Obtener los id de modulo
            String consulta = "SELECT Id AS IdTransferenciasBancarias "
                    + "FROM transferenciasbancarias "
                    + "WHERE NroOperacion = ? ";
            PreparedStatement pstmt = conn.prepareStatement(consulta);
            pstmt.setString(1, transferencia);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                idTransferenciasBancarias = rs.getString("IdTransferenciasBancarias");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Opciones", JOptionPane.ERROR_MESSAGE);
        }

        return idTransferenciasBancarias;
    }*/
 /*
    public static void Fecha(JTable tabla, JComboBox combo) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String nroOperacion = combo.getSelectedItem().toString();
            System.out.println("nroOperacion = " + nroOperacion);
            try {
                PreparedStatement pstmt = conn.prepareStatement("SELECT DATE_FORMAT(Fecha, '%d/%m/%Y') AS Fecha FROM transferenciasbancarias WHERE NroOperacion = ? ");
                pstmt.setString(1, nroOperacion);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String fecha = rs.getString("Fecha");
                    tabla.getModel().setValueAt(fecha, fila, 2);
                }
                rs.close();
                pstmt.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
     */
}
