/**
 * Estudo Dirigido 0092
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 92
*/

import IO.*;

public class Exemplo0092
{
   public static void metodo12( int n )
   {
      int y = 1, z = 3;
 
         while( y <= n )
         {
            if( z % 2 != 0 )
            {
               IO.println( "N = " + z );
               
               y = y + 1;
            }
            
            z = z + 3;
         }
   }
   
   public static void main ( String [] args )
   {
      int n;
      
      n = IO.readint( "Digite uma quantidade: " );
      
      metodo12( n );
   }
}