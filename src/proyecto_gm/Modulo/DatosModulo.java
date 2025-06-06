package proyecto_gm.Modulo;

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

public class DatosModulo {

    static Connection conn = ConexionBD.getConnection();

    public static String GenerarCodigo() {
        String codigoGenerado = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?) }")) {
            cstmt.setString(1, "modulos");
            cstmt.setString(2, "IdModulo");
            cstmt.registerOutParameter(3, Types.INTEGER);

            cstmt.execute();

            int idGenerado = cstmt.getInt(3); // Recibe el número
            codigoGenerado = String.valueOf(idGenerado);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return codigoGenerado;
    }

    public static void Mostrar(DefaultTableModel modelo) {
        try {
            PreparedStatement ate = conn.prepareStatement("CALL listar_modulo()");
            ResultSet rs = ate.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getInt("IdModulo"), // Cambiado a getInt para consistencia con tu clase
                    rs.getString("Descripcion")
                };
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Insertar(Modulo mod, JTable tabla) {
        try {
            PreparedStatement ate = conn.prepareStatement("{CALL insertar_modulo (?,?)}");
            ate.setInt(1, mod.getId());  // CAMBIADO de setString a setInt
            ate.setString(2, mod.getDescripcion());
            ate.executeUpdate();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            Object[] rowData = {mod.getId(), mod.getDescripcion()};
            modelo.addRow(rowData);

            tabla.setModel(modelo);
            ate.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Actualizar(Modulo mod, JTable tabla) {
        try {
            CallableStatement ate = conn.prepareCall("{CALL actualizar_modulo (?,?)}");
            ate.setInt(1, mod.getId());  // CAMBIADO de setString a setInt
            ate.setString(2, mod.getDescripcion());
            ate.executeUpdate();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosModulo.Mostrar(modelo);

            ate.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Eliminar(JTable tabla) {
        try {
            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                String[] options = {"Sí", "No", "Cancelar"};
                int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que quiere eliminar la fila seleccionada?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                if (opcion == JOptionPane.YES_OPTION) {
                    int id = Integer.parseInt(tabla.getModel().getValueAt(fila, 0).toString());  // CAMBIADO a int

                    CallableStatement stmt = conn.prepareCall("{ CALL eliminar_modulo(?) }");
                    stmt.setInt(1, id);  // CAMBIADO de setString a setInt
                    stmt.execute();

                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.removeRow(fila);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar.");
            }

        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean Editar(Container contenedor, JTable tabla, JTextField[] cod) {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            DatosModulo.Habilitar(contenedor, true);
            tabla.clearSelection();
            tabla.setRowSelectionAllowed(false);
            for (int i = 0; i < cod.length; i++) {

                String dato = tabla.getModel().getValueAt(fila, i).toString();
                cod[i].setText(dato);
            }
            cod[0].setEnabled(false);
            cod[1].requestFocus();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No seleciono una fila");
            return false;
        }
    }

    // Habilitar o bloquear campos y botones
    public static void Habilitar(Container contenedor, boolean bloquear) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setEnabled(bloquear);

            } else if (component instanceof JButton) {
                String button = ((JButton) component).getName();
                if (button.equals("guardar") || button.equals("deshacer")) {
                    ((JButton) component).setEnabled(bloquear);
                } else if (button.equals("agregar") || button.equals("editar") || button.equals("eliminar")) {
                    ((JButton) component).setEnabled(!bloquear); // aplicar logica inversa
                }
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    public static void Limpiar(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof Container) {
                Limpiar((Container) componente);
            }
        }
    }

}
