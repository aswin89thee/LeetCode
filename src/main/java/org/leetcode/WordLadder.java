package org.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
class WordStep
{
	String word;
	int numSteps = 0;
	public WordStep(String str, int steps)
	{
		this.word = str;
		this.numSteps = steps;
	}
}
public class WordLadder
{
	//Accepted solution with 85 ms runtime
	//BFS solution. Credits to programcreek.com
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict)
	{
		List<WordStep> queue = new LinkedList<WordStep>();
		wordDict.add(endWord);
		queue.add(new WordStep(beginWord, 1));
		while(!queue.isEmpty())
		{
			WordStep step = queue.remove(0);
			String curWord = step.word;
			if(curWord.equals(endWord))
				return step.numSteps;
			char[] charArr = curWord.toCharArray();
			for(int i = 0 ; i < charArr.length; i++)
			{
				for(char c = 'a' ; c < 'z' ; c++)
				{
					char tmp = charArr[i];
					charArr[i] = c;
					String newWord = new String(charArr);
					if(wordDict.contains(newWord))
					{
						queue.add(new WordStep(newWord, step.numSteps+1));
						wordDict.remove(newWord);
					}
					charArr[i] = tmp;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args)
	{
		WordLadder obj = new WordLadder();
		String begin = "hit";
		String end = "cog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("hot");wordDict.add("dot");wordDict.add("dog");wordDict.add("lot");wordDict.add("log");
		long startTime = System.currentTimeMillis();
		int stsLen = obj.ladderLength(begin, end, wordDict);
		long endTime = System.currentTimeMillis();
		System.out.println("Ladder length: " + stsLen);
		System.out.println("Time to find ladder length: " + (endTime - startTime) + " ms");
	}

}
