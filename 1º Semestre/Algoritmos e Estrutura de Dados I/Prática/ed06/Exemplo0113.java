/**
 * Estudo Dirigido 0113
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version 113
*

*/

import IO.*;

public class Exemplo0113
{
   public static void metodo08( int n )
   {
      if( n > 0 )
      {
         metodo08( n - 1 );
         IO.println( ""+( 5*n ) );
      }
   }
   
   public static void main ( String [] args )
   {
      int n;
      n = IO.readint( "Digite uma quantidade: " );
      
      metodo08( n );
   }
}