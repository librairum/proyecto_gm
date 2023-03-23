/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Comunicacion;

import java.awt.TrayIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author pc_sistemas2022
 */
public class Utilitario {
    enum EstadoProceso{
        NUEVO,
        EDITAR,
        ELIMINAR,
        CONSULTAR
    }
    enum TipoMensaje{
        alerta,
        informativo,
        error
    }
    static void MostrarMensaje(String mensaje, TipoMensaje tipo  ){
        if(null != tipo)switch (tipo) {
            case informativo:
                JOptionPane.showMessageDialog(null, mensaje, "Sistema", JOptionPane.INFORMATION_MESSAGE);
                break;
            case alerta:
                JOptionPane.showMessageDialog(null, mensaje, "Sistema", JOptionPane.WARNING_MESSAGE);
                break;
            case error:
                JOptionPane.showMessageDialog(null, mensaje, "Sistema", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                break;
        }
        
    }
//    static void MostrarMensajeInformacion(String mensaje, String titulo){
//    
//    }
    
    
}
