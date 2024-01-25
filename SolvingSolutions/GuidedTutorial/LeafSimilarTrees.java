package leafSimilarTrees;

import java.util.ArrayList;


public class LeafSimilarTrees {

	public static void main(String[] args) {

		TreeNode d22 = new TreeNode (8);
		TreeNode d21 = new TreeNode (9);
		TreeNode d2 = new TreeNode (2,d21,d22);
		TreeNode d1 = new TreeNode (4);
		TreeNode d = new TreeNode (1,d1,d2);
		
		TreeNode c2 = new TreeNode (7);
		TreeNode c1 = new TreeNode (6);
		TreeNode c = new TreeNode (5,c1,c2);
		
		TreeNode rootB = new TreeNode (3,c,d);
		
		
		TreeNode b2 = new TreeNode (8);
		TreeNode b1 = new TreeNode (9);
		TreeNode b = new TreeNode (1,b1,b2);
		
		TreeNode a22 = new TreeNode (4);
		TreeNode a21 = new TreeNode (7);
		TreeNode a2 = new TreeNode (2,a21,a22);
		TreeNode a1 = new TreeNode (6);
		TreeNode a = new TreeNode (5,a1,a2);
		
		TreeNode rootA = new TreeNode (3,a,b);
		
		System.out.println(leafSimilar(rootA,rootB));

	}
	
	
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
    	ArrayList<Integer> leavesA = new ArrayList<>();
    	ArrayList<Integer> leavesB = new ArrayList<>();
    	
    	DFS(root1, leavesA);
    	DFS(root2, leavesB);
    	
    	return leavesA.equals(leavesB);
    }
    
    
    public static void DFS(TreeNode root, ArrayList<Integer> leaves) {
        if(root == null) {
        	return;
        }
        if(root.left == null && root.right == null) {
        	leaves.add(root.val);
        	return;
        }
        
        DFS(root.left,leaves);
        DFS(root.right,leaves);
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
