
package Entity;

import java.util.Date;

public class HoaDon {
    private String MaHoaDon;
    private double TongTien;
    private String MaKM;
    private String MaKHTT;
    private int MucGiamGia;
    private double ThanhTien;
    private Date NgayLap;
    private boolean TrangThai;
    private String MaNhanVien;
    private boolean HIDE;

    public HoaDon(String MaHoaDon, double TongTien, String MaKM, String MaKHTT, int MucGiamGia, double ThanhTien, Date NgayLap, boolean TrangThai, String MaNhanVien, boolean HIDE) {
        this.MaHoaDon = MaHoaDon;
        this.TongTien = TongTien;
        this.MaKM = MaKM;
        this.MaKHTT = MaKHTT;
        this.MucGiamGia = MucGiamGia;
        this.ThanhTien = ThanhTien;
        this.NgayLap = NgayLap;
        this.TrangThai = TrangThai;
        this.MaNhanVien = MaNhanVien;
        this.HIDE = HIDE;
    }

    public HoaDon() {
        
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getMaKHTT() {
        return MaKHTT;
    }

    public void setMaKHTT(String MaKHTT) {
        this.MaKHTT = MaKHTT;
    }

    public int getMucGiamGia() {
        return MucGiamGia;
    }

    public void setMucGiamGia(int MucGiamGia) {
        this.MucGiamGia = MucGiamGia;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public boolean isHIDE() {
        return HIDE;
    }

    public void setHIDE(boolean HIDE) {
        this.HIDE = HIDE;
    }

    
}
