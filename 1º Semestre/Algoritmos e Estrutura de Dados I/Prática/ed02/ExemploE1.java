/**
 * Estudo Dirigido E1
 *
 * Trabalho Pratico: ED 02
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version E1
*/

import IO.*;

public class ExemploE1
{
   public static void main( String [] args )
   {
      int x;
      double y, z;
      
      x = IO.readint( "Digite uma quantidade: " );
         
      while( x > 0 )
      {
         y = IO.readdouble( "Digite o primeiro número: " );
         z = IO.readdouble( "Digite o segundo número: " );
            
         if( ( y <= 25 && y >= -25 ) && ( z <= 25 && z >= -25 ) )
         {
            if( y < z )
            {
               IO.println( "y: "+ y );
               IO.println( "z: "+ z );
            }
         }
            
         x = x - 1;
      }
   }
}