package org.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak
{
	public int integerBreak(int n)
	{
		Map<Integer, Integer> prodMap = new HashMap<Integer, Integer>();
		prodMap.put(2, 1);
		return findMaxProd(n, prodMap);
    }

	private int findMaxProd(int limit, Map<Integer, Integer> prodMap)
	{
		if(limit == 0)
			return 0;
		if(prodMap.get(limit) != null)
			return prodMap.get(limit);
		int prod = 1;
		for(int i = 1 ; i < limit ; i++)
		{
			int curProd = i * (limit - i);
			if(curProd > prod)
				prod = curProd;
			curProd = i * findMaxProd(limit - i, prodMap);
			if(curProd > prod)
				prod = curProd;
		}
		prodMap.put(limit, prod);
		return prod;
	}

	public static void main(String[] args)
	{
		IntegerBreak obj = new IntegerBreak();
		int n = 6;
		System.out.println("Input : " + n + ". Output : " + obj.integerBreak(n));
	}

}
