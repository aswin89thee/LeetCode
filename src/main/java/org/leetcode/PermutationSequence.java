package org.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence
{
	//Accepted solution. 4ms runtime
	//At first, I stored all factorials in an array. With that, the time limit exceeded
	//So looks like computing the factorial using prod = prod/(n-digit) is faster than
	//storing the factorials in an array and retrieving them
	public String getPermutation(int n, int k)
	{
		String str = "";
		long remainder = k - 1;
		List<Integer> list = new ArrayList<Integer>();
		long prod = 1;
		for(int i = 1 ; i <= n ; i++)
		{
			list.add(i);
			prod = prod * i;
		}
		for(int digit = 0 ; digit < n ; digit++)
		{
			if(digit == n-1)
			{
				if(! list.isEmpty())
					str += list.get(0);
				break;
			}
			prod = prod/(n - digit);
			long numer = remainder;
			long denom = prod;
			long quot = numer / denom;
			remainder = numer % denom;
			str += list.get((int)quot);
			list.remove((int)quot);
		}
		return str;
    }

	public static void main(String[] args)
	{
		PermutationSequence obj = new PermutationSequence();
		int n = 8;
		int k = 8190;
		System.out.println(k + "th permutation : " + obj.getPermutation(n, k));
	}

}
