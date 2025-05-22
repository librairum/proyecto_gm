package proyecto_gm.Articulo;

public class Articulo {
    protected int idArticulo;
    protected Integer idCategoria;
    protected Integer idMarca;
    private String caracteristicas;
    protected String descripcion;
    private double cantidad;

    public Articulo(int idArticulo, Integer idCategoria, Integer idMarca, String caracteristicas) {
        this.idArticulo = idArticulo;
        this.idCategoria = idCategoria;
        this.idMarca = idMarca;
        this.caracteristicas = caracteristicas;
    }

    // Getters y Setters

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
}
