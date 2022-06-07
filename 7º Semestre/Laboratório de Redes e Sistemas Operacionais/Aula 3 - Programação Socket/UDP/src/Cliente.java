
import java.net.*;
import java.io.*;

public class Cliente
{
	
	//MÉTODO PRINCIPAL DA CLASSE
	public static void main (String args[])
	{
		try
		{
			//ENDEREÇO DO SERVIDOR
			String IPServidor = "127.0.0.1";
			int PortaServidor = 6000;
			int PortaCliente = 6001;
			
			//ESTABELECE UM SERVIÇO UDP NA PORTA ESPECIFICADA
			DatagramSocket ds = new DatagramSocket(PortaCliente) ;
			System.out.println("-C- Cliente estabelecendo servico UDP (P"+PortaCliente+")...");
			
			//CRIA UM PACOTE E ENVIA PARA O SERVIDOR
			String strEnvio = "MENSAGEM TESTE";
			byte[] bytEnvio = strEnvio.getBytes();
			DatagramPacket pktEnvio = new DatagramPacket(bytEnvio, bytEnvio.length, InetAddress.getByName(IPServidor), PortaServidor);
			System.out.println("-C- Enviando mensagem (IP:"+IPServidor+" - P:"+PortaServidor+")...:" + strEnvio);
			ds.send(pktEnvio);

			//CRIA UM PACOTE E RECEBE DADOS DO SERVIDOR
			byte[] bytRec = new byte[100];
			DatagramPacket pktRec = new DatagramPacket(bytRec, bytRec.length);
			System.out.println("-C- Recebendo mensagem...");
			ds.receive(pktRec);
			bytRec = pktRec.getData();
			String strRet = new String(bytRec, 0,bytRec.length);
						
			//PROCESSA O PACOTE RECEBIDO
			System.out.println("-C- Mensagem recebida: " + strRet);

			//FINALIZA O SERVIÇO UDP
			ds.close();
			System.out.println("-C- Conexao finalizada...");
			
		}
		catch(Exception e) //SE OCORRER ALGUMA EXCESSÃO, ENTÃO DEVE SER TRATADA (AMIGAVELMENTE)
		{
			System.out.println("-C- O seguinte problema ocorreu : \n" + e.toString());
		}
	}
}		