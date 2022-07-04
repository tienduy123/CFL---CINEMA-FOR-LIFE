
package Entity;

import java.util.Date;

public class Phim {
    private String MaPhim;
    private String TenPhim;
    private Date NgayKhoiChieu;
    private Date NgayKetThuc;
    private String QuocGia;
    private String MaTheLoai;
    private String DinhDang;
    private String Hinh;
    private String MaNhanVien;
    private boolean HIDE;

    @Override
    public String toString() {
        return this.TenPhim;
    }

    public Phim() {
    }

    public Phim(String MaPhim, String TenPhim, Date NgayKhoiChieu, Date NgayKetThuc, String QuocGia, String MaTheLoai, String DinhDang, String Hinh, String MaNhanVien, boolean HIDE) {
        this.MaPhim = MaPhim;
        this.TenPhim = TenPhim;
        this.NgayKhoiChieu = NgayKhoiChieu;
        this.NgayKetThuc = NgayKetThuc;
        this.QuocGia = QuocGia;
        this.MaTheLoai = MaTheLoai;
        this.DinhDang = DinhDang;
        this.Hinh = Hinh;
        this.MaNhanVien = MaNhanVien;
        this.HIDE = HIDE;
    }
    
    public String getMaPhim() {
        return MaPhim;
    }

    public void setMaPhim(String MaPhim) {
        this.MaPhim = MaPhim;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String TenPhim) {
        this.TenPhim = TenPhim;
    }

    public Date getNgayKhoiChieu() {
        return NgayKhoiChieu;
    }

    public void setNgayKhoiChieu(Date NgayKhoiChieu) {
        this.NgayKhoiChieu = NgayKhoiChieu;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String QuocGia) {
        this.QuocGia = QuocGia;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public String getDinhDang() {
        return DinhDang;
    }

    public void setDinhDang(String DinhDang) {
        this.DinhDang = DinhDang;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
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
