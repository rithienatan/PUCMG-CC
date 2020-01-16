/**
 * Estudo Dirigido 0035
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 *
 *@version 0035
*/

import IO.*;

public class Exemplo0035
{
   public static void main( String [] args )
   {
      int x, y, z;
      
      x = IO.readint( "Digite uma quantidade: " );
         
      while( x > 0 )
      {
         y = IO.readint( "Digite o primeiro número: " );
         z = IO.readint( "Digite o segundo número: " );
            
         if((y % 2 != 0) && (z % 2 == 0))
         {
            IO.println( "y: "+ y );
            IO.println( "z: "+ z );
         }
            
         x = x - 1;
      }
   }
}