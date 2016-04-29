package org.leetcode;

public class ConvertSortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0) return null;
		TreeNode root = convertToBST(nums,0,nums.length);
        return root;
    }

	private TreeNode convertToBST(int[] nums, int lo, int hi) {
		if(lo >= hi) return null;
		int mid = (lo + hi)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = convertToBST(nums,lo,mid);
		root.right = convertToBST(nums,mid+1,hi);
		return root;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		ConvertSortedArrayToBinarySearchTree obj = new ConvertSortedArrayToBinarySearchTree();
		TreeNode root = obj.sortedArrayToBST(nums);
		System.out.println(root.val);
	}

}
