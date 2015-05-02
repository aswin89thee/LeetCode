package org.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	/*
	 * Failed an initial edge test case
Input:	[""], 2
Output:	[""]
Expected:	["  "]
	 * 
	 * I don't understand why that is wrong though. This program works for some of the test cases I wrote.
	 */
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> wordList = new ArrayList<String>();
        if(maxWidth < 1){
        	for(String word : words)
        		wordList.add(word);
        	return wordList;
        }
        int begin = 0;
        for(int i=0 ; i<words.length ; i++){
        	int curLen = calculateLength(words,begin,i);
        	if( curLen < maxWidth){
        		if(i==words.length-1){
        			String lastLine = packLastWords(words,begin);
        			wordList.add(lastLine);
        			break;
        		}
        		continue;
        	}else{
        		String line = packWords(words,begin,i-1,maxWidth);
        		wordList.add(line);
        		begin = i;
        		if(i==words.length-1){
        			String lastLine = packLastWords(words,begin);
        			wordList.add(lastLine);
        			break;
        		}
        	}
        }
        
        return wordList;
    }
	private String packLastWords(String[] words, int begin) {
		String line = "";
		for(int k = begin ; k < words.length ; k++){
			line += words[k];
			if(k!= words.length -1 ){
				line += " ";
			}
		}
		return line;
	}
	private String packWords(String[] words, int begin, int end, int maxWidth) {
		int wordsLength = calculateLength(words,begin,end);
		int defaultSpaces = end - begin;
		int extraSpaces = maxWidth - wordsLength;
		int totalSpaces = defaultSpaces + extraSpaces;
		int spacePerWord = defaultSpaces > 0 ? totalSpaces / defaultSpaces : 0;
		int moduloSpaces = defaultSpaces > 0 ? totalSpaces % defaultSpaces : 0;
		String line = "";
		for(int i = begin ; i <=end ; i++){
			line += words[i];
			if(i != end){
				for(int k = 0 ; k <spacePerWord ; k++){
					line += " ";
				}
				if(moduloSpaces > 0){
					line += " ";
					moduloSpaces--;
				}
			}
		}
		return line;
	}
	private int calculateLength(String[] words, int begin, int end) {
		if(end<begin) return 0;
		int length = 0;
		for(int k = begin ; k<=end ; k++){
			length += words[k].length();
		}
		int numSpaces = end-begin;
		length += numSpaces;
		return length;
	}
	public static void main(String[] args) {
		TextJustification obj = new TextJustification();
		String[] words = {"What","must","be","shall","be."};
		List<String> list = obj.fullJustify(words, 12);
		for(String str : list){
			System.out.println(str);
		}
	}

}
