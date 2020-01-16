/**
 * Guia 0031
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 0031
*/

// lista de depêndencia

import jkarel.Robot;
import jkarel.World;

//construção da classe

public class Guia0031 extends Robot
{
   public Guia0031 ( int avenue, int street, int direction, int beepers)
   {
      super ( avenue, street, direction, beepers );
   }
   
   // criar o mundo
   
   public static void createWorld ( String nome )
   {
      World.reset( );
      
      World.setTrace( false );
      
      // colocar marcadores
      
      World.placeBeepers( 7, 3, 1 );
      World.placeBeepers( 8, 2, 1 );
      World.placeBeepers( 9, 1, 1 );
      
      // colocar paredes
      
      World.placeNSWall( 2, 1, 1 );
      World.placeEWWall( 3, 1, 1 );
      World.placeNSWall( 3, 2, 1 );
      World.placeEWWall( 4, 2, 1 );
      World.placeNSWall( 4, 3, 1 );
      World.placeEWWall( 5, 3, 1 );
      World.placeEWWall( 6, 3, 1 );
      World.placeNSWall( 6, 3, 1 );
      World.placeNSWall( 7, 2, 1 );
      World.placeNSWall( 8, 1, 1 );
      World.placeEWWall( 7, 2, 1 );
      World.placeEWWall( 8, 1, 1 );
      
      // salvar em um arquivo
      
      World.saveWorld( nome );
   }
   
   // metodo para virar a direita
   public void turnRight( )
   {
      int vezes = 1;
      
      while ( vezes <= 3 )
      {
         turnLeft( );
         
         vezes = vezes + 1;
      }
   }
   
   // metodo para pegar um marcador
   
   public void pegarBeeper( )
   {
      while( nextToABeeper( ) )
      {
         pickBeeper( );
      }
   }
   
   // metodo para colocar um marcador
   
   public void colocarBeeper( )
   {
      if( anyBeepersInBeeperBag( ) )
      {
         putBeeper( );
      }
   }
   
   // metodos para subir/descer uma escada
   
   public void stepUpRight( )
   {
      turnLeft( );
      move( );
      turnRight( );
      move( );
   }
   
   public void stepDownRight( )
   {
      move( );
      turnRight( );
      move( );
      turnLeft( );
   }
   
   public void stepUpLeft( )
   {
      turnRight( );
      move( );
      turnLeft( );
      move( );
   }
   
   public void stepDownLeft( )
   {
      move( );
      turnLeft( );
      move( );
      turnRight( );
   }
   
   public void acao( )
   { 
      turnRight( );
      move( );
      stepUpRight( );
      stepUpRight( );
      stepUpRight( );
      move( );
      stepDownRight( );
      pegarBeeper( );
      stepDownRight( );
      pegarBeeper( );
      stepDownRight( );
      pegarBeeper( );
      turnLeft( );
      turnLeft( );
      stepUpLeft( );
      stepUpLeft( );
      stepUpLeft( );
      move( );
      stepDownLeft( );
      colocarBeeper( );
      stepDownLeft( );
      colocarBeeper( );
      stepDownLeft( );
      colocarBeeper( );
      move( );
      turnRight( );
   }
   
   // metodo principal para executar as ações
   
   public static void main ( String []args )
   {
      createWorld ( "Guia0031.txt" );
      
      World.reset( );
      
      World.setSpeed( 8 );
      
      World.readWorld ( "Guia0031.txt" );
      
      Guia0031 JK = new Guia0031( 1, 1, NORTH, 0);
      
      // executar ações
      
      JK.acao( );
   }
}