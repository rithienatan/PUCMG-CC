/**
 * Estudo Dirigido 0119
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version 119
*

*/

import IO.*;

public class Exemplo0119
{
   public static int funcao09( String n, int x )
   {
      int soma = 0;
      
      if ( 0 <= x && x < n.length( ) )
      {
         if ( n.charAt (x) >= 'A' && n.charAt (x) <= 'Z' )
         {
            soma = 1;
         } 
         soma = soma + funcao09 ( n, x+1 );
      }
      return ( soma );
   } 
   
   public static void main ( String [] args )
   {
      String n;
      n = IO.readString( "Digite uma cadeia de caracter: " );  
      IO.println("Quantidade de maiúsculas: "+funcao09( n, 0 ));
   }
}