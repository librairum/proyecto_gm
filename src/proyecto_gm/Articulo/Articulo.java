package proyecto_gm.Articulo;

public class Articulo {

    protected String id, descripcion, idCategoria;

    // Constructor
    public Articulo(String id, String descripcion, String idCategoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
    }

    //get y set
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

}
