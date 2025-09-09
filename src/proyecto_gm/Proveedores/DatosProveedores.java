package proyecto_gm.Proveedores;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_gm.ConexionBD;
import proyecto_gm.Departamentos.Departamentos;

public class DatosProveedores {

    /**
     * Obtiene una lista de todos los proveedores desde la base de datos.
     * @return Una lista de objetos Proveedores.
     */
    public List<Proveedores> listar() {
        List<Proveedores> lista = new ArrayList<>();
        String sql = "{ CALL listar_proveedores() }";
        
        try (Connection conn = ConexionBD.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {
            
            while (rs.next()) {
                Proveedores prov = new Proveedores();
                prov.setIdProveedor(rs.getInt("IdProveedor"));
                prov.setNombres(rs.getString("Nombres"));
                prov.setDireccion(rs.getString("Direccion"));
                prov.setCorreo(rs.getString("Correo"));
                prov.setTelefono(rs.getString("Telefono"));
                prov.setRuc(rs.getString("Ruc"));
                prov.setIdDepartamento(rs.getInt("IdDepartamento"));
                prov.setNombreDepartamento(rs.getString("Descripcion")); // Asume que el SP devuelve la descripción del depto.
                lista.add(prov);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar proveedores: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar proveedores: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    /**
     * Obtiene los datos de un proveedor específico por su ID.
     * @param idProveedor El ID del proveedor a buscar.
     * @return Un objeto Proveedores o null si no se encuentra.
     */
    public Proveedores obtenerPorId(int idProveedor) {
        Proveedores prov = null;
        String sql = "{ CALL obtener_proveedor(?) }";
        
        try (Connection conn = ConexionBD.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            
            cstmt.setInt(1, idProveedor);
            try (ResultSet rs = cstmt.executeQuery()) {
                if (rs.next()) {
                    prov = new Proveedores();
                    prov.setIdProveedor(rs.getInt("IdProveedor"));
                    prov.setNombres(rs.getString("Nombres"));
                    prov.setDireccion(rs.getString("Direccion"));
                    prov.setCorreo(rs.getString("Correo"));
                    prov.setTelefono(rs.getString("Telefono"));
                    prov.setRuc(rs.getString("Ruc"));
                    prov.setIdDepartamento(rs.getInt("IdDepartamento"));
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener proveedor: " + ex.getMessage());
        }
        return prov;
    }
    
    /**
     * Inserta un nuevo proveedor en la base de datos.
     * El ID es autoincremental, por lo que no se envía.
     * @param proveedor El objeto Proveedor con los datos a insertar.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    public boolean insertar(Proveedores proveedor) {
        // El SP no debe pedir el IdProveedor
        String sql = "{ CALL insertar_proveedores(?, ?, ?, ?, ?, ?) }"; 
        
        try (Connection conn = ConexionBD.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            
            cstmt.setInt(1, proveedor.getIdDepartamento());
            cstmt.setString(2, proveedor.getNombres());
            cstmt.setString(3, proveedor.getDireccion());
            cstmt.setString(4, proveedor.getCorreo());
            cstmt.setString(5, proveedor.getTelefono());
            cstmt.setString(6, proveedor.getRuc());
            
            return cstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al insertar proveedor: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Actualiza un proveedor existente en la base de datos.
     * @param proveedor El objeto Proveedor con el ID y los nuevos datos.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean actualizar(Proveedores proveedor) {
        String sql = "{ CALL actualizar_proveedores(?, ?, ?, ?, ?, ?, ?) }";
        
        try (Connection conn = ConexionBD.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            
            cstmt.setInt(1, proveedor.getIdProveedor());
            cstmt.setInt(2, proveedor.getIdDepartamento());
            cstmt.setString(3, proveedor.getNombres());
            cstmt.setString(4, proveedor.getDireccion());
            cstmt.setString(5, proveedor.getCorreo());
            cstmt.setString(6, proveedor.getTelefono());
            cstmt.setString(7, proveedor.getRuc());
            
            return cstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar proveedor: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Elimina un proveedor de la base de datos usando su ID.
     * @param idProveedor El ID del proveedor a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminar(int idProveedor) {
        String sql = "{ CALL eliminar_proveedores(?) }";
        
        try (Connection conn = ConexionBD.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            
            cstmt.setInt(1, idProveedor);
            return cstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar proveedor: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Obtiene la lista de departamentos para llenar un ComboBox.
     * @return Una lista de objetos Departamentos.
     */
    public List<Departamentos> listarDepartamentos() {
        List<Departamentos> lista = new ArrayList<>();
        String sql = "{ CALL listar_departamentos() }";
        
        try (Connection conn = ConexionBD.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("IdDepartamento");
                String descripcion = rs.getString("Descripcion");
                lista.add(new Departamentos(id, descripcion));
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar departamentos: " + ex.getMessage());
        }
        return lista;
    }
}