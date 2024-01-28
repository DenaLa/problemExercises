package countGoodNodes;


public class CountGoodNodes {
	public static void main(String[] args) {
		
		TreeNode b2 = new TreeNode (2);
		TreeNode b1 = new TreeNode (1);
		TreeNode b = new TreeNode (4,b1,b2);
		
		TreeNode a1 = new TreeNode (3);
		TreeNode a = new TreeNode (1,a1,null);
		
		TreeNode root = new TreeNode (3,a,b);
		
		System.out.println(goodNodes(root));

	}
	
    public static int goodNodes(TreeNode root) {
        return travel(root,root.val);
    }
	
    
    public static int travel(TreeNode root, int max) {
    	if(root == null) {
    		return 0;
    	}
    	
    	int newMax = Math.max(max, root.val);
    	return (root.val >= max ? 1:0) + travel(root.left, newMax) + travel(root.right, newMax);
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
