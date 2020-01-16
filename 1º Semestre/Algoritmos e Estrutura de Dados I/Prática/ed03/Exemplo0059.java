/**
 * Estudo Dirigido 0059
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 59
*/

import IO.*;

public class Exemplo0059
{
   public static void metodo14( )
   {
      int x;
      char y ;
      
      x = IO.readint( "Quantos números você que escrever: " );
      while( x > 0 )
      {
         y = IO.readchar( "Digite uma letra: " );
         
         if ( (y >= 'a' && y <= 'z') || (y >= 'A' && y <= 'Z'))
         {
            IO.println( "Letras = " + y );
         }
         
         x = x - 1;
      }
   }
   
   public static void main ( String [] args )
   {
      metodo14( );
   }
}