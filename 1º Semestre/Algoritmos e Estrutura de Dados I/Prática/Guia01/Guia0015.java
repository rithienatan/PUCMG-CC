/**
 * Guia0015
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 * 
 *@version 15
*/

import jkarel.World;
import jkarel.Robot;

public class Guia0015 extends Robot
{
   public Guia0015(int avenue, int street, int direction, int beepers)
   {
      super(avenue, street, direction, beepers);
   }
   
   public static void createWorld( String nome )
   {
      World.reset();
      World.setTrace( false );
      World.placeBeepers( 5, 3, 6);
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
   
   public void mover( int Step )
   {
      int quantos = 0;
      
      for ( quantos = 0; quantos < Step; quantos = quantos + 1)
      {
         move();
      }
   }
    
   public void colocar( int Put )
   {
      int col = 0;
      
      for ( col = 0; col < Put; col = col + 1)
      {
         putBeeper();
      }
   }
                  
   public void executar()
   {
      mover(5);
      turnLeft();
      mover(5);
      turnLeft();
      move();
      turnLeft();
      mover(3);
      while(nextToABeeper())
      {
         pickBeeper();
      }
      turnLeft();
      turnLeft();
      mover(3);
      turnRight();
      move();
      turnRight();
      mover(3);
      colocar(1);
      move();
      turnRight();
      mover(4);
      turnRight();
      move();
      colocar(2);
      mover(4);
      turnRight();
      move();
      colocar(3);
      turnLeft();
      turnLeft();
      mover(2);
      turnLeft();
      mover(6);
      turnLeft();
   }
   
   public static void main (String[] args)
   {
      createWorld( "Guia0015.txt" );
      World.reset();
      World.setSpeed( 7 );
      World.readWorld ( "Guia0015.txt" );
      Guia0015 JK = new Guia0015( 1, 1, World.EAST, 0);
      JK.executar();
   }
}