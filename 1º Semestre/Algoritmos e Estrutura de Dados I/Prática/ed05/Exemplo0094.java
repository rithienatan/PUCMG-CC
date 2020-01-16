/**
 * Estudo Dirigido 0094
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 94
*/

import IO.*;

public class Exemplo0094
{
   public static void metodo14( int n )
   {
      int y = 1;
 
         IO.println( "1" );
         
         while( y < n )
         {
            IO.println( "1"+"/"+( y * 3 ));
            y = y + 1;
         }
   }
   
   public static void main ( String [] args )
   {
      int n;
      
      n = IO.readint( "Digite uma quantidade: " );
      
      metodo14( n );
   }
}