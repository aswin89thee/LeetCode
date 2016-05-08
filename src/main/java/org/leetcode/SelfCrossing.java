package org.leetcode;

public class SelfCrossing
{
	//Accepted solution with 1ms runtime
    public boolean isSelfCrossing(int[] x)
    {
    	if(x.length < 4)
    		return false;
    	for(int i = 3 ; i < x.length ; i++)
    	{
    		if(x[i-1] <= x[i-3] && x[i] >= x[i-2])
    			return true;
    		if(i > 3 && x[i-1] == x[i-3] && (x[i] + x[i-4] >= x[i-2]))
    			return true;
    		if(i > 4 && x[i-5] <= x[i-3] && x[i-4]<=x[i-2] && x[i-1]+x[i-5] >= x[i-3] &&
    				x[i] + x[i-4] >=x[i-2] && x[i] <= x[i-2] && x[i-1]<=x[i-3])
    			return true;
    	}
    	return false;
    }
    
	public static void main(String[] args)
	{
		SelfCrossing obj = new SelfCrossing();
		int[] x = {3,3,3,2,1,1};
		System.out.println(obj.isSelfCrossing(x));
	}

}
