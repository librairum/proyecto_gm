package proyecto_gm.Proveedores;

public class Proveedores {
    //Atributos

    int IdProveedor;
            String Nombres; 
            String Direccion, Correo, Telefono, Ruc;
                    int departamentoId;
                    String nombreDepartamento;
    public Proveedores(int IdProveedor, String Nombres, String Direccion, 
            String Correo, String Telefono, String Ruc, int departamentoId) {
        this.IdProveedor = IdProveedor;
        this.Nombres = Nombres;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.Ruc = Ruc;
        this.departamentoId = departamentoId;
    }

    public Proveedores() {
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }
    
    public String getDepartamentoNombre(){
        return nombreDepartamento;
    }
    public void setDepartamentoNombre(String depaNombre){
        this.nombreDepartamento = depaNombre;
    }
    
    
}
