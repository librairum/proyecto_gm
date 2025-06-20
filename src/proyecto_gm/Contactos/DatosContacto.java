/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Contactos;

import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import proyecto_gm.ConexionBD;
import proyecto_gm.Departamentos.Departamentos;

/**
 *
 * @author USUARIO
 */
public class DatosContacto {

    static Connection conn = ConexionBD.getConnection();

    public static void habilitarCampos(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setEditable(true);
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setEnabled(true);
            } else {
                LimpiarCampos((Container) componente);
            }
        }
    }

    public static void LimpiarCampos(Container contenedor) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }

        //porDefecto.setSelected(true);
    }

    // Bloquear campos
    public static void BloquearCampos(Container contenedor) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setEnabled(false);
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setEnabled(false);
            } else {

            }
        }

    }
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

    //metodo para insertar datos (nuevo cambio)
    public static void insertarDatos(Contacto contacto, JTable tabla) {
        try {
            PreparedStatement cstmt = conn.prepareCall("{ CALL insertar_contactos(?, ?, ?,?, ?, ?,?, ?, ?,?,?,?,?) }");
            if (contacto.getId() == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese un Id", "Sistema", JOptionPane.WARNING_MESSAGE);
                return;
            }

            cstmt.setInt(1, contacto.getId());
            cstmt.setString(2, contacto.getNombre());
            cstmt.setString(3, contacto.getFechaNacimiento());
            cstmt.setString(4, contacto.getPersonasRelacionadas());
            cstmt.setString(5, contacto.getEmpresa());
            cstmt.setString(6, contacto.getCuenta());
            cstmt.setString(7, contacto.getClave());

            cstmt.setString(8, contacto.getCargo());
            cstmt.setString(9, contacto.getCorreo());
            cstmt.setString(10, contacto.getTelefono());
            cstmt.setString(11, contacto.getDepartamento());
            cstmt.setString(12, contacto.getDireccion());
            cstmt.setString(13, contacto.getNotas());

            cstmt.execute(); // se inserta los datos a la BD

            // Actualiza el modelo de tabla con los nuevos datos
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosContacto.mostrarDatos(modelo);

            // Actualiza la vista del JTable con el modelo de tabla actualizado
//            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Mostrar datos
    public static void mostrarDatos(DefaultTableModel modelo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("CALL listar_contactos()");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getInt("IdContacto"),
                    rs.getString("Nombre"),
                    rs.getString("FechaNacimiento"),
                    rs.getString("PersonasRelacionadas"),
                    rs.getString("Empresa"),
                    rs.getString("Cargo"),
                    rs.getString("Correo"),
                    rs.getString("Telefono"),
                    rs.getString("Departamento"),
                    rs.getString("Direccion"),
                    rs.getString("Notas")};
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en mostrar datos", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Actualizar datos
    public static void actualizarDatos(Contacto contacto, JTable tabla) {
        try {
            PreparedStatement cstmt = conn.prepareCall("{ CALL actualizar_contactos(?, ?, ?,?,?,?,?,?,?,?,?,?,?) }");
            cstmt.setInt(1, contacto.getId());
            cstmt.setString(2, contacto.getNombre());
            cstmt.setString(3, contacto.getFechaNacimiento());
            cstmt.setString(4, contacto.getPersonasRelacionadas());
            cstmt.setString(5, contacto.getEmpresa());
            cstmt.setString(6, contacto.getCuenta());
            cstmt.setString(7, contacto.getClave());
            cstmt.setString(8, contacto.getCargo());
            cstmt.setString(9, contacto.getCorreo());
            cstmt.setString(10, contacto.getTelefono());
            cstmt.setString(11, contacto.getDepartamento());
            cstmt.setString(12, contacto.getDireccion());
            cstmt.setString(13, contacto.getNotas());

            cstmt.execute(); // se actualiza los datos en la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosContacto.mostrarDatos(modelo);

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Eliminar datos
    public static void eliminarDatos(JTable tabla) {
        try {
            // Obtener el indice de la fila seleccionada
            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                String[] options = {"Sí", "No", "Cancelar"};
                int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que quiere eliminar la fila seleccionada?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                if (opcion == JOptionPane.YES_OPTION) {
                    // Obtener los datos de fila seleccionada
                    //String id = ;  //Se asume que el ID se encuentra en la primera columna
                    int id = Integer.parseInt(tabla.getModel().getValueAt(fila, 0).toString());
                    // Ejecutar el procedimiento almacenado
                    PreparedStatement stmt = conn.prepareCall("{ CALL eliminar_contacto(?) }");
                    stmt.setInt(1, id);
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

    // Boton Guardar
    public static void guardarCambios(Contacto contacto, JTable tabla) {
        try {
            PreparedStatement stmt = conn.prepareStatement("CALL listar_contactos()");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // El registro ya existe, se debe realizar una actualización
                DatosContacto.actualizarDatos(contacto, tabla);
            } else {
                // El registro no existe, se debe realizar una inserción
                DatosContacto.insertarDatos(contacto, tabla);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Editar(JTable tabla, JTextField[] camposTexto, JComboBox[] combos) {
    int filaSeleccionada = tabla.getSelectedRow();

    if (filaSeleccionada >= 0) {
        //tabla.setRowSelectionAllowed(true);

        TableModel modelo = tabla.getModel();

        // Asignar los valores individualmente según el orden real de las columnas
        camposTexto[0].setText(modelo.getValueAt(filaSeleccionada, 0).toString()); // ID
        camposTexto[1].setText(modelo.getValueAt(filaSeleccionada, 1).toString()); // Nombre
        camposTexto[2].setText(modelo.getValueAt(filaSeleccionada, 2).toString()); // Fecha
        camposTexto[3].setText(modelo.getValueAt(filaSeleccionada, 3).toString()); // Personas
        camposTexto[4].setText(modelo.getValueAt(filaSeleccionada, 4).toString()); // Empresa
        camposTexto[5].setText(modelo.getValueAt(filaSeleccionada, 5).toString()); // Cargo
        camposTexto[6].setText(modelo.getValueAt(filaSeleccionada, 6).toString()); // Correo
        camposTexto[7].setText(modelo.getValueAt(filaSeleccionada, 7).toString()); // Teléfono
        camposTexto[8].setText(modelo.getValueAt(filaSeleccionada, 9).toString()); // Dirección
        camposTexto[9].setText(modelo.getValueAt(filaSeleccionada, 10).toString()); // Nota

        // Manejo del ComboBox (columna 8 = departamento)
        String departamento = modelo.getValueAt(filaSeleccionada, 8).toString();

        for (int i = 0; i < combos[0].getItemCount(); i++) {
            if (combos[0].getItemAt(i).toString().equals(departamento)) {
                combos[0].setSelectedIndex(i);
                break;
            }
        }

        camposTexto[0].setEnabled(false); // ID no editable
        camposTexto[1].requestFocus();

    } else {
        JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
        tabla.setRowSelectionAllowed(true);
    }
}

    /*
    private static Object[] ObtenerValoresFila(int filaSeleccionada, JTable tabla) {
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
    }*/

    public static String GenerarCodigoEntero(String tabla) {
        CallableStatement cstmt = null;
        String codigo_generado = "";

        try {
            cstmt = conn.prepareCall("{ CALL generar_codigoentero(?, ?) }");
            cstmt.setString(1, tabla);
            cstmt.registerOutParameter(2, Types.INTEGER);
            cstmt.execute();

            codigo_generado = cstmt.getString(2);
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

}
