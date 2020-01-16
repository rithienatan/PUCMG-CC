/**
 * Estudo Dirigido 0112
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version 112
*

*/

import IO.*;

public class Exemplo0112
{
   public static void metodo07( int n )
   {
      if( n > 0 )
      {
         IO.println( ""+ ( 5*n ) );
         metodo07( n - 1 );
      }
   }
   
   public static void main ( String [] args )
   {
      int n;
      n = IO.readint( "Digite uma quantidade: " );
      
      metodo07( n );
   }
}