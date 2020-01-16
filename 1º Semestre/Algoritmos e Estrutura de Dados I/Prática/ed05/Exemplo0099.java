/**
 * Estudo Dirigido 0099
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 99
*/

import IO.*;

public class Exemplo0099
{
   public static double metodo19( int n )
   {
      double soma = 0;
      int y = 1;
      
      while( y <= n )
      {
         IO.println( ""+y );
         soma = soma + Math.pow( y, 2 );
         y = y + 1;
      }
      
      return( soma );
   }
   
   public static void main ( String [] args )
   {
      int n;
      double soma = 0;
 
      n = IO.readint( "Digite uma quantidade: " );
      
      soma = metodo19( n );
      
      IO.println( "Soma: " + soma);
   }
}