package org.leetcode;

/*
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */
public class ReverseString
{

	//Accepted solution with 3 ms runtime
    public String reverseString(String s)
    {
        if(s == null || s.length() < 2)
        	return s;
        int start = 0;
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        while(start < end)
        {
        	if(arr[start] != arr[end])//If statement is optional. Just skipping a swap when it is not needed
        	{
        		char temp = arr[start];
        		arr[start] = arr[end];
        		arr[end] = temp;
        	}
        	start++;
        	end--;
        }
        return new String(arr);
    }
    
	public static void main(String[] args)
	{
		ReverseString obj = new ReverseString();
		System.out.println(obj.reverseString("hello"));
	}

}
