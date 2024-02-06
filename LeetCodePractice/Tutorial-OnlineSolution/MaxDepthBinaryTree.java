package maxDepthBinaryTree;

public class MaxDepthBinaryTree {

	public static void main(String[] args) {
		TreeNode d = new TreeNode (20);
		TreeNode c = new TreeNode (15);
		TreeNode b = new TreeNode (20,c,d);
		TreeNode a = new TreeNode (9);
		TreeNode root = new TreeNode (3,a,b);
		
		System.out.println(maxDepth(root));

	}
	
    public static int maxDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
    	
    	return Math.max(left, right) + 1;
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
