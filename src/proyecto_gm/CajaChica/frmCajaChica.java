package proyecto_gm.CajaChica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import proyecto_gm.Area.Area;
import proyecto_gm.Cargo.Cargo;
import proyecto_gm.Empleado.DatosEmpleados;

public class frmCajaChica extends javax.swing.JInternalFrame {

    private boolean primerEvento = false;

    boolean esNuevo = false;
    String periodo;

    public frmCajaChica() {
        initComponents();
        //initializeTable();
         
        //DatosCajaChica.CargarCombo(cbontransferencias);
        inicializaComboIdTransferenciaBancaria();
        //  Agrega el objeto ComboBox a la celda correspondiente en cada fila de la tabla tblCajaChica
        TableColumn comboColumn = tblCajaChica.getColumnModel().getColumn(1); // Reemplaza "columna" por el índice de la columna donde deseas agregar el ComboBox
        DatosCajaChica.Habilitar(escritorio, false);

        cargarDatosCajaChica(); //mostrar en JTable
        //calcularSumaTotal();
        // Personalizar header
        JTableHeader header = tblCajaChica.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                setBackground(Color.DARK_GRAY);
                setForeground(Color.WHITE);
                setFont(getFont().deriveFont(Font.BOLD, 13));
                return this;
            }
        });
        
        //calculo de entrada y salida
        agregarListenersCalculoTotal();

    }
    private void inicializaComboIdTransferenciaBancaria() {
    // Cargar áreas
    List<CajaChica> lista = DatosCajaChica.listaidTransBanca(); 
    DefaultComboBoxModel<CajaChica> modelo = new DefaultComboBoxModel<>();
    for (CajaChica c : lista) {
        modelo.addElement(c);
    }
    cbontransferencias.setModel(modelo); 
}

    private void cargarDatosCajaChica() {
        DefaultTableModel modelo = (DefaultTableModel) tblCajaChica.getModel();
        modelo.setRowCount(0); // Limpiar la tabla
        DatosCajaChica.Mostrar(modelo);
    }

    public static String formatearFecha(String fecha) {
        try {
            // Suponiendo que la fecha que recibes está en formato dd/MM/yyyy
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate = formatoEntrada.parse(fecha);

            // Formateamos la fecha a yyyy-MM-dd para MySQL
            SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
            return formatoSalida.format(fechaDate);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al formatear la fecha: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }

    /*
    private void calcularSumaTotal() {
        // Declarar una variable para almacenar la suma total
        float total = 0.0f;

        // Recorrer todas las filas de la tabla
        for (int row = 0; row < tblCajaChica.getRowCount(); row++) {
            // Obtener el valor de la columna 6 para la fila actual
            Object value = tblCajaChica.getValueAt(row, 6);
            if (value != null) {
                float saldo = Float.parseFloat(value.toString());
                total += saldo;
            }
        }

        // Asignar el total al JTextField "txtTotal"
        txtTotal.setText(String.valueOf(total));
    }
    /*
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
                        String saldoString = String.format("%.2f", saldo);
                        tblCajaChica.setValueAt(saldoString, tblCajaChica.getSelectedRow(), saldoColumn);
                    } catch (NumberFormatException ex) {
                        System.out.println("Error al convertir valores a float: " + ex.getMessage());
                        // Manejar la excepción si los valores no se pueden convertir a float
                    }
                }
                return result;
            }
        });
    }*/
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
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbontransferencias = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSalida = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("CAJA CHICA");

        escritorio.setBackground(new java.awt.Color(255, 248, 239));

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

        tblCajaChica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "N° Transacción:", "Fecha", "Descripcion", "Entrada", "Salida", "Saldo"
            }
        ));
        tblCajaChica.setFocusable(false);
        tblCajaChica.setRowHeight(25);
        tblCajaChica.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblCajaChica.setShowGrid(true);
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

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel1.setText("Saldo Actual:");

        jLabel3.setText("ID:");

        txtId.setEnabled(false);

        jLabel4.setText("N° Transacción:");

        cbontransferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbontransferenciasActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha: ");

        jLabel6.setText("Descripcion:");

        jLabel7.setText("Entrada: ");

        jLabel8.setText("Salida: ");

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cbontransferencias, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addGap(5, 5, 5)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeshacer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDeshacer)
                        .addComponent(btnAgregar)
                        .addComponent(btnEliminar)
                        .addComponent(btnGuardar))
                    .addComponent(btnEditar))
                .addGap(28, 28, 28)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbontransferencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void actualizarSaldo() {
        try {
            float entrada = Float.parseFloat(txtEntrada.getText());
            float salida = Float.parseFloat(txtSalida.getText());
            float saldo = Math.round((entrada - salida) * 100.0f) / 100.0f;
            txtTotal.setText("" + saldo); 
        } catch (NumberFormatException e) {
            txtTotal.setText(""); // Si hay error, dejar el campo vacío o mostrar mensaje
        }
    }

    private void agregarListenersCalculoTotal() {
        DocumentListener listener = new DocumentListener() { // DocumentListener, sirve para detectar cambios en el texto de un JTextField.
            public void insertUpdate(DocumentEvent e) {
                actualizarSaldo(); 
            }

            public void removeUpdate(DocumentEvent e) {
                actualizarSaldo();
            }

            public void changedUpdate(DocumentEvent e) {
                actualizarSaldo();
            }
        };

        txtEntrada.getDocument().addDocumentListener(listener);
        txtSalida.getDocument().addDocumentListener(listener);
    }             

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Verificar si es una nueva fila (cuando 'esNuevo' es verdadero)
        if (esNuevo) {
            // Obtener el siguiente ID antes de la inserción
            String siguienteId = DatosCajaChica.GenerarCodigo();
            txtId.setText(siguienteId);  // Asigna el siguiente ID al campo txtId

            // Crear el objeto CajaChica y asignar los valores de los campos de texto
            CajaChica caj = new CajaChica();
            caj.setId(txtId.getText());  // ID capturado anteriormente
            caj.setIdTransferenciasBancarias(Integer.parseInt(DatosCajaChica.CapturarIdTransBanca(cbontransferencias)));
            String fechaFormateada = formatearFecha(txtFecha.getText());  // Formateamos la fecha antes de asignarla
            caj.setFecha(fechaFormateada);

            caj.setDescripcion(txtDescripcion.getText());

            // Parsear los valores de Entrada, Salida y Total
            try {
                caj.setEntrada(Float.parseFloat(txtEntrada.getText()));
                caj.setSalida(Float.parseFloat(txtSalida.getText()));
                caj.setSaldo(Float.parseFloat(txtTotal.getText()));  // Usamos txtTotal para el saldo calculado
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese valores válidos en Entrada, Salida y Total", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir si los valores no son válidos
            }

            // Llamar al método Insertar para guardar en la base de datos
            DatosCajaChica.Insertar(caj, tblCajaChica, ""); // Se pasa la tabla, aunque no se usa periodo en este caso

            // Limpiar los campos para un nuevo registro
            txtFecha.setText("");
            txtDescripcion.setText("");
            txtEntrada.setText("");
            txtSalida.setText("");
            txtTotal.setText("");

            // Recargar la tabla para reflejar los nuevos datos
            cargarDatosCajaChica(); // Asegúrate de que este método esté implementado correctamente para cargar los datos en la tabla

            // Cambiar el estado del formulario
            esNuevo = false;
            DatosCajaChica.Habilitar(escritorio, false);
        } else {
            // Actualizar datos existentes desde los campos
            CajaChica caj = new CajaChica();

            caj.setId(txtId.getText());
            caj.setIdTransferenciasBancarias(Integer.parseInt(DatosCajaChica.CapturarIdTransBanca(cbontransferencias)));
            String fechaFormateada = formatearFecha(txtFecha.getText());
            caj.setFecha(fechaFormateada);
            caj.setDescripcion(txtDescripcion.getText());

            try {
                caj.setEntrada(Float.parseFloat(txtEntrada.getText()));
                caj.setSalida(Float.parseFloat(txtSalida.getText()));
                caj.setSaldo(Float.parseFloat(txtTotal.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valores inválidos en los campos Entrada, Salida o Total", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Llamar al método Actualizar
            DatosCajaChica.Actualizar(caj, tblCajaChica, "");

            JOptionPane.showMessageDialog(null, "Registro actualizado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

            // Refrescar tabla
            cargarDatosCajaChica();
            // Limpiar los campos después de actualizar
            txtId.setText("");
            txtFecha.setText("");
            txtDescripcion.setText("");
            txtEntrada.setText("");
            txtSalida.setText("");
            txtTotal.setText("");

            // Reiniciar combo box si lo deseas (opcional)
            if (cbontransferencias.getItemCount() > 0) {
                cbontransferencias.setSelectedIndex(0);
            }
        }

        // Después de guardar, desactivar campos o limpiar
        DatosCajaChica.Habilitar(escritorio, false);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // Habilitar componentes
        DatosCajaChica.Habilitar(escritorio, true);

        // Agregar nueva fila en la tabla
        //DatosCajaChica.NuevaFila(tblCajaChica);
        // Capturar el siguiente ID y mostrarlo en el campo de texto
        txtId.setText(DatosCajaChica.GenerarCodigo());
        txtId.setEnabled(false); // opcional: para evitar edición manual

        // Indicar que es un nuevo registro
        esNuevo = true;

        // Calcular totales si aplica
        //calcularSumaTotal();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        // Agrupa tus campos
        JTextField[] camposTexto = {txtId, txtFecha, txtDescripcion, txtEntrada, txtSalida, txtTotal};
        JComboBox[] combos = {cbontransferencias};

        // Limpia los campos
        DatosCajaChica.LimpiarCampos(camposTexto, combos);

        // Deshabilita los campos
        DatosCajaChica.Habilitar(escritorio, false);
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        DatosCajaChica.Eliminar(tblCajaChica);
        DatosCajaChica.Habilitar(escritorio, false);
        //calcularSumaTotal();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbontransferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbontransferenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbontransferenciasActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int filaSeleccionada = tblCajaChica.getSelectedRow();

        if (filaSeleccionada >= 0) {

            btnDeshacer.setEnabled(true);

            String id = tblCajaChica.getValueAt(filaSeleccionada, 0).toString();
            String nroOperacion = tblCajaChica.getValueAt(filaSeleccionada, 1).toString();
            String fechaOriginal = tblCajaChica.getValueAt(filaSeleccionada, 2).toString();
            String descripcion = tblCajaChica.getValueAt(filaSeleccionada, 3).toString();
            String entrada = tblCajaChica.getValueAt(filaSeleccionada, 4).toString();
            String salida = tblCajaChica.getValueAt(filaSeleccionada, 5).toString();
            String total = tblCajaChica.getValueAt(filaSeleccionada, 6).toString();

            // Formatear la fecha a dd/MM/yyyy
            String fechaFormateada = "";
            try {
                SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd"); // o el formato en el que venga tu fecha
                SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = formatoEntrada.parse(fechaOriginal);
                fechaFormateada = formatoSalida.format(fecha);
            } catch (ParseException ex) {
                fechaFormateada = fechaOriginal; // si falla, usa la fecha original
            }

            txtId.setText(id);
            cbontransferencias.setSelectedItem(nroOperacion);
            txtFecha.setText(fechaFormateada);
            txtDescripcion.setText(descripcion);
            txtEntrada.setText(entrada);
            txtSalida.setText(salida);
            txtTotal.setText(total);

            // Habilitar botón Deshacer
            btnDeshacer.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<CajaChica> cbontransferencias;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCajaChica;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtSalida;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
