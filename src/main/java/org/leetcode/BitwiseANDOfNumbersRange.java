package org.leetcode;

public class BitwiseANDOfNumbersRange
{
	//Accepted solution. Runtime 8 ms
	public int rangeBitwiseAnd(int m, int n)
	{
		if(m == n)
			return m & n;
		int powm = getSmallestPowerOf2(m);
		int pown = getSmallestPowerOf2(n);
		if(pown > powm)
			return 0;
		if(powm == 0)
			return powm;
		return powm + rangeBitwiseAnd(m - powm, n - powm);
	}
	private int getSmallestPowerOf2(int num)
	{
		if(num < 2)
			return 0;
		int pow = 1;
		while(num > 1)
		{
			num = num / 2;
			pow = pow * 2;
		}
		return pow;
	}
	
	public static void main(String[] args)
	{
		BitwiseANDOfNumbersRange obj = new BitwiseANDOfNumbersRange();
		int m = 12;
		int n = 14;
		System.out.println("m = " + m + ". n = " + n + ". RangeBitwiseAnd = " + obj.rangeBitwiseAnd(m, n));
	}

}
