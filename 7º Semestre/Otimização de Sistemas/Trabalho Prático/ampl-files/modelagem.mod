#variáveis de decisão
param n;
param MaxTemp;

set I := {1..n};

param HoraCurso {I} >= 0;
param Necessidade {I} binary;

var Conclusao {I} binary;

#função objetivo
maximize z: sum {i in I} Conclusao[i];

#restrições
s.t. Constraint:
	sum {i in I} Conclusao[i]*HoraCurso[i] <= MaxTemp;

s.t. IS_NECESSARY {i in I: Necessidade[i] = 1}:
	Conclusao[i] = 1;