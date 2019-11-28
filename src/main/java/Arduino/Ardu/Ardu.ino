#define LED_PIN 2

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(LED_PIN, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:

  if (Serial.available()) {
    byte read = Serial.read();
    Serial.print(read);

    switch (read) {
      case 2:
        Serial.print("ACCENDO");
        digitalWrite(LED_PIN, HIGH);
        Serial.write("OK");    //confermo
        break;
      case 3:
        Serial.print("SPENGO");
        digitalWrite(LED_PIN, LOW);
        Serial.write("OK");    //confermo
        break;
      default:
        Serial.write("Comando non conosciuto");
    }
  }
  delay(10);
}
