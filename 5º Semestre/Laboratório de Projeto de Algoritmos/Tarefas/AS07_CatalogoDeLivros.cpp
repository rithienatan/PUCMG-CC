/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Função de complexidade:
 * Livros Portugues = n
 * Livros Matematica = n
 * Livros Fisica = n
 * Livros Quimica = n
 * Livros Biologia = n
 * Soma dos Conjuntos = n^5
 * Quicksort = n log(n)
 * Soma dos maiores = n
 * 
 * main = n^5 + 7n + n log(n)
 * 
 * Ordem de Complexidade: O(n^5)
 * 
 */

/*----- includes -----*/
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>

using namespace std;

void quicksort(int values[], int began, int end)
{
	int i, j, pivo, aux;
	i = began;
	j = end-1;
	pivo = values[(began + end) / 2];
	while(i <= j)
	{
		while(values[i] < pivo && i < end)
		{
			i++;
		}
		while(values[j] > pivo && j > began)
		{
			j--;
		}
		if(i <= j)
		{
			aux = values[i];
			values[i] = values[j];
			values[j] = aux;
			i++;
			j--;
		}
	}
	if(j > began)
		quicksort(values, began, j+1);
	if(i < end)
		quicksort(values, i, end);
}//end quicksort

int main()
{
    /*----- entra com os preços dos livros de português -----*/
    int quantLivrosPortugues;
    cin >> quantLivrosPortugues;

    int *livrosPortuguesPrecos = (int*) malloc(quantLivrosPortugues * sizeof(int));

    for(int i = 0; i < quantLivrosPortugues; i++)
    { cin >> livrosPortuguesPrecos[i]; }

    /*----- entra com os preços dos livros de matemática -----*/
    int quantLivrosMatematica;
    cin >> quantLivrosMatematica;

    int *livrosMatematicaPrecos = (int*) malloc(quantLivrosMatematica * sizeof(int));

    for(int i = 0; i < quantLivrosMatematica; i++)
    { cin >> livrosMatematicaPrecos[i]; }

    /*----- entra com os preços dos livros de física -----*/
    int quantLivrosFisica;
    cin >> quantLivrosFisica;

    int *livrosFisicaPrecos = (int*) malloc(quantLivrosFisica * sizeof(int));

    for(int i = 0; i < quantLivrosFisica; i++)
    { cin >> livrosFisicaPrecos[i]; }

    /*----- entra com os preços dos livros de química -----*/
    int quantLivrosQuimica;
    cin >> quantLivrosQuimica;

    int *livrosQuimicaPrecos = (int*) malloc(quantLivrosQuimica * sizeof(int));

    for(int i = 0; i < quantLivrosQuimica; i++)
    { cin >> livrosQuimicaPrecos[i]; }

    /*----- entra com os preços dos livros de biologia -----*/
    int quantLivrosBiologia;
    cin >> quantLivrosBiologia;

    int *livrosBiologiaPrecos = (int*) malloc(quantLivrosBiologia * sizeof(int));

    for(int i = 0; i < quantLivrosBiologia; i++)
    { cin >> livrosBiologiaPrecos[i]; }

    /*----- quantidade de conjuntos distintos -----*/
    int quantDisjuntos;
    cin >> quantDisjuntos;

    /*----- conjuntos de livros somados -----*/
    int *somaDosConjuntos = (int*) malloc(quantLivrosPortugues * quantLivrosMatematica * quantLivrosFisica * quantLivrosQuimica * quantLivrosBiologia * sizeof(int));
    int posicaoArray = 0;
    int soma = 0;

    for(int p = 0; p < quantLivrosPortugues; p++)
    {
        for(int m = 0; m < quantLivrosMatematica; m++)
        {
            for(int f = 0; f < quantLivrosFisica; f++)
            {
                for(int q = 0; q < quantLivrosQuimica; q++)
                {
                    for(int b = 0; b < quantLivrosBiologia; b++)
                    {
                        soma = livrosPortuguesPrecos[p] + livrosMatematicaPrecos[m] + livrosFisicaPrecos[f] + livrosQuimicaPrecos[q] + livrosBiologiaPrecos[b];
                        somaDosConjuntos[posicaoArray] = soma;
                        posicaoArray = posicaoArray + 1;
                    }//end for
                }//end for
            }//end for
        }//end for
    }//end for

    /*----- ordenar o array que contem os preços -----*/
    quicksort(somaDosConjuntos, 0, posicaoArray);

    /*----- retirar os maiores valores e somar -----*/
    int resultado = 0;
    for(int t = 0; t < quantDisjuntos; t++)
    { resultado = resultado + somaDosConjuntos[posicaoArray - (t+1)]; }

    cout << resultado << endl;

    /*----- libera os vetores -----*/
    free(livrosPortuguesPrecos);
    free(livrosMatematicaPrecos);
    free(livrosFisicaPrecos);
    free(livrosQuimicaPrecos);
    free(livrosMatematicaPrecos);
    free(somaDosConjuntos);

    return 0;
}//end main()