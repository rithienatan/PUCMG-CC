/*---------- Navios-Tanque Class ---------*/
export class NaviosTanque
{
    /**
     * Default constructor
     */
    constructor()
    {
        //espaço maximo ocupado
        this.maxSpace = 4;

        //maximo de unidades disponíveis
        this.maxUnits = 2;

        //representa vida dessa peça que é destruida quando todos os espaços ocupados pela
        //unidades são destruidos
        this.life = true;
    }//end constructor()

    //---------- get(s) and set(s) ----------
    getMaxSpace()
    { return(this.maxSpace); }

    getMax()
    { return(this.maxUnits); }

    getLife()
    { return(this.life); }
}//end class