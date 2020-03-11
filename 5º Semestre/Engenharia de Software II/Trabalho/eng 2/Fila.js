function Fila() {
    var quantidade = 0;
    var primeiro = null;
    var ultimo = null;

    //Retorna a quantidade na fila
    this.GetQuantidade = function () {
        return quantidade;
    }
    //adiciona um item a fila
    this.Adicionar = function (data) {
        var node = {
            data: data,
            prox: primeiro
        };
        if (primeiro === null) {
            ultimo = node;
        }
        primeiro = node;
        quantidade++;
    }
    //Remove um item da fila
    this.Remover = function () {
        //se a fila estiver vaiza, retorna nulo
        if (ultimo === null) {
            return null;
        }
        else {
            //senão percorre a fila até o ultimo item para removelo e ajusta a lista
            var current = primeiro;
            var previous = null;
            while (current.prox) {
                previous = current;
                current = current.prox;
            }
            if (quantidade > 1) {
                previous.prox = null;
                ultimo = previous;
            }
            //zera/reseta a fila
            else {
                primeiro = null;
                ultimo = null;
            }
            quantidade--;
        }
        //Exibe todos os itens da fila
        this.ExibirTodos = function () {
            if (primeiro === null) {
                return null;
            } else {
                var arr = new Array();
                var current = primeiro;
                for (var i = 0; i < quantidade; i++) {
                    arr[i] = current.data;
                    current = current.prox;
                }
                return arr;
            }
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

