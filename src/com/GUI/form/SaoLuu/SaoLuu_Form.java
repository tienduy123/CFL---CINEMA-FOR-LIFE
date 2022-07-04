package com.GUI.form.SaoLuu;

import Entity.HoaDon;
import Utilities.Auth;
import Utilities.Log;
import Utilities.XJdbc;
import com.GUI.form.BanVe.HoaDon_Form;
import com.GUI.form.KhachHangThanThiet.KhachHangThanThiet_Form;
import com.GUI.form.NhanVien.QuanLyNhanVien_Form;
import com.GUI.form.Phim.QuanLyPhim_Form;
import com.GUI.form.QuanLyLichChieu_Form;
import com.GUI.form.SuKien.QuanLySuKien_Form;
import com.GUI.form.SuKien.SKDangDienRa_Form;
import com.GUI.main.Main;
import com.GUI.main.login.Login;
import com.GUI.swing.ScrollBar;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class SaoLuu_Form extends javax.swing.JPanel {

    private HoaDon hd = new HoaDon();
    private static String[] header = {
        "Tác vụ", "Người thực hiện", "Thời gian"
    };
    private static List<Log> listLog = new ArrayList<>();
    private String path = System.getProperty("user.dir");
    private JFileChooser fc;
    private String dir = "";
    static DefaultTableModel model = new DefaultTableModel(header, 0);

    public SaoLuu_Form() {
        initComponents();
        init();
        setOpaque(false);
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhatKyHD = new com.GUI.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        btnXuatTrucTiep = new com.GUI.swing.Button();
        btnXuatDen = new com.GUI.swing.Button();
        btnXuatLog = new com.GUI.swing.Button();
        progressBarCustom1 = new com.GUI.swing.ProgressBarCustom();
        jLabel4 = new javax.swing.JLabel();
        txtDuongDan = new com.GUI.swing.TextField();
        progressBarCustom2 = new com.GUI.swing.ProgressBarCustom();
        btnLayDuLieu = new com.GUI.swing.Button();
        btnNhapDuLieu = new com.GUI.swing.Button();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("DỮ LIỆU");

        tblNhatKyHD.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblNhatKyHD);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("NHẬT KÝ HOẠT ĐỘNG");

        btnXuatTrucTiep.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatTrucTiep.setText("XUẤT DỮ LIỆU TRỰC TIẾP");
        btnXuatTrucTiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatTrucTiepActionPerformed(evt);
            }
        });

        btnXuatDen.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatDen.setText("XUẤT DỮ LIỆU ĐẾN");
        btnXuatDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDenActionPerformed(evt);
            }
        });

        btnXuatLog.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatLog.setText("XUẤT NHẬT KÝ HOẠT ĐỘNG");
        btnXuatLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatLogActionPerformed(evt);
            }
        });

        progressBarCustom1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        progressBarCustom1.setForeground(new java.awt.Color(51, 255, 153));
        progressBarCustom1.setValue(50);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("DUNG LƯỢNG");

        txtDuongDan.setLabelText("Đường Dẫn");

        progressBarCustom2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        progressBarCustom2.setForeground(new java.awt.Color(51, 255, 153));
        progressBarCustom2.setValue(50);

        btnLayDuLieu.setForeground(new java.awt.Color(255, 255, 255));
        btnLayDuLieu.setText("LẤY DỮ LIỆU");
        btnLayDuLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayDuLieuActionPerformed(evt);
            }
        });

        btnNhapDuLieu.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapDuLieu.setText("NHẬP DỮ LIỆU");
        btnNhapDuLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapDuLieuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("KHÔI PHỤC DỮ LIỆU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnXuatLog, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnXuatDen, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnXuatTrucTiep, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(progressBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(progressBarCustom2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                                .addComponent(txtDuongDan, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLayDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNhapDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(239, 239, 239))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDuongDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressBarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressBarCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNhapDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLayDuLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatTrucTiep, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatDen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatLog, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatTrucTiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatTrucTiepActionPerformed
        backup_DuLieu_TrucTiep();
    }//GEN-LAST:event_btnXuatTrucTiepActionPerformed

    private void btnXuatDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDenActionPerformed
        backup_DuLieu_Den();
    }//GEN-LAST:event_btnXuatDenActionPerformed

    private void btnXuatLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatLogActionPerformed
        xuatLog();
    }//GEN-LAST:event_btnXuatLogActionPerformed

    private void btnLayDuLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayDuLieuActionPerformed
        layDuLieu();
    }//GEN-LAST:event_btnLayDuLieuActionPerformed

    private void btnNhapDuLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapDuLieuActionPerformed
        try {
            nhapDuLieu();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Restore thất bại.");
        }
    }//GEN-LAST:event_btnNhapDuLieuActionPerformed

    private void init() {
        tblNhatKyHD.setModel(model);
    }

    //HD
    public static void logHD() {
	    Log log = new Log();
	    log.setLogDangNhap(Auth.user.getMaNhanVien());
	    if (HoaDon_Form.checkThanhToan) {
		    log.setLogThanhToan("Thanh toán " + HoaDon_Form.maHoaDon_Paid);
		    log.setLogThoiGian(new Date());
	    }
	    listLog.add(log);
	    fillTable();
    }
    //KHTT
    public static void logKHTT() {
	Log log = new Log();
	log.setLogDangNhap(Auth.user.getMaNhanVien());
	if(KhachHangThanThiet_Form.add_KHTT) {
		log.setLogThanhToan("Thêm mới khách hàng" + KhachHangThanThiet_Form.MaKHTT);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		KhachHangThanThiet_Form.add_KHTT = false;
	}
	else if(KhachHangThanThiet_Form.sua_KHTT) {
		log.setLogThanhToan("Thay đổi thông tin " + KhachHangThanThiet_Form.MaKHTT);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		KhachHangThanThiet_Form.sua_KHTT = false;
	}
	else if(KhachHangThanThiet_Form.xoa_KHTT) {
		log.setLogThanhToan("Xóa " + KhachHangThanThiet_Form.MaKHTT);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		KhachHangThanThiet_Form.xoa_KHTT = false;
	}
	fillTable();
    }
    //NV
    public static void logNV() {
	Log log = new Log();
	log.setLogDangNhap(Auth.user.getMaNhanVien());
	if(QuanLyNhanVien_Form.add_NV) {
		log.setLogThanhToan("Thêm mới nhân viên" + QuanLyNhanVien_Form.MaNV);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLyNhanVien_Form.add_NV = false;
	}
	else if(QuanLyNhanVien_Form.sua_NV) {
		log.setLogThanhToan("Thay đổi thông tin " + QuanLyNhanVien_Form.MaNV);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLyNhanVien_Form.sua_NV = false;
	}
	else if(QuanLyNhanVien_Form.xoa_NV) {
		log.setLogThanhToan("Xóa " + QuanLyNhanVien_Form.MaNV);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLyNhanVien_Form.xoa_NV = false;
	}
	fillTable();
    }
    //Phim
    public static void logPhim() {
	    Log log = new Log();
	    log.setLogDangNhap(Auth.user.getMaNhanVien());
	if(QuanLyPhim_Form.add_Phim) {
		log.setLogThanhToan("Thêm mới phim" + QuanLyPhim_Form.MaPHIM);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLyPhim_Form.add_Phim = false;
	}
	else if(QuanLyPhim_Form.sua_Phim) {
		log.setLogThanhToan("Thay đổi thông tin " + QuanLyPhim_Form.MaPHIM);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLyPhim_Form.sua_Phim = false;
	}
	else if(QuanLyPhim_Form.xoa_Phim) {
		log.setLogThanhToan("Xóa " + QuanLyPhim_Form.MaPHIM);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLyPhim_Form.xoa_Phim = false;
	}
	fillTable();
    }
    //SuKien
    public static void logSuKien() {
	    Log log = new Log();
	    log.setLogDangNhap(Auth.user.getMaNhanVien());
	if(QuanLySuKien_Form.add_SK) {	
		log.setLogThanhToan("Thêm mới sự kiện " + QuanLySuKien_Form.MaSuKi);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLySuKien_Form.add_SK = false;
	}
	else if(QuanLySuKien_Form.sua_SK) {
		log.setLogThanhToan("Thay đổi thông tin " + QuanLySuKien_Form.MaSuKi);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLySuKien_Form.sua_SK = false;
	}
	else if(QuanLySuKien_Form.xoa_SK) {
		log.setLogThanhToan("Xóa " + QuanLySuKien_Form.MaSuKi);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLySuKien_Form.xoa_SK = false;
	}
	fillTable();
    }
    //SKDDR
    public static void logSKDDR() {
	    Log log = new Log();
	    log.setLogDangNhap(Auth.user.getMaNhanVien());
	    if(SKDangDienRa_Form.xoa_SKDangDR) {
		    log.setLogThanhToan("Xóa " + SKDangDienRa_Form.MaSuKiDDR);
			log.setLogThoiGian(new Date());
			listLog.add(log);
			SKDangDienRa_Form.xoa_SKDangDR = false;
	    }
	fillTable();
    }
    //LC
    public static void logLC() {
	    Log log = new Log();
	    log.setLogDangNhap(Auth.user.getMaNhanVien());
	if(QuanLyLichChieu_Form.add_LC) {
		log.setLogThanhToan(("Thêm mới lịch chiếu" + QuanLyLichChieu_Form.MaLiCh).replaceAll("null", ""));
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLyLichChieu_Form.add_LC = false;
	}
	else if(QuanLyLichChieu_Form.sua_LC) {
		log.setLogThanhToan("Thay đổi thông tin " + QuanLyLichChieu_Form.MaLiCh);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLyLichChieu_Form.sua_LC = false;
	}
	else if(QuanLyLichChieu_Form.xoa_LC) {
		log.setLogThanhToan("Xóa " + QuanLyLichChieu_Form.MaLiCh);
		log.setLogThoiGian(new Date());
		listLog.add(log);
		QuanLyLichChieu_Form.add_LC = false;
	}
	fillTable();
    }

    private static void fillTable() {
        model.setRowCount(0);
        for (Log l : listLog) {
            Object[] rows = {
                l.lichSuThanhToan(),
                l.lichSuDangNhap(),
                l.thoiGianThucHien()
            };
            model.addRow(rows);
        }
        System.out.println(listLog.size());
    }

    private void xuatLog() {
        try {
            File file = new File("log.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < tblNhatKyHD.getColumnCount(); j++) {
                    bw.write(tblNhatKyHD.getColumnName(j) + "  ");
                }
                bw.write("\n------------------------------------------------------------------\n");
            }
            for (int i = 0; i < tblNhatKyHD.getRowCount(); i++) {
                for (int j = 0; j < tblNhatKyHD.getColumnCount(); j++) {
                    if (tblNhatKyHD.getModel().getValueAt(i, j) == null) {
                        tblNhatKyHD.getModel().setValueAt("NULL", i, j);
                    }
                    bw.write(tblNhatKyHD.getModel().getValueAt(i, j).toString() + " | ");
                }
                bw.write("\n------------------------------------------------------------------\n");
            }
            JOptionPane.showMessageDialog(null, "Xuất Log thành công");
            bw.close();
            fw.close();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private void backup_DuLieu_Den() {
        try {
            String backup = "";
            fc = new JFileChooser();
            fc.setDialogTitle("Export to..");
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                backup = "BACKUP DATABASE QL_RapPhim TO DISK = '" + fc.getSelectedFile() + "'";
                System.out.println("Current Dir: " + fc.getCurrentDirectory());
                System.out.println("File Selected: " + fc.getSelectedFile());
            } else {
                System.out.println("No export");
            }
            XJdbc.update(backup);
            JOptionPane.showMessageDialog(this, "Backup thành công.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Backup Thất bại");
            throw new RuntimeException(e);
        }
    }

    private void backup_DuLieu_TrucTiep() {
        try {
            String backup = "BACKUP DATABASE QL_RapPhim TO DISK = 'C:\\QLRapPhim.bak'";
            XJdbc.update(backup);
            JOptionPane.showMessageDialog(this, "File backup được lưu đến C:\\QLRapPhim.bak");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Backup Thất bại");
            throw new RuntimeException(e);
        }
    }

    private void layDuLieu() {
        try {
            fc = new JFileChooser();
            FileNameExtensionFilter f = new FileNameExtensionFilter(null,"bak");
            fc.setFileFilter(f);
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                txtDuongDan.setText("" + fc.getSelectedFile());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void nhapDuLieu() throws IOException {
        if (txtDuongDan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa chọn đường dẫn");
        } else {
            String path = txtDuongDan.getText().replace('\\', '/').trim();
            String restoreCMD = "sqlcmd -q \"RESTORE DATABASE QL_RAPPHIM FROM DISK=N'"+path+"' WITH REPLACE\"";
            Process process = Runtime.getRuntime().exec(restoreCMD);
            JOptionPane.showMessageDialog(this, "Restore thành công. Vui lòng đăng nhập lại.");
            try {
                            new Login().setVisible(true);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
            Main.mainCT.dispose();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.GUI.swing.Button btnLayDuLieu;
    private com.GUI.swing.Button btnNhapDuLieu;
    private com.GUI.swing.Button btnXuatDen;
    private com.GUI.swing.Button btnXuatLog;
    private com.GUI.swing.Button btnXuatTrucTiep;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.GUI.swing.ProgressBarCustom progressBarCustom1;
    private com.GUI.swing.ProgressBarCustom progressBarCustom2;
    private com.GUI.swing.Table tblNhatKyHD;
    private com.GUI.swing.TextField txtDuongDan;
    // End of variables declaration//GEN-END:variables
}
