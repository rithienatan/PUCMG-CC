# define um tempo maximo por processador
var C_MAX >= 0;

#funcao objetivo
minimize Tempos: C_MAX;

# conjunto de processadores e de jobs
set PROCESSADOR;
set JOB;

param Tempo{JOB} >= 0;

# tempo de cada job
var X{PROCESSADOR, JOB} binary;

# computar tempo de cada processador
var temp_processador {i in PROCESSADOR} = sum {j in JOB} X[i,j]*Tempo[j];

# restricoes
s.t. JOBS {j in JOB}:
	sum {i in PROCESSADOR} X[i,j] = 1;
	
s.t. PROC {i in PROCESSADOR}:
	sum {j in JOB} X[i,j]*Tempo[j] <= C_MAX;
	
s.t. MAX_VALOR {i in PROCESSADOR}:
	C_MAX >= temp_processador[i];