package com.GUI.main.login;

import DAO.NhanVienDAO;
import Entity.NhanVien;
import Utilities.Auth;
import com.GUI.main.Main;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public static Login login;
    Loading loading = new Loading();
    NhanVienDAO dao = new NhanVienDAO();
    static String path = System.getProperty("user.dir");

    public Login() throws InterruptedException {
        initComponents();
        init();
        login = this;
    }

    void init() {
        setLocationRelativeTo(this);
        setBackground(new Color(0, 0, 0, 0));
        txtUser.setLabelText("Username");
        pwdPass.setLabelText("Password");
        this.setIconImage(new ImageIcon(path+"\\src\\com\\GUI\\icon\\Untitled-1.png").getImage());
    }

    void showLoading() throws InterruptedException {
        loading.setVisible(true);
        Thread.sleep(1000);
        loading.dispose();
    }

    void dangNhap(String manv, String matkhau) throws InterruptedException {
        NhanVien nhanVien = dao.selectById(manv);
        if (nhanVien == null) {
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập.");
        } else if (!matkhau.equals(nhanVien.getMatKhau())) {
            JOptionPane.showMessageDialog(this, "Sai mật khẩu.");
        } else {
            Main x = new Main();
            x.setNV(nhanVien);
            x.check();
            Auth.user = nhanVien;
            x.setVisible(true);
            dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.GUI.swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblQuenMatKhau = new javax.swing.JLabel();
        btnLogin = new com.GUI.swing.Button();
        txtUser = new com.GUI.swing.TextField();
        pwdPass = new com.GUI.swing.PasswordField();
        lblExit = new javax.swing.JLabel();
        btnFaceID = new com.GUI.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("LOGIN");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Password");

        lblQuenMatKhau.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblQuenMatKhau.setForeground(new java.awt.Color(255, 51, 51));
        lblQuenMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblQuenMatKhau.setText("Quên mật khẩu?");
        lblQuenMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuenMatKhau.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseMoved(evt);
            }
        });
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseExited(evt);
            }
        });

        btnLogin.setBorder(null);
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("SIGN IN");
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtUser.setBackground(new java.awt.Color(204, 204, 204));
        txtUser.setForeground(new java.awt.Color(51, 51, 51));
        txtUser.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtUser.setLabelText("Username");

        pwdPass.setBackground(new java.awt.Color(204, 204, 204));
        pwdPass.setForeground(new java.awt.Color(51, 51, 51));
        pwdPass.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        pwdPass.setLabelText("Password");
        pwdPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdPassActionPerformed(evt);
            }
        });

        lblExit.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 51, 51));
        lblExit.setText("Exit.");
        lblExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblExitMouseMoved(evt);
            }
        });
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExitMouseExited(evt);
            }
        });

        btnFaceID.setBorder(null);
        btnFaceID.setForeground(new java.awt.Color(255, 255, 255));
        btnFaceID.setText("FACE ID");
        btnFaceID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFaceID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaceIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblQuenMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwdPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(50, 50, 50))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFaceID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuenMatKhau)
                .addGap(28, 28, 28)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFaceID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblExit)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        new Thread() {
            public void run() {
                try {
                    showLoading();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                login.dispose();
            }
        }.start();
        new Thread() {
            public void run() {
                new ForgotPass().setVisible(true);
            }
        }.start();
    }//GEN-LAST:event_lblQuenMatKhauMouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (txtUser.getText().equals("") || pwdPass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.");
        } else {
            new Thread() {
                public void run() {
                    try {
                        loading.setVisible(true);
                        Thread.sleep(5000);
                        loading.dispose();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
            new Thread() {
                public void run() {
                    try {
                        dangNhap(txtUser.getText().trim(), pwdPass.getText().trim());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblQuenMatKhauMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseMoved
        lblQuenMatKhau.setForeground(Color.red);
        lblQuenMatKhau.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    }//GEN-LAST:event_lblQuenMatKhauMouseMoved

    private void lblQuenMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseExited
        lblQuenMatKhau.setForeground(new Color(255, 51, 51));
        lblQuenMatKhau.setFont(new Font("Tahoma", Font.PLAIN | Font.ITALIC, 14));
    }//GEN-LAST:event_lblQuenMatKhauMouseExited

    private void lblExitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseMoved
        lblExit.setForeground(Color.red);
        lblExit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    }//GEN-LAST:event_lblExitMouseMoved

    private void lblExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseExited
        lblExit.setForeground(new Color(255, 51, 51));
        lblExit.setFont(new Font("Tahoma", Font.PLAIN | Font.ITALIC, 14));
    }//GEN-LAST:event_lblExitMouseExited

    private void pwdPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdPassActionPerformed
        new Thread() {
            public void run() {
                try {
                    loading.setVisible(true);
                    Thread.sleep(5000);
                    loading.dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    dangNhap(txtUser.getText().trim(), pwdPass.getText().trim());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }//GEN-LAST:event_pwdPassActionPerformed

    private void btnFaceIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaceIDActionPerformed
        new Thread() {
            public void run() {
                try {
                    loading.setVisible(true);
                    Thread.sleep(5000);
                    loading.dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        new Thread() {
            public void run() {
                new FaceIDDangNhap_Form().setVisible(true);
                login.dispose();
            }
        }.start();

    }//GEN-LAST:event_btnFaceIDActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.swing.Button btnFaceID;
    private com.GUI.swing.Button btnLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblQuenMatKhau;
    private com.GUI.swing.PanelBorder panelBorder1;
    public static com.GUI.swing.PasswordField pwdPass;
    public static com.GUI.swing.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
