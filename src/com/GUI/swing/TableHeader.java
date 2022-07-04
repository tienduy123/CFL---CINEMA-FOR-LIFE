
package com.GUI.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel{

    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(Color.WHITE);
        setFont(new Font("Segoe UI Black", Font.BOLD, 18));
        setForeground(new Color(102, 102, 102));
        setBorder(new EmptyBorder(10,5,10,5));
    }
    
    @Override
    protected void paintComponent(Graphics grphs){
        super.paintComponent(grphs);
        grphs.setColor(new Color(230, 230, 230));
        grphs.drawLine(0, getWidth()-1, getWidth(), getHeight()-1);
    }
    
}
