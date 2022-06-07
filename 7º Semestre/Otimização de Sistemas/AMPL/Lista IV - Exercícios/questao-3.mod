set AGENTES;
set OBJETOS;

param Fluxo {AGENTES, OBJETOS} >= 0; 

var X {AGENTES, OBJETOS} binary;

maximize Fluxo_Total:
sum {i in AGENTES, j in OBJETOS} Fluxo[i, j] * X[i, j];

