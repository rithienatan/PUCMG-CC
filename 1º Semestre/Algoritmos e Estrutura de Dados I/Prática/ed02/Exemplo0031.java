/**
 * Estudo Dirigido 0031
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 *
 *@version 0031
*/

import IO.*;

public class Exemplo0031
{
   public static void main( String [] args )
   {
      int x, y;
      
      x = IO.readint( "Digite uma quantidade: " );
         
      while( x > 0 )
      {
         y = IO.readint( "Digite um número: " );
            
         if( y > 0 )
         {
            IO.println( "Positivo: "+ y );
         }
         else if ( y < 0 )
         {
            IO.println( "Negativo: "+ y );
         }
         else
         {
            IO.println( "Número neutro: " + y );
         }
            
         x = x - 1;
      }
   }
}