/**
 * Estudo Dirigido 09
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 12/04/2016
 
   Exemplo0161
 
 *@version 01
*
*/

/**
 * Exemplo0161
 *
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0161
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * ler valores inteiros de arquivo e guardar em uma matriz.
 * @return tabela com os valores lidos de arquivo
 * @param nome do arquivo com os dados
 */
   public static int [ ][ ] lerDoArquivo ( String nome )
   {
   // definir dados
      FILE arquivo = new FILE ( FILE.INPUT, nome );
      int linhas, colunas;
      int x, y;
      int [ ][ ] tabela = null;
      String linha;
   // identificar
      IO.println ( "Montar matriz com valores lidos de arquivo" );
   // tentar ler uma linha do arquivo
      linha = arquivo.readln ( );
   // testar a disponibilidade de dados
      if ( linha == null )
      {
         IO.println ( "ERRO: Nao ha' dados no arquivo." );
      }
      else
      {
      // tentar obter a quantidade de linhas
         linhas = IO.getint ( linha );
      // tentar obter a quantidade de colunas
         linha = arquivo.readln ( );
         colunas = IO.getint ( linha );
      // testar se quantidade valida
         if ( linhas <= 0 || colunas <= 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
         // reservar espaco para os dados
            tabela = new int [ linhas ] [ colunas ];
         // repetir para cada dado no arquivo
            for ( x = 0; x < linhas; x = x + 1 )
            {
               for ( y = 0; y < colunas; y = y + 1 )
               {
               // ler linha do arquivo
                  linha = arquivo.readln ( );
               // armazenar em um posicao da matriz
               // valor convertido para inteiro
                  tabela [ x ][ y ] = IO.getint ( linha );
               } // fim for
            } // fim for
         } // fim se
      } // fim se
   // fechar arquivo
      arquivo.close ( );
   // retornar matriz montada
      return ( tabela );
   } // fim lerDoArquivo ( )
 /**
 * recuperar dados de arquivo.
 */
   public static void teste01 ( )
   {
   // 1. definir dados
      int [ ] [ ] tabela = null;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar dados de arquivo" );
      IO.println ( );
   // 3. montar dados
      tabela = lerDoArquivo ( "DADOS.TXT" );
   // 4. testar a existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
         if ( tabela.length == 0 )
         {
            IO.println ( "ERRO: Matriz vazia." );
         }
         else
         {
            IO.println ( "Matriz montada com " +
               tabela.length + "x" +
               tabela[ 0 ].length + " dados." );
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste01 ( )
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0161 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      teste01 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0161