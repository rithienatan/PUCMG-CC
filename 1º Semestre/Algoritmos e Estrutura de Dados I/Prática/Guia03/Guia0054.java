/**
 * Guia 0054
 *
 * Trabalho Pratico: Guia 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 28/02/2016
 *
 *@version 0054
*/

import IO.*;
import jkarel.World;
import jkarel.Robot;

public class Guia0054 extends Robot
{
   public Guia0054 ( int avenue, int street, int direction, int beepers )
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
      World.placeEWWall( 5, 3, 1 );
      World.placeNSWall( 6, 4, 2 );
      World.placeEWWall( 6, 5, 1 );
      World.placeNSWall( 5, 6, 1 );
      World.placeNSWall( 4, 4, 1 );
      World.placeNSWall( 5, 4, 1 );
      World.placeEWWall( 5, 4, 1 );
      
      World.placeBeepers( 4, 6, 3 );
      World.placeBeepers( 5, 6, 2 );
      World.placeBeepers( 6, 6, 1 );
      
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
   
   public int [ ][ ]mapK ( )
   {
      int [ ][ ]map;
      int avenues, streets;
      int x,y;
      int opcao;
    
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
      
      avenues = World.numberOfAvenues( );
      streets = World.numberOfStreets( );
            
      map = new int[ avenues ][ streets ];
      
      do
      {
         opcao = IO.readint( );
         
         if ( 0 <= opcao && opcao <= 9 )
         {
            x = avenue( );
            y = street( );
            map[ x ][ y ] = 1;
            acao( opcao );
         }
      }
      while( opcao != 0 );
      return ( map );
   }
   
   public void mostrarMap ( int[ ][ ]map, String filename )
   {
      int avenues, streets;
      int x, y;
      FILE arquivo = new FILE( FILE.OUTPUT, filename );
      
      avenues = map.length;
      streets = map[ 0 ].length;
      
      for ( y = streets - 1; y >= 0; y = y - 1 )
      {
         for( x = 0; x < avenues - 1; x = x + 1 )
         {
            arquivo.println( ""+map[ x ][ y ] );
            IO.print( ""+map[ x ][ y ] );
         }
         IO.println( );
      }
      arquivo.close( );
   }
      
   public static void main ( String [] args )
   {
      createWorld( "Guia0054.txt" );
      World.reset( );
      World.setSpeed( 7 );
      World.readWorld( "Guia0054.txt" );
      Guia0054 JK = new Guia0054( 1, 1, World.EAST, 0 );
      
      int[ ][ ]worldTeste;
      
      worldTeste = JK.mapK( );
      JK.mostrarMap( worldTeste, "Tarefa0054.txt" );
   }
}