/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 22/02/2017
* Exercício: TP01Q00Aquecimento
*/

/**
* Classe Aquecimento
*/
class TP02Q00Aquecimento
{
	/**
	 * Chamador recursivo
	 */
	private static int quantmaiuscula(String s)
	{
		return(quantmaiuscula(s, 0));
	}
	
	/**
	 * @param s Recebe uma String qualquer 
	 * @return Retorna a quantidade de caracteres maiúsculos na String
	 */
	private static int quantmaiuscula(String s, int i)
	{
		int resp = 0, total = 0;

		if(i < s.length())
		{
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
			{
				resp =  quantmaiuscula(s, i+1) + 1;
			}//end if
			else
			{
				resp =  quantmaiuscula(s, i+1) + 0;
			}
		}//end if
		return (resp);
	}

	/**
	 * Metodo que compara se duas String em valor literal são iguais
	 * @param s recebe o valor de uma linha
	 * @return retorna um valor boleano para comparar no while(linha 54)
	 */
	private static boolean toCompare(String s)
	{
		boolean resp = false;
		String fim = "FIM";
		char a = s.charAt(0), b = s.charAt(1), c = s.charAt(2);

		if((a == fim.charAt(0)) && (b == fim.charAt(1)) && (c == fim.charAt(2)) && (s.length() == 3))
		{
			resp = true;	
		}

		return(resp); 
	}

	/**
	 * Metodo main
	 */
	public static void main(String [] args)
	{
		String[] arq = new String[1000];
		String linha;
		int quantEntrada = 0; //quantidade de entradas

		//ler e armazenar as entradas
		do
		{
			arq[quantEntrada] = MyIO.readLine();
		}
		while( toCompare(arq[quantEntrada++]) != true );		

		for(int i = 0; i < (quantEntrada - 1); i++)
		{
			MyIO.println( quantmaiuscula(arq[i]) );
		}	
	}
}
/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 */
