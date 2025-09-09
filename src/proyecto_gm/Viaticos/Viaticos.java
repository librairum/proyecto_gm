package proyecto_gm.Viaticos;

public class Viaticos {
    private int id;
    private String descripcion;
    private float pasaje;
    private float menu;
    private String idEmpleado;
    private String idPeriodo;

    public Viaticos() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public float getPasaje() { return pasaje; }
    public void setPasaje(float pasaje) { this.pasaje = pasaje; }

    public float getMenu() { return menu; }
    public void setMenu(float menu) { this.menu = menu; }

    public String getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(String idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getIdPeriodo() { return idPeriodo; }
    public void setIdPeriodo(String idPeriodo) { this.idPeriodo = idPeriodo; }
}
