/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 20/02/2017
* Exercício: TP02Q06Palindromo em C
*/

//Bibliotecas --------------------------------------------------------

#include<stdio.h>
#include<string.h>
#include<stdbool.h>

//--------------------------------------------------------------------

/**
 * Metodo auxiliar que compara se duas String são iguais
 * @param s,f ambas recebem valores de duas strings
 */
bool toCompare(char s[1000], char f[1000])
{
	bool resp = false;
	int length = strlen(s);//tamanho de s

	for(int i = 0; i < length; i++)
	{
		if(s[i] == f[i])
		{
			resp = true;
		}
		else
		{
			resp = false;
			i = length;
		}//end if
	}//end for

	return(resp); 
}//end toCompare()

/**
 * @param s Recebe uma String qualquer 
 * @return Retorna true se for palindromo ou false caso contrário
 */
bool isPalindromo(char s[1000], int i)
{
	bool resp = false;
	int length = strlen(s);

	if(i ==  length)
	{
		resp = true;
	}
	else if(s[i] == s[length-1-i])
	{
		resp = isPalindromo(s, i+1);
	}
	else
	{
		resp = false;
	}//end if

	return (resp);
}//end isPalindromo()

/**
 * método main
 */
int main(int argc, char*argv[])
{
	char arq[1000], fim[3] = {'F', 'I', 'M'};

	scanf(" %[^\n]s", arq);
	
	while( toCompare(arq, fim) != true )//end while
	{
		if( isPalindromo(arq, 0) == true )
		{
			printf( "SIM\n" );
		}
		else
		{
			printf( "NAO\n" );
		}//end if
		scanf(" %[^\n]s",arq);
	}//end while

	return(0);
}//end main()

/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 * @version 0.3 - Upagrade do metodo toCompare - ok!
 */
