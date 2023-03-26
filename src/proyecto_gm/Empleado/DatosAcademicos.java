/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Empleado;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyecto_gm.ConexionBD;

/**
 *
 * @author jeanv
 */
public class DatosAcademicos {

    static Connection conn = ConexionBD.getConnection();

    // Limpiar campos
    public static void LimpiarCampos(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JComboBox jComboBox) {
                jComboBox.setSelectedIndex(0);
            } else {
                // No hace nada para otros tipos de componentes
            }
        }
    }

    // Cargar opciones para los combo boxes
    public static void CargarCombos(JComboBox cbxInstitucion, JComboBox cbxFacultad, JComboBox cbxCarrera) {
        try {
            // Preparamos la consultas
            PreparedStatement pstmtInst = conn.prepareStatement("SELECT RazonSocial FROM institucioneseducativas");
            PreparedStatement pstmtFac = conn.prepareStatement("SELECT Descripcion FROM facultades");
            PreparedStatement pstmtCar = conn.prepareStatement("SELECT Descripcion FROM carreras");

            // Ejecutamos
            ResultSet instituciones = pstmtInst.executeQuery();
            ResultSet facultades = pstmtFac.executeQuery();
            ResultSet carreras = pstmtCar.executeQuery();

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

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Capturar las opciones de los radio buttons y de los combo boxes
    public static String[] CapturarOpciones(JComboBox cbxIns, JComboBox cbxFac, JComboBox cbxCar) {
        String[] ids = new String[3];
        String idIns = "", idFac = "", idCar = "";
        try {
            // Capturar las opciones seleccionadas en los combo boxes
            String selectIns = cbxIns.getSelectedItem().toString();
            String selectFac = cbxFac.getSelectedItem().toString();
            String selectCar = cbxCar.getSelectedItem().toString();

            // Obtener los id de las instituciones, facultades y carreras
            CallableStatement cstmt = conn.prepareCall("{ CALL consulta_inst_facu_carr(?, ?, ?) }");
            cstmt.setString(1, selectIns);
            cstmt.setString(2, selectFac);
            cstmt.setString(3, selectCar);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                idIns = rs.getString("id_ins");
                idFac = rs.getString("id_fac");
                idCar = rs.getString("id_car");
            }

            ids[0] = idIns;
            ids[1] = idFac;
            ids[2] = idCar;

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
                JOptionPane.showMessageDialog(null, "Datos académicos registrados exitosamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                obj.dispose();
                
            } else {
                JOptionPane.showMessageDialog(null, "No se pudieron registrar los datos académicos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
