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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
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
import proyecto_gm.Area.Area;
import proyecto_gm.Cargo.Cargo;
import proyecto_gm.ConexionBD;
import proyecto_gm.Utilitario;

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
    public static List<Area> listaAreas() {
        List<Area> lista = new ArrayList<>();
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL listar_areas() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IdArea");
                String descripcion = rs.getString("descripcion");
                lista.add(new Area(id, descripcion));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar Áreas", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public static String CapturarArea(JComboBox<Area> cboArea) {
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

    public static List<Cargo> listaCargo() {
        List<Cargo> lista = new ArrayList<>();
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL listar_cargos }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idCargo");
                String descripcion = rs.getString("descripcion");
                lista.add(new Cargo(id, descripcion));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar Cargos", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public static String CapturarCargo(JComboBox<Cargo> cboCargo) {
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

    // Listar datos
    public static void Listar(DefaultTableModel modelo) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("CALL listar_emple()");
            // 
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("Id"), // 0
                    rs.getString("Apellidos"), // 1
                    rs.getString("Nombres"), // 2
                    rs.getString("FechaNacimiento"), //3
                    rs.getString("Correo"), //4
                    rs.getString("Dni"), // 5
                    rs.getString("Celular"), // 6
                    rs.getString("Distrito"), // 7
                    rs.getString("Direccion"), // 8
                    rs.getString("IdArea"), // 9
                    rs.getString("Area"), // 10
                    rs.getString("IdCargo"), //11
                    rs.getString("Cargo"), // 12 
                    rs.getString("TipoEmpleado") // 13
                };
                modelo.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                /* manejar error */ }
            if (pstmt != null) try {
                pstmt.close();
            } catch (SQLException e) {
                /* manejar error */ }
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
    //insertar 13/07/2025
    public static void Insertar(Empleados empleado){
        
        CallableStatement cstmt = null;
        try{
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
            cstmt.setInt(10, empleado.getIdArea());  // Usar el ID de Área
            cstmt.setInt(11, empleado.getIdCargo()); // Usar el ID de Cargo
            cstmt.setInt(12, empleado.getIdTipo() ); // id tipo empleado

            // Ejecutar la inserción
            cstmt.execute();
             Utilitario.MostrarMensaje("Insercion exitosa", Utilitario.TipoMensaje.informativo);
         } catch (SQLException e) {
             Utilitario.MostrarMensaje("Error "+e.getMessage(), Utilitario.TipoMensaje.error);
            
        } finally {
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    Utilitario.MostrarMensaje("Error " + e.getMessage(), Utilitario.TipoMensaje.error);
                }
            }
        }
    }
    public static void Eliminar(String idEmpleado ){
        CallableStatement cstmt = null;
        try{
         cstmt = conn.prepareCall("{ CALL eliminar_empleados(?) }");
                    cstmt.setString(1, idEmpleado);
                    cstmt.execute();
        }catch(SQLException ex){
            Utilitario.MostrarMensaje("Error al eliminar "+ex.getMessage(), Utilitario.TipoMensaje.error);
        }
    }
    public static void Actualizar(Empleados empleado){
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL actualizar_datos_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setString(1, empleado.getId());
            cstmt.setString(2, empleado.getApellidos());
            cstmt.setString(3, empleado.getNombres());
            cstmt.setString(4, empleado.getfNacimiento());
            cstmt.setString(5, empleado.getCorreo());
            cstmt.setString(6, empleado.getDni());
            cstmt.setString(7, empleado.getCelular());
            cstmt.setString(8, empleado.getDistrito());
            cstmt.setString(9, empleado.getDireccion());
            cstmt.setInt(10, empleado.getIdArea());
            cstmt.setInt(11, empleado.getIdCargo());
            cstmt.setInt(12, empleado.getIdTipo());

            cstmt.execute(); // se actualiza los datos en la BD

            // Mostrar mensaje de éxito
            //JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            Utilitario.MostrarMensaje("Actualizacion exitos", Utilitario.TipoMensaje.informativo);
            // Actualizamos la tabla
//            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
//            modelo.setRowCount(0);
//            DatosEmpleados.Listar(modelo);

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Utilitario.MostrarMensaje("Error:"+e.getMessage(), Utilitario.TipoMensaje.informativo);
        } finally {
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    //JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    Utilitario.MostrarMensaje("Error:"+e.getMessage(), Utilitario.TipoMensaje.informativo);
                }
            }
        }
    }
    // Insertar datos
    public static void Insertar(Empleados empleado, JTable tabla, JComboBox<Area> cboArea, JComboBox<Cargo> cboCargo) {
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
            cstmt.setInt(10, Integer.parseInt(idArea));  // Usar el ID de Área
            cstmt.setInt(11, Integer.parseInt(idCargo)); // Usar el ID de Cargo
            cstmt.setInt(12, Integer.parseInt(idCargo));

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

    public static void Editar(Container contenedor, JTable tabla, 
            JTextField[] camposTexto, JComboBox[] combos, ButtonGroup grupoBotones) {
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
            cstmt.setInt(10, empleados.getIdArea());
            cstmt.setInt(11, empleados.getIdCargo());
            cstmt.setInt(12, empleados.getIdTipo());

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
                int opcion = JOptionPane.showOptionDialog(null,
                        "¿Está seguro de que quiere eliminar la fila seleccionada?", 
                        "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, 
                        options, options[2]);
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
            cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?) }");
            cstmt.setString(1, tabla);
            cstmt.setString(2, campoId);
            cstmt.registerOutParameter(3, Types.VARCHAR);
            cstmt.execute();

            codigo_generado = cstmt.getString(3);
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
