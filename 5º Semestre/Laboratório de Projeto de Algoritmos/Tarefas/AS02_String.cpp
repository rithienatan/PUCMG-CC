/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @version 0.1.0
 *
 */

/*----- includes -----*/
#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <string>

using namespace std;

//hash nas quais representam as letras e a possibilidade de tê-las.
bool hashAlfaContem[26];

/**
 * Método de inicialização das tabelas hash
 */
void initHash()
{
    for(int i = 0; i < 26; i++)
    { hashAlfaContem[i] = false; }
}//end initHash()

/**
 * Metodo main
 */
int main()
{
    initHash();//O(n)

    //recebe as entradas
    string quantEntradas;
    getline(cin, quantEntradas);

    string alimentosDieta;
    string cafeDaManha;
    string almoco;

    string resposta = "";

    for(int i = 0; i < stoi(quantEntradas); i++)//O(n²)
    {
        getline(cin, alimentosDieta);
        getline(cin, cafeDaManha);
        getline(cin, almoco);

        if(alimentosDieta.length() > 0)
        {
            //marcar as letras na hash boolean que devem ser consumidas
            for(int i = 0; i < alimentosDieta.length(); i++)
            { hashAlfaContem[(int)alimentosDieta.at(i) - 65] = true; }//end for

            //marcar as letras na hash que já foram utilizadas no cafe da manha
            if(cafeDaManha.length() > 0)
            {
                for(int i = 0; i < cafeDaManha.length(); i++)
                {
                    if(hashAlfaContem[(int)cafeDaManha.at(i) - 65] == true)
                    { hashAlfaContem[(int)cafeDaManha.at(i) - 65] = false; }
                    else
                    { resposta = "CHEATER"; i = cafeDaManha.length(); }
                }//end for
            }//end if

            //marcar as letras na hash que já foram utilizadas no almoco
            if(almoco.length() > 0 && resposta == "")
            {
                for(int i = 0; i < almoco.length(); i++)
                { 
                    if(hashAlfaContem[(int)almoco.at(i) - 65] == true)
                    { hashAlfaContem[(int)almoco.at(i) - 65] = false; }
                    else
                    { resposta = "CHEATER"; i = almoco.length(); }
                }//end for
            }//end if

            if(resposta == "")
            {
                for(int i = 0; i < 26; i++)
                {
                    if(hashAlfaContem[i] == true)
                    { resposta = resposta + (char)(i + 65); }
                }//end for
            }//end if
            
            cout << resposta << endl;
        }
        else
        {
            if(cafeDaManha.length() > 0 || almoco.length() > 0)
            { cout << "CHEATER" << endl; }
            else
            { cout << "" << endl; }
        }//end if

        initHash();
    }//end for

    return(0);
}//end main