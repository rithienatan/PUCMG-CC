/**
 * Estudo Dirigido 0058
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 58
*/

import IO.*;

public class Exemplo0058
{
   public static void metodo13( )
   {
      int x;
      char y ;
      
      x = IO.readint( "Quantos números você que escrever: " );
      while( x > 0 )
      {
         y = IO.readchar( "Digite um algarismo: " );
         
         if ( y >= '0' && y <= '9' )
         {
            IO.println( "Algarismo = " + y );
         }
         
         x = x - 1;
      }
   }
   
   public static void main ( String [] args )
   {
      metodo13( );
   }
}