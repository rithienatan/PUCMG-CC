/**
 * Recuperação 01
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 08/04/2016

 *@version 01
*
*/

import IO.*;

public class recuperacao01
{
   public static void exercicio01( )
   {
      int n = IO.readint( "Digite uma quantidade: " );
      int x;
      
      if( !(n < 0) )
      {
         while( n > 0 )
         {
            x = IO.readint( "Digite um número inteiro: " );
            
            if( x > 0 )
            {
               IO.println( "Número positivo: "+x );
            }
            else if( x == 0 )
            {
               IO.println( "Número neutro: "+x );
            }
            else if( x < 0 )
            {
               IO.println( "Número negativo: "+x );
            }
            
            n = n - 1;
         }
      }
   }
   
   public static void exercicio02( )
   {
      int n = IO.readint( "Digite uma quantidade: " );
      int x;
      int contador_p = 0, contador_n = 0, contador_nn = 0;
      
      if( !(n < 0) )
      {
         while( n > 0 )
         {
            x = IO.readint( "Digite um número inteiro: " );
            
            if( x > 0 )
            {
               IO.println( "Número positivo: "+x );
               contador_p = contador_p + 1;
            }
            else if( x == 0 )
            {
               IO.println( "Número neutro: "+x );
               contador_nn = contador_nn + 1;
            }
            else if( x < 0 )
            {
               IO.println( "Número negativo: "+x );
               contador_n = contador_n + 1;
            }

            n = n - 1;
         }
         IO.println( "Quantidade de números positivos: "+contador_p );
         IO.println( "Quantidade de números negativos: "+contador_n );
         IO.println( "Quantidade de números iguais a 0: "+contador_nn );
         
      }
      else
      { 
         IO.println( "Quantidade errada!!" );
      }  
   }
   
   public static void exercicio03( )
   {
      String cadeia = IO.readString( "Digite uma cadeia de caractere: " );
      int n = cadeia.length( );
      int posicao;
      
      for( posicao = 0; posicao < n; posicao = posicao + 1 )
      {
         if( cadeia.charAt( posicao ) >= 'A' && cadeia.charAt( posicao ) <= 'Z' )
         {
            IO.println( "Letra maiuscula: "+cadeia.charAt( posicao ) );
         }
         else if( cadeia.charAt( posicao ) >= 'a' && cadeia.charAt( posicao ) <= 'z' )
         {
            IO.println( "Letra minúscula: "+cadeia.charAt( posicao ) );
         }
         else if( cadeia.charAt( posicao ) >= '0' && cadeia.charAt( posicao ) <= '9' )
         {
            IO.println( "Digito: "+cadeia.charAt( posicao ) );
         }
         else
         {
            IO.println( "Simbolo qualquer: "+cadeia.charAt( posicao ) );
         }
      }
   }

   public static void exercicio04( )
   {
      String cadeia = IO.readString( "Digite uma cadeia de caractere: " );
      int n = cadeia.length( );
      int posicao;
      int contador_m = 0, contador_M = 0, contador_d = 0, contador_s = 0;
      
      for( posicao = 0; posicao < n; posicao = posicao + 1 )
      {
         if( cadeia.charAt( posicao ) >= 'A' && cadeia.charAt( posicao ) <= 'Z' )
         {
            IO.println( "Letra maiuscula: "+cadeia.charAt( posicao ) );
            contador_M = contador_M + 1;
         }
         else if( cadeia.charAt( posicao ) >= 'a' && cadeia.charAt( posicao ) <= 'z' )
         {
            IO.println( "Letra minúscula: "+cadeia.charAt( posicao ) );
            contador_m = contador_m + 1;
         }
         else if( cadeia.charAt( posicao ) >= '0' && cadeia.charAt( posicao ) <= '9' )
         {
            IO.println( "Digito: "+cadeia.charAt( posicao ) );
            contador_d = contador_d + 1;
         }
         else
         {
            IO.println( "Simbolo qualquer: "+cadeia.charAt( posicao ) );
            contador_s = contador_s + 1;
         }
      }
      IO.println( "Número de letras maiusculas: "+contador_M );
      IO.println( "Número de letras minusculas: "+contador_m );
      IO.println( "Número de digitos: "+contador_d );
      IO.println( "Número de simbolos: "+contador_s );
   }

   public static void exercicio05( )
   {
      int n = IO.readint( "Digite uma quantidade: " );
      double x;
      int contador_n = 0, contador_x = 0, contador_z = 0;
      
      if( n >= 0 )
      {
         while( n > 0 )
         {
            x = IO.readdouble( "Digite um número qualquer: " );
            
            if( x < -0.25 )
            {
               contador_n = contador_n + 1;
            }
            else if( x >= -0.25 && x <= 0.75 )
            {
               contador_x = contador_x + 1;
            }
            else
            {
               contador_z = contador_z + 1;
            }
            
            n = n - 1;
         }
      }
      IO.println( "Quantidade de números menores que -0.25: "+contador_n );
      IO.println( "Quantidade de números maiores, iguais ou menores que -0.25 e 0.75: "+contador_x );
      IO.println( "Quantidade de números maiores que 0.75: "+contador_z );
   }

   public static void exercicio06( )
   {
      double a = IO.readint( "Digite um número para o intervalo: " );
      double b = IO.readint( "Digite outro número para o intervalo: " );
      double k = 0, l = 0;
      double x;
      int contador_n = 0, contador_z = 0, contador_y = 0, contador_g = 0;
      double por_a = 0.0, por_b = 0.0, por_e = 0.0;
      
      if( a > b )
      {
         k = a;
         l = b;
      }
      else if( b > a )
      {
         k = b;
         l = a;
      }
      // o k é sempre maior
      
       x = IO.readdouble( "Digite um número qualquer: " ); 
         while( x != 0 )
         {
            x = IO.readdouble( "Digite um número qualquer: " );
            
            if( l <= x && x <= k )
            {
               contador_n = contador_n + 1;
            }
            else if( x < l )
            {
               contador_z = contador_z + 1;
            }
            else if( x > k )
            {
               contador_y = contador_y + 1;
            }
            contador_g = contador_g + 1;
         }
      
      if( contador_g != 0 )
      {
         por_e = ( contador_n*100.0 )/ contador_g ;
         por_a = ( contador_z*100.0 )/ contador_g ;
         por_b = ( contador_y*100.0 )/ contador_g ;
      }
      
      IO.println( "Porcentagem entre o intervalo: "+por_e );
      IO.println( "Porcentagem abaixo do intervalo: "+por_a );
      IO.println( "Porcentagem acima do intervalo: "+por_b );
   }

   public static void exercicio07( )
   {
      int x, y, z;
      
      x = IO.readint( "Digite um número inteiro: " );
      y = IO.readint( "Digite outro número inteiro: " );
      z = IO.readint( "Digite outro número inteiro: " );
      
      if( !( x == y && x == z && y == z ) )
      {
         if( x < y && y < z )
         {
            IO.println( "Ordem crescente!!" );
         }
         else if( x > y && y > z )
         {
            IO.println( "Ordem decrescente!!" );
         }
         else if( x < y && y >= z )
         {
            IO.println( "Estão desordenados!!" );
         }
         else if( x > y && y <= z )
         {
            IO.println( "Estão desordenados!!" );
         }
         else if( x >= z && y < z )
         {
            IO.println( "Estão desordenados!!" );
         }
         else if( x >= z && y > z )
         {
            IO.println( "Estão desordenados!!" );
         }
         else if( x <= z && y > z )
         {
            IO.println( "Estão desordenados!!" );
         }
         else if( x >= z && y < z )
         {
            IO.println( "Estão desordenados!!" );
         }
      }
      else
      {
         IO.println( "São todos iguais" );
      }
   }

   public static void exercicio08( )
   {
      char x, y, z;
      
      x = IO.readchar( "Digite um número caracter: " );
      y = IO.readchar( "Digite outro número caracter: " );
      z = IO.readchar( "Digite outro número caracter: " );
      
      if( !( x == y && x == z && y == z ) )
      {
         if( x < y && y < z )
         {
            IO.println( "Ordem crescente!!" );
         }
         else if( x > y && y > z )
         {
            IO.println( "Ordem decrescente!!" );
         }
         else if( x > y && y < z )
         {
            IO.println( "Estão desordenados!!" );
         }
         else if( x < y && y > z )
         {
            IO.println( "Estão desordenados!!" );
         }
      }
      else
      {
         IO.println( "São todos iguais" );
      }
   }

   public static void exercicio09( )
   {
      char x, y, z;
      int a, b, c;
      
      x = IO.readchar( "Digite um número caracter: " );
      y = IO.readchar( "Digite outro número caracter: " );
      z = IO.readchar( "Digite outro número caracter: " );
      
      a = (int)x;
      b = (int)y;
      c = (int)z;
      
         if( a < b && b < c )
         {
            IO.println( x );
            IO.println( y );
            IO.println( z );
         }
   }

   public static int compareTo ( String a, String b )
   {
      int resultado = 0, x, y;
      
      x = a.length( );
      y = b.length( );
      
      if( x > y )
      {
         resultado = 1;
      }
      else if( x < y )
      {
         resultado = -1;
      }
      else
      {
         resultado = 0;
      }
      
      return ( resultado );   
   }
   
   public static void exercicio10( )
   {
      String x, y, z;
      
      x = IO.readString( "Digite um cadeia caracter: " );
      y = IO.readString( "Digite outro cadeia caracter: " );
      z = IO.readString( "Digite outro cadeia caracter: " );
      
         if( compareTo( x, y ) == 1 && compareTo( y, z ) == 1 )
         {
            IO.println( "Ordem decrescente!!" );
         }
         else if( compareTo( x, y ) == -1 && compareTo( y, z ) == -1 )
         {
            IO.println( "Ordem crescente!!" );
         }
         else
         {
            IO.println( "Em outra ordem!!" );
         }
   }


   public static void main ( String [] args )
   {
      int n;
      
      IO.println( "Digite : "+"\n"
                  +" 1 - exercicio01  2 - exercicio02"+"\n"
                  +" 3 - exercicio03  4 - exercicio04"+"\n"
                  +" 5 - exercicio05  6 - exercicio06"+"\n"
                  +" 7 - exercicio07  8 - exercicio08"+"\n"
                  +" 9 - exercicio09  10 - exercicio10"+"\n"
                  +" 0 - Parar o programa!!!" );
      
      do
      {
         n = IO.readint( "Digite o número de um metodo: "+"\n" );
            
            if( n == 1 )
            {
               exercicio01( );
            }
            else if( n == 2 )
            {
               exercicio02( );
            }
            else if( n == 3 )
            {
               exercicio03( );
            }
            else if( n == 4 )
            {
               exercicio04( );
            }
            else if( n == 5 )
            {
               exercicio05( );
            }
            else if( n == 6 )
            {
               exercicio06( );
            }
            else if( n == 7 )
            {
               exercicio07( );
            }
            else if( n == 8 )
            {
               exercicio08( );
            }
            else if( n == 9 )
            {
               exercicio09( );
            }
            else if( n == 10 )
            {
               exercicio10( );
            }
            else if( n == 0 )
            {
               IO.pause( "\n"+"Fim do programa!!!" );
            }
            else if( n < 0 || n > 10 )
            {
               IO.println( "ERROR!! Comando inválido!!" );
            }
      }
      while( n != 0 );
   }
}