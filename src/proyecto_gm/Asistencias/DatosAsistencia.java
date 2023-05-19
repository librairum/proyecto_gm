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
import java.sql.Types;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    static final Connection conn = ConexionBD.getConnection();

    public static void RellenarTabla(JTable tabla, JComboBox mes, JComboBox empleado) {
        // Obtener el dni del empleado
        String dni = ObtenerDNI(empleado);
        String periodo = mes.getSelectedItem().toString();

        // Parsea el período en mes y año
        int month = Integer.parseInt(periodo.substring(0, 2)); // 05
        int year = Integer.parseInt(periodo.substring(2, 6)); // 2023
        // Crea un objeto Calendar para el primer día del mes
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        // Obtiene el último día del mes
        int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Crea una matriz bidimensional para almacenar los datos de la tabla
        String[][] data = new String[lastDayOfMonth][5];

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
            data[i][4] = CalcularDuracion(entrada, salida);

            // Incrementa el objeto Calendar para apuntar al siguiente día del mes
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

        // Crea un nuevo modelo de tabla utilizando la matriz bidimensional
        DefaultTableModel model = new DefaultTableModel(data, new String[]{"DÍA", "FECHA", "ENTRADA", "SALIDA", "DURACIÓN"});

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

    public static String CalcularDuracion(String horaEntrada, String horaSalida) {
        if (horaEntrada == null) {
            horaEntrada = "00:00:00";
        }

        if (horaSalida == null) {
            horaSalida = "00:00:00";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime entrada = LocalTime.parse(horaEntrada, formatter);
        LocalTime salida = LocalTime.parse(horaSalida, formatter);

        // Obtener el tiempo transcurrido entre la hora de entrada y salida
        Duration tiempoEnLaEmpresa = Duration.between(entrada, salida);

        // Dividimos el tiempo transcurrido en horas, minutos y segundos
        long horas = tiempoEnLaEmpresa.toHours();
        long minutos = tiempoEnLaEmpresa.toMinutesPart();
        long segundos = tiempoEnLaEmpresa.toSecondsPart();

        String tiempoTotal = String.format("%02d:%02d:%02d", horas, minutos, segundos);

        return tiempoTotal;
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

    public static int ObtenerID(String dni, String fecha, String hora) {
        int id = 0;
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_asistencia(?, ?, ?, ?) }");) {
            cstmt.setString(1, dni);
            cstmt.setString(2, fecha);
            cstmt.setString(3, hora);
            cstmt.registerOutParameter(4, Types.INTEGER);

            cstmt.execute();

            id = cstmt.getInt(4);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("id = " + id);
        return id;
    }

    public static void Actualizar(Asistencia a, String hora, JTable tabla, JComboBox periodo, JComboBox combo) {
        int id = ObtenerID(a.getDni(), a.getFecha(), hora);
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_asistencia(?, ?) }");) {
            cstmt.setInt(1, id);
            cstmt.setString(2, a.getHora());

            cstmt.execute();

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            RellenarTabla(tabla, periodo, combo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Insertar(Asistencia a, JTable tabla, JComboBox periodo, JComboBox combo) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL insertar_asistencia(?, ?, ?) }")) {
            cstmt.setString(1, a.getDni());
            cstmt.setString(2, a.getFecha());
            cstmt.setString(3, a.getHora());

            cstmt.execute();

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            RellenarTabla(tabla, periodo, combo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
