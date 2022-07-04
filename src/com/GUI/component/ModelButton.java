/* @author nghiacubu */


package com.GUI.component;

import com.GUI.swing.Button;


public class ModelButton {
    int id;
    Button btn;
    boolean stt;

    public ModelButton(int id, Button btn, boolean stt) {
        this.id = id;
        this.btn = btn;
        this.stt = stt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public boolean isStt() {
        return stt;
    }

    public void setStt(boolean stt) {
        this.stt = stt;
    }

}
