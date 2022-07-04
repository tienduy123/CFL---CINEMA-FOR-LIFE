package Entity;

public class Ghe {
    
    private String maGhe;
    private boolean loaiGhe;
    private double giaGhe;
    private String maPhong;
    private String GioChieu;
    private boolean trangThai;
    
    public Ghe() {
        
    }

    public Ghe(String maGhe, boolean loaiGhe, double giaGhe, String maPhong, String GioChieu, boolean trangThai) {
        this.maGhe = maGhe;
        this.loaiGhe = loaiGhe;
        this.giaGhe = giaGhe;
        this.maPhong = maPhong;
        this.GioChieu = GioChieu;
        this.trangThai = trangThai;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public boolean isLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(boolean loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public double getGiaGhe() {
        return giaGhe;
    }

    public void setGiaGhe(double giaGhe) {
        this.giaGhe = giaGhe;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getGioChieu() {
        return GioChieu;
    }

    public void setGioChieu(String GioChieu) {
        this.GioChieu = GioChieu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }


}
