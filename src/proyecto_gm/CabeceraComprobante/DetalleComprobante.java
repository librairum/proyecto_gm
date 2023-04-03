package proyecto_gm.CabeceraComprobante;


public class DetalleComprobante {
    //Atributos
    String Id;
    
    String Cantidad;
    String Descripcion;
    float PrecioUnitario;
    float SubTotal;
    float Igv;
    String NumeroComprobante;
    
    public DetalleComprobante(String Id,  String Cantidad, String Descripcion,float PrecioUnitario,
            float SubTotal, float Igv, String NumeroComprobante){
        
        this.Id=Id;
        this.Cantidad=Cantidad;
        this.Descripcion=Descripcion;
        this.PrecioUnitario=PrecioUnitario;
        this.SubTotal=SubTotal;
        this.Igv=Igv;
        this.NumeroComprobante=NumeroComprobante;
    
    }
    
    public DetalleComprobante(){
    
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(float PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public float getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(float SubTotal) {
        this.SubTotal = SubTotal;
    }

    public float getIgv() {
        return Igv;
    }

    public void setIgv(float Igv) {
        this.Igv = Igv;
    }

    public String getNumeroComprobante() {
        return NumeroComprobante;
    }

    public void setNumeroComprobante(String NumeroComprobante) {
        this.NumeroComprobante = NumeroComprobante;
    }

    
    
}
