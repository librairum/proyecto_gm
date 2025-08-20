package proyecto_gm.Cargo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import proyecto_gm.InterfazBase.OperacionesBasicas;
import proyecto_gm.Utilitario;

public class frmCargo extends javax.swing.JInternalFrame implements OperacionesBasicas {

    boolean esNuevo = false;

    public frmCargo() {
        initComponents();
        JTableHeader header = tblCargo.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                setBackground(Color.DARK_GRAY);
                setForeground(Color.WHITE);
                setFont(getFont().deriveFont(Font.BOLD, 13));
                return this;
            }
        });
        

        habilitarBotonesMantenimiento(true);

        Cargar();
        tblCargo.setCellSelectionEnabled(false);
        tblCargo.setRowSelectionAllowed(true);

    }
    private void Cargar(){
        DefaultTableModel modelo = (DefaultTableModel) tblCargo.getModel();
        DatosCargo.Mostrar(modelo);
        
    }
    
    private void limpiarCampos() {
        txtCodigo.setText("");
        txtDescripcion.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCargo = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();

        setClosable(true);
        setIconifiable(true);
        setTitle("CARGO");
        setMaximumSize(new java.awt.Dimension(500, 312));
        setMinimumSize(new java.awt.Dimension(500, 312));
        setPreferredSize(new java.awt.Dimension(500, 312));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Id:");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        jLabel2.setText("Descripción:");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAgregar.setMaximumSize(new java.awt.Dimension(40, 29));
        btnAgregar.setMinimumSize(new java.awt.Dimension(40, 29));
        btnAgregar.setName("agregar"); // NOI18N
        btnAgregar.setPreferredSize(new java.awt.Dimension(30, 29));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.setMaximumSize(new java.awt.Dimension(30, 29));
        btnEditar.setMinimumSize(new java.awt.Dimension(30, 29));
        btnEditar.setName("editar"); // NOI18N
        btnEditar.setPreferredSize(new java.awt.Dimension(30, 29));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setMaximumSize(new java.awt.Dimension(30, 29));
        btnEliminar.setMinimumSize(new java.awt.Dimension(30, 29));
        btnEliminar.setName("eliminar"); // NOI18N
        btnEliminar.setPreferredSize(new java.awt.Dimension(30, 29));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.setMaximumSize(new java.awt.Dimension(30, 29));
        btnGuardar.setMinimumSize(new java.awt.Dimension(30, 29));
        btnGuardar.setName("guardar"); // NOI18N
        btnGuardar.setPreferredSize(new java.awt.Dimension(30, 29));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnDeshacer.setMaximumSize(new java.awt.Dimension(30, 29));
        btnDeshacer.setMinimumSize(new java.awt.Dimension(30, 29));
        btnDeshacer.setName("deshacer"); // NOI18N
        btnDeshacer.setPreferredSize(new java.awt.Dimension(30, 29));
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tblCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCargo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //selecionar id de la fila y columna seleccionad
        boolean respuesta =  Utilitario.MostrarMensajePregunta("¿Dese eliminar el registro?", Utilitario.TipoMensaje.pregunta);
        if(respuesta){
            String id = tblCargo.getValueAt(tblCargo.getSelectedRow(), 0).toString();
            if(DatosCargo.Eliminar(id)){
                Utilitario.MostrarMensaje("Elminacion exitosa", Utilitario.TipoMensaje.informativo);

                tblCargo.clearSelection();
                tblCargo.setRowSelectionAllowed(true);
                Cargar();
            }
        }    
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblCargo.getSelectedRow();
        if (fila == -1) {
            Utilitario.MostrarMensaje("Seleccione un registro para editar", Utilitario.TipoMensaje.alerta);
            return;
        }
        txtCodigo.setText(tblCargo.getValueAt(fila, 0).toString());
        txtDescripcion.setText(tblCargo.getValueAt(fila, 1).toString());

        txtCodigo.setEnabled(false);
        txtDescripcion.setEnabled(true);

        habilitarBotonesMantenimiento(false);
        esNuevo = false;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // Genera codigo automaticos IdCargo es auto_increment
        txtCodigo.setText("");
        txtCodigo.setEnabled(false);

        txtDescripcion.requestFocus();
        habilitarBotonesMantenimiento(false);
        esNuevo = true;
        tblCargo.setRowSelectionAllowed(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed

    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        limpiarCampos();
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtDescripcion.setEnabled(false);

        tblCargo.clearSelection();
        tblCargo.setRowSelectionAllowed(true);

        habilitarBotonesMantenimiento(true);
        esNuevo = false;
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
          try {
                Cargo car = new Cargo();
                int codigo = txtCodigo.getText().isEmpty() ? 0 : Integer.parseInt(txtCodigo.getText());
                car.setIdCargo(codigo);

                
                 String descripcion = txtDescripcion.getText().trim();
                if (descripcion.isEmpty()) {
                    //JOptionPane.showMessageDialog(null, "La descripción es obligatoria.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    Utilitario.MostrarMensaje("La descripción es obligatoria.", Utilitario.TipoMensaje.alerta);
                    txtDescripcion.requestFocus();
                    return;
                }
                car.setDescripcion(descripcion);
                
                //operacion insertar o actualizaqr
                if (esNuevo) {
                        if (DatosCargo.Insertar(car)) {
                            //JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                            Utilitario.MostrarMensaje("Datos guardados correctamente", Utilitario.TipoMensaje.informativo);
                            habilitarBotonesMantenimiento(true);
                            //                DatosCargo.Limpiar(escritorio);
                            //                DatosCargo.Habilitar(escritorio, false);
                            tblCargo.clearSelection();
                            tblCargo.setRowSelectionAllowed(true);
                            Cargar();
                            limpiarCampos();
                        } else {
                        //JOptionPane.showMessageDialog(null, "Error al guardar los datos", "Error", JOptionPane.ERROR_MESSAGE);
                            Utilitario.MostrarMensaje("Error al guardar los datos", Utilitario.TipoMensaje.error);
                        }
                }else{
                    if(DatosCargo.Actualizar(car)) {
                        Utilitario.MostrarMensaje("Datos actualizados correctamente", Utilitario.TipoMensaje.informativo);
                        Cargar();
                        habilitarBotonesMantenimiento(true);

                        tblCargo.clearSelection();
                        tblCargo.setRowSelectionAllowed(true);
                        Cargar();
                        limpiarCampos();
                    }
                }
            } catch (NumberFormatException e) {
                Utilitario.MostrarMensaje("El codigo debe ser un numero", Utilitario.TipoMensaje.error);            
            }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
        if (txtCodigo.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblCargo;
    public static javax.swing.JTextField txtCodigo;
    public static javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void habilitarControles(boolean estado) {
        txtCodigo.setEnabled(false);
        txtDescripcion.setEnabled(estado);
    }

    @Override
    public void habilitarBotonesMantenimiento(boolean estado) {
        btnAgregar.setEnabled(estado);
        btnEditar.setEnabled(estado);
        btnEliminar.setEnabled(estado);
        btnGuardar.setEnabled(!estado);
        btnDeshacer.setEnabled(!estado);
    }
}
