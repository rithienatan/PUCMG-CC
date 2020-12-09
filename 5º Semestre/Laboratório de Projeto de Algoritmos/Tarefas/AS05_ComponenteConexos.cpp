/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 * 
 * Função de complexidade:
 * 
 * pesoVertice: n
 * compConexos: n² + n + n + n² + n³ = n³ + 2n² + 2n
 * main: n*compConexos = n^4 + 2n³ + 2n²
 * 
 * O(n^4)
 */

/*----- includes -----*/
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <string>


using namespace std;

int grafo[26][26];//matriz que representa as conexões entre os vertices
int nTestes = 1, entradas, vertices, arestas;
char vertice1, vertice2;

/**
 * Método que verifica o peso das conexões entre cada vértice
 * @param recebe o um vertice em especifico
 * @return retorna o número de conexões existente nesse vétice
 */
int pesoVertice(int vertice)
{
  int peso = 0;
  for(int i = 0; i < vertice; i++)
  {
    peso = peso + grafo[vertice][i];
  }//end for

  return(peso);
}//end pesoVertice()

void compConexos()
{
  //Completa a matriz inicial do grafo
  for(int i = 0; i < 26; i++)
  {
    for(int j = 0; j < 26; j++)
    {
      grafo[i][j] = 0;
    }//end for
  }//end for

  //entrada de vertices e arestas
  std::cin >> vertices;
  std::cin >> arestas;

  //preenche o vetor de vertices visitados com 0;
  int foiVisitado[vertices];//contabiliza os vertices que já foram visitados
  for(int i = 0; i < vertices; i++)
  {
    foiVisitado[i] = 0;
  }//end for

  //inseri as arestas na matriz grafo
  for(int i = 0; i < arestas; i++)
  {
    std::cin >> vertice1;
    std::cin >> vertice2;
    grafo[vertice1-97][vertice2-97] = 1;
    grafo[vertice2-97][vertice1-97] = 1;
  }//end for

  printf("Case #%d:", nTestes);

  int co = 0, li = 0, fV = 0, aux = 0;

  for(int i = 0; i < vertices; i++)
  {
    if(pesoVertice(i) >= 0)
    {
      printf("\n");
      vertice1 = i + 97;
      std:: cout << vertice1 << ',';
      li++;
      foiVisitado[fV] = vertice1;//incrementa o array para o vertice que foi visitado
      fV++;

      for(co = 0; co < vertices; co++)
      {
        if(grafo[i][co] == 1)
        {
          vertice2 = co + 97;
          std::cout << vertice2 << ',';
          foiVisitado[fV] = vertice2;
          fV++;
          aux++;
        }//end if
      }//end for

      for(size_t i = 0; i < aux + 1; i++)
      {
        for(size_t j = 0; j < aux + 1; j++)
        {
          grafo[foiVisitado[i]-97][foiVisitado[j]-97] = -1;
        }//end for
      }//end for
    }//end if

    for(size_t i = 0; i < aux + 1; i++)
    {
      foiVisitado[i] = 0;
    }//end for

    aux = 0;
    fV = 0;
  }//end for

  printf("\n%d connected components\n", li);
  printf("\n");

  nTestes++;
}//end compConexos()

/**
 * metodo main
 */
int main()
{
  std::cin >> entradas;

  for(int i = nTestes; i <= entradas; i++)
  {
    compConexos();
  }//end for

  return(0);
}//end main
