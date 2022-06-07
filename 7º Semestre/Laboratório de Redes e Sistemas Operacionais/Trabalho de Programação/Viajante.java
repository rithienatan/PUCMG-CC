/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @date 03-04-2022
 * @version 0.1.0
 */
//--------- Class ---------
class Viajante 
{
    private String nome;
    private int idade;
    private String cpf;

    /**
     * Default constructor
     * 
     * @param String nome
     * @param int idade
     * @param String cpf
     */
    public Viajante(String nome, int idade, String cpf)
    {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }//end constructor()


    //--------- get(s) and set(s) ---------
    public String getNome()
    { return(this.nome); }

    public void setNome(String nome)
    { this.nome = nome; }

    public int getIdade()
    { return(this.idade); }

    public void setIdade(int idade)
    { this.idade = idade; }

    public String getCpf()
    { return(this.cpf); }

    public void setCpf(String cpf)
    { this.cpf = cpf; }
}//end class
