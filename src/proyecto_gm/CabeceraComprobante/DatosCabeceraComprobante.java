package proyecto_gm.CabeceraComprobante;

import java.awt.Component;
import java.sql.Connection;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyecto_gm.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.TableModel;

public class DatosCabeceraComprobante {
    static Connection conn = ConexionBD.getConnection();
    
// Limpiar campos
    public static void Limpiar(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField jTextField) {
                jTextField.setText("");
            } else if (component instanceof JComboBox jComboBox) {
                jComboBox.setSelectedIndex(0);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }
    public static void Bloquear(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField jTextField) {
                jTextField.setEnabled(false);
            } else if (component instanceof JComboBox jComboBox) {
                jComboBox.setEnabled(false);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }
    // Habilitar campos
    public static void Habilitar(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField jTextField) {
                jTextField.setEnabled(true);
            } else if (component instanceof JComboBox jComboBox) {
                jComboBox.setEnabled(true);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }
    // Cargar opciones para los combo boxes
    public static void CargarCombo(JComboBox cboProveedores,JComboBox cboTipoDocumento ) {
        try {
            // Preparamos la consultas
            PreparedStatement pstmtProveedores = conn.prepareStatement("SELECT Nombres FROM proveedores");
            PreparedStatement pstmtTipoDocumento = conn.prepareStatement("SELECT Descripcion FROM tiposdocumentos");

            // Las ejecutamos
            ResultSet proveedores = pstmtProveedores.executeQuery();
            ResultSet tiposdocumentos = pstmtTipoDocumento.executeQuery();

            // Agregamos los provedores
            while (proveedores.next()) {
                String nomProveedores = proveedores.getString("Nombres");
                cboProveedores.addItem(nomProveedores);
            }
            // Agregamos los Tipo doc
            while (tiposdocumentos.next()) {
                String nomTiposDocumentos = tiposdocumentos.getString("Descripcion");
                cboTipoDocumento.addItem(nomTiposDocumentos);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Mostrar datos
    public static void Mostrar(DefaultTableModel modelo) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("CALL listar_cabeceracomprobante()");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString("Numero de Factura"), rs.getString("Fecha de Emision"),
                    rs.getString("Fecha de Vencimiento"), rs.getString("Total"), rs.getString("Proveedores"),
                rs.getString("Tipo de Documento")};
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
       // Capturar las opciones de los combo boxes
    public static String[] Capturar(JComboBox cboProveedores,JComboBox cboTipoDocumento) {
        String[] ids = new String[2];
        String idProveedores = "", idTiposDocumentos = "";
        try {
            // Capturar las opciones seleccionadas en los combo boxes
            String selectproveedores = cboProveedores.getSelectedItem().toString();
            String selectiposdocumentos = cboTipoDocumento.getSelectedItem().toString();

            // Obtener los id de las elecciones en area, cargo y tipo de empleado
            String consulta = "SELECT P.Id AS IdProveedores, T.Id AS IdTipoDocumento "
                    + "FROM proveedores P, tiposdocumentos T "
                    + "WHERE P.Nombres = ? AND T.Descripcion = ? ";
            PreparedStatement pstmt = conn.prepareStatement(consulta);
            
            pstmt.setString(1, selectproveedores);
            pstmt.setString(2, selectiposdocumentos);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                idProveedores = rs.getString("IdProveedores");
                idTiposDocumentos = rs.getString("IdTipoDocumento");
            }

            ids[0] = idProveedores;
            ids[1] = idTiposDocumentos;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Opciones", JOptionPane.ERROR_MESSAGE);
        }

        return ids;
        }

    public static void Insertar(CabeceraComprobante cab, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_cabeceracomprobante(?, ?, ?, ?, ?, ?) }");
            
            cstmt.setString(1, cab.getNumeroFactura());
            cstmt.setString(2, cab.getFechaEmision());
            cstmt.setString(3, cab.getFechaVencimiento());
            cstmt.setFloat(4, cab.getTotal());
            cstmt.setString(5, cab.getIdProveedores());
            cstmt.setString(6, cab.getIdTipoDocumento());
           

            cstmt.execute(); // se inserta los datos a la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosCabeceraComprobante.Mostrar(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Obtener datos de una fila seleccionada
    private static Object[] obtenerValoresFila(int filaSeleccionada, JTable tabla) {
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
    // Boton editar
    public static void Editar(JTable tabla, JTextField[] camposTexto, JComboBox[] combos) {
        
        // Deshabilitamos la seleccion de filas de la tabla
        tabla.setRowSelectionAllowed(false);

        // Obtener la fila seleccionada
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener los valores de la fila seleccionada
            Object[] valoresFila = obtenerValoresFila(filaSeleccionada, tabla); // Usamos el método para obtener los valores de la fila seleccionada de la tabla

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
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
            
            // Habilitamos la seleccion de fila(s) en la tabla
            tabla.setRowSelectionAllowed(true);
        }
    }
    
    public static void Actualizar(CabeceraComprobante cab, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_cabeceracomprobante(?, ?, ?) }");
            
            
            cstmt.setString(1, cab.getNumeroFactura());
            cstmt.setString(2, cab.getFechaEmision());
            cstmt.setString(3, cab.getFechaVencimiento());
            cstmt.setFloat(4, cab.getTotal());
            cstmt.setString(5, cab.getIdProveedores());
            cstmt.setString(6, cab.getIdTipoDocumento());

            String[] options = {"Sí", "No", "Cancelar"};
            int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que quiere actualizar la fila seleccionada?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

            if (opcion == JOptionPane.YES_OPTION) {
                cstmt.execute(); // se actualiza los datos en la BD

                // Actualizamos la tabla
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0);

                DatosCabeceraComprobante.Mostrar(modelo);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Eliminar datos
    public static void Eliminar(JTable tabla) {
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
                    CallableStatement stmt = conn.prepareCall("{ CALL eliminar_cabeceracomprobante(?) }");
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
    // Validar campos
    public static boolean ValidarCampos(CabeceraComprobante emp) {
        boolean validar = true;
        String[] campos = {emp.getNumeroFactura(), emp.getFechaEmision(), emp.getFechaVencimiento()
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
        
        // Validamos fecha vencimiento
        // Verificar que el string tenga longitud 10
        if (emp.getFechaEmision().length() == 10) {
            // Definir el formato de fecha
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false); // no permitir fechas inválidas

            try {
                // Intentar parsear el string como una fecha
                sdf.parse(emp.getFechaEmision());
                validar = true;
            } catch (ParseException e) {
                validar = false;
                JOptionPane.showMessageDialog(null, "El formato de la fecha es el siguiente: dd-mm-aaaa. Inténtelo de nuevo.");
            }

        } else {
            validar = false;
            JOptionPane.showMessageDialog(null, "El formato de la fecha es el siguiente: dd-mm-aaaa. Inténtelo de nuevo.");
        }
        
        // Validamos fecha vencimiento
        // Verificar que el string tenga longitud 10
        if (emp.getFechaVencimiento().length() == 10) {
            // Definir el formato de fecha
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false); // no permitir fechas inválidas

            try {
                // Intentar parsear el string como una fecha
                sdf.parse(emp.getFechaVencimiento());
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
//        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
//        
//        if (!emp.getCorreo().matches(regex)) {
//            validar = false;
//            JOptionPane.showMessageDialog(null, "El formato de correo es el siguiente: someone@mail.com\nInténtelo de nuevo.");
//        }
//        
        

        return validar;
    }

}
