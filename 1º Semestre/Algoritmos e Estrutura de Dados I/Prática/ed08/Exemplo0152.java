/**
 * Estudo Dirigido 08
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 10/04/2016
 
   Exemplo0151
 
 *@version 01
*
*/

import IO.*;

public class Exemplo0152
{   
   public static int [ ] criarArranjo( )
   {
      int [ ] tabela = null;
      int n = IO.readint( "Digite uma quantidade: " );
      int x, y;
      
      tabela = new int [ n ];
      
      if( n >= 0 )
      {
         for( x = 0; x < n; x = x + 1 )
         {
            y = IO.readint( "Digite um número inteiro: " );
            tabela [ x ] = y;
         }
      }
      return( tabela );
   }
   
   public static void guardar( int [ ] tabela, String nome )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, nome );
      int tamanho;
      int x;
      
      if( tabela == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
          tamanho = tabela.length;
          arquivo.println( ""+tamanho );
          if( tamanho <= 0 )
          {
            IO.println ( "ERRO: Arranjo vazio." );
          }
          else
          {
            for( x = 0; x < tamanho; x = x + 1 )
            {
               arquivo.println( ""+tabela[ x ] );
            }
          }
      }
      arquivo.close( );
   }
   
   public static int [ ] lerDados( String nome )
   {
      FILE arquivo = new FILE( FILE.INPUT, nome );
      int tamanho;
      int x;
      int [ ] tabela = null;
      String linha;
      
      linha = arquivo.readln( );
      
      if( linha == null )
      {
         IO.println ( "ERRO: Nao ha' dados no arquivo." );
      }
      else
      {
         tamanho = IO.getint( linha );
         
         if( tamanho <= 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            tabela = new int [ tamanho ];
            
            for( x = 0; x < tamanho; x = x + 1 )
            {
               linha = arquivo.readln( );
               
               tabela [ x ] = IO.getint( linha );
            }
         }
      }
      return( tabela );
   }
   
   public static void mostrar ( int [ ] tabela )
   {
      int tamanho;
      int x;
      
      if( tabela == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
         tamanho = tabela.length;
         if( tamanho <= 0 )
         {
            IO.println ( "ERRO: Arranjo vazio." );
         }
         else
         {
            for( x = 0; x < tamanho; x = x + 1 )
            {
               IO.println( ""+ tabela [ x ] );
            }
         }
      }
   }
   
   public static boolean eNuloNegativo( int [ ] tabela )
   {
      boolean resposta = true;
      int tamanho;
      int x;
      
      if( tabela == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
         if( tabela.length == 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            tamanho = tabela.length;
            for( x = 0; x < tamanho; x = x + 1 )
            {
               resposta = resposta && ( tabela [ x ] <= 0 );
            }
         }
      }    
      return ( resposta );
   }
   
   public static void executar( )
   {
      int [ ] tabela = null;
      String nome;
      
      tabela = lerDados( "Teste.txt" );
      if( tabela == null )
      {
         IO.println ( "ERRO: Arranjo vazio." );
      }
      else
      {
         if( tabela.length == 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            mostrar( tabela );
         }
      }
   }
   
   public static void main ( String [] args )
   {
      guardar( criarArranjo( ), "Teste.txt" );
      executar( );
   }
}