/**
 * Estudo Dirigido 0096
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 96
*/

import IO.*;

public class Exemplo0096
{
   public static int metodo16( int n )
   {
      int y = 1, a = 3;
      int soma = 0;
         
         while( y <= n )
         {
            if(!( a % 5 == 0) && a >= 3 )
            {
               IO.println( ""+a );
               y = y + 1;
               soma = soma + a;
            }
            a = a + 2;
         }
      return ( soma );
   }
   
   public static void main ( String [] args )
   {
      int n, soma = 0;
      
      n = IO.readint( "Digite uma quantidade: " );
      
      soma = metodo16( n );
      
      IO.println( "Soma: " + soma);
   }
}