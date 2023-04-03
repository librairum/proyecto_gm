package proyecto_gm.CabeceraComprobante;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class frmCabeceraComprobante extends javax.swing.JInternalFrame {
    boolean esNuevo=false;

    
    public frmCabeceraComprobante() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblCabezera.getModel();
       
        DatosCabeceraComprobante.Mostrar(modelo);
        DatosCabeceraComprobante.CargarCombo(cboProveedores, cboTipoDocumento);
        
        DatosCabeceraComprobante.Habilitar(escritorio, false);
        // Quitar la edicion de las celdas
        tblCabezera.setCellSelectionEnabled(false);
        // Poder seleccionar fila(s) de la tabla
        tblCabezera.setRowSelectionAllowed(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/iconos/fondo.jpg"));
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroFactura = new javax.swing.JTextField();
        txtFechaEmision = new javax.swing.JTextField();
        txtFechaVencimiento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCabezera = new javax.swing.JTable();
        btnIngrearDetalle = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        cboProveedores = new javax.swing.JComboBox<>();
        cboTipoDocumento = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("CABECERA DE COMPROBANTE");

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

        jLabel1.setText("Numero de Comprobante:");

        jLabel2.setText("Fecha de Emision:");

        jLabel3.setText("Fecha de Vencimiento:");

        txtNumeroFactura.setNextFocusableComponent(txtFechaEmision);

        txtFechaEmision.setNextFocusableComponent(txtFechaVencimiento);
        txtFechaEmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaEmisionKeyTyped(evt);
            }
        });

        txtFechaVencimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaVencimientoKeyTyped(evt);
            }
        });

        tblCabezera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Comprobante", "Fecha de Emision", "Fecha de Vencimiento", "Total", "Proveedores", "Tipo de Documento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCabezera);
        if (tblCabezera.getColumnModel().getColumnCount() > 0) {
            tblCabezera.getColumnModel().getColumn(0).setResizable(false);
            tblCabezera.getColumnModel().getColumn(1).setResizable(false);
            tblCabezera.getColumnModel().getColumn(2).setResizable(false);
            tblCabezera.getColumnModel().getColumn(3).setResizable(false);
            tblCabezera.getColumnModel().getColumn(4).setResizable(false);
            tblCabezera.getColumnModel().getColumn(5).setResizable(false);
        }

        btnIngrearDetalle.setText("Ingresar Detalle");
        btnIngrearDetalle.setName("ingresar"); // NOI18N
        btnIngrearDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngrearDetalleActionPerformed(evt);
            }
        });

        jLabel4.setText("Total:");

        jLabel5.setText("Proveedores:");

        jLabel6.setText("Tipo de Documento");

        cboTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoDocumentoActionPerformed(evt);
            }
        });

        escritorio.setLayer(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnDeshacer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtNumeroFactura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtFechaEmision, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtFechaVencimiento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnIngrearDetalle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(cboProveedores, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(cboTipoDocumento, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeshacer))
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, escritorioLayout.createSequentialGroup()
                            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(escritorioLayout.createSequentialGroup()
                                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(cboProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(escritorioLayout.createSequentialGroup()
                                            .addGap(64, 64, 64)
                                            .addComponent(btnIngrearDetalle)
                                            .addGap(62, 62, 62)
                                            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(escritorioLayout.createSequentialGroup()
                                                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel6))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(escritorioLayout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addGap(0, 0, Short.MAX_VALUE))))))
                                .addGroup(escritorioLayout.createSequentialGroup()
                                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar)
                    .addComponent(btnDeshacer, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngrearDetalle)
                    .addComponent(jLabel6)
                    .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
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
        DatosCabeceraComprobante.Habilitar(escritorio, true);
        txtNumeroFactura.requestFocus();
        esNuevo=true;
        tblCabezera.setRowSelectionAllowed(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        // Agrupar las cajas de texto
        JTextField[] camposTexto = {txtNumeroFactura, txtFechaEmision, txtFechaVencimiento, txtTotal};
        // Agrupar los combo boxes
        JComboBox[] combos = {cboProveedores, cboTipoDocumento};
        
        DatosCabeceraComprobante.Editar(escritorio, tblCabezera, camposTexto, combos);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        DatosCabeceraComprobante.Eliminar(tblCabezera);
        DatosCabeceraComprobante.Habilitar(escritorio, false);
        //DatosCabeceraComprobante.Bloquear(escritorio);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String [] opciones= DatosCabeceraComprobante.Capturar(cboProveedores, cboTipoDocumento);
        // Creamos un objeto tipo Empleado
        CabeceraComprobante cab = new CabeceraComprobante 
        (txtNumeroFactura.getText(),
        txtFechaEmision.getText(), txtFechaVencimiento.getText(), Float.parseFloat(txtTotal.getText()), 
                opciones[0],
        opciones [1]);
        // Preguntamos si haremos un INSERT o un UPDATE
        
         if (esNuevo) {
            // Insertar nuevo registro
            if (DatosCabeceraComprobante.ValidarCampos(cab)) {
                    DatosCabeceraComprobante.Insertar(cab, tblCabezera);
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    DatosCabeceraComprobante.Limpiar(escritorio);
                    DatosCabeceraComprobante.Habilitar(escritorio, false);
                    
                    tblCabezera.clearSelection();
                    // Habilitamos la seleccion de filas de la tabla
                    tblCabezera.setRowSelectionAllowed(true);
                } else 
            {
                if(DatosCabeceraComprobante.ValidarCampos(cab)){
                    DatosCabeceraComprobante.Actualizar(cab, tblCabezera);
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                    DatosCabeceraComprobante.Limpiar(escritorio);
                    DatosCabeceraComprobante.Habilitar(escritorio, false);
                    
                    tblCabezera.clearSelection();
                    // Habilitamos la seleccion de filas de la tabla
                    tblCabezera.setRowSelectionAllowed(true);
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // TODO add your handling code here:
        DatosCabeceraComprobante.Limpiar(escritorio);
        DatosCabeceraComprobante.Habilitar(escritorio, false);
        tblCabezera.clearSelection();
        // Habilitamos la seleccion de filas de la tabla
        tblCabezera.setRowSelectionAllowed(true);
        
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void cboTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoDocumentoActionPerformed

    private void txtFechaEmisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaEmisionKeyTyped
        // TODO add your handling code here:
        if (txtFechaEmision.getText().length() >= 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtFechaEmisionKeyTyped

    private void txtFechaVencimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaVencimientoKeyTyped
        // TODO add your handling code here:
        if (txtFechaVencimiento.getText().length() >= 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtFechaVencimientoKeyTyped

    private void btnIngrearDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngrearDetalleActionPerformed
        // TODO add your handling code here:{
            frmDetalleComprobante verventana = new frmDetalleComprobante();
            escritorio.add(verventana);
            verventana.setVisible(true);

            // Limpiamos alguna seleccion previa de alguna fila de la tabla
            tblCabezera.clearSelection();

    }//GEN-LAST:event_btnIngrearDetalleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIngrearDetalle;
    private javax.swing.JComboBox<String> cboProveedores;
    private javax.swing.JComboBox<String> cboTipoDocumento;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCabezera;
    private javax.swing.JTextField txtFechaEmision;
    private javax.swing.JTextField txtFechaVencimiento;
    private javax.swing.JTextField txtNumeroFactura;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
