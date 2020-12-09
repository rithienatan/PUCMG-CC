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
#include <string.h>
#include <math.h>
#include <vector>

using namespace std;

bool possibilidade(vector<int> x, int r, int k)
{
    bool resp = false;

    bool grafo[100][100 * (100 - 1) / 2];

    //inicializa o grafo
    for(int i = 0; i < 100; i++)
    {
        for(int j = 0; j < 100 * (100 - 1) / 2; j++)
        { grafo[i][j] = false; }
    }//end for

    grafo[r][k] = true;

    for (int i = r - 1; i >= 0; i--) 
    {
        for (int j = 0; j <= k; j++) 
        {
            grafo[i][j] = grafo[i + 1][j];
            if (j + x[i] <= k)
            { grafo[i][j] |=   grafo[i + 1][j + x[i]]; }
        }//end for
    }//end for

    if(grafo[0][0] == true)
    { resp = true; }

    return(resp);
}//end possibilidade

int main()
{
    int r, k;

    while(cin >> r >> k)
    {
        int a, b;

        vector<int> vertices(r);

        for(int i = 0; i < k; i++)
        {
            cin >> a >> b;
            vertices[a-1] = vertices[a-1] + 1;
            vertices[b-1] = vertices[b-1] + 1;
        }//end for

        if(possibilidade(vertices, r, k) == true)
        { cout << "S" << endl; }
        else
        { cout << "N" << endl; }
    }//end while

    return(0);
}//end main()