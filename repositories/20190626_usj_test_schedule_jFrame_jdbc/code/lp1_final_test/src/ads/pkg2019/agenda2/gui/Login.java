package ads.pkg2019.agenda2.gui;

import ads.pkg2019.agenda2.dao.AuthenticationDAO;
import ads.pkg2019.agenda2.entity.Authentication;
import ads.pkg2019.agenda2.sis.Sistema;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private String state; // start, select, edit, delet, new;
    private boolean logint, passt = false; //if the field is empty
    private boolean passk = false; //if unselected

    public void ChangeState(String state) {
        switch (state) {
            case "start":
                check_login_pass.setEnabled(false);
                btn_login_login.setEnabled(false);
                break;
        }
    }

    public void OpenLogin() {
        if (logint && passt) {
            btn_login_login.setEnabled(true);
        } else {
            btn_login_login.setEnabled(false);
        }
    }

    public Login() {
        initComponents();
        ChangeState(this.state = "start");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btn_login_new = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_login_login = new javax.swing.JButton();
        txt_login_pass = new javax.swing.JPasswordField();
        check_login_pass = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        txt_login_login = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel6.setText("Marcelo Damasco ");

        jLabel5.setText("Rafael Lapa Valgas");

        btn_login_new.setText("New account");
        btn_login_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_login_newActionPerformed(evt);
            }
        });

        btn_login_login.setText("Login");
        btn_login_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_login_loginActionPerformed(evt);
            }
        });

        txt_login_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_login_passFocusLost(evt);
            }
        });
        txt_login_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_login_passKeyReleased(evt);
            }
        });

        check_login_pass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_login_passItemStateChanged(evt);
            }
        });

        jLabel3.setText("Password");

        txt_login_login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_login_loginFocusLost(evt);
            }
        });
        txt_login_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_login_loginKeyReleased(evt);
            }
        });

        jLabel2.setText("Login");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Sistema de Agendas");

        jLabel1.setText("versão 2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_login_new)
                                .addComponent(btn_login_login)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txt_login_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(check_login_pass))
                                .addComponent(jLabel3)
                                .addComponent(txt_login_login)
                                .addComponent(jLabel2)
                                .addComponent(jSeparator2))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_login_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_login_pass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_login_pass, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23)
                .addComponent(btn_login_login)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_login_new)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8))
        );

        jTabbedPane1.addTab("Usuário", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_login_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_login_passFocusLost
        txt_login_pass.setText(txt_login_pass.getText().replaceAll(" ", ""));
        if (txt_login_pass.getText().length() <= "".length()) {
            passt = false;
            passk = false;
            check_login_pass.setSelected(false);
            check_login_pass.setEnabled(false);
            txt_login_pass.setEchoChar('\u25cf');
        } else {
            passt = true;
            check_login_pass.setEnabled(true);
            OpenLogin();
        }
    }//GEN-LAST:event_txt_login_passFocusLost

    private void txt_login_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_login_passKeyReleased
        txt_login_pass.setText(txt_login_pass.getText().replaceAll(" ", ""));
        if (txt_login_pass.getText().length() <= "".length()) {
            passt = false;
            passk = false;
            check_login_pass.setSelected(false);
            check_login_pass.setEnabled(false);
            txt_login_pass.setEchoChar('\u25cf');
        } else {
            passt = true;
            check_login_pass.setEnabled(true);
            OpenLogin();
        }
    }//GEN-LAST:event_txt_login_passKeyReleased

    private void check_login_passItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check_login_passItemStateChanged
        if (passt) {
            if (passk) {
                txt_login_pass.setEchoChar('\u25cf');
                passk = !passk;
            } else {
                txt_login_pass.setEchoChar((char) 0);
                passk = !passk;
            }
        } else {
        }
    }//GEN-LAST:event_check_login_passItemStateChanged

    private void txt_login_loginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_login_loginKeyReleased
        txt_login_login.setText(txt_login_login.getText().replaceAll(" ", ""));
    }//GEN-LAST:event_txt_login_loginKeyReleased

    private void txt_login_loginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_login_loginFocusLost
        if (txt_login_login.getText() == null) {
            logint = false;
        } else {
            logint = true;
            OpenLogin();
        }
    }//GEN-LAST:event_txt_login_loginFocusLost

    private void btn_login_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_login_newActionPerformed
        New newUser = new New();
        newUser.setVisible(true);
    }//GEN-LAST:event_btn_login_newActionPerformed

    private void btn_login_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_login_loginActionPerformed
        Authentication user = new Authentication(
                txt_login_login.getText(),
                txt_login_pass.getText());
        if (Sistema.LOGIN(user)) {
            JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
            setVisible(false);
            Agenda agendaApp = new Agenda();
            agendaApp.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao efetuar Login!");
            this.dispose();
            Login loginGUI = new Login();
            loginGUI.setVisible(true);
        }
    }//GEN-LAST:event_btn_login_loginActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login_login;
    private javax.swing.JButton btn_login_new;
    private javax.swing.JCheckBox check_login_pass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txt_login_login;
    private javax.swing.JPasswordField txt_login_pass;
    // End of variables declaration//GEN-END:variables
}
