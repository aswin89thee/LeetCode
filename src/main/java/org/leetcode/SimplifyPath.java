package org.leetcode;

import java.util.Stack;

/*
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath
{

	//Accepted solution with 13 ms runtime
    public String simplifyPath(String path)
    {
        String simplifiedPath = "";
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String dir : dirs)
        {
        	if(dir.isEmpty() || dir.equals("."))
        		continue;
        	if(dir.equals(".."))
        	{
        		if(stack.isEmpty())
        			continue;
        		stack.pop();
        	}
        	else
        		stack.push(dir);
        }
        while(!stack.isEmpty())
        	simplifiedPath = stack.pop() + "/" + simplifiedPath;
        simplifiedPath = "/" + simplifiedPath;
        if(simplifiedPath.length() > 1)
        	simplifiedPath = simplifiedPath.substring(0, simplifiedPath.length()-1);
        return simplifiedPath;
    }
    
	public static void main(String[] args)
	{
		SimplifyPath obj = new SimplifyPath();
		System.out.println(obj.simplifyPath("/a/./b/../../c"));
		System.out.println(obj.simplifyPath("/home/"));
		System.out.println(obj.simplifyPath("/a//b/"));
		System.out.println(obj.simplifyPath("/../"));
		System.out.println(obj.simplifyPath("/home/../../.."));
		System.out.println(obj.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
	}

}
