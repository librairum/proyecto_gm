/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Cuentas;

/**
 *
 * @author Usuario
 */
public class Banco {
    private int id;
    private String descripcion;

    public Banco(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
