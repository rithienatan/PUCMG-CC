function Fila(){
    this.lista = new Array();
 
    this.Inserir = function(obj){
        this.lista[this.lista.length] = obj;
    }
 
    this.RemoverPrimeiro = function(){
        if(this.lista.length > 0){
            var obj = this.lista[0];
            this.lista.splice(0,1);
            return obj;    
        }else{
            alert("Não há objetos na fila.")
        }
    }
 
    this.LerPrimeiro = function(){
        if(this.lista.length > 0){
            return this.lista[0];
        }else{
            alert("Não há objetos na fila.")
        }
    }

}

var filaGeral = new Fila();
var filaAprovado = new Fila();


function registrarPedido(){

    //Cliente faz o pedido
    filaGeral.Inserir(Pessoa); // Objeto pessoa seria os dados do cliente

}

function gerenteAprova(){

    var clienteAprovado = filaGeral.RemoverPrimeiro(); 

    filaAprovado.Inserir(clienteAprovado);

}

function clienteSentado(){
    //quando o cliente sentar na mesa 

    filaAprovado.RemoverPrimeiro();
}




    











