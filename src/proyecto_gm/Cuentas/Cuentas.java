package proyecto_gm.Cuentas;

public class Cuentas {
    private int idCuenta;
    private String tipoPropietario;
    private String nombres;
    private String nroCuenta;
    private String nroCuentaInterbancaria;
    private String tipoMoneda;
    private int idBanco;
    private String nombreBanco; // Campo adicional para mostrar en la tabla

    public Cuentas() {
        // Constructor vacío
    }

    // Getters y Setters
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoPropietario() {
        return tipoPropietario;
    }

    public void setTipoPropietario(String tipoPropietario) {
        this.tipoPropietario = tipoPropietario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getNroCuentaInterbancaria() {
        return nroCuentaInterbancaria;
    }

    public void setNroCuentaInterbancaria(String nroCuentaInterbancaria) {
        this.nroCuentaInterbancaria = nroCuentaInterbancaria;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }
    
    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
    
    @Override
    public String toString() {
        return nombres;
    }
}