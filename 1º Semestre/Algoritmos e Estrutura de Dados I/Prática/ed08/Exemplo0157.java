/**
 * Estudo Dirigido 08
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 10/04/2016
 
   Exemplo0155
 
 *@version 01
*
*/

import IO.*;

public class Exemplo0157
{   
   public static int [ ] criarArranjo( int inferior, int superior )
   {
      int [ ] tabela = null;
      int n = IO.readint( "Digite uma quantidade: " );
      int x = 0, y;
      
      tabela = new int [ n ];
      
      if( n >= 0 )
      {
         while( x < n )
         {
            y = ( int )Math.random( );
            if( y >= inferior && y <= superior )
            {
               tabela [ x ] = y;
               x = x + 1;
            }
         }
      }
      return( tabela );
   }
   
   public static void guardar( int menor, int maior, String nome )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, nome );
      //int tamanho;
      //int x;
      
      /*if( tabela == null )
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
      }*/
      arquivo.println( ""+menor );
      arquivo.println( ""+maior );
      
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
         IO.println( "Arranjo com "+tamanho+" dados" );
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
   
   public static int [ ] soma( int [ ] tabela1, int [ ] tabela2 )
   {
      int tamanho;
      int x;
      int [ ] novo = null;
      
      if( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Tabela vazia." );
      }
      else
      {
         if( tabela1.length == 0 || tabela2.length == 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            tamanho = tabela1.length;
            novo = new int [ tamanho ];
            if( novo == null )
            {
               IO.println ( "ERRO: Nao ha' espaco." );
            }
            else
            {
               for( x = 1; x < tamanho; x = x + 1 )
               {
                  novo [ x ] = tabela1 [ x ] + tabela2 [ x ]; 
               }
            }
         }
      }    
      return ( novo );
   }
   
   public static double media( int [ ] tabela )
   {
      int tamanho;
      int x;
      double novo = 0.0;
      
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
            for( x = 1; x < tamanho; x = x + 1 )
            {
               novo = novo + tabela [ x ]; 
            }
            novo = novo / tamanho;
         }
      } 
      IO.println( "Media: "+novo );   
      return ( novo );
   }
   
   public static void Maior( int [ ] tabela, double media )
   {
      int tamanho;
      int x;
      FILE arquivo = new FILE( FILE.OUTPUT, "Maiores.txt" );
      
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
            for( x = 1; x < tamanho; x = x + 1 )
            {
               if( tabela[ x ] >= media )
               {
                  arquivo.println( ""+tabela[ x ] );
               }
            }
         }
      } 
      arquivo.close( );   
   }
   
   public static void Menor( int [ ] tabela, double media )
   {
      int tamanho;
      int x;
      FILE arquivo = new FILE( FILE.OUTPUT, "Menores.txt" );
      
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
            for( x = 1; x < tamanho; x = x + 1 )
            {
               if( tabela[ x ] < media )
               {
                  arquivo.println( ""+tabela[ x ] );
               }
            }
         }
      }
      arquivo.close( );    
   }
   
   public static boolean ordem( int [ ] tabela )
   {
      boolean resposta = false;
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
            for( x = 1; x < tamanho; x = x + 1 )
            {
               if( tabela[ x-1 ] > tabela [ x ] )
               {
                  resposta = true;
               }
            }
         }
      }
      return ( resposta );
   }

   
   public static void executar( )
   {
      int [ ] tabela1 = null;
      //String nome = IO.readString( "Digite o nome do arquivo: " );
      
      tabela1 = lerDados( "DADOS.TXT" );
      
      if( tabela1 == null )
      {
         IO.println ( "ERRO: Arranjo vazio." );
      }
      else
      {
         if( tabela1.length == 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            mostrar( tabela1 );
            if( ordem( tabela1 ) )
            {
               IO.println( "Arranjo em ordem crscente!" );
            }
            else
            {
               IO.println( "Não está crescente!" );
            }
         }
      }
   }
   
   public static void main ( String [] args )
   {
      executar( );
   }
}