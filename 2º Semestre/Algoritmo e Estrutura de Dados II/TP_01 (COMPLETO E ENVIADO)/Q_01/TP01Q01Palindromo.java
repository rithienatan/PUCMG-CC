/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 20/02/2017
* Exercício: TP01Q01Palindromo
*/

/**
* Classe Palindromo
*/
class TP01Q01Palindromo
{
	/**
	 * @param s Recebe uma String qualquer 
	 * @return Retorna true se for palindromo ou false caso contrário
	 */
	private static boolean isPalindromo(String s)
	{
		boolean resp = false;
		String trasprafrente = "";

		for(int i = s.length() - 1; i >= 0; i--)
		{
			trasprafrente = trasprafrente + s.charAt(i);
		}

		if( toCompare(trasprafrente, s) == true )
		{
			resp = true;
		}

		return (resp);
	}

	/**
	 * Metodo auxiliar que compara se duas String são iguais
	 * @param s,f ambas recebem valores de duas strings
	 */
	private static boolean toCompare(String s, String f)
	{
		boolean resp = false;
		
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == f.charAt(i))
			{
				resp = true;
			}
			else
			{
				resp = false;
				i = s.length();
			}
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
		while( toCompare(arq[quantEntrada++],"FIM") != true );		

		for(int i = 0; i < (quantEntrada - 1); i++)
		{
			if( isPalindromo(arq[i]) == true )
			{
				MyIO.println( "SIM" );
			}
			else
			{
				MyIO.println( "NAO" );
			}
		}	
	}
}
/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 * @version 0.3 - Upagrade do metodo toCompare - ok!
 */
