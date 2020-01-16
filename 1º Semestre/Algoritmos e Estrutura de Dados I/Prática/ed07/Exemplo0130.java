/**
 * Estudo Dirigido 0130
 *
 * Trabalho Pratico: ED 07
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 01/04/2016

 *@version 0130
*/

/**
 * Exemplo0130
 *
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0130
{
// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * guardar dados em arquivo,
 * dada a quantidade deles.
 */
   public static void metodo01 ( )
   {
   // 1. definir dados
      int n;
      int k;
      String dado;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Guardar dados em arquivos" );
   // 3. ler dado do teclado
      n = IO.readint ( "Quantos nomes? " );
   // 4. testar a quantidade
      if ( n <= 0 )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // criar arquivo para gravar dados
         arquivo = new FILE ( FILE.OUTPUT, "DADOS1.TXT" );
      // guardar a quantidade de dados em arquivo
         arquivo.println ( ""+ n );
      // ler os outros dados do teclado
         for ( k = 1; k <= n; k = k + 1 )
         {
         // ler um dado do teclado
            dado = IO.readString ( "Nome = " );
         // guardar dado em arquivo
            arquivo.println ( ""+dado );
         } // fim repetir
      // fechar o arquivo (INDISPENSAVEL para a gravacao)
         arquivo.close ( );
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo01( )

 /**
 * consultar dados em arquivo.
 */
   public static void metodo02 ( )
   {
   // 1. definir dados
      String linha;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Consultar dados em arquivos" );
   // 3. abrir arquivo para a leitura
      arquivo = new FILE ( FILE.INPUT, "DADOS1.TXT" );
   // 4. ler linhas do arquivo
   // tentar ler uma linha do arquivo
      linha = arquivo.readln ( );
   // repetir enquanto houver dado
      while ( ! arquivo.eof ( ) )
      {
      // mostrar dado na tela
         IO.println ( "" + linha );
      // tentar ler outra linha do arquivo
         linha = arquivo.readln ( );
      } // fim repetir
   // fechar o arquivo (RECOMENDAVEL para a leitura)
      arquivo.close ( );
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo02 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * recuperar dados em arquivo,
 * dada a quantidade deles na primeira linha.
 */
   public static void metodo03 ( )
   {
   // 1. definir dados
      int n, k;
      String linha;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Consultar dados em arquivos" );
   // 3. abrir arquivo para a leitura
      arquivo = new FILE ( FILE.INPUT, "DADOS1.TXT" );
   // 4. ler quantidade de dados do arquivo
   // 4.1 ler uma linha do arquivo
      linha = arquivo.readln ( );
   // 4.2 converter conteudo para valor inteiro
      n = IO.getint ( linha );
   // 5. testar a quantidade
      if ( n <= 0 )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // mostrar a quantidade de dados
         IO.println ( "Quantidade de dados = " + n );
      // ler os outros dados do arquivo
         for ( k = 1; k <= n; k = k + 1 )
         {
         // ler uma linha do arquivo
            linha = arquivo.readln ( );
         // mostrar dado na tela
            IO.println ( "" + linha );
         } // fim repetir
      // fechar o arquivo (RECOMENDAVEL para a leitura)
         arquivo.close ( );
      } // fim se
   // 6. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo03 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * guardar dados inteiros em arquivo,
 * dada a quantidade deles.
 */
   public static void metodo04 ( )
   {
   // 1. definir dados
      int n, k, dado;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Guardar dados inteiros em arquivos" );
   // 3. ler dado do teclado
      n = IO.readint ( "Fornecer a quantidade de valores: " );
   // 4. testar a quantidade
      if ( n <= 0 )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // criar arquivo para gravar dados
         arquivo = new FILE ( FILE.OUTPUT, "DADOS2.TXT" );
      // guardar a quantidade de dados
         arquivo.println ( ""+n );
      // ler os outros dados do teclado
         for ( k = 1; k <= n; k = k + 1 )
         {
         // ler um dado do teclado
            dado = IO.readint ( "Dado = " );
         // guardar dado em arquivo
            arquivo.println ( ""+dado );
         } // fim repetir
      // fechar o arquivo (INDISPENSAVEL para a gravacao)
         arquivo.close ( );
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo04 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * recuperar dados inteiros em arquivo,
 * dada a quantidade deles na primeira linha.
 */
   public static void metodo05 ( )
   {
   // 1. definir dados
      int n, k, dado;
      String linha;
      FILE arquivo;
   // 2. identificar
      IO.println ( );
      IO.println ( "Consultar dados em arquivos" );
      IO.println ( );
   // 3. abrir arquivo para a leitura
      arquivo = new FILE ( FILE.INPUT, "DADOS2.TXT" );
   
   // 4. ler quantidade de dados do arquivo
   // 4.1 ler uma linha do arquivo
      linha = arquivo.readln ( );
   // 4.2 converter conteudo para valor inteiro
      n = IO.getint ( linha );
   // 5. testar a quantidade
      if ( n <= 0 )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // mostrar a quantidade de dados
         IO.println ( "Quantidade de dados = " + n );
      // ler os outros dados do arquivo
         for ( k = 1; k <= n; k = k + 1 )
         {
         // ler uma linha do arquivo
            linha = arquivo.readln ( );
         // converter conteudo para valor inteiro
            dado = IO.getint ( linha );
         // mostrar dado na tela
            IO.println ( "" + dado );
         } // fim repetir
      // fechar o arquivo (RECOMENDAVEL para a leitura)
         arquivo.close ( );
      } // fim se
   // 6. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo05 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * guardar dados reais em arquivo,
 * dada a quantidade deles.
 */
   public static void metodo06 ( )
   {
   // 1. definir dados
      int n, k;
      double dado;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Guardar dados reais em arquivos" );
   // 3. ler dado do teclado
      n = IO.readint ( "Fornecer a quantidade de valores: " );
   // 4. testar a quantidade
      if ( n <= 0 )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // criar arquivo para gravar dados
         arquivo = new FILE ( FILE.OUTPUT, "DADOS3.TXT" );
      // guardar a quantidade de dados
         arquivo.println ( ""+n );
      // ler os outros dados do teclado
         for ( k = 1; k <= n; k = k + 1 )
         {
         // ler um dado do teclado
            dado = IO.readdouble ( "Dado = " );
         // guardar dado em arquivo
            arquivo.println ( ""+dado );
         } // fim repetir
      // fechar o arquivo (INDISPENSAVEL para a gravacao)
         arquivo.close ( );
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo06 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * recuperar dados reais em arquivo,
 * dada a quantidade deles na primeira linha.
 */
   public static void metodo07 ( )
   {
   // 1. definir dados
      int n, k;
      double dado;
      String linha;
      FILE arquivo;
   // 2. identificar
      IO.println ( "Consultar dados em arquivos" );
   // 3. abrir arquivo para a leitura
      arquivo = new FILE ( FILE.INPUT, "DADOS3.TXT" );
   // 4. ler quantidade de dados do arquivo
   // 4.1 ler uma linha do arquivo
      linha = arquivo.readln ( );
   // 4.2 converter conteudo para valor inteiro
      n = IO.getint ( linha );
   // 5. testar a quantidade
      if ( n <= 0 )
      {
         IO.println ( "ERRO: Quantidade invalida." );
      }
      else
      {
      // mostrar a quantidade de dados
         IO.println ( "Quantidade de dados = " + n );
      // ler os outros dados do arquivo
         for ( k = 1; k <= n; k = k + 1 )
         {
         // ler uma linha do arquivo
            linha = arquivo.readln ( );
         // converter conteudo para valor inteiro
            dado = IO.getdouble ( linha );
         // mostrar dado na tela
            IO.println ( "" + dado );
         } // fim repetir
      // fechar o arquivo (RECOMENDAVEL para a leitura)
         arquivo.close ( );
      } // fim se
   // 6. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo07 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * guardar dados em arquivo.
 */
   public static void metodo08 ( )
   {
   // 1. definir dados
      String linha;
      FILE arquivo;
   // 2. identificar
      IO.println ( );
      IO.println ( "Guardar dados em arquivos" );
      IO.println ( );
   // 3. criar arquivo para gravar dados
      arquivo = new FILE ( FILE.OUTPUT, "TEXTO.TXT" );
   // 4. ler uma linha do teclado
      linha = IO.readln ( "" );
   // 5. repetir enquanto quiser guardar dados
      while ( ! linha.equals ( "PARAR" ) )
      {
      // guardar linha em arquivo
         arquivo.println ( ""+linha );
      // ler outra linha do teclado
         linha = IO.readln ( "" );
      } // fim repetir
   // 6. fechar o arquivo (INDISPENSAVEL para a gravacao)
      arquivo.close ( );
   // 7. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo08 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * ler dados de arquivo.
 */
   public static void metodo09 ( )
   {
   // 1. definir dados
      String dado;
      FILE arquivo;
   // 2. identificar
      IO.println ( );
      IO.println ( "Ler dados de arquivos" );
      IO.println ( );
   // 3. abrir arquivo para ler dados
      arquivo = new FILE ( FILE.INPUT, "TEXTO.TXT" );
   // 4. tentar ler um dado do teclado
      dado = arquivo.read ( );
   // 5. repetir enquanto houver dados
      while ( ! arquivo.eof ( ) )
      {
      // mostrar dado lido de arquivo
         IO.println ( ""+dado );
      // ler outro dado do teclado
         dado = arquivo.read ( );
      } // fim repetir
   // 6. fechar o arquivo (RECOMENDAVEL para a leitura)
      arquivo.close ( );
   // 7. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo09 ( )

// ---------------------------------------------- definicao de metodo auxiliar
 /**
 * ler dados de arquivo.
 */
   public static void metodo10 ( )
   {
   // 1. definir dados
      String dado;
      int valor;
      FILE arquivo;
   // 2. identificar
      IO.println ( );
      IO.println ( "Ler dados de arquivos" );
      IO.println ( );
   // 3. abrir arquivo para ler dados
      arquivo = new FILE ( FILE.INPUT, "TEXTO.TXT" );
   // 4. tentar ler um dado do teclado
      dado = arquivo.read ( );
   // 5. repetir enquanto houver dados
      while ( ! arquivo.eof ( ) )
      {
      // mostrar dado lido de arquivo
         if ( dado != null &&
         dado.length( ) > 0 )
         {
            IO.println ( ""+IO.getint(dado) );
         } // fim se
      // ler outro dado do teclado
         dado = arquivo.read ( );
      } // fim repetir
   // 6. fechar o arquivo (RECOMENDAVEL para a leitura)
      arquivo.close ( );
   // 7. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo10 ( )

// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0130 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      metodo10( );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0130