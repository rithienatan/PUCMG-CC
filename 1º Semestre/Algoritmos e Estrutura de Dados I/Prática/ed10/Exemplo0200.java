/**
 * Estudo Dirigido 10
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 23/04/2016
 
   Exemplo0200
 
 *@version 01
*
*/

import IO.*;

class Arranjo
{
   public Object [ ] tabela;
   
   public Arranjo ( )
   {
      tabela = null;
   }
   
   public Arranjo ( int tamanho )
   {
      if( tamanho <= 0 )
      {
         IO.println( "ERROR! Quantidade inválida!" );
      }
      else
      {
         tabela = new Object [ tamanho ];
      }
   }
   
   public int length ( )
   {
      int tamanho = 0;
      
      if( tabela != null )
      {
         tamanho = tabela.length;
      }
      return( tamanho );
   }
   
   public void readIntArranjo ( String msn, int onde, int n )
   {
      int posicao, tamanho = length( );
      String linha;
      
      if( tamanho <= 0 || n <= 0 || n > tamanho )
      {
         IO.println( "ERROR! Quantidade inválidada!" );
      }
      else
      {
         if( onde < 0 )
         {
            IO.println( "ERRO: POsição inválida!" );
         }
         else
         {
            IO.println( msn );
            for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
            {
               if( posicao >= onde )
               {
                  linha = IO.readln( );
                  
                  tabela [ posicao ] = IO.getint ( linha );
               }
            }
         }
      }
   }
   
   public void printIntArranjo ( int quant )
   {
      int posicao, tamanho = length( );
      
      if( tabela == null || tamanho <= 0 )
      {
         IO.println( "ERROR: Tabela vazio ou quantidade inválida!" );
      }
      else
      {
         for( posicao = quant; posicao < tamanho; posicao = posicao + 1 )
         {
            IO.println( ""+( int )tabela[ posicao ] );
         }
      }
   }
   
   public void lerArquivo ( String nome, int onde, int quantidade )
   {
      FILE arquivo = new FILE( FILE.INPUT, nome );
      int posicao, tamanho = length( );
      String linha;
      Arranjo novo = null;
      
      linha = arquivo.readln( );
      
      if( linha == null )
      {
         IO.println( "ERROR: Não contém dados o arquivo!" );
      }
      else
      {
         if( quantidade <= 0 || onde <= 0 || onde > quantidade || tamanho != quantidade )
         {
            IO.println( "ERROR: Quantidade inválido!" );
         }
         else
         {
            novo = new Arranjo( tamanho );
            
            IO.println( "Lendo arquivo: " );
                        
            for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
            {
               if( posicao >= onde )
               {
                  linha = arquivo.readln( );
               
                  IO.println( "Posicao"+posicao+": "+linha );
               
                  novo.tabela[ posicao ] = IO.getint( linha );
               }
            }
         }
      }
      arquivo.close( );
   }
   
   public void gravaArquivo( String nome, int onde, int quantidade )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, nome );
      int posicao, tamanho = length( );
      
      if( tabela == null || quantidade <= 0 || onde <= 0 || onde > quantidade )
      {
         IO.println( "ERROR: Tabela vazio ou quantidade inválida!" );
      }
      else
      {
         if( tamanho == quantidade )
         {
            arquivo.println( ""+tamanho );
         
            for( posicao = 0; posicao < tamanho; posicao = posicao + 1  )
            {
               if( posicao >= onde )
               {
                  IO.println( ""+tabela[ posicao ] );
                  arquivo.println( ""+tabela[ posicao ] );
               }
            }
         }
         else
         {
            IO.println( "ERROR! Tamanho diferente de quantidade!" );
         }
      }
      arquivo.close( ); 
   }
   
   public Arranjo inverterArranjo( )
   {
      Arranjo novo = null;
      int posicao, tamanho = length( );
      int contador = 0;
      
      if( tabela == null )
      {
         IO.println( "ERROR! Tabela vazia!" );
      }
      else
      {
         novo = new Arranjo( tamanho );
         
         for( posicao = tamanho - 1; posicao >= 0; posicao = posicao - 1 )
         {
            novo.tabela[ contador ] = tabela[ posicao ];
            contador = contador + 1;
         }
      } 
      return( novo );
   }
   
   public Arranjo copiaArranjo( )
   {
      Arranjo novo = null;
      int posicao, tamanho = length( );
      
      if( tabela == null )
      {
         IO.println( "ERROR! Tabela Vazia!" );
      }
      else
      {
         novo = new Arranjo( tamanho );
         
         for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
         {
            novo.tabela[ posicao ] = tabela[ posicao ];
         }
      }
      return( novo );
   }
}

public class Exemplo0200
{   
   public static int tamanhoArquivo( String nome )
   {
      int tamanho = 0;
      FILE arquivo = new FILE( FILE.INPUT, nome );
      String linha;
      
      linha = arquivo.readln( );
      
      if( linha == null )
      {
         IO.println( "ERROR: Não contém dados o arquivo!" );
      }
      else
      {
         tamanho = IO.getint( linha );
      }
      arquivo.close( );
      
      return( tamanho );
   } 
   
   public static void principal( )
   {
      Arranjo teste = new Arranjo( 5 );
      Arranjo teste2 = new Arranjo( 5 );
      int quantidade;
      int f;
      
      IO.println( "Invertendo arranjo!"+"\n" );
      
      teste.readIntArranjo( "Entrar com dados no arranjo: ", 0, 5 );
      
      teste2 = teste.inverterArranjo( );
      
      IO.println( "\n"+"Inverso: " );
      
      teste2.printIntArranjo( 0 );
      
      IO.println( );
      
      IO.println( "Copiar de arrajo!"+"\n" );
      
      teste.readIntArranjo( "Entrar com dados no arranjo: ", 0, 5 );
      
      teste2 = teste.copiaArranjo( );
      
      IO.println( "\n"+"Copia: " );
      
      teste2.printIntArranjo( 0 );       
   }
   
   public static void main( String [ ] args )
   {
      principal( );
   }
}