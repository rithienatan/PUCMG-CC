/* Exemplo de Programa na linguagem L */

Var integer n,i,j,valor;

/* Programa Principal */

  valor=0;
  For i=0 to n-1 do 
    For j=0 to n-1 do 
      valor<-valor+(4/2)*(n+(3%2)-(i+1-1-i)-n);
  writeln(valor);