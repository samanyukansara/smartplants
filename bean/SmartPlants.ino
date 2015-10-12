/* 
  This sketch uses the Bean library to blink the on-board RGB LED. 
  
  Notes:
    - This is not a low-power sketch 
    - A Bean with a low battery might show a faint blue and green LED color
  
  This example code is in the public domain.
*/

void setup() {
  //set data rate for computer communication
  Serial.begin(57600);
  
  //Shows the application is running shows blue light
  Bean.setLed(0, 0, 255);
  
  // initialize light and water sensor
  pinMode(0, OUTPUT);     // set D0 as output
  digitalWrite(0, LOW);   // turn it off initially
  
}

void loop() {
  int temperature = Bean.getTemperature();
  
  digitalWrite(0, HIGH);
  digitalWrite(1, HIGH);
  
  Bean.sleep(10);
  
  int lightValue;
  int waterValue;
  lightValue = analogRead(A1);
  waterValue = analogRead(A0);
  
  Serial.print("Temperature: ");
  Serial.print(temperature);
  Serial.println(" C");
  
  Serial.print("Light: ");
  Serial.print(lightValue);
  Serial.println("");
  
  Serial.print("Water: ");
  Serial.print(waterValue);
  Serial.println("");
  
  Bean.sleep(3000);
}
