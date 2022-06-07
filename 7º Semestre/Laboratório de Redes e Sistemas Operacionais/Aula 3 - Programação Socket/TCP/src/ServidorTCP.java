import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;

public class ServidorTCP
{
	//MÉTODO PRINCIPAL DA CLASSE
	public static void main (String args[])
	{
		for(int i = 0; i < 3; i ++)
		{
			try
			{
				int PortaServidor = 7000;
				
				//INICIALIZA UM SERVIÇO DE ESCUTA POR CONEXÕES NA PORTA ESPECIFICADA
				System.out.println(" -S- Aguardando conexao (P:"+PortaServidor+")...");
				ServerSocket socktServ = new ServerSocket(PortaServidor);
				
				//ESPERA (BLOQUEADO) POR CONEXÕES			
				Socket conSer = socktServ.accept(); //RECEBE CONEXÃO E CRIA UM NOVO CANAL (p) NO SENTIDO CONTRARIO (SERVIDOR -> CLIENTE)
				System.out.println(" -S- Conectado ao cliente ->" + conSer.toString());
			
				//CRIA UM PACOTE DE ENTRADA PARA RECEBER MENSAGENS, ASSOCIADO A CONEXÃO (p)
				ObjectInputStream sServIn = new ObjectInputStream(conSer.getInputStream());
				System.out.println(" -S- Recebendo mensagem...");
				Object msgIn = sServIn.readObject(); //ESPERA (BLOQUEADO) POR UM PACOTE
				System.out.println(" -S- Recebido: " + msgIn.toString());
				
				//CRIA UM PACOTE DE SAIDA PARA ENVIAR MENSAGENS, ASSOCIANDO-O A CONEXÃO (p)
				ObjectOutputStream sSerOut = new ObjectOutputStream(conSer.getOutputStream());
				sSerOut.writeObject("RETORNO " + msgIn.toString() + " - TCP"); //ESCREVE NO PACOTE
				System.out.println(" -S- Enviando mensagem resposta...");
				sSerOut.flush(); //ENVIA O PACOTE
			
				//FINALIZA A CONEXÃO
				socktServ.close();
				conSer.close();
				System.out.println(" -S- Conexao finalizada...");

			}
			catch(Exception e) //SE OCORRER ALGUMA EXCESSÃO, ENTÃO DEVE SER TRATADA (AMIGAVELMENTE)
			{
				System.out.println(" -S- O seguinte problema ocorreu : \n" + e.toString());
			}
		}//end for 
	}
}