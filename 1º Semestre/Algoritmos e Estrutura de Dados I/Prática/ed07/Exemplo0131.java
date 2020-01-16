/**
 * Estudo Dirigido 0131
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0131
*/

import IO.*;

public class Exemplo0131
{
   public static void metodo01( )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "Metodo01.txt" );
      int x = 0;
      int n = IO.readint( "Digite uma quantidade: " );
      
      if( !(n < 0) )
      {
         while( n > 0 )
         {
            IO.println( "n: "+(n*2+1) );
            arquivo.println( ""+(n*2+1) );
            n = n - 1;
         }
      }
      arquivo.close( );
      IO.pause( "Aperte ENTER para continuar...." );
   }
   
   public static void main ( String [] args )
   {
      metodo01( );
   }
}