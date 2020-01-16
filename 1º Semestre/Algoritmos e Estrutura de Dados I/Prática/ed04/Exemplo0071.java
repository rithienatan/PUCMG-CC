/**
 * Estudo Dirigido 0071
 *
 * Trabalho Pratico: ED 04
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 71
*/

import IO.*;

public class Exemplo0071
{
   public static void mostrar_minuscula ( )
   {
      String palavra;
      int quant;
      int posicao;
      String minuscula = "";
      char mini;
      
      palavra = IO.readString( "Escreva uma cadeia de caracter: " );
      
      quant = palavra.length( );
      
      for( posicao = 0; posicao < quant; posicao = posicao + 1 )
      {
         mini = palavra.charAt( posicao );
         
         if( mini >= 'a' && mini <= 'z' )
         {
            minuscula = minuscula + mini;
         } 
      }
      
      IO.println( "Letras minusculas: "+ minuscula ); 
   }
   
   public static void main ( String []args )
   {
      mostrar_minuscula( );
   }
}