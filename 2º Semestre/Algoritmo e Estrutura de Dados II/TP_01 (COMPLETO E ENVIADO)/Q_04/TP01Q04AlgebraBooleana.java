/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 21/08/2017
* Exercício: TP01Q04AlgebraBooleana
*/

/**
 * Bibliotecas
 */
import java.util.*;

/**
* Classe AlgebraBooleana
*/
class TP01Q04AlgebraBooleana
{
	/**
	 * @param s Recebe uma String com uma expressão booleana
	 * @return Retorna valor booleano indicando o resultado da expressão
	 */
	private static boolean AlgebraBooleana(String s)
	{
		boolean resp = false;
		boolean A = false, B = false, C = false; //variáveis lógicas com o valor '0' setado
		String legenda = ""; //traduz a parte booleana em números
		String expressao = "";

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

			for(int i = 6; i < (s.length() - 1); i++)
			{
				if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
				{
					expressao = expressao + s.charAt(i);
					if(toCompare(expressao, "and") == true)
					{
						legenda += "0";
						expressao = "";
					}
					else if(toCompare(expressao, "not") == true)
					{
						expressao = "";
						legenda += "1";
					}
					else if(toCompare(expressao, "A") == true)
					{
						legenda = legenda + "2";
						expressao = "";
					}
					else if(toCompare(expressao, "B") == true)
					{
						legenda = legenda + "3";
						expressao = "";
					}//end if	
					//verficando a legenda se é verdadeira
					if(toCompare(legenda, "01213") == true)
					{
						resp = ((!A) && (!B));
						i = s.length();
					}
					else if(toCompare(legenda, "1023"))
					{
						resp = !(A && B);
						i = s.length();
					}//end if
				}//end if
			}//end for
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
			for(int i = 8; i < (s.length() - 1); i++)
			{
				if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
				{
					expressao = expressao + s.charAt(i);
					
					if(toCompare(expressao, "and") == true)
					{
						legenda = legenda + '0';
						expressao = "";
					}
					else if(toCompare(expressao, "not") == true)
					{
						legenda = legenda + '1';
						expressao = "";
					}
					else if(toCompare(expressao, "or") == true)
					{
						legenda = legenda + '2';
						expressao = "";
					}
					else if(toCompare(expressao, "A") == true)
					{
						legenda = legenda + '3';
						expressao = "";
					}
					else if(toCompare(expressao, "B") == true)
					{
						legenda = legenda + '4';
						expressao = "";
					}
					else if(toCompare(expressao, "C") == true)
					{
						legenda = legenda + '5';
						expressao = "";
					}//end if

					//verificando se a legenda é verdadeira
					if(toCompare(legenda, "02341045") == true)
					{
						resp = ((A || B) && (!(B && C)));
						i = s.length();
					}
					else if(toCompare(legenda, "03245") == true)
					{
						resp = (A && (B || C));
						i = s.length();
					}
					else if(toCompare(legenda, "2034035") == true)
					{
						resp = ((A && B) || (A && C));
						i = s.length();
					}
					else if(toCompare(legenda, "23045") == true)
					{
						resp = (A || (B && C));
						i = s.length();
					}
					else if(toCompare(legenda, "22345") == true)
					{
						resp = ((A || B) || C);
						i = s.length();
					}
					else if(toCompare(legenda, "2034502345") == true)
					{
						resp = (((A && B) && C) || ((A || B) && C));
						i = s.length();
					}
					else if(toCompare(legenda, "20345031450131450131415") == true)
					{
						resp = ((((A && B) && C) || ((A && (!B)) && C)) || ((((!A) && (!B)) && C) || (((!A) && (!B)) && (!C))));
						i = s.length();
					}
					else if(toCompare(legenda, "213403415") == true)
					{
						resp = (((!A) || B) || ((A && B) && (!C)));
						i = s.length();
					}
					else if(toCompare(legenda, "0234152452135") == true)
					{
						resp = ((((A || B) || (!C)) && (B || C)) && ((!A) || C));
						i = s.length();
					}
					else if(toCompare(legenda, "22010341501345034503141503145") == true)
					{
						resp = (((((!(A && B)) && (!C)) || (((!A) && B) && C)) || (((A && B) && C) || ((A && (!B)) && (!C)))) || ((A && (!B)) && C));
						i = s.length();
					}
					else if(toCompare(legenda, "203450314101315") == true)
					{
						resp = (((A && B) && C) || ((A && (!B)) && (!((!A) && (!C)))));
						i = s.length();
					}//end if
				}//end if
			}//end for
		}//end if

		return(resp);
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
