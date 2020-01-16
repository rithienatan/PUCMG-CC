/**
 * Estudo Dirigido 0053
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 53
*/

import IO.*;

public class Exemplo0053
{
   public static void metodo08( )
   {
      int x;
      double y;
      
      x = IO.readint( "Quantos números você que escrever: " );
      while( x > 0 )
      {
         y = IO.readdouble( "Digite um número: " );
         
         if ( y >= 25 && y <= 125 )
         {
            if( y % 2 != 0 )
            {
               IO.println( "Y = " + y );
            }
         }
         
         x = x - 1;
      }
   }
   
   public static void main ( String [] args )
   {
      metodo08( );
   }
}