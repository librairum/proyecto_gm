package proyecto_gm.CajaChica;

import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.Area.Area;
import proyecto_gm.ConexionBD;

public class DatosCajaChica {

    static Connection conn = ConexionBD.getConnection();

      public static String GenerarCodigo() {
        String codigoGenerado = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?) }")) {
            cstmt.setString(1, "cajachica");
            cstmt.setString(2, "IdCajaChica");
            cstmt.registerOutParameter(3, Types.INTEGER);

            cstmt.execute();

            int idGenerado = cstmt.getInt(3); // Recibe directamente el número
            codigoGenerado = String.valueOf(idGenerado);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return codigoGenerado;
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
    
    // Cargar opciones para los combo boxes
    public static List<CajaChica> listaidTransBanca() {
        List<CajaChica> lista = new ArrayList<>();
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_id_TransBanca }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int IdTransferenciasBancarias = rs.getInt("IdTransferenciaBancaria");
                lista.add(new CajaChica(IdTransferenciasBancarias));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar IdTransferenciaBancaria", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public static String CapturarIdTransBanca(JComboBox<CajaChica> cbontransferencias) {
        String IdTransferenciaBancaria = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_id_TransBanca(?) }")) {
            cstmt.setString(1, cbontransferencias.getSelectedItem().toString());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                IdTransferenciaBancaria = rs.getString("IdTransferenciaBancaria");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar IdTransferenciaBancaria", JOptionPane.ERROR_MESSAGE);
        }
        return IdTransferenciaBancaria;
    }
    
    //luego borrar
    public static String CapturarIdOperacion(JComboBox<CajaChica> cbontransferencias) {
        String idCategoria = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_id_Operacion(?) }")) {
            cstmt.setString(1, cbontransferencias.getSelectedItem().toString());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                idCategoria = rs.getString("IdTransferenciaBancaria");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Categoría", JOptionPane.ERROR_MESSAGE);
        }
        return idCategoria;
    }

    public static void Insertar(CajaChica caj, JTable tabla, String periodo) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_cajachica(?,?, ?, ?, ?, ?, ?) }");

            cstmt.setString(1, caj.getId());
            cstmt.setInt(2, caj.getIdTransferenciasBancarias());
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
            cstmt.setInt(2, caj.getIdTransferenciasBancarias());
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
                    JOptionPane.showMessageDialog(null, "La fila ha sido eliminada exitosamente");                
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void LimpiarCampos(JTextField[] camposTexto, JComboBox[] combos) {
        for (JTextField campo : camposTexto) {
            campo.setText("");
        }

        for (JComboBox combo : combos) {
            combo.setSelectedIndex(0); // o -1 si quieres dejarlo sin selección
        }
    }

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
}
