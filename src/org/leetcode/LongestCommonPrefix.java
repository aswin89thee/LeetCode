package org.leetcode;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
        String lcPrefix = "";
        if(strs.length == 0) return lcPrefix;
        if(strs.length == 1) return strs[0];
        int shortestLength = Integer.MAX_VALUE;
        int i;
        for(i = 0 ; i < strs.length ; i++){
        	if(strs[i].length() < shortestLength)
        		shortestLength = strs[i].length();
        }
        for(i = 0 ; i < shortestLength ; i++){
        	boolean include = true;
        	for(int j = 1 ; j < strs.length ; j++){
        		String prev = strs[j-1];
        		String cur = strs[j];
        		if(i >= prev.length() || i >= cur.length()) return lcPrefix;
        		if(cur.charAt(i) != prev.charAt(i)){
        			include = false;
        		}
        	}
        	if(include){
        		lcPrefix = strs[0].substring(0, i+1);
        	}else break;
        }
        
        return lcPrefix;
    }

	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		String[] strs = {"aca", "cba"};
		System.out.println(obj.longestCommonPrefix(strs));
	}

}
