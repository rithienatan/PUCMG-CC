package II;

import java.net.*;
import java.io.*;
import java.util.*;
public class TCPClient {
	public static void main (String args[]) {
		// arguments supply message and hostname
		Socket s = null;
		try{
			int serverPort = 7896;
			s = new Socket("localhost", serverPort);    
			DataInputStream in = new DataInputStream( s.getInputStream());
			DataOutputStream out = new DataOutputStream( s.getOutputStream());

            Scanner sc = new Scanner(System.in);
            String userText = "";
            String test[] = new String[1000];
            int i = 0;
        
            do
            {
              userText = sc.nextLine();
              test[i] = userText;

              out.writeUTF(userText);      	// UTF is a string encoding see Sn. 4.4
              String data = in.readUTF();	    // read a line of data from the stream
              System.out.println("Received: "+ data) ; 
              i++;
            }
            while(userText.equals("0") != true && i < 1001);
            
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
     }
}