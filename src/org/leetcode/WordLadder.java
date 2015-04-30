package org.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordLadder {
	
	private Map<String,Integer> stsMap = new HashMap<String,Integer>();

	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		int stsLength = 0;
		if(beginWord.equals(endWord)) return 0;
		if(getDifference(beginWord, endWord) == 1){
			return 1;
		}
		if(stsMap.containsKey(beginWord)){
			return stsMap.get(beginWord);
		}
		Set<String> related = getDiffersByOneWords(beginWord, wordDict);
		if(related.size() <= 0) return -1;
		int minLen = Integer.MAX_VALUE;
		for(String curWord : related){
			int curLen = 0;
			if(getDifference(curWord,endWord) == 1){
				stsMap.put(curWord, 1);
				stsLength = 1;
				break;
			}else{
				curLen = 1 + ladderLength(curWord,endWord,wordDict);
				if(curLen < minLen) stsLength = curLen;
			}
		}
		
		return stsLength;
	}
	
	private Set<String> getDiffersByOneWords(String word, Set<String> wordDict){
		Set<String> strList = new HashSet<String>();
		for(String curWord : wordDict){
			if(getDifference(word,curWord) == 1)
				strList.add(curWord);
		}
		return strList;
	}

	private int getDifference(String word1, String word2) {
		int diff = 0;
		for(int i = 0 ; i < word1.length() ; i++){
			if(word1.charAt(i) != word2.charAt(i)){
				diff++;
			}
		}
		return diff;
	}

	public static void main(String[] args) {
		WordLadder obj = new WordLadder();
		String begin = "hit";
		String end = "cog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("hot");wordDict.add("dot");wordDict.add("dog");wordDict.add("lot");wordDict.add("log");
		int stsLen = obj.ladderLength(begin, end, wordDict);
		System.out.println(stsLen);
	}

}
