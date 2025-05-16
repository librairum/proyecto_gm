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
import java.util.HashMap;
import java.util.Map;
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
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
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

    // Cargar opciones para los combo boxes
    public static void CargarArea(JComboBox<String> cboArea) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_areas() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                cboArea.addItem(rs.getString("descripcion"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar Áreas", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String CapturarArea(JComboBox<String> cboArea) {
        String idArea = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_id_area(?) }")) {
            cstmt.setString(1, cboArea.getSelectedItem().toString());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                idArea = rs.getString("IdArea");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Área", JOptionPane.ERROR_MESSAGE);
        }
        return idArea;
    }

    public static void CargarCargo(JComboBox<String> cboCargo) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_cargos() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                cboCargo.addItem(rs.getString("Descripcion"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar Cargos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String CapturarCargo(JComboBox<String> cboCargo) {
        String idCargo = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_id_cargo(?) }")) {
            cstmt.setString(1, cboCargo.getSelectedItem().toString());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                idCargo = rs.getString("IdCargo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Cargo", JOptionPane.ERROR_MESSAGE);
        }
        return idCargo;
    }

    /*
    public static void CargarCombos(JComboBox cboArea, JComboBox cboCargo) {
        PreparedStatement pstmtArea = null;
        PreparedStatement pstmtCargo = null;
        ResultSet rsAreas = null;
        ResultSet rsCargos = null;

        // Mapas para almacenar los IDs
        Map<String, String> areaMap = new HashMap<>();
        Map<String, String> cargoMap = new HashMap<>();

        try {
            // Preparamos las consultas
            pstmtArea = conn.prepareStatement("CALL listar_empleados_areas()");
            pstmtCargo = conn.prepareStatement("CALL listar_empleados_cargos()");

            // Las ejecutamos
            rsAreas = pstmtArea.executeQuery();
            rsCargos = pstmtCargo.executeQuery();

            // Agregamos las áreas en cboArea
            while (rsAreas.next()) {
                String idArea = rsAreas.getString("IdArea");
                String nomArea = rsAreas.getString("descripcion");
                cboArea.addItem(nomArea); // Añadimos solo el nombre
                areaMap.put(nomArea, idArea); // Asociamos el nombre con el ID
            }

            // Agregamos los cargos en cboCargo
            while (rsCargos.next()) {
                String idCargo = rsCargos.getString("IdCargo");
                String nomCargo = rsCargos.getString("Descripcion");
                cboCargo.addItem(nomCargo); // Añadimos solo el nombre
                cargoMap.put(nomCargo, idCargo); // Asociamos el nombre con el ID
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
    }*/
    // Listar datos
    public static void Listar(DefaultTableModel modelo) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("CALL listar_emple()");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("Id"),
                    rs.getString("Apellidos"),
                    rs.getString("Nombres"),
                    rs.getString("FechaNacimiento"),
                    rs.getString("Correo"),
                    rs.getString("Dni"),
                    rs.getString("Celular"),
                    rs.getString("Distrito"),
                    rs.getString("Direccion"),
                    rs.getString("Area"),
                    rs.getString("Cargo"),
                    rs.getString("TipoEmpleado")};
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

    // Método para capturar el ID del tipo de empleado desde los RadioButtons
    public static String CapturarTipoEmpleado(ButtonGroup opciones) {
        String idTipoEmpleado = "";

        ButtonModel selectedRadioButton = opciones.getSelection();
        if (selectedRadioButton != null) {
            String tipoEmpleado = selectedRadioButton.getActionCommand();

            // Aquí defines el mapping de tipo a ID según tu lógica
            switch (tipoEmpleado) {
                case "Practicante":
                    idTipoEmpleado = "1";
                    break;
                case "completo":
                    idTipoEmpleado = "2";
                    break;
                case "Partime":
                    idTipoEmpleado = "3";
                    break;

                default:
                    // o puedes lanzar un error
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de empleado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        return idTipoEmpleado;
    }

    // Insertar datos
    // Insertar datos
    public static void Insertar(Empleados empleado, JTable tabla, JComboBox<String> cboArea, JComboBox<String> cboCargo) {
        CallableStatement cstmt = null;
        try {
            // Obtener los IDs de los combo boxes de Área y Cargo
            String idArea = CapturarArea(cboArea);
            String idCargo = CapturarCargo(cboCargo);

            // Comprobar que los IDs no estén vacíos
            if (idArea.isEmpty() || idCargo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un área y un cargo válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si no se han seleccionado correctamente
            }

            // Preparar la llamada al procedimiento almacenado
            cstmt = conn.prepareCall("{ CALL insertar_datos_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");

            // Extraer los datos del objeto empleado
            String codigoEmpleado = empleado.getId();
            int idEmpleado = Integer.parseInt(codigoEmpleado.replace("E", ""));

            // Setear los parámetros para el procedimiento
            cstmt.setInt(1, idEmpleado);
            cstmt.setString(2, empleado.getApellidos());
            cstmt.setString(3, empleado.getNombres());
            cstmt.setString(4, empleado.getfNacimiento());
            cstmt.setString(5, empleado.getCorreo());
            cstmt.setString(6, empleado.getDni());
            cstmt.setString(7, empleado.getCelular());
            cstmt.setString(8, empleado.getDistrito());
            cstmt.setString(9, empleado.getDireccion());
            cstmt.setString(10, idArea);  // Usar el ID de Área
            cstmt.setString(11, idCargo); // Usar el ID de Cargo
            cstmt.setString(12, empleado.getIdTipo());

            // Ejecutar la inserción
            cstmt.execute();
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

    public static void Editar(Container contenedor, JTable tabla, JTextField[] camposTexto, JComboBox[] combos, ButtonGroup grupoBotones) {
    // Obtener la fila seleccionada
    int fila = tabla.getSelectedRow();
    if (fila >= 0) {
        DatosEmpleados.Habilitar(contenedor, grupoBotones, true);
        tabla.clearSelection();
        tabla.setRowSelectionAllowed(false);

        // Llenar los campos de texto con los valores de la fila
        for (int i = 0; i < camposTexto.length; i++) {
            Object valor = tabla.getModel().getValueAt(fila, i);
            String dato = (valor != null) ? valor.toString() : "";
            camposTexto[i].setText(dato);
        }

        camposTexto[0].setEnabled(false);
        camposTexto[1].requestFocus();

        // Seleccionar las opciones de los combos
        for (int i = 0; i < combos.length; i++) {
            combos[i].setSelectedItem(tabla.getModel().getValueAt(fila, camposTexto.length + i).toString());
        }

        // Obtener el valor del tipo de empleado desde la tabla
        Object tipoEmpleadoObj = tabla.getModel().getValueAt(fila, camposTexto.length + combos.length);
        String tipoEmpleado = (tipoEmpleadoObj != null) ? tipoEmpleadoObj.toString().trim() : "";

        // Seleccionar el radio button correspondiente
        for (Enumeration<AbstractButton> botones = grupoBotones.getElements(); botones.hasMoreElements();) {
            AbstractButton boton = botones.nextElement();
            // Comparar ignorando mayúsculas/minúsculas y espacios
            if (boton.getText().trim().equalsIgnoreCase(tipoEmpleado)) {
                boton.setSelected(true);
                break;
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}
    // Actualizar datos

    public static void Actualizar(Empleados empleados, JTable tabla) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL actualizar_datos_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setString(1, empleados.getId());
            cstmt.setString(2, empleados.getApellidos());
            cstmt.setString(3, empleados.getNombres());
            cstmt.setString(4, empleados.getfNacimiento());
            cstmt.setString(5, empleados.getCorreo());
            cstmt.setString(6, empleados.getDni());
            cstmt.setString(7, empleados.getCelular());
            cstmt.setString(8, empleados.getDistrito());
            cstmt.setString(9, empleados.getDireccion());
            cstmt.setString(10, empleados.getIdArea());
            cstmt.setString(11, empleados.getIdCargo());
            cstmt.setString(12, empleados.getIdTipo());

            cstmt.execute(); // se actualiza los datos en la BD

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

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
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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

    // Validar campos
    /*public static boolean Validar(JTextField[] campos) {
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                campo.requestFocus();
                return false;
            }
        }

        if (!campos[3].getText().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "El formato de correo es el siguiente: someone@mail.com\nInténtelo de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            campos[3].requestFocus();
            return false;
        }

        if (campos[4].getText().length() != 8) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener 8 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            campos[4].requestFocus();
            return false;
        }

        if (campos[5].getText().length() != 9) {
            JOptionPane.showMessageDialog(null, "El celular debe contener 9 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            campos[5].requestFocus();
            return false;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(campos[2].getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "El formato de la fecha es el siguiente: dd/mm/aaaa. Inténtelo de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            campos[2].requestFocus();
            return false;
        }

        // Si se llega aquí, todos los campos son válidos
        return true;
    }*/
    // Obtener datos académicos del empleado
    public static String[] DatAcadEmpleado(String dni) {
        String[] datos = new String[5];
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = conn.prepareCall("{ CALL obtener_datos_academicos(?) }");
            cstmt.setString(1, dni);
            rs = cstmt.executeQuery();

            if (rs.next()) {
                datos[0] = rs.getString("Institucion");
                datos[1] = rs.getString("Facultad");
                datos[2] = rs.getString("Carrera");
                datos[3] = rs.getString("Ciclo");
                datos[4] = rs.getString("Codigo");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al cargar datos", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return datos;
    }

    public static String GenerarCodigo(String tabla, String campoId, String prefijo, int longitud) {
        CallableStatement cstmt = null;
        String codigo_generado = "";
        try {
            cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?, ?) }");
            cstmt.setString(1, tabla);
            cstmt.setString(2, campoId);
            cstmt.setString(3, prefijo);
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
