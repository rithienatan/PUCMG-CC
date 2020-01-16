/**
 * Estudo Dirigido 0135
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0135
*/

import IO.*;

public class Exemplo0135
{
   public static void metodo05( )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, "Metodo05.txt" );
      String n = IO.readString( "Digite uma cadeia de caracter: " );
      int tamanho = n.length( ); 
      int posicao;
      String reposicao = "";
      
      for( posicao = tamanho - 1; posicao <= tamanho && posicao >= 0; posicao = posicao - 1 )
      {
         IO.println( ""+ n.charAt( posicao ));
         arquivo.println( ""+ n.charAt( posicao ) );
      }
      
      arquivo.close( );
      IO.pause( "\n"+"Aperte ENTER para continuar...." );
   }
   
   public static void main ( String [] args )
   {
      metodo05( );
   }
}