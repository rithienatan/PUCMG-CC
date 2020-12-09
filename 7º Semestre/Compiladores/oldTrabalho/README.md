# compiladorLanguageLProject

<div align="center"><b>Trabalho de Compiladores</b></div><br>

@author [Luiz Gustavo](https://github.com/Luizgustavo358), [Ricardo Sena](https://github.com/KakaSena) e [Rithie Natan](https://github.com/rithienatan)

Prof. Alexei Manso Correa Machado

**Objetivo do trabalho:** Desenvolvimento de um compilador completo que
traduza programas escritos na linguagem fonte “L” para um subconjunto do ASSEMBLY
da família 80x86.

---
- [Enunciado do Trabalho](/trabalho)
- [TP](TP%20-%20Compiladores.pdf)
- [Autômato](/imagens/AUTOMATO.png)
- [Testes](/testes)
- [Compilador](/compilador)
---
    
Recursos Utilizados:

    . Language C/C++
    . Github: https://github.com/rithienatan/compiladorLanguageLProject
    . Semantic Versioning(SemVer): https://semver.org/lang/pt-BR/
    . Conceito de conteiner
    
Current @version 0.0.0: Start blank project

----------------------------------------------------------------------------------------------------------------------------------------

<div align="center"><b>Definição da Linguagem-Fonte L</b></div><br>
                                                  
Tratamento para 4 tipos básicos: byte, int, boolean e string.

    . byte: é um escalar que varia de 0 a 255, podendo ser escrito em formato decimal ou hexadecimal.
    . int: é um escalar que varia de –32768 a 32767, ocupando 2 bytes.
    . boolean:  pode ter os valores TRUE e FALSE, ocupando um byte de memória (0h para falso e FFh para verdadeiro). 
    . string: é um arranjo que pode conter até 255 caracteres úteis e quando armazenado em memória, é finalizado pelo caracter ‘$’. Variáveis do tipo string ocupam 256 bytes de memória.
    
    Observação¹: Constantes em formato hexadecimal são da forma 0xDD, onde DD é um número hexadecimal.

Caracteres permitidos para arquivo fonte: letras, dígitos, espaço, sublinhado, ponto, vírgula, ponto-e-vírgula, e_comercial, dois-pontos, parênteses, colchetes, chaves, mais, menos, aspas, apóstrofo, barra, exclamação, interrogação, maior, menor e igual, além da quebra de linha (bytes 0Dh e 0Ah). Qualquer outro caractere é considerado inválido.

    Observação²: Strings são delimitados, no programa-fonte, por aspas e não podem conter quebra de linha ou aspas.
    
    Observação³: Os identificadores de constantes e variáveis são compostos de letras, dígitos e o sublinhado, não podem começar com dígitos e têm no máximo 255 caracteres. Maiúsculas e minúsculas são diferenciadas.
    
As seguintes palavras são reservadas: 
 
    . final  int  byte  string  while  if  else  &&  ||  !  <-  =   (  )   <  >  !=  >=   <=  ,   +  -  *  /   ;  begin  endwhile endif  endelse readln write  writeln TRUE FALSE boolean

Os comandos existentes em “L” permitem atribuição a variáveis através do operador <-, entrada de valores pelo teclado e saída de valores para a tela, estruturas de repetição (enquanto),  estruturas de teste (se - então - senão), expressões aritméticas com inteiros e bytes, expressões lógicas e relacionais, além de atribuição, concatenação e comparação de igualdade entre strings. A ordem de precedência nas expressões é: a) parênteses; b) negação lógica (!); c) multiplicação aritmética (*), lógica (&&) e divisão (/); d) subtração (-), adição aritmética (+), lógica ( || ) e concatenação de strings (+);  e) comparação aritmética (=,!=,<,>,<=,>=) e entre strings (=). 
 
Comentários são delimitados por /* */. A quebra de linha e o espaço podem ser usados livremente como delimitadores de lexemas.

----------------------------------------------------------------------------------------------------------------------------------------

<div align="center">Declarações de Comandos</div><br>
 
    1. Declaração de variáveis: é da forma:  tipo lista-de-ids;  , onde tipo pode ser int, boolean, byte ou string e lista-de-ids é uma série de 1 ou mais identificadores, separados por vírgulas. Variáveis podem ser opcionalmente inicializadas na forma: id <- valor , onde id é um identificador e valor uma constante decimal, precedida ou não de sinal negativo, hexadecimal, lógica ou do tipo string. 
    2. Declaração de constantes: é da forma:  final  id <- valor; , onde id é um identificador e valor uma constante numérica, precedida ou não de sinal negativo, hexadecimal, lógica ou do tipo string. 
    3. Comando de atribuição: é da forma  id <- expressão; 
    4. Comando de repetição: pode assumir duas formas:  
            while (expressão)  comando 
            while (expressão)  begin comandos endwhile  
       onde expressão é do tipo lógico e comandos é uma lista de zero ou mais comandos da linguagem. 
    5. Comando de teste: pode assumir as formas, onde expressão é do tipo lógico:  
            if   (expressão)  comando1 
            if   (expressão)  comando1  else comando2   
       comando1  e/ou comando2  podem ser substituídos por blocos da forma: 
            if   (expressão) begin lista_comandos1 endif else begin lista_comandos2 endelse   
       onde as listas são sequências de comandos. 
    6. Comando nulo: é da forma   ;  . Nada é executado neste comando.  
    7. Comando de leitura: é da forma readln(id); , onde id é um identificador de variável inteira, byte ou string.  
    8. Comandos de escrita: são da forma write(lista_expressões); ou  writeln( lista_expressões);  ,onde lista_expressões é uma lista de uma ou mais expressões numéricas ou do tipo string, separadas por vírgulas. A última forma, quando executada, causa a quebra de linha após a impressão. 

----------------------------------------------------------------------------------------------------------------------------------------

Oldest versions:
