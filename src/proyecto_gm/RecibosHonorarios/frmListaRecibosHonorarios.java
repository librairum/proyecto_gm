package proyecto_gm.RecibosHonorarios;

import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class frmListaRecibosHonorarios extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;

    public frmListaRecibosHonorarios() {
        initComponents();
        mostrarDatos();
    }
    
    public JTable getTabla() {
        return tblHonorarios;
    }
    
    // Método para listar los datos en la tabla
    void mostrarDatos() {
        String[] titulos = {
            "ID", "Nro Recibo", "RUC", "Nombres", "Apellidos", "Distrito", 
            "Dirección", "Forma Pago", "Concepto", "Imp. Neto", "Retención IR", 
            "Imp. Total", "Fec. Emisión"
        };

        modelo = new DefaultTableModel(null, titulos);
        tblHonorarios.setModel(modelo);
        DatosRecibosHonorarios.Mostrar(modelo);
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHonorarios = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("RECIBOS POR HONORARIOS");
        setToolTipText(null);

        escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        escritorio.setFocusCycleRoot(true);

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

        tblHonorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NRO. RECIBO", "RUC", "NOMBRES", "APELLIDOS", "DISTRITO", "DIRECCIÓN", "F. PAGO", "CONCEPTO", "IMP. NETO", "RETENCIÓN IR", "IMP. TOTAL", "FEC. EMISIÓN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHonorarios.setFocusable(false);
        tblHonorarios.setRowHeight(25);
        tblHonorarios.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblHonorarios.setShowGrid(true);
        tblHonorarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblHonorarios);
        if (tblHonorarios.getColumnModel().getColumnCount() > 0) {
            tblHonorarios.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1216, Short.MAX_VALUE)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        frmRecibosHonorarios frm = new frmRecibosHonorarios(this); 
        this.getDesktopPane().add(frm);
        frm.setVisible(true);
        frm.toFront();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblHonorarios.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un recibo.");
            return;
        }

        try {
            // Obtener la fecha directamente como Date desde la tabla
            Date fecha = (Date) modelo.getValueAt(fila, 12);

            // Crear objeto con datos de la fila seleccionada
            ReciboHonorario rh = new ReciboHonorario(
                String.valueOf(modelo.getValueAt(fila, 0)),
                modelo.getValueAt(fila, 1).toString(),
                modelo.getValueAt(fila, 2).toString(),
                modelo.getValueAt(fila, 3).toString(),
                modelo.getValueAt(fila, 4).toString(),
                modelo.getValueAt(fila, 5).toString(),
                modelo.getValueAt(fila, 6).toString(),
                modelo.getValueAt(fila, 7).toString(),
                modelo.getValueAt(fila, 8).toString(),
                fecha, // fecha como Date
                Float.parseFloat(modelo.getValueAt(fila, 9).toString()),
                Float.parseFloat(modelo.getValueAt(fila, 10).toString()),
                Float.parseFloat(modelo.getValueAt(fila, 11).toString())
            );

            // Abrir formulario de edición pasando la referencia del listado
            frmRecibosHonorarios frm = new frmRecibosHonorarios(this, rh);
            this.getDesktopPane().add(frm);
            frm.setVisible(true);
            frm.toFront();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al obtener la fecha: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DatosRecibosHonorarios.Eliminar(tblHonorarios);      
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JPanel escritorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHonorarios;
    // End of variables declaration//GEN-END:variables
}
