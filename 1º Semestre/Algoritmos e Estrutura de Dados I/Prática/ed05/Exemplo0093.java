/**
 * Estudo Dirigido 0093
 *
 * Trabalho Pratico: ED 05
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 93
*/

import IO.*;

public class Exemplo0093
{
   public static void metodo13( int n )
   {
      int y = 1, z = 3;
 
         while( y <= n )
         {
            if( z % 2 == 0 )
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
      
      metodo13( n );
   }
}