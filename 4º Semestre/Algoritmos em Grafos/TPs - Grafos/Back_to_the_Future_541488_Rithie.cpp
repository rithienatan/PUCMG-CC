/**
 * @author  Rithie Natan Carvalhaes Prado
 * Matrícula: 541488
 * Data de Entrega: 27/10/2019
 * Exercício: Back to the Future
 */

//--------------------------------------------------------------------------
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <math.h>
//--------------------------------------------------------------------------
using namespace std;

int grafo[100][100];

/**
 * @param quantCidade recebe a quantidade de cidades
 */
void completaGrafo(int quantCidade)
{
  //Completa a matriz inicial do grafo
  for(int i = 0; i < quantCidade; i++)
  {
    for(int j = 0; j < quantCidade; j++)
    {
      grafo[i][j] = 0;
    }//end for
  }//end for
}//end completaGrafo()

/**
 * @param rotaInicio, rotaFim, passagem, quantVoos Marca cada rota com
 * com o preço de cada passagem para cada rotas
 */
void marcaRotas(int rotaInicio, int rotaFim, int passagem, int quantVoos)
{
  for(int i = 0; i < quantVoos; i++)
  {
    std::cin >> rotaInicio;
    std::cin >> rotaFim;
    std::cin >> passagem;
    grafo[rotaInicio-1][rotaFim-1] = passagem;
    grafo[rotaFim-1][rotaInicio-1] = passagem;
  }//end for
}//end marcaRotas

/**
 * Calcula o preço da melhor rota possivel dentro das possibilidades
 * @param quantAmigos, quantAcentos, quantCidade
 * @return Retorna o melhor preço encontrado
 */
int melhorRotaPossivel(int quantAmigos, int quantAcentos, int quantCidade)
{
  int valorTotal = 0;

  if(quantAmigos > quantAcentos)
  {
    int aux = quantAmigos;

    while(aux > quantAcentos)
    {
      //verifica o menor caminho
      if(grafo[0][quantCidade-1] > 0)
      {
        valorTotal = valorTotal + (grafo[0][quantCidade-1] * quantAcentos);

        //marca a rota como usada
        grafo[0][quantCidade-1] = 0;
        grafo[quantCidade-1][0] = 0;

        aux = aux - quantAcentos;

        //caso aux fique menor que a quantidade de acentos
        if(aux <= quantAcentos)
        {
          int atual = 0;
          int prox = 100000;
          int posI;
          for(int i = 1; i < quantCidade-1; i++)
          {
            for(int j = 0; j < quantCidade; j++)
            {
              if(grafo[i][j] > 0)
              {
                atual = atual + (grafo[i][j]*aux);
              }//end if
            }//end for

            if(atual < prox)
            {
              prox = atual;
              atual = 0;
              posI = i;
            }//end if
          }//end for

          valorTotal = valorTotal + prox;

          //atualiza a matriz grafo
          for(int j = 0; j < quantCidade; j++)
          {
            grafo[posI][j] = 0;
            grafo[j][posI] = 0;
          }//end for
        }//end if
      }
      else
      {
        //começa apartir das proximas opções de rotas
        int atual = 0;
        int prox = 100000;
        int posI;
        for(int i = 1; i < quantCidade-1; i++)
        {
          for(int j = 0; j < quantCidade; j++)
          {
            if(grafo[i][j] > 0)
            {
              atual = atual + (grafo[i][j]*quantAcentos);
            }//end if
          }//end for

          if(atual < prox)
          {
            prox = atual;
            atual = 0;
            posI = i;
          }//end if
        }//end for

        valorTotal = valorTotal + prox;

        //atualiza a matriz grafo
        for(int j = 0; j < quantCidade; j++)
        {
          grafo[posI][j] = 0;
          grafo[j][posI] = 0;
        }//end for

        aux = aux - quantAcentos;

        //caso aux fique menor que a quantidade de acentos
        if(aux <= quantAcentos)
        {
          int atual = 0;
          int prox = 100000;
          int posI;
          for(int i = 1; i < quantCidade-1; i++)
          {
            for(int j = 0; j < quantCidade; j++)
            {
              if(grafo[i][j] > 0)
              {
                atual = atual + (grafo[i][j]*aux);
              }//end if
            }//end for

            if(atual < prox)
            {
              prox = atual;
              atual = 0;
              posI = i;
            }//end if
          }//end for

          valorTotal = valorTotal + prox;

          //atualiza a matriz grafo
          for(int j = 0; j < quantCidade; j++)
          {
            grafo[posI][j] = 0;
            grafo[j][posI] = 0;
          }//end for
        }//end if
      }//end if
    }//end while
  }
  else
  {
    //verifica o menor caminho
    if(grafo[0][quantCidade-1] > 0)
    {
      valorTotal = valorTotal + (grafo[0][quantCidade-1] * quantAmigos);

      //marca a rota como usada
      grafo[0][quantCidade-1] = 0;
      grafo[quantCidade-1][0] = 0;
    }
    else
    {
      //começa apartir das proximas opções de rotas
      int atual = 0;
      int prox = 100000;
      int posI;
      for(int i = 1; i < quantCidade-1; i++)
      {
        for(int j = 0; j < quantCidade; j++)
        {
          if(grafo[i][j] > 0)
          {
            atual = atual + (grafo[i][j]*quantAmigos);
          }//end if
        }//end for

        if(atual < prox)
        {
          prox = atual;
          atual = 0;
          posI = i;
        }//end if
      }//end for

      valorTotal = valorTotal + prox;

      //atualiza a matriz grafo
      for(int j = 0; j < quantCidade; j++)
      {
        grafo[posI][j] = 0;
        grafo[j][posI] = 0;
      }//end for
    }//end if
  }//end if

  return(valorTotal);
}//end melhorRotaPossivel()

/**
 * Metodo que soluciona a questão
 * @param entradas número de casos a serem rodados
 */
void back(int entradas)
{
    //números de cidades pertecentes a rotas de voos
    int quantCidade = 0, quantVoos = 0;
    std::cin >> quantCidade;
    std::cin >> quantVoos;

    //verifica se os valores recebidos estão dentro da exigência do Exercício
    if((quantCidade >= 2 && quantCidade <= 100) &&
       (quantVoos >=1 && quantVoos <= 5000))
    {
      //Completa a matriz inicial do grafo e completa
      completaGrafo(quantCidade);

      //rotas de cidades A a B e seu respectivo preço e marca as rotas
      int cidadeA = 0, cidadeB = 0, passagem = 0;
      marcaRotas(cidadeA, cidadeB, passagem, quantVoos);

      //verificar melhor rota por preço com base na quantidade de
      //amigos e acentos disponiveis
      //obs.: lembrando que queremos ir da cidade 1 até cidade N
      int quantAmigos = 0, quantAcentos = 0;
      std::cin >> quantAmigos;
      std::cin >> quantAcentos;
      int valorTotal = melhorRotaPossivel(quantAmigos, quantAcentos,
                                          quantCidade);
      //resultados
      printf("Instancia %d\n", entradas);
      printf("\n");
      if(valorTotal < quantAmigos || valorTotal > pow(10,15))
      {
        printf("impossivel\n");
      }
      else
      {
        printf("%d\n", valorTotal);
      }//end if
      printf("\n");
      printf("\n");
      printf("\n");
    }
    else
    {
      printf("Quantidade de cidades e voos insuficiente ou excedente!");
    }//end if
}//end back()

/**
 * metodo main
 */
int main()
{
    int entradas = 3;

    for(int i = 0; i < entradas; i++)
    {
        back(i+1);
    }//end for

  return(0);
}//end main
