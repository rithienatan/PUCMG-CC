/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Função de complexidade:
 * AlocarMatriz: n
 * FreeMemoria: n
 * Prim: n²
 * main: n + n² + n² + n + n = 2n² + 3n
 * 
 * O(n²)
 */

/*----- includes -----*/
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>

using namespace std;

#define INF 1000000000

/**
 * Aloca na mémoria a matriz de acordo com a quantidade de rotiadores
 * 
 * @param quantRotiadores recebe um inteiro que representa a quantidade de rotiadores
 * 
 * @return retorna um ponteiro para uma matriz com os espaços alocados
 */
int **AlocarMatriz(int quantRotiadores)
{
    int **matriz;

    //alocar linhas
    matriz = (int**) calloc (quantRotiadores, sizeof(int*));

    //alocar colunas
    for(int j = 0; j < quantRotiadores; j++)
    { matriz[j] = (int*) calloc (quantRotiadores, sizeof(int)); }

    return(matriz);
}//end AlocarMatriz()

/**
 * Libera a memoria alocada pela matriz
 * 
 * @param quantRotiadores recebe um inteiro que representa a quantidade de rotiadores
 * 
 * @return retorna null
 */
int **FreeMemoria(int quantRotiadores, int **matriz)
{
    //liberar linhas
    for(int i = 0; i < quantRotiadores; i++)
    { free(matriz[i]); }

    free(matriz);

    return(NULL);
}//end FreeMemoria()

/**
 * Algoritmo de Prim
 * 
 * @param quantRotiadores recebe um inteiro referente ao rotiadores
 * @param grafo recebe uma matriz que representa um grafo
 * 
 * @return Retorna a soma dos pesos da árvore geradora minima
 */
int Prim(int quantRotiadores, int **grafo) {
    int *dist = (int*) malloc(quantRotiadores * sizeof(int));
    int *marc = (int*) malloc(quantRotiadores * sizeof(int));


    for (int i = 0; i < quantRotiadores; i++) 
    { dist[i] = INF; }

    dist[0] = 0;
   
    int curr = 0;
    int custo = 0;

    while (curr != -1) 
    {
        marc[curr] = 1;
        custo = custo + dist[curr];
       
        for (int i = 0; i < quantRotiadores; i++)
        {
            if (grafo[curr][i])
            {
                if(dist[i] <= grafo[curr][i])
                { dist[i] = dist[i]; }
                else if(grafo[curr][i] < dist[i])
                { dist[i] = grafo[curr][i]; }
            }//end if
        }//end for
       
        curr = -1;
        int min_dist = INF;

        for (int i = 0; i < quantRotiadores; i++)
        {
            if (!marc[i] && dist[i] < min_dist)
            {
                curr = i;
                min_dist = dist[i];
            }//end if
        }//end for        
    }//end while

    return(custo);
}//end Prim()

int main()
{
    int quantRotiadores;
    int quantCabos;
    int **grafo;

    cin >> quantRotiadores;
    cin >> quantCabos;

    grafo = AlocarMatriz(quantRotiadores);

    //inicializar matriz
    for(int i = 0; i < quantRotiadores; i++)
    {
        for(int j = 0; j < quantRotiadores; j++)
        { grafo[i][j] = 0; }
    }//end for

    //inserir valores na matriz
    int linha;
    int coluna;
    int preco;

    for(int i = 0; i < quantCabos; i++)
    {
        cin >> linha;
        cin >> coluna;
        cin >> preco;

        grafo[linha-1][coluna-1] = preco;
        grafo[coluna-1][linha-1] = preco;
    }//end for

    cout << Prim(quantRotiadores, grafo) << endl;

    grafo = FreeMemoria(quantRotiadores, grafo);

   return 0;
}//end main()