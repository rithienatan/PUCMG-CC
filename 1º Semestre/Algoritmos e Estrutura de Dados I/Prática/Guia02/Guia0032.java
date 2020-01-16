/**
 * Guia 0032
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 0032
*/

// lista de depêndencia

import jkarel.Robot;
import jkarel.World;

//construção da classe

public class Guia0032 extends Robot
{
   public Guia0032 ( int avenue, int street, int direction, int beepers)
   {
      super ( avenue, street, direction, beepers );
   }
   
   // criar o mundo
   
   public static void createWorld ( String nome )
   {
      World.reset( );
      
      World.setTrace( false );
      
      // colocar marcadores
      
      World.placeBeepers( 5, 4, 1 );
      World.placeBeepers( 6, 6, 1 );
      World.placeBeepers( 7, 4, 1 );
      World.placeBeepers( 6, 2, 1 );
      
      // colocar paredes
      
      World.placeNSWall( 3, 2, 2 );
      World.placeNSWall( 3, 5, 2 );
      World.placeNSWall( 5, 2, 1 );
      World.placeNSWall( 6, 2, 1 );
      World.placeNSWall( 8, 2, 2 );
      World.placeNSWall( 8, 5, 2 );
      World.placeNSWall( 6, 6, 1 );
      World.placeNSWall( 5, 6, 1 );
      World.placeNSWall( 5, 4, 1 );
      World.placeNSWall( 6, 4, 1 );
      
      World.placeEWWall( 4, 1, 2 );
      World.placeEWWall( 4, 3, 2 );
      World.placeEWWall( 4, 4, 2 );
      World.placeEWWall( 4, 6, 2 );
      World.placeEWWall( 7, 1, 2 );
      World.placeEWWall( 7, 3, 2 );
      World.placeEWWall( 7, 4, 2 );
      World.placeEWWall( 7, 6, 2 );
      World.placeEWWall( 6, 5, 1 );
      World.placeEWWall( 6, 2, 1 );
      
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
   
   // metodo para movimentar várias vezes
   
   public void moveV(int mover)
   {
      int quant = 0;
      
      while( quant < mover )
      {
         move( );
         quant = quant + 1;
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
   
   // metodos para verificar se a direita e a esquerda está livre
   
   public void direitaIsClear( )
   {
      if(rightIsClear( ))
      {
         turnRight( );
         move( );
      }
   }
   
   public void esquerdaIsClear( )
   {
      if(leftIsClear( ))
      {
         turnLeft( );
         move( );
      }
   }
      
   public void acao( )
   { 
      direitaIsClear( );
      moveV( 4 );
      esquerdaIsClear( );
      pegarBeeper( );
      turnRight( );
      direitaIsClear( );
      esquerdaIsClear( );
      moveV( 2 );
      esquerdaIsClear( );
      moveV( 2 );
      esquerdaIsClear( );
      move( );
      pegarBeeper( );
      turnRight( );
      direitaIsClear( );
      move( );
      esquerdaIsClear( );
      moveV( 2 );
      esquerdaIsClear( );
      moveV( 2 );
      esquerdaIsClear( );
      pegarBeeper( );
      turnRight( );
      direitaIsClear( );
      esquerdaIsClear( );
      moveV( 2 );
      esquerdaIsClear( );
      moveV( 2 );
      esquerdaIsClear( );
      move( );
      pegarBeeper( );
      turnLeft( );
      esquerdaIsClear( );
      moveV( 3 );
      esquerdaIsClear( );
      moveV( 2 );
      turnLeft( );
      turnLeft( );
   }
   
   // metodo principal para executar as ações
   
   public static void main ( String []args )
   {
      createWorld ( "Guia0032.txt" );
      
      World.reset( );
      
      World.setSpeed( 8 );
      
      World.readWorld ( "Guia0032.txt" );
      
      Guia0032 JK = new Guia0032( 1, 1, NORTH, 0);
      
      // executar ações
      
      JK.acao( );
   }
}