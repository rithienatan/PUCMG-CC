/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Função de complexidade:
 * 
 */

/*----- includes -----*/
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <math.h>

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


/**
 * Função que retorna o verdadeiro código do aluno
 * 
 * @param n Quantidade de números primos escritos
 * @param m Número do cartão do aluno
 * @param vetPrimos vetor que tem todos os números primos lidos
 * 
 * @return retorna um número inteiro
 */
int trueCode(int n, int m, int *vetPrimos)
{
    int resp = 0;

    int *a = (int*) malloc(100000 * sizeof(int));
    int *auxVet = (int*) malloc(n * sizeof(int));

    //preenche o vetor com os números iniciais
    for(int i = 0; i < n; i++)
    { a[i] = vetPrimos[i]; }

    int count = n;
    int before = 0;

    int factor;
    if(m % 2 == 0)
    { factor = (m-2)/2; }
    else
    { factor = (m-1)/2; }

    for(int r = 0; r < factor; r++)
    {
        int aux = count;

        for(int i = 0; i < n; i++)
        {
            cout << "i: ";
            cout << i << endl;

            if(i == 0)
            {
                for(int k = before; k < aux; k++)
                { a[count] = vetPrimos[i] * a[k]; count++; }
            }
            else if(i == n-1)
            { a[count] = vetPrimos[i] * a[aux-1]; count++; }
            else
            {
                if(aux == n)
                {

                }
                
                for(int k = before; k < aux; k++)
                { a[count] = vetPrimos[i] * a[count-(aux-1)]; count++; }
            }//end if
        }//end for

        before = aux;
    }//end while

    quicksort(a, 0, count);

    for(int i = 0; i < count; i++)
    { cout << "numero: "; cout << a[i] << endl; }

    resp = a[m-1];

    free(a);
    free(auxVet);

    return(resp);
}//end trueCode()

int main()
{
    int n, m;

    cin >> n;//quantidade de primos
    cin >> m;//número do cartão que representa a posição da sequencia

    while(n > 0 || m > 0)
    {
        int *primosList = (int*) malloc(n * sizeof(int));

        for(int i = 0; i < n; i++)
        { cin >> primosList[i]; }

        cout << trueCode(n, m, primosList) << endl;

        free(primosList);

        cin >> n;
        cin >> m;
    }//end while

    return 0;
}//end main()