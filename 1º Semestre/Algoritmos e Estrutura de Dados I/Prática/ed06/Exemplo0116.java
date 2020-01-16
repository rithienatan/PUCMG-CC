/**
 * Estudo Dirigido 0116
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version 116
*

*/

import IO.*;

public class Exemplo0116
{
   public static int funcao05( int x )
   {
      int soma = 0;
      if( x > 1 )
      {
         soma = (2*x) + funcao05( x - 1 );
         IO.print( " + "+ (2*x) );
      }
      else
      {
         IO.print( "2" );
         soma = 2;
      }
      return ( soma );
   }
   
   public static void main ( String [] args )
   {
      int n;
      n = IO.readint( "Digite uma quantidade: " );  
      IO.println( " = "+funcao05( n ));
   }
}