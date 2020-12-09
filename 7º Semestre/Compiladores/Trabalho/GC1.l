/* Exemplo de Programa na linguagem L */

Var integer n,l=10;
Char nome[40];
Const MAXITER=10;

/* Programa Principal */

  write(“Digite seu nome: “);
  readln(nome);
  For n=l to MAXITER do {
    writeln(“Ola' ",nome);
  }