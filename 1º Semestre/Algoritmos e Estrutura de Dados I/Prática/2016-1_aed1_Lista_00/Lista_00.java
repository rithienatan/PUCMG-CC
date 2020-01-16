/**
  * ---------------------------------------------- Documentacao preliminar
  * Pontificia Universidade Catolica de Minas Gerais
  * Curso de Ciencia da Computacao
  * Algoritmos e Estruturas de Dados I
  *
  * Trabalho pratico: Lista 00
  *
  * Objetivo:
  * Modelo de programa para a disciplina AED I
  * Sugestao para montar um trabalho pratico
  *
  * Autor:   Matricula: 999999  Nome: xxx yyy zzz
  * Versao:  1.0                Data: 01/mm/20aa
  *
  * Dados:
  * - opcao de execucao escolhida pelo usuario
  *
  * Resultados:
  * - execucao de um teste de cada vez a escolha do usuario
  *
  * Condicoes:
  * - so' aceitara' as opcoes oferecidas.
  * - a classe IO devera' estar acessivel.
  *
  * Arquivos:
  *
  * - Lista_00.java
  * - Lista_00.class
  * - IO.jar    ( por exemplo em C:\java\jre\lib\ext\IO.jar )
  *
  * Forma de compilacao:
  * - acionar o compilador no modo console:
  *
  *   <drive>:>javac   Lista_00.java
  *   ou
  *   <drive>:>compile Lista_00
  *
  * Forma de uso:
  * - acionar o programa no modo console:
  *
  *   <drive>:>java Lista_00
  *   ou
  *   <drive>:>run  Lista_00
  *
  * - escolher uma das opcoes oferecidas.
  *
  * Referencias:
  * - Exemplos mostrados em sala de aula
  * - Apostila: Fundamentos de Programacao - Notas de aulas
  *
  */

// ---------------------------------------------- classes nativas
//                                                ou auxiliares

   import IO.*;

// ---------------------------------------------- definicao de classe

/**
  * Lista_00 - modelo para definir uma classe.
  *            Obs.: O nome da classe  (Lista_00) deve concordar com
  *                  o nome do arquivo (Lista_00.java), inclusive no
  *                  uso de maiusculas e minusculas.
  */
   public class Lista_00
   {
   // ---------------------------------------------- conversao para String

   /**
    * metodo para identificar a classe (neste caso).
    * OBS.: Nao sera' necessario para esta lista de exercicios,
    *       mas servira' de modelo para listas futuras.
    * @return nome da classe
    */
      public String toString ( )
      {
         return ( "Lista_00" );
      } // end toString ( )

   // ---------------------------------------------- tratamento de erro


   // ---------------------------------------------- definicao de constantes


   // ---------------------------------------------- definicao de armazenadores


   // ---------------------------------------------- definicao de metodos restritos


   // ---------------------------------------------- definicao de construtor(es)


   // ---------------------------------------------- definicao de metodos publicos


   // ---------------------------------------------- definicao de metodos

   /**
    * Metodo01.
    */
      public static void metodo01 ( )
      {
       // identificar
          IO.println ( );
          IO.println ( "Metodo01" );
          IO.println ( );
       // encerrar
          IO.pause   ( "Apertar ENTER para continuar." );
      } // fim metodo01 ( )

   /**
    * Metodo02.
    */
      public static void metodo02 ( )
      {
       // identificar
          IO.println ( );
          IO.println ( "Metodo02" );
          IO.println ( );
       // encerrar
          IO.pause   ( "Apertar ENTER para continuar." );
      } // fim metodo02 ( )

   /**
    * Metodo03.
    */
      public static void metodo03 ( )
      {
       // identificar
          IO.println ( );
          IO.println ( "Metodo03" );
          IO.println ( );
       // encerrar
          IO.pause   ( "Apertar ENTER para continuar." );
      } // fim metodo03 ( )

   // ---------------------------------------------- definicao do metodo principal

      public static void main ( String [ ] args )
      {
      // definir dados
         int opcao;

      // repetir ate' desejar parar
         do
         {
         // identificar
            IO.println ( );   // para saltar linha
            IO.println ( "Lista_00 - v.0.0 - 01/mm/20aa" );
            IO.println ( "Preparacao para a Lista 01" );
            IO.println ( "Matricula: 999999 Nome: xxx yyy zzz" );
            IO.println ( );   // para saltar linha

         // mostrar opcoes
            IO.println ( "Opcoes:" );
            IO.println ( "0 - parar" );
            IO.println ( "1 - metodo 01" );
            IO.println ( "2 - metodo 02"  );
            IO.println ( "3 - metodo 03"  );
            IO.println ( );

         // ler opcao
            opcao = IO.readint ( "Qual a sua opcao? " );

         // escolher acao
            switch ( opcao )
            {
               case 0:
                  break;
               case 1:
                  metodo01 ( );
                  break;
               case 2:
                  metodo02 ( );
                  break;
               case 3:
                  metodo03 ( );
                  break;
               default:
                  break;
            } // fim escolher
         }
         while ( opcao != 0 );

      // encerrar execucao
         IO.println ( );
         IO.pause   ( "Apertar ENTER para terminar." );

      } // end main ( )

   } // fim Lista_00 class

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
