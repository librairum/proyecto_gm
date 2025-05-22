package proyecto_gm.Categoria;

public class Categoria {

    int idCat;
    String descripcionCat;

    public Categoria() {
    }

    public Categoria(int idCat, String descripcionCat) {
        this.idCat = idCat;
        this.descripcionCat = descripcionCat;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getDescripcionCat() {
        return descripcionCat;
    }

    public void setDescripcionCat(String descripcionCat) {
        this.descripcionCat = descripcionCat;
    }
    
    @Override
    public String toString() {
        return descripcionCat; // esto es lo que se verá en el combo
    }

}
