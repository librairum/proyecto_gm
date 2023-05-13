/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Asistencias;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

/**
 *
 * @author jeanv
 */
public class DatosAsistencia {

    static Connection conn = ConexionBD.getConnection();

    public static void fillTableForPeriod(JTable tabla, String periodo, JComboBox combo) {
        // Obtener el dni del empleado
        String dni = ObtenerDNI(combo);

        // Parsea el período en mes y año
        int month = Integer.parseInt(periodo.substring(0, 2));
        int year = Integer.parseInt(periodo.substring(2, 6));

        // Crea un objeto Calendar para el primer día del mes
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        // Obtiene el último día del mes
        int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Crea una matriz bidimensional para almacenar los datos de la tabla
        String[][] data = new String[lastDayOfMonth][4];

        // Utiliza un bucle para iterar sobre cada día del mes en el período seleccionado
        for (int i = 0; i < lastDayOfMonth; i++) {
            // Obtiene el nombre del día de la semana y lo convierte a mayúscula
            String dayName = new SimpleDateFormat("EEEE").format(cal.getTime());
            dayName = dayName.substring(0, 1).toUpperCase() + dayName.substring(1).toLowerCase();

            // Obtiene la fecha en formato dd-mm-YYYY
            String date = new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());

            // Consulta la base de datos para obtener los datos de entrada y salida para esta fecha
            String entrada = "";
            String salida = "";
            try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_horario_empleado (?, ?) }")) {
                cstmt.setString(1, dni);
                cstmt.setString(2, date);
                try ( ResultSet rs = cstmt.executeQuery();) {
                    if (rs.next()) {
                        entrada = rs.getString("Entrada");
                        salida = rs.getString("Salida");
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Agrega los datos a la matriz bidimensional
            data[i][0] = dayName;
            data[i][1] = date;
            data[i][2] = entrada;
            data[i][3] = salida;

            // Incrementa el objeto Calendar para apuntar al siguiente día del mes
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

        // Crea un nuevo modelo de tabla utilizando la matriz bidimensional
        DefaultTableModel model = new DefaultTableModel(data, new String[]{"DÍA", "FECHA", "ENTRADA", "SALIDA"});

        // Configura la tabla para utilizar el nuevo modelo de tabla
        tabla.setModel(model);
    }

    public static void CargarEmpleados(JComboBox combo) {
        String query = "SELECT CONCAT(Nombres, ' ', Apellidos) AS NombreCompleto FROM empleados ORDER BY Nombres ASC";
        try ( PreparedStatement pstmt = conn.prepareStatement(query);  ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                String nombre_completo = rs.getString("NombreCompleto");
                combo.addItem(nombre_completo);
            }
        } catch (SQLException e) {

        }
    }

    public static String ObtenerDNI(JComboBox combo) {
        String dni = "";
        String empleado = combo.getSelectedItem().toString();
        String query = "SELECT Dni FROM empleados WHERE CONCAT(Nombres, ' ', Apellidos) = ?";
        try ( PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, empleado);
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    dni = rs.getString("Dni");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return dni;
    }
    
    public static void Actualizar(JTable tabla) {
        
    }

}
