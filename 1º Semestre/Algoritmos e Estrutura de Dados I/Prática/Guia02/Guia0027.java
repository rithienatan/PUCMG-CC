/**
 * Guia 0027
 *
 * Trabalho Pratico: Guia 02
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 0027
*/

//
// Lista de dependecias
//
import jkarel.World;
import jkarel.Robot;

import IO.*;
/**
 * Exemplo de programa para uso com a classe JKarel.
 */
public class Guia0027 extends Robot
{
/**
 * construtor padrao da classe Guia0026.
 * @param avenue - uma das coordenadas da posicao inicial
 * @param street - outra das coordenadas da posicao inicial
 * @param direction - direcao inicial
 * @param beepers - quantidade inicial de marcadores
 */
   public Guia0027( int avenue, int street, int direction, int beepers )
   {
   // metodo para repassar dados
   // ao construtor padrao da classe original (Robot)
      super( avenue, street, direction, beepers );
   } // end Guia0027( )
/**
 * metodo para criar configuracoes do ambiente.
 * @param nome do arquivo onde guardar a configuracao
 */
   public static void createWorld( String nome )
   {
   // o executor deste metodo (World - agente)
   // ja' foi definido na classe original (Robot)
      World.reset( ); // limpar configuracoes
   // para nao exibir os passos de criacao do ambiente
      World.setTrace( false ); // (opcional)
   // para colocar marcadores
      World.placeBeepers( 4, 4, 3 ); // em (4,4), tres marcadores
   // para guardar em arquivo
      World.saveWorld( nome ); // gravar configuracao
   } // end createWorld( )

/**
 * metodo para virar 'a direita (com repeticao).
 */
   public void turnRight( )
   {
   // definir dado local
      int vezes = 1; // para contar quantas vezes
   // o executor deste metodo
   // devera' virar tres vezes 'a esquerda
   // repetir (com teste no inicio)
      while ( vezes <= 3 )
      {
      // virar uma vez ...
         turnLeft( );
      // ... e contar mais uma feita
         vezes = vezes + 1;
      } // end while
   } // end turnRight( )   

/**
 * metodo para executar um comando.
 * @param option - comando a ser executado
 */
   public void execute( int option )
   {
   // executar a opcao de comando
      switch ( option )
      {
         case 0: // terminar
         // nao fazer nada
            break;
         case 1: // virar para a esquerda
            if ( leftIsClear ( ) )
            {
               turnLeft( );
            } // end if
            break;
         case 2: // virar para o sul
            while ( ! facingSouth( ) )
            {
               turnLeft( );
            } // end while
            break;
         case 3: // virar para a direita
            if ( rightIsClear ( ) )
            {
               turnRight( );
            } // end if
            break;
         case 4: // virar para o oeste
            while ( ! facingWest( ) )
            {
               turnLeft( );
            } // end while
            break;
         case 5: // mover
            if ( frontIsClear ( ) )
            {
               move( );
            } // end if
            break;
         case 6: // virar para o leste
            while ( ! facingEast( ) )
            {
               turnLeft( );
            } // end while
            break;
         case 7: // pegar marcador
            if ( nextToABeeper( ) )
            {
               pickBeeper( );
            } // end if
            break;
         case 8: // virar para o norte
            while ( ! facingNorth( ) )
            {
               turnLeft( );
            } // end while
            break;
         case 9: // colocar marcador
            if ( anyBeepersInBeeperBag( ) )
            {
               putBeeper( );
            } // end if
            break;
         default:// nenhuma das alternativas anteriores
         // comando invalido
            IO.println ( "ERROR: Invalid command." );
      } // end switch
   } // end execute( )
  
  /**
 * metodo para mover o robot interativamente.
 */
   public void moveI( )
   {
   // definir dados
      int option;
   // apresentar comandos
      IO.println ( );
      IO.println ( "JKarel commands:" );
      IO.println ( );
      IO.println ( "0 - turnOff" );
      IO.println ( "1 - turnLeft 2 - to South" );
      IO.println ( "3 - turnRight 4 - to West " );
      IO.println ( "5 - move 6 - to East " );
      IO.println ( "7 - pickBeeper 8 - to North" );
      IO.println ( "9 - putBeeper" );
      IO.println ( );
   // repetir (com testes no fim)
   // enquanto opcao diferente de zero
      do
      {
      // ler opcao
         option = IO.readint ( "Command? " );
      // executar commando
         execute ( option );
      }
      while ( option != 0 );
   } // end moveI( )
  
      /**
 * Acao principal: executar a tarefa descrita acima.
 */
   public static void main( String [ ] args )
   {
   // criar o ambiente com escada
   // OBS.: executar pelo menos uma vez,
   // antes de qualquer outra coisa
   // (depois de criado, podera' ser comentado)
      createWorld( "Guia0027.txt" );
   // comandos para tornar o mundo visivel
      World.reset( ); // limpar configuracoes
      World.setSpeed ( 7 ); // escolher velocidade
      World.readWorld( "Guia0027.txt" ); // ler configuracao do ambiente
   // definir o objeto particular para executar as acoes (agente)
      Guia0027 JK = new Guia0027( 1, 1, NORTH, 0 );
   // executar acoes interativamente
      JK.moveI( );     
   } // end main( )
} // end class
// ---------------------------------------------- testes
/*
 Versao Teste
 0.1 01. ( ) - teste inicial
  0.2 01. ( OK ) teste da repeticao para virar 'a direita
0.3 01. ( OK ) teste da repeticao para percorrer um quadrado

*/