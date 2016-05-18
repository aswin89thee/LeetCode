package org.leetcode;

public class EditDistance
{

	//Accepted solution with 14 ms runtime
	//Dp solution based on Wagner-Fischer algorithm : https://en.wikipedia.org/wiki/Edit_distance#Common_algorithm
    public int minDistance(String word1, String word2)
    {
    	if(word1.isEmpty() || word2.isEmpty())
    		return Integer.max(word1.length(), word2.length());
    	int[][] distances = new int[word1.length()][word2.length()];
    	int len1 = word1.length();
    	int len2 = word2.length();
    	char[] arr1 = word1.toCharArray();
    	char[] arr2 = word2.toCharArray();
    	if(arr1[0] == arr2[0])
    		distances[0][0] = 0;
    	else
    		distances[0][0] = 1;
    	int i = 0, j = 0;
    	//Calculate the cost along the edges
    	//If one of the string has only one character, then all operations are either insert or delete
    	//These make up our rows and columns
    	for(i = 1 ; i < len1 ; i++)
    	{
    		if(arr1[i] == arr2[0])
    			distances[i][0] = i;
    		else
    			distances[i][0] = Integer.min(i+1, distances[i-1][0] + 1);
    	}
    	for(j = 1 ; j < len2 ; j++)
    	{
    		if(arr2[j] == arr1[0])
    			distances[0][j] = j;
    		else
    			distances[0][j] = Integer.min(j+1, distances[0][j-1]+1);
    	}
    	
    	//Fill the inner distance matrix
    	for(i = 1 ; i < len1 ; i++)
    	{
    		for(j = 1; j < len2 ; j++)
    		{
    			if(arr1[i] == arr2[j])
    			{
    				distances[i][j] = distances[i-1][j-1];
    				continue;
    			}
    			int d1 = distances[i-1][j-1];
    			int d2 = distances[i-1][j];
    			int d3 = distances[i][j-1];
    			int min = Integer.min(d1, d2);
    			min = Integer.min(min, d3);
    			distances[i][j] = min + 1;
    		}
    	}
    	return distances[len1-1][len2-1];
    }
    
	public static void main(String[] args)
	{
		EditDistance obj = new EditDistance();
		System.out.println(obj.minDistance("kitten", "sitting"));
	}

}
