package com;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ww78656 on 5/4/2017.
 */
public class Adafruit_NeoPixel extends JPanel{

    private Pixel[] pixels;

    private final int GAP = 50;
    private final Point middle = new Point(350, 350);
    private final int MIDDLE_RADIUS = 100;

    public Adafruit_NeoPixel(int numberOfPixels) {

        setLayout(null);

        pixels = new Pixel[numberOfPixels];

        for (int i = 0; i < numberOfPixels; i++) {

            add(pixels[i] = new Pixel());
        }

        int offset = 0;
        for (int i = offset; i < 5; i++) {

            pixels[i].setBounds(middle.x + MIDDLE_RADIUS + i * GAP, middle.y, 22, 22);
        }
        offset = 5;
        for (int i = offset; i < 10; i++) {

            pixels[i].setBounds(middle.x - MIDDLE_RADIUS - (i - offset) * GAP, middle.y, 22, 22);
        }

        offset = 10;
        for (int i = offset; i < 15; i++) {

            pixels[i].setBounds(middle.x, middle.y - MIDDLE_RADIUS - (i - offset) * GAP, 22, 22);
        }

        offset = 15;
        for (int i = offset; i < 20; i++) {

            pixels[i].setBounds(middle.x, middle.y + MIDDLE_RADIUS + (i - offset) * GAP, 22, 22);
        }

        offset = 20;
        for (int i = offset; i < 25; i++) {

            pixels[i].setBounds((int)(middle.x + (MIDDLE_RADIUS + (i - offset) * GAP) * 0.75), (int)(middle.y + (MIDDLE_RADIUS + (i - offset) * GAP) * 0.75), 22, 22);
        }

        offset = 25;
        for (int i = offset; i < 30; i++) {

            pixels[i].setBounds((int)(middle.x + (MIDDLE_RADIUS + (i - offset) * GAP) * 0.75), (int)(middle.y -(MIDDLE_RADIUS + (i - offset) * GAP) * 0.75), 22, 22);
        }

        offset = 30;
        for (int i = offset; i < 35; i++) {

            pixels[i].setBounds((int)(middle.x - (MIDDLE_RADIUS + (i - offset) * GAP) * 0.75), (int)(middle.y -(MIDDLE_RADIUS + (i - offset) * GAP) * 0.75), 22, 22);
        }

        offset = 35;
        for (int i = offset; i < 40; i++) {

            pixels[i].setBounds((int)(middle.x - (MIDDLE_RADIUS + (i - offset) * GAP) * 0.75), (int)(middle.y + (MIDDLE_RADIUS + (i - offset) * GAP) * 0.75), 22, 22);
        }

        offset = 40;
        pixels[offset++].setBounds((int)(middle.x + MIDDLE_RADIUS / 2), (int)(middle.y - (MIDDLE_RADIUS + 3 * GAP)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x - MIDDLE_RADIUS / 2), (int)(middle.y - (MIDDLE_RADIUS + 3 * GAP)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x + MIDDLE_RADIUS + GAP / 2), (int)(middle.y - (MIDDLE_RADIUS + 2.5 * GAP)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x - (MIDDLE_RADIUS + GAP / 2)), (int)(middle.y - (MIDDLE_RADIUS + 2.5 * GAP)), 22, 22);

        pixels[offset++].setBounds((int)(middle.x + (MIDDLE_RADIUS + 2.5 * GAP)), (int)(middle.y - (MIDDLE_RADIUS + 0.5 * GAP)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x - (MIDDLE_RADIUS + 2.5 * GAP)), (int)(middle.y - (MIDDLE_RADIUS + 0.5 * GAP)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x + (MIDDLE_RADIUS + 3 * GAP)), (int)(middle.y - (MIDDLE_RADIUS / 2)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x - (MIDDLE_RADIUS + 3 * GAP)), (int)(middle.y - (MIDDLE_RADIUS / 2)), 22, 22);

        pixels[offset++].setBounds((int)(middle.x - MIDDLE_RADIUS / 2), (int)(middle.y + (MIDDLE_RADIUS + 3 * GAP)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x + MIDDLE_RADIUS / 2), (int)(middle.y + (MIDDLE_RADIUS + 3 * GAP)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x - (MIDDLE_RADIUS + GAP / 2)), (int)(middle.y + (MIDDLE_RADIUS + 2.5 * GAP)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x + (MIDDLE_RADIUS + GAP / 2)), (int)(middle.y + (MIDDLE_RADIUS + 2.5 * GAP)), 22, 22);

        pixels[offset++].setBounds((int)(middle.x - (MIDDLE_RADIUS + 2.5 * GAP)), (int)(middle.y + (MIDDLE_RADIUS + 0.5 * GAP)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x + (MIDDLE_RADIUS + 2.5 * GAP)), (int)(middle.y + (MIDDLE_RADIUS + 0.5 * GAP)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x - (MIDDLE_RADIUS + 3 * GAP)), (int)(middle.y + (MIDDLE_RADIUS / 2)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x + (MIDDLE_RADIUS + 3 * GAP)), (int)(middle.y + (MIDDLE_RADIUS / 2)), 22, 22);

        pixels[offset++].setBounds((int)(middle.x + MIDDLE_RADIUS * 0.4), (int)(middle.y - (MIDDLE_RADIUS * 0.9)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x - MIDDLE_RADIUS * 0.4), (int)(middle.y - (MIDDLE_RADIUS * 0.9)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x + MIDDLE_RADIUS * 0.4), (int)(middle.y + (MIDDLE_RADIUS * 0.9)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x - MIDDLE_RADIUS * 0.4), (int)(middle.y + (MIDDLE_RADIUS * 0.9)), 22, 22);

        pixels[offset++].setBounds((int)(middle.x + MIDDLE_RADIUS * 0.9), (int)(middle.y - (MIDDLE_RADIUS * 0.4)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x - MIDDLE_RADIUS * 0.9), (int)(middle.y - (MIDDLE_RADIUS * 0.4)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x + MIDDLE_RADIUS * 0.9), (int)(middle.y + (MIDDLE_RADIUS * 0.4)), 22, 22);
        pixels[offset++].setBounds((int)(middle.x - MIDDLE_RADIUS * 0.9), (int)(middle.y + (MIDDLE_RADIUS * 0.4)), 22, 22);

        setPreferredSize(new Dimension(800, 800));
    }

    public Color Color(int r, int g, int b) {
        return new Color(r, g, b);
    }

    public void setPixelColor(int i, Color color) {

        pixels[i].setColor(color);
    }

    public void setPixelColor(int i, int color) {

        if(color == 0) {
            pixels[i].setColor(Color.black);
        }
    }

    public void show(){

        for(int i = 0; i < pixels.length; i++){
            pixels[i].on();
        }
    }

    public int numPixels() {
        return pixels.length;
    }
}
