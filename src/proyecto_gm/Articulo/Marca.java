package proyecto_gm.Articulo;

public class Marca {
    private int idMarca;
    private String descripcion;
    
    public Marca() {}
    
    public Marca(int idMarca, String descripcion) {
        this.idMarca = idMarca;
        this.descripcion = descripcion;
    }
    
    // Getters y Setters
    public int getIdMarca() { 
        return idMarca; 
    }
    
    public void setIdMarca(int idMarca) { 
        this.idMarca = idMarca; 
    }
    
    public String getDescripcion() { 
        return descripcion; 
    }
    
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }
    
    // Para que se muestre correctamente en el JComboBox
    @Override
    public String toString() {
        return descripcion != null ? descripcion : "";
    }
    
    // Métodos equals y hashCode para comparaciones correctas
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Marca marca = (Marca) obj;
        return idMarca == marca.idMarca;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(idMarca);
    }
}