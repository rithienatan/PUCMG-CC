/**
 * Guia0014
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 * 
 *@version 14
*/

import jkarel.World;
import jkarel.Robot;

public class Guia0014 extends Robot
{
   public Guia0014(int avenue, int street, int direction, int beepers)
   {
      super(avenue, street, direction, beepers);
   }
   
   public static void createWorld( String nome )
   {
      World.reset();
      World.setTrace( false );
      World.placeBeepers( 2, 3, 1);
      World.placeBeepers( 3, 7, 1);
      World.placeBeepers( 6, 3, 1);
      World.placeEWWall( 3, 2, 3);
      World.placeEWWall( 3, 6, 3);
      World.placeNSWall( 2, 3, 4);
      World.placeNSWall( 5, 3, 3);
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
   
   public void move4()
   {
      move();
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
        
   public void executar()
   {
      turnLeft();
      move2();
      turnRight();
      move();
      pickBeeper();
      turnLeft();
      move4();
      turnRight();
      move();
      pickBeeper();
      move3();
      turnRight();
      move4();
      pickBeeper();
      turnLeft();
      turnLeft();
      move3();
      turnLeft();
      move3();
      turnLeft();
      move3();
      if(anyBeepersInBeeperBag())
      {
         putBeeper();
      }
      turnLeft();
      move();
      turnLeft();
      move3();
      turnRight();
      move2();
      turnRight();
      move5();
      turnRight();
      move5();
      turnLeft();
      turnLeft();
   }
   
   public static void main (String[] args)
   {
      createWorld( "Guia0014.txt" );
      World.reset();
      World.setSpeed( 7 );
      World.readWorld ( "Guia0014.txt" );
      Guia0014 JK = new Guia0014( 1, 1, World.EAST, 0);
      JK.executar();
   }
}