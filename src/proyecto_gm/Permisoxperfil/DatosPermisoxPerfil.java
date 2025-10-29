package proyecto_gm.Permisoxperfil;

import java.sql.*;
import java.util.*;
import proyecto_gm.ConexionBD;
import proyecto_gm.Utilitario; 

public class DatosPermisoxPerfil {

    private static final Connection conn = ConexionBD.getConnection();

    // ejecutar consultas y devolver una lista de resultados
    private <T> List<T> ejecutarConsulta(String sql, ResultSetMapper<T> mapper) {
        List<T> lista = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapper.map(rs));  
            }
        } catch (SQLException e) {
            Utilitario.MostrarMensaje("Error en la consulta: " + e.getMessage(), Utilitario.TipoMensaje.error);  
        }
        return lista;
    }
    // mapear resultados a un objeto Perfil
    private static Perfil mapearPerfil(ResultSet rs) throws SQLException {
        String codigo = rs.getString("codperfil");
        String nombre = rs.getString("nomperfil");
        return new Perfil(codigo, nombre);
    }

    //  mapear resultados a un objeto MenuArbol
    private static MenuArbol mapearMenuArbol(ResultSet rs) throws SQLException {
        return new MenuArbol(
            rs.getString("codigo"),
            rs.getString("etiqueta"),
            rs.getString("nivel1"),
            rs.getString("nivel2"),
            rs.getString("nivel3"),
            null,
            null,
            rs.getString("codmodulo")
        );
    }

 
    public List<Perfil> listarPerfiles() {
        String sql = "CALL listar_Perfiles()";
        return ejecutarConsulta(sql, DatosPermisoxPerfil::mapearPerfil);
    }

    public List<MenuArbol> listarMenus() {
        String sql = "CALL listar_menugenerales()";
        return ejecutarConsulta(sql, DatosPermisoxPerfil::mapearMenuArbol);
    }

    public List<MenuArbol> listarMenusPorPerfil(String codPerfil) {
        String sql = "{CALL listar_menusxperfil(?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, codPerfil);
            List<MenuArbol> lista = new ArrayList<>();
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearMenuArbol(rs)); 
                }
            }
            return lista;
        } catch (SQLException e) {
            Utilitario.MostrarMensaje("Error al listar menús por perfil: " + e.getMessage(), Utilitario.TipoMensaje.error);  
        }
        return new ArrayList<>();  
    }

    public boolean insertarMenuPerfil(String codPerfil, String codMenu) {
        String sql = "CALL insertar_menuaperfil(?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, codPerfil);
            ps.setString(2, codMenu);
            ps.execute();
            return true;
        } catch (SQLException e) {
            Utilitario.MostrarMensaje("Error al insertar menú-perfil: " + e.getMessage(), Utilitario.TipoMensaje.error); 
            return false;
        }
    }

    public boolean eliminarMenuPerfil(String codPerfil, String codMenu) {
        String sql = "CALL eliminar_menuaperfil(?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, codPerfil);
            ps.setString(2, codMenu);
            ps.execute();
            return true;
        } catch (SQLException e) {
            Utilitario.MostrarMensaje("Error al eliminar menú-perfil: " + e.getMessage(), Utilitario.TipoMensaje.error);  
            return false;
        }
    }


    public List<MenuArbol> CargarMenuTodo() {
        return listarMenus();  
    }

    public List<Perfil> CargarPerfiles() {
        return listarPerfiles();  
    }

    @FunctionalInterface
    public interface ResultSetMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }
}
