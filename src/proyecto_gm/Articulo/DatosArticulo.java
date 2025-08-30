package proyecto_gm.Articulo;

import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.Categoria.Categoria;
import proyecto_gm.ConexionBD;


public class DatosArticulo {

    static Connection conn = ConexionBD.getConnection();

    public static void Limpiar(Container contenedor) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(-1); 
            }
        }
    }

    public static List<Categoria> obtenerCategorias() {
        List<Categoria> lista = new ArrayList<>();
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_categorias() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IdCategoria");
                String descripcion = rs.getString("Descripcion");
                lista.add(new Categoria(id, descripcion));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar categorías: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return lista;
    }

    public static List<Marca> obtenerMarcas() {
        List<Marca> lista = new ArrayList<>();
        // Usar consulta directa ya que el procedimiento no devuelve ID
        try (PreparedStatement pstmt = conn.prepareStatement("SELECT IdMarca, descripcion FROM marcas ORDER BY IdMarca")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IdMarca");
                String descripcion = rs.getString("descripcion");
                lista.add(new Marca(id, descripcion));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar marcas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return lista;
    }

    // Método para obtener un artículo completo por ID para edición
    public static Articulo obtenerArticuloPorId(int idArticulo) {
        try (PreparedStatement pstmt = conn.prepareStatement(
            "SELECT a.IdArticulo, a.IdCategoria, a.IdMarca, a.caracteristicas, a.descripcion, a.cantidad, " +
            "c.Descripcion as DescripcionCat, m.descripcion as DescripcionMar " +
            "FROM articulos a " +
            "LEFT JOIN categorias c ON a.IdCategoria = c.IdCategoria " +
            "LEFT JOIN marcas m ON a.IdMarca = m.IdMarca " +
            "WHERE a.IdArticulo = ?")) {
            
            pstmt.setInt(1, idArticulo);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setIdArticulo(rs.getInt("IdArticulo"));
                articulo.setCaracteristicas(rs.getString("caracteristicas"));
                articulo.setDescripcion(rs.getString("descripcion"));
                articulo.setCantidad(rs.getDouble("cantidad"));
                
                // Crear objetos Categoria y Marca si existen
                int idCat = rs.getInt("IdCategoria");
                if (!rs.wasNull()) {
                    articulo.setCategoria(new Categoria(idCat, rs.getString("DescripcionCat")));
                }
                
                int idMar = rs.getInt("IdMarca");
                if (!rs.wasNull()) {
                    articulo.setMarca(new Marca(idMar, rs.getString("DescripcionMar")));
                }
                
                return articulo;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener artículo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static void Mostrar(DefaultTableModel modelo) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_articulos() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("xCodigo"),
                    rs.getString("xDescripcionCat"),
                    rs.getString("xDescripcionMar"),
                    rs.getString("xCaracteristicas"),
                    rs.getString("xDescripcion"),
                    rs.getDouble("xCantidad")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar artículos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

        // Método Insertar corregido (eliminar parámetros extra)
    public static boolean Insertar(Articulo art) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL insertar_articulos(?, ?, ?, ?, ?, ?) }")) {

            // Validar que los objetos existan y tengan ID válido
            if (art.getCategoria() == null || art.getMarca() == null) {
                throw new SQLException("Debe seleccionar una categoría y una marca válidas.");
            }

            cstmt.setInt(1, 0); // IdArticulo se genera automáticamente
            cstmt.setInt(2, art.getCategoria().getIdCat());
            cstmt.setInt(3, art.getMarca().getIdMarca());
            cstmt.setString(4, art.getCaracteristicas() != null ? art.getCaracteristicas() : "");
            cstmt.setString(5, art.getDescripcion() != null ? art.getDescripcion() : "");
            cstmt.setDouble(6, art.getCantidad());

            cstmt.execute();

            JOptionPane.showMessageDialog(null, "¡Registro realizado correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return false;
        }
    }

    // Método Actualizar corregido (eliminar parámetros extra)
    public static boolean Actualizar(Articulo art) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_articulos(?, ?, ?, ?, ?, ?) }")) {

            // Validar que los objetos existan y tengan ID válido
            if (art.getCategoria() == null || art.getMarca() == null) {
                throw new SQLException("Debe seleccionar una categoría y una marca válidas.");
            }

            cstmt.setInt(1, art.getIdArticulo());
            cstmt.setInt(2, art.getCategoria().getIdCat());
            cstmt.setInt(3, art.getMarca().getIdMarca());
            cstmt.setString(4, art.getCaracteristicas() != null ? art.getCaracteristicas() : "");
            cstmt.setString(5, art.getDescripcion() != null ? art.getDescripcion() : "");
            cstmt.setDouble(6, art.getCantidad());

            cstmt.execute();

            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean Eliminar(int idArticulo) {
        try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM articulos WHERE IdArticulo = ?")) {
            pstmt.setInt(1, idArticulo);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static DefaultTableModel Listar() {
        String[] columnas = {"ID", "Categoría", "Marca", "Características", "Descripción", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        Mostrar(modelo);
        return modelo;
    }
}