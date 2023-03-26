/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyecto_gm.Empleado;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUIS
 */
public class frmEmpleado extends javax.swing.JInternalFrame {
    
    boolean esNuevo = false;
    
    public frmEmpleado() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblEmpleado.getModel();
        DatosEmpleados.BloquearCampos(escritorio, opcionesTipoEmpleado);
        DatosEmpleados.CargarCombos(cboArea, cboCargo);
        rbPorDefinir.setSelected(true);
        DatosEmpleados.MostrarDatos(modelo);
        btnGuardar.setEnabled(false); btnCancelar.setEnabled(false);
        
        // Quitar la edicion de las celdas
        tblEmpleado.setCellSelectionEnabled(false);
        // Poder seleccionar fila(s) de la tabla
        tblEmpleado.setRowSelectionAllowed(true);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuItem1 = new javax.swing.JMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        opcionesTipoEmpleado = new javax.swing.ButtonGroup();
        escritorio = new javax.swing.JDesktopPane();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtFechaNac = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtDirec = new javax.swing.JTextField();
        txtCel = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        rbEstable = new javax.swing.JRadioButton();
        rbPracticante = new javax.swing.JRadioButton();
        rbPorDefinir = new javax.swing.JRadioButton();
        jLabel55 = new javax.swing.JLabel();
        btnDatAcad = new javax.swing.JButton();
        cboArea = new javax.swing.JComboBox<>();
        cboCargo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmpleado = new javax.swing.JTable();
        btnExport = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenuItem1.setText("jMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        opcionesTipoEmpleado.add(rbEstable);
        opcionesTipoEmpleado.add(rbPracticante);
        opcionesTipoEmpleado.add(rbPorDefinir);

        setClosable(true);
        setIconifiable(true);
        setTitle("EMPLEADO");
        setPreferredSize(new java.awt.Dimension(1086, 700));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel45.setText("ID:");

        jLabel46.setText("APELLIDOS:");

        jLabel47.setText("NOMBRES:");

        jLabel48.setText("F. NACIMIENTO:");

        jLabel49.setText("CORREO:");

        txtFechaNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacActionPerformed(evt);
            }
        });
        txtFechaNac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaNacKeyTyped(evt);
            }
        });

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel50.setText("DNI:");

        jLabel51.setText("CELULAR:");

        jLabel52.setText("DIRECCIÓN:");

        jLabel53.setText("ÁREA:");

        jLabel54.setText("CARGO:");

        txtCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelKeyTyped(evt);
            }
        });

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        rbEstable.setText("Estable");
        rbEstable.setActionCommand("Estable");

        rbPracticante.setText("Practicante");
        rbPracticante.setActionCommand("Practicante");

        rbPorDefinir.setText("Por definir...");
        rbPorDefinir.setActionCommand("Por definir...");

        jLabel55.setText("TIP. EMPLEADO");

        btnDatAcad.setText("Registrar Datos Académicos");
        btnDatAcad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatAcadjButton3ActionPerformed(evt);
            }
        });

        tblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "APELLIDOS", "NOMBRES", "F. NACIMIENTO", "CORREO", "DNI", "CELULAR", "DIRECCIÓN", "ÁREA", "CARGO", "TIP. EMPLEADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleado.setPreferredSize(new java.awt.Dimension(1000, 600));
        jScrollPane3.setViewportView(tblEmpleado);

        btnExport.setText("Exportar Datos");

        escritorio.setLayer(btnNuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel45, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel46, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel47, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel48, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel49, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtCorreo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtFechaNac, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtNom, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtApe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel50, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel51, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel52, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel53, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel54, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtDirec, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtCel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtDni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(rbEstable, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(rbPracticante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(rbPorDefinir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel55, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnDatAcad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(cboArea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(cboCargo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnExport, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49))
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jLabel53)
                    .addComponent(jLabel50)
                    .addComponent(jLabel52)
                    .addComponent(jLabel54))
                .addGap(21, 21, 21)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addComponent(rbEstable, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbPracticante)
                                .addGap(18, 18, 18)
                                .addComponent(rbPorDefinir))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel55)
                                .addGap(92, 92, 92)))
                        .addGap(25, 25, 25))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnExport)
                        .addGap(73, 73, 73)
                        .addComponent(btnDatAcad)
                        .addGap(62, 62, 62))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel55)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbEstable)
                            .addComponent(rbPracticante)
                            .addComponent(rbPorDefinir))))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel47)
                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel52)
                        .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(btnDatAcad)
                    .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatAcadjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatAcadjButton3ActionPerformed
        // Abrimos la ventana de registro academico
        Datosacad verventana = new Datosacad();
        
        if (DatosEmpleados.ObtenerEmpleado(tblEmpleado)) { // Si se ejecuta bien el metodo
            escritorio.add(verventana);
            verventana.setVisible(true);
            // Limpiamos alguna seleccion previa de alguna fila de la tabla
            tblEmpleado.clearSelection();
        }
    }//GEN-LAST:event_btnDatAcadjButton3ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Habilitamos los campos:
        DatosEmpleados.HabilitarCampos(escritorio, opcionesTipoEmpleado);
        txtId.requestFocus(); // Colocamos el cursor en txtId
        
        // Habilitamos los siguientes botones
        btnGuardar.setEnabled(true); btnCancelar.setEnabled(true);
        // Bloqueamos los siguientes botones
        btnEditar.setEnabled(false); btnEliminar.setEnabled(false);
        // Deshabilitamos la seleccion de filas de la tabla
        tblEmpleado.setRowSelectionAllowed(false);
        
        esNuevo = true; // Indicamos que sera un nuevo registro
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // IMPORTANTE: Al presionar en "Editar", txtId quedará deshabilitado.
        // Lo habilitaremos al presionar "Guardar".

        // Habilitamos los campos:
        DatosEmpleados.HabilitarCampos(escritorio, opcionesTipoEmpleado);

        // Agrupar las cajas de texto
        JTextField[] camposTexto = {txtId, txtApe, txtNom, txtFechaNac, txtCorreo,
            txtDni, txtCel, txtDirec};

        // Agrupar los combo boxes y cargar el radio button correspondiente
        // que esta en el button group
        JComboBox[] combos = {cboArea, cboCargo};
        DatosEmpleados.Editar(tblEmpleado, camposTexto, combos, opcionesTipoEmpleado);
        
        esNuevo = false; // Indicamos que no sera un nuevo registro
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Eliminamos el registro seleccionado y bloqueamos los campos
        DatosEmpleados.EliminarDatos(tblEmpleado);
        DatosEmpleados.BloquearCampos(escritorio, opcionesTipoEmpleado);
        
        // Bloqueamos los siguientes botones:
        btnGuardar.setEnabled(false); btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Obtenemos los ids del area, cargo y tipo seleccionado
        String[] opciones = DatosEmpleados.CapturarOpciones(cboArea, cboCargo, opcionesTipoEmpleado);

        // Creamos un objeto tipo Empleado
        Empleados empleado = new Empleados(txtId.getText(), txtApe.getText(), txtNom.getText(),
                txtFechaNac.getText(), txtCorreo.getText(), txtDni.getText(), txtCel.getText(),
                txtDirec.getText(), opciones[0], opciones[1], opciones[2]);

        // Preguntamos si haremos un INSERT o un UPDATE
        if (esNuevo) {
            if (DatosEmpleados.ValidarCampos(empleado)) {
                DatosEmpleados.InsertarDatos(empleado, tblEmpleado);
            }
        } else {
            if (DatosEmpleados.ValidarCampos(empleado)) {
                DatosEmpleados.ActualizarDatos(empleado, tblEmpleado);
                txtId.setEnabled(true); // Habilitamos txtId
            }
        }
        
        DatosEmpleados.LimpiarCampos(escritorio, rbPorDefinir);
        DatosEmpleados.BloquearCampos(escritorio, opcionesTipoEmpleado);
        
        // Bloqueamos los siguientes botones:
        btnGuardar.setEnabled(false); btnCancelar.setEnabled(false);
        // Habilitamos lo siguientes botones:
        btnNuevo.setEnabled(true); btnEditar.setEnabled(true); btnEliminar.setEnabled(true);
        // Limpiamos alguna seleccion previa de alguna fila de la tabla
        tblEmpleado.clearSelection();
        // Habilitamos la seleccion de filas de la tabla
        tblEmpleado.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Limpiamos y bloqueamos los campos:
        DatosEmpleados.LimpiarCampos(escritorio, rbPorDefinir);
        DatosEmpleados.BloquearCampos(escritorio, opcionesTipoEmpleado);
        
        // Bloqueamos los siguientes botones:
        btnGuardar.setEnabled(false); btnCancelar.setEnabled(false);
        // Habilitamos lo siguientes botones:
        btnNuevo.setEnabled(true); btnEditar.setEnabled(true); btnEliminar.setEnabled(true);
        // Limpiamos alguna seleccion previa de alguna fila de la tabla
        tblEmpleado.clearSelection();
        // Habilitamos la seleccion de filas de la tabla
        tblEmpleado.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        if (txtId.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtFechaNacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaNacKeyTyped
        // TODO add your handling code here:
        if (txtFechaNac.getText().length() >= 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtFechaNacKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();
        }
        if (txtDni.getText().length() >= 8) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
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
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCelKeyTyped

    private void txtFechaNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDatAcad;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExport;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboArea;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.ButtonGroup opcionesTipoEmpleado;
    private javax.swing.JRadioButton rbEstable;
    private javax.swing.JRadioButton rbPorDefinir;
    private javax.swing.JRadioButton rbPracticante;
    private javax.swing.JTable tblEmpleado;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDirec;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
