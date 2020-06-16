/**
 * @author  Rithie Natan Carvalhaes Prado
 * Matrícula: 541488
 * Data de Entrega: 27/10/2019
 * Exercício: Cadeia Alimentar
 */

//--------------------------------------------------------------------------
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
//--------------------------------------------------------------------------

/**
 * @param cadAlimentar variavel booleana que identifica a Cadeia Alimentar
 */
void isBolada(bool cadAlimentar)
{
    if(cadAlimentar == true)
    {
        printf("Bolada");
    }
    else
    {
        printf("Nao Bolada");
    }//end if
}//end isBolada

/**
 * @param recebe a quantidade de testes
 */
void alimentar()
{
    //indentificação de quantas especies e relacões entre elas
    int quantEspecies, nRelacoes;
    std::cin >> quantEspecies;
    std::cin >> nRelacoes;

    //reserva espaço para o grafo
    int grafo[quantEspecies][quantEspecies];
    for(int i = 0; i < quantEspecies; i++)
    {
        for(int j = 0; j < quantEspecies; j++)
        {
            grafo[i][j] = 0;
        }//end for
    }//end for

    //preenche o grafo com os vértices e suas ligações
    int vertice1, vertice2;

    for(int i = 0; i < nRelacoes; i++)
    {
        std::cin >> vertice1;
        std::cin >> vertice2;
        grafo[vertice1-1][vertice2-1] = 1;
    }//end for

    //testa condição de arestas entre os véritices
    bool cadAlimentar = false;
    for(int i = 0; i < nRelacoes; i++)
    {
        for(int j = 0; j < nRelacoes; j++)
        {
            if(grafo[i][j] == 1 && grafo[j][i] == 1)
            {
                cadAlimentar = true;
                i = j = nRelacoes;
            }//end if
        }//end for
    }//end for

    isBolada(cadAlimentar);
}//end alimentar()

/**
 * metodo main
 */
int main()
{
    alimentar();

  return(0);
}//end main
