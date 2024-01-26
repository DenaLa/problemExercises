package binarySearchTree;


public class SearchInBinarySearchTree {

	public static void main(String[] args) {
		int valA = 2, valB =5;
		TreeNode r = new TreeNode(7);
		
		TreeNode lr = new TreeNode(3);
		TreeNode ll = new TreeNode(1);
		TreeNode l = new TreeNode(2,ll,lr);
		
		TreeNode root = new TreeNode(4,l,r);
		
		TreeNode first = searchBST(root,valA);
		
		System.out.println("[" + first.val + " "+ first.left.val + " "+ first.right.val + "]");

	}

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
        	return null;
        }
        if(root.val == val) {
        	return root;
        }
        if(root.val > val) {
        	return searchBST(root.left, val);
        	
        }
    	
    	return searchBST(root.right, val);
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
