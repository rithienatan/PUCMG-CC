/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 27/08/2017
* Exercício: TP01Q07LeituraHTML
*/

/**
 * Bibliotecas
 */
import java.util.*;
import java.net.*;
import java.io.*;

/**
* Classe Is
*/
class TP01Q07LeituraHTML
{
	/**
  	 * @param s Recebe uma linha
 	 * @return Retorna o número de ocorrencia de uma String nesta linha
	 */
	private static int palavras(String s, String f)
	{
		int resp = 0;
		if(toCompare(s, f) == true)
		{
			resp = resp + 1;
		}//end if
		return(resp);
	}//end metodo palavra

	/** Ocorrencia de letras
	 * @param s Recebe uma linha do código HTML
	 * @return Retorna valor inteiro indicando a ocorrencia de uma letra especifica
	 */
	private static int ocorrencia(String s, char letra)
	{
		int resp = 0;
		char getLetra;
		for(int i = 0; i < s.length(); i++)
		{
			getLetra = s.charAt(i);
			if(getLetra == letra)
			{
				resp += 1;
			}//end if
		}//end for
		return(resp);
	}//end metodo

	/**
         * Verica se a string contem somente consoante
         * @param s Recebe uma String
         * @return Retorna valor inteiro indicando a quantidade de consoantes
         */
        private static int IsConsoante(String s)
        {
                int resp = 0;
                char getLetra;
                for(int i = 0; i < s.length(); i++)
                {
			getLetra = s.charAt(i);
                        if(getLetra == 'a')
                        {
                                resp = resp +  0;
                        }
                        else if(getLetra == 'e')
                        {
                                resp = resp + 0;
                        }
                        else if(getLetra == 'i')
                        {
                                resp = resp + 0;
                        }
                        else if(getLetra == 'o')
                        {
                                resp = resp + 0;
                        }
                        else if(getLetra == 'u')
                        {
                                resp = resp + 0;
                        }
			else if(((int)getLetra > 97) && ((int)getLetra <= 122))
                        {
                                resp = resp + 1;
                        }
                        else
                        {
                                resp = resp + 0;
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
	public static void main(String [] args) throws Exception
	{
		String[] arq = new String[1000];
		String linha;
		int quantEntrada = 0;//quantidade de entradas

		//respostas(variaveis)
		int letra_a = 0;
		int letra_e = 0;
		int letra_i = 0;
		int letra_o = 0;
		int letra_u = 0;
		int acento_a = 0;
		int acento_e = 0;
		int acento_i = 0;
		int acento_o = 0;
		int acento_u = 0;
		int craze_a = 0;
		int craze_e = 0;
		int craze_i = 0;
		int craze_o = 0;
		int craze_u = 0;
		int til_a = 0;
		int til_o = 0;
		int circunflexo_a = 0;
		int circunflexo_e = 0;
		int circunflexo_i = 0;
		int circunflexo_o = 0;
		int circunflexo_u = 0;
		int br = 0;
		int table = 0;
		int consoante = 0;
		String nomepagina = "";

		//ler e armazenar as entradas
		do
		{
			arq[quantEntrada] = MyIO.readLine();
		}
		while(toCompare(arq[quantEntrada++],"FIM") != true);//end do
		
		for(int i = 0; i < (quantEntrada - 1); i++)
		{
			letra_a = letra_e = letra_i = letra_o = letra_u = 0;
			acento_a = acento_e = acento_i = acento_o = acento_u = 0;
			craze_a = craze_e = craze_i = craze_o = craze_u =0;
			til_a = til_o = 0;
			circunflexo_a = circunflexo_e = circunflexo_i = circunflexo_o = circunflexo_u = 0;
			br = table = consoante = 0;

			if(arq[i].charAt(0) != 'h')
			{
				nomepagina = arq[i];
			}
			else
			{
			 	BufferedReader leitura = null;          
			 	URL url = null;  
			 	String line;
			 	try
			 	{
				 	url = new URL(arq[i]);
				 	leitura = new BufferedReader(new InputStreamReader(url.openStream()));
					while((line = leitura.readLine()) != null)
					{
						letra_a += ocorrencia(line, 'a');
						letra_e	+= ocorrencia(line, 'e');
						letra_i += ocorrencia(line, 'i');
						letra_o += ocorrencia(line, 'o');
						letra_u += ocorrencia(line, 'u');
						acento_a += ocorrencia(line, 'á');
						acento_e += ocorrencia(line, 'é');
						acento_i += ocorrencia(line, 'í');
						acento_o += ocorrencia(line, 'ó');
						acento_u += ocorrencia(line, 'ú');
						craze_a += ocorrencia(line, 'à');
						craze_e += ocorrencia(line, 'è');
						craze_i += ocorrencia(line, 'ì');
						craze_o += ocorrencia(line, 'ò');
						craze_u += ocorrencia(line, 'ù');
						til_a += ocorrencia(line, 'ã');
						til_o += ocorrencia(line, 'õ');
						circunflexo_a += ocorrencia(line, 'â');
						circunflexo_e += ocorrencia(line, 'ê');
						circunflexo_i += ocorrencia(line, 'î');
						circunflexo_o += ocorrencia(line, 'ô');
						circunflexo_u += ocorrencia(line, 'û');
						br += palavras(line, "<br>");
						table += palavras(line, "<table>");
						consoante += IsConsoante(line);
					}//end while
				 	leitura.close();
			 	}
			 	catch(IOException e)
			 	{
				 	throw new IOException();
			 	}
				System.out.printf("a("+ letra_a + 
					   ") e("+ letra_e +
					   ") i("+ letra_i +
					   ") o("+ letra_o +
					   ") u("+ letra_u +
					   ") á("+ acento_a +
					   ") é("+ acento_e +
					   ") í("+ acento_i +
					   ") ó("+ acento_o +
					   ") ú("+ acento_u +
					   ") à("+ craze_a +
					   ") è("+ craze_e +
					   ") ì("+ craze_i +
					   ") ò("+ craze_o +
					   ") ù("+ craze_u +
					   ") ã("+ til_a +
					   ") õ("+ til_o +
					   ") â("+ circunflexo_a +
					   ") ê("+ circunflexo_e +
					   ") î("+ circunflexo_i +
					   ") ô("+ circunflexo_o +
					   ") û("+ circunflexo_u +
					   ") consoante("+consoante+
					   ") <br>("+br+
					   ") <table>("+table+
					   ") " + nomepagina+"\n");
			}//end if		
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
