package org.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]),
 *  where the two words do not share common letters. 
 *  You may assume that each word will contain only lower case letters. 
 *  If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
 */
public class MaximumProductOfWordLengths
{
	
	//Accepted solution with 32 ms runtime
    public int maxProduct(String[] words)
    {
        int maxProd = 0;
        if(words.length == 0)
        	return maxProd;
        
        //Sorting the words array by their length in descending order
        //helps us to stop the iteration when we know we won't get any bigger maxProduct
        Arrays.sort(words, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2)
			{
				return s2.length() - s1.length();
			}});
        
        int len = words.length;
        int i = 0;
        //There is one bit mask int per string. It stores 1 at the position of each char
        //For eg, if the string has the char 'a', its bit mask has 1 at position 0
        //These bit masks are useful for comparing if two strings have a common character
        int[] charBitMasks = new int[len];
        for(i = 0 ; i < len ; i++)
        {
        	for(char ch : words[i].toCharArray())
        	{
        		charBitMasks[i] = charBitMasks[i] | (1 << (ch - 'a'));
        	}
        }
        
        for(i = 0; i < len ; i++)
        {
        	for(int j = i + 1; j < len ; j++)
        	{
        		if((charBitMasks[i] & charBitMasks[j]) == 0)
        		{
        			int prod = words[i].length() * words[j].length();
        			maxProd = Integer.max(maxProd, prod);
        			break;// We can break when we hit the first pair of words, 
        			//because they are sorted by their lengths
        		}
        	}
        }
        return maxProd;
    }

	public static void main(String[] args)
	{
		MaximumProductOfWordLengths obj = new MaximumProductOfWordLengths();
		String[] words = {"a", "aa", "aaa", "aaaa"};
		System.out.println(obj.maxProduct(words));
	}

}
