package II;
/**
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 */

//----------- imports ----------//
import java.net.*;
import java.security.SecureRandom;
import java.io.*;
import java.util.*;

//---------- Classes ----------//
public class UDPClient{

  /**
   * Send messagem write for client
   */
  public static void runClient(String[] message)
  {
    // args give message contents and destination hostname
    DatagramSocket aSocket = null;
    try {
      aSocket = new DatagramSocket();

      for(int i = 0; i < message.length; i++)
      {
        byte [] m = message[i].getBytes();
        InetAddress aHost = InetAddress.getByName("localhost");
        int serverPort = 8888;		                                                 
        DatagramPacket request =
            new DatagramPacket(m,  message[i].length(), aHost, serverPort);
        aSocket.send(request);			                        
        byte[] buffer = new byte[1000];
        DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
        aSocket.setSoTimeout(5000);
        try
        {
          if(aSocket.getSoTimeout() <= 5000)
          {
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
          }//end if
        }
        catch(SocketTimeoutException ste)
        { System.out.println("Timeout after 5 seconds."); }
      }//end for
    }catch (SocketException e){System.out.println("Socket: " + e.getMessage());
    }catch (IOException e){System.out.println("IO: " + e.getMessage());
    }finally {if(aSocket != null) aSocket.close();}
  }//end runClient() 	

  public static void main(String []args)
  {
    Scanner sc = new Scanner(System.in);
    String userText = "";
    String test[] = new String[1000];
    int i = 0;

    do
    {
      userText = sc.nextLine();
      test[i] = userText;
      i++;
    }
    while(userText.equals("0") != true && i < 1001);
    
    runClient(test);
  }//end main()
}//end class