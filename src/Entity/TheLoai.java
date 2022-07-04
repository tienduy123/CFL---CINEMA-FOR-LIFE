
package Entity;


public class TheLoai {
    private String MaTheLoai;
    private String TenTheLoai;
    private boolean HIDE;
    
    @Override
    public String toString() {
        return this.TenTheLoai;
    }

    public TheLoai() {
    }

    public TheLoai(String MaTheLoai, String TenTheLoai, boolean HIDE) {
        this.MaTheLoai = MaTheLoai;
        this.TenTheLoai = TenTheLoai;
        this.HIDE = HIDE;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }

    public boolean isHIDE() {
        return HIDE;
    }

    public void setHIDE(boolean HIDE) {
        this.HIDE = HIDE;
    }
    
    
}
