/**
 * Estudo Dirigido 0091
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 91
*/

import IO.*;

public class Exemplo0091
{
   public static void metodo11( int n )
   {
      int y;
      
      for ( y = 1; y <= n; y = y + 1 )
      {
         IO.println( "N = " + (y * 3 ) );
      }
   }
   
   public static void main ( String [] args )
   {
      int n;
      
      n = IO.readint( "Digite uma quantidade: " );
      
      metodo11( n );
   }
}