package org.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram
{
	
	// Accepted solution with 7 ms runtime. O(1) space
	public boolean isAnagram(String s, String t)
    {
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		char[] sarr = s.toCharArray();
		char[] tarr = t.toCharArray();
		Arrays.sort(sarr);
		Arrays.sort(tarr);
		return new String(sarr).equals(new String(tarr));
    }

	//Accepted solution with 50 ms runtime. O(n) space
    public boolean isAnagram2(String s, String t)
    {
    	if(s.length() != t.length())
    		return false;
    	Map<Character,Integer> map = new HashMap<Character,Integer>();
    	for(char ch : s.toCharArray())
    	{
    		if(map.get(ch) == null)
    			map.put(ch, 1);
    		else
    			map.put(ch, map.get(ch)+1);
    	}
    	for(char ch : t.toCharArray())
    	{
    		if(map.get(ch) == null || map.get(ch) <= 0)
    			return false;
    		map.put(ch, map.get(ch) - 1);
    	}
    	return true;
    }
    
	public static void main(String[] args)
	{
		ValidAnagram obj = new ValidAnagram();
		System.out.println(obj.isAnagram("top", ""));
	}

}
