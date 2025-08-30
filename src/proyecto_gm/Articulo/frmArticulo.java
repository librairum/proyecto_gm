package proyecto_gm.Articulo;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import proyecto_gm.Categoria.Categoria;
import proyecto_gm.Utilitario;

public class frmArticulo extends javax.swing.JInternalFrame {
    private Articulo registro;
    private Utilitario.EstadoProceso estadoProceso;

    public frmArticulo(Articulo registro, Utilitario.EstadoProceso estado) {
        try {
            initComponents();
            
            this.registro = registro;
            this.estadoProceso = estado;

            // Inicializar combos
            cargarCategorias();
            cargarMarcas();

            if (estado == Utilitario.EstadoProceso.NUEVO) {
                limpiarFormulario();
                txtId.setEnabled(false); // El ID se genera automáticamente
            } else if (estado == Utilitario.EstadoProceso.EDITAR) {
                cargarDatosFormulario();
                txtId.setEnabled(false); // El ID no se puede editar
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al inicializar formulario: " + e.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void cargarCategorias() {
        try {
            List<Categoria> listaCategorias = DatosArticulo.obtenerCategorias();
            DefaultComboBoxModel<Categoria> modelo = new DefaultComboBoxModel<>();
            
            for (Categoria cat : listaCategorias) {
                modelo.addElement(cat);
            }
            
            cmbCategoria.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar categorías: " + e.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarMarcas() {
        try {
            List<Marca> listaMarcas = DatosArticulo.obtenerMarcas();
            DefaultComboBoxModel<Marca> modelo = new DefaultComboBoxModel<>();
            
            for (Marca marca : listaMarcas) {
                modelo.addElement(marca);
            }
            
            cboMarca.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar marcas: " + e.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void cargarDatosFormulario() {
        try {
            if (registro == null) return;
            
            txtId.setText(String.valueOf(registro.getIdArticulo()));
            txtDescripcion.setText(registro.getDescripcion() != null ? registro.getDescripcion() : "");
            txtCaracteristicas.setText(registro.getCaracteristicas() != null ? registro.getCaracteristicas() : "");
            txtCantidad.setText(String.valueOf(registro.getCantidad()));

            // Seleccionar Marca en el ComboBox
            if (registro.getMarca() != null) {
                for (int i = 0; i < cboMarca.getItemCount(); i++) {
                    Marca marcaCombo = cboMarca.getItemAt(i);
                    if (marcaCombo != null && marcaCombo.getIdMarca() == registro.getMarca().getIdMarca()) {
                        cboMarca.setSelectedIndex(i);
                        break;
                    }
                }
            }

            // Seleccionar Categoría en el ComboBox
            if (registro.getCategoria() != null) {
                for (int i = 0; i < cmbCategoria.getItemCount(); i++) {
                    Categoria catCombo = cmbCategoria.getItemAt(i);
                    if (catCombo != null && catCombo.getIdCat() == registro.getCategoria().getIdCat()) {
                        cmbCategoria.setSelectedIndex(i);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos en formulario: " + e.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCaracteristicas = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbCategoria = new javax.swing.JComboBox<>();
        cboMarca = new javax.swing.JComboBox<>();

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Descripicion");

        jLabel3.setText("Caracteristicas");

        jLabel4.setText("Categoria");

        jLabel5.setText("Marca");

        jLabel6.setText("Cantidad");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        cmbCategoria.setModel(new DefaultComboBoxModel<>());

        cboMarca.setModel(new DefaultComboBoxModel<>());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCaracteristicas, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtDescripcion))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(28, 28, 28)
                        .addComponent(btnRegresar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtCaracteristicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // Validaciones básicas
            String descripcion = txtDescripcion.getText().trim();
            String caracteristicas = txtCaracteristicas.getText().trim();
            String cantidadTexto = txtCantidad.getText().trim();

            if (descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La descripción es obligatoria.", "Validación", JOptionPane.WARNING_MESSAGE);
                txtDescripcion.requestFocus();
                return;
            }

            if (cantidadTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La cantidad es obligatoria.", "Validación", JOptionPane.WARNING_MESSAGE);
                txtCantidad.requestFocus();
                return;
            }

            double cantidad;
            try {
                cantidad = Double.parseDouble(cantidadTexto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido.", "Validación", JOptionPane.WARNING_MESSAGE);
                txtCantidad.requestFocus();
                return;
            }

            Categoria categoriaSeleccionada = (Categoria) cmbCategoria.getSelectedItem();
            Marca marcaSeleccionada = (Marca) cboMarca.getSelectedItem();

            if (categoriaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una categoría.", "Validación", JOptionPane.WARNING_MESSAGE);
                cmbCategoria.requestFocus();
                return;
            }

            if (marcaSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una marca.", "Validación", JOptionPane.WARNING_MESSAGE);
                cboMarca.requestFocus();
                return;
            }

            boolean exito = false;

            if (estadoProceso == Utilitario.EstadoProceso.NUEVO) {
                Articulo nuevo = new Articulo();
                nuevo.setDescripcion(descripcion);
                nuevo.setCaracteristicas(caracteristicas);
                nuevo.setCantidad(cantidad);
                nuevo.setCategoria(categoriaSeleccionada);
                nuevo.setMarca(marcaSeleccionada);

                exito = DatosArticulo.Insertar(nuevo);

            } else if (estadoProceso == Utilitario.EstadoProceso.EDITAR) {
                registro.setDescripcion(descripcion);
                registro.setCaracteristicas(caracteristicas);
                registro.setCantidad(cantidad);
                registro.setCategoria(categoriaSeleccionada);
                registro.setMarca(marcaSeleccionada);

                exito = DatosArticulo.Actualizar(registro);
            }

            if (exito) {
                // Actualizar la tabla en el formulario padre si existe
                if (getParent() != null) {
                    // Buscar y refrescar frmListaArticulo si está abierto
                    javax.swing.JDesktopPane desktop = (javax.swing.JDesktopPane) getParent();
                    javax.swing.JInternalFrame[] frames = desktop.getAllFrames();
                    for (javax.swing.JInternalFrame frame : frames) {
                        if (frame instanceof frmListaArticulo) {
                            ((frmListaArticulo) frame).Cargar(); // Método público para refrescar
                            break;
                        }
                    }
                }
                this.dispose();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void limpiarFormulario() {
        txtId.setText("");
        txtDescripcion.setText("");
        txtCaracteristicas.setText("");
        txtCantidad.setText("");
        cboMarca.setSelectedIndex(-1);
        cmbCategoria.setSelectedIndex(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<Marca> cboMarca;
    private javax.swing.JComboBox<Categoria> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCaracteristicas;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

}
