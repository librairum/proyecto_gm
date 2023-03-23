/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Empleado;

import java.awt.Component;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static proyecto_gm.Empleado.DatosEmpleados.conn;

/**
 *
 * @author jeanv
 */
public class DatosAcademicos {

    // Limpiar campos
    public static void LimpiarCampos(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JComboBox jComboBox) {
                jComboBox.setSelectedIndex(-1);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    // Cargar opciones para los combo boxes
    public static void CargarCombos(JComboBox cbxInstitucion, JComboBox cbxFacultad, JComboBox cbxCarrera, JComboBox cbxCiclo) {
        try {
            // Preparamos la consultas
            PreparedStatement pstmtInst = conn.prepareStatement("SELECT RazonSocial FROM institucioneseducativas");
            PreparedStatement pstmtFac = conn.prepareStatement("SELECT Descripcion FROM facultades");
            PreparedStatement pstmtCar = conn.prepareStatement("SELECT Descripcion FROM carreras");
            PreparedStatement pstmtCic = conn.prepareStatement("SELECT Descripcion FROM ciclos");

            // Ejecutamos
            ResultSet instituciones = pstmtInst.executeQuery();
            ResultSet facultades = pstmtFac.executeQuery();
            ResultSet carreras = pstmtCar.executeQuery();
            ResultSet ciclos = pstmtCic.executeQuery();

            // Llenamos cbxInstitucion
            while (instituciones.next()) {
                String inst = instituciones.getString("RazonSocial");
                cbxInstitucion.addItem(inst);
            }

            // Llenamos cbxFacultad
            while (facultades.next()) {
                String fac = facultades.getString("Descripcion");
                cbxFacultad.addItem(fac);
            }

            // Llenamos cbxCarrera
            while (carreras.next()) {
                String car = carreras.getString("Descripcion");
                cbxCarrera.addItem(car);
            }

            // Llenamos cbxCiclo
            while (ciclos.next()) {
                String cic = ciclos.getString("Descripcion");
                cbxCiclo.addItem(cic);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Capturar las opciones de los radio buttons y de los combo boxes
    public static String[] CapturarOpciones(JComboBox cbxIns, JComboBox cbxFac, JComboBox cbxCar, JComboBox cbxCic) {
        String[] ids = new String[4];
        String idIns = "", idFac = "", idCar = "", idCic = "";
        try {
            // Capturar las opciones seleccionadas en los combo boxes
            String selectIns = cbxIns.getSelectedItem().toString();
            String selectFac = cbxFac.getSelectedItem().toString();
            String selectCar = cbxCar.getSelectedItem().toString();
            String selectCic = cbxCic.getSelectedItem().toString();

            // Obtener los id de las elecciones en area, cargo y tipo de empleado
            String consulta = "SELECT i.Id AS id_ins, f.Id AS id_fac, c.Id AS id_car, s.Id AS id_cic "
                    + "FROM institucioneseducativas i, facultades f, carreras c, ciclos s "
                    + "WHERE i.RazonSocial = ? AND f.Descripcion = ? AND c.Descripcion = ? AND s.Descripcion = ?";
            PreparedStatement pstmt = conn.prepareStatement(consulta);
            pstmt.setString(1, selectIns);
            pstmt.setString(2, selectFac);
            pstmt.setString(3, selectCar);
            pstmt.setString(4, selectCic);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                idIns = rs.getString("id_ins");
                idFac = rs.getString("id_fac");
                idCar = rs.getString("id_car");
                idCic = rs.getString("id_cic");
            }

            ids[0] = idIns;
            ids[1] = idFac;
            ids[2] = idCar;
            ids[3] = idCic;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Opciones", JOptionPane.ERROR_MESSAGE);
        }

        return ids;
    }

    // Boton Guardar
    public static void InsertarDatos(Datosacad obj, String dni, String inst, String fac, String car, String cic, String codEstudiante) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_datos_academicos(?, ?, ?, ?, ?, ?) }");
            cstmt.setString(1, dni);
            cstmt.setString(2, inst);
            cstmt.setString(3, fac);
            cstmt.setString(4, car);
            cstmt.setString(5, cic);
            cstmt.setString(6, codEstudiante);
            
            if (cstmt.execute() != true) {
                JOptionPane.showMessageDialog(null, "Datos académicos registrados exitosamente.");
                obj.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudieron registrar los datos académicos.");
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
