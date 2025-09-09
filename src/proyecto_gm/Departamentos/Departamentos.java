package proyecto_gm.Departamentos;

public class Departamentos {
    
    private int id; 
    private String descripcion;

    public Departamentos(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Departamentos(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Departamentos() {
        
    }

    public Departamentos(String id, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return descripcion;
    }
}