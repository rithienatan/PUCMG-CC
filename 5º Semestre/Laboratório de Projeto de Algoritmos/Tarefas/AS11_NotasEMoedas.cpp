/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 * Função de complexidade:
 * 
 * main: n
 * 
 * O(n)
 */

/*----- includes -----*/
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include <math.h>

using namespace std;

int main()
{
    double dinheiro;
    int parteInteira, notas, moedas;

    while(cin >> dinheiro)
    {
        parteInteira = dinheiro;
        dinheiro = dinheiro * 100;
        moedas = dinheiro;

        cout << "NOTAS:" << endl;

        //quantidade de notas de 100
        cout << parteInteira/100; 
        cout << " nota(s) de R$ 100.00" << endl;

        //quantidade de notas de 50
        notas = parteInteira % 100;
        cout << notas/50; 
        cout << " nota(s) de R$ 50.00" << endl;

        //quantidade de notas de 20
        notas = notas % 50;
        cout << notas/20;
        cout << " nota(s) de R$ 20.00" << endl;

        //quatidade de notas de 10
        notas = notas % 20;
        cout << notas/10;
        cout << " nota(s) de R$ 10.00" << endl;

        //quantidade de notas de 5
        notas = notas % 10;
        cout << notas/5;
        cout << " nota(s) de R$ 5.00" << endl;

        //quantidade de notas de 2
        notas = notas % 5;
        cout << notas/2;
        cout << " nota(s) de R$ 2.00" << endl;

        //quantidade de moedas de 1
        notas = notas % 2;
        cout << "MOEDAS:" << endl;
        cout << notas/1; 
        cout << " moeda(s) de R$ 1.00" << endl;

        //quantidade de moedas de 50
        moedas = moedas % 100;
        cout << moedas/50;
        cout << " moeda(s) de R$ 0.50" << endl;

        //quantidade de moedas de 25
        moedas = moedas % 50;
        cout << moedas/25;
        cout << " moeda(s) de R$ 0.25" << endl;

        //quantidade de moedas de 10
        moedas = moedas % 25;
        cout << moedas/10;
        cout << " moeda(s) de R$ 0.10" << endl;

        //quantidade de moedas de 5
        moedas = moedas % 10;
        cout << moedas/5;
        cout << " moeda(s) de R$ 0.05" << endl;

        //quantidade de moedas de 1
        moedas = moedas % 5;
        cout << moedas/1;
        cout << " moeda(s) de R$ 0.01" << endl;
    }//end while

    return 0;
}//end main()