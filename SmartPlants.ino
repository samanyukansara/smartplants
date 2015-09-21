/* 
  This sketch uses the Bean library to blink the on-board RGB LED. 
  
  Notes:
    - This is not a low-power sketch 
    - A Bean with a low battery might show a faint blue and green LED color
  
  This example code is in the public domain.
*/

void setup() {
  //Shows the application is running shows blue light
  Bean.setLed(0, 0, 255);
}

void loop() {
  int temperature = Bean.getTemperature();
  
  Serial.print("Temperature: ");
  Serial.print(temperature);
  Serial.println(" C");
  Bean.sleep(3000);
}
