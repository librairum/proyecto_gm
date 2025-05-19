/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Viaticos;

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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;
import proyecto_gm.Empleado.Empleados;

/**
 *
 * @author jeanv
 */
public class DatosViaticos {

    static Connection conn = ConexionBD.getConnection();

    // Limpiar campos
    public static void Limpiar(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                //componente.setText("");
                ((JTextField) componente).setText("");
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof Container) {
                Limpiar((Container) componente);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    // Habilitar campos
    public static void Habilitar(Container contenedor, boolean bloquear) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                //jTextField.setEnabled(bloquear);
                ((JTextField) componente).setEnabled(bloquear);
            } else if (componente instanceof JComboBox) {
                //jComboBox.setEnabled(bloquear);
                ((JComboBox) componente).setEnabled(bloquear);
            } else if (componente instanceof JButton) {

                String button = ((JButton) componente).getName();
                if (button.equals("guardar") || button.equals("cancelar")) {
                    ((JButton) componente).setEnabled(bloquear);
                } else if (button.equals("nuevo") || button.equals("editar") || button.equals("eliminar")) {
                    ((JButton) componente).setEnabled(!bloquear); // aplicar logica inversa
                }
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    public static void llenarComboBoxViaticos(JComboBox<Empleados> cboEmpleado, JComboBox<String> cboPeriodo) {
        try {
            PreparedStatement pstmtEmpleado = conn.prepareStatement("CALL listar_viaticos_empleado()");
            ResultSet rsEmpleado = pstmtEmpleado.executeQuery();

            while (rsEmpleado.next()) {
                Empleados e = new Empleados();
                e.setId(rsEmpleado.getString("IdEmpleado"));
                e.setNombres(rsEmpleado.getString("Nombre_Completo"));
                e.setApellidos("");  // para evitar null
                cboEmpleado.addItem(e);
            }

            PreparedStatement pstmtPeriodo = conn.prepareStatement("CALL listar_viaticos_periodo()");
            ResultSet rsPeriodo = pstmtPeriodo.executeQuery();

            while (rsPeriodo.next()) {
                cboPeriodo.addItem(rsPeriodo.getString("Mes"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al llenar el ComboBox: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String capturarIdEmpleado(JComboBox<String> cboEmpleado) {
        String idEmpleado = "";
        try ( CallableStatement cstmt = conn.prepareCall("{CALL obtener_id_empleado(?)}")) {
            cstmt.setString(1, cboEmpleado.getSelectedItem().toString().trim());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                idEmpleado = rs.getString("IdEmpleado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar IdEmpleado", JOptionPane.ERROR_MESSAGE);
        }
        return idEmpleado;
    }

    public static String capturarIdPeriodo(JComboBox<String> cboPeriodo) {
        String idPeriodo = "";
        try ( CallableStatement cstmt = conn.prepareCall("{CALL obtener_id_periodo(?)}")) {
            cstmt.setString(1, cboPeriodo.getSelectedItem().toString());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                idPeriodo = rs.getString("IdPeriodo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar IdPeriodo", JOptionPane.ERROR_MESSAGE);
        }
        return idPeriodo;
    }

// Mostrar datos
    public static void Listar(DefaultTableModel modelo) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("CALL listar_viaticos()");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("Id"),
                    rs.getString("Descripcion"),
                    rs.getString("Pasaje"),
                    rs.getString("Menu"),
                    rs.getString("Empleado"),
                    rs.getString("Periodo")};
                modelo.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean InsertarDatos(Viaticos via, JTable tabla) {
        System.out.println("Entró al método InsertarDatos...");

        try ( CallableStatement cstmt = conn.prepareCall("{ CALL insertar_viaticos(?, ?, ?, ?, ?) }")) {
            cstmt.setString(1, via.getDescripcion()); // xDescripcion
            cstmt.setDouble(2, via.getPasaje());      // xPasaje
            cstmt.setDouble(3, via.getMenu());        // xMenu
            cstmt.setInt(4, Integer.parseInt(via.getEmpleado())); // xIdEmpleado
            cstmt.setInt(5, Integer.parseInt(via.getPeriodo()));  // xIdPeriodo
            cstmt.execute();

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "¡Registro exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Refrescar tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Listar(modelo);

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Boton editar
    public static void Editar(JPanel panel, JTable tabla, JTextField[] cajas, JComboBox cboEmp, JComboBox cboPer) {
        // Obtener el indice de la fila seleccionada
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            DatosViaticos.Habilitar(panel, true);
            // Limpiar la seleccion en la tabla
            tabla.clearSelection();
            // Deshabilitamos la seleccion de filas de la tabla
            tabla.setRowSelectionAllowed(false);

            for (int i = 0; i < cajas.length; i++) {
                String dato = tabla.getModel().getValueAt(fila, i).toString();
                cajas[i].setText(dato);
            }

            cajas[0].setEnabled(false);
            cajas[1].requestFocus();

            cboEmp.setSelectedItem(tabla.getModel().getValueAt(fila, 4).toString());
            cboPer.setSelectedItem(tabla.getModel().getValueAt(fila, 5).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Actualizar datos
    public static boolean Actualizar(Viaticos viatico, JTable tabla) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_viaticos(?, ?, ?, ?, ?, ?) }")) {
            cstmt.setInt(1, viatico.getId());
            cstmt.setString(2, viatico.getDescripcion());
            cstmt.setDouble(3, viatico.getPasaje());
            cstmt.setDouble(4, viatico.getMenu());
            cstmt.setInt(5, Integer.parseInt(viatico.getEmpleado()));
            cstmt.setInt(6, Integer.parseInt(viatico.getPeriodo()));

            cstmt.execute();

            // Actualizar tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Listar(modelo);

            JOptionPane.showMessageDialog(null, "¡Viático actualizado correctamente!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Eliminar datos
    public static void Eliminar(JTable tabla) {
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este viático?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try ( CallableStatement cstmt = conn.prepareCall("{ CALL eliminar_viaticos(?) }")) {
                    int id = Integer.parseInt(tabla.getModel().getValueAt(fila, 0).toString());
                    cstmt.setInt(1, id);
                    cstmt.execute();

                    // Actualizar tabla
                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                    modelo.setRowCount(0);
                    Listar(modelo);

                    JOptionPane.showMessageDialog(null, "¡Viático eliminado correctamente!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Validar campos
    public static boolean Validar(JTextField[] campos, JComboBox[] combos) {
        // Comprobamos cajas vacías
        for (JTextField campo : campos) {
            if (campo.getText().equals("")) {
                JOptionPane.showMessageDialog(
                        null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE
                );
                campo.requestFocus();
                return false;
            }
        }

        for (JComboBox combo : combos) {
            if (combo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(
                        null, "Debe escoger un empleado y un periodo.", "Advertencia", JOptionPane.WARNING_MESSAGE
                );
                combo.requestFocus();
                return false;
            }
        }

        return true;
    }
}
