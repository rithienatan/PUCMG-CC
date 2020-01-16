/**
 * Estudo Dirigido 0072
 *
 * Trabalho Pratico: ED 04
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 72
*/

import IO.*;

public class Exemplo0072
{
   public static void mostrar_minuscula ( )
   {
      String palavra;
      int quant;
      int posicao;
      String minuscula = "";
      char mini;
      int contador = 0;
      
      palavra = IO.readString( "Escreva uma cadeia de caracter: " );
      
      quant = palavra.length( );
      
      for( posicao = 0; posicao < quant; posicao = posicao + 1 )
      {
         mini = palavra.charAt( posicao );
         
         if( mini >= 'a' && mini <= 'z' )
         {
            minuscula = minuscula + mini;
            contador = contador + 1;
         } 
      }
      
      IO.println( "Letras minusculas: "+ minuscula );
      IO.println( "Quantidade de letras minúsculas: "+ contador ); 
   }
   
   public static void main ( String []args )
   {
      mostrar_minuscula( );
   }
}