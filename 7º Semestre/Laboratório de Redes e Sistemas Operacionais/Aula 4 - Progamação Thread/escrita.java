public class escrita extends Thread {
    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println("Número :" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //Cria o contexto de execução
        escrita eThread = new escrita();
        //Ativa a thread
        eThread.start();
    }        
}