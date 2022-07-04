package com.GUI.form.NhanVien;

import DAO.NhanVienDAO;
import Entity.NhanVien;
import Utilities.ValidateCheck;
import Utilities.XImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Profile_Form extends javax.swing.JFrame {

    private ValidateCheck vld = new ValidateCheck();
    private XImage xImage = new XImage();
    private NhanVienDAO nvdao = new NhanVienDAO();
    private NhanVien nv;
    static String path = System.getProperty("user.dir");

    public Profile_Form() {
        initComponents();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setIconImage(new ImageIcon(path+"\\src\\com\\GUI\\icon\\Untitled-1.png").getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.GUI.swing.PanelBorder();
        lblavatar = new com.GUI.swing.ImageAvatar();
        txttennhanvien = new javax.swing.JLabel();
        txtoldpass = new com.GUI.swing.PasswordField();
        txtnewpass1 = new com.GUI.swing.PasswordField();
        txtnewpass2 = new com.GUI.swing.PasswordField();
        btnchangepass = new com.GUI.swing.Button();
        btncancel = new com.GUI.swing.Button();
        txtmanhanvien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(56, 56, 56));

        lblavatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GUI/icon/staff.png"))); // NOI18N

        txttennhanvien.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        txttennhanvien.setForeground(new java.awt.Color(255, 255, 255));
        txttennhanvien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttennhanvien.setText("Tên Nhân Viên");

        txtoldpass.setText("passwordField1");
        txtoldpass.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        txtoldpass.setLabelText("Old PassWord");

        txtnewpass1.setText("passwordField1");
        txtnewpass1.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        txtnewpass1.setLabelText("New PassWord");

        txtnewpass2.setText("passwordField1");
        txtnewpass2.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        txtnewpass2.setLabelText("Confirm PassWord");

        btnchangepass.setBackground(new java.awt.Color(255, 0, 0));
        btnchangepass.setBorder(null);
        btnchangepass.setForeground(new java.awt.Color(255, 255, 255));
        btnchangepass.setText("Đổi Mật Khẩu");
        btnchangepass.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        btnchangepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangepassActionPerformed(evt);
            }
        });

        btncancel.setBackground(new java.awt.Color(255, 0, 0));
        btncancel.setBorder(null);
        btncancel.setForeground(new java.awt.Color(255, 255, 255));
        btncancel.setText("Hủy");
        btncancel.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        txtmanhanvien.setFont(new java.awt.Font("Segoe UI Black", 1, 15)); // NOI18N
        txtmanhanvien.setForeground(new java.awt.Color(255, 255, 255));
        txtmanhanvien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtmanhanvien.setText("Mã Nhân Viên");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GUI/icon/icons8_multiply_60px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ĐĂNG KÍ FACE ID");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(lblavatar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(txtoldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(txtnewpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnewpass2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(btnchangepass, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttennhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblavatar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(15, 15, 15)
                .addComponent(txtmanhanvien)
                .addGap(18, 18, 18)
                .addComponent(txttennhanvien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtoldpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnewpass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnewpass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnchangepass, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnchangepassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangepassActionPerformed
        ChangePass();
    }//GEN-LAST:event_btnchangepassActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
        new FaceIDDangKy_Form().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(Profile_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.swing.Button btncancel;
    private com.GUI.swing.Button btnchangepass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.GUI.swing.ImageAvatar lblavatar;
    private com.GUI.swing.PanelBorder panelBorder1;
    private javax.swing.JLabel txtmanhanvien;
    private com.GUI.swing.PasswordField txtnewpass1;
    private com.GUI.swing.PasswordField txtnewpass2;
    private com.GUI.swing.PasswordField txtoldpass;
    private javax.swing.JLabel txttennhanvien;
    // End of variables declaration//GEN-END:variables
    public void initEntity() {
        xImage.ReadAndScaleIMG(lblavatar, "/imageNhanVien/" + nv.getHinh(), lblavatar.getWidth() - 1, lblavatar.getHeight() - 1);
        txtmanhanvien.setText(nv.getMaNhanVien());
        txttennhanvien.setText(nv.getHoTen());
    }

    private void getpass() {

    }

    private boolean validatepass() {
        String oldpass = txtoldpass.getText();
        String newpass1 = txtnewpass1.getText();
        String newpass2 = txtnewpass2.getText();
        if (vld.CheckString("Mật Khẩu Cũ", oldpass, 30, false)
                && vld.CheckString("Mật Khẩu Mới", oldpass, 30, false)
                && vld.CheckString("Nhập Lại Mật Khẩu Mới", oldpass, 30, false)
                && vld.CheckDulicase2("Mật Khẩu Cũ ", oldpass, "Mật Khẩu Của Bạn\nVui Lòng Nhập Lại!", nv.getMatKhau())
                && vld.CheckDulicase2("Mật Khẩu Mới", newpass1, "Nhập Lại Mật Khẩu Mới", newpass2)) {
            return true;
        }
        return false;
    }

    private void ChangePass() {
        if (validatepass()) {
            try {
                NhanVien pass = new NhanVien();
                pass.setMaNhanVien(txtmanhanvien.getText());
                pass.setMatKhau(txtnewpass1.getText());
                nvdao.UpdatePassword(pass);
                JOptionPane.showMessageDialog(this, "Đổi Mật Khẩu Thành Công");
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Đổi Mật Khẩu Không Thành Công");
            }
        }
    }

    public void setNV(NhanVien nv) {
        this.nv = nv;
    }
}
