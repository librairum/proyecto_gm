package proyecto_gm.Area;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class frmArea extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    boolean esNuevo = false;
    private javax.swing.table.TableRowSorter<DefaultTableModel> sorter;

    public frmArea() {
        initComponents();
        
        // Configurar modelo de la tabla
        String[] titulos = {"ID", "DESCRIPCIÓN"};
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblArea.setModel(modelo);
        
        sorter = new javax.swing.table.TableRowSorter<>(modelo);
        tblArea.setRowSorter(sorter);

        // Buscar al presionar Enter
        txtBusqueda.addActionListener(e -> filtrarArea(txtBusqueda.getText().trim()));
        
        estilizarEncabezado(tblArea);
        cargarTabla();
        configurarEstadoInicial();
    }

    // Método para cargar y recargar los datos en la tabla
    private void cargarTabla() {
        modelo.setRowCount(0);
        List<Area> lista = DatosArea.listar();
        
        for (Area area : lista) {
            modelo.addRow(new Object[]{area.getIdArea(), area.getDescripcionArea()});
        }
    }

    // Método para configurar el estado inicial o de "navegación"
    private void configurarEstadoInicial() {
        // Habilitar/deshabilitar campos
        txtCodigo.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtBusqueda.setEnabled(true);

        // Habilitar/deshabilitar botones
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        
        // Limpiar campos
        limpiarCampos();
        
        // Permitir selección en la tabla
        tblArea.setEnabled(true);
        tblArea.clearSelection();
    }
    
    // Método para configurar el estado de "edición" o "nuevo"
    private void configurarEstadoFormulario() {
        txtCodigo.setEnabled(false);
        txtDescripcion.setEnabled(true);
        txtBusqueda.setEnabled(false);
        
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        
        tblArea.setEnabled(false);
    }
    
    private void limpiarCampos() {
        txtCodigo.setText("");
        txtDescripcion.setText("");
    }
    
    private void estilizarEncabezado(JTable tabla) {
        JTableHeader header = tabla.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                setBackground(Color.DARK_GRAY);
                setForeground(Color.WHITE);
                setFont(getFont().deriveFont(Font.BOLD, 13));
                return this;
            }
        });
    }
    
        private void filtrarArea(String texto) {
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

        escritorio = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("AREA");

        escritorio.setEnabled(false);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnNuevo.setName("agregar"); // NOI18N
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
        btnCancelar.setName("deshacer"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        jLabel2.setText("Descripción:");

        tblArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCIÓN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblArea.setFocusable(false);
        tblArea.setRowHeight(25);
        tblArea.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblArea.setShowGrid(true);
        jScrollPane1.setViewportView(tblArea);
        if (tblArea.getColumnModel().getColumnCount() > 0) {
            tblArea.getColumnModel().getColumn(0).setResizable(false);
            tblArea.getColumnModel().getColumn(1).setResizable(false);
        }

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
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(btnBuscar))
        );

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(escritorioLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(escritorioLayout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(escritorioLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        configurarEstadoInicial();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Validar campo
        if (txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo descripción es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }

        Area area = new Area();
        area.setDescripcionArea(txtDescripcion.getText().trim());
        boolean exito;

        if (esNuevo) {
            // Insertar
            exito = DatosArea.insertar(area);
        } else {
            // Actualizar
            area.setIdArea(Integer.parseInt(txtCodigo.getText()));
            exito = DatosArea.actualizar(area);
        }

        if (exito) {
            String msg = esNuevo ? "Área guardada correctamente." : "Área actualizada correctamente.";
            JOptionPane.showMessageDialog(this, msg, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            configurarEstadoInicial();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblArea.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idArea = (int) tblArea.getValueAt(fila, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta área?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (DatosArea.eliminar(idArea)) {
                JOptionPane.showMessageDialog(this, "Área eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el área.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblArea.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Cargar datos de la tabla al formulario
        txtCodigo.setText(tblArea.getValueAt(fila, 0).toString());
        txtDescripcion.setText(tblArea.getValueAt(fila, 1).toString());

        esNuevo = false;
        configurarEstadoFormulario();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        esNuevo = true;
        configurarEstadoFormulario();
        limpiarCampos();
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            if (!txtBusqueda.getText().trim().equals("")) {
                filtrarArea(txtBusqueda.getText());
            } else {
                filtrarArea("");
            }
        }
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        filtrarArea(txtBusqueda.getText().trim());
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblArea;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtBusqueda1;
    private javax.swing.JTextField txtBusqueda2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
