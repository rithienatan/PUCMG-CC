/*
  Programa 01
  Liga todos os Leds
 */

// Definiçao de valores para variáveis  
int led2 = 2;
int led3 = 3;
int led4 = 4;
int led5 = 5;
int led6 = 6;
int led7 = 7;
int led8 = 8;
int led9 = 9;
int led10 = 10;
int led11 = 11;
int led12 = 12;
int led13 = 13;


// Rotina executada 1 vez e que em geral configura entradas e saídas 
void setup() {                
  // configura os pinos como saídas DIGITAIS.
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
  pinMode(led5, OUTPUT);
  pinMode(led6, OUTPUT);
  pinMode(led7, OUTPUT);
  pinMode(led8, OUTPUT);
  pinMode(led9, OUTPUT);
  pinMode(led10, OUTPUT);
  pinMode(led11, OUTPUT);
  pinMode(led12, OUTPUT);
  pinMode(led13, OUTPUT);
  
}

// the loop routine runs over and over again forever:
void loop() {
  digitalWrite(led2, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led3, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led4, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led5, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led6, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led7, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led8, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led9, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led10, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led11, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led12, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms
  digitalWrite(led13, HIGH);   // Faz a saída do respectivo Led ser alta ou High)
  delay(100);               // espera por 100 ms

  digitalWrite(led2, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led3, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led4, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led5, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led6, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led7, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led8, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led9, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led10, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led11, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led12, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  digitalWrite(led13, LOW);   // Faz a saída do respectivo Led ser baixa ou Low)
  delay(100);               // espera por 100 ms
  
}
