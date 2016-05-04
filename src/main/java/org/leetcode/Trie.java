package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */

//Accepted solution - 14 ms
class TrieNode
{
	public String prefix;
	public Map<Character, TrieNode> map;
	public boolean isLeaf = false;
	// Initialize your data structure here.
	public TrieNode()
	{
		prefix = "";
		map = new HashMap<Character, TrieNode>();
	}
}

public class Trie {
	private TrieNode root;

	public Trie()
	{
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word)
	{
		if(word == null || word.isEmpty())
			return;
		TrieNode node = root;
		int i = 0;
		for(i = 0 ; i < word.length() ; i++)
		{
			char ch = word.charAt(i);
			TrieNode childNode = node.map.get(ch);
			if(childNode != null)
			{
				node = childNode;
				continue;
			}
			else
			{
				childNode = new TrieNode();
				childNode.prefix = node.prefix + ch;
				node.map.put(ch, childNode);
				break;
			}
		}
		if(i >= word.length())
		{
			node.isLeaf = true;
			return;
		}
		node = node.map.get(word.charAt(i));
		++i;
		for(; i < word.length() ; i++)
		{
			TrieNode childNode = new TrieNode();
			childNode.prefix = node.prefix + word.charAt(i);
			node.map.put(word.charAt(i), childNode);
			node = childNode;
		}
		node.isLeaf = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) 
	{
		TrieNode node = root;
		for(char ch : word.toCharArray())
		{
			node = node.map.get(ch);
			if(node == null)
				return false;
		}
		return node.isLeaf;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix)
	{
		TrieNode node = root;
		for(char ch : prefix.toCharArray())
		{
			node = node.map.get(ch);
			if(node == null)
				return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		Trie trie = new Trie();
		trie.insert("abc");
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("ab"));
		trie.insert("ab");
		System.out.println(trie.search("ab"));
		trie.insert("ab");
		System.out.println(trie.search("ab"));
	}
}