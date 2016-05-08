package org.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
class WordStepWithList
{
	String word;
	List<String> path;
	int pathLength = 0;
	public WordStepWithList(String word, List<String> path, int pathLength)
	{
		this.word = word;
		this.path = path;
		this.pathLength = pathLength;
	}
}
public class WordLadderII
{
	//Time limit exceeded
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordDict)
    {
    	List<List<String>> masterList = new ArrayList<List<String>>();
    	LinkedList<WordStepWithList> queue = new LinkedList<WordStepWithList>();
    	wordDict.add(endWord);
    	int smallestPathLength = Integer.MAX_VALUE;
    	List<String> firstWordPath = new ArrayList<String>();
    	firstWordPath.add(beginWord);
    	queue.add(new WordStepWithList(beginWord, firstWordPath, 1));
    	while(!queue.isEmpty())
    	{
    		WordStepWithList top = queue.removeFirst();
    		if(top.word.equals(endWord))
    		{
    			List<String> finalPath = top.path;
    			if(top.pathLength + 1 <= smallestPathLength)
    			{
    				smallestPathLength = top.pathLength + 1;
        			masterList.add(finalPath);
    			}
    			continue;
    		}
    		if(top.pathLength >= smallestPathLength)
    			break;
    		String word = top.word;
    		char[] wordArr = word.toCharArray();
    		for(int i = 0 ; i < wordArr.length ; i++)
    		{
    			for(char c = 'a' ; c <= 'z' ; c++)
    			{
    				char tmp = wordArr[i];
    				wordArr[i] = c;
    				String newWord = new String(wordArr);
    				if(wordDict.contains(newWord) && !top.path.contains(newWord))
    				{
    					List<String> newpath = new ArrayList<String>(top.path);
    					newpath.add(newWord);
    					queue.add(new WordStepWithList(newWord, newpath, top.pathLength + 1));
    				}
    				wordArr[i] = tmp;
    			}
    		}
    	}
    	return masterList;
    }
    
	public static void main(String[] args)
	{
		WordLadderII obj = new WordLadderII();
		String begin = "hit";
		String end = "cog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("hot");wordDict.add("dot");wordDict.add("dog");wordDict.add("lot");wordDict.add("log");
		long startTime = System.currentTimeMillis();
		List<List<String>> masterList = obj.findLadders(begin, end, wordDict);
		long endTime = System.currentTimeMillis();
		for(List<String> curList : masterList)
		{
			System.out.println(curList.toString());
		}
		System.out.println("Time to find ladders: " + (endTime - startTime) + " ms");
	}

}
