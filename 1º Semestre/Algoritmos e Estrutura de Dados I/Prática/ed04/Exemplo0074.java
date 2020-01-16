/**
 * Estudo Dirigido 0074
 *
 * Trabalho Pratico: ED 04
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 74
*/

import IO.*;

public class Exemplo0074
{
   public static boolean minuscula ( char simbolo )
   {
      boolean resposta = false;    
      
      if( simbolo >= 'a' && simbolo <= 'z' )
      {
         resposta = true;
      }
      
      return ( resposta );
   }
   
   public static int contador_minuscula ( String cadeia )
   {
      int resposta = 0;
      int tamanho;
      int posicao;
      
      tamanho = cadeia.length( );
      
      for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
      {
         if( minuscula( cadeia.charAt( posicao )))
         {
            resposta = resposta + 1;
         }
      }
   
      return ( resposta );
   }
   
   public static void mostrar_minuscula ( )
   {
      String palavra;
      int quant;
      int posicao;
      String minuscula = "";
      int contador = 0;
      
      palavra = IO.readString( "Escreva uma cadeia de caracter: " );
      
      quant = palavra.length( );
      
      for( posicao = 0; posicao < quant; posicao = posicao + 1 )
      {     
         if( minuscula( palavra.charAt( posicao )))
         {
            minuscula = minuscula + palavra.charAt( posicao );
         } 
      }
      
      contador = contador_minuscula( palavra );
      
      IO.println( "Letras minusculas: "+ minuscula );
      IO.println( "Quantidade de letras minúsculas: "+ contador ); 
   }
   
   public static void main ( String []args )
   {
      mostrar_minuscula( );
   }
}