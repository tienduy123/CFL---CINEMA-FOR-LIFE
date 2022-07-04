package com.GUI.form.BanVe;

import DAO.DichVuDAO;
import DAO.HDCTDAO;
import DAO.HoaDonDAO;
import DAO.KHTTDAO;
import DAO.KhuyenMaiDAO;
import DAO.LichChieuDAO;
import DAO.PhimDAO;
import DAO.VeDAO;
import Entity.Ghe;
import Entity.HDCT;
import Entity.HoaDon;
import Entity.LichChieu;
import Entity.Phim;
import Entity.Ve;
import Utilities.XDate;
import Utilities.XImage;
import com.GUI.form.KhachHangThanThiet.KhachHangThanThiet_Form;
import com.GUI.main.Main;
import com.GUI.swing.ScrollBar;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BanVe_Form extends javax.swing.JPanel {

    private XImage xImage = new XImage();
    private LichChieuDAO lcDAO = new LichChieuDAO();
    private KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
    private HoaDonDAO hdDAO = new HoaDonDAO();
    private PhimDAO phDAO = new PhimDAO();
    private DichVuDAO dvDAO = new DichVuDAO();
    private HDCTDAO hdctDAO = new HDCTDAO();
    public static KHTTDAO khttdao = new KHTTDAO();
    public static List<String> khttList = new ArrayList<>();
    public static List<Ve> velList = new ArrayList<>();
    public static String MaPhong;
    public static String GioChieu;
    public static String maHDNow = "";
    public static String MaHDTuHDCT;
    public static String MaKM;
    public static String MaKHTT;
    private boolean checkDel = false;
    private String[] header = {
        "Mã vé/DV", "Số lượng", "Giá tiền", "Thành tiền", "Mã HD"
    };
    private DefaultTableModel model = new DefaultTableModel(header, 0);

    public BanVe_Form() {
        initComponents();
        init();
        jScrollPane1.setVerticalScrollBar(new ScrollBar());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonCT = new com.GUI.swing.Table();
        btnXuatHD = new com.GUI.swing.Button();
        jLabel1 = new javax.swing.JLabel();
        cboPhim = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        chkPhieuGG = new javax.swing.JCheckBox();
        cboPhieuGG = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        panelDichVu = new javax.swing.JPanel();
        lblImageBap = new javax.swing.JLabel();
        lblImageNuoc = new javax.swing.JLabel();
        lblImageCB1 = new javax.swing.JLabel();
        lblImageCB2 = new javax.swing.JLabel();
        spnBap = new javax.swing.JSpinner();
        spnNuoc = new javax.swing.JSpinner();
        spnCombo1 = new javax.swing.JSpinner();
        spnCombo2 = new javax.swing.JSpinner();
        btnXuLy = new com.GUI.swing.Button();
        btnThemDichVu = new com.GUI.swing.Button();
        btnChuyen = new com.GUI.swing.Button();
        txtMaKHTT = new com.GUI.swing.TextField();
        cboPhongChieu = new javax.swing.JComboBox<>();
        lblCheckMa = new javax.swing.JLabel();
        btnNewHD = new com.GUI.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDonCT.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        tblHoaDonCT.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tblHoaDonCT.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(tblHoaDonCT);

        btnXuatHD.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatHD.setText("XUẤT HÓA ĐƠN");
        btnXuatHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("HÓA ĐƠN CHI TIẾT");

        cboPhim.setBackground(new java.awt.Color(224, 224, 224));
        cboPhim.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        cboPhim.setForeground(new java.awt.Color(204, 204, 204));
        cboPhim.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 51, 51)));
        cboPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhimActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("PHIM");

        chkPhieuGG.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        chkPhieuGG.setForeground(new java.awt.Color(255, 51, 51));
        chkPhieuGG.setText("Thêm phiếu giảm giá");
        chkPhieuGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPhieuGGActionPerformed(evt);
            }
        });

        cboPhieuGG.setBackground(new java.awt.Color(224, 224, 224));
        cboPhieuGG.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        cboPhieuGG.setForeground(new java.awt.Color(51, 51, 51));
        cboPhieuGG.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 51, 51)));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("PHIẾU GIẢM GIÁ");

        panelDichVu.setBackground(new java.awt.Color(224, 224, 224));

        lblImageBap.setForeground(new java.awt.Color(255, 153, 153));
        lblImageBap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageBap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        lblImageBap.setMaximumSize(new java.awt.Dimension(142, 159));
        lblImageBap.setMinimumSize(new java.awt.Dimension(142, 159));
        lblImageBap.setPreferredSize(new java.awt.Dimension(142, 159));

        lblImageNuoc.setForeground(new java.awt.Color(255, 153, 153));
        lblImageNuoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageNuoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        lblImageNuoc.setMaximumSize(new java.awt.Dimension(142, 159));
        lblImageNuoc.setMinimumSize(new java.awt.Dimension(142, 159));
        lblImageNuoc.setPreferredSize(new java.awt.Dimension(142, 159));

        lblImageCB1.setForeground(new java.awt.Color(255, 153, 153));
        lblImageCB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageCB1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        lblImageCB1.setMaximumSize(new java.awt.Dimension(142, 159));
        lblImageCB1.setMinimumSize(new java.awt.Dimension(142, 159));
        lblImageCB1.setPreferredSize(new java.awt.Dimension(142, 159));

        lblImageCB2.setForeground(new java.awt.Color(255, 153, 153));
        lblImageCB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageCB2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        lblImageCB2.setMaximumSize(new java.awt.Dimension(142, 159));
        lblImageCB2.setMinimumSize(new java.awt.Dimension(142, 159));
        lblImageCB2.setPreferredSize(new java.awt.Dimension(142, 159));

        spnBap.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        spnBap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 51, 51)));

        spnNuoc.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        spnNuoc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 51, 51)));

        spnCombo1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        spnCombo1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 51, 51)));

        spnCombo2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        spnCombo2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 51, 51)));

        javax.swing.GroupLayout panelDichVuLayout = new javax.swing.GroupLayout(panelDichVu);
        panelDichVu.setLayout(panelDichVuLayout);
        panelDichVuLayout.setHorizontalGroup(
            panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDichVuLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnBap)
                    .addComponent(lblImageBap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImageNuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spnNuoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImageCB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spnCombo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImageCB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spnCombo2))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelDichVuLayout.setVerticalGroup(
            panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDichVuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImageBap, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImageNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImageCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImageCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnBap, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnXuLy.setForeground(new java.awt.Color(255, 255, 255));
        btnXuLy.setText("XỬ LÝ");
        btnXuLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuLyActionPerformed(evt);
            }
        });

        btnThemDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnThemDichVu.setText("THÊM DỊCH VỤ");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        btnChuyen.setForeground(new java.awt.Color(255, 255, 255));
        btnChuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/GUI/icon/icons8_right_40px.png"))); // NOI18N
        btnChuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenActionPerformed(evt);
            }
        });

        txtMaKHTT.setInheritsPopupMenu(true);
        txtMaKHTT.setLabelText("Mã KHTT");
        txtMaKHTT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaKHTTKeyReleased(evt);
            }
        });

        cboPhongChieu.setBackground(new java.awt.Color(224, 224, 224));
        cboPhongChieu.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        cboPhongChieu.setForeground(new java.awt.Color(204, 204, 204));
        cboPhongChieu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 51, 51)));

        lblCheckMa.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblCheckMa.setForeground(new java.awt.Color(51, 51, 51));

        btnNewHD.setForeground(new java.awt.Color(255, 255, 255));
        btnNewHD.setText("HOÁ ĐƠN MỚI");
        btnNewHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(cboPhieuGG, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkPhieuGG)
                            .addComponent(cboPhongChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaKHTT, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addComponent(btnChuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblCheckMa, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(panelDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(263, 263, 263)
                                .addComponent(btnXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNewHD, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(btnXuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKHTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCheckMa, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(cboPhongChieu))
                        .addGap(16, 16, 16)
                        .addComponent(chkPhieuGG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPhieuGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewHD, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        checkDichVu(true);
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void chkPhieuGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPhieuGGActionPerformed
        if (checkPhieuGiamGia())
            cboPhieuGG.setEnabled(true);
        else
            cboPhieuGG.setEnabled(false);
    }//GEN-LAST:event_chkPhieuGGActionPerformed

    private void btnXuLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuLyActionPerformed
        xuLyDuLieu();
    }//GEN-LAST:event_btnXuLyActionPerformed

    private void btnXuatHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHDActionPerformed

        if (!maHDNow.equals("")) {
            if (model.getRowCount() != 0) {
                DefaultComboBoxModel cbxModel = (DefaultComboBoxModel) cboPhieuGG.getModel();
                String tmp = cbxModel.getSelectedItem().toString().trim();
                if (!tmp.equals("-")) {
                    MaKM = tmp;
                } else {
                    MaKM = null;
                }
                if (lblCheckMa.getText().equals("Mã hợp lệ")) {
                    MaKHTT = txtMaKHTT.getText().trim();
                } else {
                    MaKHTT = null;
                }
                Main.hoaDon.tinhTien();
                HoaDon_Form.txtMaHD.setText(BanVe_Form.maHDNow);
                HoaDon_Form.txtThanhTien.setText("" + HoaDon_Form.thanhTien);
                Main.hoaDon.loadDatabase();
                Main.main.showForm(Main.hoaDon);
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn dịch vụ.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa tạo hoá đơn.");
        }


    }//GEN-LAST:event_btnXuatHDActionPerformed

    private void btnChuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenActionPerformed
        if (!maHDNow.equals("")) {
            String tmp = cboPhongChieu.getSelectedItem().toString().trim();
            if (!tmp.equals("-")) {
                MaPhong = tmp.substring(0, tmp.indexOf(" ")).trim();
                GioChieu = tmp.substring(2).trim();
                Main.main.showForm(new ChonGhe_Form());
            } else {
                JOptionPane.showMessageDialog(null, "Chọn phim");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa tạo hoá đơn.");
        }

    }//GEN-LAST:event_btnChuyenActionPerformed

    private void cboPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhimActionPerformed
        comboBoxPhongChieu();
    }//GEN-LAST:event_cboPhimActionPerformed

    private void txtMaKHTTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKHTTKeyReleased
        checkMaKHTT();
    }//GEN-LAST:event_txtMaKHTTKeyReleased

    private void btnNewHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewHDActionPerformed
        if (checkDel) {
            deleteHDnow();
            checkDel = false;
        } else {
            HoaDon hd = new HoaDon();
            hd.setHIDE(false);
            hd.setNgayLap(XDate.now());
            hd.setTrangThai(false);
            hdDAO.insert(hd);
            maHDNow = hdDAO.selectNewHD();
            btnNewHD.setText("Cancel: " + maHDNow);
            checkDel = true;
        }
    }//GEN-LAST:event_btnNewHDActionPerformed

    // MAIN FUNCTIONAL
    private void init() {
        loadDatabase();
        spnBap.setToolTipText("BAP");
        spnNuoc.setToolTipText("NUOC");
        spnCombo1.setToolTipText("COMBO1");
        spnCombo2.setToolTipText("COMBO2");
        txtMaKHTT.setLabelText("Mã KHTT");
        tblHoaDonCT.setModel(model);
        cboPhieuGG.setEnabled(false);
        checkDichVu(false);
        comboBoxPhim();
        comboBoxPhieuGiamGia();
        khttList = khttdao.selectMaKHTT();
        spnBap.setSize(0, 100);
        spnNuoc.setSize(0, 100);
        spnCombo1.setSize(0, 100);
        spnCombo2.setSize(0, 100);
        Icon icon1 = new ImageIcon(new ImageIcon(getClass().getResource("/com/GUI/icon/bap.png")).getImage().getScaledInstance(142, 159, Image.SCALE_SMOOTH));
        lblImageBap.setIcon(icon1);
        icon1 = new ImageIcon(new ImageIcon(getClass().getResource("/com/GUI/icon/nuoclon.png")).getImage().getScaledInstance(142, 159, Image.SCALE_SMOOTH));
        lblImageNuoc.setIcon(icon1);
        icon1 = new ImageIcon(new ImageIcon(getClass().getResource("/com/GUI/icon/combo1.png")).getImage().getScaledInstance(142, 159, Image.SCALE_SMOOTH));
        lblImageCB1.setIcon(icon1);
        icon1 = new ImageIcon(new ImageIcon(getClass().getResource("/com/GUI/icon/combo2.png")).getImage().getScaledInstance(142, 159, Image.SCALE_SMOOTH));
        lblImageCB2.setIcon(icon1);
    }

    public void loadDatabase() {
        model.setRowCount(0);
        try {
            List<HDCT> list = hdctDAO.selectByID(maHDNow);
            for (HDCT hdct : list) {
                Object[] row = {
                    hdct.getMaDichVu(),
                    hdct.getSoLuong(),
                    hdct.getGiaTien(),
                    hdct.getThanhTien(),
                    hdct.getMaHoaDon()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void xuLyDuLieu() {
        try {
            insertDichVu();
            loadDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertDichVu() {
        HDCT hdct = new HDCT();

        int bap = (int) spnBap.getValue();
        int nuoc = (int) spnNuoc.getValue();
        int cb1 = (int) spnCombo1.getValue();
        int cb2 = (int) spnCombo2.getValue();

        double giaBap = bap * dvDAO.selectByMaDichVu(spnBap.getToolTipText().trim());
        double giaNuoc = nuoc * dvDAO.selectByMaDichVu(spnNuoc.getToolTipText().trim());
        double giaCB1 = cb1 * dvDAO.selectByMaDichVu(spnCombo1.getToolTipText().trim());
        double giaCB2 = cb2 * dvDAO.selectByMaDichVu(spnCombo2.getToolTipText().trim());

        hdct.setHIDE(false);
        hdct.setMaHoaDon(maHDNow);
        if (bap > 0) {
            hdct.setMaDichVu(spnBap.getToolTipText().trim());
            hdct.setGiaTien(25000);
            hdct.setSoLuong(bap);
            hdct.setThanhTien(giaBap);
            hdctDAO.insertDichVu(hdct);
        }
        if (nuoc > 0) {
            hdct.setMaDichVu(spnNuoc.getToolTipText().trim());
            hdct.setGiaTien(25000);
            hdct.setSoLuong(nuoc);
            hdct.setThanhTien(giaNuoc);
            hdctDAO.insertDichVu(hdct);
        }
        if (cb1 > 0) {
            hdct.setMaDichVu(spnCombo1.getToolTipText().trim());
            hdct.setGiaTien(50000);
            hdct.setSoLuong(cb1);
            hdct.setThanhTien(giaCB1);
            hdctDAO.insertDichVu(hdct);
        }
        if (cb2 > 0) {
            hdct.setMaDichVu(spnCombo2.getToolTipText().trim());
            hdct.setGiaTien(75000);
            hdct.setSoLuong(cb2);
            hdct.setThanhTien(giaCB2);
            hdctDAO.insertDichVu(hdct);
        }
    }
    private VeDAO vDAO = new VeDAO();

    public void insertMaVe() {

        HDCT hdct = new HDCT();
        velList.clear();

        String tmp = cboPhim.getSelectedItem().toString();
        String maphim = tmp.substring(0, tmp.indexOf("-")).trim();
        tmp = cboPhongChieu.getSelectedItem().toString();
        String giochieu = tmp.substring(3).trim();
        String malc = lcDAO.selectLCbyTT(maphim, MaPhong, giochieu);

        for (Ghe ghe : ChonGhe_Form.listGheSelected) {
            Ve ve = new Ve();
            ve.setMaghe(ghe.getMaGhe());
            ve.setMalichchieu(malc);
            ve.setMaphong(MaPhong);
            ve.setMaphim(maphim);
            ve.setGiochieu(giochieu);
            vDAO.insert(ve);
        }

        int count = ChonGhe_Form.listGheSelected.size();
        velList = vDAO.selectNewVe(count);

        for (int i = 0; i < velList.size(); i++) {
            Ve ve = velList.get(i);
            hdct.setMaDichVu(ve.getMave());
            hdct.setGiaTien(ChonGhe_Form.listGheSelected.get(i).getGiaGhe());
            hdct.setSoLuong(1);
            hdct.setThanhTien(ChonGhe_Form.listGheSelected.get(i).getGiaGhe());
            hdct.setHIDE(false);
            hdct.setMaHoaDon(maHDNow);
            hdctDAO.insertVe(hdct);
        }
    }

    // SUB-FUNCTIONAL
    private void comboBoxPhim() {
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cboPhim.getModel();
        cboModel.removeAllElements();
        cboModel.addElement("-");
        List<LichChieu> list = lcDAO.selectPhimTheoLichChieu();

        for (LichChieu lc : list) {
            List<Phim> listPh = phDAO.selectPhimTheoLichChieu(lc.getMaPhim());
            cboModel.addElement(lc.getMaPhim() + " - " + listPh.get(0).toString());
        }
    }

    private void comboBoxPhongChieu() {
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cboPhongChieu.getModel();
        cboModel.removeAllElements();
        cboModel.addElement("-");
        String lch = (String) cboPhim.getSelectedItem();
        if (!lch.equals("-")) {
            if (lch != null) {
                List<LichChieu> list = lcDAO.selectPhongChieuTheoPhim(lch.substring(0, lch.indexOf("-")).trim());
                for (LichChieu lc : list) {
                    cboModel.addElement(lc.getMaPhong());
                }
            }
        }
    }

    private void comboBoxPhieuGiamGia() {
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cboPhieuGG.getModel();
        cboModel.removeAllElements();
        cboModel.addElement("-");
        List<String> list = kmDAO.listKhuyenMai();
        for (String km : list) {
            cboModel.addElement(km);
        }
    }

    private boolean checkPhieuGiamGia() {
        if (!chkPhieuGG.isSelected()) {
            return false;
        }
        return true;
    }

    private void checkDichVu(boolean check) {
        spnBap.setEnabled(check);
        spnNuoc.setEnabled(check);
        spnCombo1.setEnabled(check);
        spnCombo2.setEnabled(check);
    }

    private void checkMaKHTT() {
        for (String maKHTT : khttList) {
            if (maKHTT.equals(txtMaKHTT.getText())) {
                lblCheckMa.setText("Mã hợp lệ");
                lblCheckMa.setForeground(Color.green);
                return;
            } else {
                lblCheckMa.setText("Chưa có mã. Đăng kí mới?");
                lblCheckMa.setForeground(Color.red);
                lblCheckMa.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        Main.main.showForm(new KhachHangThanThiet_Form());
                    }
                });
            }
        }
    }

    private void deleteHDnow() {
        maHDNow = "";
        Main.banVe = new BanVe_Form();
        Main.main.showForm(Main.banVe);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.swing.Button btnChuyen;
    private com.GUI.swing.Button btnNewHD;
    private com.GUI.swing.Button btnThemDichVu;
    private com.GUI.swing.Button btnXuLy;
    private com.GUI.swing.Button btnXuatHD;
    private javax.swing.JComboBox<String> cboPhieuGG;
    private javax.swing.JComboBox<String> cboPhim;
    private javax.swing.JComboBox<String> cboPhongChieu;
    private javax.swing.JCheckBox chkPhieuGG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCheckMa;
    private javax.swing.JLabel lblImageBap;
    private javax.swing.JLabel lblImageCB1;
    private javax.swing.JLabel lblImageCB2;
    private javax.swing.JLabel lblImageNuoc;
    private javax.swing.JPanel panelDichVu;
    private javax.swing.JSpinner spnBap;
    private javax.swing.JSpinner spnCombo1;
    private javax.swing.JSpinner spnCombo2;
    private javax.swing.JSpinner spnNuoc;
    private com.GUI.swing.Table tblHoaDonCT;
    private com.GUI.swing.TextField txtMaKHTT;
    // End of variables declaration//GEN-END:variables

}
