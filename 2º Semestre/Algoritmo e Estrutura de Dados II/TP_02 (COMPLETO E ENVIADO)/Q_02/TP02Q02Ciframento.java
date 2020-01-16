/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 22/02/2017
* Exercício: TP02Q02Ciframento
*/

/**
* Classe Ciframento
*/
class TP02Q02Ciframento
{
	/**
	 * Chamador recursivo
	 */
	private static String Ciframento(String s)
	{
		return(Ciframento(s, 0));
	}//end metodo

	/**
	 * @param s Recebe uma String qualquer 
	 * @return Retorna outra string com chave de ciframento 3
	 */
	private static String Ciframento(String s, int i)
	{
		String resp = "";
		int cod = 0; //codigo do caracter

		if(i < s.length())
		{
			cod = (int)s.charAt(i) + 3;
                       	resp = (char)((int)s.charAt(i) + 3) + Ciframento(s, i+1);
		}
		return(resp);
	}//end metodo

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
			MyIO.println(Ciframento(arq[i]));
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
