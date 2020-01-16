/**
 * Estudo Dirigido E2
 *
 * Trabalho Pratico: ED 04
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version E2
*/

import IO.*;

public class ExemploE2
{   
   public static boolean part( int quantidade, int tudo )
   {
      boolean resposta = false;
      
      if( quantidade <= tudo && quantidade >= 0 )
      {
         resposta = true;
      }
      else
      {
         IO.println( "Tamanho impossível!" );
         resposta = false;
      }
      
      return ( resposta );
   }
   
   public static int contadores( String cadeia )
   {
      int resposta = 0;
      
      int tamanho = cadeia.length( );
      
      resposta = tamanho;
      
      return ( resposta );
   }
   
   public static void mostrar ( )
   {
      String palavra;
      int quant;
      int posicao;
      String letras = "";
      int partes;
                  
      palavra = IO.readString( "Escreva uma cadeia de caracter: " );
      
      partes = IO.readint( "Qual o tamanho da parte dessa cadeia de caracter você quer ver ?" );
      
      quant = palavra.length( );
      
      if( part( partes, quant ))
      {
         for( posicao = 0; posicao < partes; posicao = posicao + 1 )
         {     
            letras = letras + palavra.charAt( posicao );
         }
      }      
      IO.println( "Caracteres: "+ letras + " Tamanho da cadeia: "+ contadores( letras ));       
   }
   
   public static void main ( String []args )
   {
      mostrar( );
   }
}