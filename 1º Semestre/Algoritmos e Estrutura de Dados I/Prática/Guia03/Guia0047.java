/**
 * Guia 0047
 *
 * Trabalho Pratico: Guia 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 28/02/2016
 *
 *@version 0047
*/

// Lista de dependencias
//
import jkarel.World;
import jkarel.Robot;
import IO.*;
/**
 * Exemplo de programa para uso com a classe JKarel.
 */
public class Guia0047 extends Robot
{
/**
 * construtor padrao da classe Guia00.
 * @param avenue - uma das coordenadas da posicao inicial
 * @param street - outra das coordenadas da posicao inicial
 * @param direction - direcao inicial
 * @param beepers - quantidade inicial de marcadores
 */
   public Guia0047( int avenue, int street, int direction, int beepers )
   {
   // metodo para repassar dados
   // ao construtor padrao da classe original (Robot)
      super( avenue, street, direction, beepers );
   } // end Guia0047( )
 
 /* metodo para criar configuracoes do ambiente.
 * @param nome do arquivo onde guardar a configuracao
 */
   public static void createWorld( String nome )
   {
   // o executor deste metodo (World - agente)
   // ja' foi definido na classe original (Robot)
      World.reset( ); // limpar configuracoes
   // para nao exibir os passos de criacao do ambiente
      World.setTrace( false ); // (opcional)
   // para colocar marcador(es)
      World.placeBeepers( 4, 4, 1 );
   // para guardar em arquivo
      World.saveWorld( nome ); // gravar configuracao
   } // end createWorld( )

   public void turnRight( )
   {
      int x = 3, n = 1;
      
      while( n <= 3 )
      {
         turnLeft( );
         n = n + 1;
      }
   }

/**
 * metodo para o robot explorar o mundo.
 */
   public void mapWorld( )
   {
   // definir dados
      int avenues, streets;
      int x, y;
      int positions, steps;
   // obter o tamanho do mundo
      avenues = World.numberOfAvenues( );
      streets = World.numberOfStreets( );
   // informar o tamanho do mundo
      IO.println ( "World is " + avenues + "x" + streets );
   // calcular o numero total de posicoes
      positions = avenues * streets;
      steps = 1;
   // repetir para todas as posicoes no mundo
      while ( steps < positions )
      {
      // mover para a proxima posicao
         move( );
      // testar se e' preciso mudar de linha
         steps = steps + 1;
         if ( steps < positions && steps % 10 == 0 )
         { // ao final de cada linha, testar ...
            if ( steps / 10 % 2 != 0 ) // … e' impar ?
            { // subir e virar a esquerda
               turnLeft( );
               move( );
               turnLeft( );
            }
            else // e' par ?
            { // subir e virar a direita
               turnRight( );
               move( );
               turnRight( );
            } // end if
            steps = steps + 1; // passer 'a proxima
         } // end if
      } // end while
   } // end mapWorld( ) 
 
 /**
 * Acao principal: executar a tarefa descrita acima.
 */
   public static void main( String [ ] args )
   {
   // criar o ambiente
   // OBS.: executar pelo menos uma vez,
   // antes de qualquer outra coisa
   // (depois de criado, podera' ser comentado)
      createWorld( "Guia0047.txt" );
   // comandos para tornar o mundo visivel
      World.reset( ); // limpar configuracoes
      World.setSpeed ( 6 ); // escolher velocidade
      World.readWorld( "Guia0047.txt" ); // ler configuracao do ambiente
   // definir o objeto particular para executar as acoes (agente)
      Guia0047 JK = new Guia0047( 1, 1, World.EAST, 0 );
   // executar acoes
      JK.mapWorld( );
   } // end main( )
}