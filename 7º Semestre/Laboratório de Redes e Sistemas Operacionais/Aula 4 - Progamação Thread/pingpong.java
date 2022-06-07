public class pingpong extends Thread {
    private String palavra;
    
    public pingpong(String palavra) {
        this.palavra= palavra;
    }
    
    public void run() {
        try {
            for(int i= 0; i < 30; i++) {
                System.out.print("\n" + palavra + " " + " : " + i);
                if (palavra.equals("ping"))
                    Thread.sleep(200);
                else
                    Thread.sleep(100);
            }
        }
        catch (InterruptedException e) {
            return;
        } 
    }   

    public static void main(String [] args) {
        Thread t1= new pingpong("ping");
        Thread t2= new pingpong("PONG");
        t1.start();
        t2.start();
    }
}