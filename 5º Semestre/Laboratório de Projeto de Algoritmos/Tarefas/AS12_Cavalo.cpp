/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Função de complexidade:
 * 
 * main: n
 * 
 * O(n)
 */

/*----- includes -----*/
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <math.h>

using namespace std;

/**
 * Aloca na mémoria a matrizs
 * 
 * @param linhas recebe um inteiro que representa a quantidade de linhas
 * @param colunas recebe um inteiro que representa a quantidade de colunas
 * 
 * @return retorna um ponteiro para uma matriz com os espaços alocados
 */
char **AlocarMatriz(int linhas, int colunas)
{
    char **matriz;

    //alocar linhas
    matriz = (char**) malloc (linhas * sizeof(char*));

    //alocar colunas
    for(int i = 0; i < linhas; i++)
    { matriz[i] = (char*) malloc (colunas * sizeof(char)); }

    return(matriz);
}//end AlocarMatriz()

/**
 * Libera a memoria alocada pela matriz
 * 
 * @param linhas recebe um inteiro que representa a quantidade de linhas
 * @param matriz recebe uma matriz
 * 
 * @return retorna null
 */
int **FreeMemoria(int linhas, char **matriz)
{
    //liberar linhas
    for(int i = 0; i < linhas; i++)
    { free(matriz[i]); }

    free(matriz);

    return(NULL);
}//end FreeMemoria()

int main()
{
    int n, m, k;

    cin >> n;
    cin >> m;
    cin >> k;

    while(n != 0 && m != 0 && k != 0)
    {        
        char **tabuleiro = AlocarMatriz(n, m);

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            { cin >> tabuleiro[i][j]; }
        }//end for

        FreeMemoria(n, tabuleiro);

        cin >> n;
        cin >> m;
        cin >> k;
    }//end while

    return 0;
}//end main()