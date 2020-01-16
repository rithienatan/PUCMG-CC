/**
 * Estudo Dirigido 0115
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version 115
*

*/

import IO.*;

public class Exemplo0115
{
   public static void metodo10( String n, int x )
   {
      if( 0 <= x && x < n.length( ))
      {
         IO.println( ""+n.charAt(x));
         metodo10( n, x+1 );
      }
   }
   
   public static void main ( String [] args )
   {
      String n;
      n = IO.readString( "Digite uma cadeia de caracter: " );  
      metodo10( n, 0 );
   }
}