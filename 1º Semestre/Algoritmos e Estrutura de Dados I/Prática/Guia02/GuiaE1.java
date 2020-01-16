/**
 * Guia E1
 *
 * Trabalho Pratico: Guia 02
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version E1
*/
import IO.*;
import jkarel.Robot;
import jkarel.World;

public class GuiaE1 extends Robot
{
   public GuiaE1 ( int avenue, int street, int direction, int beepers )
   {
      super ( avenue, street, direction, beepers );
   }
   
   public static void createWorld ( String nome )
   {
      World.reset( );
      
      World.placeBeepers( 3, 3, 1 );
      
      World.saveWorld( nome );
   }
   
   public void turnRight( )
   {
      int vezes;
      
      for (vezes = 1; vezes <= 3; vezes = vezes + 1)
      {
         turnRight( );
      }
   }
   
   public void pegar( )
   {
      if(nextToABeeper( ))
      {
         pickBeeper( );
      }
   }
   
   public void colocar( )
   {
      if(anyBeepersInBeeperBag( ))
      {
         putBeeper( );
      }
   }
      
   public void comandos ( int executar )
   {      
      switch ( executar )
      {
         case 0:
            break;
        
         case 1:
            if(leftIsClear( ))
            {
               turnLeft( );
            }
            break;
         case 2:
            while(!facingSouth( ))
            {
               turnLeft( );
            }
            break;
         
         case 3:
            if(rightIsClear( ))
            {
               turnRight( );
            }
            break;
        
         case 4:
            while(!facingWest( ))
            {
               turnLeft( );
            }
            break;
         
         case 5:
            move( );
            break;
         
         case 6:
            while(!facingEast( ))
            {
               turnLeft( );
            }
            break;
         
         case 7:
            pegar( );
            break;
        
         case 8:
            while(!facingNorth( ))
            {
               turnLeft( );
            }
            break;
         
         case 9:
            colocar( );
            break;
         
         default:
            IO.println("ERRO: Comando inválido!");
      }
   }
   
   public void guardar( String filename )
   {
      int option;
      
      FILE arquivo = new FILE( FILE.OUTPUT, filename );
      
      IO.println ( "Objetivo: Pegar o beeper!" );
      IO.println ( );
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
         option = IO.readint( );
         
         if( 0 <= option && option <= 9 )
         {
            comandos( option );
            
            arquivo.println(""+option);
         }
      }
      while( option != 0 );
      arquivo.close( );
   }
   
   public void ler( String filename )
   {
      int option, contador = 0;
      
      FILE arquivo = new FILE( FILE.INPUT, filename );
      
      String line;
      
      line = arquivo.readln( );
      while( !arquivo.eof( ))
      {
         option = IO.getint( line );
         comandos( option );
         line = arquivo.readln( );
         contador = contador + 1;
      }
      arquivo.close( );
      IO.println( "Números de linhas no arquivo: "+contador );
   }
   
   public static void main ( String []args )
   {
      int opcao;
      
      createWorld( "GuiaE1.txt" );
      World.reset( );
      World.setSpeed( 7 );
      World.readWorld( "GuiaE1.txt" );
      GuiaE1 JK = new GuiaE1( 1, 1, EAST, 0 );
      
      do
      {
         
         opcao = IO.readint( " Digite 0: Para parar o programa!"+"\n"+
                          " Digite 1: Para excutar ações e salvar!"+"\n"+
                          " Digite 2: Para ler o arquivo salvo!");
         
         if ( opcao == 1 )
         {
            JK.guardar( "TarefaE1.txt" );
         }
         else if ( opcao == 2 )
         {
            JK.ler( "TarefaE1.txt" );
         }
         else if ( opcao > 2 || opcao < 0 )
         {
            IO.println( "ERROR:Opcão inválida!" );
         }
         else if ( opcao == 0 )
         {
            IO.pause( "Fim do Programa!" );
         }
      }
      while( opcao != 0 );
   }
}