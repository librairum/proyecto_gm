package proyecto_gm.Articulo;

import proyecto_gm.Categoria.Categoria;

public class Articulo {
    private int idArticulo;
    private Integer idCategoria;
    private Integer idMarca;
    private String caracteristicas;
    private String descripcion;
    private double cantidad;
    
    private Marca marca;       // objeto Marca
    private Categoria categoria; // objeto Categoria

    public Articulo() {}

    public Articulo(int idArticulo, Integer idCategoria, Integer idMarca, String caracteristicas) {
        this.idArticulo = idArticulo;
        this.idCategoria = idCategoria;
        this.idMarca = idMarca;
        this.caracteristicas = caracteristicas;
    }

    // Getters y Setters
    public int getIdArticulo() { return idArticulo; }
    public void setIdArticulo(int idArticulo) { this.idArticulo = idArticulo; }

    public Integer getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }

    public Integer getIdMarca() { return idMarca; }
    public void setIdMarca(Integer idMarca) { this.idMarca = idMarca; }

    public String getCaracteristicas() { return caracteristicas; }
    public void setCaracteristicas(String caracteristicas) { this.caracteristicas = caracteristicas; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getCantidad() { return cantidad; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
