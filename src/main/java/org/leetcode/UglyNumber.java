package org.leetcode;

/*
 * Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber
{

	//Accepted solution with 2 ms runtime
	public boolean isUgly(int num)
	{
		if(num < 1)
			return false;
		while(num > 1)
		{
			if(num % 5 == 0)
			{
				num = num / 5;
				continue;
			}
			if(num % 3 == 0)
			{
				num = num / 3;
				continue;
			}
			if(num % 2 == 0)
			{
				num = num / 2;
				continue;
			}
			return false;
		}
		return true;
	}
    
	public static void main(String[] args)
	{
		UglyNumber obj = new UglyNumber();
		System.out.println(obj.isUgly(14));
		System.out.println(obj.isUgly(6));
		System.out.println(obj.isUgly(8));
	}

}
