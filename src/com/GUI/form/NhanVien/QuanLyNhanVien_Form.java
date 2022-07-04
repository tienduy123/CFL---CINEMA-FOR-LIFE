package com.GUI.form.NhanVien;

import Entity.*;
import DAO.*;
import Utilities.Auth;
import Utilities.ValidateCheck;
import Utilities.XImage;
import com.GUI.main.Main;
import com.GUI.swing.ScrollBar;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class QuanLyNhanVien_Form extends javax.swing.JPanel {

    private DefaultTableModel modeltable;
    private List<NhanVien> list;
    private ValidateCheck vld = new ValidateCheck();
    private XImage xImage = new XImage();
    private String HinhTam = "";
    private NhanVienDAO nvdao = new NhanVienDAO();
    private String pathDefaultFile = System.getProperty("user.dir");
    private ImageIcon icon;
    public static boolean add_NV = false;
    public static boolean xoa_NV = false;
    public static boolean sua_NV = false;
    public static String MaNV;

    public QuanLyNhanVien_Form() {
        initComponents();
        setOpaque(false);
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        LoadInit();
        FillTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rdoquanly = new javax.swing.JRadioButton();
        rdonhanvien = new javax.swing.JRadioButton();
        btnthem = new com.GUI.swing.Button();
        btncapnhat = new com.GUI.swing.Button();
        btnlammoi = new com.GUI.swing.Button();
        btnxoa = new com.GUI.swing.Button();
        txtMaNhanVien = new com.GUI.swing.TextField();
        txtTenNV = new com.GUI.swing.TextField();
        txtSDT = new com.GUI.swing.TextField();
        btnresestpassword = new com.GUI.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnhanvien = new com.GUI.swing.Table();
        txtSearch = new com.GUI.swing.TextField();
        btnSearch = new com.GUI.swing.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtghichu = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lbavatar = new javax.swing.JLabel();
        txtEmail = new com.GUI.swing.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("GIỚI TÍNH");

        buttonGroup1.add(rdonam);
        rdonam.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        rdonam.setText("Nam");

        buttonGroup1.add(rdonu);
        rdonu.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        rdonu.setText("Nữ");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("CHỨC VỤ");

        buttonGroup2.add(rdoquanly);
        rdoquanly.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        rdoquanly.setText("Quản Lý");

        buttonGroup2.add(rdonhanvien);
        rdonhanvien.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        rdonhanvien.setText("Nhân Viên");

        btnthem.setBackground(new java.awt.Color(255, 0, 0));
        btnthem.setBorder(null);
        btnthem.setForeground(new java.awt.Color(255, 255, 255));
        btnthem.setText("THÊM MỚI");
        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btncapnhat.setBackground(new java.awt.Color(255, 0, 0));
        btncapnhat.setBorder(null);
        btncapnhat.setForeground(new java.awt.Color(255, 255, 255));
        btncapnhat.setText("CẬP NHẬT");
        btncapnhat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btncapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatActionPerformed(evt);
            }
        });

        btnlammoi.setBackground(new java.awt.Color(255, 0, 0));
        btnlammoi.setBorder(null);
        btnlammoi.setForeground(new java.awt.Color(255, 255, 255));
        btnlammoi.setText("LÀM MỚI");
        btnlammoi.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(255, 0, 0));
        btnxoa.setBorder(null);
        btnxoa.setForeground(new java.awt.Color(255, 255, 255));
        btnxoa.setText("XÓA");
        btnxoa.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        txtMaNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaNhanVien.setPreferredSize(new java.awt.Dimension(6, 45));

        txtTenNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTenNV.setPreferredSize(new java.awt.Dimension(6, 45));

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSDT.setPreferredSize(new java.awt.Dimension(6, 45));

        btnresestpassword.setBackground(new java.awt.Color(255, 0, 0));
        btnresestpassword.setBorder(null);
        btnresestpassword.setForeground(new java.awt.Color(255, 255, 255));
        btnresestpassword.setText("RESET PASSWORD");
        btnresestpassword.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnresestpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresestpasswordActionPerformed(evt);
            }
        });

        tblnhanvien.setAutoCreateRowSorter(true);
        tblnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên", "SĐT", "Email", "Giới tính", "Chức vụ"
            }
        ));
        tblnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnhanvienMouseClicked(evt);
            }
        });
        tblnhanvien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblnhanvienKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblnhanvien);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 0, 0));
        btnSearch.setBorder(null);
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("TÌM KIẾM");
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtghichu.setColumns(20);
        txtghichu.setRows(5);
        jScrollPane2.setViewportView(txtghichu);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("GHI CHÚ");

        lbavatar.setBackground(new java.awt.Color(255, 255, 255));
        lbavatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        lbavatar.setMaximumSize(new java.awt.Dimension(231, 284));
        lbavatar.setMinimumSize(new java.awt.Dimension(231, 284));
        lbavatar.setPreferredSize(new java.awt.Dimension(231, 284));
        lbavatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbavatarMouseClicked(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(6, 45));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(btnxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btncapnhat, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(btnlammoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnresestpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbavatar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoquanly)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdonhanvien))
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdonam)
                                .addGap(57, 57, 57)
                                .addComponent(rdonu)
                                .addGap(79, 79, 79)))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(511, 511, 511))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lbavatar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdonam)
                                    .addComponent(rdonu))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(btnresestpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdonhanvien)
                                    .addComponent(rdoquanly))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        AddEntity();
        Main.saoLuu.logNV();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btncapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatActionPerformed
        UpdateEntity();
        Main.saoLuu.logNV();
    }//GEN-LAST:event_btncapnhatActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá nhân viên này?");
        if (i == 0) {
            DeleteEntity();
            Main.saoLuu.logNV();
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        RefreshGui();
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void lbavatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbavatarMouseClicked
        if (evt.getClickCount() == 2) {
            chooseImageAvatar();
        }
    }//GEN-LAST:event_lbavatarMouseClicked

    private void tblnhanvienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblnhanvienKeyReleased
        FillToComp();
    }//GEN-LAST:event_tblnhanvienKeyReleased

    private void tblnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnhanvienMouseClicked
        FillToComp();
    }//GEN-LAST:event_tblnhanvienMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Search();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnresestpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresestpasswordActionPerformed
        ResestPass();
    }//GEN-LAST:event_btnresestpasswordActionPerformed

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        Search2();
    }//GEN-LAST:event_txtSearchCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.swing.Button btnSearch;
    private com.GUI.swing.Button btncapnhat;
    private com.GUI.swing.Button btnlammoi;
    private com.GUI.swing.Button btnresestpassword;
    private com.GUI.swing.Button btnthem;
    private com.GUI.swing.Button btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbavatar;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonhanvien;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JRadioButton rdoquanly;
    private com.GUI.swing.Table tblnhanvien;
    private com.GUI.swing.TextField txtEmail;
    private com.GUI.swing.TextField txtMaNhanVien;
    private com.GUI.swing.TextField txtSDT;
    private com.GUI.swing.TextField txtSearch;
    private com.GUI.swing.TextField txtTenNV;
    private javax.swing.JTextArea txtghichu;
    // End of variables declaration//GEN-END:variables
    private void LoadInit() {
        txtMaNhanVien.setLabelText("Mã Nhân Viên");
        txtMaNhanVien.setEditable(false);
        txtTenNV.setLabelText("Tên Nhân Viên");
        txtSDT.setLabelText("Số Điện Thoại");
        txtEmail.setLabelText("Email");
        txtSearch.setLabelText("Tìm Kiếm Nhân Viên");
        rdonam.setSelected(true);
        rdoquanly.setSelected(true);
        SetIMG(null);
    }

    public void FillTable() {
        list = null;
        list = new NhanVienDAO().selectAll();
        modeltable = (DefaultTableModel) tblnhanvien.getModel();
        modeltable.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            modeltable.addRow(
                    new Object[]{list.get(i).getMaNhanVien(), list.get(i).getHoTen(), list.get(i).getSDT(), list.get(i).getEmail(), list.get(i).getGioiTinh(), list.get(i).getChucVu()});
        }
        modeltable.fireTableDataChanged();
    }

    public void fillTableByKey(String key) {
        list = null;
        list = new NhanVienDAO().selectbykey(key);
        modeltable = (DefaultTableModel) tblnhanvien.getModel();
        modeltable.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            modeltable.addRow(
                    new Object[]{list.get(i).getMaNhanVien(), list.get(i).getHoTen(), list.get(i).getSDT(), list.get(i).getEmail(), list.get(i).getGioiTinh(), list.get(i).getChucVu()});
        }
        modeltable.fireTableDataChanged();
    }

    private void FillToComp() {
        int index = tblnhanvien.getSelectedRow();
        if (index != -1) {
            NhanVien fill = getNhanVienFromTable(index);
            txtMaNhanVien.setText(fill.getMaNhanVien());
            txtTenNV.setText(fill.getHoTen());
            txtSDT.setText(fill.getSDT());
            txtEmail.setText(fill.getEmail());
            rdonu.setSelected(true);
            if (fill.isGioiTinh()) {
                rdonam.setSelected(true);
            }
            rdonhanvien.setSelected(true);
            if (fill.isChucVu()) {
                rdoquanly.setSelected(true);
            }
            txtEmail.setText(fill.getEmail());
            HinhTam = fill.getHinh();
            SetIMG(HinhTam);
            txtghichu.setText(fill.getGhiChu());
        }
        if (index > tblnhanvien.getRowCount()) {
            index = 0;
            tblnhanvien.setSelectionMode(index);
        }
        if (index < 0) {
            index = tblnhanvien.getRowCount();
            tblnhanvien.setSelectionMode(index);
        }
    }

    private NhanVien getNhanVienFromTable(int index) {
        String Manv = tblnhanvien.getValueAt(index, 0).toString();
        for (int i = 0; i < list.size(); i++) {
            if (Manv.equals(list.get(i).getMaNhanVien())) {
                return list.get(i);
            }
        }
        return null;
    }

    private boolean ValidateForm() {
        if (vld.CheckString("Tên Nhân Viên", txtTenNV.getText(), 100, false)
                && vld.CheckString("Số Điện Thoại", txtSDT.getText(), 10, true)
                && vld.RegexPhoneNumber("Số Điện Thoại", txtSDT.getText())
                && vld.CheckString("Email", txtEmail.getText(), 100, false)
                && vld.CheckString("Hình Nhân Viên", HinhTam, -1, false)) {
            return true;
        }
        return false;

    }

    private NhanVien GetNhanVienFromGui() {
        NhanVien obj = new NhanVien();
        obj.setMaNhanVien(txtMaNhanVien.getText());
        obj.setHoTen(txtTenNV.getText());
        obj.setSDT(txtSDT.getText());
        obj.setEmail(txtEmail.getText());
        obj.setChucVu(rdonam.isSelected() ? true : false);
        obj.setGioiTinh(rdoquanly.isSelected() ? true : false);
        obj.setGhiChu(txtghichu.getText());
        obj.setHinh(HinhTam);
        MaNV = obj.getMaNhanVien();
        return obj;
    }

    private void chooseImageAvatar() {
        File file = xImage.getImageFile(HinhTam);
        if (file != null) {
            xImage.saveImageNhanVien(file);
            HinhTam = file.getName();
            SetIMG(HinhTam);
        }
    }

    private void SetIMG(String image) {
        if (image != null) {
            xImage.ReadAndScaleIMG(lbavatar, "/imageNhanVien/" + image, 231, 284);
            return;
        }
        HinhTam = "";
        xImage.ReadAndScaleIMG(lbavatar, "/imageNhanVien/myprofile.jpg", 231, 284);

    }

    private void AddEntity() {
        if (ValidateForm()) {
            try {
                nvdao.insert(GetNhanVienFromGui());
                JOptionPane.showMessageDialog(this, "Thêm Mới Thành Công");
                FillTable();
                RefreshGui();
                add_NV = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm Mới Không Thành Công");
            }
        }
    }

    private void UpdateEntity() {
        int index = tblnhanvien.getSelectedRow();
        if (index != -1 && ValidateForm()) {
            try {
                nvdao.update(GetNhanVienFromGui());
                JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công");
                FillTable();
                RefreshGui();
                sua_NV = true;
                MaNV = tblnhanvien.getValueAt(index, 0).toString();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Cập Nhật Không Thành Công");
            }
        }
    }

    private void DeleteEntity() {
        int index = tblnhanvien.getSelectedRow();
        if (index != -1) {
            if (tblnhanvien.getValueAt(index, 0).toString().equals(Auth.user.getMaNhanVien())) {
                JOptionPane.showMessageDialog(this, "Bạn không thể xoá chính mình.");
            } else {
                try {
                    nvdao.delete(tblnhanvien.getValueAt(index, 0).toString());
                    JOptionPane.showMessageDialog(this, "Xóa Nhân Viên Thành Công");
                    xoa_NV = true;
                    MaNV = tblnhanvien.getValueAt(index, 0).toString();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Xóa Nhân Viên Không Thành Công");
                }
            }
        }
        FillTable();
    }

    private void RefreshGui() {
        txtMaNhanVien.setText("");
        txtTenNV.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        rdonam.setSelected(true);
        rdoquanly.setSelected(true);
        HinhTam = "";
        SetIMG(null);
        txtghichu.setText("");
        txtSearch.setText("");
        FillTable();
    }

    private void Search() {
        String key = txtSearch.getText();
        try {
            fillTableByKey(key);
            tblnhanvien.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy Nhân Viên");
        }
    }

    private void ResestPass() {
        int index = tblnhanvien.getSelectedRow();
        if (index != -1) {
            try {
                NhanVien pass = new NhanVien();
                pass.setMaNhanVien(tblnhanvien.getValueAt(index, 0).toString());
                pass.setMatKhau("123");
                nvdao.UpdatePassword(pass);
                JOptionPane.showMessageDialog(this, "Khôi Phục Mật Khẩu Mặc Định Thành Công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Khôi Phục Mật Khẩu Mặc Định Không Thành Công");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa Chọn Nhân Viên");
        }
    }

    private void Search2() {
        try {
            TableRowSorter<DefaultTableModel> ts = new TableRowSorter<>(modeltable);
            tblnhanvien.setRowSorter(ts);
            ts.setRowFilter(RowFilter.regexFilter(txtSearch.getText().toUpperCase()));
        } catch (Exception e) {
            modeltable.setRowCount(0);
            tblnhanvien.setModel(modeltable);
        }
    }
}
