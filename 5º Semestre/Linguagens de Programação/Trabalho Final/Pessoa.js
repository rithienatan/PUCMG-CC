/*---------- Class Pessoa ---------*/
class Pessoa
{
    /**
     * Default constructor
     * 
     * @param {string} name
     * @param {number} age
     */
    constructor(name, age)
    {
        this.name = name;
        this.age = age;
    }//end constructor()

    value = 10;
}//end class

module.exports = Pessoa;