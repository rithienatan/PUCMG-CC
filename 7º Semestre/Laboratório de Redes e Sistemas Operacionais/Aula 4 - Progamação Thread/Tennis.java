/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 752655
 */
public class Tennis extends Thread
{
    private int team;
    private String name;
    private static int lastTeamPlay = 0;

    public Tennis(String name, int team)
    {
        this.team = team;
        this.name = name;
    }
    
    public static synchronized void play(String name, int team)
    {
        if (lastTeamPlay != team)
        {
            System.out.println("JOGADOR: " + name + " TIME: " + team + " REBATE!");
            lastTeamPlay = team;
        }
    }
    
    public void run()
    {
        for ( ; ; )
        {
            play(name, team);
                  
            try
            {
                Thread.sleep(1000);
            } 
            catch (InterruptedException ex)
            {
                Logger.getLogger(Tennis.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      
    public static void main(String[] args)
    {
        new Tennis("Henrique", 0).start();
        new Tennis("Vinícius", 0).start();
        new Tennis("Bruno", 1).start();
        new Tennis("Davidson", 1).start();
    }
}
 