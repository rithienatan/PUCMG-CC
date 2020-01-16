import java.io.*;

public class teste_envia_java
{
  public static void main (String [] args)
  throws Exception
  {

   ProcessBuilder pb;
	Process p;
	int j, tempo=150;
	String x;
	for(int i=0;i<10;i++)
		{
 			j=1+i%2;
			x = " "+"0"+" "+j;
  			pb = new ProcessBuilder("envia.exe","com5",x);
			p = pb.start();
	
   		try { Thread.sleep(tempo); } 
					catch(Exception e) 
					{ 	System.out.println("Ups!"); } 

   		System.out.println("i= "+i+" j= "+j+" x= "+x);
	
		}


	}
}