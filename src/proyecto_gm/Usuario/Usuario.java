package proyecto_gm.Usuario;

public class Usuario {

    private int idUsuario;
    private String username;
    private String password;
    private String estado;  
    private String codPerfil;


    public Usuario(int idUsuario, String username, String password, String estado, String codPerfil) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.codPerfil = codPerfil;
    }

   
    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }


}