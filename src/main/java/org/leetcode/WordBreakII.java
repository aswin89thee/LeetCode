package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	
	private Map<String, List<String>> subsentences = new HashMap<String, List<String>>();
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> sentences = new ArrayList<String>();
		if(s == null || s.isEmpty())
		{
			sentences.add("");
			return sentences;
		}
		if(subsentences.get(s) != null)
			return subsentences.get(s);
		for(int i = 0 ; i < s.length() ; i ++)
		{
			String substr = s.substring(0, i+1);
			if(!wordDict.contains(substr))
			{
				continue;
			}
			List<String> subSentences = new ArrayList<String>();
			subSentences = wordBreak(s.substring(i+1), wordDict);
			if(subSentences != null && !subSentences.isEmpty())
			{
				for(String cur : subSentences)
				{
					if(!cur.equals(""))
						sentences.add(substr + " " + cur);
					else
						sentences.add(substr + cur);
				}
			}
		}
		subsentences.put(s, sentences);
		return sentences;
	}

	public static void main(String[] args) {
		WordBreakII wb = new WordBreakII();
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		List<String> sentences = wb.wordBreak(s, dict);
		if(sentences != null)
		{
			for(String str : sentences)
				System.out.println(str);
		}
	}

}
