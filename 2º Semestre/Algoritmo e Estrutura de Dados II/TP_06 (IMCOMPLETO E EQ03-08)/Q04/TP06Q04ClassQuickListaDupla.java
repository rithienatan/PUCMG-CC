/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 02/12/2017
* Exercício: TP06Q04ClassQuickListaDupla
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
		}//end setnomeTP0512ClassListaFlexivel

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

class CelulaDupla
{
	public Series elemento;
	public CelulaDupla prox, ant;

	public CelulaDupla()
	{
		this(null);
	}//end Celula

	public CelulaDupla(Series x)
	{
		this.elemento = x;
		this.prox = this.ant = null;
	}//end Celula
}//end Celula

//end Celula------------------------------------------------------------------------

class ListaDupla
{
	private CelulaDupla primeiro, ultimo;
	private int quantComparar;// n de comparações

	/**
	 * Construtor
	 */
	public ListaDupla()
	{
		primeiro = new CelulaDupla();
		ultimo = primeiro;
	}//end construtor()

	/**
	 * @return tamanho da lista
	 */
	private int tamanho()
	{
		int i = 0;

		for(CelulaDupla j = primeiro; j.prox != ultimo.prox; j = j.prox, i++);

		return(i);
	}//end tamanho()

	/**
	 * Inserir no inicio da lista
	 * @param serie Recebe o ponteiro que contém a serie a ser inserida
	 */
	public void inserirInicio(Series serie)
	{
		CelulaDupla tmp = new CelulaDupla(serie);
		tmp.ant = primeiro;
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if(primeiro == ultimo)
		{
			ultimo = tmp;
		}
		else
		{
			tmp.prox.ant = tmp;
		}//end if

		tmp = null;
	}//end inserirInicio()

	/**
	 * Inseri no fim da lista
	 * @param serie Recebe o ponteiro que contém a serie a ser inserida
	 */
	public void inserirFim(Series serie)throws Exception
	{
		ultimo.prox = new CelulaDupla(serie);
		ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
	}//end inserirFim()

	/**
	 * Inseri em uma posição desejada
	 * @param serie Recebe o ponteiro que contém a serie a ser inserida
	 * @param pos Recebe a posição que será inserida
	 */
	public void inserir(Series serie, int pos)throws Exception
	{
		int tamanho = tamanho();

		if(pos < 0 || pos > tamanho)
		{
			throw new Exception("Erro!");
		}
		else if(pos == 0)
		{
			inserirInicio(serie);
		}
		else if(pos == tamanho)
		{
			inserirFim(serie);
		}
		else
		{
			CelulaDupla i = primeiro;
			for(int j = 0; j < pos; j++, i = i.prox);
			CelulaDupla tmp = new CelulaDupla(serie);
			tmp.ant = i;
			tmp.prox = i.prox;
			tmp.ant.prox = tmp.prox.ant = tmp;
			tmp = i = null;
		}//end if
	}//end inserir()

	/**
	 * Remove elementos que estão no inicio da lista
	 * @return Retorna o ponteiro serie que foi retirado da lista
	 */
	public Series removerInicio()throws Exception
	{
		if(primeiro == ultimo)
		{
			throw new Exception("Erro!");
		}//end if

		CelulaDupla tmp = primeiro;
		primeiro = primeiro.prox;
		Series resp = primeiro.elemento;
		tmp.prox = primeiro.ant = null;
		tmp = null;

		return(resp);
	}//end removerInicio()

	/**
	 * Remove elementos que estão no fim da lista
	 * @return Retorna o ponteiro serie que foi retirado da lista
	 */
	public Series removerFim()throws Exception
	{

		if(primeiro == ultimo)
		{
			throw new Exception("Lista vazia!");
		}//end if

		Series resp = ultimo.elemento;
		ultimo = ultimo.ant;
		ultimo.prox.ant = null;
		ultimo.prox = null;

		return(resp);
	}//end removerFim()

	/**
	 * Remove elementos que estão no inicio da lista
	 * @param pos Recebe a posição do elemento a ser removido
	 * @return Retorna o ponteiro serie que foi retirado da lista
	 */
	public Series remover(int pos)throws Exception
	{
		Series resp;
		int tamanho = tamanho();
		if(primeiro == ultimo || pos < 0 || pos >= tamanho)
		{
			throw new Exception("Lista vazia ou posição incorreta!");
		}
		else if(pos == 0)
		{
			resp = removerInicio();
		}
		else if(pos == tamanho - 1)
		{
			resp = removerFim();
		}
		else
		{
			CelulaDupla i = primeiro.prox;
			for(int j = 0; j < pos; j++, i = i.prox);
			i.ant.prox = i.prox;
			i.prox.ant = i.ant;
			resp = i.elemento;
			i.prox = i.ant = null;
			i = null;
		}//end if

		return(resp);
	}//end remover()

	/**
	 * Mostra os elementos da lista
	 */
	public void mostrar()
	{
		for(CelulaDupla i = primeiro.prox; i != null; i = i.prox)
		{
			i.elemento.imprimir();
		}//end for
	}//end mostrar()

		/**
		 * Metodo swap
		 * @param menor recebe ponteiro na posição do MENOR elemento
		 * @param maior recebe ponteiro na posição do MAIOR elemento
		 */
		private void swap(CelulaDupla menor,CelulaDupla maior)
		{
			Series tmp = menor.elemento;
			menor.elemento = maior.elemento;
			maior.elemento = tmp;
			tmp = null;
		}//end swap()

		/**
 	   * Metodo de ordenação por nome
	 	 */
			private void ordenacaoNome()
			{
				for(CelulaDupla i = primeiro.prox; i != ultimo; i = i.prox)
				{
					CelulaDupla menor = i;
					for(CelulaDupla j = i.prox; j != null; j = j.prox)
					{
						if(menor.elemento.getpais_origem().trim().compareTo(j.elemento.getpais_origem().trim()) == 0 && menor.elemento.getnome().compareTo(j.elemento.getnome()) >= 1)
						{
							menor = j;
						}//end if
					}//end for
					swap(menor, i);

					//if(i.prox == ultimo)
					//{
					//	i = null;
						//menor = null;
					//}//end if
				}//end for
			}//end ordenacaoNome()

		/**
		 * Chamador recursivo
		 */
		public void quicksort()
		{
			int n = tamanho();
			quicksort(0, n-1, primeiro.prox, ultimo);
		}//end quicksort()

		/**
		 * Metodo de ordenacão por pais de origem
		 * @param esq Posicao onde inicia a pesquisa
		 * @param dir Posicao onde termina a pesquisa
		 * @param esqL Ponteiro na posição da ListaDupla refente a esq
		 * @param dirL Ponteiro na posição da ListaDupla refente a dir
		 */
		public void quicksort(int esq, int dir, CelulaDupla esqL, CelulaDupla dirL)
		{
			int i = esq, j = dir;
			CelulaDupla iL = esqL, jL = dirL;
			CelulaDupla pivo = primeiro.prox;
			for(int f = 0; f < (dir + esq)/2; f++, pivo = pivo.prox);

			while(i <= j)
			{
				while(iL.elemento.getpais_origem().trim().compareTo(pivo.elemento.getpais_origem().trim()) <= -1)
				{
					quantComparar = quantComparar + 1;
					i++;
					iL = iL.prox;
				}//end while
				while(jL.elemento.getpais_origem().trim().compareTo(pivo.elemento.getpais_origem().trim()) >= 1)
				{
					quantComparar = quantComparar + 1;
					j--;
					jL = jL.ant;
				}//end while

				quantComparar = quantComparar + 2;

				if(i <= j)
				{
					swap(iL, jL); i++; j--; iL = iL.prox; jL = jL.ant;
				}//end if
			}//end while

			if(esq < j)
			{
				quicksort(esq, j, esqL, jL);
			}//end if
			if(i < dir)
			{
				quicksort(i, dir, iL, dirL);
			}//end if

			ordenacaoNome();
		}//end quicksort()

	/**
	 * Get numero de comparações no método de pesquisa
	 */
	public int getcomparacoes()
	{
		return(quantComparar);
	}//end getcomparacoes()
}//end Lista

//end Lista--------------------------------------------------------------

class TP06Q04ClassQuickListaDupla
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
		ListaDupla lista = new ListaDupla();

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

		lista.quicksort();

		lista.mostrar();
	//--------------------------------------------------------------------------------
		long fim = System.currentTimeMillis();

		Arq.openWrite("541488_quicksort2.txt");
		Arq.println("541488\t" + (fim-inicio) + "ms\t" + lista.getcomparacoes());
		Arq.close();
	}//end main
}//end TP06Q04ClassQuickListaDupla

/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 * @version 0.3 - Upagrade do metodo toCompare - ok!
 */
