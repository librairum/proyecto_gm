
package proyecto_gm.CabeceraComprobante;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmListarCabecera extends javax.swing.JInternalFrame {

   // Variable para gestionar el formulario de agregar/editar
    frmCabecera frmAgregar;
    
    public frmListarCabecera() {
        initComponents();
        refrescarTabla();

        tblCabecera.setCellSelectionEnabled(false);
        tblCabecera.setRowSelectionAllowed(true);
    }
    
    public void refrescarTabla()  {
    DefaultTableModel modelo = (DefaultTableModel) tblCabecera.getModel();
    modelo.setRowCount(0); 
    DatosCabeceraComprobante.Listar(modelo); 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCabecera = new javax.swing.JTable();

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

        tblCabecera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Comprobante", "Fecha de Emision", "Fecha de Vencimiento", "Sub Total", "Igv", "Total", "Proveedores", "Tipo de Documento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCabecera);

        escritorio.setLayer(btnAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        JDesktopPane desktopPane = getDesktopPane();

    if (frmAgregar == null || frmAgregar.isClosed()) {
        frmAgregar = new frmCabecera(this, true, null, tblCabecera); 
        desktopPane.add(frmAgregar);
        frmAgregar.setVisible(true);
    } else {
        frmAgregar.toFront();
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int filaSeleccionada = tblCabecera.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    CabeceraComprobante cabeceraAEditar = new CabeceraComprobante();
    DefaultTableModel modelo = (DefaultTableModel) tblCabecera.getModel();

    cabeceraAEditar.setNumeroComprobante(modelo.getValueAt(filaSeleccionada, 0).toString());
    cabeceraAEditar.setFechaEmision(modelo.getValueAt(filaSeleccionada, 1).toString());
    cabeceraAEditar.setFechaVencimiento(modelo.getValueAt(filaSeleccionada, 2).toString());
    cabeceraAEditar.setSubTotal(Float.parseFloat(modelo.getValueAt(filaSeleccionada, 3).toString()));
    cabeceraAEditar.setIgv(Float.parseFloat(modelo.getValueAt(filaSeleccionada, 4).toString()));
    cabeceraAEditar.setTotal(Float.parseFloat(modelo.getValueAt(filaSeleccionada, 5).toString()));
    cabeceraAEditar.setIdProveedores(modelo.getValueAt(filaSeleccionada, 6).toString()); 
    cabeceraAEditar.setIdTipoDocumento(modelo.getValueAt(filaSeleccionada, 7).toString());

    JDesktopPane desktopPane = getDesktopPane();

    if (frmAgregar == null || frmAgregar.isClosed()) {
        frmAgregar = new frmCabecera(this, false, cabeceraAEditar, tblCabecera);
        desktopPane.add(frmAgregar);
        frmAgregar.setVisible(true);
    } else {
        frmAgregar.toFront();
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DatosCabeceraComprobante.Eliminar(tblCabecera);
        refrescarTabla(); 
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCabecera;
    // End of variables declaration//GEN-END:variables
}
