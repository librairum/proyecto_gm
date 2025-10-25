
package proyecto_gm.Permisoxperfil;
/**
 *
 * @author Cristian
 */
public class MenuArbol {
    private String codigo;
    private String etiqueta;
    private String nivel1;
    private String nivel2;
    private String nivel3;
    private String codigoFormulario;
    private String nombreIcono;
    private String codmodulo;

    public MenuArbol(String codigo, String etiqueta, String nivel1, String nivel2, String nivel3,
                     String codigoFormulario, String nombreIcono, String codmodulo) {
        this.codigo = codigo;
        this.etiqueta = etiqueta;
        this.nivel1 = nivel1;
        this.nivel2 = nivel2;
        this.nivel3 = nivel3;
        this.codigoFormulario = codigoFormulario;
        this.nombreIcono = nombreIcono;
        this.codmodulo = codmodulo;
    }

    
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getEtiqueta() { return etiqueta; }
    public void setEtiqueta(String etiqueta) { this.etiqueta = etiqueta; }

    public String getNivel1() { return nivel1; }
    public void setNivel1(String nivel1) { this.nivel1 = nivel1; }

    public String getNivel2() { return nivel2; }
    public void setNivel2(String nivel2) { this.nivel2 = nivel2; }

    public String getNivel3() { return nivel3; }
    public void setNivel3(String nivel3) { this.nivel3 = nivel3; }

    public String getCodigoFormulario() { return codigoFormulario; }
    public void setCodigoFormulario(String codigoFormulario) { this.codigoFormulario = codigoFormulario; }

    public String getNombreIcono() { return nombreIcono; }
    public void setNombreIcono(String nombreIcono) { this.nombreIcono = nombreIcono; }

    public String getCodmodulo() { return codmodulo; }
    public void setCodmodulo(String codmodulo) { this.codmodulo = codmodulo; }

    @Override
    public String toString() {
        return etiqueta;
    }
}
