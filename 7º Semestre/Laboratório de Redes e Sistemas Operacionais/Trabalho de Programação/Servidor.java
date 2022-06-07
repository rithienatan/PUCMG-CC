/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @date 03-04-2022
 * @version 0.1.0
 */
//---------- imports ----------
import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;


//--------- Class ---------
class Servidor 
{
    public static int port = 3000;

    /**
     * Main method
     * 
     * @param args
     */
	public static void main (String args[])
	{
        EmpresaDeViagens empresa = new EmpresaDeViagens("Rithie Airports LTDA.", "12.345.678/9595-30");

		for(int i = 0; i < 13; i ++)
		{
			try
			{				
				System.out.println("Servidor: Aguardando conexão na porta "+ port);
				ServerSocket serverSocket = new ServerSocket(port);
				
				Socket conexao = serverSocket.accept();
				System.out.println("Servidor: Conectado ao cliente " + conexao.toString());

                //Envia mensagens de boas vindas
				ObjectOutputStream serverOutput = new ObjectOutputStream(conexao.getOutputStream());
				serverOutput.writeObject("Bem vindo a " + empresa.getNome() + "a sua empresa de viagens!");
				System.out.println("Server: Enviando mensagem de boas vindas para " + conexao.toString());
				serverOutput.flush();

                //Envia os lugares disponiveis para reserva para o cliente
                serverOutput.writeObject("O nosso catálogo de lugares disponíneis no nosso avião para Búzios são: " + empresa.reservasDisponiveis());
				System.out.println("Server: Enviando catálogo de lugares disponiveis para reserva para o cliente " + conexao.toString());
				serverOutput.flush();

                //Troca mensagens com o cliente para efetuar a reserva de passagem
                ObjectInputStream serverInput = new ObjectInputStream(conexao.getInputStream());

                //Cliente informa nome para o servidor
                System.out.println("Server: Recebendo nome do usuário da conexão " + conexao.toString());
                String nomeUsuario = serverInput.readObject().toString();

                //Troca de mensagens para reserva
                Object mensagem;
                int numeroPassagem;

                do
                {
                    mensagem = serverInput.readObject();

                    if(mensagem.toString().compareTo("encerrar") != 0)
                    {
                        numeroPassagem = Integer.parseInt(mensagem.toString());

                        if(empresa.isReservada(numeroPassagem) == true)
                        {
                            if(empresa.reservasDisponiveis().compareTo("") == 0)
                            { 
                                serverOutput.writeObject("Passagens Esgotadas!");
                                serverOutput.flush();
                            }
                            else
                            {
                                serverOutput.writeObject("Passagem " + numeroPassagem + "esta reservada!");
                                serverOutput.flush();
                            }//end if
                        }
                        else
                        { 
                            String lastMenssage = empresa.reservarPassagem(numeroPassagem, nomeUsuario);
                            serverOutput.writeObject(lastMenssage);
                            serverOutput.flush();
                        }//end if
                    }//end if
                } while(mensagem.toString().compareTo("encerrar") != 0);
			
				//Termina a conexão
				serverSocket.close();
				conexao.close();
                System.out.println("Servidor: Conexão Encerrada com o cliente " + nomeUsuario);
			}
			catch(Exception e)
			{ System.out.println("Servidor: Problema ocorrido!\n" + e.toString()); }
		}//end for 
	}//end main()
}//end class
