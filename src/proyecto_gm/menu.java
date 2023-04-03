package proyecto_gm;


import proyecto_gm.Instituciones.frmInstituciones;
import proyecto_gm.Tipo.frmTipo;
import proyecto_gm.Facultades.frmFacultades;
import proyecto_gm.Carreras.frmCarreras;
import proyecto_gm.Empleado.frmEmpleado;
import proyecto_gm.Cargo.frmCargo;

import proyecto_gm.Area.frmArea;
import proyecto_gm.CabeceraComprobante.frmCabeceraComprobante;
import proyecto_gm.Comunicacion.frmListaComunicacion;
import proyecto_gm.CabeceraComprobante.frmDetalleComprobante;
import proyecto_gm.Modulo.frmModulo;
import proyecto_gm.Proveedores.frmProveedores;
import proyecto_gm.TipoDocumento.frmTipoDocumento;



public class menu extends javax.swing.JFrame {

    
    public menu() {

        initComponents();
        setSize(1100, 700);
        this.setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuArea = new javax.swing.JMenuItem();
        menuCargo = new javax.swing.JMenuItem();
        menuEmpleado = new javax.swing.JMenuItem();
        menuTipo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuModulo = new javax.swing.JMenuItem();
        menuproveedores = new javax.swing.JMenuItem();
        menuTipoDocumento = new javax.swing.JMenuItem();
        menuComunicaciones = new javax.swing.JMenuItem();
        menuCabeceraComprobante = new javax.swing.JMenuItem();
        menuDetalleComprobante = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuRegistros = new javax.swing.JMenuItem();
        menuGastos = new javax.swing.JMenuItem();
        menuCampos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1114, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );

        jMenu1.setText("Mantenimiento");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuArea.setText("Area");
        menuArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAreaActionPerformed(evt);
            }
        });
        jMenu1.add(menuArea);

        menuCargo.setText("Cargo");
        menuCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCargoActionPerformed(evt);
            }
        });
        jMenu1.add(menuCargo);

        menuEmpleado.setText("Empleado");
        menuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(menuEmpleado);

        menuTipo.setText("Tipo de empleado");
        menuTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTipoActionPerformed(evt);
            }
        });
        jMenu1.add(menuTipo);

        jMenuItem1.setText("Instituciones");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Facultades");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Carreras");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        menuModulo.setText("Modulo");
        menuModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModuloActionPerformed(evt);
            }
        });
        jMenu1.add(menuModulo);

        menuproveedores.setText("Proveedores");
        menuproveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuproveedoresActionPerformed(evt);
            }
        });
        jMenu1.add(menuproveedores);

        menuTipoDocumento.setText("Tipo Documento");
        menuTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTipoDocumentoActionPerformed(evt);
            }
        });
        jMenu1.add(menuTipoDocumento);

        menuComunicaciones.setText("Comunicaciones");
        menuComunicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuComunicacionesActionPerformed(evt);
            }
        });
        jMenu1.add(menuComunicaciones);

        menuCabeceraComprobante.setText("Cabecera de Comprobante");
        menuCabeceraComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCabeceraComprobanteActionPerformed(evt);
            }
        });
        jMenu1.add(menuCabeceraComprobante);

        menuDetalleComprobante.setText("Detalle Comprobante");
        menuDetalleComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDetalleComprobanteActionPerformed(evt);
            }
        });
        jMenu1.add(menuDetalleComprobante);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Proceso");

        menuRegistros.setText("Registros");
        menuRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrosActionPerformed(evt);
            }
        });
        jMenu2.add(menuRegistros);

        menuGastos.setText("Gastos");
        menuGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGastosActionPerformed(evt);
            }
        });
        jMenu2.add(menuGastos);

        menuCampos.setText("Campos");
        menuCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCamposActionPerformed(evt);
            }
        });
        jMenu2.add(menuCampos);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmpleadoActionPerformed
        // TODO add your handling code here:
        frmEmpleado verventana = new frmEmpleado();
        escritorio.add(verventana);
        verventana.show();

    }//GEN-LAST:event_menuEmpleadoActionPerformed

    private void menuCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCargoActionPerformed
        // TODO add your handling code here:
        frmCargo verventana = new frmCargo();
        escritorio.add(verventana);
        verventana.show();
    }//GEN-LAST:event_menuCargoActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void menuAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAreaActionPerformed
        // TODO add your handling code here:
        frmArea verventana = new frmArea();
        escritorio.add(verventana);
        verventana.show();
    }//GEN-LAST:event_menuAreaActionPerformed

    private void menuRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuRegistrosActionPerformed

    private void menuGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGastosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuGastosActionPerformed

    private void menuCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCamposActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuCamposActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        frmCarreras verventana = new frmCarreras();
        escritorio.add(verventana);
        verventana.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTipoActionPerformed
        // TODO add your handling code here:
        frmTipo verventana = new frmTipo();
        escritorio.add(verventana);
        verventana.show();
    }//GEN-LAST:event_menuTipoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        frmInstituciones verventana = new frmInstituciones();
        escritorio.add(verventana);
        verventana.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        frmFacultades verventana = new frmFacultades();
        escritorio.add(verventana);
        verventana.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModuloActionPerformed
        // TODO add your handling code here:
        frmModulo verventana = new frmModulo();
        escritorio.add(verventana);
        verventana.show();
    }//GEN-LAST:event_menuModuloActionPerformed

    private void menuTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTipoDocumentoActionPerformed
        // TODO add your handling code here:
        frmTipoDocumento verventana = new frmTipoDocumento();
        escritorio.add(verventana);
        verventana.show();
    }//GEN-LAST:event_menuTipoDocumentoActionPerformed

    private void menuComunicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuComunicacionesActionPerformed
        frmListaComunicacion verventana = new frmListaComunicacion();
        escritorio.add(verventana);
        verventana.AsignarPadre(escritorio);
        verventana.show();
        
    }//GEN-LAST:event_menuComunicacionesActionPerformed

    private void menuproveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuproveedoresActionPerformed
        // TODO add your handling code here:
        frmProveedores verventana = new frmProveedores();
        escritorio.add(verventana);
        
        verventana.show();
    }//GEN-LAST:event_menuproveedoresActionPerformed

    private void menuCabeceraComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCabeceraComprobanteActionPerformed
        // TODO add your handling code here:
        frmCabeceraComprobante verventana = new frmCabeceraComprobante();
        escritorio.add(verventana);
        
        verventana.show();
    }//GEN-LAST:event_menuCabeceraComprobanteActionPerformed

    private void menuDetalleComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDetalleComprobanteActionPerformed
        // TODO add your handling code here:
//        frmDetalleComprobante verventana = new frmDetalleComprobante();
//        escritorio.add(verventana);
//        
//        verventana.show();
        
    }//GEN-LAST:event_menuDetalleComprobanteActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem menuArea;
    private javax.swing.JMenuItem menuCabeceraComprobante;
    private javax.swing.JMenuItem menuCampos;
    private javax.swing.JMenuItem menuCargo;
    private javax.swing.JMenuItem menuComunicaciones;
    private javax.swing.JMenuItem menuDetalleComprobante;
    private javax.swing.JMenuItem menuEmpleado;
    private javax.swing.JMenuItem menuGastos;
    private javax.swing.JMenuItem menuModulo;
    private javax.swing.JMenuItem menuRegistros;
    private javax.swing.JMenuItem menuTipo;
    private javax.swing.JMenuItem menuTipoDocumento;
    private javax.swing.JMenuItem menuproveedores;
    // End of variables declaration//GEN-END:variables
}
