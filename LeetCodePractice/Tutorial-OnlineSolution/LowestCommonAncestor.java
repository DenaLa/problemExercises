package lowestCommonAncestor;


public class LowestCommonAncestor {

	public static void main(String[] args) {
		
		TreeNode rr = new TreeNode(8);
		TreeNode rl = new TreeNode(0);
		TreeNode r = new TreeNode(1,rl,rr);
		
		TreeNode lrr = new TreeNode(4);
		TreeNode lrl = new TreeNode(7);
		TreeNode lr = new TreeNode(2,lrl,lrr);
		TreeNode ll = new TreeNode(6);
		TreeNode l = new TreeNode(5,ll,lr);
		
		TreeNode root = new TreeNode(3,l,r);
		
		TreeNode two = new TreeNode(2);
		TreeNode one = new TreeNode(1,two,null);
		
		
		System.out.println(lowestCommonAncestor(root, l, r).val);
		System.out.println(lowestCommonAncestor(root, l, lrr).val);
		System.out.println(lowestCommonAncestor(one, one, two).val);
		
	}

	
	
	
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null || root == p || root == q) {
        	return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);

        
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null) {
        	return root;
        }
        
    	
    	return (left == null ? right : left); 

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
