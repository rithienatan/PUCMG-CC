/**
 * Guia 0053
 *
 * Trabalho Pratico: Guia 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 28/02/2016
 *
 *@version 0053
*/

import IO.*;
import jkarel.World;
import jkarel.Robot;

public class Guia0053 extends Robot
{
   public Guia0053 ( int avenue, int street, int direction, int beepers )
   {
      super( avenue, street, direction, beepers );
   }
   
   public static void createWorld( String nome )
   {
      World.reset( );
      
      World.setTrace( false );
      
      World.placeNSWall( 1, 3, 5 );
      World.placeEWWall( 2, 7, 7);
      World.placeEWWall( 2, 2, 7);
      World.placeNSWall( 2, 4, 3 );
      World.placeNSWall( 4, 6, 1 );
      World.placeEWWall( 3, 6, 6);
      World.placeNSWall( 8, 3, 4 );
      World.placeEWWall( 4, 5, 1 );
      World.placeNSWall( 3, 4, 2 );
      World.placeEWWall( 4, 3, 3 );
      World.placeNSWall( 6, 5, 1 );
      World.placeEWWall( 6, 5, 1 );
      World.placeNSWall( 5, 6, 1 );
      
      World.placeBeepers( 4, 6, 1 );
      World.placeBeepers( 5, 6, 2 );
      World.placeBeepers( 6, 6, 3 );
      
      World.saveWorld( nome );
   }
   
   public void turnRight( )
   {
      int x = 3, n = 1;
      
      while( n <= 3 )
      {
         turnLeft( );
         n = n + 1;
      }
   }
   
   public void turnAround( )
   {
      if(facingNorth( ) )
      {
         while(!facingSouth( ) )
         {
            turnLeft( );
         }
      }
      else if(facingSouth( ) )
      {
         while(!facingNorth( ) )
         {
            turnLeft( );
         }
      }
      else if(facingEast( ) )
      {
         while(!facingWest( ) )
         {
            turnLeft( );
         }
      }
      else if(facingWest( ) )
      {
         while(!facingEast( ) )
         {
            turnLeft( );
         }
      }
   }
   
   public void turnAroundCornerLeft( )
   {
      move( );
      turnRight( );
      move( );
      turnRight( );
      move( );
   }
      
   public void acao ( int mover )
   {
         switch( mover )
         {
           case 0:
               break;
            
           case 1:
               turnAround( );
               break;
               
           case 2:
               while( !facingSouth( ) )
               {
                  turnLeft( );
               }
               break;
               
           case 3:
               turnAroundCornerLeft( );
               break;
               
           case 4:
               while( !facingWest( ) )
               {
                  turnLeft( );
               }
               break;
               
           case 5:
               if ( frontIsClear( ) )
               {
                  move( );
               }
               break;
               
           case 6:
               while( !facingEast( ) )
               {
                  turnLeft( );
               }
               break;
               
           case 7:
               if( nextToABeeper( ) )
               {
                  pickBeeper( );
               }
               break;
               
           case 8:
               while( !facingNorth( ))
               {
                  turnLeft( );
               }
               break;
               
           case 9:
               if( anyBeepersInBeeperBag( ) )
               {
                  putBeeper( );
               }
               break;
            
            default:
               IO.println( "ERROR!! Comando inválido" );
         }
   }
   
   public void beeper ( )
   {
      int x = 0, y = 0;
      int beepers = 0;
      int opcao;
      int guardar [] [];
      int quant[] [];
    
      IO.println ( "JKarel commands:" );
      IO.println ( );
      IO.println ( "0 - turnOff" );
      IO.println ( "1 - turnAround 2 - to South" );
      IO.println ( "3 - turnAroundCornerLeft 4 - to West " );
      IO.println ( "5 - move 6 - to East " );
      IO.println ( "7 - pickBeeper 8 - to North" );
      IO.println ( "9 - putBeeper" );
      IO.println ( );
      IO.println( "Escolha o comando: " ); 
      
      guardar = new int [x][y];
      quant = new int [1][1];
      
      do
      {
         opcao = IO.readint( );
         
         if ( 0 <= opcao && opcao <= 9 )
         {
            acao( opcao );
            if( nextToABeeper( ) )
            {
               x = street( );
               y = avenue( );
                     
               guardar[x][y] = 1;

               IO.println("("+x+" , "+y+")");
               beepers = beepers + 1;
            }
         }
      }
      while( opcao != 0 );
      quant[0][0] = beepers;
      IO.println( "Quantidades de beepers: "+quant[0][0]);
   }
      
   public static void main ( String [] args )
   {
      createWorld( "Guia0053.txt" );
      World.reset( );
      World.setSpeed( 7 );
      World.readWorld( "Guia0053.txt" );
      Guia0053 JK = new Guia0053( 1, 1, World.EAST, 0 );
      
      JK.beeper( );
   }
}