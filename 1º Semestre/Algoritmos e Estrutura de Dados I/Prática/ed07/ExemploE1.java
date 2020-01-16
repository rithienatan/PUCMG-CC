/**
 * Estudo Dirigido E1
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version E1
*/

import IO.*;

public class ExemploE1
{   
   public static void metodoE1( )
   {
      FILE arquivo = new FILE ( FILE.OUTPUT, "MetodoE1.txt" );
      int n = IO.readint( "Digite um número: " );
      int x = n;
      int y = ((-1)*n);
      
      arquivo.println( "Número digitado: "+n );
      
      if( n > 0 )
      {
         while( x >= y )
         {
            if( !( x == 0) )
            {
               if( n % x == 0 )
               {
                  IO.println( "Divisores: "+( x ) );
                  arquivo.println( "Divisores: "+x );
               }
               x = x - 1;
            }
            else
            {
               x = x - 1;
            }
         }
      }
      else if( n < 0 )
      {
         while( x <= y )
         {
            if( !( x == 0 ) )
            {   
               if( n % x == 0 )
               {
                  IO.println( "Divisores: "+( -x ) );
                  arquivo.println( "Divisores: "+( -x ) );
               }
               x = x + 1;
            }
            else
            {
               x = x + 1;
            }
         }
      }
      arquivo.close( );
      IO.pause( "\n"+"Aperte ENTER para terminar..." );       
   }
   
   public static void main ( String [] args )
   {
      metodoE1( );
   }
}