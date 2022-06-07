/**
 * @author Rithie Natan Carvalhaes Prado
 * Matricula: 541488
 * @date 03-04-2022
 * @version 0.1.0
 */
//--------- Class ---------
class EmpresaDeViagens
{
    private String nome;
    private String cnpj;

    //atributos para o gerenciamento de passagens
    private String[] passagens;

    /**
     * Default constructor
     * 
     * @param String nome
     * @param String cnpj
     */
    public EmpresaDeViagens(String nome, String cnpj)
    {  
        this.nome = nome;
        this.cnpj = cnpj;
        
        //inicializa array de passagens
        this.passagens = new String[6];

        for(int i = 0; i < 6; i++)
        { this.passagens[i] = null; }
    }//end constructor()

    
    //--------- get(s) and set(s) ---------
    public String getNome()
    { return(this.nome); }

    public void setNome(String nome)
    { this.nome = nome; }

    public String getCnpj()
    { return(this.cnpj); }

    public void setCnpj(String cnpj)
    { this.cnpj = cnpj; }



    //--------- functions ----------
    /**
     * Verifica se uma passagem já está reservada
     * 
     * @param int passagem
     * 
     * @return true para passagem já reservada ou false para não
     */
    public boolean isReservada(int passagem)
    {
        boolean answer = false;

        if(this.passagens[passagem] != null)
        { answer = true; }

        return(answer);
    }//end isReservada()

    /**
     * Cardápio de passagens disponíveis
     * 
     * @return Lugares passagens para reserva
     */
    public String reservasDisponiveis()
    {
        String answer = "";

        for(int i = 0; i < 6; i++)
        {
            if(this.passagens[i] == null)
            { answer = answer + i + "\t"; } 
        }//end for

        return(answer);
    }//end reservasDisponiveis()

    /**
     * Reserva passagem para o cliente
     * 
     * @param passagem
     * @param nome
     * @return string
     */
    public String reservarPassagem(int passagem, String nome)
    {
        this.passagens[passagem] = passagem + " reservada para " + nome;

        return(this.passagens[passagem]);
    }//end ReservarPassagem();
}//end class 