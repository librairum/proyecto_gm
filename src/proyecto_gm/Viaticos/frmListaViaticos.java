package proyecto_gm.Viaticos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.*;

public class frmListaViaticos extends javax.swing.JInternalFrame {

    public frmListaViaticos() {
        initComponents();
        personalizarTabla();
        cargarDatos();
    }

    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) tblViatico.getModel();
        modelo.setRowCount(0);
        DatosViaticos.listar(modelo);
    }

    private void personalizarTabla() {
        JTableHeader header = tblViatico.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                setBackground(Color.DARK_GRAY);
                setForeground(Color.WHITE);
                setFont(getFont().deriveFont(Font.BOLD, 13));
                return this;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViatico = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("VIATICOS");
        setPreferredSize(new java.awt.Dimension(949, 523));

        escritorio.setBackground(new java.awt.Color(255, 248, 239));

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

        tblViatico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCIÓN", "PASAJE", "MENÚ", "EMPLEADO", "PERIODO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblViatico.setFocusable(false);
        tblViatico.setRowHeight(25);
        tblViatico.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblViatico.setShowGrid(true);
        tblViatico.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblViatico);
        if (tblViatico.getColumnModel().getColumnCount() > 0) {
            tblViatico.getColumnModel().getColumn(0).setResizable(false);
            tblViatico.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblViatico.getColumnModel().getColumn(1).setResizable(false);
            tblViatico.getColumnModel().getColumn(1).setPreferredWidth(210);
            tblViatico.getColumnModel().getColumn(2).setResizable(false);
            tblViatico.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblViatico.getColumnModel().getColumn(3).setResizable(false);
            tblViatico.getColumnModel().getColumn(3).setPreferredWidth(40);
            tblViatico.getColumnModel().getColumn(4).setResizable(false);
            tblViatico.getColumnModel().getColumn(4).setPreferredWidth(210);
            tblViatico.getColumnModel().getColumn(5).setResizable(false);
            tblViatico.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNuevo)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEditar)
                        .addComponent(btnEliminar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

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
        int fila = tblViatico.getSelectedRow();
        if (fila >= 0) {
            int id = Integer.parseInt(tblViatico.getValueAt(fila, 0).toString());
            if (DatosViaticos.eliminar(id)) {
                cargarDatos();
                JOptionPane.showMessageDialog(this, "Eliminado correctamente");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblViatico.getSelectedRow();
        if (fila >= 0) {
            Viaticos v = new Viaticos();
            v.setId(Integer.parseInt(tblViatico.getValueAt(fila, 0).toString()));
            v.setDescripcion(tblViatico.getValueAt(fila, 1).toString());
            v.setPasaje(Float.parseFloat(tblViatico.getValueAt(fila, 2).toString()));
            v.setMenu(Float.parseFloat(tblViatico.getValueAt(fila, 3).toString()));
            // Nota: faltaría mapear correctamente Empleado y Periodo por ID real

            frmViaticos frm = new frmViaticos(v, this);
            getDesktopPane().add(frm);
            frm.setVisible(true);
            frm.toFront();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para editar");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        frmViaticos frm = new frmViaticos(null, this);
        getDesktopPane().add(frm);
        frm.setVisible(true);
        frm.toFront();
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel escritorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblViatico;
    // End of variables declaration//GEN-END:variables
}
