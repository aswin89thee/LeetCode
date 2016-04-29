package org.leetcode;

import java.util.Stack;

public class ReversePolishNotation {

	public int evalRPN(String[] tokens) {
		int res = 0;
		if(tokens.length == 0) return res;
		Stack<String> stack = new Stack<String>();
		for(int i = 0 ; i < tokens.length ; i++){
			String curToken = tokens[i];
			if(!curToken.equals("+") && !curToken.equals("-") && !curToken.equals("*") && !curToken.equals("/")){
				stack.push(curToken);
				continue;
			}
			int num2 = Integer.parseInt(stack.pop());
			int num1 = Integer.parseInt(stack.pop());
			if(curToken.equals("+"))
				res = num1 + num2;
			else if (curToken.equals("-"))
				res = num1 - num2;
			else if (curToken.equals("*"))
				res = num1 * num2;
			else if (curToken.equals("/"))
				res = num1 / num2;
			stack.push(res+"");
		}
		res = Integer.parseInt(stack.pop());
		return res;
	}

	public static void main(String[] args) {
		ReversePolishNotation obj = new ReversePolishNotation();
		String[] tokens = {"4","13","5","/","+"};
		int val = obj.evalRPN(tokens);
		System.out.println(val);
	}

}
