
package proyecto_gm.Asistencias;

public class AsistenciaImagenes {

    public AsistenciaImagenes(){
    
    }
    public int getId_foto() {
        return id_foto;
    }

    public void setId_foto(int id_foto) {
        this.id_foto = id_foto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public byte[] getImagenEnBytes() {
        return imagenEnBytes;
    }

    public void setImagenEnBytes(byte[] imagenEnBytes) {
        this.imagenEnBytes = imagenEnBytes;
    }
    
    private int id_foto;
    private String dni;
    private String nombreEquipo; 
    private String fecha;        
    private String hora;        
    private byte[] imagenEnBytes; 

    public AsistenciaImagenes(String dni, String nomPc, String fecha, String hora){
        this.dni = dni;
        this.nombreEquipo = nomPc;
        this.fecha = fecha;
        this.hora = hora;
    }
}
