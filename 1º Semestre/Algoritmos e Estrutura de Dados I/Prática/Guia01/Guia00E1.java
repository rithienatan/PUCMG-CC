/**
 * GuiaE1
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 * 
 *@version E1
*/

import jkarel.World;
import jkarel.Robot;

public class Guia00E1 extends Robot
{
   public Guia00E1(int avenue, int street, int direction, int beepers)
   {
      super(avenue, street, direction, beepers);
   }
   
   public static void createWorld( String nome )
   {
      World.reset();
      World.setTrace( false );
      //World.placeBeepers( 5, 3, 6);
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
    
   /*public void colocar( int Put )
   {
      int col = 0;
      
      for ( col = 0; col < Put; col = col + 1)
      {
         putBeeper();
      }
   }*/
                  
   public void executar()
   {
      moveN(0);
      moveN(3);
   }
   
   public static void main (String[] args)
   {
      createWorld( "Guia00E1.txt" );
      World.reset();
      World.setSpeed( 7 );
      World.readWorld ( "Guia00E1.txt" );
      Guia00E1 JK = new Guia00E1( 1, 1, World.EAST, 0);
      JK.executar();
   }
}