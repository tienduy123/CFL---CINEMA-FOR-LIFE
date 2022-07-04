
package Entity;

public class Phong {

    private int id;
    private String maphong;
    private boolean hide;

    public Phong() {
    }

    public Phong(int id, String maphong, boolean hide) {
        this.id = id;
        this.maphong = maphong;
        this.hide = hide;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }
}
