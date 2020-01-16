/**
 * Estudo Dirigido 10
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 23/04/2016
 
   Exemplo0191
 
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
}

public class Exemplo191
{
   public static void principal( )
   {
      int n, f;
      Arranjo teste = null;
      
      n = IO.readint( "Digite o tamanho do arranjo: " );
      f = IO.readint( "Digite a posição que você deseja começar a gravar os dados: " );
      
      teste = new Arranjo( n );
      
      teste.readIntArranjo( "Entrar com dados no arranjo: ", f, n );
      
      IO.println( "Dados mostrados a partir da posição desejada: "+"\n" );
      
      teste.printIntArranjo( f );      
   }
   
   public static void main( String [ ] args )
   {
      principal( );
   }
}