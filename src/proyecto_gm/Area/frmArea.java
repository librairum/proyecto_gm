package proyecto_gm.Area;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class frmArea extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    boolean esNuevo=false;
  
    public frmArea() {
        initComponents();
   
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCION");
        this.tblArea.setModel(modelo);
        
        
        btnGuardar.setEnabled(false);
        btnDeshacer.setEnabled(false);
        DatosArea.Bloquear(rootPane);
        
        DatosArea.Mostrar(modelo);
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        escritorio = new javax.swing.JDesktopPane();
        btnAgregar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();

        setClosable(true);
        setIconifiable(true);
        setTitle("AREA");

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
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

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel2.setText("Descripción:");

        tblArea.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblArea);
        if (tblArea.getColumnModel().getColumnCount() > 0) {
            tblArea.getColumnModel().getColumn(0).setResizable(false);
            tblArea.getColumnModel().getColumn(1).setResizable(false);
        }

        escritorio.setLayer(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnDeshacer, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(txtDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeshacer))
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion)
                        .addGap(6, 6, 6))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar)
                    .addComponent(btnDeshacer))
                .addGap(11, 11, 11)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPane1.setLayer(escritorio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // TODO add your handling code here:
        DatosArea.Limpiar(rootPane);
        btnEditar.setEnabled(true);btnEliminar.setEnabled(true);btnAgregar.setEnabled(true);
        btnGuardar.setEnabled(false);btnDeshacer.setEnabled(false);
        txtId.setEditable(false);txtDescripcion.setEditable(false);
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        btnEditar.setEnabled(true);btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);btnDeshacer.setEnabled(false);
        txtId.setEditable(false);txtDescripcion.setEditable(false);

        Area are= new Area();
        are.setId(txtId.getText());
        are.setDescripcion(txtDescripcion.getText());
        //verificar si debo ingresar o actualizar
        if (esNuevo) {
            // Insertar nuevo registro
            if (txtId.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Completar bien los campos");
                    return;
                } else {
                    DatosArea.Insertar(are, tblArea);
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                }
        } else {
            // Actualizar registro existente
            if (txtId.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Completar bien los campos");
                    return;
                } else {
                    DatosArea.Actualizar(are, tblArea);
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
        }
        modelo.setRowCount(0);
        DatosArea.Mostrar(modelo);
        DatosArea.Limpiar(rootPane);

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        DatosArea.Eliminar(tblArea);
        btnGuardar.setEnabled(false);
        btnDeshacer.setEnabled(false);
        txtId.setEditable(false);txtDescripcion.setEditable(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        btnGuardar.setEnabled(true);btnDeshacer.setEnabled(true);btnEliminar.setEnabled(false);
        txtId.setEditable(false);
        txtDescripcion.setEditable(true);

        JTextField [] cod= new JTextField [2];
        cod[0] = txtId;
        cod[1] = txtDescripcion;
        DatosArea.Editar(tblArea, cod);
        esNuevo=false;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        btnGuardar.setEnabled(true);btnDeshacer.setEnabled(true);btnEditar.setEnabled(false);btnEliminar.setEnabled(false);
        txtId.setEditable(true);txtDescripcion.setEditable(true);
        esNuevo=true;
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        if (txtId.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtIdKeyTyped
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArea;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
