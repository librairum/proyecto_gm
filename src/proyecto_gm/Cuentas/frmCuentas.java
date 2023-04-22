/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyecto_gm.Cuentas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author jeanv
 */
public class frmCuentas extends javax.swing.JInternalFrame {

    boolean esNuevo = false;

    /**
     * Creates new form frmCuentas
     */
    public frmCuentas() {
        initComponents();
        // Personalizar header
        JTableHeader header = tblCuentas.getTableHeader();
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

        DefaultTableModel modelo = (DefaultTableModel) tblCuentas.getModel();
        DatosCuentas.Listar(modelo);
        DatosCuentas.Habilitar(panel, monedas, false);
        DatosCuentas.CargarBancos(cboBanco);
        rbSoles.setSelected(true);

        // Quitar la edicion de las celdas
        tblCuentas.setCellSelectionEnabled(false);
        // Poder seleccionar fila(s) de la tabla
        tblCuentas.setRowSelectionAllowed(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monedas = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboTipoPropietario = new javax.swing.JComboBox<>();
        cboBanco = new javax.swing.JComboBox<>();
        rbSoles = new javax.swing.JRadioButton();
        rbDolares = new javax.swing.JRadioButton();
        txtId = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtCCI = new javax.swing.JTextField();
        txtCCC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuentas = new javax.swing.JTable();

        monedas.add(rbSoles);
        monedas.add(rbDolares);

        setClosable(true);
        setIconifiable(true);
        setTitle("CUENTAS BANCARIAS");

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnNuevo.setName("nuevo"); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
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

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnCancelar.setName("cancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Tipo Propietario:");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Banco:");

        jLabel5.setText("Nro. Cuenta:");

        jLabel6.setText("Moneda:");

        jLabel7.setText("Nro. Cuenta Interbancaria:");

        cboTipoPropietario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Persona Natural", "Empresa" }));
        cboTipoPropietario.setFocusCycleRoot(true);
        cboTipoPropietario.setNextFocusableComponent(txtNombres);

        cboBanco.setNextFocusableComponent(txtCCC);

        rbSoles.setText("Soles");
        rbSoles.setNextFocusableComponent(btnGuardar);
        rbSoles.setActionCommand("Soles");

        rbDolares.setText("Dólares");
        rbDolares.setNextFocusableComponent(btnGuardar);
        rbDolares.setActionCommand("Dólares");

        txtNombres.setNextFocusableComponent(cboBanco);
        txtNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombresFocusLost(evt);
            }
        });

        txtCCI.setNextFocusableComponent(panel);
        txtCCI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCCIFocusLost(evt);
            }
        });
        txtCCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCCIKeyTyped(evt);
            }
        });

        txtCCC.setNextFocusableComponent(txtCCI);
        txtCCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCCCFocusLost(evt);
            }
        });
        txtCCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCCCKeyTyped(evt);
            }
        });

        tblCuentas.setBackground(new java.awt.Color(255, 255, 255));
        tblCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TIP. PROPIETARIO", "NOMBRES", "BANCO", "CCC", "CCI", "MONEDA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCuentas.setFocusable(false);
        tblCuentas.setRowHeight(25);
        tblCuentas.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblCuentas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblCuentas.setShowGrid(true);
        jScrollPane1.setViewportView(tblCuentas);
        if (tblCuentas.getColumnModel().getColumnCount() > 0) {
            tblCuentas.getColumnModel().getColumn(0).setResizable(false);
            tblCuentas.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblCuentas.getColumnModel().getColumn(1).setResizable(false);
            tblCuentas.getColumnModel().getColumn(2).setResizable(false);
            tblCuentas.getColumnModel().getColumn(2).setPreferredWidth(180);
            tblCuentas.getColumnModel().getColumn(3).setResizable(false);
            tblCuentas.getColumnModel().getColumn(4).setResizable(false);
            tblCuentas.getColumnModel().getColumn(5).setResizable(false);
            tblCuentas.getColumnModel().getColumn(5).setPreferredWidth(120);
            tblCuentas.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboTipoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbSoles)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbDolares))
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCCI, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCCC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addGap(25, 25, 25))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar))
                .addGap(27, 27, 27)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboTipoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rbSoles)
                            .addComponent(rbDolares))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tblCuentas.clearSelection();
        tblCuentas.setRowSelectionAllowed(false);
        DatosCuentas.Habilitar(panel, monedas, true);
        String codigo = DatosCuentas.GenerarCodigo("cuentasbancarias", "CB", 7);
        txtId.setText(codigo);
        txtId.setEnabled(false);
        cboTipoPropietario.requestFocus();
        esNuevo = true; // Indicamos que sera un nuevo registro
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        JTextField[] cajas = {txtId, txtNombres, txtCCC, txtCCI};
        JComboBox[] combos = {cboTipoPropietario, cboBanco};
        DatosCuentas.Editar(panel, tblCuentas, cajas, combos, monedas);
        esNuevo = false; // Indicamos que no sera un nuevo registro
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DatosCuentas.Eliminar(tblCuentas);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Cuentas cuenta = new Cuentas();
        cuenta.setId(txtId.getText());
        cuenta.setTipoPropietario(cboTipoPropietario.getSelectedItem().toString().substring(0, 1));
        cuenta.setNombres(txtNombres.getText());
        cuenta.setIdBanco(cboBanco.getSelectedIndex() + 1);
        cuenta.setNroCuenta(txtCCC.getText());
        cuenta.setNroCuentaInterbancaria(txtCCI.getText());
        cuenta.setTipoMoneda(monedas.getSelection().getActionCommand().substring(0, 1));

        JTextField[] campos = {txtNombres, txtCCC, txtCCI};
        if (!DatosCuentas.Validar(campos)) {
            return;
        }
        
        if (esNuevo) {
            DatosCuentas.Insertar(cuenta, tblCuentas);
        } else {
            DatosCuentas.Actualizar(cuenta, tblCuentas);
        }

        DatosCuentas.Limpiar(panel);
        DatosCuentas.Habilitar(panel, monedas, false);
        tblCuentas.clearSelection();
        tblCuentas.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        DatosCuentas.Limpiar(panel);
        DatosCuentas.Habilitar(panel, monedas, false);
        tblCuentas.clearSelection();
        tblCuentas.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCCCKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();// Si no es un número, se ignora el evento de tecla
        }
        if (txtCCC.getText().length() >= 14) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCCCKeyTyped

    private void txtCCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCCIKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();// Si no es un número, se ignora el evento de tecla
        }
        if (txtCCI.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCCIKeyTyped

    private void txtNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusLost
        String texto = txtNombres.getText().trim();
        txtNombres.setText(texto);
    }//GEN-LAST:event_txtNombresFocusLost

    private void txtCCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCCCFocusLost
        String texto = txtCCC.getText().trim();
        txtCCC.setText(texto);
    }//GEN-LAST:event_txtCCCFocusLost

    private void txtCCIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCCIFocusLost
        String texto = txtCCI.getText().trim();
        txtCCI.setText(texto);
    }//GEN-LAST:event_txtCCIFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboBanco;
    private javax.swing.JComboBox<String> cboTipoPropietario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup monedas;
    private javax.swing.JPanel panel;
    private javax.swing.JRadioButton rbDolares;
    private javax.swing.JRadioButton rbSoles;
    private javax.swing.JTable tblCuentas;
    private javax.swing.JTextField txtCCC;
    private javax.swing.JTextField txtCCI;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
