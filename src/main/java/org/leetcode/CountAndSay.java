package org.leetcode;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay
{

	//Accepted solution with 17 ms runtime
    public String countAndSay(int n)
    {
        if(n == 1)
        	return "1";
        String prev = countAndSay(n-1);
        String str = "";
        int i = 0;
        char[] prevChars = prev.toCharArray();
        while(i < prev.length())
        {
        	int count = 0;
        	char curNum = prevChars[i];
        	while(i < prev.length() && prevChars[i] == curNum)
        	{
        		count++;
        		i++;
        	}
        	str += count + "" + curNum;
        }
        return str;
    }
    
	public static void main(String[] args)
	{
		CountAndSay obj = new CountAndSay();
		System.out.println(obj.countAndSay(5));
	}
}
