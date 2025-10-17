package proyecto_gm.Carreras;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;
import proyecto_gm.Utilitario;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.Exportar;


public class frmCarreras extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    boolean esNuevo = false;
    List<Carreras> listaCarreras; 

    public frmCarreras() {
        initComponents();
        
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCIÓN");
        tblCarreras.setModel(modelo);
        
        cargarDatos();
        gestionarEstadoCampos(false); 
    }
    
    private void cargarDatos() {
        modelo.setRowCount(0);
        listaCarreras = DatosCarrera.listar();
        for (Carreras carrera : listaCarreras) {
            modelo.addRow(new Object[]{carrera.getId(), carrera.getDescripcion()});
        }
    }
    
    private void gestionarEstadoCampos(boolean activo) {
        txtId.setEnabled(false);
        txtDescripcion.setEnabled(activo);
        
        btnGuardar.setEnabled(activo);
        btnDeshacer.setEnabled(activo);
        
        btnAgregar.setEnabled(!activo);
        btnEditar.setEnabled(!activo);
        btnEliminar.setEnabled(!activo);
    }
    
    private void limpiarCampos() {
        txtId.setText("");
        txtDescripcion.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarreras = new javax.swing.JTable();
        btnDeshacer = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("CARRERAS");

        escritorio.setBackground(new java.awt.Color(255, 248, 239));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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

        jLabel1.setText("Id:");

        txtId.setEnabled(false);

        jLabel2.setText("Descripcion:");

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        tblCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCIÓN"
            }
        ));
        jScrollPane1.setViewportView(tblCarreras);

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeshacer)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExportar)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar)
                    .addComponent(btnDeshacer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        esNuevo = true;
        limpiarCampos();
        gestionarEstadoCampos(true);
        txtId.setEnabled(false); 
        setTitle("Nueva Carrera");
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
          int fila = tblCarreras.getSelectedRow();
        if (fila >= 0) {
        esNuevo = false;
            // Obtener el objeto Carrera de la lista
        Carreras carreraSeleccionada = listaCarreras.get(fila);
        txtId.setText(String.valueOf(carreraSeleccionada.getId()));
        txtDescripcion.setText(carreraSeleccionada.getDescripcion());
            
            gestionarEstadoCampos(true);
            setTitle("Editar Carrera");
        txtDescripcion.requestFocus();
        } else {
            
        Utilitario.MostrarMensaje("Debes seleccionar una fila para editar.", Utilitario.TipoMensaje.alerta);
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblCarreras.getSelectedRow();
    if (fila >= 0) {
        boolean confirmar = Utilitario.MostrarMensajePregunta(
                "¿Está seguro de eliminar esta carrera?",Utilitario.TipoMensaje.pregunta);
        
        if (confirmar) {
            int idCarrera = (int) tblCarreras.getValueAt(fila, 0);DatosCarrera.eliminar(idCarrera);
            cargarDatos();}
    } else {
        Utilitario.MostrarMensaje("Debes seleccionar una fila para eliminar.", Utilitario.TipoMensaje.alerta);}

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         if (txtDescripcion.getText().trim().isEmpty()) {
        Utilitario.MostrarMensaje("El campo descripción no puede estar vacío.", Utilitario.TipoMensaje.alerta);
        return;
    }
    Carreras carrera = new Carreras();
    carrera.setDescripcion(txtDescripcion.getText().trim());

    if (esNuevo) {
        DatosCarrera.insertar(carrera);
    } else {
        carrera.setId(Integer.parseInt(txtId.getText()));
        DatosCarrera.actualizar(carrera);}
    
    cargarDatos();
    limpiarCampos();
    gestionarEstadoCampos(false);
    setTitle("Carreras");
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
         try {
            Exportar obj = new Exportar();
            obj.exportarExcel(tblCarreras);
        } catch (IOException ex) {
             Utilitario.MostrarMensaje("Error al exportar el archivo: " + ex.getMessage(), Utilitario.TipoMensaje.error);}
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        limpiarCampos();
        gestionarEstadoCampos(false);
        setTitle("Carreras");
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        if (txtDescripcion.getText().length() >= 100) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCarreras;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
