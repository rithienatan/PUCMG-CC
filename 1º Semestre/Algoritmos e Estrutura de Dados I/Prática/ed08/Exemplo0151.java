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

public class Exemplo0151
{   
   public static void criarArranjo( String nome )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, nome );
      int [ ] arranjo = null;
      int quant = IO.readint( "Digite uma quantidade: " );
      int x, n;
      
      arranjo = new int [ quant ];
      
      arquivo.println( ""+quant );
      
      if( quant >= 0 )
      {
         for( x = 0; x < quant; x = x + 1 )
         {
            n = IO.readint( "Digite um número inteiro: " );
            arranjo [ x ] = n;
            arquivo.println( ""+arranjo[ x ] );
            IO.println( ""+arranjo[ x ] );
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
   
   public static void metodo0151( )
   {
      int [ ] tabela = null;
      String nome;
      boolean resposta;
      
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
            IO.println( "Testar se a tabela é nula ou negativa!!" );
            resposta = eNuloNegativo( tabela ); 
            if( resposta )
            {
               IO.println( "Arranjo negativo ou nulo!!" );
            }
            else
            {
               IO.println( "Arranjo não é negativo ou nulo!!" );
            }
         }
      }
   }
   
   public static void main ( String [] args )
   {
      criarArranjo( "Teste.txt" );
      metodo0151( );
   }
}