package org.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. 
 * Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). 
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. 
You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */

public class MinimumHeightTrees
{

	//Accepted solution with 60 ms runtime
	public List<Integer> findMinHeightTrees(int n, int[][] edges)
	{
		List<Integer> list = new ArrayList<Integer>();
		if(n <= 0)
			return list;
		if(n == 1)
		{
			list.add(0);
			return list;
		}
		List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();
		
		//Form the graph
		int i;
		for(i = 0 ; i < n ; i++)
			adjList.add(new HashSet<Integer>());
		for(i = 0 ; i < edges.length ; i++)
		{
			adjList.get(edges[i][0]).add(edges[i][1]);
			adjList.get(edges[i][1]).add(edges[i][0]);
		}
		
		//Find the leaves
		List<Integer> leaves = new ArrayList<Integer>();
		for(i = 0 ; i < n ; i++)
		{
			if(adjList.get(i).size() == 1)
				leaves.add(i);
		}
		
		//Iteratively remove the leaves to reach the center (kind of like two pointers traversing back to meet each other)
		while(n > 2)
		{
			//Reduce n by the size of leaves as we remove the leaves from the tree
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<Integer>();
			for(int leaf : leaves)
			{
				int neighbor = adjList.get(leaf).iterator().next();
				adjList.get(neighbor).remove(leaf);
				if(adjList.get(neighbor).size() == 1)
					newLeaves.add(neighbor);
			}
			leaves = newLeaves;
		}
		list.addAll(leaves);
		return list;
	}

	//BFS-based O(n^2) solution - Time limit exceeded
	class TreeHeightInfo
	{
		int source;
		int cur;
		int parent;
		int height;
		public TreeHeightInfo(int src, int cur, int parent, int height)
		{
			this.source = src;
			this.cur = cur;
			this.parent = parent;
			this.height = height;
		}
	}
	public List<Integer> findMinHeightTrees2(int n, int[][] edges)
	{
		List<Integer> list = new ArrayList<Integer>();
		int[][] matrix = new int[n][n];
		int i;
		//Create the graph matrix
		for(i = 0 ; i < edges.length ; i++)
		{
			int j = edges[i][0];
			int k = edges[i][1];
			matrix[j][k] = matrix[k][j] = 1;
		}
		LinkedList<TreeHeightInfo> queue = new LinkedList<TreeHeightInfo>();
		for(i = 0 ; i < n ; i++)
		{
			queue.addLast(new TreeHeightInfo(i, i, -1, 0));
		}
		int minHeight = Integer.MAX_VALUE;
		while(!queue.isEmpty())
		{
			TreeHeightInfo top = queue.removeFirst();
			int cur = top.cur;
			int parent = top.parent;
			int height = top.height;
			int src = top.source;
			if(height > minHeight)
				continue;
			boolean isLeaf = true;
			for(int j = 0 ; j < n ; j++)
			{
				if(j == cur || j == parent || matrix[cur][j] == 0)
					continue;
				isLeaf = false;
				TreeHeightInfo node = new TreeHeightInfo(src, j, cur, height+1);
				queue.addLast(node);
			}
			if(isLeaf)
			{
				minHeight = Integer.min(minHeight, height);
				if(height == minHeight && !list.contains(src))
					list.add(src);
			}
		}
		return list;
	}

	public static void main(String[] args)
	{
		MinimumHeightTrees obj = new MinimumHeightTrees();
//		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
//		int n = 6;
		
		int[][] edges = {{0, 1}, {0,2}};
		int n = 3;
		
//		int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
//		int n = 4;
		
		List<Integer> list = obj.findMinHeightTrees(n, edges);
		System.out.println(list.toString());
	}

}
