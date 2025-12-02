package proyecto_gm.Proveedores;

import proyecto_gm.Departamentos.Ubigeo;
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
     */
    public List<Proveedores> listar() {
        List<Proveedores> lista = new ArrayList<>();
        String sql = "{ CALL listar_proveedores() }";

        try ( Connection conn = ConexionBD.getConnection();  CallableStatement cstmt = conn.prepareCall(sql);  ResultSet rs = cstmt.executeQuery()) {

            while (rs.next()) {
                Proveedores prov = new Proveedores();
                prov.setIdProveedor(rs.getInt("IdProveedor"));
                prov.setIdDepartamento(rs.getInt("IdDepartamento"));
                prov.setNombreDepartamento(rs.getString("Departamento")); // Ahora coincide con tu SP
                prov.setNombres(rs.getString("Nombres"));
                prov.setDireccion(rs.getString("Direccion"));
                prov.setCorreo(rs.getString("Correo"));
                prov.setTelefono(rs.getString("Telefono"));
                prov.setCelular(rs.getString("Celular"));
                prov.setRuc(rs.getString("Ruc"));
                prov.setProvincia(rs.getString("Provincia"));
                prov.setDistrito(rs.getString("Distrito"));
                prov.setRubro(rs.getString("Rubro"));
                prov.setEstado(rs.getString("Estado"));
                lista.add(prov);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar proveedores: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar proveedores: " + ex.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

   
    public Proveedores obtenerPorId(int idProveedor) {
        Proveedores prov = null;
        String sql = "{ CALL obtener_proveedor(?) }"; // Debes crear este SP si aún no existe

        try ( Connection conn = ConexionBD.getConnection();  CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, idProveedor);
            try ( ResultSet rs = cstmt.executeQuery()) {
                if (rs.next()) {
                    prov = new Proveedores();
                    prov.setIdProveedor(rs.getInt("IdProveedor"));
                    prov.setIdDepartamento(rs.getInt("IdDepartamento"));
                    prov.setNombreDepartamento(rs.getString("NombreDepartamento"));
                    prov.setNombres(rs.getString("Nombres"));
                    prov.setDireccion(rs.getString("Direccion"));
                    prov.setCorreo(rs.getString("Correo"));
                    prov.setTelefono(rs.getString("Telefono"));
                    prov.setCelular(rs.getString("Celular"));
                    prov.setRuc(rs.getString("Ruc"));
                    prov.setProvincia(rs.getString("Provincia"));
                    prov.setDistrito(rs.getString("Distrito"));
                    prov.setRubro(rs.getString("Rubro"));
                    prov.setEstado(rs.getString("Estado"));
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener proveedor: " + ex.getMessage());
        }
        return prov;
    }

    /**
     * Inserta un nuevo proveedor en la base de datos.
     */
    public boolean insertar(Proveedores proveedor) {
        String sql = "{ CALL insertar_proveedores(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";

        try ( Connection conn = ConexionBD.getConnection();  CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, proveedor.getIdDepartamento());
            cstmt.setString(2, proveedor.getNombres());
            cstmt.setString(3, proveedor.getDireccion());
            cstmt.setString(4, proveedor.getCorreo());
            cstmt.setString(5, proveedor.getTelefono());
            cstmt.setString(6, proveedor.getCelular());
            cstmt.setString(7, proveedor.getRuc());
            cstmt.setString(8, proveedor.getProvincia());
            cstmt.setString(9, proveedor.getDistrito());
            cstmt.setString(10, proveedor.getRubro());
            cstmt.setString(11, proveedor.getEstado());

            return cstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al insertar proveedor: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Actualiza un proveedor existente en la base de datos.
     */
    public boolean actualizar(Proveedores proveedor) {
        String sql = "{ CALL actualizar_proveedores(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";

        try ( Connection conn = ConexionBD.getConnection();  CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, proveedor.getIdProveedor());
            cstmt.setInt(2, proveedor.getIdDepartamento());
            cstmt.setString(3, proveedor.getNombres());
            cstmt.setString(4, proveedor.getDireccion());
            cstmt.setString(5, proveedor.getCorreo());
            cstmt.setString(6, proveedor.getTelefono());
            cstmt.setString(7, proveedor.getCelular());
            cstmt.setString(8, proveedor.getRuc());
            cstmt.setString(9, proveedor.getProvincia());
            cstmt.setString(10, proveedor.getDistrito());
            cstmt.setString(11, proveedor.getRubro());
            cstmt.setString(12, proveedor.getEstado());

            return cstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al actualizar proveedor: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Elimina un proveedor de la base de datos usando su ID.
     */
    public boolean eliminar(int idProveedor) {
        String sql = "{ CALL eliminar_proveedores(?) }";

        try ( Connection conn = ConexionBD.getConnection();  CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, idProveedor);
            return cstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error al eliminar proveedor: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Obtiene la lista de departamentos para llenar un ComboBox.
     */
    public List<Departamentos> listarDepartamentos() {
        List<Departamentos> lista = new ArrayList<>();
        String sql = "{ CALL listar_departamentos() }";

        try ( Connection conn = ConexionBD.getConnection();  CallableStatement cstmt = conn.prepareCall(sql);  ResultSet rs = cstmt.executeQuery()) {

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

    public List<Ubigeo> listarDepartamentosUbigeo() {
        List<Ubigeo> lista = new ArrayList<>();
        String sql = "{CALL ListaDepartamentosUbigeo()}";
        try ( Connection cn = ConexionBD.getConnection();  CallableStatement cs = cn.prepareCall(sql);  ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                lista.add(new Ubigeo(rs.getString("idDepartamento"), rs.getString("nomdep")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Ubigeo> listarProvinciasUbigeo(String idDepartamento) {
        List<Ubigeo> lista = new ArrayList<>();
        String sql = "{CALL ListaProvinciaUbigeo(?)}";
        try ( Connection cn = ConexionBD.getConnection();  CallableStatement cs = cn.prepareCall(sql)) {
            cs.setString(1, idDepartamento);
            try ( ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Ubigeo(rs.getString("idprovincia"), rs.getString("nomprov")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Ubigeo> listarDistritosUbigeo(String idDepartamento, String idProvincia) {
        List<Ubigeo> lista = new ArrayList<>();
        String sql = "{CALL ListaDistritoUbigeo(?, ?)}";
        try ( Connection cn = ConexionBD.getConnection();  CallableStatement cs = cn.prepareCall(sql)) {
            cs.setString(1, idDepartamento);
            cs.setString(2, idProvincia);
            try ( ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Ubigeo(rs.getString("iddistrito"), rs.getString("nomdist")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public List<String> listarEstadosPV() {
    List<String> lista = new ArrayList<>();
    String sql = "{CALL listar_estadospv()}";

    try (Connection cn = ConexionBD.getConnection();
         CallableStatement cs = cn.prepareCall(sql);
         ResultSet rs = cs.executeQuery()) {

        while (rs.next()) {
            lista.add(rs.getString("descripcion"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}


}
