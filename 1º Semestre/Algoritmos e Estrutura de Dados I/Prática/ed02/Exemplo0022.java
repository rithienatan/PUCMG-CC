/**
 * Guia0022
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 *
 *@version 0022
*/

/**
 * Exemplo0021
 *
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0022
{
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // definir dados
      int x;
   // identificar
      IO.println ( "EXEMPLO0022 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // ler valor inteiro do teclado
      x = IO.readint ( "Entrar com um valor inteiro: " );
      while ( x > 0 )
      {
         IO.println ( "Valor lido = " + x );
         x = x - 1;
      } // fim repetir   
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0022
// ---------------------------------------------- documentacao complementar
//
// ---------------------------------------------- historico
//
// Versao Data Modificacao
// 0.1 __ / __ esboco
// 0.2 __ / __ mudança de versão
//
// ---------------------------------------------- testes
//
// ---------------------------------------------- testes
//
// Versao Teste
// 0.1 01. ( OK ) identificacao de programa
// Valores previstos: 5, 0, -5
//
// 0.2 01. ( OK ) identificacao de programa
// Valores previstos:
// com 5:
// com 0:
// com-5:
//
//