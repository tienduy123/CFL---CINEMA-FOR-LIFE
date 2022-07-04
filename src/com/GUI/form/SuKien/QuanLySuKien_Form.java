package com.GUI.form.SuKien;

import DAO.KHTTDAO;
import DAO.KhuyenMaiDAO;
import Entity.KHTT;
import Entity.KhuyenMai;
import Entity.NhanVien;
import Utilities.Auth;
import Utilities.ValidateCheck;
import com.GUI.form.BanVe.BanVe_Form;
import com.GUI.main.Main;
import com.GUI.swing.ScrollBar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLySuKien_Form extends javax.swing.JPanel {

    private DefaultTableModel modeltable;
    private List<KhuyenMai> list;
    private ValidateCheck vld = new ValidateCheck();
    private KhuyenMaiDAO KmAction;
    private NhanVien nv;
    public static boolean add_SK = false;
    public static boolean xoa_SK = false;
    public static boolean sua_SK = false;
    public static String MaSuKi;

    public QuanLySuKien_Form() {
        initComponents();
        setOpaque(false);
        txtMaSuKien.setLabelText("Mã Sự Kiện");
        txtTenSuKien.setLabelText("Tên Sự Kiện");
        txtMucKhuyenMai.setLabelText("Mức Khuyến Mãi (%)");
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        FillTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblsukien = new com.GUI.swing.Table();
        jLabel1 = new javax.swing.JLabel();
        DateOpen = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        DateClose = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtthongtin = new javax.swing.JTextArea();
        btnthem = new com.GUI.swing.Button();
        btncapnhat = new com.GUI.swing.Button();
        btnxoa = new com.GUI.swing.Button();
        btnlammoi = new com.GUI.swing.Button();
        jLabel4 = new javax.swing.JLabel();
        txtMaSuKien = new com.GUI.swing.TextField();
        txtTenSuKien = new com.GUI.swing.TextField();
        txtMucKhuyenMai = new com.GUI.swing.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

        tblsukien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên Khuyến Mãi", "Mức Giảm Giá", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Mã Nhân Viên"
            }
        ));
        tblsukien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsukienMouseClicked(evt);
            }
        });
        tblsukien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblsukienKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblsukien);
        if (tblsukien.getColumnModel().getColumnCount() > 0) {
            tblsukien.getColumnModel().getColumn(0).setMinWidth(120);
            tblsukien.getColumnModel().getColumn(0).setMaxWidth(120);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Ngày Bắt Đầu");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Ngày Kết Thúc");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Mô tả:");

        txtthongtin.setColumns(20);
        txtthongtin.setRows(5);
        jScrollPane2.setViewportView(txtthongtin);

        btnthem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnthem.setForeground(new java.awt.Color(255, 255, 255));
        btnthem.setText("THÊM");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btncapnhat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btncapnhat.setForeground(new java.awt.Color(255, 255, 255));
        btncapnhat.setText("CẬP NHẬT");
        btncapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatActionPerformed(evt);
            }
        });

        btnxoa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnxoa.setForeground(new java.awt.Color(255, 255, 255));
        btnxoa.setText("XÓA");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnlammoi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnlammoi.setForeground(new java.awt.Color(255, 255, 255));
        btnlammoi.setText("LÀM MỚI");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("QUẢN LÝ SỰ KIỆN");

        txtMaSuKien.setForeground(new java.awt.Color(51, 51, 51));
        txtMaSuKien.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N

        txtTenSuKien.setForeground(new java.awt.Color(51, 51, 51));
        txtTenSuKien.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N

        txtMucKhuyenMai.setForeground(new java.awt.Color(51, 51, 51));
        txtMucKhuyenMai.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtMucKhuyenMai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMucKhuyenMaiKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btncapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(6, 6, 6))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTenSuKien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                .addComponent(txtMaSuKien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(DateOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DateClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(553, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(541, 541, 541))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMaSuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenSuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateClose, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        FillToNull();
        FillTable();
        btnxoa.setEnabled(false);
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        AddEvent();
        Main.saoLuu.logSuKien();
        Main.banVe = new BanVe_Form();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btncapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatActionPerformed
        UpdateEvent();
        Main.saoLuu.logSuKien();
    }//GEN-LAST:event_btncapnhatActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        if (Auth.isManager()) {
            int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá sự kiện này?");
            if (i == 0) {
                DeleteEvent();
                Main.banVe = new BanVe_Form();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chỉ Quản lý mới được sử dụng chức năng này.");
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void tblsukienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblsukienKeyReleased
        FillToComp();
    }//GEN-LAST:event_tblsukienKeyReleased

    private void tblsukienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsukienMouseClicked
        FillToComp();
        btnxoa.setEnabled(true);
    }//GEN-LAST:event_tblsukienMouseClicked

    private void txtMucKhuyenMaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMucKhuyenMaiKeyReleased
        try {
            if (txtMucKhuyenMai.getText().length()>2) {
                txtMucKhuyenMai.setText("10");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtMucKhuyenMaiKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateClose;
    private com.toedter.calendar.JDateChooser DateOpen;
    private com.GUI.swing.Button btncapnhat;
    private com.GUI.swing.Button btnlammoi;
    private com.GUI.swing.Button btnthem;
    private com.GUI.swing.Button btnxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.GUI.swing.Table tblsukien;
    private com.GUI.swing.TextField txtMaSuKien;
    private com.GUI.swing.TextField txtMucKhuyenMai;
    private com.GUI.swing.TextField txtTenSuKien;
    private javax.swing.JTextArea txtthongtin;
    // End of variables declaration//GEN-END:variables

    private void FillTable() {
        list = null;
        list = new KhuyenMaiDAO().selectAll();
        modeltable = (DefaultTableModel) tblsukien.getModel();
        modeltable.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            modeltable.addRow(new Object[]{list.get(i).getMaKM(), list.get(i).getTenKM(), list.get(i).getMucGiamGia(), list.get(i).getNgayBatDau(), list.get(i).getNgayKetThuc(), list.get(i).getMaNhanVien()});
        }
        modeltable.fireTableDataChanged();
    }

    private void FillToNull() {
        txtMaSuKien.setEditable(true);
        tblsukien.clearSelection();
        txtMaSuKien.setText("");
        txtTenSuKien.setText("");
        txtMucKhuyenMai.setText("");
        DateOpen.setDate(null);
        DateClose.setDate(null);
        txtthongtin.setText("");
    }

    private KhuyenMai GetValuesKhuyenMai() {
        KhuyenMai km = new KhuyenMai();
        km.setMaKM(txtMaSuKien.getText().trim());
        km.setTenKM(txtTenSuKien.getText());
        km.setNgayBatDau(DateOpen.getDate());
        km.setNgayKetThuc(DateClose.getDate());
        km.setMucGiamGia(Float.valueOf(txtMucKhuyenMai.getText()));
        km.setThongTinKM(txtthongtin.getText());
        km.setMaNhanVien(nv.getMaNhanVien());
        MaSuKi = km.getMaKM();
        return km;
    }

    private boolean Check(String values1) {
        for (int i = 0; i < list.size(); i++) {
            return vld.CheckDulicase("Mã Sự Kiện", values1, "Mã Sự Kiện Có Sẵn", list.get(i).getMaKM());
        }
        return true;
    }

    private boolean Validateform(boolean x) {
        if (x
                && vld.CheckString("Mã Sự Kiện", txtMaSuKien.getText(), 50, false)
                && Check(txtMaSuKien.getText())
                && vld.CheckString("Tên Sự Kiện", txtTenSuKien.getText(), 255, false)
                && vld.CheckNullDate("Ngày Bắt Đầu", DateOpen.getDate())
                && vld.CheckNullDate("Ngày Kết Thúc", DateClose.getDate())
                && vld.CheckAfterAndBefore("Ngày Bắt Đầu", DateOpen.getDate(), "Ngày Kết Thúc", DateClose.getDate())
                && vld.CheckString("Mức Khuyến Mãi", txtMucKhuyenMai.getText(), -1, false)
                && vld.CheckFloat("Mức Khuyến Mãi", txtMucKhuyenMai.getText())
                && vld.CheckString("Thông Tin Sự Kiện", txtthongtin.getText(), 255, false)) {
            return true;
        }
        if (x == false
                && vld.CheckString("Mã Sự Kiện", txtMaSuKien.getText(), 50, false)
                && vld.CheckString("Tên Sự Kiện", txtTenSuKien.getText(), 255, false)
                && vld.CheckNullDate("Ngày Bắt Đầu", DateOpen.getDate())
                && vld.CheckNullDate("Ngày Kết Thúc", DateClose.getDate())
                && vld.CheckAfterAndBefore("Ngày Bắt Đầu", DateOpen.getDate(), "Ngày Kết Thúc", DateClose.getDate())
                && vld.CheckString("Mức Khuyến Mãi", txtMucKhuyenMai.getText(), -1, false)
                && vld.CheckFloat("Mức Khuyến Mãi", txtMucKhuyenMai.getText())
                && vld.CheckString("Thông Tin Sự Kiện", txtthongtin.getText(), 255, false)) {
            return true;
        }
        return false;
    }

    private void AddEvent() {
        if (Validateform(true)) {
            KhuyenMai values = GetValuesKhuyenMai();
            KmAction = new KhuyenMaiDAO();
            try {
                KmAction.insert(values);
                int test = JOptionPane.showConfirmDialog(null, "Bạn có muốn thông báo sự kiện này đến KHTT không?");
                if (test == 0) {
                    new SKDangDienRa_Form().guiMail2(new KhuyenMaiDAO().selectById(txtMaSuKien.getText()));
                }
                add_SK = true;
            } catch (Exception e) {
                if (check(values.getMaKM())) {
                    JOptionPane.showMessageDialog(this, "Mã Sự Kiện Trùng Với Mã Sự Kiện Có Sẵn");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Thêm Mới Không Thành Công!");
            }
            FillTable();
            JOptionPane.showMessageDialog(null, "Thêm Mới Thành Công!");
        }
    }

    private void FillToComp() {
        int index = tblsukien.getSelectedRow();
        if (index != -1) {
            txtMaSuKien.setEditable(false);
            for (int i = 0; i < list.size(); i++) {
                if (tblsukien.getValueAt(index, 0).equals(list.get(i).getMaKM())) {
                    txtMaSuKien.setText(list.get(i).getMaKM());
                    txtTenSuKien.setText(list.get(i).getTenKM());
                    DateOpen.setDate(list.get(i).getNgayBatDau());
                    DateClose.setDate(list.get(i).getNgayKetThuc());
                    txtMucKhuyenMai.setText(String.valueOf(list.get(i).getMucGiamGia()));
                    txtthongtin.setText(list.get(i).getThongTinKM());
                }
            }
        }
    }

    private void UpdateEvent() {
        if (Validateform(false)) {
            KhuyenMai values = GetValuesKhuyenMai();
            KmAction = new KhuyenMaiDAO();
            try {
                KmAction.update(values);
                JOptionPane.showMessageDialog(null, "Cập Nhật Thông Tin Thành Công!");
                sua_SK = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cập Nhật Thông Tin Không Thành Công!\n");
            }
            FillTable();
        }
    }

    private void DeleteEvent() {
        int index = tblsukien.getSelectedRow();
        if (index != -1) {
            KmAction = new KhuyenMaiDAO();
            try {
                xoa_SK = true;
                MaSuKi = (String) tblsukien.getValueAt(index, 0);
                Main.saoLuu.logSuKien();
                KmAction.delete((String) tblsukien.getValueAt(index, 0));
                JOptionPane.showMessageDialog(null, "Xóa Sự Kiện Thành Công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Xóa Sự Kiện Không Thành Công!\n");
            }
            FillTable();
            FillToNull();
        } else {
            JOptionPane.showMessageDialog(null, "Chưa Chọn Dòng Để Xóa!");
        }
    }

    private void guiMail() {
        int test = JOptionPane.showConfirmDialog(null, "Bạn có muốn gửi thông tin sự kiện đến KHTT không ?");
        if (test == 0) {

            List<KHTT> listMailKH = new KHTTDAO().selectAll();
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            String accountName = "cflcinema.nhom02@gmail.com";
            String accountPassword = "CFLnhom02";
            Session s = Session.getInstance(p, new javax.mail.Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(accountName, accountPassword);
                }
            });
            String from = accountName;
            // gửi đến mail nào       
            for (int j = 0; j < listMailKH.size(); j++) {
                String email = listMailKH.get(j).getEmail();
                String nameKH = listMailKH.get(j).getTen();

                // chủ đề
                Thread a = new Thread() {
                    @Override
                    public void run() {
                        try {
                            String subject = "CFL Cinema";
                            // nội dung
                            String body = "<!DOCTYPE html>\n"
                                    + "<html lang=\"en\">\n"
                                    + "<head>\n"
                                    + "    <meta charset=\"UTF-8\">\n"
                                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                                    + "    <title>Document</title>\n"
                                    + "</head>\n"
                                    + "<body>\n"
                                    + "    <div class = \"bocNgoai\" >\n"
                                    + "        <h1 style = \"text-align: center;color: #B22222;\">CFL Cinema</h1>\n"
                                    + "\n"
                                    + "        <div class =\"bocTrong\" style=\"margin: 0 auto;width: 430px; height: 350px;border: 5px outset gray;padding: 15px;\">\n"
                                    + "            <p  style=\"font-size: 18px\">\n"
                                    + "                <span>Xin chào </span><b>" + nameKH + "</b>\n"
                                    + "                <br><br>\n"
                                    + "                <p style=\"\"> Công ty TNHH CFL Cinema trân trọng thông báo. Cảm ơn Quý khách đã cùng tin tưởng, đồng hành và bình chọn \n"
                                    + "                  CFL Cinema là công ty dẫn đầu về trải nghiệm khách hàng rạp chiếu phim. \n"
                                    + "                  Nay chúng tôi tổ chức sự kiện tri ân khách hàng. Kính mong quý khách\n"
                                    + "                  có mặt tại buổi tri ân \n"
                                    + "                  <ul>\n"
                                    + "                      <li><b>Tên sự kiện: Ăn mừng giám đốc Nguyên qua môn</b></li>\n"
                                    + "                      <li><b>Thời gian bắt đầu : 19:00 PM 30/02/2021</b></li>\n"
                                    + "                      <li><b>Thời gian kết thúc: 19:00 PM 30/02/2021</b></li>\n"
                                    + "                      <li><b>Giảm giá: 90%</b></li>\n"
                                    + "                      \n"
                                    + "                  </ul>\n"
                                    + "                  Chúng tôi mong nhận được sự phản hồi sớm từ Quý khách ! <br><br>\n"
                                    + "                  Giám Đốc: <b>Đào Đức Nguyên</b>\n"
                                    + "                </p>\n"
                                    + "                </p>\n"
                                    + "\n"
                                    + "        </div>\n"
                                    + "\n"
                                    + "\n"
                                    + "\n"
                                    + "    </div>\n"
                                    + "</body>\n"
                                    + "</html>";
                            Message msg = new MimeMessage(s);
                            msg.setFrom(new InternetAddress(from));
                            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                            msg.setSubject(subject);
                            msg.setContent(body, "text/html;charset = utf-8");

                            Transport.send(msg);
                        } catch (AddressException ex) {
                            Logger.getLogger(SKDangDienRa_Form.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (MessagingException ex) {
                            Logger.getLogger(SKDangDienRa_Form.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                a.start();
            }
            JOptionPane.showMessageDialog(null, "Gửi mail thành công");
        }
    }

    public void setNV(NhanVien nv) {
        this.nv = nv;
    }
    
    private boolean check(String makm) {
        for (int i = 0; i < tblsukien.getRowCount(); i++) {
            if (makm.toUpperCase().equals(tblsukien.getValueAt(i, 0).toString())) {
                tblsukien.setRowSelectionInterval(i, i);
                return false;
            }
        }
        return true;
    }
}
