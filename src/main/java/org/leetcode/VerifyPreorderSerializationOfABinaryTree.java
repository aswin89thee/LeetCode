package org.leetcode;

import java.util.Stack;

/*
 * One way to serialize a binary tree is to use pre-order traversal. 
 * When we encounter a non-null node, we record the node's value. 
 * If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", 
where # represents a null node.

Given a string of comma separated values, 
verify whether it is a correct preorder traversal serialization of a binary tree. 
Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, 
for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
 */
class PreOrderInfo
{
	String str;
	boolean leftProcessed = false;
	public PreOrderInfo(String s)
	{
		str = s;
		leftProcessed = false;
	}
}

public class VerifyPreorderSerializationOfABinaryTree
{

	//Accepted solution with 21 ms runtime
    public boolean isValidSerialization(String preorder)
    {
    	if(preorder == null || preorder.isEmpty() || preorder.equals("#"))
    		return true;
    	Stack<PreOrderInfo> stack = new Stack<PreOrderInfo>();
    	String[] vals = preorder.split(",");
    	for(int i = 0 ; i < vals.length ; i++)
    	{
    		String str = vals[i];
    		if(str.equals("#"))
    		{
    			if(stack.isEmpty())
    				return false;
    			PreOrderInfo top = stack.peek();
    			if(top.leftProcessed)
    			{
    				while(!stack.isEmpty() && stack.peek().leftProcessed)
    					stack.pop();
    				if(!stack.isEmpty())
    					stack.peek().leftProcessed = true;
    			}
    			else
    				top.leftProcessed = true;
    		}
    		else
    		{
    			//Stack shouldn't be empty in the middle of processing the tree
    			if( i > 0 && stack.isEmpty())
    				return false;
    			stack.push(new PreOrderInfo(str));
    		}
    	}
    	if(!stack.isEmpty())
    		return false;
    	return true;
    }
    
	public static void main(String[] args)
	{
		VerifyPreorderSerializationOfABinaryTree obj = new VerifyPreorderSerializationOfABinaryTree();
		System.out.println(obj.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(obj.isValidSerialization("9,#,#,1"));
		System.out.println(obj.isValidSerialization("1,#"));
		System.out.println(obj.isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#"));
	}

}
