/**
 * Estudo Dirigido 0132
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0132
*/

import IO.*;

public class Exemplo0132
{
   public static void metodo02( )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "Metodo02.txt" );
      int x = 1;
      int n = IO.readint( "Digite uma quantidade: " );
      
      if( !(n < 0) )
      {
         while( x <= n )
         {
            IO.println( "n: "+(x*3) );
            arquivo.println( ""+(x*3) );
            x = x + 1;
         }
      }
      arquivo.close( );
      IO.pause( "Aperte ENTER para continuar...." );
   }
   
   public static void main ( String [] args )
   {
      metodo02( );
   }
}