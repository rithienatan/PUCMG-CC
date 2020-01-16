/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 22/02/2017
* Exercício: TP02Q05Is
*/

/**
 * Bibliotecas
 */
import java.util.*;

/**
* Classe Is
*/
class TP02Q05Is
{
	/**
	 * Charmador recursivo
	 */
	private static boolean IsVogal(String s)
	{
		return(IsVogal(s, 0));
	}//end metodo

	/**
	 * Verica se a string contem somente vogais
	 * @param s Recebe uma String
	 * @return Retorna valor booleano indicando se composto por vogais
	 */
	private static boolean IsVogal(String s, int i)
	{
		boolean resp = false;
		char getLetra;
		if(i > (s.length()-1))
		{
			resp = true;
		}
		else if((s.charAt(i) == 'A') || (s.charAt(i) == 'a'))
		{
			resp = IsVogal(s, i+1);
		}
		else if((s.charAt(i) == 'E') || (s.charAt(i) == 'e'))
		{
			resp = IsVogal(s, i+1);
		}
		else if((s.charAt(i) == 'I') || (s.charAt(i) == 'i'))
		{
			resp = IsVogal(s, i+1);
		}
		else if((s.charAt(i) == 'O') || (s.charAt(i) == 'o'))
                {
			resp = IsVogal(s, i+1);
                }
		else if((s.charAt(i) == 'U') || (s.charAt(i) == 'u'))
                {
			resp = IsVogal(s, i+1);
                }
		else
		{
			resp = false;
		}//end if
		return(resp);
	}//end metodo

	/**
	 * Chamador recursivo
	 */
	private static boolean IsConsoante(String s)
	{
		return(IsConsoante(s, 0));
	}//end metodo

	/**
         * Verica se a string contem somente consoante
         * @param s Recebe uma String
         * @return Retorna valor booleano indicando se composto por consoantes
         */
        private static boolean IsConsoante(String s, int i)
        {
                boolean resp = false;
                char getLetra;
                if(i > (s.length()-1))
                {
			resp = true;	
		}
                else if((s.charAt(i) == 'A') || (s.charAt(i) == 'a'))
                {
                        resp = false;
                }
                else if((s.charAt(i) == 'E') || (s.charAt(i) == 'e'))
                {
                        resp = false;
                }
                else if((s.charAt(i) == 'I') || (s.charAt(i) == 'i'))
                {
                        resp = false;
                }
                else if((s.charAt(i) == 'O') || (s.charAt(i) == 'o'))
                {
                        resp = false;
                }
                else if((s.charAt(i) == 'U') || (s.charAt(i) == 'u'))
                {
                        resp = false;
                }
		else if(((int)s.charAt(i) > 97) && ((int)s.charAt(i) <= 122))
                {
                        resp = IsConsoante(s, i+1);
                }
                else if(((int)s.charAt(i) > 65) && ((int)s.charAt(i) <= 90))
                {
                        resp = IsConsoante(s, i+1);
                }
                else
                {
                        resp = false;
                }//end if
                return(resp);
        }//end metodo

	/**
	 * Chamador recursivo
	 */
	private static boolean IsInteiro(String s)
	{
		return(IsInteiro(s, 0));
	}//end metodo

	/**
         * Verica se a string contem somente numeros inteiros
         * @param s Recebe uma String
         * @return Retorna valor booleano indicando se composto por numeros inteiros
         */
        private static boolean IsInteiro(String s, int i)
        {
                boolean resp = false;
                char getNum;
                if(i > (s.length() - 1))
                {
			resp = true;
                }
                else if((s.charAt(i) >= '0') && (s.charAt(i) <= '9'))
                {
                        resp = IsInteiro(s, i+1);
                }
		else
                {
                        resp = 	false;
                }//end if
                return(resp);
        }//end metodo

	/**
	 * Chamador recursivo
	 */
	private static boolean IsReal(String s)
	{
		return(IsReal(s, 0, 0));
	}//end metodo
	
	/**
         * Verica se a string contem somente numeros reais
         * @param s Recebe uma String
         * @return Retorna valor booleano indicando se composto por numeros reais
         */
        private static boolean IsReal(String s, int i, int ocorrencia)
        {
                boolean resp = false;
                char getNum;
		//int ocorrencia = 0;
                if(i > (s.length()-1))
                {
			resp = true;
		}
		else if(ocorrencia > 1)
		{
			resp = false;
		}
                else if((s.charAt(i) >= '0') && (s.charAt(i) <= '9'))
                {
                        resp = IsReal(s, i+1, ocorrencia);
                }
                else if(s.charAt(i) == '.')
                {
                      	resp = IsReal(s, i+1, ocorrencia+1);
		}
		else if(s.charAt(i) == ',')
		{
			resp = IsReal(s, i+1, ocorrencia+1);
		}
		else
		{
			resp = false;
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
			}//end if
		}//end for

		return(resp); 
	}//end metodo toCompare

	/**
	 * Metodo main
	 */
	public static void main(String [] args)
	{
		String[] arq = new String[1000];
		String linha;
		int quantEntrada = 0;//quantidade de entradas
		String x1, x2, x3, x4;//valores dos metodos acima

		//ler e armazenar as entradas
		do
		{
			arq[quantEntrada] = MyIO.readLine();
		}
		while(toCompare(arq[quantEntrada++],"FIM") != true);//end do
		
		for(int i = 0; i < (quantEntrada - 1); i++)
		{
			if(IsVogal(arq[i]) == true)
			{
				x1 = "SIM";
			}
			else
			{
				x1 = "NAO";
			}//end if

			if(IsConsoante(arq[i]) == true)
                        {
                                x2 = "SIM";
                        }
                        else
                        {
                                x2 = "NAO";
                        }//end if
			
			if(IsInteiro(arq[i]) == true)
                        {
                                x3 = "SIM";
                        }
                        else
                        {
                                x3 = "NAO";
                        }//end if
			
			if(IsReal(arq[i]) == true)
                        {
                                x4 = "SIM";
                        }
                        else
                        {
                                x4 = "NAO";
                        }//end if	

			MyIO.println("" + x1 + " " + x2 + " " + x3 + " " + x4);
		}//end for	
	}//end metodo main
}//end class
/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 * @version 0.3 - Upgrade do metodo toCompare - ok!
 */
