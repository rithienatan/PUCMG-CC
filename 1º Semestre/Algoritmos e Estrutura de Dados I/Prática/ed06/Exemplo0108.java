/**
 * Estudo Dirigido 0108
 *
 * Trabalho Pratico: ED 06
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 27/03/2016

 *@version 108
*

/**
 * Exemplo0108
 *
 * @author
 * @version 01
 */
// ---------------------------------------------- dependencias
import IO.*;
// ---------------------------------------------- definicao da classe principal
public class Exemplo0108
{
// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo01 ( int x )
   {
   // testar se valor positivo
      if ( x > 0 )
      {
      // mostrar valor
         IO.println ( "Valor lido = " + x );
      // tentar fazer de novo com valor menor
         metodo01 ( x-1 );
      } // fim se
   } // fim metodo01( )

   public static void metodo02 ( int x )
   {
   // testar se valor positivo
      if ( x > 0 )
      {
      // tentar fazer de novo com valor menor
         metodo02 ( x-1 );
      // mostrar valor ( acao pendente )
         IO.println ( "Valor = " + x );
      } // fim se
   } // fim metodo02( ) 

// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo03 ( int x )
   {
   // testar se contador valido
      if ( x > 1 )
      {
      // mostrar valor relativo
         IO.print ( " " + x );
      // tentar fazer de novo com valor menor
         metodo03 ( x-1 ); // motor da recursividade
      }
      else
      {
      // mostrar ultimo
         IO.println ( " " + x ); // base da recursividade
      } // fim se
   } // fim metodo03( )

// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo04 ( int x )
   {
   // testar se contador valido
      if ( x > 1 )
      {
      // mostrar valor relativo
         IO.print ( " " + 2*(x-1) );
      // tentar fazer de novo com valor menor
         metodo04 ( x-1 );
      }
      else
      {
      // mostrar ultimo
         IO.println ( " 1" );
      } // fim se
   } // fim metodo04( )

// ---------------------------------------------- definicao de metodo auxiliar
   public static void metodo05 ( int x )
   {
   // testar se contador valido
      if ( x > 1 )
      {
      // tentar fazer de novo com valor menor
         metodo05 ( x-1 );
      // mostrar valor relativo
         IO.print ( " + " + (2*(x-1)) + "/" + (2*x-1) );
      }
      else
      {
      // mostrar ultimo valor (primeiro na sequencia)
         IO.print ( " 1" );
      } // fim se
   } // fim metodo05( )

// ---------------------------------------------- definicao de metodo auxiliar
   public static int funcao01 ( int x )
   {
   // definir dado
      int resposta = 0;
   // testar se contador valido
      if ( x > 1 )
      {
      // tentar fazer de novo com valor menor
         resposta = x + funcao01 ( x-1 );
      // mostrar valor relativo
         IO.print ( " + " + x );
      }
      else
      {
      // mostrar ultimo
         IO.print ( " 1" );
      // ultima resposta
         resposta = 1;
      } // fim se
   // retornar resposta
      return ( resposta );
   } // fim funcao01( )

   public static double funcao02 ( int x )
   {
   // definir dado
      double resposta = 0.0;
   // testar se contador valido
      if ( x > 1 )
      {
      // calcular termo e tentar fazer de novo com valor menor
         resposta = (2.0*(x-1) / (2.0*x-1)) + funcao02 ( x-1 );
      // mostrar valor relativo
         IO.print ( " + " + 2*(x-1) + "/" + (2*x-1) );
      }
      else
      {
      // ultima resposta
         resposta = 1.0;
      // mostrar ultimo
         IO.print ( " 1" );
      } // fim se
   // retornar resposta
      return ( resposta );
   } // fim funcao02( )

   public static int funcao03 ( int x )
   {
   // definir dado
      int resposta = 1; // base
   // testar se contador valido
      if ( x >= 10 )
      {
      // tentar fazer de novo com valor menor
         resposta = 1 + funcao03 ( x/10 ); // motor 1
      }
      else
      {
         if ( x < 0 )
         {
         // fazer de novo com valor absoluto
            resposta = funcao03 ( -x ); // motor 2
         } // fim se
      } // fim se
   // retornar resposta
      return ( resposta );
   } // fim funcao03( )

// ---------------------------------------------- definicao do metodo principal
 /**
 * main() – metodo principal
 */
   public static void main ( String [ ] args )
   {
   // identificar
      IO.println ( "EXEMPLO0108 - Programa em Java" );
      IO.println ( "Autor: ________________________" );
   // executar o metodo auxiliar
      IO.println ( " Digitos = " + funcao03 ( 123 ) );
      IO.println ( " Digitos = " + funcao03 ( 0 ) );
      IO.println ( " Digitos = " + funcao03 ( -12 ) );
   // encerrar
      IO.pause ( "Apertar ENTER para terminar." );
   } // fim main( )
   
} // fim class Exemplo0108