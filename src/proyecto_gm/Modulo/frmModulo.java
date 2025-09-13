package proyecto_gm.Modulo;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmModulo extends javax.swing.JInternalFrame {

    private boolean esNuevo = false;
    private DefaultTableModel modeloTabla;

    public frmModulo() {
        initComponents();
        
        // Configurar el modelo de la tabla una sola vez
        modeloTabla = new DefaultTableModel() {
            // Hacemos que las celdas de la tabla no sean editables
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblModulo.setModel(modeloTabla);
        
        cargarTabla();
        gestionarControles(false); // Estado inicial
    }
    
    // Método para cargar y recargar los datos en la tabla
    private void cargarTabla() {
        DatosModulo.listar(modeloTabla);
    }

    // Centraliza la gestión de la habilitación de controles
    private void gestionarControles(boolean editando) {
        // Campos de texto
        txtDescripcion.setEnabled(editando);
        txtId.setEnabled(false); // El ID nunca es editable

        // Botones de acción principal
        btnAgregar.setEnabled(!editando);
        btnEditar.setEnabled(!editando);
        btnEliminar.setEnabled(!editando);

        // Botones de formulario
        btnGuardar.setEnabled(editando);
        btnDeshacer.setEnabled(editando);

        // Tabla
        tblModulo.setEnabled(!editando);
    }
    
    // Limpia los campos del formulario
    private void limpiarCampos() {
        txtId.setText("");
        txtDescripcion.setText("");
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
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModulo = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();

        setClosable(true);
        setIconifiable(true);
        setTitle("MODULO");

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

        jLabel2.setText("Descripción:");

        tblModulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblModulo);
        if (tblModulo.getColumnModel().getColumnCount() > 0) {
            tblModulo.getColumnModel().getColumn(0).setResizable(false);
            tblModulo.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar))
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeshacer)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar)
                            .addComponent(btnEditar)
                            .addComponent(btnAgregar))
                        .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnDeshacer))
                .addGap(19, 19, 19)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        limpiarCampos();
        gestionarControles(false);
        tblModulo.clearSelection();
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Validar campos
        if (txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo descripción no puede estar vacío.", "Validación", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }

        // Crear objeto Modulo con datos del formulario
        Modulo modulo = new Modulo();
        modulo.setDescripcion(txtDescripcion.getText().trim());

        boolean resultado;
        if (esNuevo) {
            // Insertar nuevo módulo
            resultado = DatosModulo.insertar(modulo);
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Módulo registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Actualizar módulo existente
            modulo.setId(Integer.parseInt(txtId.getText()));
            resultado = DatosModulo.actualizar(modulo);
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Módulo actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        if (resultado) {
            cargarTabla();
            limpiarCampos();
            gestionarControles(false);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tblModulo.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar el módulo seleccionado?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            if (DatosModulo.eliminar(id)) {
                JOptionPane.showMessageDialog(this, "Módulo eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
                limpiarCampos();
                gestionarControles(false);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int filaSeleccionada = tblModulo.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener datos de la tabla
        int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        String descripcion = (String) modeloTabla.getValueAt(filaSeleccionada, 1);

        // Cargar datos en el formulario
        txtId.setText(String.valueOf(id));
        txtDescripcion.setText(descripcion);

        esNuevo = false;
        gestionarControles(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        esNuevo = true;
        gestionarControles(true);
        limpiarCampos();
        txtId.setText("(Automático)");
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblModulo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
