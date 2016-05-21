package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
Read more about how a graph is represented.
 */
public class CourseSchedule
{

	//Accepted solution with 47 ms runtime
	Set<Integer> allNodes = new HashSet<Integer>();
    public boolean canFinish(int n, int[][] prerequisites)
    {
    	if(n < 1)
    		return true;
    	Map<Integer,Set<Integer>> adjList = new HashMap<Integer,Set<Integer>>();
    	int i;
    	Set<Integer> startingNodes = new HashSet<Integer>();
    	for(i = 0 ; i < n ; i++)
    	{
    		startingNodes.add(i);
    		if(adjList.get(i) == null)
    			adjList.put(i, new HashSet<Integer>());
    	}
    	
    	for(i = 0 ; i < prerequisites.length ; i++)
    	{
    		int u = prerequisites[i][0];
    		int v = prerequisites[i][1];
    		adjList.get(u).add(v);
    		startingNodes.remove(v);
    		allNodes.add(u);
    		allNodes.add(v);
    	}
    	
    	if(startingNodes.isEmpty())
    		return false;
    	
    	List<Integer> visited = new ArrayList<Integer>();
    	for(int j : startingNodes)
    	{
    		if(!dfs(j, adjList, visited))
    			return false;
    	}
    	//If the graph has a separate cycle, then startingNodes will not have the entire sub-graph
    	//So we need to check if we've processed all the nodes before
        return allNodes.isEmpty();
    }
    
	private boolean dfs(int cur, Map<Integer, Set<Integer>> adjList, List<Integer> visited)
	{
		Set<Integer> adjacents = adjList.get(cur);
		allNodes.remove(cur);
		if(adjacents.isEmpty())
			return true;
		visited.add(cur);
		for(int neighbor : adjacents)
		{
			if(visited.contains(neighbor))
				return false;
			List<Integer> newVisited = new ArrayList<Integer>(visited);
			if(!dfs(neighbor, adjList, newVisited))
				return false;
		}
		//Removing the edges helps us in avoiding going down the same path again
		adjList.get(cur).clear();
		return true;
	}

	public static void main(String[] args)
	{
		CourseSchedule obj = new CourseSchedule();
		
//		int n = 2;
//		int[][] prerequisites = {{0,1},{1,0}};
		
//		int n = 2;
//		int[][] prerequisites = {{1,0}};
		
//		int n = 3;
//		int[][] prerequisites = {{1,0}, {2,1}};
		
		int n = 8;
		int[][] prerequisites = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
		
//		int n = 8;//false
//		int[][] prerequisites = {{1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{0,5},{5,1},{6,4}};
		
		System.out.println(obj.canFinish(n, prerequisites));
	}

}
