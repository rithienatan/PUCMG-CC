/**
 * Guia0024
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 *
 *@version 0024
*/

/**
 * Exemplo0024
 *
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0024
{
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // definir dados
      int x;
      int y;
   // identificar
      IO.println ( "EXEMPLO0024 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // ler valor inteiro do teclado
      x = IO.readint ( "Entrar com um valor inteiro: " );
      for ( y = 1; y <= x; y = y + 1 )
      {
         IO.println ( "" + y );
      } // fim repetir
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0024
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
// Versao Teste
// 0.1 01. ( OK ) identificacao de programa e leitura
// Valores previstos: 5, 0, -5
//
// 0.2 01. ( ___ ) identificacao de programa
// Valores previstos: 5, 0, -5
//
// 0.3 01. ( ___ ) identificacao de programa
// Valores previstos: 5, 0, -5
//