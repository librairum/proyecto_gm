package proyecto_gm.CajaChica;

public class CajaChica {
    
    //Atributos
    String Id;    
    int IdTransferenciasBancarias;
    String Fecha;
    String Descripcion;
    float Entrada;
    float Salida;
    float Saldo;

    public CajaChica(String Id, int IdTransferenciasBancarias, String Fecha, String Descripcion, float Entrada, float Salida, float Saldo) {
        this.Id = Id;
        this.IdTransferenciasBancarias = IdTransferenciasBancarias;
        this.Fecha = Fecha;
        this.Descripcion = Descripcion;
        this.Entrada = Entrada;
        this.Salida = Salida;
        this.Saldo = Saldo;
    }
    
    public CajaChica() {
    }

    public CajaChica(int IdTransferenciasBancarias) {
        this.IdTransferenciasBancarias = IdTransferenciasBancarias;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getIdTransferenciasBancarias() {
        return IdTransferenciasBancarias;
    }

    public void setIdTransferenciasBancarias(int IdTransferenciasBancarias) {
        this.IdTransferenciasBancarias = IdTransferenciasBancarias;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getEntrada() {
        return Entrada;
    }

    public void setEntrada(float Entrada) {
        this.Entrada = Entrada;
    }

    public float getSalida() {
        return Salida;
    }

    public void setSalida(float Salida) {
        this.Salida = Salida;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }

    @Override
     public String toString() {
      return String.valueOf(IdTransferenciasBancarias);
    }
}
