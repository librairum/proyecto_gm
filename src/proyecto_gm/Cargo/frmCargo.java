package proyecto_gm.Cargo;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class frmCargo extends javax.swing.JInternalFrame {
    
    DefaultTableModel modelo;
    boolean esNuevo=false;

    public frmCargo() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Descripción");
        this.tblCargo.setModel(modelo);
        
        btnGuardar.setEnabled(false);
        btnDeshacer.setEnabled(false);
        DatosCargo.Bloquear(escritorio);
        
        DatosCargo.Mostrar(modelo);
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
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCargo = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();

        setClosable(true);
        setIconifiable(true);
        setTitle("CARGO");

        escritorio.setBackground(new java.awt.Color(255, 248, 239));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        jLabel2.setText("Descripción:");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        tblCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
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
        tblCargo.setCellSelectionEnabled(true);
        tblCargo.setEnabled(false);
        jScrollPane1.setViewportView(tblCargo);

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(escritorioLayout.createSequentialGroup()
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
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEditar)
                        .addComponent(btnAgregar))
                    .addComponent(btnDeshacer, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        DatosCargo.Eliminar(tblCargo);
        btnGuardar.setEnabled(false);
        btnDeshacer.setEnabled(false);
        txtId.setEditable(false);txtDescripcion.setEditable(false);

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnGuardar.setEnabled(true);btnDeshacer.setEnabled(true);btnEliminar.setEnabled(false);
        btnAgregar.setEnabled(false);
        txtId.setEditable(false);
        txtDescripcion.setEditable(true);

        JTextField [] cod= new JTextField [2];
        cod[0] = txtId;
        cod[1] = txtDescripcion;
        DatosCargo.Editar(tblCargo, cod);
        esNuevo=false;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        btnGuardar.setEnabled(true);btnDeshacer.setEnabled(true);btnEditar.setEnabled(false);btnEliminar.setEnabled(false);
        txtId.setEditable(true);txtDescripcion.setEditable(true);
        esNuevo=true;
        btnAgregar.setEnabled(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // TODO add your handling code here:
        DatosCargo.Limpiar(escritorio);
        btnEditar.setEnabled(true);btnEliminar.setEnabled(true);btnAgregar.setEnabled(true);
        btnGuardar.setEnabled(false);btnDeshacer.setEnabled(false);
        txtId.setEditable(false);txtDescripcion.setEditable(false);
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:z

        Cargo car= new Cargo();
        car.setId(txtId.getText());
        car.setDescripcion(txtDescripcion.getText());
        //verificar si debo ingresar o actualizar
        if (esNuevo) {
            // Insertar nuevo registro
            if (txtId.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Completar bien los campos");
                return;
            } 
            else if(!txtId.getText().matches("^[A-Z]{2}[0-9]{2}$")){
                JOptionPane.showMessageDialog(null, "El formato del Id es el siguente: CR00. Intentelo de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                txtId.requestFocus();
            }
            else {
                DatosCargo.Insertar(car, tblCargo);
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                DatosCargo.Limpiar(escritorio);
                btnEditar.setEnabled(true);btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);btnDeshacer.setEnabled(false);
        txtId.setEditable(false);txtDescripcion.setEditable(false);
        btnAgregar.setEnabled(true);
            }
            
        } else {
            // Actualizar registro existente
            if (txtId.getText().isEmpty() || txtDescripcion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Completar bien los campos");
                return;
            } else {
                DatosCargo.Actualizar(car, tblCargo);
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                DatosCargo.Limpiar(escritorio);
                    btnEditar.setEnabled(true);btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);btnDeshacer.setEnabled(false);
        txtId.setEditable(false);txtDescripcion.setEditable(false);
        btnAgregar.setEnabled(true);
            }
  
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCargo;
    public static javax.swing.JTextField txtDescripcion;
    public static javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
