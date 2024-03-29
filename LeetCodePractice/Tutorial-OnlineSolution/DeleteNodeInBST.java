package binarySearchTree;

public class DeleteNodeInBST {

//I don't know how to make function that would display this

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
        	return null;
        }
        if(root.val == key) {
        	if(root.left == null) {
        		return root.right;
        	}
        	if(root.right == null) {
        		return root.left;
        	}
        	TreeNode minNode = getMin(root.right);
        	root.right = deleteNode(root.right,minNode.val);
        	minNode.left = root.left;
        	minNode.right = root.right;
        	root = minNode;
        }
        else if(root.val < key) {
        	root.right = deleteNode(root.right, key);
        }
        else {
        	root.left = deleteNode(root.left, key);
        }
    	
    	return root;
    }
    
    
    public static TreeNode getMin(TreeNode node) {
    	while(node.left != null) {
    		node = node.left;
    	}
    	return node;
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
