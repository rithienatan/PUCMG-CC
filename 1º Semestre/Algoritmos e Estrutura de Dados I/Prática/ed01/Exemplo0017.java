/**
 * Estudo Dirigido 17
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 17
*/

import IO.*;

public class Exemplo0017
{
   public static void main (String[] args)
   {
      char x, y;
      String z;
      
      x = IO.readchar("Digite um caracter: ");
      
      z = IO.readString("Digite um caracter: ");
      
      y = IO.getchar(z);
      
      z = ""+x+y;
      
      IO.println ( "x = " + x );
      
      IO.println ( "y = " + y );
      
      IO.println ( "z = " + z );
   }
}
