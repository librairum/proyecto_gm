package proyecto_gm.Cuentas;

public class Banco {
    private int id;
    private String descripcion;

    public Banco(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}