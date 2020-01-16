import java.time.LocalDateTime;

abstract class notasBuilder {
    private notas nota;

    /**
     * Metodo construtor
     */
    public notasBuilder() {
        setNota(new notas());
    }// end Construtor

    // -----------------------get(s) and set(s)----------------------//

    public notas getNota() {
        return nota;
    }

    public void setNota(notas nota) {
        this.nota = nota;
    }

    // ------------------end get(s) and set(s)----------------------//

    // ------------------------build--------------------------------//

    public abstract void buildValorTotal(double clienteValorTotal);
    public abstract void buildDesconto(double clienteDesconto);
    public abstract void buildImposto(double clienteImposto);
    public abstract void buildEmissao();
    public abstract void buildVencimento();

    //----------------------end build------------------------------//
}//end class