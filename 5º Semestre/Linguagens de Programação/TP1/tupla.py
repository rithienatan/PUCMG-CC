# são imutáveis, então caso queira adicionar algo à ela, o que dá para
# fazer é colocar as informações a serem adicionadas em uma segunda
# tupla e adicionar ambos à uma terceira tupla vazia
tupla = ('e', 5, "escola")
tupla2 = ('f', 6, "feijão")
tupla3 = tupla + tupla2

print(tupla3)

# como é impossível deletar elementos dela, pode-se criar outra tupla e # adicionar a ela os elementos que quer
tupla4 = tupla[0:2]

print(tupla4)