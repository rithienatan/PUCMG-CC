/***********************************************
 *             Compiladores                    *
 * ------------------------------------------- *
 * Professor: Alexei Manso Correa Machado      *
 * ------------------------------------------- *
 * Grupo:                                      *
 * @author Luiz Gustavo Bragança dos Santos    *
 * @author Ricardo Xavier Sena                 *
 * @author Rithie Nathan Carvalhaes Prado      *
 ***********************************************/

//-------------------includes------------------//
#include<cstddef>
#include<iostream>
#include<string>
#include<stdio.h>
#include<stdlib.h>
#include<bitset>
#include<cstddef>
//---------------------------------------------//

using namespace std;

typedef unsigned char toByte; // declaração do tipo byte

/**
 * Classe de objeto token
 */
class Simbolo
{
    private:
        toByte token;
        toByte type;
        toByte classType;
        int address;
        string lexeme;
    
    public:
        const toByte FINAL = 0;
        const toByte VARIAVEL = 1;
        
        // tipos
        const toByte TYPE_INT = 0;
        const toByte TYPE_BYTE = 1;
        const toByte TYPE_STRING = 2;
        const toByte TYPE_BOOLEAN = 3;

        Simbolo()
        {

        }// end contrutor

        Simbolo(toByte token, string lexeme, toByte type) 
        {
            this->token = token;
            this->lexeme = lexeme;
            this->type = type;
            this->classType = -1;
        }// end contrutor

        Simbolo(toByte token, string lexeme)
        {
            this->token = token;
            this->lexeme = lexeme;
            this->classType = -1;
        }// end contrutor

        void setType(toByte type)
        {
            this->type = type;
        }// end setType()

        void setToken(toByte token)
        {
            this->token = token;
        }// end setToken()

        void setAddress(int address) 
        {
            this->address = type;
        }// end setAddress()

        void setLexeme(string lexeme) 
        {
            this->lexeme = lexeme;
        }// end setLexeme()

        toByte getToken()
        {
            return this->token;
        }// end getToken()

        toByte getType()
        {
            return this->type;
        }// end getType()

        int getAddress()
        {
            return this->address;
        }// end getAddress()

        string getLexeme()
        {
            return this->lexeme;
        }// end getLexeme()

        void setClassType(toByte classType) 
        {
            this->classType = classType;
        }// end setClassType()

        toByte getClassType() 
        {
            return this->classType;
        }//end getClassType()
};


/**
 * Classe de inserção de tokens
 */
struct TabelaSimbolos
{
    public: 
        const toByte ID = 0;
        const toByte CONST = 1;
        const toByte FINAL = 2;
        const toByte INT = 3;
        const toByte BYTE = 4;
        const toByte STRING = 5;
        const toByte WHILE = 6;
        const toByte IF = 7;
        const toByte ELSE = 8;
        const toByte AND = 9;
        const toByte OR = 10;
        const toByte NOT = 11;
        const toByte ATRIBUICAO = 12;
        const toByte IGUAL = 13;
        const toByte ABRE_PARENTESE = 14;
        const toByte FECHA_PARENTESE = 15;
        const toByte MENOR = 16;
        const toByte MAIOR = 17;
        const toByte DIFERENTE = 18;
        const toByte MAIOR_IGUAL = 19;
        const toByte MENOR_IGUAL = 20;
        const toByte VIRGULA = 21;
        const toByte MAIS = 22;
        const toByte MENOS = 23;
        const toByte MULTIPLICACAO = 24;
        const toByte DIVISAO = 25;
        const toByte PONTO_VIRGULA = 26;
        const toByte BEGIN = 27;
        const toByte ENDWHILE = 28;
        const toByte ENDIF = 29;
        const toByte ENDELSE = 30;
        const toByte READLN = 31;
        const toByte WRITE = 32;
        const toByte WRITELN = 33;
        const toByte TRUE = 34;
        const toByte FALSE = 35;
        const toByte BOOLEAN = 36;

        string tableArraySimbols[37];
        
        /**
         * Metodo de inserção de lexemas na tabela de simbolos
         */
        void inserirSymbols()
        {
            tableArraySimbols[ID] = "id";
            tableArraySimbols[CONST] = "const";
            tableArraySimbols[FINAL] = "final";
            tableArraySimbols[INT] = "toByte";
            tableArraySimbols[BYTE] = "toByte";
            tableArraySimbols[STRING] = "string";
            tableArraySimbols[WHILE] = "while";
            tableArraySimbols[IF] = "if";
            tableArraySimbols[ELSE] = "else";
            tableArraySimbols[AND] = "&&";
            tableArraySimbols[OR] = "||";
            tableArraySimbols[NOT] = "!";
            tableArraySimbols[ATRIBUICAO] = "<-";
            tableArraySimbols[IGUAL] = "=";
            tableArraySimbols[ABRE_PARENTESE] = "(";
            tableArraySimbols[FECHA_PARENTESE] = ")";
            tableArraySimbols[MENOR] = "<";
            tableArraySimbols[MAIOR] = ">";
            tableArraySimbols[DIFERENTE] = "!=";
            tableArraySimbols[MAIOR_IGUAL] = ">=";
            tableArraySimbols[MENOR_IGUAL] = "<=";
            tableArraySimbols[VIRGULA] = ",";
            tableArraySimbols[MAIS] = "+";
            tableArraySimbols[MENOS] = "-";
            tableArraySimbols[MULTIPLICACAO] = "*";
            tableArraySimbols[DIVISAO] = "/";
            tableArraySimbols[PONTO_VIRGULA] = ";";
            tableArraySimbols[BEGIN] = "begin";
            tableArraySimbols[ENDWHILE] = "endwhile";
            tableArraySimbols[ENDIF] = "endif";
            tableArraySimbols[ENDELSE] = "endelse";
            tableArraySimbols[READLN] = "readln";
            tableArraySimbols[WRITE] = "write";
            tableArraySimbols[WRITELN] = "writeln";
            tableArraySimbols[TRUE] = "TRUE";
            tableArraySimbols[FALSE] = "FALSE";
            tableArraySimbols[BOOLEAN] = "boolean";
        }//end inserirSymbols
} tableSymbols;

/**
 * Metodo main 
 */
int main()
{
    // tableSymbols.inserirSymbols();

    // cout << tableSymbols.tableArraySimbols[tableSymbols.BOOLEAN] << endl;
    
    Simbolo symbol;

    symbol.setLexeme("&&");

    cout << symbol.getLexeme() << endl;
    return 0;
}//end main()