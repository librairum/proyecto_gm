package proyecto_gm.Facultades;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static proyecto_gm.Cargo.frmCargo.tblCargo;
import proyecto_gm.Exportar;

public class frmFacultades extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    boolean esNuevo = false;
    List<Facultades> listaFacultades; 
    private javax.swing.table.TableRowSorter<DefaultTableModel> sorter;

    public frmFacultades() {
        initComponents();
        
        // Configuración inicial de la tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCIÓN");
        tblFacultades.setModel(modelo);
        
        cargarDatos();
        gestionarControles(false); 
        
                // Inicializar filtro
        DefaultTableModel modelo = (DefaultTableModel) tblFacultades.getModel();
        sorter = new javax.swing.table.TableRowSorter<>(modelo);
        tblFacultades.setRowSorter(sorter);

        // Buscar al presionar Enter
        txtBusqueda.addActionListener(e -> filtrarFacultades(txtBusqueda.getText().trim()));
    }
    
    private void cargarDatos() {
        modelo.setRowCount(0);
        listaFacultades = DatosFacultades.listar();
        for (Facultades facultad : listaFacultades) {
            modelo.addRow(new Object[]{facultad.getId(), facultad.getDescripcion()});
        }
    }
    
    private void gestionarControles(boolean activo) {
        txtId.setEnabled(false);
        txtDescripcion.setEnabled(activo);
        
        btnGuardar.setEnabled(activo);
        btnDeshacer.setEnabled(activo);
        
        btnNuevo.setEnabled(!activo);
        btnEditar.setEnabled(!activo);
        btnEliminar.setEnabled(!activo);
    }
    
    private void limpiarCampos() {
        txtId.setText("");
        txtDescripcion.setText("");
    }
    
    private void filtrarFacultades(String texto) {
        try {
            if (texto.isEmpty()) {
                sorter.setRowFilter(null);
            } else {
                // Busca en la columna 1 (Descripción)
                sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i).*" + java.util.regex.Pattern.quote(texto) + ".*", 1));
            }
        } catch (java.util.regex.PatternSyntaxException ex) {
            System.err.println("Error en el filtro: " + ex.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFacultades = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("FACULTADES");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 248, 239));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
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

        jLabel2.setText("Descripcion:");

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        tblFacultades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCIÓN"
            }
        ));
        jScrollPane1.setViewportView(tblFacultades);

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Buscar");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        btnBuscar.setText("Aceptar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(btnBuscar))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeshacer))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExportar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar)
                    .addComponent(btnDeshacer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        esNuevo = true;
        limpiarCampos();
        gestionarControles(true);
        setTitle("Nueva Facultad");
        txtDescripcion.requestFocus();
        txtBusqueda.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblFacultades.getSelectedRow();
        if (fila >= 0) {
            esNuevo = false;
            Facultades facultadSeleccionada = listaFacultades.get(fila);
            
            txtId.setText(String.valueOf(facultadSeleccionada.getId()));
            txtDescripcion.setText(facultadSeleccionada.getDescripcion());
            
            gestionarControles(true);
            setTitle("Editar Facultad");
            txtDescripcion.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        txtBusqueda.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblFacultades.getSelectedRow();
        if (fila >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta facultad?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                int idFacultad = (int) tblFacultades.getValueAt(fila, 0);
                DatosFacultades.eliminar(idFacultad);
                cargarDatos(); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo descripción es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Facultades facultad = new Facultades();
        facultad.setDescripcion(txtDescripcion.getText().trim());
        
        if (esNuevo) {
            DatosFacultades.insertar(facultad);
        } else {
            facultad.setId(Integer.parseInt(txtId.getText()));
            DatosFacultades.actualizar(facultad);
        }
        
        cargarDatos();
        limpiarCampos();
        gestionarControles(false);
        setTitle("Facultades");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        limpiarCampos();
        gestionarControles(false);
        setTitle("Facultades");
        txtBusqueda.setEnabled(false);
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
            Exportar obj = new Exportar();
            obj.exportarExcel(tblFacultades);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al exportar el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        if (txtDescripcion.getText().length() >= 100) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        if(evt.getKeyChar()== KeyEvent.VK_ENTER){
            if(!txtBusqueda.getText().trim().equals("")){
                filtrarFacultades(txtBusqueda.getText());
            }else{
                filtrarFacultades("");
            }
        }
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        filtrarFacultades(txtBusqueda.getText().trim());
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFacultades;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
