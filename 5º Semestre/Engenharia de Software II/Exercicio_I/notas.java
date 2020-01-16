import java.time.LocalDateTime;

class notas {
    private double valorTotal;
    private double desconto;
    private double imposto;
    private LocalDateTime emissao;// data de emissão
    private LocalDateTime vencimento;// data de vencimento

    /**
     * Main Constructor
     */
    public notas()
    {
        this.valorTotal = 0.0;
        this.desconto = 0.0;
        this.imposto = 0.0;
        this.emissao = null;
        this.vencimento = null;
    }//end notas()

    /**
     * Alternative Constructor
     */
    public notas(double valorTotal, double desconto, double imposto, 
                 LocalDateTime emissao, LocalDateTime vencimento) 
    {
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.imposto = imposto;
        this.emissao = emissao;
        this.vencimento = vencimento;
    }// end constructor()

    // ----------------------get(s) and set(s)----------------------//

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDateTime vencimento) {
        this.vencimento = vencimento;
    }

    public LocalDateTime getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDateTime emissao) {
        this.emissao = emissao;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    //------------------end get(s) and set(s)----------------------// 
}//end class