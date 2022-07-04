


package Entity;


public class DichVu {    
    private String MaDichVu;
    private String TenDichVu;
    private Double GiaDichVu;
    private boolean HIDE;

    public DichVu() {
    }

    public DichVu(String MaDichVu, String TenDichVu, Double GiaDichVu, boolean HIDE) {
        this.MaDichVu = MaDichVu;
        this.TenDichVu = TenDichVu;
        this.GiaDichVu = GiaDichVu;
        this.HIDE = HIDE;
    }

    public String getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(String MaDichVu) {
        this.MaDichVu = MaDichVu;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String TenDichVu) {
        this.TenDichVu = TenDichVu;
    }

    public Double getGiaDichVu() {
        return GiaDichVu;
    }

    public void setGiaDichVu(Double GiaDichVu) {
        this.GiaDichVu = GiaDichVu;
    }

    public boolean isHIDE() {
        return HIDE;
    }

    public void setHIDE(boolean HIDE) {
        this.HIDE = HIDE;
    }

    @Override
    public String toString() {
        return this.TenDichVu;
    }
    
}
