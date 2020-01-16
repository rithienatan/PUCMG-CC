/**
 * Guia 0033
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 0033
*/

// lista de depêndencia

import jkarel.Robot;
import jkarel.World;

//construção da classe

public class Guia0033 extends Robot
{
   public Guia0033 ( int avenue, int street, int direction, int beepers)
   {
      super ( avenue, street, direction, beepers );
   }
   
   // criar o mundo
   
   public static void createWorld ( String nome )
   {
      World.reset( );
      
      World.setTrace( false );
      
      // colocar marcadores
      
      World.placeBeepers( 4, 2, 1 );
      World.placeBeepers( 5, 2, 2 );
      World.placeBeepers( 6, 2, 3 );
      
      // colocar paredes
      
      World.placeNSWall( 3, 2, 5 );
      World.placeNSWall( 4, 2, 4 );
      World.placeNSWall( 5, 2, 4 );
      World.placeNSWall( 6, 2, 5 );
      
      World.placeEWWall( 4, 1, 3 );
      World.placeEWWall( 4, 6, 1 );
      World.placeEWWall( 6, 6, 1 );
      
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
      while( anyBeepersInBeeperBag( ) )
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
      turnLeft( );
      if( areYouHere( 1,1 ))
      {
         moveV( 6 );
         direitaIsClear( );
         moveV( 3 );
         direitaIsClear( );
         direitaIsClear( );
         esquerdaIsClear( );
         moveV( 3 );
         pegarBeeper( );
      }
      turnLeft( );
      if ( areYouHere( 4,2 ))
      {
         esquerdaIsClear( );
         moveV( 3 );
         direitaIsClear( );
         direitaIsClear( );
         moveV( 3 );
         pegarBeeper( );
      }
      turnLeft( );
      if( areYouHere( 5,2 ))
      {
         esquerdaIsClear( );
         moveV( 3 );
         direitaIsClear( );
         direitaIsClear( );
         moveV( 3 );
         pegarBeeper( );
      }
      turnLeft( );
      if( areYouHere( 6,2 ))
      {
         esquerdaIsClear( );
         moveV( 3 );
         esquerdaIsClear( );
         direitaIsClear( );
         moveV( 2 );
         esquerdaIsClear( );
         moveV( 3 );
         colocarBeeper( );
      }
      turnLeft( );
      if( areYouHere( 1,9 ))
      {
         moveV( 8 );
         while(!facingNorth( ))
         {
            turnRight( );
         }
      }
   }
   
   // metodo principal para executar as ações
   
   public static void main ( String []args )
   {
      createWorld ( "Guia0033.txt" );
      
      World.reset( );
      
      World.setSpeed( 8 );
      
      World.readWorld ( "Guia0033.txt" );
      
      Guia0033 JK = new Guia0033( 1, 1, EAST, 0);
      
      // executar ações
      
      JK.acao( );
   }
}