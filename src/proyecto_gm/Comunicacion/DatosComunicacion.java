/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_gm.Comunicacion;

import com.mysql.cj.protocol.Resultset;
import java.sql.*;

//import java.util.Date;
import java.text.SimpleDateFormat;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;
import proyecto_gm.proyectos.Proyectos;

/**
 *
 * @author pc_sistemas2022
 */
//Lista los datos de la tabla comunicacion
public class DatosComunicacion {

    public DatosComunicacion() {
    }
    Comunicacion entidad = new Comunicacion();
    static Connection conn = ConexionBD.getConnection();

    //funcion para obtener el numero numero de codigo
    static boolean Validar(Comunicacion entidad) {
        boolean estado = true;
        if (entidad.getNombreProyecto().equals("")) {
            Utilitario.MostrarMensaje("Ingresar nombre de proeyecto", Utilitario.TipoMensaje.alerta);
            return false;
        }
        if (entidad.getTipo() == null || entidad.getTipo().equals("-1")) {
            Utilitario.MostrarMensaje("Seleccionar tipo", Utilitario.TipoMensaje.alerta);
            return false;
        }
        if (entidad.getCodDoc().equals("")) {
            Utilitario.MostrarMensaje("Ingresar codigo documento", Utilitario.TipoMensaje.alerta);
            return false;
        }
        if (entidad.getOrigen().equals("")) {
            Utilitario.MostrarMensaje("Ingresar origen", Utilitario.TipoMensaje.alerta);
            return false;
        }
        if (entidad.getDestino().equals("")) {
            Utilitario.MostrarMensaje("Ingresar destino", Utilitario.TipoMensaje.alerta);
            return false;
        }
        if (entidad.getFlujo().equals("-1")) {
            Utilitario.MostrarMensaje("Seleccionar flujo", Utilitario.TipoMensaje.alerta);
            return false;
        }
        if (entidad.getAsunto().equals("")) {
            Utilitario.MostrarMensaje("Ingresar asunto", Utilitario.TipoMensaje.alerta);
            return false;
        }
        if (entidad.getEstado().equals("-1")) {
            Utilitario.MostrarMensaje("Seleccionar estado", Utilitario.TipoMensaje.alerta);
            return false;
        }
        if (entidad.getEnlace().equals("")) {
            Utilitario.MostrarMensaje("Ingresar enlace", Utilitario.TipoMensaje.alerta);
            return false;
        }
        return estado;
    }
    //Proceso para insertar un registor al tabla comunicacion

    //cargar periodo
    public static void CargarCombo(JComboBox<String> cboPeriodo) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL listar_periodos() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                cboPeriodo.addItem(String.valueOf(rs.getInt("Mes")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //capturar id comboperiodo
    public static String CapturarIdPeriodo(JComboBox<String> cboPeriodo) {
        String idCategoria = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL obtener_id_Periodo(?) }")) {
            cstmt.setString(1, cboPeriodo.getSelectedItem().toString());
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                idCategoria = rs.getString("IdPeriodo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en Capturar Categoría", JOptionPane.ERROR_MESSAGE);
        }
        return idCategoria;
    }

    public static void CargarComboTipoComunicacion(JComboBox<String> cboTipo) {
        cboTipo.removeAllItems();
        cboTipo.addItem("Carta");
        cboTipo.addItem("Correo");
        cboTipo.addItem("Llamada");
    }

    public static void CargarComboFlujo(JComboBox<String> cboFlujo) {
        cboFlujo.removeAllItems();
        cboFlujo.addItem("Emision");
        cboFlujo.addItem("Recepcion");
    }

    public static void CargarComboEstado(JComboBox<String> cboEstado) {
        cboEstado.removeAllItems();
        cboEstado.addItem("Proceso");
        cboEstado.addItem("Resuelto");
        cboEstado.addItem("Archivado");
    }

    static boolean Insertar(Comunicacion entidad) {
        boolean estadoProceso = false;
        try {
            //Llamar al procedimiento almacenado 
            CallableStatement proc = conn.prepareCall(" {call insertar_comunicacion(?,?,?,?,?,?,?,?,?,?,?,?)}");
            //validacion de campos con valores en blanco
            if (Validar(entidad) == true) {
                proc.setString("parIdPeriodo", entidad.getIdPeriodo());
                proc.setString("parNomProy", entidad.getNombreProyecto());
                proc.setString("parTipo", entidad.getTipo());
                proc.setString("parCodDoc", entidad.getCodDoc());
                proc.setString("parOrigen", entidad.getOrigen());
                proc.setString("parDestino", entidad.getDestino());
                proc.setString("parFlujo", entidad.getFlujo());
                proc.setString("parAsunto", entidad.getAsunto());
                proc.setDate("parFecha", entidad.getFecha());
                proc.setString("parCodDocRespuesta", entidad.getCodDocRespuesta());
                proc.setString("parEstado", entidad.getEstado());
                proc.setString("parEnlace", entidad.getEnlace());
                estadoProceso = proc.execute();

                estadoProceso = true;
            }
        } catch (SQLException exSQL) {
            System.err.println("Error en proceso insertar..." + exSQL.getMessage());
            estadoProceso = false;
        }
        return estadoProceso;
    }

    static boolean Actualizar(Comunicacion entidad) {
        boolean estadoProceso = false;
        try {
            CallableStatement proc = conn.prepareCall("{call actualizar_comunicacion(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            String idStr = entidad.getId().replaceAll("[^0-9]", "");
            if (idStr.isEmpty()) {
                System.err.println("Error: ID no contiene números");
                return false;
            }
            int idComunicacion = Integer.parseInt(idStr);

            proc.setInt(1, idComunicacion);
            proc.setString(2, entidad.getIdPeriodo());
            proc.setString(3, entidad.getNombreProyecto());
            proc.setString(4, entidad.getTipo());
            proc.setString(5, entidad.getCodDoc());
            proc.setString(6, entidad.getOrigen());
            proc.setString(7, entidad.getDestino());
            proc.setString(8, entidad.getFlujo());
            proc.setString(9, entidad.getAsunto());
            proc.setDate(10, entidad.getFecha());
            proc.setString(11, entidad.getCodDocRespuesta());
            proc.setString(12, entidad.getEstado());
            proc.setString(13, entidad.getEnlace());

            int rowsAffected = proc.executeUpdate(); // Usar executeUpdate para operaciones de actualización
            estadoProceso = rowsAffected > 0;

            if (!estadoProceso) {
                System.err.println("Advertencia: No se actualizó ningún registro");
            }
        } catch (SQLException exSQL) {
            System.err.println("Error en proceso actualizar: " + exSQL.getMessage());
            exSQL.printStackTrace();
        }
        return estadoProceso;
    }

    static String GenerarCodigo() {
        String codigoGenerado = "";
        try {
            CallableStatement cst = conn.prepareCall("{call generar_codigocomunicacion()}");
            ResultSet rs = null;

            rs = cst.executeQuery();

            while (rs.next()) {
                codigoGenerado = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al GenerarCodigo:" + ex.getMessage());
        }
        return codigoGenerado;
    }

    static void ConfigurarGrilla(DefaultTableModel modelo) {

        try {
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            //formateo las columnas de la tabla
            //ArrayList<Comunicacion> lista = new ArrayList<Comunicacion>();
            // 
            // NombreProyecto->Proyecto,  Codigo -> Id, Periodo-> IdPeriodo,  Tipo, TipoDesc, CodDoc, Origen, Destino, Flujo, FlujoDesc, Asunto, Fecha, CodDocRespuesta,Estado, EstadoDesc, Enlace
            String columnas[] = {"Codigo", "Periodo", "Proyecto", "Tipo",
                "Cod.Doc", "Origen", "Destino",
                "Flujo", "Asunto", "Fecha",
                "Cod.Doc.Resp", "Estado", "Enlace"};
            //ocultar el id
            //modelo.addColumn(columnas);
            //ocultar idperiodo

            modelo.addColumn(columnas[0]); //  codigo = Id
            modelo.addColumn(columnas[1]); // periodo  = IdPeriodo
            modelo.addColumn(columnas[2]); // proyecto = Nombreproyecto 
            modelo.addColumn(columnas[3]); //Tipo = Tipo : bd:tipodocumento id
            modelo.addColumn(columnas[4]); //cod.doc 
            modelo.addColumn(columnas[5]); // origen

            modelo.addColumn(columnas[6]);//Destino = destino
            modelo.addColumn(columnas[7]);//Flujo = Flujo
            modelo.addColumn(columnas[8]);//Asunto = asunto

            modelo.addColumn(columnas[9]);//Fecha = fecha
            modelo.addColumn(columnas[10]);//Cod.Doc.Resp = CodDocRespuesta 
            modelo.addColumn(columnas[11]);//Estado       //
            modelo.addColumn(columnas[12]);  // enlace
            //modelo.addColumn(columnas[13]); // Estado

            //  modelo.addColumn(columnas[14]); // Dias  = dias
            // Id -> codigo
            // -- , , , Tipo, TipoDesc, CodDoc, Origen, Destino, Flujo, FlujoDesc, Asunto, Fecha, CodDocRespuesta,Estado, EstadoDesc, Enlace, Dias
        } catch (Exception ex) {
            System.out.println("Error al configurar grilla:" + ex.getMessage());
        }

    }

    public static boolean Eliminar(Comunicacion entidad) {
        boolean estadoProceso = false;
        try {
            CallableStatement proc = conn.prepareCall("{call eliminar_comunicacion(?)}");
            proc.setString(1, entidad.getId());

            int filasAfectadas = proc.executeUpdate();
            estadoProceso = (filasAfectadas > 0);
        } catch (SQLException ex) {
            System.err.println("Error al eliminar comunicación: " + ex.getMessage());
            estadoProceso = false;
        }
        return estadoProceso;
    }

    public static void Listar(DefaultTableModel modelo) {
        CallableStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareCall("CALL listarComunicacion()");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Fila encontrada: " + rs.getString("IdComunicacion")); // depuración

                Object[] row = new Object[]{
                    rs.getString("IdComunicacion"),
                    rs.getString("IdPeriodo"),
                    rs.getString("NombreProyecto"),
                    rs.getString("Tipo"),
                    rs.getString("CodDoc"),
                    rs.getString("Origen"),
                    rs.getString("Destino"),
                    rs.getString("Flujo"),
                    rs.getString("Asunto"),
                    rs.getString("Fecha"),
                    rs.getString("CodDocRespuesta"),
                    rs.getString("estado"),
                    rs.getString("Enlace")
                };

                modelo.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
            }
           
        }
    }

    // 
    public static void Buscar(DefaultTableModel modelo, String origen, String destino, String flujo, String estado, Date fechaInicio, Date fechaFin) {
        try ( Connection con = ConexionBD.getConnection()) {

            String sql = "{CALL buscar_comunicaciones(?, ?, ?, ?, ?, ?)}";
            try ( CallableStatement stmt = con.prepareCall(sql)) {

                // Si están vacíos, setear como NULL
                if (origen == null || origen.isEmpty()) {
                    stmt.setNull(1, Types.VARCHAR);
                } else {
                    stmt.setString(1, origen);
                }

                if (destino == null || destino.isEmpty()) {
                    stmt.setNull(2, Types.VARCHAR);
                } else {
                    stmt.setString(2, destino);
                }

                if (flujo == null || flujo.isEmpty()) {
                    stmt.setNull(3, Types.VARCHAR);
                } else {
                    stmt.setString(3, flujo);
                }

                if (estado == null || estado.isEmpty()) {
                    stmt.setNull(4, Types.VARCHAR);
                } else {
                    stmt.setString(4, estado);
                }

                if (fechaInicio == null) {
                    stmt.setNull(5, Types.DATE);
                } else {
                    stmt.setDate(5, fechaInicio);
                }

                if (fechaFin == null) {
                    stmt.setNull(6, Types.DATE);
                } else {
                    stmt.setDate(6, fechaFin);
                }

                // Ejecutar y llenar tabla
                try ( ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Object[] fila = new Object[13];
                        for (int i = 0; i < fila.length; i++) {
                            fila[i] = rs.getObject(i + 1);
                        }
                        modelo.addRow(fila);
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error al buscar datos: " + ex.getMessage());
        }
    }

}
