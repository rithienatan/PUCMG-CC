/**
 * GuiaE2
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 * 
 *@version E2
*/

import jkarel.World;
import jkarel.Robot;

public class Guia00E2 extends Robot
{
   public Guia00E2(int avenue, int street, int direction, int beepers)
   {
      super(avenue, street, direction, beepers);
   }
   
   public static void createWorld( String nome )
   {
      World.reset();
      World.setTrace( false );
      World.placeBeepers( 4, 1, 6);
      World.saveWorld( nome );
   }
   
   public void turnRight()
   {
      turnLeft();
      turnLeft();
      turnLeft();
   }
   
   public void moveN( int steps )
   {
      if (steps > 0)
      {
         while(steps > 0)
         {
            move();
            steps = steps - 1;
         }
      }
   }
    
   public void putBeepers( int n )
   {
      if ( n > 0)
      {
         while (n > 0)
         {
            putBeeper();
            n = n - 1;
         }
      }
   }
                  
   public void executar()
   {
      moveN(0);
      moveN(3);
      while(nextToABeeper())
      {
         pickBeeper();
      }
      moveN(1);
      putBeepers(6);
      turnLeft();
      move();
   }
   
   public static void main (String[] args)
   {
      createWorld( "Guia00E2.txt" );
      World.reset();
      World.setSpeed( 7 );
      World.readWorld ( "Guia00E2.txt" );
      Guia00E2 JK = new Guia00E2( 1, 1, World.EAST, 0);
      JK.executar();
   }
}