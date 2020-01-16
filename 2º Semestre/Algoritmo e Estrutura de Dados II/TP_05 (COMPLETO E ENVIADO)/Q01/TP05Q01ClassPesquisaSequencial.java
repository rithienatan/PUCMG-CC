/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 11/10/2017
* Exercício: TP05Q01ClassPesquisaSequencial
*/

//Bibliotecas --------------------------------------------------------

import java.util.*;
import java.lang.*;

//--------------------------------------------------------------------

class Series
{
	private String nome;
	private String formato;
	private String duracao;
	private String pais_origem;
	private String idioma_original;
	private String emissora_tv;
	private String transmissao_original;
	private int n_temporadas;
	private int n_episodios;


	/**
	 * Construtor padrão
	 */
	public Series()
	{
		this.nome = null;
		this.formato = null;
		this.duracao = null;
		this.pais_origem = null;
		this.idioma_original = null;
		this.emissora_tv = null;
		this.transmissao_original = null;
		this.n_temporadas = 0;
		this.n_episodios = 0;
	}//end Series

	/**
	 * Metodo Contrutor
	 * @param recebe os valores dos atributos no parametro
	 */
	public Series(String nome, String formato, String duracao, String pais_origem, String idioma_original,
		      String emissora_tv, String transmissao_original, int n_temporadas, int n_episodios)
	{
		this.nome = nome;
		this.formato = formato;
		this.duracao = duracao;
		this.pais_origem = pais_origem;
		this.idioma_original = idioma_original;
		this.emissora_tv = emissora_tv;
		this.transmissao_original = transmissao_original;
		this.n_temporadas = n_temporadas;
		this.n_episodios = n_episodios;
	}//end Series

	//metodos get(s) e set(s) ------------------------------------------------
		
		/**
		 * Get e set nome
		 */
		public String getnome()
		{
			return(nome);
		}//end nome
		public void setnome(String nome)
		{
			this.nome = nome;
		}//end setnome
	
		/**
		 * Get e set formato
		 */
		public String getformato()
		{
			return(formato);
		}//end formato
		public void setformato(String formato)
		{
			this.formato = formato;
		}//end setformato

		/**
		 * Get e Set duracao
		 */
		public String getduracao()
		{
			return(duracao);
		}//end duracao
		public void setduracao(String duracao)
		{
			this.duracao = duracao;
		}//end setduracao

		/**
		 * Get e Set pais_origem
		 */
		public String getpais_origem()
		{
			return(pais_origem);
		}//end pais_origem
		public void setpais_origem(String pais_origem)
		{
			this.pais_origem = pais_origem;
		}//end setpais_origem

		/**
		 * Get e Set idioma_original
		 */
		public String getidioma_original()
		{
			return(idioma_original);
		}//end idioma_original
		public void setidioma_original(String idioma_original)
		{
			this.idioma_original = idioma_original;
		}//end setidioma_original

		/**
		 * Get e Set emissora_tv
		 */
		public String getemissora_tv()
		{
			return(emissora_tv);
		}//end emissora_tv
		public void setemissora_tv(String emissora_tv)
		{
			this.emissora_tv = emissora_tv;
		}//end setemissora_tv

		/**
		 * Get e Set transmissao_original
		 */
		public String gettransmissao_original()
		{
			return(transmissao_original);
		}//end transmissao_original
		public void settransmissao_original(String transmissao_original)
		{
			this.transmissao_original = transmissao_original;
		}//end settransmissao_original

		/**
		 * Get e Set n_temporadas
		 */
		public int getn_temporadas()
		{
			return(n_temporadas);
		}//end n_temporadas
		public void setn_temporadas(int n_temporadas)
		{
			this.n_temporadas = n_temporadas;
		}//end setn_temporadas

		/**
		 * Get e Set n_episodios
		 */
		public int getn_episodios()
		{
			return(n_episodios);
		}//end n_episodios
		public void setn_episodios(int n_episodios)
		{
			this.n_episodios = n_episodios;
		}//end setn_episodios

	//metodos ler(), imprimir() e clone()-------------------------------------------------------

		/**
		 * Metodo de leitura do html
		 * @param entrada Recebe o nome da pagina html
		 */
		public void ler(String entrada)
		{
			//extraindo nome
			String name, charset = "UTF-8";
			name = entrada.replace("_", " ").replace(".html", "");
			setnome(name);

			//extraindo as outras informações
			Arq.openRead("/tmp/" + entrada, charset);
			String aux; //recebe a linha sem tags
			String linha = Arq.readLine();
			aux = linha.replaceAll("<.*?>" ,"");

			while((linha != null) && Arq.hasNext() == true)
			{
				if(aux.equals("Formato") == true)
				{
					linha = Arq.readLine();
					aux = linha.replaceAll("<.*?>" ,"");
					setformato(aux);
				}
			 	else if(aux.equals("Duração") == true)
				{
					linha = Arq.readLine();
					aux = linha.replaceAll("<.*?>" ,"");
					if((aux.equals("") != true) && (getduracao() == null))
					{
						setduracao(aux);
					}//end if
				}
			 	else if(aux.equals("País de origem") == true)
				{
					linha = Arq.readLine();
					aux = linha.replaceAll("<.*?>" ,"");
					if((aux.contains("&#160;") == true) || (aux.contains("&nbsp;") == true))
					{
						aux = aux.replaceAll("&#160;", "");
						aux = aux.replaceAll("&nbsp;", "");
						setpais_origem(aux);
					}
					else
					{
						setpais_origem(aux);
					}//end if
				}
			 	else if(aux.equals("Idioma original") == true)
				{
					linha = Arq.readLine();
					aux = linha.replaceAll("<.*?>" ,"");
					setidioma_original(aux);
				}
			 	else if(aux.equals("Emissora de televisão original") == true)
				{
					linha = Arq.readLine();
					aux = linha.replaceAll("<.*?>" ,"");
					setemissora_tv(aux);
				}
			 	else if(aux.equals("Transmissão original") == true)
				{
					linha = Arq.readLine();
					aux = linha.replaceAll("<.*?>" ,"");
					settransmissao_original(aux);
					if((aux.contains("&#160;") == true) || (aux.contains("&nbsp;") == true))
					{
						aux = aux.replaceAll("&#160;", "");
						aux = aux.replaceAll("&nbsp;", "");
						settransmissao_original(aux);
					}
					else
					{
						settransmissao_original(aux);
					}//end if
				}
			 	else if(aux.equals("N.º de temporadas") == true)
				{
					linha = Arq.readLine();
					aux = linha.replaceAll("<.*?>" ,"");
					String []ntemp = aux.split(" ");
					setn_temporadas(Integer.parseInt(ntemp[0]));
				}
			 	else if(aux.equals("N.º de episódios") == true)
				{
					linha = Arq.readLine();
					aux = linha.replaceAll("<.*?>" ,"");
					String []number = aux.split(" ");
					if((number[0].charAt(0) >= '0') && (number[0].charAt(0) <= '9'))
					{
						setn_episodios(Integer.parseInt(number[0]));
					}//end if
				}//end if
				linha = Arq.readLine();
				aux = linha.replaceAll("<.*?>" ,""); 
			}//end while()

			Arq.close();
		}//end ler()

		/**
		 * Metodo imprimir
		 */
		public void imprimir()
		{
		  	System.out.println("" + getnome() + " " + getformato() + 
				     " " + getduracao() + " " + getpais_origem() + 
				     " " + getidioma_original() + 
                                     " " + getemissora_tv() + 
				     " " + gettransmissao_original() + 
				     " " + getn_temporadas() + 
				     " " + getn_episodios());
		}//end imprimir()

		/**
		 * Metodo clone
		 * @return Retorna um ponteiro com todos os atributos clonados
		 */
		public Series clone()
		{
			Series series = new Series(this.nome, this.formato, 
						   this.duracao, this.pais_origem, 
					           this.idioma_original, 
						   this.emissora_tv, 
						   this.transmissao_original, 
						   this.n_temporadas, 
						   this.n_episodios);
			return(series);
		}//end clone()
}//end Series

//end Series-------------------------------------------------------------

class Lista
{
	private int n;//quantidade de elementos da lista
	private Series []lista;
	private int quantComparar;// n de comparações
	
	/**
	 * Construtor
	 */
	public Lista()
	{
		this(200);
	}//end construtor()

	/**
	 * Construtor padrão
	 * @param tamanho Recebe o tamanho total da lista
	 */
	public Lista(int tamanho)
	{
		lista = new Series[tamanho];
		n = 0;
		quantComparar = 0;
	}//end construtor padrão()

	/**
	 * Inserir no inicio da lista
	 * @param serie Recebe o ponteiro que contém a serie a ser inserida
	 */
	public void inserirInicio(Series serie)throws Exception
	{
		if(n >= lista.length)
		{
			throw new Exception("Lista cheia!");
		}//end if

		for(int i = n; i > 0; i--)
		{
			lista[i] = lista[i-1];
		}//end for

		lista[0] = serie;
		n++;
	}//end inserirInicio()

	/**
	 * Inseri no fim da lista
	 * @param serie Recebe o ponteiro que contém a serie a ser inserida
	 */
	public void inserirFim(Series serie)throws Exception
	{
		if(n >= lista.length)
		{
			throw new Exception("Lista cheia!");
		}//end if

		lista[n] = serie;
		n++;
	}//end inserirFim()

	/**
	 * Inseri em uma posição desejada
	 * @param serie Recebe o ponteiro que contém a serie a ser inserida
	 * @param pos Recebe a posição que será inserida
	 */
	public void inserir(Series serie, int pos)throws Exception
	{
		if(n >= lista.length || pos < 0 || pos > n)
		{
			throw new Exception("Lista cheia ou posição incorreta!");
		}//end if

		//leva os elementos já inseridos para o fim da lista
		for(int i = n; i > pos; i--)
		{
			lista[i] = lista[i-1];
		}//end for

		lista[pos] = serie;
		n++;
	}//end inserir()

	/**
	 * Remove elementos que estão no inicio da lista
	 * @return Retorna o ponteiro serie que foi retirado da lista
	 */
	public Series removerInicio()throws Exception
	{
		if(n == 0)
		{
			throw new Exception("Lista vazia!");
		}//end if

		Series resp = lista[0];

		for(int i = 0; i < n; i++)
		{
			lista[i] = lista[i+1];
		}//end for
		n--;

		return(resp);
	}//end removerInicio()

	/**
	 * Remove elementos que estão no fim da lista
	 * @return Retorna o ponteiro serie que foi retirado da lista
	 */
	public Series removerFim()throws Exception
	{
		if(n == 0)
		{
			throw new Exception("Lista vazia!");
		}//end if
		
		return(lista[--n]);
	}//end removerFim()

	/**
	 * Remove elementos que estão no inicio da lista
	 * @param pos Recebe a posição do elemento a ser removido
	 * @return Retorna o ponteiro serie que foi retirado da lista
	 */
	public Series remover(int pos)throws Exception
	{
		if(n == 0 || pos < 0 || pos >= n)
		{
			throw new Exception("Lista vazia ou posição incorreta!");
		}//end if
		
		Series resp = lista[pos];
		n--;

		for(int i = pos; i < n; i++)
		{
			lista[i] = lista[i+1];
		}//end for

		return(resp);
	}//end remover()

	/**
	 * Mostra os elementos da lista
	 */
	public void mostrar()
	{
		for(int i = 0; i < n; i++)
		{
			lista[i].imprimir();
		}//end for
	}//end mostrar()

	/**
	 * Pesquisa se um elemento existe na lista
	 * @param nome Pesquisa os elementos pelo nome da série
	 * @return true para elementos que foram encontrados | false para o contrário
 	 */
	public boolean pesquisaSequencial(String nome)
	{
		boolean resp = false;

		for(int i = 0; i < n; i++)
		{
			if(lista[i].getnome().equals(nome) == true)
			{
				resp = true;
				i = n;
			}//end if
			quantComparar = quantComparar + 1;
		}//end for		

		return(resp);
	}//end pesquisaSequencial()
	
	/**
	 * Get numero de comparações no método de pesquisa
	 */
	public int getcomparacoes()
	{
		return(quantComparar);
	}//end getcomparacoes()
}//end Lista

//end Lista--------------------------------------------------------------

class TP05Q01ClassPesquisaSequencial
{
	/**
	 * Método main
	 */
	public static void main(String []args)throws Exception
	{		
		long inicio = System.currentTimeMillis();
	//---------------------------------------------------------------------------------
		String[] arq = new String[1000];
		String linha;
		int quantEntrada = 0; //quantidade de entradas
		Series series = null;
		Lista lista = new Lista();

		//ler e armazenar as entradas
		do
		{
			arq[quantEntrada] = MyIO.readLine();
		}
		while(arq[quantEntrada++].equals("FIM") != true );

		for(int i = 0; i < quantEntrada - 1; i++)
		{
			series = new Series();
			series.ler(arq[i]);
			lista.inserirFim(series);
		}//end for

		do
		{
			arq[quantEntrada] = MyIO.readLine();
			if(arq[quantEntrada].equals("FIM") != true)
			{
				if(lista.pesquisaSequencial(arq[quantEntrada]) == true)
				{
					System.out.println("SIM");
				}
				else
				{
					System.out.println("NÃO");
				}//end if
			}//end if
		}
		while(arq[quantEntrada++].equals("FIM") != true);
	//--------------------------------------------------------------------------------
		long fim = System.currentTimeMillis();

		Arq.openWrite("541488_sequencial.txt");
		Arq.println("541488\t" + (fim-inicio) + "ms\t" + lista.getcomparacoes());
		Arq.close();
	}//end main
}//end TP05Q01ClassPesquisaSequencial

/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 * @version 0.3 - Upagrade do metodo toCompare - ok!
 */
