/**
 * Estudo Dirigido 11
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 30/04/2016
 
   Exemplo0191
 
 *@version 01
*
*/

/**
 * Exemplo0203
 *
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao de classe auxiliar
/**
 * Classe para tratar matriz de objetos.
 */
class Matriz
{
 /**
 * armazenador generico dos dados
 */
   public Object [ ][ ] tabela;
 /**
 * construtor padrao
 */
   public Matriz ( )
   {
      tabela = null;
   } // fim construtor padrao
   
   /**
 * construtor alternativo.
 */
   public Matriz ( int linhas, int colunas )
   {
      if ( linhas <= 0 || colunas <= 0 )
      {
         IO.println ( "ERRO: quantidade invalida." );
      }
      else
      {
         tabela = new Object [ linhas ][ colunas ];
      } // fim se
   } // fim construtor alternativo
 /**
 * informar a quantidade de posicoes reservadas (linhas).
 */
   public int lines ( )
   {
      int linhas = 0;
   
      if ( tabela != null )
      {
         linhas = tabela.length;
      }
      return ( linhas );
   } // fim lines ( )
 /**
 * informar a quantidade de posicoes reservadas (colunas).
 */
   public int columns ( )
   {
      int colunas = 0;
   
      if ( tabela != null )
      {
         colunas = tabela[0].length;
      }
      return ( colunas );
   } // fim columns ( )
   
/**
 * exibir dados em matriz.
 */
   public void printMatrix ( )
   {
   // definir dados
      int x, y,
         linhas, colunas;
   // identificar
      IO.println ( );
   // testar se a matriz foi montada
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // obter dimensoes da matriz
         linhas = lines( );
         colunas = columns( );
      // mostrar matriz
         IO.println ( "Matriz com "+linhas+"x"+colunas+" posicoes:" );
      // repetir para cada posicao na matriz
         for ( x = 0; x < linhas; x = x + 1 )
         {
            for ( y = 0; y < colunas; y = y + 1 )
            {
            // mostrar o valor armazenado
               IO.print ( "\t"+tabela [ x ][ y ] );
            } // fim repetir
            IO.println ( );
         } // fim repetir
      } // fim se
   } // fim printMatrix ( )

} // fim da classe Matriz

// ---------------------------------------------- definicao da classe principal
public class Exemplo0203
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * Testar entrada e saida de dados em matriz usando classe.
 */
   public static void metodo03 ( )
   {
   // 1. definir dados
      Matriz a3 = new Matriz ( 3, 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em matriz" );
      IO.println ( );
   // 3. testar entrada e saida em matriz
      if ( a3 == null )
      {
         IO.println ( "Matriz a3 nula" );
      }
      else
      {
      // mostrar informacoes sobre matriz
         IO.println ( "Matriz a3 nao nula com "+a3.lines( )+"x"+a3.columns( )+" posicoes." );
      // mostrar dados no matriz
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printMatrix ( );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo03( )

// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0203 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      metodo03( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0203