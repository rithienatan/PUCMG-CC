/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Função de complexidade:
 * mergesort = O(n log n)
 * 
 * main = n * (n + n log n) = n² + n² log n = O(n² log n)
 * 
 */

/*----- includes -----*/
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>

using namespace std;

int contador = 0;//conta quantos movimentos serão feitos até o vetor estar ordenado

/**
 * Metodo merge
 * 
 * @param vetor Recebe o vetor criado na main
 * @param ini Recebe o inicio do vetor
 * @param meio Recebe o meio do vetor
 * @param fim Recebe o fim do vetor
 * @param vetAux vetor auxiliar criado quando chamamos o mergesort
 * @param tam Recebe o tamanho do vetor criado na main
 */
void Merge(int vetor[], int ini, int meio, int fim, int vetAux[], int tam) 
{
    int esq = ini;
    int dir = meio;
    for (int i = ini; i < fim; ++i) {
        if ((esq < meio) && ((dir >= fim) || (vetor[esq] < vetor[dir]))) 
		{
            vetAux[i] = vetor[esq];
            ++esq;
        }
        else 
		{
            vetAux[i] = vetor[dir];
            ++dir;
			contador = contador + (tam - esq);
        }//end if
    }

    for (int i = ini; i < fim; ++i) 
	{ vetor[i] = vetAux[i]; }
}//end Merge()

/**
 * Metodo recursivo mergesort
 * 
 * @param vetor Recebe o vetor criado na main
 * @param inicio Recebe o inicio do vetor
 * @param fim Recebe o fim do vetor
 * @param vetAux vetor auxiliar criado quando chamamos o mergesort
 * @param tam Recebe o tamanho do vetor criado na main
 */
void MergeSort(int vetor[], int inicio, int fim, int vetorAux[], int tam) 
{
    if ((fim - inicio) < 2) return;
    
    int meio = ((inicio + fim)/2);
    MergeSort(vetor, inicio, meio, vetorAux, tam);
    MergeSort(vetor, meio, fim, vetorAux, tam);
    Merge(vetor, inicio, meio, fim, vetorAux, tam);
}//end MergeSort()

/**
 * Metodo chamador do mergesort
 * 
 * @param vetor Recebe o vetor criado na main
 * @param tamanho Recebe o tamanho do vetor criado na main
 */
void MergeSort(int vetor[], int tamanho) 
{
    int vetorAux[tamanho];
    MergeSort(vetor, 0, tamanho, vetorAux, tamanho);
}//end MergeSort

int main()
{
    int tamVetor;

    cin >> tamVetor;

    while(tamVetor > 0)
    {
        int *vet = (int*) malloc(tamVetor * sizeof(int));

        /*----- add elementos no vetor -----*/
        for(int i = 0; i < tamVetor; i++)
        { cin >> vet[i]; }//end if

		MergeSort(vet, tamVetor);
		
		if(contador == 0 || contador % 2 == 0)
		{ cout << "Carlos" << endl; }
		else
		{ cout << "Marcelo" << endl; }

		contador = 0;
		
        /*----- liberar vetor -----*/
        free(vet);

        /*----- ler o tamanho do proximo vetor -----*/
        cin >> tamVetor;
    }//end while

    return 0;
}//end main()