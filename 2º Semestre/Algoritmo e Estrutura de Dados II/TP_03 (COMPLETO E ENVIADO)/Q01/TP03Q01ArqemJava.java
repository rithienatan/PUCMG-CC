/**
* @author Rithie Natan Carvalhaes Prado
* Matrícula: 541488
* Data de Entrega: 27/08/2017
* Exercício: TP03Q01ArqemJava
*/

/**
 * bibliotecas
 */
import java.util.*;
import java.io.*;
import java.lang.*;

/**
* Classe Aquecimento
*/
class TP03Q01ArqemJava
{
	/**
	 * Metodo main
	 */
	public static void main(String [] args)throws Exception
	{
		RandomAccessFile raf = new RandomAccessFile("Arqui.txt","rw");
		
		int quantEntrada = MyIO.readInt();
		double valores;
		int val;
		long where = 0;
	
		//ler e armazenar as entradas
		for(int i = 0; i < quantEntrada; i++)
		{
			valores = MyIO.readDouble();
			val = (int)valores;
			if(valores == val)
			{
				where = raf.getFilePointer();
				raf.seek(where);
				raf.writeInt(val);
			}
			else
			{			
				where = raf.getFilePointer();
				raf.seek(where);
				raf.writeDouble(valores);
			}//end if
		}//end for

		for(int i = 0; i < quantEntrada; i++)
		{
			if(where < 440 && where > 400 )
			{
				raf.seek(where);
				val = raf.readInt();
				MyIO.println(val);
				where = where - 4;
			}
			else if(where == 400)
			{
				raf.seek(where);
				val = raf.readInt();
				MyIO.println(val);
				where = where - 8;
			}
			else if(where == 440)
			{
				raf.seek(where);
				valores = raf.readDouble();
				MyIO.println(valores);
				where = where - 4;
			}
			else
			{
				raf.seek(where);
				valores = raf.readDouble();
				MyIO.println(valores);
				where = where - 8;
			}//end if
		}//end for

		raf.close();

	}//end metodo main
}//end TP03Q01ArqemJava
/**
 * Testes
 * -----------------------------------------------------------------------
 * @version 0.1 - Teste de funcionamento - ok!
 * @version 0.2 - Teste de saidas - ok!
 */

