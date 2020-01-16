/**
 * Estudo Dirigido 08
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 *
 *@version 08
*/

import IO.*;

public class Exemplo0008
{
   public static void main (String[] args)
   {
      boolean x;
   
      x = true; // ou false
   
   
      x = IO.readboolean ( "Entrar com um valor lógico: " );
      
      IO.println ( "x=" + x );  
   }
}
