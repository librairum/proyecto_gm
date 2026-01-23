package Actualizador;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import java.io.File;

public class Actualizador {

    public String comprobarNuevaVersion() {
        try {
            String modo = Configurador.getDato("flag_modo_actualiza");
            if (modo == null || modo.equalsIgnoreCase("false")) {
                return null;
            }

            String urlRepo = Configurador.getDato("url_github");
            
            if (urlRepo == null || urlRepo.trim().isEmpty() || urlRepo.equals("null")) {
                return "ERROR_SERVIDOR";
            }

            if (urlRepo.contains("?")) {
                urlRepo += "&nocache=" + System.currentTimeMillis();
            } else {
                urlRepo += "?nocache=" + System.currentTimeMillis();
            }

            URL url = new URL(urlRepo);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            
            con.setUseCaches(false);
            con.setRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
            con.setRequestProperty("Pragma", "no-cache");
            con.setRequestProperty("Expires", "0");
            
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            
            int status = con.getResponseCode();
            if(status == 404){
                return null;
            }
            if (status != 200) {
                return "ERROR_SERVIDOR";
            }

            Scanner scanner = new Scanner(con.getInputStream());
            String response = scanner.useDelimiter("\\A").next();
            scanner.close();

            if (response.contains("\"tag_name\":\"")) {
                int inicioTag = response.indexOf("\"tag_name\":\"") + 12;
                int finTag = response.indexOf("\"", inicioTag);
                
                String versionNube = response.substring(inicioTag, finTag).replace("v", "").trim();

                String versionLocal = "1.0";
                try {
                    File fVer = new File("version.txt");
                    if(fVer.exists()){
                         versionLocal = new String(Files.readAllBytes(fVer.toPath())).trim().replace("v", "");
                    }
                } catch (Exception e) {
                }

                if (!versionNube.equals(versionLocal)) {
                    return versionNube + "|" + response;
                }
            }
        } catch (MalformedURLException e) {
            return "ERROR_SERVIDOR";
        } catch (UnknownHostException | java.net.SocketTimeoutException e) {
            return "ERROR_CONEXION";
        } catch (Exception e) {
            return "ERROR_SERVIDOR";
        }
        return null;
    }

    public void descargarYActualizar(String jsonResponse, String nuevaVersion, JProgressBar barra) {
        try {
            if (!descargarArchivo(jsonResponse, "proyecto_gm.jar", "proyecto_gm_nuevo.jar", barra, true)) {
                JOptionPane.showMessageDialog(null, "Error: No se encontró 'proyecto_gm.jar' en GitHub");
                return;
            }

            boolean jsonDescargado = descargarArchivo(jsonResponse, "proyect_gm.config.json", "config_nuevo.json", null, false);

            Files.write(Paths.get("version.txt"), nuevaVersion.getBytes());

            JOptionPane.showMessageDialog(null, 
                    "Actualización completada exitosamente.\nEl programa se cerrará. Por favor, ábralo nuevamente.", 
                    "Actualización Finalizada", 
                    JOptionPane.INFORMATION_MESSAGE);

            crearScriptReinicio(jsonDescargado);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error actualizando: " + e.getMessage());
        }
    }

    private boolean descargarArchivo(String jsonResponse, String nombreArchivoNube, String nombreArchivoLocal, JProgressBar barra, boolean esPrincipal) {
        try {
            int pos = jsonResponse.indexOf(nombreArchivoNube);
            if (pos == -1) return false;

            int inicioUrl = jsonResponse.indexOf("\"browser_download_url\":\"", pos) + 24;
            
            if (inicioUrl < 24 || inicioUrl > jsonResponse.length()) return false;

            int finUrl = jsonResponse.indexOf("\"", inicioUrl);
            String urlArchivo = jsonResponse.substring(inicioUrl, finUrl);

            URL url = new URL(urlArchivo);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivoLocal);
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            long downloadedFileSize = 0;

            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                downloadedFileSize += bytesRead;
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                
                if (esPrincipal && barra != null && completeFileSize > 0) {
                    final int currentProgress = (int) ((((double)downloadedFileSize) / ((double)completeFileSize)) * 100d);
                    SwingUtilities.invokeLater(() -> barra.setValue(currentProgress));
                }
            }
            
            fileOutputStream.close();
            in.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void crearScriptReinicio(boolean actualizarJson) throws Exception {
        String rutaActual = Paths.get("").toAbsolutePath().toString();
        
        String vbs = "WScript.Sleep 2000\n" +
                     "Set fso = CreateObject(\"Scripting.FileSystemObject\")\n" +
                     "Set shell = CreateObject(\"WScript.Shell\")\n" +
                     "shell.CurrentDirectory = \"" + rutaActual + "\"\n" + 
                     
                     "If fso.FileExists(\"proyecto_gm.jar\") Then fso.DeleteFile \"proyecto_gm.jar\"\n" +
                     "If fso.FileExists(\"proyecto_gm_nuevo.jar\") Then fso.MoveFile \"proyecto_gm_nuevo.jar\", \"proyecto_gm.jar\"\n";

        if (actualizarJson) {
            vbs += "If fso.FileExists(\"proyect_gm.config.json\") Then fso.DeleteFile \"proyect_gm.config.json\"\n" +
                   "If fso.FileExists(\"config_nuevo.json\") Then fso.MoveFile \"config_nuevo.json\", \"proyect_gm.config.json\"\n";
        }
                     
        vbs += "fso.DeleteFile WScript.ScriptFullName";

        Files.write(Paths.get("update.vbs"), vbs.getBytes());
        Runtime.getRuntime().exec("wscript.exe update.vbs");
        System.exit(0);
    }
}

