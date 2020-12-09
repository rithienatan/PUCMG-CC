/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Função de complexidade:
 * 
 * main: n³ + n² + n³ + n² = 2n³ + 2n² = O(n³)
 */

/*----- includes -----*/
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <iomanip>
#include <cmath>
#include <iostream>

using namespace std;

/**
 * Aloca na mémoria uma matriz
 * 
 * @param x recebe um inteiro que representa a quantidade de linhas
 * @param y recebe um inteiro que representa a quantidade de colunas
 * 
 * @return retorna um ponteiro para uma matriz com os espaços alocados
 */
int **AlocarMatriz(int x, int y)
{
    int **matriz;

    //alocar linhas
    matriz = (int**) calloc (x, sizeof(int*));

    //alocar colunas
    for(int i = 0; i < x; i++)
    {
        for(int j = 0; j < y; j++)
        { matriz[i] = (int*) calloc (y, sizeof(int)); }
    }//end for

    return(matriz);
}//end AlocarMatriz()

/**
 * Libera a memoria alocada pela matriz
 * 
 * @param X recebe um inteiro que representa a quantidade de linhas
 * @param matriz Recebe uma matriz preenchida
 * 
 * @return retorna null
 */
int **FreeMemoria(int x, int **matriz)
{
    //liberar linhas
    for(int i = 0; i < x; i++)
    { free(matriz[i]); }

    free(matriz);

    return(NULL);
}//end FreeMemoria()

int main()
{
    int casos;
    cin >> casos;

    while(casos > 0)
    {
        int **bidimensional;//matriz bidimensional que contem todos os pontos
        bidimensional = AlocarMatriz(casos, 2);

        for(int i = 0; i < casos; i++)
        {
            cin >> bidimensional[i][0];
            cin >> bidimensional[i][1];
        }//end for

        double distancia = -1;

        for(int i = 0; i+1 < casos; i++)
        {
            for(int a = i+1; a < casos; a++)
            {
                double aux = sqrt(pow((bidimensional[a][0] - bidimensional[i][0]), 2) + pow((bidimensional[a][1] - bidimensional[i][1]), 2));
                if(aux < 10000)
                {
                    if(i == 0 && a == 1)
                    { distancia = aux; }
                    else if(aux < distancia)
                    { distancia = aux; }
                }//end if
            }//end for
        }//end for

        if(distancia == -1)
        { cout << "INFINITY"; }
        else
        { printf("%0.4f", distancia); }

        FreeMemoria(casos, bidimensional);

        cin >> casos;

        if(casos > 0)
        { cout << endl; }
    }//end while

    return(0);
}//end main()