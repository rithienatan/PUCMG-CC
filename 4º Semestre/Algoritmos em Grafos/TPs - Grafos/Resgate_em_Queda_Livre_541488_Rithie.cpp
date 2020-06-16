/**
 * @author  Rithie Natan Carvalhaes Prado
 * Matrícula: 541488
 * Data de Entrega: 17/05/2020
 * Exercício: Resgate em Queda Livre
 */

//--------------------------------------------------------------------------
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <math.h>
//--------------------------------------------------------------------------
using namespace std;

int grafo[(int)pow(10,4)][(int)pow(10,4)];

/**
 * Metodo completa grafo
 */
 void completaGrafo(int pessoas)
 {
   //Completa a matriz inicial do grafo
   for(int i = 0; i < pessoas; i++)
   {
     for(int j = 0; j < pessoas; j++)
     {
       grafo[i][j] = 0;
     }//end for
   }//end for
 }//end completaGrafo()

/**
 * @param recebe a quantidade de testes
 */
void resgate(int teste)
{
  int coordenada[500][2];
  int tamanho = sizeof(grafo)/pow(630,2);
  int quantPessoas, li, co;

  for(int n = 0; n < teste; n++)
  {
    std::cin >> quantPessoas;

    completaGrafo(quantPessoas);

    int posicao[quantPessoas][2];

    for(int i = 0; i < quantPessoas; i++)
    {
      std::cin >> li;
      std::cin >> co;
      grafo[li][co] = 1;
      posicao[i][0] = li;
      posicao[i][1] = co;
    }//end for

    //peso dos vertices
    float dist = 0.0;
    for(int i = 0; i < quantPessoas - 1; i++)
    {
      float lin = pow((posicao[i][1] - posicao[i+1][1]),2);
      float col = pow((posicao[i][0] - posicao[i+1][0]),2);
      dist = dist + (sqrt(col + lin)/100);
    }//end for

    //construindo o caminho
    int tmp = 0;
    for(int i = 0; tmp < quantPessoas && i < tamanho; i++)
    {
      for(int j = 0; tmp < quantPessoas && j < tamanho; j++)
      {
        if(grafo[i][j] == 1)
        {
          coordenada[tmp][0] = i;
          coordenada[tmp][1] = j;
          tmp++;
        }//end if
      }//end for
    }//end for

    //Caminho mais curto
    int min = tamanho;
    int curto = 0;
    for(int i = 0; i < quantPessoas; i++)
    {
      float aux1 = pow((coordenada[i][1] - coordenada[i+1][1]),2);
      float aux2 = pow((coordenada[i][0] - coordenada[i+1][0]),2);
      float peso = peso + (sqrt(aux2 + aux1)/100);

      if(peso < min)
      {
        min = peso;
      }//end if

      curto = curto + min;
    }//end for

    std::cout.precision(2);
    std::cout << std::fixed << dist;
    printf("\n \n");
  }//end for
}//end resgate()

/**
 * metodo main
 */
int main()
{
  int teste;
  std::cin >> teste;
  resgate(teste);

  return(0);
}//end main
