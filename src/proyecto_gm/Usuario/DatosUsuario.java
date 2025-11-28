package proyecto_gm.Usuario;

import java.awt.Component;
import java.awt.Container;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_gm.Utilitario;
import proyecto_gm.ConexionBD;

public class DatosUsuario {
    static Connection conn = ConexionBD.getConnection();
    public static void Limpiar(Container contenedor) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
        }
    }
    public static void Habilitar(Container contenedor, boolean habilitar) {
        for (Component component : contenedor.getComponents()) {
            if (component instanceof JTextField || component instanceof JComboBox) {
                component.setEnabled(habilitar);
            } else if (component instanceof JButton) {
                String button = ((JButton) component).getName();
                boolean esEditable = "guardar".equals(button) || "deshacer".equals(button);
                component.setEnabled(esEditable == habilitar);
            }
        }
    }
    public static List<String> obtenerNombresPerfiles() {
        List<String> lista = new ArrayList<>();
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL listar_Perfiles() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nomperfil");
                lista.add(nombre);
            }
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
        }
        return lista;
    }
    public static String getCodigoPerfilPorNombre(String nombrePerfil) {
        String codPerfil = null;
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_codigoperfil(?) }")) {
            cstmt.setString(1, nombrePerfil);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                codPerfil = rs.getString("codperfil");
            }
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
        }
        return codPerfil;
    }
    public static void Mostrar(DefaultTableModel modelo) {
        try ( PreparedStatement pstmt = conn.prepareStatement("CALL listar_usuario()")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("IdUsuario"),
                    rs.getString("username"),
                    rs.getString("pass"),
                    rs.getString("estadousuario"),
                    rs.getString("nomperfil")
                });
            }
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
        }
    }
    public static boolean InsertarActualizar(Usuario usuario, JTable tabla) {
        if (usuario.getIdUsuario() == 0) {
            return Insertar(usuario, tabla);
        } else {
            Actualizar(usuario, tabla);
            return true;
        }
    }
    public static boolean Insertar(Usuario usuario, JTable tabla) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL insertar_usuario(?, ?, ?, ?) }")) {
            cstmt.setString(1, usuario.getUsername());
            cstmt.setString(2, usuario.getPassword());
            cstmt.setString(3, usuario.getEstado());
            cstmt.setString(4, usuario.getCodPerfil());
            cstmt.execute();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Mostrar(modelo);
            return true;
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
            return false;
        }
    }
    public static void Actualizar(Usuario usuario, JTable tabla) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_usuario(?, ?, ?, ?, ?) }")) {
            cstmt.setInt(1, usuario.getIdUsuario());
            cstmt.setString(2, usuario.getUsername());
            cstmt.setString(3, usuario.getPassword());
            cstmt.setString(4, usuario.getEstado());
            cstmt.setString(5, usuario.getCodPerfil());
            cstmt.execute();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Mostrar(modelo);

            Utilitario.MostrarMensaje("Datos actualizados correctamente.", Utilitario.TipoMensaje.informativo);
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
        }
    }
    public static void Eliminar(JTable tabla) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String idUsuario = tabla.getModel().getValueAt(fila, 0).toString();
            boolean confirmar = Utilitario.MostrarMensajePregunta("¿Eliminar usuario?", Utilitario.TipoMensaje.pregunta);
            if (confirmar) {
                try ( CallableStatement stmt = conn.prepareCall("{ CALL eliminar_usuario(?) }")) {
                    stmt.setString(1, idUsuario);
                    stmt.execute();

                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                    modelo.setRowCount(0);
                    Mostrar(modelo);

                    Utilitario.MostrarMensaje("Usuario eliminado correctamente.", Utilitario.TipoMensaje.informativo);
                } catch (SQLException ex) {
                    Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
                }
            }
        } else {
            Utilitario.MostrarMensaje("Debe seleccionar una fila para eliminar.", Utilitario.TipoMensaje.alerta);
        }
    }
}