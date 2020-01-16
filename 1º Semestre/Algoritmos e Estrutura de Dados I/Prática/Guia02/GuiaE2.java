/**
 * Guia E2
 *
 * Trabalho Pratico: Guia 02
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version E2
*/
import IO.*;
import jkarel.Robot;
import jkarel.World;

public class GuiaE2 extends Robot
{
   public GuiaE2 ( int avenue, int street, int direction, int beepers )
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
   
   public void ler( String filename )
   {
      int option, contador = 0;
      
      FILE arquivo = new FILE( FILE.INPUT, filename );
      
      String line;
      
      line = arquivo.readln( );
      contador = IO.getint ( line );
      IO.println( "Números de linhas no arquivo: "+contador );
      while( !arquivo.eof( ))
      {
         line = arquivo.readln( );
         option = IO.getint( line );
         comandos( option );
      }
      arquivo.close( );
   }
   
   public static void main ( String []args )
   {
      int opcao;
      
      createWorld( "GuiaE2.txt" );
      World.reset( );
      World.setSpeed( 7 );
      World.readWorld( "GuiaE2.txt" );
      GuiaE2 JK = new GuiaE2( 1, 1, EAST, 0 );
      
      JK.ler( "TarefaE2.txt" );
   }
}