/**
 * Estudo Dirigido 0139
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0139
*/

import IO.*;

public class Exemplo0139
{
   public static int funcao04( String cadeia )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "Metodo09.txt" );
      int soma = 0;
      int x = cadeia.length( );
      int posicao;
      
      arquivo.println( "Cadeia: "+cadeia );
      
      for( posicao = 0; posicao < x; posicao = posicao + 1 )
      {
         if( cadeia.charAt( posicao ) >= 'a' && cadeia.charAt( posicao ) <= 'z')
         {
            IO.println( ""+cadeia.charAt( posicao ));
            arquivo.println( ""+cadeia.charAt( posicao ) );
            soma = soma + 1;
         }
      }
      arquivo.println( "Quantidade de letras minusculas: "+soma );
      arquivo.close( );
      IO.pause( "\n"+"Aperte ENTER para terminar..." );
      return( soma );
   }
   
   public static void metodo09( )
   {
      String n = IO.readString( "Digite uma cadeia de caracter: " );
      int x = n.length( );

      if( !( x < 0 ))
      {
         IO.println( "Quantidade de letras minusculas: "+funcao04( n ));
      }        
   }
   
   public static void main ( String [] args )
   {
      metodo09( );
   }
}