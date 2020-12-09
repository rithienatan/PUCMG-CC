/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Algoritmo de Dijkstra 
 */

/*----- includes -----*/
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <list>
#include <queue>
#define INFINITO 10000000

using namespace std;

/**
 * Aloca na mémoria a matriz
 * 
 * @param ordem recebe um inteiro que representa a ordem da matriz
 * 
 * @return retorna um ponteiro para uma matriz com os espaços alocados
 */
int **AlocarMatriz(int ordem)
{
    int **matriz;

    //alocar linhas
    matriz = (int**) calloc (ordem, sizeof(int*));

    //alocar colunas
    for(int j = 0; j < ordem; j++)
    { matriz[j] = (int*) calloc (ordem, sizeof(int)); }

    return(matriz);
}//end AlocarMatriz()

/**
 * Libera a memoria alocada pela matriz
 * 
 * @param x recebe um inteiro que representa a ordem da matriz
 * 
 * @return retorna null
 */
int **FreeMemoria(int ordem, int **matriz)
{
    //liberar linhas
    for(int i = 0; i < ordem; i++)
    { free(matriz[i]); }

    free(matriz);

    return(NULL);
}//end FreeMemoria()

/**
 * Algoritmop de Dijkstra para achar o menor caminho em um grafo com pesos positivos
 * 
 * @param grafo Recebe um grafo
 * @param tamanho Recebe a quantidade de vertices do grafo
 * @param origem Recebe o vertice de origem
 * @param destino Recebe o vertice de destino
 */
void Dijkstra(int **grafo, int tamanho, int origem, int destino)
{
    int i, vert,k, NovaDist, min;
    int *M, *L, *A, *caminho;
    M = (int *)malloc(tamanho*sizeof(int));
    L = (int *)malloc(tamanho*sizeof(int));
    A = (int *)malloc(tamanho*sizeof(int));
    caminho = (int *)malloc(tamanho*3*sizeof(int));//vetor auxiliar
    
    // incializando vairiaveis
    for (i = 0; i < tamanho; i++)
    {
        M[i] = 0; // false -- determina se um vertice ja foi visitado
        A[i] = -1; // determina o caminho mais curto entre origem e destino
        L[i] = 300000; //infinito determina o comprimento do caminho mais curto
    }//end for

    vert = origem;
    L[vert] = 0;
    while (vert != destino && vert != -1) // não terminou ou caminho inexistente
    {
        for(i = 0; i < tamanho; i++) // percorre vertices adjacentes de vert
        if (grafo[vert][i] != 0 && M[i]==0) // se aresta existe e ela não foi visitada
        {
            NovaDist = L[vert] + grafo[vert][i];
            if (NovaDist < L[i])
            {
                L[i] = NovaDist; // atualiza menor distancia
                A[i] = vert; // atualiza caminho
            }//end if
        }//end if

        M[vert] = 1; // toda a lista de adjacentes de vert já foi analisada
        min = 300000; //infinito
        vert = -1; // valor invalido

        for (i = 0; i < tamanho; i++) // encontra proximo vertice do caminho
        {
            if (M[i]==0 && L[i] < min) //escolhe o vertice cuja aresta possui o menor peso
            {
                min = L[i]; // atualiza min
                vert = i; //atualiza vert
            }//end if
        }//end for
    } //fim while

    // listar o caminho mais curto entre origem e destino
    if (vert == destino) // encontrou um caminho
    {
        printf("caminho mais curto entre %4d e %4d tem comprimento %4d: ",
        origem, destino, L[destino] );
        caminho[0] = destino;
        k = 1;
        while (vert != origem)
        {
            caminho[k]= A[vert];
            vert = A[vert];
            k++;
        }
        for (i = k-1; i >= 0; i--)
        printf("%4d \n", caminho[i]);
    }
    else printf("nao exite caminho entre %4d e %4d.\n", origem, destino);
}//end Dijkstra()

/**
 * Metodo main
 */
int main()
{
    int ordemMatriz;
    int quantConexoes;
    int **grafo;

    cin >> ordemMatriz;
    cin >> quantConexoes;
    grafo = AlocarMatriz(ordemMatriz);

    //inicializar matriz
    for(int i = 0; i < ordemMatriz; i++)
    {
        for(int j = 0; j < ordemMatriz; j++)
        { grafo[i][j] = 0; }
    }//end for

    //inserir valores na matriz
    int linha;
    int coluna;
    int pesos;

    for(int i = 0; i < quantConexoes; i++)
    {
        cin >> linha;
        cin >> coluna;
        cin >> pesos;

        grafo[linha-1][coluna-1] = pesos;
        grafo[coluna-1][linha-1] = pesos;
    }//end for

    Dijkstra(grafo, ordemMatriz, 0, 6);

    grafo = FreeMemoria(ordemMatriz, grafo);

   return 0;
}//end main()