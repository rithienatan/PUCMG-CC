/**
 * Guia0013
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 * 
 *@version 13
*/

import jkarel.World;
import jkarel.Robot;

public class Guia0013 extends Robot
{
   public Guia0013(int avenue, int street, int direction, int beepers)
   {
      super(avenue, street, direction, beepers);
   }
   
   public static void createWorld( String nome )
   {
      World.reset();
      World.setTrace( false );
      World.placeBeepers( 3, 3, 1);
      World.placeBeepers( 6, 3, 1);
      World.placeBeepers( 6, 6, 1);
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
   
   public void move5()
   {
      move();
      move();
      move();
      move();
      move();
   }
   
   public void putInOrder()
   {
      turnLeft();
      turnLeft();
      move();
      turnRight();
      move2();
      putBeeper();
      turnRight();
      move();
      putBeeper();
      move();
      putBeeper();
      move();
      turnLeft();
      turnLeft();
   }
   
   public void executar()
   {
      turnLeft();
      move5();
      turnRight();
      move5();
      pickBeeper();
      turnRight();
      move3();
      pickBeeper();
      turnRight();
      move3();
      pickBeeper();
      putInOrder();
   }
   
   public static void main (String[] args)
   {
      createWorld( "Guia0013.txt" );
      World.reset();
      World.setSpeed( 7 );
      World.readWorld ( "Guia0013.txt" );
      Guia0013 JK = new Guia0013( 1, 1, World.EAST, 0);
      JK.executar();
   }
}