import IO.*;

class Arranjo
{
   public Object [] tabela;
   
   public Arranjo()
   {
      tabela = null;
   }
   
   public Arranjo (int tamanho)
   {
      if(tamanho <= 0)
      {
         IO.println("ERRO. Quantidade inválida!");
      }
      else
      {
         tabela = new Object[tamanho];
      }
   }
   
   public int length()
   {
      int tamanho = 0;
      
      if (tabela != null)
      {
         tamanho = tabela.length;
      }
      return(tamanho);
   }
   
   public void printArray()
   {
      int tamanho, posicao;
      
      if(tabela == null)
      {
         IO.println("ERRO. Tabela vazia!!!");
      }
      else
      {
         tamanho = length();
         
         IO.println("Tabela com "+tamanho+" posições: ");
         
         for(posicao = 0; posicao < tamanho; posicao = posicao + 1)
         {
            IO.println("Posição "+posicao+" tem valor = "+tabela[posicao]);
         }
      }
   }
   
   public void readArray(String menssage)
   {
      int tamanho = length(), posicao;
      String linha;
      
      if(tabela == null)
      {
         IO.println("ERRO. Tabela vazia!!!");
      }
      else
      {
         IO.println(menssage);
         tamanho = this.length();
         for(posicao = 0; posicao < tamanho; posicao = posicao + 1)
         {
            linha = IO.readln();
            tabela[posicao] = linha;
         }
      }
   }
   
   public void readIntArray(String message, int n)
   {
      int tamanho = length(), posicao;
      String linha;
      
      if(tabela == null)
      {
         IO.println("ERRO. Tabela vazia!!!");
      }
      else
      {
         IO.println(message);
         tamanho = this.length();
         for(posicao = 0; posicao < tamanho; posicao = posicao + 1)
         {
            linha = IO.readln();
            tabela[posicao] = IO.getint(linha);
         }
      }
   }
   
   public void printIntArray(int n)
   {
      int posicao, tamanho = length();
      
      if(tabela == null || n <= 0 || n > tamanho)
      {
         IO.println("ERRO. Tabela vazia ou quantidade inválida!!!");
      }
      else
      {
         IO.println("Tabela com "+tamanho+" posições: ");
         
         for(posicao = 0; posicao < tamanho; posicao = posicao + 1)
         {
            IO.println ( "Posicao = "+posicao+
               " tem valor = "+(int) tabela [ posicao ] );
         }
         
      }
   }
   
   public Arranjo clone()
   {
      int tamanho, posicao;
      Arranjo nova = null;
      
      if(tabela == null)
      {
         IO.println("ERRO. Tabela vazia ou quantidade inválida!!!");
      }
      else
      {
         tamanho = length();
         
         nova = new Arranjo(tamanho);
         
         if(nova == null)
         {
            IO.println("Não há espaço!!");
         }
         else
         {
            for(posicao = 0; posicao < tamanho; posicao = posicao + 1)
            {
               nova.tabela[posicao] = tabela [posicao];
            }
         }
      }
      return(nova);
   }
   
   public Arranjo copyArray(int n)
   {
      int posicao, tamanho = length();
      Arranjo nova = null;
      
      if(tabela == null || n <= 0 || n > tamanho)
      {
         IO.println("ERRO. Tabela vazia ou quantidade inválida!!!");
      }
      else
      {
         nova = new Arranjo (n);
         
         if(nova == null)
         {
            IO.println("Não há espaço!!");
         }
         else
         {
            for(posicao = 0; posicao < tamanho; posicao = posicao + 1)
            {
               nova.tabela[posicao] = tabela [posicao];
            }
         }
      
      }
      return(nova);
   }
   
   public String toString()
   {
      String msg = null;
      int posicao, tamanho;
      
      if (tabela != null)
      {
         tamanho = length();
         
         msg = "";
         for(posicao = 0; posicao < tamanho; posicao = posicao + 1)
         {
            msg = msg + " " + tabela[posicao];
         }
      }
      return(msg);
   }
}

public class arranjo
{
   public static void metodo01 ( )
   {
   // 1. definir dados
      Arranjo a1 = null; // nao existe objeto
      Arranjo a2 = new Arranjo ( ); // existe objeto (sem dados, no momento)
   // 2. identificar
      IO.println ( "Definicoes de arranjo" );
   // 3. testar as definicoes de arranjo
      if ( a1 == null )
      {
         IO.println ( "Arranjo a1 nulo" );
      }
      else
      {
         IO.println ( "Arranjo a1 nao nulo" );
      } // fim se
      if ( a2 == null )
      {
         IO.println ( "Arranjo a2 nulo" );
      }
      else
      {
         IO.println ( "Arranjo a2 nao nulo" );
      } // fim se
   // 5. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo01( )



   public static void metodo02 ( )
   {
   // 1. definir dados
      Arranjo a1 = null;
      Arranjo a2 = new Arranjo ( );
      Arranjo a3 = new Arranjo ( 3 );
   // 3. testar as definicoes de arranjo
      if ( a3 == null )
      {
         IO.println ( "Arranjo a3 nulo" );
      }
      else
      {
         IO.println ( "Arranjo a3 nao nulo com "+a3.length( )+" posicoes." );
      } // fim se
   }




/**
 * Testar entrada e saida de dados em arranjo usando classe.
 */
   public static void metodo03 ( )
   {
   // 1. definir dados
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em arranjo" );
      IO.println ( );
   // 3. testar entrada e saida em arranjo
      if ( a3 == null )
      {
         IO.println ( "Arranjo a3 nulo" );
      }
      else
      {
      // mostrar informacoes sobre arranjo
         IO.println ( "Arranjo a3 nao nulo com "+a3.length( )+" posicoes." );
      // mostrar dados no arranjo
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printArray ( );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo03( )




 /**
 * Testar entrada e saida de dados em arranjo usando classe.
 */
   public static void metodo04 ( )
   {
   // 1. definir dados
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em arranjo" );
      IO.println ( );
   // 3. testar entrada e saida em arranjo
      if ( a3 == null )
      {
         IO.println ( "Arranjo a3 nulo" );
      }
      else
      {
      // mostrar informacoes sobre arranjo
         IO.println ( "Arranjo a3 nao nulo com "+a3.length( )+" posicoes." );
      // ler dados e guardar no arranjo
         a3.readArray ( "Entrar com dados no arranjo:" );
      // mostrar dados no arranjo
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printArray ( );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo04( )




/**
 * Testar entrada e saida de dados em arranjo usando classe.
 */
   public static void metodo05 ( )
   {
   // 1. definir dados
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em arranjo" );
      IO.println ( );
   // 3. testar entrada e saida em arranjo
      if ( a3 == null )
      {
         IO.println ( "Arranjo a3 nulo" );
      }
      else
      {
      // mostrar informacoes sobre arranjo
         IO.println ( "Arranjo a3 nao nulo com "+a3.length( )+" posicoes." );
      // ler dados e guardar no arranjo
         a3.readIntArray ( "Entrar com dados no arranjo:", 2 );
      // mostrar dados no arranjo
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printArray ( );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo05( )




 /**
 * Testar entrada e saida de dados em arranjo usando classe.
 */
   public static void metodo06 ( )
   {
   // 1. definir dados
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em arranjo" );
      IO.println ( );
   // 3. testar entrada e saida em arranjo
      if ( a3 == null )
      {
         IO.println ( "Arranjo a3 nulo" );
      }
      else
      {
      // mostrar informacoes sobre arranjo
         IO.println ( "Arranjo a3 nao nulo com "+a3.length( )+" posicoes." );
      // ler dados e guardar no arranjo
         a3.readIntArray ( "Entrar com dados no arranjo:", 2 );
      // mostrar dados no arranjo
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printIntArray ( 2 );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo06( )




 /**
 * Testar entrada e saida de dados em arranjo usando classe.
 */
   public static void metodo07 ( )
   {
   // 1. definir dados
      Arranjo a2 = null;
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em arranjo" );
      IO.println ( );
   // 3. testar entrada e saida em arranjo
      if ( a3 == null )
      {
         IO.println ( "Arranjo a3 nulo" );
      }
      else
      {
      // mostrar informacoes sobre arranjo
         IO.println ( "Arranjo a3 nao nulo com "+a3.length( )+" posicoes." );
      // ler dados e guardar no arranjo
         a3.readIntArray ( "Entrar com dados no arranjo:", 2 );
      // tornar arranjos identicos
         a2 = a3;
      // mostrar dados no arranjo
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a2.printIntArray ( 2 );
      // ler dados e guardar no arranjo
         a2.readIntArray ( "Entrar com dados no arranjo:", 3 );
      // mostrar dados no arranjo original
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printIntArray ( 3 );
      // mostrar dados no arranjo copiado
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a2.printIntArray ( 3 );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo07( )




/**
 * Testar entrada e saida de dados em arranjo usando classe.
 */
   public static void metodo08 ( )
   {
   // 1. definir dados
      Arranjo a2 = null;
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em arranjo" );
      IO.println ( );
   // 3. testar entrada e saida em arranjo
      if ( a3 == null )
      {
         IO.println ( "Arranjo a3 nulo" );
      }
      else
      {
      // mostrar informacoes sobre arranjo
         IO.println ( "Arranjo a3 nao nulo com "+a3.length( )+" posicoes." );
      // ler dados e guardar no arranjo
         a3.readIntArray ( "Entrar com dados no arranjo:", 3 );
      // tornar arranjos identicos
         a2 = a3.clone ( );
      // mostrar dados no arranjo
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a2.printIntArray ( 3 );
      // ler dados e guardar no arranjo
         a2.readIntArray ( "Entrar com dados no arranjo:", 3 );
      // mostrar dados no arranjo original
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printArray ( );
      // mostrar dados no arranjo copiado
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a2.printIntArray ( 3 );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo08( )




 /**
 * Testar entrada e saida de dados em arranjo usando classe.
 */
   public static void metodo09 ( )
   {
   // 1. definir dados
      Arranjo a2 = null;
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em arranjo" );
      IO.println ( );
   // 3. testar entrada e saida em arranjo
      if ( a3 == null )
      {
         IO.println ( "Arranjo a3 nulo" );
      }
      else
      {
      // mostrar informacoes sobre arranjo
         IO.println ( "Arranjo a3 nao nulo com "+a3.length( )+" posicoes." );
      // ler dados e guardar no arranjo
         a3.readIntArray ( "Entrar com dados no arranjo:", 3 );
      // tornar arranjos identicos
         a2 = a3.copyArray( 3 );
      // mostrar dados no arranjo copiado
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a2.printIntArray ( 3 );
      // mostrar dados no arranjo original
         IO.println ( "Mostrar dados lidos e armazenados:" );
         a3.printIntArray ( 3 );
      } // fim se
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo09( )




/**
 * Testar entrada e saida de dados em arranjo usando classe.
 */
   public static void metodo10 ( )
   {
   // 1. definir dados
      Arranjo a2 = null;
      Arranjo a3 = new Arranjo ( 3 );
   // 2. identificar
      IO.println ( );
      IO.println ( "Entrada e saida em arranjo" );
      IO.println ( );
   // 3. testar entrada e saida em arranjo
   // ler dados e guardar no arranjo
      a3.readArray ( "Entrar com dados no arranjo:" );
   // tornar arranjos identicos
      a2 = a3.copyArray( 2 );
   // mostrar dados no arranjo copiado
      IO.println ( "Mostrar dados lidos e armazenados:" );
      IO.println ( ""+a2 );
   // mostrar dados no arranjo original
      IO.println ( "Mostrar dados lidos e armazenados:" );
      IO.println ( ""+a3 );
   // 4. encerrar
      IO.println ( );
      IO.pause ( "Apertar ENTER para continuar." );
   } // fim metodo10( )

   
   
   public static void main (String [] args)
   {
      metodo01();
   }
}