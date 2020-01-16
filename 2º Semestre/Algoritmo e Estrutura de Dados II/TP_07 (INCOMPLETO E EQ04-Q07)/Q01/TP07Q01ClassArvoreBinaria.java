/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 28/11/2017
* Exercício: TP07Q01ClassArvoreBinaria
*/

//Bibliotecas --------------------------------------------------------

import java.util.*;
import java.lang.*;
import java.io.*;

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

			while((linha != null && Arq.hasNext() == true))
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

class No
{
	public Series elemento;
	public No esq, dir;

	public No(Series x)
	{
		this(x, null, null);
	}//end No

	public No(Series x, No esq, No dir)
	{
		this.elemento = x;
		this.esq = esq;
		this.dir = dir;
	}//end No
}//end No

//end No------------------------------------------------------------------------

class ArvoreBinaria
{
	private No raiz;
	private int quantComparar;// n de comparações

	/**
	 * Construtor
	 */
	public ArvoreBinaria()
	{
		raiz = null;
	}//end construtor()

	/**
	 * pesquisar na Arvore
	 * @param x Elemento a ser pesquisado
	 * @return True caso o elemento seja encontrado
	 */
	public boolean pesquisar(String x)
	{
		System.out.print("raiz ");
		return(pesquisar(x, raiz));
	}//end pesquisar()

	private boolean pesquisar(String x, No i)
	{
		boolean resp;
		if(i == null)
		{
			quantComparar = quantComparar + 1;
			resp = false;
		}
		else if(x.replaceAll(" ", "").equals(i.elemento.getnome().replaceAll(" ", "")) == true)
		{
			quantComparar = quantComparar + 2;
			resp = true;
		}
		else if(x.compareTo(i.elemento.getnome()) < 0)
		{
			quantComparar = quantComparar + 3;
			System.out.print("esq ");
			resp = pesquisar(x, i.esq);
		}
		else
		{
			quantComparar = quantComparar + 3;
			System.out.print("dir ");
			resp = pesquisar(x, i.dir);
		}//end if
	
		return(resp);
	}//end pesquisar()

	/**
	 * inserir na Arvore
	 * @param x Elemento a ser inserido
	 */
	public void inserir(Series x) throws Exception
	{
		raiz = inserir(x, raiz);
	}//end inserir()

	private No inserir(Series x, No i) throws Exception
	{
		if(i == null)
		{
			quantComparar = quantComparar + 1;
			i = new No(x);
		}
		else if(x.getnome().compareTo(i.elemento.getnome()) < 0)
		{
			quantComparar = quantComparar + 2;
			i.esq = inserir(x, i.esq);
		}
		else if(x.getnome().compareTo(i.elemento.getnome()) > 0)
		{
			quantComparar = quantComparar + 3;
			i.dir = inserir(x, i.dir);
		}
		else
		{
			throw new Exception("Erro!");
		}//end if

		return(i);
	}//end inserir()	

	/**
	 * remover na Arvore
	 * @param x Elemento a ser inserido
	 */
	public void remover(String x) throws Exception
	{
		raiz = remover(x, raiz);
	}//end remover()

	private No remover(String x, No i) throws Exception
	{
		if(i == null)
		{
			quantComparar = quantComparar + 1;
			i = null;
		}
		else if(x.compareTo(i.elemento.getnome()) < 0)
		{
			quantComparar = quantComparar + 2;
			i.esq = remover(x, i.esq);
		}
		else if(x.compareTo(i.elemento.getnome()) > 0)
		{
			quantComparar = quantComparar + 3;
			i.dir = remover(x, i.dir);
		}
		else if(i.dir == null)
		{
			quantComparar = quantComparar + 4;
			i = i.esq;
		}
		else if(i.esq == null)
		{
			quantComparar = quantComparar + 5;
			i = i.dir;
		}
		else
		{
			quantComparar = quantComparar + 5;
			i.esq = anterior(i, i.esq);
		}//end if

		return(i);
	}//end remover()

	private No anterior(No i, No j)
	{
		if(j.dir != null)
		{
			j.dir = anterior(i, j.dir);
		}
		else
		{
			i.elemento = j.elemento; j = j.esq;
		}//end if

		return(j);
	}//end anterior()

	/**
	 * Get numero de comparações no método de pesquisa
	 */
	public int getcomparacoes()
	{
		return(quantComparar);
	}//end getcomparacoes()
}//end ArvoreBinaria

//end ArvoreBinaria--------------------------------------------------------------

class TP07Q01ClassArvoreBinaria
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
		ArvoreBinaria ab = new ArvoreBinaria();

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
			ab.inserir(series);
		}//end for

		arq[quantEntrada] = MyIO.readLine();
		int n = Integer.parseInt(arq[quantEntrada], 10);//quantidades de comando da lista

		for(int i = 0; i < n; i++)
		{
			quantEntrada = quantEntrada + 1;
			arq[quantEntrada] = MyIO.readLine();
			String[] s = new String[3];//contém duas strings
			s = arq[quantEntrada].split(" ");

			if(s[0].equals("I") == true)
			{
				series = new Series();
				series.ler(s[1]);
				ab.inserir(series);
			}
			else if(s[0].equals("R") == true)
			{
				String junto;
				if(s.length == 3)
				{
					junto = "" + s[1] + " " + s[2];
				}
				else
				{
					junto = s[1];
				}//end if
				ab.remover(junto);
			}//end if
		}//end for

		do
		{
			arq[quantEntrada] = MyIO.readLine();
			if(arq[quantEntrada].equals("FIM") != true)
			{
				if(ab.pesquisar(arq[quantEntrada]) == true)
				{
					System.out.print("SIM\n");
				}
				else
				{
					System.out.print("NAO\n");
				}//end if
			}//end if
		}
		while(arq[quantEntrada++].equals("FIM") != true);

	//--------------------------------------------------------------------------------
		long fim = System.currentTimeMillis();

		Arq.openWrite("541488_arvorebinaria.txt");
		Arq.println("541488\t" + (fim-inicio) + "ms\t" + ab.getcomparacoes());
		Arq.close();
	}//end main
}//end TP07Q01ArvoreBinaria

/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 * @version 0.3 - Upagrade do metodo toCompare - ok!
 */
