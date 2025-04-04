/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyecto_gm.credencial;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc_sistemas2022
 */
public class frmCredencial extends javax.swing.JInternalFrame {
private boolean esNuevo = false;
    /**
     * Creates new form frmCredencial
     */
    public frmCredencial() {
        initComponents();
        btnGuardar.setEnabled(false);
        btnDeshacer.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnAgregar.setEnabled(true);
        DefaultTableModel modelo = (DefaultTableModel) tblContacto.getModel();
        DatosCredencial.Listar(modelo);
        Habilitar(false);
        Limpiar();
        tblContacto.setCellSelectionEnabled(false);
        tblContacto.setRowSelectionAllowed(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnDeshacer = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContacto = new javax.swing.JTable();

        setClosable(true);
        setTitle("Credencial");

        jLabel1.setText("Correo");

        jLabel2.setText("Clave");

        jLabel3.setText("Alias");

        jLabel4.setText("Descripcion");

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblContacto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Correo", "Clave", "Alias", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblContacto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(35, 35, 35))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(72, 72, 72))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAlias)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(txtClave)
                            .addComponent(txtCorreo))
                        .addGap(215, 215, 215))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeshacer)
                        .addContainerGap())))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeshacer, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void Limpiar(){
    txtCorreo.setText("");
    txtClave.setText("");
    txtAlias.setText("");
    txtDescripcion.setText("");
    
}

private void Habilitar(boolean estado){
    txtCorreo.setEnabled(estado);
    txtClave.setEnabled(estado);
    txtAlias.setEnabled(estado);
    txtDescripcion.setEnabled(estado);
}
    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // TODO add your handling code here:
/*
        DatosContacto.LimpiarCampos(escritorio);

        DatosContacto.BloquearCampos(escritorio);
        */
        btnGuardar.setEnabled(false);
        btnDeshacer.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnAgregar.setEnabled(true);
        esNuevo = false;
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        
        
        try{
            Credencial c = new Credencial();
            c.setCorreo(txtCorreo.getText());
            c.setClave(txtClave.getText());
            c.setAlias(txtAlias.getText());
            c.setDescripcion(txtDescripcion.getText());
            if(esNuevo){
                DatosCredencial.Insertar(c, tblContacto);
            }else{
                DatosCredencial.Actualizar(c, tblContacto);
            }

              Limpiar();
            Habilitar(false);
            btnGuardar.setEnabled(false);
            btnDeshacer.setEnabled(false);
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnAgregar.setEnabled(true);
            esNuevo = false;
        }catch(Exception ex){
        
        }
        /*
     

        if (esNuevo) {
            // Insertar nuevo registro
            if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty()
                || txtTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Completar bien los campos");
                return;
            } else {
                DatosContacto.insertarDatos(f, tblContacto);
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            }
        } else {
            // Actualizar registro existente
            if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty()
                || txtTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Completar bien los campos");
                return;
            } else {
                DatosContacto.actualizarDatos(f, tblContacto);
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            }
        }
        //        DatosFacultades.limpiarCampos(jPanel1);
        //        DatosFacultades.bloquearCampos(jPanel1);

        
        DatosContacto.LimpiarCampos(escritorio);
        DatosContacto.BloquearCampos(escritorio);
        */
      
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        /*
        DatosContacto.eliminarDatos(tblContacto);
        txtId.setEnabled(false);
        txtNombre.setEnabled(false);
        txtFecha.setEnabled(false);
        txtPersonas.setEnabled(false);
        txtEmpresa.setEnabled(false);
        txtCargo.setEnabled(false);
        txtCorreo.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtNota.setEnabled(false);
        cboDepartamento.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnDeshacer.setEnabled(false);
*/
    }//GEN-LAST:event_btnEliminarActionPerformed
    private int id;
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        // Habilitamos los campos:
        
        esNuevo = false;
        Habilitar(true);
        DefaultTableModel modelo = (DefaultTableModel) this.tblContacto.getModel();
        id = 0; String correo = "", clave = "", alias = "", descripcion = "";
        int filaSeleccionada = this.tblContacto.getSelectedRow();
        
        id =   Integer.parseInt(modelo.getValueAt(filaSeleccionada,0).toString());
        correo = String.valueOf(modelo.getValueAt(filaSeleccionada, 1));
        clave = String.valueOf(modelo.getValueAt(filaSeleccionada, 2));
        alias = String.valueOf(modelo.getValueAt(filaSeleccionada, 3));
        descripcion = String.valueOf(modelo.getValueAt(filaSeleccionada, 4));
        txtCorreo.setText(correo);
        txtClave.setText(clave);
        txtAlias.setText(alias);
        txtDescripcion.setText(descripcion);
        
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnDeshacer.setEnabled(true);
        btnEditar.setEnabled(false);
        
        /*modelo.getValueAt(ERROR, WIDTH)*/
        /*
        
        txtId.setEnabled(true);
        txtNombre.setEnabled(true);
        txtFecha.setEnabled(true);
        txtPersonas.setEnabled(true);
        txtEmpresa.setEnabled(true);
        txtCargo.setEnabled(true);
        txtCorreo.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtNota.setEnabled(true);
        cboDepartamento.setEnabled(true);

        DatosContacto.habilitarCampos(escritorio);

        // Agrupar las cajas de texto
        JTextField[] camposTexto = {txtId, txtNombre,txtFecha,txtPersonas,txtEmpresa,txtCargo,txtCorreo,txtTelefono,txtDireccion,txtNota};

        JComboBox[] combos = {cboDepartamento};
        DatosContacto.Editar(tblContacto, camposTexto, combos);

        esNuevo = false;
*/
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       esNuevo = true;
       Limpiar();
        Habilitar(true);
        txtCorreo.requestFocus();
          btnGuardar.setEnabled(true);
        btnDeshacer.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAgregar.setEnabled(false);
        /*
        DatosContacto.habilitarCampos(escritorio);
        //String codigo = DatosContacto.GenerarCodigo("contactos", "CO", 4);
        String codigo = DatosContacto.GenerarCodigoEntero("contactos");
        txtId.setText(codigo);
        txtNombre.setEnabled(true);
        txtFecha.setEnabled(true);
        txtPersonas.setEnabled(true);
        txtEmpresa.setEnabled(true);
        txtCargo.setEnabled(true);
        txtCorreo.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtNota.setEnabled(true);
        cboDepartamento.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnDeshacer.setEnabled(true);
        btnAgregar.setEnabled(false);
        txtNombre.requestFocus();
        esNuevo = true;
*/
       
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblContacto;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
