/**
 * Guia E1
 *
 * Trabalho Pratico: Guia 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 28/02/2016
 *
 *@version E1
*/

import IO.*;
import jkarel.World;
import jkarel.Robot;

public class GuiaE1 extends Robot
{
   public GuiaE1 ( int avenue, int street, int direction, int beepers )
   {
      super( avenue, street, direction, beepers );
   }
   
   public static void createWorld( String nome )
   {
      World.reset( );
      
      World.setTrace( false );
      
      World.placeNSWall( 1, 3, 2 );
      World.placeEWWall( 2, 2, 7);
      World.placeNSWall( 8, 3, 2);
      World.placeEWWall( 2, 4, 7);
      World.placeEWWall( 2, 3, 3);
      World.placeEWWall( 6, 3, 3);
            
      World.placeBeepers( 8, 3, 1 );      
      
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
   
   public void halfPathRight( )
   {
      while(!facingEast( ) )
      {
         turnLeft( );
      }
      move( );
      move( );
      move( );
   }
   
   public void halfPathLeft( )
   {
      while(!facingWest( ) )
      {
         turnLeft( );
      }
      move( );
      move( );
      move( );
   }
      
   public void acao ( int mover )
   {
      switch( mover )
      {
         case 0:
            break;
            
         case 1:
            halfPathLeft( );
            break;
               
         case 2:
            while( !facingSouth( ) )
            {
               turnLeft( );
            }
            break;
               
         case 3:
            halfPathRight( );
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
            else
            {
               IO.println( "Não está perto do Beeper!!" );
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
           
         case 10:
            if(nextToARobot( ) )
            {
               putBeeper( );
            }
            else
            {
               while(!facingSouth( ) )
               {
                  turnLeft( );
               }
               move( );
               halfPathLeft( );
               IO.pause( "O Robô 2 não estava no local marcado!!" ); 
            }
            break;
            
         default:
            IO.println( "ERROR!! Comando inválido" );
      }
   }
   
   public void Rmove ( String filename )
   {
      int opcao;
      FILE arquivo = new FILE( FILE.OUTPUT, filename );
    
      IO.println ( "JKarel commands:" );
      IO.println ( );
      IO.println ( "0 - turnOff" );
      IO.println ( "1 - halfPathLeft 2 - to South" );
      IO.println ( "3 - halfPathRight 4 - to West " );
      IO.println ( "5 - move 6 - to East " );
      IO.println ( "7 - pickBeeper 8 - to North" );
      IO.println ( "9 - putBeeper 10 - nextToARobot(putBeeper)" );
      IO.println ( );
      IO.println( "Escolha o comando: " ); 
      
      do
      {
         opcao = IO.readint( );
         
         if ( 0 <= opcao && opcao <= 10 )
         {
            acao( opcao );
            arquivo.println(""+opcao);
         }
      }
      while( opcao != 0 );
      arquivo.close( );
   }
   
   public void executarArquivo( String filename )
   {
      FILE arquivo = new FILE( FILE.INPUT, filename );
      String line;
      int opcao;
      
      while(!arquivo.eof( ) )
      {
         line = arquivo.readln( );
         opcao = IO.getint( line );
         acao( opcao );
      }
   }
      
   public static void main ( String [] args )
   {
      createWorld( "GuiaE1.txt" );
      World.reset( );
      World.setSpeed( 7 );
      World.readWorld( "GuiaE1.txt" );
      GuiaE1 JK1 = new GuiaE1( 2, 3, World.EAST, 0 );
      GuiaE1 JK2 = new GuiaE1( 8, 4, World.WEST, 0 );
      
      int x, n, control = 0;
      
      IO.println( "Sugestão: Move o Robô da direita primeiro!!"+"\n" );
      
      do
      {
         x = IO.readint( "Digite 1 para mover o Robô da esquerda!!"+"\n"+
                     "Digite 2 para mover o Robô da direita!!"+"\n"+
                     "Digite 3 executar os comandos no arquivo!!"+"\n"+
                     "Digite 0 para parar o programa!!"+"\n" );
         
         if( x == 1 )
         {
            JK1.Rmove( "TarefaJK1E1.txt" );
         }
         else if( x == 2 )
         {
            n = IO.readint( "Escolha 1 para fazer a primeira parte da tarefa do Robô 2!!"+"\n"+
                            "Depois escolha 2 para terminar a tarefa do Robô 2!!"+"\n" );
            
            if( n == 1 )
            {
               JK2.Rmove( "TarefaJK2E1_Parte1.txt" );
            }
            else if ( n == 2 )
            {
               JK2.Rmove( "TarefaJK2E1_Parte2.txt" );
            }
            else
            {
            IO.println( "ERROR! Opcão inválida! " );
            }
         }
         else if( x == 3 )
         {
            for( control = 0; control < 3; control = control + 1 )
            {
               if( control == 0 )
               {
                  JK2.executarArquivo( "TarefaJK2E1_Parte1.txt" );
               }
               else if( control == 1 )
               {
                  JK1.executarArquivo( "TarefaJK1E1.txt" );
               }
               else if( control == 2 )
               {
                  JK2.executarArquivo( "TarefaJK2E1_Parte2.txt" );
               }
            }
         }
         else if( x == 0 )
         {
            IO.pause( "Fim do programa!!!" );
         }
         else
         {
            IO.println( "ERROR! Opcão inválida! " );
         }
      }
      while( x != 0 );
   }
}