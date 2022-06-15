package ads.pkg2019.agenda2.gui;

import ads.pkg2019.agenda2.dao.AuthenticationDAO;
import ads.pkg2019.agenda2.dao.UserDAO;
import ads.pkg2019.agenda2.entity.User;
import java.awt.Dialog;

import javax.swing.JOptionPane;


public class New extends javax.swing.JFrame {

    private String state; // start, select, edit, delet, new; 
    private boolean namet = false, logint = false, emailt = false, passt = false; //if the field is empty
    private boolean passk = false; //if unselected

    public void ChangeState(String state) {
        switch (state) {
            case "start":
                check_new_pass.setEnabled(passt);
                btn_new_new.setEnabled(false);
                break;
        }
    }
    public void OpenNew() {
        if (namet && logint && emailt && passt) {
            btn_new_new.setEnabled(true);
        } else {
            btn_new_new.setEnabled(false);
        }
    }

    public New() {
        initComponents();
        ChangeState(this.state = "start");
        setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txt_new_login = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_new_new = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        check_new_pass = new javax.swing.JCheckBox();
        txt_new_pass = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txt_new_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_new_email = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txt_new_login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_new_loginFocusLost(evt);
            }
        });
        txt_new_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_new_loginKeyReleased(evt);
            }
        });

        jLabel2.setText("Login");

        jLabel3.setText("Password");

        btn_new_new.setText("New account");
        btn_new_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_new_newActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Sistema de Agendas");

        jLabel1.setText("versão 2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        check_new_pass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_new_passItemStateChanged(evt);
            }
        });
        check_new_pass.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                check_new_passStateChanged(evt);
            }
        });
        check_new_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_new_passMouseClicked(evt);
            }
        });
        check_new_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_new_passActionPerformed(evt);
            }
        });

        txt_new_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_new_passFocusLost(evt);
            }
        });
        txt_new_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_new_passKeyReleased(evt);
            }
        });

        jLabel7.setText("Nome completo");

        txt_new_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_new_nameFocusLost(evt);
            }
        });

        jLabel8.setText("Email");

        txt_new_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_new_emailFocusLost(evt);
            }
        });
        txt_new_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_new_emailKeyReleased(evt);
            }
        });

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_new_name)
                            .addComponent(txt_new_email)
                            .addComponent(txt_new_login)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txt_new_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(check_new_pass))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_new_new)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_new_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_new_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_new_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_new_pass)
                    .addComponent(txt_new_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_new_new)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_new_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_new_passKeyReleased
        txt_new_pass.setText(txt_new_pass.getText().replaceAll(" ", ""));
        if (txt_new_pass.getText().length() <= "".length()) {
            passt = false;
            passk = false;
            check_new_pass.setSelected(false);
            check_new_pass.setEnabled(false);
            txt_new_pass.setEchoChar('\u25cf');
        } else {
            passt = true;
            check_new_pass.setEnabled(true);
            OpenNew();
        }
    }//GEN-LAST:event_txt_new_passKeyReleased

    private void check_new_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_new_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_new_passActionPerformed

    private void check_new_passStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_check_new_passStateChanged
    }//GEN-LAST:event_check_new_passStateChanged

    private void check_new_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_new_passMouseClicked
    }//GEN-LAST:event_check_new_passMouseClicked

    private void btn_new_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_new_newActionPerformed
        User user = new User(
                txt_new_name.getText(),
                txt_new_login.getText(),
                txt_new_email.getText(),
                txt_new_pass.getText());
        AuthenticationDAO verify = new AuthenticationDAO();
        if (verify.AUTH(user.getLogin())) {
            JOptionPane.showMessageDialog(null, "Usuário já Cadastrado!");
        } else {
            UserDAO cadastro = new UserDAO();
            if (cadastro.CREAT(user)) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso! "
                        + "\n\n Bem vindo " + user.getName()
                        + "\n\n Seu login é: " + user.getLogin());
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Alguma falha ao cadastrar, "
                        + "\n entre em contato com o administrador");
                this.dispose();
            }
        }
    }//GEN-LAST:event_btn_new_newActionPerformed

    private void txt_new_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_new_nameFocusLost
        if (txt_new_name.getText() == null) {
            namet = false;
        } else {
            namet = true;
            OpenNew();
        }
    }//GEN-LAST:event_txt_new_nameFocusLost

    private void txt_new_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_new_emailFocusLost
        if (txt_new_email.getText() == null) {
            emailt = false;
        } else {
            emailt = true;
            OpenNew();
        }
    }//GEN-LAST:event_txt_new_emailFocusLost

    private void txt_new_loginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_new_loginFocusLost
        if (txt_new_login.getText() == null) {
            logint = false;
        } else {
            logint = true;
            OpenNew();
        }
    }//GEN-LAST:event_txt_new_loginFocusLost

    private void txt_new_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_new_passFocusLost
        txt_new_pass.setText(txt_new_pass.getText().replaceAll(" ", ""));
        if (txt_new_pass.getText().length() <= "".length()) {
            passt = false;
            passk = false;
            check_new_pass.setSelected(false);
            check_new_pass.setEnabled(false);
            txt_new_pass.setEchoChar('\u25cf');
        } else {
            passt = true;
            check_new_pass.setEnabled(true);
            OpenNew();
        }
    }//GEN-LAST:event_txt_new_passFocusLost

    private void txt_new_loginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_new_loginKeyReleased
        txt_new_login.setText(txt_new_login.getText().replaceAll(" ", ""));        // TODO add your handling code here:
    }//GEN-LAST:event_txt_new_loginKeyReleased

    private void txt_new_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_new_emailKeyReleased
        txt_new_email.setText(txt_new_email.getText().replaceAll(" ", ""));         // TODO add your handling code here:
    }//GEN-LAST:event_txt_new_emailKeyReleased

    private void check_new_passItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check_new_passItemStateChanged
        if (passt) {
            if (passk) {
                txt_new_pass.setEchoChar('\u25cf');
                passk = !passk;
            } else {
                txt_new_pass.setEchoChar((char) 0);
                passk = !passk;
            }
        } else {
        }
    }//GEN-LAST:event_check_new_passItemStateChanged

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(New.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_new_new;
    private javax.swing.JCheckBox check_new_pass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txt_new_email;
    private javax.swing.JTextField txt_new_login;
    private javax.swing.JTextField txt_new_name;
    private javax.swing.JPasswordField txt_new_pass;
    // End of variables declaration//GEN-END:variables
}
