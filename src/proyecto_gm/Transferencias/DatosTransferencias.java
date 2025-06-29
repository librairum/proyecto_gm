/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Transferencias;

import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;
import proyecto_gm.Cuentas.Cuentas;
import proyecto_gm.Periodos.Periodos;

/**
 *
 * @author jeanv
 *
 */
public class DatosTransferencias {

    static Connection conn = ConexionBD.getConnection();

    // Limpiar campos
    public static void Limpiar(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof Container) {
                Limpiar((Container) componente);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    // Habilitar campos
    public static void Habilitar(Container contenedor, boolean bloquear) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setEnabled(bloquear);
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setEnabled(bloquear);
            } else if (componente instanceof JButton) {
                String button = ((JButton) componente).getName();
                if (button.equals("guardar") || button.equals("cancelar")) {
                    ((JButton) componente).setEnabled(bloquear);
                } else if (button.equals("nuevo") || button.equals("editar") || button.equals("eliminar")) {
                    ((JButton) componente).setEnabled(!bloquear); // aplicar logica inversa
                }
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    // Cargar lista de periodos en un JComboBox<Periodo>
    public static void CargarPeriodos(JComboBox<Periodos> cboPeriodo) {
        List<Periodos> lista = new ArrayList<>();
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL listar_periodos() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Periodos p = new Periodos();
                p.setId(rs.getString("Mes"));
                p.setDescripcion(rs.getString("Descripcion")); // si lo tuvieses
                lista.add(p);
            }
            cboPeriodo.setModel(new DefaultComboBoxModel<>(lista.toArray(new Periodos[0])));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Cargar cuentas en JComboBox<Cuenta>
    public static void CargarCuentas(JComboBox<Cuentas> origen, JComboBox<Cuentas> destino) {
        List<Cuentas> cuentas = new ArrayList<>();
        try ( CallableStatement cstmt = conn.prepareCall("CALL listar_ctransferencias()")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Cuentas cuenta = new Cuentas();
                cuenta.setIdCuenta(rs.getInt("IdCuentaBancaria"));
                cuenta.setNombres(rs.getString("Nombres"));
                cuentas.add(cuenta);
            }

            DefaultComboBoxModel<Cuentas> modelo = new DefaultComboBoxModel<>(cuentas.toArray(new Cuentas[0]));
            origen.setModel(modelo);
            destino.setModel(new DefaultComboBoxModel<>(cuentas.toArray(new Cuentas[0])));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Mostrar datos
    public static void Listar(DefaultTableModel modelo) {
        try ( PreparedStatement pstmt = conn.prepareStatement("CALL listar_transferencias");  ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("IdTransferenciaBancaria"),
                    rs.getString("IdPeriodo"),
                    rs.getString("NroOperacion"),
                    rs.getString("cuentaOrigen"),
                    rs.getString("cuentaDestino"),
                    rs.getString("Fecha")};
                modelo.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Insertar datos
    public static void Insertar(Transferencia transferencia, JTable tabla) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL insertar_transferencia(?, ?, ?, ?, ?) }")) {
            cstmt.setInt(1, Integer.parseInt(transferencia.getPeriodo()));
            cstmt.setString(2, transferencia.getNroOperacion());
            cstmt.setString(3, transferencia.getCuentaOrigen());
            cstmt.setString(4, transferencia.getCuentaDestino());
            cstmt.setString(5, transferencia.getFecha());

            cstmt.execute(); // se inserta los datos a la BD
            JOptionPane.showMessageDialog(null, "Transferencia registrada satisfactoriamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Listar(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Boton editar
    public static void Editar(Container contenedor, JTable tabla, JTextField[] cajas, JComboBox cboPeriodo, JComboBox origen, JComboBox destino) {
        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            Habilitar(contenedor, true);
            tabla.clearSelection();
            tabla.setRowSelectionAllowed(false);

            cajas[0].setText(tabla.getModel().getValueAt(fila, 0).toString()); // txtId
            String periodo = tabla.getModel().getValueAt(fila, 1).toString();  // para el combo
            cajas[1].setText(tabla.getModel().getValueAt(fila, 2).toString()); // txtNroOperacion
            try {
                String fechaOriginal = tabla.getModel().getValueAt(fila, 5).toString(); // "2025-05-08"
                SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = formatoEntrada.parse(fechaOriginal);
                cajas[2].setText(formatoSalida.format(fecha));
            } catch (ParseException e) {
                cajas[2].setText(""); // En caso de error, deja el campo vacío
                JOptionPane.showMessageDialog(null, "Error al convertir la fecha: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            cajas[0].setEnabled(false);
            cajas[1].requestFocus();

            origen.setSelectedItem(tabla.getModel().getValueAt(fila, 3).toString());
            destino.setSelectedItem(tabla.getModel().getValueAt(fila, 4).toString());

            // Aquí el combo para el periodo (supongamos que se llama cboPeriodo)
            // 
            cboPeriodo.setSelectedItem(periodo);

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Actualizar datos
    public static void Actualizar(Transferencia transferencia, JTable tabla) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_transferencia(?, ?, ?, ?, ?, ?) }")) {

            cstmt.setInt(1, transferencia.getId());
            cstmt.setString(2, transferencia.getPeriodo());
            cstmt.setString(3, transferencia.getNroOperacion());
            cstmt.setString(4, transferencia.getCuentaOrigen());
            cstmt.setString(5, transferencia.getCuentaDestino());
            cstmt.setString(6, transferencia.getFecha());

            cstmt.execute(); // se actualiza los datos en la BD
            JOptionPane.showMessageDialog(null, "Transferencia actualizado satisfactoriamente.", "Actualización Exitoso", JOptionPane.INFORMATION_MESSAGE);

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Listar(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Eliminar datos
    public static void Eliminar(JTable tabla) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL eliminar_transferencia(?) }")) {
            // Obtener el indice de la fila seleccionada
            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                String[] options = {"Sí", "No", "Cancelar"};
                int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro de que quiere eliminar la fila seleccionada?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                if (opcion == JOptionPane.YES_OPTION) {
                    // Obtener los datos de fila seleccionada
                    String id = tabla.getModel().getValueAt(fila, 0).toString(); // Se asume que el ID se encuentra en la primera columna

                    // Ejecutar el procedimiento almacenado
                    cstmt.setString(1, id);
                    cstmt.execute();
                    JOptionPane.showMessageDialog(null, "Transferencia eliminada satisfactoriamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    // Actualizamos la tabla
                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                    modelo.setRowCount(0);
                    Listar(modelo);
                } else {
                    tabla.clearSelection();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Validar campos
    public static boolean Validar(JTextField[] campos, JComboBox[] combos) {
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos.");
                campo.requestFocus();
                return false;
            }
        }
        return true;
    }
}
