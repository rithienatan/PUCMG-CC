/**
 * Estudo Dirigido E1
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version E1
*

*/

import IO.*;

public class ExemploE1
{
  public static double E1( int n, int x )
   {
      double soma = 0;
      
      if( n > 1 && x > 0 )
      {
         soma = Math.pow( n-1, x-1 ) + E1( n-1, x-1 );
         IO.print( " + "+(n-1)+"^"+(x-1));
      }
      else
      {
         soma = 1.0;
         IO.print( "1" );
      }
      return ( soma );
   } 

   
   public static void main ( String [] args )
   {
      int n, x;
      n = IO.readint( "Digite um número: " );  
      x = IO.readint( "Digite outro número: " );
      IO.println( " = " + E1( n, x ));
   }
}