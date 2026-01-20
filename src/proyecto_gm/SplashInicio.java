/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_gm;

import Actualizador.Actualizador;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
public class SplashInicio extends javax.swing.JFrame {

    /**
     * Creates new form SplashInicio
     */
    public SplashInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        new Thread(() -> verificarUpdate()).start();
    }



    
   private void verificarUpdate() {
        try {
            Actualizador act = new Actualizador();
            String resultado = act.comprobarNuevaVersion();

            SwingUtilities.invokeLater(() -> {
                if ("ERROR_SERVIDOR".equals(resultado)) {
                    JOptionPane.showMessageDialog(this, 
                        "Error: Se ha caído el servidor", 
                        "Error de Servidor", 
                        JOptionPane.ERROR_MESSAGE);
                    irAlLogin();
                } else if ("ERROR_CONEXION".equals(resultado)) {
                    JOptionPane.showMessageDialog(this, 
                        "Error de conexión", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    irAlLogin();
                } else if (resultado != null) {
                    this.setVisible(true);
                    
                    String[] partes = resultado.split("\\|");
                    String verNueva = partes[0];
                    String json = partes[1];

                    int resp = JOptionPane.showConfirmDialog(this, 
                            "Versión " + verNueva + " disponible.\n¿Desea actualizar ahora?", 
                            "Actualización Sistema GM", 
                            JOptionPane.YES_NO_OPTION);

                    if (resp == JOptionPane.YES_OPTION) {
                        this.dispose();
                        new SplashFinal(json, verNueva).setVisible(true);
                    } else {
                        irAlLogin();
                    }
                } else {
                    irAlLogin();
                }
            });
        } catch (Exception e) {
            SwingUtilities.invokeLater(() -> irAlLogin());
        }
    }

    private void irAlLogin() {
        this.dispose();
        new inicio().setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("ACTUALIZADOR");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-ingeniero-100.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("GM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) { 
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // SOLO INSTANCIAR, NO MOSTRAR
                new SplashInicio(); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
