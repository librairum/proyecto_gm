package proyecto_gm.Mac;

import proyecto_gm.ConexionBD;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

public class DatosMac {

    public String validarAcceso(int idUsuario) {
        String macActual = obtenerMac();
        System.out.println("Validando acceso para ID: " + idUsuario);
        System.out.println("MAC detectada: " + macActual);

        if (macActual.equals("ERROR")) return "ERROR_MAC";

        ControlMac datos = buscarMacEspecifica(idUsuario, macActual);

        if (datos == null) {
            System.out.println("Nueva PC detectada. Registrando...");
            if (insertar(idUsuario, macActual)) {
                return "PERMITIDO_NUEVO";
            } else {
                return "ERROR_DB";
            }
        } else {
            System.out.println("PC registrada encontrada.");
            
            if (datos.getEstado() != null && datos.getEstado().equalsIgnoreCase("DENEGADO")) {
                return "DENEGADO_MANUAL";
            }

            if (datos.getDiaFinalizacion() != null && new Date().after(datos.getDiaFinalizacion())) {
                return "DENEGADO_LICENCIA";
            }
            
            actualizarSesion(datos.getIdControl());
            return "PERMITIDO";
        }
    }

    public boolean insertar(int idUsuario, String mac) {
        String nombrePC = obtenerNombrePC();
        String sql = "INSERT INTO control_mac (id_usuario, mac_address, nombre_pc, ultima_sesion, inicio_instalacion, dia_finalizacion, estado) " +
                     "VALUES (?, ?, ?, ?, ?, DATE_ADD(?, INTERVAL 30 DAY), 'PENDIENTE')";
        try {
            Connection con = ConexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            Timestamp horaLocal = new Timestamp(System.currentTimeMillis());

            ps.setInt(1, idUsuario);
            ps.setString(2, mac);
            ps.setString(3, nombrePC);
            ps.setTimestamp(4, horaLocal);
            ps.setTimestamp(5, horaLocal);
            ps.setTimestamp(6, horaLocal);
            
            ps.executeUpdate();
            System.out.println("Registro exitoso en BD.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    public ControlMac buscarMacEspecifica(int idUsuario, String mac) {
        ControlMac cm = null;
        String sql = "SELECT * FROM control_mac WHERE id_usuario = ? AND mac_address = ?";
        try {
            Connection con = ConexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.setString(2, mac);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                cm = new ControlMac();
                cm.setIdControl(rs.getInt("id_control"));
                cm.setIdUsuario(rs.getInt("id_usuario"));
                cm.setMacAddress(rs.getString("mac_address"));
                cm.setDiaFinalizacion(rs.getTimestamp("dia_finalizacion"));
                cm.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar: " + e);
        }
        return cm;
    }

    public void actualizarSesion(int idControl) {
        try {
            Connection con = ConexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE control_mac SET ultima_sesion = ? WHERE id_control = ?");
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setInt(2, idControl);
            ps.executeUpdate();
        } catch (Exception e) { System.out.println(e); }
    }

    private String obtenerMac() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            if (mac == null) return "ERROR";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        } catch (Exception e) { return "ERROR"; }
    }

    private String obtenerNombrePC() {
        try { return InetAddress.getLocalHost().getHostName(); } catch (Exception e) { return "Desconocido"; }
    }
}