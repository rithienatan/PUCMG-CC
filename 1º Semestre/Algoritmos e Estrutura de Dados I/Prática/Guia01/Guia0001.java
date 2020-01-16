/**
 * Guia0001
 *
 * Trabalho Pratico: Guia 01
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 14/02/2016
 * 
 *@version 01  
*/

import IO.*;
// ---------------------------------------------- definicao da classe principal

// Lista de dependencias
//
 import jkarel.World;
 import jkarel.Robot;

/**
 * Exemplo de programa para uso com a classe JKarel.
 */
public class Guia0001 extends Robot
{
/**
 * construtor padrao da classe Guia00.
 * @param avenue - uma das coordenadas da posicao inicial
 * @param street - outra das coordenadas da posicao inicial
 * @param direction - direcao inicial
 * @param beepers - quantidade inicial de marcadores
 */
 public Guia0001( int avenue, int street, int direction, int beepers )
 {
 // metodo para repassar dados
 // ao construtor padrao da classe original (Robot)
 super( avenue, street, direction, beepers );
 } // end Guia0001( )
/**
 * metodo para criar configuracoes do ambiente.
 * @param nome do arquivo onde guardar a configuracao
 */
 public static void createWorld( String nome )
 {
 // o executor deste metodo (World - agente)
 // ja' foi definido na classe original (Robot)
 World.reset( ); // limpar configuracoes
 // para nao exibir os passos de criacao do ambiente
 World.setTrace( false ); // (opcional)
 // para colocar marcador(es)
 World.placeBeepers( 4, 4, 1 ); // marcador no topo da escada
 // para guardar em arquivo
 World.saveWorld( nome ); // gravar configuracao
 } // end createWorld( )
/**
 * metodo para virar 'a direita.
 */
 public void turnRight( )
 {
 // o executor deste metodo
 // deve virar tres vezes 'a esquerda
 turnLeft( );
 turnLeft( );
 turnLeft( );
 } // end turnRight( )
 /**
 * Acao principal: executar a tarefa descrita acima.
 */
 public static void main( String [ ] args )
 {
 // criar o ambiente com escada
 // OBS.: executar pelo menos uma vez,
 // antes de qualquer outra coisa
 // (depois de criado, podera' ser comentado)
 createWorld( "Guia0001.txt" );
 // comandos para tornar o mundo visivel
 World.reset( ); // limpar configuracoes
 World.setSpeed ( 7 ); // escolher velocidade
 World.readWorld( "Guia0001.txt" ); // ler configuracao do ambiente
 // definir o objeto particular para executar as acoes (agente)
 Guia0001 JK = new Guia0001( 1, 1, World.EAST, 0 );
 // executar acoes
 JK.move( );
 JK.move( );
 JK.turnLeft( );
 JK.move( );
 JK.move( );
 JK.turnLeft( );
 JK.move( );
 JK.move( );
 JK.turnLeft( );
 JK.move( );
 JK.move( );
 JK.turnLeft( );
 JK.turnLeft( );
 JK.turnOff( );
 } // end main( )
} // end class
// ---------------------------------------------- testes
//
// Versao Teste
// 0.1 01. (OK)
//