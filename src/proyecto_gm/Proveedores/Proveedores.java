package proyecto_gm.Proveedores;

public class Proveedores {

    private int idProveedor;
    private int idDepartamento;
    private String nombres;
    private String direccion;
    private String correo;
    private String telefono;
    private String ruc;
    
    // Campo adicional para mostrar el nombre del departamento en la tabla
    private String nombreDepartamento;

    // Constructor vacío
    public Proveedores() {
    }

    // Constructor para crear un nuevo proveedor (sin ID, la BD lo genera)
    public Proveedores(int idDepartamento, String nombres, String direccion, String correo, String telefono, String ruc) {
        this.idDepartamento = idDepartamento;
        this.nombres = nombres;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.ruc = ruc;
    }

    // Constructor completo para leer datos de la BD
    public Proveedores(int idProveedor, int idDepartamento, String nombres, String direccion, String correo, String telefono, String ruc) {
        this.idProveedor = idProveedor;
        this.idDepartamento = idDepartamento;
        this.nombres = nombres;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.ruc = ruc;
    }

    // Getters y Setters
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}