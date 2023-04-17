/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.RecibosHonorarios;

import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
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

/**
 *
 * @author jeanv
 */
public class DatosRecibosHonorarios {

    static Connection conn = ConexionBD.getConnection();

    // Limpiar campos
    public static void Limpiar(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField jTextField) {
                jTextField.setText("");
            } else if (componente instanceof JComboBox jComboBox) {
                jComboBox.setSelectedIndex(-1);
            } else if (componente instanceof Container container) {
                Limpiar(container);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    // Habilitar campos
    public static void Habilitar(Container contenedor, boolean bloquear) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField jTextField) {
                jTextField.setEnabled(bloquear);
            } else if (componente instanceof JComboBox jComboBox) {
                jComboBox.setEnabled(bloquear);
            } else if (componente instanceof JButton jButton) {
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
    }

    // Mostrar datos
    public static void Listar(DefaultTableModel modelo) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("CALL listar_recibos_honorarios()");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString("Id"), rs.getString("NroRecibo"),
                    rs.getString("Ruc"), rs.getString("Nombres"), rs.getString("Apellidos"),
                    rs.getString("Distrito"), rs.getString("Direccion"), rs.getString("FormaPago"),
                    rs.getString("Concepto"), rs.getString("ImporteNeto"), rs.getString("RetencionIr"),
                    rs.getString("ImporteTotal"), rs.getString("FechaEmision")};
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
    public static void Insertar(ReciboHonorario recibo, JTable tabla) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL insertar_recibo_honorario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");

            cstmt.setString(1, recibo.getId());
            cstmt.setString(2, recibo.getNroRecibo());
            cstmt.setString(3, recibo.getRuc());
            cstmt.setString(4, recibo.getNombres());
            cstmt.setString(5, recibo.getApellidos());
            cstmt.setString(6, recibo.getDistrito());
            cstmt.setString(7, recibo.getDireccion());
            cstmt.setString(8, recibo.getFormaPago());
            cstmt.setString(9, recibo.getConcepto());
            cstmt.setFloat(10, recibo.getImporteNeto());
            cstmt.setFloat(11, recibo.getRetencionIr());
            cstmt.setFloat(12, recibo.getImporteTotal());
            cstmt.setString(13, recibo.getFecha());

            cstmt.execute(); // se inserta los datos a la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosRecibosHonorarios.Listar(modelo);

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

    // Boton editar
    public static void Editar(Container contenedor, JTable tabla, JTextField[] cajas, JComboBox cboDistrito, JComboBox cboPago) {
        // Obtener el indice de la fila seleccionada
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            DatosRecibosHonorarios.Habilitar(contenedor, true);
            // Limpiamos la seleccion en la tabla
            tabla.clearSelection();
            // Deshabilitamos la seleccion de filas de la tabla
            tabla.setRowSelectionAllowed(false);

            cajas[0].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("ID")).toString());
            cajas[1].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("NRO. RECIBO")).toString());
            cajas[2].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("RUC")).toString());
            cajas[3].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("NOMBRES")).toString());
            cajas[4].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("APELLIDOS")).toString());
            cajas[5].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("DIRECCIÓN")).toString());
            cajas[6].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("CONCEPTO")).toString());
            cajas[7].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("IMP. NETO")).toString());
            cajas[8].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("RETENCIÓN IR")).toString());
            cajas[9].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("IMP. TOTAL")).toString());
            cajas[10].setText(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("FEC. EMISIÓN")).toString());

            cajas[0].setEnabled(false);
            cajas[1].requestFocus();

            cboDistrito.setSelectedItem(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("DISTRITO")).toString());
            cboPago.setSelectedItem(tabla.getModel().getValueAt(fila, tabla.getColumnModel().getColumnIndex("F. PAGO")).toString());

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Actualizar datos
    public static void Actualizar(ReciboHonorario recibo, JTable tabla) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL actualizar_recibo_honorario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");

            cstmt.setString(1, recibo.getId());
            cstmt.setString(2, recibo.getNroRecibo());
            cstmt.setString(3, recibo.getRuc());
            cstmt.setString(4, recibo.getNombres());
            cstmt.setString(5, recibo.getApellidos());
            cstmt.setString(6, recibo.getDistrito());
            cstmt.setString(7, recibo.getDireccion());
            cstmt.setString(8, recibo.getFormaPago());
            cstmt.setString(9, recibo.getConcepto());
            cstmt.setFloat(10, recibo.getImporteNeto());
            cstmt.setFloat(11, recibo.getRetencionIr());
            cstmt.setFloat(12, recibo.getImporteTotal());
            cstmt.setString(13, recibo.getFecha());

            cstmt.execute(); // se actualiza los datos en la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);

            DatosRecibosHonorarios.Listar(modelo);

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
                    cstmt = conn.prepareCall("{ CALL eliminar_recibo_honorario(?) }");
                    cstmt.setString(1, id);
                    cstmt.execute();

                    // Actualizar el JTable
                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.removeRow(fila);
                    // JOptionPane.showMessageDialog(null, "La fila ha sido eliminada exitosamente");                
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
    public static boolean Validar(JTextField[] cajas, JComboBox persona, JComboBox periodo) {
        // Comprobamos cajas vacías
        for (JTextField caja : cajas) {
            if (caja.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        // Comprobamos combos sin elección
        if (persona.getSelectedItem() == null || periodo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    public static boolean Validar(JTextField[] campos) {
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                campo.requestFocus();
                return false;
            }
        }
        
        if (campos[1].getText().length() != 11) {
            JOptionPane.showMessageDialog(null, "El RUC debe contener 11 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            campos[1].requestFocus();
            return false;
        }
        
        // Si se llega aquí, todos los campos son válidos
        return true;
    }

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
