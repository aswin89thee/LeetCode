package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
		Given a string of numbers and operators, return all possible results from 
		computing all the different possible ways to group numbers and operators. 
		The valid operators are +, - and *.
		
		Example 1
		Input: "2-1-1".
		
		((2-1)-1) = 0
		(2-(1-1)) = 2
		Output: [0, 2]
		
		
		Example 2
		Input: "2*3-4*5"
		
		(2*(3-(4*5))) = -34
		((2*3)-(4*5)) = -14
		((2*(3-4))*5) = -10
		(2*((3-4)*5)) = -10
		(((2*3)-4)*5) = 10
		Output: [-34, -14, -10, -10, 10]
*/
public class DifferentWaysToAddParentheses
{
	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	
	//Accepted solution. Runtime 14 ms
	public List<Integer> diffWaysToCompute(String input)
	{
		return evalString(input);
    }
	
	private List<Integer> evalString(String input)
	{
		if(map.get(input) != null)
			return map.get(input);
		List<Integer> list = new ArrayList<Integer>();
		if(input == null || input.isEmpty())
			return list;
		int numberOfOperations = this.getNumberOfOperations(input);
		if(numberOfOperations == 0)
		{
			list.add(Integer.parseInt(input));
			return list;
		}
		if(numberOfOperations == 1 || (numberOfOperations == 2 && input.startsWith("-")))
		{
			list.add(getOpResult(input));
			return list;
		}
		List<Integer> opIndexes = null;
		opIndexes = getOpIndexes(input);
		if(input.startsWith("-"))
		{
			opIndexes.remove(0);
		}
		for(int index : opIndexes)
		{
			List<Integer> list1 = this.evalString(input.substring(0, index));
			List<Integer> list2 = this.evalString(input.substring(index + 1));
			for(int l1 : list1)
			{
				for(int l2 : list2)
				{
					list.add(this.getOpResult(l1 + "" + input.charAt(index) + l2));
				}
			}
		}
		map.put(input, list);
		return list;
	}

	private List<Integer> getOpIndexes(String str)
	{
		List<Integer> opIndexes = new ArrayList<Integer>();
		if(str == null || str.isEmpty())
			return opIndexes;
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(this.isOperand(str.charAt(i)))
				opIndexes.add(i);
		}
		return opIndexes;
	}

	private Integer getOpResult(String input)
	{
		int index = -1;
		if(input.startsWith("-") && this.getNumberOfOperations(input) == 1)
		{
			return Integer.parseInt(input);
		}
		if(input.startsWith("-"))
			index = getOpIndex(input.substring(1)) + 1;
		else
			index = getOpIndex(input);
		Integer l = Integer.parseInt(input.substring(0, index));
		Integer r = Integer.parseInt(input.substring(index + 1));
		char op = input.charAt(index);
		if(op == '+')
			return l + r;
		else if (op == '-')
			return l - r;
		else if (op == '*')
			return l * r;
		return 0;
	}

	private int getOpIndex(String input)
	{
		for(int i = 0 ; i < input.length() ; i++)
		{
			if(this.isOperand(input.charAt(i)))
				return i;
		}
		return -1;
	}

	private int getNumberOfOperations(String input)
	{
		if(input == null || input.isEmpty())
			return 0;
		int num = 0;
		for(char ch : input.toCharArray())
		{
			if(isOperand(ch))
				num++;
		}
		return num;
	}
	
	private boolean isOperand(char ch)
	{
		return ch == '+' || ch == '-' || ch == '*';
	}

	public static void main(String[] args)
	{
		DifferentWaysToAddParentheses obj = new DifferentWaysToAddParentheses();
		List<Integer> list = obj.diffWaysToCompute("2*3-4*5");
		System.out.println(list.toString());
	}

}
