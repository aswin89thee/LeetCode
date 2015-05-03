package org.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	//There are overlapping subproblems whose values can be tracked instead of having to recompute everytime
	//Use arrays to store if a particular break has already been explored (haveFound[]) and another for its value (say "boolean values[]")
	//If something has already been explored, the only value it can be is false, because if it had been true, the method would have returned
	//So we can even eliminate the use of values[] array
	public boolean wordBreak(String s, Set<String> wordDict) {
        boolean breakable = true;
        boolean[] haveFound = new boolean[s.length()];
        breakable = isBreakable(s,wordDict,haveFound);
        return breakable;
    }

	private boolean isBreakable(String str, Set<String> wordDict, boolean[] haveFound) {
		if(str.equals("")) return false;
		if(wordDict.contains(str)) return true;
		boolean breakable = false;
		for( int i = 0 ; i < str.length() ; i++){
			if(!wordDict.contains(str.substring(0, i+1))){
				continue;
			}
			String rest = str.substring(i+1);
			if(!haveFound[i+1]){
				breakable = isBreakable(rest,wordDict,haveFound);
				haveFound[i+1] = true;
			}else{
				breakable = false;
			}
			if(breakable) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		WordBreak obj = new WordBreak();
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");wordDict.add("codes");
		String str = "leetcode";
		boolean breakable = obj.wordBreak(str, wordDict);
		System.out.println(breakable);
	}

}
