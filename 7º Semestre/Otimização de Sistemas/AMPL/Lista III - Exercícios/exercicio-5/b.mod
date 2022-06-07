# variáveis
var x1 >= 0;
var x2 >= 0;

# Função de minimização
maximize z: 4*x1 + 2*x2;

# Sujeito a:
s.t. A1: 1*x1 + 2*x2 <= 12;
s.t. A2: -1*x1 + 1*x2 <= 0;
s.t. A3: 6*x1 + 2*x2 <= 21;