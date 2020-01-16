/**
 * Estudo Dirigido 0076
 *
 * Trabalho Pratico: ED 04
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 76
*/

import IO.*;

public class Exemplo0076
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
   
   public static boolean maiuscula ( char simbolo )
   {
      boolean resposta = false;
      
      if( simbolo >= 'A' && simbolo <= 'Z' )
      {
         resposta = true;
      }
   
      return ( resposta );
   }
   
   public static int contador_maiuscula( String cadeia )
   {
      int resposta = 0;
      int tamanho;
      int posicao;
      
      tamanho = cadeia.length( );
      
      for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
      {
         if( maiuscula( cadeia.charAt( posicao )))
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
      String maiuscula = "";
      int contador_m = 0;
      int contador_M = 0;
      
      palavra = IO.readString( "Escreva uma cadeia de caracter: " );
      
      quant = palavra.length( );
      
      for( posicao = 0; posicao < quant; posicao = posicao + 1 )
      {     
         if( minuscula( palavra.charAt( posicao )))
         {
            minuscula = minuscula + palavra.charAt( posicao );
         }
         else if( maiuscula( palavra.charAt( posicao )))
         {
            maiuscula = maiuscula + palavra.charAt( posicao );
         }
      }
      
      contador_m = contador_minuscula( palavra );
      contador_M = contador_maiuscula( palavra );
      
      IO.println( "Letras minusculas: "+ minuscula );
      IO.println( "Quantidade de letras minúsculas: "+ contador_m );
      IO.println( "Letras maiúsculas: "+ maiuscula );
      IO.println( "Quantidade de letras maiúsculas: "+ contador_M );
   }
   
   public static void main ( String []args )
   {
      mostrar_minuscula( );
   }
}