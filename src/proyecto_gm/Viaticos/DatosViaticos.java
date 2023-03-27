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
import javax.swing.JComboBox;
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
public class DatosViaticos {

    static Connection conn = ConexionBD.getConnection();

    // Limpiar campos
    public static void LimpiarCampos(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField jTextField) {
                jTextField.setText("");
            } else if (componente instanceof JComboBox jComboBox) {
                jComboBox.setSelectedIndex(-1);
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
            } else if (componente instanceof JComboBox jComboBox) {
                jComboBox.setEnabled(false);
            } else if (componente instanceof Container container) {
                BloquearCampos(container);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }

    }

    // Habilitar campos
    public static void HabilitarCampos(Container contenedor, JTextField txtId) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField jTextField && componente != txtId) {
                jTextField.setEnabled(true);
            } else if (componente instanceof JComboBox jComboBox) {
                jComboBox.setEnabled(true);
            } else if (componente instanceof Container container) {
                HabilitarCampos(container, txtId);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    // Pensando en el nombre de la funcion...
    public static void CleanForm(JPanel panel, JTable tabla, JComboBox cboEmp, JComboBox cboPer) {
        DatosViaticos.LimpiarCampos(panel);
        DatosViaticos.BloquearCampos(panel);
        // Quitamos las selecciones de los combo boxes
        cboEmp.setSelectedIndex(-1);
        cboPer.setSelectedIndex(-1);

        // Bloqueamos los siguientes botones:
        frmViaticos.btnGuardar.setEnabled(false);
        frmViaticos.btnCancelar.setEnabled(false);
        // Habilitamos lo siguientes botones:
        frmViaticos.btnNuevo.setEnabled(true);
        frmViaticos.btnEditar.setEnabled(true);
        frmViaticos.btnEliminar.setEnabled(true);
        // Limpiamos alguna seleccion previa de alguna fila de la tabla
        tabla.clearSelection();
        // Habilitamos la seleccion de filas de la tabla
        tabla.setRowSelectionAllowed(true);
    }

    // Cargar opciones para los combo boxes
    public static void CargarCombos(JComboBox cboEmpleado, JComboBox cboPeriodo) {
        try {
            // Preparamos la consultas
            PreparedStatement pstmtEmp = conn.prepareStatement("SELECT Nombres FROM empleados");
            PreparedStatement pstmtPer = conn.prepareStatement("SELECT Id FROM periodos");

            // Las ejecutamos
            ResultSet empleados = pstmtEmp.executeQuery();
            ResultSet periodos = pstmtPer.executeQuery();

            // Agregamos las areas en cbxArea
            while (empleados.next()) {
                String nomEmp = empleados.getString("Nombres");
                cboEmpleado.addItem(nomEmp);
            }

            // Agregamos los cargos a cbxCargo
            while (periodos.next()) {
                String nomPer = periodos.getString("Id");
                cboPeriodo.addItem(nomPer);
            }

            // Contenido vacio en los combo boxes
            cboEmpleado.setSelectedIndex(-1);
            cboPeriodo.setSelectedIndex(-1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Mostrar datos
    public static void MostrarDatos(DefaultTableModel modelo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("CALL listar_viaticos()");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString("Id"), rs.getString("Descripcion"), rs.getString("Pasaje"),
                    rs.getString("Menu"), rs.getString("Empleado"), rs.getString("Periodo")};
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Insertar datos
    public static void InsertarDatos(Viaticos viatico, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_viaticos(?, ?, ?, ?, ?) }");
            cstmt.setString(1, viatico.getDescripcion());
            cstmt.setFloat(2, viatico.getPasaje());
            cstmt.setFloat(3, viatico.getMenu());
            cstmt.setString(4, viatico.getEmpleado());
            cstmt.setString(5, viatico.getPeriodo());

            cstmt.execute(); // se inserta los datos a la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosViaticos.MostrarDatos(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Boton editar
    public static void Editar(JPanel panel, JTable tabla, JTextField[] cajas, JComboBox cboEmp, JComboBox cboPer) {
        // Obtener el indice de la fila seleccionada
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            // Bloqueamos lo siguientes botones del formulario:
            frmViaticos.btnNuevo.setEnabled(false);
            frmViaticos.btnEditar.setEnabled(false);
            frmViaticos.btnEliminar.setEnabled(false);
            // Habilitamos lo siguientes botontes del formulario:
            frmViaticos.btnGuardar.setEnabled(true);
            frmViaticos.btnCancelar.setEnabled(true);
            // Volvemos a habilitar los campos
            DatosViaticos.HabilitarCampos(panel, cajas[0]);
            // Deshabilitamos la seleccion de filas de la tabla
            tabla.setRowSelectionAllowed(false);

            for (int i = 0; i < cajas.length; i++) {
                String dato = tabla.getModel().getValueAt(fila, i).toString();
                cajas[i].setText(dato);
            }

            cboEmp.setSelectedItem(tabla.getModel().getValueAt(fila, 4).toString());
            cboPer.setSelectedItem(tabla.getModel().getValueAt(fila, 5).toString());

            cajas[1].requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Actualizar datos
    public static void ActualizarDatos(Viaticos viatico, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_viaticos(?, ?, ?, ?, ?, ?) }");
            cstmt.setInt(1, viatico.getId());
            cstmt.setString(2, viatico.getDescripcion());
            cstmt.setFloat(3, viatico.getPasaje());
            cstmt.setFloat(4, viatico.getMenu());
            cstmt.setString(5, viatico.getEmpleado());
            cstmt.setString(6, viatico.getPeriodo());

            cstmt.execute(); // se actualiza los datos en la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);

            DatosViaticos.MostrarDatos(modelo);

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
                    int id = Integer.parseInt(tabla.getModel().getValueAt(fila, 0).toString()); //Se asume que el ID se encuentra en la primera columna

                    // Ejecutar el procedimiento almacenado
                    CallableStatement stmt = conn.prepareCall("{ CALL eliminar_viaticos(?) }");
                    stmt.setInt(1, id);
                    stmt.execute();

                    // Actualizar el JTable
                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.removeRow(fila);
                    // JOptionPane.showMessageDialog(null, "La fila ha sido eliminada exitosamente");                
                } else {
                    tabla.clearSelection();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Validar campos
    public static boolean Validar(JTextField[] cajas, JComboBox persona, JComboBox periodo) {
        boolean validar = true;
        // Comprobamos cajas vacías
        for (JTextField caja : cajas) {
            if (caja.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                validar = false;
                break;
            }
        }
        
        // Comprobamos combos sin elección
        if (persona.getSelectedItem() == null || periodo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            validar = false;
        }
        
        return validar;
    }
}
