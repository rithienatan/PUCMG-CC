/**
 * Estudo Dirigido 10
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 23/04/2016
 
   Exemplo0190
 
 *@version 01
*
*/

/**
 * Exemplo0190
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

 /**
 * ler valores inteiros de arquivo e guardar em uma tabela.
 * @param message - com texto a ser mostrado na tela
 */
   public void readArray ( String message )
   {
   // definir dados
      int posicao,
         tamanho = length( );
      String linha;
   // testar se quantidade valida
      if ( tamanho <= 0 )
      {
         IO.println ( "ERRO: Tamanho invalido." );
      }
      else
      {
      // mostrar mensagem antes de ler dados
         IO.println ( message );
      // obter o tamanho da tabela
         tamanho = this.length ( );
      // repetir para cada posicao na tabela
         for ( posicao = 0;
         posicao < tamanho;
         posicao = posicao + 1 )
         {
         // ler linha do teclado
            linha = IO.readln ( );
         // armazenar em um posicao da tabela
         // como objeto em String
            tabela [ posicao ] = linha;
         } // fim repetir
      } // fim se
   } // fim readArray ( )
   
    /**
 * ler valores inteiros de arquivo e guardar em uma tabela.
 * @param message - com texto a ser mostrado na tela
 * @param n - quantidade de dados a serem lidos
 */
   public void readIntArray ( String message, int n )
   {
   // definir dados
      int posicao,
         tamanho = length( );
      String linha;
   // testar se quantidade valida
      if ( tamanho <= 0 ||
      n <= 0 || n > tamanho )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // mostrar mensagem antes de ler dados
         IO.println ( message );
      // repetir para cada posicao na tabela
         for ( posicao = 0;
         posicao < n;
         posicao = posicao + 1 )
         {
         // ler linha do teclado
            linha = IO.readln ( );
         // armazenar em um posicao da tabela
         // valor convertido para inteiro
            tabela [ posicao ] = IO.getint ( linha );
         } // fim repetir
      } // fim se
   } // fim readIntArray ( )
   
   /**
 * exibir certa quantidade de dados em tabela.
 * @param n - quantidade de dados a serem mostrados
 */
   public void printIntArray ( int n )
   {
   // definir dados
      int posicao,
         tamanho = length( );
   // identificar
      IO.println ( );
   // testar se a tabela foi montada
      if ( tabela == null ||
      n <= 0 || n > tamanho )
      {
         IO.println ( "ERRO: Tabela vazia ou quantidade invalida." );
      }
      else
      {
      // mostrar tabela
         IO.println ( "Tabela com "+tamanho+" posicoes:" );
      // repetir para cada posicao na tabela
         for ( posicao = 0;
         posicao < n;
         posicao = posicao + 1 )
         {
         // mostrar o valor armazenado
            IO.println ( "posicao = "+posicao+
               " tem valor = "+(int) tabela [ posicao ] );
         } // fim repetir
      } // fim se
   } // fim printIntArray ( )
   
    /**
 * clonar tabela.
 * @return nova tabela com dados copiados
 */
   public Arranjo clone ( )
   {
   // definir dados
      int tamanho, posicao;
      Arranjo nova = null;
   // testar existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
      // obter o tamanho da tabela original
         tamanho = length( );
      // reservar espaco para a nova tabela
         nova = new Arranjo ( tamanho );
      // testar a existencia de dados
         if ( nova == null )
         {
            IO.println ( "ERRO: Nao ha' espaco." );
         }
         else
         {
         // repetir para cada posicao na tabela original
            for ( posicao = 0;
            posicao < nova.length( );
            posicao = posicao + 1 )
            {
            // copiar dado de uma posicao
               nova.tabela [ posicao ] = tabela [ posicao ];
            } // fim repetir
         } // fim se
      } // fim se
   // retornar nova tabela
      return ( nova );
   } // fim clone ( )

 /**
 * copiar certa quantidade de dados em tabela.
 * @return nova tabela com dados copiados
 * @param n - quantidade de dados
 */
   public Arranjo copyArray ( int n )
   {
   // definir dados
      int posicao,
         tamanho = length( );
      Arranjo nova = null;
   // testar existencia de dados
      if ( tabela == null ||
      n <= 0 || n > tamanho )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
      // reservar espaco para a nova tabela
         nova = new Arranjo ( n );
      // testar a existencia de dados
         if ( nova == null )
         {
            IO.println ( "ERRO: Nao ha' espaco." );
         }
         else
         {
         // repetir para cada posicao na tabela original
            for ( posicao = 0;
            posicao < nova.length( );
            posicao = posicao + 1 )
            {
            // copiar dado de uma posicao
               nova.tabela [ posicao ] = tabela [ posicao ];
            } // fim repetir
         } // fim se
      } // fim se
   // retornar nova tabela
      return ( nova );
   } // fim copyArray ( )

/**
 * exibir dados em tabela automaticamente.
 */
   public String toString ( )
   {
   // definir dados
      String msg = null;
      int posicao,
         tamanho;
   // testar se a tabela foi montada
      if ( tabela != null )
      {
      // obter o tamanho da tabela
         tamanho = length( );
      // repetir para cada posicao na tabela
         msg = "";
         for ( posicao = 0;
         posicao < tamanho;
         posicao = posicao + 1 )
         {
         // guardar valor armazenado
            msg = msg + " " + tabela [ posicao ];
         } // fim repetir
      } // fim se
   // retornar valores armazenados
      return ( msg );
   } // fim toString ( )

} // fim da classe Arranjo

 
// ---------------------------------------------- definicao da classe principal
public class Exemplo0190
{
// ---------------------------------------------- definicao de metodo auxiliar
   /**
 * Testar entrada e saida de dados em arranjo usando classe.
 */
   public static void metodo10 ( )
   {
   // 1. definir dados
      Arranjo a2 = null;
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em arranjo" );
      IO.println ( );
   // 3. testar entrada e saida em arranjo
   // ler dados e guardar no arranjo
      a3.readIntArray ( "Entrar com dados no arranjo:", 3 );
   // tornar arranjos identicos
      a2 = a3.copyArray( 2 );
   // mostrar dados no arranjo copiado
      IO.println ( "Mostrar dados lidos e armazenados:" );
      IO.println ( ""+a2 );
   // mostrar dados no arranjo original
      IO.println ( "Mostrar dados lidos e armazenados:" );
      IO.println ( ""+a3 );
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo10( )  
   
// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0190 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      metodo10( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0190