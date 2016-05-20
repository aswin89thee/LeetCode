package org.leetcode;

/*
 * Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 */
public class SuperUglyNumber
{

	//Accepted solution with 25 ms runtime
	//DP solution based on the solution for UglyNumberII
    public int nthSuperUglyNumber(int n, int[] primes)
    {
    	int[] superuglies = new int[n];
    	int k = primes.length;
    	int[] primeIndexes = new int[k];
    	superuglies[0] = 1;
    	for(int i = 1 ; i < n ; i++)
    	{
    		int minUgly = Integer.MAX_VALUE;
    		int j;
    		for(j = 0 ; j < k ; j++)
    		{
    			int curUgly = superuglies[primeIndexes[j]] * primes[j];
    			minUgly = Math.min(minUgly, curUgly);
    		}
    		superuglies[i] = minUgly;
    		for( j = 0 ; j < k ; j++)
    		{
    			if(minUgly == superuglies[primeIndexes[j]] * primes[j])
    				primeIndexes[j]++;
    		}
    	}
    	return superuglies[n-1];
    }

	public static void main(String[] args)
	{
		SuperUglyNumber obj = new SuperUglyNumber();
		int[] primes = {2, 7, 13, 19};
		System.out.println(obj.nthSuperUglyNumber(7, primes));
	}

}
