/**
 * Guia 0034
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 0034
*/

// lista de depêndencia

import jkarel.Robot;
import jkarel.World;

import IO.*;
//construção da classe

public class Guia0034 extends Robot
{
   public Guia0034 ( int avenue, int street, int direction, int beepers)
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
      World.placeBeepers( 4, 3, 2 );
      World.placeBeepers( 4, 4, 3 );
      World.placeBeepers( 5, 2, 1 );
      World.placeBeepers( 5, 3, 2 );
      World.placeBeepers( 6, 2, 1 );
      
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
 
 // metodo para pegar o beeper nas posições
  
   public void pegar1( )
   {
      turnRight( );
      direitaIsClear( );
      moveV( 3 );
      esquerdaIsClear( );
      esquerdaIsClear( );
      moveV( 3 );
      pegarBeeper( );
   }
   
   public void pegar2( )
   {
      pegarBeeper( );
      moveV( 3 );
      direitaIsClear( );
      direitaIsClear( );
      moveV( 2 );
      pegarBeeper( );
   }
   
   public void pegar3( )
   {
      esquerdaIsClear( );
      moveV( 2 );
      esquerdaIsClear( );
      esquerdaIsClear( );
      move( );
      pegarBeeper( );
   }
   
   // metodo com ações e gravação das posições dos beepers
      
   public void acao( )
   {
      FILE arquivo = new FILE( FILE.APPEND, "Tarefa34b.txt" );
      int x,y;
      
      turnLeft( );
      if( areYouHere( 1,1 ))
      {
         moveV( 6 );
         direitaIsClear( );
         moveV( 3 );
         direitaIsClear( );       
      }
      if( areYouHere( 5,6 ))
      {
         direitaIsClear( );
         esquerdaIsClear( );
         move( );
         pegarBeeper( );
         x = avenue( );
         y = street( );
         arquivo.println ( ""+x );
         arquivo.println ( ""+y );      
      }
      if( areYouHere( 4,4 ))
      {
         move( );
         pegarBeeper( );
         turnLeft( );
         esquerdaIsClear( );
         moveV( 2 );
         direitaIsClear( );
         direitaIsClear( );
         moveV( 2 );
         pegarBeeper( );
         x = avenue( );
         y = street( );
         arquivo.println ( ""+x );
         arquivo.println ( ""+y );
      }
      turnLeft( );
      if( areYouHere( 5,3 ))
      {
         esquerdaIsClear( );
         moveV( 2 );
         direitaIsClear( );
         direitaIsClear( );
         moveV( 3 );
         pegarBeeper( );
         x = avenue( );
         y = street( );
         arquivo.println ( ""+x );
         arquivo.println ( ""+y );
      }
      if( areYouHere( 6,2 ))
      {
         pegar1( );
         x = avenue( );
         y = street( );
         arquivo.println ( ""+x );
         arquivo.println ( ""+y );   
      }
      if( areYouHere( 5,2 ))
      {
         pegar1( );
         x = avenue( );
         y = street( );
         arquivo.println ( ""+x );
         arquivo.println ( ""+y );
      }
      turnLeft( );
      if( areYouHere( 4,2 ))
      {
         esquerdaIsClear( );
         moveV( 3 );
         direitaIsClear( );
         esquerdaIsClear( );
         direitaIsClear( );
         move( );
         direitaIsClear( );
         moveV( 5 ); 
         colocarBeeper( );
      }
      if( areYouHere( 7,1 ))
      {
         direitaIsClear( );
         moveV( 5 );
         turnRight( );
         turnRight( );
      }   
         
      arquivo.close( );
   }
   
   // metodo para quardar as posições em que tiver beepers
        
   // metodo principal para executar as ações
   
   public static void main ( String []args )
   {
      createWorld ( "Guia0034.txt" );
      
      World.reset( );
      
      World.setSpeed( 10 );
      
      World.readWorld ( "Guia0034.txt" );
      
      Guia0034 JK = new Guia0034( 1, 1, EAST, 0);
      
      // executar ações
      
      JK.acao( );
   }
}