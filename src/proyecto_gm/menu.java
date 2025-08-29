package proyecto_gm;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import proyecto_gm.Instituciones.frmInstituciones;
import proyecto_gm.Tipo.frmTipo;
import proyecto_gm.Facultades.frmFacultades;
import proyecto_gm.Carreras.frmCarreras;
import proyecto_gm.Empleado.frmEmpleado;
import proyecto_gm.Cargo.frmCargo;
import proyecto_gm.Area.frmArea;
import proyecto_gm.Articulo.frmListaArticulo;
import proyecto_gm.Asistencias.frmAsistencias;
import proyecto_gm.CabeceraComprobante.frmCabeceraComprobante;
import proyecto_gm.Categoria.frmCategoria;
import proyecto_gm.Comunicacion.frmListaComunicacion;
import proyecto_gm.Contactos.frmContacto;
import proyecto_gm.Cuentas.frmCuentas;
import proyecto_gm.Modulo.frmModulo;
import proyecto_gm.Periodos.frmPeriodos;
import proyecto_gm.Proveedores.frmProveedores;
import proyecto_gm.RecibosHonorarios.frmListaRecibosHonorarios;
import proyecto_gm.TipoDocumento.frmTipoDocumento;
import proyecto_gm.Transferencias.frmTransferencias;
import proyecto_gm.Viaticos.frmViaticos;
import proyecto_gm.CajaChica.frmCajaChica;
import proyecto_gm.Departamentos.frmDepartamentos;
import proyecto_gm.credencial.frmCredencial;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JLabel;
import org.apache.poi.hssf.record.TextObjectRecord;
import proyecto_gm.Asistencias.frmAsistenciaImagen;
import proyecto_gm.Empleado.frmListaEmpleado;
import proyecto_gm.Proveedores.frmListaProveedores;
import proyecto_gm.seguridad.frmPermisosxPerfil;
import proyecto_gm.seguridad.frmUsuario;

public class menu extends javax.swing.JFrame {

    static Connection conn = ConexionBD.getConnection();
    
    public menu() {

        initComponents();        
        setSize(1100, 700);
        this.setLocationRelativeTo(null);
        DeshabilitarMenu();
        System.out.println("formulario Menu , codigo perfil: " +ConexionBD.codPerfil);
        TraerMenu(ConexionBD.codPerfil);
        this.setTitle("SISTEMAS GM");
        String datoUsuario= "Usuario:" + ConexionBD.nomUsuario +"\t\t";
         String datoPerfil = "Perfil:"+ ConexionBD.nomPerfil+"\t\t\t";
        String datoEmpresa = "20555841095-GM INGENIEROS Y CONSULTORES" ;
        
        this.lblEstadoSesion.setText(datoUsuario +"        " + datoPerfil + "       " +datoEmpresa);
    }
    
    void DeshabilitarMenu(){
        this.menuAdministracion.setVisible(false);
        this.menuFacturacion.setVisible(false);
        this.menuLogistica.setVisible(false);
        this.menuProyecto.setVisible(false);
        this.menuRecursosHumanos.setVisible(false);
        this.menuTesoreria.setVisible(false);
        this.menuConfiguracion.setVisible(false);
        //this.menuSeguridad.setVisible(false);
        
        this.subMenuCargos.setVisible(false);
        this.subMenuAreas.setVisible(false);
        this.subMenuTipoEmpleado.setVisible(false);
        this.submenuAsistencia.setVisible(false);
        this.subMenuTipoDocumento.setVisible(false);
        this.submenuContratosPersonal.setVisible(false);
        this.subMenuRelojActividad.setVisible(false);
        
        this.subMenuReciboHonorario.setVisible(false);
        this.subMenuComprobante.setVisible(false);
        this.subMenuTransferencia.setVisible(false);

        this.subMenuCategoria.setVisible(false);
        this.subMenuArticulos.setVisible(false);

        this.subMenuClientes.setVisible(false);
        this.subMenuComunicaciones.setVisible(false);
        this.subMenuContactos.setVisible(false);
        this.submenuContratoProyecto.setVisible(false);

        this.subMenuExpLaboral.setVisible(false);
        this.subMenuCarreras.setVisible(false);
        this.subMenuInstituciones.setVisible(false);
        this.subMenuFacultades.setVisible(false);
        this.subMenuProveedores.setVisible(false);
        this.subMenuEmpleados.setVisible(false);

        this.subMenuBancos.setVisible(false);
        this.subMenuFlujoCaja.setVisible(false);
        this.subMenuCuentasBancarias.setVisible(false);
        this.subMenuViaticos.setVisible(false);

        this.subMenuPeriodos.setVisible(false);
        this.subMenuModulos.setVisible(false);
        this.subMenuDepartamentos.setVisible(false);
        this.subMenuCredencial.setVisible(false);

        
    }
    void TraerMenu(String codperfil){
         //deshabiliar todo
        
        try{
            
        CallableStatement cstmt =  conn.prepareCall("call listar_Menuxperfil(?,?)");
        cstmt.setString(1, "01");
        cstmt.setString(2, codperfil);
        System.out.println(codperfil);
        ResultSet rs = cstmt.executeQuery();
         
        //pst.setString(1, "01"); // codmodulo
        //pst.setString(2, "01"); // perfil 
        //ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            String nombre = rs.getString("nombre");
            this.Habilitar(nombre);
            //System.out.println(nombre); 
        }
        }catch(SQLException exSql){
            JOptionPane.showMessageDialog(null,exSql.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void Habilitar(String nombreMenu){
        switch (nombreMenu) {
            case "menuAdministracion":
                this.menuAdministracion.setVisible(true);
             
                break;
            case "menuFacturacion":
                this.menuFacturacion.setVisible(true);
                break;
             case "menuLogistica": 
                this.menuLogistica.setVisible(true);
                break;
            case "menuProyecto": 
                this.menuProyecto.setVisible(true);
                break;
             case "menuRecursosHumanos": 
                 this.menuRecursosHumanos.setVisible(true);
                 break;
            case "menuTesoreria": 
                this.menuTesoreria.setVisible(true);
                break;
            
            case "menuConfiguracion":
                this.menuConfiguracion.setVisible(true);
                break;                                                                                    
            case "menuSeguridad": 
                this.menuSeguridad.setVisible(true);
                break;
            case "subMenuCargos":
                this.subMenuCargos.setVisible(true);
                break;
            case "subMenuAreas":
                this.subMenuAreas.setVisible(true);
                break;
            case "subMenuTipoEmpleado":
                this.subMenuTipoEmpleado.setVisible(true);
                break;
            case "submenuAsistencia":
                this.submenuAsistencia.setVisible(true);
                break;
            case "subMenuTipoDocumento": 
                this.subMenuTipoDocumento.setVisible(true);
                break;
            
            case "submenuContratosPersonal":
                this.submenuContratosPersonal.setVisible(true);
                break;

            case "subMenuReciboHonorario":
                this.subMenuReciboHonorario.setVisible(true);
                break;
            case "subMenuComprobante":
                this.subMenuComprobante.setVisible(true);
                break;
            case "subMenuTransferencia": 
                this.subMenuTransferencia.setVisible(true);
                break;
                
            case "subMenuCategoria":
                this.subMenuCategoria.setVisible(true);
                break;

            case "subMenuArticulos": 
                this.subMenuArticulos.setVisible(true);
                break;
            case "subMenuClientes"    :
                this.subMenuClientes.setVisible(true);
                break;
            case "subMenuComunicaciones":
                this.subMenuComunicaciones.setVisible(true);
                break;
             
            case "subMenuContactos":
                this.subMenuContactos.setVisible(true);
                break;
                
            case "submenuContratoProyecto":
                this.submenuContratoProyecto.setVisible(true);
                break;
                
            case "subMenuExpLaboral":
                this.subMenuExpLaboral.setVisible(true);
                break;

            case "subMenuCarreras":
                this.subMenuCarreras.setVisible(true);
                break;
                
            case "subMenuInstituciones":
                this.subMenuInstituciones.setVisible(true);
                break;
                
            case "subMenuFacultades":
                this.subMenuFacultades.setVisible(true);
                break;

            case "subMenuProveedores":
                this.subMenuProveedores.setVisible(true);
                break;
                
                
            case "subMenuEmpleados":
                this.subMenuEmpleados.setVisible(true);
                break;
                
                
            case "subMenuBancos":
                this.subMenuBancos.setVisible(true);
                break;
                
            case "subMenuFlujoCaja":
                this.subMenuFlujoCaja.setVisible(true);
                break;
            case "subMenuCuentasBancarias":
                this.subMenuCuentasBancarias.setVisible(true);
                break;
            case "subMenuViaticos":
                this.subMenuViaticos.setVisible(true);
                break;
                

                case "subMenuPeriodos":
                this.subMenuPeriodos.setVisible(true);
                break;
                
                
                case "subMenuModulos":
                this.subMenuModulos.setVisible(true);
                break;
                
                
                case "subMenuDepartamentos":
                this.subMenuDepartamentos.setVisible(true);
                break;
                
                case "subMenuCredencial":
                this.subMenuCredencial.setVisible(true);
                break;
            case "subMenuRelojActividad":
                this.subMenuRelojActividad.setVisible(true);
                break;
            default:
                throw new AssertionError();
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/iconos/fondogm.png"));
        Image img = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                int x = (this.getWidth() - img.getWidth(null))/2;
                int y = (this.getHeight()-img.getHeight(null))/2;
                g.drawImage(img, x, y, null);
            }
        };
        pnlEstado = new javax.swing.JPanel();
        lblEstadoSesion = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdministracion = new javax.swing.JMenu();
        subMenuCargos = new javax.swing.JMenuItem();
        subMenuAreas = new javax.swing.JMenuItem();
        subMenuTipoEmpleado = new javax.swing.JMenuItem();
        submenuAsistencia = new javax.swing.JMenuItem();
        subMenuTipoDocumento = new javax.swing.JMenuItem();
        submenuContratosPersonal = new javax.swing.JMenuItem();
        subMenuRelojActividad = new javax.swing.JMenuItem();
        menuFacturacion = new javax.swing.JMenu();
        subMenuReciboHonorario = new javax.swing.JMenuItem();
        subMenuComprobante = new javax.swing.JMenuItem();
        subMenuTransferencia = new javax.swing.JMenuItem();
        menuLogistica = new javax.swing.JMenu();
        subMenuCategoria = new javax.swing.JMenuItem();
        subMenuArticulos = new javax.swing.JMenuItem();
        menuProyecto = new javax.swing.JMenu();
        subMenuClientes = new javax.swing.JMenuItem();
        subMenuComunicaciones = new javax.swing.JMenuItem();
        subMenuContactos = new javax.swing.JMenuItem();
        submenuContratoProyecto = new javax.swing.JMenuItem();
        menuRecursosHumanos = new javax.swing.JMenu();
        subMenuExpLaboral = new javax.swing.JMenuItem();
        subMenuCarreras = new javax.swing.JMenuItem();
        subMenuInstituciones = new javax.swing.JMenuItem();
        subMenuFacultades = new javax.swing.JMenuItem();
        subMenuProveedores = new javax.swing.JMenuItem();
        subMenuEmpleados = new javax.swing.JMenuItem();
        menuTesoreria = new javax.swing.JMenu();
        subMenuBancos = new javax.swing.JMenuItem();
        subMenuFlujoCaja = new javax.swing.JMenuItem();
        subMenuCuentasBancarias = new javax.swing.JMenuItem();
        subMenuViaticos = new javax.swing.JMenuItem();
        menuConfiguracion = new javax.swing.JMenu();
        subMenuPeriodos = new javax.swing.JMenuItem();
        subMenuModulos = new javax.swing.JMenuItem();
        subMenuDepartamentos = new javax.swing.JMenuItem();
        subMenuCredencial = new javax.swing.JMenuItem();
        menuSeguridad = new javax.swing.JMenu();
        subMenuUsuario = new javax.swing.JMenuItem();
        subMenuPermisosxPerfil = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(1, 1));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1292, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        jPanel2.add(escritorio);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pnlEstado.setBackground(new java.awt.Color(0, 102, 204));

        lblEstadoSesion.setForeground(new java.awt.Color(255, 255, 255));
        lblEstadoSesion.setText("jLabel1");

        javax.swing.GroupLayout pnlEstadoLayout = new javax.swing.GroupLayout(pnlEstado);
        pnlEstado.setLayout(pnlEstadoLayout);
        pnlEstadoLayout.setHorizontalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEstadoSesion)
                .addContainerGap(1245, Short.MAX_VALUE))
        );
        pnlEstadoLayout.setVerticalGroup(
            pnlEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEstadoSesion)
        );

        getContentPane().add(pnlEstado, java.awt.BorderLayout.SOUTH);

        menuAdministracion.setText("Administracion");

        subMenuCargos.setText("Cargos");
        subMenuCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCargosActionPerformed(evt);
            }
        });
        menuAdministracion.add(subMenuCargos);

        subMenuAreas.setText("Areas");
        subMenuAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuAreasActionPerformed(evt);
            }
        });
        menuAdministracion.add(subMenuAreas);

        subMenuTipoEmpleado.setText("Tipos de empleados");
        subMenuTipoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuTipoEmpleadoActionPerformed(evt);
            }
        });
        menuAdministracion.add(subMenuTipoEmpleado);

        submenuAsistencia.setText("Asistencia");
        submenuAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAsistenciaActionPerformed(evt);
            }
        });
        menuAdministracion.add(submenuAsistencia);

        subMenuTipoDocumento.setText("Tipos de documentos");
        subMenuTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuTipoDocumentoActionPerformed(evt);
            }
        });
        menuAdministracion.add(subMenuTipoDocumento);

        submenuContratosPersonal.setText("Contratos personal");
        submenuContratosPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuContratosPersonalActionPerformed(evt);
            }
        });
        menuAdministracion.add(submenuContratosPersonal);

        subMenuRelojActividad.setText("Reloj actividad");
        subMenuRelojActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuRelojActividadActionPerformed(evt);
            }
        });
        menuAdministracion.add(subMenuRelojActividad);

        jMenuBar1.add(menuAdministracion);

        menuFacturacion.setText("Facturacion");

        subMenuReciboHonorario.setText("Recibo por honorarios");
        subMenuReciboHonorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuReciboHonorarioActionPerformed(evt);
            }
        });
        menuFacturacion.add(subMenuReciboHonorario);

        subMenuComprobante.setText("Comprobantes");
        subMenuComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuComprobanteActionPerformed(evt);
            }
        });
        menuFacturacion.add(subMenuComprobante);

        subMenuTransferencia.setText("Transferencias");
        subMenuTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuTransferenciaActionPerformed(evt);
            }
        });
        menuFacturacion.add(subMenuTransferencia);

        jMenuBar1.add(menuFacturacion);

        menuLogistica.setText("Logistica");

        subMenuCategoria.setText("Categorias");
        subMenuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCategoriaActionPerformed(evt);
            }
        });
        menuLogistica.add(subMenuCategoria);

        subMenuArticulos.setText("Articulos");
        subMenuArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuArticulosActionPerformed(evt);
            }
        });
        menuLogistica.add(subMenuArticulos);

        jMenuBar1.add(menuLogistica);

        menuProyecto.setText("Proyecto");

        subMenuClientes.setText("Clientes");
        subMenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuClientesActionPerformed(evt);
            }
        });
        menuProyecto.add(subMenuClientes);

        subMenuComunicaciones.setText("Comunicaciones");
        subMenuComunicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuComunicacionesActionPerformed(evt);
            }
        });
        menuProyecto.add(subMenuComunicaciones);

        subMenuContactos.setText("Contactos");
        subMenuContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuContactosActionPerformed(evt);
            }
        });
        menuProyecto.add(subMenuContactos);

        submenuContratoProyecto.setText("Contrato proyectos");
        submenuContratoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuContratoProyectoActionPerformed(evt);
            }
        });
        menuProyecto.add(submenuContratoProyecto);

        jMenuBar1.add(menuProyecto);

        menuRecursosHumanos.setText("Recursos humanos");

        subMenuExpLaboral.setText("Experiencia laboral");
        subMenuExpLaboral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuExpLaboralActionPerformed(evt);
            }
        });
        menuRecursosHumanos.add(subMenuExpLaboral);

        subMenuCarreras.setText("Carreras");
        subMenuCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCarrerasActionPerformed(evt);
            }
        });
        menuRecursosHumanos.add(subMenuCarreras);

        subMenuInstituciones.setText("Instituciones");
        subMenuInstituciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuInstitucionesActionPerformed(evt);
            }
        });
        menuRecursosHumanos.add(subMenuInstituciones);

        subMenuFacultades.setText("Facultades");
        subMenuFacultades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuFacultadesActionPerformed(evt);
            }
        });
        menuRecursosHumanos.add(subMenuFacultades);

        subMenuProveedores.setText("Proveedores");
        subMenuProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuProveedoresActionPerformed(evt);
            }
        });
        menuRecursosHumanos.add(subMenuProveedores);

        subMenuEmpleados.setText("Personal");
        subMenuEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuEmpleadosActionPerformed(evt);
            }
        });
        menuRecursosHumanos.add(subMenuEmpleados);

        jMenuBar1.add(menuRecursosHumanos);

        menuTesoreria.setText("Tesoreria");

        subMenuBancos.setText("Bancos");
        subMenuBancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuBancosActionPerformed(evt);
            }
        });
        menuTesoreria.add(subMenuBancos);

        subMenuFlujoCaja.setText("Flujo de caja");
        subMenuFlujoCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuFlujoCajaActionPerformed(evt);
            }
        });
        menuTesoreria.add(subMenuFlujoCaja);

        subMenuCuentasBancarias.setText("Cuentas bancarias");
        subMenuCuentasBancarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCuentasBancariasActionPerformed(evt);
            }
        });
        menuTesoreria.add(subMenuCuentasBancarias);

        subMenuViaticos.setText("Viaticos");
        subMenuViaticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuViaticosActionPerformed(evt);
            }
        });
        menuTesoreria.add(subMenuViaticos);

        jMenuBar1.add(menuTesoreria);

        menuConfiguracion.setText("Configuracion");

        subMenuPeriodos.setText("Periodos");
        subMenuPeriodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuPeriodosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(subMenuPeriodos);

        subMenuModulos.setText("Modulos");
        subMenuModulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuModulosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(subMenuModulos);

        subMenuDepartamentos.setText("Departamentos");
        subMenuDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuDepartamentosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(subMenuDepartamentos);

        subMenuCredencial.setText("Credencial");
        subMenuCredencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCredencialActionPerformed(evt);
            }
        });
        menuConfiguracion.add(subMenuCredencial);

        jMenuBar1.add(menuConfiguracion);

        menuSeguridad.setText("Seguridad");

        subMenuUsuario.setText("Usuario");
        subMenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuUsuarioActionPerformed(evt);
            }
        });
        menuSeguridad.add(subMenuUsuario);

        subMenuPermisosxPerfil.setText("Permisos por perfil");
        subMenuPermisosxPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuPermisosxPerfilActionPerformed(evt);
            }
        });
        menuSeguridad.add(subMenuPermisosxPerfil);

        jMenuBar1.add(menuSeguridad);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void Abrirareas(){
             frmArea verventana = new frmArea();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrirarticulos(){
         frmListaArticulo verventana = new frmListaArticulo();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrirasistencias(){
           frmAsistencias verventana = new frmAsistencias();
        escritorio.add(verventana);
        verventana.show(); 
        }
        
        
        private void Abrirbancos(){
        }
        
        private void Abrircabeceracomprobante(){
            frmCabeceraComprobante verventana = new frmCabeceraComprobante();
        escritorio.add(verventana);
        
        verventana.show();
        }
        
        private void Abrircajachica(){
             frmCajaChica verventana = new frmCajaChica();
            escritorio.add((verventana));
            verventana.show();
        }
        
        private void Abrircargos(){
        frmCargo verventana = new frmCargo();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrircarreras(){
         frmCarreras verventana = new frmCarreras();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrircategorias(){
         frmCategoria verventana = new frmCategoria();
        escritorio.add(verventana);
        verventana.show();
        }
        private void Abrircomprobantes(){}
        private void Abrirclientes(){
        
        }
        
        private void Abrircomunicaciones(){
        
            frmListaComunicacion verventana = new frmListaComunicacion();
            escritorio.add(verventana);
            verventana.AsignarPadre(escritorio);
            verventana.show();
        }
        
        private void Abrircontactos(){
        frmContacto verventana = new frmContacto();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrircontratos(){
        
        }
        
        private void Abrircuentasbancarias(){
        frmCuentas verventana = new frmCuentas();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrirdepartamentos(){
        frmDepartamentos verventana = new frmDepartamentos();
        escritorio.add(verventana);
        verventana.setVisible(true);
        
        }
        
        private void Abrirdetalles_asistencia(){
        
        }
        
        private void Abrirempleados(){
//        frmEmpleado verventana = new frmEmpleado();
//        escritorio.add(verventana);
//        verventana.show();
            frmListaEmpleado verventana = new frmListaEmpleado(escritorio);
            escritorio.add(verventana);
            verventana.show();
        
        }
        
        private void Abrirexperiencialaboral(){
        
        }
        
        private void Abrirfacultades(){
        frmFacultades verventana = new frmFacultades();
        escritorio.add(verventana);
        verventana.show();
        }
        
        
        private void Abririnstitucioneseducativas(){
         frmInstituciones verventana = new frmInstituciones();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrirmodulos(){
        frmModulo verventana = new frmModulo();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrirperiodos(){
        frmPeriodos verventana = new frmPeriodos();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrirproveedores(){
            frmListaProveedores verventana = new frmListaProveedores(escritorio);
            escritorio.add(verventana);
             //frmProveedores verventana = new frmProveedores();
            //escritorio.add(verventana);
        
            verventana.show();
        }
        
        private void Abrirreciboshonorarios(){
         frmListaRecibosHonorarios verventana = new frmListaRecibosHonorarios();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrirtiposdocumentos(){
            frmTipoDocumento verventana = new frmTipoDocumento();
            escritorio.add(verventana);
            verventana.show();
        }
        
        private void Abrirtiposempleados(){
            
         frmTipo verventana = new frmTipo();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrirtransferenciasbancarias(){
         frmTransferencias verventana = new frmTransferencias();
        escritorio.add(verventana);
        verventana.show();
        }
        
        private void Abrirusuarios(){
        
        }
        
        private void Abrirviaticos(){
            frmViaticos verventana = new frmViaticos();
        escritorio.add(verventana);
        verventana.show();
        }
        private void Abrircredencial(){
            proyecto_gm.credencial.frmCredencial verventana = new frmCredencial();
            escritorio.add(verventana);
            verventana.show();
        }
        private void AbrirAsistenciaImagen(){
            proyecto_gm.Asistencias.frmAsistenciaImagen verventana = new frmAsistenciaImagen();
            escritorio.add(verventana);
            verventana.show();
        }
        
        private void AbrirUsuario(){
            proyecto_gm.seguridad.frmUsuario verventana = new frmUsuario();
            escritorio.add(verventana);
            verventana.show();
        }
        private void AbrirMenuxperfil()
        {
            proyecto_gm.seguridad.frmPermisosxPerfil verventana = new frmPermisosxPerfil();
            escritorio.add(verventana);
            verventana.show();
        }
    private void menuCajaChicaActionPerformed (java.awt.event.ActionEvent evt){
       
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        /*    
        try ( 
            
            PreparedStatement pstmt = conn.prepareCall(" CALL generar_detalle_asistencia() ")) {
            pstmt.execute();
            System.out.println("Detalle generado al cerrar el form.");
            ConexionBD.closeConnection(); // Cerramos la conexion a la base de datos
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
                */
    }//GEN-LAST:event_formWindowClosing

    private void subMenuTipoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuTipoEmpleadoActionPerformed
        Abrirtiposempleados();
    }//GEN-LAST:event_subMenuTipoEmpleadoActionPerformed

    private void subMenuCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCargosActionPerformed
        Abrircargos();
    }//GEN-LAST:event_subMenuCargosActionPerformed

    private void subMenuAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAreasActionPerformed
        Abrirareas();
    }//GEN-LAST:event_subMenuAreasActionPerformed

    private void submenuAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAsistenciaActionPerformed
        Abrirasistencias();
    }//GEN-LAST:event_submenuAsistenciaActionPerformed

    private void subMenuTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuTipoDocumentoActionPerformed
        Abrirtiposdocumentos();
    }//GEN-LAST:event_subMenuTipoDocumentoActionPerformed

    private void submenuContratosPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuContratosPersonalActionPerformed
        Abrircontratos();
    }//GEN-LAST:event_submenuContratosPersonalActionPerformed

    private void subMenuReciboHonorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuReciboHonorarioActionPerformed
        Abrirreciboshonorarios();
    }//GEN-LAST:event_subMenuReciboHonorarioActionPerformed

    private void subMenuComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuComprobanteActionPerformed
        Abrircomprobantes();
    }//GEN-LAST:event_subMenuComprobanteActionPerformed

    private void subMenuTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuTransferenciaActionPerformed
        Abrirtransferenciasbancarias();
    }//GEN-LAST:event_subMenuTransferenciaActionPerformed

    private void subMenuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCategoriaActionPerformed
        Abrircategorias();
    }//GEN-LAST:event_subMenuCategoriaActionPerformed

    private void subMenuArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuArticulosActionPerformed
        Abrirarticulos();
    }//GEN-LAST:event_subMenuArticulosActionPerformed

    private void subMenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuClientesActionPerformed
        Abrirclientes();
    }//GEN-LAST:event_subMenuClientesActionPerformed

    private void subMenuComunicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuComunicacionesActionPerformed
        Abrircomunicaciones();
    }//GEN-LAST:event_subMenuComunicacionesActionPerformed

    private void subMenuContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuContactosActionPerformed
        Abrircontactos();
        
    }//GEN-LAST:event_subMenuContactosActionPerformed

    private void submenuContratoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuContratoProyectoActionPerformed
        Abrircontratos();
    }//GEN-LAST:event_submenuContratoProyectoActionPerformed

    private void subMenuExpLaboralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuExpLaboralActionPerformed
        Abrirexperiencialaboral();
    }//GEN-LAST:event_subMenuExpLaboralActionPerformed

    private void subMenuCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCarrerasActionPerformed
        Abrircarreras();
    }//GEN-LAST:event_subMenuCarrerasActionPerformed

    private void subMenuInstitucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuInstitucionesActionPerformed
        Abririnstitucioneseducativas();
    }//GEN-LAST:event_subMenuInstitucionesActionPerformed

    private void subMenuFacultadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuFacultadesActionPerformed
        Abrirfacultades();
    }//GEN-LAST:event_subMenuFacultadesActionPerformed

    private void subMenuProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuProveedoresActionPerformed
        Abrirproveedores();
    }//GEN-LAST:event_subMenuProveedoresActionPerformed

    private void subMenuEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuEmpleadosActionPerformed
        Abrirempleados();
    }//GEN-LAST:event_subMenuEmpleadosActionPerformed

    private void subMenuBancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuBancosActionPerformed
        Abrirbancos();
    }//GEN-LAST:event_subMenuBancosActionPerformed

    private void subMenuFlujoCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuFlujoCajaActionPerformed
        Abrircajachica();
    }//GEN-LAST:event_subMenuFlujoCajaActionPerformed

    private void subMenuCuentasBancariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCuentasBancariasActionPerformed
        Abrircuentasbancarias();
    }//GEN-LAST:event_subMenuCuentasBancariasActionPerformed

    private void subMenuViaticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuViaticosActionPerformed
        Abrirviaticos();
    }//GEN-LAST:event_subMenuViaticosActionPerformed

    private void subMenuPeriodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuPeriodosActionPerformed
        Abrirperiodos();
    }//GEN-LAST:event_subMenuPeriodosActionPerformed

    private void subMenuCredencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCredencialActionPerformed
        Abrircredencial();
    }//GEN-LAST:event_subMenuCredencialActionPerformed

    private void subMenuDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuDepartamentosActionPerformed
        Abrirdepartamentos();
    }//GEN-LAST:event_subMenuDepartamentosActionPerformed

    private void subMenuModulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuModulosActionPerformed
        Abrirmodulos();
    }//GEN-LAST:event_subMenuModulosActionPerformed

    private void subMenuRelojActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuRelojActividadActionPerformed
        AbrirAsistenciaImagen();
    }//GEN-LAST:event_subMenuRelojActividadActionPerformed

    private void subMenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuUsuarioActionPerformed
        AbrirUsuario();
    }//GEN-LAST:event_subMenuUsuarioActionPerformed

    private void subMenuPermisosxPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuPermisosxPerfilActionPerformed
        AbrirMenuxperfil();
    }//GEN-LAST:event_subMenuPermisosxPerfilActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEstadoSesion;
    private javax.swing.JMenu menuAdministracion;
    private javax.swing.JMenu menuConfiguracion;
    private javax.swing.JMenu menuFacturacion;
    private javax.swing.JMenu menuLogistica;
    private javax.swing.JMenu menuProyecto;
    private javax.swing.JMenu menuRecursosHumanos;
    private javax.swing.JMenu menuSeguridad;
    private javax.swing.JMenu menuTesoreria;
    private javax.swing.JPanel pnlEstado;
    private javax.swing.JMenuItem subMenuAreas;
    private javax.swing.JMenuItem subMenuArticulos;
    private javax.swing.JMenuItem subMenuBancos;
    private javax.swing.JMenuItem subMenuCargos;
    private javax.swing.JMenuItem subMenuCarreras;
    private javax.swing.JMenuItem subMenuCategoria;
    private javax.swing.JMenuItem subMenuClientes;
    private javax.swing.JMenuItem subMenuComprobante;
    private javax.swing.JMenuItem subMenuComunicaciones;
    private javax.swing.JMenuItem subMenuContactos;
    private javax.swing.JMenuItem subMenuCredencial;
    private javax.swing.JMenuItem subMenuCuentasBancarias;
    private javax.swing.JMenuItem subMenuDepartamentos;
    private javax.swing.JMenuItem subMenuEmpleados;
    private javax.swing.JMenuItem subMenuExpLaboral;
    private javax.swing.JMenuItem subMenuFacultades;
    private javax.swing.JMenuItem subMenuFlujoCaja;
    private javax.swing.JMenuItem subMenuInstituciones;
    private javax.swing.JMenuItem subMenuModulos;
    private javax.swing.JMenuItem subMenuPeriodos;
    private javax.swing.JMenuItem subMenuPermisosxPerfil;
    private javax.swing.JMenuItem subMenuProveedores;
    private javax.swing.JMenuItem subMenuReciboHonorario;
    private javax.swing.JMenuItem subMenuRelojActividad;
    private javax.swing.JMenuItem subMenuTipoDocumento;
    private javax.swing.JMenuItem subMenuTipoEmpleado;
    private javax.swing.JMenuItem subMenuTransferencia;
    private javax.swing.JMenuItem subMenuUsuario;
    private javax.swing.JMenuItem subMenuViaticos;
    private javax.swing.JMenuItem submenuAsistencia;
    private javax.swing.JMenuItem submenuContratoProyecto;
    private javax.swing.JMenuItem submenuContratosPersonal;
    // End of variables declaration//GEN-END:variables
}
