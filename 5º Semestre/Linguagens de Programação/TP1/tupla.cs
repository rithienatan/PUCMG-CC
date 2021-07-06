using System;

namespace Tupla
{
    class Program
    {
    static void Main(string[] args)
        {
            Tuple<int, string, int, Tuple<int, int>> tuple = new Tuple<int, string>(22, "Outubro", 1996, (2, 2));
            Console.WriteLine(tuple[3]);
        }
    }
}