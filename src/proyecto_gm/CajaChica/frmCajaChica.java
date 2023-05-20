package proyecto_gm.CajaChica;

import java.sql.SQLException;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class frmCajaChica extends javax.swing.JInternalFrame {

    private boolean primerEvento = false;

    boolean esNuevo = false;

    public frmCajaChica() throws SQLException {
        initComponents();
        initializeTable();
//  Crea un objeto ComboBox y asigna el modelo creado en el paso anterior

        DatosCajaChica.CargarCombo(cbotransferencias);

//  Agrega el objeto ComboBox a la celda correspondiente en cada fila de la tabla tblCajaChica
        DefaultTableModel modelo = (DefaultTableModel) tblCajaChica.getModel();
        TableColumn comboColumn = tblCajaChica.getColumnModel().getColumn(1); // Reemplaza "columna" por el índice de la columna donde deseas agregar el ComboBox
        comboColumn.setCellEditor(new DefaultCellEditor(cbotransferencias));
        DatosCajaChica.Mostrar(modelo);
        DatosCajaChica.Habilitar(escritorio, false);

    }

    private void initializeTable() {
        final int entradaColumn = 4; // Número de columna de entrada
        final int salidaColumn = 5; // Número de columna de salida
        final int saldoColumn = 6; // Número de columna de saldo

        // Establecer el CellEditor personalizado solo en la columna de salida
        tblCajaChica.getColumnModel().getColumn(salidaColumn).setCellEditor(new DefaultCellEditor(new JTextField()) {
            @Override
            public boolean stopCellEditing() {
                boolean result = super.stopCellEditing();
                if (result) {
                    // Obtener el valor de la celda editada en la columna de salida
                    String salida = tblCajaChica.getModel().getValueAt(tblCajaChica.getSelectedRow(), salidaColumn).toString();

                    // Obtener el valor de la celda de entrada en la misma fila
                    String entrada = tblCajaChica.getModel().getValueAt(tblCajaChica.getSelectedRow(), entradaColumn).toString();

                    try {
                        // Convertir los valores de String a float
                        float entradaValue = Float.parseFloat(entrada) * 100.0f / 100.0f;
                        float salidaValue = Float.parseFloat(salida) * 100.0f / 100.0f;

                        // Calcular el saldo
                        float saldo = Math.round((entradaValue - salidaValue) * 100.0f) / 100.0f;

                        // Mostrar el saldo en la celda de saldo correspondiente
                        tblCajaChica.setValueAt(saldo, tblCajaChica.getSelectedRow(), saldoColumn);
                    } catch (NumberFormatException ex) {
                        System.out.println("Error al convertir valores a float: " + ex.getMessage());
                        // Manejar la excepción si los valores no se pueden convertir a float
                    }
                }
                return result;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCajaChica = new javax.swing.JTable();
        cbotransferencias = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("CAJA CHICA");

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAgregar.setName("agregar"); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnDeshacer.setName("deshacer"); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        cbotransferencias.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (!primerEvento) {
                primerEvento = true;
                return; // Ignorar el primer evento
            }
            if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                System.out.println("Click");
                DatosCajaChica.Fecha(tblCajaChica, cbotransferencias);
            }
        }
    });

        tblCajaChica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "NroOperacion", "Fecha", "Descripcion", "Entrada", "Salida", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(tblCajaChica);
        if (tblCajaChica.getColumnModel().getColumnCount() > 0) {
            tblCajaChica.getColumnModel().getColumn(0).setResizable(false);
            tblCajaChica.getColumnModel().getColumn(1).setResizable(false);
            tblCajaChica.getColumnModel().getColumn(2).setResizable(false);
            tblCajaChica.getColumnModel().getColumn(3).setResizable(false);
            tblCajaChica.getColumnModel().getColumn(4).setResizable(false);
            tblCajaChica.getColumnModel().getColumn(5).setResizable(false);
            tblCajaChica.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeshacer)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(escritorioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cbotransferencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeshacer)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(escritorioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(cbotransferencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        CajaChica caj = new CajaChica();

        // Dentro del método donde capturas los datos de la nueva fila
        int newRow = tblCajaChica.getSelectedRow(); // Última fila ingresada
        String transferencia = DatosCajaChica.CapturarID(tblCajaChica.getValueAt(newRow, 1).toString());

        caj.setId((String) tblCajaChica.getValueAt(newRow, 0)); // Asigna el valor de la primera columna a campo1

        caj.setIdTransferenciasBancarias(transferencia);
        caj.setFecha((String) tblCajaChica.getValueAt(newRow, 2));
        caj.setDescripcion((String) tblCajaChica.getValueAt(newRow, 3));
        // Validar y convertir el valor de entrada
        Object entradaValue = tblCajaChica.getValueAt(newRow, 4);
        if (entradaValue instanceof String) {
            try {
                caj.setEntrada(Float.parseFloat((String) entradaValue));
            } catch (NumberFormatException ex) {
                // Manejar la excepción si el valor no es un número válido
                System.out.println("Error al convertir entrada a float: " + ex.getMessage());
            }
        }

        // Validar y convertir el valor de salida
        Object salidaValue = tblCajaChica.getValueAt(newRow, 5);
        if (salidaValue instanceof String) {
            try {
                caj.setSalida(Float.parseFloat((String) salidaValue));
            } catch (NumberFormatException ex) {
                // Manejar la excepción si el valor no es un número válido
                System.out.println("Error al convertir salida a float: " + ex.getMessage());
            }
        }

        // Validar y convertir el valor de saldo
        Object saldoValue = tblCajaChica.getValueAt(newRow, 6);
        if (saldoValue instanceof String) {
            try {
                caj.setSaldo(Float.parseFloat((String) saldoValue));
            } catch (NumberFormatException ex) {
                // Manejar la excepción si el valor no es un número válido
                System.out.println("Error al convertir saldo a float: " + ex.getMessage());
            }
        }

        System.out.println(caj.getSaldo());

        // Preguntamos si haremos un INSERT o un UPDATE
        if (esNuevo) {
            // Insertar nuevo registro
            if (DatosCajaChica.validarCamposCompletados(tblCajaChica)) {
                DatosCajaChica.Insertar(caj, tblCajaChica);
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                DatosCajaChica.Habilitar(escritorio, false);

                tblCajaChica.clearSelection();
                // Habilitamos la seleccion de filas de la tabla
                tblCajaChica.setRowSelectionAllowed(true);
            }
        } else {
            if (DatosCajaChica.validarCamposCompletados(tblCajaChica)) {
                DatosCajaChica.Actualizar(caj, tblCajaChica);
                JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                DatosCajaChica.Habilitar(escritorio, false);

                tblCajaChica.clearSelection();
                // Habilitamos la seleccion de filas de la tabla
                tblCajaChica.setRowSelectionAllowed(true);
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code
        DatosCajaChica.Habilitar(escritorio, true);
        DatosCajaChica.NuevaFila(tblCajaChica);
        esNuevo = true;
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // TODO add your handling code here:
        DatosCajaChica.Limpiar(tblCajaChica);
        DatosCajaChica.Habilitar(escritorio, false);
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        DatosCajaChica.Eliminar(tblCajaChica);
        DatosCajaChica.Habilitar(escritorio, false);
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbotransferencias;
    private javax.swing.JPanel escritorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCajaChica;
    // End of variables declaration//GEN-END:variables
}
