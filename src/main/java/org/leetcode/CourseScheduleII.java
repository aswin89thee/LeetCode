package org.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take 
to finish all courses.

There may be multiple correct orders, you just need to return one of them. 
If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. 
Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 */
class Pair
{
	int u, v;
	public Pair(int u, int v){this.u = u; this.v = v;}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + u;
		result = prime * result + v;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (u != other.u)
			return false;
		if (v != other.v)
			return false;
		return true;
	}
}
public class CourseScheduleII
{
	//Accepted solution with 39 ms runtime
    public int[] findOrder(int n, int[][] prerequisites)
    {
    	if(n < 1)
    		return new int[0];
    	if(n == 1)
    	{
    		int[] a = {0};
    		return a;
    	}
    	Set<Integer> allNodes = new HashSet<Integer>();
    	List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();
    	Set<Integer> startingNodes = new HashSet<Integer>();
    	List<Integer> finalList = new ArrayList<Integer>();
    	Set<Pair> edgePairs = new HashSet<Pair>();
    	int[] inDegree = new int[n];
    	int i;
    	for(i = 0 ; i < n ; i++)
    	{
    		startingNodes.add(i);
    		adjList.add(new HashSet<Integer>());
    	}
    	
    	for(i = 0 ; i < prerequisites.length ; i++)
    	{
    		int u = prerequisites[i][0];
    		int v = prerequisites[i][1];
    		adjList.get(u).add(v);
    		startingNodes.remove(v);
    		allNodes.add(u);
    		allNodes.add(v);
    		Pair pair = new Pair(u,v);
    		if(!edgePairs.contains(pair))
    			inDegree[v]++;
    		edgePairs.add(pair);
    	}
    	
    	if(startingNodes.isEmpty())
    	{
    		return new int[0];
    	}
    	
    	while(!startingNodes.isEmpty())
    	{
    		Set<Integer> newStartingNodes = new HashSet<Integer>();
    		for(int source : startingNodes)
    		{
    			finalList.add(0, source);
    			allNodes.remove(source);
    			Set<Integer> neighbors = adjList.get(source);
    			for(Integer neighbor : neighbors)
    			{
    				inDegree[neighbor]--;
    				if(inDegree[neighbor] == 0)
    					newStartingNodes.add(neighbor);
    			}
    			adjList.get(source).clear();
    		}
    		startingNodes = newStartingNodes;
    	}
    	if(allNodes.isEmpty())
    	{
    		return toIntArray(finalList);
    	}
    	else
    		return new int[0];
    }
    
	private int[] toIntArray(List<Integer> finalList)
	{
		int[] arr = new int[finalList.size()];
		for(int i = 0 ; i < finalList.size() ; i++)
		{
			arr[i] = finalList.get(i);
		}
		return arr;
	}

	public static void main(String[] args)
	{
		CourseScheduleII obj = new CourseScheduleII();
		
//		int n = 2;
//		int[][] prerequisites = {{1,0}};
		
//		int n = 4;
//		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		
		int n = 10;
		int[][] prerequisites = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		
		int[] order = obj.findOrder(n, prerequisites);
		for(int i : order)
			System.out.print(i + " ");
	}

}
