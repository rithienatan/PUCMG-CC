/*--------- Custom Imports ---------*/
const Pessoa = require('./Pessoa');


/*---------- Class Celebridade ---------*/
class Celebridade extends Pessoa
{
    /**
     * Default constructor
     * 
     * @param {string} name
     * @param {number} age
     * @param {string} role
     */
    constructor(name, age, role)
    {
        super(name, age);

        this.role = role;
    }//end constructor()

    value = this.value + 5;
}//end class

module.exports = Celebridade;