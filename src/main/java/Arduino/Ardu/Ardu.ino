#define LED_PIN 4
#define BUTTON 2
#define POTENZIOMETRO_PIN A0

int potenziometro;
bool ledState;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(LED_PIN, OUTPUT);
  attachInterrupt(digitalPinToInterrupt(BUTTON), premuto, RISING);
}

void loop() {
  // put your main code here, to run repeatedly:
  int temp = analogRead(POTENZIOMETRO_PIN);
  if (temp != potenziometro) {
    Serial.println("4:" + String(temp));
    potenziometro = temp;
  }


  if (Serial.available()) {
    byte read = Serial.read();
    //Serial.write(read);

    switch (read) {
      case 2:
        Serial.println("ACCENDO");
        digitalWrite(LED_PIN, HIGH);
        ledState = true;
        Serial.println("OK");    //confermo
        break;
      case 3:
        Serial.println("SPENGO");
        digitalWrite(LED_PIN, LOW);
        ledState = false;
        Serial.println("OK");    //confermo
        break;
      default:
        Serial.println("Comando non conosciuto");
    }
  }
  delay(100);
}

void premuto() {
  if (ledState) {
    digitalWrite(LED_PIN, LOW);
    Serial.println("2");
  } else {
    digitalWrite(LED_PIN, HIGH);
    Serial.println("3");
  }
  ledState = !ledState;
}
