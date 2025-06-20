package proyecto_gm.Proveedores;

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
import proyecto_gm.Departamentos.Departamentos;

public class DatosProveedores {

    static Connection conn = ConexionBD.getConnection();

    public static String GenerarCodigo() {
        String codigoGenerado = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?) }")) {
            cstmt.setString(1, "proveedores");
            cstmt.setString(2, "IdProveedor");
            cstmt.registerOutParameter(3, Types.INTEGER);

            cstmt.execute();

            int idGenerado = cstmt.getInt(3); // Recibe directamente el número
            codigoGenerado = String.valueOf(idGenerado);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return codigoGenerado;
    }

    // Mostrar datos
    public static void Mostrar(DefaultTableModel modelo) {
        try ( PreparedStatement pstmt = conn.prepareStatement("CALL listar_proveedores()")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("IdProveedor"),
                    rs.getString("Descripcion"), // Departamento
                    rs.getString("Nombres"),
                    rs.getString("Direccion"),
                    rs.getString("Correo"),
                    rs.getString("Telefono"),
                    rs.getString("Ruc")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al mostrar proveedores", JOptionPane.ERROR_MESSAGE);
        }
    }

    //cargar combobox
    public static List<Departamentos> listaDepartamentos() {
        List<Departamentos> lista = new ArrayList<>();
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_departamentos() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("IdDepartamento");
                String descripcion = rs.getString("Descripcion");
                lista.add(new Departamentos(id, descripcion));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener departamentos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }    

    public static String Capturar(JComboBox<Departamentos> cmbDepartamentos) {
        String idModulo = "";
        try ( PreparedStatement pstmt = conn.prepareStatement("CALL obtener_id_departamento(?)")) {
            pstmt.setString(1, cmbDepartamentos.getSelectedItem().toString());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                idModulo = rs.getString("IdDepartamento");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Opciones", JOptionPane.ERROR_MESSAGE);
        }
        return idModulo;
    }

    public static boolean InsertarDatos(Proveedores pro, JTable tabla) {
        System.out.println("Entró al método InsertarDatos...");

        int idProveedor = Integer.parseInt(pro.getIdProveedor());

        try ( CallableStatement cstmt = conn.prepareCall("{ CALL insertar_proveedores(?, ?, ?, ?, ?, ?, ?) }")) {
            cstmt.setInt(1, idProveedor);
            cstmt.setInt(2, Integer.parseInt(pro.getDepartamentoId()));
            cstmt.setString(3, pro.getNombres());
            cstmt.setString(4, pro.getDireccion());
            cstmt.setString(5, pro.getCorreo());
            cstmt.setString(6, pro.getTelefono());
            cstmt.setString(7, pro.getRuc());
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

    public static boolean Actualizar(Proveedores pro, JTable tabla, JComboBox<Departamentos> cmbDepartamentos) {
        try {
            // Llamada al procedimiento almacenado
            CallableStatement cstmt = conn.prepareCall("{CALL actualizar_proveedores(?,?,?,?,?,?,?)}");

            // Capturamos el IdDepartamento desde el ComboBox
            String idDepartamento = Capturar(cmbDepartamentos);

            // Definir los parámetros de la consulta
            cstmt.setString(1, pro.IdProveedor);
            cstmt.setInt(2, Integer.parseInt(idDepartamento)); // ComboBox contiene IDs como enteros.
            cstmt.setString(3, pro.Nombres);
            cstmt.setString(4, pro.Direccion);
            cstmt.setString(5, pro.Correo);
            cstmt.setString(6, pro.Telefono);
            cstmt.setString(7, pro.Ruc);

            cstmt.executeUpdate();
            cstmt.close();

            // Actualizar la tabla después de la actualización en la base de datos
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosProveedores.Mostrar(modelo);
            return true;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void Eliminar(JTable tabla) {
        try {
            // Obtener el indice de la fila seleccionada
            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                String codigoDepartamento = tabla.getModel().getValueAt(fila, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar tipo de empleado?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {

                    // Ejecutar el procedimiento almacenado
                    CallableStatement stmt = conn.prepareCall("{ CALL eliminar_proveedores(?) }");
                    stmt.setString(1, codigoDepartamento);
                    stmt.execute();

                    // Actualizar el JTable
                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.removeRow(fila);
                    JOptionPane.showMessageDialog(null, "El registro ha sido eliminada exitosamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Editar(Container contenedor, JTable tabla, JTextField[] camposTexto, JComboBox[] combos) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            Habilitar(contenedor, true);
            camposTexto[0].setEnabled(false); // desactivar edición del ID
            camposTexto[1].requestFocus();

            // Rellenar los campos de texto con los valores de la fila seleccionada.
            camposTexto[0].setText(tabla.getValueAt(filaSeleccionada, 0).toString()); // Id (Proveedor)
            camposTexto[3].setText(tabla.getValueAt(filaSeleccionada, 2).toString()); // Nombres
            camposTexto[1].setText(tabla.getValueAt(filaSeleccionada, 3).toString()); // Direccion
            camposTexto[4].setText(tabla.getValueAt(filaSeleccionada, 4).toString()); // Correo
            camposTexto[2].setText(tabla.getValueAt(filaSeleccionada, 5).toString()); // Telefono
            camposTexto[5].setText(tabla.getValueAt(filaSeleccionada, 6).toString()); // RUC

            // actualiza el ComboBox para el departamento
            String moduloDescripcion = tabla.getValueAt(filaSeleccionada, 1).toString(); // columna de Modulo (Departamento)

            // Verifica si el ComboBox tiene ese valor y lo selecciona
            for (int i = 0; i < combos[0].getItemCount(); i++) {
                if (combos[0].getItemAt(i).equals(moduloDescripcion)) {
                    combos[0].setSelectedIndex(i); // Selecciona el valor correcto
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
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
