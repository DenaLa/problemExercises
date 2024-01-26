package binaryTreeRSV;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRSV {

	public static void main(String[] args) {
		
		TreeNode rr = new TreeNode(4);
		TreeNode r = new TreeNode(3,null,rr);
		
		TreeNode lr = new TreeNode(5);
		TreeNode l = new TreeNode(2,null,lr);
		
		TreeNode root = new TreeNode(1,l,r);
		
		System.out.println(rightSideView(root).toString());

	}

    public static List<Integer> rightSideView(TreeNode root) {
        List <Integer> ans = new LinkedList<>();
        searchTree(root, ans,0);
        
       return ans;
    }
    
    public static void searchTree(TreeNode root, List<Integer> ans, int depth) {
    	if(root == null) {
    		return;
    	}
    	if(ans.size() == depth) {

    		ans.add(root.val);
    	}

    	searchTree(root.right,ans,depth+1);
    	

    	searchTree(root.left, ans, depth+1);
    	
    }
    
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {
			
		}
		
		TreeNode(int val) { 
			this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
}
