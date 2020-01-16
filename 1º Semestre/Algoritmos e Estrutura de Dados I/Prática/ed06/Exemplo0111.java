/**
 * Estudo Dirigido 0111
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version 111
*

*/

import IO.*;

public class Exemplo0111
{
   public static void metodo06( int n )
   {
      if( n > 0 )
      {
         metodo06( n - 1 );
         IO.println( ""+ ( 2*n+3 ) );
      }
   }
   
   public static void main ( String [] args )
   {
      int n;
      n = IO.readint( "Digite uma quantidade: " );
      
      metodo06( n );
   }
}