package Actualizador;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Configurador {
    
    private static final String FILE_NAME = "proyect_gm.config.json";

    public static String getDato(String clave) {
        try {
            File jarPath = new File(Configurador.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            String directorioReal = jarPath.getParent(); 
            File archivo = new File(directorioReal, FILE_NAME);

            if (!archivo.exists()) {
                archivo = new File(FILE_NAME);
            }

            if (archivo.exists()) {
                String contenido = new String(Files.readAllBytes(archivo.toPath()), StandardCharsets.UTF_8);
                String busqueda = "\"" + clave + "\": \"";
                
                if (contenido.contains(busqueda)) {
                    int inicio = contenido.indexOf(busqueda) + busqueda.length();
                    int fin = contenido.indexOf("\"", inicio);
                    return contenido.substring(inicio, fin);
                }
            }
            
            return null;

        } catch (Exception e) {
            return null;
        }
    }
}