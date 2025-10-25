
package proyecto_gm.Permisoxperfil;

public class Perfil {
    private String codigo;
    private String nombre;

    public Perfil(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre;
    }
}


