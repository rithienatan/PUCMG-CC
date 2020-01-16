/**
 * Estudo Dirigido E2
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version E2
*/

import IO.*;

public class ExemploE2
{   
   public static void metodoE222( )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "MetodoE2.txt" );
      String palavra;
      
      palavra = IO.readln( "" );
      
      while( ! palavra.equals( "PARAR" ) )
      {
         arquivo.println( ""+palavra );
         palavra = IO.readln( "" );
      }
      arquivo.close( );
   }
   
   public static void metodoE2( )
   {
      FILE arquivo = new FILE ( FILE.INPUT, "MetodoE2.txt" );
      String dado;
      int contador = 0;
      
      dado = arquivo.readln( );
      
      while( !arquivo.eof( ) )
      {
         if( dado.charAt( 0 ) == 'a' || dado.charAt( 0 ) == 'A' )
         {
            contador = contador + 1;
         }
         
         IO.println( ""+dado );
         dado = arquivo.readln( );
      }
      IO.println( "Quantidades de palavra que começam com a letra A( ou a ): "+contador );
      
      arquivo.close( );
      IO.pause( "\n"+"Aperte ENTER para terminar..." );   
   }
   
   public static void main ( String [] args )
   {
      int n;
      do
      {
         n = IO.readint( "1. Para digitar várias palavras!"+"\n"+
                          "2. Para ler o arquivo com as palavras que começam com A( ou a )!"+"\n"+
                          "0. Terminar o programa!"+"\n" );
         if( n == 1 )
         {
            metodoE222( );
         }
         else if( n == 2 )
         {
            metodoE2( );
         }
         else if( n == 0 )
         {
            IO.pause( "Fim do programa!" );
         }
         else if( n < 0 || n > 2 )
         {
            IO.println( "ERROR!Opção errada!" );
         }
      }
      while( n != 0 );
   }
}