package proyecto_gm.Area;

public class Area {
    //Atributos
    String idArea;  
    String descripcionArea;

    public Area() {   
    }
     
    public Area(String idArea, String descripcionArea) {
        this.idArea = idArea;
        this.descripcionArea = descripcionArea;
    }
    
    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }
    
    public String getDescripcionArea() {
        return descripcionArea;
    }

    public void setDescripcionArea(String descripcionArea) {
        this.descripcionArea = descripcionArea;
    }
    
    @Override
    public String toString() {
        return descripcionArea; 
    }
}
