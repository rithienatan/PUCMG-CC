/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 20/02/2017
* Exercício: TP02Q06Palindromo em C
*/

//Bibliotecas --------------------------------------------------------

#include<stdio.h>
#include<string.h>
#include<math.h>

//--------------------------------------------------------------------


/**
 * método main
 */
int main(int argc, char*argv[])
{
	FILE *a = fopen("Arqui.txt", "wb+");
	int quant;
	double valores;
	long where = 0;

	scanf("%i", &quant); // quantidade de números a serem lidos

	for(int i = 0; i < quant; i++)
	{
		scanf("%lf", &valores);
		where = ftell(a);
		fwrite(&valores, sizeof(double), 1, a);	
	}//end for

	while(where >= 0)
	{
		fread(&valores, sizeof(double), 1, a);
		printf("%g \n", valores);
		where = where - 8;
		fseek(a, where, SEEK_SET);
	}//end while

	fclose(a);
	return(0);
}//end main()

/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 * @version 0.3 - Upagrade do metodo toCompare - ok!
 */
