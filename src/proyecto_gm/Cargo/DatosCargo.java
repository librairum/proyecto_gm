package proyecto_gm.Cargo;

import java.awt.Component;
import java.awt.Container;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

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

    public static boolean Insertar(Cargo car, JTable tabla) {
        try ( CallableStatement stmt = conn.prepareCall("{CALL insertar_cargos(?, ?)}")) {
            stmt.setString(1, car.getDescripcion());
            stmt.registerOutParameter(2, Types.INTEGER); // Cambié a INTEGER para el Id autogenerado

            int filasAfectadas = stmt.executeUpdate();

            // Obtener el Id generado desde el OUT parameter
            int nuevoId = stmt.getInt(2);
            car.setIdCargo(nuevoId);  // Asegúrate que Cargo tenga atributo IdCargo y setter

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.addRow(new Object[]{car.getIdCargo(), car.getDescripcion()});

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void Actualizar(Cargo car, JTable tabla) {
        try {
            CallableStatement ate = conn.prepareCall("{CALL actualizar_cargos (?,?)}");
            ate.setInt(1, car.getIdCargo());
            ate.setString(2, car.getDescripcion());
            ate.executeUpdate();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);

            DatosCargo.Mostrar(modelo);
            ate.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Eliminar(JTable tabla) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String idStr = tabla.getModel().getValueAt(fila, 0).toString();
            int idCargo;
            try {
                idCargo = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Id inválido para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar cargo?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try ( CallableStatement stmt = conn.prepareCall("{ CALL eliminar_cargos(?) }")) {
                    stmt.setInt(1, idCargo);
                    stmt.execute();
                    ((DefaultTableModel) tabla.getModel()).removeRow(fila);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un cargo para eliminar.");
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
