/**
 * Estudo Dirigido 09
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 12/04/2016
 
   Exemplo0179
 
 *@version 01
*
*/

import IO.*;

public class Exemplo0179
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
         if( linhas == colunas )
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
            if( linhas == colunas )
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
                     if( x > y && tabela [ x ][ y ] == 0 )
                     {
                        IO.println( "Abaixo da diagonal principal são nulos!" );
                     }
                     else
                     {
                        IO.println( ""+tabela [ x ][ y ] );
                     }               
                  }// mudar de linha
               } // fim for
            }
            else
            {
               IO.println( "Não é uma matriz quadrada!" );
            }
         } // fim se
      } // fim se
   } // fim mostrar ( )
   
   public static void guardar ( int [ ][ ] tabela, String nome )
   {
      FILE arquivo = new FILE( FILE.INPUT, nome );
      int linha, coluna;
      int x, y;
      
      if ( tabela == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
         linha = tabela.length;
         coluna = tabela[0].length;
         if ( linha <= 0 || coluna <= 0 )
         {
            IO.println ( "ERRO: Tabela vazia." );
         }
         else
         {
            arquivo.println( ""+linha );
            arquivo.println( ""+coluna );
            for ( x = 0; x < linha; x = x + 1 )
            {
               for ( y = 0; y < coluna; y = y + 1 )
               {
                  arquivo.println( ""+tabela[ x ][ y ] );
               } 
            } 
         }
      }
      arquivo.close( );
   }
   
   public static int [ ][ ] lerDoArquivo ( String nome )
   {
   // definir dados
      FILE arquivo = new FILE ( FILE.INPUT, nome );
      int linhas, colunas;
      int x, y;
      int [ ][ ] tabela = null;
      String linha;
   // identificar
      IO.println ( "Montar matriz com valores lidos de arquivo" );
   // tentar ler uma linha do arquivo
      linha = arquivo.readln ( );
   // testar a disponibilidade de dados
      if ( linha == null )
      {
         IO.println ( "ERRO: Nao ha' dados no arquivo." );
      }
      else
      {
      // tentar obter a quantidade de linhas
         linhas = IO.getint ( linha );
      // tentar obter a quantidade de colunas
         linha = arquivo.readln ( );
         colunas = IO.getint ( linha );
      // testar se quantidade valida
         if ( linhas <= 0 || colunas <= 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
         // reservar espaco para os dados
            tabela = new int [ linhas ] [ colunas ];
         // repetir para cada dado no arquivo
            for ( x = 0; x < linhas; x = x + 1 )
            {
               for ( y = 0; y < colunas; y = y + 1 )
               {
               // ler linha do arquivo
                  linha = arquivo.readln ( );
               // armazenar em um posicao da matriz
               // valor convertido para inteiro
                  tabela [ x ][ y ] = IO.getint ( linha );
               } // fim for
            } // fim for
         } // fim se
      } // fim se
   // fechar arquivo
      arquivo.close ( );
   // retornar matriz montada
      return ( tabela );
   } // fim lerDoArquivo ( )

   
   public static void fixo( )
   {
      int [][] matriz = null;
      String nome;
      
      matriz = montarmatriz( );
      
      if( matriz == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
         nome = IO.readString ( "Digite o nome do arquivo para guardar a matriz: " );
         guardar( matriz, nome );
      }
   }
   
   public static void main ( String [ ] args )
   {
      fixo( );
   }
}