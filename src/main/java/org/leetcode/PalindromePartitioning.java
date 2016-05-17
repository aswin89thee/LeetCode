package org.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
public class PalindromePartitioning
{
	
	//Accepted solution, with 13 ms runtime
    public List<List<String>> partition(String s)
    {
    	List<List<String>> ret = new ArrayList<List<String>>();
        ret = partitionString(s, 0, s.length());
        return ret;
    }
    
    private List<List<String>> partitionString(String str, int start, int end)
    {
    	List<List<String>> ret = new ArrayList<List<String>>();
    	if(start > end || end > str.length() || start >= str.length())
    		return ret;
    	//Base case
    	if(start == end - 1)
    	{
    		List<String> curList = new ArrayList<String>();
    		curList.add(str.substring(start, end));
    		ret.add(curList);
    		return ret;
    	}
    	for(int i = start ; i < end ; i++)
    	{
    		String firstPart = str.substring(start, i+1);
    		if(!isPalindrome(firstPart)) //backtrack
    			continue;
    		List<List<String>> secondPartString = partitionString(str, i+1, end);
    		//Add firstPart to the list
    		for(List<String> curList : secondPartString)
    		{
    			curList.add(0, firstPart);
    		}
    		if(secondPartString.isEmpty())
    		{
    			List<String> curList = new ArrayList<String>();
    			curList.add(firstPart);
    			secondPartString.add(curList);
    		}
    		ret.addAll(secondPartString);
    	}
        return ret;
    }
    
    private boolean isPalindrome(String str)
    {
    	if(str.length() < 2)
    		return true;
    	int start = 0;
    	int end = str.length() - 1;
    	char[] arr = str.toCharArray();
    	while(start < end)
    	{
    		if(arr[start] != arr[end])
    			return false;
    		start++;
    		end--;
    	}
    	return true;
    }
    
	public static void main(String[] args)
	{
		PalindromePartitioning obj = new PalindromePartitioning();
		List<List<String>> list = obj.partition("aab");
		for(List<String> curList : list)
		{
			System.out.println(curList.toString());
		}
	}

}
