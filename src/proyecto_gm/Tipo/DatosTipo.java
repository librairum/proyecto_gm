package proyecto_gm.Tipo;
import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;


public class DatosTipo {
        static Connection conn = ConexionBD.getConnection();

    
    public static void Limpiar(Container contenedor){
        for (Component componente: contenedor.getComponents()){
            if(componente instanceof JTextField){
                ((JTextField) componente).setText("");
            }else if ( componente instanceof Container){
                Limpiar((Container)componente);
            }
        }  
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
    
    // Habilitar o bloquear campos y botones
    public static void Habilitar(Container contenedor,  boolean bloquear) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField jTextField) {
                jTextField.setEnabled(bloquear);
            
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
    
    public static void Mostrar(DefaultTableModel modelo) {
        try {
            PreparedStatement ate = conn.prepareStatement("CALL listar_tipoempleado()");
            ResultSet rs= ate.executeQuery();
            while (rs.next()) {                
                Object[] row = new Object[]{
                    rs.getString("Id"), rs.getString("Descripcion")
                };
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Insertar(Tipo tip,JTable tabla) {
        try {
            PreparedStatement ate = conn.prepareStatement("{CALL insertar_tipoempleado (?,?)}");
            ate.setString(1, tip.getId());
            ate.setString(2, tip.getDescripcion());
            ate.executeUpdate();
            
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            Object[] rowData = {tip.getId(), tip.getDescripcion()};
            modelo.addRow(rowData);
            // Actualiza la vista del JTable con el modelo de tabla actualizado
            tabla.setModel(modelo);
            ate.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void Actualizar(Tipo tip, JTable tabla){
        try { 
            CallableStatement ate = conn.prepareCall("{CALL actualizar_tipoempleado (?,?)}");
            //defino los parametros de la bd para ser actualizado mediante el id
            ate.setString(1, tip.Id);
            ate.setString(2, tip.Descripcion);
            ate.executeUpdate();
            // Actualizamos la tabla
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0);

                DatosTipo.Mostrar(modelo);
          
            ate.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
                    CallableStatement stmt = conn.prepareCall("{ CALL eliminar_tipoempleado(?) }");
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
      
    public static boolean Editar(Container contenedor,  JTable tabla, JTextField [] cod){
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            DatosTipo.Habilitar(contenedor, true);
            tabla.clearSelection();
            tabla.setRowSelectionAllowed(false);
            for (int i = 0; i < cod.length; i++) {
                
                String dato= tabla.getModel().getValueAt(fila, i).toString();
                cod[i].setText(dato);
            }
            cod[0].setEnabled(false);
            cod[1].requestFocus();
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"No seleciono una fila" );
            return false;
        }
    }
}
