package proyecto_gm.Cargo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import proyecto_gm.ConexionBD;

public class DatosCargo {

    public List<Cargo> listarCargo() throws SQLException {
        List<Cargo> lista = new ArrayList<>();
        // Usamos try-with-resources para asegurar que la conexión y el statement se cierren
        try (Connection conn = ConexionBD.getConnection();
             CallableStatement stmt = conn.prepareCall("{ CALL listar_cargos() }");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cargo cargo = new Cargo(
                    rs.getInt("IdCargo"),
                    rs.getString("Descripcion")
                );
                lista.add(cargo);
            }
        }
        return lista;
    }

    public boolean insertar(Cargo cargo) throws SQLException {
        try (Connection conn = ConexionBD.getConnection();
             CallableStatement stmt = conn.prepareCall("{ CALL insertar_cargos(?, ?) }")) {
            
            stmt.setString(1, cargo.getDescripcion());
            stmt.registerOutParameter(2, Types.INTEGER);

            stmt.executeUpdate();

            // Obtener el ID autogenerado del parámetro de salida
            int nuevoId = stmt.getInt(2);
            cargo.setIdCargo(nuevoId); // Actualizamos el ID en el objeto

            return nuevoId > 0;
        }
    }

    public boolean actualizar(Cargo cargo) throws SQLException {
        try (Connection conn = ConexionBD.getConnection();
             CallableStatement stmt = conn.prepareCall("{ CALL actualizar_cargos(?, ?) }")) {
            
            stmt.setInt(1, cargo.getIdCargo());
            stmt.setString(2, cargo.getDescripcion());
            
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    public boolean eliminar(int idCargo) throws SQLException {
        try (Connection conn = ConexionBD.getConnection();
             CallableStatement stmt = conn.prepareCall("{ CALL eliminar_cargos(?) }")) {
            
            stmt.setInt(1, idCargo);
            
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }
}