/**
 * Estudo Dirigido 0140
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0140
*/

import IO.*;

public class Exemplo0140
{
   public static int funcao05( String cadeia )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "Metodo10.txt" );
      int soma = 0;
      int x = cadeia.length( );
      int posicao;
      
      arquivo.println( "Cadeia: "+cadeia );
      
      for( posicao = 0; posicao < x; posicao = posicao + 1 )
      {
         if( cadeia.charAt( posicao ) >= '0' && cadeia.charAt( posicao ) <= '9')
         {
            IO.println( ""+cadeia.charAt( posicao ));
            arquivo.println( ""+cadeia.charAt( posicao ) );
            soma = soma + 1;
         }
      }
      arquivo.println( "Quantidade de digitos: "+soma );
      arquivo.close( );
      IO.pause( "\n"+"Aperte ENTER para terminar..." );
      return( soma );
   }
   
   public static void metodo10( )
   {
      String n = IO.readString( "Digite uma cadeia de caracter: " );
      int x = n.length( );
   
      if( !( x < 0 ))
      {
         IO.println( "Quantidade de digitos: "+funcao05( n ));
      }        
   }
   
   public static void main ( String [] args )
   {
      metodo10( );
   }
}