import java.rmi.*;

class Result
{
    String name;
    int vote;
}//end class

public interface Election extends Remote
{
    void vote(String name, int number) throws RemoteException;
    Result result() throws RemoteException;
};

class electionRMIJava
{
    public static void main(String []args)
    {}
}//end class