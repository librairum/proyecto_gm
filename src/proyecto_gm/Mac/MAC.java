
package proyecto_gm.Mac;

import java.net.InetAddress;
import java.net.NetworkInterface;
public class MAC {
    public static String ObtenerMac() {
        if (proyecto_gm.inicio.esModoDev) return "DEV_MAC"; 
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            if (mac == null) return null;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }   
    
    public static String ObtenerNombrePC() {
        if (proyecto_gm.inicio.esModoDev) return "DEV_PC"; 
        try {
            return java.net.InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            return "Desconocido";
        }
    }
}
