package org.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * @author arajamannar
 *
 */

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsOnALine
{
	//Accepted solution. 26 ms runtime
	public int maxPoints(Point[] points)
	{
		if(points == null) return 0;
		if(points.length <= 2) return points.length;
		int maxPts = 0;
		for(int i = 0 ; i < points.length ; i++)
		{
			Map<Double, Integer> slopeMap = new HashMap<Double,Integer>();
			int x1 = points[i].x, y1 = points[i].y;
			int duplicate = 1;
			int verticalPts = 0;
			for(int j = i+1 ; j < points.length ; j++)
			{
				int x2 = points[j].x, y2 = points[j].y;
				if(x1 == x2)
				{
					if(y1 == y2)
						duplicate++;
					else
						verticalPts++;
				}
				else
				{
					//Interestingly, if I don't manually set it to 0.0, java would set its value as -0.0 and +0.0 based on the x and y values
					double slope = y2 == y1 ? 0.0 : ((double)y1-y2)/((double)x1-x2);
					Integer curSlopeCount = slopeMap.get(slope);
					if(curSlopeCount == null)
						slopeMap.put(slope, 1);
					else
						slopeMap.put(slope, curSlopeCount+1);
				}
			}
			//Update max at the end of each loop for a point
			for(Entry<Double,Integer> entry : slopeMap.entrySet())
			{
				if(entry.getValue() + duplicate > maxPts)
					maxPts = entry.getValue() + duplicate;
			}
			maxPts = Integer.max(verticalPts + duplicate, maxPts);
		}
		return maxPts;
	}
	
	public static void main(String[] args)
	{
		MaxPointsOnALine obj = new MaxPointsOnALine();
		Point[] points = {new Point(2,3), new Point(3,3), new Point(-5,3)};
		System.out.println("Max points : " + obj.maxPoints(points));
	}
}
