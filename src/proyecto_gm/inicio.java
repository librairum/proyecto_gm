/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_gm;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import java.sql.CallableStatement;
import java.util.Locale;


/**
 *
 * @author Mariluz
 */
public class inicio extends javax.swing.JFrame {

    int intentos;

    public inicio() {

        initComponents();

    }
    static Connection conn = ConexionBD.getConnection();

    public void ingresar() {
        PreparedStatement pst = null;
        ResultSet rs = null;

        String User = txtusuario.getText();
        String Pass = txtcontrasena.getText();
        menu contenedor = new menu();

        if (User.equals("") || Pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Llenar completamente los campos");
        } else {
            try {
                // Llamada al procedimiento almacenado
                pst = conn.prepareStatement("CALL validar_usuario(?, ?)");
                pst.setString(1, User);
                pst.setString(2, Pass);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String resultado = rs.getString("resultado");

                    switch (resultado) {
                        case "ACCESO PERMITIDO":
                            this.dispose();
                            contenedor.setExtendedState(Frame.MAXIMIZED_BOTH);
                            contenedor.setVisible(true);
                            break;
                        case "ACCESO DENEGADO":
                            JOptionPane.showMessageDialog(this, "Usuario inactivo. Contacte al administrador.");
                            break;
                        case "USUARIO NO ENCONTRADO":
                            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta, vuelva a intentarlo.");
                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "Error desconocido en validación.");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Error al procesar la respuesta del procedimiento.");
                }

            } catch (SQLException e) {
                System.err.println("Error en ingresar(): " + e.toString());
                JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuario = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtcontrasena = new javax.swing.JPasswordField();
        contraseña = new javax.swing.JLabel();
        btningresar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GM SISTEMAS");
        setBackground(new java.awt.Color(0, 0, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(280, 130));
        setMinimumSize(new java.awt.Dimension(290, 140));
        setPreferredSize(new java.awt.Dimension(280, 130));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        usuario.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        usuario.setText("usuario:");
        getContentPane().add(usuario);
        usuario.setBounds(30, 20, 50, 20);

        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtusuario);
        txtusuario.setBounds(90, 10, 170, 30);

        txtcontrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontrasenaActionPerformed(evt);
            }
        });
        txtcontrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcontrasenaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontrasenaKeyTyped(evt);
            }
        });
        getContentPane().add(txtcontrasena);
        txtcontrasena.setBounds(90, 40, 170, 30);

        contraseña.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        contraseña.setText("contraseña:");
        getContentPane().add(contraseña);
        contraseña.setBounds(20, 50, 61, 17);

        btningresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btningresar.setText("INGRESAR");
        btningresar.setMaximumSize(new java.awt.Dimension(200, 28));
        btningresar.setMinimumSize(new java.awt.Dimension(90, 28));
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        getContentPane().add(btningresar);
        btningresar.setBounds(90, 70, 100, 26);

        btnsalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir);
        btnsalir.setBounds(190, 70, 71, 26);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcontrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontrasenaActionPerformed

    }//GEN-LAST:event_txtcontrasenaActionPerformed
    void TraerPerfil(String nombreUsuario){
        try{
          CallableStatement cstmt =  conn.prepareCall("call listar_perfilxusuario(?,?)");
            cstmt.setString(1, "01");
            cstmt.setString(2, nombreUsuario);
           ResultSet rs = cstmt.executeQuery();
           while(rs.next()){
             ConexionBD.codPerfil=  rs.getString("codperfil");
             ConexionBD.nomPerfil = rs.getString("nomperfil");
               System.out.println("Menu inicio, Codigo perfil:" + ConexionBD.codPerfil);
           }
        }catch(SQLException exSQL){
             JOptionPane.showMessageDialog(null,exSQL.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        // TODO add your handling code here:
        TraerPerfil(this.txtusuario.getText());
        ConexionBD.nomUsuario = txtusuario.getText();
        ingresar();
    }//GEN-LAST:event_btningresarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        // TODO add your handling code here:
        if (txtusuario.getText().length() == 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtcontrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasenaKeyTyped
        // TODO add your handling code here:
        if (txtcontrasena.getText().length() == 20) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtcontrasenaKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.txtusuario.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void txtcontrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontrasenaKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            TraerPerfil(this.txtusuario.getText());
        ConexionBD.nomUsuario = txtusuario.getText();
        ingresar();
        }
    }//GEN-LAST:event_txtcontrasenaKeyPressed

    private void txtusuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            txtcontrasena.requestFocus();
        }
    }//GEN-LAST:event_txtusuarioKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new inicio().setVisible(true);
                try {
                    Locale.setDefault(new Locale("es", "ES"));
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    
                    new inicio().show();
                } catch (Exception e) {

                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel contraseña;
    private javax.swing.JPasswordField txtcontrasena;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
