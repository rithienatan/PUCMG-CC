/**
 * Estudo Dirigido 10
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 23/04/2016
 
   Exemplo0195
 
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
   
   public void lerArquivo ( String nome, int quantidade )
   {
      FILE arquivo = new FILE( FILE.INPUT, nome );
      int posicao;
      String linha;
      Arranjo novo = null;
      
      linha = arquivo.readln( );
      
      if( linha == null )
      {
         IO.println( "ERROR: Não contém dados o arquivo!" );
      }
      else
      {
         if( quantidade <= 0 )
         {
            IO.println( "ERROR: Tamanho inválido!" );
         }
         else
         {
            novo = new Arranjo( quantidade );
            
            IO.println( "Lendo arquivo: " );
                        
            for( posicao = 0; posicao < quantidade; posicao = posicao + 1 )
            {
               linha = arquivo.readln( );
               
               IO.println( "Posicao"+posicao+": "+linha );
               
               novo.tabela[ posicao ] = IO.getint( linha );
            }
         }
      }
      arquivo.close( );
   }
   
   public void gravaArquivo( String nome, int quantidade )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, nome );
      int posicao;
      
      if( tabela == null || quantidade <= 0 )
      {
         IO.println( "ERROR: Tabela vazio ou quantidade inválida!" );
      }
      else
      {
         arquivo.println( ""+quantidade );
         
         for( posicao = 0; posicao < quantidade; posicao = posicao + 1  )
         {
            IO.println( ""+tabela[ posicao ] );
            arquivo.println( ""+tabela[ posicao ] );
         }
      }
      arquivo.close( ); 
   }
}

public class Exemplo195
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
      Arranjo teste = null;
      String nome, nome1;
      int quantidade;
      
      IO.println( "Lendo arquivo e gravando no arranjo!"+"\n" );
      
      nome = IO.readString( "Digite o nome do arquivo: " );
      
      quantidade = tamanhoArquivo( nome );
      
      teste = new Arranjo( quantidade );
      
      teste.lerArquivo( nome, quantidade ); 
      
      IO.println( "Gravando dados do arranjo no arquivo!"+"\n" );
      
      nome1 = IO.readString( "Digite o nome do arquivo: " );
      
      teste.gravaArquivo( nome1, quantidade );         
   }
   
   public static void main( String [ ] args )
   {
      principal( );
   }
}