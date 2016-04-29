package org.leetcode;

import java.util.Stack;

public class LongestValidParantheses {
	
	public int longestValidParentheses(String s) {
        int maxLen = 0;
        int lastError = -1;
        if(s == null || s.length() < 2) return maxLen;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0 ; i<s.length() ; i++){
        	char ch = s.charAt(i);
        	if(ch == '('){
        		stack.push(i);
        		continue;
        	}else if(ch==')'){
        		if(stack.isEmpty()){
        			lastError = i;
        			continue;
        		}else{
        			stack.pop();
        			int len = 0;
        			if (stack.size()==0){
                        len = i - lastError;
                    }else {
                    	len = i - stack.peek();
                    }
                    if (len > maxLen) {
                        maxLen = len;
                    }
        		}
        	}
        }
        
        return maxLen;
    }

	public static void main(String[] args) {
		String str = "()(()";
		LongestValidParantheses obj = new LongestValidParantheses();
		System.out.println(obj.longestValidParentheses(str));
	}

}
