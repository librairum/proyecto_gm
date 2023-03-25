package proyecto_gm.Proveedores;

import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import proyecto_gm.ConexionBD;

public class DatosProveedores {
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
    
    public static void Bloquear(Container contenedor){
        for (Component componente: contenedor.getComponents()){
            if(componente instanceof JTextField){
                ((JTextField)componente).setEditable(false);
            }else if( componente instanceof Container){
                Limpiar((Container)componente);
            }
        }  
    }
    // Mostrar datos
    public static void Mostrar(DefaultTableModel modelo) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("CALL listar_proveedores()");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString("Id"), rs.getString("Nombres"), rs.getString("Direccion"), 
                    rs.getString("Correo"), rs.getString("Telefono"), rs.getString("Ruc")};
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void Insertar(Proveedores pro,JTable tabla) {
        try {
            PreparedStatement ate = conn.prepareStatement("{CALL insertar_proveedores (?,?,?,?,?,?)}");
            ate.setString(1, pro.getId());
            ate.setString(2, pro.getNombres());
            ate.setString(3, pro.getDireccion());
            ate.setString(4, pro.getCorreo());
            ate.setString(5, pro.getTelefono());
            ate.setString(6, pro.getRuc());
            ate.executeUpdate();
            
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            Object[] rowData = {pro.getId(), pro.getNombres(),pro.getDireccion(), pro.getCorreo(),pro.getTelefono()
            ,pro.getRuc()};
            modelo.addRow(rowData);
            // Actualiza la vista del JTable con el modelo de tabla actualizado
            tabla.setModel(modelo);
            ate.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void Actualizar(Proveedores pro, JTable tabla){
        try { 
            CallableStatement ate = conn.prepareCall("{CALL actualizar_proveedores (?,?,?,?,?,?)}");
            //defino los parametros de la bd para ser actualizado mediante el id
            ate.setString(1, pro.Id);
            ate.setString(2, pro.Nombres);
            ate.setString(3, pro.Direccion);
            ate.setString(4, pro.Correo);
            ate.setString(5, pro.Telefono);
            ate.setString(6, pro.Ruc);
            ate.executeUpdate();
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
                int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere eliminar la fila seleccionada?");
                if (opcion == JOptionPane.YES_OPTION) {
                    // Obtener los datos de fila seleccionada
                    String id = tabla.getModel().getValueAt(fila, 0).toString(); //Se asume que el ID se encuentra en la primera columna

                    // Ejecutar el procedimiento almacenado
                    CallableStatement stmt = conn.prepareCall("{ CALL eliminar_proveedores(?) }");
                    stmt.setString(1, id);
                    stmt.execute();

                    // Actualizar el JTable
                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.removeRow(fila);
                    // JOptionPane.showMessageDialog(null, "La fila ha sido eliminada exitosamente");                
                } else {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar.");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void Editar(JTable tabla, JTextField [] cod){
        int selectedRow = tabla.getSelectedRow();
        if (selectedRow != -1) {
            for (int i = 0; i < cod.length; i++) {
                cod[i].setText(tabla.getValueAt(selectedRow, i).toString());
            }
        }else{
            JOptionPane.showMessageDialog(null,"No seleciono una fila" );
        }
    }

}
