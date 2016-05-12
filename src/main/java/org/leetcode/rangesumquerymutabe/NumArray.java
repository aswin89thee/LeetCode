package org.leetcode.rangesumquerymutabe;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.

 */
//Your NumArray object will be instantiated and called as such:
//NumArray numArray = new NumArray(nums);
//numArray.sumRange(0, 1);
//numArray.update(1, 10);
//numArray.sumRange(1, 2);
class SegTreeNode
{
	int start, end;
	int val;
	SegTreeNode left, right;
	public SegTreeNode()
	{
	}
	public SegTreeNode(int x)
	{
		val = x;
	}
}

//Accepted solution. 14 ms runtime
public class NumArray
{
	int[] nums;
	SegTreeNode root;

    public NumArray(int[] nums)
    {
    	this.nums = nums;
    	root = createTree(0, nums.length-1);
    }

	void update(int i, int val)
    {
		nums[i] = val;
		updateTreeVal(i, val, root);
    }

	public int sumRange(int i, int j)
    {
    	if(i == j)
    		return nums[i];
    	return getSumFromTree(i,j,root);
    }

    private void updateTreeVal(int ind, int val, SegTreeNode node)
	{
    	if(node.start == ind && node.end == ind)
    	{
    		node.val = val;
    		return;
    	}
    	int mid = node.start + (node.end - node.start)/2;
    	if(ind <= mid)
    		updateTreeVal(ind, val, node.left);
    	else
    		updateTreeVal(ind, val, node.right);
    	node.val = node.left.val + node.right.val;
	}

	private int getSumFromTree(int i, int j, SegTreeNode node)
	{
		if(i == node.start && j == node.end)
			return node.val;
		if(i == j)
			return nums[i];
		int mid = node.start + (node.end - node.start) / 2;
        if (j <= mid)
        {
            return getSumFromTree(i, j, node.left);
        }else if (i >= mid+1)
        {
            return getSumFromTree(i, j, node.right);
        }else
        {
            return getSumFromTree(mid+1, j, node.right) + getSumFromTree(i, mid, node.left);
        }
	}

	private SegTreeNode createTree(int i, int j)
	{
		if(i > j)
			return null;
		if(i == j)
		{
			SegTreeNode node = new SegTreeNode(nums[i]);
			node.start = i;
			node.end = j;
			return node;
		}
		SegTreeNode node = new SegTreeNode(0);
		node.start = i;
		node.end = j;
		int mid = i + (j-i)/2;
		SegTreeNode left = createTree(i,mid);
		SegTreeNode right = createTree(mid+1,j);
		node.val = left.val + right.val;
		node.left = left; node.right = right;
		return node;
	}
    
	public static void main(String[] args)
	{
//		int[] nums = {1,2,3,4};
//		NumArray obj = new NumArray(nums);
//		System.out.println(obj.sumRange(0, 1));
//		System.out.println(obj.sumRange(0, 2));
//		System.out.println(obj.sumRange(1, 3));
//		obj.update(1, 3);
//		System.out.println(obj.sumRange(0, 2));
//		System.out.println(obj.sumRange(1, 3));
		
		int[] nums = {0,9,5,7,3};
		NumArray obj = new NumArray(nums);
		System.out.println(obj.sumRange(1, 2));
		System.out.println(obj.sumRange(4,4));
		System.out.println(obj.sumRange(2, 4));
		System.out.println(obj.sumRange(3, 3));
		obj.update(4, 5);
		obj.update(1, 7);
		obj.update(0, 8);
		System.out.println(obj.sumRange(1, 2));
		System.out.println(obj.sumRange(1, 3));
	}

}
