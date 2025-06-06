package proyecto_gm.TipoDocumento;

public class TipoDocumento {
    int idTipoDocumento;
    String idModulo;
    String descripcion;

    // Constructor
    public TipoDocumento(int idTipoDocumento, String idModulo, String descripcion) {
        this.idTipoDocumento = idTipoDocumento;
        this.idModulo = idModulo;
        this.descripcion = descripcion;
    }

    // Getters
    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
