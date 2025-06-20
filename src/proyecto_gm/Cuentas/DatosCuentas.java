/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Cuentas;

import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

/**
 *
 * @author jeanv
 */
public class DatosCuentas {

    static Connection conn = ConexionBD.getConnection();

    public static String GenerarCodigo() {
        String codigoGenerado = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?) }")) {
            cstmt.setString(1, "cuentasbancarias");
            cstmt.setString(2, "IdCuentaBancaria");
            cstmt.registerOutParameter(3, Types.INTEGER);
            cstmt.execute();
            int idGenerado = cstmt.getInt(3); // Recibe el número
            codigoGenerado = String.valueOf(idGenerado);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return codigoGenerado;
    }

    // Llenar ComboBox de bancos desde la BD
    public static void CargarBancos(JComboBox<Banco> combo) {
        combo.removeAllItems();
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL listar_bancos() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idBanco");
                String descripcion = rs.getString("descripcion");
                combo.addItem(new Banco(id, descripcion));
            }
        } catch (Exception e) {
            System.err.println("Error al cargar bancos: " + e.getMessage());
        }
    }

    // Llenar ComboBox de tipo propietario con datos estáticos
    public static void CargarTipoPropietario(JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Persona Natural");
        combo.addItem("Empresa");
    }

    // (Si usas getSelectedIndex + 1 para banco, no necesitarías esto,
    // pero si quieres obtener el ID real del banco seleccionado, usa esto:)
    public static int obtenerIdBancoSeleccionado(JComboBox<Banco> combo) {
        Banco banco = (Banco) combo.getSelectedItem();
        return banco != null ? banco.getId() : -1;
    }

    // Mostrar datos
    public static void Listar(DefaultTableModel modelo) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("CALL listar_cuentas()");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String tipoPropietario = rs.getString("TipoPropietario");
                String tipoPropietarioTexto = tipoPropietario.equals("P") ? "Persona Natural" : "Empresa";
                String tipoMoneda = rs.getString("TipoMoneda");
                String tipoMonedaTexto = tipoMoneda.equals("S") ? "Soles" : "Dólares";
                Object[] row = new Object[]{
                    rs.getString("IdCuentaBancaria"),
                    tipoPropietarioTexto,
                    rs.getString("Nombres"),
                    rs.getString("Banco"),
                    rs.getString("CCC"),
                    rs.getString("CCI"), tipoMonedaTexto};
                modelo.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Insertar datos
    public static void Insertar(Cuentas cuenta, JTable tabla) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL insertar_cuenta(?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setInt(1, cuenta.getIdCuenta());
            cstmt.setString(2, cuenta.getTipoPropietario());
            cstmt.setString(3, cuenta.getNombres());
            cstmt.setInt(4, cuenta.getIdBanco());
            cstmt.setString(5, cuenta.getNroCuenta());
            cstmt.setString(6, cuenta.getNroCuentaInterbancaria());
            cstmt.setString(7, cuenta.getTipoMoneda());
            cstmt.execute(); // se inserta los datos a la BD
            JOptionPane.showMessageDialog(null, "Cuenta registrada satisfactoriamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Listar(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Actualizar datos
    public static void Actualizar(Cuentas cuenta, JTable tabla) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL actualizar_cuenta(?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setInt(1, cuenta.getIdCuenta());
            cstmt.setString(2, cuenta.getTipoPropietario());
            cstmt.setString(3, cuenta.getNombres());
            cstmt.setInt(4, cuenta.getIdBanco());
            cstmt.setString(5, cuenta.getNroCuenta());
            cstmt.setString(6, cuenta.getNroCuentaInterbancaria());
            cstmt.setString(7, cuenta.getTipoMoneda());
            int rowsUpdated = cstmt.executeUpdate(); // Devuelve el número de filas afectadas

            // Verificar si se actualizó alguna fila
            if (rowsUpdated > 0) {
                // Si se actualizó, actualizamos la tabla
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0);
                Listar(modelo); // Volver a listar los datos
                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Si no se actualizó nada
                JOptionPane.showMessageDialog(null, "No se encontró la cuenta o no hubo cambios.", "Sin cambios", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Eliminar datos
    public static void Eliminar(JTable tabla) {
        CallableStatement cstmt = null;
        try {
            // Obtener el índice de la fila seleccionada
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                String[] options = {"Sí", "No", "Cancelar"};
                int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que quiere eliminar la fila seleccionada?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                if (opcion == JOptionPane.YES_OPTION) {
                    // Obtener los datos de la fila seleccionada
                    int id = Integer.parseInt(tabla.getModel().getValueAt(fila, 0).toString()); // ID primera columna
                    // Ejecutar el procedimiento almacenado
                    cstmt = conn.prepareCall("{ CALL eliminar_cuenta(?) }");
                    cstmt.setInt(1, id);
                    int rowsDeleted = cstmt.executeUpdate(); // Devuelve el número de filas eliminadas
                    if (rowsDeleted > 0) {
                        // Si se eliminó correctamente, actualizamos la tabla
                        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                        modelo.setRowCount(0);
                        Listar(modelo); // Volver a listar los datos
                        // Mostrar mensaje de éxito
                        JOptionPane.showMessageDialog(null, "La cuenta se eliminó correctamente.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Si no se eliminó ninguna fila
                        JOptionPane.showMessageDialog(null, "No se encontró la cuenta o no hubo cambios.", "Sin cambios", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    tabla.clearSelection(); // Cancelar la acción
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Boton Editar
    public static void Editar(Container contenedor, JTable tabla, JTextField[] cajas, JComboBox[] combos, ButtonGroup grupoBotones) {
        // Obtener la fila seleccionada
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            Habilitar(contenedor, grupoBotones, true);
            tabla.clearSelection();
            tabla.setRowSelectionAllowed(false);
            cajas[0].setText(tabla.getModel().getValueAt(fila, 0).toString());
            cajas[1].setText(tabla.getModel().getValueAt(fila, 2).toString());
            cajas[2].setText(tabla.getModel().getValueAt(fila, 4).toString());
            cajas[3].setText(tabla.getModel().getValueAt(fila, 5).toString());
            cajas[0].setEnabled(false);
            combos[0].setSelectedItem(tabla.getModel().getValueAt(fila, 1).toString()); // la columna "Tip. Propietario" está en la posición 1
            combos[1].setSelectedItem(tabla.getModel().getValueAt(fila, 3).toString()); // la columna "Banco" está en la posición 3
            combos[0].requestFocus();

            // Seleccionar las opciones de los radio buttons
            for (Enumeration<AbstractButton> botones = grupoBotones.getElements(); botones.hasMoreElements();) {
                AbstractButton boton = botones.nextElement();
                if (boton.getText().equals(tabla.getModel().getValueAt(fila, 6).toString())) {
                    boton.setSelected(true);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Validar campos
    public static boolean Validar(JTextField[] campos) {
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                campo.requestFocus();
                return false;
            }
        }
        if (campos[1].getText().length() != 14) {
            JOptionPane.showMessageDialog(null, "El número de cuenta debe contener 14 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            campos[1].requestFocus();
            return false;
        }
        if (campos[2].getText().length() != 20) {
            JOptionPane.showMessageDialog(null, "El número de cuenta interbancaria debe contener 20 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            campos[2].requestFocus();
            return false;
        }
        return true;
    }

    // Limpiar campos
    public static void Limpiar(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(0);
            } else if (componente instanceof Container) {
                Limpiar((Container) componente);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    // Habilitar o bloquear campos y botones
    public static void Habilitar(Container contenedor, ButtonGroup opciones, boolean bloquear) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setEnabled(bloquear);
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setEnabled(bloquear);
            } else if (component instanceof JButton) {
                String button = ((JButton) component).getName();
                if (button.equals("guardar") || button.equals("cancelar")) {
                    ((JButton) component).setEnabled(bloquear);
                } else if (button.equals("nuevo") || button.equals("editar") || button.equals("eliminar")) {
                    ((JButton) component).setEnabled(!bloquear); // aplicar logica inversa
                }
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
        for (Enumeration<AbstractButton> buttons = opciones.getElements(); buttons.hasMoreElements();) {
            buttons.nextElement().setEnabled(bloquear);
        }
    }
}
