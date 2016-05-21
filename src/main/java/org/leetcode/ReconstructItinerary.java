package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. 
 * Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. 
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */

public class ReconstructItinerary
{

	//Accepted solution with 11 ms runtime
	Map<String, PriorityQueue<String>> nodeGraph = new HashMap<String, PriorityQueue<String>>();
    public List<String> findItinerary(String[][] tickets)
    {
        List<String> itinerary = new ArrayList<String>();
        int i;
        //Form the graph
        for(i = 0 ; i < tickets.length ; i++)
        {
        	String curSource = tickets[i][0];
        	String curDest = tickets[i][1];
        	if(nodeGraph.get(curSource) == null)
        		nodeGraph.put(curSource, new PriorityQueue<String>());
        	if(nodeGraph.get(curDest) == null)
        		nodeGraph.put(curDest, new PriorityQueue<String>());
        	nodeGraph.get(curSource).offer(curDest);
        }
        findDFSItinerary("JFK", itinerary);
        return itinerary;
    }

	private void findDFSItinerary(String string, List<String> itinerary)
	{
		PriorityQueue<String> adjacents = nodeGraph.get(string);
		while(adjacents != null && !adjacents.isEmpty())
		{
			findDFSItinerary(adjacents.poll(), itinerary);
		}
		itinerary.add(0, string);
	}

	public static void main(String[] args)
	{
		ReconstructItinerary obj = new ReconstructItinerary();
//		String[][] tickets = {
//				{"MUC", "LHR"},
//				{"JFK", "MUC"},
//				{"SFO", "SJC"},
//				{"LHR", "SFO"}
//				};
		
		String[][] tickets = {
				{"JFK","KUL"},
				{"JFK","NRT"},
				{"NRT","JFK"}	
		};
		
//		String[][] tickets = {
//				{"JFK","SFO"},
//				{"JFK","ATL"},
//				{"SFO","ATL"},
//				{"ATL","JFK"},
//				{"ATL","SFO"}	
//		};
		List<String> itinerary = obj.findItinerary(tickets);
		for(String str : itinerary)
		{
			System.out.print(str + "  ");
		}
	}

}
