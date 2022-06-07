/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @date 03-21-2022
 * @version 0.1.0
 */
//---------- imports ----------
import java.util.logging.Level;
import java.util.logging.Logger;

//---------- class ----------
public class MyTennis extends Thread
{
    private String nome;
    private int time;
    private int numeroJogador;

    private static int ultimoTimeQueJogou = 1;
    private static int ultimoJogadorQueJogou = 1;

    /**
     * Constructor padrão
     */
    public MyTennis(String nome, int time, int numeroJogador)
    {
        this.nome = nome;
        this.time = time;
        this.numeroJogador = numeroJogador;
    }//end MyTennis()

    /**
     * Play Tennis
     * 
     * @param nome
     * @param time
     */
    public static synchronized void play(String nome, int time, int numeroJogador)
    {
        if(ultimoTimeQueJogou != time && ultimoJogadorQueJogou != numeroJogador)
        { 
            System.out.println("JOGADOR: " + nome + " TIME: " + time + " REBATE!");
            ultimoTimeQueJogou = time;
            ultimoJogadorQueJogou = numeroJogador;
        }//end if
    }//end play()

    /**
     * Run play
     */
    public void run()
    {
        for ( ; ; )
        {
            play(nome, time, numeroJogador);
                  
            try
            { Thread.sleep(1000); } 
            catch (InterruptedException ex)
            { Logger.getLogger(Tennis.class.getName()).log(Level.SEVERE, null, ex); }
        }//end for
    }//end run()

    /**
     * Metodo main
     * @param args
     */
    public static void main(String []args)
    {
        new MyTennis("Rithie", 1, 1).start();
        new MyTennis("Kira", 1, 2).start();
        new MyTennis("TRAO", 2, 3).start();
        new MyTennis("MINGO", 2, 4).start();
    }//end main()
}//end class
