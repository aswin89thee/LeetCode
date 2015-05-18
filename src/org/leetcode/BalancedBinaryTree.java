package org.leetcode;

import java.util.HashMap;
import java.util.Map;

//Using a map is not essential, but when there are millions of nodes, it might help improve performance
public class BalancedBinaryTree {
	
	Map<TreeNode,Integer> heightMap = new HashMap<TreeNode,Integer>();

    public boolean isBalanced(TreeNode root) {
    	if(root == null) return true;
    	int leftHeight = getHeight(root.left);
    	int rightHeight = getHeight(root.right);
    	int diff = leftHeight - rightHeight;
    	diff = diff >= 0 ? diff : -diff;
    	if(diff > 1) return false;
    	if(!isBalanced(root.left)) return false;
    	if(!isBalanced(root.right)) return false;
    	return true;
    }
    private int getHeight(TreeNode root){
    	if(root == null) return 0;
    	if(heightMap.get(root) != null) return heightMap.get(root);
    	int height = 0;
    	int leftHeight = 1 + getHeight(root.left);
    	int rightHeight = 1 + getHeight(root.right);
    	height = leftHeight > rightHeight ? leftHeight : rightHeight;
    	heightMap.put(root, height);
    	return height;
    }
    
	public static void main(String[] args) {

	}

}
