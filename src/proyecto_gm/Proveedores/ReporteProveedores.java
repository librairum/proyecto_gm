package proyecto_gm.Proveedores;

import java.io.File;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import proyecto_gm.ConexionBD;

public class ReporteProveedores {

    private final String rutaReporte = "proveedores.jasper";

    public void mostrar() {
        try {
            JasperReport reporte = cargarReporte();
            if (reporte == null) return;

            HashMap<String, Object> params = new HashMap<>();
            Connection conn = ConexionBD.getConnection();

            JasperPrint jp = JasperFillManager.fillReport(reporte, params, conn);

            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setTitle("Reporte de Proveedores");
            viewer.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportarPDF() {
        try {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar reporte como PDF");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo PDF", "pdf"));

            int seleccion = fileChooser.showSaveDialog(null);

            if (seleccion != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File archivo = fileChooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();

            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }


            JasperReport reporte = cargarReporte();
            if (reporte == null) return;

            HashMap<String, Object> params = new HashMap<>();
            Connection conn = ConexionBD.getConnection();

            JasperPrint jp = JasperFillManager.fillReport(reporte, params, conn);


            JasperExportManager.exportReportToPdfFile(jp, ruta);

            JOptionPane.showMessageDialog(null,
                    "PDF generado correctamente en:\n" + ruta);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error al generar PDF: " + e.getMessage());
        }
    }

    private JasperReport cargarReporte() {
        try {
            return (JasperReport) JRLoader.loadObject(
                    getClass().getResourceAsStream(rutaReporte)
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "No se pudo cargar el archivo del reporte (.jasper)");
            ex.printStackTrace();
            return null;
        }
    }
}
