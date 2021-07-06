using System;

namespace Lista
{
    class Program
    {
        static void Main(string[] args)
        {
            // só aceita um tipo de dado
            List<int> lista= new List<int>();
            lista.Add(1);
            lista.Add(2);
            lista.Add(4);
            lista.ForEach(i => Console.WriteLine(i));
        }
    }
}