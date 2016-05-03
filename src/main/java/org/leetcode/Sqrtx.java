package org.leetcode;

public class Sqrtx
{
	//Binary search method. 3 ms runtime
	public int mySqrt(int x)
	{
		if(x <= 1)
			return x;
		int lo = 0;
		int hi = x/2 + 1;
		while(lo <= hi)
		{
			int mid = lo + (hi - lo)/2;
			double sq = (long)mid * mid;
			if(sq == x)
				return mid;
			if(sq < x)
				lo = mid + 1;
			else
				hi = mid - 1;
			mid = lo + (hi - lo)/2;
		}
		return hi;
	}
	
	public static void main(String[] args)
	{
		Sqrtx obj = new Sqrtx();
		System.out.println(obj.mySqrt(8));
	}

}
