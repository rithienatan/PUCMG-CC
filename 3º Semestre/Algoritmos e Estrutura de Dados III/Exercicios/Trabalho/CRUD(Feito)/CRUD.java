/**
 * @author Rithie Natan Carvalhaes Prado
 * Matrícula: 541488
 * Data de Entrega: 11/03/2019
 * Exercício: CRUD
 * @version 0.2
 */

//------------------------------------------------------------------------------
import java.io.*;
import java.util.*;
//------------------------------------------------------------------------------

class Produto
{
  private int idProduto;
  private String nome;
  private String descricao;
  private String tipo;
  private String marca;
  private float preco;

  /**
   * Construtor padrão
   */
  public Produto()
  {this(-1, " ", " ", " ", " ", 0);}//end construtor padrão

  /**
   * Construtor alternativo
   * @param idProduto,nome,descricao,tipo,marca,preco
   * Reservam espaço para os atributos
   */
  public Produto(int idProduto, String nome, String descricao, String tipo,
                 String marca, float preco)
  {
    this.idProduto = idProduto;
    this.nome = nome;
    this.descricao = descricao;
    this.tipo = tipo;
    this.marca = marca;
    this.preco = preco;
  }//end construtor alternativo

  //metodos get(s) and set(s)--------------------//
  public int getidProduto()
  {return(this.idProduto);}

  public void setidProduto(int idProduto)
  {this.idProduto = idProduto;}

  public String getnome()
  {return(this.nome);}

  public void setnome(String nome)
  {this.nome = nome;}

  public String getdescricao()
  {return(this.descricao);}

  public void setdescricao(String descricao)
  {this.descricao = descricao;}

  public String gettipo()
  {return(this.tipo);}

  public void settipo(String tipo)
  {this.tipo = tipo;}

  public String getmarca()
  {return(this.marca);}

  public void setmarca(String marca)
  {this.marca = marca;}

  public float getpreco()
  {return(this.preco);}

  public void setpreco(float preco)
  {this.preco = preco;}
  //end metodos get(s) and set(s)-----------------//

  /**
   * Transforma os atributos em String
   * @return retorna os atributos em String
   */
  public String toString()
  {
    String together = "ID :" + this.idProduto +
                      "\nNome: " + this.nome +
                      "\nDescrição: " + this.descricao +
                      "\nTipo: " + this.tipo +
                      "\nMarca: " + this.marca +
                      "\nPreço: " + this.preco;
    return(together);
  }//end toString()

  /**
   * Transforma os atributos de um objeto para byte
   * @throws IOException
   * @return retorna um vetor de bytes dos objetos
   */
  public byte[] toByteArray() throws IOException
  {
    ByteArrayOutputStream dados = new ByteArrayOutputStream();
    DataOutputStream saida = new DataOutputStream( dados );

    saida.writeInt(this.idProduto);
    saida.writeUTF(this.nome);
    saida.writeUTF(this.descricao);
    saida.writeUTF(this.tipo);
    saida.writeUTF(this.marca);
    saida.writeFloat(this.preco);

    return(dados.toByteArray());
  }//end toByteArray()

  /**
   * Transforma os bytes recebidos do arquivo e os passam para as variáveis
   * @param bytes recebe um array de bytes que contem as informações dos
   * @throws IOException
   * do objetos
   */
  public void fromByteArray(byte[] bytes) throws IOException
  {
    ByteArrayInputStream dados = new ByteArrayInputStream(bytes);
    DataInputStream entrada = new DataInputStream(dados);

    this.idProduto = entrada.readInt();
    this.nome = entrada.readUTF();
    this.descricao = entrada.readUTF();
    this.tipo = entrada.readUTF();
    this.marca = entrada.readUTF();
    this.preco = entrada.readFloat();
  }//end fromByteArray()

  /**
   * Mostra os elementos dentro de um objeto em especifico
   */
  public void mostrar()
  {
    System.out.println("ID do Produto: \n" + this.idProduto);
    System.out.println("Nome do Produto: \n" + this.nome);
    System.out.println("Descrição do Produto: \n" + this.descricao);
    System.out.println("Tipo de Produto: \n" + this.tipo);
    System.out.println("Marca do Produto: \n" + this.marca);
    System.out.println("Preço do Produto: \n" + this.preco);
  }//end mostrar()
}//end Classe

//------------------------------------------------------------------------------

class ArquivoProdutos
{
  private RandomAccessFile arqProdutos;
  private String nomeArquivo;
  private String nomeIndice;
  private Produto produto;
  private Indice indice;
  private ArrayList<Produto> list;

  /**
   * Construtor alternativo
   * @param arq,nome Reservam espaço para os atributos
   */
  public ArquivoProdutos(Produto product, String nomeArq,
                         String nomeInd) throws IOException
  {
    this.list = new ArrayList <>();
    this.nomeArquivo = nomeArq;
    this.nomeIndice = nomeInd;
    this.produto = product;
    this.arqProdutos = new RandomAccessFile(this.nomeArquivo, "rw");
    this.indice = new Indice(20, nomeInd);
    if(arqProdutos.length() < 4)
    {
        arqProdutos.writeInt(0);
    }//end if
  }//end ArquivoProdutos()

  /**
   * Inseri no arquivo de produtos e no indice
   * @param pro Recebe o ponteiro de um produto em especifico
   * @return Retorna o id do produto
   */
  public int incluir(Produto pro) throws IOException
  {
    arqProdutos.seek(0);
    int lastID = arqProdutos.readInt();
    arqProdutos.seek(0);
    arqProdutos.writeInt(lastID+1);
    pro.setidProduto(lastID+1);

    arqProdutos.seek(arqProdutos.length());
    long endereco = arqProdutos.getFilePointer();
    byte[] b = pro.toByteArray();
    arqProdutos.writeByte(' ');
    arqProdutos.writeShort(b.length);
    arqProdutos.write(b);
    indice.inserir(pro.getidProduto(), endereco);

    this.list.add(pro);

    return(pro.getidProduto());
  }//end incluir

  /**
   * Inseri no arquivo de produtos e no indice sem alterar ID
   * @param pro Recebe o ponteiro de um produto em especifico
   * @return Retorna o id do produto
   */
  public int incluirSemAlterarID(Produto pro) throws IOException
  {
    arqProdutos.seek(0);
    int mainID = arqProdutos.readInt();
    arqProdutos.seek(0);
    arqProdutos.writeInt(mainID);
    pro.setidProduto(mainID);

    arqProdutos.seek(arqProdutos.length());
    long endereco = arqProdutos.getFilePointer();
    byte[] b = pro.toByteArray();
    arqProdutos.writeByte(' ');
    arqProdutos.writeShort(b.length);
    arqProdutos.write(b);
    indice.inserir(pro.getidProduto(), endereco);

    for(int i = 0; i < this.list.size(); i++)
    {
      if(this.list.get(i).getidProduto() == mainID)
      {
        this.list.remove(i);
        this.list.add(pro);
        i = this.list.size();
      }//end if
    }//end for

    return(pro.getidProduto());
  }//end incluirSemAlterarID()

  /**
   * Faz a leitura de algum objeto através de seu id
   * @param id Recebe o ponteiro de um produto em especifico
   * @return Retorna o endereço de mémoria do produto em especifico
   */
  public Produto ler(int id) throws IOException
  {
    Produto p = new Produto();
    short tamanho;
    byte[] b;
    byte lapide;

    long endereco = indice.buscar(id);

    if(endereco != -1)
    {
        arqProdutos.seek(endereco);
        lapide = arqProdutos.readByte();
        tamanho = arqProdutos.readShort();
        b = new byte[tamanho];
        arqProdutos.read(b);
        p.fromByteArray(b);
    }
    else
    {
        p = null;
    }//end if

    return(p);
  }//end ler

  /**
   * Faz a alteração de algum objeto através de seu id
   * @param id,alternativo Recebe o ponteiro de um produto em especifico
   * @return Retorna um confirmação de alteração do objeto
   */
  public boolean alterar(int id, Produto alternativo) throws IOException
  {
    boolean resp;
    Produto p = new Produto();
    short tamanho;
    byte[] b;
    byte lapide;

    long endereco = indice.buscar(id);

    if(endereco != -1)
    {
        arqProdutos.seek(endereco);
        lapide = arqProdutos.readByte();
        tamanho = arqProdutos.readShort();
        b = new byte[tamanho];
        arqProdutos.read(b);
        p.fromByteArray(b);

        p.setnome(alternativo.getnome());
        p.setdescricao(alternativo.getdescricao());
        p.settipo(alternativo.gettipo());
        p.setmarca(alternativo.getmarca());
        p.setpreco(alternativo.getpreco());

        boolean excluido = excluir(id);
        int include = incluirSemAlterarID(p);

        resp = true;
    }
    else
    {
        resp = false;
    }//end if

    return(resp);
  }//end alterar

  /**
   * Exclui um objeto do arquivo de indice e de produtos
   * @param id Recebe o ponteiro de um produto em especifico
   * @return Retorna uma confirmação da exclusão do objeto
   */
  public boolean excluir(int id) throws IOException
  {
    boolean resp;
    Produto p = new Produto();
    long endereco = indice.buscar(id);

    if(endereco != -1)
    {
        arqProdutos.seek(endereco);
        arqProdutos.writeByte('*');
        indice.excluir(id);
        resp = true;

        for(int i = 0; i < this.list.size(); i++)
        {
          if(this.list.get(i).getidProduto() == id)
          {
            this.list.remove(i);
            i = this.list.size();
          }//end if
        }//end for
    }
    else
    {
        resp = false;
    }//end if

    return(resp);
  }//end excluir

  /**
   * @return Retorna uma lista de produtos que estavam no arquivo
   * @throws IOException
   */
  public ArrayList<Produto> listar() throws IOException
  {
    Produto produto = null;
    
    arqProdutos.seek(0);
    int lastID = arqProdutos.readInt();

    for(int i = 1; i <= lastID; i++)
    {
      produto = ler(i);
      if(produto != null)
      {
        this.list.add(produto);
      }//
    }//end for

    return(this.list);
  }//end listar

}//end ArquivoProdutos

//------------------------------------------------------------------------------

class Indice
{
    private int  ordem;
    private int  maxElementos;
    private int  maxFilhos;
    private RandomAccessFile arquivo;
    private String nomeArquivo;

    // Variáveis usadas nas funções recursivas (já que não é possível passar valores por referência)
    private int  chaveAux;
    private long  dadoAux;
    private long paginaAux;
    private boolean cresceu;
    private boolean diminuiu;

    // Esta classe representa uma página da árvore (folha ou não folha).
    private class Pagina
    {
        protected int    ordem;
        protected int    maxElementos;
        protected int    maxFilhos;
        protected int    n;
        protected int[]  chaves;
        protected long[] dados;
        protected long   proxima;
        protected long[] filhos;
        protected int    TAMANHO_ELEMENTO;
        protected int    TAMANHO_PAGINA;

        /**
         * Construtor da página
         * @param o
         */
        public Pagina(int o)
        {
            // Inicialização dos atributos
            n = 0;
            ordem = o;
            maxFilhos = o;
            maxElementos = o-1;
            chaves = new int[maxElementos];
            dados  = new long[maxElementos];
            filhos = new long[maxFilhos];
            proxima = -1;

            // Criação de uma página vázia
            for(int i=0; i<maxElementos; i++)
            {
                chaves[i] = 0;
                dados[i]  = -1;
                filhos[i] = -1;
            }//end for
            filhos[maxFilhos-1] = -1;

            // Cálculo do tamanho (fixo) da página
            TAMANHO_ELEMENTO = 12;
            TAMANHO_PAGINA = 4 + maxElementos*TAMANHO_ELEMENTO + maxFilhos*8 + 16;
        }//end pagina()

        /**
         * Retorna o vetor de bytes que representa a página para armazenamento em arquivo
         * @throws IOException
         */
        protected byte[] getBytes() throws IOException
        {
            ByteArrayOutputStream ba = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(ba);

            // Quantidade de elementos presentes na página
            out.writeInt(n);

            // Escreve todos os elementos
            int i=0;
            while(i<n)
            {
                out.writeLong(filhos[i]);
                out.writeInt(chaves[i]);
                out.writeLong(dados[i]);
                i++;
            }//end while
            out.writeLong(filhos[i]);

            // Completa o restante da página com registros vazios
            byte[] elementoVazio = new byte[TAMANHO_ELEMENTO];
            while(i<maxElementos)
            {
                out.write(elementoVazio);
                out.writeLong(filhos[i+1]);
                i++;
            }//end while

            // Escreve o ponteiro para a próxima página
            out.writeLong(proxima);

            // Retorna o vetor de bytes que representa a página
            return(ba.toByteArray());
        }//end getBytes()

        /**
         * Reconstrói uma página a partir de um vetor de bytes lido no arquivo
         * @param buffer
         * @throws IOException
         */
        protected void setBytes(byte[] buffer) throws IOException
        {
            ByteArrayInputStream ba = new ByteArrayInputStream(buffer);
            DataInputStream in = new DataInputStream(ba);

            // Lê a quantidade de elementos da página
            n = in.readInt();

            // Lê todos os elementos (reais ou vazios)
            int i=0;
            while(i<maxElementos)
            {
                filhos[i]  = in.readLong();
                chaves[i] = in.readInt();
                dados[i]   = in.readLong();
                i++;
            }//end while
            filhos[i] = in.readLong();
            proxima = in.readLong();
        }//end setBytes()
    }//end class

    /**
     * Metodo construtor
     * @param o,na
     * @throws IOException
     */
    public Indice(int o, String na) throws IOException
    {
        // Inicializa os atributos da árvore
        ordem = o;
        maxElementos = o-1;
        maxFilhos = o;
        nomeArquivo = na;

        // Abre (ou cria) o arquivo, escrevendo uma raiz vazia, se necessário.
        arquivo = new RandomAccessFile(nomeArquivo,"rw");
        if(arquivo.length()<8)
            arquivo.writeLong(-1);  // raiz vazia
    }//end Indice()

    /**
     * Testa se a árvore está vazia. Uma árvore vazia é identificada pela raiz == -1
     * @throws IOException
     */
    public boolean vazia() throws IOException
    {
        long raiz;
        arquivo.seek(0);
        raiz = arquivo.readLong();
        return raiz == -1;
    }//end vazia()

    /**
     * Busca recursiva por um elemento a partir da chave. Este metodo invoca
     * o método recursivo buscar1, passando a raiz como referência.
     * @param c
     * @throws IOException
     */
    public long buscar(int c) throws IOException
    {
        long raiz;
        arquivo.seek(0);
        raiz = arquivo.readLong();

        if(raiz!=-1)
            return buscar1(c,raiz);
        else
            return -1;
    }//end buscar()

    /**
     * Busca recursiva. Este método recebe a referência de uma página e busca
     * pela chave na mesma. A busca continua pelos filhos, se houverem.
     * @param chave,pagina
     * @throws IOException
     */
    private long buscar1(int chave, long pagina) throws IOException
    {
        if(pagina==-1)
            return -1;

        // Reconstrói a página passada como referência a partir
        // do registro lido no arquivo
        arquivo.seek(pagina);
        Pagina pa = new Pagina(ordem);
        byte[] buffer = new byte[pa.TAMANHO_PAGINA];
        arquivo.read(buffer);
        pa.setBytes(buffer);

        // Encontra o ponto em que a chave deve estar na página
        int i=0;
        while(i<pa.n && chave>pa.chaves[i])
        {i++;}

        // Chave encontrada (ou pelo menos o ponto onde ela deveria estar).
        // Segundo passo - testa se a chave é a chave buscada e se está em uma folha
        if(i<pa.n && pa.filhos[0]==-1 && chave==pa.chaves[i])
        {return(pa.dados[i]);}

        // Terceiro passo - ainda não é uma folha, continua a busca recursiva pela árvore
        if(i==pa.n || chave<pa.chaves[i])
            return(buscar1(chave, pa.filhos[i]));
        else
            return(buscar1(chave, pa.filhos[i+1]));
    }//end buscar1()

    /**
     * Atualiza recursivamente um valor a partir da sua chave. Este metodo invoca
     * o método recursivo atualizar1, passando a raiz como referência.
     * @param c,d
     * @throws IOException
     */
    public boolean atualizar(int c, long d) throws IOException
    {
        long raiz;
        arquivo.seek(0);
        raiz = arquivo.readLong();

        // Executa a busca recursiva
        if(raiz!=-1)
            return(atualizar1(c,d,raiz));
        else
            return(false);
    }//end atualizar()

    /**
     * @param chave,dado,pagina
     * @throws IOException
     */
    private boolean atualizar1(int chave, long dado, long pagina) throws IOException
    {
        if(pagina==-1)
            return(false);

        arquivo.seek(pagina);
        Pagina pa = new Pagina(ordem);
        byte[] buffer = new byte[pa.TAMANHO_PAGINA];
        arquivo.read(buffer);
        pa.setBytes(buffer);

        // Encontra o ponto em que a chave deve estar na página
        // Primeiro passo - todas as chaves menores que a chave buscada são ignoradas
        int i=0;
        while(i<pa.n && chave>pa.chaves[i])
        {i++;}

        // Chave encontrada (ou pelo menos o ponto onde ela deveria estar).
        // Segundo passo - testa se a chave é a chave buscada e se está em uma folha
        if(i<pa.n && pa.filhos[0]==-1 && chave==pa.chaves[i])
        {
            pa.dados[i] = dado;
            arquivo.seek(pagina);
            arquivo.write(pa.getBytes());
            return(true);
        }//end if

        // Terceiro passo - ainda não é uma folha, continua a busca recursiva pela árvore
        if(i==pa.n || chave<pa.chaves[i])
            return(atualizar1(chave, dado, pa.filhos[i]));
        else
            return(atualizar1(chave, dado, pa.filhos[i+1]));
    }//end atualizar1()

    /**
     * Inclusão de novos elementos na árvore. A inclusão é recursiva. A primeira
     * função chama a segunda recursivamente, passando a raiz como referência.
     * Eventualmente, a árvore pode crescer para cima.
     * @param c,d
     * @throws IOException
     */
    public boolean inserir(int c, long d) throws IOException
    {
        if(c<0)
        {
            System.out.println( "Chave não pode ser negativa" );
            return(false);
        }//end if

        // Carrega a raiz
        arquivo.seek(0);
        long pagina;
        pagina = arquivo.readLong();

        chaveAux = c;
        dadoAux = d;
        paginaAux = -1;
        cresceu = false;

        boolean inserido = inserir1(pagina);

        // Testa a necessidade de criação de uma nova raiz.
        if(cresceu)
        {
            Pagina novaPagina = new Pagina(ordem);
            novaPagina.n = 1;
            novaPagina.chaves[0] = chaveAux;
            novaPagina.dados[0]  = dadoAux;
            novaPagina.filhos[0] = pagina;
            novaPagina.filhos[1] = paginaAux;

            arquivo.seek(arquivo.length());
            long raiz = arquivo.getFilePointer();
            arquivo.write(novaPagina.getBytes());
            arquivo.seek(0);
            arquivo.writeLong(raiz);
        }//end if
        return(inserido);
    }//end inserir()

    /**
     * As inclusões são sempre feitas em uma folha.
     * @param pagina
     * @throws IOException
     */
    private boolean inserir1(long pagina) throws IOException
    {
        if(pagina==-1)
        {
            cresceu = true;
            paginaAux = -1;
            return(false);
        }//end if

        // Lê a página passada como referência
        arquivo.seek(pagina);
        Pagina pa = new Pagina(ordem);
        byte[] buffer = new byte[pa.TAMANHO_PAGINA];
        arquivo.read(buffer);
        pa.setBytes(buffer);

        int i=0;
        while(i<pa.n && chaveAux>pa.chaves[i])
        {i++;}

        // Testa se a chave já existe em uma folha. Se isso acontecer, então
        // a inclusão é cancelada.
        if(i<pa.n && pa.filhos[0]==-1 && chaveAux==pa.chaves[i])
        {
            cresceu = false;
            return(false);
        }//end if

        boolean inserido;
        if(i==pa.n || chaveAux<pa.chaves[i])
            inserido = inserir1(pa.filhos[i]);
        else
            inserido = inserir1(pa.filhos[i+1]);

        if(!cresceu)
            return(inserido);

        // Se tiver espaço na página, faz a inclusão nela mesmo
        if(pa.n<maxElementos)
        {
            for(int j=pa.n; j>i; j--)
            {
                pa.chaves[j] = pa.chaves[j-1];
                pa.dados[j] = pa.dados[j-1];
                pa.filhos[j+1] = pa.filhos[j];
            }//end for

            // Insere o novo elemento
            pa.chaves[i] = chaveAux;
            pa.dados[i] = dadoAux;
            pa.filhos[i+1] = paginaAux;
            pa.n++;

            // Escreve a página atualizada no arquivo
            arquivo.seek(pagina);
            arquivo.write(pa.getBytes());

            // Encerra o processo de crescimento e retorna
            cresceu=false;
            return(true);
        }//end if

        // Cria uma nova página
        Pagina np = new Pagina(ordem);

        int meio = maxElementos/2;
        for(int j=0; j<(maxElementos-meio); j++)
        {
            np.chaves[j] = pa.chaves[j+meio];
            np.dados[j] = pa.dados[j+meio];
            np.filhos[j+1] = pa.filhos[j+meio+1];

            pa.chaves[j+meio] = 0;
            pa.dados[j+meio] = 0;
            pa.filhos[j+meio+1] = -1;
        }//end for
        np.filhos[0] = pa.filhos[meio];
        np.n = maxElementos-meio;
        pa.n = meio;

        if(i<=meio)
        {
            for(int j=meio; j>0 && j>i; j--)
            {
                pa.chaves[j] = pa.chaves[j-1];
                pa.dados[j] = pa.dados[j-1];
                pa.filhos[j+1] = pa.filhos[j];
            }//end for

            pa.chaves[i] = chaveAux;
            pa.dados[i] = dadoAux;
            pa.filhos[i+1] = paginaAux;
            pa.n++;

            if(pa.filhos[0]==-1)
            {
                chaveAux = np.chaves[0];
                dadoAux = np.dados[0];
            }
            else
            {
                chaveAux = pa.chaves[pa.n-1];
                dadoAux = pa.dados[pa.n-1];
                pa.chaves[pa.n-1] = 0;
                pa.dados[pa.n-1] = 0;
                pa.filhos[pa.n] = -1;
                pa.n--;
            }//end if
        }
        else
        {
            int j;
            for(j=maxElementos-meio; j>0 && chaveAux<np.chaves[j-1]; j--)
            {
                np.chaves[j] = np.chaves[j-1];
                np.dados[j] = np.dados[j-1];
                np.filhos[j+1] = np.filhos[j];
            }//end for
            np.chaves[j] = chaveAux;
            np.dados[j] = dadoAux;
            np.filhos[j+1] = paginaAux;
            np.n++;

            chaveAux = np.chaves[0];
            dadoAux = np.dados[0];

            if(pa.filhos[0]!=-1)
            {
                for(j=0; j<np.n-1; j++)
                {
                    np.chaves[j] = np.chaves[j+1];
                    np.dados[j] = np.dados[j+1];
                    np.filhos[j] = np.filhos[j+1];
                }//end for
                np.filhos[j] = np.filhos[j+1];

                np.chaves[j] = 0;
                np.dados[j] = 0;
                np.filhos[j+1] = -1;
                np.n--;
            }//end if
        }//end if

        // Se a página era uma folha e apontava para outra folha,
        // então atualiza os ponteiros dessa página e da página nova
        if(pa.filhos[0]==-1)
        {
            np.proxima=pa.proxima;
            pa.proxima = arquivo.length();
        }//end if

        // Grava as páginas no arquivos arquivo
        paginaAux = arquivo.length();
        arquivo.seek(paginaAux);
        arquivo.write(np.getBytes());

        arquivo.seek(pagina);
        arquivo.write(pa.getBytes());

        return(true);
    }//end inserir1()

    /**
     * Remoção elementos na árvore.
     * @param chave
     * @throws IOException
     */
    public boolean excluir(int chave) throws IOException
    {
        arquivo.seek(0);
        long pagina;
        pagina = arquivo.readLong();

        // variável global de controle da redução do tamanho da árvore
        diminuiu = false;

        boolean excluido = excluir1(chave, pagina);

        if(excluido && diminuiu)
        {
            arquivo.seek(pagina);
            Pagina pa = new Pagina(ordem);
            byte[] buffer = new byte[pa.TAMANHO_PAGINA];
            arquivo.read(buffer);
            pa.setBytes(buffer);

            if(pa.n == 0)
            {
                arquivo.seek(0);
                arquivo.writeLong(pa.filhos[0]);
            }//end if
        }//end if
        return(excluido);
    }//end excluir()

    /**
     * @param chave,pagina
     * @throws IOException
     */
    private boolean excluir1(int chave, long pagina) throws IOException
    {
        boolean excluido=false;
        int diminuido;

        if(pagina==-1)
        {
            diminuiu=false;
            return(false);
        }//end if

        // Lê o registro da página no arquivo
        arquivo.seek(pagina);
        Pagina pa = new Pagina(ordem);
        byte[] buffer = new byte[pa.TAMANHO_PAGINA];
        arquivo.read(buffer);
        pa.setBytes(buffer);

        int i=0;
        while(i<pa.n && chave>pa.chaves[i])
        {i++;}

        if(i<pa.n && pa.filhos[0]==-1 && chave==pa.chaves[i])
        {
            // Puxa todas os elementos seguintes para uma posição anterior, sobrescrevendo
            // o elemento a ser excluído
            int j;
            for(j=i; j<pa.n-1; j++)
            {
                pa.chaves[j] = pa.chaves[j+1];
                pa.dados[j] = pa.dados[j+1];
            }//end for
            pa.n--;

            pa.chaves[pa.n] = 0;
            pa.dados[pa.n] = 0;

            arquivo.seek(pagina);
            arquivo.write(pa.getBytes());

            diminuiu = pa.n<maxElementos/2;
            return(true);
        }//end if

        if(i==pa.n || chave<pa.chaves[i])
        {
            excluido = excluir1(chave, pa.filhos[i]);
            diminuido = i;
        }
        else
        {
            excluido = excluir1(chave, pa.filhos[i+1]);
            diminuido = i+1;
        }//end if

        // Testa se há necessidade de fusão de páginas
        if(diminuiu)
        {
            long paginaFilho = pa.filhos[diminuido];
            Pagina pFilho = new Pagina(ordem);
            arquivo.seek(paginaFilho);
            arquivo.read(buffer);
            pFilho.setBytes(buffer);

            long paginaIrmao;
            Pagina pIrmao;

            if(diminuido>0)
            {
                paginaIrmao = pa.filhos[diminuido-1];
                pIrmao = new Pagina(ordem);
                arquivo.seek(paginaIrmao);
                arquivo.read(buffer);
                pIrmao.setBytes(buffer);

                if(pIrmao.n>maxElementos/2)
                {
                    for(int j=pFilho.n; j>0; j--)
                    {
                        pFilho.chaves[j] = pFilho.chaves[j-1];
                        pFilho.dados[j] = pFilho.dados[j-1];
                        pFilho.filhos[j+1] = pFilho.filhos[j];
                    }//end for
                    pFilho.filhos[1] = pFilho.filhos[0];
                    pFilho.n++;

                    if(pFilho.filhos[0]==-1)
                    {
                        pFilho.chaves[0] = pIrmao.chaves[pIrmao.n-1];
                        pFilho.dados[0] = pIrmao.dados[pIrmao.n-1];
                    }
                    else
                    {
                        pFilho.chaves[0] = pa.chaves[diminuido-1];
                        pFilho.dados[0] = pa.dados[diminuido-1];
                    }//end if

                    // Copia o elemento do irmão para o pai (página atual)
                    pa.chaves[diminuido-1] = pIrmao.chaves[pIrmao.n-1];
                    pa.dados[diminuido-1] = pIrmao.dados[pIrmao.n-1];

                    // Reduz o elemento no irmão
                    pFilho.filhos[0] = pIrmao.filhos[pIrmao.n];
                    pIrmao.n--;
                    diminuiu = false;
                }
                else
                {
                    if(pFilho.filhos[0] != -1)
                    {
                        pIrmao.chaves[pIrmao.n] = pa.chaves[diminuido-1];
                        pIrmao.dados[pIrmao.n] = pa.dados[diminuido-1];
                        pIrmao.filhos[pIrmao.n+1] = pFilho.filhos[0];
                        pIrmao.n++;
                    }//end if

                    for(int j=0; j<pFilho.n; j++)
                    {
                        pIrmao.chaves[pIrmao.n] = pFilho.chaves[j];
                        pIrmao.dados[pIrmao.n] = pFilho.dados[j];
                        pIrmao.filhos[pIrmao.n+1] = pFilho.filhos[j+1];
                        pIrmao.n++;
                    }//end for
                    pFilho.n = 0;

                    if(pIrmao.filhos[0]==-1)
                        pIrmao.proxima = pFilho.proxima;

                    int j;
                    for(j=diminuido-1; j<pa.n-1; j++)
                    {
                        pa.chaves[j] = pa.chaves[j+1];
                        pa.dados[j] = pa.dados[j+1];
                        pa.filhos[j+1] = pa.filhos[j+2];
                    }//end for
                    pa.chaves[j] = 0;
                    pa.dados[j] = -1;
                    pa.filhos[j+1] = -1;
                    pa.n--;
                    diminuiu = pa.n<maxElementos/2;
                }//end if
            }
            else
            {
                paginaIrmao = pa.filhos[diminuido+1];
                pIrmao = new Pagina(ordem);
                arquivo.seek(paginaIrmao);
                arquivo.read(buffer);
                pIrmao.setBytes(buffer);

                if(pIrmao.n>maxElementos/2)
                {
                    if( pFilho.filhos[0]==-1 )
                    {
                        pFilho.chaves[pFilho.n] = pIrmao.chaves[0];
                        pFilho.dados[pFilho.n] = pIrmao.dados[0];
                        pFilho.filhos[pFilho.n+1] = pIrmao.filhos[0];
                        pFilho.n++;

                        pa.chaves[diminuido] = pIrmao.chaves[1];
                        pa.dados[diminuido] = pIrmao.dados[1];

                    }
                    else
                    {
                        pFilho.chaves[pFilho.n] = pa.chaves[diminuido];
                        pFilho.dados[pFilho.n] = pa.dados[diminuido];
                        pFilho.filhos[pFilho.n+1] = pIrmao.filhos[0];
                        pFilho.n++;

                        pa.chaves[diminuido] = pIrmao.chaves[0];
                        pa.dados[diminuido] = pIrmao.dados[0];
                    }//end if

                    int j;
                    for(j=0; j<pIrmao.n-1; j++)
                    {
                        pIrmao.chaves[j] = pIrmao.chaves[j+1];
                        pIrmao.dados[j] = pIrmao.dados[j+1];
                        pIrmao.filhos[j] = pIrmao.filhos[j+1];
                    }//end for
                    pIrmao.filhos[j] = pIrmao.filhos[j+1];
                    pIrmao.n--;
                    diminuiu = false;
                }
                else
                {
                    if(pFilho.filhos[0] != -1)
                    {
                        pFilho.chaves[pFilho.n] = pa.chaves[diminuido];
                        pFilho.dados[pFilho.n] = pa.dados[diminuido];
                        pFilho.filhos[pFilho.n+1] = pIrmao.filhos[0];
                        pFilho.n++;
                    }//end for

                    for(int j=0; j<pIrmao.n; j++)
                    {
                        pFilho.chaves[pFilho.n] = pIrmao.chaves[j];
                        pFilho.dados[pFilho.n] = pIrmao.dados[j];
                        pFilho.filhos[pFilho.n+1] = pIrmao.filhos[j+1];
                        pFilho.n++;
                    }//end for
                    pIrmao.n = 0;

                    pFilho.proxima = pIrmao.proxima;

                    for(int j=diminuido; j<pa.n-1; j++)
                    {
                        pa.chaves[j] = pa.chaves[j+1];
                        pa.dados[j] = pa.dados[j+1];
                        pa.filhos[j+1] = pa.filhos[j+2];
                    }//end for
                    pa.n--;
                    diminuiu = pa.n<maxElementos/2;
                }//end if
            }//end if

            // Atualiza todos os registros
            arquivo.seek(pagina);
            arquivo.write(pa.getBytes());
            arquivo.seek(paginaFilho);
            arquivo.write(pFilho.getBytes());
            arquivo.seek(paginaIrmao);
            arquivo.write(pIrmao.getBytes());
        }//end if
        return(excluido);
    }//end excluir1()

    /**
     * Imprime a árvore, usando uma chamada recursiva.
     * A função recursiva é chamada com uma página de referência (raiz)
     * @throws IOException
     */
    public void print() throws IOException
    {
        long raiz;
        arquivo.seek(0);
        raiz = arquivo.readLong();
        if(raiz!=-1)
            print1(raiz);
        System.out.println();
    }//end print()

    /**
     * @param pagina
     * @throws IOException
     */
    private void print1(long pagina) throws IOException
    {
        if(pagina==-1)
            return;
        int i;

        arquivo.seek(pagina);
        Pagina pa = new Pagina(ordem);
        byte[] buffer = new byte[pa.TAMANHO_PAGINA];
        arquivo.read(buffer);
        pa.setBytes(buffer);

        // Imprime a página
        String endereco = String.format("%04d", pagina);
        System.out.print(endereco+"  " + pa.n +":"); // endereço e número de elementos
        for(i=0; i<maxElementos; i++)
        {
            System.out.print("("+String.format("%04d",pa.filhos[i])+") "+String.format("%2d",pa.chaves[i])+","+String.format("%2d",pa.dados[i])+" ");
        }//end for
        System.out.print("("+String.format("%04d",pa.filhos[i])+")");
        if(pa.proxima==-1)
            System.out.println();
        else
            System.out.println(" --> ("+String.format("%04d", pa.proxima)+")");

        // Chama recursivamente cada filho, se a página não for folha
        if(pa.filhos[0] != -1)
        {
            for(i=0; i<pa.n; i++)
                print1(pa.filhos[i]);
            print1(pa.filhos[i]);
        }//end if
    }//end print1()

    /**
     * Apaga o arquivo do índice, para que possa ser reconstruído
     * @throws IOException
     */
    public void apagar() throws IOException
    {
        File f = new File(nomeArquivo);
        f.delete();

        arquivo = new RandomAccessFile(nomeArquivo,"rw");
        arquivo.writeLong(-1);  // raiz vazia
    }//end apagar()
}//end class

//------------------------------------------------------------------------------

class CRUD
{
  /**
   * Faz a inclusão de um novo produto
   * @param arqProd
   * @throws IOException
   */
  public static void incluir(ArquivoProdutos arqProd) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //Atributos do produto
    String nome;
    String descricao;
    String tipo;
    String marca;
    float preco;

    //informações do produto---------------------------------------

             System.out.println("Digite o nome do produto: ");
             nome = br.readLine();
             System.out.println("Digite a descrição do produto: ");
             descricao = br.readLine();
             System.out.println("Digite o tipo de produto: ");
             tipo = br.readLine();
             System.out.println("Digite a marca do produto: ");
             marca = br.readLine();
             System.out.println("Digite o preço do produto: ");
             preco = Float.parseFloat(br.readLine());

    //end informações do produto-----------------------------------

             Produto novo = new Produto(-1, nome, descricao, tipo, marca, preco);

             int include = arqProd.incluir(novo);

             System.out.println("Inserido com sucesso - ID: " + include);
  }//end incluir

  /**
   * Faz a alteração de um produto existente
   * @param arqProd
   * @throws IOException
   */
  public static void alterar(ArquivoProdutos arqProd) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Digite o ID do produto: ");
    int alterarID = Integer.parseInt(br.readLine());

    Produto isProduto = arqProd.ler(alterarID);

    if(isProduto != null)
    {
      //Atributos do produto
      String nome;
      String descricao;
      String tipo;
      String marca;
      float preco;

      //informações do novo produto---------------------------------------

               System.out.println("Digite o novo nome do produto: ");
               nome = br.readLine();
               System.out.println("Digite a nova descrição do produto: ");
               descricao = br.readLine();
               System.out.println("Digite o novo tipo de produto: ");
               tipo = br.readLine();
               System.out.println("Digite a nova marca do produto: ");
               marca = br.readLine();
               System.out.println("Digite o novo preço do produto: ");
               preco = Float.parseFloat(br.readLine());

      //end informações do novo produto-----------------------------------

      isProduto.setnome(nome);
      isProduto.setdescricao(descricao);
      isProduto.settipo(tipo);
      isProduto.setmarca(marca);
      isProduto.setpreco(preco);

      boolean alterou = arqProd.alterar(alterarID, isProduto);

      if(alterou == true)
      {System.out.println("Produto alterado com sucesso!");}
      else
      {System.out.println("Falha na atualização!");}
    }
    else
    {System.out.println("Esse produto não existe!");}//end if
  }//end alterar()

  /**
   * Faz a exclusão de um produto existente
   * @param arqProd
   * @throws IOException
   */
  public static void excluir(ArquivoProdutos arqProd) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Digite o ID do produto: ");
    int excluirID = Integer.parseInt(br.readLine());
    boolean resp = arqProd.excluir(excluirID);

    if(resp == true)
    {System.out.println("Produto excluido com sucesso!");}
    else
    {System.out.println("Este produto não existe!");}
  }//end excluir()

  /**
   * Faz a consulta de um produto
   * @param arqProd
   * @throws IOException
   */
  public static void consultar(ArquivoProdutos arqProd) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Digite o ID do produto: ");
    int buscarID = Integer.parseInt(br.readLine());

    Produto p = arqProd.ler(buscarID);

    if(p == null)
    {System.out.println("Este produto não existe!");}
    else
    {p.mostrar();}
  }//end consultar()

  /**
   * Mostra a lista de produtos cadastrados
   * @param arqProd
   * @throws IOException
   */
  public static void listar(ArquivoProdutos arqProd) throws IOException
  {
    ArrayList<Produto> list = arqProd.listar();

    for(int i = 0; i < list.size(); i++)
    {
      list.get(i).mostrar();
      System.out.println();
    }//end for

  }//end listar()

  /**
   * Main
   * @throws IOException
   */
  public static void main(String []args) throws IOException
  {
    ArquivoProdutos arqProd;
    File rw;
    Produto p;

    try
    {
      p = new Produto();
      rw = new File("Produtos.db");
      arqProd = new ArquivoProdutos(p, "Produtos.db", "Produtos.idx");

      System.out.println("--------Menu de Opções--------\n" +
                        "1 - Incluir um produto\n" +
                        "2 - Alterar um produto\n" +
                        "3 - Excluir um produto\n" +
                        "4 - Consultar um produto por ID\n" +
                        "5 - Listar os produtos\n" +
                        "0 - Sair\n" +
                        "Escolha uma das opções acima: \n");

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int option = Integer.parseInt(br.readLine());

      while(option < 0 && option > 5)
      {
        br.readLine();
        System.out.println("Digite novamente: \n");
        option = Integer.parseInt(br.readLine());
      }//end while

      while(option != 0)
      {
          switch(option)
          {
            case 0:
              //Exit program
            break;
            case 1:
              System.out.println("1 - Incluir um produto");

              incluir(arqProd);

              System.out.println("Escolha uma opção novamente!");
              option = Integer.parseInt(br.readLine());
            break;
            case 2:
              System.out.println("2 - Alterar um produto");

              alterar(arqProd);

              System.out.println("Escolha uma opção novamente!");
              option = Integer.parseInt(br.readLine());
            break;
            case 3:
              System.out.println("3 - Excluir um produto");

              excluir(arqProd);

              System.out.println("Escolha uma opção novamente!");
              option = Integer.parseInt(br.readLine());
            break;
            case 4:
              System.out.println("4 - Consultar um produto por ID");

              consultar(arqProd);

              System.out.println("Escolha uma opção novamente!");
              option = Integer.parseInt(br.readLine());
            break;
            case 5:
              System.out.println("5 - Listar os produtos");

              listar(arqProd);

              System.out.println("Escolha uma opção novamente!");
              option = Integer.parseInt(br.readLine());
            break;
            default:
              System.out.println("Comando Inválido!");
              System.out.println("Escolha uma opção novamente!");
              option = Integer.parseInt(br.readLine());
          }//end switch
      }//end while
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }//end trycatch
  }//end main
}//end class
