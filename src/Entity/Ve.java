
package Entity;

public class Ve {

    private int id;
    private String maghe;
    private String mave;
    private String maphim;
    private String malichchieu;
    private String maphong;
    private String giochieu;

    public Ve() {
    }

    public Ve(int id, String mave, String maphim, String malichchieu, String maphong, String maghe, String giochieu) {
        this.id = id;
        this.mave = mave;
        this.maphim = maphim;
        this.malichchieu = malichchieu;
        this.maphong = maphong;
        this.maghe = maghe;
        this.giochieu = giochieu;
    }

    public String getGiochieu() {
        return giochieu;
    }

    public void setGiochieu(String giochieu) {
        this.giochieu = giochieu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getMaphim() {
        return maphim;
    }

    public void setMaphim(String maphim) {
        this.maphim = maphim;
    }

    public String getMalichchieu() {
        return malichchieu;
    }

    public void setMalichchieu(String malichchieu) {
        this.malichchieu = malichchieu;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getMaghe() {
        return maghe;
    }

    public void setMaghe(String maghe) {
        this.maghe = maghe;
    }

    
    
}
