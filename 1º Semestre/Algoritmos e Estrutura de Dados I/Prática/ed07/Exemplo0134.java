/**
 * Estudo Dirigido 0134
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0134
*/

import IO.*;

public class Exemplo0134
{
   public static void metodo04( )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "Metodo04.txt" );
      int x;
      int n = IO.readint( "Digite uma quantidade: " );
      
      if( !(n < 0) )
      {
         while( n > 1 )
         {
            IO.print( " "+(n)+"/"+""+((int)Math.pow( 3, n - 1 )) );
            arquivo.print( " "+(n)+"/"+""+((int)Math.pow( 3, n - 1 )));
            n = n - 1;
         }
      }  
      
      IO.print( " 1" );
      arquivo.print( " 1" );
      
      arquivo.close( );
      IO.pause( "\n"+"Aperte ENTER para continuar...." );
   }
   
   public static void main ( String [] args )
   {
      metodo04( );
   }
}