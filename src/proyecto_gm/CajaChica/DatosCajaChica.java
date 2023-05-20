package proyecto_gm.CajaChica;

import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosCajaChica {

    static Connection conn = ConexionBD.getConnection();

    public static void Limpiar(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        if (rowCount > 0) {
            model.removeRow(rowCount - 1); // Remueve la última fila del modelo de datos
        }
    }

    // Mostrar datos
    public static void Mostrar(DefaultTableModel modelo) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("CALL listar_cajachica()");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString("Id"), rs.getString("NroOperacion"),
                    rs.getString("Fecha"),
                    rs.getString("Descripcion"), rs.getString("Entrada"), rs.getString("Salida"),
                    rs.getString("Saldo")};
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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

    public static void Habilitar(Container contenedor, boolean bloquear) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JButton jButton) {
                String button = jButton.getName();
                if (button.equals("deshacer")) {
                    jButton.setEnabled(bloquear);
                } else if (button.equals("agregar") || button.equals("editar") || button.equals("eliminar")) {
                    jButton.setEnabled(!bloquear); // aplicar logica inversa
                }
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    public static void Insertar(CajaChica caj, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_cajachica(?,?, ?, ?, ?, ?, ?) }");

            cstmt.setString(1, caj.getId());
            cstmt.setString(2, caj.getIdTransferenciasBancarias());
            cstmt.setString(3, caj.getFecha());
            cstmt.setString(4, caj.getDescripcion());
            cstmt.setFloat(5, caj.getEntrada());
            cstmt.setFloat(6, caj.getSalida());
            cstmt.setFloat(7, caj.getSaldo());

            cstmt.execute(); // se inserta los datos a la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosCajaChica.Mostrar(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Actualizar(CajaChica caj, JTable tabla) {
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

            DatosCajaChica.Mostrar(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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

    public static void CargarCombo(JComboBox cbotransferencias) {
        try {
            // Preparamos la consultas
            PreparedStatement pstmttransferencias = conn.prepareStatement("SELECT NroOperacion FROM transferenciasbancarias");

            // Las ejecutamos
            ResultSet proveedores = pstmttransferencias.executeQuery();

            // Agregamos los provedores
            while (proveedores.next()) {
                String nomtransferencias = proveedores.getString("NroOperacion");
                cbotransferencias.addItem(nomtransferencias);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

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
    }

    public static void Fecha(JTable tabla) {
        // Obtener la fila seleccionada
        int fila = tabla.getSelectedRow();
        String nroOperacion = tabla.getModel().getValueAt(fila, 1).toString();
        try {
            // Preparamos la consulta
            PreparedStatement pstmt = conn.prepareStatement("SELECT Fecha FROM transferenciasbancarias WHERE NroOperacion = ? ");
            pstmt.setString(1, nroOperacion);
            // Ejecutamos la consulta
            ResultSet rs = pstmt.executeQuery(); // oh, i'm cumming

            // Creamos el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

            // Limpiamos los datos existentes en la tabla
            modelo.setRowCount(0);

            // Agregamos las fechas a la tabla
            while (rs.next()) {
                String fecha = rs.getString("Fecha");

                modelo.setValueAt(fecha, fila, 2);
            }

            // Cerramos recursos
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
