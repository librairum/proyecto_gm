/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyecto_gm.Empleado;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.Exportar;

/**
 *
 * @author jeanv
 */
public class frmEmpleado extends javax.swing.JInternalFrame {
    
    boolean esNuevo = false;

    /**
     * Creates new form frmEmpleado
     */
    public frmEmpleado() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblEmpleados.getModel();
        DatosEmpleados.BloquearCampos(escritorio, opcionesTipo);
        DatosEmpleados.CargarCombos(cboArea, cboCargo);
        rbPorDefinir.setSelected(true);
        DatosEmpleados.Mostrar(modelo);
        btnGuardar.setEnabled(false); btnCancelar.setEnabled(false);
        // Quitar la edicion de las celdas
        tblEmpleados.setCellSelectionEnabled(false);
        // Poder seleccionar fila(s) de la tabla
        tblEmpleados.setRowSelectionAllowed(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcionesTipo = new javax.swing.ButtonGroup();
        escritorio = new javax.swing.JDesktopPane();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecNac = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboCargo = new javax.swing.JComboBox<>();
        cboArea = new javax.swing.JComboBox<>();
        txtDirec = new javax.swing.JTextField();
        txtCel = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();
        btnDatAcad = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        rbEstable = new javax.swing.JRadioButton();
        rbPracticante = new javax.swing.JRadioButton();
        rbPorDefinir = new javax.swing.JRadioButton();

        opcionesTipo.add(rbEstable);
        opcionesTipo.add(rbPracticante);
        opcionesTipo.add(rbPorDefinir);

        setClosable(true);
        setIconifiable(true);
        setTitle("EMPLEADOS");
        setPreferredSize(new java.awt.Dimension(1086, 640));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtId.setNextFocusableComponent(txtApe);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        txtApe.setNextFocusableComponent(txtNom);
        txtApe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApeFocusLost(evt);
            }
        });

        txtNom.setNextFocusableComponent(txtFecNac);
        txtNom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomFocusLost(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel4.setText("Apellidos:");

        jLabel3.setText("Nombres:");

        jLabel2.setText("Fecha de nacimiento:");

        txtFecNac.setNextFocusableComponent(txtCorreo);
        txtFecNac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecNacKeyTyped(evt);
            }
        });

        jLabel12.setText("dd-mm-aaaa");

        txtCorreo.setNextFocusableComponent(txtDni);
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        jLabel5.setText("Correo:");

        cboCargo.setNextFocusableComponent(rbPorDefinir);

        cboArea.setNextFocusableComponent(cboCargo);

        txtDirec.setNextFocusableComponent(cboArea);
        txtDirec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDirecFocusLost(evt);
            }
        });

        txtCel.setNextFocusableComponent(txtDirec);
        txtCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelKeyTyped(evt);
            }
        });

        txtDni.setNextFocusableComponent(txtCel);
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jLabel7.setText("DNI:");

        jLabel6.setText("Celular:");

        jLabel8.setText("Dirección:");

        jLabel9.setText("Área:");

        jLabel11.setText("Cargo:");

        btnExportar.setText("Exportar a Excel");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnDatAcad.setText("Registrar Datos Académicos");
        btnDatAcad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatAcadActionPerformed(evt);
            }
        });

        jLabel10.setText("Tip. Empleado");

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "APELLIDOS", "NOMBRES", "FEC. NACIMIENTO", "CORREO", "DNI", "CELULAR", "DIRECCIÓN", "ÁREA", "CARGO", "TIP. EMPLEADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEmpleados);
        if (tblEmpleados.getColumnModel().getColumnCount() > 0) {
            tblEmpleados.getColumnModel().getColumn(0).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(1).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(2).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(3).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(4).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(5).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(6).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(7).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(8).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(9).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(10).setResizable(false);
        }

        rbEstable.setText("Estable");
        rbEstable.setNextFocusableComponent(btnGuardar);
        rbEstable.setActionCommand("Estable");

        rbPracticante.setText("Practicante");
        rbPracticante.setNextFocusableComponent(btnGuardar);
        rbPracticante.setActionCommand("Practicante");

        rbPorDefinir.setText("Por definir...");
        rbPorDefinir.setNextFocusableComponent(btnGuardar);
        rbPorDefinir.setActionCommand("Por definir...");

        escritorio.setLayer(btnNuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtApe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtNom, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtFecNac, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtCorreo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(cboCargo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(cboArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtDirec, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtCel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtDni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnExportar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnDatAcad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(rbEstable, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(rbPracticante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(rbPorDefinir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDni, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDirec, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cboCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                        .addComponent(rbEstable)
                        .addGap(18, 18, 18)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(rbPracticante)
                                .addGap(18, 18, 18)
                                .addComponent(rbPorDefinir)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                        .addComponent(btnDatAcad)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                        .addComponent(btnExportar)
                        .addGap(105, 105, 105))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNuevo)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEditar)
                        .addComponent(btnEliminar)
                        .addComponent(btnGuardar)
                        .addComponent(btnCancelar)))
                .addGap(32, 32, 32)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExportar)))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbPracticante)
                            .addComponent(rbEstable)
                            .addComponent(rbPorDefinir))
                        .addGap(18, 18, 18)
                        .addComponent(btnDatAcad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Obtenemos los ids del area, cargo y tipo seleccionado
        // Capturar las opciones seleccionadas en los combo boxes
        String[] opciones = DatosEmpleados.CapturarOpciones(cboArea, cboCargo, opcionesTipo);

        // Creamos un objeto tipo Empleado
        Empleados empleado = new Empleados();
        empleado.setId(txtId.getText());
        empleado.setApellidos(txtApe.getText());
        empleado.setNombres(txtNom.getText());
        empleado.setfNacimiento(txtFecNac.getText());
        empleado.setCorreo(txtCorreo.getText());
        empleado.setDni(txtDni.getText());
        empleado.setCelular(txtCel.getText());
        empleado.setDireccion(txtDirec.getText());
        empleado.setIdArea(opciones[0]);
        empleado.setIdCargo(opciones[1]);
        empleado.setIdTipo(opciones[2]);

        // Seleccionamos las cajas para validar
        JTextField[] porValidar = {txtId, txtApe, txtNom, txtFecNac, txtCorreo, txtDni, txtCel, txtDirec};

        // Preguntamos si haremos un INSERT o un UPDATE
        if (esNuevo) {
            if (DatosEmpleados.Validar(porValidar)) {
                DatosEmpleados.Insertar(empleado, tblEmpleados);
                DatosEmpleados.CleanForm(escritorio, rbPorDefinir, opcionesTipo, tblEmpleados);
            }
        } else {
            if (DatosEmpleados.Validar(porValidar)) {
                DatosEmpleados.Actualizar(empleado, tblEmpleados);
                DatosEmpleados.CleanForm(escritorio, rbPorDefinir, opcionesTipo, tblEmpleados);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        // TODO add your handling code here:
        String text = txtCorreo.getText().trim(); // Eliminamos los espacios del inicio y del final
        txtCorreo.setText(text);
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isUpperCase(c) || Character.isDigit(c))) {
            evt.consume(); // Si no es letra mayúscula o número, se ignora el evento de tecla
        }

        if (txtId.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Limpiamos y bloqueamos los campos:
        DatosEmpleados.CleanForm(escritorio, rbPorDefinir, opcionesTipo, tblEmpleados);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // IMPORTANTE: Al presionar en "Editar", txtId quedará deshabilitado.
        // Lo habilitaremos al presionar "Guardar".

        // Agrupar las cajas de texto
        JTextField[] camposTexto = {txtId, txtApe, txtNom, txtFecNac, txtCorreo,
            txtDni, txtCel, txtDirec};

        // Agrupar los combo boxes y cargar el radio button correspondiente
        // que esta en el button group
        JComboBox[] combos = {cboArea, cboCargo};
        DatosEmpleados.Editar(escritorio, tblEmpleados, camposTexto, combos, opcionesTipo);

        esNuevo = false; // Indicamos que no sera un nuevo registro
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Eliminamos el registro seleccionado y bloqueamos los campos
        DatosEmpleados.Eliminar(tblEmpleados);
        DatosEmpleados.BloquearCampos(escritorio, opcionesTipo);

        // Bloqueamos los siguientes botones:
        btnGuardar.setEnabled(false); btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtFecNacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecNacKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '-')) {
            evt.consume(); // Si no es un número o un guión, se ignora el evento de tecla
        }

        if (txtFecNac.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFecNacKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume() ;// Si no es un número, se ignora el evento de tecla
        }
        if (txtDni.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();
        }
        if (txtCel.getText().length() >= 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Habilitamos los campos:
        DatosEmpleados.HabilitarCampos(escritorio, opcionesTipo);
        txtId.requestFocus();

        // Habilitamos los siguientes botones
        btnGuardar.setEnabled(true); btnCancelar.setEnabled(true);
        // Bloqueamos los siguientes botones
        btnNuevo.setEnabled(false); btnEditar.setEnabled(false); btnEliminar.setEnabled(false);
        // Deshabilitamos la seleccion de filas de la tabla
        tblEmpleados.setRowSelectionAllowed(false);

        esNuevo = true; // Indicamos que sera un nuevo registro
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtNomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomFocusLost
        // TODO add your handling code here:
        String text = txtNom.getText().trim(); // Eliminamos los espacios del inicio y del final
        txtNom.setText(text);
    }//GEN-LAST:event_txtNomFocusLost

    private void txtApeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApeFocusLost
        // TODO add your handling code here:
        String text = txtApe.getText().trim(); // Eliminamos los espacios del inicio y del final
        txtApe.setText(text);
    }//GEN-LAST:event_txtApeFocusLost

    private void txtDirecFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirecFocusLost
        // TODO add your handling code here:
        String text = txtDirec.getText().trim(); // Eliminamos los espacios del inicio y del final
        txtDirec.setText(text);
    }//GEN-LAST:event_txtDirecFocusLost

    private void btnDatAcadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatAcadActionPerformed
        // TODO add your handling code here:
        Datosacad verventana = new Datosacad();
        
        if (DatosEmpleados.ObtenerEmpleado(tblEmpleados)) { // Si se ejecuta bien el metodo
            escritorio.add(verventana);
            verventana.setVisible(true);
            // Limpiamos alguna seleccion previa de alguna fila de la tabla
            tblEmpleados.clearSelection();
        }
    }//GEN-LAST:event_btnDatAcadActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
            Exportar obj = new Exportar();
            obj.exportarExcel(tblEmpleados);
        } catch (IOException ex) {
            Logger.getLogger(frmEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDatAcad;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboArea;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup opcionesTipo;
    private javax.swing.JRadioButton rbEstable;
    private javax.swing.JRadioButton rbPorDefinir;
    private javax.swing.JRadioButton rbPracticante;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDirec;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFecNac;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
