package reportes;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import proyecto_gm.ConexionBD;

public class GeneradorReportes {

    public void mostrarReporte(String nombreReporte, Map<String, Object> parametros) {
        try {
            Connection conn = ConexionBD.getConnection();
            InputStream is = getClass().getResourceAsStream("/reportes/" + nombreReporte + ".jrxml");
            
            if (is == null) {
                javax.swing.JOptionPane.showMessageDialog(null, "No se encontró el archivo: " + nombreReporte);
                return;
            }

            JasperReport jr = JasperCompileManager.compileReport(is);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conn);
            
            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setTitle("Reporte de Sistema");
            viewer.setVisible(true);
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al generar reporte: " + e.getMessage());
            e.printStackTrace();
        }
    }
}