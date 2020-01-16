import java.util.*;

class exercicio1
{
	public static boolean estanoarray(int [] array)
	{
		boolean resp = false;
		int x = MyIO.readInt("Digite um número: ");
		
		for(int j = 0; j < array.length; j++)
		{
			if(x == array[j])
			{
				resp = true;
				j = array.length;
			}//end if
		}//end for

		return(resp);
	}//end estanoarray

	public static void main (String [] args)
	{
		int [] array = new int [10];
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = i;
		}//end for

		if(estanoarray(array) == true)
		{
			System.out.println("Está no array!");
		}
		else
		{
			System.out.println("Não está no array!");
		}//end if\else
	}//end main
}//end class
