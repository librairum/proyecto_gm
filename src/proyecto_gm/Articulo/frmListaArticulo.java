package proyecto_gm.Articulo;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.Utilitario;

public class frmListaArticulo extends javax.swing.JInternalFrame {
    
    private JDesktopPane panelPadre;

    public frmListaArticulo(JDesktopPane panelPadre) {
        initComponents();
        this.panelPadre = panelPadre;
        Cargar();
    }
    
    public frmListaArticulo() {
        initComponents();
        System.out.println("ADVERTENCIA: Usando constructor sin parámetros. Puede causar NullPointerException.");
        Cargar();
    }
    
    void Cargar() {
        String[] columnas = {"ID", "Categoría", "Marca", "Características", "Descripción", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        DatosArticulo.Mostrar(modelo);
        tblarticulo.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblarticulo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("ARTICULO");

        escritorio.setBackground(new java.awt.Color(255, 248, 239));

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

        tblarticulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdArticulo", "Categoria", "Marca", "Caracteristicas", "Descripcion", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tblarticulo);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(3, 3, 3)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(0, 492, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try {
            Articulo nuevo = new Articulo(); 
            frmArticulo frm = new frmArticulo(nuevo, Utilitario.EstadoProceso.NUEVO);
            this.getParent().add(frm); 
            frm.setVisible(true);
            frm.toFront();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al abrir formulario: " + e.getMessage());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            int fila = tblarticulo.getSelectedRow();
            if (fila < 0) {
                Utilitario.MostrarMensaje("Debe seleccionar un artículo", Utilitario.TipoMensaje.alerta);
                return;
            }

            DefaultTableModel modelo = (DefaultTableModel) tblarticulo.getModel();
            int filaModelo = tblarticulo.convertRowIndexToModel(fila);

            int idArticulo = Integer.parseInt(modelo.getValueAt(filaModelo, 0).toString());
            Articulo registro = DatosArticulo.obtenerArticuloPorId(idArticulo);

            if (registro == null) {
                Utilitario.MostrarMensaje("No se pudo cargar los datos del artículo seleccionado.", Utilitario.TipoMensaje.error);
                return;
            }

            frmArticulo frm = new frmArticulo(registro, Utilitario.EstadoProceso.EDITAR);

            this.getParent().add(frm);  
            frm.setVisible(true);
            frm.toFront();
            frm.setSelected(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al editar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tblarticulo.getSelectedRowCount() == 0) {
            Utilitario.MostrarMensaje("Debe seleccionar un registro a eliminar", Utilitario.TipoMensaje.alerta);
            return;
        }

        int indice = tblarticulo.getSelectedRow();
        Object idObj = tblarticulo.getValueAt(indice, 0);
        
        if (idObj == null) {
            Utilitario.MostrarMensaje("Error: ID del artículo no válido", Utilitario.TipoMensaje.error);
            return;
        }
        
        int id = Integer.parseInt(idObj.toString());

        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de eliminar este artículo?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            boolean estado = DatosArticulo.Eliminar(id);
            if (estado) {
                Cargar();
                Utilitario.MostrarMensaje("Registro eliminado correctamente", Utilitario.TipoMensaje.informativo);
            } else {
                Utilitario.MostrarMensaje("Error al eliminar el registro", Utilitario.TipoMensaje.error);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel escritorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblarticulo;
    // End of variables declaration//GEN-END:variables
}
