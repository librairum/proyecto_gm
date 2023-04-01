/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Empleado;

import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

/**
 *
 * @author jeanv
 */
public class DatosEmpleados {

    static Connection conn = ConexionBD.getConnection();

    // Limpiar campos
    public static void Limpiar(Container contenedor, JRadioButton porDefecto) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField jTextField) {
                jTextField.setText("");
            } else if (component instanceof JComboBox jComboBox) {
                jComboBox.setSelectedIndex(0);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }

        porDefecto.setSelected(true);
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

    // Cargar opciones para los combo boxes
    public static void CargarCombos(JComboBox cboArea, JComboBox cboCargo) {
        PreparedStatement pstmtArea = null;
        PreparedStatement pstmtCargo = null;
        ResultSet rsAreas = null;
        ResultSet rsCargos = null;
        try {
            // Preparamos la consultas
            pstmtArea = conn.prepareStatement("SELECT Descripcion FROM areas");
            pstmtCargo = conn.prepareStatement("SELECT Descripcion FROM cargos");

            // Las ejecutamos
            rsAreas = pstmtArea.executeQuery();
            rsCargos = pstmtCargo.executeQuery();

            // Agregamos las areas en cbxArea
            while (rsAreas.next()) {
                String nomArea = rsAreas.getString("Descripcion");
                cboArea.addItem(nomArea);
            }

            // Agregamos los cargos a cbxCargo
            while (rsCargos.next()) {
                String nomCargo = rsCargos.getString("Descripcion");
                cboCargo.addItem(nomCargo);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerramos los recursos
            try {
                if (rsAreas != null) {
                    rsAreas.close();
                }
                if (rsCargos != null) {
                    rsCargos.close();
                }
                if (pstmtArea != null) {
                    pstmtArea.close();
                }
                if (pstmtCargo != null) {
                    pstmtCargo.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Listar datos
    public static void Listar(DefaultTableModel modelo) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("CALL listar_emple()");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString("Id"), rs.getString("Apellidos"),
                    rs.getString("Nombres"), rs.getString("FechaNacimiento"), rs.getString("Correo"),
                    rs.getString("Dni"), rs.getString("Celular"), rs.getString("Direccion"),
                    rs.getString("Area"), rs.getString("Cargo"), rs.getString("Tip. Empleado")};
                modelo.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Capturar las opciones de los radio buttons y de los combo boxes
    public static String[] CapturarOpciones(JComboBox cbxArea, JComboBox cbxCargo, ButtonGroup opciones) {
        String[] ids = new String[3];
        String idArea = "", idCargo = "", idTipoEmpleado = "";
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            // Capturar las opciones seleccionadas en los combo boxes
            String selectArea = cbxArea.getSelectedItem().toString();
            String selectCargo = cbxCargo.getSelectedItem().toString();

            // Capturar la opcion seleccionada de los radio buttons (tipo empleado)
            ButtonModel selectedRadioButton = opciones.getSelection();
            String tipoEmpleado = selectedRadioButton.getActionCommand();

            // Obtener los id de las elecciones en area, cargo y tipo de empleado
            cstmt = conn.prepareCall("{ CALL consulta_areas_cargos_tipos(?, ?, ?) }");
            cstmt.setString(1, selectArea);
            cstmt.setString(2, selectCargo);
            cstmt.setString(3, tipoEmpleado);
            rs = cstmt.executeQuery();

            while (rs.next()) {
                idArea = rs.getString("Id_area");
                idCargo = rs.getString("Id_cargo");
                idTipoEmpleado = rs.getString("Id_tipo");
            }

            ids[0] = idArea;
            ids[1] = idCargo;
            ids[2] = idTipoEmpleado;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al procesar las opciones seleccionadas.", JOptionPane.ERROR_MESSAGE);
        } finally { // Finalmente cerramos el ResultSet y el CallableStatement
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        return ids;
    }

    // Insertar datos
    public static void Insertar(Empleados empleado, JTable tabla) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL insertar_datos_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setString(1, empleado.getId());
            cstmt.setString(2, empleado.getApellidos());
            cstmt.setString(3, empleado.getNombres());
            cstmt.setString(4, empleado.getfNacimiento());
            cstmt.setString(5, empleado.getCorreo());
            cstmt.setString(6, empleado.getDni());
            cstmt.setString(7, empleado.getCelular());
            cstmt.setString(8, empleado.getDireccion());
            cstmt.setString(9, empleado.getIdArea());
            cstmt.setString(10, empleado.getIdCargo());
            cstmt.setString(11, empleado.getIdTipo());

            cstmt.execute(); // se inserta los datos a la BD
            JOptionPane.showMessageDialog(null, "Empleado registrado satisfactoriamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosEmpleados.Listar(modelo);

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

    }

    // Boton Editar
    public static void Editar(Container contenedor, JTable tabla, JTextField[] camposTexto, JComboBox[] combos, ButtonGroup grupoBotones) {

        // Obtener la fila seleccionada
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            DatosEmpleados.Habilitar(contenedor, grupoBotones, true);
            tabla.clearSelection();
            tabla.setRowSelectionAllowed(false);

            // Llenar los campos de texto con los valores de la fila
            for (int i = 0; i < camposTexto.length; i++) {
                if (tabla.getValueAt(fila, i) != null) { // si el dato no es nulo
                    String dato = tabla.getModel().getValueAt(fila, i).toString();
                    camposTexto[i].setText(dato);
                } else {
                    camposTexto[i].setText("");
                }

            }

            camposTexto[0].setEnabled(false);
            camposTexto[1].requestFocus();

            // Llenar los combos con los valores de la fila
            for (int i = 0; i < combos.length; i++) {
                combos[i].setSelectedItem(tabla.getModel().getValueAt(fila, camposTexto.length + i).toString());
            }

            // Llenar el grupo de botones con los valores de la fila
            for (Enumeration<AbstractButton> botones = grupoBotones.getElements(); botones.hasMoreElements();) {
                AbstractButton boton = botones.nextElement();
                if (boton.getText().equals(tabla.getModel().getValueAt(fila, camposTexto.length + combos.length).toString())) {
                    boton.setSelected(true);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    // Actualizar datos

    public static void Actualizar(Empleados empleado, JTable tabla) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL actualizar_datos_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setString(1, empleado.getId());
            cstmt.setString(2, empleado.getApellidos());
            cstmt.setString(3, empleado.getNombres());
            cstmt.setString(4, empleado.getfNacimiento());
            cstmt.setString(5, empleado.getCorreo());
            cstmt.setString(6, empleado.getDni());
            cstmt.setString(7, empleado.getCelular());
            cstmt.setString(8, empleado.getDireccion());
            cstmt.setString(9, empleado.getIdArea());
            cstmt.setString(10, empleado.getIdCargo());
            cstmt.setString(11, empleado.getIdTipo());

            cstmt.execute(); // se actualiza los datos en la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosEmpleados.Listar(modelo);

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
                    cstmt = conn.prepareCall("{ CALL eliminar_empleados(?) }");
                    cstmt.setString(1, id);
                    cstmt.execute();

                    // Actualizar el JTable
                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                    modelo.setRowCount(0);
                    DatosEmpleados.Listar(modelo);

                    // JOptionPane.showMessageDialog(null, "La fila ha sido eliminada exitosamente");                
                } else {
                    tabla.clearSelection();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

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

    }

    // Boton registrar datos academicos
    // Debemos capturar el nombre completo y el dni de la fila seleccionada
    public static boolean ObtenerEmpleado(JTable tabla) {
        // Obtener el indice de la fila seleccionada
        int fila = tabla.getSelectedRow();
        String nombreCompleto = "", dni = "";

        if (fila >= 0) {
            nombreCompleto = tabla.getModel().getValueAt(fila, 2).toString() + " " + tabla.getModel().getValueAt(fila, 1).toString();
            dni = tabla.getModel().getValueAt(fila, 5).toString();

            Datosacad.txtNomCom.setText(nombreCompleto);
            Datosacad.txtDni.setText(dni);
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para registrar sus datos académicos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    // Validar campos
    public static boolean Validar(JTextField[] campos) {
        boolean validar = true;
        // Validamos si los campos estan vacios
        for (JTextField campo : campos) {
            if (campo.getText().equals("")) {
                validar = false;
                campo.requestFocus();
                break;
            }
        }

        if (validar) {
            // Validamos uno por uno
            if (!campos[4].getText().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) { // Validamos correo
                validar = false;
                JOptionPane.showMessageDialog(null, "El formato de correo es el siguiente: someone@mail.com\nInténtelo de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                campos[4].requestFocus();
            } else if (campos[5].getText().length() != 8) { // Validamos DNI
                validar = false;
                JOptionPane.showMessageDialog(null, "El DNI debe contener 8 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                campos[5].requestFocus();
            } else if (campos[6].getText().length() != 9) { // Validamos celular
                validar = false;
                JOptionPane.showMessageDialog(null, "El celular debe contener 9 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                campos[6].requestFocus();
            } else if (campos[3].getText().length() != 10) { // Validamos fecha
                validar = false;
                JOptionPane.showMessageDialog(null, "El formato de la fecha es el siguiente: dd-mm-aaaa. Inténtelo de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                campos[3].requestFocus();
            } else {
                // Definir el formato de fecha
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                sdf.setLenient(false); // no permitir fechas inválidas

                try {
                    // Intentar parsear el string como una fecha
                    sdf.parse(campos[3].getText());
                } catch (ParseException e) {
                    validar = false;
                    JOptionPane.showMessageDialog(null, "El formato de la fecha es el siguiente: dd-mm-aaaa. Inténtelo de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            validar = false;
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        return validar;
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
