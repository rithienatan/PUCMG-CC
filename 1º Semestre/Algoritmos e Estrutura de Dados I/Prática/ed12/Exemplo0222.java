/**
 * Estudo Dirigido 12
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 08/05/2016
 
   Exemplo0222
 
 *@version 01
*
*/
/**
 * Exemplo0222
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
      if( nomeInicial != null && foneInicial != null )
      {
         nome = nomeInicial;
         fone = foneInicial;
      }
   } // fim construtor alternativo
 
   
} // fim da classe Contato
// ---------------------------------------------- definicao da classe principal
public class Exemplo0222
{
// ---------------------------------------------- definicao de metodo auxiliar
  /**
 * Testar definições da classe Contato.
 */
   public void metodo02 ( )
   {
   // 1. definir dados
      Contato a1 = null;
      Contato a2 = new Contato ( );
      Contato a3 = new Contato ( "nome1", "1111-1111" );
   // 2. identificar
      IO.println ( "Definicoes da Contato" );
   // 3. testar as definicoes de arranjo
   // . . .
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
      Exemplo0222 m1 = new Exemplo0222 ( );
      m1.metodo02 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0222