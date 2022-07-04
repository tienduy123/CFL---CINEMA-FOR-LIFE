
package Entity;

public class NhanVien {

    private String MaNhanVien;
    private String HoTen;
    private String SDT;
    private String Email;
    private boolean GioiTinh;
    private boolean ChucVu;
    private String MatKhau;
    private String Hinh;
    private String GhiChu;
    private boolean HIDE;

    public NhanVien() {
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public int gioitinh() {
        return GioiTinh ? 1 : 0;
    }

    public String getGioiTinh() {
        if (GioiTinh) {
            return "Nam";
        }
        return "Nữ";
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public boolean isChucVu() {
        return ChucVu;
    }

    public int chucvu() {
        return ChucVu ? 1 : 0;
    }

    public String getChucVu() {
        if (ChucVu) {
            return "Quản Lý";
        }
        return "Nhân Viên";
    }

    public void setChucVu(boolean ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public boolean isHIDE() {
        return HIDE;
    }

    public void setHIDE(boolean HIDE) {
        this.HIDE = HIDE;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public NhanVien(String MaNhanVien, String HoTen, String SDT, String Email, boolean GioiTinh, boolean ChucVu, String MatKhau, String Hinh, String GhiChu, boolean HIDE) {
        this.MaNhanVien = MaNhanVien;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.ChucVu = ChucVu;
        this.MatKhau = MatKhau;
        this.Hinh = Hinh;
        this.GhiChu = GhiChu;
        this.HIDE = HIDE;
    }
    
    
}
