package com;

import javax.swing.*;
import java.awt.*;

public class Main {

    private final Color BLUE = Color.blue;

    private final Color YELLOW = Color.yellow;
    private final Color RED = Color.red;
    private final Color WHIRE = Color.white;
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

    private int[] outerCircle = new int[]{13,40 ,42 ,28, 44, 46,3, 55, 53, 23, 51, 49, 18, 48, 50,  38, 52, 54, 8, 47, 45, 33, 43, 41};
    private int[] innerCircle = new int[]{10, 56, 25,  60, 0, 62, 20, 58,15 ,59, 35, 63, 5, 61, 30,57};

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
        //rainbowCycle(100);
//        theaterChase(BLUE, 100);
//        theaterChase(YELLOW, 100);
//        theaterChase(RED, 100);
//        theaterChase(WHIRE, 100);
//        theaterChase(ORANGE, 100);

        theaterChaseRainbow(100);
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
        for (int j=0; j < 256; j++) {     // cycle all 256 colors in the wheel
            for (int q=0; q < 3; q++) {
                for (int i=0; i < outerCircle.length; i=i+3) {
                    pixels.setPixelColor(outerCircle[i+q], Wheel( (i+j) % 255));    //turn every third pixel on
                }
                pixels.show();

                delay(wait);

                for (int i=0; i < outerCircle.length; i=i+3) {
                    pixels.setPixelColor(outerCircle[i+q], 0);        //turn every third pixel off
                }
            }
        }
    }

    void rainbowCycle(int wait) {
        int i, j;

        for(j=0; j<256*5; j++) { // 5 cycles of all colors on wheel
            for(i=0; i< outerCircle.length; i++) {
                pixels.setPixelColor(outerCircle[i], Wheel((byte) (((i * 256 / outerCircle.length) + j) & 255)));
            }
            pixels.show();
            delay(wait);
        }
    }

    Color Wheel(int WheelPos) {

        WheelPos = unsignedToBytes((byte) (255 - WheelPos));
        if(WheelPos < 85) {
            return pixels.Color(255 - WheelPos * 3, 0, WheelPos * 3);
        }
        if(WheelPos < 170) {
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

            pixels.setPixelColor(innerCircle[i], pixels.Color(255,0,0));
            pixels.show();
            delay(100);
            pixels.setPixelColor(innerCircle[i], pixels.Color(0,0,0));
            pixels.show();
        }
//        for (int i = 0; i < innerCircle.length; i++) {
//
//            pixels[innerCircle[i]].setColor(YELLOW);
//            System.out.println(innerCircle[i]);
//            delay(100);
//            pixels[innerCircle[i]].setColor(WHIRE);
//        }
//        for (int i = 0; i < innerCircle.length; i++) {
//
//            pixels[innerCircle[i]].setColor(RED);
//            System.out.println(innerCircle[i]);
//            delay(100);
//            pixels[innerCircle[i]].setColor(WHIRE);
//        }
//        for (int i = 0; i < innerCircle.length; i++) {
//
//            pixels[innerCircle[i]].setColor(WHIRE);
//            System.out.println(innerCircle[i]);
//            delay(100);
//            pixels[innerCircle[i]].setColor(YELLOW);
//        }
//        for (int i = 0; i < innerCircle.length; i++) {
//
//            pixels[innerCircle[i]].setColor(ORANGE);
//            System.out.println(innerCircle[i]);
//            delay(100);
//            pixels[innerCircle[i]].setColor(WHIRE);
//        }
    }

    private void outterCircle() {

//        for (int i = 0; i < outerCircle.length; i++) {
//
//            pixels[outerCircle[i]].setColor(BLUE);
//            System.out.println(outerCircle[i]);
//            delay(100);
//            pixels[outerCircle[i]].setColor(WHIRE);
//        }
    }

    private void delay(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
