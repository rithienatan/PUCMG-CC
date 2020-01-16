/**
 * Estudo Dirigido 12
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 08/05/2016
 
   Exemplo0226
 
 *@version 01
*
*/
/**
 * Exemplo0226
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
 * indicar a existencia de erro.
 */
   public boolean hasErro ( )
   {
      return ( getErro( ) != 0 );
   } // end hasErro ( )
   
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
   
       /**
 * obter o nome.
 */
   public String getNome ( )
   {
      return ( nome );
   } // end getNome ( )
 /**
 * obter o telefone.
 */
   public String getFone ( )
   {
      return ( fone );
   } // end getFone ( )
 
  /**
 * estabelecer novo nome.
 */
   public void setNome ( String novoNome )
   {
      nome = novoNome;
   } // end setNome ( )
 /**
 * estabelecer novo telefone.
 */
   public void setFone ( String novoFone )
   {
      fone = novoFone;
   } // end setFone ( )
   
} // fim da classe Contato
// ---------------------------------------------- definicao da classe principal
public class Exemplo0226
{
// ---------------------------------------------- definicao de metodo auxiliar
  /**
 * Testar definições da classe Contato.
 */
   public void metodo06 ( )
   {
   // 1. definir dados
      Contato a1 = new Contato ( );
      Contato a2 = new Contato ( );
      Contato a3 = new Contato ( );
   // 2. identificar
      IO.println ( "Definicoes da Contato" );
   // 3. testar as definicoes de arranjo
   // <conforme o modelo abaixo testar cada contato>
      if ( a3 == null )
      {
         IO.println ( "Contato a3 nulo" );
      }
      else
      {
         a3.setNome ( "nome1" );
         a3.setFone ( "1111-1111" );
         if ( a3.hasErro ( ) )
         {
            IO.println ( "Contato a3 com erro " + a3.getErro ( ) );
         }
         else
         {
            IO.println ( "Contato a3 nao nulo com "
               + a3.getNome( )+" e " + a3.getFone( ) );
         } // fim se
      } // fim se
   // encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo06 ( )

// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0204 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // criar e executar o metodo auxiliar
      Exemplo0226 m1 = new Exemplo0226 ( );
      m1.metodo06( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0226