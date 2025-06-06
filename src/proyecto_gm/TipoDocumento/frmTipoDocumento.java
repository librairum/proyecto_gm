package proyecto_gm.TipoDocumento;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.Modulo.Modulo;

public class frmTipoDocumento extends javax.swing.JInternalFrame {

    boolean esNuevo = false;

    public frmTipoDocumento() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblTipoDocumento.getModel();
        DatosTipoDocumento.Habilitar(escritorio, false);
        inicializaComboCategoria();

        DatosTipoDocumento.Mostrar(modelo);
        // Quitar la edicion de las celdas
        tblTipoDocumento.setCellSelectionEnabled(false);
        // Poder seleccionar fila(s) de la tabla
        tblTipoDocumento.setRowSelectionAllowed(true);

    }

    private void inicializaComboCategoria() {
        List<Modulo> listaCategoria = DatosTipoDocumento.obtenerModulos(); // o CategoriaDAO si lo separas

        DefaultComboBoxModel<Modulo> modelo = new DefaultComboBoxModel<>();
        for (Modulo c : listaCategoria) {
            modelo.addElement(c);
        }
        cboModulo.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboModulo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoDocumento = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DOCUMENTO");

        escritorio.setBackground(new java.awt.Color(255, 255, 255));
        escritorio.setForeground(new java.awt.Color(255, 255, 255));
        escritorio.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                escritorioComponentMoved(evt);
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

        jLabel1.setText("ID:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel3.setText("Modulo:");

        cboModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboModuloActionPerformed(evt);
            }
        });

        jLabel2.setText("Descripción:");

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        tblTipoDocumento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripción", "Modulo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTipoDocumento);
        if (tblTipoDocumento.getColumnModel().getColumnCount() > 0) {
            tblTipoDocumento.getColumnModel().getColumn(0).setResizable(false);
            tblTipoDocumento.getColumnModel().getColumn(1).setResizable(false);
            tblTipoDocumento.getColumnModel().getColumn(2).setResizable(false);
        }

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAgregar.setName("agregar"); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        escritorio.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnDeshacer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(cboModulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeshacer)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar)
                    .addComponent(btnDeshacer)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        // Agrupar las cajas de texto
        JTextField[] camposTexto = {txtId, txtDescripcion};

        // Agrupar los combo boxes
        JComboBox[] combos = {cboModulo};
        DatosTipoDocumento.Editar(escritorio, tblTipoDocumento, camposTexto, combos);

        esNuevo = false;

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        DatosTipoDocumento.Eliminar(tblTipoDocumento);
        DatosTipoDocumento.Habilitar(escritorio, false);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtId.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completar bien los campos");
            return;
        }

        Modulo modSeleccionado = (Modulo) cboModulo.getSelectedItem();
        if (modSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un módulo válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idTipoDocumento;
        int idModulo;

        try {
            idTipoDocumento = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            txtId.requestFocus();
            return;
        }

        // ✅ CORRECTO: ya es un entero
        idModulo = modSeleccionado.getId();

        // Crea el objeto TipoDocumento
        TipoDocumento tip = new TipoDocumento(idTipoDocumento, String.valueOf(idModulo), txtDescripcion.getText());

        if (esNuevo) {
            if (DatosTipoDocumento.Insertar(tip, tblTipoDocumento)) {
                JOptionPane.showMessageDialog(null, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            DatosTipoDocumento.Actualizar(tip, tblTipoDocumento, cboModulo);
        }

        DatosTipoDocumento.Limpiar(escritorio);
        DatosTipoDocumento.Habilitar(escritorio, false);
        tblTipoDocumento.clearSelection();
        tblTipoDocumento.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // Limpiamos y bloqueamos los campos:
        DatosTipoDocumento.Limpiar(escritorio);
        DatosTipoDocumento.Habilitar(escritorio, false);
        // Limpiamos alguna seleccion previa de alguna fila de la tabla
        tblTipoDocumento.clearSelection();
        // Habilitamos la seleccion de filas de la tabla
        tblTipoDocumento.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void cboModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboModuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboModuloActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:

        if (txtId.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped

    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void escritorioComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_escritorioComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_escritorioComponentMoved

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DatosTipoDocumento.Habilitar(escritorio, true);

        txtId.setEnabled(true);              // Habilitar campo para ingreso manual
        txtId.setText("");                   // Limpiar el campo
        txtDescripcion.setText("");         // Limpiar descripción

        txtId.requestFocus();               // Colocar el foco en el campo ID
        esNuevo = true;
        tblTipoDocumento.setRowSelectionAllowed(false);
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    public static javax.swing.JButton btnDeshacer;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Modulo> cboModulo;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTipoDocumento;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
