package org.leetcode;

/*
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
public class RotateImage
{
	
    public void rotate(int[][] matrix)
    {
    	if(matrix == null)
    		return;
    	if(matrix.length <= 1)
    		return;
    	//Do a transpose first
    	transpose(matrix);
    	//Then flip it vertically
    	flipVertical(matrix);
    }

	private void transpose(int[][] matrix)
	{
		int len = matrix.length;
		for(int i = 0; i < len ; i++)
		{
			for(int j = i ; j < len ; j++)
			{
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
    
	private void flipVertical(int[][] matrix)
	{
		int len = matrix.length;
		for(int i = 0 ; i < len/2 ; i++)
		{
			for(int j = 0 ; j < len ; j++)
			{
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[j][len-i-1];
				matrix[j][len-i-1] = tmp;
			}
		}
	}

	public static void main(String[] args)
	{
		RotateImage obj = new RotateImage();
		int[][] matrix = {{1,2,3},
						  {4,5,6},
						  {7,8,9}};
		obj.rotate(matrix);
		for(int i = 0 ; i < matrix.length ; i++)
		{
			System.out.println();
			for(int j = 0 ; j < matrix.length ; j++)
			{
				System.out.print("\t" + matrix[i][j]);
			}
		}
	}

}
