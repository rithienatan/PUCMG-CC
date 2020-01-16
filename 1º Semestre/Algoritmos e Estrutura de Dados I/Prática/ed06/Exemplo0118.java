/**
 * Estudo Dirigido 0118
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version 118
*

*/

import IO.*;

public class Exemplo0118
{
   public static int funcao07( int x )
   {
      int soma = 0;
      if( x == 1 || x == 2 )
      {
         soma = 1;
      }
      else
      {
         if( x > 1 )
         {
            soma = funcao07( x-1 ) + funcao07( x-2 );
         }
      }
      if ( soma % 2 == 0 )
      {
         IO.println( ""+soma );
      }
      else
      {
         IO.println( "\n" );
      }
      return ( soma );
   }
   
   public static void main ( String [] args )
   {
      int n;
      n = IO.readint( "Digite uma quantidade: " );  
      IO.println( "Fibonacci par = "+funcao07( n ));
   }
}