#include <Adafruit_NeoPixel.h>
#ifdef __AVR__
  #include <avr/power.h>
#endif

// Which pin on the Arduino is connected to the NeoPixels?
// On a Trinket or Gemma we suggest changing this to 1
#define PIN            6

// How many NeoPixels are attached to the Arduino?
#define NUMPIXELS      64

// When we setup the NeoPixel library, we tell it how many pixels, and which pin to use to send signals.
// Note that for older NeoPixel strips you might need to change the third parameter--see the strandtest
// example for more information on possible values.
Adafruit_NeoPixel pixels = Adafruit_NeoPixel(NUMPIXELS, PIN, NEO_GRB + NEO_KHZ800);


int outerCircle[] = {13, 40, 42, 28, 44, 46, 3, 55, 53, 23, 51, 49, 18, 48, 50, 38, 52, 54, 8, 47, 45, 33, 43, 41};
int innerCircle[] = {10, 56, 25, 60, 0, 62, 20, 58, 15, 59, 35, 63, 5, 61, 30, 57};

int pole1[] = {10, 11, 12, 13, 14};
int pole2[] = {25, 26, 27, 28, 29};
int pole3[] = {0, 1, 2, 3, 4};
int pole4[] = {20, 21, 22, 23, 24};
int pole5[] = {15, 16, 17, 18, 19};
int pole6[] = {35, 36, 37, 38, 39};
int pole7[] = {5, 6, 7, 8, 9};
int pole8[] = {30, 31, 32, 33, 34};

uint32_t BLUE;
uint32_t YELLOW;
uint32_t RED;
uint32_t WHITE;
uint32_t ORANGE;


// the setup function runs once when you press reset or power the board
void setup() {
  pixels.begin();

  BLUE = pixels.Color(0, 0, 255);
  YELLOW = pixels.Color(255, 255, 0);
  RED = pixels.Color(255, 0, 0);
  WHITE = pixels.Color(255, 255, 255);
  ORANGE = pixels.Color(255, 128, 0);
}

// the loop function runs over and over again forever
void loop() {

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

        uint32_t colors[] = {WHITE, BLUE, YELLOW, RED, WHITE, ORANGE};

        for (int i = 0; i < sizeof(colors)/sizeof(int); i++) {


            uint32_t x = colors[i % sizeof(colors)/sizeof(int)];
            uint32_t y = colors[(i + 1) % sizeof(colors)/sizeof(int)];

            uint8_t oldColorR = (uint8_t)(x >> 16);
            uint8_t oldColorG = (uint8_t)(x >>  8);
            uint8_t oldColorB = (uint8_t)x;

            uint8_t newColorR = (uint8_t)(y >> 16);
            uint8_t newColorG = (uint8_t)(y >>  8);
            uint8_t newColorB = (uint8_t)y;

            int redValues[100];
            int greenValues[100];
            int blueValues[100];

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

    void fade(int x, int y, int steps, int values[]){

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

        uint32_t colors[] = {WHITE, BLUE, YELLOW, RED, WHITE, ORANGE};

        for (int i = 0; i < pixels.numPixels(); i++) {

            pixels.setPixelColor(i, WHITE);
        }
        pixels.show();
        delay(100);

        for (int i = 0; i < sizeof(colors)/sizeof(int); i++) {

            for (int j = 0; j < sizeof(pole1)/sizeof(int); j++) {
                pixels.setPixelColor(pole1[j], colors[(i + 0) % 5]);
            }
            for (int j = 0; j < sizeof(pole1)/sizeof(int); j++) {
                pixels.setPixelColor(pole2[j], colors[(i + 1) % 5]);
            }
            for (int j = 0; j < sizeof(pole1)/sizeof(int); j++) {
                pixels.setPixelColor(pole3[j], colors[(i + 2) % 5]);
            }
            for (int j = 0; j < sizeof(pole1)/sizeof(int); j++) {
                pixels.setPixelColor(pole4[j], colors[(i + 3) % 5]);
            }
            for (int j = 0; j < sizeof(pole1)/sizeof(int); j++) {
                pixels.setPixelColor(pole5[j], colors[(i + 4) % 5]);
            }
            for (int j = 0; j < sizeof(pole1)/sizeof(int); j++) {
                pixels.setPixelColor(pole6[j], colors[(i + 5) % 5]);
            }
            for (int j = 0; j < sizeof(pole1)/sizeof(int); j++) {
                pixels.setPixelColor(pole7[j], colors[(i + 6) % 5]);
            }
            for (int j = 0; j < sizeof(pole1)/sizeof(int); j++) {
                pixels.setPixelColor(pole8[j], colors[(i + 7) % 5]);
            }
            pixels.show();
            delay(200);
        }
    }

    void pattern1() {

        uint32_t colors[] = {WHITE, BLUE, YELLOW, RED, WHITE, ORANGE};

        for (int i = 0; i < pixels.numPixels(); i++) {

            pixels.setPixelColor(i, WHITE);
        }
        pixels.show();

        for (int i = 0; i < sizeof(colors)/sizeof(int); i++) {

            for (int j = 0; j < sizeof(pole1)/sizeof(int); j++) {

                pixels.setPixelColor(pole1[j], colors[i]);
                pixels.setPixelColor(pole2[j], colors[i]);
                pixels.setPixelColor(pole3[j], colors[i]);
                pixels.setPixelColor(pole4[j], colors[i]);
                pixels.setPixelColor(pole5[j], colors[i]);
                pixels.setPixelColor(pole6[j], colors[i]);
                pixels.setPixelColor(pole7[j], colors[i]);
                pixels.setPixelColor(pole8[j], colors[i]);

                if (j == 0) {

                    for (int k = 0; k < sizeof(innerCircle)/sizeof(int); k++) {

                        pixels.setPixelColor(innerCircle[k], colors[i]);
                    }
                } else if (j == 3) {

                    for (int k = 0; k < sizeof(outerCircle)/sizeof(int); k++) {

                        pixels.setPixelColor(outerCircle[k], colors[i]);
                    }
                }

                pixels.show();
                delay(100);
            }
        }
    }
