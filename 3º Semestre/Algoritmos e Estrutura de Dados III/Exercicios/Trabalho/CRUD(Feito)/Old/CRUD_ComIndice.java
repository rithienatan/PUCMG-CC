/**
* @author Rithie Natan Carvalhaes Prado
* @author Lauro Milagres Oliveira
* @author Pedro Rodrigues de Freitas Faria
* @author Hugo Alves Duarte
* Matéria: AED III
* Data de Entrega: 30/08/2018
* Exercício: CRUD
* @version 0.1
*/

/**
* imports
*/

import java.io.*;
import java.util.*;

//-----------------------------------------------------------------------------

/**
* Classe Filme
*/
class Filme
{
  private int id;//id do Filme
  private String titulo;//Título
  private String tituloOrigi;//Título Original
  private String paisOrigem;//País de Origem
  private int anoLancamento;//Ano de Lançamento
  private int duracao;//Duração em minutos
  private String diretor;//Diretor
  private String sinopse;//Sinopse

  //metodos construtores-------------------------------------------------------
  /**
  * Metodo construtor Principal
  */
  public Filme()
  {
    this(-1, "", "", "", 0, 0, "", "");
  }//end Filme

  /**
  * Metodo construtor alternativo
  * @param titulo,tituloOrigi,paisOrigem,anoLancamento,duracao,diretor,sinopse
  *         Reservam espaço para os atributos
  */
  public Filme(int id, String titulo, String tituloOrigi, String paisOrigem,
  int anoLancamento, int duracao, String diretor, String sinopse)
  {
    this.id = id;
    this.titulo = titulo;
    this.tituloOrigi = tituloOrigi;
    this.paisOrigem = paisOrigem;
    this.anoLancamento = anoLancamento;
    this.duracao = duracao;
    this.diretor = diretor;
    this.sinopse = sinopse;
  }//end Filme

  //metodos get(s) and set(s)--------------------------------------------------

  public int getid()
  {return(this.id);}

  public void setid(int id)
  {this.id = id;}

  public String getTitulo()
  {return(this.titulo);}

  public void setTitulo(String titulo)
  {this.titulo = titulo;}

  public String gettituloOrigi()
  {return(this.tituloOrigi);}

  public void settituloOrigi(String tituloiOrigi)
  {this.tituloOrigi = tituloOrigi;}

  public String getpaisOrigem()
  {return(this.paisOrigem);}

  public void setpaisOrigem(String paisOrigi)
  {this.paisOrigem = paisOrigi;}

  public int getanoLancamento()
  {return(this.anoLancamento);}

  public void setanoLancamento(int anoLancamento)
  {this.anoLancamento = anoLancamento;}

  public int getduracao()
  {return(this.duracao);}

  public void setduracao(int duracao)
  {this.duracao = duracao;}

  public String getdiretor()
  {return(this.diretor);}

  public void setdiretor(String diretor)
  {this.diretor = diretor;}

  public String getsinopse()
  {return(this.sinopse);}

  public void setsinopse(String sinopse)
  {this.sinopse = sinopse;}

//end metodos get(s) and set(s)=-----------------------------------------------

  /**
   * @return Retorna todos os atributos cadastrados daquele objeto
   */
  public String toString()
  {
	  return("\nID: " + this.id +
		 "\nTítulo: " + this.titulo +
		 "\nTítulo Original: " + this.tituloOrigi +
		 "\nPaís de Origem: " + this.paisOrigem +
		 "\nAno de Lançamento: " + this.anoLancamento +
		 "\nDuração em Minutos: " + this.duracao +
		 "\nDiretor: " + this.diretor +
		 "\nSinopse: " + this.sinopse);
  }//end toString()

  /**
   * @return Faz a escrita do objeto para o arquivo e o retorna
   */
  public byte[] getByteArray() throws IOException
  {
  	ByteArrayOutputStream dados = new ByteArrayOutputStream();
  	DataOutputStream saida = new DataOutputStream(dados);

    saida.writeInt(this.id);
    saida.writeUTF(this.titulo);
    saida.writeUTF(this.tituloOrigi);
    saida.writeUTF(this.paisOrigem);
    saida.writeInt(this.anoLancamento);
    saida.writeInt(this.duracao);
    saida.writeUTF(this.diretor);
    saida.writeUTF(this.sinopse);

    saida.flush();

  	return(dados.toByteArray());
  }//end getByteArray()

  /**
   * @return Faz a leitura dos dados do objetos que estão em bytes
   */
  public void setByteArray(byte[] bytes) throws IOException
  {
  	ByteArrayInputStream dados = new ByteArrayInputStream(bytes);
  	DataInputStream entrada = new DataInputStream( dados );

  	this.id = entrada.readInt();
    this.titulo = entrada.readUTF();
    this.tituloOrigi = entrada.readUTF();
    this.paisOrigem = entrada.readUTF();
    this.anoLancamento = entrada.readInt();
    this.duracao = entrada.readInt();
    this.diretor = entrada.readUTF();
    this.sinopse = entrada.readUTF();
  }//end setByteArray()

  /**
   * Metodo para verificar a inserção dos atrubutos
   */
   public void mostrar()
   {
     System.out.println(getid());
     System.out.println(getTitulo());
     System.out.println(gettituloOrigi());
     System.out.println(getpaisOrigem());
     System.out.println(getanoLancamento());
     System.out.println(getduracao());
     System.out.println(getdiretor());
     System.out.println(getsinopse());
   }//end mostrar()
}//end class

//-----------------------------------------------------------------------------

/**
* Classe Principal
*/
class CRUD_ComIndice
{
  /**
   * Faz a inserção de filmes no arquivo
   */
  public static Filme inserir(RandomAccessFile arq) throws Exception
  {
    Filme filme;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Título:");
    String titulo = br.readLine();
    System.out.println("Título original:");
    String tituloOrigi = br.readLine();
    System.out.println("País de origem:");
    String paisOrigem = br.readLine();
    System.out.println("Ano de lançamento:");
    int anoLancamento = Integer.parseInt(br.readLine());
    System.out.println("Duração em minutos:");
    int duracao = Integer.parseInt(br.readLine());
    System.out.println("Diretor:");
    String diretor = br.readLine();
    System.out.println("Sinopse:");
    String sinopse = br.readLine();

    System.out.println("Para confirmar a inclusão do filme digite 's' ou 'S':");
    String confirma = br.readLine();

    if(confirma.charAt(0) == 's' || confirma.charAt(0) == 'S')
    {
      filme = new Filme(-1, titulo, tituloOrigi, paisOrigem, anoLancamento,
                        duracao, diretor, sinopse);
      arq.seek(0);
      int id = arq.readInt();
      filme.setid(id);
      System.out.println("id: " + id);
      id++;
      arq.seek(0);
      arq.writeInt(id);
      arq.seek(arq.length());
      arq.writeByte(' ');
      byte[] b = filme.getByteArray();
      arq.writeInt(b.length);
      arq.write(b);

      System.out.println("Filme cadastrado!");
    }
    else
    {
      filme = null;
      System.out.println("Filme não foi cadastrado!");
    }//end if

    return(filme);
  }//end inserir()

  /**
   * Faz a busca do filme no arquivo atravez do id
   */
  public static Filme buscar(RandomAccessFile arq) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Digite um código para a busca do filme!");
    int id = Integer.parseInt(br.readLine());
    Filme filmes = null;

    if(id < 0)
    {
      filmes = null;
    }
    else
    {
      filmes = new Filme();
      byte lapide;
      byte[] b;
      int tamanho;

      arq.seek(4);
      long estouAqui = arq.getFilePointer();
      while(arq.getFilePointer() < arq.length())
      {
        lapide = arq.readByte();
        tamanho = arq.readInt();
        b = new byte[tamanho];
        arq.read(b);
        filmes.setByteArray(b);
        System.out.println("Filme id: " + filmes.getid());
        if((lapide == ' ') && (filmes.getid() == id))
        {
          //estouAqui = arq.length();
        }
        else if(filmes.getid() != id)
        {
        }//end if
      }//end while
    }//end if

    if(filmes == null)
    {
      System.out.println("Filme não encontrado!");
    }
    else
    {
      filmes.mostrar();
    }//end if

    return(filmes);
  }//end buscar()

  /**
   * Faz a busca do filme e o exclui
   */
  public static Filme excluir(RandomAccessFile arq) throws Exception
  {
    Filme filmes = null;
    byte lapide;
    byte[] b;
    int tamanho;
    long endereço;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Digite um código(id) para a exclui um filme!");
    int id = Integer.parseInt(br.readLine());

    if(id <= 0)
    {
      filmes = null;
    }
    else
    {
      filmes = new Filme();

      arq.seek(4);
      while(arq.getFilePointer() < arq.length())
      {
        endereço = arq.getFilePointer();
        lapide = arq.readByte();
        tamanho = arq.readInt();
        b = new byte[tamanho];
        arq.read(b);
        filmes.setByteArray(b);
        if(lapide == ' ' && filmes.getid() == id)
        {
          System.out.println("Para confirmar a exclusão do filme digite 's' ou 'S':");
          String confirma = br.readLine();

          if(confirma.charAt(0) == 's' || confirma.charAt(0) == 'S')
          {
            arq.seek(endereço);
            arq.write('*');
          }//end if
        }
        else
        {
          filmes = null;
        }//end if
      }//end while
    }//end if

    if(filmes == null)
    {
      System.out.println("Filme não encontrado!");
    }
    else
    {
     filmes.mostrar();
    }//end if

    return(filmes);
  }//end excluir()

  /**
   * Exclui um filme no arquivo
   */
  public static Filme alterar(RandomAccessFile arq) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Digite um código(id) para alterar um filme!");
    int id = Integer.parseInt(br.readLine());
    Filme filmes = null;

    if(id <= 0)
    {
      filmes = null;
    }
    else
    {
      filmes = buscar(arq);
      if(filmes != null)
      {
        System.out.println("Novo Título:");
        String titulo = br.readLine();
        System.out.println("Novo Título original:");
        String tituloOrigi = br.readLine();
        System.out.println("Novo País de origem:");
        String paisOrigem = br.readLine();
        System.out.println("Novo Ano de lançamento:");
        int anoLancamento = Integer.parseInt(br.readLine());
        System.out.println("Nova Duração em minutos:");
        int duracao = Integer.parseInt(br.readLine());
        System.out.println("Novo Diretor:");
        String diretor = br.readLine();
        System.out.println("Novo Sinopse:");
        String sinopse = br.readLine();

        if(titulo.length() > 0 || tituloOrigi.length() > 0 ||
           paisOrigem.length() > 0 || diretor.length() > 0 ||
           sinopse.length() > 0)
        {
          filmes.setTitulo(titulo);
          filmes.settituloOrigi(tituloOrigi);
          filmes.setpaisOrigem(paisOrigem);
          filmes.setanoLancamento(anoLancamento);
          filmes.setduracao(duracao);
          filmes.setdiretor(diretor);
          filmes.setsinopse(sinopse);

          byte lapide;
          byte[] b;
          int tamanho;
          long endereco;
          int idExistente = filmes.getid();

          arq.seek(4);
          while(arq.getFilePointer() < arq.length())
          {
            endereco = arq.getFilePointer();
            lapide = arq.readByte();
            tamanho = arq.readInt();
            b = new byte[tamanho];
            arq.read(b);
            filmes.setByteArray(b);
            if(lapide == ' ' && filmes.getid() == idExistente)
            {
              arq.seek(endereco);
              arq.write('*');

              arq.seek(arq.length());
              arq.writeByte(' ');
              b = filmes.getByteArray();
              arq.writeInt(b.length);
              arq.write(b);
            }//end if
          }//end while
        }//end if
      }//end if
    }//end if

    return(filmes);
  }//end alterar()

  public static void main(String[] args) throws Exception
  {
    try
    {
      RandomAccessFile arq = new RandomAccessFile("Filmes.db", "rw");

      if(arq.length() < 4)
      {
        arq.seek(0);
        arq.writeInt(0);
      }//end if

      System.out.println("Menu para Filmes: ");
      System.out.println("Inserir - 1");
      System.out.println("Alterar - 2");
      System.out.println("Excluir - 3");
      System.out.println("Consultar - 4");
      System.out.println("Exit - 0");
      System.out.println("Escolha uma das opções acima: ");

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int choose = Integer.parseInt(br.readLine());

      while(choose != 0)
      {
      	switch(choose)
      	{
          case 0:
            System.out.println("Exit - 0");
          break;
          case 1:
            System.out.println("Inserir - 1");
            Filme novoFilme = inserir(arq);
            System.out.println("Escolha uma opção novamente!");
            choose = Integer.parseInt(br.readLine());
          break;
          case 2:
            System.out.println("Alterar - 2");
            Filme filmeAlterar = alterar(arq);
            System.out.println("Escolha uma opção novamente!");
            choose = Integer.parseInt(br.readLine());
          break;
          case 3:
            System.out.println("Excluir - 3");
            Filme filmeExcluir = excluir(arq);
            System.out.println("Escolha uma opção novamente!");
            choose = Integer.parseInt(br.readLine());
          break;
          case 4:
            System.out.println("Consultar - 4");
            Filme filmes = buscar(arq);
            System.out.println("Escolha uma opção novamente!");
            choose = Integer.parseInt(br.readLine());
          break;
          default:
            System.out.println("Comando Inválido!");
            System.out.println("Escolha uma opção novamente!");
            choose = Integer.parseInt(br.readLine());
        }//end switch case
      }//end while

      arq.close();
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }//end trycatch
  }//end main
}//end class
