package com.GUI.main.login;

import DAO.NhanVienDAO;
import Entity.NhanVien;
import Utilities.Auth;
import static com.GUI.main.login.Login.path;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ForgotPass extends javax.swing.JFrame {

    ForgotPass forgotPass;
    Loading loading = new Loading();
    String code = "";
    NhanVienDAO nvdao = new NhanVienDAO();

    public ForgotPass() {
        initComponents();
        init();
        forgotPass = this;
    }

    void init() {
        setLocationRelativeTo(this);
        setBackground(new Color(0, 0, 0, 0));
        panelEnterMail.setVisible(true);
        panelEnterCode.setVisible(false);
        panelEnterNewPass.setVisible(false);
        txtUser.setLabelText("Username");
        txtEmail.setLabelText("Email");
        txtCode.setLabelText("Code");
        pwdNewPass.setLabelText("New Password");
        pwdConfirmPass.setLabelText("Confirm Password");
        this.setIconImage(new ImageIcon(path+"\\src\\com\\GUI\\icon\\Untitled-1.png").getImage());
    }

    void showLoading() throws InterruptedException {
        loading.setVisible(true);
        Thread.sleep(1500);
        loading.dispose();
    }

    void sendCode() {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            String accountName = "cflcinema.nhom02@gmail.com";
            String accountPassword = "CFLnhom02";
            Session s = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(accountName, accountPassword);
                }
            });
            String from = "cflcinema.nhom02@gmail.com";
            String to = txtEmail.getText().trim();
            String subject = "Xác nhận đổi mật khẩu";

            for (int i = 0; i < 6; i++) {
                code += String.valueOf(new Random().nextInt(10));
            }
            System.out.println(code);

            String body = "Mã xác nhận của bạn là: " + code;

            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText(body);
            Transport.send(msg);
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(this, "Không thể gửi Code. Vui lòng kiểm tra lại Email.");
        }
    }

    void checkUser(String manv, String email) throws InterruptedException {
        boolean check = false;
        List<NhanVien> list = nvdao.selectAll();

        for (NhanVien nv : list) {
            if (manv.equalsIgnoreCase(nv.getMaNhanVien()) && email.equals(nv.getEmail())) {
                check = true;
                Auth.user = nv;
            }
        }

        if (check) {
            panelEnterMail.setVisible(false);
            panelEnterCode.setVisible(true);

            new Thread() {
                public void run() {
                    try {
                        showLoading();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();

            new Thread() {
                public void run() {
                    sendCode();
                }
            }.start();
            JOptionPane.showMessageDialog(this, "Nhập code đã gửi vào Email.");
        } else {
            showLoading();
            JOptionPane.showMessageDialog(this, "Mã nhân viên nhập không khớp với Email.");
        }
    }

    void checkCode(String codeType) throws InterruptedException {
        if (codeType.equalsIgnoreCase(code)) {
            panelEnterCode.setVisible(false);
            panelEnterNewPass.setVisible(true);
            showLoading();
        } else {
            showLoading();
            JOptionPane.showMessageDialog(this, "Code đã nhập không chính xác. Vui lòng kiểm tra lại email.");
            txtCode.setText("");
        }
    }

    void doiMatKhau(String matKhauMoi, String xacNhan) throws InterruptedException {
        if (!matKhauMoi.equalsIgnoreCase(xacNhan)) {
            showLoading();
            JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu không đúng. Vui lòng nhập lại.");
            pwdNewPass.setText("");
            pwdConfirmPass.setText("");
        } else {
            Auth.user.setMatKhau(xacNhan);
            nvdao.update(Auth.user);
            Auth.clear();
            showLoading();
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công. Vui lòng đăng nhập lại.");
            dispose();
            new Login().setVisible(true);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEnterMail = new com.GUI.swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnNext = new com.GUI.swing.Button();
        txtUser = new com.GUI.swing.TextField();
        btnCancel = new com.GUI.swing.Button();
        txtEmail = new com.GUI.swing.TextField();
        panelEnterCode = new com.GUI.swing.PanelBorder();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNext1 = new com.GUI.swing.Button();
        txtCode = new com.GUI.swing.TextField();
        btnCancel1 = new com.GUI.swing.Button();
        lblResentCode = new javax.swing.JLabel();
        panelEnterNewPass = new com.GUI.swing.PanelBorder();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnChange = new com.GUI.swing.Button();
        btnCancel2 = new com.GUI.swing.Button();
        pwdNewPass = new com.GUI.swing.PasswordField();
        pwdConfirmPass = new com.GUI.swing.PasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelEnterMail.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FORGOT PASSWORD");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Email");

        btnNext.setBorder(null);
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("NEXT");
        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        txtUser.setBackground(new java.awt.Color(204, 204, 204));
        txtUser.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N

        btnCancel.setBorder(null);
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("CANCEL");
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelEnterMailLayout = new javax.swing.GroupLayout(panelEnterMail);
        panelEnterMail.setLayout(panelEnterMailLayout);
        panelEnterMailLayout.setHorizontalGroup(
            panelEnterMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnterMailLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(panelEnterMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelEnterMailLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelEnterMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEnterMailLayout.createSequentialGroup()
                        .addGroup(panelEnterMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnterMailLayout.createSequentialGroup()
                        .addGroup(panelEnterMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))))
        );
        panelEnterMailLayout.setVerticalGroup(
            panelEnterMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnterMailLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(panelEnterMail, "card2");

        panelEnterCode.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("FORGOT PASSWORD");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Verification code");

        btnNext1.setBorder(null);
        btnNext1.setForeground(new java.awt.Color(255, 255, 255));
        btnNext1.setText("NEXT");
        btnNext1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        txtCode.setBackground(new java.awt.Color(204, 204, 204));
        txtCode.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtCode.setLabelText("Verification code");

        btnCancel1.setBorder(null);
        btnCancel1.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel1.setText("CANCEL");
        btnCancel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        lblResentCode.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblResentCode.setForeground(new java.awt.Color(255, 51, 51));
        lblResentCode.setText("Did not receive the verification code. Click here.");
        lblResentCode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblResentCode.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblResentCodeMouseMoved(evt);
            }
        });
        lblResentCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResentCodeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblResentCodeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelEnterCodeLayout = new javax.swing.GroupLayout(panelEnterCode);
        panelEnterCode.setLayout(panelEnterCodeLayout);
        panelEnterCodeLayout.setHorizontalGroup(
            panelEnterCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnterCodeLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelEnterCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEnterCodeLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(264, Short.MAX_VALUE))
                    .addGroup(panelEnterCodeLayout.createSequentialGroup()
                        .addGroup(panelEnterCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblResentCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                            .addComponent(txtCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 81, Short.MAX_VALUE))))
            .addGroup(panelEnterCodeLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(panelEnterCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNext1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEnterCodeLayout.setVerticalGroup(
            panelEnterCodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnterCodeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResentCode)
                .addGap(48, 48, 48)
                .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        getContentPane().add(panelEnterCode, "card2");

        panelEnterNewPass.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FORGOT PASSWORD");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("New Password");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Confirm Password");

        btnChange.setBackground(new java.awt.Color(0, 0, 0));
        btnChange.setBorder(null);
        btnChange.setForeground(new java.awt.Color(255, 255, 255));
        btnChange.setText("CHANGE");
        btnChange.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        btnCancel2.setBackground(new java.awt.Color(0, 0, 0));
        btnCancel2.setBorder(null);
        btnCancel2.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel2.setText("CANCEL");
        btnCancel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel2ActionPerformed(evt);
            }
        });

        pwdNewPass.setBackground(new java.awt.Color(204, 204, 204));
        pwdNewPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pwdNewPass.setLabelText("New Password");

        pwdConfirmPass.setBackground(new java.awt.Color(204, 204, 204));
        pwdConfirmPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pwdConfirmPass.setLabelText("Confirm");

        javax.swing.GroupLayout panelEnterNewPassLayout = new javax.swing.GroupLayout(panelEnterNewPass);
        panelEnterNewPass.setLayout(panelEnterNewPassLayout);
        panelEnterNewPassLayout.setHorizontalGroup(
            panelEnterNewPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnterNewPassLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(panelEnterNewPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChange, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(btnCancel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelEnterNewPassLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelEnterNewPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEnterNewPassLayout.createSequentialGroup()
                        .addGroup(panelEnterNewPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addContainerGap(250, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnterNewPassLayout.createSequentialGroup()
                        .addGroup(panelEnterNewPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pwdConfirmPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pwdNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))))
        );
        panelEnterNewPassLayout.setVerticalGroup(
            panelEnterNewPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnterNewPassLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pwdNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pwdConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnChange, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(panelEnterNewPass, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        new Thread() {
            public void run() {
                forgotPass.dispose();
                try {
                    showLoading();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                Auth.clear();
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    new Login().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        new Thread() {
            public void run() {
                forgotPass.dispose();
                try {
                    showLoading();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                Auth.clear();
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    new Login().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void btnCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel2ActionPerformed
        new Thread() {
            public void run() {
                forgotPass.dispose();
                try {
                    showLoading();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                Auth.clear();
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    new Login().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }//GEN-LAST:event_btnCancel2ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        new Thread() {
            public void run() {
                try {
                    if (txtUser.getText().equals("") || txtEmail.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.");
                    } else {
                        checkUser(txtUser.getText().trim(), txtEmail.getText().trim());
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }//GEN-LAST:event_btnNextActionPerformed

    private void lblResentCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResentCodeMouseClicked
        new Thread() {
            public void run() {
                try {
                    showLoading();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
                }
                sendCode();
            }
        }.start();
    }//GEN-LAST:event_lblResentCodeMouseClicked

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        new Thread() {
            public void run() {
                try {
                    showLoading();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    if (txtCode.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.");
                    } else {
                        Thread.sleep(1000);
                        checkCode(txtCode.getText().trim());
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        new Thread() {
            public void run() {
                try {
                    showLoading();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    if (pwdConfirmPass.getText().equals("") || pwdNewPass.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.");
                    } else {
                        Thread.sleep(1000);
                        doiMatKhau(pwdConfirmPass.getText().trim(), pwdNewPass.getText().trim());
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }//GEN-LAST:event_btnChangeActionPerformed

    private void lblResentCodeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResentCodeMouseMoved
        lblResentCode.setForeground(Color.red);
        lblResentCode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    }//GEN-LAST:event_lblResentCodeMouseMoved

    private void lblResentCodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResentCodeMouseExited
        lblResentCode.setForeground(new Color(255, 51, 51));
        lblResentCode.setFont(new Font("Tahoma", Font.PLAIN | Font.ITALIC, 14));
    }//GEN-LAST:event_lblResentCodeMouseExited

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
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.swing.Button btnCancel;
    private com.GUI.swing.Button btnCancel1;
    private com.GUI.swing.Button btnCancel2;
    private com.GUI.swing.Button btnChange;
    private com.GUI.swing.Button btnNext;
    private com.GUI.swing.Button btnNext1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblResentCode;
    private com.GUI.swing.PanelBorder panelEnterCode;
    private com.GUI.swing.PanelBorder panelEnterMail;
    private com.GUI.swing.PanelBorder panelEnterNewPass;
    private com.GUI.swing.PasswordField pwdConfirmPass;
    private com.GUI.swing.PasswordField pwdNewPass;
    private com.GUI.swing.TextField txtCode;
    private com.GUI.swing.TextField txtEmail;
    private com.GUI.swing.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
