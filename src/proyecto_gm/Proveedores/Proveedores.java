package proyecto_gm.Proveedores;

public class Proveedores {

    private int idProveedor;
    private int idDepartamento;
    private String nombres;
    private String direccion;
    private String correo;
    private String telefono;
    private String celular;       
    private String ruc;
    private String provincia;     
    private String distrito;      
    private String rubro;        
    private String estado;        

    private String nombreDepartamento;


    public Proveedores() {
    }

    // Constructor para crear un nuevo proveedor (sin ID, la BD lo genera)
    public Proveedores(int idDepartamento, String nombres, String direccion, String correo,
                       String telefono, String celular, String ruc, String provincia,
                       String distrito, String rubro, String estado) {
        this.idDepartamento = idDepartamento;
        this.nombres = nombres;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.celular = celular;
        this.ruc = ruc;
        this.provincia = provincia;
        this.distrito = distrito;
        this.rubro = rubro;
        this.estado = estado;
    }

    public Proveedores(int idProveedor, int idDepartamento, String nombres, String direccion, String correo,
                       String telefono, String celular, String ruc, String provincia,
                       String distrito, String rubro, String estado, String nombreDepartamento) {
        this.idProveedor = idProveedor;
        this.idDepartamento = idDepartamento;
        this.nombres = nombres;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.celular = celular;
        this.ruc = ruc;
        this.provincia = provincia;
        this.distrito = distrito;
        this.rubro = rubro;
        this.estado = estado;
        this.nombreDepartamento = nombreDepartamento;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}
