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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;
/**
 *
 * @author pc_sistemas2022
 */

public class DatosComunicacion {
    public DatosComunicacion(){}
    Comunicacion entidad = new Comunicacion();
    //ConexionBD objCon = new ConexionBD();
    static Connection conn = ConexionBD.getConnection();
    //funcion para obtener el numero numero de codigo
   
     static boolean Validar(Comunicacion entidad){
        boolean estado = true;
            if(entidad.getNombreProyecto().equals("")){
                Utilitario.MostrarMensaje("Ingresar nombre de proeyecto", Utilitario.TipoMensaje.alerta);
                return false;
            }
            if(entidad.getTipo() == -1){
                Utilitario.MostrarMensaje("Seleccionar tipo", Utilitario.TipoMensaje.alerta);
                return false;
                
            }
            
            if(entidad.getCodDoc().equals("")){
                Utilitario.MostrarMensaje("Ingresar codigo documento", Utilitario.TipoMensaje.alerta);
                return false;
            }
            if(entidad.getOrigen().equals("")){
                Utilitario.MostrarMensaje("Ingresar origen", Utilitario.TipoMensaje.alerta);
                return false;
            }
            if(entidad.getDestino().equals("")){
                Utilitario.MostrarMensaje("Ingresar destino", Utilitario.TipoMensaje.alerta);
                return false;
            }
            
            if(entidad.getFlujo() == -1 ){
                Utilitario.MostrarMensaje("Seleccionar flujo", Utilitario.TipoMensaje.alerta);
                return false;
            }
                
            if(entidad.getAsunto().equals("")){
                Utilitario.MostrarMensaje("Ingresar asunto", Utilitario.TipoMensaje.alerta);
                return false;
            }
            if(entidad.getEstado() == -1){
                Utilitario.MostrarMensaje("Seleccionar estado", Utilitario.TipoMensaje.alerta);
                return false;
            }
            
            if(entidad.getEnlace().equals("")){
                Utilitario.MostrarMensaje("Ingresar enlace", Utilitario.TipoMensaje.alerta);
                return  false;
            }
            return estado;
    }
    static boolean Insertar(Comunicacion entidad){
        boolean estadoProceso  = false;
        try {
            
            CallableStatement proc = conn.prepareCall(" {call insertar_comunicacion(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        
            //validacion de campos con valores en blanco
            
            
            if(Validar(entidad)== true){
                
            
            proc.setString("parId", entidad.getId());
            proc.setString("parIdPeriodo",entidad.getIdPeriodo());
                    proc.setString("parNomProy", entidad.getNombreProyecto());
                    proc.setInt("parTipo", entidad.getTipo());
                    proc.setString("parCodDoc", entidad.getCodDoc());
                    proc.setString("parOrigen", entidad.getOrigen());
                    proc.setString("parDestino", entidad.getDestino());
                    proc.setInt("parFlujo", entidad.getFlujo());
                    proc.setString("parAsunto", entidad.getAsunto());                    
                    proc.setDate("parFecha", entidad.getFecha());                    
                    proc.setString("parCodDocRespuesta", entidad.getCodDocRespuesta());
                    proc.setInt("parEstado", entidad.getEstado());
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
    static boolean  Actualizar(Comunicacion entidad) {
        boolean estadoProceso  = false;
        try{
         CallableStatement proc = conn.prepareCall(" {call actualizar_comunicacion(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
          if(Validar(entidad)== true){
                
            
            proc.setString("parId", entidad.getId());
            proc.setString("parIdPeriodo",entidad.getIdPeriodo());
                    proc.setString("parNomProy", entidad.getNombreProyecto());
                    proc.setInt("parTipo", entidad.getTipo());
                    proc.setString("parCodDoc", entidad.getCodDoc());
                    proc.setString("parOrigen", entidad.getOrigen());
                    proc.setString("parDestino", entidad.getDestino());
                    proc.setInt("parFlujo", entidad.getFlujo());
                    proc.setString("parAsunto", entidad.getAsunto());                    
                    proc.setDate("parFecha", entidad.getFecha());                    
                    proc.setString("parCodDocRespuesta", entidad.getCodDocRespuesta());
                    proc.setInt("parEstado", entidad.getEstado());
                    proc.setString("parEnlace", entidad.getEnlace());
                    estadoProceso = proc.execute();
          }else{
            estadoProceso  = false;
          }
          
        }catch(SQLException ex){
            estadoProceso = false;
        }
        return estadoProceso;
    }
    
        
    static String GenerarCodigo(){
        String codigoGenerado = "";
        try{
            CallableStatement cst = conn.prepareCall("{call generar_codigocomunicacion()}");
            ResultSet rs =null;
            
            rs = cst.executeQuery();
            
            while(rs.next()){
                codigoGenerado = rs.getString(1);
            }
        }catch(SQLException ex){
         System.out.println("Error al GenerarCodigo:"+ ex.getMessage());
        }
        return codigoGenerado;
    }
    public void ConfigurarGrilla(DefaultTableModel modelo){
    
    try{
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
        String columnas[] = {"Proyecto","Codigo","Periodo", "Tipo", 
                             "Cod.Doc", "Origen", "Destino", "Flujo",
                             "Asunto", "Fecha", "Tipo Comunicacion","Cod.Doc.Resp", 
                             "Dias", "Estado", "Enlace"};
        modelo.addColumn(columnas[0]);
        modelo.addColumn(columnas[1]);
        modelo.addColumn(columnas[2]);
        modelo.addColumn(columnas[3]);
        modelo.addColumn(columnas[4]);
        modelo.addColumn(columnas[5]);
        modelo.addColumn(columnas[6]);
        modelo.addColumn(columnas[7]);
        modelo.addColumn(columnas[8]);
        modelo.addColumn(columnas[9]);
        modelo.addColumn(columnas[10]);
        modelo.addColumn(columnas[11]);
        modelo.addColumn(columnas[12]);
        modelo.addColumn(columnas[13]);
        modelo.addColumn(columnas[14]);
        
    }catch(Exception ex){
    
    }
    
    
    }
//    public ArrayList<Comunicacion> Listar(DefaultTableModel modelo){
    static  void Listar(JTable tabla){
        ResultSet rs = null;
        
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
            
        };
                
         modelo.setColumnCount(0);
        modelo.setRowCount(0);
        //formateo las columnas de la tabla
        //ArrayList<Comunicacion> lista = new ArrayList<Comunicacion>();
          String columnas[] = {"Proyecto","Codigo","Periodo", "Tipo", 
                             "Cod.Doc", "Origen", "Destino", "Flujo",
                             "Asunto", "Fecha", "Cod.Doc.Resp", 
                             "Dias", "Estado", "Enlace"};
          modelo.addColumn(columnas[0]); // proyecto
        modelo.addColumn(columnas[1]); // codigo
        modelo.addColumn(columnas[2]); // periodo
        modelo.addColumn(columnas[3]); //Tipo
        modelo.addColumn(columnas[4]);//Cod.Doc
        modelo.addColumn(columnas[5]);//origen
        modelo.addColumn(columnas[6]);//destino
        modelo.addColumn(columnas[7]);//flujo
        modelo.addColumn(columnas[8]);//asunto
        modelo.addColumn(columnas[9]);//fecha
        //modelo.addColumn(columnas[10]);//Tipo.comunicacion
        modelo.addColumn(columnas[10]);//Cod.Doc:Resp
        modelo.addColumn(columnas[11]); // Dias
        modelo.addColumn(columnas[12]);//Estado
        modelo.addColumn(columnas[13]);//Enalce
        //Object registro[];
//        modelo.addColumn(rs);
        
        try{
            
            
        CallableStatement cst = conn.prepareCall("{ call listar_comunicacion() }");
        rs  = cst.executeQuery();
        int i = 0;
        //mientras realizo la lectura de registros
        while(rs.next()){
            String[] campos = rs.getString("Fecha").split("-");
            
            String fechaFormato =  campos[2]+"/"+campos[1]+"/"+ campos[0]; // anio
            //agrego el resultado de la consulta al arreglo de tipo object
            Object registro[]  = new Object[] {  rs.getString("NombreProyecto"), rs.getString("Id"), rs.getString("IdPeriodo"), 
            rs.getInt("Tipo"), rs.getString("CodDoc"), rs.getString("Origen"), rs.getString("Destino"),
            rs.getInt("Flujo"), rs.getString("Asunto"), fechaFormato, rs.getString("CodDocRespuesta"),"",
            rs.getInt("Estado"),  rs.getString("Enlace")};
           //insertar al modelo de la tabla la variable tipo objeto
         modelo.addRow(registro);
        }
        //System.out.println("Registros: " + i);
                
        //System.out.println("Registros consultados: " + rs.last()); 
        //System.out.println("utlimo registro: " +rs.getRow());
        //while(rs.next()){
            
        //}
        tabla.setModel(modelo);
        }catch(Exception ex){
            System.out.println("Error al listar:"+ ex.getMessage());
        }
        //return lista;
    }
    /*
    --  METODO LISTA DATOS
    private static void mostrarProcedimiento() throws SQLException {
             
                   Connection conectar = null;
                   ResultSet rs;
                        try{
                                // creamos la Conexion
                                conectar = Conexion.conectar();                                                                                       
                                CallableStatement prcProcedimientoAlmacenado = conectar.prepareCall("{call MostrarCampo()}");
                              rs=prcProcedimientoAlmacenado.executeQuery();                             
                             
                           while(rs.next()){
                                  System.out.println("ID"+"->"+rs.getInt(1));
                                  System.out.println("Longitud"+"->"+rs.getString(2));
                                  System.out.println("Nombre Campo"+"->"+rs.getString(3));
                                  System.out.println("Descripcion"+"->"+rs.getString(4));
                                 
                           }
                                 
                                conectar.commit();
                               
                             
                               
                        } catch (Exception e) {
                               
                                conectar.rollback();
                               
                                e.printStackTrace();
                        } finally {
                                
                                conectar.close();
                        }
        }
    
    
    
    public void Actualizar(){
        try {
            
        } catch (Exception e) {
        }
    }
    
    
    public void Eliminar(){
        try {
            
        } catch (Exception e) {
        }
    }
    */
//    public String[][] listar(){
//    
//    }


    
}
