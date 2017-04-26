/*
  Blink
  Turns on an LED on for one second, then off for one second, repeatedly.

  Most Arduinos have an on-board LED you can control. On the UNO, MEGA and ZERO 
  it is attached to digital pin 13, on MKR1000 on pin 6. LED_BUILTIN takes care 
  of use the correct LED pin whatever is the board used.
  If you want to know what pin the on-board LED is connected to on your Arduino model, check
  the Technical Specs of your board  at https://www.arduino.cc/en/Main/Products
  
  This example code is in the public domain.

  modified 8 May 2014
  by Scott Fitzgerald
  
  modified 2 Sep 2016
  by Arturo Guadalupi
*/

int RED = 16;
int GREEN = 5;
int BLUE = 4;

int pins[] = {0, 2, 14, 12, 13, 15, 3, 1};

// the setup function runs once when you press reset or power the board
void setup() {
  // initialize digital pin LED_BUILTIN as an output.
  pinMode(RED, OUTPUT);
  pinMode(GREEN, OUTPUT);
  pinMode(BLUE, OUTPUT);

  for(int i = 0; i < 8; i++){
    pinMode(pins[i], OUTPUT);
  }
  
}

// the loop function runs over and over again forever
void loop() {


  digitalWrite(GREEN, HIGH);
  for(int i = 0; i < 8; i++){

    digitalWrite(pins[i], LOW);   // turn the LED on (HIGH is the voltage level)
    delay(500); 
    digitalWrite(pins[i], HIGH);
    delay(500); 
  }
  digitalWrite(GREEN, LOW);
  delay(500); 

  digitalWrite(RED, HIGH);
  for(int i = 0; i < 8; i++){

    digitalWrite(pins[i], LOW);   // turn the LED on (HIGH is the voltage level)
    delay(500); 
    digitalWrite(pins[i], HIGH);
    delay(500); 
  }
  digitalWrite(RED, LOW);
  delay(500); 

digitalWrite(BLUE, HIGH);
  for(int i = 0; i < 8; i++){

    digitalWrite(pins[i], LOW);   // turn the LED on (HIGH is the voltage level)
    delay(500); 
    digitalWrite(pins[i], HIGH);
    delay(500); 
  }
  digitalWrite(BLUE, LOW);
  delay(500); 

  //digitalWrite(5, HIGH);
  //digitalWrite(15, LOW);
}
