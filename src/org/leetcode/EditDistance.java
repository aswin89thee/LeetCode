package org.leetcode;

import java.util.HashMap;
import java.util.Map;


//Time limit exceeded for "dinitrophenylhydrazine","acetylphenylhydrazine". Plus I doubt if this algo is 100% correct
public class EditDistance {
	int[] distances;
	boolean[] explored;
	Map<String,Integer> distMap = new HashMap<String,Integer>();
	
	public int minDistance(String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        distances = new int[word2.length()];
        explored = new boolean[word2.length()];
        minDistance = calculateMinDist(word1,word2);
        return minDistance;
    }

	private int calculateMinDist(String word1, String word2) {
		if(word1.equals(word2)) return 0;
		if(word1 == null || word1.equals("")) return word2.length();
		if(word2 == null || word2.equals("")) return word1.length();
		if(distMap.get(word1) != null) return distMap.get(word1);
		int i;
		int minDist = Integer.MAX_VALUE;
		for(i = 0 ; i < word1.length() ; i++){
			if(i == word2.length()){
				minDist = word1.length() - word2.length();
				return minDist;
			}
			if(word1.charAt(i) == word2.charAt(i)){
				continue;
			}else{
				if(explored[i] && word1.length() >= word2.length()) return distances[i];
				//Characters are different. Try different combinations
				char ch1 = word1.charAt(i), ch2 = word2.charAt(i);
				//Replace
				String newWord = word1.substring(0,i) + ch2 + word1.substring(i+1);
				int distReplace = 1 + calculateMinDist(newWord, word2);
				distMap.put(newWord, distReplace);
				//Delete
				newWord = word1.substring(0,i)+word1.substring(i+1);
				int distDelete = 1 + calculateMinDist(newWord, word2);
				distMap.put(newWord, distDelete);
				//Insert before and after
				if(word1.length() < word2.length()){
					newWord = word1.substring(0,i) + ch2 + "" + word1.substring(i);
					int distInsert1 = 1 + calculateMinDist(newWord,word2);
					distMap.put(newWord, distInsert1);
					newWord = word1.substring(0,i) + ch1 + "" + ch2 + word1.substring(i+1);
					int distInsert2 = 1 + calculateMinDist(newWord ,word2);
					distMap.put(newWord, distInsert2);
					minDist = getMinVal(distReplace, distDelete, distInsert1,distInsert2);
				}else{
					minDist = distReplace < distDelete ? distReplace : distDelete;
				}
				explored[i] = true;
				distances[i] = minDist;
				distMap.put(word1, minDist);
				return minDist;
			}
		}
		minDist = word2.length() - word1.length();
		explored[i] = true;
		distances[i] = minDist;
		return minDist;
	}

	private int getMinVal(int a, int b, int c, int d) {
		int min = a;
		min = min < b ? min : b;
		min = min < c ? min : c;
		min = min <d ? min : d;
		return min;
	}

	public static void main(String[] args) {
		EditDistance obj = new EditDistance();
		System.out.println(obj.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
	}

}
