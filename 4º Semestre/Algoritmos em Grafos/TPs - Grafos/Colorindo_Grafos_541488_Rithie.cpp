/**
 * @author  Rithie Natan Carvalhaes Prado
 * Matrícula: 541488
 * Data de Entrega: 17/05/2020
 * Exercício: Colorindo Grafos
 */

//--------------------------------------------------------------------------
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <math.h>
//--------------------------------------------------------------------------
using namespace std;

int grafo[1000][1000];

/**
 * @param inicializa o grafo
 */
void completaGrafo(int quantVertices)
{
  //Completa a matriz inicial do grafo
  for(int i = 0; i < quantVertices; i++)
  {
    for(int j = 0; j < quantVertices+1; j++)
    {
      grafo[i][j] = 0;
    }//end for
  }//end for
}//end completaGrafo()

/**
 * @param colorindo, quantVertices inclui cores nos vertices
 */
void colorirVertices(int colorindo, int quantVertices)
{
  for(int i = 0; i < quantVertices; i++)
  {
    std::cin >> colorindo;
    grafo[i][quantVertices] = colorindo;
  }//end for
}//end completaGrafo()

/**
 * @param vericeInicio, verticeFim, quantArestas Marca todas as arestas
 */
void includeArestas(int verticeInicio, int verticeFim, int quantArestas)
{
  for(int i = 0; i < quantArestas; i++)
  {
    std::cin >> verticeInicio;
    std::cin >> verticeFim;
    grafo[verticeInicio-1][verticeFim-1] = 1;
    grafo[verticeFim-1][verticeInicio-1] = 1;
  }//end for
}//end marcaRotas

bool verificarInsercao(int quantVertices)
{
  bool result = false;

  for(int i = 0; i < quantVertices; i++)
  {
    for(int j = 0; j < quantVertices; j++)
    {
      if((grafo[i][j] + grafo[j][i] == 0) &&
         (grafo[i][quantVertices] != grafo[j][quantVertices]))
      {
        grafo[i][j] = 0;
        grafo[j][i] = 0;
        result = true;
        i = j = quantVertices;
      }//end if
    }//end for
  }//end for

  return(result);
}//end verificarInsercao

/**
 * Metodo que soluciona a questão
 */
void colorir()
{
    //números de vertices, arestas, inserirArestas, cores
    int vertices = 0, arestas = 0, inserirArestas = 0, cores = 0;
    std::cin >> vertices;
    std::cin >> arestas;
    std::cin >> inserirArestas;
    std::cin >> cores;

    //verifica se os valores recebidos estão dentro da exigência do Exercício
    if((vertices >= 1 && vertices <= pow(10,3)) &&
       (arestas >= 0 && arestas <= pow(10,5)) &&
       (inserirArestas >= 0 && inserirArestas <= pow(10,6)) &&
       (cores >= 1 && cores <= pow(10,3)))
    {
      //Completa a matriz inicial do grafo
      //obs.: vertice+1 é para inserir uma coluna que representa a
      //      cor do verice
      completaGrafo(vertices);

      //colorir os vertices
      int cor = 0;
      colorirVertices(cor, vertices);

      //marca as arestas
      int verticeA = 0, verticeB = 0;
      includeArestas(verticeA, verticeB, arestas);

      //testar a inclusão de novos vertices sem conectar dois vertices de mesma
      //cor
      int possivelInclusao = 0;//verifica a inclusão de nova aresta

      while(possivelInclusao < inserirArestas &&
            verificarInsercao(vertices) == true)
      {
        possivelInclusao = possivelInclusao + 1;
      }//end while

      //verificando a conectividade dos vertices
      bool isConected = true;

      for(int i = 0; i < vertices; i++)
      {
        for(int j = 0; j < vertices; j++)
        {
          if(grafo[i][j] == 1)
          {
            //marca os vertices conectados com 0
            grafo[i][j] = -1;
            grafo[j][i] = -1;
            i = j - 1;
          }//end if
        }//end for
      }//end for

      int quantConectado = 0, total = 0;
      for(int i = 0; i < vertices; i++)
      {
        for(int j = 0; j < vertices; j++)
        {
          total = total + grafo[i][j];
          quantConectado = quantConectado + grafo[i][j];
        }//end for
        if(total > 0 || quantConectado == 0)
        {
          isConected = false;
        }//end if
        quantConectado = 0;
      }//end for

      //resultados
      if(possivelInclusao == inserirArestas && isConected == true)
      {
        printf("Y\n");
      }
      else
      {
        printf("N\n");
      }//end if
      printf("\n");
    }
    else
    {
      printf("Quantidade de vertices, arestas, ");
      printf("quantidade de arestas a serem inseridas e cores ");
      printf("insuficiente ou excedente!");
    }//end if
}//end back()

/**
 * metodo main
 */
int main()
{
    int testes = 0;
    std::cin >> testes;

    if(testes > 0 && testes < 70)
    {
      for(int i = 0; i < testes; i++)
      {
          colorir();
      }//end for
    }
    else
    {
      printf("Número de testes insuficiente ou excedente!");
    }//end if

  return(0);
}//end main
