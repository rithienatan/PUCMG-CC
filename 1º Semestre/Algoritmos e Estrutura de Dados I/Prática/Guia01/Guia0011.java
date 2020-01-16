/**
 * Guia0011
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 * 
 *@version 11
*/

import jkarel.World;
import jkarel.Robot;

public class Guia0011 extends Robot
{
   public Guia0011(int avenue, int street, int direction, int beepers)
   {
      super(avenue, street, direction, beepers);
   }
   
   public static void createWorld( String nome )
   {
      World.reset();
      World.setTrace( false );
      World.saveWorld( nome );
   }
   
   public void turnRight()
   {
      turnLeft();
      turnLeft();
      turnLeft();
   }
   
   public void move2()
   {
      move();
      move();
   }
   
   public void move3()
   {
      move();
      move();
      move();
   }
   
   public void executar()
   {
      move2();
      turnLeft();
      move2();
      putBeeper();
      turnRight();
      move3();
      putBeeper();
      turnLeft();
      move3();
      putBeeper();
      turnLeft();
      move3();
      move2();
      turnLeft();
      move3();
      move2();
      turnLeft();
   }
   
   public static void main (String[] args)
   {
      createWorld( "Guia0011.txt" );
      World.reset();
      World.setSpeed( 7 );
      World.readWorld ( "Guia0011.txt" );
      Guia0011 JK = new Guia0011( 1, 1, World.EAST, 3);
      JK.executar();
   }
}
