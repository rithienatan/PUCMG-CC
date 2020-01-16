/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 22/02/2017
* Exercício: TP01Q05Is
*/

/**
 * Bibliotecas
 */
import java.util.*;

/**
* Classe Is
*/
class TP01Q05Is
{
	/**
	 * Verica se a string contem somente vogais
	 * @param s Recebe uma String
	 * @return Retorna valor booleano indicando se composto por vogais
	 */
	private static boolean IsVogal(String s)
	{
		boolean resp = false;
		char getLetra;
		for(int i = 0; i < s.length(); i++)
		{
			getLetra = s.charAt(i);
			if((getLetra == 'A') || (getLetra == 'a'))
			{
				resp = true;
			}
			else if((getLetra == 'E') || (getLetra == 'e'))
			{
				resp = true;
			}
			else if((getLetra == 'I') || (getLetra == 'i'))
			{
				resp = true;
			}
			else if((getLetra == 'O') || (getLetra == 'o'))
                        {
                                resp = true;
                        }
			else if((getLetra == 'U') || (getLetra == 'u'))
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
	}//end metodo

	/**
         * Verica se a string contem somente consoante
         * @param s Recebe uma String
         * @return Retorna valor booleano indicando se composto por consoantes
         */
        private static boolean IsConsoante(String s)
        {
                boolean resp = false;
                char getLetra;
                for(int i = 0; i < s.length(); i++)
                {
			getLetra = s.charAt(i);
                        if((getLetra == 'A') || (getLetra == 'a'))
                        {
                                resp = false;
                                i = s.length();
                        }
                        else if((getLetra == 'E') || (getLetra == 'e'))
                        {
                                resp = false;
                                i = s.length();
                        }
                        else if((getLetra == 'I') || (getLetra == 'i'))
                        {
                                resp = false;
                                i = s.length();
                        }
                        else if((getLetra == 'O') || (getLetra == 'o'))
                        {
                                resp = false;
                                i = s.length();
                        }
                        else if((getLetra == 'U') || (getLetra == 'u'))
                        {
                                resp = false;
                                i = s.length();
                        }
			else if(((int)getLetra > 97) && ((int)getLetra <= 122))
                        {
                                resp = true;
                        }
                        else if(((int)getLetra > 65) && ((int)getLetra <= 90))
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
        }//end metodo

	/**
         * Verica se a string contem somente numeros inteiros
         * @param s Recebe uma String
         * @return Retorna valor booleano indicando se composto por numeros inteiros
         */
        private static boolean IsInteiro(String s)
        {
                boolean resp = false;
                char getNum;
                for(int i = 0; i < s.length(); i++)
                {
                        getNum = s.charAt(i);
                        if((getNum >= '0') && (getNum <= '9'))
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
        }//end metodo

	/**
         * Verica se a string contem somente numeros reais
         * @param s Recebe uma String
         * @return Retorna valor booleano indicando se composto por numeros reais
         */
        private static boolean IsReal(String s)
        {
                boolean resp = false;
                char getNum;
		int ocorrencia = 0;
                for(int i = 0; i < s.length(); i++)
                {
                        getNum = s.charAt(i); 
                        if((getNum >= '0') && (getNum <= '9'))
                        {
                                resp = true;
                        }
                        else if((ocorrencia == 0) && (getNum == '.'))
                        {
                                resp = true;
				ocorrencia++;
			}
			else if((ocorrencia == 0) && (getNum == ','))
			{
				resp = true;
				ocorrencia++;
			}
			else
			{
				resp = false;
				i = s.length();
                        }//end if
                }//end for
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
