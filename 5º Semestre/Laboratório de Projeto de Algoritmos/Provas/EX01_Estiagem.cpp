/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Função de complexidade:
 * AlocarMatriz: n
 * FreeMemoria: n
 * Prim: n²
 * main: n + n² + n² + n + n = 2n² + 3n
 * 
 * O(n²)
 */

/*----- includes -----*/
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <iomanip>
#include <cmath>
#include <iostream>

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
    int quantImoveis;
    int quantMoradores;
    int quantConsumo;
    int cidade = 0;

    double totalPessoas = 0;
    double totalConsumo = 0;
    double consumoMedio = 0;

    cin >> quantImoveis;

    while(quantImoveis > 0)
    {
        cidade = cidade + 1;

        cout << "Cidade# ";
        cout << cidade;
        cout << ": " << endl;

        int *cidade = (int*) malloc(quantImoveis * sizeof(int));

        int *infoCidade = (int*) malloc(quantImoveis * 2 * sizeof(int));

        int j = 0;

        for(int i = 0; i < quantImoveis; i++)
        {
            cin >> quantMoradores;
            infoCidade[j] = quantMoradores;
            totalPessoas = totalPessoas + quantMoradores;

            cin >> quantConsumo;
            totalConsumo = totalConsumo + quantConsumo;

            cidade[i] = (int)floor(quantConsumo/quantMoradores); 
            infoCidade[j+1] = (int)floor(quantConsumo/quantMoradores);

            j = j + 2;       
        }//end for

        quicksort(cidade, 0, quantImoveis);
        for(int i = 0; i < quantImoveis; i++)
        {
            for(int k = 0; k < quantImoveis*2; k = k + 2)
            {
                if(cidade[i] == infoCidade[k+1])
                {
                    cout << infoCidade[k];
                    cout << "-";
                    cout << cidade[i];
                    cout << " ";

                    k = quantImoveis*2;
                }//end if
            }//end for
        }//end for

        cout << endl;

        free(cidade);

        consumoMedio = totalConsumo/totalPessoas;

        cout << "Consumo medio: ";
        printf("%0.2lf", consumoMedio);
        cout << " m3." << endl;

        totalPessoas = 0;
        totalConsumo = 0;
        consumoMedio = 0;

        cin >> quantImoveis;

        if(quantImoveis > 0)
        { cout << endl; }
    }//end while

   return 0;
}//end main()