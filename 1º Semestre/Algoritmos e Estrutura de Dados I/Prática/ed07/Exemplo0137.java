/**
 * Estudo Dirigido 0137
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0137
*/

import IO.*;

public class Exemplo0137
{
   public static double funcao02( int n )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "Metodo07.txt" );
      double soma = 0;
      int x;
            
      arquivo.println( ""+n );
      
      for( x = 1; x <= n; x = x + 1 )
      {
         IO.println( "1"+"/"+(x*3) );
         arquivo.println( "1"+"/"+(x*3) );
         soma = soma + 1.0/( x*3 );
      }
      
      arquivo.println( ""+soma );
      
      arquivo.close( );
      
      IO.pause( "\n"+"Aperte ENTER para continuar...." );
      return( soma );
   }
   
   public static void metodo07( )
   {
      int n = IO.readint( "Digite uma quantidade: " );
      
      if( !( n < 0 ))
      {
         IO.println( "Soma = "+funcao02( n ) );
      }      
   }
   
   public static void main ( String [] args )
   {
      metodo07( );
   }
}