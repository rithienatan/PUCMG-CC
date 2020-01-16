/**
 * Estudo Dirigido E1
 *
 * Trabalho Pratico: ED 04
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version E1
*/

import IO.*;

public class ExemploE1
{
   public static boolean digitos ( char simbolo )
   {
      boolean resposta = false;  
      
      if( simbolo >= '0' && simbolo <= '9' )
      {
         resposta = true;
      }
      
      return ( resposta );
   }
   
   public static int contador_digitos ( String cadeia )
   {
      int resposta = 0;
      int tamanho;
      int posicao;
      
      tamanho = cadeia.length( );
      
      for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
      {
         if( digitos( cadeia.charAt( posicao )))
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
   
   public static int quantidade( String cadeia )
   {
      int resposta = 0;
      int tamanho;
      int posicao;
      
      tamanho = cadeia.length( );
      
      if( tamanho == 1 )
      {
         resposta = tamanho - 1;
      }
      else
      {
         resposta = tamanho;
      }
      return ( resposta );
   }
   
   public static void mostrar ( )
   {
      String palavra;
      int quant;
      int posicao;
      String letras = "";
            
      palavra = IO.readString( "Escreva uma cadeia de caracter: " );
      
      quant = quantidade( palavra );
      
      for( posicao = 1; posicao < quant; posicao = posicao + 1 )
      {     
          letras = letras + palavra.charAt( posicao );
      }      
      IO.println( "Caracteres sem o primeiro: "+ letras );       
   }
   
   public static void main ( String []args )
   {
      mostrar( );
   }
}