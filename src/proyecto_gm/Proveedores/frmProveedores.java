package proyecto_gm.Proveedores;

import java.awt.Toolkit;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import proyecto_gm.Departamentos.Ubigeo;

public class frmProveedores extends javax.swing.JInternalFrame {

    private DatosProveedores datos = new DatosProveedores();
    private boolean esNuevo = false;
    private Proveedores proveedorActual;
    private frmListaProveedores frmLista;


    public frmProveedores(frmListaProveedores frmLista) {
        initComponents();
        this.frmLista = frmLista;
        this.esNuevo = true;
        this.proveedorActual = new Proveedores();
        setTitle("Nuevo Proveedor");
        cargarDepartamentos();
        cargarEstados();
        txtId.setEnabled(false);
    }

    public frmProveedores(frmListaProveedores frmLista, int idProveedor) {
        initComponents();
        this.frmLista = frmLista;
        this.esNuevo = false;
        setTitle("Editar Proveedor");
        cargarDepartamentos();
        cargarEstados();
        cmbDepartamento.setSelectedIndex(-1);
        cmbprovincia.setModel(new DefaultComboBoxModel<>());
        cmbdistrito.setModel(new DefaultComboBoxModel<>());
        this.proveedorActual = datos.obtenerPorId(idProveedor);
        if (proveedorActual != null) {
            cargarDatosEnFormulario();
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron los datos del proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }

        txtId.setEnabled(false);

        if (!esNuevo) {
            cmbEstado.setSelectedItem(proveedorActual.getEstado());
        } else {
            cmbEstado.setSelectedIndex(0);
        }
    }

    private void cargarDepartamentos() {
        List<Ubigeo> lista = datos.listarDepartamentosUbigeo();
        DefaultComboBoxModel<Ubigeo> modelo = new DefaultComboBoxModel<>();
        for (Ubigeo u : lista) {
            modelo.addElement(u);
        }
        cmbDepartamento.setModel(modelo);
        cmbDepartamento.setSelectedIndex(-1);
    }

    private void cargarEstados() {
        List<String> estados = datos.listarEstadosPV();
        cmbEstado.removeAllItems();
        for (String est : estados) {
            cmbEstado.addItem(est);
        }
    }

    private void cargarDatosEnFormulario() {
        txtId.setText(String.valueOf(proveedorActual.getIdProveedor()));
        txtNombres.setText(proveedorActual.getNombres());
        txtDireccion.setText(proveedorActual.getDireccion());
        txtCorreo.setText(proveedorActual.getCorreo());
        txtTelefono.setText(proveedorActual.getTelefono());
        txtRuc.setText(proveedorActual.getRuc());
        txtCelular.setText(proveedorActual.getCelular());
        txtRubro.setText(proveedorActual.getRubro());
        // 1. Seleccionar departamento
        for (int i = 0; i < cmbDepartamento.getItemCount(); i++) {
            Ubigeo depto = cmbDepartamento.getItemAt(i);
            if (depto.getCodigo().equals(String.valueOf(proveedorActual.getIdDepartamento()))) {
                cmbDepartamento.setSelectedIndex(i);
                break;
            }
        }
        Ubigeo deptoSeleccionado = (Ubigeo) cmbDepartamento.getSelectedItem();
        if (deptoSeleccionado != null) {
            // 2. Cargar provincias
            List<Ubigeo> listaProv = datos.listarProvinciasUbigeo(deptoSeleccionado.getCodigo());
            DefaultComboBoxModel<Ubigeo> modeloProv = new DefaultComboBoxModel<>();
            for (Ubigeo u : listaProv) {
                modeloProv.addElement(u);
            }
            cmbprovincia.setModel(modeloProv);

            for (int i = 0; i < cmbprovincia.getItemCount(); i++) {
                Ubigeo prov = cmbprovincia.getItemAt(i);
                if (prov.getNombre().equals(proveedorActual.getProvincia())) {
                    cmbprovincia.setSelectedIndex(i);
                    break;
                }
            }
            Ubigeo provSeleccionada = (Ubigeo) cmbprovincia.getSelectedItem();
            if (provSeleccionada != null) {
                List<Ubigeo> listaDist = datos.listarDistritosUbigeo(
                        deptoSeleccionado.getCodigo(), provSeleccionada.getCodigo());
                DefaultComboBoxModel<Ubigeo> modeloDist = new DefaultComboBoxModel<>();
                for (Ubigeo u : listaDist) {
                    modeloDist.addElement(u);
                }
                cmbdistrito.setModel(modeloDist);

                // Seleccionar distrito
                for (int i = 0; i < cmbdistrito.getItemCount(); i++) {
                    Ubigeo dist = cmbdistrito.getItemAt(i);
                    if (dist.getNombre().equals(proveedorActual.getDistrito())) {
                        cmbdistrito.setSelectedIndex(i);
                        break;
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbDepartamento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtRubro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbprovincia = new javax.swing.JComboBox<>();
        cmbdistrito = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("PROVEEDORES");

        escritorio.setBackground(new java.awt.Color(255, 248, 239));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.setName("guardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnDeshacer.setName("deshacer"); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        txtId.setNextFocusableComponent(txtNombres);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel2.setText("Provincia:");

        txtNombres.setNextFocusableComponent(txtDireccion);

        jLabel3.setText("Dirección:");

        txtDireccion.setNextFocusableComponent(txtCorreo);

        jLabel4.setText("Correo:");

        txtCorreo.setNextFocusableComponent(txtTelefono);

        jLabel5.setText("Telefono:");

        txtTelefono.setNextFocusableComponent(txtRuc);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel6.setText("Ruc:");

        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        jLabel7.setText("Departamento:");

        cmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentoActionPerformed(evt);
            }
        });

        jLabel8.setText("Nombres:");

        txtRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRubroActionPerformed(evt);
            }
        });

        jLabel9.setText("Rubro");

        jLabel10.setText("Estado");

        jLabel11.setText("Celular");

        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        jLabel12.setText("Distrito");

        cmbprovincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbprovinciaActionPerformed(evt);
            }
        });

        cmbdistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdistritoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(25, 25, 25))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(escritorioLayout.createSequentialGroup()
                                        .addGap(253, 253, 253)
                                        .addComponent(jLabel4))
                                    .addGroup(escritorioLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(escritorioLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(11, 11, 11))))
                                    .addGroup(escritorioLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(escritorioLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(escritorioLayout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtRuc)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cmbprovincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCorreo)))
                        .addGap(33, 33, 33)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbdistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRubro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeshacer)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar)
                    .addComponent(btnDeshacer))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(cmbprovincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbdistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNombres.getText().trim().isEmpty() || txtRuc.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos Nombres y RUC son obligatorios.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtRuc.getText().trim().length() != 11) {
            JOptionPane.showMessageDialog(this, "El RUC debe tener 11 dígitos.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cmbDepartamento.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un departamento.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Ubigeo deptoSeleccionado = (Ubigeo) cmbDepartamento.getSelectedItem();
        if (deptoSeleccionado != null) {
            proveedorActual.setIdDepartamento(Integer.parseInt(deptoSeleccionado.getCodigo()));
        }

        proveedorActual.setNombres(txtNombres.getText());
        proveedorActual.setDireccion(txtDireccion.getText());
        proveedorActual.setCorreo(txtCorreo.getText());
        proveedorActual.setTelefono(txtTelefono.getText());
        proveedorActual.setCelular(txtCelular.getText());
        proveedorActual.setRuc(txtRuc.getText());

        Ubigeo provSeleccionado = (Ubigeo) cmbprovincia.getSelectedItem();
        Ubigeo distSeleccionado = (Ubigeo) cmbdistrito.getSelectedItem();

        if (provSeleccionado != null) {
            proveedorActual.setProvincia(provSeleccionado.getNombre());
        }
        if (distSeleccionado != null) {
            proveedorActual.setDistrito(distSeleccionado.getNombre());
        }

        
        if (cmbEstado.getSelectedItem() != null) {
            proveedorActual.setEstado(cmbEstado.getSelectedItem().toString());
        }

        boolean resultado;
        if (esNuevo) {
            resultado = datos.insertar(proveedorActual);
        } else {
            resultado = datos.actualizar(proveedorActual);
        }

        if (resultado) {
            String mensaje = esNuevo ? "Proveedor guardado exitosamente." : "Proveedor actualizado exitosamente.";
            JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            frmLista.cargarTabla();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        if (txtId.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();
        }
        if (txtTelefono.getText().length() >= 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        if (txtRuc.getText().length() >= 11) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRubroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRubroActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void cmbprovinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbprovinciaActionPerformed
        Ubigeo depto = (Ubigeo) cmbDepartamento.getSelectedItem();
        Ubigeo prov = (Ubigeo) cmbprovincia.getSelectedItem();
        if (depto != null && prov != null) {
            List<Ubigeo> listaDist = datos.listarDistritosUbigeo(depto.getCodigo(), prov.getCodigo());
            DefaultComboBoxModel<Ubigeo> modelo = new DefaultComboBoxModel<>();
            for (Ubigeo u : listaDist) {
                modelo.addElement(u);
            }
            cmbdistrito.setModel(modelo);
            cmbdistrito.setSelectedIndex(-1);
        }

    }//GEN-LAST:event_cmbprovinciaActionPerformed

    private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed
        Ubigeo depto = (Ubigeo) cmbDepartamento.getSelectedItem();
        if (depto != null) {
            List<Ubigeo> listaProv = datos.listarProvinciasUbigeo(depto.getCodigo());

            DefaultComboBoxModel<Ubigeo> modelo = new DefaultComboBoxModel<>();
            for (Ubigeo u : listaProv) {
                modelo.addElement(u);
            }
            cmbprovincia.setModel(modelo);
            cmbprovincia.setSelectedIndex(-1);
            cmbdistrito.setModel(new DefaultComboBoxModel<>());
        }
    }//GEN-LAST:event_cmbDepartamentoActionPerformed

    private void cmbdistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbdistritoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Ubigeo> cmbDepartamento;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<Ubigeo> cmbdistrito;
    private javax.swing.JComboBox<Ubigeo> cmbprovincia;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtRubro;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
