package proyecto_gm.Mac;

import java.sql.Timestamp;

public class ControlMac {
    private int idControl;
    private int idUsuario;
    private String macAddress;
    private Timestamp ultimaSesion;
    private Timestamp inicioInstalacion;
    private Timestamp diaFinalizacion;
    private String estado;

    public ControlMac() {
    }

    public int getIdControl() { return idControl; }
    public void setIdControl(int idControl) { this.idControl = idControl; }
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getMacAddress() { return macAddress; }
    public void setMacAddress(String macAddress) { this.macAddress = macAddress; }
    public Timestamp getUltimaSesion() { return ultimaSesion; }
    public void setUltimaSesion(Timestamp ultimaSesion) { this.ultimaSesion = ultimaSesion; }
    public Timestamp getInicioInstalacion() { return inicioInstalacion; }
    public void setInicioInstalacion(Timestamp inicioInstalacion) { this.inicioInstalacion = inicioInstalacion; }
    public Timestamp getDiaFinalizacion() { return diaFinalizacion; }
    public void setDiaFinalizacion(Timestamp diaFinalizacion) { this.diaFinalizacion = diaFinalizacion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}