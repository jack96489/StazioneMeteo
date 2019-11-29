#define LED_PIN 2
#define POTENZIOMETRO_PIN A0

int potenziometro;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(LED_PIN, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
    int temp = analogRead(POTENZIOMETRO_PIN);
    if(temp!=potenziometro){
      Serial.println("4:"+String(temp));
      potenziometro=temp;
    }


  if (Serial.available()) {
    byte read = Serial.read();
    //Serial.write(read);

    switch (read) {
      case 2:
        Serial.println("ACCENDO");
        digitalWrite(LED_PIN, HIGH);
        Serial.println("OK");    //confermo
        break;
      case 3:
        Serial.println("SPENGO");
        digitalWrite(LED_PIN, LOW);
        Serial.println("OK");    //confermo
        break;
      default:
        Serial.println("Comando non conosciuto");
    }
  }
  delay(100);
}
