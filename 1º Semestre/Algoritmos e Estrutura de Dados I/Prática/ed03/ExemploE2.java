/**
 * Estudo Dirigido E2
 *
 * Trabalho Pratico: ED 03
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version E2
*/

import IO.*;

public class ExemploE2
{
   public static void metodo17( )
   {
      int x;
      String y;
      int quant;
      char a;
      int j;
      
      x = IO.readint( "Quantidade de coisas que você quer escrever: " );
      while( x > 0 )
      {
         y = IO.readString( "Digite uma cadeia de caracter: " );
         
         quant = y.length( );
         
         for( j = 0; j < quant; j = j + 1 )
         {
            a = y.charAt( j );
            
            if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z'))
            {  
               IO.println( "Letra: " + a );
            }
            else
            {
               IO.println( "Algarismo: " + a );
            }
         }
         x = x - 1;
      }
   }
   
   public static void main ( String [] args )
   {
      metodo17( );
   }
}