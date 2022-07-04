package com.GUI.form.KhachHangThanThiet;

import Entity.*;
import DAO.*;
import Utilities.*;
import com.GUI.main.Main;
import com.GUI.swing.ScrollBar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class KhachHangThanThiet_Form extends javax.swing.JPanel {

    private DefaultTableModel modeltable;
    private List<KHTT> list;
    private ValidateCheck vld = new ValidateCheck();
    private KHTTDAO khdao = new KHTTDAO();
    private NhanVien nv;
    public static boolean add_KHTT = false;
    public static boolean xoa_KHTT = false;
    public static boolean sua_KHTT = false;
    public static String MaKHTT;
    private String luuMaKHTT;

    public KhachHangThanThiet_Form() {
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
        btnthem = new com.GUI.swing.Button();
        btncapnhat = new com.GUI.swing.Button();
        btnlammoi = new com.GUI.swing.Button();
        btnxoa = new com.GUI.swing.Button();
        txtMaKhachHang = new com.GUI.swing.TextField();
        txtTenKH = new com.GUI.swing.TextField();
        txtSDT = new com.GUI.swing.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkhachhangthanthiet = new com.GUI.swing.Table();
        txtSearch = new com.GUI.swing.TextField();
        btnSearch = new com.GUI.swing.Button();
        txtEmail = new com.GUI.swing.TextField();
        txtMucGiamGia = new com.GUI.swing.TextField();
        txtsolansudung = new com.GUI.swing.TextField();
        DateNgayDK = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Khách Hàng VIP");

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

        txtMaKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblkhachhangthanthiet.setAutoCreateRowSorter(true);
        tblkhachhangthanthiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Tên Khách Hàng", "SĐT", "Email", "Giảm Giá", "SLOT", "Ngày Tạo"
            }
        ));
        tblkhachhangthanthiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhachhangthanthietMouseClicked(evt);
            }
        });
        tblkhachhangthanthiet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblkhachhangthanthietKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblkhachhangthanthiet);
        if (tblkhachhangthanthiet.getColumnModel().getColumnCount() > 0) {
            tblkhachhangthanthiet.getColumnModel().getColumn(0).setMaxWidth(80);
            tblkhachhangthanthiet.getColumnModel().getColumn(1).setMinWidth(150);
        }

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

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMucGiamGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtsolansudung.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Ngày Đăng Kí:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(DateNgayDK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                        .addComponent(txtsolansudung, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMucGiamGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btncapnhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(533, 533, 533))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtsolansudung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(DateNgayDK, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        AddEntity();
	Main.saoLuu.logKHTT();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btncapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatActionPerformed
        UpdateEntity();
	Main.saoLuu.logKHTT();
    }//GEN-LAST:event_btncapnhatActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        if (Auth.isManager()) {
            DeleteEntity();
            Main.saoLuu.logKHTT();
        } else {
           JOptionPane.showMessageDialog(null, "Chỉ Quản lý mới được sử dụng chức năng này.");
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        RefreshGui();
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void tblkhachhangthanthietKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblkhachhangthanthietKeyReleased
        FillToComp();
    }//GEN-LAST:event_tblkhachhangthanthietKeyReleased

    private void tblkhachhangthanthietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachhangthanthietMouseClicked
        FillToComp();
    }//GEN-LAST:event_tblkhachhangthanthietMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Search();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        Search2();
    }//GEN-LAST:event_txtSearchCaretUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateNgayDK;
    private com.GUI.swing.Button btnSearch;
    private com.GUI.swing.Button btncapnhat;
    private com.GUI.swing.Button btnlammoi;
    private com.GUI.swing.Button btnthem;
    private com.GUI.swing.Button btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.GUI.swing.Table tblkhachhangthanthiet;
    private com.GUI.swing.TextField txtEmail;
    private com.GUI.swing.TextField txtMaKhachHang;
    private com.GUI.swing.TextField txtMucGiamGia;
    private com.GUI.swing.TextField txtSDT;
    private com.GUI.swing.TextField txtSearch;
    private com.GUI.swing.TextField txtTenKH;
    private com.GUI.swing.TextField txtsolansudung;
    // End of variables declaration//GEN-END:variables
    private void LoadInit() {
        txtMaKhachHang.setLabelText("Mã Khách Hàng");
        txtMaKhachHang.setEditable(false);
        txtTenKH.setLabelText("Tên Khách Hàng");
        txtSDT.setLabelText("Số Điện Thoại");
        txtEmail.setLabelText("Địa Chỉ Email");
        txtsolansudung.setLabelText("Số Lần Sử Dụng");
        txtMucGiamGia.setLabelText("Mức Giảm Giá(%)");
        txtSearch.setLabelText("Tìm Kiếm Khách Hàng");
        DateNgayDK.setDate(XDate.now());
        DateNgayDK.setEnabled(false);
    }

    public void FillTable() {
        list = null;
        list = new KHTTDAO().selectAll();
        modeltable = (DefaultTableModel) tblkhachhangthanthiet.getModel();
        modeltable.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            modeltable.addRow(
                    new Object[]{list.get(i).getMAKHTT(), list.get(i).getTen(), list.get(i).getSDT(), list.get(i).getEmail(), list.get(i).getMucGiacGia(), list.get(i).getSoLanSuDung(), list.get(i).getNgayDK()});
        }
        modeltable.fireTableDataChanged();
    }

    public void fillTableByKey(String key) {
        list = null;
        list = new KHTTDAO().selectbykey(key);
        modeltable = (DefaultTableModel) tblkhachhangthanthiet.getModel();
        modeltable.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            modeltable.addRow(
                    new Object[]{list.get(i).getMAKHTT(), list.get(i).getTen(), list.get(i).getSDT(), list.get(i).getEmail(), list.get(i).getMucGiacGia(), list.get(i).getSoLanSuDung(), list.get(i).getNgayDK()});
        }
        modeltable.fireTableDataChanged();
    }

    private void FillToComp() {
        int index = tblkhachhangthanthiet.getSelectedRow();
        if (index != -1) {
            KHTT fill = getKhachHangFromTable(index);
            txtMaKhachHang.setText(fill.getMAKHTT());
            txtTenKH.setText(fill.getTen());
            txtSDT.setText(fill.getSDT());
            txtEmail.setText(fill.getEmail());
            txtsolansudung.setText(String.valueOf(fill.getSoLanSuDung()));
            txtMucGiamGia.setText(String.valueOf(fill.getMucGiacGia()));
            DateNgayDK.setDate(fill.getNgayDK());
            DateNgayDK.setEnabled(true);
        }
    }

    private KHTT getKhachHangFromTable(int index) {
        String Makh = tblkhachhangthanthiet.getValueAt(index, 0).toString();
        for (int i = 0; i < list.size(); i++) {
            if (Makh.equals(list.get(i).getMAKHTT())) {
                return list.get(i);
            }
        }
        return null;
    }

    private boolean ValidateForm() {
        if (vld.CheckString("Tên Khách Hàng", txtTenKH.getText(), 50, false)
                && vld.CheckString("Số Điện Thoại", txtSDT.getText(), 10, true)
                && vld.RegexPhoneNumber("Số Điện Thoại", txtSDT.getText())
                && vld.CheckString("Email", txtEmail.getText(), 255, false)
                && vld.RegexEmail("Email", txtEmail.getText())
                && vld.CheckString("Mức Giảm Giá", txtMucGiamGia.getText(), -1, false)
                && vld.CheckFloat("Mức Giảm Giá", txtMucGiamGia.getText())
                && vld.CheckString("Số Lần Sử Dụng", txtsolansudung.getText(), -1, false)
                && vld.CheckInt("Số Lần Sử Dụng", txtsolansudung.getText())
                && vld.CheckNullDate("Ngày Đăng Kí", DateNgayDK.getDate())) {
            return true;
        }
        return false;

    }

    private KHTT GetKhachHangFromGui() {
        KHTT obj = new KHTT();
        obj.setMAKHTT(txtMaKhachHang.getText());
        obj.setTen(txtTenKH.getText());
        obj.setSDT(txtSDT.getText());
        obj.setEmail(txtEmail.getText());
        obj.setMucGiacGia(Double.valueOf(txtMucGiamGia.getText()));
        obj.setSoLanSuDung(Integer.valueOf(txtsolansudung.getText()));
        obj.setNgayDK(DateNgayDK.getDate());
        obj.setMaNhanVien(nv.getMaNhanVien());
	luuMaKHTT = obj.getMAKHTT();
        return obj;
    }

    private void AddEntity() {
        if (ValidateForm()) {
            try {
                khdao.insert(GetKhachHangFromGui());
                JOptionPane.showMessageDialog(this, "Thêm Mới Thành Công");
		add_KHTT = true;
		MaKHTT = luuMaKHTT;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm Mới Không Thành Công");
            }
        }
        FillTable();
    }

    private void UpdateEntity() {
        int index = tblkhachhangthanthiet.getSelectedRow();
        if (index != -1 && ValidateForm()) {
            try {
                khdao.update(GetKhachHangFromGui());
                JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công");
		sua_KHTT = true;
		MaKHTT = tblkhachhangthanthiet.getValueAt(index, 0).toString();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Cập Nhật Không Thành Công");
            }
        }
        FillTable();
    }

    private void DeleteEntity() {
        int index = tblkhachhangthanthiet.getSelectedRow();
        if (index != -1) {
            try {
                khdao.delete(tblkhachhangthanthiet.getValueAt(index, 0).toString());
                JOptionPane.showMessageDialog(this, "Xóa Thành Công");
		xoa_KHTT = true;
		MaKHTT = tblkhachhangthanthiet.getValueAt(index, 0).toString();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa Không Thành Công");
            }
        }
        FillTable();
    }

    private void RefreshGui() {
        txtMaKhachHang.setText("");
        txtTenKH.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtMucGiamGia.setText("");
        txtsolansudung.setText("");
        txtSearch.setText("");
        DateNgayDK.setDate(XDate.now());
        DateNgayDK.setEnabled(false);
        FillTable();
    }

    private void Search() {
        String key = txtSearch.getText();
        try {
            fillTableByKey(key);
            tblkhachhangthanthiet.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy Khách Hàng");
        }
    }

    private void Search2() {
        try {
            TableRowSorter<DefaultTableModel> ts = new TableRowSorter<>(modeltable);
            tblkhachhangthanthiet.setRowSorter(ts);
            ts.setRowFilter(RowFilter.regexFilter(txtSearch.getText().toUpperCase()));
        } catch (Exception e) {
            if (txtSearch.getText().equals("")) {
                FillTable();
            }
            modeltable.setRowCount(0);
            tblkhachhangthanthiet.setModel(modeltable);
        }
    }

    public void setNV(NhanVien nv) {
        this.nv = nv;
    }
}
