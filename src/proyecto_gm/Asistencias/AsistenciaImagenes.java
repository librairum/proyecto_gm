/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Asistencias;

/**
 *
 * @author sistemas
 */
public class AsistenciaImagenes {

    /**
     * @return the id_foto
     */
    public AsistenciaImagenes(){
    
    }
    public int getId_foto() {
        return id_foto;
    }

    /**
     * @param id_foto the id_foto to set
     */
    public void setId_foto(int id_foto) {
        this.id_foto = id_foto;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombreEquipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * @param nombreEquipo the nombreEquipo to set
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the imagenEnBytes
     */
    public byte[] getImagenEnBytes() {
        return imagenEnBytes;
    }

    /**
     * @param imagenEnBytes the imagenEnBytes to set
     */
    public void setImagenEnBytes(byte[] imagenEnBytes) {
        this.imagenEnBytes = imagenEnBytes;
    }
        private int id_foto;
    private String dni;
    private String nombreEquipo; // Se usa camelCase para nombres de variables en Java
    private String fecha;        // Mantener como String si se lee como VARCHAR(10)
    private String hora;         // Mantener como String si se lee como VARCHAR(10)
    private byte[] imagenEnBytes; // Para almacenar el contenido de LONGBLOB como un arreglo de bytes

    public AsistenciaImagenes(String dni, String nomPc, String fecha, String hora){
        this.dni = dni;
        this.nombreEquipo = nomPc;
        this.fecha = fecha;
        this.hora = hora;
    }
}
