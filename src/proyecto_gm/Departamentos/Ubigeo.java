package proyecto_gm.Departamentos;
public class Ubigeo {
    private String codigo;
    private String nombre;

    public Ubigeo(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;  
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}

