package proyecto_gm.TipoDocumento;

import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;
import proyecto_gm.Modulo.Modulo;

public class DatosTipoDocumento {

    static Connection conn = ConexionBD.getConnection();

    public static void Limpiar(Container contenedor) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
        }
    }

    public static void Habilitar(Container contenedor, boolean bloquear) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField || component instanceof JComboBox) {
                component.setEnabled(bloquear);
            } else if (component instanceof JButton) {
                String button = ((JButton) component).getName();
                ((JButton) component).setEnabled(button.equals("guardar") || button.equals("deshacer") ? bloquear : !bloquear);
            }
        }
    }

    public static List<Modulo> obtenerModulos() {
        List<Modulo> lista = new ArrayList<>();
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL listar_modulo() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("IdModulo");  // obtener el int directamente
                String descripcion = rs.getString("Descripcion");
                lista.add(new Modulo(Id, descripcion));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public static void Mostrar(DefaultTableModel modelo) {
        try ( PreparedStatement pstmt = conn.prepareStatement("CALL listar_tipodocumento()")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("IdTipoDocumento"),
                    rs.getString("Descripcion"),
                    rs.getString("Modulo")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean Insertar(TipoDocumento tip, JTable tabla) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL insertar_tipodocumento(?, ?, ?) }")) {
            cstmt.setInt(1, tip.getIdTipoDocumento());
            cstmt.setString(2, tip.getIdModulo());
            cstmt.setString(3, tip.getDescripcion());
            cstmt.execute();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Mostrar(modelo);

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void Editar(Container contenedor, JTable tabla, JTextField[] camposTexto, JComboBox[] combos) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            Habilitar(contenedor, true);
            camposTexto[0].setEnabled(false);
            camposTexto[1].requestFocus();
            for (int i = 0; i < camposTexto.length; i++) {
                camposTexto[i].setText(tabla.getValueAt(filaSeleccionada, i).toString());
            }
            String moduloDescripcion = tabla.getValueAt(filaSeleccionada, 2).toString(); // xModulo
            for (int i = 0; i < combos[0].getItemCount(); i++) {
                if (combos[0].getItemAt(i).equals(moduloDescripcion)) {
                    combos[0].setSelectedIndex(i);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
        }
    }

    public static void Actualizar(TipoDocumento tip, JTable tabla, JComboBox<Modulo> cboModulo) {
    try (CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_tipodocumento(?, ?, ?) }")) {
        // Usamos el idModulo directamente del objeto tip
        String idModulo = tip.getIdModulo();

        cstmt.setInt(1, tip.getIdTipoDocumento());   // ID del tipo de documento
        cstmt.setString(2, tip.getDescripcion());    // Descripción
        cstmt.setString(3, idModulo);                // ID del módulo como string

        cstmt.execute();

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        Mostrar(modelo);

        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    public static void Eliminar(JTable tabla) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String codigoTipo = tabla.getModel().getValueAt(fila, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar tipo de empleado?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try ( CallableStatement stmt = conn.prepareCall("{ CALL eliminar_tipodocumento(?) }")) {
                    stmt.setString(1, codigoTipo);
                    stmt.execute();

                    // Refrescar la tabla completa
                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                    modelo.setRowCount(0); // Limpiar
                    Mostrar(modelo);       // Volver a cargar

                    // Confirmación
                    JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un área para eliminar.");
        }
    }

}
