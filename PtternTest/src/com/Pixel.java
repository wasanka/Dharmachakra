package com;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ww78656 on 5/3/2017.
 */
public class Pixel extends JPanel {

    private final int SIZE = 20;
    private Color color = Color.black;
    boolean on = false;

    public Pixel() {

        setPreferredSize(new Dimension(SIZE + 2, SIZE + 2));
        setOpaque(false);
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(color);
        g.drawOval(1, 1, SIZE, SIZE);
        if(!on){

            return;
        }
        g.fillOval(1, 1, SIZE, SIZE);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void on() {

        if(color.getRed() == 0 && color.getBlue() ==0 && color.getGreen() == 0){
            on = false;
        } else {
            on = true;
        }
        repaint();
    }
}
