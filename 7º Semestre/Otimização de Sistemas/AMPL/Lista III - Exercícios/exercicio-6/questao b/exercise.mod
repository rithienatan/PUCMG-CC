set Container;
set Item;

# variaveis de decisao
var Y{Container} binary;
var X{Container, Item} binary;

param Peso{Item} >= 0;
param Capacidade{Container} >= 0;

#funcao objetivo
minimize Containers: sum {i in Container} Y[i];

#restricoes
s.t. CONT {i in Container}:
	Y[i] = 1;
	
s.t. COLOCADO {i in Container}:
	sum {j in Item} X[i,j] = 1;
	
s.t. MAX_CAPACIDADE {i in Container}:
	sum {j in Item} Peso[j]*X[i,j] <= Capacidade[i];