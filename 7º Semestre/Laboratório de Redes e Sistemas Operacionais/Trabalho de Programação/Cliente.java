/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @date 03-04-2022
 * @version 0.1.0
 */
//---------- imports ----------
import java.net.Socket;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;


//--------- Class ---------
class Cliente extends Thread
{
    //atributos do cliente
    private Viajante viajante;

    //atributos para conexão com servidor
    public static String serverIp = "127.0.0.1";
    public static int port = 3000;

    /**
     * Default constructor
     */
    public Cliente(String nome, int idade, String cpf)
    { this.viajante = new Viajante(nome, idade, cpf); }

    /**
     * Reserva passagem
     * 
     * @param Viajante viajante
     */
    public static synchronized void ReservarPassagem(Viajante viajante)
    {
        try
		{
            System.out.println("\n-------------------------------------");
            System.out.println("Cliente nome: " + viajante.getNome() + " | Idade: " + viajante.getIdade() + " | CPF: " + viajante.getCpf());

			//inicia conexão
			System.out.println("Cliente: Conectando ao servidor " + serverIp + ":" + port);
			Socket clienteSocket = new Socket(serverIp, port);
			System.out.println("Detalhes da conexao com servidor: " + clienteSocket.toString());

            System.out.println();

            //Recebe mensagem de boas vindas ao conectar ao servidor
			ObjectInputStream clienteInput = new ObjectInputStream (clienteSocket.getInputStream());
			String mensagem = clienteInput.readObject().toString();
			System.out.println(mensagem);

            //Recebe mensagem de reservas disponiveis
            mensagem = clienteInput.readObject().toString();
			System.out.println(mensagem);

            //informa o nome e tenta reservar uma passagem
			ObjectOutputStream clienteOutput = new ObjectOutputStream(clienteSocket.getOutputStream());
            clienteOutput.writeObject(viajante.getNome());
            clienteOutput.flush();

            boolean isReservada = false;
            int passagemInicial = 0;
            do
            {
                clienteOutput.writeObject(passagemInicial);
                System.out.println("Cliente nome: " + viajante.getNome() + " tentando reservar a passagem: " + passagemInicial + "\n");
                clienteOutput.flush();

                mensagem = clienteInput.readObject().toString();

                if(mensagem.compareTo("Passagens Esgotadas!") == 0)
                { isReservada = true; System.out.println(mensagem); }
                else if(mensagem.compareTo("Passagem " + passagemInicial + "esta reservada!") == 0)
                { ++passagemInicial; System.out.println(mensagem); }
                else
                { 
                    System.out.println(mensagem);
                    isReservada = true;
                }//end if
            } while(isReservada == false && passagemInicial < 6);

            //encerra o ciclo de reserva da passagem
            clienteOutput.writeObject("encerrar");
            clienteOutput.flush();

            //termina conexão
			clienteSocket.close();
			System.out.println("Fim de conexão!");
		}
		catch(Exception e)
		{ System.out.println("Cliente: Problema ocorrido!\n" + e.toString()); }
    }//end ReservarPassagem()

    /**
     * Executa Reserva de Passagem()
     */
    public void run()
    {
        for(int i = 0; i < 2; i++)
        {            
            ReservarPassagem(viajante);

            try
            { Thread.sleep(5000); } 
            catch (InterruptedException ex)
            { Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex); }
        }//end for
    }//end run()


    /**
     * Main method
     * 
     * @param args
     */
	public static void main (String args[])
	{
        new Cliente("Alvaro", 22, "777.777.777-77").start();
        new Cliente("Renato", 33, "111.111.111-11").start();
        new Cliente("Marco", 27, "555.555.555-55").start();
        new Cliente("Fernanda", 26, "666.666.666-66").start();
        new Cliente("Jessica", 25, "888.888.888-88").start();
        new Cliente("Rosa", 21, "000.000.000-00").start();
        new Cliente("Rica", 20, "444.444.444-44").start();
	}//end main()
}//end class
