/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyecto_gm.Asistencias;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import proyecto_gm.Exportar;
import proyecto_gm.ImpAsistencias;

/**
 *
 * @author jeanv
 */
public class frmAsistencias extends javax.swing.JInternalFrame {

    Asistencia a = new Asistencia();

    /**
     * Creates new form frmAsistencias
     */
    public frmAsistencias() {
        initComponents();
        initializeTable();
        // Personalizar header
        JTableHeader header = tblAsistencias.getTableHeader();
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

        // Cargar empleados
        DatosAsistencia.CargarEmpleados(cboEmpleado);

        RowsRenderer renderer = new RowsRenderer(0);
        tblAsistencias.setDefaultRenderer(Object.class, renderer);
    }

    // Metodo para leer la edicion en las celdas
    private void initializeTable() {
        tblAsistencias.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()) {
            @Override
            public boolean stopCellEditing() {
                boolean result = super.stopCellEditing();
                if (result) {
                    if (lastSelectedColumn == 5) {
                        String obs = tblAsistencias.getValueAt(lastSelectedRow, lastSelectedColumn).toString();
                        DatosAsistencia.ColocarObservacion(datos[0], datos[1], horas[0], obs);
                    } else {
                        String hora = tblAsistencias.getValueAt(lastSelectedRow, lastSelectedColumn).toString();
                        System.out.println("hora = " + hora);
                        a.setHora(hora);
                        if (datos[2].isEmpty()) {
                            DatosAsistencia.Insertar(a, tblAsistencias, cboPeriodo, cboEmpleado, txtTotalHoras);
                            horas = obtenerHoras();
                            System.out.println("Se registro nueva asistencia");
                            if (!horas[0].isEmpty() && !horas[1].isEmpty()) {
                                DatosAsistencia.GenerarDetalle(tblAsistencias, cboPeriodo, cboEmpleado, txtTotalHoras);
                                System.out.println("Se genero el detalle.");
                            }
                        } else {
                            DatosAsistencia.Actualizar(a, horas[0], tblAsistencias, cboPeriodo, cboEmpleado, txtTotalHoras);
                        }
                    }

                }
                return result;
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDni = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsistencias = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lblEmpleado = new javax.swing.JLabel();
        cboPeriodo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboEmpleado = new javax.swing.JComboBox<>();
        btnImportar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTotalHoras = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("ASISTENCIAS");

        jPanel1.setBackground(new java.awt.Color(255, 248, 239));

        lblDni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDni.setText("jLabel2");
        lblDni.setHorizontalAlignment(JLabel.CENTER);

        tblAsistencias.setBackground(new java.awt.Color(255, 255, 255));
        tblAsistencias.setForeground(new java.awt.Color(0, 0, 0));
        tblAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DÍA", "FECHA", "ENTRADA", "SALIDA", "DURACIÓN", "OBSERVACIONES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAsistencias.setFocusable(false);
        tblAsistencias.setRowHeight(25);
        tblAsistencias.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblAsistencias.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblAsistencias.setShowGrid(true);
        tblAsistencias.getTableHeader().setReorderingAllowed(false);
        tblAsistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsistenciasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAsistencias);
        if (tblAsistencias.getColumnModel().getColumnCount() > 0) {
            tblAsistencias.getColumnModel().getColumn(0).setResizable(false);
            tblAsistencias.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblAsistencias.getColumnModel().getColumn(1).setResizable(false);
            tblAsistencias.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblAsistencias.getColumnModel().getColumn(2).setResizable(false);
            tblAsistencias.getColumnModel().getColumn(2).setPreferredWidth(30);
            tblAsistencias.getColumnModel().getColumn(3).setResizable(false);
            tblAsistencias.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblAsistencias.getColumnModel().getColumn(4).setResizable(false);
            tblAsistencias.getColumnModel().getColumn(4).setPreferredWidth(30);
            tblAsistencias.getColumnModel().getColumn(5).setResizable(false);
            tblAsistencias.getColumnModel().getColumn(5).setPreferredWidth(260);
        }

        jLabel4.setText("Periodo:");

        lblEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmpleado.setText("jLabel1");
        lblEmpleado.setHorizontalAlignment(JLabel.CENTER);

        cboPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "102022", "112022" }));
        cboPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPeriodoActionPerformed(evt);
            }
        });

        jLabel3.setText("Empleado:");

        cboEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpleadoActionPerformed(evt);
            }
        });

        btnImportar.setBackground(new java.awt.Color(0, 153, 0));
        btnImportar.setForeground(new java.awt.Color(255, 255, 255));
        btnImportar.setText("Importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        btnExportar.setBackground(new java.awt.Color(153, 153, 0));
        btnExportar.setForeground(new java.awt.Color(0, 0, 0));
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("TOTAL DE HORAS:");

        txtTotalHoras.setEditable(false);
        txtTotalHoras.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalHoras.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnImportar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExportar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(lblDni, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(lblEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(lblEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtTotalHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String ultimoPeriodoSeleccionado = "";
    private String ultimoEmpleadoSeleccionado = "";

    private void actualizarEmpleadoSeleccionado() {
        // Mostrar el empleado seleccionado
        lblEmpleado.setText(cboEmpleado.getSelectedItem().toString());

        // Mostrar el DNI del empleado seleccionado
        lblDni.setText(DatosAsistencia.ObtenerDNI(cboEmpleado));
    }

    private void cboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpleadoActionPerformed
        String empleadoSeleccionado = cboEmpleado.getSelectedItem().toString();
        String periodoSeleccionado = cboPeriodo.getSelectedItem().toString();

        if (!empleadoSeleccionado.equals(ultimoEmpleadoSeleccionado) || !periodoSeleccionado.equals(ultimoPeriodoSeleccionado)) {
            actualizarEmpleadoSeleccionado();

            DatosAsistencia.RellenarTabla(tblAsistencias, cboPeriodo, cboEmpleado, txtTotalHoras);

            ultimoEmpleadoSeleccionado = empleadoSeleccionado;
            ultimoPeriodoSeleccionado = periodoSeleccionado;
        }
    }//GEN-LAST:event_cboEmpleadoActionPerformed

    private void cboPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPeriodoActionPerformed
        String periodoSeleccionado = cboPeriodo.getSelectedItem().toString();
        String empleadoSeleccionado = cboEmpleado.getSelectedItem().toString();

        if (!periodoSeleccionado.equals(ultimoPeriodoSeleccionado) || !empleadoSeleccionado.equals(ultimoEmpleadoSeleccionado)) {
            actualizarEmpleadoSeleccionado();

            DatosAsistencia.RellenarTabla(tblAsistencias, cboPeriodo, cboEmpleado, txtTotalHoras);

            ultimoPeriodoSeleccionado = periodoSeleccionado;
            ultimoEmpleadoSeleccionado = empleadoSeleccionado;
        }
    }//GEN-LAST:event_cboPeriodoActionPerformed

    private int lastSelectedRow = -1; // Variable para guardar el índice de la última fila seleccionada
    private int lastSelectedColumn = -1; // Variable para guardar el índice de la última columna seleccionada
    private String[] datos = new String[3]; // Arreglo para almacenar los datos de la fila seleccionada
    private String[] horas = new String[2]; // Arreglo para almacenar las horas de entrada y salida

    private void tblAsistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsistenciasMouseClicked
        int selectedRow = tblAsistencias.getSelectedRow();
        int selectedColumn = tblAsistencias.getSelectedColumn();

        if (selectedRow != -1 && selectedRow != lastSelectedRow || selectedColumn != lastSelectedColumn) {
            lastSelectedRow = selectedRow;
            lastSelectedColumn = selectedColumn;
            datos = obtenerDatos();
            horas = obtenerHoras();
            
            String[] horario = {"Entrada", "Salida"};
            for (int i = 0; i < horas.length; i++) {
                System.out.println(horario[i] + ": " + horas[i]);
            }

            System.out.println("Dato[2]: " + datos[2]);

            a.setDni(datos[0]);
            a.setFecha(datos[1]);
        }
    }//GEN-LAST:event_tblAsistenciasMouseClicked

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getAbsolutePath();

            try {
                ImpAsistencias.importData(fileName);
            } catch (ParseException ex) {
                Logger.getLogger(frmAsistencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
            Exportar obj = new Exportar();
            obj.exportarExcel(tblAsistencias);
        } catch (IOException ex) {
            Logger.getLogger(frmAsistencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private String[] obtenerDatos() {
        int fila = tblAsistencias.getSelectedRow();
        String dni = lblDni.getText();
        String fecha = tblAsistencias.getValueAt(fila, 1).toString();
        String hora = tblAsistencias.getValueAt(lastSelectedRow, lastSelectedColumn) != null ? tblAsistencias.getModel().getValueAt(lastSelectedRow, lastSelectedColumn).toString() : "";
        return new String[]{dni, fecha, hora};
    }
    
    private String[] obtenerHoras() {
        int fila = tblAsistencias.getSelectedRow();
        String horaEntrada = tblAsistencias.getValueAt(fila, 2).toString();
        String horaSalida = tblAsistencias.getValueAt(fila, 3).toString();
        
        return new String[]{horaEntrada, horaSalida};
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnImportar;
    private javax.swing.JComboBox<String> cboEmpleado;
    private javax.swing.JComboBox<String> cboPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JTable tblAsistencias;
    private javax.swing.JTextField txtTotalHoras;
    // End of variables declaration//GEN-END:variables
}
