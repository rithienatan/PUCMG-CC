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

/**
 * Função que calcula o máximo de maçãs que podemos colher
 * 
 * @return retorna o número de maçãs que serão possiveis colher
 */
int maxCatch(int x[], int y[], int z[], int startX, int startY, int k, int beginVetor)
{
    int resp = 0;
    int distance = 0;
    int *respArray = (int*) malloc(k * sizeof(int));//vetor de respostas

    int momentoAtual = 0;//momento inicial

    for(int i = beginVetor; i < k; i++)
    {
        if(x[i] == startX)
        {
            distance = y[i] - startY;

            if(distance < 0)
            { distance = -distance; }
        }
        else if(y[i] == startY)
        {
            distance = x[i] - startX;

            if(distance < 0)
            { distance = -distance; }
        }
        else
        { distance = sqrt(pow(startX - x[i], 2) + pow(startY - y[i], 2)); }

        //cout << "distance: ";
        //cout << distance << endl;

        if(distance == 0)
        { resp = resp + 1; momentoAtual = z[i]; }
        else if(distance == 1)
        { resp = resp + 1; startX = x[i]; startY = y[i]; momentoAtual = z[i]; }
        else if(distance <= z[i]-momentoAtual)
        { resp = resp + 1; startX = x[i]; startY = y[i]; momentoAtual = z[i]; }
        else
        {
            //cout << "x: ";
            //cout << x[i] << endl;
            //cout << "y: ";
            //cout << y[i] << endl;

            //cout << "resp: ";
           // cout << resp << endl; 
           // cout << "here" << endl;  
        }
    }//end for

    return(resp);
}//end maxCatch()

int main()
{
    int n, m, k;

    cin >> n;//linhas
    cin >> m;//colunas
    cin >> k;//quantidade de maçãs que cairam

    while(n > 0 || m > 0 || k > 0)
    {
        int *x = (int*) malloc(k * sizeof(int));//vetor com apenas a posição de linha de cada maçã
        int *y = (int*) malloc(k * sizeof(int));//vetor com apenas a posição de coluna de cada maçã
        int *t = (int*) malloc(k * sizeof(int));//vetor com apenas o tempo de cada maçã

        for(int i = 0; i < k; i++)
        { cin >> x[i]; cin >> y[i]; cin >> t[i]; }

        int startX, startY;

        cin >> startX;//linha de inicio
        cin >> startY;//coluna de inicio

        int bestSolution = 0;
        int temp = 0;

        for(int i = 0; i < k; i++)
        {
            temp = maxCatch(x, y, t, startX, startY, k, i);

            if(temp == k-i)
            { bestSolution = k-i; i = k; }
            else
            { bestSolution = temp; }
        }//end for

        cout << bestSolution << endl;

        //----- liberar vetores -----
        free(x); free(y); free(t);

        //----- ler próximos testes -----
        cin >> n;//linhas
        cin >> m;//colunas
        cin >> k;//quantidade de maçãs que cairam
    }//end while

    return 0;
}//end main()