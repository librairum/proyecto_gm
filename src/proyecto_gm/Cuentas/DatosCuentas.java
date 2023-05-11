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

    // Limpiar campos
    public static void Limpiar(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField jTextField) {
                jTextField.setText("");
            } else if (componente instanceof JComboBox jComboBox) {
                jComboBox.setSelectedIndex(0);
            } else if (componente instanceof Container container) {
                Limpiar(container);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    // Habilitar o bloquear campos y botones
    public static void Habilitar(Container contenedor, ButtonGroup opciones, boolean bloquear) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField jTextField) {
                jTextField.setEnabled(bloquear);
            } else if (component instanceof JComboBox jComboBox) {
                jComboBox.setEnabled(bloquear);
            } else if (component instanceof JButton jButton) {
                String button = jButton.getName();
                if (button.equals("guardar") || button.equals("cancelar")) {
                    jButton.setEnabled(bloquear);
                } else if (button.equals("nuevo") || button.equals("editar") || button.equals("eliminar")) {
                    jButton.setEnabled(!bloquear); // aplicar logica inversa
                }
            } else {
                // No hace nada para otros tipos de componentes
            }
        }

        for (Enumeration<AbstractButton> buttons = opciones.getElements(); buttons.hasMoreElements();) {
            buttons.nextElement().setEnabled(bloquear);
        }
    }

    // Cargar opciones el combo box "cboBanco"
    public static void CargarBancos(JComboBox<String> cboBanco) {
        String sql = "SELECT Descripcion FROM bancos";
        List<String> bancos = new ArrayList<>();
        try ( PreparedStatement pstmt = conn.prepareStatement(sql);  ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                bancos.add(rs.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        cboBanco.setModel(new DefaultComboBoxModel<>(bancos.toArray(new String[0])));
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
                Object[] row = new Object[]{rs.getString("Id"), tipoPropietarioTexto, rs.getString("Nombres"),
                    rs.getString("Banco"), rs.getString("CCC"), rs.getString("CCI"), tipoMonedaTexto};
                modelo.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Insertar datos
    public static void Insertar(Cuentas cuenta, JTable tabla) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL insertar_cuenta(?, ?, ?, ?, ?, ?, ?) }");

            cstmt.setString(1, cuenta.getId());
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
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
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

    // Actualizar datos
    public static void Actualizar(Cuentas cuenta, JTable tabla) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL actualizar_cuenta(?, ?, ?, ?, ?, ?, ?) }");

            cstmt.setString(1, cuenta.getId());
            cstmt.setString(2, cuenta.getTipoPropietario());
            cstmt.setString(3, cuenta.getNombres());
            cstmt.setInt(4, cuenta.getIdBanco());
            cstmt.setString(5, cuenta.getNroCuenta());
            cstmt.setString(6, cuenta.getNroCuentaInterbancaria());
            cstmt.setString(7, cuenta.getTipoMoneda());

            cstmt.execute(); // se inserta los datos a la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Listar(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Eliminar datos
    public static void Eliminar(JTable tabla) {
        CallableStatement cstmt = null;
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
                    cstmt = conn.prepareCall("{ CALL eliminar_cuenta(?) }");
                    cstmt.setString(1, id);
                    cstmt.execute();

                    // Actualizamos la tabla
                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                    modelo.setRowCount(0);
                    Listar(modelo);

                } else {
                    tabla.clearSelection();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
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

    // Generar código
    public static String GenerarCodigo(String tabla, String prefijo, int longitud) {
        CallableStatement cstmt = null;
        String codigo_generado = "";
        try {
            cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?, ?) }");
            cstmt.setString(1, tabla);
            cstmt.setString(2, prefijo);
            cstmt.setInt(3, longitud);
            cstmt.registerOutParameter(4, Types.VARCHAR);

            cstmt.execute();

            codigo_generado = cstmt.getString(4);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        return codigo_generado;
    }
}
