package proyecto_gm.CabeceraComprobante;

public class CabeceraComprobante {
    //Atributos
    String NumeroFactura;
    String FechaEmision;
    String FechaVencimiento;
    float Total;
    String IdProveedores;
    String IdTipoDocumento;
    
    public CabeceraComprobante (String NumeroFactura, String FechaEmision, String FechaVencimiento,
            float Total, String IdProveedores, String TipoDocumento)
    {
        this.NumeroFactura=NumeroFactura;
        this.FechaEmision=FechaEmision;
        this.FechaVencimiento=FechaVencimiento;
        this.Total= Total;
        this.IdProveedores= IdProveedores;
        this.IdTipoDocumento= TipoDocumento;
        
    
    }
    public CabeceraComprobante() {
        
    }

    public String getNumeroFactura() {
        return NumeroFactura;
    }

    public void setNumeroFactura(String NumeroFactura) {
        this.NumeroFactura = NumeroFactura;
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
