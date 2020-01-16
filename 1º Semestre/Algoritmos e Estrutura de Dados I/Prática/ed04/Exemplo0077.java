/**
 * Estudo Dirigido 0077
 *
 * Trabalho Pratico: ED 04
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 77
*/

import IO.*;

public class Exemplo0077
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
   
   public static boolean letras ( char simbolo )
   {
      boolean resposta = false;
      
      if( (simbolo >= 'A' && simbolo <= 'Z') || (simbolo >= 'a' && simbolo <= 'z') )
      {
         resposta = true;
      }
   
      return ( resposta );
   }
   
   public static int contador_letras( String cadeia )
   {
      int resposta = 0;
      int tamanho;
      int posicao;
      
      tamanho = cadeia.length( );
      
      for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
      {
         if( letras( cadeia.charAt( posicao )))
         {
            resposta = resposta + 1;
         }
      }
   
      return ( resposta );
   }
   
   public static void mostrar ( )
   {
      String palavra;
      int quant;
      int posicao;
      //String letras = "";
      //int contador_l = 0;
      String algarismos = "";
      int contador_a = 0;
      char c;
            
      palavra = IO.readString( "Escreva uma cadeia de caracter com algarismos: " );
      
      quant = palavra.length( );
      
      for( posicao = 0; posicao < quant; posicao = posicao + 1 )
      {     
         /*if( letras( palavra.charAt( posicao )))
         {
            letras = letras + palavra.charAt( posicao );
         }*/
         c = palavra.charAt( posicao );
         
         if( c >= '0' && c <= '9' )
         {
            algarismos = algarismos + c;
         }
      }
      
      //contador_l = contador_letras( palavra );
      
      //IO.println( "Letras: "+ letras );
      //IO.println( "Quantidade de letras: "+ contador_l );
      //IO.println( "Letras maiúsculas: "+ maiuscula );
      //IO.println( "Quantidade de letras maiúsculas: "+ contador_M );
      
      IO.println( "Digitos: "+algarismos );
   }
   
   public static void main ( String []args )
   {
      mostrar( );
   }
}