/**
 * Estudo Dirigido 0120
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version 120
*

*/

import IO.*;

public class Exemplo0120
{
  public static int funcao10( String n, int x )
   {
      int soma = 0;
      
      if ( 0 <= x && x < n.length( ) )
      {
         if ( n.charAt (x) >= '0' && n.charAt (x) <= '9' )
         {
            soma = 1;
         } 
         soma = soma + funcao10 ( n, x+1 );
      }
      return ( soma );
   } 

   
   public static void main ( String [] args )
   {
      String n;
      n = IO.readString( "Escreva uma cadeia de caracter: " );  
      IO.println("Quantidade de digitos: "+funcao10( n, 0 ));
   }
}