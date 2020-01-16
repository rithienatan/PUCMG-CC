/**
 * Estudo Dirigido 0136
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0136
*/

import IO.*;

public class Exemplo0136
{
   public static int funcao01( int n )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "Metodo06.txt" );
      int soma = 0, x;
      
      arquivo.println( ""+n );
      
      for( x = 1; x <= n; x = x + 1 )
      {
         IO.println( ""+(x*2) );
         arquivo.println( ""+(x*2) );
         soma = soma + ( x*2 );
      }
      
      arquivo.println( ""+soma );
      
      arquivo.close( );
      
      IO.pause( "\n"+"Aperte ENTER para continuar...." );
      return( soma );
   }
   
   public static void metodo06( )
   {
      int n = IO.readint( "Digite uma quantidade: " );
      
      if( !( n < 0 ) )
      {
         IO.println( "Soma = "+funcao01( n ) );
      }      
   }
   
   public static void main ( String [] args )
   {
      metodo06( );
   }
}