/**
 * Estudo Dirigido E1
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version E1
*/

import IO.*;

public class ExemploE1
{
   public static int metodoE1( int n )
   {
      int soma = 1;
      int y = 1;
      
      while( n >= y )
      {
         IO.println( ""+n );
         soma = soma * n;
         n = n - 1;
      }   
      return( soma );
   }
   
   public static void main ( String [] args )
   {
      int n;
      int soma = 0;
 
      n = IO.readint( "Digite uma quantidade: " );
      
      soma = metodoE1( n );
      
      IO.println( "Fatorial: " + soma);
   }
}