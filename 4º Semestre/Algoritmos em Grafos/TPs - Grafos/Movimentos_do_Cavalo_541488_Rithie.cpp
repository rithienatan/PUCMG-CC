/**
 * @author  Rithie Natan Carvalhaes Prado
 * Matrícula: 541488
 * Data de Entrega: 17/05/2020
 * Exercício: Movimentos do Cavalo
 */

//--------------------------------------------------------------------------
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <iostream>
#include <string>
//--------------------------------------------------------------------------
using namespace std;

const int jumpHouse = 3;//maximo de movimentos que o cavalo pode fazer

/**
 * Struct que representa as informações de cada quadrado individualmente
 */
typedef struct Posicao
{
  int linha, coluna, movimentos;

  bool operator==(const Posicao p) const{
		return (p.linha == linha && p.coluna == coluna);
	}
} posicao;

posicao list[1000000];

/**
 * Tranforma um caracter em numero
 * @return retorna um número equivalente a letra
 */
int charToNumber(char letra)
{
  int resp;

  if(letra == 'a')
  {
    resp = 0;
  }
  else if(letra == 'b')
  {
    resp = 1;
  }
  else if(letra == 'c')
  {
    resp = 2;
  }
  else if(letra == 'd')
  {
    resp = 3;
  }
  else if(letra == 'e')
  {
    resp = 4;
  }
  else if(letra == 'f')
  {
    resp = 5;
  }
  else if(letra == 'g')
  {
    resp = 6;
  }
  else if(letra == 'h')
  {
    resp = 7;
  }
  else
  {
    cout << "entrada incorreta" << endl;
    exit(0);
  }//end if

  return(resp);
}//end charToNumber()

/**
 * Recebe os valores de entrada e os marca na matriz
 * valores na matriz:
 * 0 - vertice AINDA não percorrido
 * 1 - start
 * 2 - nextPossibleVertices
 * 3 - vértice que dista 1 movimento antes do vértice final
 * 4 - end
 * @param start1
 * @param start2
 * @param end1
 * @param end2
 * @return retorna a quantidade máxima de movimentos possiveis entre um quadrado e outro
 */
int moveHorse(int start1, int start2, int end1, int end2)
{
  int quantMov;

  if(start1 == end1 && start2 == end2)//verifica se a posição inicial é igual a final
  {
    quantMov = 0;
  }
  else
  {
    posicao begin, final, current;

    //setar os valores de vértice do inicio
    begin.linha = start1;
    begin.coluna = start2;
    begin.movimentos = 0;
    list[0] = begin;

    //setar os valores de vértices do fim
    final.linha = end1;
    final.coluna = end2;

    int prox = 0, ult = 0;

    while(1)
    {
      current = list[prox++];

      if(current == final)
      { break; }

      if(current.linha + 2 < 8)
      {
        if(current.coluna + 1 < 8)
        {
          ult++;
          list[ult].linha = current.linha + 2;
          list[ult].coluna = current.coluna + 1;
          list[ult].movimentos = current.movimentos + 1;
        }//end if

        if(current.coluna - 1 >= 0)
        {
          ult++;
          list[ult].linha = current.linha + 2;
          list[ult].coluna = current.coluna - 1;
          list[ult].movimentos = current.movimentos + 1;
        }//end if
      }//end if

      if(current.linha - 2 >= 0)
      {
        if(current.coluna + 1 < 8)
        {
          ult++;
          list[ult].linha = current.linha - 2;
          list[ult].coluna = current.coluna + 1;
          list[ult].movimentos = current.movimentos + 1;
        }//end if

        if(current.coluna - 1 >= 0)
        {
          ult++;
          list[ult].linha = current.linha - 2;
          list[ult].coluna = current.coluna - 1;
          list[ult].movimentos = current.movimentos + 1;
        }//end if
      }//end if

      if(current.coluna + 2 < 8)
      {
        if(current.linha + 1 < 8)
        {
          ult++;
          list[ult].linha = current.linha + 1;
          list[ult].coluna = current.coluna + 2;
          list[ult].movimentos = current.movimentos + 1;
        }//end if

        if(current.linha - 1 >= 0)
        {
          ult++;
          list[ult].linha = current.linha - 1;
          list[ult].coluna = current.coluna + 2;
          list[ult].movimentos = current.movimentos + 1;
        }//end if
      }//end if

      if(current.coluna - 2 < 8)
      {
        if(current.linha + 1 < 8)
        {
          ult++;
          list[ult].linha = current.linha + 1;
          list[ult].coluna = current.coluna - 2;
          list[ult].movimentos = current.movimentos + 1;
        }//end if

        if(current.linha - 1 >= 0)
        {
          ult++;
          list[ult].linha = current.linha - 1;
          list[ult].coluna = current.coluna - 2;
          list[ult].movimentos = current.movimentos + 1;
        }//end if
      }//end if
    }//end while

    quantMov = current.movimentos;
  }//end if
  
  return(quantMov);
}//end moveHorse()

/**
 * metodo main
 */
int main()
{
  string entrada;
  int num1, num2;//entrada para linhas
  string saida = "";

  while(cin.eof() == 0)
  {
    getline(cin, entrada);
    num1 = (int)entrada.at(1) - '0';
    num2 = (int)entrada.at(4) - '0';

    //saida
    cout << "To get from ";
    cout << entrada.at(0);
    cout << num1;
    cout << " to ";
    cout << entrada.at(3);
    cout << num2;
    cout << " takes ";
    cout << moveHorse(charToNumber(entrada.at(0)), num1 - 1, charToNumber(entrada.at(3)), num2 - 1);
    cout << " knight moves." << endl;
  }//end while

  return(0);
}//end main