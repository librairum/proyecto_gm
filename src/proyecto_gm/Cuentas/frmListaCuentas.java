package proyecto_gm.Cuentas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmListaCuentas extends javax.swing.JInternalFrame {

    public frmListaCuentas() {
        initComponents();
        cargarDatosTabla();
    }

    // Método público para que otros formularios puedan refrescar la tabla
    public void cargarDatosTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblCuentas.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        try {
            List<Cuentas> lista = DatosCuentas.listar();
            for (Cuentas cuenta : lista) {
                String tipoPropietarioTexto = "P".equalsIgnoreCase(cuenta.getTipoPropietario()) ? "Persona Natural" : "Empresa";
                String tipoMonedaTexto = "S".equalsIgnoreCase(cuenta.getTipoMoneda()) ? "Soles" : "Dólares";

                modelo.addRow(new Object[]{
                    cuenta.getIdCuenta(),
                    tipoPropietarioTexto,
                    cuenta.getNombres(),
                    cuenta.getNombreBanco(),
                    cuenta.getNroCuenta(),
                    cuenta.getNroCuentaInterbancaria(),
                    tipoMonedaTexto
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        panel = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuentas = new javax.swing.JTable();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

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
                    .addComponent(jScrollPane1)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addContainerGap(720, Short.MAX_VALUE))))
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
        frmCuentas frm = new frmCuentas(null, this); 
        
        getParent().add(frm);
        frm.setLocation(
           (this.getParent().getWidth() - frm.getWidth()) / 2,
           (this.getParent().getHeight() - frm.getHeight()) / 2
        );
        frm.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    int filaSeleccionada = tblCuentas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        Cuentas cuenta = new Cuentas();
        DefaultTableModel modelo = (DefaultTableModel) tblCuentas.getModel();
        
        cuenta.setIdCuenta((Integer) modelo.getValueAt(filaSeleccionada, 0));

        frmCuentas frm = new frmCuentas(cuenta, this);
        getParent().add(frm);
         frm.setLocation(
           (this.getParent().getWidth() - frm.getWidth()) / 2,
           (this.getParent().getHeight() - frm.getHeight()) / 2
        );
        frm.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int filaSeleccionada = tblCuentas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta cuenta?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                int idCuenta = (int) tblCuentas.getValueAt(filaSeleccionada, 0);
                DatosCuentas.eliminar(idCuenta);
                JOptionPane.showMessageDialog(this, "Cuenta eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarDatosTabla(); // Recargar la tabla
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar la cuenta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tblCuentas;
    // End of variables declaration//GEN-END:variables
}
