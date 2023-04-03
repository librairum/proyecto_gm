
package proyecto_gm.CabeceraComprobante;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class frmDetalleComprobante extends javax.swing.JInternalFrame {
    boolean esNuevo=false;
    
    public frmDetalleComprobante() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
        DatosDetalleComprobante.Mostrar(modelo);
        DatosDetalleComprobante.CargarCombo(cboNumeroComprobante);
        //DatosDetalleComprobante.Bloquear(escritorio);
        DatosDetalleComprobante.Habilitar(escritorio, false);
        
        // Quitar la edicion de las celdas
        tblDetalle.setCellSelectionEnabled(false);
        // Poder seleccionar fila(s) de la tabla
        tblDetalle.setRowSelectionAllowed(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioUnitario = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        cboNumeroComprobante = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("DETALLE COMPROBANTE");

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

        jLabel5.setText("Precio Unitario");

        jLabel1.setText("Id:");

        jLabel4.setText("Cantidad");

        jLabel6.setText("Sub Total:");

        jLabel3.setText("Numero de Comprobante");

        jLabel2.setText("Descripcion:");

        jLabel7.setText("Igv");

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cantidad", "Descripcion", "Precio Unitario", "Sub Total", "Igv", "Num. de Compro."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDetalle);
        if (tblDetalle.getColumnModel().getColumnCount() > 0) {
            tblDetalle.getColumnModel().getColumn(0).setResizable(false);
            tblDetalle.getColumnModel().getColumn(1).setResizable(false);
            tblDetalle.getColumnModel().getColumn(2).setResizable(false);
            tblDetalle.getColumnModel().getColumn(3).setResizable(false);
            tblDetalle.getColumnModel().getColumn(4).setResizable(false);
            tblDetalle.getColumnModel().getColumn(5).setResizable(false);
            tblDetalle.getColumnModel().getColumn(6).setResizable(false);
        }

        escritorio.setLayer(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnDeshacer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtPrecioUnitario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtSubTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtIgv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(cboNumeroComprobante, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(escritorioLayout.createSequentialGroup()
                                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                            .addComponent(txtId)))
                                    .addGroup(escritorioLayout.createSequentialGroup()
                                        .addComponent(btnAgregar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEditar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGuardar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDeshacer)))
                                .addGap(27, 27, 27)
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(escritorioLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(escritorioLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel3)
                                .addGap(59, 59, 59)
                                .addComponent(cboNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIgv)
                            .addComponent(txtSubTotal))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar)
                    .addComponent(btnDeshacer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        DatosDetalleComprobante.Habilitar(escritorio, true);
        txtId.requestFocus(); // Colocamos el cursor en txtId
        esNuevo=true;
        tblDetalle.setRowSelectionAllowed(false);
        //btnAgregar.setEnabled(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        // Agrupar las cajas de texto
        JTextField[] camposTexto = {txtId, txtCantidad, txtDescripcion, txtPrecioUnitario, 
            txtSubTotal, txtIgv};

        // Agrupar los combo boxes y cargar el radio button correspondiente
        // que esta en el button group
        JComboBox[] combos = {cboNumeroComprobante};
        DatosDetalleComprobante.Editar(escritorio, tblDetalle, camposTexto, combos);
        
        esNuevo = false;
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        DatosDetalleComprobante.Eliminar(tblDetalle);
        DatosDetalleComprobante.Habilitar(escritorio, false);
        // Bloqueamos los siguientes botones:
//        btnGuardar.setEnabled(false); btnDeshacer.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String opcion= DatosDetalleComprobante.Capturar(cboNumeroComprobante);
        // Creamos un objeto tipo Empleado
        DetalleComprobante det = new DetalleComprobante (txtId.getText(),  
                txtCantidad.getText(),txtDescripcion.getText(),
                Float.parseFloat(txtPrecioUnitario.getText()), 
                Float.parseFloat(txtSubTotal.getText()), Float.parseFloat(txtIgv.getText()), opcion);

         //Preguntamos si haremos un INSERT o un UPDATE
         if (esNuevo) {
            // Insertar nuevo registro
            if (txtId.getText().isEmpty() || txtCantidad.getText().isEmpty() || txtDescripcion.getText().isEmpty()
                    || txtPrecioUnitario.getText().isEmpty()|| txtSubTotal.getText().isEmpty()
                    || txtIgv.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Completar bien los campos");
                    return;
                } 
            else if(!txtId.getText().matches("^[A-Z]{2}[0-9]{2}$")){
                JOptionPane.showMessageDialog(null, "El formato del Id es el siguente: DC00. Intentelo de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                txtId.requestFocus();
            } else {
                    DatosDetalleComprobante.Insertar(det, tblDetalle);
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    DatosDetalleComprobante.Limpiar(escritorio);
                    DatosDetalleComprobante.Habilitar(escritorio, false);

                    
                    tblDetalle.clearSelection();
                    // Habilitamos la seleccion de filas de la tabla
                    tblDetalle.setRowSelectionAllowed(true);
     
        }
           } else {
            // Actualizar registro existente
            if (txtId.getText().isEmpty() || txtDescripcion.getText().isEmpty()|| txtCantidad.getText().isEmpty()
                    || txtPrecioUnitario.getText().isEmpty()|| txtSubTotal.getText().isEmpty()
                    || txtIgv.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Completar bien los campos");
                    return;
                } else {
                    DatosDetalleComprobante.Actualizar(det, tblDetalle);
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    DatosDetalleComprobante.Limpiar(escritorio);
                    DatosDetalleComprobante.Habilitar(escritorio, false);

                    // Limpiamos alguna seleccion previa de alguna fila de la tabla
                    tblDetalle.clearSelection();
                    // Habilitamos la seleccion de filas de la tabla
                    tblDetalle.setRowSelectionAllowed(true);
            }
        
         }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        DatosDetalleComprobante.Limpiar(escritorio);
//        DatosDetalleComprobante.Bloquear(escritorio);   
        DatosDetalleComprobante.Habilitar(escritorio, false);
        // Limpiamos alguna seleccion previa de alguna fila de la tabla
        tblDetalle.clearSelection();
        // Habilitamos la seleccion de filas de la tabla
        tblDetalle.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnDeshacerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboNumeroComprobante;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
