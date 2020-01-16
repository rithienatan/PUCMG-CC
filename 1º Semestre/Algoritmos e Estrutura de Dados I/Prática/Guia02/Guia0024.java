/**
 * Guia 0024
 *
 * Trabalho Pratico: Guia 02
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 0024
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
public class Guia0024 extends Robot
{
/**
 * construtor padrao da classe Guia0021.
 * @param avenue - uma das coordenadas da posicao inicial
 * @param street - outra das coordenadas da posicao inicial
 * @param direction - direcao inicial
 * @param beepers - quantidade inicial de marcadores
 */
   public Guia0024( int avenue, int street, int direction, int beepers )
   {
   // metodo para repassar dados
   // ao construtor padrao da classe original (Robot)
      super( avenue, street, direction, beepers );
   } // end Guia0023( )
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
 * metodo para mover repetidas vezes.
 * @param vezes para executar
 */
   public void moveN( int vezes )
   {
   // repetir (com teste no inicio)
      while ( vezes > 0 )
      {
      // mover-se uma vez ...
         move ( );
      // ... e descontar uma das ainda por fazer
         vezes = vezes - 1;
      } // end while
   } // end moveN( )
  
  /**
 * metodo para coletar marcadores.
 */
   public void pickBeepers( )
   {
   // repetir (com teste no inicio)
   // enquanto houver marcador proximo
      while ( nextToABeeper( ) )
      {
      // coletar um marcador
         pickBeeper ( );
      } // end while
   } // end pickBeepers( )
  
 /**
 * metodo para mover o robot em um retangulo.
 */
   public void doRectangle( )
   {
   // definir dado local
      int vezes; // para contar
   
   // executar acoes repetidas vezes
   // repetir (com teste no inicio e variacao)
      for ( vezes=1; vezes<=4; vezes=vezes+1 )
      {
      // mover-se tres vezes ...
         moveN( 3 );
         // coletar marcadores, se houver
         pickBeepers( );
         // ... e virar 'a direira
         turnRight( );
      } // end for
   
   } // end doRectangle( )
      
 /**
 * Acao principal: executar a tarefa descrita acima.
 */
   public static void main( String [ ] args )
   {
   // criar o ambiente com escada
   // OBS.: executar pelo menos uma vez,
   // antes de qualquer outra coisa
   // (depois de criado, podera' ser comentado)
      createWorld( "Guia0024.txt" );
   // comandos para tornar o mundo visivel
      World.reset( ); // limpar configuracoes
      World.setSpeed ( 7 ); // escolher velocidade
      World.readWorld( "Guia0024.txt" ); // ler configuracao do ambiente
   // definir o objeto particular para executar as acoes (agente)
      Guia0024 JK = new Guia0024( 1, 1, NORTH, 0 );
   // executar acoes repetidas vezes
      JK.doRectangle( );
   } // end main( )
} // end class
// ---------------------------------------------- testes
/*
 Versao Teste
 0.1 01. ( ) - teste inicial
  0.2 01. ( OK ) teste da repeticao para virar 'a direita
0.3 01. ( OK ) teste da repeticao para percorrer um quadrado

*/