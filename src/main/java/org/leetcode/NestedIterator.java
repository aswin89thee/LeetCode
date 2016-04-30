package org.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> 
{
    
    ///////////////////// List-based implementation start (7 ms final runtime)
	List<Integer> list = new ArrayList<Integer>();
	int index = 0;
	public NestedIterator(List<NestedInteger> nestedList)
    {
		processNestedList(nestedList, list);
    }

    private void processNestedList(List<NestedInteger> nestedList, List<Integer> intlist)
	{
    	for(NestedInteger ni : nestedList)
    	{
    		if(ni.isInteger())
    		{
    			intlist.add(ni.getInteger());
    			continue;
    		}
    		processNestedList(ni.getList(), intlist);
    	}
	}

	@Override
    public Integer next()
    {
		Integer i = list.get(index);
		index++;
    	return i;
    }

    @Override
    public boolean hasNext()
    {
    	return index < list.size();
    }
    ///////////////////// List-based implementation end
    
    
	///////////////////// Stack-based implementation start (13 ms final runtime)
//	Stack<NestedInteger> stack = new Stack<NestedInteger>();
//
//    public NestedIterator(List<NestedInteger> nestedList)
//    {
//    	for(int i = nestedList.size() - 1 ; i >= 0 ; i--)
//    	{
//    		stack.push(nestedList.get(i));
//    	}
//    }
//
//    @Override
//    public Integer next()
//    {
//    	while(!stack.peek().isInteger())
//    	{
//    		List<NestedInteger> curList = stack.pop().getList();
//        	for(int i = curList.size() - 1 ; i >= 0 ; i--)
//        	{
//        		stack.push(curList.get(i));
//        	}
//    	}
//		return stack.pop().getInteger();
//    }
//
//    @Override
//    public boolean hasNext()
//    {
//    	if(stack.isEmpty())
//    		return false;
//    	while(!stack.isEmpty() &&!stack.peek().isInteger())
//    	{
//    		List<NestedInteger> curList = stack.pop().getList();
//        	for(int i = curList.size() - 1 ; i >= 0 ; i--)
//        	{
//        		stack.push(curList.get(i));
//        	}
//    	}
//		return !stack.isEmpty();
//    }
    ///////////////////// Stack-based implementation end
    
    
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */