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
 * @param quantLugares recebe um inteiro que representa a quantidade de lugares
 * 
 * @return retorna um ponteiro para uma matriz com os espaços alocados
 */
int **AlocarMatriz(int quantLugares)
{
    int **matriz;

    //alocar linhas
    matriz = (int**) calloc (quantLugares, sizeof(int*));

    //alocar colunas
    for(int j = 0; j < quantLugares; j++)
    { matriz[j] = (int*) calloc (quantLugares, sizeof(int)); }

    return(matriz);
}//end AlocarMatriz()

/**
 * Libera a memoria alocada pela matriz
 * 
 * @param quantLugares recebe um inteiro que representa a quantidade de lugares
 * @param matriz Recebe uma matriz preenchida
 * 
 * @return retorna null
 */
int **FreeMemoria(int quantLugares, int **matriz)
{
    //liberar linhas
    for(int i = 0; i < quantLugares; i++)
    { free(matriz[i]); }

    free(matriz);

    return(NULL);
}//end FreeMemoria()

/**
 * Verifica se um grafo é disconexo
 * 
 * @param quantLugares recebe um inteiro que representa a quantidade de lugares
 * @param grafo Recebe um grafo já montado
 * 
 * @return retorna um inteiro: 0 se não é disconexo | maior que 0 se é disconexo
 */
int isDisconected(int quantLugares, int **grafo)
{
    int resp = 0;
    bool haveAresta = false;

    for(int i = 0; i < quantLugares; i++)
    {
        for(int j = 0; j < quantLugares; j++)
        {
            if(grafo[i][j] > 0)
            { haveAresta = true; j = quantLugares; }
        }//end for

        if(haveAresta == false)
        { resp = resp + 1; }

        haveAresta = false;
    }//end for

    return(resp);
}//end isDisconected()

/**
 * Algoritmo de Prim
 * 
 * @param quantLugares recebe um inteiro referente aos lugares
 * @param grafo recebe uma matriz que representa um grafo
 * 
 * @return Retorna a soma dos pesos da árvore geradora minima
 */
int Prim(int quantLugares, int **grafo) 
{
    int *dist = (int*) malloc(quantLugares * sizeof(int));
    int *marc = (int*) malloc(quantLugares * sizeof(int));


    for (int i = 0; i < quantLugares; i++) 
    { dist[i] = INF; }

    dist[0] = 0;
   
    int curr = 0;
    int custo = 0;

    while (curr != -1) 
    {
        marc[curr] = 1;
        custo = custo + dist[curr];
       
        for (int i = 0; i < quantLugares; i++)
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

        for (int i = 0; i < quantLugares; i++)
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
    int instancias;//ler instancias
    cin >> instancias;

    for(int i = 0; i < instancias; i++)
    {
        int quantLugares;
        cin >> quantLugares;

        int quantRotas;
        cin >> quantRotas;

        int quantTeletransporte;
        cin >> quantTeletransporte;

        int **grafo;
        grafo = AlocarMatriz(quantLugares);

        //inicializar matriz
        for(int m = 0; m < quantLugares; m++)
        {
            for(int n = 0; n < quantLugares; n++)
            { grafo[m][n] = 0; }
        }//end for

        //inserir valores na matriz
        int linha;
        int coluna;
        int tempo;

        //inserir as arestas
        for(int y = 0; y < quantRotas; y++)
        {
            cin >> linha;
            cin >> coluna;
            cin >> tempo;

            grafo[linha-1][coluna-1] = tempo;
            grafo[coluna-1][linha-1] = tempo;
        }//end for

        int disconectGrafo = isDisconected(quantLugares, grafo);

        if(disconectGrafo > 0 && quantTeletransporte == 0)
        { cout << -1 << endl; }
        else
        { cout << Prim(quantLugares, grafo) << endl; }//end if

        grafo = FreeMemoria(quantLugares, grafo);
    }//end for

   return 0;
}//end main()