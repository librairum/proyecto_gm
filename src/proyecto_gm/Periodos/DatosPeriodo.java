/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Periodos;

import java.awt.Component;
import java.awt.Container;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

/**
 *
 * @author jeanv
 */
public class DatosPeriodo {

    static Connection conn = ConexionBD.getConnection();

    // Limpiar campos
    public static void LimpiarCampos(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField jTextField) {
                jTextField.setText("");
            } else if (componente instanceof Container container) {
                LimpiarCampos(container);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    // Bloquear campos
    public static void BloquearCampos(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField jTextField) {
                jTextField.setEnabled(false);
            } else if (componente instanceof Container container) {
                BloquearCampos(container);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }

    }

    // Habilitar campos
    public static void HabilitarCampos(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField jTextField) {
                jTextField.setEnabled(true);
            } else if (componente instanceof Container container) {
                HabilitarCampos(container);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }
    
    public static void CleanForm(JPanel panel, JTable tabla) {
        DatosPeriodo.LimpiarCampos(panel);
        DatosPeriodo.BloquearCampos(panel);

        // Bloqueamos los siguientes botones:
        frmPeriodos.btnGuardar.setEnabled(false);
        frmPeriodos.btnCancelar.setEnabled(false);
        // Habilitamos lo siguientes botones:
        frmPeriodos.btnNuevo.setEnabled(true);
        frmPeriodos.btnEditar.setEnabled(true);
        frmPeriodos.btnEliminar.setEnabled(true);
        // Limpiamos alguna seleccion previa de alguna fila de la tabla
        tabla.clearSelection();
        // Habilitamos la seleccion de filas de la tabla
        tabla.setRowSelectionAllowed(true);
    }

    // Mostrar datos
    public static void MostrarDatos(DefaultTableModel modelo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("CALL listar_periodos()");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString("Id"), rs.getString("Descripcion")};
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Insertar datos
    public static void InsertarDatos(Periodos periodo, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_periodos(?, ?) }");
            cstmt.setString(1, periodo.getId());
            cstmt.setString(2, periodo.getDescripcion());
            cstmt.execute(); // se inserta los datos a la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosPeriodo.MostrarDatos(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Boton editar
    public static void Editar(JPanel panel, JTable tabla, JTextField[] cajas) {
        // Obtener el indice de la fila seleccionada
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            // Bloqueamos lo siguientes botones del formulario:
            frmPeriodos.btnNuevo.setEnabled(false);
            frmPeriodos.btnEditar.setEnabled(false);
            frmPeriodos.btnEliminar.setEnabled(false);
            // Habilitamos lo siguientes botontes del formulario:
            frmPeriodos.btnGuardar.setEnabled(true);
            frmPeriodos.btnCancelar.setEnabled(true);
            // Volvemos a bloquear los campos
            DatosPeriodo.HabilitarCampos(panel);
            // Deshabilitamos la seleccion de filas de la tabla
            tabla.setRowSelectionAllowed(false);
            
            for (int i = 0; i < cajas.length; i++) {
                String dato = tabla.getModel().getValueAt(fila, i).toString();
                cajas[i].setText(dato);
            }

            cajas[0].setEnabled(false);
            cajas[1].requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
        }

    }

    // Actualizar datos
    public static void ActualizarDatos(Periodos periodo, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_periodos(?, ?) }");
            cstmt.setString(1, periodo.getId());
            cstmt.setString(2, periodo.getDescripcion());

            String[] options = {"Sí", "No", "Cancelar"};
            int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que quiere actualizar la fila seleccionada?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

            if (opcion == JOptionPane.YES_OPTION) {
                cstmt.execute(); // se actualiza los datos en la BD

                // Actualizamos la tabla
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0);

                DatosPeriodo.MostrarDatos(modelo);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Eliminar datos
    public static void EliminarDatos(JTable tabla) {
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
                    CallableStatement stmt = conn.prepareCall("{ CALL eliminar_periodos(?) }");
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
}
