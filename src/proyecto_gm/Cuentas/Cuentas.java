/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Cuentas;

/**
 *
 * @author jeanv
 */
public class Cuentas {
    String id, tipoPropietario, nombres, nroCuenta, nroCuentaInterbancaria, tipoMoneda;
    int idBanco;
    
    public Cuentas() {
        // Constructo vacio
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
}
