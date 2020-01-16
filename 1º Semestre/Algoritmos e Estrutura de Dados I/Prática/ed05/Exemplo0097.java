/**
 * Estudo Dirigido 0097
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 97
*/

import IO.*;

public class Exemplo0097
{
   public static double metodo17( int n )
   {
      int y = 1, denominador = 3, numerador = 1;
      double soma = 0;
         
         while( y <= n )
         {
            if(!( denominador % 5 == 0) && denominador >= 3 )
            {
               IO.println(""+ numerador+ "/"+denominador);
               y = y + 1;
               soma = soma + 1.0 * numerador / denominador;
            }
            denominador = denominador + 2;
         }
      return ( soma );
   }
   
   public static void main ( String [] args )
   {
      int n;
      double soma = 0;
      
      n = IO.readint( "Digite uma quantidade: " );
      
      soma = metodo17( n );
      
      IO.println( "Soma: " + soma);
   }
}