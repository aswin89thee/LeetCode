package org.leetcode;

public class LongestPalindrome {

	public String longestPalindrome(String s) {
		String longestPal = s.charAt(0) + "";
		if(s.length() == 2){
			if(s.charAt(0) == s.charAt(1))
				return s;
		}
		int longest = 0;
		for(int i = 0 ; i < s.length() ; i++){
			int curLength = 1;
			if((i<s.length()-1) && s.charAt(i) == s.charAt(i+1)){
				curLength = 2;
				if(longest < 2){
					longest = 2;
					longestPal = s.charAt(i) + "" + s.charAt(i+1);
				}
				int a = i, b = i+1;
				for(int j = 1 ; ; j++){
					if(a-j < 0) break;
					if(b+j >= s.length()) break;
					if(s.charAt(a-j) == s.charAt(b+j)){
						curLength += 2;
						if(curLength > longest){
							longest = curLength;
							longestPal = s.substring(a-j, b+j+1);
						}
					}
				}
			}else{
				for(int j = 1; ;j++){
					if(i-j < 0) break;
					if(i+j >= s.length()) break;
					if(s.charAt(i-j) == s.charAt(i+j)){
						curLength += 2;
						if(curLength > longest){
							longest = curLength;
							longestPal = s.substring(i-j, i+j+1);
						}
					}
				}
			}
		}

		return longestPal;
	}

	public static void main(String[] args) {
		LongestPalindrome obj = new LongestPalindrome();
		String str = "aaaa";
		System.out.println("Longest palindrome is " + obj.longestPalindrome(str));
	}

}
