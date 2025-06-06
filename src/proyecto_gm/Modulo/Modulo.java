package proyecto_gm.Modulo;

public class Modulo {
    // Atributos
    private int Id;
    private String Descripcion;

    // Constructor con parámetros
    public Modulo(int Id, String Descripcion) {
        this.Id = Id;
        this.Descripcion = Descripcion;
    }

    // Constructor vacío
    public Modulo() {
    }

    // Getters y setters
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return Descripcion;
    }
}
