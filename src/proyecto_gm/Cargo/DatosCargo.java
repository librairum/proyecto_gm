package proyecto_gm.Cargo;

import java.awt.Component;
import java.awt.Container;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;
import proyecto_gm.Utilitario;

public class DatosCargo {

    static Connection conn = ConexionBD.getConnection();

    public static void Limpiar(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof Container) {
                Limpiar((Container) componente);
            }
        }
    }
    
    public static void Mostrar(DefaultTableModel modelo) {
        modelo.setRowCount(0);
        try ( PreparedStatement stmt = conn.prepareStatement("CALL listar_cargos()");  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getInt("IdCargo"), // Cambié getString por getInt porque IdCargo es int
                    rs.getString("Descripcion")
                };
                modelo.addRow(row);
            }

        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static boolean Insertar(Cargo car) {
        try ( CallableStatement stmt = conn.prepareCall("{CALL insertar_cargos(?, ?)}")) {
            stmt.setString(1, car.getDescripcion());
            stmt.registerOutParameter(2, Types.INTEGER); // Cambié a INTEGER para el Id autogenerado

            int filasAfectadas = stmt.executeUpdate();

            // Obtener el Id generado desde el OUT parameter
            int nuevoId = stmt.getInt(2);
            car.setIdCargo(nuevoId);  // Asegúrate que Cargo tenga atributo IdCargo y setter

            
            

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
            return false;
        }
    }

    public static boolean Actualizar(Cargo car) {
        try {
            CallableStatement cstmt = conn.prepareCall("{CALL actualizar_cargos (?,?)}");
            cstmt.setInt(1, car.getIdCargo());
            cstmt.setString(2, car.getDescripcion());
            //cstmt.executeQuery();
            int filasAfectadas = cstmt.executeUpdate();
            cstmt.close();
                return filasAfectadas > 0;
            
            
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
            return false;
        }
        
    }

    public static boolean Eliminar(String idCargo) {
 
            try {
                  
                int id = Integer.parseInt(idCargo);
                CallableStatement cstmt = conn.prepareCall("{ CALL eliminar_cargos(?) }");
                cstmt.setInt(1, id);
                int filasAfectadas = cstmt.executeUpdate();
                return filasAfectadas> 0;
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Id inválido para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                return  false;
            }catch (SQLException ex){
                return false;
            }

        
    }

    public static boolean Editar(Container contenedor, JTable tabla, JTextField[] campos) {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            Habilitar(contenedor, true);
            for (int i = 0; i < campos.length; i++) {
                campos[i].setText(tabla.getModel().getValueAt(fila, i).toString());
            }
            campos[0].setEnabled(false);
            campos[1].requestFocus();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para editar.");
            return false;
        }
    }

    public static void Habilitar(Container contenedor, boolean bloquear) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setEnabled(bloquear);
            } else if (componente instanceof JButton) {
                String button = ((JButton) componente).getName();
                boolean activar = button.equals("guardar") || button.equals("deshacer");
                ((JButton) componente).setEnabled(activar == bloquear);
            }
        }
    }
}
