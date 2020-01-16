class notaDiretor {
    private notasBuilder diretorNota;

    /**
     * Construtor
     */
    public notaDiretor()
    {
        setDiretorNota(diretorNota);
    }//end construtor

    // -----------------------get(s) and set(s)----------------------//

    public notasBuilder getDiretorNota() {
        return diretorNota;
    }

    public void setDiretorNota(notasBuilder diretorNota) {
        this.diretorNota = diretorNota;
    }

    // ------------------end get(s) and set(s)----------------------//
}//end notaDiretor