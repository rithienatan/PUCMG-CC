/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 21/08/2017
* Exercício: TP02Q04AlgebraBooleana
*/

/**
 * Bibliotecas
 */
import java.util.*;

/**
* Classe AlgebraBooleana
*/
class TP02Q04AlgebraBooleana
{
	/**
	 * Faz a leitura da expressão booleana
	 * @param s Recebe uma String com uma expressão booleana 
	 * @return Retorna valor booleano indicando o resultado da expressão
	 */
	private static boolean AlgebraBooleana(String s)
	{
		String legenda = "";
		boolean resp = false;
		boolean A = false, B = false, C = false; //variáveis lógicas com o valor '0' setado

		legenda = legendando(s);

		//determina a quantidade de entradas
		if(s.charAt(0) == '2')
		{
			//determina os valores das entradas
			if(s.charAt(2) == '1')
			{
				A = true;
			}//end if
			if(s.charAt(4) == '1')
			{
				B = true;
			}//end if

			//verficando a legenda se é verdadeira
			if(toCompare(legenda, "01213") == true)
			{
				resp = ((!A) && (!B));
			}
			else if(toCompare(legenda, "1023"))
			{
				resp = !(A && B);
			}//end if
		}
		else if(s.charAt(0) == '3')
		{
			//seta os valores das variáveis
			if(s.charAt(2) == '1')
			{
				A = true;
			}//end if
			if(s.charAt(4) == '1')
			{
				B = true;
			}//end if
			if(s.charAt(6) == '1')
			{
				C = true;
			}//end if

			//verificando se a legenda é verdadeira
			if(toCompare(legenda, "02341045") == true)
			{
				resp = ((A || B) && (!(B && C)));
			}
			else if(toCompare(legenda, "03245") == true)
			{
				resp = (A && (B || C));
			}
			else if(toCompare(legenda, "2034035") == true)
			{
				resp = ((A && B) || (A && C));
			}
			else if(toCompare(legenda, "23045") == true)
			{
				resp = (A || (B && C));
			}
			else if(toCompare(legenda, "22345") == true)
			{
				resp = ((A || B) || C);
			}
			else if(toCompare(legenda, "2034502345") == true)
			{
				resp = (((A && B) && C) || ((A || B) && C));
			}
			else if(toCompare(legenda, "20345031450131450131415") == true)
			{
				resp = ((((A && B) && C) || ((A && (!B)) && C)) || ((((!A) && (!B)) && C) || (((!A) && (!B)) && (!C))));
			}
			else if(toCompare(legenda, "213403415") == true)
			{
				resp = (((!A) || B) || ((A && B) && (!C)));
			}
			else if(toCompare(legenda, "0234152452135") == true)
			{
				resp = ((((A || B) || (!C)) && (B || C)) && ((!A) || C));
			}
			else if(toCompare(legenda, "22010341501345034503141503145") == true)
			{
				resp = (((((!(A && B)) && (!C)) || (((!A) && B) && C)) || (((A && B) && C) || ((A && (!B)) && (!C)))) || ((A && (!B)) && C));
			}
			else if(toCompare(legenda, "203450314101315") == true)
			{
				resp = (((A && B) && C) || ((A && (!B)) && (!((!A) && (!C)))));
			}//end if
		}//end if

		return(resp);
	}//end AlgebraBooleana()

	/**
	 * Chamada recursiva de legendando
	 * @param s Recebe uma String com uma expressão booleana
	 * @return Retorna a legenda da expressão
	 */
	private static String legendando (String s)
	{
		String resp = "";
		if(s.charAt(0) == '2')
		{
			resp = legendando(s, 6, "");
		}
		else if(s.charAt(0) == '3')
		{
			resp = legendando(s, 8, "");
		}
		return(resp);
	}//end legendando()

	/**
	 * @param expressao Concatena uma parte da string s
	 * @param s Recebe uma String com uma expressão booleana
	 * @param i Contador para pegar as posição dentro das strings
	 * @return Retorna valor booleano indicando o resultado da expressão
	 */
	private static String legendando (String s, int i, String expressao)
	{
		String legenda = ""; //traduz a parte booleana em números

		if((s.charAt(0) == '2') && (i < (s.length() - 1)))
		{
			if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
			{
				expressao = expressao + s.charAt(i);
				if(toCompare(expressao, "and") == true)
				{
					legenda = "0" + legendando(s, i+1, "");
				}
				else if(toCompare(expressao, "not") == true)
				{
					legenda = "1" + legendando(s, i+1, "");
				}
				else if(toCompare(expressao, "A") == true)
				{
					legenda = "2" + legendando(s, i+1, "");
				}
				else if(toCompare(expressao, "B") == true)
				{
					legenda = "3" + legendando(s, i+1, "");
				}
				else
				{
					legenda = legendando(s, i+1, expressao);
				}//end if
			}//end if
			else
			{
				legenda = legendando(s, i+1, expressao);
			}//end if
		}
		else if((s.charAt(0) == '3') && (i < (s.length() - 1)))
		{
			if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
			{
				expressao = expressao + s.charAt(i);
				if(toCompare(expressao, "and") == true)
				{
					legenda = "0" + legendando(s, i+1, "");
				}
				else if(toCompare(expressao, "not") == true)
				{
					legenda = "1" + legendando(s, i+1, "");
				}
				else if(toCompare(expressao, "or") == true)
				{
					legenda = "2" + legendando(s, i+1, "");
				}
				else if(toCompare(expressao, "A") == true)
				{
					legenda = "3" + legendando(s, i+1, "");
				}
				else if(toCompare(expressao, "B") == true)
				{
					legenda = "4" + legendando(s, i+1, "");
				}
				else if(toCompare(expressao, "C") == true)
				{
					legenda = "5" + legendando(s, i+1, "");
				}
				else
				{
					legenda = legendando(s, i+1, expressao);	
				}//end if
			}
			else
			{
				legenda = legendando(s, i+1, expressao);
			}//end if
		}//end if
		return(legenda);
	}//end metodo AlgebraBooleana

	/**
	 * Metodo auxiliar que compara se duas String são iguais
	 * @param s,f ambas recebem valores de duas strings
	 */
	private static boolean toCompare(String s, String f)
	{
		boolean resp = false;
		if(s.length() == f.length())
		{
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
				}//end if
			}//end for
		}//end if
		return(resp); 
	}//end metodo toCompare

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
		while(toCompare(arq[quantEntrada++],"0") != true);//end do
		
		for(int i = 0; i < (quantEntrada - 1); i++)
		{
			if(AlgebraBooleana(arq[i]) == false)
			{
				MyIO.println(0);
			}
			else
			{
				MyIO.println(1);
			}//end if
		}//end for	
	}//end metodo main
}
/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 * @version 0.3 - Upgrade do metodo toCompare - ok!
 */
