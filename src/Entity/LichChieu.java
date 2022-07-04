
package Entity;

import java.util.Date;


public class LichChieu {
    private String MaLichChieu;
    private Date NgayChieu;
    private String GioChieu;
    private String MaPhim;
    private String MaPhong;
    private boolean HIDE;
    private String PhongChieu;

    @Override
    public String toString() {
        return this.MaLichChieu;
    }

    public LichChieu() {
    }

    public LichChieu(String MaLichChieu, Date NgayChieu, String GioChieu, String MaPhim, String MaPhong, boolean HIDE) {
        this.MaLichChieu = MaLichChieu;
        this.NgayChieu = NgayChieu;
        this.GioChieu = GioChieu;
        this.MaPhim = MaPhim;
        this.MaPhong = MaPhong;
        this.HIDE = HIDE;
    }
    

    public String getMaLichChieu() {
        return MaLichChieu;
    }

    public void setMaLichChieu(String MaLichChieu) {
        this.MaLichChieu = MaLichChieu;
    }

    public Date getNgayChieu() {
        return NgayChieu;
    }

    public void setNgayChieu(Date NgayChieu) {
        this.NgayChieu = NgayChieu;
    }

    public String getGioChieu() {
        return GioChieu;
    }

    public void setGioChieu(String GioChieu) {
        this.GioChieu = GioChieu;
    }

    public String getMaPhim() {
        return MaPhim;
    }

    public void setMaPhim(String MaPhim) {
        this.MaPhim = MaPhim;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public boolean isHIDE() {
        return HIDE;
    }

    public void setHIDE(boolean HIDE) {
        this.HIDE = HIDE;
    }

    public String getPhongChieu() {
        return PhongChieu;
    }

    public void setPhongChieu(String PhongChieu) {
        this.PhongChieu = PhongChieu;
    }
    
    
    
}
