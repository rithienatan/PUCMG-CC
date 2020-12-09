/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Operações relevante:
 * while e if
 * 
 * Função de complexidade:
 *      Pior caso: T = n * 6 = 6n
 *      Melhor caso: T = n * 6 = 6n
 *      
 * No caso da função de complexidade aqui, estamos olhando para 'n',
 * no qual representa a quantidade de vezes que o while irá executar.
 * E no caso do '6', representa as operações relevantes dentro dos ifs, em que
 * seja no pior caso ou no melhor caso, sempre iremos executar 4 vezes a cada execução do while.
 */

/*----- includes -----*/
#include <stdio.h>
#include <iostream>
#include <stdlib.h>

using namespace std;

/**
 * Função que verifica se um ano é bissexto
 * 
 * @param ano Número inteiro
 * 
 * @return retorna um valor booleano
 */
bool isBissexto(int ano)
{
    bool resp = false;

    if(((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0))
    { resp = true; }

    return(resp);
}//end isBissexto()

/**
 * Função que verifica se é um ano de festival Huluculu
 * 
 * @param ano Número inteiro
 * 
 * @return retorna um valor booleano
 */
bool isHuluculu(int ano)
{
    bool resp = false;

    if(ano % 15 == 0)
    { resp = true; }

    return(resp);
}//end isHulukulu()

/**
 * Função que verifica se é um ano de festival Bulukulu
 * 
 * @param ano Número inteiro
 * 
 * @return retorna um valor booleano
 */
bool isBulukulu(int ano)
{
    bool resp = false;

    if(ano % 55 == 0)
    { resp = true; }

    return(resp);
}//end isBulukulu()

/**
 * Metodo main
 */
int main()
{
    int ano;

    /**
     * Obs.: Após o teste do ano, verificamos se estamos no final do arquivo para
     * manipular os espaços entre as respostas.
     */
    while(cin.eof() == 0)
    {
        std::cin >> ano;

        if(isBissexto(ano) == true)
        {
            printf("This is leap year.\n");

            if(isHuluculu(ano) == true)
            { printf("This is huluculu festival year.\n"); }

            if(isBulukulu(ano) == true)
            { printf("This is bulukulu festival year.\n"); }

            if(cin.eof() == 0)
            { printf("\n"); }
        }
        else if(isHuluculu(ano) == true)
        {
            printf("This is huluculu festival year.\n");

            if(isBulukulu(ano) == true)
            { printf("This is bulukulu festival year.\n"); }

            if(cin.eof() == 0)
            { printf("\n"); }
        }
        else if(isBulukulu(ano) == true)
        {
            printf("This is bulukulu festival year.\n");

            if(cin.eof() == 0)
            { printf("\n"); }
        }
        else
        {
            printf("This is an ordinary year.\n");

            if(cin.eof() == 0)
            { printf("\n"); }
        }//end else

        fflush(stdin);
    }//end while
    return(0);
}//end main