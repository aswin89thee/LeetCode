package org.leetcode;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome
{

	//Accepted solution with 9 ms runtime
    public boolean isPalindrome(String s)
    {
    	if(s == null || s.isEmpty())
    		return true;
    	s = s.toLowerCase();
    	char[] arr = s.toCharArray();
    	int len = s.length();
    	int start = 0;
    	int end = len - 1;
    	while(start < end)
    	{
    		while(start < end && (arr[start] < '0' || arr[start] > '9') && (arr[start] < 'a' || arr[start] > 'z'))
    			start++;
    		while(end > start && (arr[end] < '0' || arr[end] > '9') && (arr[end] <'a' || arr[end] > 'z'))
    			end--;
    		if(start >= end)
    			break;
    		if(arr[start] != arr[end])
    			return false;
    		start++;
    		end--;
    	}
        return true;
    }
    
	public static void main(String[] args)
	{
		ValidPalindrome obj = new ValidPalindrome();
		String s = "race a car";
		System.out.println(obj.isPalindrome(s));
	}

}
