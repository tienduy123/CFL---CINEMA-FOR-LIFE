package com.GUI.main;

import DAO.GheDAO;
import Entity.Ghe;
import Entity.NhanVien;
import Utilities.Auth;
import com.GUI.component.Header;
import com.GUI.component.Menu;
import com.GUI.event.EventMenuSelected;
import com.GUI.form.BanVe.BanVe_Form;
import com.GUI.form.BanVe.HoaDon_Form;
import com.GUI.form.DashBoard;
import com.GUI.form.KhachHangThanThiet.KhachHangThanThiet_Form;
import com.GUI.form.MainForm;
import com.GUI.form.NhanVien.QuanLyNhanVien_Form;
import com.GUI.form.Phim.QuanLyPhim_Form;
import com.GUI.form.QuanLyLichChieu_Form;
import com.GUI.form.SaoLuu.SaoLuu_Form;
import com.GUI.form.SuKien.QuanLySuKien_Form;
import com.GUI.form.SuKien.SKDangDienRa_Form;
import com.GUI.form.ThongKe.TKDoanhThu_Form;
import com.GUI.form.ThongKe.TKDoanhThu_Ngay;
import com.GUI.form.ThongKe.TKLuotXem_Form;
import com.GUI.form.CustomerAnalysis.DectectCustomer;
import com.GUI.main.login.Login;
import com.GUI.swing.icon.GoogleMaterialDesignIcons;
import com.GUI.swing.icon.IconFontSwing;
import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    public static MainForm main;
    public static Main mainCT;
    private Animator animator;
    public static BanVe_Form banVe = new BanVe_Form();
    public static HoaDon_Form hoaDon = new HoaDon_Form();
    public static SaoLuu_Form saoLuu = new SaoLuu_Form();
    public static List<Ghe> listGhe = new ArrayList<>();
    public static GheDAO ghDAO = new GheDAO();
    private KhachHangThanThiet_Form khtt;
    private QuanLyNhanVien_Form qlnv;
    private NhanVien nv;
    static String path = System.getProperty("user.dir");

    public Main() {
        initComponents();
        init();
        mainCT = this;
        listGhe = ghDAO.selectAll();
    }

    public void setNV(NhanVien nv) {
        this.nv = nv;
    }

    public void check() {
        header.setNV(nv);
        header.init();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                if (menuIndex == 0) {
                    main.showForm(new DashBoard());
                }
                if (menuIndex == 1) {
                    main.showForm(banVe);
                    if (subMenuIndex == 0) {
//                        main.showForm(new ChonGhe_Form());
                    } else if (subMenuIndex == 1) {
//                        main.showForm(new HoaDon_Form());
                    }
                } else if (menuIndex == 2) {
                    khtt = new KhachHangThanThiet_Form();
                    khtt.setNV(nv);
                    main.showForm(khtt);
                } else if (menuIndex == 3) {
                    if (subMenuIndex == 0) {
                        main.showForm(new QuanLyPhim_Form());
                    }
                } else if (menuIndex == 4) {
                    if (subMenuIndex == 0) {
                        main.showForm(new QuanLyLichChieu_Form());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new QuanLyLichChieu_Form());
                    }
                } else if (menuIndex == 5) {
                    if (subMenuIndex == 0) {
                        QuanLySuKien_Form sk = new QuanLySuKien_Form();
                        sk.setNV(nv);
                        main.showForm(sk);
                    } else if (subMenuIndex == 1) {
                        main.showForm(new SKDangDienRa_Form());
                    }
                } else if (menuIndex == 6) {
                    if (Auth.isManager()) {
                        QuanLyNhanVien_Form nvf = new QuanLyNhanVien_Form();
                        main.showForm(nvf);
                    } else {
                        JOptionPane.showMessageDialog(null, "Chỉ Quản lý mới được sử dụng chức năng này.");
                    }
                } else if (menuIndex == 7) {
                    if (Auth.isManager()) {
                        if (subMenuIndex == 0) {
                            main.showForm(new TKDoanhThu_Ngay());
                        } else if (subMenuIndex == 1) {
                            main.showForm(new TKDoanhThu_Form());
                        } else if (subMenuIndex == 2) {
                            main.showForm(new TKLuotXem_Form());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Chỉ Quản lý mới được sử dụng chức năng này.");
                    }
                } else if (menuIndex == 8) {
                    if (Auth.isManager()) {
                        if (subMenuIndex == 0) {
                            main.showForm(saoLuu);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Chỉ Quản lý mới được sử dụng chức năng này.");
                    }
                } else if (menuIndex == 9) {
                    new DectectCustomer().setVisible(true);
                } else if (menuIndex == 10) {
                    int test = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Đăng Xuất Không?");
                    if (test == 0) {
                        try {
                            new Login().setVisible(true);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    }
                } else if (menuIndex == 11) {
                    try {
                        Desktop.getDesktop().browse(new File("Responsive/index.html").toURI());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy file hướng dẫn.");
                    }
                }
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 255!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 85 + (170 * (1f - fraction));
                } else {
                    width = 85 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new DashBoard());
        this.setIconImage(new ImageIcon(path+"\\src\\com\\GUI\\icon\\Untitled-1.png").getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1700, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
