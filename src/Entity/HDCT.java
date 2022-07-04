
package Entity;


public class HDCT {
    private String MaHoaDonChiTiet;
    private String MaDichVu;
    private double GiaTien;
    private int SoLuong;
    private double ThanhTien;
    private String MaHoaDon;
    private boolean HIDE;
    
    public HDCT()
    {
        
    }

    public HDCT(String MaHoaDonChiTiet, String MaDichVu, String MaVe, double GiaTien, int SoLuong, double ThanhTien, String MaHoaDon, boolean HIDE) {
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
        this.MaDichVu = MaDichVu;
//        this.MaVe = MaVe;
        this.GiaTien = GiaTien;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.MaHoaDon = MaHoaDon;
        this.HIDE = HIDE;
    }
    
    @Override
    public String toString(){
        return this.MaHoaDonChiTiet;
    }

    public String getMaHoaDonChiTiet() {
        return MaHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String MaHoaDonChiTiet) {
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
    }

    public String getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(String MaDichVu) {
        this.MaDichVu = MaDichVu;
    }

//    public String getMaVe() {
//        return MaVe;
//    }
//
//    public void setMaVe(String MaVe) {
//        this.MaVe = MaVe;
//    }

    public double getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(double GiaTien) {
        this.GiaTien = GiaTien;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public boolean isHIDE() {
        return HIDE;
    }

    public void setHIDE(boolean HIDE) {
        this.HIDE = HIDE;
    }
    
    
}
