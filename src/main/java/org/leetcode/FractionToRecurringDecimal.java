package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two integers representing the numerator and denominator of a fraction, 
 * return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal
{
	//Accepted solution with 6 ms runtime
    public String fractionToDecimal(int numer, int denom)
    {
    	//Make the numerator and denominator as long so that it will be easy to handle the int edge cases
    	long numerator = numer;
    	long denominator = denom;
    	if(numerator == 0)
    		return "0";
    	String decimal = "";
    	//Lets eliminate negative numbers and do our division with positive numbers only
    	//This is a main reason why these need to be long type, 
    	//because -2147483648 cannot be made into a positive number without using long 
    	if(numerator < 0 && denominator < 0)
    	{
    		numerator = -numerator;
    		denominator = -denominator;
    	}
    	if(numerator < 0)
    	{
    		decimal += "-";
    		numerator = -numerator;
    	}
    	if(denominator < 0)
    	{
    		decimal += "-";
    		denominator = -denominator;
    	}
    	//Keep track of the changing numerator in seenMap
    	Map<Long, Integer> seenMap = new HashMap<Long, Integer>();
    	if(numerator > denominator)
    	{
    		long quot = numerator / denominator;
    		long remainder = numerator % denominator;
    		decimal += quot + "";
    		if(remainder == 0)
    			return decimal;
    		decimal += ".";
    		numerator = remainder * 10;
    	}
    	else
    	{
    		decimal += "0.";
    		numerator = numerator * 10;
    	}
    	String fraction = "";
    	int mantissaIndex = 0;
    	while(numerator != 0)
    	{
    		if(seenMap.get(numerator) != null)
    		{
    			//Add brackets and break
    			int seenIndex = seenMap.get(numerator);
    			fraction = fraction.substring(0, seenIndex) + "(" + fraction.substring(seenIndex) + ")";
    			break;
    		}
    		seenMap.put(numerator, mantissaIndex);
    		while(numerator < denominator)
    		{
    			fraction = fraction + "0";
    			numerator = numerator * 10;
    			mantissaIndex++;
    			seenMap.put(numerator, mantissaIndex);
    		}
    		long quot = numerator/denominator;
    		fraction += quot + "";
    		mantissaIndex++;
    		long remainder = numerator % denominator;
    		if(remainder == 0)
    		{
    			//We are done break;
    			break;
    		}
    		if(remainder < denominator)
    			remainder = remainder * 10;
    		numerator = remainder;
    	}
    	return decimal + fraction;
    }
    
	public static void main(String[] args)
	{
		FractionToRecurringDecimal obj = new FractionToRecurringDecimal();
		System.out.println(obj.fractionToDecimal(2, 7));
	}
}
