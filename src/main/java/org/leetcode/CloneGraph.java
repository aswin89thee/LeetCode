package org.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */
public class CloneGraph
{

	//Accepted solution. 5 ms runtime
	//Depth-first search (using recursion)
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
    	if(node == null)
    		return null;
    	Map<Integer,UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
    	UndirectedGraphNode newNode = getClone(node, nodeMap);
    	return newNode;
    }
    
	private UndirectedGraphNode getClone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> nodeMap)
	{
		int label = node.label;
		UndirectedGraphNode newNode = nodeMap.get(label);
		if(newNode != null)
			return newNode;
		newNode = new UndirectedGraphNode(label);
		nodeMap.put(label, newNode);
		List<UndirectedGraphNode> neighbors = node.neighbors;
		List<UndirectedGraphNode> newNeighbors = newNode.neighbors;
		for(UndirectedGraphNode neighbor : neighbors)
		{
			UndirectedGraphNode newNeighbor = nodeMap.get(neighbor.label);
			if(newNeighbor != null)
			{
				newNeighbors.add(newNeighbor);
				continue;
			}
			newNeighbor = getClone(neighbor, nodeMap);
			newNeighbors.add(newNeighbor);
			nodeMap.put(neighbor.label, newNeighbor);
		}
		return newNode;
	}

	public static void main(String[] args)
	{
	}

}
