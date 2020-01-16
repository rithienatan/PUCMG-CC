/*
* Adapted from: http://w...content-available-to-author-only...s.org/sieve-of-eratosthenes
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>

int sieveOfEratosthenes(int n)
{
   // Create a boolean array "prime[0..n]" and initialize
   // all entries it as true. A value in prime[i] will
   // finally be false if i is Not a prime, else true.
   int primes = 0; 
   bool *prime = (bool*) malloc((n+1)*sizeof(bool));
   int sqrt_n = sqrt(n);

   memset(prime, true,(n+1)*sizeof(bool));

   for (int p=2; p <= sqrt_n; p++)
   {
	   // If prime[p] is not changed, then it is a prime
	   if (prime[p] == true)
	   {
		   // Update all multiples of p
		   #pragma omp parallel for
		   for (int i=p*2; i<=n; i += p)
		   	 prime[i] = false;
		}
	}

	// count prime numbers
	#pragma omp parallel for reduction(+:primes)
	for (int p=2; p<=n; p++)
	   if (prime[p])
		 primes++;

	return(primes);
}

int main()
{
	/*
	
	CODIGO SEQUENCIAL (NAO PARALELIZADO):
	
	1027959@PMG34INFLL20712:~/Área de Trabalho$ time ./tarefa3Seq
	5761455

	real	0m1,731s
	user	0m1,695s
	sys	0m0,036s
	
	-----------------------------------------------------------------
	
	CODIGO PARALELIZADO:
	
	1027959@PMG34INFLL20712:~/Área de Trabalho$ time ./tarefa3
	5761455

	real	0m1,057s
	user	0m4,017s
	sys	0m0,040s
	
	*/
	
   int n = 100000000;
   printf("%d\n",sieveOfEratosthenes(n));
   return 0;
}