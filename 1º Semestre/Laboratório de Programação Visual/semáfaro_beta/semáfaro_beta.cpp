#include <mbq.h>
#include <PingIRReceiver.h>

void setup()
{
	initBoard();
	//Este é o código do Lab in a box de um Semáfaro inteligente!!
	//Foi colocado uma estrutura de repetição para fazer o semáfaro funcionar continuamente.
	//Legenda: s --&#62; segundos
	while(true)
	{
		DigitalWrite(D13_LED, true);
		DigitalWrite(D6, true);
		DigitalWrite(D5, true);
		//Em um instante de 5s (50s na vida real) fica acesso as luz verde do semáfaro de carro e duas luzes vermelhas de acessas do semafáro do pedestre também.
		delay(5000);
		DigitalWrite(D13_LED, false);
		DigitalWrite(D12, true);
		DigitalWrite(D6, false);
		//Agora acende o semáfaro amarelo por 1s (+ou- 5s na vida real) e desliga uma lede vermelha do semáfaro do pedestre
		delay(1000);
		DigitalWrite(D12, false);
		DigitalWrite(D5, false);
		DigitalWrite(D11, true);
		DigitalWrite(D8, true);
		DigitalWrite(D9, true);
		//Agora fica acesso por 6s (40s na vida real) o vermelho do semáfaro de carro e o verde de pedestre apaga a cada 2s
		delay(2000);
		DigitalWrite(D9, false);
		delay(2000);
		DigitalWrite(D8, false);
		DigitalWrite(D7, true);
		//O semáfaro amarelo de pedestre fica acesso por 2s(+ou- 10s na vida real)
		delay(2000);
		DigitalWrite(D11, false);
		DigitalWrite(D7, false);
		DigitalWrite(D6, true);
		DigitalWrite(D5, true);
		//reinicia o loop novamente
	}
}

void loop()
{
}
