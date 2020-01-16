/**
 * Estudo Dirigido 0078
 *
 * Trabalho Pratico: ED 04
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 78
*/

import IO.*;

public class Exemplo0078
{
   public static boolean digitos_impares ( char simbolo )
   {
      boolean resposta = false;
      int x;   
      
      if( simbolo >= '0' && simbolo <= '9' )
      {
         x = (int)simbolo;
         if( x % 2 != 0 )
         {
            resposta = true;
         }
      }
      
      return ( resposta );
   }
   
   public static int contador_digitos_impares ( String cadeia )
   {
      int resposta = 0;
      int tamanho;
      int posicao;
      
      tamanho = cadeia.length( );
      
      for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
      {
         if( digitos_impares( cadeia.charAt( posicao )))
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
            
      palavra = IO.readString( "Escreva uma cadeia de caracter com algarismos: " );
      
      quant = palavra.length( );
      
      for( posicao = 0; posicao < quant; posicao = posicao + 1 )
      {     
         /*if( letras( palavra.charAt( posicao )))
         {
            letras = letras + palavra.charAt( posicao );
         }*/
         if( digitos_impares( palavra.charAt( posicao )))
         {
            algarismos = algarismos + palavra.charAt( posicao );
         }
      }
      contador_a = contador_digitos_impares( palavra );
      //contador_l = contador_letras( palavra );
      
      //IO.println( "Letras: "+ letras );
      //IO.println( "Quantidade de letras: "+ contador_l );
      //IO.println( "Letras maiúsculas: "+ maiuscula );
      //IO.println( "Quantidade de letras maiúsculas: "+ contador_M );
      
      IO.println( "Digitos: "+algarismos );
      IO.println( "Quantos Digitos: "+contador_a );
   }
   
   public static void main ( String []args )
   {
      mostrar( );
   }
}