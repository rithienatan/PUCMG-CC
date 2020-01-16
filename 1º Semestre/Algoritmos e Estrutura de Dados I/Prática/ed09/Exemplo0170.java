/**
 * Estudo Dirigido 09
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 12/04/2016
 
   Exemplo0170
 
 *@version 01
*
*
/**
 * Exemplo0169
 
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0170
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * ler valores inteiros de arquivo e guardar em uma matriz.
 * @return tabela com os valores lidos de arquivo
 * @param nome do arquivo com os dados
 */
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
 /**
 * recuperar dados de arquivo.
 */
   public static void teste01 ( )
   {
   // 1. definir dados
      int [ ] [ ] tabela = null;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar dados de arquivo" );
      IO.println ( );
   // 3. montar dados
      tabela = lerDoArquivo ( "DADOS.TXT" );
   // 4. testar a existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
         if ( tabela.length == 0 )
         {
            IO.println ( "ERRO: Matriz vazia." );
         }
         else
         {
            IO.println ( "Matriz montada com " +
               tabela.length + "x" +
               tabela[ 0 ].length + " dados." );
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste01 ( )

// ---------------------------------------------- definicao de metodo auxiliar
/**
 * exibir dados em matriz.
 * @param tabela - matriz com dados
 */
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
 /**
 * recuperar e mostrar dados de arquivo.
 */
   public static void teste02 ( )
   {
   // 1. definir dados
      int [ ][ ] tabela = null;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar e mostrar dados de arquivo" );
      IO.println ( );
   // 3. montar dados
      tabela = lerDoArquivo ( "DADOS.TXT" );
   // 4. testar a existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz nula." );
      }
      else
      {
         if ( tabela.length == 0 )
         {
            IO.println ( "ERRO: Matriz vazia." );
         }
         else
         {
            mostrar ( tabela );
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste02 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * copiar dados em matriz.
 * @return nova matriz com dados copiados
 * @param tabela - matriz com dados
 */
   public static int [ ][ ] copiar ( int [ ][ ] tabela )
   {
   // definir dados
      int linhas, colunas;
      int x, y;
      int [ ][ ] nova = null;
   // testar existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // reservar espaco na nova matriz para os dados
         linhas = tabela.length;
         colunas = tabela[0].length;
         nova = new int [ linhas ][ colunas ];
      // testar o espaco disponivel
         if ( nova == null )
         {
            IO.println ( "ERRO: Nao ha' espaco." );
         }
         else
         {
         // reservar espaco para os dados
            nova = new int [ linhas ] [ colunas ];
         // repetir para cada dado no arquivo
            for ( x = 0; x < linhas; x = x + 1 )
            {
               for ( y = 0; y < colunas; y = y + 1 )
               {
               // copiar cada posicao da matriz
                  nova [ x ][ y ] = tabela [ x ][ y ];
               } // fim for
            } // fim for
         } // fim se
      } // fim se
   // retornar nova matriz
      return ( nova );
   } // fim copiar ( )
 /**
 * recuperar e mostrar dados de arquivo.
 */
   public static void teste03 ( )
   {
   // 1. definir dados
      int [ ][ ] tabela1 = null;
      int [ ][ ] tabela2 = null;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar e mostrar dados de arquivo" );
      IO.println ( );
   // 3. montar dados
      tabela1 = lerDoArquivo ( "DADOS.TXT" );
   // 4. testar a existencia de dados
      if ( tabela1 == null )
      {
         IO.println ( "ERRO: Matriz nula." );
      }
      else
      {
         if ( tabela1.length == 0 )
         {
            IO.println ( "ERRO: Matriz vazia." );
         }
         else
         {
            mostrar ( tabela1 );
            tabela2 = copiar ( tabela1 );
            IO.println ( );
            IO.println ( "Apos copiar:" );
            mostrar ( tabela2 );
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste03 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * somar dados em matrizes.
 * @return nova matriz com dados somados
 * @param tabela1 - matriz com dados
 * @param tabela2 - matriz com dados
 */
   public static int [ ][ ] somar
   ( int [ ][ ] tabela1,
   int [ ][ ] tabela2 )
   {
   // definir dados
      int linhas, colunas;
      int x, y;
      int [ ][ ] nova = null;
   // testar existencia de dados
      if ( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // testar se tamanhos validos
         if ( tabela1.length == 0 ||
         tabela2.length == 0 ||
         tabela1.length != tabela2.length ||
         tabela1[0].length != tabela2[0].length )
         {
            IO.println ( "ERRO: Tamanho(s) invalido(s)." );
         }
         else
         {
         // reservar espaco na nova matriz para os dados
            linhas = tabela1.length;
            colunas = tabela1[0].length;
         // reservar espaco para os dados
            nova = new int [ linhas ][ colunas ];
         // testar o espaco disponivel
            if ( nova == null )
            {
               IO.println ( "ERRO: Nao ha' espaco." );
            }
            else
            {
            // repetir para cada dado no arquivo
               for ( x = 0; x < linhas; x = x + 1 )
               {
                  for ( y = 0; y < colunas; y = y + 1 )
                  {
                  // somar dados em cada posicao da matriz
                     nova [ x ][ y ] = tabela1 [ x ][ y ]
                        + tabela2 [ x ][ y ];
                  } // fim for
               } // fim for
            } // fim se
         } // fim se
      } // fim se
   // retornar nova matriz
      return ( nova );
   } // fim somar ( )
 /**
 * recuperar, somar e mostrar dados de arquivo.
 */
   public static void teste04 ( )
   {
   // 1. definir dados
      int [ ][ ] tabela1 = null;
      int [ ][ ] tabela2 = null;
      int [ ][ ] tabela3 = null;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar, somar e mostrar dados de arquivo" );
      IO.println ( );
   // 3. montar dados
      tabela1 = lerDoArquivo ( "DADOS1.TXT" );
      tabela2 = lerDoArquivo ( "DADOS2.TXT" );
   // 4. testar a existencia de dados
      if ( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Matriz nula." );
      }
      else
      {
         if ( tabela1.length == 0 ||
         tabela2.length == 0 ||
         tabela1.length != tabela2.length ||
         tabela1[0].length != tabela2[0].length )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            IO.println ( "Somar matrizes: " );
            mostrar ( tabela1 );
            IO.println ( "\n+" );
            mostrar ( tabela2 );
            IO.println ( );
            IO.println ( "Resultado:" );
            tabela3 = somar ( tabela1, tabela2 );
            mostrar ( tabela3 );
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste04 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * somar dados em matrizes.
 * @return nova matriz com dados somados
 * @param tabela1 - matriz com dados
 * @param constante - constante para escalar dados
 * @param tabela2 - matriz com dados
 */
   public static int [ ][ ] somar
   ( int [ ][ ] tabela1,
   int constante,
   int [ ][ ] tabela2 )
   {
   // definir dados
      int linhas, colunas;
      int x, y;
      int [ ][ ] nova = null;
   // testar existencia de dados
      if ( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // testar se tamanhos validos
         if ( tabela1.length == 0 ||
         tabela2.length == 0 ||
         tabela1.length != tabela2.length ||
         tabela1[0].length != tabela2[0].length )
         {
            IO.println ( "ERRO: Tamanho(s) invalido(s)." );
         }
         else
         {
         // reservar espaco na nova matriz para os dados
            linhas = tabela1.length;
            colunas = tabela1[0].length;
         // reservar espaco para os dados
            nova = new int [ linhas ][ colunas ];
         // testar o espaco disponivel
            if ( nova == null )
            {
               IO.println ( "ERRO: Nao ha' espaco." );
            }
            else
            {
            // repetir para cada dado no arquivo
               for ( x = 0; x < linhas; x = x + 1 )
               {
                  for ( y = 0; y < colunas; y = y + 1 )
                  {
                  // somar dados em cada posicao da matriz
                     nova [ x ][ y ] = tabela1 [ x ][ y ]
                        + constante * tabela2 [ x ][ y ];
                  } // fim for
               } // fim for
            } // fim se
         } // fim se
      } // fim se
   // retornar nova matriz
      return ( nova );
   } // fim somar ( )
 /**
 * recuperar, somar e mostrar dados de arquivo.
 */
   public static void teste05 ( )
   {
   // 1. definir dados
      int [ ][ ] tabela1 = null;
      int [ ][ ] tabela2 = null;
      int [ ][ ] tabela3 = null;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar, somar e mostrar dados de arquivo" );
      IO.println ( );
   // 3. montar dados
      tabela1 = lerDoArquivo ( "DADOS1.TXT" );
      tabela2 = lerDoArquivo ( "DADOS2.TXT" );
   // 4. testar a existencia de dados
      if ( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Matriz nula." );
      }
      else
      {
         if ( tabela1.length == 0 ||
         tabela2.length == 0 ||
         tabela1.length != tabela2.length ||
         tabela1[0].length != tabela2[0].length )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            IO.println ( "Somar matrizes: " );
            mostrar ( tabela1 );
            IO.println ( "\n+" );
            mostrar ( tabela2 );
            IO.println ( );
            IO.println ( "Resultado:" );
            tabela3 = somar ( tabela1, -1, tabela2 );
            mostrar ( tabela3 );
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste05 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * comparar dados em matrizes.
 * @return se matrizes iguais, ou nao
 * @param tabela1 - matriz com dados
 * @param tabela2 - matriz com dados
 */
   public static boolean comparar
   ( int [ ][ ] tabela1,
   int [ ][ ] tabela2 )
   {
   // definir dados
      boolean resposta = true;
      int linhas, colunas;
      int x, y;
   // testar existencia de dados
      if ( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // testar se tamanhos validos
         if ( tabela1.length == 0 ||
         tabela2.length == 0 ||
         tabela1.length != tabela2.length ||
         tabela1[0].length != tabela2[0].length )
         {
            IO.println ( "ERRO: Tamanho(s) invalido(s)." );
         }
         else
         {
         // repetir para cada posicao das matrizes
            linhas = tabela1.length;
            colunas = tabela1[0].length;
            for ( x = 0; x < linhas; x = x + 1 )
            {
               for ( y = 0; y < colunas; y = y + 1 )
               {
               // comparar cada posicao das matrizes
                  resposta = resposta &&
                     ( tabela1 [ x ][ y ] == tabela2 [ x ][ y ] );
               } // fim for
            } // fim for
         } // fim se
      } // fim se
   // retornar nova matriz
      return ( resposta );
   } // fim comparar ( )
 /**
 * recuperar e comparar dados de arquivos.
 */
   public static void teste06 ( )
   {
   // 1. definir dados
      int [ ][ ] tabela1 = null;
      int [ ][ ] tabela2 = null;
      String nome1, nome2;
      boolean resposta;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar e comparar dados de arquivos" );
      IO.println ( );
   // 3. montar dados
      nome1 = IO.readString ( "Qual o nome do primeiro arquivo? " );
      nome2 = IO.readString ( "Qual o nome do segundo arquivo? " );
      tabela1 = lerDoArquivo ( nome1 );
      tabela2 = lerDoArquivo ( nome2 );
   // 4. testar a existencia de dados
      if ( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Matriz nula." );
      }
      else
      {
         if ( tabela1.length == 0 ||
         tabela2.length == 0 ||
         tabela1.length != tabela2.length ||
         tabela1[0].length != tabela2[0].length )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            IO.println ( "Somar matrizes: " );
            mostrar ( tabela1 );
            IO.println ( "\n+" );
            mostrar ( tabela2 );
            IO.println ( );
            IO.println ( "Resultado:" );
            resposta = comparar ( tabela1, tabela2 );
            if ( resposta )
            {
               IO.println ( "Matrizes iguais." );
            }
            else
            {
               IO.println ( "Matrizes diferentes." );
            } // fim se
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste06 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * comparar se dados em matrizes sao nulos.
 * @return se dados na matriz sao iguais a zero, ou nao
 * @param tabela - matriz com dados
 */
   public static boolean eNula
   ( int [ ][ ] tabela )
   {
   // definir dados
      boolean resposta = true;
      int linhas, colunas;
      int x, y;
   // testar existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // testar se tamanhos validos
         if ( tabela.length == 0 ||
         tabela[0].length == 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
         // repetir para cada posicao das matrizes
            linhas = tabela.length;
            colunas = tabela[0].length;
            for ( x = 0; x < linhas; x = x + 1 )
            {
               for ( y = 0; y < colunas; y = y + 1 )
               {
               // comparar cada posicao das matrizes
                  resposta = resposta &&
                     ( tabela [ x ][ y ] == 0 );
               } // fim for
            } // fim for
         } // fim se
      } // fim se
   // retornar resultado
      return ( resposta );
   } // fim eNula ( )
 /**
 * recuperar e comparar dados de arquivo.
 */
   public static void teste07 ( )
   {
   // 1. definir dados
      int [ ][ ] tabela = null;
      String nome;
      boolean resposta;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar e comparar dados de arquivos" );
      IO.println ( );
   // 3. montar dados
      nome = IO.readString ( "Qual o nome do arquivo? " );
      tabela = lerDoArquivo ( nome );
   // 4. testar a existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
         if ( tabela.length == 0 ||
         tabela[0].length == 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            IO.println ( "Testar se matriz nula: " );
            mostrar ( tabela );
            IO.println ( );
            IO.println ( "Resultado:" );
            resposta = eNula ( tabela );
            if ( resposta )
            {
               IO.println ( "Matriz nula." );
            }
            else
            {
               IO.println ( "Matriz nao e' nula." );
            } // fim se
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste07 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * comparar se dados em matrizes sao nulos,
 * exceto na diagonal principal.
 * @return se matriz igual 'a identidade
 * @param tabela - matriz com dados
 */
   public static boolean eIdentidade
   ( int [ ][ ] tabela )
   {
   // definir dados
      boolean resposta = true;
      int linhas, colunas;
      int x, y;
   // testar existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // testar se tamanhos validos
         if ( tabela.length == 0 ||
         tabela[0].length == 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
         // repetir para cada posicao das matrizes
            linhas = tabela.length;
            colunas = tabela[0].length;
            for ( x = 0; x < linhas; x = x + 1 )
            {
               for ( y = 0; y < colunas; y = y + 1 )
               {
               // comparar cada posicao das matrizes
                  if ( x == y )
                  {
                  // na diagonal
                     resposta = resposta &&
                        ( tabela [ x ][ y ] == 1 );
                  }
                  else
                  {
                  // fora da diagonal
                     resposta = resposta &&
                        ( tabela [ x ][ y ] == 0 );
                  } // fim se
               } // fim for
            } // fim for
         } // fim se
      } // fim se
   // retornar resultado
      return ( resposta );
   } // fim eIdentidade ( )
 /**
 * recuperar e comparar dados de arquivo.
 */
   public static void teste08 ( )
   {
   // 1. definir dados
      int [ ][ ] tabela = null;
      String nome;
      boolean resposta;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar e comparar dados de arquivos" );
      IO.println ( );
   // 3. montar dados
      nome = IO.readString ( "Qual o nome do arquivo? " );
      tabela = lerDoArquivo ( nome );
   // 4. testar a existencia de dados
      if ( tabela == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
         if ( tabela.length == 0 ||
         tabela[0].length == 0 )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            IO.println ( "Testar se matriz identidade: " );
            mostrar ( tabela );
            IO.println ( );
            IO.println ( "Resultado:" );
            resposta = eIdentidade ( tabela );
            if ( resposta )
            {
               IO.println ( "Matriz identidade." );
            }
            else
            {
               IO.println ( "Matriz nao e' identidade." );
            } // fim se
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste08 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * comparar dados em matrizes.
 * @return se matrizes transpostas, ou nao
 * @param tabela1 - matriz com dados
 * @param tabela2 - matriz com dados
 */
   public static boolean eTransposta
   ( int [ ][ ] tabela1,
   int [ ][ ] tabela2 )
   {
   // definir dados
      boolean resposta = true;
      int linhas, colunas;
      int x, y;
   // testar existencia de dados
      if ( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // testar se tamanhos validos
         if ( tabela1.length == 0 ||
         tabela2.length == 0 ||
         tabela1.length != tabela2[0].length ||
         tabela1[0].length != tabela2.length )
         {
            IO.println ( "ERRO: Tamanho(s) invalido(s)." );
         }
         else
         {
         // repetir para cada posicao das matrizes
            linhas = tabela1.length;
            colunas = tabela1[0].length;
            for ( x = 0; x < linhas; x = x + 1 )
            {
               for ( y = 0; y < colunas; y = y + 1 )
               {
               // comparar cada posicao das matrizes
                  resposta = resposta &&
                     ( tabela1 [ x ][ y ] == tabela2 [ y ][ x ] );
               } // fim for
            } // fim for
         } // fim se
      } // fim se
   // retornar nova matriz
      return ( resposta );
   } // fim eTransposta ( )
 /**
 * recuperar e comparar dados de arquivo.
 */
   public static void teste09 ( )
   {
   // 1. definir dados
      int [ ][ ] tabela1 = null;
      int [ ][ ] tabela2 = null;
      String nome1, nome2;
      boolean resposta;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar e comparar dados de arquivos" );
      IO.println ( );
   // 3. montar dados
      nome1 = IO.readString ( "Qual o nome do primeiro arquivo? " );
      nome2 = IO.readString ( "Qual o nome do segundo arquivo? " );
      tabela1 = lerDoArquivo ( nome1 );
      tabela2 = lerDoArquivo ( nome2 );
   // 4. testar a existencia de dados
      if ( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Matriz nula." );
      }
      else
      {
         if ( tabela1.length == 0 ||
         tabela2.length == 0 ||
         tabela1.length != tabela2.length ||
         tabela1[0].length != tabela2[0].length )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            IO.println ( "Testar se matriz e’ transposta: " );
            mostrar ( tabela1 );
            IO.println ( );
            mostrar ( tabela2 );
            IO.println ( );
            IO.println ( "Resultado:" );
            resposta = eTransposta ( tabela1, tabela2 );
            if ( resposta )
            {
               IO.println ( "Matrizes transpostas." );
            }
            else
            {
               IO.println ( "Matrizes nao sao transpostas." );
            } // fim se
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste09 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * multiplicar dados em matrizes.
 * @return nova matriz com o produto
 * @param tabela1 - matriz com dados
 * @param tabela2 - matriz com dados
 */
   public static int [ ][ ] multiplicar
   ( int [ ][ ] tabela1,
   int [ ][ ] tabela2 )
   {
   // definir dados
      int linhas, colunas;
      int x, y, z;
      int soma;
      int [ ][ ] nova = null;
      int linhas1, colunas1,
         linhas2, colunas2;
   // testar existencia de dados
      if ( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Matriz vazia." );
      }
      else
      {
      // testar se tamanhos validos
         if ( tabela1.length == 0 ||
         tabela2.length == 0 ||
         tabela1.length != tabela2.length ||
         tabela1[0].length != tabela2[0].length )
         {
            IO.println ( "ERRO: Tamanho(s) invalido(s)." );
         }
         else
         {
         // reservar espaco na nova matriz para os dados
            linhas1 = tabela1.length;
            colunas1 = tabela1[0].length;
            linhas2 = tabela2.length;
            colunas2 = tabela2[0].length;
            nova = new int [ linhas1 ][ colunas2 ];
         // testar o espaco disponivel
            if ( nova == null )
            {
               IO.println ( "ERRO: Nao ha' espaco." );
            }
            else
            {
            // repetir para cada dado no arquivo
               for ( x = 0; x < linhas1; x = x + 1 )
               {
                  for ( y = 0; y < colunas2; y = y + 1 )
                  {
                     soma = 0;
                     for ( z = 0; z < colunas1; z = z + 1 )
                     {
                     // acumular o produto cada posicao da matriz
                        soma = soma +
                           tabela1 [ x ][ z ] * tabela2 [ z ][ y ];
                     } // fim for
                     nova [ x ][ y ] = soma;
                  } // fim for
               } // fim for
            } // fim se
         } // fim se
      } // fim se
   // retornar nova matriz
      return ( nova );
   } // fim multiplicar ( )
 /**
 * recuperar, multiplicar e mostrar dados de arquivos.
 */
   public static void teste10 ( )
   {
   // 1. definir dados
      int [ ][ ] tabela1 = null;
      int [ ][ ] tabela2 = null;
      int [ ][ ] tabela3 = null;
   // 2. identificar
      IO.println ( );
      IO.println ( "Recuperar, multiplicar e mostrar dados de arquivos" );
      IO.println ( );
   // 3. montar dados
      tabela1 = lerDoArquivo ( "DADOS1.TXT" );
      tabela2 = lerDoArquivo ( "DADOS2.TXT" );
   // 4. testar a existencia de dados
      if ( tabela1 == null || tabela2 == null )
      {
         IO.println ( "ERRO: Matriz nula." );
      }
      else
      {
         if ( tabela1.length == 0 ||
         tabela2.length == 0 ||
         tabela1[0].length != tabela2.length )
         {
            IO.println ( "ERRO: Tamanho invalido." );
         }
         else
         {
            IO.println ( "Multiplicar matrizes: " );
            mostrar ( tabela1 );
            IO.println ( "\n+" );
            mostrar ( tabela2 );
            IO.println ( );
            IO.println ( "Resultado:" );
            tabela3 = multiplicar ( tabela1, tabela2 );
            mostrar ( tabela3 );
         } // fim se
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim teste10 ( )

// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0170 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      teste10 ( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0170