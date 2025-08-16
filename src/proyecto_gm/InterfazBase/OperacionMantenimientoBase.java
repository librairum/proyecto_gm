/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyecto_gm.InterfazBase;

/**
 *
 * @author sistemas
 */
public interface OperacionMantenimientoBase {
    abstract boolean guardar();
    abstract void nuevo();
    abstract void editar();
    abstract void cancelar();
    abstract void eliminar();
}
