
package proyecto_gm.Perfil;



public class Perfil {
    private String codigo;
    private String nombre;

    public Perfil(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() { 
        return codigo; 
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

 
    public String getNombre() { 
        return nombre; 
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void insertarPerfil() {
        String codmodulo = "01";  
        
    }

    @Override
    public String toString() {
        return nombre; 
    }
}


