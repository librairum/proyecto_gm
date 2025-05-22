package proyecto_gm.Categoria;

import java.awt.Component;
import java.awt.Container;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosCategoria {

    static Connection conn = ConexionBD.getConnection();

    public static void LimpiarCat(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof Container) {
                LimpiarCat((Container) componente);
            }
        }
    }

    public static void MostrarCat(DefaultTableModel modelo) {
        modelo.setRowCount(0);
        try ( PreparedStatement stmt = conn.prepareStatement("CALL listar_categorias()");  ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getInt("IdCategoria"),
                    rs.getString("Descripcion")
                };
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean InsertarCat(Categoria cat, JTable tabla) {
        try ( CallableStatement stmt = conn.prepareCall("{CALL insertar_categorias(?, ?)}")) {
            stmt.setString(1, cat.getDescripcionCat());
            stmt.registerOutParameter(2, Types.INTEGER); // p_id (OUT)

            int filasAfectadas = stmt.executeUpdate();

            int nuevoId = stmt.getInt(2); // Obtener el ID generado
            cat.setIdCat(nuevoId);  // Suponiendo que ahora tienes get/setIdCategoria

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.addRow(new Object[]{
                cat.getIdCat(),
                cat.getDescripcionCat()
            });

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void ActualizarCat(Categoria cat, JTable tabla) {
        try ( CallableStatement stmt = conn.prepareCall("{CALL actualizar_categorias (?, ?)}")) {
            stmt.setInt(1, cat.getIdCat()); // Cambiado de setString a setInt
            stmt.setString(2, cat.getDescripcionCat());
            stmt.executeUpdate();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosCategoria.MostrarCat(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void EliminarCat(JTable tabla) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            int idCategoria = Integer.parseInt(tabla.getModel().getValueAt(fila, 0).toString()); // cast a int
            int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar Categoría?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try ( CallableStatement stmt = conn.prepareCall("{CALL eliminar_categorias(?)}")) {
                    stmt.setInt(1, idCategoria);
                    stmt.execute();
                    ((DefaultTableModel) tabla.getModel()).removeRow(fila);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoría para eliminar.");
        }
    }

    public static void HabilitarCat(Container contenedor, boolean bloquear) {
        if (contenedor == null) {
            return;
        }
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setEnabled(bloquear);
            } else if (componente instanceof JButton) {
                String button = ((JButton) componente).getName();
                if (button != null) {
                    // Se habilitan solo cuando bloquear es true
                    boolean activar = button.equals("guardar") || button.equals("deshacer");
                    ((JButton) componente).setEnabled(bloquear && activar);
                }
            }
        }
    }

    public static boolean EditarCat(Container contenedor, JTable tabla, JTextField[] campos) {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            HabilitarCat(contenedor, true);
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

}
