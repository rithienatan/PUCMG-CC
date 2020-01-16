/**
 * Estudo Dirigido 18
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 18
*/

import IO.*;

public class Exemplo0018
{
   public static void main (String[] args)
   {
      String x, y;
      String z;
      
      x = IO.readString("Digite um caracter: ");
      
      y = IO.readString("Digite um caracter: ");
      
      z = x + "|" + y;
      
      IO.println ( "x = " + x );
      
      IO.println ( "y = " + y );
      
      IO.println ( "z = " + z );
   }
}
