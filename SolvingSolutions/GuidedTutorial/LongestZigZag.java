package longestZigZag;



public class LongestZigZag {
	public static int ans = 0;
	public static void main(String args[]) {
		TreeNode single = new TreeNode(1);
		
		System.out.println(longestZigZag(single));
		
		TreeNode r = new TreeNode(1);
		
		TreeNode lrr = new TreeNode(1);
		TreeNode lrlr = new TreeNode(1);
		TreeNode lrl = new TreeNode(1,null,lrlr);
		TreeNode lr = new TreeNode(1,lrl,lrr);
		TreeNode l = new TreeNode(1,null,lr);
		
		TreeNode root = new TreeNode(1,l,r);
		
		
		System.out.println(longestZigZag(root));
	}
	
	
	
	public static int longestZigZag(TreeNode root) {
       DFS(root, 'l', 0);
       return ans;
    }
	
	
	public static void DFS(TreeNode root, char dir, int count) {
		if(root == null) {
			return;
		}
		if(dir == 'l'){
            if (root.left != null) {
                DFS(root.left, 'r', count + 1);
            }
            ans = Math.max(ans, count);
            if (root.right != null)
                DFS(root.right, 'l', 1);
		}
		else if(dir == 'r') {
			if(root.right != null) {
				DFS(root.right,'l',count +1);
			}
			
			ans = Math.max(ans, count);
			
			if(root.left != null) {
				DFS(root.left, 'r', 1);
			}
		}

		
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
