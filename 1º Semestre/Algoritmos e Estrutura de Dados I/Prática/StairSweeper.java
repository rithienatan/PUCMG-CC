/*
 Rithie... 
 06/08
*/
//
// lista de dependecias
//
   import jkarel.World;
   import jkarel.Robot;

/**
  * exemplo de programa para uso com a classe JKarel.
  */
public class StairSweeper extends Robot
{
 /**
   * construtor padrao da classe StairSweeper.
   */
    public StairSweeper ( int avenue, int street, int direction, int beepers )
    {
     // repassara' dados ao construtor padrao da classe original
        super ( avenue, street, direction, beepers );
    } // end constructor ( )
 /**
   * metodo para criar escada.
   * @param filename nome do arquivo para guardar a descricao
   */
    public static void createWorld ( String filename )
    {
     // o executor deste metodo (World - agente)
     // ja' foi definido na class Robot
        World.reset ( );
        World.setTrace ( false );

        World.placeNSWall ( 1, 1, 1 );
        World.placeNSWall ( 2, 2, 1 );
        World.placeNSWall ( 3, 3, 1 );
        World.placeNSWall ( 4, 1, 3 );

        World.placeEWWall ( 2, 1, 1 );
        World.placeEWWall ( 3, 2, 1 );
        World.placeEWWall ( 4, 3, 1 );

        World.placeBeepers( 2, 2, 1 );
        World.placeBeepers( 3, 3, 1 );
        World.placeBeepers( 4, 4, 1 );

        World.saveWorld ( filename );
    } // end createWorld( )

 /**
   * metodo para virar 'a direita.
   */
    public void turnRight ( )
    {
     // o executor deste metodo
     // deve virar tres vezes 'a esquerda
        turnLeft( );
        turnLeft( );
        turnLeft( );
    } // end turnRight( )

 /**
   * metodo para subir escada.
   */
    public void climbStair ( )
    {
     // se estiver voltado para cima,
     // mover-se uma posicao nesse sentido
        move ( );
     // virar 'a direita
        turnRight( );
     // mover-se uma posicao para a direita
        move ( );
     // voltar-se para cima
        turnLeft ( );
     // OBS.: O agente esta' implicito (nao precisa do this),
     //       porque o metodo pode ser executado
     //       por qualquer agente definido por essa classe.
    } // end climbStair ( )

 /**
   * tarefa: subir uma escada,
   *         recolher tres marcadores,
   *         desligar-se.
   */
  
//Descer escada
    public void downStair ( )
    {
      turnLeft( );
      move( );
    }
    public void task ( )
    {
     // voltar-se para norte
        turnLeft ( );
     // subir um degrau, segundo o novo metodo definido
        climbStair ( );
     // recolher o primeiro marcador
        pickBeeper ( );
     // subir mais um degrau
        climbStair ( );
     // recolher o segundo marcador
        pickBeeper ( );
     // subir mais um degrau
        climbStair ( );
     // recolher o terceiro marcador
        pickBeeper ( );
    } // end task ( )

  /**
    *  acao principal: executar a tarefa descrita acima.
    */
    public static void main ( String [ ] args )
    {
     // criar o ambiente com escada
     // OBS.: executar pelo menos uma vez
     //       antes de qualquer outra coisa,
     //       ou se alterar a configuracao do mundo
        createWorld ( "stair.wld" );

     // comandos para tornar o mundo visivel
        World.reset    ( );
        World.setSpeed ( 5 );
        World.readWorld( "stair.wld" );

     // definir o objeto particular para executar as acoes (agente)
        StairSweeper JK = new StairSweeper ( 1, 1, World.EAST, 0 );

     // executar a segunda tarefa
     // recolher os marcadores
        JK.task ( );

        } // end main ( )
} // end class
