/**
 * Estudo Dirigido 12
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 08/05/2016
 
   Exemplo0223
 
 *@version 01
*
*/
/**
 * Exemplo0223
 *
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao de classe auxiliar
/**
 * Classe para tratar contatos.
 */
class Contato
{
  /**
 * tratamento de erro.
 Codigos de erro:
 1. Nome invalido.
 2. Fone invalido.
 */
   private int erro;
   
  /**
 * obter o codigo de erro.
 */
   public int getErro ( )
   {
      return ( erro );
   } // end getErro ( )
 /**
 * estabelecer novo codigo de erro.
 */
   private void setErro ( int codigo )
   {
      erro = codigo;
      
      switch( erro )
      {
         case 1:
            IO.println( "1. ERROR: Nome Inválido!" );
            break;
         case 2:
            IO.println( "2. ERROR: Fone Inválido!" );
            break;
      } 
   } // end setErro ( )

 /**
 * atributos.
 */
   public String nome;
   public String fone;
 /**
 * construtor padrao.
 */
   public Contato ( )
   {
   // atribuir valores iniciais nulos
      nome = null;
      fone = null;
   } // fim construtor padrao
   
    /**
 * construtor alternativo.
 */
   public Contato (String nomeInicial, String foneInicial )
   {
      setErro ( 0 ); // ainda não há erro
      if( nomeInicial == null || nomeInicial == "" )
      {
         setErro ( 1 );
      }
      else if ( foneInicial == null || foneInicial == "" )
      {
         setErro ( 2 );
      }
      else if( nomeInicial != null && foneInicial != null )
      {
         nome = nomeInicial;
         fone = foneInicial;
      }
      
   } // fim construtor alternativo
 
   
} // fim da classe Contato
// ---------------------------------------------- definicao da classe principal
public class Exemplo0223
{
// ---------------------------------------------- definicao de metodo auxiliar
  /**
 * Testar definições da classe Contato.
 */
    /**
 * Testar definições da classe Contato.
 */
   public void metodo03 ( )
   {
   // 1. definir dados
      Contato a1 = new Contato ( "", "1111-1111" );
      Contato a2 = new Contato ( "nome1", null );
      Contato a3 = new Contato ( "nome1", "1111-1111" );
   // 2. identificar
      IO.println ( "Definicoes da Contato" );
   // 3. testar as definicoes de arranjo
      if ( a1 == null )
      {
         IO.println ( "Contato a1 nulo" );
      }
      else
      {
         IO.println ( "Contato a1 nao nulo com "+a1.nome+" e " + a1.fone );
      } // fim se
      if ( a2 == null )
      {
         IO.println ( "Contato a2 nulo" );
      }
      else
      {
         IO.println ( "Contato a2 nao nulo com "+a2.nome+" e " + a2.fone );
      } // fim se
      if ( a3 == null )
      {
         IO.println ( "Contato a3 nulo" );
      }
      else
      {
         IO.println ( "Contato a3 nao nulo com "+a3.nome+" e " + a3.fone );
      } // fim se
   // encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo02 ( )

// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0201 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // criar e executar o metodo auxiliar
      Exemplo0223 m1 = new Exemplo0223 ( );
      m1.metodo03 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0223