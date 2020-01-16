/**
 * Estudo Dirigido E2
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version E2
*/

import IO.*;

public class ExemploE2
{
   public static double metodoE2( int n )
   {
      double soma = 0;
      int y = 1, numerador = 1, denominador = 1;
      
      for( y = 1; y <= n; y = y + 1 )
      {
         IO.println( ""+numerador+"/"+denominador );
         soma = soma + (1 + numerador / denominador);
         numerador = y * 2;
         denominador = denominador + 2;
      }   
      return( soma );
   }
   
   public static void main ( String [] args )
   {
      int n;
      double soma = 0;
 
      n = IO.readint( "Digite uma quantidade: " );
      
      soma = metodoE2( n );
      
      IO.println( "Função: " + soma);
   }
}