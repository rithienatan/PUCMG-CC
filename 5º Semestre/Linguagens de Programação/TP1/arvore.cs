using System;

namespace Arvore
{
    public Class Tree {  
        Node root; 
        public Tree() {  
            this.root = null;  
        }  
    }  

    public Class Node {
        Node esq;
        Node dir;
        int valor;

        public Node() {
            this.esq = null;
            this.dir = null;
            this.valor = 0;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Tree tree = new Tree();
            Console.WriteLine(tree.root);
        }
    }
}