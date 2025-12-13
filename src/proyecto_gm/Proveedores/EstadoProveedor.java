package proyecto_gm.Proveedores;

/**
 *
 * @author Cristian
 */
public class EstadoProveedor {
    private int codigo;
    private String descripcion;
    private String tipo;

    public EstadoProveedor(int codigo, String descripcion, String tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public int getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return descripcion;  
    }
}
