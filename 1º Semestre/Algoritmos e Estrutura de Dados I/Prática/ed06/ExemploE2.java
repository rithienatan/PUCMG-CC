/**
 * Estudo Dirigido E2
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version E2
*

*/

import IO.*;

public class ExemploE2
{
  public static double funcao05( int x )
   {
      double soma = 0;
      if( x > 1 )
      {
         soma = 1.0/(x-1) + funcao05( x - 1 );
         IO.print( " + 1/"+ (x-1) );
      }
      else
      {
         IO.print( "1" );
         soma = 1.0;
      }
      return ( soma );
   }
   
   public static void main ( String [] args )
   {
      int n;
      n = IO.readint( "Digite uma quantidade: " );  
      IO.println( " = " + funcao05( n ));
   }
}