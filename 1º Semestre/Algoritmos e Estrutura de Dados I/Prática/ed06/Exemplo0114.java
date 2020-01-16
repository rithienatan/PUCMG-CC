/**
 * Estudo Dirigido 0114
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version 114
*

*/

import IO.*;

public class Exemplo0114
{
   public static void metodo09( int n )
   {
      if( n > 1 )
      {
         IO.println( "1"+"/"+( Math.pow( 5, n-1 )) );
         metodo09( n - 1 );
      }
      else
      {
         IO.println( "1" );
      }
   }
   
   public static void main ( String [] args )
   {
      int n;
      n = IO.readint( "Digite uma quantidade: " );    
      metodo09( n );
   }
}