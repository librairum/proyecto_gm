package proyecto_gm.Cuentas;

//import java.awt.Color;

import javax.swing.AbstractButton;

//import java.awt.Component;
//import java.awt.Font;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;
//import proyecto_gm.Cuentas.Banco;

public class frmListaCuentas extends javax.swing.JInternalFrame {

    private AbstractButton rbSoles;
    private AbstractButton rbDolares;

//    boolean esNuevo = false;
//
//    public frmListaCuentas() {
//        initComponents();
//
//        // Personalizar header de la tabla
//        JTableHeader header = tblCuentas.getTableHeader();
//        header.setDefaultRenderer(new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table,
//                    Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                setHorizontalAlignment(JLabel.CENTER);
//                setBackground(Color.DARK_GRAY);
//                setForeground(Color.WHITE);
//                setFont(getFont().deriveFont(Font.BOLD, 13));
//                return this;
//            }
//        });
//
//        DefaultTableModel modelo = (DefaultTableModel) tblCuentas.getModel();
//        DatosCuentas.Listar(modelo);
//        DatosCuentas.Habilitar(panel, monedas, false);
//
//        // Cargar datos en ComboBoxes
//        DatosCuentas.CargarTipoPropietario(cboTipoPropietario); // datos locales
//        DatosCuentas.CargarBancos(cboBanco); // datos desde BD
//
//        rbSoles.setSelected(true);
//
//        tblCuentas.setCellSelectionEnabled(false);
//        tblCuentas.setRowSelectionAllowed(true);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monedas = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuentas = new javax.swing.JTable();

        monedas.add(rbSoles);
        monedas.add(rbDolares);

        setClosable(true);
        setIconifiable(true);
        setTitle("CUENTAS BANCARIAS");

        panel.setBackground(new java.awt.Color(255, 248, 239));

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
        tblCuentas.setShowGrid(true);
        tblCuentas.getTableHeader().setReorderingAllowed(false);
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
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
//        tblCuentas.clearSelection();
//        tblCuentas.setRowSelectionAllowed(false);
//        DatosCuentas.Habilitar(panel, monedas, true);
//        String codigo = DatosCuentas.GenerarCodigo();
//        txtId.setText(codigo);
//        txtId.setEnabled(false);
//        cboTipoPropietario.requestFocus();
//        esNuevo = true; // Indicamos que sera un nuevo registro
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//        JTextField[] cajas = {txtId, txtNombres, txtCCC, txtCCI};
//        JComboBox[] combos = {cboTipoPropietario, cboBanco};
//        DatosCuentas.Editar(panel, tblCuentas, cajas, combos, monedas);
//        esNuevo = false; // Indicamos que no sera un nuevo registro
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DatosCuentas.Eliminar(tblCuentas);
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup monedas;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tblCuentas;
    // End of variables declaration//GEN-END:variables
}
