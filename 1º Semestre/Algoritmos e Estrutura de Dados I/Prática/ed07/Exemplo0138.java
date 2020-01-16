/**
 * Estudo Dirigido 0138
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0138
*/

import IO.*;

public class Exemplo0138
{
   public static int funcao03( int n )
   {
      int soma = 0;
            
         if( n == 1 || n == 2 )
         {
            soma = 1;
         }
         else
         {
            if( n > 1 )
            {
               soma = funcao03( n - 1 ) + funcao03( n - 2 );
            }
         }
      
      return( soma );
   }
   
   public static void metodo08( )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "Metodo08.txt" );
      int n = IO.readint( "Digite uma quantidade: " );
      int x;
      
      arquivo.println( "Qunatidade: "+n );
      if( !( n < 0 ))
      {
         for( x = 1; x <= n; x = x + 1 )
         {
            IO.println( "Fibonnaci(par) = "+funcao03((x*2)) );
            arquivo.println( "Termo par: "+(x*2)+" --> "+funcao03((x*2)) ); 
         }
      }        
      arquivo.close( );
      IO.pause( "\n"+"Aperte ENTER para continuar...." );
   }
   
   public static void main ( String [] args )
   {
      metodo08( );
   }
}