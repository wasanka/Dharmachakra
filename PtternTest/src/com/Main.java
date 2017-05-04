package com;

import javax.swing.*;
import java.awt.*;

public class Main {

    private final Color BLUE = Color.blue;

    private final Color YELLOW = Color.yellow;
    private final Color RED = Color.red;
    private final Color WHITE = Color.white;
    private final Color ORANGE = Color.orange;

    private final int NUMBER_OF_PIXELS = 64;

    Adafruit_NeoPixel pixels = new Adafruit_NeoPixel(NUMBER_OF_PIXELS);

//    private Pixel[] pixels = new Pixel[NUMBER_OF_PIXELS];


    public Main() {

        JFrame f = new JFrame("Patterns");

        f.setContentPane(pixels);
        f.pack();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    loop();
                }
            }
        });
        t.start();
    }

    private int[] outerCircle = new int[]{13, 40, 42, 28, 44, 46, 3, 55, 53, 23, 51, 49, 18, 48, 50, 38, 52, 54, 8, 47, 45, 33, 43, 41};
    private int[] innerCircle = new int[]{10, 56, 25, 60, 0, 62, 20, 58, 15, 59, 35, 63, 5, 61, 30, 57};

    private int[] pole1 = new int[]{10, 11, 12, 13, 14};
    private int[] pole2 = new int[]{25, 26, 27, 28, 29};
    private int[] pole3 = new int[]{0, 1, 2, 3, 4};
    private int[] pole4 = new int[]{20, 21, 22, 23, 24};
    private int[] pole5 = new int[]{15, 16, 17, 18, 19};
    private int[] pole6 = new int[]{35, 36, 37, 38, 39};
    private int[] pole7 = new int[]{5, 6, 7, 8, 9};
    private int[] pole8 = new int[]{30, 31, 32, 33, 34};


    public static void main(String[] args) {
        // write your code here

        new Main();
    }

    public void loop() {

//        outterCircle();
//        innerCircle();
//        rainbowCycle(100);
//        theaterChase(BLUE, 100);
//        theaterChase(YELLOW, 100);
//        theaterChase(RED, 100);
//        theaterChase(WHITE, 100);
//        theaterChase(ORANGE, 100);

//        theaterChaseRainbow(100);

        pattern3();
        for (int i = 0; i < 5; i++) {
            pattern2();
        }
        pattern1();
    }

    void pattern3() {

        Color[] colors = new Color[]{WHITE, BLUE, YELLOW, RED, WHITE, ORANGE};

        for (int i = 0; i < colors.length; i++) {


            Color x = colors[i % colors.length];
            Color y = colors[(i + 1) % colors.length];

            int oldColorR = x.getRed();
            int oldColorG = x.getGreen();
            int oldColorB = x.getBlue();

            int newColorR = y.getRed();
            int newColorG = y.getGreen();
            int newColorB = y.getBlue();

            int[] redValues = new int[100];
            int[] greenValues = new int[100];
            int[] blueValues = new int[100];

            fade(oldColorR, newColorR, 100, redValues);
            fade(oldColorG, newColorG, 100, greenValues);
            fade(oldColorB, newColorB, 100, blueValues);

            for (int j = 0; j < 100; j ++) {

                for (int k = 0; k < pixels.numPixels(); k++) {

                    pixels.setPixelColor(k, pixels.Color(redValues[j], greenValues[j], blueValues[j]));
                }
                pixels.show();
                delay(10);
            }

            delay(1000);
        }
    }

    void fade(int x, int y, int steps, int[] values){

        int a = x < y ? x : y;
        int b = x < y ? y : x;
        if(x < y) {
            for (int j = 0; j < steps; j++) {
                values[j] = x + (int) ((b - a) * j / steps);
            }
        } else if(x > y) {
            for (int j = 0; j < steps; j++) {
                values[j] = x - (int) ((b - a) * j / steps);
            }
        } else {
            for (int j = 0; j < steps; j++) {
                values[j] = x;
            }
        }
        values[0] = x;
        values[steps -1 ] = y;
    }

    void pattern2() {

        Color[] colors = new Color[]{BLUE, YELLOW, RED, WHITE, ORANGE};

        for (int i = 0; i < pixels.numPixels(); i++) {

            pixels.setPixelColor(i, WHITE);
        }
        pixels.show();
        delay(100);

        for (int i = 0; i < colors.length; i++) {

            for (int j = 0; j < pole1.length; j++) {
                pixels.setPixelColor(pole1[j], colors[(i + 0) % 5]);
            }
            for (int j = 0; j < pole2.length; j++) {
                pixels.setPixelColor(pole2[j], colors[(i + 1) % 5]);
            }
            for (int j = 0; j < pole2.length; j++) {
                pixels.setPixelColor(pole3[j], colors[(i + 2) % 5]);
            }
            for (int j = 0; j < pole2.length; j++) {
                pixels.setPixelColor(pole4[j], colors[(i + 3) % 5]);
            }
            for (int j = 0; j < pole2.length; j++) {
                pixels.setPixelColor(pole5[j], colors[(i + 4) % 5]);
            }
            for (int j = 0; j < pole2.length; j++) {
                pixels.setPixelColor(pole6[j], colors[(i + 5) % 5]);
            }
            for (int j = 0; j < pole2.length; j++) {
                pixels.setPixelColor(pole7[j], colors[(i + 6) % 5]);
            }
            for (int j = 0; j < pole2.length; j++) {
                pixels.setPixelColor(pole8[j], colors[(i + 7) % 5]);
            }
            pixels.show();
            delay(200);
        }
    }

    void pattern1() {

        Color[] colors = new Color[]{BLUE, YELLOW, RED, WHITE, ORANGE};

        for (int i = 0; i < pixels.numPixels(); i++) {

            pixels.setPixelColor(i, WHITE);
        }
        pixels.show();

        for (int i = 0; i < colors.length; i++) {

            for (int j = 0; j < pole1.length; j++) {

                pixels.setPixelColor(pole1[j], colors[i]);
                pixels.setPixelColor(pole2[j], colors[i]);
                pixels.setPixelColor(pole3[j], colors[i]);
                pixels.setPixelColor(pole4[j], colors[i]);
                pixels.setPixelColor(pole5[j], colors[i]);
                pixels.setPixelColor(pole6[j], colors[i]);
                pixels.setPixelColor(pole7[j], colors[i]);
                pixels.setPixelColor(pole8[j], colors[i]);

                if (j == 0) {

                    for (int k = 0; k < innerCircle.length; k++) {

                        pixels.setPixelColor(innerCircle[k], colors[i]);
                    }
                } else if (j == 3) {

                    for (int k = 0; k < outerCircle.length; k++) {

                        pixels.setPixelColor(outerCircle[k], colors[i]);
                    }
                }

                pixels.show();
                delay(100);
            }
        }
    }

    void theaterChase(Color c, int wait) {
        for (int j = 0; j < 10; j++) {  //do 10 cycles of chasing
            for (int q = 0; q < 3; q++) {
                for (int i = 0; i < outerCircle.length; i = i + 3) {
                    pixels.setPixelColor(outerCircle[i + q], c);    //turn every third pixel on
                }
                pixels.show();

                delay(wait);

                for (int i = 0; i < outerCircle.length; i = i + 3) {
                    pixels.setPixelColor(outerCircle[i + q], 0);        //turn every third pixel off
                }
            }
        }
    }

    void theaterChaseRainbow(int wait) {
        for (int j = 0; j < 256; j++) {     // cycle all 256 colors in the wheel
            for (int q = 0; q < 3; q++) {
                for (int i = 0; i < outerCircle.length; i = i + 3) {
                    pixels.setPixelColor(outerCircle[i + q], Wheel((i + j) % 255));    //turn every third pixel on
                }
                pixels.show();

                delay(wait);

                for (int i = 0; i < outerCircle.length; i = i + 3) {
                    pixels.setPixelColor(outerCircle[i + q], 0);        //turn every third pixel off
                }
            }
        }
    }

    void rainbowCycle(int wait) {
        int i, j;

        for (j = 0; j < 256 * 5; j++) { // 5 cycles of all colors on wheel
            for (i = 0; i < outerCircle.length; i++) {
                pixels.setPixelColor(outerCircle[i], Wheel((byte) (((i * 256 / outerCircle.length) + j) & 255)));
            }
            pixels.show();
            delay(wait);
        }
    }

    Color Wheel(int WheelPos) {

        WheelPos = unsignedToBytes((byte) (255 - WheelPos));
        if (WheelPos < 85) {
            return pixels.Color(255 - WheelPos * 3, 0, WheelPos * 3);
        }
        if (WheelPos < 170) {
            WheelPos -= 85;
            return pixels.Color(0, WheelPos * 3, 255 - WheelPos * 3);
        }
        WheelPos -= 170;
        return pixels.Color(WheelPos * 3, 255 - WheelPos * 3, 0);
    }

    public static int unsignedToBytes(byte b) {
        return b & 0xFF;
    }

    private void innerCircle() {

        System.out.println();
        for (int i = 0; i < innerCircle.length; i++) {

            pixels.setPixelColor(innerCircle[i], pixels.Color(255, 0, 0));
            pixels.show();
            delay(100);
            pixels.setPixelColor(innerCircle[i], pixels.Color(0, 0, 0));
            pixels.show();
        }
    }

    private void outterCircle() {

        for (int i = 0; i < outerCircle.length; i++) {

            pixels.setPixelColor(outerCircle[i], BLUE);
            pixels.show();
            delay(100);
            pixels.setPixelColor(outerCircle[i], WHITE);
            pixels.show();
        }

    }

    private void delay(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
