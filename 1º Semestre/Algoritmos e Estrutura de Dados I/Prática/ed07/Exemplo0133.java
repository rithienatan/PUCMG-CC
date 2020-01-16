/**
 * Estudo Dirigido 0133
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0133
*/

import IO.*;

public class Exemplo0133
{
   public static void metodo03( )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "Metodo03.txt" );
      int x;
      int n = IO.readint( "Digite uma quantidade: " );
      
      IO.print( " 1" );
      arquivo.print( " 1" );
      
      if( !(n < 0) )
      {
         for( x = 1; x < n; x = x + 1 )
         {
            IO.print( " "+ (x*3) );
            arquivo.print( " "+(x*3) );
         }
      }
      arquivo.close( );
      IO.pause( "\n"+"Aperte ENTER para continuar...." );
   }
   
   public static void main ( String [] args )
   {
      metodo03( );
   }
}