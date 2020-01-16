/**
 * Estudo Dirigido 19
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 19
*/

import IO.*;

public class Exemplo0019
{
   public static void main (String[] args)
   {
      String x, y;
      int a, b;
      String z;
      
      x = IO.readString("Entre com uma sequência de digitos: ");
      
      y = IO.readString("Entre com uma sequência de digitos: ");
      
      a = IO.getint(x);
      
      b = IO.getint(y);
      
      x = x + a;
      
      y = y + b;
      
      z = x + "|" + y + "|" + a + "|" + b;
      
      IO.println ( "x = " + x );
      
      IO.println ( "y = " + y );
      
      IO.println ( "a = " + a );
      
      IO.println ( "b = " + b );
      
      IO.println ( "z = " + z );
   }
}
