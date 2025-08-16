package proyecto_gm.Proveedores;

import java.awt.Toolkit;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.Departamentos.Departamentos;

public class frmProveedores extends javax.swing.JInternalFrame {

    boolean esNuevo = false;
    
    public frmProveedores() {
        initComponents();
        //llenarComboBoxDepartamentos(cboModulo2); // Llenar el JComboBox al abrir la ventana
        
        //DatosProveedores.llenarComboBoxDepartamentos(cboModulo2);
        inicializaComboDepartamentos(); 
        btnGuardar.setEnabled(false);
        btnDeshacer.setEnabled(false);
        DatosProveedores.Habilitar(escritorio, false);

        
        
    }
    public frmProveedores(boolean parEsNuevo, int idProveedor){
        
        initComponents();
         this.limpiar();
        this.esNuevo = parEsNuevo;
        System.out.println("id seleccionado desde frmProveedor: " + idProveedor);
        habilitarMantenimiento(false);
        //llenarComboBoxDepartamentos(cboModulo2); // Llenar el JComboBox al abrir la ventana
        inicializaComboDepartamentos(); 
       if(esNuevo ){
           this.txtId.setText("");
                 txtId.setText(DatosProveedores.GenerarCodigo());  
       }else{
           txtId.setEditable(false);
           System.out.println("id seleccionado desde frmProveedor_validado: " + idProveedor);
           this.txtId.setText(String.valueOf(idProveedor)); 
           //DefaultTableModel modelo = (DefaultTableModel) tblProveedores.getModel();
           Proveedores reg =  DatosProveedores.ObtenerProveedor(idProveedor);
            txtId.setText(String.valueOf(reg.getIdProveedor())); 
           txtCorreo.setText(reg.getCorreo());
           txtDireccion.setText(reg.getDireccion());
           txtNombres.setText(reg.getNombres());
           txtRuc.setText(reg.getRuc());
           
           cmbDepartamentos.setSelectedIndex(reg.getDepartamentoId()-1);
           //cmbDepartamentos.setSelectedItem(reg.getDepartamentoNombre());
           //System.out.println("Item recuperado Departamento:" +reg.getDepartamentoId());
           txtTelefono.setText(reg.getTelefono()); 
       
       }                       
    }
     private void inicializaComboDepartamentos() {
        List<Departamentos> listaDepartamentos = DatosProveedores.listaDepartamentos(); 

        DefaultComboBoxModel<Departamentos> modelo = new DefaultComboBoxModel<>();
        for (Departamentos c : listaDepartamentos) {
            modelo.addElement(c);
        }
        cmbDepartamentos.setModel(modelo);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbDepartamentos = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("PROVEEDORES");

        escritorio.setBackground(new java.awt.Color(255, 248, 239));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAgregar.setName("agregar"); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.setName("editar"); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setName("eliminar"); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.setName("guardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnDeshacer.setName("deshacer"); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        txtId.setNextFocusableComponent(txtNombres);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombres:");

        txtNombres.setNextFocusableComponent(txtDireccion);
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel3.setText("Dirección:");

        txtDireccion.setNextFocusableComponent(txtCorreo);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel4.setText("Correo:");

        txtCorreo.setNextFocusableComponent(txtTelefono);

        jLabel5.setText("Telefono:");

        txtTelefono.setNextFocusableComponent(txtRuc);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel6.setText("Ruc:");

        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        jLabel7.setText("Departamento:");

        cmbDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeshacer))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(44, 44, 44)
                                .addComponent(txtRuc))
                            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(50, 50, 50)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDepartamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(29, 29, 29)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar)
                    .addComponent(btnGuardar)
                    .addComponent(btnDeshacer))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarFormulario(boolean estado){
        limpiar();
        if(estado){
        
        }else{
            
        }
    }
    private void limpiar(){
        this.txtCorreo.setText("");
        this.txtDireccion.setText("");
        this.txtId.setText("");
        this.txtNombres.setText("");
        this.txtRuc.setText("");
        this.txtTelefono.setText("");
        this.cmbDepartamentos.setSelectedIndex(-1);
    }
    private void habilitarControles(boolean estado)
    {
        this.txtCorreo.setEnabled(estado);
        this.txtDireccion.setEnabled(estado);
        this.txtId.setEnabled(false);
        this.txtNombres.setEnabled(estado);
        this.txtRuc.setEnabled(estado);
        this.txtTelefono.setEnabled(estado);
    }

    private void habilitarMantenimiento(boolean estado){
        btnGuardar.setEnabled(!estado);
        btnDeshacer.setEnabled(!estado);
        btnAgregar.setEnabled(estado);
        btnEditar.setEnabled(estado);
        btnEliminar.setEnabled(estado);
    }
    private void guardar(boolean estadoNuevo){
        String opcion = DatosProveedores.Capturar(cmbDepartamentos);
        
//         Proveedores pro = new Proveedores(
//                txtId.getText(), // IdProveedor
//                txtNombres.getText(), // Nombres
//                txtDireccion.getText(), // Direccion
//                txtCorreo.getText(), // Correo
//                txtTelefono.getText(), // Telefono
//                txtRuc.getText(), // Ruc
//                opcion // departamentoId
//        );
        int idDepartamento = Integer.parseInt(DatosProveedores.Capturar(cmbDepartamentos));
        
        Proveedores pro = new Proveedores();
        pro.setIdProveedor(Integer.parseInt(txtId.getText()));        
        pro.setDepartamentoId(idDepartamento);
        pro.setDireccion(txtDireccion.getText());
        pro.setCorreo(txtCorreo.getText());
        pro.setNombres(txtNombres.getText());
        pro.setRuc(txtRuc.getText());
        pro.setTelefono(txtTelefono.getText());
        
        //pro.setDepartamentoId(PROPERTIES);
        if(estadoNuevo){
        System.out.println("Intentando insertar proveedor...");
            if (DatosProveedores.InsertarDatos(pro)) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                System.out.println("ID Departamento capturado: " + opcion);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }else{
            
            //pro.setIdProveedor(Integer.parseInt(txtId.getText()));
            if (DatosProveedores.Actualizar(pro,  cmbDepartamentos)) {
                JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        habilitarControles(false);
        habilitarMantenimiento(false);
        limpiar();

        
        this.setVisible(false);
        
    }
    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // TODO add your handling code here:
        //DatosProveedores.Limpiar(escritorio);
        //DatosProveedores.Habilitar(escritorio, false);
        limpiar();
        habilitarControles(false);
        habilitarMantenimiento(false);
        
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        guardar(this.esNuevo);
        frmListaProveedores.cargarLista();
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        DatosProveedores.Eliminar(Integer.parseInt(txtId.getText()));
        //DatosProveedores.Habilitar(escritorio, false);
        esNuevo = false;
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Crear el arreglo con los campos de texto
        JTextField[] cod = new JTextField[6];
        cod[0] = txtId;
        cod[1] = txtDireccion;
        cod[2] = txtTelefono;
        cod[3] = txtNombres;
        cod[4] = txtCorreo;
        cod[5] = txtRuc;

        // Crear el arreglo con el ComboBox de departamento
        JComboBox[] combos = {cmbDepartamentos}; // Pasamos solo el ComboBox

        // Llamar al método Editar pasándole el ComboBox junto con los campos de texto
        Proveedores registro = new Proveedores();
        registro.setIdProveedor(Integer.parseInt(txtId.getText()));
        registro.setDireccion(txtDireccion.getText());
        registro.setTelefono(txtTelefono.getText());
        registro.setNombres(txtNombres.getText());
        registro.setCorreo(txtCorreo.getText());
        registro.setRuc(txtRuc.getText());
                                
        
        
        esNuevo = false;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        String codigo = DatosProveedores.GenerarCodigo(); 

        if (codigo != null && !codigo.isEmpty()) {
            txtId.setText(codigo);
            txtId.setEnabled(false);
            txtId.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error al generar el código.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        DatosProveedores.Habilitar(escritorio, true);
        esNuevo = true;
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        if (txtId.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();
        }
        if (txtTelefono.getText().length() >= 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        if (txtRuc.getText().length() >= 11) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDireccionKeyTyped

    private void cmbDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDepartamentosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Departamentos> cmbDepartamentos;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
