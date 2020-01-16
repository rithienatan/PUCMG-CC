/**
 * Estudo Dirigido 0095
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 95
*/

import IO.*;

public class Exemplo0095
{
   public static void metodo15( int n )
   {
      int y = 1;
 
         IO.println( "1" );
         
         while( y < n )
         {
            IO.println( "1"+"/"+ Math.pow( 3, y ));
            
            y = y + 1;
         }
   }
   
   public static void main ( String [] args )
   {
      int n;
      
      n = IO.readint( "Digite uma quantidade: " );
      
      metodo15( n );
   }
}