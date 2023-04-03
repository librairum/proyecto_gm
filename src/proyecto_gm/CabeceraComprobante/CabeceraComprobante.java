package proyecto_gm.CabeceraComprobante;

public class CabeceraComprobante {
    //Atributos
    String NumeroComprobante;
    String FechaEmision;
    String FechaVencimiento;
    float Total;
    String IdProveedores;
    String IdTipoDocumento;
    
    public CabeceraComprobante (String NumeroComprobante, String FechaEmision, String FechaVencimiento,
            float Total, String IdProveedores, String TipoDocumento)
    {
        this.NumeroComprobante=NumeroComprobante;
        this.FechaEmision=FechaEmision;
        this.FechaVencimiento=FechaVencimiento;
        this.Total= Total;
        this.IdProveedores= IdProveedores;
        this.IdTipoDocumento= TipoDocumento;
        
    }
    public CabeceraComprobante() {
        
    }

    public String getNumeroComprobante() {
        return NumeroComprobante;
    }

    public void setNumeroComprobante(String NumeroComprobante) {
        this.NumeroComprobante = NumeroComprobante;
    }

    public String getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(String FechaEmision) {
        this.FechaEmision = FechaEmision;
    }

    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(String FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public String getIdProveedores() {
        return IdProveedores;
    }

    public void setIdProveedores(String IdProveedores) {
        this.IdProveedores = IdProveedores;
    }

    public String getIdTipoDocumento() {
        return IdTipoDocumento;
    }

    public void setIdTipoDocumento(String IdTipoDocumento) {
        this.IdTipoDocumento = IdTipoDocumento;
    }

    
}
