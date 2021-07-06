# para criar uma árvore, é preciso criar a classe dos nodes da árvore 
# com variáveis que apontam para outros nodes além do dado que salva
class Node:

    def __init__(self, data):

        self.left = None
        self.right = None
        self.data = data

class Tree:
    def __init__(self, data):

        self.root = None
        self.data = data