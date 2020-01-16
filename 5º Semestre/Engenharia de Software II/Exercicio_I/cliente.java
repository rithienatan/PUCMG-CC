import java.time.LocalDateTime;
import java.util.Scanner;

class cliente 
{
    private notaMinas clienteMinas;

    // ----------------------get(s) and set(s)----------------------//

    public notaMinas getClienteMinas() {
        return clienteMinas;
    }

    public void setClienteMinas(notaMinas clienteMinas) {
        this.clienteMinas = clienteMinas;
    }

    // ------------------end get(s) and set(s)----------------------//

    /**
     * Metodo que criar uma nota para um cliente de minas
     */
    public static void criarNotaCliente()
    {

    }//end criarNotaCliente

    public static void main(String[] args) {

        System.out.println("/-----------Sistema de notas----------/");


        int i;//para o menu de opções
        Scanner sc = new Scanner(System.in);

        do
        {
            System.out.println("Menu: \n" +
            "0 - Sair\n" +
            "1 - Criar nota para cliente\n"+ 
            "Escolha uma opção: ");

            i = sc.nextInt();
            switch(i)
            {
                case 0:
                    i = -1;
                    break;
                case 1:
                    criarNotaCliente();
                    break;
                default:
                    System.out.println("Opção não existente!");
            }//end switch

        }while(i >= 0 && i < 2);
    }// end main
}//end class