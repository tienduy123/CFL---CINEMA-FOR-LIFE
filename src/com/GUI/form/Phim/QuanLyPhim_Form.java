package com.GUI.form.Phim;

import com.GUI.swing.ScrollBar;
import DAO.PhimDAO;
import DAO.TheLoaiDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Entity.Phim;
import Entity.TheLoai;
import Utilities.Auth;
import Utilities.ValidateCheck;
import Utilities.XImage;
import com.GUI.main.Main;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class QuanLyPhim_Form extends javax.swing.JPanel {

//    JFileChooser fileChooser = new JFileChooser();
    DefaultTableModel model;
    DefaultComboBoxModel cbomodelTheLoai = new DefaultComboBoxModel();
    TheLoaiDAO theLoaiDao = new TheLoaiDAO();
    private ValidateCheck vld = new ValidateCheck();
    PhimDAO phimDAO = new PhimDAO();
    private XImage xImage = new XImage();
    public static boolean add_Phim = false;
    public static boolean xoa_Phim = false;
    public static boolean sua_Phim = false;
    public static String MaPHIM;

    public QuanLyPhim_Form() {
        initComponents();
        setOpaque(false);
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        init();
    }

    public void init() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Mã phim", "Tên phim", "Ngày Khởi Chiếu", "Ngày Kết Thúc", "Thể Loại", "Định Dạng", "Quốc Gia"});
        tblPhim.setModel(model);
        jdNgaykc.setDateFormatString("yyyy-MM-dd");
        jdNgaykt.setDateFormatString("yyyy-MM-dd");
        fillcboTheLoai();
        fillTable();
        txtMaPhim.setEnabled(false);
        clear();
    }

    public void fillcboTheLoai() {
        cboTheLoai.setModel(cbomodelTheLoai);
        cbomodelTheLoai.removeAllElements();
        List<TheLoai> list = theLoaiDao.selectAll();
        for (TheLoai theloai : list) {
            cbomodelTheLoai.addElement(theloai); // ko co du lieu dc do vao
        }
    }

    public void fillTableWithList(List<Phim> list) {
        model.setRowCount(0);
        for (Phim ph : list) {
            model.addRow(new Object[]{ph.getMaPhim(), ph.getTenPhim(), ph.getNgayKhoiChieu(), ph.getNgayKetThuc(), ph.getMaTheLoai(), ph.getDinhDang(), ph.getQuocGia()});
        }
    }

    public void fillTable() {
        model.setRowCount(0);
        List<Phim> list = new ArrayList<>();
        list = phimDAO.selectAll();
        fillTableWithList(list);
    }

    public Phim getModel() {
        Phim ph = new Phim();
        ph.setMaPhim(txtMaPhim.getText());
        ph.setTenPhim(txtTenPhim.getText());
        ph.setNgayKhoiChieu(jdNgaykc.getDate());
        ph.setNgayKetThuc(jdNgaykt.getDate());
        ph.setMaTheLoai(((TheLoai) cboTheLoai.getSelectedItem()).getMaTheLoai());
        ph.setDinhDang(txtDinhDang.getText());
        ph.setHinh(txtvideo.getText());
        ph.setQuocGia(txtQuocGia.getText());
	MaPHIM = ph.getMaNhanVien();
        return ph;
    }

    public void setModel(Phim ph) {
        txtMaPhim.setText(ph.getMaPhim());
        txtTenPhim.setText(ph.getTenPhim());
        jdNgaykc.setDate(ph.getNgayKhoiChieu());
        jdNgaykt.setDate(ph.getNgayKetThuc());
        cbomodelTheLoai.setSelectedItem(theLoaiDao.selectById(ph.getMaTheLoai()));
        txtDinhDang.setText(ph.getDinhDang());
        txtvideo.setText(ph.getHinh().substring(ph.getHinh().indexOf("=") + 1, ph.getHinh().length()));
        video1.loadlink(ph.getHinh());
        txtQuocGia.setText(ph.getQuocGia());
    }

    public void them() {
        Phim ph = getModel();
        try {
            if (check(true)) {
                phimDAO.insert(ph);
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                fillTable();
		add_Phim = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
            e.printStackTrace();
        }
    }

    public void sua() {
        int index = tblPhim.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Vui dòng chọn phim cần sửa");
            return;
        } else {
            Phim ph = getModel();
            ph.setMaPhim(tblPhim.getValueAt(index, 0).toString());
            if (check(true)) {
                try {
                    phimDAO.update(ph);
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    fillTable();
		    sua_Phim = true;
		    MaPHIM = tblPhim.getValueAt(index, 0).toString();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");
                    e.printStackTrace();
                }
            }
        }

    }

    public void xoa() {
        int index = tblPhim.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Vui dòng chọn cần xóa");
            return;
        } else {
            int test = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa phim này không ?");
            if (test == 0) {

                try {
		    xoa_Phim = true;
		    MaPHIM = tblPhim.getValueAt(index, 0).toString();
                    phimDAO.delete(tblPhim.getValueAt(index, 0).toString());
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                    fillTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                    e.printStackTrace();
                }

            }
        }
    }

    public boolean check(boolean x) {
        if (x
                
                && vld.CheckString("Tên Phim", txtTenPhim.getText(), 255, false)
                && vld.CheckNullDate("Ngày Khởi Chiếu", jdNgaykc.getDate())
                && vld.CheckNullDate("Ngày Kết Thúc", jdNgaykt.getDate())
                && vld.CheckAfterAndBefore("Ngày Khởi Chiếu", jdNgaykc.getDate(), "Ngày Kết Thúc", jdNgaykt.getDate())
                && vld.CheckString("Định Dạng", txtDinhDang.getText(), 50, false)
                && vld.CheckString("Quốc Gia", txtQuocGia.getText(), 50, false)) {
            return true;
        }
        if (x == false
                && vld.CheckString("Tên Phim", txtTenPhim.getText(), 255, false)
                && vld.CheckNullDate("Ngày Khởi Chiếu", jdNgaykc.getDate())
                && vld.CheckNullDate("Ngày Kết Thúc", jdNgaykt.getDate())
                && vld.CheckAfterAndBefore("Ngày Khởi Chiếu", jdNgaykt.getDate(), "Ngày Kết Thúc", jdNgaykt.getDate())
                && vld.CheckString("Định Dạng", txtDinhDang.getText(), 50, false)
                && vld.CheckString("Quốc Gia", txtQuocGia.getText(), 50, false)) {
            return true;
        }
        return false;
    }
    
    void clear(){
        txtMaPhim.setText("");
        txtQuocGia.setText("");
        txtDinhDang.setText("");
        txtvideo.setText("");
        txtTenPhim.setText("");
        jdNgaykc.setDate(null);
        jdNgaykt.setDate(null);
        video1.loadlink("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhim = new com.GUI.swing.TextField();
        txtTenPhim = new com.GUI.swing.TextField();
        jdNgaykc = new com.toedter.calendar.JDateChooser();
        jdNgaykt = new com.toedter.calendar.JDateChooser();
        cboTheLoai = new javax.swing.JComboBox<>();
        txtDinhDang = new com.GUI.swing.TextField();
        txtQuocGia = new com.GUI.swing.TextField();
        txtvideo = new com.GUI.swing.TextField();
        btnInsert = new com.GUI.swing.Button();
        btnUpdate = new com.GUI.swing.Button();
        btnDelete = new com.GUI.swing.Button();
        btnReset = new com.GUI.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhim = new com.GUI.swing.Table();
        video1 = new com.GUI.form.Phim.video();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(159, 159, 159));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("QUẢN LÝ PHIM");

        txtMaPhim.setBackground(new java.awt.Color(224, 224, 224));
        txtMaPhim.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtMaPhim.setLabelText("Mã phim");
        txtMaPhim.setMaximumSize(new java.awt.Dimension(6, 56));

        txtTenPhim.setBackground(new java.awt.Color(224, 224, 224));
        txtTenPhim.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtTenPhim.setLabelText("Tên phim");
        txtTenPhim.setMaximumSize(new java.awt.Dimension(6, 56));

        jdNgaykc.setBackground(new java.awt.Color(224, 224, 224));
        jdNgaykc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jdNgaykc.setMaximumSize(new java.awt.Dimension(91, 20));
        jdNgaykc.setMinimumSize(new java.awt.Dimension(91, 20));

        jdNgaykt.setBackground(new java.awt.Color(224, 224, 224));
        jdNgaykt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jdNgaykt.setMaximumSize(new java.awt.Dimension(91, 20));
        jdNgaykt.setMinimumSize(new java.awt.Dimension(91, 20));

        cboTheLoai.setBackground(new java.awt.Color(224, 224, 224));
        cboTheLoai.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        cboTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hành động - TL01", "Kinh dị", "Trinh thám", "Hoạt hình" }));
        cboTheLoai.setMaximumSize(new java.awt.Dimension(192, 32));

        txtDinhDang.setBackground(new java.awt.Color(224, 224, 224));
        txtDinhDang.setAutoscrolls(false);
        txtDinhDang.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtDinhDang.setLabelText("Định dạng");
        txtDinhDang.setMaximumSize(new java.awt.Dimension(6, 56));

        txtQuocGia.setBackground(new java.awt.Color(224, 224, 224));
        txtQuocGia.setAutoscrolls(false);
        txtQuocGia.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtQuocGia.setLabelText("Quốc gia");
        txtQuocGia.setMaximumSize(new java.awt.Dimension(6, 56));

        txtvideo.setBackground(new java.awt.Color(224, 224, 224));
        txtvideo.setAutoscrolls(false);
        txtvideo.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtvideo.setLabelText("VIDEO");
        txtvideo.setMaximumSize(new java.awt.Dimension(6, 56));
        txtvideo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtvideoFocusLost(evt);
            }
        });

        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setText("THÊM");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("SỬA");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("XÓA");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("LÀM MỚI");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblPhim.setBackground(new java.awt.Color(255, 51, 51));
        tblPhim.setForeground(new java.awt.Color(255, 51, 51));
        tblPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phim", "Tên phim", "Ngày khởi chiếu", "Ngày kết thúc", "Thể loại", "Tên định dạng", "Quốc gia"
            }
        ));
        tblPhim.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        tblPhim.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tblPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhimMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhim);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaPhim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTenPhim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jdNgaykc, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                            .addComponent(jdNgaykt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(51, 51, 51)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboTheLoai, 0, 311, Short.MAX_VALUE)
                                            .addComponent(txtDinhDang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtQuocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtvideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(40, 40, 40)))
                                .addGap(1, 1, 1)
                                .addComponent(video1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jdNgaykc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtvideo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdNgaykt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(video1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        them();
	Main.saoLuu.logPhim();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        sua();
	Main.saoLuu.logPhim();

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (Auth.isManager()) {
            xoa();
            Main.saoLuu.logPhim();
        } else {
            JOptionPane.showMessageDialog(null, "Chỉ Quản lý mới được sử dụng chức năng này.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhimMouseClicked
        int index = tblPhim.getSelectedRow();
        Phim ph = phimDAO.selectById(tblPhim.getValueAt(index, 0).toString());
        setModel(ph);
    }//GEN-LAST:event_tblPhimMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clear();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtvideoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtvideoFocusLost
        txtvideo.setText(txtvideo.getText().substring(txtvideo.getText().indexOf("=") + 1, txtvideo.getText().length()));
    }//GEN-LAST:event_txtvideoFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.swing.Button btnDelete;
    private com.GUI.swing.Button btnInsert;
    private com.GUI.swing.Button btnReset;
    private com.GUI.swing.Button btnUpdate;
    private javax.swing.JComboBox<String> cboTheLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdNgaykc;
    private com.toedter.calendar.JDateChooser jdNgaykt;
    private com.GUI.swing.Table tblPhim;
    private com.GUI.swing.TextField txtDinhDang;
    private com.GUI.swing.TextField txtMaPhim;
    private com.GUI.swing.TextField txtQuocGia;
    private com.GUI.swing.TextField txtTenPhim;
    private com.GUI.swing.TextField txtvideo;
    private com.GUI.form.Phim.video video1;
    // End of variables declaration//GEN-END:variables

}
