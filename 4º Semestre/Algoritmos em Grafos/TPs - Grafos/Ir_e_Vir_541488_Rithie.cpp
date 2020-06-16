/**
 * @author  Rithie Natan Carvalhaes Prado
 * Matrícula: 541488
 * Data de Entrega: 17/05/2020
 * Exercício: Ir e Vir
 */

//--------------------------------------------------------------------------
#include <iostream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
//--------------------------------------------------------------------------
using namespace std;

int grafo[2000][2000];
int visitados[2000];
int pilha[2000];

/**
 * Metodo que liga dois vertices
 * @param v1
 * @param v2
 */
void liga(int v1, int v2)
{ grafo[v1 - 1][v2 - 1] = 1; }

/**
 * Preenche todos os vértices visitáveis
 * @param v
 * @param e
 */
void dfs (int v, int e)
{
	int i;
	visitados[v] = 1;

	for (i = 0; i < e; i++)
	{
		if (grafo[v][i] == 1 && visitados[i] == -1)
    { dfs(i, e); }
	}//end for
}//end dfs()

/**
 * metodo main
 */
int main()
{
  string entrada;
	int isConexo;

  int n_interseccoes, m_ruas;
  int e, l;

  int id_v, id_w, unicaOUdupla_p;
  int x, y, p; 

	while(1)
	{
		//setar o grafo previamente
		memset(grafo, -1, sizeof(grafo));

    //entrada de dados
    getline(cin, entrada);
    n_interseccoes = entrada.at(0) - '0';
    m_ruas = entrada.at(2) - '0';

		if(n_interseccoes == 0 && m_ruas == 0) 
    { break; }
		else
		{
			for (int i = 0; i < m_ruas; i++)
			{
        //entrada de dados
        getline(cin, entrada);
        id_v = entrada.at(0) - '0';
        id_w = entrada.at(2) - '0';
        unicaOUdupla_p = entrada.at(4) - '0';

				if (unicaOUdupla_p == 1) 
        { liga(id_v, id_w); }
				else
				{
          liga(id_v, id_w);
          liga(id_w, id_v);
				}//end if
			}//end for

			isConexo = 1;

			for(int i = 0; i < n_interseccoes; i++)
			{
        //setar o array de visitados
				memset(visitados, -1, sizeof(visitados));

        //setar o array de pilha
				memset(pilha, -1, sizeof(pilha));

				dfs(i, n_interseccoes);

				for (int v = 0; v < n_interseccoes; v++)
				{
					if (visitados[v] == -1)
					{
						isConexo = 0;
						break;
					}//end if
				}//end for

				if(isConexo == 0)
        { break; }
			}//end for

		}//end if
		cout << isConexo << endl;
	}//end while

	return 0;
}//end main