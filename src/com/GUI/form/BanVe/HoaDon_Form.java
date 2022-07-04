package com.GUI.form.BanVe;

import DAO.DichVuDAO;
import DAO.GheDAO;
import DAO.HDCTDAO;
import DAO.HoaDonDAO;
import DAO.KHTTDAO;
import DAO.KhuyenMaiDAO;
import DAO.LichChieuDAO;
import DAO.PhimDAO;
import Entity.Ghe;
import Entity.HoaDon;
import Entity.Ve;
import Utilities.Auth;
import Utilities.XDate;
import Utilities.XJdbc;
import com.GUI.main.Main;
import java.awt.Image;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class HoaDon_Form extends javax.swing.JPanel {

    private HDCTDAO hdctdao = new HDCTDAO();
    private LichChieuDAO lcDAO = new LichChieuDAO();
    private KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
    private KHTTDAO khttdao = new KHTTDAO();
    private HoaDonDAO hdDAO = new HoaDonDAO();
    private PhimDAO phDAO = new PhimDAO();
    private DichVuDAO dvDAO = new DichVuDAO();
    private HoaDon hd;
    public static String maHoaDon_Paid;
    public static double thanhTien;
    public static boolean checkThanhToan = false;
    private String[] header = {
        "Mã HD", "Tổng tiền", "Mã KM", "Mã KHTT", "Mức giảm giá", "Thành Tiền", "Ngày lập", "Mã NV"
    };
    private DefaultTableModel model = new DefaultTableModel(header, 0);

    public HoaDon_Form() {
        initComponents();
        init();
    }

    private void init() {
        tblHoaDon.setModel(model);
        comboBoxThanhToan();
        Icon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/com/GUI/icon/QRTT.jpg")).getImage().getScaledInstance(lblQRTT.getPreferredSize().width, lblQRTT.getPreferredSize().height, Image.SCALE_SMOOTH));
        lblQRTT.setIcon(imageIcon);
    }

    public void tinhTien() {
        hd = new HoaDon();
        hd.setMaHoaDon(BanVe_Form.maHDNow);
        int tongTien = (int) hdctdao.getTongTien(BanVe_Form.maHDNow);
        hd.setTongTien(tongTien);
        hd.setMaKM(BanVe_Form.MaKM);
        hd.setMaKHTT(BanVe_Form.MaKHTT);
        int mucGG = kmDAO.selectMucGiamGia(BanVe_Form.MaKM) + khttdao.selectMucGiamGia(BanVe_Form.MaKHTT);
        hd.setMucGiamGia(mucGG);
        thanhTien = tongTien * (100 - mucGG) / 100;
        hd.setThanhTien(thanhTien);
        hd.setNgayLap(XDate.now());
        hd.setMaNhanVien(Auth.user.getMaNhanVien());
        hd.setHIDE(false);
        hdDAO.update(hd);
        maHoaDon_Paid = hd.getMaHoaDon();
        checkThanhToan = true;
    }

    public void loadDatabase() {
        model.setRowCount(0);
        HoaDon hd = hdDAO.selectById(BanVe_Form.maHDNow);
        Object[] row = {
            hd.getMaHoaDon(),
            hd.getTongTien(),
            hd.getMaKM(),
            hd.getMaKHTT(),
            hd.getMucGiamGia(),
            hd.getThanhTien(),
            hd.getNgayLap(),
            hd.getMaNhanVien()
        };
        model.addRow(row);
    }

    private void comboBoxThanhToan() {
        cboPTThanhToan.addItem("Thanh toán bằng tiền mặt");
        cboPTThanhToan.addItem("Thanh toán bằng MOMO");
    }

    void updateHD() {
        GheDAO gheDAO = new GheDAO();
        for (Ghe ghe : ChonGhe_Form.listGheSelected) {
            ghe.setTrangThai(true);
            gheDAO.update(ghe);
        }
        hd.setTrangThai(true);
        hdDAO.update(hd);
        //remove all tmp
        ChonGhe_Form.listGheSelected.clear();
        BanVe_Form.MaPhong = "";
        BanVe_Form.maHDNow = "";
        hd = new HoaDon();
        Main.banVe = new BanVe_Form();
        Main.banVe.loadDatabase();
        Main.main.showForm(Main.banVe);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new com.GUI.swing.Table();
        jLabel1 = new javax.swing.JLabel();
        cboPTThanhToan = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblQRTT = new javax.swing.JLabel();
        btnThanhToan = new com.GUI.swing.Button();
        btnQuayLai = new com.GUI.swing.Button();
        txtMaHD = new com.GUI.swing.TextField();
        txtThanhTien = new com.GUI.swing.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("BẢNG HÓA ĐƠN");

        cboPTThanhToan.setBackground(new java.awt.Color(224, 224, 224));
        cboPTThanhToan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        cboPTThanhToan.setForeground(new java.awt.Color(51, 51, 51));
        cboPTThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 51, 51)));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("PHƯƠNG THỨC THANH TOÁN: ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblQRTT.setMaximumSize(new java.awt.Dimension(391, 385));
        lblQRTT.setMinimumSize(new java.awt.Dimension(391, 385));
        lblQRTT.setPreferredSize(new java.awt.Dimension(391, 385));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQRTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQRTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnThanhToan.setBackground(new java.awt.Color(255, 51, 51));
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnQuayLai.setForeground(new java.awt.Color(255, 255, 255));
        btnQuayLai.setText("QUAY LẠI");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        txtMaHD.setBackground(new java.awt.Color(224, 224, 224));
        txtMaHD.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtMaHD.setLabelText("Nội dung chuyển khoản");

        txtThanhTien.setBackground(new java.awt.Color(224, 224, 224));
        txtThanhTien.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        txtThanhTien.setLabelText("Số tiền");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(318, 318, 318)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboPTThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(126, 126, 126)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPTThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        try {
            exportHoaDon(Main.banVe.maHDNow);
            exportVe();
            updateHD();
            Main.saoLuu.logHD();
        } catch (JRException ex) {
            Logger.getLogger(HoaDon_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        Main.main.showForm(Main.banVe);
    }//GEN-LAST:event_btnQuayLaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.swing.Button btnQuayLai;
    private com.GUI.swing.Button btnThanhToan;
    private javax.swing.JComboBox<String> cboPTThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQRTT;
    private com.GUI.swing.Table tblHoaDon;
    public static com.GUI.swing.TextField txtMaHD;
    public static com.GUI.swing.TextField txtThanhTien;
    // End of variables declaration//GEN-END:variables

    private void exportHoaDon(String maHoaDon) throws JRException {
        Hashtable a = new Hashtable();
        JasperReport jasperReport = JasperCompileManager.compileReport("src/Utilities/HoaDon.jrxml");
        a.put("MaHoaDon", maHoaDon);
        JasperPrint p = JasperFillManager.fillReport(jasperReport, a, XJdbc.ConnectDB());
        JasperViewer.viewReport(p, false);
    }

    private void exportVe() throws JRException {
        for (Ve ve : Main.banVe.velList) {
            System.out.println(ve.getMave());
            Hashtable a = new Hashtable();
            JasperReport jasperReport = JasperCompileManager.compileReport("src/Utilities/Ve.jrxml");
            a.put("MaVe", ve.getMave().toString());
            JasperPrint p = JasperFillManager.fillReport(jasperReport, a, XJdbc.ConnectDB());
            JasperViewer.viewReport(p, false);
        }
    }
}
