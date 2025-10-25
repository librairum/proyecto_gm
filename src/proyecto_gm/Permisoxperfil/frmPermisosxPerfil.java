package proyecto_gm.Permisoxperfil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import proyecto_gm.ConexionBD;
import proyecto_gm.Permisoxperfil.MenuArbol;
import proyecto_gm.Permisoxperfil.DatosPermisoxPerfil;
import proyecto_gm.Permisoxperfil.Perfil;

public class frmPermisosxPerfil extends javax.swing.JInternalFrame {

public frmPermisosxPerfil() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboPerfil = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        trvMenusTodo = new javax.swing.JTree();
        btnAgregar = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        trvMenuSeleccionado = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Permisos por perfil");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Seleccione el perfil para la configuracion de permisos");

        cboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Sistemas", "RH", " " }));
        cboPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPerfilActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Menus");
        trvMenusTodo.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(trvMenusTodo);

        btnAgregar.setText(">>");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnRetirar.setText("<<");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Menus Habilitados");
        trvMenuSeleccionado.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(trvMenuSeleccionado);

        jLabel2.setText("Al presionar el boton  \">>\" o \"<<\"  se guardar los cambios de permiso automaticamente");

        jLabel3.setText("Lista general de menu");

        jLabel4.setText("Lista de menu configurado por perfil");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cboPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRetirar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(134, 134, 134)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRetirar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 124, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(12, 12, 12)))
                .addComponent(jLabel2)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
    limpiar();
    CargarPerfiles();  
    CargarMenuTodo(); 
      
    
    }//GEN-LAST:event_formInternalFrameOpened

    private void cboPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPerfilActionPerformed
  int indice = cboPerfil.getSelectedIndex();
    if (indice < 0) return; 

    Perfil perfil = listaPerfiles.get(indice); // obtenemos el objeto real
    String codPerfil = perfil.getCodigo();

    DatosPermisoxPerfil datos = new DatosPermisoxPerfil();

    DefaultTreeModel modelo = (DefaultTreeModel) trvMenuSeleccionado.getModel();
    DefaultMutableTreeNode root = (DefaultMutableTreeNode) modelo.getRoot();
    root.removeAllChildren();

    List<MenuArbol> lista = datos.listarMenusPorPerfil(codPerfil);
    for (MenuArbol menu : lista) {
        root.add(new DefaultMutableTreeNode(menu));
    }

    modelo.reload(root);
    }//GEN-LAST:event_cboPerfilActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
   // --- Validar selección en árbol de menús disponibles ---
    TreePath path = trvMenusTodo.getSelectionPath();
    if (path == null) {
        JOptionPane.showMessageDialog(this, "Seleccione un menú para agregar.");
        return;
    }

    DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) path.getLastPathComponent();
    if (!(nodoSeleccionado.getUserObject() instanceof MenuArbol)) return;

    MenuArbol menu = (MenuArbol) nodoSeleccionado.getUserObject();

    // --- Obtener perfil seleccionado desde la lista auxiliar ---
    int indice = cboPerfil.getSelectedIndex();
    if (indice < 0) return;
    Perfil perfil = listaPerfiles.get(indice);

    // --- Insertar el permiso ---
    DatosPermisoxPerfil datos = new DatosPermisoxPerfil();
    boolean exito = datos.insertarMenuPerfil(perfil.getCodigo(), menu.getCodigo());

    if (exito) {
        JOptionPane.showMessageDialog(this, "Menú agregado correctamente.");
        cboPerfilActionPerformed(null); // recarga los menús del perfil
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo agregar el menú.");
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
    // --- Validar selección en árbol de menús asignados ---
    TreePath path = trvMenuSeleccionado.getSelectionPath();
    if (path == null) {
        JOptionPane.showMessageDialog(this, "Seleccione un menú para retirar.");
        return;
    }

    DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) path.getLastPathComponent();
    if (!(nodoSeleccionado.getUserObject() instanceof MenuArbol)) return;

    MenuArbol menu = (MenuArbol) nodoSeleccionado.getUserObject();

    // --- Obtener perfil seleccionado desde la lista auxiliar ---
    int indice = cboPerfil.getSelectedIndex();
    if (indice < 0) return;
    Perfil perfil = listaPerfiles.get(indice);

    // --- Eliminar el permiso ---
    DatosPermisoxPerfil datos = new DatosPermisoxPerfil();
    boolean exito = datos.eliminarMenuPerfil(perfil.getCodigo(), menu.getCodigo());


    if (exito) {
        JOptionPane.showMessageDialog(this, "Menú retirado correctamente.");
        cboPerfilActionPerformed(null); // recarga los menús
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo retirar el menú.");
    }
    }//GEN-LAST:event_btnRetirarActionPerformed
    private void limpiar() {
    DefaultTreeModel modelo = (DefaultTreeModel) this.trvMenusTodo.getModel();
    DefaultMutableTreeNode root = (DefaultMutableTreeNode) modelo.getRoot();
    root.removeAllChildren();

    DefaultTreeModel modeloSeleccionado = (DefaultTreeModel) this.trvMenuSeleccionado.getModel();
    DefaultMutableTreeNode raizSeleccionado = (DefaultMutableTreeNode) modeloSeleccionado.getRoot();
    raizSeleccionado.removeAllChildren();

    modelo.reload(root);
    modeloSeleccionado.reload(raizSeleccionado);
}

    private void CargarPerfiles() {
    DatosPermisoxPerfil datos = new DatosPermisoxPerfil();
    listaPerfiles = datos.listarPerfiles(); // Guarda todos los perfiles

    cboPerfil.removeAllItems();
    for (Perfil perfil : listaPerfiles) {
        cboPerfil.addItem(perfil.getNombre()); //  muestra el nombre
    }
}



    private void CargarMenuTodo() {
    DefaultTreeModel modelo = (DefaultTreeModel) trvMenusTodo.getModel();
    DefaultMutableTreeNode root = (DefaultMutableTreeNode) modelo.getRoot();
    root.removeAllChildren();

    DatosPermisoxPerfil datos = new DatosPermisoxPerfil();
    List<MenuArbol> lista = datos.listarMenus();

    // Crear árbol por niveles
    for (MenuArbol item1 : lista) {
        if (item1.getNivel2().equals("00") && item1.getNivel3().equals("00")) {
            DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode(item1);

            // Nivel 2
            for (MenuArbol item2 : lista) {
                if (item2.getNivel1().equals(item1.getNivel1()) && 
                    !item2.getNivel2().equals("00") && 
                    item2.getNivel3().equals("00")) {

                    DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode(item2);

                    // Nivel 3
                    for (MenuArbol item3 : lista) {
                        if (item3.getNivel1().equals(item1.getNivel1()) &&
                            item3.getNivel2().equals(item2.getNivel2()) &&
                            !item3.getNivel3().equals("00")) {
                            nodo2.add(new DefaultMutableTreeNode(item3));
                        }
                    }

                    nodo1.add(nodo2);
                }
            }

            root.add(nodo1);
        }
    }

    modelo.reload(root);
}
private List<Perfil> listaPerfiles = new ArrayList<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JComboBox<String> cboPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree trvMenuSeleccionado;
    private javax.swing.JTree trvMenusTodo;
    // End of variables declaration//GEN-END:variables
}
