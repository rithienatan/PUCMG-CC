/**
 * Guia 0052
 *
 * Trabalho Pratico: Guia 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 28/02/2016
 *
 *@version 0052
*/

import IO.*;
import jkarel.World;
import jkarel.Robot;

public class Guia0052 extends Robot
{
   public Guia0052 ( int avenue, int street, int direction, int beepers )
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
      World.placeNSWall( 2, 3, 4 );
      World.placeNSWall( 4, 6, 1 );
      World.placeEWWall( 3, 6, 1);
      World.placeEWWall( 5, 6, 4);
      World.placeNSWall( 8, 3, 4 );
      World.placeEWWall( 4, 5, 1 );
      World.placeNSWall( 3, 4, 2 );
      World.placeEWWall( 4, 3, 4 );
      World.placeNSWall( 7, 4, 1 );
      World.placeEWWall( 6, 4, 2 );
      World.placeNSWall( 5, 5, 1 );
      
      World.placeBeepers( 2, 3, 1 );
      World.placeBeepers( 5, 6, 2 );
      World.placeBeepers( 7, 4, 3 );
      
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
   
   public void guardar ( String filename )
   {
      FILE arquivo = new FILE ( FILE.OUTPUT, filename );
      
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
            guardar( "Tarefa0052.txt" );
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
      createWorld( "Guia0052.txt" );
      World.reset( );
      World.setSpeed( 7 );
      World.readWorld( "Guia0052.txt" );
      Guia0052 JK = new Guia0052( 1, 1, World.EAST, 0 );
      
      JK.executar( "Tarefa0052.txt" );
   }
}