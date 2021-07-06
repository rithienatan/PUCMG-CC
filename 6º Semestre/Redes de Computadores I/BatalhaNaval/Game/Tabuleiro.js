/*---------- Tabuleiro Class ---------*/
export class Tabuleiro
{
    /**
     * Default constructor
     */
    constructor()
    {
        this.linhas = 10;
        this.colunas = 10;

        //enumeração de linhas e colunas
        this.linhasSetup = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'];
        this.colunasSetup = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

        this.tabuleiro = null;
    }//end constructor()

    /**
     * Inicia o tabuleiro com posições nulas
     */
    initTabuleiro()
    {
        this.tabuleiro = new Array(this.linhas);

        for(let i = 0; i < this.linhas; i++)
        { this.tabuleiro[i] = new Array(this.colunas); }
    }//end initTabuleiro()


    //---------- get(s) and set(s) ----------
    getLinhas()
    { return(this.linhas); }

    getColunas()
    { return(this.colunas); }
    
    getLinhasSetup()
    { return(this.linhasSetup); }
    
    getColunasSetup()
    { return(this.colunasSetup); }
}//end class