/**
 * Guia 0035
 *
 * Trabalho Pratico: Guia 02
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 0035
*/

// lista de depêndencia

import jkarel.Robot;
import jkarel.World;

import IO.*;
//construção da classe

public class Guia0035 extends Robot
{
   public Guia0035 ( int avenue, int street, int direction, int beepers )
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
      World.placeBeepers( 6, 4, 1 );
      World.placeBeepers( 6, 3, 2 );
      World.placeBeepers( 5, 2, 2 );
      World.placeBeepers( 5, 3, 1 );
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
   
   public void moveV( int mover )
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
   
   // metodo com as ações
      
   public void acao( int executar )
   {
      switch( executar )
      {
         case 0:
            break;
         
         case 1:
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
               turnLeft( );
               move( );
               direitaIsClear( );
               moveV( 3 );
               pegarBeeper( );     
            }
            if( areYouHere( 6,2 ))
            {
               turnLeft( );
               esquerdaIsClear( );
               pegarBeeper( );
               moveV( 3 );
               esquerdaIsClear( );
               esquerdaIsClear( );
               moveV( 3 );
               pegarBeeper( );
            }
            if( areYouHere( 5,2 ))
            {
               turnLeft( );
               esquerdaIsClear( );
               pegarBeeper( );
               moveV( 3 );
               esquerdaIsClear( );
               esquerdaIsClear( );
               moveV( 3 );
               pegarBeeper( );
            }
            turnLeft( );
            esquerdaIsClear( );
            if( areYouHere( 4,3 ))
            {
               moveV( 3 );
               direitaIsClear( );
               move( );
               direitaIsClear( );
               move( );
               pegarBeeper( );
            }
            turnLeft( );
            esquerdaIsClear( );
            if( areYouHere( 6,5 ))
            {
               move( );
               esquerdaIsClear( );
               direitaIsClear( );
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
            break;
            
         default:
            IO.println( "ERRROR!!! Comando inválido!!" );
      }
   }
   
   public void guardar ( String filename )
   {
      int option;
      
      FILE archive = new FILE( FILE.OUTPUT, filename );
            
      do
      {
         option = IO.readint( "Aperte 1 para executar a tarefa ou 0 para não fazer nada!!!" );
         
         if( 0 <= option && option <= 1 )
         {
            acao( option );
            
            archive.println(""+option);
         }
      }
      while( option != 0 );
      archive.close( );
   }
   
   public void ler ( String filename )
   {
      int option;
      FILE archive = new FILE ( FILE.INPUT, filename );
      String line;
      
      line = archive.readln( );
      while( !archive.eof( ) )
      {
         option = IO.getint( line );
         acao( option );
         line = archive.readln( );
      }
      archive.close( );
   }
   
   // metodo principal para executar as ações
   
   public static void main ( String []args )
   {
      createWorld ( "Guia0035.txt" );
      
      World.reset( );
      
      World.setSpeed( 7 );
      
      World.readWorld ( "Guia0035.txt" );
      
      Guia0035 JK = new Guia0035( 1, 1, EAST, 0);
      
      // executar ações
      
      JK.ler( "Tarefa0035.txt" );
   }
}