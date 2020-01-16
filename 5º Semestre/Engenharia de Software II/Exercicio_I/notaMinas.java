import java.time.LocalDateTime;

class notaMinas extends notasBuilder 
{
    private double impostoMinas;// É 7% sobre o valor total da nota
    private LocalDateTime vencimentoMinas;// É 7 dias após a emissão

    /**
     * Main Constructor
     */
    public notaMinas()
    {

    }//end notaMinas()

    /**
     * Alternative Constructor
     */
    public notaMinas()
    {

    }//end notaMinas()

    //----------------------get(s) and set(s)----------------------//

    public double getImpostoMinas() {
        return impostoMinas;
    }

    public LocalDateTime getVencimentoMinas() {
        return vencimentoMinas;
    }

    public void setVencimentoMinas(LocalDateTime vencimentoMinas) {
        this.vencimentoMinas = vencimentoMinas;
    }

    public void setImpostoMinas(double impostoMinas) {
        this.impostoMinas = impostoMinas;
    }
    
    //------------------end get(s) and set(s)----------------------//

    //------------------building-----------------------------------//

    @Override
    public void buildValorTotal(double clienteValorTotal)
    {
        getNota().setValorTotal(clienteValorTotal);
    }//end buildValorTotal()

    @Override
    public void buildDesconto(double clienteDesconto)
    {
        getNota().setDesconto(clienteDesconto);
    }//end buildDesconto()

    @Override
    public void buildImposto(double clienteImposto)
    {
        getNota().setImposto(clienteImposto * 0.07);
    }//end buildImposto()

    @Override
    public void buildEmissao()
    {
    }//end buildEmissao()

    @Override
    public void buildVencimento()
    {
    }//end buildVencimento()

    //------------------end building-------------------------------//
}//end class