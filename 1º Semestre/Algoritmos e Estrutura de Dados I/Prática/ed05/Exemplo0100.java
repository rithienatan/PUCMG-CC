/**
 * Estudo Dirigido 0100
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 100
*/

import IO.*;

public class Exemplo0100
{
   public static double metodo20( int n )
   {
      double soma = 0;
      int y = 1, a = 1;
      
      while( y <= n )
      {
         IO.println( ""+a+"/"+y );
         soma = soma + 1.0 * a / y;
         y = y + 1;
      }
      
      return( soma );
   }
   
   public static void main ( String [] args )
   {
      int n;
      double soma = 0;
 
      n = IO.readint( "Digite uma quantidade: " );
      
      soma = metodo20( n );
      
      IO.println( "Soma: " + soma);
   }
}