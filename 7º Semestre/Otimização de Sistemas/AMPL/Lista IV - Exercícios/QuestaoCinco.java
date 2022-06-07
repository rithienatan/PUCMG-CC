/**
 * @author Rithie Natan Carvalhaes Prado
 * @version 0.1.0
 * 
 * Data: 25-04-2022
 */
//---------- imports ----------
import java.util.Scanner;

//---------- Classes -----------
public class QuestaoCinco
{
    private static final int N = 3;

    public static double valorReal(int i, int j, double[][] a, double[] p) 
    { return a[i][j] - p[j]; }

    public static int melhorObjeto(int pessoa, double[][] a, double[] p) 
    {

        int melhor = 0;
        double valor_real = a[pessoa][melhor] - p[melhor];

        for (int j = 1; j < N; j++) {
            if (a[pessoa][j] - p[j] > valor_real) 
            {
                valor_real = valorReal(pessoa, j, a, p);
                melhor = j;
            }//end if
        }//end for

        return melhor;
    }//end melhorObjeto()

    public static int segundoMelhorObjeto(int pessoa, int melhorObjeto, double[][] a, double[] p)
    {
        int segundoMelhor = 0;

        while (segundoMelhor == melhorObjeto) 
        { segundoMelhor++; }

        double valor_real = a[pessoa][segundoMelhor] - p[segundoMelhor];

        for (int j = 1; j < N; j++) 
        {
            if (a[pessoa][j] - p[j] > valor_real && j != melhorObjeto) 
            {
                valor_real = valorReal(pessoa, j, a, p);
                segundoMelhor = j;
            }//end if
        }//end for

        return segundoMelhor;
    }//end segundoMelhorObjeto()

    public static int getPessoaAlocada(int objeto, int[] alocacao) 
    {
        for (int i = 0; i < N; i++) 
        {
            if (alocacao[i] == objeto) 
            { return i; }
        }//end for

        return -1;
    }//end getPessoaAlocada()


    public static boolean existemPessoasNaoAtribuiaos(int[] alocacao) 
    {
        for (int i = 0; i < N; i++) 
        {
            if (alocacao[i] == -1) 
            { return true; }
        }//end for

        return false;
    }//end existemPessoasNaoAtribuiaos()


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        double E = 0.1;

        // Matriz de Interesse a[nxn] (linha = agente | coluna = região de interesse
        double[][] a = {{6, 3, 2},
                        {2, 7, 5},
                        {3, 10, 1}};

        System.out.println();
        System.out.println("Matriz de interesse: ");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            { System.out.print(a[i][j] + " | "); }

            System.out.println();
        }//end for


        // Vetor de preços p[n]. (inicializa com 0 em todas as posições)
        double[] p = {0, 0, 0, 0};

        // Vetor alocacao[n] (inicializa com -1 em todas as posições >> linha = agente | coluna = objeto)
        int[] alocacao = {-1, -1, -1, -1};

        int contIteracao = 0;

        // Enquanto existirem pessoas não atribuidas
        while (existemPessoasNaoAtribuiaos(alocacao))
        {
            System.out.println("Iteracao: " + contIteracao++);

            // Para cada pessoa nao atribuída, faça:
            for (int i = 0; i < N; i++)
            {
                if (alocacao[i] == -1)
                {
                    // Escolhe o melhor, segundo melhor e calcula o incremento.
                    int v = melhorObjeto(i, a, p);
                    int w = segundoMelhorObjeto(i, v, a, p); // v <> w
                    double incremento = valorReal(i, v, a, p) - valorReal(i, w, a, p) + E;

                    System.out.print("Atribuicao = (" + i + ", " + v + ")\t v = " + v + " | Vi = " + valorReal(i, v, a, p));
                    System.out.print(" | w = " + w + " | Wi = " + valorReal(i, w, a, p) + " | Incremento = " + incremento);

                    // Aumenta o valor do novo objeto.
                    p[v] = p[v] + incremento;

                    // Desatribui o objeto a quem estava atribuído
                    int perdedor = getPessoaAlocada(v, alocacao);
                    if (perdedor >= 0) 
                    { alocacao[perdedor] = -1; }

                    // Atribui o objeto ao agente i.
                    alocacao[i] = v;

                    System.out.print(" | Novo Preco = " + p[v] + " | Desatribuicao = ");
                    if (perdedor >= 0) 
                    { System.out.print(" (" + perdedor + ", " + v + ")"); }
                    else 
                    { System.out.print(" --- "); }
                    System.out.println();

                    String s = input.nextLine();
                }//end if
            }//end for
        }//end while
    }//end main()
}//end class