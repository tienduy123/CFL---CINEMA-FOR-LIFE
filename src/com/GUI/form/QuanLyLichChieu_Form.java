package com.GUI.form;

import DAO.LichChieuDAO;
import DAO.PhimDAO;
import DAO.PhongDAO;
import Entity.LichChieu;
import Entity.Phim;
import Entity.Phong;
import Utilities.XDate;
import Utilities.XRegex;
import com.GUI.form.BanVe.BanVe_Form;
import com.GUI.main.Main;
import com.GUI.swing.ScrollBar;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class QuanLyLichChieu_Form extends javax.swing.JPanel {

    DefaultTableModel model;
    DefaultComboBoxModel cbomodelPhong = new DefaultComboBoxModel();
    DefaultComboBoxModel cbomodelPhim = new DefaultComboBoxModel();
    LichChieuDAO lichChieuDao = new LichChieuDAO();
    PhimDAO phimDAO = new PhimDAO();
    PhongDAO phongDAO = new PhongDAO();
    public static boolean add_LC = false;
    public static boolean xoa_LC = false;
    public static boolean sua_LC = false;
    public static String MaLiCh;
    private boolean check = false;
    
    public QuanLyLichChieu_Form() {
        initComponents();
        setOpaque(false);
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        init();
    }

    public void init() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Mã lịch chiếu", "Mã phim", "Tên phim", "Mã phòng", "Ngày chiếu", "Giờ chiếu"});
        tblLichChieu.setModel(model);
        txtNgayChieu.setDateFormatString("yyyy-MM-dd");
        fillTable();
        fillSearchPhimCbo();
        fillcboMaPhong();
        fillcboPhim();
        try {
            search();
        } catch (Exception e) {
        }
    }

    public void search() {
        try {
            TableRowSorter<DefaultTableModel> ts = new TableRowSorter<>(model);
            tblLichChieu.setRowSorter(ts);
            ts.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText()));
        } catch (Exception e) {
        }
    }

    public void fillSearchPhimCbo() {
        DefaultComboBoxModel cbomodel = new DefaultComboBoxModel();
        cboPhimTimKiem.setModel(cbomodel);
        cbomodel.removeAllElements();
        cbomodel.addElement("Tất cả");
        List<Phim> list = phimDAO.selectAll();
        for (Phim phim : list) {
            cbomodel.addElement(phim);
        }
        cboPhimTimKiem.setSize(new Dimension(241, 47));
    }

    public void fillcboMaPhong() {
        cboMaPhong.setModel(cbomodelPhong);
        cbomodelPhong.removeAllElements();

        List<Phong> list = phongDAO.selectAll();
        for (Phong phong : list) {
            cbomodelPhong.addElement(phong.getMaphong());
        }
    }

    public void fillcboPhim() {
        cboPhim.setModel(cbomodelPhim);
        cbomodelPhim.removeAllElements();

        List<Phim> list = phimDAO.selectAll();

        for (Phim phim : list) {
            cbomodelPhim.addElement(phim);

        }
    }

    public void fillTableWithList(List<LichChieu> list) {
        model.setRowCount(0);
        for (LichChieu lc : list) {
            String tenPhim = phimDAO.selectById(lc.getMaPhim()).getTenPhim();
            model.addRow(new Object[]{lc.getMaLichChieu(), lc.getMaPhim(), tenPhim, lc.getMaPhong(), lc.getNgayChieu(), lc.getGioChieu()});
        }
    }

    public void fillTable() {
        model.setRowCount(0);
        List<LichChieu> list = new ArrayList<>();
        list = lichChieuDao.selectAll();
        fillTableWithList(list);
    }

    public void fillTableByMaPhim() {
        model.setRowCount(0);
        String maphim = ((Phim) cboPhimTimKiem.getSelectedItem()).getMaPhim();
        List<LichChieu> list = lichChieuDao.selectAllByMa(maphim.toString());
        fillTableWithList(list);
    }

    public void searchByCbo() {
        String maphim = cboPhimTimKiem.getSelectedItem().toString();
        if (maphim.equals("Tất cả")) {
            fillTable();
        } else {
            fillTableByMaPhim();
        }
    }

    public LichChieu getModel() {
        LichChieu lc = new LichChieu();
        lc.setNgayChieu(txtNgayChieu.getDate());
        lc.setGioChieu(txtGioChieu.getText());
        lc.setMaPhim(((Phim) cboPhim.getSelectedItem()).getMaPhim());
        lc.setMaPhong(cboMaPhong.getSelectedItem().toString());
        MaLiCh = lc.getMaLichChieu();
        return lc;
    }

    public void setModel(LichChieu lc) {
        txtTitle.setToolTipText(lc.getMaLichChieu());
        txtGioChieu.setText(lc.getGioChieu());
        txtNgayChieu.setDate(lc.getNgayChieu());
        cbomodelPhim.setSelectedItem(phimDAO.selectById(lc.getMaPhim()));
        cbomodelPhong.setSelectedItem(lc.getMaPhong());
    }

    public void them() {
        LichChieu lc = getModel();
        try {
            if (check()) {
                lichChieuDao.insert(lc);

                fillTable();
                if (!cboPhimTimKiem.getSelectedItem().equals("Tất cả")) {
                    cboPhimTimKiem.setSelectedIndex(0);
                }
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                add_LC = true;
                moi();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại");
            e.printStackTrace();
        }
    }

    public void sua() {
        int index = tblLichChieu.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Vui dòng chọn lịch phim cần sửa");
            return;
        } else {
            LichChieu lc = getModel();
            lc.setMaLichChieu(tblLichChieu.getValueAt(index, 0).toString());
            if (check()) {
                try {
                    lichChieuDao.update(lc);

                    fillTable();
                    sua_LC = true;
                    MaLiCh = tblLichChieu.getValueAt(index, 0).toString();
                    if (!cboPhimTimKiem.getSelectedItem().equals("Tất cả")) {
                        cboPhimTimKiem.setSelectedIndex(0);
                    }
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                    moi();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Sửa thất bại");
                    e.printStackTrace();
                }
            }
        }

    }

    public void xoa() {
        int index = tblLichChieu.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Vui dòng chọn cần xóa");
            return;
        } else {
            int test = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa lịch chiếu này không ?");
            if (test == 0) {
                try {
                    lichChieuDao.delete(tblLichChieu.getValueAt(index, 0).toString());

                    fillTable();
                    xoa_LC = true;
                    MaLiCh = tblLichChieu.getValueAt(index, 0).toString();
                    if (!cboPhimTimKiem.getSelectedItem().equals("Tất cả")) {
                        cboPhimTimKiem.setSelectedIndex(0);
                    }
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                    moi();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại");
                    e.printStackTrace();
                }

            }
        }
    }

    public void searchByDate() {
        if (!check) {
            txtsearchFirstDate.setDate(null);
            txtsearchLastDate.setDate(null);
            check = false;
        } else {
            cboPhimTimKiem.setSelectedIndex(0);
        }
        try {
            if (txtsearchFirstDate.getDate() == null) {
                List<LichChieu> list = lichChieuDao.selectByDate(new java.sql.Date(XDate.now().getTime()), new java.sql.Date(txtsearchLastDate.getDate().getTime()));
                System.out.println(new java.sql.Date(XDate.now().getTime()));
                System.out.println(new java.sql.Date(txtsearchLastDate.getDate().getTime()));
                fillTableWithList(list);
            } else if (txtsearchLastDate.getDate() == null) {
                List<LichChieu> list = lichChieuDao.selectByDateWithoutLastDay(new java.sql.Date(txtsearchFirstDate.getDate().getTime()));
                fillTableWithList(list);
            } else if (txtsearchFirstDate.getDate() == null && txtsearchLastDate.getDate() == null) {
                fillTable();
            } else {
                if (txtsearchFirstDate.getDate().getTime() > txtsearchLastDate.getDate().getTime()) {
                    JOptionPane.showMessageDialog(null, "Ngày đầu không được lớn hơn ngày sau");
                    txtsearchFirstDate.setDate(null);
                    txtsearchLastDate.setDate(null);
                    cboPhimTimKiem.setSelectedItem("Tất cả");
                    fillTable();
                } else {
                    List<LichChieu> list = lichChieuDao.selectByDate(new java.sql.Date(txtsearchFirstDate.getDate().getTime()), new java.sql.Date(txtsearchLastDate.getDate().getTime()));
                    fillTableWithList(list);

                }
            }
        } catch (Exception e) {

        }
    }

    public boolean check() {
        String regexGio = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]?$";
        Pattern p = Pattern.compile("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]?$");
        String thongbao = "";
        if (XRegex.checkNull(txtGioChieu.getText()) == false) {
            thongbao += "Giờ không được để trống\n";
        } else if (!p.matcher(txtGioChieu.getText()).matches()) {
            thongbao += "Sai đinh dạng giờ. Ex: HH:MM\n";
        }
        if (txtNgayChieu.getDate() == null) {
            thongbao += "Vui lòng chọn ngày chiếu\n";
        }
//        else if(txtNgayChieu.getDate().getTime()<XDate.now().getTime()){
//            thongbao += "Không thể chọn ngày đã qua\n";
//        }
        if (thongbao.length() > 0) {
            JOptionPane.showMessageDialog(null, thongbao);
            return false;
        }
        return true;

    }

    public void moi() {
        txtNgayChieu.setDate(null);
        txtGioChieu.setText("");
        cboPhim.setSelectedIndex(0);
        cboMaPhong.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLichChieu = new com.GUI.swing.Table();
        txtTimKiem = new com.GUI.swing.TextField();
        txtGioChieu = new com.GUI.swing.TextField();
        txtsearchFirstDate = new com.toedter.calendar.JDateChooser();
        txtsearchLastDate = new com.toedter.calendar.JDateChooser();
        cboPhimTimKiem = new javax.swing.JComboBox<>();
        txtTitle = new javax.swing.JLabel();
        btnSua = new com.GUI.swing.ButtonBadges();
        btnMoi = new com.GUI.swing.ButtonBadges();
        btnThem = new com.GUI.swing.ButtonBadges();
        btnXoa = new com.GUI.swing.ButtonBadges();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNgayChieu = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cboMaPhong = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboPhim = new javax.swing.JComboBox<>();
        btnReset = new com.GUI.swing.ButtonBadges();

        setBackground(new java.awt.Color(255, 255, 255));

        tblLichChieu.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã lịch chiếu", "Mã phim", "Mã phòng", "Tên phim", "Ngày chiếu", "Giờ chiếu"
            }
        ));
        tblLichChieu.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        tblLichChieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLichChieuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLichChieu);

        txtTimKiem.setBackground(new java.awt.Color(224, 224, 224));
        txtTimKiem.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtTimKiem.setLabelText("Tìm kiếm");
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        txtGioChieu.setBackground(new java.awt.Color(224, 224, 224));
        txtGioChieu.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtGioChieu.setLabelText("Giờ chiếu");

        txtsearchFirstDate.setBackground(new java.awt.Color(224, 224, 224));
        txtsearchFirstDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtsearchFirstDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtsearchFirstDatePropertyChange(evt);
            }
        });

        txtsearchLastDate.setBackground(new java.awt.Color(224, 224, 224));
        txtsearchLastDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtsearchLastDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtsearchLastDatePropertyChange(evt);
            }
        });

        cboPhimTimKiem.setBackground(new java.awt.Color(224, 224, 224));
        cboPhimTimKiem.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        cboPhimTimKiem.setForeground(new java.awt.Color(255, 51, 51));
        cboPhimTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên phim 1", "Tên phim 2", "Tên phim 3", "Tên phim 4" }));
        cboPhimTimKiem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPhimTimKiemItemStateChanged(evt);
            }
        });
        cboPhimTimKiem.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboPhimTimKiemPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cboPhimTimKiemPopupMenuWillBecomeVisible(evt);
            }
        });
        cboPhimTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhimTimKiemActionPerformed(evt);
            }
        });

        txtTitle.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(255, 51, 51));
        txtTitle.setText("QUẢN LÝ LỊCH CHIẾU");

        btnSua.setBackground(new java.awt.Color(51, 51, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("SỬA");
        btnSua.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(51, 51, 51));
        btnMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnMoi.setText("MỚI");
        btnMoi.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(51, 51, 51));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("THÊM");
        btnThem.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(51, 51, 51));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("XÓA");
        btnXoa.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Từ");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Đến");

        txtNgayChieu.setBackground(new java.awt.Color(224, 224, 224));
        txtNgayChieu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Ngày chiếu");

        cboMaPhong.setBackground(new java.awt.Color(224, 224, 224));
        cboMaPhong.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        cboMaPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hành động", "Kinh dị", "Trinh thám", "Hoạt hình" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Mã phòng:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Phim: ");

        cboPhim.setBackground(new java.awt.Color(224, 224, 224));
        cboPhim.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        cboPhim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hành động", "Kinh dị", "Trinh thám", "Hoạt hình" }));

        btnReset.setBackground(new java.awt.Color(51, 51, 51));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET");
        btnReset.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTitle)
                .addGap(509, 509, 509))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsearchFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsearchLastDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboPhimTimKiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1032, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(txtNgayChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGioChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTitle)
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboPhimTimKiem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsearchLastDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtsearchFirstDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtGioChieu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        search();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cboPhimTimKiemPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboPhimTimKiemPopupMenuWillBecomeInvisible
        cboPhimTimKiem.setSize(242, 47);
    }//GEN-LAST:event_cboPhimTimKiemPopupMenuWillBecomeInvisible

    private void cboPhimTimKiemPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboPhimTimKiemPopupMenuWillBecomeVisible
        cboPhimTimKiem.setSize(500, cboPhimTimKiem.getPreferredSize().height);
    }//GEN-LAST:event_cboPhimTimKiemPopupMenuWillBecomeVisible

    private void tblLichChieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichChieuMouseClicked
        int index = tblLichChieu.getSelectedRow();
        LichChieu lc = lichChieuDao.selectById(tblLichChieu.getValueAt(index, 0).toString());
        setModel(lc);
    }//GEN-LAST:event_tblLichChieuMouseClicked

    private void cboPhimTimKiemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPhimTimKiemItemStateChanged
//        searchByCbo();
//        txtsearchFirstDate.setDate(null);
//            txtsearchLastDate.setDate(null);
//        if (txtsearchFirstDate.getDate() == null || txtsearchLastDate.getDate() == null) {
//            
//        } else {
//            
//        }
    }//GEN-LAST:event_cboPhimTimKiemItemStateChanged

    private void txtsearchFirstDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtsearchFirstDatePropertyChange
        searchByDate();
    }//GEN-LAST:event_txtsearchFirstDatePropertyChange

    private void txtsearchLastDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtsearchLastDatePropertyChange
        searchByDate();
    }//GEN-LAST:event_txtsearchLastDatePropertyChange

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        them();
        Main.saoLuu.logLC();
        Main.banVe = new BanVe_Form();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        sua();
        Main.saoLuu.logLC();
        Main.banVe = new BanVe_Form();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        xoa();
        Main.saoLuu.logLC();
        Main.banVe = new BanVe_Form();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        moi();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtsearchFirstDate.setDate(null);
        txtsearchLastDate.setDate(null);
        fillTable();
        cboPhimTimKiem.setSelectedItem("Tất cả");
    }//GEN-LAST:event_btnResetActionPerformed

    private void cboPhimTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhimTimKiemActionPerformed
        searchByCbo();
        check = true;
    }//GEN-LAST:event_cboPhimTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.swing.ButtonBadges btnMoi;
    private com.GUI.swing.ButtonBadges btnReset;
    private com.GUI.swing.ButtonBadges btnSua;
    private com.GUI.swing.ButtonBadges btnThem;
    private com.GUI.swing.ButtonBadges btnXoa;
    private javax.swing.JComboBox<String> cboMaPhong;
    private javax.swing.JComboBox<String> cboPhim;
    private javax.swing.JComboBox<String> cboPhimTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.GUI.swing.Table tblLichChieu;
    private com.GUI.swing.TextField txtGioChieu;
    private com.toedter.calendar.JDateChooser txtNgayChieu;
    private com.GUI.swing.TextField txtTimKiem;
    private javax.swing.JLabel txtTitle;
    private com.toedter.calendar.JDateChooser txtsearchFirstDate;
    private com.toedter.calendar.JDateChooser txtsearchLastDate;
    // End of variables declaration//GEN-END:variables
}
