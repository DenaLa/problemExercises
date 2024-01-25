package pathSumThree;

import java.util.HashMap;


public class PathSumThree {
	public static HashMap<Long, Integer> map;
	public static int count;
	
	public static void main(String[] args) {

		
		
		TreeNode rl = new TreeNode (11);
		TreeNode r = new TreeNode (-3,rl,null);
		
		TreeNode lrl = new TreeNode (1);
		TreeNode lr = new TreeNode (2,lrl,null);
		TreeNode llr = new TreeNode (-2);
		TreeNode lll = new TreeNode (3);
		TreeNode ll = new TreeNode (3,lll,llr);
		TreeNode l = new TreeNode (5,ll,lr);
		
		TreeNode root = new TreeNode (10,l,r);
		
		int TargetSum = 8;
		
		System.out.println(pathSum(root, TargetSum));

	}
	
    public static int pathSum(TreeNode root, int targetSum) {
    	map = new HashMap<>();
    	count = 0;
    	DFS(root, 0, targetSum);
    	
    	return count;
    	 
    }
    
    public static void DFS(TreeNode root, long prefixSum, int targetSum) {
    	if(root == null) {
    		return;
    	}
    	
    	prefixSum += root.val;
    	
    	if(map.containsKey(prefixSum - targetSum)) {
    		count += map.get(prefixSum - targetSum);
    	}
    	if(targetSum == prefixSum) {
    		count++;
    	}
    	
    	
    	map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
    	
    	DFS(root.left, prefixSum, targetSum);
    	DFS(root.right, prefixSum, targetSum);
    	
    	map.put(prefixSum, map.get(prefixSum)-1);
    	
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
