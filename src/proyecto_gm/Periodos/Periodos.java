package proyecto_gm.Periodos;

public class Periodos {
    private String id, descripcion;

    public Periodos() {
        // Constructor vacio
    }

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
    
    @Override
    public String toString() {
        return id;
    }    
}
