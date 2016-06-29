package org.leetcode;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber
{

	//Accepted solution with 22 ms runtime
    public boolean isPalindrome(int x)
    {
    	if(x < 0)
    		return false;
        int numDigits = getDigitCount(x);
        for(int i = 1 ; i <= numDigits && x > 0 ; i++)
        {
        	int startDigit = x % 10;
        	int endDigit = x / ((int)(Math.pow(10, (numDigits - 1))));
        	if(startDigit != endDigit)
        		return false;
        	x = x - startDigit * (int)(Math.pow(10, (numDigits - 1)));
        	x = x / 10;
        	if(x % 10 != 0)
        	{
        		numDigits -= 2;
        		continue;
        	}
        	if(x == 0)
        		return true;
        	int nDigits = getDigitCount(x);
        	int nTrailingZeros = 0;
        	//Take an example 1000030001. After one iteration, the number becomes 00003000 = 3000
        	//Count the number of trailing zeros and compare it with the leading zeros in the original number
        	while(x % 10 == 0)
        	{
        		x = x / 10;
        		nTrailingZeros++;
        	}
        	if(nDigits + nTrailingZeros != numDigits - 2)
        		return false;
        	numDigits = nDigits - nTrailingZeros;
        }
        return true;
    }
    
    private int getDigitCount(int n)
    {
    	int digits = 0;
    	while(n > 0)
    	{
    		digits++;
    		n = n/10;
    	}
    	return digits;
    }
    
	public static void main(String[] args)
	{
		PalindromeNumber obj = new PalindromeNumber();
		System.out.println("1000110001	:	" + obj.isPalindrome(1000110001));
		System.out.println("1000030001	:	" + obj.isPalindrome(1000030001));
		System.out.println("320023	:	" + obj.isPalindrome(320023));
		System.out.println("0	:	" + obj.isPalindrome(0));
		System.out.println("90	:	" + obj.isPalindrome(90));
		System.out.println("767	:	" + obj.isPalindrome(767));
		System.out.println("44	:	" + obj.isPalindrome(44));
	}

}
