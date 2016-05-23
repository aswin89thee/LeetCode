package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */

public class WordDictionary
{
	//DFS based solution to search. But time limit exceeded :(
	//Other solutions that use array instead of HashMap seems to pass the OJ
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

	private TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word)
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

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) 
	{
		return dfsSearch(word.toCharArray(), 0, root);
	}
	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");

	private boolean dfsSearch(char[] word, int ind, TrieNode node)
	{
		if(ind == word.length)
			return node.isLeaf;
		if(node.map.isEmpty())
			return false;
		if(word[ind] == '.')
		{
			for(char mapCh : node.map.keySet())
			{
				if(dfsSearch(word, ind+1, node.map.get(mapCh)))
					return true;
			}
		}
		else
		{
			if(node.map.containsKey(word[ind]))
				return dfsSearch(word, ind+1, node.map.get(word[ind]));
			else
				return false;
		}
		return false;
	}

	public static void main(String[] args)
	{
		WordDictionary obj = new WordDictionary();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		System.out.println(obj.search("pad")); //-> false
		System.out.println(obj.search("bad")); //-> true
		System.out.println(obj.search(".ad")); //-> true
		System.out.println(obj.search("b..")); //-> true
	}

}
