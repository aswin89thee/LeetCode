package org.leetcode;

/*
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.


Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger
{
	
	//Accepted solution - 4 ms
    public int myAtoi(String str)
    {
        int n = 0;
        if(str == null || str.isEmpty())
        	return n;
        str = str.trim();
        if(str.isEmpty())
        	return 0;
        boolean negative = false;
        if(str.charAt(0) == '-')
        {
        	negative = true;
        	if(str.length() > 1)
        		str = str.substring(1);
        	else
        		return 0;
        }
        else if(str.charAt(0) == '+')
        {
        	if(str.length() > 1)
        		str = str.substring(1);
        	else
        		return 0;
        }
        boolean limitReached = false;
        for(int i = 0 ; i < str.length() ; i++)
        {
        	if(limitReached)
        		break;
        	int digit = str.charAt(i) - 48;
        	if(digit < 0 || digit > 9)
        		break;
        	if(n < 0 || n > 1000000000)
        	{
        		limitReached = true;
        		break;
        	}
        	n = n*10 + digit;
        	if(n < 0)
        	{
        		limitReached = true;
        		break;
        	}
        }
        if(limitReached)
        {
        	if(negative)
        		return Integer.MIN_VALUE;
        	else
        		return Integer.MAX_VALUE;
        }
        return negative ? -n : n;
    }
    
	public static void main(String[] args)
	{
		StringToInteger obj = new StringToInteger();
		System.out.println(obj.myAtoi("2147483648"));
	}

}
