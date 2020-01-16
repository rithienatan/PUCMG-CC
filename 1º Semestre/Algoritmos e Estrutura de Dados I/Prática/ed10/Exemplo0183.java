/**
 * Estudo Dirigido 10
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 12/04/2016
 
   Exemplo0183
 
 *@version 01
*
*/

/**
 * Exemplo0183
 *
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao de classe auxiliar
/**
 * Classe para tratar arranjo de inteiros.
 */
class Arranjo
{
 /**
 * armazenador generico dos dados
 */
   public Object [ ] tabela;
 /**
 * construtor padrao
 */
   public Arranjo ( )
   {
      tabela = null;
   } // fim construtor padrao
   
   public Arranjo ( int tamanho )
   {
      if ( tamanho <= 0 )
      {
         IO.println ( "ERRO: quantidade invalida." );
      }
      else
      {
         tabela = new Object [ tamanho ];
      } // fim se
   } // fim construtor alternativo
 /**
 * informar a quantidade de posicoes reservadas.
 */
   public int length ( )
   {
      int tamanho = 0;
   
      if ( tabela != null )
      {
         tamanho = tabela.length;
      }
      return ( tamanho );
   } // fim length ( )  

/**
 * exibir dados em tabela.
 */
   public void printArray ( )
   {
   // definir dados
      int tamanho, posicao;
   // identificar
      IO.println ( );
   // testar se a tabela foi montada
      if ( tabela == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
      // obter o tamanho da tabela
         tamanho = length( );
      // mostrar tabela
         IO.println ( "Tabela com "+tamanho+" posicoes:" );
      // repetir para cada posicao na tabela
         for ( posicao = 0;
         posicao < tamanho;
         posicao = posicao + 1 )
         {
         // mostrar o valor armazenado
            IO.println ( "posicao = "+posicao+
               " tem valor = "+tabela [ posicao ] );
         } // fim repetir
      } // fim se
   } // fim printArray ( )
} // fim da classe Arranjo

 
// ---------------------------------------------- definicao da classe principal
public class Exemplo0183
{
// ---------------------------------------------- definicao de metodo auxiliar
  /**
 * Testar entrada e saida de dados em arranjo usando classe.
 */
   public static void metodo03 ( )
   {
   // 1. definir dados
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em arranjo" );
      IO.println ( );
   // 3. testar entrada e saida em arranjo
      if ( a3 == null )
      {
         IO.println ( "Arranjo a3 nulo" );
      }
      else
      {
      // mostrar informacoes sobre arranjo
         IO.println ( "Arranjo a3 nao nulo com "+a3.length( )+" posicoes." );
      // mostrar dados no arranjo
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printArray ( );
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
      IO.println ( "EXEMPLO0183 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      metodo03 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0183