/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyecto_gm.Viaticos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import proyecto_gm.ConexionBD;

/**
 *
 * @author jeanv
 */
public class frmViaticos extends javax.swing.JInternalFrame {

    static Connection conn = ConexionBD.getConnection();

    boolean esNuevo = false;

    /**
     * Creates new form frmViaticos
     */
    public frmViaticos() {
        initComponents();
        // Personalizar header
        JTableHeader header = tblViatico.getTableHeader();
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

        DefaultTableModel modelo = (DefaultTableModel) tblViatico.getModel();
        DatosViaticos.CargarCombos(cboEmpleado, cboPeriodo);
        DatosViaticos.Listar(modelo);
        DatosViaticos.Habilitar(escritorio, false);
        // Quitar la edicion de las celdas
        tblViatico.setCellSelectionEnabled(false);
        // Poder seleccionar fila(s) de la tabla
        tblViatico.setRowSelectionAllowed(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPasaje = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMenu = new javax.swing.JTextField();
        cboPeriodo = new javax.swing.JComboBox<>();
        cboEmpleado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViatico = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("VIATICOS");
        setPreferredSize(new java.awt.Dimension(660, 395));

        escritorio.setBackground(new java.awt.Color(255, 248, 239));

        jLabel1.setText("ID:");

        txtId.setName("id"); // NOI18N

        jLabel2.setText("DESCRIPCIÓN:");

        txtDescripcion.setName("descripcion"); // NOI18N
        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });

        jLabel3.setText("PASAJE:");

        txtPasaje.setName("pasaje"); // NOI18N
        txtPasaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasajeKeyTyped(evt);
            }
        });

        jLabel4.setText("EMPLEADO:");

        jLabel5.setText("PERIODO:");

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

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.setName("guardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnCancelar.setName("cancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("MENÚ:");

        txtMenu.setName("menu"); // NOI18N
        txtMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMenuKeyTyped(evt);
            }
        });

        tblViatico.setBackground(new java.awt.Color(255, 255, 255));
        tblViatico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCIÓN", "PASAJE", "MENÚ", "EMPLEADO", "PERIODO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblViatico.setFocusable(false);
        tblViatico.setRowHeight(25);
        tblViatico.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblViatico.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblViatico.setShowGrid(true);
        tblViatico.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblViatico);
        if (tblViatico.getColumnModel().getColumnCount() > 0) {
            tblViatico.getColumnModel().getColumn(0).setResizable(false);
            tblViatico.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblViatico.getColumnModel().getColumn(1).setResizable(false);
            tblViatico.getColumnModel().getColumn(1).setPreferredWidth(210);
            tblViatico.getColumnModel().getColumn(2).setResizable(false);
            tblViatico.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblViatico.getColumnModel().getColumn(3).setResizable(false);
            tblViatico.getColumnModel().getColumn(3).setPreferredWidth(40);
            tblViatico.getColumnModel().getColumn(4).setResizable(false);
            tblViatico.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblViatico.getColumnModel().getColumn(5).setResizable(false);
            tblViatico.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNuevo)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEditar)
                        .addComponent(btnEliminar)
                        .addComponent(btnGuardar)
                        .addComponent(btnCancelar)))
                .addGap(26, 26, 26)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
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
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tblViatico.clearSelection();
        tblViatico.setRowSelectionAllowed(false);
        // Habilitamos los campos:
        DatosViaticos.Habilitar(escritorio, true);
        // Bloquemos ID
        txtId.setEnabled(false);
        // Ponemos el foco en descripcion
        txtDescripcion.requestFocus();
        esNuevo = true; // Indicamos que sera un nuevo registro
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // IMPORTANTE: Al presionar en "Editar", txtId quedará deshabilitado.
        // Lo habilitaremos al presionar "Guardar".

        JTextField[] cajas = {txtId, txtDescripcion, txtPasaje, txtMenu};
        DatosViaticos.Editar(escritorio, tblViatico, cajas, cboEmpleado, cboPeriodo);
        esNuevo = false;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Eliminamos el registro seleccionado
        DatosViaticos.Eliminar(tblViatico);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Seleccionamos todas las cajas
        JTextField[] campos = {txtDescripcion, txtPasaje, txtMenu};
        
        // Validamos que todos los campos estén llenos
        if (!DatosViaticos.Validar(campos)) {
            return;
        }

        // Validamos que se haya seleccionado un empleado y un periodo
        JComboBox[] combos = {cboEmpleado, cboPeriodo};
        for (JComboBox combo : combos) {
            if (combo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(
                        null, "Debe escoger un empleado y un periodo.", "Advertencia", JOptionPane.WARNING_MESSAGE
                );
                combo.requestFocus();
                return;
            }
        }

        String periodo = cboPeriodo.getSelectedItem().toString();
        String idEmpleado = ObtenerIdEmpleado(cboEmpleado.getSelectedItem().toString());

        Viaticos viatico = new Viaticos();
        viatico.setDescripcion(txtDescripcion.getText());
        viatico.setEmpleado(idEmpleado);
        viatico.setPeriodo(periodo);
        viatico.setPasaje(Float.parseFloat(txtPasaje.getText()));
        viatico.setMenu(Float.parseFloat(txtMenu.getText()));

        if (esNuevo) {
            DatosViaticos.Insertar(viatico, tblViatico);
        } else if (!esNuevo) {
            viatico.setId(Integer.parseInt(txtId.getText()));
            DatosViaticos.Actualizar(viatico, tblViatico);
        }

        DatosViaticos.Limpiar(escritorio);
        DatosViaticos.Habilitar(escritorio, false);
        tblViatico.clearSelection();
        tblViatico.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private String ObtenerIdEmpleado(String empleado) {
        String idEmpleado = "";
        String consulta = "SELECT Id FROM empleados WHERE Nombres = ?";
        try ( PreparedStatement pstmt = conn.prepareStatement(consulta)) {
            pstmt.setString(1, empleado);
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    idEmpleado = rs.getString("Id");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al obtener el ID del empleado", JOptionPane.ERROR_MESSAGE);
        }
        return idEmpleado;
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        DatosViaticos.Limpiar(escritorio);
        DatosViaticos.Habilitar(escritorio, false);
        tblViatico.clearSelection();
        tblViatico.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPasajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasajeKeyTyped
        char c = evt.getKeyChar();
        String text = txtPasaje.getText();

        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume(); // Si no es un número o un punto, se ignora el evento de tecla
        } else if (c == '.' && text.contains(".")) {
            evt.consume(); // Si el carácter ingresado es un punto y ya hay un punto en el campo de texto, se ignora el evento de tecla
        } else if (text.contains(".") && text.length() - text.indexOf(".") > 2) {
            evt.consume(); // Si ya hay dos decimales en el campo de texto, se ignora el evento de tecla
        } else if (text.equals("0") && c != '.') {
            evt.consume(); // Si el primer carácter es 0 y el siguiente carácter no es un punto, se ignora el evento de tecla
        }
    }//GEN-LAST:event_txtPasajeKeyTyped

    private void txtMenuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMenuKeyTyped
        char c = evt.getKeyChar();
        String text = txtMenu.getText();

        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume(); // Si no es un número o un punto, se ignora el evento de tecla
        } else if (c == '.' && text.contains(".")) {
            evt.consume(); // Si el carácter ingresado es un punto y ya hay un punto en el campo de texto, se ignora el evento de tecla
        } else if (text.contains(".") && text.length() - text.indexOf(".") > 2) {
            evt.consume(); // Si ya hay dos decimales en el campo de texto, se ignora el evento de tecla
        } else if (text.equals("0") && c != '.') {
            evt.consume(); // Si el primer carácter es 0 y el siguiente carácter no es un punto, se ignora el evento de tecla
        }
    }//GEN-LAST:event_txtMenuKeyTyped

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost
        // TODO add your handling code here:
        String text = txtDescripcion.getText().trim();
        txtDescripcion.setText(text);
    }//GEN-LAST:event_txtDescripcionFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboEmpleado;
    private javax.swing.JComboBox<String> cboPeriodo;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblViatico;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMenu;
    private javax.swing.JTextField txtPasaje;
    // End of variables declaration//GEN-END:variables
}
