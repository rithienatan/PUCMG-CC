/**
 * Guia 0050
 *
 * Trabalho Pratico: Guia 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 28/02/2016
 *
 *@version 0050
*/

// Lista de dependencias
//
import jkarel.World;
import jkarel.Robot;
import IO.*;
/**
 * Exemplo de programa para uso com a classe JKarel.
 */
public class Guia0050 extends Robot
{
/**
 * construtor padrao da classe Guia00.
 * @param avenue - uma das coordenadas da posicao inicial
 * @param street - outra das coordenadas da posicao inicial
 * @param direction - direcao inicial
 * @param beepers - quantidade inicial de marcadores
 */
   public Guia0050( int avenue, int street, int direction, int beepers )
   {
   // metodo para repassar dados
   // ao construtor padrao da classe original (Robot)
      super( avenue, street, direction, beepers );
   } // end Guia0050( )
 
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
   public int [ ] [ ] mapWorld( )
   {
   // definir dados
      int [ ] [ ] map; // para guardar o mapa
      int avenues, streets;
      int x, y;
      int positions, steps;
      int beepers = 0;
   // obter o tamanho do mundo
      avenues = World.numberOfAvenues( );
      streets = World.numberOfStreets( );
   // informar o tamanho do mundo
      IO.println ( "World is " + avenues + "x" + streets );
   // reservar espaco para o mapa
      map = new int [avenues][streets];
   // calcular o numero total de posicoes
      positions = avenues * streets;
      steps = 1;
   // repetir para todas as posicoes no mundo
      while ( steps < positions )
      {
      // mover para a proxima posicao
         move( );
         // se proximo a um marcador
         if ( nextToABeeper( ) )
         {
            y = steps / 10;
            if ( getDirection( ) == World.EAST )
            {
               x = steps % 10;
            }
            else
            {
               x = avenues - (steps%10) - 1;
               IO.println ( "Beeper found at ("+
                  (x+1)+", "+(y+1)+")" );
            // marcar posicao no mapa
               map[y][x] = 1;
            }            
            // encontrado mais um marcador
            beepers = beepers + 1;
         } // end if
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
      // retornar mapa
      return ( map );   
   } // end mapWorld( ) 
 
 /**
 * metodo para mover o robot interativamente
 * e guardar a descricao da tarefa.
 */
   public void showMap( int[][] map )
   {
   // definir dados
      int avenues,
         streets;
      int x, y;
   // testar existencia de mapa
      if ( map != null )
      {
      // obter o tamanho do mundo
         avenues = map.length;
         streets = map [ 0 ].length;
      // repetir para todas as posicoes no mundo
         for ( y=streets-1; y >= 0; y=y-1 )
         {
            for ( x=0; x<avenues; x=x+1 )
            {
               IO.print ( ""+map [ y ][ x ] );
            }
            IO.println( );
         }
      }
   } // end showMap( )
 
 /**
 * Acao principal: executar a tarefa descrita acima.
 */
   public static void main( String [ ] args )
   {
   // criar o ambiente
   // OBS.: executar pelo menos uma vez,
   // antes de qualquer outra coisa
   // (depois de criado, podera' ser comentado)
      createWorld( "Guia0050.txt" );
   // comandos para tornar o mundo visivel
      World.reset( ); // limpar configuracoes
      World.setSpeed ( 10 ); // escolher velocidade
      World.readWorld( "Guia0050.txt" ); // ler configuracao do ambiente
   // definir o objeto particular para executar as acoes (agente)
      Guia0050 JK = new Guia0050( 1, 1, World.EAST, 0 );
   // executar acoes
    // definir dado
      int [ ] [ ] worldNow;
   // executar acoes
      worldNow = JK.mapWorld( );
      JK.showMap ( worldNow );
   } // end main( )
}