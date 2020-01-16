/**
 * Estudo Dirigido 0068
 *
 * Trabalho Pratico: ED 04
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016
 
 *@version 68
*/

 /* Exemplo0067
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0068
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo01 ( )
   {
   // definir dados
      String x;
   // identificar o metodo
      IO.println ( "Metodo 01" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
   } // fim metodo01( )

   public static void metodo02 ( )
   {
   // definir dados
      String x;
      int tamanho;
   // identificar o metodo
      IO.println ( "Metodo 02" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
   // obter o tamanho da cadeia
      tamanho = x.length( );
   // mostrar o tamanho da cadeia
      IO.println ( "tamanho de " + x + " = " + tamanho );
   } // fim metodo02( )

   public static void metodo03 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
   // identificar o metodo
      IO.println ( "Metodo 03" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
   // obter o tamanho da cadeia
      tamanho = x.length( );
   // mostrar o tamanho da cadeia
      IO.println ( "tamanho de " + x + " = " + tamanho );
   // mostrar cada simbolo separadamente
      for ( posicao=0; posicao<tamanho; posicao=posicao+1 )
      {
         IO.println ( "posicao = " + posicao
            + " contem " + x.charAt(posicao) );
      } // fim repetir
   } // fim metodo03( ) 

// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo04 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
   // identificar o metodo
      IO.println ( "Metodo 04" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
   // obter o tamanho da cadeia
      tamanho = x.length( );
   // mostrar o tamanho da cadeia
      IO.println ( "tamanho de " + x + " = " + tamanho );
   // mostrar cada simbolo separadamente
   // em ordem inversa
      for ( posicao=tamanho-1; posicao>=0; posicao=posicao-1 )
      {
         IO.println ( "posicao = " + posicao
            + " contem " + x.charAt(posicao) );
      } // fim repetir
   } // fim metodo04( )

// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo05 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
   // identificar o metodo
      IO.println ( "Metodo 05" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
   // obter o tamanho da cadeia
      tamanho = x.length( );
   // mostrar o tamanho da cadeia
      IO.println ( "tamanho de " + x + " = " + tamanho );
   // mostrar cada letra minuscula separadamente
      posicao = 0;
      while ( posicao<tamanho )
      {
         if ( x.charAt(posicao) >= 'a' &&
         x.charAt(posicao) <= 'z' )
         {
            IO.println ( "posicao = " + posicao
               + " contem " + x.charAt(posicao) );
         } // fim se
         posicao = posicao + 1;
      } // fim repetir
   } // fim metodo05( ) 

// ---------------------------------------------- definicao de metodo auxiliar
   public static boolean minuscula ( char simbolo )
   {
   // definir dado
      boolean resposta = false;
   // testar se letra minuscula
      if ( simbolo >= 'a' &&
      simbolo <= 'z' )
      {
         resposta = true;
      } // fim se
   // retornar resultado
      return ( resposta );
   } // fim minuscula ( )
   public static void metodo06 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
   // identificar o metodo
      IO.println ( "Metodo 06" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
   // obter o tamanho da cadeia
      tamanho = x.length( );
   // mostrar o tamanho da cadeia
      IO.println ( "tamanho de " + x + " = " + tamanho );
   // mostrar cada letra minuscula separadamente
      posicao = 0;
      while ( posicao<tamanho )
      {
         if ( minuscula ( x.charAt(posicao) ) )
         {
            IO.println ( "posicao = " + posicao
               + " contem " + x.charAt(posicao) );
         } // fim se
         posicao = posicao + 1;
      } // fim repetir
   } // fim metodo06( )

// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo07 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
      int contador = 0;
   // identificar o metodo
      IO.println( "Metodo 07" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
   // obter o tamanho da cadeia
      tamanho = x.length( );
   // mostrar o tamanho da cadeia
      IO.println ( "tamanho de " + x + " = " + tamanho );
   // contar letras minusculas
      contador = 0;
      posicao = 0;
      while ( posicao<tamanho )
      {
         if ( minuscula ( x.charAt(posicao) ) )
         {
            IO.println ( "posicao = " + posicao
               + " contem " + x.charAt(posicao) );
            contador = contador + 1;
         } // fim se
         posicao = posicao + 1;
      } // fim repetir
   // mostrar a quantidade de letras minusculas
      IO.println ( "letras minusculas = " + contador );
   } // fim metodo07( )

// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo08 ( )
   {
   // definir dados
      String x;
      int tamanho;
      int posicao;
      int contador;
      String minusculas;
   // identificar o metodo
      IO.println ( "Metodo 08" );
   // ler cadeia de caracteres do teclado
      x = IO.readString ( "Entrar com uma cadeia de caracteres: " );
      IO.println ( "Valor lido = " + x );
   // obter o tamanho da cadeia
      tamanho = x.length( );
   // mostrar o tamanho da cadeia
      IO.println ( "tamanho de " + x + " = " + tamanho );
   // contar e separar letras minusculas
      minusculas = "";
      contador = 0;
      posicao = 0;
      while ( posicao<tamanho )
      {
         if ( minuscula ( x.charAt(posicao) ) )
         {
            IO.println ( "posicao = " + posicao
               + " contem " + x.charAt(posicao) );
            contador = contador + 1;
            minusculas = minusculas + x.charAt(posicao);
         } // fim se
         posicao = posicao + 1;
      } // fim repetir
   // mostrar a quantidade de letras minusculas
      IO.println ( "letras minusculas = " + contador +
         " = " + minusculas );
   } // fim metodo08( )

// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0068 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      metodo08 ( ); // tratar caracteres
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
} // fim class Exemplo0068