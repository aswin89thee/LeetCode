package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 */

//Accepted solution. 16 ms runtime
class LruNode
{
	int key;
	int val;
	LruNode next;
	LruNode prev;
	public LruNode(int k, int v){this.key = k; this.val = v;}
}

public class LRUCache
{
	protected int capacity = 0;
	protected LruNode head = null;
	protected LruNode tail = null;
	Map<Integer,LruNode> map = new HashMap<Integer,LruNode>();

	public LRUCache(int capacity)
	{
		this.capacity = capacity;
	}

	public int get(int key)
	{
		LruNode node = map.get(key);
		if(node == null)
			return -1;
		makeNodeHead(node);
		return node.val;
	}
	
	private void makeNodeHead(LruNode node)
	{
		if(node == head)
			return;
		if(map.size() == 2)
		{
			//node is the tail. So swap head and tail
			LruNode temp = head;
			head = tail;
			tail = temp;
			head.next = tail;
			tail.prev = head;
			head.prev = null;
			tail.next = null;
			return;
		}
		LruNode prev = node.prev;
		LruNode next = node.next;
		node.next = head;
		node.prev = null;
		head.prev = node;
		head = node;
		prev.next = next;
		if(next != null)
			next.prev = prev;
		else
			tail = prev;
	}

	public void set(int key, int value)
	{
		LruNode node = map.get(key);
		if(node != null)
		{
			node.val = value;
			makeNodeHead(node);
			return;
		}
		node = new LruNode(key, value);
		map.put(key, node);
		if(map.size() == 1)
		{
			head = tail = node;
			return;
		}
		node.next = head;
		node.prev = null;
		head.prev = node;
		head = node;
		if(map.size() >= this.capacity + 1)
		{
			map.remove(tail.key);
			LruNode prev = tail.prev;
			prev.next = null;
			tail = prev;
		}
	}

	public static void main(String[] args) {
		//Expect 1,-1,3
//		LRUCache obj = new LRUCache(1);
//		obj.set(2,1);
//		System.out.println(obj.get(2));
//		obj.set(3,3);
//		System.out.println(obj.get(2));
//		System.out.println(obj.get(3));

		//Expect [1,-1,1]
		LRUCache obj = new LRUCache(2);
		obj.set(2,1);
		obj.set(1,1);
		System.out.println(obj.get(2));
		obj.set(4,1);
		System.out.println(obj.get(1));
		System.out.println(obj.get(2));
	}

}
