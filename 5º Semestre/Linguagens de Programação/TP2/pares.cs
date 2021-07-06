using System;

namespace Pares
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = new int[10]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int i = 0;
            while (i < array.Length) {
                if(array[i] % 2 == 0) Console.WriteLine(array[i]);
                i++;
            }
        }
    }
}