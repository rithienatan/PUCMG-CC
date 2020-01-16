/**
 * Estudo Dirigido 09
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 12/04/2016
 
   Exemplo0170
 
 *@version 01
*
*/

import IO.*;

public class Exemplo0171
{
   public static int [ ][ ] montarmatriz( )
   {
      int linhas, colunas;
      int x, y, n;
      int [ ] [ ] matriz = null;
      linhas = IO.readint( "Digite o número de linhas: " );
      colunas = IO.readint( "Digite o número de colunas: " );
      
      if( linhas >= 0 && linhas <= 10 || colunas >= 0 && colunas <= 10 )
      {
         matriz = new int [ linhas ] [ colunas ];
         if( matriz != null )
         {
            IO.println( "Dimensões da matriz: "+linhas+" x "+colunas );
         
            for( x = 0; x < linhas; x = x + 1 )
            {
               for( y = 0; y < colunas; y = y + 1 )
               {
                  n = IO.readint( "Digite um número positivo ?" );
                  if( n > 0 )
                  {
                     matriz [ x ][ y ] = n;
                  }
                  else
                  {
                     IO.println( "Não é positivo!" );
                  }
               }
            } 
         }
         else
         {
            IO.println( "Matriz sem dados!" );
         } 
      }
      else
      {
         IO.println( "Linhas ou colunas muito grandes ou com valor inapropriado! " );
      }
      
      return( matriz );
   }
   
   public static void mostrar ( int [ ][ ] tabela )
   {
   // definir dados
      int linhas, colunas;
      int x, y;
   // identificar
      IO.println ( );
   // testar se a matriz foi montada
      if ( tabela == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
      // verificar o tamanho da matriz
         linhas = tabela.length;
         colunas = tabela[0].length;
         if ( linhas <= 0 || colunas <= 0 )
         {
            IO.println ( "ERRO: Tabela vazia." );
         }
         else
         {
         // mostrar matriz
            IO.println ( "Matriz montada com " +
               linhas + "x" +
               colunas + " dados." );
         // repetir para cada dado na matriz
            for ( x = 0; x < linhas; x = x + 1 )
            {
               for ( y = 0; y < colunas; y = y + 1 )
               {
               // mostrar dado em um posicao da matriz
               // convertido para inteiro
                  IO.print ( " " + tabela [ x ][ y ] );
               } // fim for
            // mudar de linha
               IO.println ( );
            } // fim for
         } // fim se
      } // fim se
   } // fim mostrar ( )
   
   public static void metodo11( )
   {
      int [][] matriz = null;
      
      matriz = montarmatriz( );
      
      if( matriz == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
         mostrar( matriz );
      }
   }
   
   public static void main ( String [ ] args )
   {
      metodo11( );
   }
}