package org.leetcode;

import java.util.Arrays;

/*
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes
{
	//Accepted solution with 33 ms runtime
	//Sieve of Eratosthenes method of computing number of primes
	//As you discover primes, make sure you mark its multiples as non-primes so that you don't have to check them
	//The boolean array primeArr is used for this
	public int countPrimes(int n)
    {
		if(n <= 2)
			return 0;
		int count = 0;
		boolean[] primeArr = new boolean[n];
		Arrays.fill(primeArr, true);
		int i = 2;
		while(i < n)
		{
			if(!primeArr[i])
			{
				i++;
				continue;
			}
			primeArr[i] = true;
			count++;
			if((long)i*i < n)
				for(int j = i * i; j < n ; j += i)
				{
					primeArr[j] = false;
				}
			i++;
		}
		return count;
    }
    
	public static void main(String[] args)
	{
		CountPrimes obj = new CountPrimes();
		System.out.println(obj.countPrimes(2));
		System.out.println(obj.countPrimes(20));
		System.out.println(obj.countPrimes(499979));
	}

}
