/**
 * Estudo Dirigido 0052
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 52
*/

import IO.*;

public class Exemplo0052
{
   public static void metodo07( )
   {
      int x, y;
      
      x = IO.readint( "Quantos números você que escrever: " );
      while( x > 0 )
      {
         y = IO.readint( "Digite um número: " );
         
         if ( y % 2 != 0 && y < 100 )
         {
            IO.println( "Y = " + y );
         }
         
         x = x - 1;
      }
   }
   
   public static void main ( String [] args )
   {
      metodo07( );
   }
}