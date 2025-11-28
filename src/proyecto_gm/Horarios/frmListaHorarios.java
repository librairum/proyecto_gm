package proyecto_gm.Horarios;

import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import proyecto_gm.Empleado.DatosEmpleados;
import proyecto_gm.Empleado.Empleados;

public class frmListaHorarios extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    List<Horarios> listaHorarios;
    TableRowSorter<DefaultTableModel> sorter;

    public frmListaHorarios() {
        initComponents();

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Celular");
        modelo.addColumn("Lunes (HE-HS)");
        modelo.addColumn("Martes (HE-HS)");
        modelo.addColumn("Miércoles (HE-HS)");
        modelo.addColumn("Jueves (HE-HS)");
        modelo.addColumn("Viernes (HE-HS)");
        modelo.addColumn("Sábado (HE-HS)");
        modelo.addColumn("Domingo (HE-HS)");
        tblHorario.setModel(modelo);

        sorter = new TableRowSorter<>(modelo);
        tblHorario.setRowSorter(sorter);

        cargarDatos();
    }

    public void cargarDatos() {
        modelo.setRowCount(0);
        listaHorarios = DatosHorarios.listar();

        for (Horarios h : listaHorarios) {
            modelo.addRow(new Object[]{
                h.getIdhorario(),
                h.getDni(),
                h.getCelular(),
                h.getLunes_he() + " - " + h.getLunes_hs(),
                h.getMartes_he() + " - " + h.getMartes_hs(),
                h.getMiercoles_he() + " - " + h.getMiercoles_hs(),
                h.getJueves_he() + " - " + h.getJueves_hs(),
                h.getViernes_he() + " - " + h.getViernes_hs(),
                h.getSabado_he() + " - " + h.getSabado_hs(),
                h.getDomingo_he() + " - " + h.getDomingo_hs()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("HORARIOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla"));

        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "TELEFONO", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"
            }
        ));
        jScrollPane1.setViewportView(tblHorario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(949, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        List<Empleados> empleados = DatosEmpleados.listar();

        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay empleados registrados.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] opciones = empleados.stream()
                .map(e -> e.getDni() + " - " + e.getNombres() + " " + e.getApellidos())
                .toArray(String[]::new);

        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Selecciona un empleado:",
                "Asignar Horario",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (seleccion != null) {
            String dniSeleccionado = seleccion.split(" - ")[0];
            Empleados empSeleccionado = empleados.stream()
                    .filter(e -> e.getDni().equals(dniSeleccionado))
                    .findFirst().orElse(null);

            if (empSeleccionado != null) {
                frmHorarios frm = new frmHorarios(this, empSeleccionado, null);
                JDesktopPane desktopPane = getDesktopPane();
                desktopPane.add(frm);
                frm.setVisible(true);
            }
        }                       
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblHorario.getSelectedRow();
        if (fila >= 0) {
            Horarios seleccionado = listaHorarios.get(tblHorario.convertRowIndexToModel(fila));

            Empleados emp = DatosEmpleados.buscarPorDni(seleccionado.getDni());
            if (emp == null) {
                JOptionPane.showMessageDialog(this, "No se encontró el empleado vinculado a este horario.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            frmHorarios frm = new frmHorarios(this, emp, seleccionado);
            JDesktopPane desktopPane = getDesktopPane();
            desktopPane.add(frm);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un horario para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblHorario.getSelectedRow();
        if (fila >= 0) {
            Horarios seleccionado = listaHorarios.get(tblHorario.convertRowIndexToModel(fila));

            int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Seguro que deseas eliminar el horario de este empleado?", 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                DatosHorarios.eliminar(seleccionado.getIdhorario());
                cargarDatos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un horario para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHorario;
    // End of variables declaration//GEN-END:variables
}
