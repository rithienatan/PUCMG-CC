/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Função de complexidade:
 * quicksort: n log(n)
 * main: n * (n + quicksort + n) = n²log(n) + 2n²
 * 
 * O(n²log(n))
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
    int quantEntrada;
    int quantidadePessoas = 0;
    int alturas;

    cin >> quantEntrada;

    for(int i = 0; i < quantEntrada; i++)
    {
        //alocar quantidade de elementos no vetor
        cin >> quantidadePessoas;
        int *cidade = (int*) malloc(quantidadePessoas * sizeof(int));

        //inserir elementos
        for(int j = 0; j < quantidadePessoas ; j++)
        {cin >> cidade[j];}

        quicksort(cidade, 0, quantidadePessoas);

        //mostrar elementos
        for(int j = 0; j < quantidadePessoas ; j++)
        {cout << cidade[j]; cout << " ";}

        cout << endl;

        free(cidade);
    }//end for

   return 0;
}//end main()