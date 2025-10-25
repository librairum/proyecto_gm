package proyecto_gm.Permisoxperfil;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import proyecto_gm.ConexionBD;

public class DatosPermisoxPerfil {

    private static final Connection conn = ConexionBD.getConnection();

   
    public List<Perfil> listarPerfiles() {
        List<Perfil> lista = new ArrayList<>();
        String sql = "CALL listar_Perfiles()"; 
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String codigo = rs.getString("codperfil");
                String nombre = rs.getString("nomperfil");
                lista.add(new Perfil(codigo, nombre));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al listar perfiles: " + e.getMessage(),
                "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    
    public List<MenuArbol> listarMenus() {
        List<MenuArbol> lista = new ArrayList<>();
        String sql = "CALL listar_menugenerales()"; 

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new MenuArbol(
                    rs.getString("codigo"),
                    rs.getString("etiqueta"),
                    rs.getString("nivel1"),
                    rs.getString("nivel2"),
                    rs.getString("nivel3"),
                    null,
                    null,
                    rs.getString("codmodulo")
                ));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al listar menús: " + e.getMessage(),
                "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

   
    public List<MenuArbol> listarMenusPorPerfil(String codPerfil) {
        List<MenuArbol> lista = new ArrayList<>();
        String sql = "{CALL listar_menusxperfil(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, codPerfil);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    lista.add(new MenuArbol(
                        rs.getString("codigo"),
                        rs.getString("etiqueta"),
                        rs.getString("nivel1"),
                        rs.getString("nivel2"),
                        rs.getString("nivel3"),
                        null,
                        null,
                        rs.getString("codmodulo")
                    ));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al listar menús por perfil: " + e.getMessage(),
                "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    
    public boolean insertarMenuPerfil(String codPerfil, String codMenu) {
        String sql = "CALL insertar_menuaperfil(?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, codPerfil);
            ps.setString(2, codMenu);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                "Error al insertar menú-perfil: " + e.getMessage(),
                "Error SQL", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,
                "Error al eliminar menú-perfil: " + e.getMessage(),
                "Error SQL", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
