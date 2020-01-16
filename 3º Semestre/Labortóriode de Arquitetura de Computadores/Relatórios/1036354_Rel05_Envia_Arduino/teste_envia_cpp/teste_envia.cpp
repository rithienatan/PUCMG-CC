#include <iostream>
#include <windows.h>
#include <cstdlib>
#include <string.h>


using namespace std;

int main()
{

    string p1, p2, porta, linha;
    char *manda;

//    system ("envia.exe com5 0 1");
//    system("pause");

    cout<<"\n Digite a porta ->";
    cin>>porta;


    for(int i=0;i<10;i++)
    {
        linha = "envia.exe ";
        if(i%2==0) p1="1";
        else p1="0";
        p2="1";
        linha = linha + porta + " " + p1 + " " + p2;
        manda = new char[linha.length()+1];
        memcpy(manda, linha.c_str(), linha.length() + 1);
        cout<<linha;
      //system("pause");
        system(manda);

    }


    linha = "envia.exe ";
    cout<<"\n Digite palavra ->";
    cin>>p1;
    cout<<"\n Digite palavra ->";
    cin>>p2;

    linha = linha + porta + " " + p1+ " "+p2;
    manda = new char[linha.length()+1];
    memcpy(manda, linha.c_str(), linha.length() + 1);
    cout<<linha;
    system(manda);

    return 0;
}
