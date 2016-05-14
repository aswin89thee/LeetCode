package org.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Given an Iterator class interface with methods: next() and hasNext(), 
 * design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. 
Calling hasNext() after that should return false.
 */
public class PeekingIterator implements Iterator<Integer>
{
	//Accepted solution with 109 ms
	private Integer nextInt = null;
	private Iterator<Integer> iterator;
	private Boolean hasNext = false;
	
	public PeekingIterator(Iterator<Integer> iterator)
	{
	    // initialize any member here.
		this.iterator = iterator;
		this.hasNext = iterator.hasNext();
		if(hasNext)
			this.nextInt = iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek()
	{
		return nextInt;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next()
	{
		Integer ret = nextInt;
		this.hasNext = iterator.hasNext();
		if(this.hasNext())
			nextInt = iterator.next();
	    return ret;
	}

	@Override
	public boolean hasNext()
	{
	    return this.hasNext;
	}
	
	public static void main(String[] args)
	{
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		PeekingIterator iter = new PeekingIterator(intList.iterator());
		System.out.println("Iter.hasNext() is " + iter.hasNext());
		if(iter.hasNext())
			System.out.println(iter.next());
		System.out.println("Iter.hasNext() is " + iter.hasNext());
		if(iter.hasNext())
		{
			System.out.println(iter.peek());
			System.out.println(iter.peek());
			System.out.println(iter.peek());
			System.out.println(iter.peek());
		}
		System.out.println("Iter.hasNext() is " + iter.hasNext());
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}

}
