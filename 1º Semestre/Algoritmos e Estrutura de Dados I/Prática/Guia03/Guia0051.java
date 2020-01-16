/**
 * Guia 0051
 *
 * Trabalho Pratico: Guia 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 28/02/2016
 *
 *@version 0051
*/

import IO.*;
import jkarel.World;
import jkarel.Robot;

public class Guia0051 extends Robot
{
   public Guia0051 ( int avenue, int street, int direction, int beepers )
   {
      super( avenue, street, direction, beepers );
   }
   
   public static void createWorld( String nome )
   {
      World.reset( );
      
      World.setTrace( false );
      
      World.placeNSWall( 1, 2, 3 );
      World.placeEWWall( 2, 4, 3);
      World.placeEWWall( 2, 1, 3);
      World.placeNSWall( 4, 2, 3 );
      
      World.placeNSWall( 5, 2, 3 );
      World.placeEWWall( 6, 4, 3);
      World.placeEWWall( 6, 1, 3);
      World.placeNSWall( 8, 2, 3 );
      
      World.placeBeepers( 1, 3, 1 );
      World.placeBeepers( 3, 1, 1 );
      World.placeBeepers( 3, 5, 1 );
      
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
      
   public void acao ( int mover )
   {
         switch( mover )
         {
           case 0:
               break;
            
           case 1:
               if( leftIsClear( ))
               {
                  turnLeft( );
               }
               break;
               
           case 2:
               while( !facingSouth( ) )
               {
                  turnLeft( );
               }
               break;
               
           case 3:
               if (  rightIsClear( ) )
               {
                  turnRight( );
               }
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
   
   public void guardar ( String filename )
   {
      FILE arquivo = new FILE ( FILE.OUTPUT, filename );
      
      int opcao;
    
      IO.println ( "JKarel commands:" );
      IO.println ( );
      IO.println ( "0 - turnOff" );
      IO.println ( "1 - turnLeft 2 - to South" );
      IO.println ( "3 - turnRight 4 - to West " );
      IO.println ( "5 - move 6 - to East " );
      IO.println ( "7 - pickBeeper 8 - to North" );
      IO.println ( "9 - putBeeper" );
      IO.println ( );
      IO.println( "Escolha o comando: " );  
      
      do
      {
         opcao = IO.readint( );
         
         if ( 0 <= opcao && opcao <= 9 )
         {
            acao( opcao );
            arquivo.println( ""+opcao );
         }
      }
      while( opcao != 0 );
      arquivo.close( );
   }
   
   public int contarcomandos( String filename )
   {
      FILE arquivo = new FILE( FILE.INPUT, filename );
      int tamanho = 0;
      String linha;
      
      linha = arquivo.readln( );
      while(!arquivo.eof( ))
      {
         tamanho = tamanho + 1;
         linha = arquivo.readln( );
      }
      arquivo.close( );
      
      return tamanho;
   }
   
   public int [] ler( String filename )
   {
      FILE arquivo = new FILE( FILE.INPUT, filename );
      int [] comandos;
      int tamanho;
      int opcao;
      int contar;
      String linha;
      
      tamanho = contarcomandos( filename );
      comandos = new int [tamanho];
      
      for ( contar = 0; contar < tamanho; contar = contar + 1 )
      {
         linha = arquivo.readln( );
         opcao = IO.getint( linha );
         comandos [contar] = opcao;
      }
      arquivo.close( );
      return comandos;
   }
   
   public void fazer ( int [] comando )
   {
      int tamanho = comando.length;
      int opcao;
      int contador;
      
      for( contador = 0; contador < tamanho; contador = contador + 1 )
      {
         acao( comando [ contador ] );
      }
   }
      
   public void executar ( String filename )
   {
      int a;
      int n;
      int []tarefa;
      do
      {
         a = IO.readint( " Digite 0: Para parar o programa!"+"\n"+
                          " Digite 1: Para excutar ações e salvar!"+"\n"+
                          " Digite 2: Para ler o arquivo salvo!");
         
         if ( a == 1 )
         {
            guardar( "Tarefa0051.txt" );
         }
         else if( a == 2 )
         {
            n = contarcomandos( filename );
            tarefa = ler( filename );
            fazer( tarefa );
         }       
         else if( a == 0 )
         {
            IO.pause( "Fim do programa!" );
         }
         else if ( a > 2 || a < 0 )
         {
            IO.println( "ERROR:Opcão inválida!" );
         }   
      }
      while( a != 0 );
   }
   
   public static void main ( String [] args )
   {
      createWorld( "Guia0051.txt" );
      World.reset( );
      World.setSpeed( 7 );
      World.readWorld( "Guia0051.txt" );
      Guia0051 JK = new Guia0051( 1, 1, World.EAST, 0 );
      
      JK.executar( "Tarefa0051.txt" );
   }
}