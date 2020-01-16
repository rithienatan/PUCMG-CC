int led = 2; //F0
int led2 = 3; //F1
int led3 = 4; //F2
int led4 = 5; //F3
int retorno = 0;
String entrada = "";
char aux = ' '; 
char op = ' ';
int numberheld = 0;
String Bnumber = "";
String Bnumber2 = "";

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
         pinMode(led, OUTPUT);
         pinMode(led2, OUTPUT);
         pinMode(led3, OUTPUT);
         pinMode(led4, OUTPUT);

}// fim setup
int toint(char a){
  if(a == 'A') retorno = 10;
    else if(a == 'B') retorno = 11;
      else if(a == 'C') retorno = 12;
        else if(a == 'D') retorno = 13;
          else if(a == 'E') retorno = 14;
            else if(a == 'F') retorno = 15;
            else retorno = (int)a;
   return retorno;

}// to int

String opNot(String a){
  String answer;
   if(a.charAt(2) == 0)answer += '1';
    if(a.charAt(2) == 1)answer += '0';
     if(a.charAt(3) == 0)answer += '1';
      if(a.charAt(3) == 1)answer += '0';
      if(a.charAt(4) == 0)answer += '1';
       if(a.charAt(4) == 1)answer += '0';
       if(a.charAt(5) == 0)answer += '1';
        if(a.charAt(5) == 1)answer += '0';
        return answer;
}// fim opNot

String opXor(String a, String b){
  String answer;
  if((a.charAt(2) == '0') && (b.charAt(2) == '0')) answer += '0';
  if((a.charAt(2) == '1') && (b.charAt(2) == '1')) answer += '0';
  if((a.charAt(2) == '0') && (b.charAt(2) == '1')) answer += '1';
  if((a.charAt(2) == '1') && (b.charAt(2) == '0')) answer += '1';
  //
  if((a.charAt(3) == '0') && (b.charAt(3) == '0')) answer += '0';
  if((a.charAt(3) == '1') && (b.charAt(3) == '1')) answer += '0';
  if((a.charAt(3) == '0') && (b.charAt(3) == '1')) answer += '1';
  if((a.charAt(3) == '1') && (b.charAt(3) == '0')) answer += '1';
  //
  if((a.charAt(4) == '0') && (b.charAt(4) == '0')) answer += '0';
  if((a.charAt(4) == '1') && (b.charAt(4) == '1')) answer += '0';
  if((a.charAt(4) == '0') && (b.charAt(4) == '1')) answer += '1';
  if((a.charAt(4) == '1') && (b.charAt(4) == '0')) answer += '1';
  //
  if((a.charAt(5) == '0') && (b.charAt(5) == '0')) answer += '0';
  if((a.charAt(5) == '1') && (b.charAt(5) == '1')) answer += '0';
  if((a.charAt(5) == '0') && (b.charAt(5) == '1')) answer += '1';
  if((a.charAt(5) == '1') && (b.charAt(5) == '0')) answer += '1';
  return answer;
}// fim xor

String opAnd(String a, String b){
  String answer;
  if((a.charAt(2) == '0') && (b.charAt(2) == '0')) answer += '0';
  if((a.charAt(2) == '1') && (b.charAt(2) == '1')) answer += '1';
  if((a.charAt(2) == '0') && (b.charAt(2) == '1')) answer += '0';
  if((a.charAt(2) == '1') && (b.charAt(2) == '0')) answer += '0';
  //
  if((a.charAt(3) == '0') && (b.charAt(3) == '0')) answer += '0';
  if((a.charAt(3) == '1') && (b.charAt(3) == '1')) answer += '1';
  if((a.charAt(3) == '0') && (b.charAt(3) == '1')) answer += '0';
  if((a.charAt(3) == '1') && (b.charAt(3) == '0')) answer += '0';
  //
  if((a.charAt(4) == '0') && (b.charAt(4) == '0')) answer += '0';
  if((a.charAt(4) == '1') && (b.charAt(4) == '1')) answer += '1';
  if((a.charAt(4) == '0') && (b.charAt(4) == '1')) answer += '0';
  if((a.charAt(4) == '1') && (b.charAt(4) == '0')) answer += '0';
  //
  if((a.charAt(5) == '0') && (b.charAt(5) == '0')) answer += '0';
  if((a.charAt(5) == '1') && (b.charAt(5) == '1')) answer += '1';
  if((a.charAt(5) == '0') && (b.charAt(5) == '1')) answer += '0';
  if((a.charAt(5) == '1') && (b.charAt(5) == '0')) answer += '0';
  return answer;
}// fim and

String opOr(String a, String b){
  String answer;
  if((a.charAt(2) == '0') && (b.charAt(2) == '0'))answer += '0';
  if((a.charAt(2) == '1') && (b.charAt(2) == '1'))answer += '1';
  if((a.charAt(2) == '0') && (b.charAt(2) == '1'))answer += '1';
  if((a.charAt(2) == '1') && (b.charAt(2) == '0'))answer += '1';
  //
  if((a.charAt(3) == '0') && (b.charAt(3) == '0'))answer += '0';
  if((a.charAt(3) == '1') && (b.charAt(3) == '1'))answer += '1';
  if((a.charAt(3) == '0') && (b.charAt(3) == '1'))answer += '1';
  if((a.charAt(3) == '1') && (b.charAt(3) == '0'))answer += '1';
  //
  if((a.charAt(4) == '0') && (b.charAt(4) == '0'))answer += '0';
  if((a.charAt(4) == '1') && (b.charAt(4) == '1'))answer += '1';
  if((a.charAt(4) == '0') && (b.charAt(4) == '1'))answer += '1';
  if((a.charAt(4) == '1') && (b.charAt(4) == '0'))answer += '1';
  //
  if((a.charAt(5) == '0') && (b.charAt(5) == '0'))answer += '0';
  if((a.charAt(5) == '1') && (b.charAt(5) == '1'))answer += '1';
  if((a.charAt(5) == '0') && (b.charAt(5) == '1'))answer += '1';
  if((a.charAt(5) == '1') && (b.charAt(5) == '0'))answer += '1';
  
  return answer;

}

void ligarLeds(String leds){
  if(leds.charAt(0) == '0')digitalWrite(led, LOW);
   if(leds.charAt(0) == '1')digitalWrite(led, HIGH);
   if(leds.charAt(1) == '0')digitalWrite(led2, LOW);
    if(leds.charAt(1) == '1')digitalWrite(led2, HIGH);
    if(leds.charAt(2) == '0')digitalWrite(led3, LOW);
     if(leds.charAt(2) == '1')digitalWrite(led3, HIGH);
     if(leds.charAt(3) == '0')digitalWrite(led4, LOW);
      if(leds.charAt(3) == '1')digitalWrite(led4, HIGH);
}// fim ligar leds

void logicalZero(){
  ligarLeds("0000");
}// fim logical 0

void logicalUm(){
  ligarLeds("1111");
}// fim logical 1


void loop()
{
  // put your main code here, to run repeatedly:
  if (Serial.available() > 0)
  {
      entrada = Serial.readString();
      aux = entrada.charAt(0);
      numberheld = toint(aux);
      Bnumber = String (numberheld, BIN); // transforma para valor binario de E0
      aux = entrada.charAt(1);
      numberheld = toint(aux);
      Bnumber2 = String (numberheld, BIN); // transforma para valor binario de E1
      op = entrada.charAt(2); // valor da operacao

      if(op == '0')ligarLeds(opNot(Bnumber));//not a
      if(op == '1')ligarLeds(opNot(opOr(Bnumber, Bnumber2))); // not(a+b)
      if(op == '2')ligarLeds(opAnd((opNot(Bnumber)), Bnumber2)); // A negado and B
      if(op == '3')logicalZero();// logical 0
      if(op == '4')ligarLeds(opNot(opAnd(Bnumber, Bnumber2))); // A and B negado
      if(op == '5')ligarLeds(opNot(Bnumber2));//not b
      if(op == '6')ligarLeds(opXor(Bnumber,Bnumber2));// xor
      if(op == '7')ligarLeds(opAnd(Bnumber, opNot(Bnumber2))); // A and (B negado)
      if(op == '8')ligarLeds(opOr((opNot(Bnumber)), Bnumber2)); // (A negado) OR B
      if(op == '9')ligarLeds(opNot(opXor(Bnumber,Bnumber2)));//not xor
      if(op == 'A')ligarLeds(Bnumber2);// B
      if(op == 'B')ligarLeds(opAnd(Bnumber, Bnumber2));
      if(op == 'C')logicalUm();// logical 1
      if(op == 'D')ligarLeds(opOr(Bnumber, opNot(Bnumber2))); // A OR (B negado)
      if(op == 'E') ligarLeds((opOr(Bnumber, Bnumber2))); //(a+b)
      if(op == 'F')ligarLeds(Bnumber); // A
  }
}
