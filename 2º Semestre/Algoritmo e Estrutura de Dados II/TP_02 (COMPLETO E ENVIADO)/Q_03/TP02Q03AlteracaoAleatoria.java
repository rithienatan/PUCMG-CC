/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 20/02/2017
* Exercício: TP02Q03AlteracaoAleatoria
*/

/**
 * Bibliotecas
 */
import java.util.*;

/**
* Classe AlteracaoAleatoria
*/
class TP02Q03AlteracaoAleatoria
{
	/**
	 * Chamador recursivo
	 */
	private static String substituicao(String s, char char1, char char2)
	{
		return(substituicao(s, char1, char2, 0));
	}//end metodo

	/**
	 * @param s Recebe uma String qualquer
	 * @param char1 letra de ocorrencia
	 * @param char2 letra de substituição
	 * @return Retorna outra string com letras substituidas
	 */
	private static String substituicao(String s, char char1, char char2, int i)
	{
		String resp = "";
		
		// verifica a ocorrencia de letra e substitui por char2
		if(i < s.length())
		{
			if(s.charAt(i) == char1)
			{
				resp = char2 + substituicao(s, char1, char2, i+1);
			}
			else
			{
				resp = s.charAt(i) + substituicao(s, char1, char2, i+1);
			}//end if
		}//end if
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
		char char1;
		char char2;
		
		Random gerador = new Random();
		gerador.setSeed(4);

		//ler e armazenar as entradas
		do
		{
			arq[quantEntrada] = MyIO.readLine();
		}
		while( toCompare(arq[quantEntrada++],"FIM") != true );		

		for(int i = 0; i < (quantEntrada - 1); i++)
		{
			//gera letras aleatórias para char1 e char2		
			char1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
			char2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
			
			MyIO.println(substituicao(arq[i], char1, char2));
		}	
	}
}
/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 * @version 0.3 - Upgrade do metodo toCompare - ok!
 */
