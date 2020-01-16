/**
 * Estudo Dirigido 11
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 11
*/

import IO.*;

public class Exemplo0011
{
   public static void main (String[] args)
   {
      String x;
      int y;
      double z;
      
      y = IO.readint("Digite um número: ");
      z = IO.readdouble("Digite um número: ");
      
      x = ""+(y+z);
      
      IO.println ( "x = " + x );
      
      IO.println ( "y = " + y );
      
      IO.println ( "y = " + z );
   }
}
