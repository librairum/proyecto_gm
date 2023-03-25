/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Empleado;

import java.awt.Component;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import proyecto_gm.ConexionBD;

/**
 *
 * @author jeanv
 */
public class DatosEmpleados {

    static Connection conn = ConexionBD.getConnection();

    // Limpiar campos
    public static void LimpiarCampos(JDesktopPane desktopPane, JRadioButton porDefecto) {
        Component[] components = desktopPane.getComponents();
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

    // Bloquear campos
    public static void BloquearCampos(JDesktopPane desktopPane, ButtonGroup opciones) {
        Component[] components = desktopPane.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField jTextField) {
                jTextField.setEnabled(false);
            } else if (component instanceof JComboBox jComboBox) {
                jComboBox.setEnabled(false);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
        for (Enumeration<AbstractButton> buttons = opciones.getElements(); buttons.hasMoreElements();) {
            buttons.nextElement().setEnabled(false);
        }

    }

    // Habilitar campos
    public static void HabilitarCampos(JDesktopPane desktopPane, ButtonGroup opciones) {
        Component[] components = desktopPane.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField jTextField) {
                jTextField.setEnabled(true);
            } else if (component instanceof JComboBox jComboBox) {
                jComboBox.setEnabled(true);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
        for (Enumeration<AbstractButton> buttons = opciones.getElements(); buttons.hasMoreElements();) {
            buttons.nextElement().setEnabled(true);
        }

    }

    // Cargar opciones para los combo boxes
    public static void CargarCombos(JComboBox cboArea, JComboBox cboCargo) {
        try {
            // Preparamos la consultas
            PreparedStatement pstmtArea = conn.prepareStatement("SELECT Descripcion FROM areas");
            PreparedStatement pstmtCargo = conn.prepareStatement("SELECT Descripcion FROM cargos");

            // Las ejecutamos
            ResultSet areas = pstmtArea.executeQuery();
            ResultSet cargos = pstmtCargo.executeQuery();

            // Agregamos las areas en cbxArea
            while (areas.next()) {
                String nomArea = areas.getString("Descripcion");
                cboArea.addItem(nomArea);
            }

            // Agregamos los cargos a cbxCargo
            while (cargos.next()) {
                String nomCargo = cargos.getString("Descripcion");
                cboCargo.addItem(nomCargo);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Mostrar datos
    public static void MostrarDatos(DefaultTableModel modelo) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("CALL listar_emple()");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString("Id"), rs.getString("Apellidos"),
                    rs.getString("Nombres"), rs.getString("FechaNacimiento"), rs.getString("Correo"),
                    rs.getString("Dni"), rs.getString("Celular"), rs.getString("Direccion"),
                    rs.getString("Area"), rs.getString("Cargo"), rs.getString("Tip. Empleado")};
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Capturar las opciones de los radio buttons y de los combo boxes
    public static String[] CapturarOpciones(JComboBox cbxArea, JComboBox cbxCargo, ButtonGroup opciones) {
        String[] ids = new String[3];
        String idArea = "", idCargo = "", idTipoEmpleado = "";
        try {
            // Capturar las opciones seleccionadas en los combo boxes
            String selectArea = cbxArea.getSelectedItem().toString();
            String selectCargo = cbxCargo.getSelectedItem().toString();

            // Capturar la opcion seleccionada de los radio buttons (tipo empleado)
            ButtonModel selectedRadioButton = opciones.getSelection();
            String tipoEmpleado = selectedRadioButton.getActionCommand();

            // Obtener los id de las elecciones en area, cargo y tipo de empleado
            String consulta = "SELECT a.Id AS Id_area, c.Id AS Id_cargo, t.Id AS Id_tipo "
                    + "FROM areas a, cargos c, tiposempleados t "
                    + "WHERE a.Descripcion = ? AND c.Descripcion = ? AND t.Descripcion = ?";
            PreparedStatement pstmt = conn.prepareStatement(consulta);
            pstmt.setString(1, selectArea);
            pstmt.setString(2, selectCargo);
            pstmt.setString(3, tipoEmpleado);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                idArea = rs.getString("Id_area");
                idCargo = rs.getString("Id_cargo");
                idTipoEmpleado = rs.getString("Id_tipo");
            }

            ids[0] = idArea;
            ids[1] = idCargo;
            ids[2] = idTipoEmpleado;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Opciones", JOptionPane.ERROR_MESSAGE);
        }

        return ids;
    }

    // Insertar datos
    public static void InsertarDatos(Empleados empleado, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_datos_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
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

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosEmpleados.MostrarDatos(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Obtener datos de una fila seleccionada
    private static Object[] ObtenerValoresFila(int filaSeleccionada, JTable tabla) {
        // Obtener el modelo de la tabla
        TableModel modelo = tabla.getModel();

        // Obtener el número de columnas de la tabla
        int numColumnas = modelo.getColumnCount();

        // Crear un arreglo de objetos para almacenar los valores de la fila
        Object[] valoresFila = new Object[numColumnas];

        // Obtener los valores de la fila seleccionada y guardarlos en el arreglo
        for (int i = 0; i < numColumnas; i++) {
            valoresFila[i] = modelo.getValueAt(filaSeleccionada, i);
        }

        return valoresFila;
    }

    // Boton Editar
    public static void Editar(JTable tabla, JTextField[] camposTexto, JComboBox[] combos, ButtonGroup grupoBotones) {
        // Bloqueamos lo siguientes botones del formulario:
        frmEmpleado.btnNuevo.setEnabled(false);
        frmEmpleado.btnEliminar.setEnabled(false);
        // Habilitamos lo siguientes botontes del formulario:
        frmEmpleado.btnGuardar.setEnabled(true);
        frmEmpleado.btnCancelar.setEnabled(true);
        // Deshabilitamos la seleccion de filas de la tabla
        tabla.setRowSelectionAllowed(false);

        // Obtener la fila seleccionada
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener los valores de la fila seleccionada
            Object[] valoresFila = ObtenerValoresFila(filaSeleccionada, tabla); // Usamos el método para obtener los valores de la fila seleccionada de la tabla

            // Llenar los campos de texto con los valores de la fila
            for (int i = 0; i < camposTexto.length; i++) {
                if (valoresFila[i] != null) {
                    camposTexto[i].setText(valoresFila[i].toString());
                } else {
                    camposTexto[i].setText("");
                }

            }

            camposTexto[0].setEnabled(false);
            camposTexto[1].requestFocus();

            // Llenar los combos con los valores de la fila
            for (int i = 0; i < combos.length; i++) {
                combos[i].setSelectedItem(valoresFila[camposTexto.length + i].toString());
            }

            // Llenar el grupo de botones con los valores de la fila
            for (Enumeration<AbstractButton> botones = grupoBotones.getElements(); botones.hasMoreElements();) {
                AbstractButton boton = botones.nextElement();
                if (boton.getText().equals(valoresFila[camposTexto.length + combos.length].toString())) {
                    boton.setSelected(true);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");

            // Habilitamos lo siguientes botones del formulario:
            frmEmpleado.btnNuevo.setEnabled(true);
            frmEmpleado.btnEliminar.setEnabled(true);
            // Bloqueamos lo siguientes botontes del formulario:
            frmEmpleado.btnGuardar.setEnabled(false);
            frmEmpleado.btnCancelar.setEnabled(false);

            // Habilitamos la seleccion de fila(s) en la tabla
            tabla.setRowSelectionAllowed(true);
        }
    }
    // Actualizar datos

    public static void ActualizarDatos(Empleados empleado, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_datos_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
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

            String[] options = {"Sí", "No", "Cancelar"};
            int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que quiere actualizar la fila seleccionada?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

            if (opcion == JOptionPane.YES_OPTION) {
                cstmt.execute(); // se actualiza los datos en la BD

                // Actualizamos la tabla
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0);

                DatosEmpleados.MostrarDatos(modelo);
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
                    CallableStatement stmt = conn.prepareCall("{ CALL eliminar_empleados(?) }");
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

    // Boton registrar datos academicos
    // Debemos capturar el nombre completo y el dni de la fila seleccionada
    public static boolean ObtenerEmpleado(JTable tabla) {
        // Obtener el indice de la fila seleccionada
        boolean correcto = true;
        int fila = tabla.getSelectedRow();
        String nombreCompleto = "", dni = "";

        if (fila >= 0) {
            // Obtener los valores de la fila seleccionada
            Object[] valoresFila = ObtenerValoresFila(fila, tabla);
            nombreCompleto = valoresFila[2].toString() + " " + valoresFila[1].toString();
            dni = valoresFila[5].toString();

            Datosacad.txtNomCom.setText(nombreCompleto);
            Datosacad.txtDni.setText(dni);
        } else {
            correcto = false;
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para registrar sus datos académicos.");
        }

        return correcto;
    }

    // Validar campos
    public static boolean ValidarCampos(Empleados emp) {
        boolean validar = true;
        String[] campos = {emp.getId(), emp.getApellidos(), emp.getNombres(), emp.getfNacimiento(),
            emp.getCorreo(), emp.getDni(), emp.getCelular(), emp.getDireccion()
        };

        // Validamos si los campos estan vacios
        for (String campo : campos) {
            if (campo.equals("")) {
                validar = false;
            }
        }

        if (!validar) {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.");
        }

        // Validamos uno por uno
        // Validamos ID:
        if (!emp.getId().matches("^[A-Z]{2}[0-9]{2}$") || emp.getId().length() != 4) {
            validar = false;
            JOptionPane.showMessageDialog(null, "El formato del ID es el siguiente: AA00. Inténtelo de nuevo.");
        }

        // Validamos fecha
        // Verificar que el string tenga longitud 10
        if (emp.getfNacimiento().length() == 10) {
            // Definir el formato de fecha
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false); // no permitir fechas inválidas

            try {
                // Intentar parsear el string como una fecha
                sdf.parse(emp.getfNacimiento());
                validar = true;
            } catch (ParseException e) {
                validar = false;
                JOptionPane.showMessageDialog(null, "El formato de la fecha es el siguiente: dd-mm-aaaa. Inténtelo de nuevo.");
            }

        } else {
            validar = false;
            JOptionPane.showMessageDialog(null, "El formato de la fecha es el siguiente: dd-mm-aaaa. Inténtelo de nuevo.");
        }

        // Validamos correo
        // Expresión regular para validar el formato de un correo electrónico
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        if (!emp.getCorreo().matches(regex)) {
            validar = false;
            JOptionPane.showMessageDialog(null, "El formato de correo es el siguiente: someone@mail.com\nInténtelo de nuevo.");
        }

        // Validamos el dni
        if (emp.getDni().length() != 8) {
            JOptionPane.showMessageDialog(null, "El DNI debe contener 8 dígitos.");
        }

        // Validamos el celular
        if (emp.getCelular().length() != 9) {
            JOptionPane.showMessageDialog(null, "El celular debe contener 9 dígitos.");
        }

        return validar;
    }
    
    

//    public void exportarExcel(JTable t) throws IOException {
//        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de exce", "xls");
//        chooser.setFileFilter(filter);
//        chooser.setDialogTitle("Guardar archivo");
//        chooser.setAcceptAllFileFilterUsed(false);
//        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
//            String ruta = chooser.getSelectedFile().toString().concat(".xls");
//            try {
//                File archivoXLS = new File(ruta);
//                if (archivoXLS.exists()) {
//                    archivoXLS.delete();
//                }
//                archivoXLS.createNewFile();
//                Workbook libro = new HSSFWorkbook();
//                FileOutputStream archivo = new FileOutputStream(archivoXLS);
//                Sheet hoja = libro.createSheet("Datos");
//                hoja.setDisplayGridlines(false);
//                for (int f = 0; f < t.getColumnCount(); f++) {
//                    Row fila = hoja.createRow(f);
//                    for (int c = 0; c < t.getColumnCount(); c++) {
//                        Cell celda = fila.createCell(c);
//                        if (f == 0) {
//                            celda.setCellValue(t.getColumnName(c));
//                        }
//                    }
//                }
//                int filaInicio = 1;
//                for (int f = 0; f < t.getRowCount(); f++) {
//                    Row fila = hoja.createRow(filaInicio);
//                    filaInicio++;
//                    for (int c = 0; c < t.getColumnCount(); c++) {
//                        Cell celda = fila.createCell(c);
//                        if (t.getValueAt(f, c) instanceof Double) {
//                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
//                        } else if (t.getValueAt(f, c) instanceof Float) {
//                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
//                        } else {
//                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
//                        }
//                    }
//                }
//                libro.write(archivo);
//                archivo.close();
//                Desktop.getDesktop().open(archivoXLS);
//            } catch (IOException | NumberFormatException e) {
//                throw e;
//            }
//        }
    }
