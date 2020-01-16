/*
   Identificacao:
   Aluno:
   Matricula:
   Versao:
*/

//
// lista de dependecias
// ( por exemplo em C:\java\jre\lib\ext\jkarel.jar )
//
   import jkarel.World;
   import jkarel.Robot;

/**
  * exemplo de programa para uso da classe JKarel.
  */
public class Guia_00 extends Robot
{
 /**
   * construtor padrao da classe Guia_00.
   */
    public Guia_00 ( int avenue, int street, int direction, int beepers )
    {
     // repassar dados ao construtor padrao
     // da classe original (super)
        super ( avenue, street, direction, beepers );
    } // end constructor ( )
 /**
   * metodo para criar escada.
   * @param filename nome do arquivo 
   *        onde guardar a descricao
   */
    public static void createWorld ( String filename )
    {
     // o executor deste metodo (World - agente)
     // ja' foi definido na class Robot
        World.reset ( );               // iniciar um novo cenario
        World.setTrace ( false );      // dispensar narrativa

     // colocar paredes verticais   (sentido norte-sul)
        World.placeNSWall ( 1, 1, 1 ); // na posicao  (1,1), 1 parede
        World.placeNSWall ( 2, 2, 1 );
        World.placeNSWall ( 3, 3, 1 );
        World.placeNSWall ( 4, 1, 3 ); // a partir de (4,1), 3 paredes

     // colocar paredes horizontais (sentido leste-oeste)
        World.placeEWWall ( 2, 1, 1 ); // na posicao  (2,1), 1 parede
        World.placeEWWall ( 3, 2, 1 );
        World.placeEWWall ( 4, 3, 1 );

     // colocar marcadores
        World.placeBeepers( 2, 2, 1 ); // na posicao  (2,2), 1 marcador
        World.placeBeepers( 3, 3, 1 );
        World.placeBeepers( 4, 4, 1 );

     // gravar a configuracao
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
    public void climbStep ( )
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
    } // end climbStep ( )

 /**
   * tarefa: subir uma escada,
   *         recolher tres marcadores,
   *         desligar-se.
   */
    public void task ( )
    {
     // voltar-se para norte
        turnLeft ( );
     // subir um degrau, segundo o novo metodo definido
        climbStep ( );
     // recolher o primeiro marcador
        pickBeeper ( );
     // subir mais um degrau
        climbStep ( );
     // recolher o segundo marcador
        pickBeeper ( );
     // subir mais um degrau
        climbStep ( );
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
        createWorld ( "guia_00.txt" );

     // comandos para tornar o mundo visivel
        World.reset    ( );               // reiniciar o cenario
        World.setSpeed ( 6 );             // ajustar velocidade
        World.readWorld( "guia_00.txt" ); // ler descricao do cenario

     // definir o objeto para executar as acoes (agente)
        Guia_00 JK = new Guia_00 ( 1, 1, World.EAST, 0 );

     // executar a tarefa
     // para recolher os marcadores
        JK.task ( );

    } // end main ( )
} // end class

/*
// ---------------------------------------------- Documentacao complementar
//
// ---------------------------------------------- Historico
//
// Versao	Data	 Modificacao
// 0.0		01/mm	 esboco
//
// ---------------------------------------------- Testes
//
// Versao	Teste
// 0.0		01. ( OK )      teste do modelo
//
// ----------------------------------------------
*/
