package proyecto_gm.RecibosHonorarios;

import java.util.Date;
import javax.swing.*;

public class frmRecibosHonorarios extends javax.swing.JInternalFrame {
    
    private frmListaRecibosHonorarios lista;

    // Constructor por defecto (para nuevo registro)
    public frmRecibosHonorarios(frmListaRecibosHonorarios lista) {
        initComponents();
        cargarCombos();
        this.lista = lista;
    }
    
    // Constructor para editar registro existente
    public frmRecibosHonorarios(frmListaRecibosHonorarios lista, ReciboHonorario rh) {
        initComponents();
        cargarCombos();
        this.lista = lista;

        // Llenar campos con el objeto recibido
        txtId.setText(rh.getCodigoRecibo());
        txtNroRecibo.setText(rh.getNroRecibo());
        txtRuc.setText(rh.getRuc());
        txtNom.setText(rh.getNombres());
        txtApe.setText(rh.getApellidos());
        txtDirec.setText(rh.getDireccion());
        cboDistrito.setSelectedItem(rh.getDistrito());
        cboPago.setSelectedItem(rh.getFormaPago());
        txtConcepto.setText(rh.getConcepto());
        txtImpNeto.setText(String.valueOf(rh.getImporteNeto()));
        txtIR.setText(String.valueOf(rh.getRetencionIr()));
        txtImpTotal.setText(String.valueOf(rh.getImporteTotal()));
        jDateChooser1.setDate(rh.getFecha());
    }

    private void cargarCombos() {
        // Distritos
        String[] distritos = {
            "<<Seleccionar>>","Ancón","Ate","Barranco","Breña","Carabayllo","Chaclacayo","Chorrillos",
            "Cieneguilla","Comas","El Agustino","Independencia","Jesús María","La Molina","La Victoria",
            "Lima","Lince","Los Olivos","Lurigancho","Lurin","Magdalena del Mar","Miraflores","Pachacamac",
            "Pucusana","Pueblo Libre","Puente Piedra","Punta Hermosa","Punta Negra","Rímac","San Bartolo",
            "San Borja","San Isidro","San Juan de Lurigancho","San Juan de Miraflores","San Luis","San Martín de Porres",
            "San Miguel","Santa Anita","Santa María del Mar","Santa Rosa","Santiago de Surco","Surquillo",
            "Villa El Salvador","Villa María del Triunfo"
        };
        for (String d : distritos) cboDistrito.addItem(d);

        // Formas de pago
        String[] pagos = {"<<Seleccionar>>","Transferencia","Al contado"};
        for (String p : pagos) cboPago.addItem(p);
    }
    
    // Método para calcular importe total
    private void calcularImporteTotal() {
        try {
            float neto = Float.parseFloat(txtImpNeto.getText().isEmpty() ? "0" : txtImpNeto.getText());
            float ir = Float.parseFloat(txtIR.getText().isEmpty() ? "0" : txtIR.getText());
            txtImpTotal.setText(String.valueOf(Math.round((neto - ir) * 100f) / 100f));
        } catch (NumberFormatException e) {
            txtImpTotal.setText("0.00");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNroRecibo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDirec = new javax.swing.JTextField();
        txtIR = new javax.swing.JTextField();
        txtConcepto = new javax.swing.JTextField();
        cboPago = new javax.swing.JComboBox<>();
        cboDistrito = new javax.swing.JComboBox<>();
        txtImpNeto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtImpTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setTitle("Formulario Recibos Honorarios");

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel4.setText("RUC:");

        jLabel5.setText("Dirección:");

        jLabel13.setText("Fec. Emisión:");

        jLabel6.setText("Distrito:");

        txtNroRecibo.setActionCommand("<Not Set>");
        txtNroRecibo.setFocusCycleRoot(true);
        txtNroRecibo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroReciboKeyTyped(evt);
            }
        });

        jLabel7.setText("Apellidos:");

        txtId.setEnabled(false);

        txtRuc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRucFocusLost(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        txtApe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApeFocusLost(evt);
            }
        });

        txtNom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomFocusLost(evt);
            }
        });

        jLabel8.setText("Concepto:");

        jLabel9.setText("Forma de pago:");

        jLabel10.setText("Importe Neto:");

        jLabel11.setText("Retención IR:");

        txtDirec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDirecFocusLost(evt);
            }
        });

        txtIR.setEnabled(false);
        txtIR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIRFocusLost(evt);
            }
        });
        txtIR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIRKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIRKeyTyped(evt);
            }
        });

        cboPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        cboDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {

        }));

        txtImpNeto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtImpNetoFocusLost(evt);
            }
        });
        txtImpNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImpNetoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtImpNetoKeyTyped(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel12.setText("Importe Total:");

        txtImpTotal.setEditable(false);
        txtImpTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImpTotalKeyReleased(evt);
            }
        });

        jLabel2.setText("Nro. Recibo:");

        jLabel3.setText("Nombres:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnGuardar)
                .addGap(35, 35, 35)
                .addComponent(btnLimpiar)
                .addGap(37, 37, 37)
                .addComponent(btnRegresar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNom, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(txtNroRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApe))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtImpNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboDistrito, 0, 160, Short.MAX_VALUE)
                                    .addComponent(cboPago, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDirec))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIR, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtImpTotal))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnRegresar))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNroRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cboPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtImpTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtImpNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNroReciboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroReciboKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && !Character.isISOControl(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNroReciboKeyTyped

    private void txtRucFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRucFocusLost
        String ruc = txtRuc.getText().trim();
        txtRuc.setText(ruc);

        if (!ruc.isEmpty() && ruc.length() != 11) {
            JOptionPane.showMessageDialog(null, "El RUC debe contener 11 dígitos.");
            txtRuc.requestFocus(); // vuelve al campo
        }
    }//GEN-LAST:event_txtRucFocusLost

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        char c = evt.getKeyChar();

        // Solo números, backspace y delete
        if (!Character.isDigit(c) && c != evt.VK_BACK_SPACE && c != evt.VK_DELETE) {
            evt.consume();
        }

        // Máximo 11 dígitos
        if (txtRuc.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtApeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApeFocusLost
        txtApe.setText(txtApe.getText().trim());
    }//GEN-LAST:event_txtApeFocusLost

    private void txtNomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomFocusLost
        txtNom.setText(txtNom.getText().trim());
    }//GEN-LAST:event_txtNomFocusLost

    private void txtDirecFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirecFocusLost
        txtDirec.setText(txtDirec.getText().trim());
    }//GEN-LAST:event_txtDirecFocusLost

    private void txtIRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIRFocusLost
        if (txtIR.getText().isEmpty()) txtIR.setText("0.00");
        calcularImporteTotal();
    }//GEN-LAST:event_txtIRFocusLost

    private void txtIRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIRKeyTyped
        char c = evt.getKeyChar();
        String text = txtIR.getText();

        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume();
        } else if (c == '.' && text.contains(".")) {
            evt.consume();
        } else if (text.contains(".") && text.length() - text.indexOf(".") > 2) {
            evt.consume();
        } else if (text.equals("0") && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txtIRKeyTyped

    private void txtImpNetoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImpNetoFocusLost
        String impBruto = txtImpNeto.getText();
        if (impBruto.isEmpty()) {
            impBruto = "0.00";
            txtImpNeto.setText(impBruto);
        }
        float rentaBruta = Float.parseFloat(impBruto);
        float ir = Math.round(rentaBruta * 0.08f * 100.0f) / 100.0f;
        txtIR.setText(String.valueOf(ir));

        // Actualizar total correctamente
        calcularImporteTotal();
    }//GEN-LAST:event_txtImpNetoFocusLost

    private void txtImpNetoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImpNetoKeyTyped
        char c = evt.getKeyChar();
        String text = txtImpNeto.getText();

        if (Character.isISOControl(c)) return;

        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume();
            return;
        }
        if (c == '.' && text.contains(".")) {
            evt.consume();
            return;
        }
        if (text.contains(".")) {
            int index = text.indexOf(".");
            int decimals = text.length() - index - 1;
            if (txtImpNeto.getCaretPosition() > index && decimals >= 2) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtImpNetoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         // Validar campos
        JTextField[] campos = {txtRuc, txtNom, txtApe, txtDirec, txtConcepto, txtImpNeto, txtIR, txtImpTotal};
        JComboBox[] combos = {cboDistrito, cboPago};
        if (!DatosRecibosHonorarios.Validar(campos, combos)) return;

        // Crear objeto ReciboHonorario
        ReciboHonorario rh = new ReciboHonorario();
        rh.setCodigoRecibo(txtId.getText().trim());
        rh.setNroRecibo(txtNroRecibo.getText());
        rh.setRuc(txtRuc.getText());
        rh.setNombres(txtNom.getText());
        rh.setApellidos(txtApe.getText());
        rh.setDistrito(cboDistrito.getSelectedItem().toString());
        rh.setDireccion(txtDirec.getText());
        rh.setFormaPago(cboPago.getSelectedItem().toString());
        rh.setConcepto(txtConcepto.getText());
        rh.setImporteNeto(Float.parseFloat(txtImpNeto.getText()));
        rh.setRetencionIr(Float.parseFloat(txtIR.getText()));
        rh.setImporteTotal(Float.parseFloat(txtImpTotal.getText()));
        Date fecha = jDateChooser1.getDate();
        if (fecha != null) rh.setFecha(new java.sql.Date(fecha.getTime()));

        // Guardar o actualizar
        if (txtId.getText() == null || txtId.getText().trim().isEmpty()) {
            DatosRecibosHonorarios.Insertar(rh, lista.getTabla());
        } else {
            rh.setCodigoRecibo(txtId.getText()); // asegúrate de asignarlo
            DatosRecibosHonorarios.Actualizar(rh, lista.getTabla());
        }


        // Refrescar tabla en listado y cerrar ventana
        lista.mostrarDatos();
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtId.setText("");
        txtNroRecibo.setText("");
        txtRuc.setText("");
        txtNom.setText("");
        txtApe.setText("");
        txtDirec.setText("");
        cboDistrito.setSelectedIndex(-1);
        txtConcepto.setText("");
        txtImpNeto.setText("");
        txtIR.setText("");
        txtImpTotal.setText("");
        cboPago.setSelectedIndex(-1);
        jDateChooser1.setDate(null);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtImpTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImpTotalKeyReleased
        calcularImporteTotal();
    }//GEN-LAST:event_txtImpTotalKeyReleased

    private void txtIRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIRKeyReleased
        calcularImporteTotal();
    }//GEN-LAST:event_txtIRKeyReleased

    private void txtImpNetoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImpNetoKeyReleased
        calcularImporteTotal();
    }//GEN-LAST:event_txtImpNetoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cboDistrito;
    private javax.swing.JComboBox<String> cboPago;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtConcepto;
    private javax.swing.JTextField txtDirec;
    private javax.swing.JTextField txtIR;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtImpNeto;
    private javax.swing.JTextField txtImpTotal;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNroRecibo;
    private javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
