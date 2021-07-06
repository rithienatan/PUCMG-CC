/*--------- Custom Imports ---------*/
const TestsP = require('./TestsPessoas.json')
const TestsC = require('./TestsCelebridades.json');
const Pessoa = require('./Pessoa');
const Celebridade = require('./Celebridade');


/**
 * Run code
 */
function main()
{
    let array = new Array();

    for(let i = 0; i < TestsP.length; i++)
    { array.push(new Pessoa(TestsP[i].nome, TestsP[i].idade, TestsP[i].role)); }

    for(let i = 0; i < TestsC.length; i++)
    { array.push(new Celebridade(TestsC[i].nome, TestsC[i].idade, TestsC[i].role)); }

    console.log(array);
}//end main()

main();