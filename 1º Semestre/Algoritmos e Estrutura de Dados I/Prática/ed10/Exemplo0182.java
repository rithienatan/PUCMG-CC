/**
 * Estudo Dirigido 10
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 12/04/2016
 
   Exemplo0182
 
 *@version 01
*
*/

/**
 * Exemplo0182
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
} // fim da classe Arranjo

 
// ---------------------------------------------- definicao da classe principal
public class Exemplo0182
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * Testar definições de arranjo usando classe.
 */
   public static void metodo02 ( )
   {
   // 1. definir dados
      Arranjo a1 = null; // nao existe objeto
      Arranjo a2 = new Arranjo ( ); // existe objeto (sem dados, no momento)
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( "Definicoes de arranjo" );
   // 3. testar as definicoes de arranjo
      if ( a1 == null )
      {
         IO.println ( "Arranjo a1 nulo" );
      }
      else
      {
         IO.println ( "Arranjo a1 nao nulo" );
      } // fim se
      if ( a2 == null )
      {
         IO.println ( "Arranjo a2 nulo" );
      }
      else
      {
         IO.println ( "Arranjo a2 nao nulo" );
      } // fim se
      // 3. testar as definicoes de arranjo
      if ( a3 == null )
      {
         IO.println ( "Arranjo a3 nulo" );
      }
      else
      {
         IO.println ( "Arranjo a3 nao nulo com "+a3.length( )+" posicoes." );
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo01( )
   
   
   
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0182 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      metodo02 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0182