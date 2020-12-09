/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Algoritmo de Bellman-Ford
 */

/*----- includes -----*/
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <list>
#include <queue>
#define INT_MAX 10000000

using namespace std;

/**
 * Algoritmo de Bellman-Ford para achar a menor distancia em um grafo que contem pesos
 * negativos.
 * 
 * @param grafo Recebe um grafo
 * @param vertice Recebe o número de vertices
 * @param arestas Recebe o número de arestas
 * @param inicio Vértice de inicio
 */
void BellmanFord(int grafo[][3], int vertices, int arestas, int inicio) 
{ 
    //Inicializa a distancia dos vetices
    int dis[vertices]; 
    for (int i = 0; i < vertices; i++)
    { dis[i] = INT_MAX; }
  
    //Inicializa a distancia do vertice inicial
    dis[inicio] = 0; 

    //Relaxa as arestas
    for (int i = 0; i < vertices - 1; i++) { 
  
        for (int j = 0; j < arestas; j++) 
        { 
            if (dis[grafo[j][0]] + grafo[j][2] < dis[grafo[j][1]])
            { dis[grafo[j][1]] = dis[grafo[j][0]] + grafo[j][2]; }
        }//end for
    }//end for

    //verifica se existe um ciclo negativo
    for (int i = 0; i < arestas; i++) 
    { 
        int x = grafo[i][0]; 
        int y = grafo[i][1]; 
        int weight = grafo[i][2]; 
        if (dis[x] != INT_MAX && dis[x] + weight < dis[y]) 
            cout << "O grafo contém um ciclo negativo!" << endl; 
    }//end for
  
    cout << "Distância do vertice de inicial: " << endl; 
    for (int i = 0; i < vertices; i++)
    { cout << i << "\t\t" << dis[i] << endl; }
}//end BellmanFord()

/**
 * Metodo main
 */
int main()
{
    int vertices = 5; //numero de vertices 
    int arestas = 8; //numero de arestas
     
    // representa os valores (x, y, peso), sendo:
    // x e y a conexão entre arestas e
    // peso de entre essas arestas
    int grafo[][3] = { { 0, 1, -1 }, { 0, 2, 4 }, 
                       { 1, 2, 3 }, { 1, 3, 2 },  
                       { 1, 4, 2 }, { 3, 2, 5 },  
                       { 3, 1, 1 }, { 4, 3, -3 } }; 
  
    BellmanFord(grafo, vertices, arestas, 0); 

    //grafo = FreeMemoria(vertices, grafo);

   return 0;
}//end main()