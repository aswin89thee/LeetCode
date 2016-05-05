package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters
{
	//Accepted solution . 16 ms runtime
	public int lengthOfLongestSubstring(String s)
	{
		if(s == null || s.isEmpty())
			return 0;
		if(s.length() == 1)
			return 1;
		int maxLen = 1;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int curLen = 0;
		int curStart = 0;
		for(int i = 0 ; i < s.length() ; i++)
		{
			char ch = s.charAt(i);
			Integer existingIndex = map.get(ch);
			if(existingIndex != null && existingIndex >= curStart)
			{
				curStart = existingIndex + 1;
				map.put(ch, i);
				curLen = i - existingIndex;
			}
			else
			{
				map.put(ch, i);
				curLen++;
				maxLen = Integer.max(maxLen, curLen);
			}
		}
		return maxLen;
    }
	public static void main(String[] args)
	{
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println("tmmzuxt : " + obj.lengthOfLongestSubstring("tmmzuxt"));
		System.out.println("abcabcbb : " + obj.lengthOfLongestSubstring("abcabcbb"));
		System.out.println("bbbbb : " + obj.lengthOfLongestSubstring("bbbbb"));
		System.out.println("pwwkew : " + obj.lengthOfLongestSubstring("pwwkew"));
	}

}
