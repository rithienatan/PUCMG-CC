/**
 * Estudo Dirigido 0098
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 98
*/

import IO.*;

public class Exemplo0098
{
   public static int metodo18( int n )
   {
      int soma = 0;
      int y = 1;
      
      while( y <= n )
      {
         IO.println( ""+y );
         soma = soma + y;
         y = y + 1;
      }
      
      return( soma );
   }
   
   public static void main ( String [] args )
   {
      int n;
      int soma = 0;
 
      n = IO.readint( "Digite uma quantidade: " );
      
      soma = metodo18( n );
      
      IO.println( "Soma: " + soma);
   }
}