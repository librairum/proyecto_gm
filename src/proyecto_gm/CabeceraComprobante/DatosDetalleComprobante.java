
package proyecto_gm.CabeceraComprobante;
import java.sql.CallableStatement;
import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import proyecto_gm.ConexionBD;


public class DatosDetalleComprobante {
    static Connection conn = ConexionBD.getConnection();
    
    // Limpiar campos
    public static void Limpiar(Container contenedor) {
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
    }
    
   
    
    // Habilitar o bloquear campos y botones
    public static void Habilitar(Container contenedor,  boolean bloquear) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField jTextField) {
                jTextField.setEnabled(bloquear);
            } else if (component instanceof JComboBox jComboBox) {
                jComboBox.setEnabled(bloquear);
            } else if (component instanceof JButton jButton) {
                String button = jButton.getName();
                if (button.equals("guardar") || button.equals("deshacer")) {
                    jButton.setEnabled(bloquear);
                } else if (button.equals("agregar") || button.equals("editar") || button.equals("eliminar"))  {
                    jButton.setEnabled(!bloquear); // aplicar logica inversa
                }
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }
    
    // Cargar opciones para los combo boxes
    public static void CargarCombo(JComboBox cboNumeroComprobante ) {
        try {
            // Preparamos la consultas
            PreparedStatement pstmtNumeroComprobante = conn.prepareStatement("SELECT NumeroComprobante FROM cabeceracomprobante");

            // Las ejecutamos
            ResultSet numerocomprobante = pstmtNumeroComprobante.executeQuery();

            // Agregamos los provedores
            while (numerocomprobante.next()) {
                String nomProveedores = numerocomprobante.getString("NumeroComprobante");
                cboNumeroComprobante.addItem(nomProveedores);
            }
           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Mostrar datos
    public static void Mostrar(DefaultTableModel modelo) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("CALL listar_detallecomprobante()");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString("Id"), rs.getString("Cantidad"), rs.getString("Descripcion"),
                     rs.getString("Precio Unitario"), rs.getString("Sub Total"),
                rs.getString("Igv"), rs.getString("Numero de Comprobante")};
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Capturar las opciones del combo box 
    public static String Capturar(JComboBox cboNumeroComprobante) {
        String idCabeceraComprobante = "";
        try {
            // Capturar las opciones seleccionadas en los combo boxes
            String selectcabeceracomprobante = cboNumeroComprobante.getSelectedItem().toString();

            // Obtener los id de modulo
            String consulta = "SELECT NumeroComprobante AS xNumeroComporbante "
                    + "FROM cabeceracomprobante "
                  + "WHERE NumeroComprobante = ? ";
            PreparedStatement pstmt = conn.prepareStatement(consulta);
            pstmt.setString(1, selectcabeceracomprobante);
            
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                idCabeceraComprobante = rs.getString("xNumeroComporbante");   
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Opciones", JOptionPane.ERROR_MESSAGE);
        }

        return idCabeceraComprobante;
    }
    
    // Insertar datos
    public static void Insertar(DetalleComprobante det, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_detallecomprobante(?, ?, ?, ?, ?, ?, ?) }");
            
            cstmt.setString(1, det.getId());
            cstmt.setString(2, det.getCantidad());
            cstmt.setString(3, det.getDescripcion());
            cstmt.setFloat(4, det.getPrecioUnitario());
            cstmt.setFloat(5, det.getSubTotal());
            cstmt.setFloat(6, det.getIgv());
            cstmt.setString(7, det.getNumeroComprobante());
            cstmt.execute(); // se inserta los datos a la BD

            
            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosDetalleComprobante.Mostrar(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    // Boton editar
    public static void Editar(Container contenedor, JTable tabla, JTextField[] camposTexto, JComboBox[] combos) {
        

        // Obtener la fila seleccionada
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            // Obtener los valores de la fila seleccionada
            DatosDetalleComprobante.Habilitar(contenedor, true);
            tabla.clearSelection();
            // Deshabilitamos la seleccion de filas de la tabla
            tabla.setRowSelectionAllowed(false);
            // Llenar los campos de texto con los valores de la fila
            for (int i = 0; i < camposTexto.length; i++) {
                if (tabla.getValueAt(filaSeleccionada, i) != null) {
                    String dato= tabla.getModel().getValueAt(filaSeleccionada, i).toString();
                    camposTexto[i].setText(dato);
                } else {
                    camposTexto[i].setText("");
                }
            }

            camposTexto[0].setEnabled(false);
            camposTexto[1].requestFocus();

            // Llenar los combos con los valores de la fila
            for (int i = 0; i < combos.length; i++) {
                combos[i].setSelectedItem(tabla.getModel().getValueAt(filaSeleccionada, camposTexto.length + i).toString());
                break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
            
            // Habilitamos la seleccion de fila(s) en la tabla
            tabla.setRowSelectionAllowed(true);
        }
    }
    
    // Actualizar datos

    public static void Actualizar(DetalleComprobante det, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_detallecomprobante(?, ?, ?, ?, ?, ?, ?) }");
            
            
            cstmt.setString(1, det.getId());
            
            cstmt.setString(2, det.getCantidad());
            cstmt.setString(3, det.getDescripcion());
            cstmt.setFloat(4, det.getPrecioUnitario());
            cstmt.setFloat(5, det.getSubTotal());
            cstmt.setFloat(6, det.getIgv());
            cstmt.setString(7, det.getNumeroComprobante());

       
                cstmt.execute(); // se actualiza los datos en la BD

                // Actualizamos la tabla
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0);

                DatosDetalleComprobante.Mostrar(modelo);
            

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
                    CallableStatement stmt = conn.prepareCall("{ CALL eliminar_detallecomprobante(?) }");
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
    


